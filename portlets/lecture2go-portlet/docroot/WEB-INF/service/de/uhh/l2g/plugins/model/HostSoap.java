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
public class HostSoap implements Serializable {
	public static HostSoap toSoapModel(Host model) {
		HostSoap soapModel = new HostSoap();

		soapModel.setHostId(model.getHostId());
		soapModel.setProtocol(model.getProtocol());
		soapModel.setStreamer(model.getStreamer());
		soapModel.setPort(model.getPort());
		soapModel.setServerRoot(model.getServerRoot());
		soapModel.setServerTemplate(model.getServerTemplate());
		soapModel.setName(model.getName());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static HostSoap[] toSoapModels(Host[] models) {
		HostSoap[] soapModels = new HostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HostSoap[][] toSoapModels(Host[][] models) {
		HostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HostSoap[] toSoapModels(List<Host> models) {
		List<HostSoap> soapModels = new ArrayList<HostSoap>(models.size());

		for (Host model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HostSoap[soapModels.size()]);
	}

	public HostSoap() {
	}

	public long getPrimaryKey() {
		return _hostId;
	}

	public void setPrimaryKey(long pk) {
		setHostId(pk);
	}

	public long getHostId() {
		return _hostId;
	}

	public void setHostId(long hostId) {
		_hostId = hostId;
	}

	public String getProtocol() {
		return _protocol;
	}

	public void setProtocol(String protocol) {
		_protocol = protocol;
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

	public String getServerTemplate() {
		return _serverTemplate;
	}

	public void setServerTemplate(String serverTemplate) {
		_serverTemplate = serverTemplate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _hostId;
	private String _protocol;
	private String _streamer;
	private int _port;
	private String _serverRoot;
	private String _serverTemplate;
	private String _name;
	private long _groupId;
}