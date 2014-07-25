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

import java.util.Date;

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
		StringBundler sb = new StringBundler(41);

		sb.append("{metadataId=");
		sb.append(metadataId);
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
		sb.append(", coverage=");
		sb.append(coverage);
		sb.append(", description=");
		sb.append(description);
		sb.append(", creator=");
		sb.append(creator);
		sb.append(", publisher=");
		sb.append(publisher);
		sb.append(", contributor=");
		sb.append(contributor);
		sb.append(", rightsHolder=");
		sb.append(rightsHolder);
		sb.append(", rights=");
		sb.append(rights);
		sb.append(", provenance=");
		sb.append(provenance);
		sb.append(", source=");
		sb.append(source);
		sb.append(", relation=");
		sb.append(relation);
		sb.append(", audience=");
		sb.append(audience);
		sb.append(", instructionalMethods=");
		sb.append(instructionalMethods);
		sb.append(", date=");
		sb.append(date);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Metadata toEntityModel() {
		MetadataImpl metadataImpl = new MetadataImpl();

		metadataImpl.setMetadataId(metadataId);

		if (URLID == null) {
			metadataImpl.setURLID(StringPool.BLANK);
		}
		else {
			metadataImpl.setURLID(URLID);
		}

		if (format == null) {
			metadataImpl.setFormat(StringPool.BLANK);
		}
		else {
			metadataImpl.setFormat(format);
		}

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

		if (coverage == null) {
			metadataImpl.setCoverage(StringPool.BLANK);
		}
		else {
			metadataImpl.setCoverage(coverage);
		}

		if (description == null) {
			metadataImpl.setDescription(StringPool.BLANK);
		}
		else {
			metadataImpl.setDescription(description);
		}

		if (creator == null) {
			metadataImpl.setCreator(StringPool.BLANK);
		}
		else {
			metadataImpl.setCreator(creator);
		}

		if (publisher == null) {
			metadataImpl.setPublisher(StringPool.BLANK);
		}
		else {
			metadataImpl.setPublisher(publisher);
		}

		if (contributor == null) {
			metadataImpl.setContributor(StringPool.BLANK);
		}
		else {
			metadataImpl.setContributor(contributor);
		}

		if (rightsHolder == null) {
			metadataImpl.setRightsHolder(StringPool.BLANK);
		}
		else {
			metadataImpl.setRightsHolder(rightsHolder);
		}

		if (rights == null) {
			metadataImpl.setRights(StringPool.BLANK);
		}
		else {
			metadataImpl.setRights(rights);
		}

		if (provenance == null) {
			metadataImpl.setProvenance(StringPool.BLANK);
		}
		else {
			metadataImpl.setProvenance(provenance);
		}

		if (source == null) {
			metadataImpl.setSource(StringPool.BLANK);
		}
		else {
			metadataImpl.setSource(source);
		}

		if (relation == null) {
			metadataImpl.setRelation(StringPool.BLANK);
		}
		else {
			metadataImpl.setRelation(relation);
		}

		if (audience == null) {
			metadataImpl.setAudience(StringPool.BLANK);
		}
		else {
			metadataImpl.setAudience(audience);
		}

		if (instructionalMethods == null) {
			metadataImpl.setInstructionalMethods(StringPool.BLANK);
		}
		else {
			metadataImpl.setInstructionalMethods(instructionalMethods);
		}

		if (date == Long.MIN_VALUE) {
			metadataImpl.setDate(null);
		}
		else {
			metadataImpl.setDate(new Date(date));
		}

		metadataImpl.resetOriginalValues();

		return metadataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		metadataId = objectInput.readLong();
		URLID = objectInput.readUTF();
		format = objectInput.readUTF();
		type = objectInput.readUTF();
		language = objectInput.readUTF();
		title = objectInput.readUTF();
		subject = objectInput.readUTF();
		coverage = objectInput.readUTF();
		description = objectInput.readUTF();
		creator = objectInput.readUTF();
		publisher = objectInput.readUTF();
		contributor = objectInput.readUTF();
		rightsHolder = objectInput.readUTF();
		rights = objectInput.readUTF();
		provenance = objectInput.readUTF();
		source = objectInput.readUTF();
		relation = objectInput.readUTF();
		audience = objectInput.readUTF();
		instructionalMethods = objectInput.readUTF();
		date = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(metadataId);

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

		if (coverage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(coverage);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (creator == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(creator);
		}

		if (publisher == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publisher);
		}

		if (contributor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contributor);
		}

		if (rightsHolder == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rightsHolder);
		}

		if (rights == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rights);
		}

		if (provenance == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(provenance);
		}

		if (source == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(source);
		}

		if (relation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(relation);
		}

		if (audience == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(audience);
		}

		if (instructionalMethods == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(instructionalMethods);
		}

		objectOutput.writeLong(date);
	}

	public long metadataId;
	public String URLID;
	public String format;
	public String type;
	public String language;
	public String title;
	public String subject;
	public String coverage;
	public String description;
	public String creator;
	public String publisher;
	public String contributor;
	public String rightsHolder;
	public String rights;
	public String provenance;
	public String source;
	public String relation;
	public String audience;
	public String instructionalMethods;
	public long date;
}