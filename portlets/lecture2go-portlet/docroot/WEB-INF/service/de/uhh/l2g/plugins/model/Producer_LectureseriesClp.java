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
import de.uhh.l2g.plugins.service.Producer_LectureseriesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class Producer_LectureseriesClp extends BaseModelImpl<Producer_Lectureseries>
	implements Producer_Lectureseries {
	public Producer_LectureseriesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Producer_Lectureseries.class;
	}

	@Override
	public String getModelClassName() {
		return Producer_Lectureseries.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _producerLectureseries;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProducerLectureseries(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _producerLectureseries;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("producerLectureseries", getProducerLectureseries());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("producerId", getProducerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long producerLectureseries = (Long)attributes.get(
				"producerLectureseries");

		if (producerLectureseries != null) {
			setProducerLectureseries(producerLectureseries);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}
	}

	@Override
	public long getProducerLectureseries() {
		return _producerLectureseries;
	}

	@Override
	public void setProducerLectureseries(long producerLectureseries) {
		_producerLectureseries = producerLectureseries;

		if (_producer_LectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _producer_LectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setProducerLectureseries",
						long.class);

				method.invoke(_producer_LectureseriesRemoteModel,
					producerLectureseries);
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

		if (_producer_LectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _producer_LectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesId", long.class);

				method.invoke(_producer_LectureseriesRemoteModel,
					lectureseriesId);
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

		if (_producer_LectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _producer_LectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setProducerId", long.class);

				method.invoke(_producer_LectureseriesRemoteModel, producerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProducer_LectureseriesRemoteModel() {
		return _producer_LectureseriesRemoteModel;
	}

	public void setProducer_LectureseriesRemoteModel(
		BaseModel<?> producer_LectureseriesRemoteModel) {
		_producer_LectureseriesRemoteModel = producer_LectureseriesRemoteModel;
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

		Class<?> remoteModelClass = _producer_LectureseriesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_producer_LectureseriesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Producer_LectureseriesLocalServiceUtil.addProducer_Lectureseries(this);
		}
		else {
			Producer_LectureseriesLocalServiceUtil.updateProducer_Lectureseries(this);
		}
	}

	@Override
	public Producer_Lectureseries toEscapedModel() {
		return (Producer_Lectureseries)ProxyUtil.newProxyInstance(Producer_Lectureseries.class.getClassLoader(),
			new Class[] { Producer_Lectureseries.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Producer_LectureseriesClp clone = new Producer_LectureseriesClp();

		clone.setProducerLectureseries(getProducerLectureseries());
		clone.setLectureseriesId(getLectureseriesId());
		clone.setProducerId(getProducerId());

		return clone;
	}

	@Override
	public int compareTo(Producer_Lectureseries producer_Lectureseries) {
		long primaryKey = producer_Lectureseries.getPrimaryKey();

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

		if (!(obj instanceof Producer_LectureseriesClp)) {
			return false;
		}

		Producer_LectureseriesClp producer_Lectureseries = (Producer_LectureseriesClp)obj;

		long primaryKey = producer_Lectureseries.getPrimaryKey();

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

		sb.append("{producerLectureseries=");
		sb.append(getProducerLectureseries());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
		sb.append(", producerId=");
		sb.append(getProducerId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Producer_Lectureseries");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>producerLectureseries</column-name><column-value><![CDATA[");
		sb.append(getProducerLectureseries());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>producerId</column-name><column-value><![CDATA[");
		sb.append(getProducerId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _producerLectureseries;
	private long _lectureseriesId;
	private long _producerId;
	private BaseModel<?> _producer_LectureseriesRemoteModel;
}