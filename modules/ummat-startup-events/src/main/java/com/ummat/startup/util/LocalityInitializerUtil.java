package com.ummat.startup.util;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.ummat.slayer.model.District;
import com.ummat.slayer.model.Locality;
import com.ummat.slayer.service.DistrictLocalServiceUtil;
import com.ummat.slayer.service.LocalityLocalServiceUtil;

/**
 * @author Vinoth-kumar
 */
public class LocalityInitializerUtil {

	public static void initializeCompanyCountries(long companyId) throws Exception {
		CountryLocalServiceUtil.deleteCompanyCountries(companyId);
		List<District> districts = DistrictLocalServiceUtil.getDistricts(-1, -1);
		if (!districts.isEmpty() && Validator.isNotNull(districts)) {
			for (District district : districts) {
				DistrictLocalServiceUtil.deleteDistrict(district.getDistrictId());
			}
		}
		List<Locality> localities = LocalityLocalServiceUtil.getLocalities(-1, -1);
		if (!localities.isEmpty() && Validator.isNotNull(localities)) {
			for (Locality locality : localities) {
				LocalityLocalServiceUtil.deleteLocality(locality.getLocalityId());
			}
		}
		populateCompanyCountries(companyId);
	}

	public static void populateCompanyCountries(long companyId) throws Exception {
		Company company = CompanyLocalServiceUtil.getCompany(companyId);
		int count = CountryLocalServiceUtil.getCompanyCountriesCount(company.getCompanyId());
		JSONArray countriesJSONArray = getJSONArray("com/liferay/address/dependencies/countries.json");
		if (count > 0) {
			logger.info(StringBundler.concat("Skipping country initialization. Countries are ",
					"already initialized for company ", company.getCompanyId(), "."));
			return;
		}
		logger.info("Initializing countries for company " + company.getCompanyId());
		for (int i = 0; i < countriesJSONArray.length(); i++) {
			JSONObject countryJSONObject = countriesJSONArray.getJSONObject(i);

			try {
				String name = countryJSONObject.getString("name");

				ServiceContext serviceContext = new ServiceContext();

				serviceContext.setCompanyId(company.getCompanyId());

				User guestUser = company.getGuestUser();

				serviceContext.setUserId(guestUser.getUserId());

				Country country = CountryLocalServiceUtil.addCountry(countryJSONObject.getString("a2"),
						countryJSONObject.getString("a3"), true, true, countryJSONObject.getString("idd"), name,
						countryJSONObject.getString("number"), 0, true, false,
						countryJSONObject.getBoolean("zipRequired"), serviceContext);

				Map<String, String> titleMap = new HashMap<>();

				for (Locale locale : LanguageUtil.getCompanyAvailableLocales(companyId)) {

					titleMap.put(LanguageUtil.getLanguageId(locale), country.getName(locale));
				}

				CountryLocalServiceUtil.updateCountryLocalizations(country, titleMap);

				processCountryRegions(country);
			} catch (Exception exception) {
				logger.error(exception);
			}
		}
	}

	private static ClassLoader getClassLoader() {
		Class<?> clazz = LocalityInitializerUtil.class;
		return clazz.getClassLoader();
	}

	private static JSONArray getJSONArray(String path) throws Exception {
		return JSONFactoryUtil.createJSONArray(StringUtil.read(getClassLoader(), path, false));
	}

	private static void processCountryRegions(Country country) {
		String a2 = country.getA2();
		try {
			String path = "com/liferay/address/dependencies/regions/" + a2 + ".json";
			ClassLoader classLoader = getClassLoader();
			if (classLoader.getResource(path) == null) {
				return;
			}
			JSONArray regionsJSONArray = getJSONArray(path);
			for (int i = 0; i < regionsJSONArray.length(); i++) {
				try {
					JSONObject regionJSONObject = regionsJSONArray.getJSONObject(i);

					ServiceContext serviceContext = new ServiceContext();

					serviceContext.setCompanyId(country.getCompanyId());
					serviceContext.setUserId(country.getUserId());

					Region region = RegionLocalServiceUtil.addRegion(country.getCountryId(), true,
							regionJSONObject.getString("name"), 0, regionJSONObject.getString("regionCode"),
							serviceContext);

					JSONObject localizationsJSONObject = regionJSONObject.getJSONObject("localizations");

					if (localizationsJSONObject == null) {
						Map<String, String> titleMap = new HashMap<>();

						for (Locale locale : LanguageUtil.getCompanyAvailableLocales(country.getCompanyId())) {

							titleMap.put(LanguageUtil.getLanguageId(locale), region.getName());
						}

						RegionLocalServiceUtil.updateRegionLocalizations(region, titleMap);
					} else {
						for (String key : localizationsJSONObject.keySet()) {
							RegionLocalServiceUtil.updateRegionLocalization(region, key,
									localizationsJSONObject.getString(key));
						}
					}
					if (region.getName().equalsIgnoreCase("Tamil nadu")) {
						processDistricts(region);
					}
				} catch (PortalException portalException) {
					logger.error(portalException);
				}
			}
		} catch (Exception exception) {
			logger.info("No regions found for country " + a2, exception);
		}
	}

	private static void processDistricts(Region region) {
		String path = "com/liferay/address/dependencies/regions/districts/TN.json";
		try {
			ClassLoader classLoader = getClassLoader();
			if (classLoader.getResource(path) == null) {
				return;
			}
			JSONArray districtsJSONArray = getJSONArray(path);
			for (int i = 0; i < districtsJSONArray.length(); i++) {
				JSONObject districtJSONObj = districtsJSONArray.getJSONObject(i);
				String districtName = districtJSONObj.get("name").toString();
				District district = AdderUtil.addDistrict(region, districtName);
				processLocality(district, districtName);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	private static void processLocality(District district, String districtName) {
		String path = "com/liferay/address/dependencies/regions/districts/locality/TNLocality.json";
		try {
			ClassLoader classLoader = getClassLoader();
			if (classLoader.getResource(path) == null) {
				return;
			}
			JSONArray localitiesJsonArray = getJSONArray(path);
			JSONObject districtJSONObj = localitiesJsonArray.getJSONObject(0);
			JSONArray locationsArray = districtJSONObj.getJSONArray(districtName.toLowerCase());
			for (int j = 0; j < locationsArray.length(); j++) {
				JSONObject locationObject = locationsArray.getJSONObject(j);
				Locality locality = AdderUtil.addLocality(district, locationObject.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final Log logger = LogFactoryUtil.getLog(LocalityInitializerUtil.class);

	private LocalityInitializerUtil() {
	}
}
