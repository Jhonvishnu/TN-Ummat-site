package com.ummat.profiles.mvc.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.ummat.profiles.web.constants.UmmatProfilesWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + UmmatProfilesWebPortletKeys.UMMATPROFILESWEB,
		"mvc.command.name=/searchProfiles" }, service = MVCActionCommand.class)

public class SearchProfilesMVCActionCommand implements MVCActionCommand {
	private static final Log logger = LogFactoryUtil.getLog(SearchProfilesMVCActionCommand.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		String districtName = ParamUtil.getString(actionRequest, "district");
		String areaName = ParamUtil.getString(actionRequest, "area");
		if(Validator.isNull(areaName) || areaName.isEmpty()) {
			areaName = districtName;
		}
		if(logger.isDebugEnabled()) {
			logger.debug("Area name from search::: " +areaName);
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<User> users = new ArrayList<>();
		try {
			UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(themeDisplay.getCompanyId(), areaName);
			users = UserLocalServiceUtil.getUserGroupUsers(userGroup.getUserGroupId());
		} catch (PortalException e) {
			if(logger.isDebugEnabled()) {
				logger.warn(e.getMessage());
			}
		}
		actionRequest.setAttribute("currentProfilesSearch", users);
		return false;
	}
	
}
