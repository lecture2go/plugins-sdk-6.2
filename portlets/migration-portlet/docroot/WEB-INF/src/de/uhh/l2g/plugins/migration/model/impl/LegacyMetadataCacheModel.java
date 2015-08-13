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

import de.uhh.l2g.plugins.migration.model.LegacyMetadata;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyMetadata in entity cache.
 *
 * @author unihh
 * @see LegacyMetadata
 * @generated
 */
public class LegacyMetadataCacheModel implements CacheModel<LegacyMetadata>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", URLID=");
		sb.append(URLID);
		sb.append(", format=");
		sb.append(format);
		sb.append(", type=");
		sb.append(type);
		sb.append(", language=");
		sb.append(language);
		sb.append(", title=");
		sb.append(title);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", description=");
		sb.append(description);
		sb.append(", publisher=");
		sb.append(publisher);
		sb.append(", rightsHolder=");
		sb.append(rightsHolder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyMetadata toEntityModel() {
		LegacyMetadataImpl legacyMetadataImpl = new LegacyMetadataImpl();

		legacyMetadataImpl.setId(id);

		if (URLID == null) {
			legacyMetadataImpl.setURLID(StringPool.BLANK);
		}
		else {
			legacyMetadataImpl.setURLID(URLID);
		}

		if (format == null) {
			legacyMetadataImpl.setFormat(StringPool.BLANK);
		}
		else {
			legacyMetadataImpl.setFormat(format);
		}

		if (type == null) {
			legacyMetadataImpl.setType(StringPool.BLANK);
		}
		else {
			legacyMetadataImpl.setType(type);
		}

		if (language == null) {
			legacyMetadataImpl.setLanguage(StringPool.BLANK);
		}
		else {
			legacyMetadataImpl.setLanguage(language);
		}

		if (title == null) {
			legacyMetadataImpl.setTitle(StringPool.BLANK);
		}
		else {
			legacyMetadataImpl.setTitle(title);
		}

		if (subject == null) {
			legacyMetadataImpl.setSubject(StringPool.BLANK);
		}
		else {
			legacyMetadataImpl.setSubject(subject);
		}

		if (description == null) {
			legacyMetadataImpl.setDescription(StringPool.BLANK);
		}
		else {
			legacyMetadataImpl.setDescription(description);
		}

		if (publisher == null) {
			legacyMetadataImpl.setPublisher(StringPool.BLANK);
		}
		else {
			legacyMetadataImpl.setPublisher(publisher);
		}

		if (rightsHolder == null) {
			legacyMetadataImpl.setRightsHolder(StringPool.BLANK);
		}
		else {
			legacyMetadataImpl.setRightsHolder(rightsHolder);
		}

		legacyMetadataImpl.resetOriginalValues();

		return legacyMetadataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		URLID = objectInput.readUTF();
		format = objectInput.readUTF();
		type = objectInput.readUTF();
		language = objectInput.readUTF();
		title = objectInput.readUTF();
		subject = objectInput.readUTF();
		description = objectInput.readUTF();
		publisher = objectInput.readUTF();
		rightsHolder = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (URLID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(URLID);
		}

		if (format == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(format);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (language == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (subject == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (publisher == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publisher);
		}

		if (rightsHolder == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rightsHolder);
		}
	}

	public long id;
	public String URLID;
	public String format;
	public String type;
	public String language;
	public String title;
	public String subject;
	public String description;
	public String publisher;
	public String rightsHolder;
}