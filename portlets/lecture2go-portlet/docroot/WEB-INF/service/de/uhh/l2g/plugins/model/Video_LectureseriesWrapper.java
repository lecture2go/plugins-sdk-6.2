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
 * This class is a wrapper for {@link Video_Lectureseries}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_Lectureseries
 * @generated
 */
public class Video_LectureseriesWrapper implements Video_Lectureseries,
	ModelWrapper<Video_Lectureseries> {
	public Video_LectureseriesWrapper(Video_Lectureseries video_Lectureseries) {
		_video_Lectureseries = video_Lectureseries;
	}

	@Override
	public Class<?> getModelClass() {
		return Video_Lectureseries.class;
	}

	@Override
	public String getModelClassName() {
		return Video_Lectureseries.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoLectureseriesId", getVideoLectureseriesId());
		attributes.put("videoId", getVideoId());
		attributes.put("lectureseriesId", getLectureseriesId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoLectureseriesId = (Long)attributes.get("videoLectureseriesId");

		if (videoLectureseriesId != null) {
			setVideoLectureseriesId(videoLectureseriesId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}
	}

	/**
	* Returns the primary key of this video_ lectureseries.
	*
	* @return the primary key of this video_ lectureseries
	*/
	@Override
	public long getPrimaryKey() {
		return _video_Lectureseries.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video_ lectureseries.
	*
	* @param primaryKey the primary key of this video_ lectureseries
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_video_Lectureseries.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the video lectureseries ID of this video_ lectureseries.
	*
	* @return the video lectureseries ID of this video_ lectureseries
	*/
	@Override
	public long getVideoLectureseriesId() {
		return _video_Lectureseries.getVideoLectureseriesId();
	}

	/**
	* Sets the video lectureseries ID of this video_ lectureseries.
	*
	* @param videoLectureseriesId the video lectureseries ID of this video_ lectureseries
	*/
	@Override
	public void setVideoLectureseriesId(long videoLectureseriesId) {
		_video_Lectureseries.setVideoLectureseriesId(videoLectureseriesId);
	}

	/**
	* Returns the video ID of this video_ lectureseries.
	*
	* @return the video ID of this video_ lectureseries
	*/
	@Override
	public long getVideoId() {
		return _video_Lectureseries.getVideoId();
	}

	/**
	* Sets the video ID of this video_ lectureseries.
	*
	* @param videoId the video ID of this video_ lectureseries
	*/
	@Override
	public void setVideoId(long videoId) {
		_video_Lectureseries.setVideoId(videoId);
	}

	/**
	* Returns the lectureseries ID of this video_ lectureseries.
	*
	* @return the lectureseries ID of this video_ lectureseries
	*/
	@Override
	public long getLectureseriesId() {
		return _video_Lectureseries.getLectureseriesId();
	}

	/**
	* Sets the lectureseries ID of this video_ lectureseries.
	*
	* @param lectureseriesId the lectureseries ID of this video_ lectureseries
	*/
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_video_Lectureseries.setLectureseriesId(lectureseriesId);
	}

	@Override
	public boolean isNew() {
		return _video_Lectureseries.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_video_Lectureseries.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _video_Lectureseries.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_video_Lectureseries.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _video_Lectureseries.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _video_Lectureseries.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_video_Lectureseries.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _video_Lectureseries.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_video_Lectureseries.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_video_Lectureseries.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_video_Lectureseries.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Video_LectureseriesWrapper((Video_Lectureseries)_video_Lectureseries.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.Video_Lectureseries video_Lectureseries) {
		return _video_Lectureseries.compareTo(video_Lectureseries);
	}

	@Override
	public int hashCode() {
		return _video_Lectureseries.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Video_Lectureseries> toCacheModel() {
		return _video_Lectureseries.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Lectureseries toEscapedModel() {
		return new Video_LectureseriesWrapper(_video_Lectureseries.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Lectureseries toUnescapedModel() {
		return new Video_LectureseriesWrapper(_video_Lectureseries.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _video_Lectureseries.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _video_Lectureseries.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_video_Lectureseries.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Video_LectureseriesWrapper)) {
			return false;
		}

		Video_LectureseriesWrapper video_LectureseriesWrapper = (Video_LectureseriesWrapper)obj;

		if (Validator.equals(_video_Lectureseries,
					video_LectureseriesWrapper._video_Lectureseries)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Video_Lectureseries getWrappedVideo_Lectureseries() {
		return _video_Lectureseries;
	}

	@Override
	public Video_Lectureseries getWrappedModel() {
		return _video_Lectureseries;
	}

	@Override
	public void resetOriginalValues() {
		_video_Lectureseries.resetOriginalValues();
	}

	private Video_Lectureseries _video_Lectureseries;
}