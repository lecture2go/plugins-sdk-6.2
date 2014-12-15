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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.persistence.HostPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class HostClp extends BaseModelImpl<Host> implements Host {
	public HostClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Host.class;
	}

	@Override
	public String getModelClassName() {
		return Host.class.getName();
	}

	@Override
	public HostPK getPrimaryKey() {
		return new HostPK(_hostId, _hostId);
	}

	@Override
	public void setPrimaryKey(HostPK primaryKey) {
		setHostId(primaryKey.hostId);
		setHostId(primaryKey.hostId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new HostPK(_hostId, _hostId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((HostPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hostId", getHostId());
		attributes.put("protocol", getProtocol());
		attributes.put("streamer", getStreamer());
		attributes.put("port", getPort());
		attributes.put("serverRoot", getServerRoot());
		attributes.put("name", getName());
		attributes.put("serverTemplate", getServerTemplate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uuid", getUuid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		String protocol = (String)attributes.get("protocol");

		if (protocol != null) {
			setProtocol(protocol);
		}

		String streamer = (String)attributes.get("streamer");

		if (streamer != null) {
			setStreamer(streamer);
		}

		Integer port = (Integer)attributes.get("port");

		if (port != null) {
			setPort(port);
		}

		String serverRoot = (String)attributes.get("serverRoot");

		if (serverRoot != null) {
			setServerRoot(serverRoot);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String serverTemplate = (String)attributes.get("serverTemplate");

		if (serverTemplate != null) {
			setServerTemplate(serverTemplate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}
	}

	@Override
	public long getHostId() {
		return _hostId;
	}

	@Override
	public void setHostId(long hostId) {
		_hostId = hostId;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setHostId", long.class);

				method.invoke(_hostRemoteModel, hostId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProtocol() {
		return _protocol;
	}

	@Override
	public void setProtocol(String protocol) {
		_protocol = protocol;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setProtocol", String.class);

				method.invoke(_hostRemoteModel, protocol);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreamer() {
		return _streamer;
	}

	@Override
	public void setStreamer(String streamer) {
		_streamer = streamer;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setStreamer", String.class);

				method.invoke(_hostRemoteModel, streamer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPort() {
		return _port;
	}

	@Override
	public void setPort(int port) {
		_port = port;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setPort", int.class);

				method.invoke(_hostRemoteModel, port);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServerRoot() {
		return _serverRoot;
	}

	@Override
	public void setServerRoot(String serverRoot) {
		_serverRoot = serverRoot;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setServerRoot", String.class);

				method.invoke(_hostRemoteModel, serverRoot);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_hostRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServerTemplate() {
		return _serverTemplate;
	}

	@Override
	public void setServerTemplate(String serverTemplate) {
		_serverTemplate = serverTemplate;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setServerTemplate",
						String.class);

				method.invoke(_hostRemoteModel, serverTemplate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_hostRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_hostRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_hostRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_hostRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_hostRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_hostRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_hostRemoteModel != null) {
			try {
				Class<?> clazz = _hostRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_hostRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getHostRemoteModel() {
		return _hostRemoteModel;
	}

	public void setHostRemoteModel(BaseModel<?> hostRemoteModel) {
		_hostRemoteModel = hostRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _hostRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_hostRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HostLocalServiceUtil.addHost(this);
		}
		else {
			HostLocalServiceUtil.updateHost(this);
		}
	}

	@Override
	public Host toEscapedModel() {
		return (Host)ProxyUtil.newProxyInstance(Host.class.getClassLoader(),
			new Class[] { Host.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HostClp clone = new HostClp();

		clone.setHostId(getHostId());
		clone.setProtocol(getProtocol());
		clone.setStreamer(getStreamer());
		clone.setPort(getPort());
		clone.setServerRoot(getServerRoot());
		clone.setName(getName());
		clone.setServerTemplate(getServerTemplate());
		clone.setHostId(getHostId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUuid(getUuid());

		return clone;
	}

	@Override
	public int compareTo(Host host) {
		HostPK primaryKey = host.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HostClp)) {
			return false;
		}

		HostClp host = (HostClp)obj;

		HostPK primaryKey = host.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{hostId=");
		sb.append(getHostId());
		sb.append(", protocol=");
		sb.append(getProtocol());
		sb.append(", streamer=");
		sb.append(getStreamer());
		sb.append(", port=");
		sb.append(getPort());
		sb.append(", serverRoot=");
		sb.append(getServerRoot());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", serverTemplate=");
		sb.append(getServerTemplate());
		sb.append(getHostId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", uuid=");
		sb.append(getUuid());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Host");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hostId</column-name><column-value><![CDATA[");
		sb.append(getHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>protocol</column-name><column-value><![CDATA[");
		sb.append(getProtocol());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>streamer</column-name><column-value><![CDATA[");
		sb.append(getStreamer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>port</column-name><column-value><![CDATA[");
		sb.append(getPort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serverRoot</column-name><column-value><![CDATA[");
		sb.append(getServerRoot());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serverTemplate</column-name><column-value><![CDATA[");
		sb.append(getServerTemplate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hostId</column-name><column-value><![CDATA[");
		sb.append(getHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _hostId;
	private String _protocol;
	private String _streamer;
	private int _port;
	private String _serverRoot;
	private String _name;
	private String _serverTemplate;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _uuid;
	private BaseModel<?> _hostRemoteModel;
}