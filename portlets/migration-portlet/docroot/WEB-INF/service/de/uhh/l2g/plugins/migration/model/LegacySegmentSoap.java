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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author unihh
 * @generated
 */
public class LegacySegmentSoap implements Serializable {
	public static LegacySegmentSoap toSoapModel(LegacySegment model) {
		LegacySegmentSoap soapModel = new LegacySegmentSoap();

		soapModel.setId(model.getId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setStart(model.getStart());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setEnd(model.getEnd());
		soapModel.setChapter(model.getChapter());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static LegacySegmentSoap[] toSoapModels(LegacySegment[] models) {
		LegacySegmentSoap[] soapModels = new LegacySegmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacySegmentSoap[][] toSoapModels(LegacySegment[][] models) {
		LegacySegmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacySegmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacySegmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacySegmentSoap[] toSoapModels(List<LegacySegment> models) {
		List<LegacySegmentSoap> soapModels = new ArrayList<LegacySegmentSoap>(models.size());

		for (LegacySegment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacySegmentSoap[soapModels.size()]);
	}

	public LegacySegmentSoap() {
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

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public String getStart() {
		return _start;
	}

	public void setStart(String start) {
		_start = start;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getEnd() {
		return _end;
	}

	public void setEnd(String end) {
		_end = end;
	}

	public int getChapter() {
		return _chapter;
	}

	public void setChapter(int chapter) {
		_chapter = chapter;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _id;
	private long _videoId;
	private String _start;
	private String _title;
	private String _description;
	private String _end;
	private int _chapter;
	private long _userId;
}