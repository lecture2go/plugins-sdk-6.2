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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Iavor Sturm
 * @generated
 */
public class UploadSoap implements Serializable {
	public static UploadSoap toSoapModel(Upload model) {
		UploadSoap soapModel = new UploadSoap();

		soapModel.setUploadId(model.getUploadId());
		soapModel.setUserId(model.getUserId());
		soapModel.setContentLength(model.getContentLength());
		soapModel.setTimestamp(model.getTimestamp());
		soapModel.setStatus(model.getStatus());
		soapModel.setVideoId(model.getVideoId());

		return soapModel;
	}

	public static UploadSoap[] toSoapModels(Upload[] models) {
		UploadSoap[] soapModels = new UploadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UploadSoap[][] toSoapModels(Upload[][] models) {
		UploadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UploadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UploadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UploadSoap[] toSoapModels(List<Upload> models) {
		List<UploadSoap> soapModels = new ArrayList<UploadSoap>(models.size());

		for (Upload model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UploadSoap[soapModels.size()]);
	}

	public UploadSoap() {
	}

	public long getPrimaryKey() {
		return _uploadId;
	}

	public void setPrimaryKey(long pk) {
		setUploadId(pk);
	}

	public long getUploadId() {
		return _uploadId;
	}

	public void setUploadId(long uploadId) {
		_uploadId = uploadId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getContentLength() {
		return _contentLength;
	}

	public void setContentLength(long contentLength) {
		_contentLength = contentLength;
	}

	public long getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(long timestamp) {
		_timestamp = timestamp;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	private long _uploadId;
	private long _userId;
	private long _contentLength;
	private long _timestamp;
	private int _status;
	private long _videoId;
}