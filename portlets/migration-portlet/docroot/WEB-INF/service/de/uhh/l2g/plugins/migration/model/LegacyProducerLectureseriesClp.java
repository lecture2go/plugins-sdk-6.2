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
import de.uhh.l2g.plugins.migration.service.LegacyProducerLectureseriesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyProducerLectureseriesClp extends BaseModelImpl<LegacyProducerLectureseries>
	implements LegacyProducerLectureseries {
	public LegacyProducerLectureseriesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyProducerLectureseries.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyProducerLectureseries.class.getName();
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
		attributes.put("producerId", getProducerId());
		attributes.put("lectureseriesId", getLectureseriesId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_legacyProducerLectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _legacyProducerLectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_legacyProducerLectureseriesRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProducerId() {
		return _producerId;
	}

	@Override
	public void setProducerId(long producerId) {
		_producerId = producerId;

		if (_legacyProducerLectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _legacyProducerLectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setProducerId", long.class);

				method.invoke(_legacyProducerLectureseriesRemoteModel,
					producerId);
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

		if (_legacyProducerLectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _legacyProducerLectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesId", long.class);

				method.invoke(_legacyProducerLectureseriesRemoteModel,
					lectureseriesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyProducerLectureseriesRemoteModel() {
		return _legacyProducerLectureseriesRemoteModel;
	}

	public void setLegacyProducerLectureseriesRemoteModel(
		BaseModel<?> legacyProducerLectureseriesRemoteModel) {
		_legacyProducerLectureseriesRemoteModel = legacyProducerLectureseriesRemoteModel;
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

		Class<?> remoteModelClass = _legacyProducerLectureseriesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyProducerLectureseriesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyProducerLectureseriesLocalServiceUtil.addLegacyProducerLectureseries(this);
		}
		else {
			LegacyProducerLectureseriesLocalServiceUtil.updateLegacyProducerLectureseries(this);
		}
	}

	@Override
	public LegacyProducerLectureseries toEscapedModel() {
		return (LegacyProducerLectureseries)ProxyUtil.newProxyInstance(LegacyProducerLectureseries.class.getClassLoader(),
			new Class[] { LegacyProducerLectureseries.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyProducerLectureseriesClp clone = new LegacyProducerLectureseriesClp();

		clone.setId(getId());
		clone.setProducerId(getProducerId());
		clone.setLectureseriesId(getLectureseriesId());

		return clone;
	}

	@Override
	public int compareTo(
		LegacyProducerLectureseries legacyProducerLectureseries) {
		long primaryKey = legacyProducerLectureseries.getPrimaryKey();

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

		if (!(obj instanceof LegacyProducerLectureseriesClp)) {
			return false;
		}

		LegacyProducerLectureseriesClp legacyProducerLectureseries = (LegacyProducerLectureseriesClp)obj;

		long primaryKey = legacyProducerLectureseries.getPrimaryKey();

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

		sb.append("{id=");
		sb.append(getId());
		sb.append(", producerId=");
		sb.append(getProducerId());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append(
			"de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>producerId</column-name><column-value><![CDATA[");
		sb.append(getProducerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _producerId;
	private long _lectureseriesId;
	private BaseModel<?> _legacyProducerLectureseriesRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}