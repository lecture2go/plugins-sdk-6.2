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
public class OaiSetSoap implements Serializable {
	public static OaiSetSoap toSoapModel(OaiSet model) {
		OaiSetSoap soapModel = new OaiSetSoap();

		soapModel.setOaiSetId(model.getOaiSetId());
		soapModel.setSetSpec(model.getSetSpec());
		soapModel.setSetName(model.getSetName());
		soapModel.setSetDescription(model.getSetDescription());

		return soapModel;
	}

	public static OaiSetSoap[] toSoapModels(OaiSet[] models) {
		OaiSetSoap[] soapModels = new OaiSetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OaiSetSoap[][] toSoapModels(OaiSet[][] models) {
		OaiSetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OaiSetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OaiSetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OaiSetSoap[] toSoapModels(List<OaiSet> models) {
		List<OaiSetSoap> soapModels = new ArrayList<OaiSetSoap>(models.size());

		for (OaiSet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OaiSetSoap[soapModels.size()]);
	}

	public OaiSetSoap() {
	}

	public long getPrimaryKey() {
		return _oaiSetId;
	}

	public void setPrimaryKey(long pk) {
		setOaiSetId(pk);
	}

	public long getOaiSetId() {
		return _oaiSetId;
	}

	public void setOaiSetId(long oaiSetId) {
		_oaiSetId = oaiSetId;
	}

	public String getSetSpec() {
		return _setSpec;
	}

	public void setSetSpec(String setSpec) {
		_setSpec = setSpec;
	}

	public String getSetName() {
		return _setName;
	}

	public void setSetName(String setName) {
		_setName = setName;
	}

	public String getSetDescription() {
		return _setDescription;
	}

	public void setSetDescription(String setDescription) {
		_setDescription = setDescription;
	}

	private long _oaiSetId;
	private String _setSpec;
	private String _setName;
	private String _setDescription;
}