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

import de.uhh.l2g.plugins.migration.model.LegacyVideo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegacyVideo in entity cache.
 *
 * @author unihh
 * @see LegacyVideo
 * @generated
 */
public class LegacyVideoCacheModel implements CacheModel<LegacyVideo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{id=");
		sb.append(id);
		sb.append(", title=");
		sb.append(title);
		sb.append(", tags=");
		sb.append(tags);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append(", ownerId=");
		sb.append(ownerId);
		sb.append(", producerId=");
		sb.append(producerId);
		sb.append(", containerFormat=");
		sb.append(containerFormat);
		sb.append(", filename=");
		sb.append(filename);
		sb.append(", resolution=");
		sb.append(resolution);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", hostId=");
		sb.append(hostId);
		sb.append(", textId=");
		sb.append(textId);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append(", generationDate=");
		sb.append(generationDate);
		sb.append(", openAccess=");
		sb.append(openAccess);
		sb.append(", downloadLink=");
		sb.append(downloadLink);
		sb.append(", metadataId=");
		sb.append(metadataId);
		sb.append(", surl=");
		sb.append(surl);
		sb.append(", hits=");
		sb.append(hits);
		sb.append(", uploadDate=");
		sb.append(uploadDate);
		sb.append(", permittedToSegment=");
		sb.append(permittedToSegment);
		sb.append(", facilityId=");
		sb.append(facilityId);
		sb.append(", citation2go=");
		sb.append(citation2go);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyVideo toEntityModel() {
		LegacyVideoImpl legacyVideoImpl = new LegacyVideoImpl();

		legacyVideoImpl.setId(id);

		if (title == null) {
			legacyVideoImpl.setTitle(StringPool.BLANK);
		}
		else {
			legacyVideoImpl.setTitle(title);
		}

		if (tags == null) {
			legacyVideoImpl.setTags(StringPool.BLANK);
		}
		else {
			legacyVideoImpl.setTags(tags);
		}

		legacyVideoImpl.setLectureseriesId(lectureseriesId);
		legacyVideoImpl.setOwnerId(ownerId);
		legacyVideoImpl.setProducerId(producerId);

		if (containerFormat == null) {
			legacyVideoImpl.setContainerFormat(StringPool.BLANK);
		}
		else {
			legacyVideoImpl.setContainerFormat(containerFormat);
		}

		if (filename == null) {
			legacyVideoImpl.setFilename(StringPool.BLANK);
		}
		else {
			legacyVideoImpl.setFilename(filename);
		}

		if (resolution == null) {
			legacyVideoImpl.setResolution(StringPool.BLANK);
		}
		else {
			legacyVideoImpl.setResolution(resolution);
		}

		if (duration == null) {
			legacyVideoImpl.setDuration(StringPool.BLANK);
		}
		else {
			legacyVideoImpl.setDuration(duration);
		}

		legacyVideoImpl.setHostId(hostId);
		legacyVideoImpl.setTextId(textId);

		if (fileSize == null) {
			legacyVideoImpl.setFileSize(StringPool.BLANK);
		}
		else {
			legacyVideoImpl.setFileSize(fileSize);
		}

		if (generationDate == null) {
			legacyVideoImpl.setGenerationDate(StringPool.BLANK);
		}
		else {
			legacyVideoImpl.setGenerationDate(generationDate);
		}

		legacyVideoImpl.setOpenAccess(openAccess);
		legacyVideoImpl.setDownloadLink(downloadLink);
		legacyVideoImpl.setMetadataId(metadataId);

		if (surl == null) {
			legacyVideoImpl.setSurl(StringPool.BLANK);
		}
		else {
			legacyVideoImpl.setSurl(surl);
		}

		legacyVideoImpl.setHits(hits);

		if (uploadDate == Long.MIN_VALUE) {
			legacyVideoImpl.setUploadDate(null);
		}
		else {
			legacyVideoImpl.setUploadDate(new Date(uploadDate));
		}

		legacyVideoImpl.setPermittedToSegment(permittedToSegment);
		legacyVideoImpl.setFacilityId(facilityId);
		legacyVideoImpl.setCitation2go(citation2go);

		legacyVideoImpl.resetOriginalValues();

		return legacyVideoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		title = objectInput.readUTF();
		tags = objectInput.readUTF();
		lectureseriesId = objectInput.readLong();
		ownerId = objectInput.readLong();
		producerId = objectInput.readLong();
		containerFormat = objectInput.readUTF();
		filename = objectInput.readUTF();
		resolution = objectInput.readUTF();
		duration = objectInput.readUTF();
		hostId = objectInput.readLong();
		textId = objectInput.readLong();
		fileSize = objectInput.readUTF();
		generationDate = objectInput.readUTF();
		openAccess = objectInput.readInt();
		downloadLink = objectInput.readInt();
		metadataId = objectInput.readLong();
		surl = objectInput.readUTF();
		hits = objectInput.readLong();
		uploadDate = objectInput.readLong();
		permittedToSegment = objectInput.readInt();
		facilityId = objectInput.readLong();
		citation2go = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (tags == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tags);
		}

		objectOutput.writeLong(lectureseriesId);
		objectOutput.writeLong(ownerId);
		objectOutput.writeLong(producerId);

		if (containerFormat == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(containerFormat);
		}

		if (filename == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filename);
		}

		if (resolution == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(resolution);
		}

		if (duration == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(duration);
		}

		objectOutput.writeLong(hostId);
		objectOutput.writeLong(textId);

		if (fileSize == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileSize);
		}

		if (generationDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(generationDate);
		}

		objectOutput.writeInt(openAccess);
		objectOutput.writeInt(downloadLink);
		objectOutput.writeLong(metadataId);

		if (surl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(surl);
		}

		objectOutput.writeLong(hits);
		objectOutput.writeLong(uploadDate);
		objectOutput.writeInt(permittedToSegment);
		objectOutput.writeLong(facilityId);
		objectOutput.writeInt(citation2go);
	}

	public long id;
	public String title;
	public String tags;
	public long lectureseriesId;
	public long ownerId;
	public long producerId;
	public String containerFormat;
	public String filename;
	public String resolution;
	public String duration;
	public long hostId;
	public long textId;
	public String fileSize;
	public String generationDate;
	public int openAccess;
	public int downloadLink;
	public long metadataId;
	public String surl;
	public long hits;
	public long uploadDate;
	public int permittedToSegment;
	public long facilityId;
	public int citation2go;
}