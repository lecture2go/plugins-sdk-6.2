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
import de.uhh.l2g.plugins.service.Lectureseries_CategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class Lectureseries_CategoryClp extends BaseModelImpl<Lectureseries_Category>
	implements Lectureseries_Category {
	public Lectureseries_CategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries_Category.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries_Category.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _lectureseriesCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLectureseriesCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lectureseriesCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lectureseriesCategoryId", getLectureseriesCategoryId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("lectureseriesId", getLectureseriesId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesCategoryId = (Long)attributes.get(
				"lectureseriesCategoryId");

		if (lectureseriesCategoryId != null) {
			setLectureseriesCategoryId(lectureseriesCategoryId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}
	}

	@Override
	public long getLectureseriesCategoryId() {
		return _lectureseriesCategoryId;
	}

	@Override
	public void setLectureseriesCategoryId(long lectureseriesCategoryId) {
		_lectureseriesCategoryId = lectureseriesCategoryId;

		if (_lectureseries_CategoryRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseries_CategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesCategoryId",
						long.class);

				method.invoke(_lectureseries_CategoryRemoteModel,
					lectureseriesCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_lectureseries_CategoryRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseries_CategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_lectureseries_CategoryRemoteModel, categoryId);
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

		if (_lectureseries_CategoryRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseries_CategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesId", long.class);

				method.invoke(_lectureseries_CategoryRemoteModel,
					lectureseriesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLectureseries_CategoryRemoteModel() {
		return _lectureseries_CategoryRemoteModel;
	}

	public void setLectureseries_CategoryRemoteModel(
		BaseModel<?> lectureseries_CategoryRemoteModel) {
		_lectureseries_CategoryRemoteModel = lectureseries_CategoryRemoteModel;
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

		Class<?> remoteModelClass = _lectureseries_CategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lectureseries_CategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Lectureseries_CategoryLocalServiceUtil.addLectureseries_Category(this);
		}
		else {
			Lectureseries_CategoryLocalServiceUtil.updateLectureseries_Category(this);
		}
	}

	@Override
	public Lectureseries_Category toEscapedModel() {
		return (Lectureseries_Category)ProxyUtil.newProxyInstance(Lectureseries_Category.class.getClassLoader(),
			new Class[] { Lectureseries_Category.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Lectureseries_CategoryClp clone = new Lectureseries_CategoryClp();

		clone.setLectureseriesCategoryId(getLectureseriesCategoryId());
		clone.setCategoryId(getCategoryId());
		clone.setLectureseriesId(getLectureseriesId());

		return clone;
	}

	@Override
	public int compareTo(Lectureseries_Category lectureseries_Category) {
		long primaryKey = lectureseries_Category.getPrimaryKey();

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

		if (!(obj instanceof Lectureseries_CategoryClp)) {
			return false;
		}

		Lectureseries_CategoryClp lectureseries_Category = (Lectureseries_CategoryClp)obj;

		long primaryKey = lectureseries_Category.getPrimaryKey();

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

		sb.append("{lectureseriesCategoryId=");
		sb.append(getLectureseriesCategoryId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Lectureseries_Category");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lectureseriesCategoryId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _lectureseriesCategoryId;
	private long _categoryId;
	private long _lectureseriesId;
	private BaseModel<?> _lectureseries_CategoryRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}