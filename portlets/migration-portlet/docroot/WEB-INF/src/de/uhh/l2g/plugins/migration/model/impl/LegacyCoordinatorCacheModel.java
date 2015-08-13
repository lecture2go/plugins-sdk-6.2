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

import de.uhh.l2g.plugins.migration.model.LegacyCoordinator;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyCoordinator in entity cache.
 *
 * @author unihh
 * @see LegacyCoordinator
 * @generated
 */
public class LegacyCoordinatorCacheModel implements CacheModel<LegacyCoordinator>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", facilityId=");
		sb.append(facilityId);
		sb.append(", officeId=");
		sb.append(officeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyCoordinator toEntityModel() {
		LegacyCoordinatorImpl legacyCoordinatorImpl = new LegacyCoordinatorImpl();

		legacyCoordinatorImpl.setUserId(userId);
		legacyCoordinatorImpl.setFacilityId(facilityId);
		legacyCoordinatorImpl.setOfficeId(officeId);

		legacyCoordinatorImpl.resetOriginalValues();

		return legacyCoordinatorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		facilityId = objectInput.readLong();
		officeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);
		objectOutput.writeLong(facilityId);
		objectOutput.writeLong(officeId);
	}

	public long userId;
	public long facilityId;
	public long officeId;
}