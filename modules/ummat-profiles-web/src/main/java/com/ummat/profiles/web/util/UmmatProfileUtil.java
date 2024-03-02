package com.ummat.profiles.web.util;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;

public class UmmatProfileUtil {
	
	
	/*
	 * public static String ObjectToString( Object object) { if(object != null) {
	 * return object.toString(); } return ""; }
	 */
	 
	public static String getData(User user) {
		String data = "";
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
		try {
			ExpandoTable table = ExpandoTableLocalServiceUtil.getDefaultTable(user.getCompanyId(),
					User.class.getName());
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getDefaultTableColumn(user.getCompanyId(),
					User.class.getName(), "Jamath");
			ExpandoValue value = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), column.getColumnId(),
					user.getUserId());
			/* System.out.println("value------->"+value.getData()); */
			data = value.getData();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	public static String getMaritalStatus(User user) {
	    String maritalStatus = "";

	    try {
	        PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
	        PermissionThreadLocal.setPermissionChecker(permissionChecker);

	        ExpandoTable table1 = ExpandoTableLocalServiceUtil.getDefaultTable(user.getCompanyId(),
					User.class.getName());
			ExpandoColumn column1 = ExpandoColumnLocalServiceUtil.getDefaultTableColumn(user.getCompanyId(),
					User.class.getName(), "Marital Status");
			
	        if (column1 != null) {
	        	ExpandoValue value1 = ExpandoValueLocalServiceUtil.getValue(table1.getTableId(), column1.getColumnId(),
						user.getUserId());
	            if (value1 != null) {
	            	System.out.println("value1------->"+value1.getData());
	                maritalStatus = value1.getData();
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("value1------- Not working>");
	    }

	    return maritalStatus;
	}

	
}
