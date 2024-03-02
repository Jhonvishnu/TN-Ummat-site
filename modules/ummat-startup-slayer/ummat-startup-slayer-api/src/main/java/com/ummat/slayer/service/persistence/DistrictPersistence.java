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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.ummat.slayer.exception.NoSuchDistrictException;
import com.ummat.slayer.model.District;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the district service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DistrictUtil
 * @generated
 */
@ProviderType
public interface DistrictPersistence extends BasePersistence<District> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DistrictUtil} to access the district persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the districts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching districts
	 */
	public java.util.List<District> findByUuid(String uuid);

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
	public java.util.List<District> findByUuid(String uuid, int start, int end);

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
	public java.util.List<District> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

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
	public java.util.List<District> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first district in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the first district in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns the last district in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the last district in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns the districts before and after the current district in the ordered set where uuid = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public District[] findByUuid_PrevAndNext(
			long districtId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Removes all the districts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of districts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching districts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the districts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching districts
	 */
	public java.util.List<District> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<District> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<District> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

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
	public java.util.List<District> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first district in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the first district in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns the last district in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the last district in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

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
	public District[] findByUuid_C_PrevAndNext(
			long districtId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Removes all the districts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of districts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching districts
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the districts where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the matching districts
	 */
	public java.util.List<District> findByRegionId(long regionId);

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
	public java.util.List<District> findByRegionId(
		long regionId, int start, int end);

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
	public java.util.List<District> findByRegionId(
		long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

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
	public java.util.List<District> findByRegionId(
		long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first district in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByRegionId_First(
			long regionId,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the first district in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByRegionId_First(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns the last district in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public District findByRegionId_Last(
			long regionId,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Returns the last district in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public District fetchByRegionId_Last(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

	/**
	 * Returns the districts before and after the current district in the ordered set where regionId = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public District[] findByRegionId_PrevAndNext(
			long districtId, long regionId,
			com.liferay.portal.kernel.util.OrderByComparator<District>
				orderByComparator)
		throws NoSuchDistrictException;

	/**
	 * Removes all the districts where regionId = &#63; from the database.
	 *
	 * @param regionId the region ID
	 */
	public void removeByRegionId(long regionId);

	/**
	 * Returns the number of districts where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the number of matching districts
	 */
	public int countByRegionId(long regionId);

	/**
	 * Caches the district in the entity cache if it is enabled.
	 *
	 * @param district the district
	 */
	public void cacheResult(District district);

	/**
	 * Caches the districts in the entity cache if it is enabled.
	 *
	 * @param districts the districts
	 */
	public void cacheResult(java.util.List<District> districts);

	/**
	 * Creates a new district with the primary key. Does not add the district to the database.
	 *
	 * @param districtId the primary key for the new district
	 * @return the new district
	 */
	public District create(long districtId);

	/**
	 * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param districtId the primary key of the district
	 * @return the district that was removed
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public District remove(long districtId) throws NoSuchDistrictException;

	public District updateImpl(District district);

	/**
	 * Returns the district with the primary key or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public District findByPrimaryKey(long districtId)
		throws NoSuchDistrictException;

	/**
	 * Returns the district with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district, or <code>null</code> if a district with the primary key could not be found
	 */
	public District fetchByPrimaryKey(long districtId);

	/**
	 * Returns all the districts.
	 *
	 * @return the districts
	 */
	public java.util.List<District> findAll();

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
	public java.util.List<District> findAll(int start, int end);

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
	public java.util.List<District> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator);

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
	public java.util.List<District> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<District>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the districts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of districts.
	 *
	 * @return the number of districts
	 */
	public int countAll();

}