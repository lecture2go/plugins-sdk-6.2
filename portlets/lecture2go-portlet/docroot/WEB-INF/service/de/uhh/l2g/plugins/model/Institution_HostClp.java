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
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class Institution_HostClp extends BaseModelImpl<Institution_Host>
	implements Institution_Host {
	public Institution_HostClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Institution_Host.class;
	}

	@Override
	public String getModelClassName() {
		return Institution_Host.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _institutionHostId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInstitutionHostId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _institutionHostId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("institutionHostId", getInstitutionHostId());
		attributes.put("institutionId", getInstitutionId());
		attributes.put("hostId", getHostId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long institutionHostId = (Long)attributes.get("institutionHostId");

		if (institutionHostId != null) {
			setInstitutionHostId(institutionHostId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}
	}

	@Override
	public long getInstitutionHostId() {
		return _institutionHostId;
	}

	@Override
	public void setInstitutionHostId(long institutionHostId) {
		_institutionHostId = institutionHostId;

		if (_institution_HostRemoteModel != null) {
			try {
				Class<?> clazz = _institution_HostRemoteModel.getClass();

				Method method = clazz.getMethod("setInstitutionHostId",
						long.class);

				method.invoke(_institution_HostRemoteModel, institutionHostId);
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

		if (_institution_HostRemoteModel != null) {
			try {
				Class<?> clazz = _institution_HostRemoteModel.getClass();

				Method method = clazz.getMethod("setInstitutionId", long.class);

				method.invoke(_institution_HostRemoteModel, institutionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHostId() {
		return _hostId;
	}

	@Override
	public void setHostId(long hostId) {
		_hostId = hostId;

		if (_institution_HostRemoteModel != null) {
			try {
				Class<?> clazz = _institution_HostRemoteModel.getClass();

				Method method = clazz.getMethod("setHostId", long.class);

				method.invoke(_institution_HostRemoteModel, hostId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getInstitution_HostRemoteModel() {
		return _institution_HostRemoteModel;
	}

	public void setInstitution_HostRemoteModel(
		BaseModel<?> institution_HostRemoteModel) {
		_institution_HostRemoteModel = institution_HostRemoteModel;
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

		Class<?> remoteModelClass = _institution_HostRemoteModel.getClass();

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

		Object returnValue = method.invoke(_institution_HostRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Institution_HostLocalServiceUtil.addInstitution_Host(this);
		}
		else {
			Institution_HostLocalServiceUtil.updateInstitution_Host(this);
		}
	}

	@Override
	public Institution_Host toEscapedModel() {
		return (Institution_Host)ProxyUtil.newProxyInstance(Institution_Host.class.getClassLoader(),
			new Class[] { Institution_Host.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Institution_HostClp clone = new Institution_HostClp();

		clone.setInstitutionHostId(getInstitutionHostId());
		clone.setInstitutionId(getInstitutionId());
		clone.setHostId(getHostId());

		return clone;
	}

	@Override
	public int compareTo(Institution_Host institution_Host) {
		long primaryKey = institution_Host.getPrimaryKey();

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

		if (!(obj instanceof Institution_HostClp)) {
			return false;
		}

		Institution_HostClp institution_Host = (Institution_HostClp)obj;

		long primaryKey = institution_Host.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{institutionHostId=");
		sb.append(getInstitutionHostId());
		sb.append(", institutionId=");
		sb.append(getInstitutionId());
		sb.append(", hostId=");
		sb.append(getHostId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Institution_Host");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>institutionHostId</column-name><column-value><![CDATA[");
		sb.append(getInstitutionHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>institutionId</column-name><column-value><![CDATA[");
		sb.append(getInstitutionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hostId</column-name><column-value><![CDATA[");
		sb.append(getHostId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _institutionHostId;
	private long _institutionId;
	private long _hostId;
	private BaseModel<?> _institution_HostRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}