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

import de.uhh.l2g.plugins.migration.model.LegacyLicense;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyLicense in entity cache.
 *
 * @author unihh
 * @see LegacyLicense
 * @generated
 */
public class LegacyLicenseCacheModel implements CacheModel<LegacyLicense>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", ccby=");
		sb.append(ccby);
		sb.append(", ccbybc=");
		sb.append(ccbybc);
		sb.append(", ccbyncnd=");
		sb.append(ccbyncnd);
		sb.append(", ccbyncsa=");
		sb.append(ccbyncsa);
		sb.append(", ccbysa=");
		sb.append(ccbysa);
		sb.append(", ccbync=");
		sb.append(ccbync);
		sb.append(", l2go=");
		sb.append(l2go);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyLicense toEntityModel() {
		LegacyLicenseImpl legacyLicenseImpl = new LegacyLicenseImpl();

		legacyLicenseImpl.setId(id);
		legacyLicenseImpl.setVideoId(videoId);
		legacyLicenseImpl.setCcby(ccby);
		legacyLicenseImpl.setCcbybc(ccbybc);
		legacyLicenseImpl.setCcbyncnd(ccbyncnd);
		legacyLicenseImpl.setCcbyncsa(ccbyncsa);
		legacyLicenseImpl.setCcbysa(ccbysa);
		legacyLicenseImpl.setCcbync(ccbync);
		legacyLicenseImpl.setL2go(l2go);

		legacyLicenseImpl.resetOriginalValues();

		return legacyLicenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		videoId = objectInput.readLong();
		ccby = objectInput.readInt();
		ccbybc = objectInput.readInt();
		ccbyncnd = objectInput.readInt();
		ccbyncsa = objectInput.readInt();
		ccbysa = objectInput.readInt();
		ccbync = objectInput.readInt();
		l2go = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(videoId);
		objectOutput.writeInt(ccby);
		objectOutput.writeInt(ccbybc);
		objectOutput.writeInt(ccbyncnd);
		objectOutput.writeInt(ccbyncsa);
		objectOutput.writeInt(ccbysa);
		objectOutput.writeInt(ccbync);
		objectOutput.writeInt(l2go);
	}

	public long id;
	public long videoId;
	public int ccby;
	public int ccbybc;
	public int ccbyncnd;
	public int ccbyncsa;
	public int ccbysa;
	public int ccbync;
	public int l2go;
}