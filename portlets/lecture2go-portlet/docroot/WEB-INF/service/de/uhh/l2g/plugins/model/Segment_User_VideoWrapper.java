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
 * This class is a wrapper for {@link Segment_User_Video}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Segment_User_Video
 * @generated
 */
public class Segment_User_VideoWrapper implements Segment_User_Video,
	ModelWrapper<Segment_User_Video> {
	public Segment_User_VideoWrapper(Segment_User_Video segment_User_Video) {
		_segment_User_Video = segment_User_Video;
	}

	@Override
	public Class<?> getModelClass() {
		return Segment_User_Video.class;
	}

	@Override
	public String getModelClassName() {
		return Segment_User_Video.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("segmentId", getSegmentId());
		attributes.put("userId", getUserId());
		attributes.put("videoId", getVideoId());
		attributes.put("segmentUserVideoId", getSegmentUserVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long segmentId = (Long)attributes.get("segmentId");

		if (segmentId != null) {
			setSegmentId(segmentId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long segmentUserVideoId = (Long)attributes.get("segmentUserVideoId");

		if (segmentUserVideoId != null) {
			setSegmentUserVideoId(segmentUserVideoId);
		}
	}

	/**
	* Returns the primary key of this segment_ user_ video.
	*
	* @return the primary key of this segment_ user_ video
	*/
	@Override
	public long getPrimaryKey() {
		return _segment_User_Video.getPrimaryKey();
	}

	/**
	* Sets the primary key of this segment_ user_ video.
	*
	* @param primaryKey the primary key of this segment_ user_ video
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_segment_User_Video.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the segment ID of this segment_ user_ video.
	*
	* @return the segment ID of this segment_ user_ video
	*/
	@Override
	public long getSegmentId() {
		return _segment_User_Video.getSegmentId();
	}

	/**
	* Sets the segment ID of this segment_ user_ video.
	*
	* @param segmentId the segment ID of this segment_ user_ video
	*/
	@Override
	public void setSegmentId(long segmentId) {
		_segment_User_Video.setSegmentId(segmentId);
	}

	/**
	* Returns the user ID of this segment_ user_ video.
	*
	* @return the user ID of this segment_ user_ video
	*/
	@Override
	public long getUserId() {
		return _segment_User_Video.getUserId();
	}

	/**
	* Sets the user ID of this segment_ user_ video.
	*
	* @param userId the user ID of this segment_ user_ video
	*/
	@Override
	public void setUserId(long userId) {
		_segment_User_Video.setUserId(userId);
	}

	/**
	* Returns the user uuid of this segment_ user_ video.
	*
	* @return the user uuid of this segment_ user_ video
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _segment_User_Video.getUserUuid();
	}

	/**
	* Sets the user uuid of this segment_ user_ video.
	*
	* @param userUuid the user uuid of this segment_ user_ video
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_segment_User_Video.setUserUuid(userUuid);
	}

	/**
	* Returns the video ID of this segment_ user_ video.
	*
	* @return the video ID of this segment_ user_ video
	*/
	@Override
	public long getVideoId() {
		return _segment_User_Video.getVideoId();
	}

	/**
	* Sets the video ID of this segment_ user_ video.
	*
	* @param videoId the video ID of this segment_ user_ video
	*/
	@Override
	public void setVideoId(long videoId) {
		_segment_User_Video.setVideoId(videoId);
	}

	/**
	* Returns the segment user video ID of this segment_ user_ video.
	*
	* @return the segment user video ID of this segment_ user_ video
	*/
	@Override
	public long getSegmentUserVideoId() {
		return _segment_User_Video.getSegmentUserVideoId();
	}

	/**
	* Sets the segment user video ID of this segment_ user_ video.
	*
	* @param segmentUserVideoId the segment user video ID of this segment_ user_ video
	*/
	@Override
	public void setSegmentUserVideoId(long segmentUserVideoId) {
		_segment_User_Video.setSegmentUserVideoId(segmentUserVideoId);
	}

	@Override
	public boolean isNew() {
		return _segment_User_Video.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_segment_User_Video.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _segment_User_Video.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_segment_User_Video.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _segment_User_Video.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _segment_User_Video.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_segment_User_Video.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _segment_User_Video.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_segment_User_Video.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_segment_User_Video.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_segment_User_Video.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Segment_User_VideoWrapper((Segment_User_Video)_segment_User_Video.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.Segment_User_Video segment_User_Video) {
		return _segment_User_Video.compareTo(segment_User_Video);
	}

	@Override
	public int hashCode() {
		return _segment_User_Video.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Segment_User_Video> toCacheModel() {
		return _segment_User_Video.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment_User_Video toEscapedModel() {
		return new Segment_User_VideoWrapper(_segment_User_Video.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment_User_Video toUnescapedModel() {
		return new Segment_User_VideoWrapper(_segment_User_Video.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _segment_User_Video.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _segment_User_Video.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_segment_User_Video.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Segment_User_VideoWrapper)) {
			return false;
		}

		Segment_User_VideoWrapper segment_User_VideoWrapper = (Segment_User_VideoWrapper)obj;

		if (Validator.equals(_segment_User_Video,
					segment_User_VideoWrapper._segment_User_Video)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Segment_User_Video getWrappedSegment_User_Video() {
		return _segment_User_Video;
	}

	@Override
	public Segment_User_Video getWrappedModel() {
		return _segment_User_Video;
	}

	@Override
	public void resetOriginalValues() {
		_segment_User_Video.resetOriginalValues();
	}

	private Segment_User_Video _segment_User_Video;
}