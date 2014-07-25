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

import de.uhh.l2g.plugins.model.Facility_Host;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Facility_Host in entity cache.
 *
 * @author Iavor Sturm
 * @see Facility_Host
 * @generated
 */
public class Facility_HostCacheModel implements CacheModel<Facility_Host>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{fasilityHostId=");
		sb.append(fasilityHostId);
		sb.append(", facilityId=");
		sb.append(facilityId);
		sb.append(", hostId=");
		sb.append(hostId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Facility_Host toEntityModel() {
		Facility_HostImpl facility_HostImpl = new Facility_HostImpl();

		facility_HostImpl.setFasilityHostId(fasilityHostId);
		facility_HostImpl.setFacilityId(facilityId);
		facility_HostImpl.setHostId(hostId);

		facility_HostImpl.resetOriginalValues();

		return facility_HostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fasilityHostId = objectInput.readLong();
		facilityId = objectInput.readLong();
		hostId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(fasilityHostId);
		objectOutput.writeLong(facilityId);
		objectOutput.writeLong(hostId);
	}

	public long fasilityHostId;
	public long facilityId;
	public long hostId;
}