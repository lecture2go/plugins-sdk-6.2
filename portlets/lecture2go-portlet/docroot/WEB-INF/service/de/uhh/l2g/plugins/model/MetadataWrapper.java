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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Metadata}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Metadata
 * @generated
 */
public class MetadataWrapper implements Metadata, ModelWrapper<Metadata> {
	public MetadataWrapper(Metadata metadata) {
		_metadata = metadata;
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

	/**
	* Returns the primary key of this metadata.
	*
	* @return the primary key of this metadata
	*/
	@Override
	public long getPrimaryKey() {
		return _metadata.getPrimaryKey();
	}

	/**
	* Sets the primary key of this metadata.
	*
	* @param primaryKey the primary key of this metadata
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_metadata.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the metadata ID of this metadata.
	*
	* @return the metadata ID of this metadata
	*/
	@Override
	public long getMetadataId() {
		return _metadata.getMetadataId();
	}

	/**
	* Sets the metadata ID of this metadata.
	*
	* @param metadataId the metadata ID of this metadata
	*/
	@Override
	public void setMetadataId(long metadataId) {
		_metadata.setMetadataId(metadataId);
	}

	/**
	* Returns the type of this metadata.
	*
	* @return the type of this metadata
	*/
	@Override
	public java.lang.String getType() {
		return _metadata.getType();
	}

	/**
	* Sets the type of this metadata.
	*
	* @param type the type of this metadata
	*/
	@Override
	public void setType(java.lang.String type) {
		_metadata.setType(type);
	}

	/**
	* Returns the language of this metadata.
	*
	* @return the language of this metadata
	*/
	@Override
	public java.lang.String getLanguage() {
		return _metadata.getLanguage();
	}

	/**
	* Sets the language of this metadata.
	*
	* @param language the language of this metadata
	*/
	@Override
	public void setLanguage(java.lang.String language) {
		_metadata.setLanguage(language);
	}

	/**
	* Returns the title of this metadata.
	*
	* @return the title of this metadata
	*/
	@Override
	public java.lang.String getTitle() {
		return _metadata.getTitle();
	}

	/**
	* Sets the title of this metadata.
	*
	* @param title the title of this metadata
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_metadata.setTitle(title);
	}

	/**
	* Returns the subject of this metadata.
	*
	* @return the subject of this metadata
	*/
	@Override
	public java.lang.String getSubject() {
		return _metadata.getSubject();
	}

	/**
	* Sets the subject of this metadata.
	*
	* @param subject the subject of this metadata
	*/
	@Override
	public void setSubject(java.lang.String subject) {
		_metadata.setSubject(subject);
	}

	/**
	* Returns the description of this metadata.
	*
	* @return the description of this metadata
	*/
	@Override
	public java.lang.String getDescription() {
		return _metadata.getDescription();
	}

	/**
	* Sets the description of this metadata.
	*
	* @param description the description of this metadata
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_metadata.setDescription(description);
	}

	/**
	* Returns the publisher of this metadata.
	*
	* @return the publisher of this metadata
	*/
	@Override
	public java.lang.String getPublisher() {
		return _metadata.getPublisher();
	}

	/**
	* Sets the publisher of this metadata.
	*
	* @param publisher the publisher of this metadata
	*/
	@Override
	public void setPublisher(java.lang.String publisher) {
		_metadata.setPublisher(publisher);
	}

	@Override
	public boolean isNew() {
		return _metadata.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_metadata.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _metadata.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_metadata.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _metadata.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _metadata.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_metadata.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _metadata.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_metadata.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_metadata.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_metadata.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MetadataWrapper((Metadata)_metadata.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Metadata metadata) {
		return _metadata.compareTo(metadata);
	}

	@Override
	public int hashCode() {
		return _metadata.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Metadata> toCacheModel() {
		return _metadata.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Metadata toEscapedModel() {
		return new MetadataWrapper(_metadata.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Metadata toUnescapedModel() {
		return new MetadataWrapper(_metadata.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _metadata.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _metadata.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_metadata.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MetadataWrapper)) {
			return false;
		}

		MetadataWrapper metadataWrapper = (MetadataWrapper)obj;

		if (Validator.equals(_metadata, metadataWrapper._metadata)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Metadata getWrappedMetadata() {
		return _metadata;
	}

	@Override
	public Metadata getWrappedModel() {
		return _metadata;
	}

	@Override
	public void resetOriginalValues() {
		_metadata.resetOriginalValues();
	}

	private Metadata _metadata;
}