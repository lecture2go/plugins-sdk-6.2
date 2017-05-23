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
import de.uhh.l2g.plugins.migration.service.LegacyL2gSysLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyL2gSysClp extends BaseModelImpl<LegacyL2gSys>
	implements LegacyL2gSys {
	public LegacyL2gSysClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyL2gSys.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyL2gSys.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("version", getVersion());
		attributes.put("setupwizard", getSetupwizard());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Integer setupwizard = (Integer)attributes.get("setupwizard");

		if (setupwizard != null) {
			setSetupwizard(setupwizard);
		}
	}

	@Override
	public int getId() {
		return _id;
	}

	@Override
	public void setId(int id) {
		_id = id;

		if (_legacyL2gSysRemoteModel != null) {
			try {
				Class<?> clazz = _legacyL2gSysRemoteModel.getClass();

				Method method = clazz.getMethod("setId", int.class);

				method.invoke(_legacyL2gSysRemoteModel, id);
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

		if (_legacyL2gSysRemoteModel != null) {
			try {
				Class<?> clazz = _legacyL2gSysRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_legacyL2gSysRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSetupwizard() {
		return _setupwizard;
	}

	@Override
	public void setSetupwizard(int setupwizard) {
		_setupwizard = setupwizard;

		if (_legacyL2gSysRemoteModel != null) {
			try {
				Class<?> clazz = _legacyL2gSysRemoteModel.getClass();

				Method method = clazz.getMethod("setSetupwizard", int.class);

				method.invoke(_legacyL2gSysRemoteModel, setupwizard);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyL2gSysRemoteModel() {
		return _legacyL2gSysRemoteModel;
	}

	public void setLegacyL2gSysRemoteModel(BaseModel<?> legacyL2gSysRemoteModel) {
		_legacyL2gSysRemoteModel = legacyL2gSysRemoteModel;
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

		Class<?> remoteModelClass = _legacyL2gSysRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyL2gSysRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyL2gSysLocalServiceUtil.addLegacyL2gSys(this);
		}
		else {
			LegacyL2gSysLocalServiceUtil.updateLegacyL2gSys(this);
		}
	}

	@Override
	public LegacyL2gSys toEscapedModel() {
		return (LegacyL2gSys)ProxyUtil.newProxyInstance(LegacyL2gSys.class.getClassLoader(),
			new Class[] { LegacyL2gSys.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyL2gSysClp clone = new LegacyL2gSysClp();

		clone.setId(getId());
		clone.setVersion(getVersion());
		clone.setSetupwizard(getSetupwizard());

		return clone;
	}

	@Override
	public int compareTo(LegacyL2gSys legacyL2gSys) {
		int primaryKey = legacyL2gSys.getPrimaryKey();

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

		if (!(obj instanceof LegacyL2gSysClp)) {
			return false;
		}

		LegacyL2gSysClp legacyL2gSys = (LegacyL2gSysClp)obj;

		int primaryKey = legacyL2gSys.getPrimaryKey();

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
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", setupwizard=");
		sb.append(getSetupwizard());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyL2gSys");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>setupwizard</column-name><column-value><![CDATA[");
		sb.append(getSetupwizard());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id;
	private String _version;
	private int _setupwizard;
	private BaseModel<?> _legacyL2gSysRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}