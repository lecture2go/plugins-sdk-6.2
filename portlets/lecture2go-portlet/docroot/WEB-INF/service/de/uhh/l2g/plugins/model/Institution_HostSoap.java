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
public class Institution_HostSoap implements Serializable {
	public static Institution_HostSoap toSoapModel(Institution_Host model) {
		Institution_HostSoap soapModel = new Institution_HostSoap();

		soapModel.setInstitutionHostId(model.getInstitutionHostId());
		soapModel.setInstitutionId(model.getInstitutionId());
		soapModel.setHostId(model.getHostId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static Institution_HostSoap[] toSoapModels(Institution_Host[] models) {
		Institution_HostSoap[] soapModels = new Institution_HostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Institution_HostSoap[][] toSoapModels(
		Institution_Host[][] models) {
		Institution_HostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Institution_HostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Institution_HostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Institution_HostSoap[] toSoapModels(
		List<Institution_Host> models) {
		List<Institution_HostSoap> soapModels = new ArrayList<Institution_HostSoap>(models.size());

		for (Institution_Host model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Institution_HostSoap[soapModels.size()]);
	}

	public Institution_HostSoap() {
	}

	public long getPrimaryKey() {
		return _institutionHostId;
	}

	public void setPrimaryKey(long pk) {
		setInstitutionHostId(pk);
	}

	public long getInstitutionHostId() {
		return _institutionHostId;
	}

	public void setInstitutionHostId(long institutionHostId) {
		_institutionHostId = institutionHostId;
	}

	public long getInstitutionId() {
		return _institutionId;
	}

	public void setInstitutionId(long institutionId) {
		_institutionId = institutionId;
	}

	public long getHostId() {
		return _hostId;
	}

	public void setHostId(long hostId) {
		_hostId = hostId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _institutionHostId;
	private long _institutionId;
	private long _hostId;
	private long _groupId;
}