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
public class CoordinatorSoap implements Serializable {
	public static CoordinatorSoap toSoapModel(Coordinator model) {
		CoordinatorSoap soapModel = new CoordinatorSoap();

		soapModel.setCoordinatorId(model.getCoordinatorId());
		soapModel.setInstitutionId(model.getInstitutionId());
		soapModel.setOfficeId(model.getOfficeId());

		return soapModel;
	}

	public static CoordinatorSoap[] toSoapModels(Coordinator[] models) {
		CoordinatorSoap[] soapModels = new CoordinatorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CoordinatorSoap[][] toSoapModels(Coordinator[][] models) {
		CoordinatorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CoordinatorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CoordinatorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CoordinatorSoap[] toSoapModels(List<Coordinator> models) {
		List<CoordinatorSoap> soapModels = new ArrayList<CoordinatorSoap>(models.size());

		for (Coordinator model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CoordinatorSoap[soapModels.size()]);
	}

	public CoordinatorSoap() {
	}

	public long getPrimaryKey() {
		return _coordinatorId;
	}

	public void setPrimaryKey(long pk) {
		setCoordinatorId(pk);
	}

	public long getCoordinatorId() {
		return _coordinatorId;
	}

	public void setCoordinatorId(long coordinatorId) {
		_coordinatorId = coordinatorId;
	}

	public long getInstitutionId() {
		return _institutionId;
	}

	public void setInstitutionId(long institutionId) {
		_institutionId = institutionId;
	}

	public long getOfficeId() {
		return _officeId;
	}

	public void setOfficeId(long officeId) {
		_officeId = officeId;
	}

	private long _coordinatorId;
	private long _institutionId;
	private long _officeId;
}