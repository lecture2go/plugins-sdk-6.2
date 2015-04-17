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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Iavor Sturm
 * @generated
 */
public class Video_InstitutionSoap implements Serializable {
	public static Video_InstitutionSoap toSoapModel(Video_Institution model) {
		Video_InstitutionSoap soapModel = new Video_InstitutionSoap();

		soapModel.setVideoInstitutionId(model.getVideoInstitutionId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setInstitutionId(model.getInstitutionId());
		soapModel.setInstitutionParentId(model.getInstitutionParentId());

		return soapModel;
	}

	public static Video_InstitutionSoap[] toSoapModels(
		Video_Institution[] models) {
		Video_InstitutionSoap[] soapModels = new Video_InstitutionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Video_InstitutionSoap[][] toSoapModels(
		Video_Institution[][] models) {
		Video_InstitutionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Video_InstitutionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Video_InstitutionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Video_InstitutionSoap[] toSoapModels(
		List<Video_Institution> models) {
		List<Video_InstitutionSoap> soapModels = new ArrayList<Video_InstitutionSoap>(models.size());

		for (Video_Institution model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Video_InstitutionSoap[soapModels.size()]);
	}

	public Video_InstitutionSoap() {
	}

	public long getPrimaryKey() {
		return _videoInstitutionId;
	}

	public void setPrimaryKey(long pk) {
		setVideoInstitutionId(pk);
	}

	public long getVideoInstitutionId() {
		return _videoInstitutionId;
	}

	public void setVideoInstitutionId(long videoInstitutionId) {
		_videoInstitutionId = videoInstitutionId;
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public long getInstitutionId() {
		return _institutionId;
	}

	public void setInstitutionId(long institutionId) {
		_institutionId = institutionId;
	}

	public long getInstitutionParentId() {
		return _institutionParentId;
	}

	public void setInstitutionParentId(long institutionParentId) {
		_institutionParentId = institutionParentId;
	}

	private long _videoInstitutionId;
	private long _videoId;
	private long _institutionId;
	private long _institutionParentId;
}