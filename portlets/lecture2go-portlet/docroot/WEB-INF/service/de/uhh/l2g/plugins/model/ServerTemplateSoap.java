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
public class ServerTemplateSoap implements Serializable {
	public static ServerTemplateSoap toSoapModel(ServerTemplate model) {
		ServerTemplateSoap soapModel = new ServerTemplateSoap();

		soapModel.setServerTemplateId(model.getServerTemplateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());
		soapModel.setPrefixURL(model.getPrefixURL());
		soapModel.setSuffixURL(model.getSuffixURL());
		soapModel.setSecExt(model.getSecExt());
		soapModel.setTemplateURL(model.getTemplateURL());
		soapModel.setPrefixFile(model.getPrefixFile());
		soapModel.setSuffixFile(model.getSuffixFile());
		soapModel.setTemplateFile(model.getTemplateFile());
		soapModel.setTemplateIOS(model.getTemplateIOS());
		soapModel.setTemplateAndroid(model.getTemplateAndroid());

		return soapModel;
	}

	public static ServerTemplateSoap[] toSoapModels(ServerTemplate[] models) {
		ServerTemplateSoap[] soapModels = new ServerTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServerTemplateSoap[][] toSoapModels(ServerTemplate[][] models) {
		ServerTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServerTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServerTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServerTemplateSoap[] toSoapModels(List<ServerTemplate> models) {
		List<ServerTemplateSoap> soapModels = new ArrayList<ServerTemplateSoap>(models.size());

		for (ServerTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServerTemplateSoap[soapModels.size()]);
	}

	public ServerTemplateSoap() {
	}

	public long getPrimaryKey() {
		return _serverTemplateId;
	}

	public void setPrimaryKey(long pk) {
		setServerTemplateId(pk);
	}

	public long getServerTemplateId() {
		return _serverTemplateId;
	}

	public void setServerTemplateId(long serverTemplateId) {
		_serverTemplateId = serverTemplateId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public String getPrefixURL() {
		return _prefixURL;
	}

	public void setPrefixURL(String prefixURL) {
		_prefixURL = prefixURL;
	}

	public String getSuffixURL() {
		return _suffixURL;
	}

	public void setSuffixURL(String suffixURL) {
		_suffixURL = suffixURL;
	}

	public String getSecExt() {
		return _secExt;
	}

	public void setSecExt(String secExt) {
		_secExt = secExt;
	}

	public String getTemplateURL() {
		return _templateURL;
	}

	public void setTemplateURL(String templateURL) {
		_templateURL = templateURL;
	}

	public String getPrefixFile() {
		return _prefixFile;
	}

	public void setPrefixFile(String prefixFile) {
		_prefixFile = prefixFile;
	}

	public String getSuffixFile() {
		return _suffixFile;
	}

	public void setSuffixFile(String suffixFile) {
		_suffixFile = suffixFile;
	}

	public String getTemplateFile() {
		return _templateFile;
	}

	public void setTemplateFile(String templateFile) {
		_templateFile = templateFile;
	}

	public long getTemplateIOS() {
		return _templateIOS;
	}

	public void setTemplateIOS(long templateIOS) {
		_templateIOS = templateIOS;
	}

	public long getTemplateAndroid() {
		return _templateAndroid;
	}

	public void setTemplateAndroid(long templateAndroid) {
		_templateAndroid = templateAndroid;
	}

	private long _serverTemplateId;
	private long _groupId;
	private String _name;
	private int _type;
	private String _prefixURL;
	private String _suffixURL;
	private String _secExt;
	private String _templateURL;
	private String _prefixFile;
	private String _suffixFile;
	private String _templateFile;
	private long _templateIOS;
	private long _templateAndroid;
}