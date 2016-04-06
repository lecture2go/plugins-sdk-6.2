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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author unihh
 * @generated
 */
public class LegacyStatisticSoap implements Serializable {
	public static LegacyStatisticSoap toSoapModel(LegacyStatistic model) {
		LegacyStatisticSoap soapModel = new LegacyStatisticSoap();

		soapModel.setId(model.getId());
		soapModel.setPublic_(model.getPublic_());
		soapModel.setPrivate_(model.getPrivate_());
		soapModel.setAutofill(model.getAutofill());
		soapModel.setDate_(model.getDate_());

		return soapModel;
	}

	public static LegacyStatisticSoap[] toSoapModels(LegacyStatistic[] models) {
		LegacyStatisticSoap[] soapModels = new LegacyStatisticSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyStatisticSoap[][] toSoapModels(
		LegacyStatistic[][] models) {
		LegacyStatisticSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyStatisticSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyStatisticSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyStatisticSoap[] toSoapModels(
		List<LegacyStatistic> models) {
		List<LegacyStatisticSoap> soapModels = new ArrayList<LegacyStatisticSoap>(models.size());

		for (LegacyStatistic model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyStatisticSoap[soapModels.size()]);
	}

	public LegacyStatisticSoap() {
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int pk) {
		setId(pk);
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public int getPublic_() {
		return _public_;
	}

	public void setPublic_(int public_) {
		_public_ = public_;
	}

	public int getPrivate_() {
		return _private_;
	}

	public void setPrivate_(int private_) {
		_private_ = private_;
	}

	public int getAutofill() {
		return _autofill;
	}

	public void setAutofill(int autofill) {
		_autofill = autofill;
	}

	public Date getDate_() {
		return _date_;
	}

	public void setDate_(Date date_) {
		_date_ = date_;
	}

	private int _id;
	private int _public_;
	private int _private_;
	private int _autofill;
	private Date _date_;
}