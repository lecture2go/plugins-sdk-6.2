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
 * This class is a wrapper for {@link Upload}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Upload
 * @generated
 */
public class UploadWrapper implements Upload, ModelWrapper<Upload> {
	public UploadWrapper(Upload upload) {
		_upload = upload;
	}

	@Override
	public Class<?> getModelClass() {
		return Upload.class;
	}

	@Override
	public String getModelClassName() {
		return Upload.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uploadId", getUploadId());
		attributes.put("userId", getUserId());
		attributes.put("contentLength", getContentLength());
		attributes.put("timestamp", getTimestamp());
		attributes.put("status", getStatus());
		attributes.put("videoId", getVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long uploadId = (Long)attributes.get("uploadId");

		if (uploadId != null) {
			setUploadId(uploadId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long contentLength = (Long)attributes.get("contentLength");

		if (contentLength != null) {
			setContentLength(contentLength);
		}

		Long timestamp = (Long)attributes.get("timestamp");

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
	* Returns the primary key of this upload.
	*
	* @return the primary key of this upload
	*/
	@Override
	public long getPrimaryKey() {
		return _upload.getPrimaryKey();
	}

	/**
	* Sets the primary key of this upload.
	*
	* @param primaryKey the primary key of this upload
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_upload.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the upload ID of this upload.
	*
	* @return the upload ID of this upload
	*/
	@Override
	public long getUploadId() {
		return _upload.getUploadId();
	}

	/**
	* Sets the upload ID of this upload.
	*
	* @param uploadId the upload ID of this upload
	*/
	@Override
	public void setUploadId(long uploadId) {
		_upload.setUploadId(uploadId);
	}

	/**
	* Returns the user ID of this upload.
	*
	* @return the user ID of this upload
	*/
	@Override
	public long getUserId() {
		return _upload.getUserId();
	}

	/**
	* Sets the user ID of this upload.
	*
	* @param userId the user ID of this upload
	*/
	@Override
	public void setUserId(long userId) {
		_upload.setUserId(userId);
	}

	/**
	* Returns the user uuid of this upload.
	*
	* @return the user uuid of this upload
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _upload.getUserUuid();
	}

	/**
	* Sets the user uuid of this upload.
	*
	* @param userUuid the user uuid of this upload
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_upload.setUserUuid(userUuid);
	}

	/**
	* Returns the content length of this upload.
	*
	* @return the content length of this upload
	*/
	@Override
	public long getContentLength() {
		return _upload.getContentLength();
	}

	/**
	* Sets the content length of this upload.
	*
	* @param contentLength the content length of this upload
	*/
	@Override
	public void setContentLength(long contentLength) {
		_upload.setContentLength(contentLength);
	}

	/**
	* Returns the timestamp of this upload.
	*
	* @return the timestamp of this upload
	*/
	@Override
	public long getTimestamp() {
		return _upload.getTimestamp();
	}

	/**
	* Sets the timestamp of this upload.
	*
	* @param timestamp the timestamp of this upload
	*/
	@Override
	public void setTimestamp(long timestamp) {
		_upload.setTimestamp(timestamp);
	}

	/**
	* Returns the status of this upload.
	*
	* @return the status of this upload
	*/
	@Override
	public int getStatus() {
		return _upload.getStatus();
	}

	/**
	* Sets the status of this upload.
	*
	* @param status the status of this upload
	*/
	@Override
	public void setStatus(int status) {
		_upload.setStatus(status);
	}

	/**
	* Returns the video ID of this upload.
	*
	* @return the video ID of this upload
	*/
	@Override
	public long getVideoId() {
		return _upload.getVideoId();
	}

	/**
	* Sets the video ID of this upload.
	*
	* @param videoId the video ID of this upload
	*/
	@Override
	public void setVideoId(long videoId) {
		_upload.setVideoId(videoId);
	}

	@Override
	public boolean isNew() {
		return _upload.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_upload.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _upload.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_upload.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _upload.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _upload.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_upload.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _upload.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_upload.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_upload.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_upload.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UploadWrapper((Upload)_upload.clone());
	}

	@Override
	public int compareTo(Upload upload) {
		return _upload.compareTo(upload);
	}

	@Override
	public int hashCode() {
		return _upload.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Upload> toCacheModel() {
		return _upload.toCacheModel();
	}

	@Override
	public Upload toEscapedModel() {
		return new UploadWrapper(_upload.toEscapedModel());
	}

	@Override
	public Upload toUnescapedModel() {
		return new UploadWrapper(_upload.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _upload.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _upload.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_upload.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UploadWrapper)) {
			return false;
		}

		UploadWrapper uploadWrapper = (UploadWrapper)obj;

		if (Validator.equals(_upload, uploadWrapper._upload)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Upload getWrappedUpload() {
		return _upload;
	}

	@Override
	public Upload getWrappedModel() {
		return _upload;
	}

	@Override
	public void resetOriginalValues() {
		_upload.resetOriginalValues();
	}

	private Upload _upload;
}