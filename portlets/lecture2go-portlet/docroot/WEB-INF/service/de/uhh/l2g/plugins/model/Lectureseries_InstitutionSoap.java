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
public class Lectureseries_InstitutionSoap implements Serializable {
	public static Lectureseries_InstitutionSoap toSoapModel(
		Lectureseries_Institution model) {
		Lectureseries_InstitutionSoap soapModel = new Lectureseries_InstitutionSoap();

		soapModel.setLectureseriesInstitutionId(model.getLectureseriesInstitutionId());
		soapModel.setLectureseriesId(model.getLectureseriesId());
		soapModel.setInstitutionId(model.getInstitutionId());
		soapModel.setInstitutionParentId(model.getInstitutionParentId());

		return soapModel;
	}

	public static Lectureseries_InstitutionSoap[] toSoapModels(
		Lectureseries_Institution[] models) {
		Lectureseries_InstitutionSoap[] soapModels = new Lectureseries_InstitutionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Lectureseries_InstitutionSoap[][] toSoapModels(
		Lectureseries_Institution[][] models) {
		Lectureseries_InstitutionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Lectureseries_InstitutionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Lectureseries_InstitutionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Lectureseries_InstitutionSoap[] toSoapModels(
		List<Lectureseries_Institution> models) {
		List<Lectureseries_InstitutionSoap> soapModels = new ArrayList<Lectureseries_InstitutionSoap>(models.size());

		for (Lectureseries_Institution model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Lectureseries_InstitutionSoap[soapModels.size()]);
	}

	public Lectureseries_InstitutionSoap() {
	}

	public long getPrimaryKey() {
		return _lectureseriesInstitutionId;
	}

	public void setPrimaryKey(long pk) {
		setLectureseriesInstitutionId(pk);
	}

	public long getLectureseriesInstitutionId() {
		return _lectureseriesInstitutionId;
	}

	public void setLectureseriesInstitutionId(long lectureseriesInstitutionId) {
		_lectureseriesInstitutionId = lectureseriesInstitutionId;
	}

	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;
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

	private long _lectureseriesInstitutionId;
	private long _lectureseriesId;
	private long _institutionId;
	private long _institutionParentId;
}