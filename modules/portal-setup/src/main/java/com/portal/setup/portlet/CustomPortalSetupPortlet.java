package com.portal.setup.portlet;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.security.service.access.policy.model.SAPEntry;
import com.liferay.portal.security.service.access.policy.service.SAPEntryLocalServiceUtil;

/**
 * @author Vinoth-kumar
 */

@Component(immediate = true, service = CustomPortalSetupPortlet.class)
public class CustomPortalSetupPortlet {
	@Activate
	@Modified
	public void setup() throws PortalException {
		logger.info(" ::: Setting up SAP for Districts and Areas :::");
		ServiceContext serviceContext = new ServiceContext();
		try {
			SAPEntryLocalServiceUtil.getSAPEntry(PortalUtil.getDefaultCompanyId(), "DISTRICT_SAP");
		} catch (PortalException e1) {
			try {
				Map<Locale, String> map = new HashMap<Locale, String>();
				map.putIfAbsent(LocaleUtil.getDefault(), "Created by portal setup to access district");
				SAPEntry sapEntry = SAPEntryLocalServiceUtil.addSAPEntry(getAdminUser().getUserId(),
						"com.ummat.slayer.service.DistrictService#getByRegionId", true, true, "DISTRICT_SAP", map,
						serviceContext);
			} catch (PortalException e) {
			}
		}
		try {
			SAPEntryLocalServiceUtil.getSAPEntry(PortalUtil.getDefaultCompanyId(), "LOCALITY_SAP");
		} catch (PortalException e1) {
			try {
				Map<Locale, String> map = new HashMap<Locale, String>();
				map.putIfAbsent(LocaleUtil.getDefault(), "Created by portal setup to access areas");
				SAPEntry sapEntry = SAPEntryLocalServiceUtil.addSAPEntry(getAdminUser().getUserId(),
						"com.ummat.slayer.service.LocalityService#getLocalityByDistrictId", true, true, "LOCALITY_SAP",
						map, serviceContext);
			} catch (PortalException e) {
			}
		}
	}

	private User getAdminUser() throws PortalException {
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), RoleConstants.ADMINISTRATOR);
		for (User adminUser : UserLocalServiceUtil.getRoleUsers(role.getRoleId())) {
			return adminUser;
		}
		return null;
	}

	@Deactivate
	protected void deactivate() {
	}

	@Reference(target = ModuleServiceLifecycle.PORTLETS_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	private static final Log logger = LogFactoryUtil.getLog(CustomPortalSetupPortlet.class);
}
