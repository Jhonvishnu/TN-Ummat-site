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
 * Provides a wrapper for {@link DistrictLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DistrictLocalService
 * @generated
 */
public class DistrictLocalServiceWrapper
	implements DistrictLocalService, ServiceWrapper<DistrictLocalService> {

	public DistrictLocalServiceWrapper() {
		this(null);
	}

	public DistrictLocalServiceWrapper(
		DistrictLocalService districtLocalService) {

		_districtLocalService = districtLocalService;
	}

	/**
	 * Adds the district to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param district the district
	 * @return the district that was added
	 */
	@Override
	public com.ummat.slayer.model.District addDistrict(
		com.ummat.slayer.model.District district) {

		return _districtLocalService.addDistrict(district);
	}

	/**
	 * Creates a new district with the primary key. Does not add the district to the database.
	 *
	 * @param districtId the primary key for the new district
	 * @return the new district
	 */
	@Override
	public com.ummat.slayer.model.District createDistrict(long districtId) {
		return _districtLocalService.createDistrict(districtId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the district from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param district the district
	 * @return the district that was removed
	 */
	@Override
	public com.ummat.slayer.model.District deleteDistrict(
		com.ummat.slayer.model.District district) {

		return _districtLocalService.deleteDistrict(district);
	}

	/**
	 * Deletes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param districtId the primary key of the district
	 * @return the district that was removed
	 * @throws PortalException if a district with the primary key could not be found
	 */
	@Override
	public com.ummat.slayer.model.District deleteDistrict(long districtId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtLocalService.deleteDistrict(districtId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _districtLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _districtLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _districtLocalService.dynamicQuery();
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

		return _districtLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ummat.slayer.model.impl.DistrictModelImpl</code>.
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

		return _districtLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ummat.slayer.model.impl.DistrictModelImpl</code>.
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

		return _districtLocalService.dynamicQuery(
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

		return _districtLocalService.dynamicQueryCount(dynamicQuery);
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

		return _districtLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ummat.slayer.model.District fetchDistrict(long districtId) {
		return _districtLocalService.fetchDistrict(districtId);
	}

	/**
	 * Returns the district with the matching UUID and company.
	 *
	 * @param uuid the district's UUID
	 * @param companyId the primary key of the company
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 */
	@Override
	public com.ummat.slayer.model.District fetchDistrictByUuidAndCompanyId(
		String uuid, long companyId) {

		return _districtLocalService.fetchDistrictByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _districtLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ummat.slayer.model.District> getByRegionId(
		long regionId) {

		return _districtLocalService.getByRegionId(regionId);
	}

	/**
	 * Returns the district with the primary key.
	 *
	 * @param districtId the primary key of the district
	 * @return the district
	 * @throws PortalException if a district with the primary key could not be found
	 */
	@Override
	public com.ummat.slayer.model.District getDistrict(long districtId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtLocalService.getDistrict(districtId);
	}

	/**
	 * Returns the district with the matching UUID and company.
	 *
	 * @param uuid the district's UUID
	 * @param companyId the primary key of the company
	 * @return the matching district
	 * @throws PortalException if a matching district could not be found
	 */
	@Override
	public com.ummat.slayer.model.District getDistrictByUuidAndCompanyId(
			String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtLocalService.getDistrictByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ummat.slayer.model.impl.DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of districts
	 */
	@Override
	public java.util.List<com.ummat.slayer.model.District> getDistricts(
		int start, int end) {

		return _districtLocalService.getDistricts(start, end);
	}

	/**
	 * Returns the number of districts.
	 *
	 * @return the number of districts
	 */
	@Override
	public int getDistrictsCount() {
		return _districtLocalService.getDistrictsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _districtLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _districtLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _districtLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _districtLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the district in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param district the district
	 * @return the district that was updated
	 */
	@Override
	public com.ummat.slayer.model.District updateDistrict(
		com.ummat.slayer.model.District district) {

		return _districtLocalService.updateDistrict(district);
	}

	@Override
	public DistrictLocalService getWrappedService() {
		return _districtLocalService;
	}

	@Override
	public void setWrappedService(DistrictLocalService districtLocalService) {
		_districtLocalService = districtLocalService;
	}

	private DistrictLocalService _districtLocalService;

}