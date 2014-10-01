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
public class Producer_LectureseriesSoap implements Serializable {
	public static Producer_LectureseriesSoap toSoapModel(
		Producer_Lectureseries model) {
		Producer_LectureseriesSoap soapModel = new Producer_LectureseriesSoap();

		soapModel.setProducerLectureseriesId(model.getProducerLectureseriesId());
		soapModel.setLectureseriesId(model.getLectureseriesId());
		soapModel.setProducerId(model.getProducerId());

		return soapModel;
	}

	public static Producer_LectureseriesSoap[] toSoapModels(
		Producer_Lectureseries[] models) {
		Producer_LectureseriesSoap[] soapModels = new Producer_LectureseriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Producer_LectureseriesSoap[][] toSoapModels(
		Producer_Lectureseries[][] models) {
		Producer_LectureseriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Producer_LectureseriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Producer_LectureseriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Producer_LectureseriesSoap[] toSoapModels(
		List<Producer_Lectureseries> models) {
		List<Producer_LectureseriesSoap> soapModels = new ArrayList<Producer_LectureseriesSoap>(models.size());

		for (Producer_Lectureseries model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Producer_LectureseriesSoap[soapModels.size()]);
	}

	public Producer_LectureseriesSoap() {
	}

	public long getPrimaryKey() {
		return _producerLectureseriesId;
	}

	public void setPrimaryKey(long pk) {
		setProducerLectureseriesId(pk);
	}

	public long getProducerLectureseriesId() {
		return _producerLectureseriesId;
	}

	public void setProducerLectureseriesId(long producerLectureseriesId) {
		_producerLectureseriesId = producerLectureseriesId;
	}

	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;
	}

	public long getProducerId() {
		return _producerId;
	}

	public void setProducerId(long producerId) {
		_producerId = producerId;
	}

	private long _producerLectureseriesId;
	private long _lectureseriesId;
	private long _producerId;
}