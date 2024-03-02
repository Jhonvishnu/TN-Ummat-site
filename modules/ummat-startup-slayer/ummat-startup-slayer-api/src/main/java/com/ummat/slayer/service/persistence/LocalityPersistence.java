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

import com.ummat.slayer.exception.NoSuchLocalityException;
import com.ummat.slayer.model.Locality;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the locality service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalityUtil
 * @generated
 */
@ProviderType
public interface LocalityPersistence extends BasePersistence<Locality> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LocalityUtil} to access the locality persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the localities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching localities
	 */
	public java.util.List<Locality> findByUuid(String uuid);

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
	public java.util.List<Locality> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Locality> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator);

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
	public java.util.List<Locality> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first locality in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	public Locality findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Locality>
				orderByComparator)
		throws NoSuchLocalityException;

	/**
	 * Returns the first locality in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality, or <code>null</code> if a matching locality could not be found
	 */
	public Locality fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator);

	/**
	 * Returns the last locality in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	public Locality findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Locality>
				orderByComparator)
		throws NoSuchLocalityException;

	/**
	 * Returns the last locality in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality, or <code>null</code> if a matching locality could not be found
	 */
	public Locality fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator);

	/**
	 * Returns the localities before and after the current locality in the ordered set where uuid = &#63;.
	 *
	 * @param localityId the primary key of the current locality
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next locality
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	public Locality[] findByUuid_PrevAndNext(
			long localityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Locality>
				orderByComparator)
		throws NoSuchLocalityException;

	/**
	 * Removes all the localities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of localities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching localities
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the localities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching localities
	 */
	public java.util.List<Locality> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Locality> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Locality> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator);

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
	public java.util.List<Locality> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first locality in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	public Locality findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Locality>
				orderByComparator)
		throws NoSuchLocalityException;

	/**
	 * Returns the first locality in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality, or <code>null</code> if a matching locality could not be found
	 */
	public Locality fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator);

	/**
	 * Returns the last locality in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	public Locality findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Locality>
				orderByComparator)
		throws NoSuchLocalityException;

	/**
	 * Returns the last locality in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality, or <code>null</code> if a matching locality could not be found
	 */
	public Locality fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator);

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
	public Locality[] findByUuid_C_PrevAndNext(
			long localityId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Locality>
				orderByComparator)
		throws NoSuchLocalityException;

	/**
	 * Removes all the localities where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of localities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching localities
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the localities where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the matching localities
	 */
	public java.util.List<Locality> findByDistrictId(long districtId);

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
	public java.util.List<Locality> findByDistrictId(
		long districtId, int start, int end);

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
	public java.util.List<Locality> findByDistrictId(
		long districtId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator);

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
	public java.util.List<Locality> findByDistrictId(
		long districtId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first locality in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	public Locality findByDistrictId_First(
			long districtId,
			com.liferay.portal.kernel.util.OrderByComparator<Locality>
				orderByComparator)
		throws NoSuchLocalityException;

	/**
	 * Returns the first locality in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality, or <code>null</code> if a matching locality could not be found
	 */
	public Locality fetchByDistrictId_First(
		long districtId,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator);

	/**
	 * Returns the last locality in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	public Locality findByDistrictId_Last(
			long districtId,
			com.liferay.portal.kernel.util.OrderByComparator<Locality>
				orderByComparator)
		throws NoSuchLocalityException;

	/**
	 * Returns the last locality in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality, or <code>null</code> if a matching locality could not be found
	 */
	public Locality fetchByDistrictId_Last(
		long districtId,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator);

	/**
	 * Returns the localities before and after the current locality in the ordered set where districtId = &#63;.
	 *
	 * @param localityId the primary key of the current locality
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next locality
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	public Locality[] findByDistrictId_PrevAndNext(
			long localityId, long districtId,
			com.liferay.portal.kernel.util.OrderByComparator<Locality>
				orderByComparator)
		throws NoSuchLocalityException;

	/**
	 * Removes all the localities where districtId = &#63; from the database.
	 *
	 * @param districtId the district ID
	 */
	public void removeByDistrictId(long districtId);

	/**
	 * Returns the number of localities where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the number of matching localities
	 */
	public int countByDistrictId(long districtId);

	/**
	 * Caches the locality in the entity cache if it is enabled.
	 *
	 * @param locality the locality
	 */
	public void cacheResult(Locality locality);

	/**
	 * Caches the localities in the entity cache if it is enabled.
	 *
	 * @param localities the localities
	 */
	public void cacheResult(java.util.List<Locality> localities);

	/**
	 * Creates a new locality with the primary key. Does not add the locality to the database.
	 *
	 * @param localityId the primary key for the new locality
	 * @return the new locality
	 */
	public Locality create(long localityId);

	/**
	 * Removes the locality with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localityId the primary key of the locality
	 * @return the locality that was removed
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	public Locality remove(long localityId) throws NoSuchLocalityException;

	public Locality updateImpl(Locality locality);

	/**
	 * Returns the locality with the primary key or throws a <code>NoSuchLocalityException</code> if it could not be found.
	 *
	 * @param localityId the primary key of the locality
	 * @return the locality
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	public Locality findByPrimaryKey(long localityId)
		throws NoSuchLocalityException;

	/**
	 * Returns the locality with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param localityId the primary key of the locality
	 * @return the locality, or <code>null</code> if a locality with the primary key could not be found
	 */
	public Locality fetchByPrimaryKey(long localityId);

	/**
	 * Returns all the localities.
	 *
	 * @return the localities
	 */
	public java.util.List<Locality> findAll();

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
	public java.util.List<Locality> findAll(int start, int end);

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
	public java.util.List<Locality> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator);

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
	public java.util.List<Locality> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Locality>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the localities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of localities.
	 *
	 * @return the number of localities
	 */
	public int countAll();

}