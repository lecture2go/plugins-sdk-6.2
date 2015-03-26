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
 * This class is a wrapper for {@link Tags}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Tags
 * @generated
 */
public class TagsWrapper implements Tags, ModelWrapper<Tags> {
	public TagsWrapper(Tags tags) {
		_tags = tags;
	}

	@Override
	public Class<?> getModelClass() {
		return Tags.class;
	}

	@Override
	public String getModelClassName() {
		return Tags.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagId", getTagId());
		attributes.put("isVideo", getIsVideo());
		attributes.put("isLectureseries", getIsLectureseries());
		attributes.put("tags", getTags());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
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
	* Returns the primary key of this tags.
	*
	* @return the primary key of this tags
	*/
	@Override
	public long getPrimaryKey() {
		return _tags.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tags.
	*
	* @param primaryKey the primary key of this tags
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tags.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tag ID of this tags.
	*
	* @return the tag ID of this tags
	*/
	@Override
	public long getTagId() {
		return _tags.getTagId();
	}

	/**
	* Sets the tag ID of this tags.
	*
	* @param tagId the tag ID of this tags
	*/
	@Override
	public void setTagId(long tagId) {
		_tags.setTagId(tagId);
	}

	/**
	* Returns the is video of this tags.
	*
	* @return the is video of this tags
	*/
	@Override
	public int getIsVideo() {
		return _tags.getIsVideo();
	}

	/**
	* Sets the is video of this tags.
	*
	* @param isVideo the is video of this tags
	*/
	@Override
	public void setIsVideo(int isVideo) {
		_tags.setIsVideo(isVideo);
	}

	/**
	* Returns the is lectureseries of this tags.
	*
	* @return the is lectureseries of this tags
	*/
	@Override
	public int getIsLectureseries() {
		return _tags.getIsLectureseries();
	}

	/**
	* Sets the is lectureseries of this tags.
	*
	* @param isLectureseries the is lectureseries of this tags
	*/
	@Override
	public void setIsLectureseries(int isLectureseries) {
		_tags.setIsLectureseries(isLectureseries);
	}

	/**
	* Returns the tags of this tags.
	*
	* @return the tags of this tags
	*/
	@Override
	public java.lang.String getTags() {
		return _tags.getTags();
	}

	/**
	* Sets the tags of this tags.
	*
	* @param tags the tags of this tags
	*/
	@Override
	public void setTags(java.lang.String tags) {
		_tags.setTags(tags);
	}

	@Override
	public boolean isNew() {
		return _tags.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tags.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tags.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tags.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tags.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tags.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tags.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tags.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tags.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tags.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tags.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TagsWrapper((Tags)_tags.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Tags tags) {
		return _tags.compareTo(tags);
	}

	@Override
	public int hashCode() {
		return _tags.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Tags> toCacheModel() {
		return _tags.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Tags toEscapedModel() {
		return new TagsWrapper(_tags.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Tags toUnescapedModel() {
		return new TagsWrapper(_tags.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tags.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tags.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tags.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TagsWrapper)) {
			return false;
		}

		TagsWrapper tagsWrapper = (TagsWrapper)obj;

		if (Validator.equals(_tags, tagsWrapper._tags)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Tags getWrappedTags() {
		return _tags;
	}

	@Override
	public Tags getWrappedModel() {
		return _tags;
	}

	@Override
	public void resetOriginalValues() {
		_tags.resetOriginalValues();
	}

	private Tags _tags;
}