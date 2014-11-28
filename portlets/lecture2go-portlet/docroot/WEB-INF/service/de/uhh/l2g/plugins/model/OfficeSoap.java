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
public class OfficeSoap implements Serializable {
	public static OfficeSoap toSoapModel(Office model) {
		OfficeSoap soapModel = new OfficeSoap();

		soapModel.setOfficeId(model.getOfficeId());
		soapModel.setName(model.getName());
		soapModel.setWww(model.getWww());
		soapModel.setEmail(model.getEmail());
		soapModel.setInstitutionId(model.getInstitutionId());

		return soapModel;
	}

	public static OfficeSoap[] toSoapModels(Office[] models) {
		OfficeSoap[] soapModels = new OfficeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OfficeSoap[][] toSoapModels(Office[][] models) {
		OfficeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OfficeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OfficeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OfficeSoap[] toSoapModels(List<Office> models) {
		List<OfficeSoap> soapModels = new ArrayList<OfficeSoap>(models.size());

		for (Office model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OfficeSoap[soapModels.size()]);
	}

	public OfficeSoap() {
	}

	public long getPrimaryKey() {
		return _officeId;
	}

	public void setPrimaryKey(long pk) {
		setOfficeId(pk);
	}

	public long getOfficeId() {
		return _officeId;
	}

	public void setOfficeId(long officeId) {
		_officeId = officeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getWww() {
		return _www;
	}

	public void setWww(String www) {
		_www = www;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public long getInstitutionId() {
		return _institutionId;
	}

	public void setInstitutionId(long institutionId) {
		_institutionId = institutionId;
	}

	private long _officeId;
	private String _name;
	private String _www;
	private String _email;
	private long _institutionId;
}