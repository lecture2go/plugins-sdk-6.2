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
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class MetadataClp extends BaseModelImpl<Metadata> implements Metadata {
	public MetadataClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Metadata.class;
	}

	@Override
	public String getModelClassName() {
		return Metadata.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _metadataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMetadataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _metadataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metadataId", getMetadataId());
		attributes.put("type", getType());
		attributes.put("language", getLanguage());
		attributes.put("title", getTitle());
		attributes.put("subject", getSubject());
		attributes.put("description", getDescription());
		attributes.put("publisher", getPublisher());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long metadataId = (Long)attributes.get("metadataId");

		if (metadataId != null) {
			setMetadataId(metadataId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String publisher = (String)attributes.get("publisher");

		if (publisher != null) {
			setPublisher(publisher);
		}
	}

	@Override
	public long getMetadataId() {
		return _metadataId;
	}

	@Override
	public void setMetadataId(long metadataId) {
		_metadataId = metadataId;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataId", long.class);

				method.invoke(_metadataRemoteModel, metadataId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_metadataRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLanguage() {
		return _language;
	}

	@Override
	public void setLanguage(String language) {
		_language = language;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguage", String.class);

				method.invoke(_metadataRemoteModel, language);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_metadataRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubject() {
		return _subject;
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setSubject", String.class);

				method.invoke(_metadataRemoteModel, subject);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_metadataRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublisher() {
		return _publisher;
	}

	@Override
	public void setPublisher(String publisher) {
		_publisher = publisher;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setPublisher", String.class);

				method.invoke(_metadataRemoteModel, publisher);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMetadataRemoteModel() {
		return _metadataRemoteModel;
	}

	public void setMetadataRemoteModel(BaseModel<?> metadataRemoteModel) {
		_metadataRemoteModel = metadataRemoteModel;
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

		Class<?> remoteModelClass = _metadataRemoteModel.getClass();

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

		Object returnValue = method.invoke(_metadataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MetadataLocalServiceUtil.addMetadata(this);
		}
		else {
			MetadataLocalServiceUtil.updateMetadata(this);
		}
	}

	@Override
	public Metadata toEscapedModel() {
		return (Metadata)ProxyUtil.newProxyInstance(Metadata.class.getClassLoader(),
			new Class[] { Metadata.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MetadataClp clone = new MetadataClp();

		clone.setMetadataId(getMetadataId());
		clone.setType(getType());
		clone.setLanguage(getLanguage());
		clone.setTitle(getTitle());
		clone.setSubject(getSubject());
		clone.setDescription(getDescription());
		clone.setPublisher(getPublisher());

		return clone;
	}

	@Override
	public int compareTo(Metadata metadata) {
		long primaryKey = metadata.getPrimaryKey();

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

		if (!(obj instanceof MetadataClp)) {
			return false;
		}

		MetadataClp metadata = (MetadataClp)obj;

		long primaryKey = metadata.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{metadataId=");
		sb.append(getMetadataId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", publisher=");
		sb.append(getPublisher());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Metadata");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>metadataId</column-name><column-value><![CDATA[");
		sb.append(getMetadataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publisher</column-name><column-value><![CDATA[");
		sb.append(getPublisher());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _metadataId;
	private String _type;
	private String _language;
	private String _title;
	private String _subject;
	private String _description;
	private String _publisher;
	private BaseModel<?> _metadataRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}