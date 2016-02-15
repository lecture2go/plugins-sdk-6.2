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
public class LegacyHostSoap implements Serializable {
	public static LegacyHostSoap toSoapModel(LegacyHost model) {
		LegacyHostSoap soapModel = new LegacyHostSoap();

		soapModel.setId(model.getId());
		soapModel.setProtokoll(model.getProtokoll());
		soapModel.setStreamer(model.getStreamer());
		soapModel.setPort(model.getPort());
		soapModel.setServerRoot(model.getServerRoot());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static LegacyHostSoap[] toSoapModels(LegacyHost[] models) {
		LegacyHostSoap[] soapModels = new LegacyHostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyHostSoap[][] toSoapModels(LegacyHost[][] models) {
		LegacyHostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyHostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyHostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyHostSoap[] toSoapModels(List<LegacyHost> models) {
		List<LegacyHostSoap> soapModels = new ArrayList<LegacyHostSoap>(models.size());

		for (LegacyHost model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyHostSoap[soapModels.size()]);
	}

	public LegacyHostSoap() {
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

	public String getProtokoll() {
		return _protokoll;
	}

	public void setProtokoll(String protokoll) {
		_protokoll = protokoll;
	}

	public String getStreamer() {
		return _streamer;
	}

	public void setStreamer(String streamer) {
		_streamer = streamer;
	}

	public int getPort() {
		return _port;
	}

	public void setPort(int port) {
		_port = port;
	}

	public String getServerRoot() {
		return _serverRoot;
	}

	public void setServerRoot(String serverRoot) {
		_serverRoot = serverRoot;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _id;
	private String _protokoll;
	private String _streamer;
	private int _port;
	private String _serverRoot;
	private String _name;
}