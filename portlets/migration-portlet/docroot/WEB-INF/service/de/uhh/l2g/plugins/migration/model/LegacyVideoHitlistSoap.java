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
public class LegacyVideoHitlistSoap implements Serializable {
	public static LegacyVideoHitlistSoap toSoapModel(LegacyVideoHitlist model) {
		LegacyVideoHitlistSoap soapModel = new LegacyVideoHitlistSoap();

		soapModel.setId(model.getId());
		soapModel.setHitsperday(model.getHitsperday());
		soapModel.setHitsperweek(model.getHitsperweek());
		soapModel.setHitspermonth(model.getHitspermonth());
		soapModel.setHitsperyear(model.getHitsperyear());

		return soapModel;
	}

	public static LegacyVideoHitlistSoap[] toSoapModels(
		LegacyVideoHitlist[] models) {
		LegacyVideoHitlistSoap[] soapModels = new LegacyVideoHitlistSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyVideoHitlistSoap[][] toSoapModels(
		LegacyVideoHitlist[][] models) {
		LegacyVideoHitlistSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyVideoHitlistSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyVideoHitlistSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyVideoHitlistSoap[] toSoapModels(
		List<LegacyVideoHitlist> models) {
		List<LegacyVideoHitlistSoap> soapModels = new ArrayList<LegacyVideoHitlistSoap>(models.size());

		for (LegacyVideoHitlist model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyVideoHitlistSoap[soapModels.size()]);
	}

	public LegacyVideoHitlistSoap() {
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

	public long getHitsperday() {
		return _hitsperday;
	}

	public void setHitsperday(long hitsperday) {
		_hitsperday = hitsperday;
	}

	public long getHitsperweek() {
		return _hitsperweek;
	}

	public void setHitsperweek(long hitsperweek) {
		_hitsperweek = hitsperweek;
	}

	public long getHitspermonth() {
		return _hitspermonth;
	}

	public void setHitspermonth(long hitspermonth) {
		_hitspermonth = hitspermonth;
	}

	public long getHitsperyear() {
		return _hitsperyear;
	}

	public void setHitsperyear(long hitsperyear) {
		_hitsperyear = hitsperyear;
	}

	private long _id;
	private long _hitsperday;
	private long _hitsperweek;
	private long _hitspermonth;
	private long _hitsperyear;
}