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

import de.uhh.l2g.plugins.migration.model.LegacyProducer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyProducer in entity cache.
 *
 * @author unihh
 * @see LegacyProducer
 * @generated
 */
public class LegacyProducerCacheModel implements CacheModel<LegacyProducer>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", idNum=");
		sb.append(idNum);
		sb.append(", homeDir=");
		sb.append(homeDir);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", hostId=");
		sb.append(hostId);
		sb.append(", facilityId=");
		sb.append(facilityId);
		sb.append(", numberOfProductions=");
		sb.append(numberOfProductions);
		sb.append(", approved=");
		sb.append(approved);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyProducer toEntityModel() {
		LegacyProducerImpl legacyProducerImpl = new LegacyProducerImpl();

		legacyProducerImpl.setId(id);

		if (idNum == null) {
			legacyProducerImpl.setIdNum(StringPool.BLANK);
		}
		else {
			legacyProducerImpl.setIdNum(idNum);
		}

		if (homeDir == null) {
			legacyProducerImpl.setHomeDir(StringPool.BLANK);
		}
		else {
			legacyProducerImpl.setHomeDir(homeDir);
		}

		legacyProducerImpl.setUserId(userId);
		legacyProducerImpl.setHostId(hostId);
		legacyProducerImpl.setFacilityId(facilityId);
		legacyProducerImpl.setNumberOfProductions(numberOfProductions);
		legacyProducerImpl.setApproved(approved);

		legacyProducerImpl.resetOriginalValues();

		return legacyProducerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		idNum = objectInput.readUTF();
		homeDir = objectInput.readUTF();
		userId = objectInput.readLong();
		hostId = objectInput.readLong();
		facilityId = objectInput.readLong();
		numberOfProductions = objectInput.readLong();
		approved = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (idNum == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idNum);
		}

		if (homeDir == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(homeDir);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(hostId);
		objectOutput.writeLong(facilityId);
		objectOutput.writeLong(numberOfProductions);
		objectOutput.writeInt(approved);
	}

	public long id;
	public String idNum;
	public String homeDir;
	public long userId;
	public long hostId;
	public long facilityId;
	public long numberOfProductions;
	public int approved;
}