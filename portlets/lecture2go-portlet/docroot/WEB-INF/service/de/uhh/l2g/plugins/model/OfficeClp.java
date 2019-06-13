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
import de.uhh.l2g.plugins.service.OfficeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class OfficeClp extends BaseModelImpl<Office> implements Office {
	public OfficeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Office.class;
	}

	@Override
	public String getModelClassName() {
		return Office.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _officeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOfficeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _officeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeId", getOfficeId());
		attributes.put("name", getName());
		attributes.put("www", getWww());
		attributes.put("email", getEmail());
		attributes.put("institutionId", getInstitutionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long officeId = (Long)attributes.get("officeId");

		if (officeId != null) {
			setOfficeId(officeId);
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

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}
	}

	@Override
	public long getOfficeId() {
		return _officeId;
	}

	@Override
	public void setOfficeId(long officeId) {
		_officeId = officeId;

		if (_officeRemoteModel != null) {
			try {
				Class<?> clazz = _officeRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeId", long.class);

				method.invoke(_officeRemoteModel, officeId);
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

		if (_officeRemoteModel != null) {
			try {
				Class<?> clazz = _officeRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_officeRemoteModel, name);
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

		if (_officeRemoteModel != null) {
			try {
				Class<?> clazz = _officeRemoteModel.getClass();

				Method method = clazz.getMethod("setWww", String.class);

				method.invoke(_officeRemoteModel, www);
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

		if (_officeRemoteModel != null) {
			try {
				Class<?> clazz = _officeRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_officeRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInstitutionId() {
		return _institutionId;
	}

	@Override
	public void setInstitutionId(long institutionId) {
		_institutionId = institutionId;

		if (_officeRemoteModel != null) {
			try {
				Class<?> clazz = _officeRemoteModel.getClass();

				Method method = clazz.getMethod("setInstitutionId", long.class);

				method.invoke(_officeRemoteModel, institutionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOfficeRemoteModel() {
		return _officeRemoteModel;
	}

	public void setOfficeRemoteModel(BaseModel<?> officeRemoteModel) {
		_officeRemoteModel = officeRemoteModel;
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

		Class<?> remoteModelClass = _officeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_officeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OfficeLocalServiceUtil.addOffice(this);
		}
		else {
			OfficeLocalServiceUtil.updateOffice(this);
		}
	}

	@Override
	public Office toEscapedModel() {
		return (Office)ProxyUtil.newProxyInstance(Office.class.getClassLoader(),
			new Class[] { Office.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OfficeClp clone = new OfficeClp();

		clone.setOfficeId(getOfficeId());
		clone.setName(getName());
		clone.setWww(getWww());
		clone.setEmail(getEmail());
		clone.setInstitutionId(getInstitutionId());

		return clone;
	}

	@Override
	public int compareTo(Office office) {
		long primaryKey = office.getPrimaryKey();

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

		if (!(obj instanceof OfficeClp)) {
			return false;
		}

		OfficeClp office = (OfficeClp)obj;

		long primaryKey = office.getPrimaryKey();

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

		sb.append("{officeId=");
		sb.append(getOfficeId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", www=");
		sb.append(getWww());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", institutionId=");
		sb.append(getInstitutionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Office");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>officeId</column-name><column-value><![CDATA[");
		sb.append(getOfficeId());
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
			"<column><column-name>institutionId</column-name><column-value><![CDATA[");
		sb.append(getInstitutionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _officeId;
	private String _name;
	private String _www;
	private String _email;
	private long _institutionId;
	private BaseModel<?> _officeRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}