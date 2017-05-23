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
public class LegacyL2gSysSoap implements Serializable {
	public static LegacyL2gSysSoap toSoapModel(LegacyL2gSys model) {
		LegacyL2gSysSoap soapModel = new LegacyL2gSysSoap();

		soapModel.setId(model.getId());
		soapModel.setVersion(model.getVersion());
		soapModel.setSetupwizard(model.getSetupwizard());

		return soapModel;
	}

	public static LegacyL2gSysSoap[] toSoapModels(LegacyL2gSys[] models) {
		LegacyL2gSysSoap[] soapModels = new LegacyL2gSysSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyL2gSysSoap[][] toSoapModels(LegacyL2gSys[][] models) {
		LegacyL2gSysSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyL2gSysSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyL2gSysSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyL2gSysSoap[] toSoapModels(List<LegacyL2gSys> models) {
		List<LegacyL2gSysSoap> soapModels = new ArrayList<LegacyL2gSysSoap>(models.size());

		for (LegacyL2gSys model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyL2gSysSoap[soapModels.size()]);
	}

	public LegacyL2gSysSoap() {
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int pk) {
		setId(pk);
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public int getSetupwizard() {
		return _setupwizard;
	}

	public void setSetupwizard(int setupwizard) {
		_setupwizard = setupwizard;
	}

	private int _id;
	private String _version;
	private int _setupwizard;
}