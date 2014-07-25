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
import de.uhh.l2g.plugins.service.Lectureseries_FacilityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class Lectureseries_FacilityClp extends BaseModelImpl<Lectureseries_Facility>
	implements Lectureseries_Facility {
	public Lectureseries_FacilityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries_Facility.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries_Facility.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _lectureseriesFacilityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLectureseriesFacilityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lectureseriesFacilityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lectureseriesFacilityId", getLectureseriesFacilityId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("facilityId", getFacilityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesFacilityId = (Long)attributes.get(
				"lectureseriesFacilityId");

		if (lectureseriesFacilityId != null) {
			setLectureseriesFacilityId(lectureseriesFacilityId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}
	}

	@Override
	public long getLectureseriesFacilityId() {
		return _lectureseriesFacilityId;
	}

	@Override
	public void setLectureseriesFacilityId(long lectureseriesFacilityId) {
		_lectureseriesFacilityId = lectureseriesFacilityId;

		if (_lectureseries_FacilityRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseries_FacilityRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesFacilityId",
						long.class);

				method.invoke(_lectureseries_FacilityRemoteModel,
					lectureseriesFacilityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;

		if (_lectureseries_FacilityRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseries_FacilityRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesId", long.class);

				method.invoke(_lectureseries_FacilityRemoteModel,
					lectureseriesId);
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

		if (_lectureseries_FacilityRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseries_FacilityRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityId", long.class);

				method.invoke(_lectureseries_FacilityRemoteModel, facilityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLectureseries_FacilityRemoteModel() {
		return _lectureseries_FacilityRemoteModel;
	}

	public void setLectureseries_FacilityRemoteModel(
		BaseModel<?> lectureseries_FacilityRemoteModel) {
		_lectureseries_FacilityRemoteModel = lectureseries_FacilityRemoteModel;
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

		Class<?> remoteModelClass = _lectureseries_FacilityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lectureseries_FacilityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Lectureseries_FacilityLocalServiceUtil.addLectureseries_Facility(this);
		}
		else {
			Lectureseries_FacilityLocalServiceUtil.updateLectureseries_Facility(this);
		}
	}

	@Override
	public Lectureseries_Facility toEscapedModel() {
		return (Lectureseries_Facility)ProxyUtil.newProxyInstance(Lectureseries_Facility.class.getClassLoader(),
			new Class[] { Lectureseries_Facility.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Lectureseries_FacilityClp clone = new Lectureseries_FacilityClp();

		clone.setLectureseriesFacilityId(getLectureseriesFacilityId());
		clone.setLectureseriesId(getLectureseriesId());
		clone.setFacilityId(getFacilityId());

		return clone;
	}

	@Override
	public int compareTo(Lectureseries_Facility lectureseries_Facility) {
		long primaryKey = lectureseries_Facility.getPrimaryKey();

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

		if (!(obj instanceof Lectureseries_FacilityClp)) {
			return false;
		}

		Lectureseries_FacilityClp lectureseries_Facility = (Lectureseries_FacilityClp)obj;

		long primaryKey = lectureseries_Facility.getPrimaryKey();

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

		sb.append("{lectureseriesFacilityId=");
		sb.append(getLectureseriesFacilityId());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
		sb.append(", facilityId=");
		sb.append(getFacilityId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Lectureseries_Facility");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lectureseriesFacilityId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesFacilityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilityId</column-name><column-value><![CDATA[");
		sb.append(getFacilityId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _lectureseriesFacilityId;
	private long _lectureseriesId;
	private long _facilityId;
	private BaseModel<?> _lectureseries_FacilityRemoteModel;
}