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
public class VideohitlistSoap implements Serializable {
	public static VideohitlistSoap toSoapModel(Videohitlist model) {
		VideohitlistSoap soapModel = new VideohitlistSoap();

		soapModel.setVideohitlistId(model.getVideohitlistId());
		soapModel.setHitsPerDay(model.getHitsPerDay());
		soapModel.setHitsPerWeek(model.getHitsPerWeek());
		soapModel.setHitsPerMonth(model.getHitsPerMonth());
		soapModel.setHitsPerYear(model.getHitsPerYear());

		return soapModel;
	}

	public static VideohitlistSoap[] toSoapModels(Videohitlist[] models) {
		VideohitlistSoap[] soapModels = new VideohitlistSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideohitlistSoap[][] toSoapModels(Videohitlist[][] models) {
		VideohitlistSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideohitlistSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideohitlistSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideohitlistSoap[] toSoapModels(List<Videohitlist> models) {
		List<VideohitlistSoap> soapModels = new ArrayList<VideohitlistSoap>(models.size());

		for (Videohitlist model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideohitlistSoap[soapModels.size()]);
	}

	public VideohitlistSoap() {
	}

	public long getPrimaryKey() {
		return _videohitlistId;
	}

	public void setPrimaryKey(long pk) {
		setVideohitlistId(pk);
	}

	public long getVideohitlistId() {
		return _videohitlistId;
	}

	public void setVideohitlistId(long videohitlistId) {
		_videohitlistId = videohitlistId;
	}

	public int getHitsPerDay() {
		return _hitsPerDay;
	}

	public void setHitsPerDay(int hitsPerDay) {
		_hitsPerDay = hitsPerDay;
	}

	public int getHitsPerWeek() {
		return _hitsPerWeek;
	}

	public void setHitsPerWeek(int hitsPerWeek) {
		_hitsPerWeek = hitsPerWeek;
	}

	public int getHitsPerMonth() {
		return _hitsPerMonth;
	}

	public void setHitsPerMonth(int hitsPerMonth) {
		_hitsPerMonth = hitsPerMonth;
	}

	public int getHitsPerYear() {
		return _hitsPerYear;
	}

	public void setHitsPerYear(int hitsPerYear) {
		_hitsPerYear = hitsPerYear;
	}

	private long _videohitlistId;
	private int _hitsPerDay;
	private int _hitsPerWeek;
	private int _hitsPerMonth;
	private int _hitsPerYear;
}