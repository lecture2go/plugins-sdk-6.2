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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.model.Metadata;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Metadata in entity cache.
 *
 * @author Iavor Sturm
 * @see Metadata
 * @generated
 */
public class MetadataCacheModel implements CacheModel<Metadata>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{metadataId=");
		sb.append(metadataId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Metadata toEntityModel() {
		MetadataImpl metadataImpl = new MetadataImpl();

		metadataImpl.setMetadataId(metadataId);

		if (type == null) {
			metadataImpl.setType(StringPool.BLANK);
		}
		else {
			metadataImpl.setType(type);
		}

		if (language == null) {
			metadataImpl.setLanguage(StringPool.BLANK);
		}
		else {
			metadataImpl.setLanguage(language);
		}

		if (title == null) {
			metadataImpl.setTitle(StringPool.BLANK);
		}
		else {
			metadataImpl.setTitle(title);
		}

		if (subject == null) {
			metadataImpl.setSubject(StringPool.BLANK);
		}
		else {
			metadataImpl.setSubject(subject);
		}

		if (description == null) {
			metadataImpl.setDescription(StringPool.BLANK);
		}
		else {
			metadataImpl.setDescription(description);
		}

		if (publisher == null) {
			metadataImpl.setPublisher(StringPool.BLANK);
		}
		else {
			metadataImpl.setPublisher(publisher);
		}

		metadataImpl.resetOriginalValues();

		return metadataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		metadataId = objectInput.readLong();
		type = objectInput.readUTF();
		language = objectInput.readUTF();
		title = objectInput.readUTF();
		subject = objectInput.readUTF();
		description = objectInput.readUTF();
		publisher = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(metadataId);

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
	}

	public long metadataId;
	public String type;
	public String language;
	public String title;
	public String subject;
	public String description;
	public String publisher;
}