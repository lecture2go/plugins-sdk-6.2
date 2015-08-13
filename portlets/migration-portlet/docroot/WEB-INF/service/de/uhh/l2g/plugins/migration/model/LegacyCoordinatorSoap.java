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
public class LegacyCoordinatorSoap implements Serializable {
	public static LegacyCoordinatorSoap toSoapModel(LegacyCoordinator model) {
		LegacyCoordinatorSoap soapModel = new LegacyCoordinatorSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setFacilityId(model.getFacilityId());
		soapModel.setOfficeId(model.getOfficeId());

		return soapModel;
	}

	public static LegacyCoordinatorSoap[] toSoapModels(
		LegacyCoordinator[] models) {
		LegacyCoordinatorSoap[] soapModels = new LegacyCoordinatorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyCoordinatorSoap[][] toSoapModels(
		LegacyCoordinator[][] models) {
		LegacyCoordinatorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyCoordinatorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyCoordinatorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyCoordinatorSoap[] toSoapModels(
		List<LegacyCoordinator> models) {
		List<LegacyCoordinatorSoap> soapModels = new ArrayList<LegacyCoordinatorSoap>(models.size());

		for (LegacyCoordinator model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyCoordinatorSoap[soapModels.size()]);
	}

	public LegacyCoordinatorSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getFacilityId() {
		return _facilityId;
	}

	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;
	}

	public long getOfficeId() {
		return _officeId;
	}

	public void setOfficeId(long officeId) {
		_officeId = officeId;
	}

	private long _userId;
	private long _facilityId;
	private long _officeId;
}