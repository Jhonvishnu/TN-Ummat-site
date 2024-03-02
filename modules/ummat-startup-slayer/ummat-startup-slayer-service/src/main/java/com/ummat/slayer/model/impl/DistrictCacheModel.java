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

package com.ummat.slayer.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.ummat.slayer.model.District;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing District in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DistrictCacheModel
	implements CacheModel<District>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DistrictCacheModel)) {
			return false;
		}

		DistrictCacheModel districtCacheModel = (DistrictCacheModel)object;

		if (districtId == districtCacheModel.districtId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, districtId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", districtId=");
		sb.append(districtId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", active=");
		sb.append(active);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public District toEntityModel() {
		DistrictImpl districtImpl = new DistrictImpl();

		if (uuid == null) {
			districtImpl.setUuid("");
		}
		else {
			districtImpl.setUuid(uuid);
		}

		districtImpl.setDistrictId(districtId);
		districtImpl.setRegionId(regionId);

		if (name == null) {
			districtImpl.setName("");
		}
		else {
			districtImpl.setName(name);
		}

		districtImpl.setActive(active);
		districtImpl.setCompanyId(companyId);
		districtImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			districtImpl.setCreateDate(null);
		}
		else {
			districtImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			districtImpl.setModifiedDate(null);
		}
		else {
			districtImpl.setModifiedDate(new Date(modifiedDate));
		}

		districtImpl.resetOriginalValues();

		return districtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		districtId = objectInput.readLong();

		regionId = objectInput.readLong();
		name = objectInput.readUTF();

		active = objectInput.readBoolean();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(districtId);

		objectOutput.writeLong(regionId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(active);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long districtId;
	public long regionId;
	public String name;
	public boolean active;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;

}