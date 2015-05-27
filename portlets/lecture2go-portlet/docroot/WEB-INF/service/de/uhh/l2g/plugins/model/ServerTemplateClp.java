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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.ServerTemplateLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class ServerTemplateClp extends BaseModelImpl<ServerTemplate>
	implements ServerTemplate {
	public ServerTemplateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ServerTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return ServerTemplate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _serverTemplateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setServerTemplateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _serverTemplateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serverTemplateId", getServerTemplateId());
		attributes.put("groupId", getGroupId());
		attributes.put("name", getName());
		attributes.put("type", getType());
		attributes.put("prefixURL", getPrefixURL());
		attributes.put("suffixURL", getSuffixURL());
		attributes.put("secExt", getSecExt());
		attributes.put("templateURL", getTemplateURL());
		attributes.put("prefixFile", getPrefixFile());
		attributes.put("suffixFile", getSuffixFile());
		attributes.put("templateFile", getTemplateFile());
		attributes.put("templateIOS", getTemplateIOS());
		attributes.put("templateAndroid", getTemplateAndroid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serverTemplateId = (Long)attributes.get("serverTemplateId");

		if (serverTemplateId != null) {
			setServerTemplateId(serverTemplateId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String prefixURL = (String)attributes.get("prefixURL");

		if (prefixURL != null) {
			setPrefixURL(prefixURL);
		}

		String suffixURL = (String)attributes.get("suffixURL");

		if (suffixURL != null) {
			setSuffixURL(suffixURL);
		}

		String secExt = (String)attributes.get("secExt");

		if (secExt != null) {
			setSecExt(secExt);
		}

		String templateURL = (String)attributes.get("templateURL");

		if (templateURL != null) {
			setTemplateURL(templateURL);
		}

		String prefixFile = (String)attributes.get("prefixFile");

		if (prefixFile != null) {
			setPrefixFile(prefixFile);
		}

		String suffixFile = (String)attributes.get("suffixFile");

		if (suffixFile != null) {
			setSuffixFile(suffixFile);
		}

		String templateFile = (String)attributes.get("templateFile");

		if (templateFile != null) {
			setTemplateFile(templateFile);
		}

		Long templateIOS = (Long)attributes.get("templateIOS");

		if (templateIOS != null) {
			setTemplateIOS(templateIOS);
		}

		Long templateAndroid = (Long)attributes.get("templateAndroid");

		if (templateAndroid != null) {
			setTemplateAndroid(templateAndroid);
		}
	}

	@Override
	public long getServerTemplateId() {
		return _serverTemplateId;
	}

	@Override
	public void setServerTemplateId(long serverTemplateId) {
		_serverTemplateId = serverTemplateId;

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setServerTemplateId",
						long.class);

				method.invoke(_serverTemplateRemoteModel, serverTemplateId);
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

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_serverTemplateRemoteModel, groupId);
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

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_serverTemplateRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_type = type;

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setType", int.class);

				method.invoke(_serverTemplateRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrefixURL() {
		return _prefixURL;
	}

	@Override
	public void setPrefixURL(String prefixURL) {
		_prefixURL = prefixURL;

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setPrefixURL", String.class);

				method.invoke(_serverTemplateRemoteModel, prefixURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSuffixURL() {
		return _suffixURL;
	}

	@Override
	public void setSuffixURL(String suffixURL) {
		_suffixURL = suffixURL;

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setSuffixURL", String.class);

				method.invoke(_serverTemplateRemoteModel, suffixURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecExt() {
		return _secExt;
	}

	@Override
	public void setSecExt(String secExt) {
		_secExt = secExt;

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setSecExt", String.class);

				method.invoke(_serverTemplateRemoteModel, secExt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTemplateURL() {
		return _templateURL;
	}

	@Override
	public void setTemplateURL(String templateURL) {
		_templateURL = templateURL;

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateURL", String.class);

				method.invoke(_serverTemplateRemoteModel, templateURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrefixFile() {
		return _prefixFile;
	}

	@Override
	public void setPrefixFile(String prefixFile) {
		_prefixFile = prefixFile;

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setPrefixFile", String.class);

				method.invoke(_serverTemplateRemoteModel, prefixFile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSuffixFile() {
		return _suffixFile;
	}

	@Override
	public void setSuffixFile(String suffixFile) {
		_suffixFile = suffixFile;

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setSuffixFile", String.class);

				method.invoke(_serverTemplateRemoteModel, suffixFile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTemplateFile() {
		return _templateFile;
	}

	@Override
	public void setTemplateFile(String templateFile) {
		_templateFile = templateFile;

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateFile", String.class);

				method.invoke(_serverTemplateRemoteModel, templateFile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTemplateIOS() {
		return _templateIOS;
	}

	@Override
	public void setTemplateIOS(long templateIOS) {
		_templateIOS = templateIOS;

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateIOS", long.class);

				method.invoke(_serverTemplateRemoteModel, templateIOS);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTemplateAndroid() {
		return _templateAndroid;
	}

	@Override
	public void setTemplateAndroid(long templateAndroid) {
		_templateAndroid = templateAndroid;

		if (_serverTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serverTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateAndroid", long.class);

				method.invoke(_serverTemplateRemoteModel, templateAndroid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getServerTemplateRemoteModel() {
		return _serverTemplateRemoteModel;
	}

	public void setServerTemplateRemoteModel(
		BaseModel<?> serverTemplateRemoteModel) {
		_serverTemplateRemoteModel = serverTemplateRemoteModel;
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

		Class<?> remoteModelClass = _serverTemplateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_serverTemplateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ServerTemplateLocalServiceUtil.addServerTemplate(this);
		}
		else {
			ServerTemplateLocalServiceUtil.updateServerTemplate(this);
		}
	}

	@Override
	public ServerTemplate toEscapedModel() {
		return (ServerTemplate)ProxyUtil.newProxyInstance(ServerTemplate.class.getClassLoader(),
			new Class[] { ServerTemplate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ServerTemplateClp clone = new ServerTemplateClp();

		clone.setServerTemplateId(getServerTemplateId());
		clone.setGroupId(getGroupId());
		clone.setName(getName());
		clone.setType(getType());
		clone.setPrefixURL(getPrefixURL());
		clone.setSuffixURL(getSuffixURL());
		clone.setSecExt(getSecExt());
		clone.setTemplateURL(getTemplateURL());
		clone.setPrefixFile(getPrefixFile());
		clone.setSuffixFile(getSuffixFile());
		clone.setTemplateFile(getTemplateFile());
		clone.setTemplateIOS(getTemplateIOS());
		clone.setTemplateAndroid(getTemplateAndroid());

		return clone;
	}

	@Override
	public int compareTo(ServerTemplate serverTemplate) {
		long primaryKey = serverTemplate.getPrimaryKey();

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

		if (!(obj instanceof ServerTemplateClp)) {
			return false;
		}

		ServerTemplateClp serverTemplate = (ServerTemplateClp)obj;

		long primaryKey = serverTemplate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{serverTemplateId=");
		sb.append(getServerTemplateId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", prefixURL=");
		sb.append(getPrefixURL());
		sb.append(", suffixURL=");
		sb.append(getSuffixURL());
		sb.append(", secExt=");
		sb.append(getSecExt());
		sb.append(", templateURL=");
		sb.append(getTemplateURL());
		sb.append(", prefixFile=");
		sb.append(getPrefixFile());
		sb.append(", suffixFile=");
		sb.append(getSuffixFile());
		sb.append(", templateFile=");
		sb.append(getTemplateFile());
		sb.append(", templateIOS=");
		sb.append(getTemplateIOS());
		sb.append(", templateAndroid=");
		sb.append(getTemplateAndroid());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.ServerTemplate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>serverTemplateId</column-name><column-value><![CDATA[");
		sb.append(getServerTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prefixURL</column-name><column-value><![CDATA[");
		sb.append(getPrefixURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>suffixURL</column-name><column-value><![CDATA[");
		sb.append(getSuffixURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secExt</column-name><column-value><![CDATA[");
		sb.append(getSecExt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateURL</column-name><column-value><![CDATA[");
		sb.append(getTemplateURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prefixFile</column-name><column-value><![CDATA[");
		sb.append(getPrefixFile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>suffixFile</column-name><column-value><![CDATA[");
		sb.append(getSuffixFile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateFile</column-name><column-value><![CDATA[");
		sb.append(getTemplateFile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateIOS</column-name><column-value><![CDATA[");
		sb.append(getTemplateIOS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateAndroid</column-name><column-value><![CDATA[");
		sb.append(getTemplateAndroid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _serverTemplateRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}