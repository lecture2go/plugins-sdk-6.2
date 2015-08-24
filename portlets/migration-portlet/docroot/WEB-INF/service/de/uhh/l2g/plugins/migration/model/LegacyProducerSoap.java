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
public class LegacyProducerSoap implements Serializable {
	public static LegacyProducerSoap toSoapModel(LegacyProducer model) {
		LegacyProducerSoap soapModel = new LegacyProducerSoap();

		soapModel.setId(model.getId());
		soapModel.setIdNum(model.getIdNum());
		soapModel.setHomeDir(model.getHomeDir());
		soapModel.setUserId(model.getUserId());
		soapModel.setHostId(model.getHostId());
		soapModel.setFacilityId(model.getFacilityId());
		soapModel.setNumberOfProductions(model.getNumberOfProductions());
		soapModel.setApproved(model.getApproved());

		return soapModel;
	}

	public static LegacyProducerSoap[] toSoapModels(LegacyProducer[] models) {
		LegacyProducerSoap[] soapModels = new LegacyProducerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyProducerSoap[][] toSoapModels(LegacyProducer[][] models) {
		LegacyProducerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyProducerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyProducerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyProducerSoap[] toSoapModels(List<LegacyProducer> models) {
		List<LegacyProducerSoap> soapModels = new ArrayList<LegacyProducerSoap>(models.size());

		for (LegacyProducer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyProducerSoap[soapModels.size()]);
	}

	public LegacyProducerSoap() {
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

	public String getIdNum() {
		return _idNum;
	}

	public void setIdNum(String idNum) {
		_idNum = idNum;
	}

	public String getHomeDir() {
		return _homeDir;
	}

	public void setHomeDir(String homeDir) {
		_homeDir = homeDir;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getHostId() {
		return _hostId;
	}

	public void setHostId(long hostId) {
		_hostId = hostId;
	}

	public long getFacilityId() {
		return _facilityId;
	}

	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;
	}

	public long getNumberOfProductions() {
		return _numberOfProductions;
	}

	public void setNumberOfProductions(long numberOfProductions) {
		_numberOfProductions = numberOfProductions;
	}

	public int getApproved() {
		return _approved;
	}

	public void setApproved(int approved) {
		_approved = approved;
	}

	private long _id;
	private String _idNum;
	private String _homeDir;
	private long _userId;
	private long _hostId;
	private long _facilityId;
	private long _numberOfProductions;
	private int _approved;
}