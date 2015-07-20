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
public class LegacyOfficeSoap implements Serializable {
	public static LegacyOfficeSoap toSoapModel(LegacyOffice model) {
		LegacyOfficeSoap soapModel = new LegacyOfficeSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setWww(model.getWww());
		soapModel.setEmail(model.getEmail());
		soapModel.setFacilityId(model.getFacilityId());

		return soapModel;
	}

	public static LegacyOfficeSoap[] toSoapModels(LegacyOffice[] models) {
		LegacyOfficeSoap[] soapModels = new LegacyOfficeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyOfficeSoap[][] toSoapModels(LegacyOffice[][] models) {
		LegacyOfficeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyOfficeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyOfficeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyOfficeSoap[] toSoapModels(List<LegacyOffice> models) {
		List<LegacyOfficeSoap> soapModels = new ArrayList<LegacyOfficeSoap>(models.size());

		for (LegacyOffice model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyOfficeSoap[soapModels.size()]);
	}

	public LegacyOfficeSoap() {
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

	public long getFacilityId() {
		return _facilityId;
	}

	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;
	}

	private long _id;
	private String _name;
	private String _www;
	private String _email;
	private long _facilityId;
}