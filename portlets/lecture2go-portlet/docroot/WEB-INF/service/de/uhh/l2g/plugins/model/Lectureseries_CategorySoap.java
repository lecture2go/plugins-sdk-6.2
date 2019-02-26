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
public class Lectureseries_CategorySoap implements Serializable {
	public static Lectureseries_CategorySoap toSoapModel(
		Lectureseries_Category model) {
		Lectureseries_CategorySoap soapModel = new Lectureseries_CategorySoap();

		soapModel.setLectureseriesCategoryId(model.getLectureseriesCategoryId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setLectureseriesId(model.getLectureseriesId());

		return soapModel;
	}

	public static Lectureseries_CategorySoap[] toSoapModels(
		Lectureseries_Category[] models) {
		Lectureseries_CategorySoap[] soapModels = new Lectureseries_CategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Lectureseries_CategorySoap[][] toSoapModels(
		Lectureseries_Category[][] models) {
		Lectureseries_CategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Lectureseries_CategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new Lectureseries_CategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Lectureseries_CategorySoap[] toSoapModels(
		List<Lectureseries_Category> models) {
		List<Lectureseries_CategorySoap> soapModels = new ArrayList<Lectureseries_CategorySoap>(models.size());

		for (Lectureseries_Category model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Lectureseries_CategorySoap[soapModels.size()]);
	}

	public Lectureseries_CategorySoap() {
	}

	public long getPrimaryKey() {
		return _lectureseriesCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setLectureseriesCategoryId(pk);
	}

	public long getLectureseriesCategoryId() {
		return _lectureseriesCategoryId;
	}

	public void setLectureseriesCategoryId(long lectureseriesCategoryId) {
		_lectureseriesCategoryId = lectureseriesCategoryId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;
	}

	private long _lectureseriesCategoryId;
	private long _categoryId;
	private long _lectureseriesId;
}