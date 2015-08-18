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
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.migration.model.LegacyFacilityHost;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyFacilityHost in entity cache.
 *
 * @author unihh
 * @see LegacyFacilityHost
 * @generated
 */
public class LegacyFacilityHostCacheModel implements CacheModel<LegacyFacilityHost>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{facilityHostId=");
		sb.append(facilityHostId);
		sb.append(", facilityId=");
		sb.append(facilityId);
		sb.append(", hostId=");
		sb.append(hostId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyFacilityHost toEntityModel() {
		LegacyFacilityHostImpl legacyFacilityHostImpl = new LegacyFacilityHostImpl();

		legacyFacilityHostImpl.setFacilityHostId(facilityHostId);
		legacyFacilityHostImpl.setFacilityId(facilityId);
		legacyFacilityHostImpl.setHostId(hostId);

		legacyFacilityHostImpl.resetOriginalValues();

		return legacyFacilityHostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		facilityHostId = objectInput.readLong();
		facilityId = objectInput.readLong();
		hostId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(facilityHostId);
		objectOutput.writeLong(facilityId);
		objectOutput.writeLong(hostId);
	}

	public long facilityHostId;
	public long facilityId;
	public long hostId;
}