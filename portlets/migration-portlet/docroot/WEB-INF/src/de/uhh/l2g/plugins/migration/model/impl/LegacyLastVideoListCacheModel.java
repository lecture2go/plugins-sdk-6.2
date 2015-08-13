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

import de.uhh.l2g.plugins.migration.model.LegacyLastVideoList;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyLastVideoList in entity cache.
 *
 * @author unihh
 * @see LegacyLastVideoList
 * @generated
 */
public class LegacyLastVideoListCacheModel implements CacheModel<LegacyLastVideoList>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id=");
		sb.append(id);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyLastVideoList toEntityModel() {
		LegacyLastVideoListImpl legacyLastVideoListImpl = new LegacyLastVideoListImpl();

		legacyLastVideoListImpl.setId(id);
		legacyLastVideoListImpl.setVideoId(videoId);

		legacyLastVideoListImpl.resetOriginalValues();

		return legacyLastVideoListImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		videoId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(id);
		objectOutput.writeLong(videoId);
	}

	public int id;
	public long videoId;
}