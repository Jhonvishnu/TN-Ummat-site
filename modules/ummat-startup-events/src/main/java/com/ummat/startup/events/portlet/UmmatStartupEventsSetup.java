package com.ummat.startup.events.portlet;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.ummat.startup.util.LocalityInitializerUtil;

/**
 * @author Vinoth-kumar
 */
@Component(immediate = true, service = UmmatStartupEventsSetup.class)
public class UmmatStartupEventsSetup {
	@Activate
	@Modified
	public void setup() throws PortalException {
		try {
			LocalityInitializerUtil.initializeCompanyCountries(20096);
		} catch (Exception e) {
			logger.error(e);
		}
		logger.info("Method started:::::::::::::");
	}

	@Deactivate
	protected void deactivate() {
	}

	@Reference(target = ModuleServiceLifecycle.PORTLETS_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	private static final Log logger = LogFactoryUtil.getLog(UmmatStartupEventsSetup.class);
}