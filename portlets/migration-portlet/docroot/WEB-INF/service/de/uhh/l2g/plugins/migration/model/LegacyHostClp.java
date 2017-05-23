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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.uhh.l2g.plugins.migration.service.ClpSerializer;
import de.uhh.l2g.plugins.migration.service.LegacyHostLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyHostClp extends BaseModelImpl<LegacyHost>
	implements LegacyHost {
	public LegacyHostClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyHost.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyHost.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("protokoll", getProtokoll());
		attributes.put("streamer", getStreamer());
		attributes.put("port", getPort());
		attributes.put("serverRoot", getServerRoot());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String protokoll = (String)attributes.get("protokoll");

		if (protokoll != null) {
			setProtokoll(protokoll);
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
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_legacyHostRemoteModel != null) {
			try {
				Class<?> clazz = _legacyHostRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_legacyHostRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProtokoll() {
		return _protokoll;
	}

	@Override
	public void setProtokoll(String protokoll) {
		_protokoll = protokoll;

		if (_legacyHostRemoteModel != null) {
			try {
				Class<?> clazz = _legacyHostRemoteModel.getClass();

				Method method = clazz.getMethod("setProtokoll", String.class);

				method.invoke(_legacyHostRemoteModel, protokoll);
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

		if (_legacyHostRemoteModel != null) {
			try {
				Class<?> clazz = _legacyHostRemoteModel.getClass();

				Method method = clazz.getMethod("setStreamer", String.class);

				method.invoke(_legacyHostRemoteModel, streamer);
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

		if (_legacyHostRemoteModel != null) {
			try {
				Class<?> clazz = _legacyHostRemoteModel.getClass();

				Method method = clazz.getMethod("setPort", int.class);

				method.invoke(_legacyHostRemoteModel, port);
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

		if (_legacyHostRemoteModel != null) {
			try {
				Class<?> clazz = _legacyHostRemoteModel.getClass();

				Method method = clazz.getMethod("setServerRoot", String.class);

				method.invoke(_legacyHostRemoteModel, serverRoot);
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

		if (_legacyHostRemoteModel != null) {
			try {
				Class<?> clazz = _legacyHostRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_legacyHostRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyHostRemoteModel() {
		return _legacyHostRemoteModel;
	}

	public void setLegacyHostRemoteModel(BaseModel<?> legacyHostRemoteModel) {
		_legacyHostRemoteModel = legacyHostRemoteModel;
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

		Class<?> remoteModelClass = _legacyHostRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyHostRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyHostLocalServiceUtil.addLegacyHost(this);
		}
		else {
			LegacyHostLocalServiceUtil.updateLegacyHost(this);
		}
	}

	@Override
	public LegacyHost toEscapedModel() {
		return (LegacyHost)ProxyUtil.newProxyInstance(LegacyHost.class.getClassLoader(),
			new Class[] { LegacyHost.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyHostClp clone = new LegacyHostClp();

		clone.setId(getId());
		clone.setProtokoll(getProtokoll());
		clone.setStreamer(getStreamer());
		clone.setPort(getPort());
		clone.setServerRoot(getServerRoot());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(LegacyHost legacyHost) {
		long primaryKey = legacyHost.getPrimaryKey();

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

		if (!(obj instanceof LegacyHostClp)) {
			return false;
		}

		LegacyHostClp legacyHost = (LegacyHostClp)obj;

		long primaryKey = legacyHost.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", protokoll=");
		sb.append(getProtokoll());
		sb.append(", streamer=");
		sb.append(getStreamer());
		sb.append(", port=");
		sb.append(getPort());
		sb.append(", serverRoot=");
		sb.append(getServerRoot());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyHost");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>protokoll</column-name><column-value><![CDATA[");
		sb.append(getProtokoll());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _protokoll;
	private String _streamer;
	private int _port;
	private String _serverRoot;
	private String _name;
	private BaseModel<?> _legacyHostRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}