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
public class LegacyLectureSeriesSoap implements Serializable {
	public static LegacyLectureSeriesSoap toSoapModel(LegacyLectureSeries model) {
		LegacyLectureSeriesSoap soapModel = new LegacyLectureSeriesSoap();

		soapModel.setNumber(model.getNumber());
		soapModel.setEventType(model.getEventType());
		soapModel.setEventCategory(model.getEventCategory());
		soapModel.setName(model.getName());
		soapModel.setShortDesc(model.getShortDesc());
		soapModel.setSemesterName(model.getSemesterName());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setFacultyName(model.getFacultyName());
		soapModel.setInstructorsString(model.getInstructorsString());
		soapModel.setId(model.getId());
		soapModel.setPassword(model.getPassword());
		soapModel.setApproved(model.getApproved());
		soapModel.setLongDesc(model.getLongDesc());

		return soapModel;
	}

	public static LegacyLectureSeriesSoap[] toSoapModels(
		LegacyLectureSeries[] models) {
		LegacyLectureSeriesSoap[] soapModels = new LegacyLectureSeriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyLectureSeriesSoap[][] toSoapModels(
		LegacyLectureSeries[][] models) {
		LegacyLectureSeriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyLectureSeriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyLectureSeriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyLectureSeriesSoap[] toSoapModels(
		List<LegacyLectureSeries> models) {
		List<LegacyLectureSeriesSoap> soapModels = new ArrayList<LegacyLectureSeriesSoap>(models.size());

		for (LegacyLectureSeries model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyLectureSeriesSoap[soapModels.size()]);
	}

	public LegacyLectureSeriesSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	public String getEventCategory() {
		return _eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		_eventCategory = eventCategory;
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

	public String getSemesterName() {
		return _semesterName;
	}

	public void setSemesterName(String semesterName) {
		_semesterName = semesterName;
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

	public String getInstructorsString() {
		return _instructorsString;
	}

	public void setInstructorsString(String instructorsString) {
		_instructorsString = instructorsString;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
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

	private String _number;
	private String _eventType;
	private String _eventCategory;
	private String _name;
	private String _shortDesc;
	private String _semesterName;
	private String _language;
	private String _facultyName;
	private String _instructorsString;
	private long _id;
	private String _password;
	private int _approved;
	private String _longDesc;
}