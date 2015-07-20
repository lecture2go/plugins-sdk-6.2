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
public class LegacyLectureSeriesFacilitySoap implements Serializable {
	public static LegacyLectureSeriesFacilitySoap toSoapModel(
		LegacyLectureSeriesFacility model) {
		LegacyLectureSeriesFacilitySoap soapModel = new LegacyLectureSeriesFacilitySoap();

		soapModel.setFacilityId(model.getFacilityId());
		soapModel.setLectureseriesId(model.getLectureseriesId());
		soapModel.setIsLinkFrom(model.getIsLinkFrom());

		return soapModel;
	}

	public static LegacyLectureSeriesFacilitySoap[] toSoapModels(
		LegacyLectureSeriesFacility[] models) {
		LegacyLectureSeriesFacilitySoap[] soapModels = new LegacyLectureSeriesFacilitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyLectureSeriesFacilitySoap[][] toSoapModels(
		LegacyLectureSeriesFacility[][] models) {
		LegacyLectureSeriesFacilitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyLectureSeriesFacilitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyLectureSeriesFacilitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyLectureSeriesFacilitySoap[] toSoapModels(
		List<LegacyLectureSeriesFacility> models) {
		List<LegacyLectureSeriesFacilitySoap> soapModels = new ArrayList<LegacyLectureSeriesFacilitySoap>(models.size());

		for (LegacyLectureSeriesFacility model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyLectureSeriesFacilitySoap[soapModels.size()]);
	}

	public LegacyLectureSeriesFacilitySoap() {
	}

	public long getPrimaryKey() {
		return _facilityId;
	}

	public void setPrimaryKey(long pk) {
		setFacilityId(pk);
	}

	public long getFacilityId() {
		return _facilityId;
	}

	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;
	}

	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;
	}

	public long getIsLinkFrom() {
		return _isLinkFrom;
	}

	public void setIsLinkFrom(long isLinkFrom) {
		_isLinkFrom = isLinkFrom;
	}

	private long _facilityId;
	private long _lectureseriesId;
	private long _isLinkFrom;
}