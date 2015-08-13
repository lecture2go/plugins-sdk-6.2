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
import de.uhh.l2g.plugins.migration.service.LegacyVideoFacilityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyVideoFacilityClp extends BaseModelImpl<LegacyVideoFacility>
	implements LegacyVideoFacility {
	public LegacyVideoFacilityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyVideoFacility.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyVideoFacility.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _videoFacilityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVideoFacilityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _videoFacilityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoFacilityId", getVideoFacilityId());
		attributes.put("videoId", getVideoId());
		attributes.put("facilityId", getFacilityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoFacilityId = (Long)attributes.get("videoFacilityId");

		if (videoFacilityId != null) {
			setVideoFacilityId(videoFacilityId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}
	}

	@Override
	public long getVideoFacilityId() {
		return _videoFacilityId;
	}

	@Override
	public void setVideoFacilityId(long videoFacilityId) {
		_videoFacilityId = videoFacilityId;

		if (_legacyVideoFacilityRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoFacilityRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoFacilityId", long.class);

				method.invoke(_legacyVideoFacilityRemoteModel, videoFacilityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVideoId() {
		return _videoId;
	}

	@Override
	public void setVideoId(long videoId) {
		_videoId = videoId;

		if (_legacyVideoFacilityRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoFacilityRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", long.class);

				method.invoke(_legacyVideoFacilityRemoteModel, videoId);
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

		if (_legacyVideoFacilityRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoFacilityRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityId", long.class);

				method.invoke(_legacyVideoFacilityRemoteModel, facilityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyVideoFacilityRemoteModel() {
		return _legacyVideoFacilityRemoteModel;
	}

	public void setLegacyVideoFacilityRemoteModel(
		BaseModel<?> legacyVideoFacilityRemoteModel) {
		_legacyVideoFacilityRemoteModel = legacyVideoFacilityRemoteModel;
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

		Class<?> remoteModelClass = _legacyVideoFacilityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyVideoFacilityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyVideoFacilityLocalServiceUtil.addLegacyVideoFacility(this);
		}
		else {
			LegacyVideoFacilityLocalServiceUtil.updateLegacyVideoFacility(this);
		}
	}

	@Override
	public LegacyVideoFacility toEscapedModel() {
		return (LegacyVideoFacility)ProxyUtil.newProxyInstance(LegacyVideoFacility.class.getClassLoader(),
			new Class[] { LegacyVideoFacility.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyVideoFacilityClp clone = new LegacyVideoFacilityClp();

		clone.setVideoFacilityId(getVideoFacilityId());
		clone.setVideoId(getVideoId());
		clone.setFacilityId(getFacilityId());

		return clone;
	}

	@Override
	public int compareTo(LegacyVideoFacility legacyVideoFacility) {
		long primaryKey = legacyVideoFacility.getPrimaryKey();

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

		if (!(obj instanceof LegacyVideoFacilityClp)) {
			return false;
		}

		LegacyVideoFacilityClp legacyVideoFacility = (LegacyVideoFacilityClp)obj;

		long primaryKey = legacyVideoFacility.getPrimaryKey();

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

		sb.append("{videoFacilityId=");
		sb.append(getVideoFacilityId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", facilityId=");
		sb.append(getFacilityId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyVideoFacility");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoFacilityId</column-name><column-value><![CDATA[");
		sb.append(getVideoFacilityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilityId</column-name><column-value><![CDATA[");
		sb.append(getFacilityId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videoFacilityId;
	private long _videoId;
	private long _facilityId;
	private BaseModel<?> _legacyVideoFacilityRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}