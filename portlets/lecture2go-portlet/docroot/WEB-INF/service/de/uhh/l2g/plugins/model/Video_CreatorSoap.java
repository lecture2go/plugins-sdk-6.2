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
public class Video_CreatorSoap implements Serializable {
	public static Video_CreatorSoap toSoapModel(Video_Creator model) {
		Video_CreatorSoap soapModel = new Video_CreatorSoap();

		soapModel.setVideoCreatorId(model.getVideoCreatorId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setVideoId(model.getVideoId());

		return soapModel;
	}

	public static Video_CreatorSoap[] toSoapModels(Video_Creator[] models) {
		Video_CreatorSoap[] soapModels = new Video_CreatorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Video_CreatorSoap[][] toSoapModels(Video_Creator[][] models) {
		Video_CreatorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Video_CreatorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Video_CreatorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Video_CreatorSoap[] toSoapModels(List<Video_Creator> models) {
		List<Video_CreatorSoap> soapModels = new ArrayList<Video_CreatorSoap>(models.size());

		for (Video_Creator model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Video_CreatorSoap[soapModels.size()]);
	}

	public Video_CreatorSoap() {
	}

	public long getPrimaryKey() {
		return _videoCreatorId;
	}

	public void setPrimaryKey(long pk) {
		setVideoCreatorId(pk);
	}

	public long getVideoCreatorId() {
		return _videoCreatorId;
	}

	public void setVideoCreatorId(long videoCreatorId) {
		_videoCreatorId = videoCreatorId;
	}

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	private long _videoCreatorId;
	private long _creatorId;
	private long _videoId;
}