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
public class SysSoap implements Serializable {
	public static SysSoap toSoapModel(Sys model) {
		SysSoap soapModel = new SysSoap();

		soapModel.setSysId(model.getSysId());
		soapModel.setVersion(model.getVersion());
		soapModel.setSetupWizard(model.getSetupWizard());

		return soapModel;
	}

	public static SysSoap[] toSoapModels(Sys[] models) {
		SysSoap[] soapModels = new SysSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SysSoap[][] toSoapModels(Sys[][] models) {
		SysSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SysSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SysSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SysSoap[] toSoapModels(List<Sys> models) {
		List<SysSoap> soapModels = new ArrayList<SysSoap>(models.size());

		for (Sys model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SysSoap[soapModels.size()]);
	}

	public SysSoap() {
	}

	public int getPrimaryKey() {
		return _sysId;
	}

	public void setPrimaryKey(int pk) {
		setSysId(pk);
	}

	public int getSysId() {
		return _sysId;
	}

	public void setSysId(int sysId) {
		_sysId = sysId;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public int getSetupWizard() {
		return _setupWizard;
	}

	public void setSetupWizard(int setupWizard) {
		_setupWizard = setupWizard;
	}

	private int _sysId;
	private String _version;
	private int _setupWizard;
}