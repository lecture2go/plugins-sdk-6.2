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
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class TermClp extends BaseModelImpl<Term> implements Term {
	public TermClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Term.class;
	}

	@Override
	public String getModelClassName() {
		return Term.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _termId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTermId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _termId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("termId", getTermId());
		attributes.put("parentId", getParentId());
		attributes.put("languageId", getLanguageId());
		attributes.put("prefix", getPrefix());
		attributes.put("year", getYear());
		attributes.put("translation", getTranslation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
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

		String year = (String)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String translation = (String)attributes.get("translation");

		if (translation != null) {
			setTranslation(translation);
		}
	}

	@Override
	public long getTermId() {
		return _termId;
	}

	@Override
	public void setTermId(long termId) {
		_termId = termId;

		if (_termRemoteModel != null) {
			try {
				Class<?> clazz = _termRemoteModel.getClass();

				Method method = clazz.getMethod("setTermId", long.class);

				method.invoke(_termRemoteModel, termId);
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

		if (_termRemoteModel != null) {
			try {
				Class<?> clazz = _termRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_termRemoteModel, parentId);
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

		if (_termRemoteModel != null) {
			try {
				Class<?> clazz = _termRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageId", String.class);

				method.invoke(_termRemoteModel, languageId);
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

		if (_termRemoteModel != null) {
			try {
				Class<?> clazz = _termRemoteModel.getClass();

				Method method = clazz.getMethod("setPrefix", String.class);

				method.invoke(_termRemoteModel, prefix);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYear() {
		return _year;
	}

	@Override
	public void setYear(String year) {
		_year = year;

		if (_termRemoteModel != null) {
			try {
				Class<?> clazz = _termRemoteModel.getClass();

				Method method = clazz.getMethod("setYear", String.class);

				method.invoke(_termRemoteModel, year);
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

		if (_termRemoteModel != null) {
			try {
				Class<?> clazz = _termRemoteModel.getClass();

				Method method = clazz.getMethod("setTranslation", String.class);

				method.invoke(_termRemoteModel, translation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setFullName(java.lang.String fullName) {
		try {
			String methodName = "setFullName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { fullName };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getFullName() {
		try {
			String methodName = "getFullName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getTermName() {
		try {
			String methodName = "getTermName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getTermRemoteModel() {
		return _termRemoteModel;
	}

	public void setTermRemoteModel(BaseModel<?> termRemoteModel) {
		_termRemoteModel = termRemoteModel;
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

		Class<?> remoteModelClass = _termRemoteModel.getClass();

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

		Object returnValue = method.invoke(_termRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TermLocalServiceUtil.addTerm(this);
		}
		else {
			TermLocalServiceUtil.updateTerm(this);
		}
	}

	@Override
	public Term toEscapedModel() {
		return (Term)ProxyUtil.newProxyInstance(Term.class.getClassLoader(),
			new Class[] { Term.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TermClp clone = new TermClp();

		clone.setTermId(getTermId());
		clone.setParentId(getParentId());
		clone.setLanguageId(getLanguageId());
		clone.setPrefix(getPrefix());
		clone.setYear(getYear());
		clone.setTranslation(getTranslation());

		return clone;
	}

	@Override
	public int compareTo(Term term) {
		int value = 0;

		value = getYear().compareTo(term.getYear());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TermClp)) {
			return false;
		}

		TermClp term = (TermClp)obj;

		long primaryKey = term.getPrimaryKey();

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

		sb.append("{termId=");
		sb.append(getTermId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", prefix=");
		sb.append(getPrefix());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", translation=");
		sb.append(getTranslation());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Term");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>termId</column-name><column-value><![CDATA[");
		sb.append(getTermId());
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
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>translation</column-name><column-value><![CDATA[");
		sb.append(getTranslation());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _termId;
	private long _parentId;
	private String _languageId;
	private String _prefix;
	private String _year;
	private String _translation;
	private BaseModel<?> _termRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}