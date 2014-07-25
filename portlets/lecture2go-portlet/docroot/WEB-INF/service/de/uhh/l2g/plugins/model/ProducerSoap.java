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
public class ProducerSoap implements Serializable {
	public static ProducerSoap toSoapModel(Producer model) {
		ProducerSoap soapModel = new ProducerSoap();

		soapModel.setProducerId(model.getProducerId());
		soapModel.setIdNum(model.getIdNum());
		soapModel.setHomeDir(model.getHomeDir());
		soapModel.setHostId(model.getHostId());
		soapModel.setFacilityId(model.getFacilityId());
		soapModel.setNumberOfProductions(model.getNumberOfProductions());
		soapModel.setApproved(model.getApproved());

		return soapModel;
	}

	public static ProducerSoap[] toSoapModels(Producer[] models) {
		ProducerSoap[] soapModels = new ProducerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProducerSoap[][] toSoapModels(Producer[][] models) {
		ProducerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProducerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProducerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProducerSoap[] toSoapModels(List<Producer> models) {
		List<ProducerSoap> soapModels = new ArrayList<ProducerSoap>(models.size());

		for (Producer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProducerSoap[soapModels.size()]);
	}

	public ProducerSoap() {
	}

	public long getPrimaryKey() {
		return _producerId;
	}

	public void setPrimaryKey(long pk) {
		setProducerId(pk);
	}

	public long getProducerId() {
		return _producerId;
	}

	public void setProducerId(long producerId) {
		_producerId = producerId;
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

	private long _producerId;
	private String _idNum;
	private String _homeDir;
	private long _hostId;
	private long _facilityId;
	private long _numberOfProductions;
	private int _approved;
}