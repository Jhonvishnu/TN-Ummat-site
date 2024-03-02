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

package com.ummat.slayer.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.ummat.slayer.model.District;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the district service. This utility wraps <code>com.ummat.slayer.service.persistence.impl.DistrictPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DistrictPersistence
 * @generated
 */
public class DistrictUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(District district) {
		getPersistence().clearCache(district);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, District> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<District> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<District> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<District> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static District update(District district) {
		return getPersistence().update(district);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static District update(
		District district, ServiceContext serviceContext) {

		return getPersistence().update(district, serviceContext);
	}

	/**
	 * Returns all the districts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching districts
	 */
	public static List<District> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the districts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public static List<District> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the districts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the districts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first district in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByUuid_First(
			String uuid, OrderByComparator<District> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchDistrictException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first district in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByUuid_First(
		String uuid, OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByUuid_Last(
			String uuid, OrderByComparator<District> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchDistrictException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByUuid_Last(
		String uuid, OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the districts before and after the current district in the ordered set where uuid = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District[] findByUuid_PrevAndNext(
			long districtId, String uuid,
			OrderByComparator<District> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchDistrictException {

		return getPersistence().findByUuid_PrevAndNext(
			districtId, uuid, orderByComparator);
	}

	/**
	 * Removes all the districts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of districts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching districts
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the districts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching districts
	 */
	public static List<District> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the districts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public static List<District> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the districts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the districts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first district in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<District> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchDistrictException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first district in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<District> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchDistrictException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the districts before and after the current district in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District[] findByUuid_C_PrevAndNext(
			long districtId, String uuid, long companyId,
			OrderByComparator<District> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchDistrictException {

		return getPersistence().findByUuid_C_PrevAndNext(
			districtId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the districts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of districts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching districts
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the districts where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the matching districts
	 */
	public static List<District> findByRegionId(long regionId) {
		return getPersistence().findByRegionId(regionId);
	}

	/**
	 * Returns a range of all the districts where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public static List<District> findByRegionId(
		long regionId, int start, int end) {

		return getPersistence().findByRegionId(regionId, start, end);
	}

	/**
	 * Returns an ordered range of all the districts where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByRegionId(
		long regionId, int start, int end,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().findByRegionId(
			regionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the districts where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByRegionId(
		long regionId, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByRegionId(
			regionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first district in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByRegionId_First(
			long regionId, OrderByComparator<District> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchDistrictException {

		return getPersistence().findByRegionId_First(
			regionId, orderByComparator);
	}

	/**
	 * Returns the first district in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByRegionId_First(
		long regionId, OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByRegionId_First(
			regionId, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByRegionId_Last(
			long regionId, OrderByComparator<District> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchDistrictException {

		return getPersistence().findByRegionId_Last(
			regionId, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByRegionId_Last(
		long regionId, OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByRegionId_Last(
			regionId, orderByComparator);
	}

	/**
	 * Returns the districts before and after the current district in the ordered set where regionId = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District[] findByRegionId_PrevAndNext(
			long districtId, long regionId,
			OrderByComparator<District> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchDistrictException {

		return getPersistence().findByRegionId_PrevAndNext(
			districtId, regionId, orderByComparator);
	}

	/**
	 * Removes all the districts where regionId = &#63; from the database.
	 *
	 * @param regionId the region ID
	 */
	public static void removeByRegionId(long regionId) {
		getPersistence().removeByRegionId(regionId);
	}

	/**
	 * Returns the number of districts where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the number of matching districts
	 */
	public static int countByRegionId(long regionId) {
		return getPersistence().countByRegionId(regionId);
	}

	/**
	 * Caches the district in the entity cache if it is enabled.
	 *
	 * @param district the district
	 */
	public static void cacheResult(District district) {
		getPersistence().cacheResult(district);
	}

	/**
	 * Caches the districts in the entity cache if it is enabled.
	 *
	 * @param districts the districts
	 */
	public static void cacheResult(List<District> districts) {
		getPersistence().cacheResult(districts);
	}

	/**
	 * Creates a new district with the primary key. Does not add the district to the database.
	 *
	 * @param districtId the primary key for the new district
	 * @return the new district
	 */
	public static District create(long districtId) {
		return getPersistence().create(districtId);
	}

	/**
	 * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param districtId the primary key of the district
	 * @return the district that was removed
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District remove(long districtId)
		throws com.ummat.slayer.exception.NoSuchDistrictException {

		return getPersistence().remove(districtId);
	}

	public static District updateImpl(District district) {
		return getPersistence().updateImpl(district);
	}

	/**
	 * Returns the district with the primary key or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District findByPrimaryKey(long districtId)
		throws com.ummat.slayer.exception.NoSuchDistrictException {

		return getPersistence().findByPrimaryKey(districtId);
	}

	/**
	 * Returns the district with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district, or <code>null</code> if a district with the primary key could not be found
	 */
	public static District fetchByPrimaryKey(long districtId) {
		return getPersistence().fetchByPrimaryKey(districtId);
	}

	/**
	 * Returns all the districts.
	 *
	 * @return the districts
	 */
	public static List<District> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of districts
	 */
	public static List<District> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of districts
	 */
	public static List<District> findAll(
		int start, int end, OrderByComparator<District> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of districts
	 */
	public static List<District> findAll(
		int start, int end, OrderByComparator<District> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the districts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of districts.
	 *
	 * @return the number of districts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DistrictPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DistrictPersistence _persistence;

}