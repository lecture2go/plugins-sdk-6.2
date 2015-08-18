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
 * This class is a wrapper for {@link LegacySegment}.
 * </p>
 *
 * @author unihh
 * @see LegacySegment
 * @generated
 */
public class LegacySegmentWrapper implements LegacySegment,
	ModelWrapper<LegacySegment> {
	public LegacySegmentWrapper(LegacySegment legacySegment) {
		_legacySegment = legacySegment;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacySegment.class;
	}

	@Override
	public String getModelClassName() {
		return LegacySegment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("videoId", getVideoId());
		attributes.put("start", getStart());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("end", getEnd());
		attributes.put("chapter", getChapter());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		String start = (String)attributes.get("start");

		if (start != null) {
			setStart(start);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String end = (String)attributes.get("end");

		if (end != null) {
			setEnd(end);
		}

		Integer chapter = (Integer)attributes.get("chapter");

		if (chapter != null) {
			setChapter(chapter);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this legacy segment.
	*
	* @return the primary key of this legacy segment
	*/
	@Override
	public long getPrimaryKey() {
		return _legacySegment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy segment.
	*
	* @param primaryKey the primary key of this legacy segment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacySegment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy segment.
	*
	* @return the ID of this legacy segment
	*/
	@Override
	public long getId() {
		return _legacySegment.getId();
	}

	/**
	* Sets the ID of this legacy segment.
	*
	* @param id the ID of this legacy segment
	*/
	@Override
	public void setId(long id) {
		_legacySegment.setId(id);
	}

	/**
	* Returns the video ID of this legacy segment.
	*
	* @return the video ID of this legacy segment
	*/
	@Override
	public long getVideoId() {
		return _legacySegment.getVideoId();
	}

	/**
	* Sets the video ID of this legacy segment.
	*
	* @param videoId the video ID of this legacy segment
	*/
	@Override
	public void setVideoId(long videoId) {
		_legacySegment.setVideoId(videoId);
	}

	/**
	* Returns the start of this legacy segment.
	*
	* @return the start of this legacy segment
	*/
	@Override
	public java.lang.String getStart() {
		return _legacySegment.getStart();
	}

	/**
	* Sets the start of this legacy segment.
	*
	* @param start the start of this legacy segment
	*/
	@Override
	public void setStart(java.lang.String start) {
		_legacySegment.setStart(start);
	}

	/**
	* Returns the title of this legacy segment.
	*
	* @return the title of this legacy segment
	*/
	@Override
	public java.lang.String getTitle() {
		return _legacySegment.getTitle();
	}

	/**
	* Sets the title of this legacy segment.
	*
	* @param title the title of this legacy segment
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_legacySegment.setTitle(title);
	}

	/**
	* Returns the description of this legacy segment.
	*
	* @return the description of this legacy segment
	*/
	@Override
	public java.lang.String getDescription() {
		return _legacySegment.getDescription();
	}

	/**
	* Sets the description of this legacy segment.
	*
	* @param description the description of this legacy segment
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_legacySegment.setDescription(description);
	}

	/**
	* Returns the end of this legacy segment.
	*
	* @return the end of this legacy segment
	*/
	@Override
	public java.lang.String getEnd() {
		return _legacySegment.getEnd();
	}

	/**
	* Sets the end of this legacy segment.
	*
	* @param end the end of this legacy segment
	*/
	@Override
	public void setEnd(java.lang.String end) {
		_legacySegment.setEnd(end);
	}

	/**
	* Returns the chapter of this legacy segment.
	*
	* @return the chapter of this legacy segment
	*/
	@Override
	public int getChapter() {
		return _legacySegment.getChapter();
	}

	/**
	* Sets the chapter of this legacy segment.
	*
	* @param chapter the chapter of this legacy segment
	*/
	@Override
	public void setChapter(int chapter) {
		_legacySegment.setChapter(chapter);
	}

	/**
	* Returns the user ID of this legacy segment.
	*
	* @return the user ID of this legacy segment
	*/
	@Override
	public long getUserId() {
		return _legacySegment.getUserId();
	}

	/**
	* Sets the user ID of this legacy segment.
	*
	* @param userId the user ID of this legacy segment
	*/
	@Override
	public void setUserId(long userId) {
		_legacySegment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this legacy segment.
	*
	* @return the user uuid of this legacy segment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacySegment.getUserUuid();
	}

	/**
	* Sets the user uuid of this legacy segment.
	*
	* @param userUuid the user uuid of this legacy segment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_legacySegment.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _legacySegment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacySegment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacySegment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacySegment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacySegment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacySegment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacySegment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacySegment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacySegment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacySegment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacySegment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacySegmentWrapper((LegacySegment)_legacySegment.clone());
	}

	@Override
	public int compareTo(LegacySegment legacySegment) {
		return _legacySegment.compareTo(legacySegment);
	}

	@Override
	public int hashCode() {
		return _legacySegment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<LegacySegment> toCacheModel() {
		return _legacySegment.toCacheModel();
	}

	@Override
	public LegacySegment toEscapedModel() {
		return new LegacySegmentWrapper(_legacySegment.toEscapedModel());
	}

	@Override
	public LegacySegment toUnescapedModel() {
		return new LegacySegmentWrapper(_legacySegment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacySegment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacySegment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacySegment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacySegmentWrapper)) {
			return false;
		}

		LegacySegmentWrapper legacySegmentWrapper = (LegacySegmentWrapper)obj;

		if (Validator.equals(_legacySegment, legacySegmentWrapper._legacySegment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacySegment getWrappedLegacySegment() {
		return _legacySegment;
	}

	@Override
	public LegacySegment getWrappedModel() {
		return _legacySegment;
	}

	@Override
	public void resetOriginalValues() {
		_legacySegment.resetOriginalValues();
	}

	private LegacySegment _legacySegment;
}