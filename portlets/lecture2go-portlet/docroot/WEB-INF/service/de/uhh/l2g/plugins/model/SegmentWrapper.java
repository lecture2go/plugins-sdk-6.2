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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Segment}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Segment
 * @generated
 */
public class SegmentWrapper implements Segment, ModelWrapper<Segment> {
	public SegmentWrapper(Segment segment) {
		_segment = segment;
	}

	@Override
	public Class<?> getModelClass() {
		return Segment.class;
	}

	@Override
	public String getModelClassName() {
		return Segment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("segmentId", getSegmentId());
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
		Long segmentId = (Long)attributes.get("segmentId");

		if (segmentId != null) {
			setSegmentId(segmentId);
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
	* Returns the primary key of this segment.
	*
	* @return the primary key of this segment
	*/
	@Override
	public long getPrimaryKey() {
		return _segment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this segment.
	*
	* @param primaryKey the primary key of this segment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_segment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the segment ID of this segment.
	*
	* @return the segment ID of this segment
	*/
	@Override
	public long getSegmentId() {
		return _segment.getSegmentId();
	}

	/**
	* Sets the segment ID of this segment.
	*
	* @param segmentId the segment ID of this segment
	*/
	@Override
	public void setSegmentId(long segmentId) {
		_segment.setSegmentId(segmentId);
	}

	/**
	* Returns the video ID of this segment.
	*
	* @return the video ID of this segment
	*/
	@Override
	public long getVideoId() {
		return _segment.getVideoId();
	}

	/**
	* Sets the video ID of this segment.
	*
	* @param videoId the video ID of this segment
	*/
	@Override
	public void setVideoId(long videoId) {
		_segment.setVideoId(videoId);
	}

	/**
	* Returns the start of this segment.
	*
	* @return the start of this segment
	*/
	@Override
	public java.lang.String getStart() {
		return _segment.getStart();
	}

	/**
	* Sets the start of this segment.
	*
	* @param start the start of this segment
	*/
	@Override
	public void setStart(java.lang.String start) {
		_segment.setStart(start);
	}

	/**
	* Returns the title of this segment.
	*
	* @return the title of this segment
	*/
	@Override
	public java.lang.String getTitle() {
		return _segment.getTitle();
	}

	/**
	* Sets the title of this segment.
	*
	* @param title the title of this segment
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_segment.setTitle(title);
	}

	/**
	* Returns the description of this segment.
	*
	* @return the description of this segment
	*/
	@Override
	public java.lang.String getDescription() {
		return _segment.getDescription();
	}

	/**
	* Sets the description of this segment.
	*
	* @param description the description of this segment
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_segment.setDescription(description);
	}

	/**
	* Returns the end of this segment.
	*
	* @return the end of this segment
	*/
	@Override
	public java.lang.String getEnd() {
		return _segment.getEnd();
	}

	/**
	* Sets the end of this segment.
	*
	* @param end the end of this segment
	*/
	@Override
	public void setEnd(java.lang.String end) {
		_segment.setEnd(end);
	}

	/**
	* Returns the chapter of this segment.
	*
	* @return the chapter of this segment
	*/
	@Override
	public int getChapter() {
		return _segment.getChapter();
	}

	/**
	* Sets the chapter of this segment.
	*
	* @param chapter the chapter of this segment
	*/
	@Override
	public void setChapter(int chapter) {
		_segment.setChapter(chapter);
	}

	/**
	* Returns the user ID of this segment.
	*
	* @return the user ID of this segment
	*/
	@Override
	public long getUserId() {
		return _segment.getUserId();
	}

	/**
	* Sets the user ID of this segment.
	*
	* @param userId the user ID of this segment
	*/
	@Override
	public void setUserId(long userId) {
		_segment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this segment.
	*
	* @return the user uuid of this segment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _segment.getUserUuid();
	}

	/**
	* Sets the user uuid of this segment.
	*
	* @param userUuid the user uuid of this segment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_segment.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _segment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_segment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _segment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_segment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _segment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _segment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_segment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _segment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_segment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_segment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_segment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SegmentWrapper((Segment)_segment.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Segment segment) {
		return _segment.compareTo(segment);
	}

	@Override
	public int hashCode() {
		return _segment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Segment> toCacheModel() {
		return _segment.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment toEscapedModel() {
		return new SegmentWrapper(_segment.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment toUnescapedModel() {
		return new SegmentWrapper(_segment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _segment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _segment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_segment.persist();
	}

	@Override
	public long getPreviusSegmentId() {
		return _segment.getPreviusSegmentId();
	}

	@Override
	public void setPreviusSegmentId(long previusSegmentId) {
		_segment.setPreviusSegmentId(previusSegmentId);
	}

	@Override
	public int getSeconds() {
		return _segment.getSeconds();
	}

	@Override
	public void setSeconds(int seconds) {
		_segment.setSeconds(seconds);
	}

	@Override
	public int getNumber() {
		return _segment.getNumber();
	}

	@Override
	public void setNumber(int number) {
		_segment.setNumber(number);
	}

	@Override
	public java.lang.String getImage() {
		return _segment.getImage();
	}

	@Override
	public void setImage(java.lang.String image) {
		_segment.setImage(image);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SegmentWrapper)) {
			return false;
		}

		SegmentWrapper segmentWrapper = (SegmentWrapper)obj;

		if (Validator.equals(_segment, segmentWrapper._segment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Segment getWrappedSegment() {
		return _segment;
	}

	@Override
	public Segment getWrappedModel() {
		return _segment;
	}

	@Override
	public void resetOriginalValues() {
		_segment.resetOriginalValues();
	}

	private Segment _segment;
}