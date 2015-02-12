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

package de.uhh.l2g.plugins.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.model.Office;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Office in entity cache.
 *
 * @author Iavor Sturm
 * @see Office
 * @generated
 */
public class OfficeCacheModel implements CacheModel<Office>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{officeId=");
		sb.append(officeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", www=");
		sb.append(www);
		sb.append(", email=");
		sb.append(email);
		sb.append(", institutionId=");
		sb.append(institutionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Office toEntityModel() {
		OfficeImpl officeImpl = new OfficeImpl();

		officeImpl.setOfficeId(officeId);

		if (name == null) {
			officeImpl.setName(StringPool.BLANK);
		}
		else {
			officeImpl.setName(name);
		}

		if (www == null) {
			officeImpl.setWww(StringPool.BLANK);
		}
		else {
			officeImpl.setWww(www);
		}

		if (email == null) {
			officeImpl.setEmail(StringPool.BLANK);
		}
		else {
			officeImpl.setEmail(email);
		}

		officeImpl.setInstitutionId(institutionId);

		officeImpl.resetOriginalValues();

		return officeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		officeId = objectInput.readLong();
		name = objectInput.readUTF();
		www = objectInput.readUTF();
		email = objectInput.readUTF();
		institutionId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(officeId);

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

		objectOutput.writeLong(institutionId);
	}

	public long officeId;
	public String name;
	public String www;
	public String email;
	public long institutionId;
}