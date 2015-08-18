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
import de.uhh.l2g.plugins.migration.service.LegacyFacilityHostLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyFacilityHostClp extends BaseModelImpl<LegacyFacilityHost>
	implements LegacyFacilityHost {
	public LegacyFacilityHostClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyFacilityHost.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyFacilityHost.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _facilityHostId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFacilityHostId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _facilityHostId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facilityHostId", getFacilityHostId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("hostId", getHostId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long facilityHostId = (Long)attributes.get("facilityHostId");

		if (facilityHostId != null) {
			setFacilityHostId(facilityHostId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}
	}

	@Override
	public long getFacilityHostId() {
		return _facilityHostId;
	}

	@Override
	public void setFacilityHostId(long facilityHostId) {
		_facilityHostId = facilityHostId;

		if (_legacyFacilityHostRemoteModel != null) {
			try {
				Class<?> clazz = _legacyFacilityHostRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityHostId", long.class);

				method.invoke(_legacyFacilityHostRemoteModel, facilityHostId);
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

		if (_legacyFacilityHostRemoteModel != null) {
			try {
				Class<?> clazz = _legacyFacilityHostRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityId", long.class);

				method.invoke(_legacyFacilityHostRemoteModel, facilityId);
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

		if (_legacyFacilityHostRemoteModel != null) {
			try {
				Class<?> clazz = _legacyFacilityHostRemoteModel.getClass();

				Method method = clazz.getMethod("setHostId", long.class);

				method.invoke(_legacyFacilityHostRemoteModel, hostId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyFacilityHostRemoteModel() {
		return _legacyFacilityHostRemoteModel;
	}

	public void setLegacyFacilityHostRemoteModel(
		BaseModel<?> legacyFacilityHostRemoteModel) {
		_legacyFacilityHostRemoteModel = legacyFacilityHostRemoteModel;
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

		Class<?> remoteModelClass = _legacyFacilityHostRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyFacilityHostRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyFacilityHostLocalServiceUtil.addLegacyFacilityHost(this);
		}
		else {
			LegacyFacilityHostLocalServiceUtil.updateLegacyFacilityHost(this);
		}
	}

	@Override
	public LegacyFacilityHost toEscapedModel() {
		return (LegacyFacilityHost)ProxyUtil.newProxyInstance(LegacyFacilityHost.class.getClassLoader(),
			new Class[] { LegacyFacilityHost.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyFacilityHostClp clone = new LegacyFacilityHostClp();

		clone.setFacilityHostId(getFacilityHostId());
		clone.setFacilityId(getFacilityId());
		clone.setHostId(getHostId());

		return clone;
	}

	@Override
	public int compareTo(LegacyFacilityHost legacyFacilityHost) {
		long primaryKey = legacyFacilityHost.getPrimaryKey();

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

		if (!(obj instanceof LegacyFacilityHostClp)) {
			return false;
		}

		LegacyFacilityHostClp legacyFacilityHost = (LegacyFacilityHostClp)obj;

		long primaryKey = legacyFacilityHost.getPrimaryKey();

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

		sb.append("{facilityHostId=");
		sb.append(getFacilityHostId());
		sb.append(", facilityId=");
		sb.append(getFacilityId());
		sb.append(", hostId=");
		sb.append(getHostId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyFacilityHost");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>facilityHostId</column-name><column-value><![CDATA[");
		sb.append(getFacilityHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilityId</column-name><column-value><![CDATA[");
		sb.append(getFacilityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hostId</column-name><column-value><![CDATA[");
		sb.append(getHostId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _facilityHostId;
	private long _facilityId;
	private long _hostId;
	private BaseModel<?> _legacyFacilityHostRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}