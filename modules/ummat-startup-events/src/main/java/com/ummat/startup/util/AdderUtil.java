package com.ummat.startup.util;

import java.util.Date;

import com.liferay.portal.kernel.model.Region;
import com.ummat.slayer.model.District;
import com.ummat.slayer.model.Locality;
import com.ummat.slayer.service.DistrictLocalServiceUtil;
import com.ummat.slayer.service.LocalityLocalServiceUtil;

/**
 * @author Vinoth-kumar
 */

public class AdderUtil {
	public static District addDistrict(Region region, String districtName) {
		District district = DistrictLocalServiceUtil.createDistrict(0);
		district.setName(districtName);
		district.setCreateDate(new Date());
		district.setRegionId(region.getRegionId());
		district.setActive(true);
		district.setUserId(region.getUserId());
		district.setCompanyId(region.getCompanyId());
		DistrictLocalServiceUtil.addDistrict(district);
		return district;
	}

	public static Locality addLocality(District district, String localityName) {
		Locality locality = LocalityLocalServiceUtil.createLocality(0);
		locality.setName(localityName);
		locality.setCreateDate(new Date());
		locality.setRegionId(district.getRegionId());
		locality.setDistrictId(district.getDistrictId());
		locality.setActive(true);
		locality.setUserId(district.getUserId());
		locality.setCompanyId(district.getCompanyId());
		LocalityLocalServiceUtil.addLocality(locality);
		return locality;
	}

	private AdderUtil() {
	}
}