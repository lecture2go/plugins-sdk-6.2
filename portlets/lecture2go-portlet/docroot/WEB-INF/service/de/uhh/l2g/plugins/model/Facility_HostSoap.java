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
public class Facility_HostSoap implements Serializable {
	public static Facility_HostSoap toSoapModel(Facility_Host model) {
		Facility_HostSoap soapModel = new Facility_HostSoap();

		soapModel.setFasilityHostId(model.getFasilityHostId());
		soapModel.setFacilityId(model.getFacilityId());
		soapModel.setHostId(model.getHostId());

		return soapModel;
	}

	public static Facility_HostSoap[] toSoapModels(Facility_Host[] models) {
		Facility_HostSoap[] soapModels = new Facility_HostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Facility_HostSoap[][] toSoapModels(Facility_Host[][] models) {
		Facility_HostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Facility_HostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Facility_HostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Facility_HostSoap[] toSoapModels(List<Facility_Host> models) {
		List<Facility_HostSoap> soapModels = new ArrayList<Facility_HostSoap>(models.size());

		for (Facility_Host model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Facility_HostSoap[soapModels.size()]);
	}

	public Facility_HostSoap() {
	}

	public long getPrimaryKey() {
		return _fasilityHostId;
	}

	public void setPrimaryKey(long pk) {
		setFasilityHostId(pk);
	}

	public long getFasilityHostId() {
		return _fasilityHostId;
	}

	public void setFasilityHostId(long fasilityHostId) {
		_fasilityHostId = fasilityHostId;
	}

	public long getFacilityId() {
		return _facilityId;
	}

	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;
	}

	public long getHostId() {
		return _hostId;
	}

	public void setHostId(long hostId) {
		_hostId = hostId;
	}

	private long _fasilityHostId;
	private long _facilityId;
	private long _hostId;
}