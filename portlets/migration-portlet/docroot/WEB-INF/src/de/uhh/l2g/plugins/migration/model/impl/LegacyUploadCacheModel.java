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

import de.uhh.l2g.plugins.migration.model.LegacyUpload;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegacyUpload in entity cache.
 *
 * @author unihh
 * @see LegacyUpload
 * @generated
 */
public class LegacyUploadCacheModel implements CacheModel<LegacyUpload>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", contentLength=");
		sb.append(contentLength);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append(", status=");
		sb.append(status);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyUpload toEntityModel() {
		LegacyUploadImpl legacyUploadImpl = new LegacyUploadImpl();

		legacyUploadImpl.setId(id);
		legacyUploadImpl.setUserId(userId);
		legacyUploadImpl.setContentLength(contentLength);

		if (timestamp == Long.MIN_VALUE) {
			legacyUploadImpl.setTimestamp(null);
		}
		else {
			legacyUploadImpl.setTimestamp(new Date(timestamp));
		}

		legacyUploadImpl.setStatus(status);
		legacyUploadImpl.setVideoId(videoId);

		legacyUploadImpl.resetOriginalValues();

		return legacyUploadImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		userId = objectInput.readLong();
		contentLength = objectInput.readLong();
		timestamp = objectInput.readLong();
		status = objectInput.readInt();
		videoId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(contentLength);
		objectOutput.writeLong(timestamp);
		objectOutput.writeInt(status);
		objectOutput.writeLong(videoId);
	}

	public long id;
	public long userId;
	public long contentLength;
	public long timestamp;
	public int status;
	public long videoId;
}