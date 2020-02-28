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
public class OaiRecordSoap implements Serializable {
	public static OaiRecordSoap toSoapModel(OaiRecord model) {
		OaiRecordSoap soapModel = new OaiRecordSoap();

		soapModel.setOaiRecordId(model.getOaiRecordId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setIdentifier(model.getIdentifier());
		soapModel.setDatestamp(model.getDatestamp());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static OaiRecordSoap[] toSoapModels(OaiRecord[] models) {
		OaiRecordSoap[] soapModels = new OaiRecordSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OaiRecordSoap[][] toSoapModels(OaiRecord[][] models) {
		OaiRecordSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OaiRecordSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OaiRecordSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OaiRecordSoap[] toSoapModels(List<OaiRecord> models) {
		List<OaiRecordSoap> soapModels = new ArrayList<OaiRecordSoap>(models.size());

		for (OaiRecord model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OaiRecordSoap[soapModels.size()]);
	}

	public OaiRecordSoap() {
	}

	public long getPrimaryKey() {
		return _oaiRecordId;
	}

	public void setPrimaryKey(long pk) {
		setOaiRecordId(pk);
	}

	public long getOaiRecordId() {
		return _oaiRecordId;
	}

	public void setOaiRecordId(long oaiRecordId) {
		_oaiRecordId = oaiRecordId;
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public String getIdentifier() {
		return _identifier;
	}

	public void setIdentifier(String identifier) {
		_identifier = identifier;
	}

	public Date getDatestamp() {
		return _datestamp;
	}

	public void setDatestamp(Date datestamp) {
		_datestamp = datestamp;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	private long _oaiRecordId;
	private long _videoId;
	private String _identifier;
	private Date _datestamp;
	private boolean _deleted;
}