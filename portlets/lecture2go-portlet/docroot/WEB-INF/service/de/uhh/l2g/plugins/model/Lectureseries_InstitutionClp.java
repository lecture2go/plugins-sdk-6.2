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
import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class Lectureseries_InstitutionClp extends BaseModelImpl<Lectureseries_Institution>
	implements Lectureseries_Institution {
	public Lectureseries_InstitutionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries_Institution.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries_Institution.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _lectureseriesInstitutionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLectureseriesInstitutionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lectureseriesInstitutionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lectureseriesInstitutionId",
			getLectureseriesInstitutionId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("institutionId", getInstitutionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesInstitutionId = (Long)attributes.get(
				"lectureseriesInstitutionId");

		if (lectureseriesInstitutionId != null) {
			setLectureseriesInstitutionId(lectureseriesInstitutionId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}
	}

	@Override
	public long getLectureseriesInstitutionId() {
		return _lectureseriesInstitutionId;
	}

	@Override
	public void setLectureseriesInstitutionId(long lectureseriesInstitutionId) {
		_lectureseriesInstitutionId = lectureseriesInstitutionId;

		if (_lectureseries_InstitutionRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseries_InstitutionRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesInstitutionId",
						long.class);

				method.invoke(_lectureseries_InstitutionRemoteModel,
					lectureseriesInstitutionId);
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

		if (_lectureseries_InstitutionRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseries_InstitutionRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesId", long.class);

				method.invoke(_lectureseries_InstitutionRemoteModel,
					lectureseriesId);
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

		if (_lectureseries_InstitutionRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseries_InstitutionRemoteModel.getClass();

				Method method = clazz.getMethod("setInstitutionId", long.class);

				method.invoke(_lectureseries_InstitutionRemoteModel,
					institutionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLectureseries_InstitutionRemoteModel() {
		return _lectureseries_InstitutionRemoteModel;
	}

	public void setLectureseries_InstitutionRemoteModel(
		BaseModel<?> lectureseries_InstitutionRemoteModel) {
		_lectureseries_InstitutionRemoteModel = lectureseries_InstitutionRemoteModel;
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

		Class<?> remoteModelClass = _lectureseries_InstitutionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lectureseries_InstitutionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Lectureseries_InstitutionLocalServiceUtil.addLectureseries_Institution(this);
		}
		else {
			Lectureseries_InstitutionLocalServiceUtil.updateLectureseries_Institution(this);
		}
	}

	@Override
	public Lectureseries_Institution toEscapedModel() {
		return (Lectureseries_Institution)ProxyUtil.newProxyInstance(Lectureseries_Institution.class.getClassLoader(),
			new Class[] { Lectureseries_Institution.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Lectureseries_InstitutionClp clone = new Lectureseries_InstitutionClp();

		clone.setLectureseriesInstitutionId(getLectureseriesInstitutionId());
		clone.setLectureseriesId(getLectureseriesId());
		clone.setInstitutionId(getInstitutionId());

		return clone;
	}

	@Override
	public int compareTo(Lectureseries_Institution lectureseries_Institution) {
		long primaryKey = lectureseries_Institution.getPrimaryKey();

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

		if (!(obj instanceof Lectureseries_InstitutionClp)) {
			return false;
		}

		Lectureseries_InstitutionClp lectureseries_Institution = (Lectureseries_InstitutionClp)obj;

		long primaryKey = lectureseries_Institution.getPrimaryKey();

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

		sb.append("{lectureseriesInstitutionId=");
		sb.append(getLectureseriesInstitutionId());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
		sb.append(", institutionId=");
		sb.append(getInstitutionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Lectureseries_Institution");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lectureseriesInstitutionId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesInstitutionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>institutionId</column-name><column-value><![CDATA[");
		sb.append(getInstitutionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _lectureseriesInstitutionId;
	private long _lectureseriesId;
	private long _institutionId;
	private BaseModel<?> _lectureseries_InstitutionRemoteModel;
}