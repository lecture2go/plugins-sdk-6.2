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
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
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
		attributes.put("rights", getRights());
		attributes.put("provenance", getProvenance());
		attributes.put("source", getSource());
		attributes.put("relation", getRelation());
		attributes.put("audience", getAudience());
		attributes.put("instructionalMethods", getInstructionalMethods());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long metadataId = (Long)attributes.get("metadataId");

		if (metadataId != null) {
			setMetadataId(metadataId);
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

		String rights = (String)attributes.get("rights");

		if (rights != null) {
			setRights(rights);
		}

		String provenance = (String)attributes.get("provenance");

		if (provenance != null) {
			setProvenance(provenance);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		String relation = (String)attributes.get("relation");

		if (relation != null) {
			setRelation(relation);
		}

		String audience = (String)attributes.get("audience");

		if (audience != null) {
			setAudience(audience);
		}

		String instructionalMethods = (String)attributes.get(
				"instructionalMethods");

		if (instructionalMethods != null) {
			setInstructionalMethods(instructionalMethods);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
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
	public String getURLID() {
		return _URLID;
	}

	@Override
	public void setURLID(String URLID) {
		_URLID = URLID;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setURLID", String.class);

				method.invoke(_metadataRemoteModel, URLID);
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

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setFormat", String.class);

				method.invoke(_metadataRemoteModel, format);
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
	public String getCoverage() {
		return _coverage;
	}

	@Override
	public void setCoverage(String coverage) {
		_coverage = coverage;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setCoverage", String.class);

				method.invoke(_metadataRemoteModel, coverage);
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
	public String getCreator() {
		return _creator;
	}

	@Override
	public void setCreator(String creator) {
		_creator = creator;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setCreator", String.class);

				method.invoke(_metadataRemoteModel, creator);
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

	@Override
	public String getContributor() {
		return _contributor;
	}

	@Override
	public void setContributor(String contributor) {
		_contributor = contributor;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setContributor", String.class);

				method.invoke(_metadataRemoteModel, contributor);
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

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setRightsHolder", String.class);

				method.invoke(_metadataRemoteModel, rightsHolder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRights() {
		return _rights;
	}

	@Override
	public void setRights(String rights) {
		_rights = rights;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setRights", String.class);

				method.invoke(_metadataRemoteModel, rights);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProvenance() {
		return _provenance;
	}

	@Override
	public void setProvenance(String provenance) {
		_provenance = provenance;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setProvenance", String.class);

				method.invoke(_metadataRemoteModel, provenance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSource() {
		return _source;
	}

	@Override
	public void setSource(String source) {
		_source = source;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setSource", String.class);

				method.invoke(_metadataRemoteModel, source);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRelation() {
		return _relation;
	}

	@Override
	public void setRelation(String relation) {
		_relation = relation;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setRelation", String.class);

				method.invoke(_metadataRemoteModel, relation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAudience() {
		return _audience;
	}

	@Override
	public void setAudience(String audience) {
		_audience = audience;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setAudience", String.class);

				method.invoke(_metadataRemoteModel, audience);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInstructionalMethods() {
		return _instructionalMethods;
	}

	@Override
	public void setInstructionalMethods(String instructionalMethods) {
		_instructionalMethods = instructionalMethods;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setInstructionalMethods",
						String.class);

				method.invoke(_metadataRemoteModel, instructionalMethods);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;

		if (_metadataRemoteModel != null) {
			try {
				Class<?> clazz = _metadataRemoteModel.getClass();

				Method method = clazz.getMethod("setDate", Date.class);

				method.invoke(_metadataRemoteModel, date);
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
		clone.setRights(getRights());
		clone.setProvenance(getProvenance());
		clone.setSource(getSource());
		clone.setRelation(getRelation());
		clone.setAudience(getAudience());
		clone.setInstructionalMethods(getInstructionalMethods());
		clone.setDate(getDate());

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

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{metadataId=");
		sb.append(getMetadataId());
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
		sb.append(", rights=");
		sb.append(getRights());
		sb.append(", provenance=");
		sb.append(getProvenance());
		sb.append(", source=");
		sb.append(getSource());
		sb.append(", relation=");
		sb.append(getRelation());
		sb.append(", audience=");
		sb.append(getAudience());
		sb.append(", instructionalMethods=");
		sb.append(getInstructionalMethods());
		sb.append(", date=");
		sb.append(getDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Metadata");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>metadataId</column-name><column-value><![CDATA[");
		sb.append(getMetadataId());
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
		sb.append(
			"<column><column-name>rights</column-name><column-value><![CDATA[");
		sb.append(getRights());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>provenance</column-name><column-value><![CDATA[");
		sb.append(getProvenance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>source</column-name><column-value><![CDATA[");
		sb.append(getSource());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>relation</column-name><column-value><![CDATA[");
		sb.append(getRelation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>audience</column-name><column-value><![CDATA[");
		sb.append(getAudience());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>instructionalMethods</column-name><column-value><![CDATA[");
		sb.append(getInstructionalMethods());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _metadataId;
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
	private String _rights;
	private String _provenance;
	private String _source;
	private String _relation;
	private String _audience;
	private String _instructionalMethods;
	private Date _date;
	private BaseModel<?> _metadataRemoteModel;
}