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
public class LegacyFacilityHostSoap implements Serializable {
	public static LegacyFacilityHostSoap toSoapModel(LegacyFacilityHost model) {
		LegacyFacilityHostSoap soapModel = new LegacyFacilityHostSoap();

		soapModel.setFacilityHostId(model.getFacilityHostId());
		soapModel.setFacilityId(model.getFacilityId());
		soapModel.setHostId(model.getHostId());

		return soapModel;
	}

	public static LegacyFacilityHostSoap[] toSoapModels(
		LegacyFacilityHost[] models) {
		LegacyFacilityHostSoap[] soapModels = new LegacyFacilityHostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyFacilityHostSoap[][] toSoapModels(
		LegacyFacilityHost[][] models) {
		LegacyFacilityHostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyFacilityHostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyFacilityHostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyFacilityHostSoap[] toSoapModels(
		List<LegacyFacilityHost> models) {
		List<LegacyFacilityHostSoap> soapModels = new ArrayList<LegacyFacilityHostSoap>(models.size());

		for (LegacyFacilityHost model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyFacilityHostSoap[soapModels.size()]);
	}

	public LegacyFacilityHostSoap() {
	}

	public long getPrimaryKey() {
		return _facilityHostId;
	}

	public void setPrimaryKey(long pk) {
		setFacilityHostId(pk);
	}

	public long getFacilityHostId() {
		return _facilityHostId;
	}

	public void setFacilityHostId(long facilityHostId) {
		_facilityHostId = facilityHostId;
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

	private long _facilityHostId;
	private long _facilityId;
	private long _hostId;
}