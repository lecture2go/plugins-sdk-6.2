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
import de.uhh.l2g.plugins.service.SysLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class SysClp extends BaseModelImpl<Sys> implements Sys {
	public SysClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Sys.class;
	}

	@Override
	public String getModelClassName() {
		return Sys.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _sysId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setSysId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sysId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sysId", getSysId());
		attributes.put("version", getVersion());
		attributes.put("setupWizard", getSetupWizard());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer sysId = (Integer)attributes.get("sysId");

		if (sysId != null) {
			setSysId(sysId);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Integer setupWizard = (Integer)attributes.get("setupWizard");

		if (setupWizard != null) {
			setSetupWizard(setupWizard);
		}
	}

	@Override
	public int getSysId() {
		return _sysId;
	}

	@Override
	public void setSysId(int sysId) {
		_sysId = sysId;

		if (_sysRemoteModel != null) {
			try {
				Class<?> clazz = _sysRemoteModel.getClass();

				Method method = clazz.getMethod("setSysId", int.class);

				method.invoke(_sysRemoteModel, sysId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersion() {
		return _version;
	}

	@Override
	public void setVersion(String version) {
		_version = version;

		if (_sysRemoteModel != null) {
			try {
				Class<?> clazz = _sysRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_sysRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSetupWizard() {
		return _setupWizard;
	}

	@Override
	public void setSetupWizard(int setupWizard) {
		_setupWizard = setupWizard;

		if (_sysRemoteModel != null) {
			try {
				Class<?> clazz = _sysRemoteModel.getClass();

				Method method = clazz.getMethod("setSetupWizard", int.class);

				method.invoke(_sysRemoteModel, setupWizard);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSysRemoteModel() {
		return _sysRemoteModel;
	}

	public void setSysRemoteModel(BaseModel<?> sysRemoteModel) {
		_sysRemoteModel = sysRemoteModel;
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

		Class<?> remoteModelClass = _sysRemoteModel.getClass();

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

		Object returnValue = method.invoke(_sysRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SysLocalServiceUtil.addSys(this);
		}
		else {
			SysLocalServiceUtil.updateSys(this);
		}
	}

	@Override
	public Sys toEscapedModel() {
		return (Sys)ProxyUtil.newProxyInstance(Sys.class.getClassLoader(),
			new Class[] { Sys.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SysClp clone = new SysClp();

		clone.setSysId(getSysId());
		clone.setVersion(getVersion());
		clone.setSetupWizard(getSetupWizard());

		return clone;
	}

	@Override
	public int compareTo(Sys sys) {
		int primaryKey = sys.getPrimaryKey();

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

		if (!(obj instanceof SysClp)) {
			return false;
		}

		SysClp sys = (SysClp)obj;

		int primaryKey = sys.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{sysId=");
		sb.append(getSysId());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", setupWizard=");
		sb.append(getSetupWizard());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Sys");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sysId</column-name><column-value><![CDATA[");
		sb.append(getSysId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>setupWizard</column-name><column-value><![CDATA[");
		sb.append(getSetupWizard());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _sysId;
	private String _version;
	private int _setupWizard;
	private BaseModel<?> _sysRemoteModel;
}