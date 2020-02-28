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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Iavor Sturm
 * @generated
 */
public class OaiRecord_OaiSetSoap implements Serializable {
	public static OaiRecord_OaiSetSoap toSoapModel(OaiRecord_OaiSet model) {
		OaiRecord_OaiSetSoap soapModel = new OaiRecord_OaiSetSoap();

		soapModel.setOaiRecordOaiSetId(model.getOaiRecordOaiSetId());
		soapModel.setOaiRecordId(model.getOaiRecordId());
		soapModel.setOaiSetId(model.getOaiSetId());

		return soapModel;
	}

	public static OaiRecord_OaiSetSoap[] toSoapModels(OaiRecord_OaiSet[] models) {
		OaiRecord_OaiSetSoap[] soapModels = new OaiRecord_OaiSetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OaiRecord_OaiSetSoap[][] toSoapModels(
		OaiRecord_OaiSet[][] models) {
		OaiRecord_OaiSetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OaiRecord_OaiSetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OaiRecord_OaiSetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OaiRecord_OaiSetSoap[] toSoapModels(
		List<OaiRecord_OaiSet> models) {
		List<OaiRecord_OaiSetSoap> soapModels = new ArrayList<OaiRecord_OaiSetSoap>(models.size());

		for (OaiRecord_OaiSet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OaiRecord_OaiSetSoap[soapModels.size()]);
	}

	public OaiRecord_OaiSetSoap() {
	}

	public long getPrimaryKey() {
		return _oaiRecordOaiSetId;
	}

	public void setPrimaryKey(long pk) {
		setOaiRecordOaiSetId(pk);
	}

	public long getOaiRecordOaiSetId() {
		return _oaiRecordOaiSetId;
	}

	public void setOaiRecordOaiSetId(long oaiRecordOaiSetId) {
		_oaiRecordOaiSetId = oaiRecordOaiSetId;
	}

	public long getOaiRecordId() {
		return _oaiRecordId;
	}

	public void setOaiRecordId(long oaiRecordId) {
		_oaiRecordId = oaiRecordId;
	}

	public long getOaiSetId() {
		return _oaiSetId;
	}

	public void setOaiSetId(long oaiSetId) {
		_oaiSetId = oaiSetId;
	}

	private long _oaiRecordOaiSetId;
	private long _oaiRecordId;
	private long _oaiSetId;
}