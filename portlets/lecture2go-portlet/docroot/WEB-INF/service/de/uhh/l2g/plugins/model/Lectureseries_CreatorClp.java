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
import de.uhh.l2g.plugins.service.Lectureseries_CreatorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class Lectureseries_CreatorClp extends BaseModelImpl<Lectureseries_Creator>
	implements Lectureseries_Creator {
	public Lectureseries_CreatorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries_Creator.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries_Creator.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _lectureseriesCreatorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLectureseriesCreatorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lectureseriesCreatorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lectureseriesCreatorId", getLectureseriesCreatorId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("creatorId", getCreatorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesCreatorId = (Long)attributes.get(
				"lectureseriesCreatorId");

		if (lectureseriesCreatorId != null) {
			setLectureseriesCreatorId(lectureseriesCreatorId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}
	}

	@Override
	public long getLectureseriesCreatorId() {
		return _lectureseriesCreatorId;
	}

	@Override
	public void setLectureseriesCreatorId(long lectureseriesCreatorId) {
		_lectureseriesCreatorId = lectureseriesCreatorId;

		if (_lectureseries_CreatorRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseries_CreatorRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesCreatorId",
						long.class);

				method.invoke(_lectureseries_CreatorRemoteModel,
					lectureseriesCreatorId);
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

		if (_lectureseries_CreatorRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseries_CreatorRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesId", long.class);

				method.invoke(_lectureseries_CreatorRemoteModel, lectureseriesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;

		if (_lectureseries_CreatorRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseries_CreatorRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", long.class);

				method.invoke(_lectureseries_CreatorRemoteModel, creatorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLectureseries_CreatorRemoteModel() {
		return _lectureseries_CreatorRemoteModel;
	}

	public void setLectureseries_CreatorRemoteModel(
		BaseModel<?> lectureseries_CreatorRemoteModel) {
		_lectureseries_CreatorRemoteModel = lectureseries_CreatorRemoteModel;
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

		Class<?> remoteModelClass = _lectureseries_CreatorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lectureseries_CreatorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Lectureseries_CreatorLocalServiceUtil.addLectureseries_Creator(this);
		}
		else {
			Lectureseries_CreatorLocalServiceUtil.updateLectureseries_Creator(this);
		}
	}

	@Override
	public Lectureseries_Creator toEscapedModel() {
		return (Lectureseries_Creator)ProxyUtil.newProxyInstance(Lectureseries_Creator.class.getClassLoader(),
			new Class[] { Lectureseries_Creator.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Lectureseries_CreatorClp clone = new Lectureseries_CreatorClp();

		clone.setLectureseriesCreatorId(getLectureseriesCreatorId());
		clone.setLectureseriesId(getLectureseriesId());
		clone.setCreatorId(getCreatorId());

		return clone;
	}

	@Override
	public int compareTo(Lectureseries_Creator lectureseries_Creator) {
		long primaryKey = lectureseries_Creator.getPrimaryKey();

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

		if (!(obj instanceof Lectureseries_CreatorClp)) {
			return false;
		}

		Lectureseries_CreatorClp lectureseries_Creator = (Lectureseries_CreatorClp)obj;

		long primaryKey = lectureseries_Creator.getPrimaryKey();

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

		sb.append("{lectureseriesCreatorId=");
		sb.append(getLectureseriesCreatorId());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Lectureseries_Creator");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lectureseriesCreatorId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesCreatorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creatorId</column-name><column-value><![CDATA[");
		sb.append(getCreatorId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _lectureseriesCreatorId;
	private long _lectureseriesId;
	private long _creatorId;
	private BaseModel<?> _lectureseries_CreatorRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}