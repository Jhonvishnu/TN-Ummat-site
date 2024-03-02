/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.portal.login.mvc.overrides;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.login.web.constants.LoginPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.UnicodePropertiesBuilder;
import com.liferay.portal.kernel.util.WebKeys;

@Component(property = { "javax.portlet.name=" + LoginPortletKeys.FAST_LOGIN,
		"javax.portlet.name=" + LoginPortletKeys.LOGIN, "mvc.command.name=/login/create_account",
		"service.ranking:Integer=500" }, service = MVCRenderCommand.class)
public class CreateAccountMVCRenderCommand implements MVCRenderCommand {
	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			logger.info("Adding custom fields for user::: ");
			if (!themeDisplay.getUser().getExpandoBridge().hasAttribute("Marital Status")) {
				themeDisplay.getUser().getExpandoBridge().addAttribute("Marital Status",
						ExpandoColumnConstants.STRING_ARRAY,
						new String[] { "Single", "Divorced", "Widowed", "Separated" }, false);
				UnicodeProperties unicodeProperties = UnicodePropertiesBuilder
						.put("display-type", ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST)
						.put(ExpandoColumnConstants.PROPERTY_HIDDEN, false)
						.put(ExpandoColumnConstants.PROPERTY_VISIBLE_WITH_UPDATE_PERMISSION, false).build();
				themeDisplay.getUser().getExpandoBridge().setAttributeProperties("Marital Status", unicodeProperties,
						false);
			}
			if (!themeDisplay.getUser().getExpandoBridge().hasAttribute("Country")) {
				themeDisplay.getUser().getExpandoBridge().addAttribute("Country", ExpandoColumnConstants.STRING, false);
			}
			if (!themeDisplay.getUser().getExpandoBridge().hasAttribute("State")) {
				themeDisplay.getUser().getExpandoBridge().addAttribute("State", ExpandoColumnConstants.STRING, false);
			}
			if (!themeDisplay.getUser().getExpandoBridge().hasAttribute("District")) {
				themeDisplay.getUser().getExpandoBridge().addAttribute("District", ExpandoColumnConstants.STRING,
						false);
			}
			if (!themeDisplay.getUser().getExpandoBridge().hasAttribute("Area")) {
				themeDisplay.getUser().getExpandoBridge().addAttribute("Area", ExpandoColumnConstants.STRING, false);
			}
			if (!themeDisplay.getUser().getExpandoBridge().hasAttribute("Education")) {
				themeDisplay.getUser().getExpandoBridge().addAttribute("Education", ExpandoColumnConstants.STRING,
						false);
			}
			if (!themeDisplay.getUser().getExpandoBridge().hasAttribute("Height")) {
				themeDisplay.getUser().getExpandoBridge().addAttribute("Height", ExpandoColumnConstants.INTEGER, false);
			}
			if (!themeDisplay.getUser().getExpandoBridge().hasAttribute("Weight")) {
				themeDisplay.getUser().getExpandoBridge().addAttribute("Weight", ExpandoColumnConstants.INTEGER, false);
			}
			if (!themeDisplay.getUser().getExpandoBridge().hasAttribute("gender")) {
				themeDisplay.getUser().getExpandoBridge().addAttribute("gender", ExpandoColumnConstants.BOOLEAN, false);
			}
			if (!themeDisplay.getUser().getExpandoBridge().hasAttribute("Color")) {
				themeDisplay.getUser().getExpandoBridge().addAttribute("Color", ExpandoColumnConstants.STRING_LABEL,
						false);
			}
			if (!themeDisplay.getUser().getExpandoBridge().hasAttribute("Jamath")) {
				themeDisplay.getUser().getExpandoBridge().addAttribute("Jamath", ExpandoColumnConstants.STRING_ARRAY,
						new String[] { "Sunnathwal Jamath", "Thowheed Jamath", "TNTJ", "Others" }, false);
				UnicodeProperties unicodeProperties = UnicodePropertiesBuilder
						.put("display-type", ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST)
						.put(ExpandoColumnConstants.PROPERTY_HIDDEN, false)
						.put(ExpandoColumnConstants.PROPERTY_VISIBLE_WITH_UPDATE_PERMISSION, false).build();
				themeDisplay.getUser().getExpandoBridge().setAttributeProperties("Jamath", unicodeProperties, false);
			}
		} catch (PortalException e) {
			logger.error(e);
		}
		return "/create_account.jsp";
	}

}