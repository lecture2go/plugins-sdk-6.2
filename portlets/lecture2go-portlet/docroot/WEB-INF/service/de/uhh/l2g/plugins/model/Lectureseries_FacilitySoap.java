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
public class Lectureseries_FacilitySoap implements Serializable {
	public static Lectureseries_FacilitySoap toSoapModel(
		Lectureseries_Facility model) {
		Lectureseries_FacilitySoap soapModel = new Lectureseries_FacilitySoap();

		soapModel.setLectureseriesFacilityId(model.getLectureseriesFacilityId());
		soapModel.setLectureseriesId(model.getLectureseriesId());
		soapModel.setFacilityId(model.getFacilityId());

		return soapModel;
	}

	public static Lectureseries_FacilitySoap[] toSoapModels(
		Lectureseries_Facility[] models) {
		Lectureseries_FacilitySoap[] soapModels = new Lectureseries_FacilitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Lectureseries_FacilitySoap[][] toSoapModels(
		Lectureseries_Facility[][] models) {
		Lectureseries_FacilitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Lectureseries_FacilitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new Lectureseries_FacilitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Lectureseries_FacilitySoap[] toSoapModels(
		List<Lectureseries_Facility> models) {
		List<Lectureseries_FacilitySoap> soapModels = new ArrayList<Lectureseries_FacilitySoap>(models.size());

		for (Lectureseries_Facility model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Lectureseries_FacilitySoap[soapModels.size()]);
	}

	public Lectureseries_FacilitySoap() {
	}

	public long getPrimaryKey() {
		return _lectureseriesFacilityId;
	}

	public void setPrimaryKey(long pk) {
		setLectureseriesFacilityId(pk);
	}

	public long getLectureseriesFacilityId() {
		return _lectureseriesFacilityId;
	}

	public void setLectureseriesFacilityId(long lectureseriesFacilityId) {
		_lectureseriesFacilityId = lectureseriesFacilityId;
	}

	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;
	}

	public long getFacilityId() {
		return _facilityId;
	}

	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;
	}

	private long _lectureseriesFacilityId;
	private long _lectureseriesId;
	private long _facilityId;
}