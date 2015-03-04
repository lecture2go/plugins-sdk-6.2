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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Iavor Sturm
 * @generated
 */
public class LectureseriesSoap implements Serializable {
	public static LectureseriesSoap toSoapModel(Lectureseries model) {
		LectureseriesSoap soapModel = new LectureseriesSoap();

		soapModel.setNumber(model.getNumber());
		soapModel.setEventType(model.getEventType());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setName(model.getName());
		soapModel.setShortDesc(model.getShortDesc());
		soapModel.setTermId(model.getTermId());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setFacultyName(model.getFacultyName());
		soapModel.setLectureseriesId(model.getLectureseriesId());
		soapModel.setPassword(model.getPassword());
		soapModel.setApproved(model.getApproved());
		soapModel.setLongDesc(model.getLongDesc());
		soapModel.setLatestOpenAccessVideoId(model.getLatestOpenAccessVideoId());
		soapModel.setLatestVideoUploadDate(model.getLatestVideoUploadDate());
		soapModel.setLatestVideoGenerationDate(model.getLatestVideoGenerationDate());

		return soapModel;
	}

	public static LectureseriesSoap[] toSoapModels(Lectureseries[] models) {
		LectureseriesSoap[] soapModels = new LectureseriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LectureseriesSoap[][] toSoapModels(Lectureseries[][] models) {
		LectureseriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LectureseriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LectureseriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LectureseriesSoap[] toSoapModels(List<Lectureseries> models) {
		List<LectureseriesSoap> soapModels = new ArrayList<LectureseriesSoap>(models.size());

		for (Lectureseries model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LectureseriesSoap[soapModels.size()]);
	}

	public LectureseriesSoap() {
	}

	public long getPrimaryKey() {
		return _lectureseriesId;
	}

	public void setPrimaryKey(long pk) {
		setLectureseriesId(pk);
	}

	public String getNumber() {
		return _number;
	}

	public void setNumber(String number) {
		_number = number;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getShortDesc() {
		return _shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		_shortDesc = shortDesc;
	}

	public long getTermId() {
		return _termId;
	}

	public void setTermId(long termId) {
		_termId = termId;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getFacultyName() {
		return _facultyName;
	}

	public void setFacultyName(String facultyName) {
		_facultyName = facultyName;
	}

	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public int getApproved() {
		return _approved;
	}

	public void setApproved(int approved) {
		_approved = approved;
	}

	public String getLongDesc() {
		return _longDesc;
	}

	public void setLongDesc(String longDesc) {
		_longDesc = longDesc;
	}

	public long getLatestOpenAccessVideoId() {
		return _latestOpenAccessVideoId;
	}

	public void setLatestOpenAccessVideoId(long latestOpenAccessVideoId) {
		_latestOpenAccessVideoId = latestOpenAccessVideoId;
	}

	public Date getLatestVideoUploadDate() {
		return _latestVideoUploadDate;
	}

	public void setLatestVideoUploadDate(Date latestVideoUploadDate) {
		_latestVideoUploadDate = latestVideoUploadDate;
	}

	public String getLatestVideoGenerationDate() {
		return _latestVideoGenerationDate;
	}

	public void setLatestVideoGenerationDate(String latestVideoGenerationDate) {
		_latestVideoGenerationDate = latestVideoGenerationDate;
	}

	private String _number;
	private String _eventType;
	private long _categoryId;
	private String _name;
	private String _shortDesc;
	private long _termId;
	private String _language;
	private String _facultyName;
	private long _lectureseriesId;
	private String _password;
	private int _approved;
	private String _longDesc;
	private long _latestOpenAccessVideoId;
	private Date _latestVideoUploadDate;
	private String _latestVideoGenerationDate;
}