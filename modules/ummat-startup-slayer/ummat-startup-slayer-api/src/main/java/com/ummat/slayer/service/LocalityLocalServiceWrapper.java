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

package com.ummat.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LocalityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LocalityLocalService
 * @generated
 */
public class LocalityLocalServiceWrapper
	implements LocalityLocalService, ServiceWrapper<LocalityLocalService> {

	public LocalityLocalServiceWrapper() {
		this(null);
	}

	public LocalityLocalServiceWrapper(
		LocalityLocalService localityLocalService) {

		_localityLocalService = localityLocalService;
	}

	/**
	 * Adds the locality to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LocalityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param locality the locality
	 * @return the locality that was added
	 */
	@Override
	public com.ummat.slayer.model.Locality addLocality(
		com.ummat.slayer.model.Locality locality) {

		return _localityLocalService.addLocality(locality);
	}

	/**
	 * Creates a new locality with the primary key. Does not add the locality to the database.
	 *
	 * @param localityId the primary key for the new locality
	 * @return the new locality
	 */
	@Override
	public com.ummat.slayer.model.Locality createLocality(long localityId) {
		return _localityLocalService.createLocality(localityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _localityLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the locality from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LocalityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param locality the locality
	 * @return the locality that was removed
	 */
	@Override
	public com.ummat.slayer.model.Locality deleteLocality(
		com.ummat.slayer.model.Locality locality) {

		return _localityLocalService.deleteLocality(locality);
	}

	/**
	 * Deletes the locality with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LocalityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param localityId the primary key of the locality
	 * @return the locality that was removed
	 * @throws PortalException if a locality with the primary key could not be found
	 */
	@Override
	public com.ummat.slayer.model.Locality deleteLocality(long localityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _localityLocalService.deleteLocality(localityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _localityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _localityLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _localityLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _localityLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _localityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ummat.slayer.model.impl.LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _localityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ummat.slayer.model.impl.LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _localityLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _localityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _localityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ummat.slayer.model.Locality fetchLocality(long localityId) {
		return _localityLocalService.fetchLocality(localityId);
	}

	/**
	 * Returns the locality with the matching UUID and company.
	 *
	 * @param uuid the locality's UUID
	 * @param companyId the primary key of the company
	 * @return the matching locality, or <code>null</code> if a matching locality could not be found
	 */
	@Override
	public com.ummat.slayer.model.Locality fetchLocalityByUuidAndCompanyId(
		String uuid, long companyId) {

		return _localityLocalService.fetchLocalityByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _localityLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _localityLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _localityLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the localities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ummat.slayer.model.impl.LocalityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of localities
	 * @param end the upper bound of the range of localities (not inclusive)
	 * @return the range of localities
	 */
	@Override
	public java.util.List<com.ummat.slayer.model.Locality> getLocalities(
		int start, int end) {

		return _localityLocalService.getLocalities(start, end);
	}

	/**
	 * Returns the number of localities.
	 *
	 * @return the number of localities
	 */
	@Override
	public int getLocalitiesCount() {
		return _localityLocalService.getLocalitiesCount();
	}

	/**
	 * Returns the locality with the primary key.
	 *
	 * @param localityId the primary key of the locality
	 * @return the locality
	 * @throws PortalException if a locality with the primary key could not be found
	 */
	@Override
	public com.ummat.slayer.model.Locality getLocality(long localityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _localityLocalService.getLocality(localityId);
	}

	@Override
	public java.util.List<com.ummat.slayer.model.Locality>
		getLocalityByDistrictId(long districtId) {

		return _localityLocalService.getLocalityByDistrictId(districtId);
	}

	/**
	 * Returns the locality with the matching UUID and company.
	 *
	 * @param uuid the locality's UUID
	 * @param companyId the primary key of the company
	 * @return the matching locality
	 * @throws PortalException if a matching locality could not be found
	 */
	@Override
	public com.ummat.slayer.model.Locality getLocalityByUuidAndCompanyId(
			String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _localityLocalService.getLocalityByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _localityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _localityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the locality in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LocalityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param locality the locality
	 * @return the locality that was updated
	 */
	@Override
	public com.ummat.slayer.model.Locality updateLocality(
		com.ummat.slayer.model.Locality locality) {

		return _localityLocalService.updateLocality(locality);
	}

	@Override
	public LocalityLocalService getWrappedService() {
		return _localityLocalService;
	}

	@Override
	public void setWrappedService(LocalityLocalService localityLocalService) {
		_localityLocalService = localityLocalService;
	}

	private LocalityLocalService _localityLocalService;

}