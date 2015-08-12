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

package de.uhh.l2g.plugins.migration.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author unihh
 * @generated
 */
public class LegacyMetadataSoap implements Serializable {
	public static LegacyMetadataSoap toSoapModel(LegacyMetadata model) {
		LegacyMetadataSoap soapModel = new LegacyMetadataSoap();

		soapModel.setId(model.getId());
		soapModel.setURLID(model.getURLID());
		soapModel.setFormat(model.getFormat());
		soapModel.setType(model.getType());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setTitle(model.getTitle());
		soapModel.setSubject(model.getSubject());
		soapModel.setDescription(model.getDescription());
		soapModel.setPublisher(model.getPublisher());
		soapModel.setRightsHolder(model.getRightsHolder());

		return soapModel;
	}

	public static LegacyMetadataSoap[] toSoapModels(LegacyMetadata[] models) {
		LegacyMetadataSoap[] soapModels = new LegacyMetadataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyMetadataSoap[][] toSoapModels(LegacyMetadata[][] models) {
		LegacyMetadataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyMetadataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyMetadataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyMetadataSoap[] toSoapModels(List<LegacyMetadata> models) {
		List<LegacyMetadataSoap> soapModels = new ArrayList<LegacyMetadataSoap>(models.size());

		for (LegacyMetadata model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyMetadataSoap[soapModels.size()]);
	}

	public LegacyMetadataSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getURLID() {
		return _URLID;
	}

	public void setURLID(String URLID) {
		_URLID = URLID;
	}

	public String getFormat() {
		return _format;
	}

	public void setFormat(String format) {
		_format = format;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getPublisher() {
		return _publisher;
	}

	public void setPublisher(String publisher) {
		_publisher = publisher;
	}

	public String getRightsHolder() {
		return _rightsHolder;
	}

	public void setRightsHolder(String rightsHolder) {
		_rightsHolder = rightsHolder;
	}

	private long _id;
	private String _URLID;
	private String _format;
	private String _type;
	private String _language;
	private String _title;
	private String _subject;
	private String _description;
	private String _publisher;
	private String _rightsHolder;
}