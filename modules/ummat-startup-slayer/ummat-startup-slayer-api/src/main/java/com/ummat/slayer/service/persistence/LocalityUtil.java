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

import com.ummat.slayer.model.Locality;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the locality service. This utility wraps <code>com.ummat.slayer.service.persistence.impl.LocalityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalityPersistence
 * @generated
 */
public class LocalityUtil {

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
	public static void clearCache(Locality locality) {
		getPersistence().clearCache(locality);
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
	public static Map<Serializable, Locality> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Locality> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Locality> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Locality> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Locality> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Locality update(Locality locality) {
		return getPersistence().update(locality);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Locality update(
		Locality locality, ServiceContext serviceContext) {

		return getPersistence().update(locality, serviceContext);
	}

	/**
	 * Returns all the localities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching localities
	 */
	public static List<Locality> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the localities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @return the range of matching localities
	 */
	public static List<Locality> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the localities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localities
	 */
	public static List<Locality> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Locality> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the localities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localities
	 */
	public static List<Locality> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Locality> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first locality in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	public static Locality findByUuid_First(
			String uuid, OrderByComparator<Locality> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchLocalityException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first locality in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality, or <code>null</code> if a matching locality could not be found
	 */
	public static Locality fetchByUuid_First(
		String uuid, OrderByComparator<Locality> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last locality in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	public static Locality findByUuid_Last(
			String uuid, OrderByComparator<Locality> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchLocalityException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last locality in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality, or <code>null</code> if a matching locality could not be found
	 */
	public static Locality fetchByUuid_Last(
		String uuid, OrderByComparator<Locality> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the localities before and after the current locality in the ordered set where uuid = &#63;.
	 *
	 * @param localityId the primary key of the current locality
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next locality
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	public static Locality[] findByUuid_PrevAndNext(
			long localityId, String uuid,
			OrderByComparator<Locality> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchLocalityException {

		return getPersistence().findByUuid_PrevAndNext(
			localityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the localities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of localities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching localities
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the localities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching localities
	 */
	public static List<Locality> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the localities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @return the range of matching localities
	 */
	public static List<Locality> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the localities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localities
	 */
	public static List<Locality> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Locality> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the localities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localities
	 */
	public static List<Locality> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Locality> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first locality in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	public static Locality findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Locality> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchLocalityException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first locality in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality, or <code>null</code> if a matching locality could not be found
	 */
	public static Locality fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Locality> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last locality in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	public static Locality findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Locality> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchLocalityException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last locality in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality, or <code>null</code> if a matching locality could not be found
	 */
	public static Locality fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Locality> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the localities before and after the current locality in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param localityId the primary key of the current locality
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next locality
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	public static Locality[] findByUuid_C_PrevAndNext(
			long localityId, String uuid, long companyId,
			OrderByComparator<Locality> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchLocalityException {

		return getPersistence().findByUuid_C_PrevAndNext(
			localityId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the localities where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of localities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching localities
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the localities where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the matching localities
	 */
	public static List<Locality> findByDistrictId(long districtId) {
		return getPersistence().findByDistrictId(districtId);
	}

	/**
	 * Returns a range of all the localities where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @return the range of matching localities
	 */
	public static List<Locality> findByDistrictId(
		long districtId, int start, int end) {

		return getPersistence().findByDistrictId(districtId, start, end);
	}

	/**
	 * Returns an ordered range of all the localities where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localities
	 */
	public static List<Locality> findByDistrictId(
		long districtId, int start, int end,
		OrderByComparator<Locality> orderByComparator) {

		return getPersistence().findByDistrictId(
			districtId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the localities where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localities
	 */
	public static List<Locality> findByDistrictId(
		long districtId, int start, int end,
		OrderByComparator<Locality> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDistrictId(
			districtId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first locality in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	public static Locality findByDistrictId_First(
			long districtId, OrderByComparator<Locality> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchLocalityException {

		return getPersistence().findByDistrictId_First(
			districtId, orderByComparator);
	}

	/**
	 * Returns the first locality in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality, or <code>null</code> if a matching locality could not be found
	 */
	public static Locality fetchByDistrictId_First(
		long districtId, OrderByComparator<Locality> orderByComparator) {

		return getPersistence().fetchByDistrictId_First(
			districtId, orderByComparator);
	}

	/**
	 * Returns the last locality in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	public static Locality findByDistrictId_Last(
			long districtId, OrderByComparator<Locality> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchLocalityException {

		return getPersistence().findByDistrictId_Last(
			districtId, orderByComparator);
	}

	/**
	 * Returns the last locality in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality, or <code>null</code> if a matching locality could not be found
	 */
	public static Locality fetchByDistrictId_Last(
		long districtId, OrderByComparator<Locality> orderByComparator) {

		return getPersistence().fetchByDistrictId_Last(
			districtId, orderByComparator);
	}

	/**
	 * Returns the localities before and after the current locality in the ordered set where districtId = &#63;.
	 *
	 * @param localityId the primary key of the current locality
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next locality
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	public static Locality[] findByDistrictId_PrevAndNext(
			long localityId, long districtId,
			OrderByComparator<Locality> orderByComparator)
		throws com.ummat.slayer.exception.NoSuchLocalityException {

		return getPersistence().findByDistrictId_PrevAndNext(
			localityId, districtId, orderByComparator);
	}

	/**
	 * Removes all the localities where districtId = &#63; from the database.
	 *
	 * @param districtId the district ID
	 */
	public static void removeByDistrictId(long districtId) {
		getPersistence().removeByDistrictId(districtId);
	}

	/**
	 * Returns the number of localities where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the number of matching localities
	 */
	public static int countByDistrictId(long districtId) {
		return getPersistence().countByDistrictId(districtId);
	}

	/**
	 * Caches the locality in the entity cache if it is enabled.
	 *
	 * @param locality the locality
	 */
	public static void cacheResult(Locality locality) {
		getPersistence().cacheResult(locality);
	}

	/**
	 * Caches the localities in the entity cache if it is enabled.
	 *
	 * @param localities the localities
	 */
	public static void cacheResult(List<Locality> localities) {
		getPersistence().cacheResult(localities);
	}

	/**
	 * Creates a new locality with the primary key. Does not add the locality to the database.
	 *
	 * @param localityId the primary key for the new locality
	 * @return the new locality
	 */
	public static Locality create(long localityId) {
		return getPersistence().create(localityId);
	}

	/**
	 * Removes the locality with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localityId the primary key of the locality
	 * @return the locality that was removed
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	public static Locality remove(long localityId)
		throws com.ummat.slayer.exception.NoSuchLocalityException {

		return getPersistence().remove(localityId);
	}

	public static Locality updateImpl(Locality locality) {
		return getPersistence().updateImpl(locality);
	}

	/**
	 * Returns the locality with the primary key or throws a <code>NoSuchLocalityException</code> if it could not be found.
	 *
	 * @param localityId the primary key of the locality
	 * @return the locality
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	public static Locality findByPrimaryKey(long localityId)
		throws com.ummat.slayer.exception.NoSuchLocalityException {

		return getPersistence().findByPrimaryKey(localityId);
	}

	/**
	 * Returns the locality with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param localityId the primary key of the locality
	 * @return the locality, or <code>null</code> if a locality with the primary key could not be found
	 */
	public static Locality fetchByPrimaryKey(long localityId) {
		return getPersistence().fetchByPrimaryKey(localityId);
	}

	/**
	 * Returns all the localities.
	 *
	 * @return the localities
	 */
	public static List<Locality> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the localities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @return the range of localities
	 */
	public static List<Locality> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the localities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of localities
	 */
	public static List<Locality> findAll(
		int start, int end, OrderByComparator<Locality> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the localities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of localities
	 */
	public static List<Locality> findAll(
		int start, int end, OrderByComparator<Locality> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the localities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of localities.
	 *
	 * @return the number of localities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LocalityPersistence getPersistence() {
		return _persistence;
	}

	private static volatile LocalityPersistence _persistence;

}