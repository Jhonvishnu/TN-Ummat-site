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

import com.ummat.slayer.model.Locality;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Locality in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LocalityCacheModel
	implements CacheModel<Locality>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LocalityCacheModel)) {
			return false;
		}

		LocalityCacheModel localityCacheModel = (LocalityCacheModel)object;

		if (localityId == localityCacheModel.localityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, localityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", localityId=");
		sb.append(localityId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", districtId=");
		sb.append(districtId);
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
	public Locality toEntityModel() {
		LocalityImpl localityImpl = new LocalityImpl();

		if (uuid == null) {
			localityImpl.setUuid("");
		}
		else {
			localityImpl.setUuid(uuid);
		}

		localityImpl.setLocalityId(localityId);
		localityImpl.setRegionId(regionId);
		localityImpl.setDistrictId(districtId);

		if (name == null) {
			localityImpl.setName("");
		}
		else {
			localityImpl.setName(name);
		}

		localityImpl.setActive(active);
		localityImpl.setCompanyId(companyId);
		localityImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			localityImpl.setCreateDate(null);
		}
		else {
			localityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			localityImpl.setModifiedDate(null);
		}
		else {
			localityImpl.setModifiedDate(new Date(modifiedDate));
		}

		localityImpl.resetOriginalValues();

		return localityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		localityId = objectInput.readLong();

		regionId = objectInput.readLong();

		districtId = objectInput.readLong();
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

		objectOutput.writeLong(localityId);

		objectOutput.writeLong(regionId);

		objectOutput.writeLong(districtId);

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
	public long localityId;
	public long regionId;
	public long districtId;
	public String name;
	public boolean active;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;

}