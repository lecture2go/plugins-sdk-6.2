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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegacyMetadata}.
 * </p>
 *
 * @author unihh
 * @see LegacyMetadata
 * @generated
 */
public class LegacyMetadataWrapper implements LegacyMetadata,
	ModelWrapper<LegacyMetadata> {
	public LegacyMetadataWrapper(LegacyMetadata legacyMetadata) {
		_legacyMetadata = legacyMetadata;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("URLID", getURLID());
		attributes.put("format", getFormat());
		attributes.put("type", getType());
		attributes.put("language", getLanguage());
		attributes.put("title", getTitle());
		attributes.put("subject", getSubject());
		attributes.put("description", getDescription());
		attributes.put("publisher", getPublisher());
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String publisher = (String)attributes.get("publisher");

		if (publisher != null) {
			setPublisher(publisher);
		}

		String rightsHolder = (String)attributes.get("rightsHolder");

		if (rightsHolder != null) {
			setRightsHolder(rightsHolder);
		}
	}

	/**
	* Returns the primary key of this legacy metadata.
	*
	* @return the primary key of this legacy metadata
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyMetadata.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy metadata.
	*
	* @param primaryKey the primary key of this legacy metadata
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyMetadata.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy metadata.
	*
	* @return the ID of this legacy metadata
	*/
	@Override
	public long getId() {
		return _legacyMetadata.getId();
	}

	/**
	* Sets the ID of this legacy metadata.
	*
	* @param id the ID of this legacy metadata
	*/
	@Override
	public void setId(long id) {
		_legacyMetadata.setId(id);
	}

	/**
	* Returns the u r l i d of this legacy metadata.
	*
	* @return the u r l i d of this legacy metadata
	*/
	@Override
	public java.lang.String getURLID() {
		return _legacyMetadata.getURLID();
	}

	/**
	* Sets the u r l i d of this legacy metadata.
	*
	* @param URLID the u r l i d of this legacy metadata
	*/
	@Override
	public void setURLID(java.lang.String URLID) {
		_legacyMetadata.setURLID(URLID);
	}

	/**
	* Returns the format of this legacy metadata.
	*
	* @return the format of this legacy metadata
	*/
	@Override
	public java.lang.String getFormat() {
		return _legacyMetadata.getFormat();
	}

	/**
	* Sets the format of this legacy metadata.
	*
	* @param format the format of this legacy metadata
	*/
	@Override
	public void setFormat(java.lang.String format) {
		_legacyMetadata.setFormat(format);
	}

	/**
	* Returns the type of this legacy metadata.
	*
	* @return the type of this legacy metadata
	*/
	@Override
	public java.lang.String getType() {
		return _legacyMetadata.getType();
	}

	/**
	* Sets the type of this legacy metadata.
	*
	* @param type the type of this legacy metadata
	*/
	@Override
	public void setType(java.lang.String type) {
		_legacyMetadata.setType(type);
	}

	/**
	* Returns the language of this legacy metadata.
	*
	* @return the language of this legacy metadata
	*/
	@Override
	public java.lang.String getLanguage() {
		return _legacyMetadata.getLanguage();
	}

	/**
	* Sets the language of this legacy metadata.
	*
	* @param language the language of this legacy metadata
	*/
	@Override
	public void setLanguage(java.lang.String language) {
		_legacyMetadata.setLanguage(language);
	}

	/**
	* Returns the title of this legacy metadata.
	*
	* @return the title of this legacy metadata
	*/
	@Override
	public java.lang.String getTitle() {
		return _legacyMetadata.getTitle();
	}

	/**
	* Sets the title of this legacy metadata.
	*
	* @param title the title of this legacy metadata
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_legacyMetadata.setTitle(title);
	}

	/**
	* Returns the subject of this legacy metadata.
	*
	* @return the subject of this legacy metadata
	*/
	@Override
	public java.lang.String getSubject() {
		return _legacyMetadata.getSubject();
	}

	/**
	* Sets the subject of this legacy metadata.
	*
	* @param subject the subject of this legacy metadata
	*/
	@Override
	public void setSubject(java.lang.String subject) {
		_legacyMetadata.setSubject(subject);
	}

	/**
	* Returns the description of this legacy metadata.
	*
	* @return the description of this legacy metadata
	*/
	@Override
	public java.lang.String getDescription() {
		return _legacyMetadata.getDescription();
	}

	/**
	* Sets the description of this legacy metadata.
	*
	* @param description the description of this legacy metadata
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_legacyMetadata.setDescription(description);
	}

	/**
	* Returns the publisher of this legacy metadata.
	*
	* @return the publisher of this legacy metadata
	*/
	@Override
	public java.lang.String getPublisher() {
		return _legacyMetadata.getPublisher();
	}

	/**
	* Sets the publisher of this legacy metadata.
	*
	* @param publisher the publisher of this legacy metadata
	*/
	@Override
	public void setPublisher(java.lang.String publisher) {
		_legacyMetadata.setPublisher(publisher);
	}

	/**
	* Returns the rights holder of this legacy metadata.
	*
	* @return the rights holder of this legacy metadata
	*/
	@Override
	public java.lang.String getRightsHolder() {
		return _legacyMetadata.getRightsHolder();
	}

	/**
	* Sets the rights holder of this legacy metadata.
	*
	* @param rightsHolder the rights holder of this legacy metadata
	*/
	@Override
	public void setRightsHolder(java.lang.String rightsHolder) {
		_legacyMetadata.setRightsHolder(rightsHolder);
	}

	@Override
	public boolean isNew() {
		return _legacyMetadata.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyMetadata.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyMetadata.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyMetadata.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyMetadata.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyMetadata.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyMetadata.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyMetadata.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyMetadata.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyMetadata.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyMetadata.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyMetadataWrapper((LegacyMetadata)_legacyMetadata.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyMetadata legacyMetadata) {
		return _legacyMetadata.compareTo(legacyMetadata);
	}

	@Override
	public int hashCode() {
		return _legacyMetadata.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyMetadata> toCacheModel() {
		return _legacyMetadata.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata toEscapedModel() {
		return new LegacyMetadataWrapper(_legacyMetadata.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata toUnescapedModel() {
		return new LegacyMetadataWrapper(_legacyMetadata.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyMetadata.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyMetadata.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyMetadata.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyMetadataWrapper)) {
			return false;
		}

		LegacyMetadataWrapper legacyMetadataWrapper = (LegacyMetadataWrapper)obj;

		if (Validator.equals(_legacyMetadata,
					legacyMetadataWrapper._legacyMetadata)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyMetadata getWrappedLegacyMetadata() {
		return _legacyMetadata;
	}

	@Override
	public LegacyMetadata getWrappedModel() {
		return _legacyMetadata;
	}

	@Override
	public void resetOriginalValues() {
		_legacyMetadata.resetOriginalValues();
	}

	private LegacyMetadata _legacyMetadata;
}