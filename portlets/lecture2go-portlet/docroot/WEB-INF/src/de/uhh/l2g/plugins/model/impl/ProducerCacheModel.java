/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import de.uhh.l2g.plugins.model.Producer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Producer in entity cache.
 *
 * @author Iavor Sturm
 * @see Producer
 * @generated
 */
public class ProducerCacheModel implements CacheModel<Producer>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{producerId=");
		sb.append(producerId);
		sb.append(", idNum=");
		sb.append(idNum);
		sb.append(", homeDir=");
		sb.append(homeDir);
		sb.append(", hostId=");
		sb.append(hostId);
		sb.append(", institutionId=");
		sb.append(institutionId);
		sb.append(", numberOfProductions=");
		sb.append(numberOfProductions);
		sb.append(", approved=");
		sb.append(approved);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Producer toEntityModel() {
		ProducerImpl producerImpl = new ProducerImpl();

		producerImpl.setProducerId(producerId);

		if (idNum == null) {
			producerImpl.setIdNum(StringPool.BLANK);
		}
		else {
			producerImpl.setIdNum(idNum);
		}

		if (homeDir == null) {
			producerImpl.setHomeDir(StringPool.BLANK);
		}
		else {
			producerImpl.setHomeDir(homeDir);
		}

		producerImpl.setHostId(hostId);
		producerImpl.setInstitutionId(institutionId);
		producerImpl.setNumberOfProductions(numberOfProductions);
		producerImpl.setApproved(approved);

		producerImpl.resetOriginalValues();

		return producerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		producerId = objectInput.readLong();
		idNum = objectInput.readUTF();
		homeDir = objectInput.readUTF();
		hostId = objectInput.readLong();
		institutionId = objectInput.readLong();
		numberOfProductions = objectInput.readLong();
		approved = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(producerId);

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

		objectOutput.writeLong(hostId);
		objectOutput.writeLong(institutionId);
		objectOutput.writeLong(numberOfProductions);
		objectOutput.writeInt(approved);
	}

	public long producerId;
	public String idNum;
	public String homeDir;
	public long hostId;
	public long institutionId;
	public long numberOfProductions;
	public int approved;
}