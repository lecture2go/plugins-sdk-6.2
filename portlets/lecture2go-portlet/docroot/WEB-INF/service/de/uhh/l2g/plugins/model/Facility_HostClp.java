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
import de.uhh.l2g.plugins.service.Facility_HostLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class Facility_HostClp extends BaseModelImpl<Facility_Host>
	implements Facility_Host {
	public Facility_HostClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Facility_Host.class;
	}

	@Override
	public String getModelClassName() {
		return Facility_Host.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _fasilityHostId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFasilityHostId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fasilityHostId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fasilityHostId", getFasilityHostId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("hostId", getHostId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fasilityHostId = (Long)attributes.get("fasilityHostId");

		if (fasilityHostId != null) {
			setFasilityHostId(fasilityHostId);
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
	public long getFasilityHostId() {
		return _fasilityHostId;
	}

	@Override
	public void setFasilityHostId(long fasilityHostId) {
		_fasilityHostId = fasilityHostId;

		if (_facility_HostRemoteModel != null) {
			try {
				Class<?> clazz = _facility_HostRemoteModel.getClass();

				Method method = clazz.getMethod("setFasilityHostId", long.class);

				method.invoke(_facility_HostRemoteModel, fasilityHostId);
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

		if (_facility_HostRemoteModel != null) {
			try {
				Class<?> clazz = _facility_HostRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityId", long.class);

				method.invoke(_facility_HostRemoteModel, facilityId);
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

		if (_facility_HostRemoteModel != null) {
			try {
				Class<?> clazz = _facility_HostRemoteModel.getClass();

				Method method = clazz.getMethod("setHostId", long.class);

				method.invoke(_facility_HostRemoteModel, hostId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFacility_HostRemoteModel() {
		return _facility_HostRemoteModel;
	}

	public void setFacility_HostRemoteModel(
		BaseModel<?> facility_HostRemoteModel) {
		_facility_HostRemoteModel = facility_HostRemoteModel;
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

		Class<?> remoteModelClass = _facility_HostRemoteModel.getClass();

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

		Object returnValue = method.invoke(_facility_HostRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Facility_HostLocalServiceUtil.addFacility_Host(this);
		}
		else {
			Facility_HostLocalServiceUtil.updateFacility_Host(this);
		}
	}

	@Override
	public Facility_Host toEscapedModel() {
		return (Facility_Host)ProxyUtil.newProxyInstance(Facility_Host.class.getClassLoader(),
			new Class[] { Facility_Host.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Facility_HostClp clone = new Facility_HostClp();

		clone.setFasilityHostId(getFasilityHostId());
		clone.setFacilityId(getFacilityId());
		clone.setHostId(getHostId());

		return clone;
	}

	@Override
	public int compareTo(Facility_Host facility_Host) {
		long primaryKey = facility_Host.getPrimaryKey();

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

		if (!(obj instanceof Facility_HostClp)) {
			return false;
		}

		Facility_HostClp facility_Host = (Facility_HostClp)obj;

		long primaryKey = facility_Host.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{fasilityHostId=");
		sb.append(getFasilityHostId());
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
		sb.append("de.uhh.l2g.plugins.model.Facility_Host");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>fasilityHostId</column-name><column-value><![CDATA[");
		sb.append(getFasilityHostId());
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

	private long _fasilityHostId;
	private long _facilityId;
	private long _hostId;
	private BaseModel<?> _facility_HostRemoteModel;
}