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
public class LegacyProducerLectureseriesSoap implements Serializable {
	public static LegacyProducerLectureseriesSoap toSoapModel(
		LegacyProducerLectureseries model) {
		LegacyProducerLectureseriesSoap soapModel = new LegacyProducerLectureseriesSoap();

		soapModel.setId(model.getId());
		soapModel.setProducerId(model.getProducerId());
		soapModel.setLectureseriesId(model.getLectureseriesId());

		return soapModel;
	}

	public static LegacyProducerLectureseriesSoap[] toSoapModels(
		LegacyProducerLectureseries[] models) {
		LegacyProducerLectureseriesSoap[] soapModels = new LegacyProducerLectureseriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyProducerLectureseriesSoap[][] toSoapModels(
		LegacyProducerLectureseries[][] models) {
		LegacyProducerLectureseriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyProducerLectureseriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyProducerLectureseriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyProducerLectureseriesSoap[] toSoapModels(
		List<LegacyProducerLectureseries> models) {
		List<LegacyProducerLectureseriesSoap> soapModels = new ArrayList<LegacyProducerLectureseriesSoap>(models.size());

		for (LegacyProducerLectureseries model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyProducerLectureseriesSoap[soapModels.size()]);
	}

	public LegacyProducerLectureseriesSoap() {
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

	public long getProducerId() {
		return _producerId;
	}

	public void setProducerId(long producerId) {
		_producerId = producerId;
	}

	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;
	}

	private long _id;
	private long _producerId;
	private long _lectureseriesId;
}