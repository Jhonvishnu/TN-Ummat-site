package com.tnummat.travel.portlet;

import com.tnummat.travel.constants.TnummatTravelPortletKeys;

import com.ummat.slayer.model.District;
import com.ummat.slayer.service.DistrictLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author USER
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TnummatTravel",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TnummatTravelPortletKeys.TNUMMATTRAVEL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TnummatTravelPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Set<User> currentProfileSet = new HashSet<>();
		currentProfileSet.addAll(UserLocalServiceUtil.getUsers(-1, -1));
		List<UserGroup> userGroups = UserGroupLocalServiceUtil.getUserUserGroups(themeDisplay.getUserId());
		for (UserGroup userGroupItem : userGroups) {
			List<User> users = UserLocalServiceUtil.getUserGroupUsers(userGroupItem.getUserGroupId());
			for (User userItem : users) {
				currentProfileSet.add(userItem);
				currentProfileSet.addAll(users);

			}
		}
		List<User> currentProfileList = new ArrayList<>(currentProfileSet);
		List<District> districts = DistrictLocalServiceUtil.getDistricts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("districtLists", districts);
		renderRequest.setAttribute("currentProfiles", currentProfileList);

		super.doView(renderRequest, renderResponse);

	}
	private static final Log logger = LogFactoryUtil.getLog(TnummatTravelPortlet.class);

}