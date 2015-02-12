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

package de.uhh.l2g.plugins.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Iavor Sturm
 * @generated
 */
public class MetadataSoap implements Serializable {
	public static MetadataSoap toSoapModel(Metadata model) {
		MetadataSoap soapModel = new MetadataSoap();

		soapModel.setMetadataId(model.getMetadataId());
		soapModel.setURLID(model.getURLID());
		soapModel.setFormat(model.getFormat());
		soapModel.setType(model.getType());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setTitle(model.getTitle());
		soapModel.setSubject(model.getSubject());
		soapModel.setCoverage(model.getCoverage());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreator(model.getCreator());
		soapModel.setPublisher(model.getPublisher());
		soapModel.setContributor(model.getContributor());
		soapModel.setRightsHolder(model.getRightsHolder());
		soapModel.setRights(model.getRights());
		soapModel.setProvenance(model.getProvenance());
		soapModel.setSource(model.getSource());
		soapModel.setRelation(model.getRelation());
		soapModel.setAudience(model.getAudience());
		soapModel.setInstructionalMethods(model.getInstructionalMethods());
		soapModel.setDate(model.getDate());

		return soapModel;
	}

	public static MetadataSoap[] toSoapModels(Metadata[] models) {
		MetadataSoap[] soapModels = new MetadataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MetadataSoap[][] toSoapModels(Metadata[][] models) {
		MetadataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MetadataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MetadataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MetadataSoap[] toSoapModels(List<Metadata> models) {
		List<MetadataSoap> soapModels = new ArrayList<MetadataSoap>(models.size());

		for (Metadata model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MetadataSoap[soapModels.size()]);
	}

	public MetadataSoap() {
	}

	public long getPrimaryKey() {
		return _metadataId;
	}

	public void setPrimaryKey(long pk) {
		setMetadataId(pk);
	}

	public long getMetadataId() {
		return _metadataId;
	}

	public void setMetadataId(long metadataId) {
		_metadataId = metadataId;
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

	public String getCoverage() {
		return _coverage;
	}

	public void setCoverage(String coverage) {
		_coverage = coverage;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getCreator() {
		return _creator;
	}

	public void setCreator(String creator) {
		_creator = creator;
	}

	public String getPublisher() {
		return _publisher;
	}

	public void setPublisher(String publisher) {
		_publisher = publisher;
	}

	public String getContributor() {
		return _contributor;
	}

	public void setContributor(String contributor) {
		_contributor = contributor;
	}

	public String getRightsHolder() {
		return _rightsHolder;
	}

	public void setRightsHolder(String rightsHolder) {
		_rightsHolder = rightsHolder;
	}

	public String getRights() {
		return _rights;
	}

	public void setRights(String rights) {
		_rights = rights;
	}

	public String getProvenance() {
		return _provenance;
	}

	public void setProvenance(String provenance) {
		_provenance = provenance;
	}

	public String getSource() {
		return _source;
	}

	public void setSource(String source) {
		_source = source;
	}

	public String getRelation() {
		return _relation;
	}

	public void setRelation(String relation) {
		_relation = relation;
	}

	public String getAudience() {
		return _audience;
	}

	public void setAudience(String audience) {
		_audience = audience;
	}

	public String getInstructionalMethods() {
		return _instructionalMethods;
	}

	public void setInstructionalMethods(String instructionalMethods) {
		_instructionalMethods = instructionalMethods;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	private long _metadataId;
	private String _URLID;
	private String _format;
	private String _type;
	private String _language;
	private String _title;
	private String _subject;
	private String _coverage;
	private String _description;
	private String _creator;
	private String _publisher;
	private String _contributor;
	private String _rightsHolder;
	private String _rights;
	private String _provenance;
	private String _source;
	private String _relation;
	private String _audience;
	private String _instructionalMethods;
	private Date _date;
}