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
import de.uhh.l2g.plugins.service.YearLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class YearClp extends BaseModelImpl<Year> implements Year {
	public YearClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Year.class;
	}

	@Override
	public String getModelClassName() {
		return Year.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _yearId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setYearId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _yearId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("yearId", getYearId());
		attributes.put("parentId", getParentId());
		attributes.put("languageId", getLanguageId());
		attributes.put("prefix", getPrefix());
		attributes.put("name", getName());
		attributes.put("translation", getTranslation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long yearId = (Long)attributes.get("yearId");

		if (yearId != null) {
			setYearId(yearId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String prefix = (String)attributes.get("prefix");

		if (prefix != null) {
			setPrefix(prefix);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String translation = (String)attributes.get("translation");

		if (translation != null) {
			setTranslation(translation);
		}
	}

	@Override
	public long getYearId() {
		return _yearId;
	}

	@Override
	public void setYearId(long yearId) {
		_yearId = yearId;

		if (_yearRemoteModel != null) {
			try {
				Class<?> clazz = _yearRemoteModel.getClass();

				Method method = clazz.getMethod("setYearId", long.class);

				method.invoke(_yearRemoteModel, yearId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_yearRemoteModel != null) {
			try {
				Class<?> clazz = _yearRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_yearRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLanguageId() {
		return _languageId;
	}

	@Override
	public void setLanguageId(String languageId) {
		_languageId = languageId;

		if (_yearRemoteModel != null) {
			try {
				Class<?> clazz = _yearRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageId", String.class);

				method.invoke(_yearRemoteModel, languageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrefix() {
		return _prefix;
	}

	@Override
	public void setPrefix(String prefix) {
		_prefix = prefix;

		if (_yearRemoteModel != null) {
			try {
				Class<?> clazz = _yearRemoteModel.getClass();

				Method method = clazz.getMethod("setPrefix", String.class);

				method.invoke(_yearRemoteModel, prefix);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_yearRemoteModel != null) {
			try {
				Class<?> clazz = _yearRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_yearRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTranslation() {
		return _translation;
	}

	@Override
	public void setTranslation(String translation) {
		_translation = translation;

		if (_yearRemoteModel != null) {
			try {
				Class<?> clazz = _yearRemoteModel.getClass();

				Method method = clazz.getMethod("setTranslation", String.class);

				method.invoke(_yearRemoteModel, translation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getYearRemoteModel() {
		return _yearRemoteModel;
	}

	public void setYearRemoteModel(BaseModel<?> yearRemoteModel) {
		_yearRemoteModel = yearRemoteModel;
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

		Class<?> remoteModelClass = _yearRemoteModel.getClass();

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

		Object returnValue = method.invoke(_yearRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			YearLocalServiceUtil.addYear(this);
		}
		else {
			YearLocalServiceUtil.updateYear(this);
		}
	}

	@Override
	public Year toEscapedModel() {
		return (Year)ProxyUtil.newProxyInstance(Year.class.getClassLoader(),
			new Class[] { Year.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		YearClp clone = new YearClp();

		clone.setYearId(getYearId());
		clone.setParentId(getParentId());
		clone.setLanguageId(getLanguageId());
		clone.setPrefix(getPrefix());
		clone.setName(getName());
		clone.setTranslation(getTranslation());

		return clone;
	}

	@Override
	public int compareTo(Year year) {
		long primaryKey = year.getPrimaryKey();

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

		if (!(obj instanceof YearClp)) {
			return false;
		}

		YearClp year = (YearClp)obj;

		long primaryKey = year.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{yearId=");
		sb.append(getYearId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", prefix=");
		sb.append(getPrefix());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", translation=");
		sb.append(getTranslation());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Year");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>yearId</column-name><column-value><![CDATA[");
		sb.append(getYearId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prefix</column-name><column-value><![CDATA[");
		sb.append(getPrefix());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>translation</column-name><column-value><![CDATA[");
		sb.append(getTranslation());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _yearId;
	private long _parentId;
	private String _languageId;
	private String _prefix;
	private String _name;
	private String _translation;
	private BaseModel<?> _yearRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}