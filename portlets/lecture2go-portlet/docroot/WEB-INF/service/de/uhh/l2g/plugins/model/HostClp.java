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

import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

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
	public long getPrimaryKey() {
		return _hostId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHostId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _hostId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hostId", getHostId());
		attributes.put("protocol", getProtocol());
		attributes.put("streamer", getStreamer());
		attributes.put("port", getPort());
		attributes.put("serverRoot", getServerRoot());
		attributes.put("serverTemplate", getServerTemplate());
		attributes.put("name", getName());
		attributes.put("groupId", getGroupId());

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

		String serverTemplate = (String)attributes.get("serverTemplate");

		if (serverTemplate != null) {
			setServerTemplate(serverTemplate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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
		clone.setServerTemplate(getServerTemplate());
		clone.setName(getName());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(Host host) {
		long primaryKey = host.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
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

		long primaryKey = host.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

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
		sb.append(", serverTemplate=");
		sb.append(getServerTemplate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

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
			"<column><column-name>serverTemplate</column-name><column-value><![CDATA[");
		sb.append(getServerTemplate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _hostId;
	private String _protocol;
	private String _streamer;
	private int _port;
	private String _serverRoot;
	private String _serverTemplate;
	private String _name;
	private long _groupId;
	private BaseModel<?> _hostRemoteModel;
}