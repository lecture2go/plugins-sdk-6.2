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

import de.uhh.l2g.plugins.model.OaiRecord;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OaiRecord in entity cache.
 *
 * @author Iavor Sturm
 * @see OaiRecord
 * @generated
 */
public class OaiRecordCacheModel implements CacheModel<OaiRecord>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{oaiRecordId=");
		sb.append(oaiRecordId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", identifier=");
		sb.append(identifier);
		sb.append(", datestamp=");
		sb.append(datestamp);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OaiRecord toEntityModel() {
		OaiRecordImpl oaiRecordImpl = new OaiRecordImpl();

		oaiRecordImpl.setOaiRecordId(oaiRecordId);
		oaiRecordImpl.setVideoId(videoId);

		if (identifier == null) {
			oaiRecordImpl.setIdentifier(StringPool.BLANK);
		}
		else {
			oaiRecordImpl.setIdentifier(identifier);
		}

		if (datestamp == Long.MIN_VALUE) {
			oaiRecordImpl.setDatestamp(null);
		}
		else {
			oaiRecordImpl.setDatestamp(new Date(datestamp));
		}

		oaiRecordImpl.setDeleted(deleted);

		oaiRecordImpl.resetOriginalValues();

		return oaiRecordImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		oaiRecordId = objectInput.readLong();
		videoId = objectInput.readLong();
		identifier = objectInput.readUTF();
		datestamp = objectInput.readLong();
		deleted = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(oaiRecordId);
		objectOutput.writeLong(videoId);

		if (identifier == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(identifier);
		}

		objectOutput.writeLong(datestamp);
		objectOutput.writeBoolean(deleted);
	}

	public long oaiRecordId;
	public long videoId;
	public String identifier;
	public long datestamp;
	public boolean deleted;
}