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
import de.uhh.l2g.plugins.migration.service.LegacyLectureSeriesFacilityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyLectureSeriesFacilityClp extends BaseModelImpl<LegacyLectureSeriesFacility>
	implements LegacyLectureSeriesFacility {
	public LegacyLectureSeriesFacilityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyLectureSeriesFacility.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyLectureSeriesFacility.class.getName();
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
		attributes.put("facilityId", getFacilityId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("isLinkFrom", getIsLinkFrom());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesFacilityId = (Long)attributes.get(
				"lectureseriesFacilityId");

		if (lectureseriesFacilityId != null) {
			setLectureseriesFacilityId(lectureseriesFacilityId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long isLinkFrom = (Long)attributes.get("isLinkFrom");

		if (isLinkFrom != null) {
			setIsLinkFrom(isLinkFrom);
		}
	}

	@Override
	public long getLectureseriesFacilityId() {
		return _lectureseriesFacilityId;
	}

	@Override
	public void setLectureseriesFacilityId(long lectureseriesFacilityId) {
		_lectureseriesFacilityId = lectureseriesFacilityId;

		if (_legacyLectureSeriesFacilityRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLectureSeriesFacilityRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesFacilityId",
						long.class);

				method.invoke(_legacyLectureSeriesFacilityRemoteModel,
					lectureseriesFacilityId);
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

		if (_legacyLectureSeriesFacilityRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLectureSeriesFacilityRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityId", long.class);

				method.invoke(_legacyLectureSeriesFacilityRemoteModel,
					facilityId);
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

		if (_legacyLectureSeriesFacilityRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLectureSeriesFacilityRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesId", long.class);

				method.invoke(_legacyLectureSeriesFacilityRemoteModel,
					lectureseriesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIsLinkFrom() {
		return _isLinkFrom;
	}

	@Override
	public void setIsLinkFrom(long isLinkFrom) {
		_isLinkFrom = isLinkFrom;

		if (_legacyLectureSeriesFacilityRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLectureSeriesFacilityRemoteModel.getClass();

				Method method = clazz.getMethod("setIsLinkFrom", long.class);

				method.invoke(_legacyLectureSeriesFacilityRemoteModel,
					isLinkFrom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyLectureSeriesFacilityRemoteModel() {
		return _legacyLectureSeriesFacilityRemoteModel;
	}

	public void setLegacyLectureSeriesFacilityRemoteModel(
		BaseModel<?> legacyLectureSeriesFacilityRemoteModel) {
		_legacyLectureSeriesFacilityRemoteModel = legacyLectureSeriesFacilityRemoteModel;
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

		Class<?> remoteModelClass = _legacyLectureSeriesFacilityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyLectureSeriesFacilityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyLectureSeriesFacilityLocalServiceUtil.addLegacyLectureSeriesFacility(this);
		}
		else {
			LegacyLectureSeriesFacilityLocalServiceUtil.updateLegacyLectureSeriesFacility(this);
		}
	}

	@Override
	public LegacyLectureSeriesFacility toEscapedModel() {
		return (LegacyLectureSeriesFacility)ProxyUtil.newProxyInstance(LegacyLectureSeriesFacility.class.getClassLoader(),
			new Class[] { LegacyLectureSeriesFacility.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyLectureSeriesFacilityClp clone = new LegacyLectureSeriesFacilityClp();

		clone.setLectureseriesFacilityId(getLectureseriesFacilityId());
		clone.setFacilityId(getFacilityId());
		clone.setLectureseriesId(getLectureseriesId());
		clone.setIsLinkFrom(getIsLinkFrom());

		return clone;
	}

	@Override
	public int compareTo(
		LegacyLectureSeriesFacility legacyLectureSeriesFacility) {
		long primaryKey = legacyLectureSeriesFacility.getPrimaryKey();

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

		if (!(obj instanceof LegacyLectureSeriesFacilityClp)) {
			return false;
		}

		LegacyLectureSeriesFacilityClp legacyLectureSeriesFacility = (LegacyLectureSeriesFacilityClp)obj;

		long primaryKey = legacyLectureSeriesFacility.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{lectureseriesFacilityId=");
		sb.append(getLectureseriesFacilityId());
		sb.append(", facilityId=");
		sb.append(getFacilityId());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
		sb.append(", isLinkFrom=");
		sb.append(getIsLinkFrom());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lectureseriesFacilityId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesFacilityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilityId</column-name><column-value><![CDATA[");
		sb.append(getFacilityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isLinkFrom</column-name><column-value><![CDATA[");
		sb.append(getIsLinkFrom());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _lectureseriesFacilityId;
	private long _facilityId;
	private long _lectureseriesId;
	private long _isLinkFrom;
	private BaseModel<?> _legacyLectureSeriesFacilityRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}