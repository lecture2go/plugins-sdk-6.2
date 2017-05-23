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
import de.uhh.l2g.plugins.migration.service.LegacyMetadataLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyMetadataClp extends BaseModelImpl<LegacyMetadata>
	implements LegacyMetadata {
	public LegacyMetadataClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyMetadata.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyMetadata.class.getName();
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
		attributes.put("URLID", getURLID());
		attributes.put("format", getFormat());
		attributes.put("type", getType());
		attributes.put("language", getLanguage());
		attributes.put("title", getTitle());
		attributes.put("subject", getSubject());
		attributes.put("coverage", getCoverage());
		attributes.put("description", getDescription());
		attributes.put("creator", getCreator());
		attributes.put("publisher", getPublisher());
		attributes.put("contributor", getContributor());
		attributes.put("rightsHolder", getRightsHolder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String URLID = (String)attributes.get("URLID");

		if (URLID != null) {
			setURLID(URLID);
		}

		String format = (String)attributes.get("format");

		if (format != null) {
			setFormat(format);
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

		String coverage = (String)attributes.get("coverage");

		if (coverage != null) {
			setCoverage(coverage);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String creator = (String)attributes.get("creator");

		if (creator != null) {
			setCreator(creator);
		}

		String publisher = (String)attributes.get("publisher");

		if (publisher != null) {
			setPublisher(publisher);
		}

		String contributor = (String)attributes.get("contributor");

		if (contributor != null) {
			setContributor(contributor);
		}

		String rightsHolder = (String)attributes.get("rightsHolder");

		if (rightsHolder != null) {
			setRightsHolder(rightsHolder);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_legacyMetadataRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getURLID() {
		return _URLID;
	}

	@Override
	public void setURLID(String URLID) {
		_URLID = URLID;

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setURLID", String.class);

				method.invoke(_legacyMetadataRemoteModel, URLID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormat() {
		return _format;
	}

	@Override
	public void setFormat(String format) {
		_format = format;

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setFormat", String.class);

				method.invoke(_legacyMetadataRemoteModel, format);
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

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_legacyMetadataRemoteModel, type);
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

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguage", String.class);

				method.invoke(_legacyMetadataRemoteModel, language);
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

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_legacyMetadataRemoteModel, title);
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

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setSubject", String.class);

				method.invoke(_legacyMetadataRemoteModel, subject);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCoverage() {
		return _coverage;
	}

	@Override
	public void setCoverage(String coverage) {
		_coverage = coverage;

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setCoverage", String.class);

				method.invoke(_legacyMetadataRemoteModel, coverage);
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

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_legacyMetadataRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreator() {
		return _creator;
	}

	@Override
	public void setCreator(String creator) {
		_creator = creator;

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setCreator", String.class);

				method.invoke(_legacyMetadataRemoteModel, creator);
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

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setPublisher", String.class);

				method.invoke(_legacyMetadataRemoteModel, publisher);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContributor() {
		return _contributor;
	}

	@Override
	public void setContributor(String contributor) {
		_contributor = contributor;

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setContributor", String.class);

				method.invoke(_legacyMetadataRemoteModel, contributor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRightsHolder() {
		return _rightsHolder;
	}

	@Override
	public void setRightsHolder(String rightsHolder) {
		_rightsHolder = rightsHolder;

		if (_legacyMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _legacyMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setRightsHolder", String.class);

				method.invoke(_legacyMetadataRemoteModel, rightsHolder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyMetadataRemoteModel() {
		return _legacyMetadataRemoteModel;
	}

	public void setLegacyMetadataRemoteModel(
		BaseModel<?> legacyMetadataRemoteModel) {
		_legacyMetadataRemoteModel = legacyMetadataRemoteModel;
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

		Class<?> remoteModelClass = _legacyMetadataRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyMetadataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyMetadataLocalServiceUtil.addLegacyMetadata(this);
		}
		else {
			LegacyMetadataLocalServiceUtil.updateLegacyMetadata(this);
		}
	}

	@Override
	public LegacyMetadata toEscapedModel() {
		return (LegacyMetadata)ProxyUtil.newProxyInstance(LegacyMetadata.class.getClassLoader(),
			new Class[] { LegacyMetadata.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyMetadataClp clone = new LegacyMetadataClp();

		clone.setId(getId());
		clone.setURLID(getURLID());
		clone.setFormat(getFormat());
		clone.setType(getType());
		clone.setLanguage(getLanguage());
		clone.setTitle(getTitle());
		clone.setSubject(getSubject());
		clone.setCoverage(getCoverage());
		clone.setDescription(getDescription());
		clone.setCreator(getCreator());
		clone.setPublisher(getPublisher());
		clone.setContributor(getContributor());
		clone.setRightsHolder(getRightsHolder());

		return clone;
	}

	@Override
	public int compareTo(LegacyMetadata legacyMetadata) {
		long primaryKey = legacyMetadata.getPrimaryKey();

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

		if (!(obj instanceof LegacyMetadataClp)) {
			return false;
		}

		LegacyMetadataClp legacyMetadata = (LegacyMetadataClp)obj;

		long primaryKey = legacyMetadata.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", URLID=");
		sb.append(getURLID());
		sb.append(", format=");
		sb.append(getFormat());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", coverage=");
		sb.append(getCoverage());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", creator=");
		sb.append(getCreator());
		sb.append(", publisher=");
		sb.append(getPublisher());
		sb.append(", contributor=");
		sb.append(getContributor());
		sb.append(", rightsHolder=");
		sb.append(getRightsHolder());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyMetadata");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>URLID</column-name><column-value><![CDATA[");
		sb.append(getURLID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>format</column-name><column-value><![CDATA[");
		sb.append(getFormat());
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
			"<column><column-name>coverage</column-name><column-value><![CDATA[");
		sb.append(getCoverage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creator</column-name><column-value><![CDATA[");
		sb.append(getCreator());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publisher</column-name><column-value><![CDATA[");
		sb.append(getPublisher());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contributor</column-name><column-value><![CDATA[");
		sb.append(getContributor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rightsHolder</column-name><column-value><![CDATA[");
		sb.append(getRightsHolder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _URLID;
	private String _format;
	private String _type;
	private String _language;
	private String _title;
	private String _subject;
	private String _coverage;
	private String _description;
	private String _creator;
	private String _publisher;
	private String _contributor;
	private String _rightsHolder;
	private BaseModel<?> _legacyMetadataRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}