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
 * Provides a wrapper for {@link DistrictService}.
 *
 * @author Brian Wing Shun Chan
 * @see DistrictService
 * @generated
 */
public class DistrictServiceWrapper
	implements DistrictService, ServiceWrapper<DistrictService> {

	public DistrictServiceWrapper() {
		this(null);
	}

	public DistrictServiceWrapper(DistrictService districtService) {
		_districtService = districtService;
	}

	@Override
	public java.util.List<com.ummat.slayer.model.District> getByRegionId(
		long regionId) {

		return _districtService.getByRegionId(regionId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _districtService.getOSGiServiceIdentifier();
	}

	@Override
	public DistrictService getWrappedService() {
		return _districtService;
	}

	@Override
	public void setWrappedService(DistrictService districtService) {
		_districtService = districtService;
	}

	private DistrictService _districtService;

}