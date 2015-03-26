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
 * This class is a wrapper for {@link Tagcloud}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Tagcloud
 * @generated
 */
public class TagcloudWrapper implements Tagcloud, ModelWrapper<Tagcloud> {
	public TagcloudWrapper(Tagcloud tagcloud) {
		_tagcloud = tagcloud;
	}

	@Override
	public Class<?> getModelClass() {
		return Tagcloud.class;
	}

	@Override
	public String getModelClassName() {
		return Tagcloud.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagcloudId", getTagcloudId());
		attributes.put("isVideo", getIsVideo());
		attributes.put("isLectureseries", getIsLectureseries());
		attributes.put("tags", getTags());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tagcloudId = (Long)attributes.get("tagcloudId");

		if (tagcloudId != null) {
			setTagcloudId(tagcloudId);
		}

		Integer isVideo = (Integer)attributes.get("isVideo");

		if (isVideo != null) {
			setIsVideo(isVideo);
		}

		Integer isLectureseries = (Integer)attributes.get("isLectureseries");

		if (isLectureseries != null) {
			setIsLectureseries(isLectureseries);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
		}
	}

	/**
	* Returns the primary key of this tagcloud.
	*
	* @return the primary key of this tagcloud
	*/
	@Override
	public long getPrimaryKey() {
		return _tagcloud.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tagcloud.
	*
	* @param primaryKey the primary key of this tagcloud
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tagcloud.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tagcloud ID of this tagcloud.
	*
	* @return the tagcloud ID of this tagcloud
	*/
	@Override
	public long getTagcloudId() {
		return _tagcloud.getTagcloudId();
	}

	/**
	* Sets the tagcloud ID of this tagcloud.
	*
	* @param tagcloudId the tagcloud ID of this tagcloud
	*/
	@Override
	public void setTagcloudId(long tagcloudId) {
		_tagcloud.setTagcloudId(tagcloudId);
	}

	/**
	* Returns the is video of this tagcloud.
	*
	* @return the is video of this tagcloud
	*/
	@Override
	public int getIsVideo() {
		return _tagcloud.getIsVideo();
	}

	/**
	* Sets the is video of this tagcloud.
	*
	* @param isVideo the is video of this tagcloud
	*/
	@Override
	public void setIsVideo(int isVideo) {
		_tagcloud.setIsVideo(isVideo);
	}

	/**
	* Returns the is lectureseries of this tagcloud.
	*
	* @return the is lectureseries of this tagcloud
	*/
	@Override
	public int getIsLectureseries() {
		return _tagcloud.getIsLectureseries();
	}

	/**
	* Sets the is lectureseries of this tagcloud.
	*
	* @param isLectureseries the is lectureseries of this tagcloud
	*/
	@Override
	public void setIsLectureseries(int isLectureseries) {
		_tagcloud.setIsLectureseries(isLectureseries);
	}

	/**
	* Returns the tags of this tagcloud.
	*
	* @return the tags of this tagcloud
	*/
	@Override
	public java.lang.String getTags() {
		return _tagcloud.getTags();
	}

	/**
	* Sets the tags of this tagcloud.
	*
	* @param tags the tags of this tagcloud
	*/
	@Override
	public void setTags(java.lang.String tags) {
		_tagcloud.setTags(tags);
	}

	@Override
	public boolean isNew() {
		return _tagcloud.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tagcloud.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tagcloud.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tagcloud.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tagcloud.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tagcloud.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tagcloud.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tagcloud.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tagcloud.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tagcloud.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tagcloud.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TagcloudWrapper((Tagcloud)_tagcloud.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Tagcloud tagcloud) {
		return _tagcloud.compareTo(tagcloud);
	}

	@Override
	public int hashCode() {
		return _tagcloud.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Tagcloud> toCacheModel() {
		return _tagcloud.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Tagcloud toEscapedModel() {
		return new TagcloudWrapper(_tagcloud.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Tagcloud toUnescapedModel() {
		return new TagcloudWrapper(_tagcloud.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tagcloud.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tagcloud.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tagcloud.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TagcloudWrapper)) {
			return false;
		}

		TagcloudWrapper tagcloudWrapper = (TagcloudWrapper)obj;

		if (Validator.equals(_tagcloud, tagcloudWrapper._tagcloud)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Tagcloud getWrappedTagcloud() {
		return _tagcloud;
	}

	@Override
	public Tagcloud getWrappedModel() {
		return _tagcloud;
	}

	@Override
	public void resetOriginalValues() {
		_tagcloud.resetOriginalValues();
	}

	private Tagcloud _tagcloud;
}