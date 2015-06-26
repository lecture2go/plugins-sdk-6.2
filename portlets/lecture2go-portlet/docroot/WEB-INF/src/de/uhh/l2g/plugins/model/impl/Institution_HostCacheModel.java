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
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.model.Institution_Host;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Institution_Host in entity cache.
 *
 * @author Iavor Sturm
 * @see Institution_Host
 * @generated
 */
public class Institution_HostCacheModel implements CacheModel<Institution_Host>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{institutionHostId=");
		sb.append(institutionHostId);
		sb.append(", institutionId=");
		sb.append(institutionId);
		sb.append(", hostId=");
		sb.append(hostId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Institution_Host toEntityModel() {
		Institution_HostImpl institution_HostImpl = new Institution_HostImpl();

		institution_HostImpl.setInstitutionHostId(institutionHostId);
		institution_HostImpl.setInstitutionId(institutionId);
		institution_HostImpl.setHostId(hostId);
		institution_HostImpl.setGroupId(groupId);

		institution_HostImpl.resetOriginalValues();

		return institution_HostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		institutionHostId = objectInput.readLong();
		institutionId = objectInput.readLong();
		hostId = objectInput.readLong();
		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(institutionHostId);
		objectOutput.writeLong(institutionId);
		objectOutput.writeLong(hostId);
		objectOutput.writeLong(groupId);
	}

	public long institutionHostId;
	public long institutionId;
	public long hostId;
	public long groupId;
}