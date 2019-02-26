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
 * This class is a wrapper for {@link Video_Category}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_Category
 * @generated
 */
public class Video_CategoryWrapper implements Video_Category,
	ModelWrapper<Video_Category> {
	public Video_CategoryWrapper(Video_Category video_Category) {
		_video_Category = video_Category;
	}

	@Override
	public Class<?> getModelClass() {
		return Video_Category.class;
	}

	@Override
	public String getModelClassName() {
		return Video_Category.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoCategoryId", getVideoCategoryId());
		attributes.put("videoId", getVideoId());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoCategoryId = (Long)attributes.get("videoCategoryId");

		if (videoCategoryId != null) {
			setVideoCategoryId(videoCategoryId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	/**
	* Returns the primary key of this video_ category.
	*
	* @return the primary key of this video_ category
	*/
	@Override
	public long getPrimaryKey() {
		return _video_Category.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video_ category.
	*
	* @param primaryKey the primary key of this video_ category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_video_Category.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the video category ID of this video_ category.
	*
	* @return the video category ID of this video_ category
	*/
	@Override
	public long getVideoCategoryId() {
		return _video_Category.getVideoCategoryId();
	}

	/**
	* Sets the video category ID of this video_ category.
	*
	* @param videoCategoryId the video category ID of this video_ category
	*/
	@Override
	public void setVideoCategoryId(long videoCategoryId) {
		_video_Category.setVideoCategoryId(videoCategoryId);
	}

	/**
	* Returns the video ID of this video_ category.
	*
	* @return the video ID of this video_ category
	*/
	@Override
	public long getVideoId() {
		return _video_Category.getVideoId();
	}

	/**
	* Sets the video ID of this video_ category.
	*
	* @param videoId the video ID of this video_ category
	*/
	@Override
	public void setVideoId(long videoId) {
		_video_Category.setVideoId(videoId);
	}

	/**
	* Returns the category ID of this video_ category.
	*
	* @return the category ID of this video_ category
	*/
	@Override
	public long getCategoryId() {
		return _video_Category.getCategoryId();
	}

	/**
	* Sets the category ID of this video_ category.
	*
	* @param categoryId the category ID of this video_ category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_video_Category.setCategoryId(categoryId);
	}

	@Override
	public boolean isNew() {
		return _video_Category.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_video_Category.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _video_Category.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_video_Category.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _video_Category.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _video_Category.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_video_Category.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _video_Category.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_video_Category.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_video_Category.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_video_Category.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Video_CategoryWrapper((Video_Category)_video_Category.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Video_Category video_Category) {
		return _video_Category.compareTo(video_Category);
	}

	@Override
	public int hashCode() {
		return _video_Category.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Video_Category> toCacheModel() {
		return _video_Category.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Category toEscapedModel() {
		return new Video_CategoryWrapper(_video_Category.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Category toUnescapedModel() {
		return new Video_CategoryWrapper(_video_Category.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _video_Category.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _video_Category.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_video_Category.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Video_CategoryWrapper)) {
			return false;
		}

		Video_CategoryWrapper video_CategoryWrapper = (Video_CategoryWrapper)obj;

		if (Validator.equals(_video_Category,
					video_CategoryWrapper._video_Category)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Video_Category getWrappedVideo_Category() {
		return _video_Category;
	}

	@Override
	public Video_Category getWrappedModel() {
		return _video_Category;
	}

	@Override
	public void resetOriginalValues() {
		_video_Category.resetOriginalValues();
	}

	private Video_Category _video_Category;
}