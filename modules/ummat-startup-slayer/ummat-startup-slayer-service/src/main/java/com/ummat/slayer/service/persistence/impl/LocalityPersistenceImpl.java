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

package com.ummat.slayer.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import com.ummat.slayer.exception.NoSuchLocalityException;
import com.ummat.slayer.model.Locality;
import com.ummat.slayer.model.LocalityTable;
import com.ummat.slayer.model.impl.LocalityImpl;
import com.ummat.slayer.model.impl.LocalityModelImpl;
import com.ummat.slayer.service.persistence.LocalityPersistence;
import com.ummat.slayer.service.persistence.LocalityUtil;
import com.ummat.slayer.service.persistence.impl.constants.UMMATPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the locality service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LocalityPersistence.class)
public class LocalityPersistenceImpl
	extends BasePersistenceImpl<Locality> implements LocalityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LocalityUtil</code> to access the locality persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LocalityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the localities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching localities
	 */
	@Override
	public List<Locality> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Locality> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Locality> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Locality> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Locality> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Locality> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Locality> list = null;

		if (useFinderCache) {
			list = (List<Locality>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Locality locality : list) {
					if (!uuid.equals(locality.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LOCALITY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LocalityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Locality>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first locality in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	@Override
	public Locality findByUuid_First(
			String uuid, OrderByComparator<Locality> orderByComparator)
		throws NoSuchLocalityException {

		Locality locality = fetchByUuid_First(uuid, orderByComparator);

		if (locality != null) {
			return locality;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLocalityException(sb.toString());
	}

	/**
	 * Returns the first locality in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality, or <code>null</code> if a matching locality could not be found
	 */
	@Override
	public Locality fetchByUuid_First(
		String uuid, OrderByComparator<Locality> orderByComparator) {

		List<Locality> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last locality in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	@Override
	public Locality findByUuid_Last(
			String uuid, OrderByComparator<Locality> orderByComparator)
		throws NoSuchLocalityException {

		Locality locality = fetchByUuid_Last(uuid, orderByComparator);

		if (locality != null) {
			return locality;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLocalityException(sb.toString());
	}

	/**
	 * Returns the last locality in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality, or <code>null</code> if a matching locality could not be found
	 */
	@Override
	public Locality fetchByUuid_Last(
		String uuid, OrderByComparator<Locality> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Locality> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Locality[] findByUuid_PrevAndNext(
			long localityId, String uuid,
			OrderByComparator<Locality> orderByComparator)
		throws NoSuchLocalityException {

		uuid = Objects.toString(uuid, "");

		Locality locality = findByPrimaryKey(localityId);

		Session session = null;

		try {
			session = openSession();

			Locality[] array = new LocalityImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, locality, uuid, orderByComparator, true);

			array[1] = locality;

			array[2] = getByUuid_PrevAndNext(
				session, locality, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Locality getByUuid_PrevAndNext(
		Session session, Locality locality, String uuid,
		OrderByComparator<Locality> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOCALITY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LocalityModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(locality)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Locality> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the localities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Locality locality :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(locality);
		}
	}

	/**
	 * Returns the number of localities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching localities
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOCALITY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"locality.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(locality.uuid IS NULL OR locality.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the localities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching localities
	 */
	@Override
	public List<Locality> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Locality> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Locality> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Locality> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Locality> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Locality> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Locality> list = null;

		if (useFinderCache) {
			list = (List<Locality>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Locality locality : list) {
					if (!uuid.equals(locality.getUuid()) ||
						(companyId != locality.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_LOCALITY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LocalityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Locality>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Locality findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Locality> orderByComparator)
		throws NoSuchLocalityException {

		Locality locality = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (locality != null) {
			return locality;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLocalityException(sb.toString());
	}

	/**
	 * Returns the first locality in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality, or <code>null</code> if a matching locality could not be found
	 */
	@Override
	public Locality fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Locality> orderByComparator) {

		List<Locality> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Locality findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Locality> orderByComparator)
		throws NoSuchLocalityException {

		Locality locality = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (locality != null) {
			return locality;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLocalityException(sb.toString());
	}

	/**
	 * Returns the last locality in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality, or <code>null</code> if a matching locality could not be found
	 */
	@Override
	public Locality fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Locality> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Locality> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Locality[] findByUuid_C_PrevAndNext(
			long localityId, String uuid, long companyId,
			OrderByComparator<Locality> orderByComparator)
		throws NoSuchLocalityException {

		uuid = Objects.toString(uuid, "");

		Locality locality = findByPrimaryKey(localityId);

		Session session = null;

		try {
			session = openSession();

			Locality[] array = new LocalityImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, locality, uuid, companyId, orderByComparator, true);

			array[1] = locality;

			array[2] = getByUuid_C_PrevAndNext(
				session, locality, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Locality getByUuid_C_PrevAndNext(
		Session session, Locality locality, String uuid, long companyId,
		OrderByComparator<Locality> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LOCALITY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LocalityModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(locality)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Locality> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the localities where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Locality locality :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(locality);
		}
	}

	/**
	 * Returns the number of localities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching localities
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LOCALITY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"locality.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(locality.uuid IS NULL OR locality.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"locality.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByDistrictId;
	private FinderPath _finderPathWithoutPaginationFindByDistrictId;
	private FinderPath _finderPathCountByDistrictId;

	/**
	 * Returns all the localities where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the matching localities
	 */
	@Override
	public List<Locality> findByDistrictId(long districtId) {
		return findByDistrictId(
			districtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Locality> findByDistrictId(
		long districtId, int start, int end) {

		return findByDistrictId(districtId, start, end, null);
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
	@Override
	public List<Locality> findByDistrictId(
		long districtId, int start, int end,
		OrderByComparator<Locality> orderByComparator) {

		return findByDistrictId(
			districtId, start, end, orderByComparator, true);
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
	@Override
	public List<Locality> findByDistrictId(
		long districtId, int start, int end,
		OrderByComparator<Locality> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDistrictId;
				finderArgs = new Object[] {districtId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDistrictId;
			finderArgs = new Object[] {
				districtId, start, end, orderByComparator
			};
		}

		List<Locality> list = null;

		if (useFinderCache) {
			list = (List<Locality>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Locality locality : list) {
					if (districtId != locality.getDistrictId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LOCALITY_WHERE);

			sb.append(_FINDER_COLUMN_DISTRICTID_DISTRICTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LocalityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(districtId);

				list = (List<Locality>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first locality in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	@Override
	public Locality findByDistrictId_First(
			long districtId, OrderByComparator<Locality> orderByComparator)
		throws NoSuchLocalityException {

		Locality locality = fetchByDistrictId_First(
			districtId, orderByComparator);

		if (locality != null) {
			return locality;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("districtId=");
		sb.append(districtId);

		sb.append("}");

		throw new NoSuchLocalityException(sb.toString());
	}

	/**
	 * Returns the first locality in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching locality, or <code>null</code> if a matching locality could not be found
	 */
	@Override
	public Locality fetchByDistrictId_First(
		long districtId, OrderByComparator<Locality> orderByComparator) {

		List<Locality> list = findByDistrictId(
			districtId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last locality in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality
	 * @throws NoSuchLocalityException if a matching locality could not be found
	 */
	@Override
	public Locality findByDistrictId_Last(
			long districtId, OrderByComparator<Locality> orderByComparator)
		throws NoSuchLocalityException {

		Locality locality = fetchByDistrictId_Last(
			districtId, orderByComparator);

		if (locality != null) {
			return locality;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("districtId=");
		sb.append(districtId);

		sb.append("}");

		throw new NoSuchLocalityException(sb.toString());
	}

	/**
	 * Returns the last locality in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching locality, or <code>null</code> if a matching locality could not be found
	 */
	@Override
	public Locality fetchByDistrictId_Last(
		long districtId, OrderByComparator<Locality> orderByComparator) {

		int count = countByDistrictId(districtId);

		if (count == 0) {
			return null;
		}

		List<Locality> list = findByDistrictId(
			districtId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Locality[] findByDistrictId_PrevAndNext(
			long localityId, long districtId,
			OrderByComparator<Locality> orderByComparator)
		throws NoSuchLocalityException {

		Locality locality = findByPrimaryKey(localityId);

		Session session = null;

		try {
			session = openSession();

			Locality[] array = new LocalityImpl[3];

			array[0] = getByDistrictId_PrevAndNext(
				session, locality, districtId, orderByComparator, true);

			array[1] = locality;

			array[2] = getByDistrictId_PrevAndNext(
				session, locality, districtId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Locality getByDistrictId_PrevAndNext(
		Session session, Locality locality, long districtId,
		OrderByComparator<Locality> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOCALITY_WHERE);

		sb.append(_FINDER_COLUMN_DISTRICTID_DISTRICTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LocalityModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(districtId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(locality)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Locality> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the localities where districtId = &#63; from the database.
	 *
	 * @param districtId the district ID
	 */
	@Override
	public void removeByDistrictId(long districtId) {
		for (Locality locality :
				findByDistrictId(
					districtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(locality);
		}
	}

	/**
	 * Returns the number of localities where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the number of matching localities
	 */
	@Override
	public int countByDistrictId(long districtId) {
		FinderPath finderPath = _finderPathCountByDistrictId;

		Object[] finderArgs = new Object[] {districtId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOCALITY_WHERE);

			sb.append(_FINDER_COLUMN_DISTRICTID_DISTRICTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(districtId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DISTRICTID_DISTRICTID_2 =
		"locality.districtId = ?";

	public LocalityPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Locality.class);

		setModelImplClass(LocalityImpl.class);
		setModelPKClass(long.class);

		setTable(LocalityTable.INSTANCE);
	}

	/**
	 * Caches the locality in the entity cache if it is enabled.
	 *
	 * @param locality the locality
	 */
	@Override
	public void cacheResult(Locality locality) {
		entityCache.putResult(
			LocalityImpl.class, locality.getPrimaryKey(), locality);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the localities in the entity cache if it is enabled.
	 *
	 * @param localities the localities
	 */
	@Override
	public void cacheResult(List<Locality> localities) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (localities.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Locality locality : localities) {
			if (entityCache.getResult(
					LocalityImpl.class, locality.getPrimaryKey()) == null) {

				cacheResult(locality);
			}
		}
	}

	/**
	 * Clears the cache for all localities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LocalityImpl.class);

		finderCache.clearCache(LocalityImpl.class);
	}

	/**
	 * Clears the cache for the locality.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Locality locality) {
		entityCache.removeResult(LocalityImpl.class, locality);
	}

	@Override
	public void clearCache(List<Locality> localities) {
		for (Locality locality : localities) {
			entityCache.removeResult(LocalityImpl.class, locality);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LocalityImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LocalityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new locality with the primary key. Does not add the locality to the database.
	 *
	 * @param localityId the primary key for the new locality
	 * @return the new locality
	 */
	@Override
	public Locality create(long localityId) {
		Locality locality = new LocalityImpl();

		locality.setNew(true);
		locality.setPrimaryKey(localityId);

		String uuid = _portalUUID.generate();

		locality.setUuid(uuid);

		locality.setCompanyId(CompanyThreadLocal.getCompanyId());

		return locality;
	}

	/**
	 * Removes the locality with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localityId the primary key of the locality
	 * @return the locality that was removed
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	@Override
	public Locality remove(long localityId) throws NoSuchLocalityException {
		return remove((Serializable)localityId);
	}

	/**
	 * Removes the locality with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the locality
	 * @return the locality that was removed
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	@Override
	public Locality remove(Serializable primaryKey)
		throws NoSuchLocalityException {

		Session session = null;

		try {
			session = openSession();

			Locality locality = (Locality)session.get(
				LocalityImpl.class, primaryKey);

			if (locality == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLocalityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(locality);
		}
		catch (NoSuchLocalityException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Locality removeImpl(Locality locality) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(locality)) {
				locality = (Locality)session.get(
					LocalityImpl.class, locality.getPrimaryKeyObj());
			}

			if (locality != null) {
				session.delete(locality);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (locality != null) {
			clearCache(locality);
		}

		return locality;
	}

	@Override
	public Locality updateImpl(Locality locality) {
		boolean isNew = locality.isNew();

		if (!(locality instanceof LocalityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(locality.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(locality);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in locality proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Locality implementation " +
					locality.getClass());
		}

		LocalityModelImpl localityModelImpl = (LocalityModelImpl)locality;

		if (Validator.isNull(locality.getUuid())) {
			String uuid = _portalUUID.generate();

			locality.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (locality.getCreateDate() == null)) {
			if (serviceContext == null) {
				locality.setCreateDate(date);
			}
			else {
				locality.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!localityModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				locality.setModifiedDate(date);
			}
			else {
				locality.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(locality);
			}
			else {
				locality = (Locality)session.merge(locality);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LocalityImpl.class, localityModelImpl, false, true);

		if (isNew) {
			locality.setNew(false);
		}

		locality.resetOriginalValues();

		return locality;
	}

	/**
	 * Returns the locality with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the locality
	 * @return the locality
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	@Override
	public Locality findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLocalityException {

		Locality locality = fetchByPrimaryKey(primaryKey);

		if (locality == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLocalityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return locality;
	}

	/**
	 * Returns the locality with the primary key or throws a <code>NoSuchLocalityException</code> if it could not be found.
	 *
	 * @param localityId the primary key of the locality
	 * @return the locality
	 * @throws NoSuchLocalityException if a locality with the primary key could not be found
	 */
	@Override
	public Locality findByPrimaryKey(long localityId)
		throws NoSuchLocalityException {

		return findByPrimaryKey((Serializable)localityId);
	}

	/**
	 * Returns the locality with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param localityId the primary key of the locality
	 * @return the locality, or <code>null</code> if a locality with the primary key could not be found
	 */
	@Override
	public Locality fetchByPrimaryKey(long localityId) {
		return fetchByPrimaryKey((Serializable)localityId);
	}

	/**
	 * Returns all the localities.
	 *
	 * @return the localities
	 */
	@Override
	public List<Locality> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Locality> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Locality> findAll(
		int start, int end, OrderByComparator<Locality> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Locality> findAll(
		int start, int end, OrderByComparator<Locality> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Locality> list = null;

		if (useFinderCache) {
			list = (List<Locality>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LOCALITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LOCALITY;

				sql = sql.concat(LocalityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Locality>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the localities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Locality locality : findAll()) {
			remove(locality);
		}
	}

	/**
	 * Returns the number of localities.
	 *
	 * @return the number of localities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LOCALITY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "localityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LOCALITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LocalityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the locality persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByDistrictId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDistrictId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"districtId"}, true);

		_finderPathWithoutPaginationFindByDistrictId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDistrictId",
			new String[] {Long.class.getName()}, new String[] {"districtId"},
			true);

		_finderPathCountByDistrictId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDistrictId",
			new String[] {Long.class.getName()}, new String[] {"districtId"},
			false);

		_setLocalityUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setLocalityUtilPersistence(null);

		entityCache.removeCache(LocalityImpl.class.getName());
	}

	private void _setLocalityUtilPersistence(
		LocalityPersistence localityPersistence) {

		try {
			Field field = LocalityUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, localityPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = UMMATPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = UMMATPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = UMMATPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LOCALITY =
		"SELECT locality FROM Locality locality";

	private static final String _SQL_SELECT_LOCALITY_WHERE =
		"SELECT locality FROM Locality locality WHERE ";

	private static final String _SQL_COUNT_LOCALITY =
		"SELECT COUNT(locality) FROM Locality locality";

	private static final String _SQL_COUNT_LOCALITY_WHERE =
		"SELECT COUNT(locality) FROM Locality locality WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "locality.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Locality exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Locality exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LocalityPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "active"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}