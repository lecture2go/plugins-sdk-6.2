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
public class LegacyStatisticsSoap implements Serializable {
	public static LegacyStatisticsSoap toSoapModel(LegacyStatistics model) {
		LegacyStatisticsSoap soapModel = new LegacyStatisticsSoap();

		soapModel.setId(model.getId());
		soapModel.setPublic_(model.getPublic_());
		soapModel.setPrivate_(model.getPrivate_());
		soapModel.setAutofill(model.getAutofill());
		soapModel.setDate_(model.getDate_());

		return soapModel;
	}

	public static LegacyStatisticsSoap[] toSoapModels(LegacyStatistics[] models) {
		LegacyStatisticsSoap[] soapModels = new LegacyStatisticsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyStatisticsSoap[][] toSoapModels(
		LegacyStatistics[][] models) {
		LegacyStatisticsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyStatisticsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyStatisticsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyStatisticsSoap[] toSoapModels(
		List<LegacyStatistics> models) {
		List<LegacyStatisticsSoap> soapModels = new ArrayList<LegacyStatisticsSoap>(models.size());

		for (LegacyStatistics model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyStatisticsSoap[soapModels.size()]);
	}

	public LegacyStatisticsSoap() {
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