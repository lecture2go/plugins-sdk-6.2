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
public class Segment_User_VideoSoap implements Serializable {
	public static Segment_User_VideoSoap toSoapModel(Segment_User_Video model) {
		Segment_User_VideoSoap soapModel = new Segment_User_VideoSoap();

		soapModel.setSegmentId(model.getSegmentId());
		soapModel.setUserId(model.getUserId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setSegmentUserVideoId(model.getSegmentUserVideoId());

		return soapModel;
	}

	public static Segment_User_VideoSoap[] toSoapModels(
		Segment_User_Video[] models) {
		Segment_User_VideoSoap[] soapModels = new Segment_User_VideoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Segment_User_VideoSoap[][] toSoapModels(
		Segment_User_Video[][] models) {
		Segment_User_VideoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Segment_User_VideoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Segment_User_VideoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Segment_User_VideoSoap[] toSoapModels(
		List<Segment_User_Video> models) {
		List<Segment_User_VideoSoap> soapModels = new ArrayList<Segment_User_VideoSoap>(models.size());

		for (Segment_User_Video model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Segment_User_VideoSoap[soapModels.size()]);
	}

	public Segment_User_VideoSoap() {
	}

	public long getPrimaryKey() {
		return _segmentUserVideoId;
	}

	public void setPrimaryKey(long pk) {
		setSegmentUserVideoId(pk);
	}

	public long getSegmentId() {
		return _segmentId;
	}

	public void setSegmentId(long segmentId) {
		_segmentId = segmentId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public long getSegmentUserVideoId() {
		return _segmentUserVideoId;
	}

	public void setSegmentUserVideoId(long segmentUserVideoId) {
		_segmentUserVideoId = segmentUserVideoId;
	}

	private long _segmentId;
	private long _userId;
	private long _videoId;
	private long _segmentUserVideoId;
}