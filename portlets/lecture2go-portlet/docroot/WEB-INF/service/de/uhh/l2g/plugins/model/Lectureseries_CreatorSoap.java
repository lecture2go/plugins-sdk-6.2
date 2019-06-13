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
public class Lectureseries_CreatorSoap implements Serializable {
	public static Lectureseries_CreatorSoap toSoapModel(
		Lectureseries_Creator model) {
		Lectureseries_CreatorSoap soapModel = new Lectureseries_CreatorSoap();

		soapModel.setLectureseriesCreatorId(model.getLectureseriesCreatorId());
		soapModel.setLectureseriesId(model.getLectureseriesId());
		soapModel.setCreatorId(model.getCreatorId());

		return soapModel;
	}

	public static Lectureseries_CreatorSoap[] toSoapModels(
		Lectureseries_Creator[] models) {
		Lectureseries_CreatorSoap[] soapModels = new Lectureseries_CreatorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Lectureseries_CreatorSoap[][] toSoapModels(
		Lectureseries_Creator[][] models) {
		Lectureseries_CreatorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Lectureseries_CreatorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Lectureseries_CreatorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Lectureseries_CreatorSoap[] toSoapModels(
		List<Lectureseries_Creator> models) {
		List<Lectureseries_CreatorSoap> soapModels = new ArrayList<Lectureseries_CreatorSoap>(models.size());

		for (Lectureseries_Creator model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Lectureseries_CreatorSoap[soapModels.size()]);
	}

	public Lectureseries_CreatorSoap() {
	}

	public long getPrimaryKey() {
		return _lectureseriesCreatorId;
	}

	public void setPrimaryKey(long pk) {
		setLectureseriesCreatorId(pk);
	}

	public long getLectureseriesCreatorId() {
		return _lectureseriesCreatorId;
	}

	public void setLectureseriesCreatorId(long lectureseriesCreatorId) {
		_lectureseriesCreatorId = lectureseriesCreatorId;
	}

	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;
	}

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	private long _lectureseriesCreatorId;
	private long _lectureseriesId;
	private long _creatorId;
}