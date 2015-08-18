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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author unihh
 * @generated
 */
public class LegacyUploadSoap implements Serializable {
	public static LegacyUploadSoap toSoapModel(LegacyUpload model) {
		LegacyUploadSoap soapModel = new LegacyUploadSoap();

		soapModel.setId(model.getId());
		soapModel.setUserId(model.getUserId());
		soapModel.setContentLength(model.getContentLength());
		soapModel.setTimestamp(model.getTimestamp());
		soapModel.setStatus(model.getStatus());
		soapModel.setVideoId(model.getVideoId());

		return soapModel;
	}

	public static LegacyUploadSoap[] toSoapModels(LegacyUpload[] models) {
		LegacyUploadSoap[] soapModels = new LegacyUploadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyUploadSoap[][] toSoapModels(LegacyUpload[][] models) {
		LegacyUploadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyUploadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyUploadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyUploadSoap[] toSoapModels(List<LegacyUpload> models) {
		List<LegacyUploadSoap> soapModels = new ArrayList<LegacyUploadSoap>(models.size());

		for (LegacyUpload model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyUploadSoap[soapModels.size()]);
	}

	public LegacyUploadSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
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

	public Date getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(Date timestamp) {
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

	private long _id;
	private long _userId;
	private long _contentLength;
	private Date _timestamp;
	private int _status;
	private long _videoId;
}