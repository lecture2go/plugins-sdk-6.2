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

import de.uhh.l2g.plugins.service.AutocompleteLocalServiceUtil;
import de.uhh.l2g.plugins.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class AutocompleteClp extends BaseModelImpl<Autocomplete>
	implements Autocomplete {
	public AutocompleteClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Autocomplete.class;
	}

	@Override
	public String getModelClassName() {
		return Autocomplete.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _autocompleteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAutocompleteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _autocompleteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("autocompleteId", getAutocompleteId());
		attributes.put("searchWordsJson", getSearchWordsJson());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long autocompleteId = (Long)attributes.get("autocompleteId");

		if (autocompleteId != null) {
			setAutocompleteId(autocompleteId);
		}

		String searchWordsJson = (String)attributes.get("searchWordsJson");

		if (searchWordsJson != null) {
			setSearchWordsJson(searchWordsJson);
		}
	}

	@Override
	public long getAutocompleteId() {
		return _autocompleteId;
	}

	@Override
	public void setAutocompleteId(long autocompleteId) {
		_autocompleteId = autocompleteId;

		if (_autocompleteRemoteModel != null) {
			try {
				Class<?> clazz = _autocompleteRemoteModel.getClass();

				Method method = clazz.getMethod("setAutocompleteId", long.class);

				method.invoke(_autocompleteRemoteModel, autocompleteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSearchWordsJson() {
		return _searchWordsJson;
	}

	@Override
	public void setSearchWordsJson(String searchWordsJson) {
		_searchWordsJson = searchWordsJson;

		if (_autocompleteRemoteModel != null) {
			try {
				Class<?> clazz = _autocompleteRemoteModel.getClass();

				Method method = clazz.getMethod("setSearchWordsJson",
						String.class);

				method.invoke(_autocompleteRemoteModel, searchWordsJson);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAutocompleteRemoteModel() {
		return _autocompleteRemoteModel;
	}

	public void setAutocompleteRemoteModel(BaseModel<?> autocompleteRemoteModel) {
		_autocompleteRemoteModel = autocompleteRemoteModel;
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

		Class<?> remoteModelClass = _autocompleteRemoteModel.getClass();

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

		Object returnValue = method.invoke(_autocompleteRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AutocompleteLocalServiceUtil.addAutocomplete(this);
		}
		else {
			AutocompleteLocalServiceUtil.updateAutocomplete(this);
		}
	}

	@Override
	public Autocomplete toEscapedModel() {
		return (Autocomplete)ProxyUtil.newProxyInstance(Autocomplete.class.getClassLoader(),
			new Class[] { Autocomplete.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AutocompleteClp clone = new AutocompleteClp();

		clone.setAutocompleteId(getAutocompleteId());
		clone.setSearchWordsJson(getSearchWordsJson());

		return clone;
	}

	@Override
	public int compareTo(Autocomplete autocomplete) {
		long primaryKey = autocomplete.getPrimaryKey();

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

		if (!(obj instanceof AutocompleteClp)) {
			return false;
		}

		AutocompleteClp autocomplete = (AutocompleteClp)obj;

		long primaryKey = autocomplete.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{autocompleteId=");
		sb.append(getAutocompleteId());
		sb.append(", searchWordsJson=");
		sb.append(getSearchWordsJson());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Autocomplete");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>autocompleteId</column-name><column-value><![CDATA[");
		sb.append(getAutocompleteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>searchWordsJson</column-name><column-value><![CDATA[");
		sb.append(getSearchWordsJson());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _autocompleteId;
	private String _searchWordsJson;
	private BaseModel<?> _autocompleteRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}