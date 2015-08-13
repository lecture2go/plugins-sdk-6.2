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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegacyUpload}.
 * </p>
 *
 * @author unihh
 * @see LegacyUpload
 * @generated
 */
public class LegacyUploadWrapper implements LegacyUpload,
	ModelWrapper<LegacyUpload> {
	public LegacyUploadWrapper(LegacyUpload legacyUpload) {
		_legacyUpload = legacyUpload;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyUpload.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyUpload.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("userId", getUserId());
		attributes.put("contentLength", getContentLength());
		attributes.put("timestamp", getTimestamp());
		attributes.put("status", getStatus());
		attributes.put("videoId", getVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long contentLength = (Long)attributes.get("contentLength");

		if (contentLength != null) {
			setContentLength(contentLength);
		}

		Date timestamp = (Date)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}
	}

	/**
	* Returns the primary key of this legacy upload.
	*
	* @return the primary key of this legacy upload
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyUpload.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy upload.
	*
	* @param primaryKey the primary key of this legacy upload
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyUpload.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy upload.
	*
	* @return the ID of this legacy upload
	*/
	@Override
	public long getId() {
		return _legacyUpload.getId();
	}

	/**
	* Sets the ID of this legacy upload.
	*
	* @param id the ID of this legacy upload
	*/
	@Override
	public void setId(long id) {
		_legacyUpload.setId(id);
	}

	/**
	* Returns the user ID of this legacy upload.
	*
	* @return the user ID of this legacy upload
	*/
	@Override
	public long getUserId() {
		return _legacyUpload.getUserId();
	}

	/**
	* Sets the user ID of this legacy upload.
	*
	* @param userId the user ID of this legacy upload
	*/
	@Override
	public void setUserId(long userId) {
		_legacyUpload.setUserId(userId);
	}

	/**
	* Returns the user uuid of this legacy upload.
	*
	* @return the user uuid of this legacy upload
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyUpload.getUserUuid();
	}

	/**
	* Sets the user uuid of this legacy upload.
	*
	* @param userUuid the user uuid of this legacy upload
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_legacyUpload.setUserUuid(userUuid);
	}

	/**
	* Returns the content length of this legacy upload.
	*
	* @return the content length of this legacy upload
	*/
	@Override
	public long getContentLength() {
		return _legacyUpload.getContentLength();
	}

	/**
	* Sets the content length of this legacy upload.
	*
	* @param contentLength the content length of this legacy upload
	*/
	@Override
	public void setContentLength(long contentLength) {
		_legacyUpload.setContentLength(contentLength);
	}

	/**
	* Returns the timestamp of this legacy upload.
	*
	* @return the timestamp of this legacy upload
	*/
	@Override
	public java.util.Date getTimestamp() {
		return _legacyUpload.getTimestamp();
	}

	/**
	* Sets the timestamp of this legacy upload.
	*
	* @param timestamp the timestamp of this legacy upload
	*/
	@Override
	public void setTimestamp(java.util.Date timestamp) {
		_legacyUpload.setTimestamp(timestamp);
	}

	/**
	* Returns the status of this legacy upload.
	*
	* @return the status of this legacy upload
	*/
	@Override
	public int getStatus() {
		return _legacyUpload.getStatus();
	}

	/**
	* Sets the status of this legacy upload.
	*
	* @param status the status of this legacy upload
	*/
	@Override
	public void setStatus(int status) {
		_legacyUpload.setStatus(status);
	}

	/**
	* Returns the video ID of this legacy upload.
	*
	* @return the video ID of this legacy upload
	*/
	@Override
	public long getVideoId() {
		return _legacyUpload.getVideoId();
	}

	/**
	* Sets the video ID of this legacy upload.
	*
	* @param videoId the video ID of this legacy upload
	*/
	@Override
	public void setVideoId(long videoId) {
		_legacyUpload.setVideoId(videoId);
	}

	@Override
	public boolean isNew() {
		return _legacyUpload.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyUpload.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyUpload.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyUpload.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyUpload.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyUpload.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyUpload.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyUpload.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyUpload.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyUpload.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyUpload.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyUploadWrapper((LegacyUpload)_legacyUpload.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyUpload legacyUpload) {
		return _legacyUpload.compareTo(legacyUpload);
	}

	@Override
	public int hashCode() {
		return _legacyUpload.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyUpload> toCacheModel() {
		return _legacyUpload.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyUpload toEscapedModel() {
		return new LegacyUploadWrapper(_legacyUpload.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyUpload toUnescapedModel() {
		return new LegacyUploadWrapper(_legacyUpload.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyUpload.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyUpload.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyUpload.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyUploadWrapper)) {
			return false;
		}

		LegacyUploadWrapper legacyUploadWrapper = (LegacyUploadWrapper)obj;

		if (Validator.equals(_legacyUpload, legacyUploadWrapper._legacyUpload)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyUpload getWrappedLegacyUpload() {
		return _legacyUpload;
	}

	@Override
	public LegacyUpload getWrappedModel() {
		return _legacyUpload;
	}

	@Override
	public void resetOriginalValues() {
		_legacyUpload.resetOriginalValues();
	}

	private LegacyUpload _legacyUpload;
}