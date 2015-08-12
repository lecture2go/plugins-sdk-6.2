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
import de.uhh.l2g.plugins.migration.service.LegacyOfficeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyOfficeClp extends BaseModelImpl<LegacyOffice>
	implements LegacyOffice {
	public LegacyOfficeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyOffice.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyOffice.class.getName();
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
		attributes.put("name", getName());
		attributes.put("www", getWww());
		attributes.put("email", getEmail());
		attributes.put("facilityId", getFacilityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String www = (String)attributes.get("www");

		if (www != null) {
			setWww(www);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_legacyOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _legacyOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_legacyOfficeRemoteModel, id);
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

		if (_legacyOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _legacyOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_legacyOfficeRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWww() {
		return _www;
	}

	@Override
	public void setWww(String www) {
		_www = www;

		if (_legacyOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _legacyOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setWww", String.class);

				method.invoke(_legacyOfficeRemoteModel, www);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_legacyOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _legacyOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_legacyOfficeRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFacilityId() {
		return _facilityId;
	}

	@Override
	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;

		if (_legacyOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _legacyOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityId", long.class);

				method.invoke(_legacyOfficeRemoteModel, facilityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyOfficeRemoteModel() {
		return _legacyOfficeRemoteModel;
	}

	public void setLegacyOfficeRemoteModel(BaseModel<?> legacyOfficeRemoteModel) {
		_legacyOfficeRemoteModel = legacyOfficeRemoteModel;
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

		Class<?> remoteModelClass = _legacyOfficeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyOfficeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyOfficeLocalServiceUtil.addLegacyOffice(this);
		}
		else {
			LegacyOfficeLocalServiceUtil.updateLegacyOffice(this);
		}
	}

	@Override
	public LegacyOffice toEscapedModel() {
		return (LegacyOffice)ProxyUtil.newProxyInstance(LegacyOffice.class.getClassLoader(),
			new Class[] { LegacyOffice.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyOfficeClp clone = new LegacyOfficeClp();

		clone.setId(getId());
		clone.setName(getName());
		clone.setWww(getWww());
		clone.setEmail(getEmail());
		clone.setFacilityId(getFacilityId());

		return clone;
	}

	@Override
	public int compareTo(LegacyOffice legacyOffice) {
		long primaryKey = legacyOffice.getPrimaryKey();

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

		if (!(obj instanceof LegacyOfficeClp)) {
			return false;
		}

		LegacyOfficeClp legacyOffice = (LegacyOfficeClp)obj;

		long primaryKey = legacyOffice.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", www=");
		sb.append(getWww());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", facilityId=");
		sb.append(getFacilityId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyOffice");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>www</column-name><column-value><![CDATA[");
		sb.append(getWww());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilityId</column-name><column-value><![CDATA[");
		sb.append(getFacilityId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _name;
	private String _www;
	private String _email;
	private long _facilityId;
	private BaseModel<?> _legacyOfficeRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}