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
 * This class is a wrapper for {@link Video_Facility}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_Facility
 * @generated
 */
public class Video_FacilityWrapper implements Video_Facility,
	ModelWrapper<Video_Facility> {
	public Video_FacilityWrapper(Video_Facility video_Facility) {
		_video_Facility = video_Facility;
	}

	@Override
	public Class<?> getModelClass() {
		return Video_Facility.class;
	}

	@Override
	public String getModelClassName() {
		return Video_Facility.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoFacilityId", getVideoFacilityId());
		attributes.put("videoId", getVideoId());
		attributes.put("facilityId", getFacilityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoFacilityId = (Long)attributes.get("videoFacilityId");

		if (videoFacilityId != null) {
			setVideoFacilityId(videoFacilityId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}
	}

	/**
	* Returns the primary key of this video_ facility.
	*
	* @return the primary key of this video_ facility
	*/
	@Override
	public long getPrimaryKey() {
		return _video_Facility.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video_ facility.
	*
	* @param primaryKey the primary key of this video_ facility
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_video_Facility.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the video facility ID of this video_ facility.
	*
	* @return the video facility ID of this video_ facility
	*/
	@Override
	public long getVideoFacilityId() {
		return _video_Facility.getVideoFacilityId();
	}

	/**
	* Sets the video facility ID of this video_ facility.
	*
	* @param videoFacilityId the video facility ID of this video_ facility
	*/
	@Override
	public void setVideoFacilityId(long videoFacilityId) {
		_video_Facility.setVideoFacilityId(videoFacilityId);
	}

	/**
	* Returns the video ID of this video_ facility.
	*
	* @return the video ID of this video_ facility
	*/
	@Override
	public long getVideoId() {
		return _video_Facility.getVideoId();
	}

	/**
	* Sets the video ID of this video_ facility.
	*
	* @param videoId the video ID of this video_ facility
	*/
	@Override
	public void setVideoId(long videoId) {
		_video_Facility.setVideoId(videoId);
	}

	/**
	* Returns the facility ID of this video_ facility.
	*
	* @return the facility ID of this video_ facility
	*/
	@Override
	public long getFacilityId() {
		return _video_Facility.getFacilityId();
	}

	/**
	* Sets the facility ID of this video_ facility.
	*
	* @param facilityId the facility ID of this video_ facility
	*/
	@Override
	public void setFacilityId(long facilityId) {
		_video_Facility.setFacilityId(facilityId);
	}

	@Override
	public boolean isNew() {
		return _video_Facility.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_video_Facility.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _video_Facility.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_video_Facility.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _video_Facility.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _video_Facility.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_video_Facility.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _video_Facility.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_video_Facility.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_video_Facility.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_video_Facility.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Video_FacilityWrapper((Video_Facility)_video_Facility.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Video_Facility video_Facility) {
		return _video_Facility.compareTo(video_Facility);
	}

	@Override
	public int hashCode() {
		return _video_Facility.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Video_Facility> toCacheModel() {
		return _video_Facility.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Facility toEscapedModel() {
		return new Video_FacilityWrapper(_video_Facility.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Facility toUnescapedModel() {
		return new Video_FacilityWrapper(_video_Facility.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _video_Facility.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _video_Facility.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_video_Facility.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Video_FacilityWrapper)) {
			return false;
		}

		Video_FacilityWrapper video_FacilityWrapper = (Video_FacilityWrapper)obj;

		if (Validator.equals(_video_Facility,
					video_FacilityWrapper._video_Facility)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Video_Facility getWrappedVideo_Facility() {
		return _video_Facility;
	}

	@Override
	public Video_Facility getWrappedModel() {
		return _video_Facility;
	}

	@Override
	public void resetOriginalValues() {
		_video_Facility.resetOriginalValues();
	}

	private Video_Facility _video_Facility;
}