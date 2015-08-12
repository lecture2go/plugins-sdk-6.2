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

package de.uhh.l2g.plugins.migration.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.migration.model.LegacyOffice;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyOffice in entity cache.
 *
 * @author unihh
 * @see LegacyOffice
 * @generated
 */
public class LegacyOfficeCacheModel implements CacheModel<LegacyOffice>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", www=");
		sb.append(www);
		sb.append(", email=");
		sb.append(email);
		sb.append(", facilityId=");
		sb.append(facilityId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyOffice toEntityModel() {
		LegacyOfficeImpl legacyOfficeImpl = new LegacyOfficeImpl();

		legacyOfficeImpl.setId(id);

		if (name == null) {
			legacyOfficeImpl.setName(StringPool.BLANK);
		}
		else {
			legacyOfficeImpl.setName(name);
		}

		if (www == null) {
			legacyOfficeImpl.setWww(StringPool.BLANK);
		}
		else {
			legacyOfficeImpl.setWww(www);
		}

		if (email == null) {
			legacyOfficeImpl.setEmail(StringPool.BLANK);
		}
		else {
			legacyOfficeImpl.setEmail(email);
		}

		legacyOfficeImpl.setFacilityId(facilityId);

		legacyOfficeImpl.resetOriginalValues();

		return legacyOfficeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		name = objectInput.readUTF();
		www = objectInput.readUTF();
		email = objectInput.readUTF();
		facilityId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (www == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(www);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(facilityId);
	}

	public long id;
	public String name;
	public String www;
	public String email;
	public long facilityId;
}