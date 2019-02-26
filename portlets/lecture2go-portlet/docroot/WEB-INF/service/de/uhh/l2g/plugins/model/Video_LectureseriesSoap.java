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
public class Video_LectureseriesSoap implements Serializable {
	public static Video_LectureseriesSoap toSoapModel(Video_Lectureseries model) {
		Video_LectureseriesSoap soapModel = new Video_LectureseriesSoap();

		soapModel.setVideoLectureseriesId(model.getVideoLectureseriesId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setLectureseriesId(model.getLectureseriesId());
		soapModel.setOpenAccess(model.getOpenAccess());

		return soapModel;
	}

	public static Video_LectureseriesSoap[] toSoapModels(
		Video_Lectureseries[] models) {
		Video_LectureseriesSoap[] soapModels = new Video_LectureseriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Video_LectureseriesSoap[][] toSoapModels(
		Video_Lectureseries[][] models) {
		Video_LectureseriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Video_LectureseriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Video_LectureseriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Video_LectureseriesSoap[] toSoapModels(
		List<Video_Lectureseries> models) {
		List<Video_LectureseriesSoap> soapModels = new ArrayList<Video_LectureseriesSoap>(models.size());

		for (Video_Lectureseries model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Video_LectureseriesSoap[soapModels.size()]);
	}

	public Video_LectureseriesSoap() {
	}

	public long getPrimaryKey() {
		return _videoLectureseriesId;
	}

	public void setPrimaryKey(long pk) {
		setVideoLectureseriesId(pk);
	}

	public long getVideoLectureseriesId() {
		return _videoLectureseriesId;
	}

	public void setVideoLectureseriesId(long videoLectureseriesId) {
		_videoLectureseriesId = videoLectureseriesId;
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;
	}

	public int getOpenAccess() {
		return _openAccess;
	}

	public void setOpenAccess(int openAccess) {
		_openAccess = openAccess;
	}

	private long _videoLectureseriesId;
	private long _videoId;
	private long _lectureseriesId;
	private int _openAccess;
}