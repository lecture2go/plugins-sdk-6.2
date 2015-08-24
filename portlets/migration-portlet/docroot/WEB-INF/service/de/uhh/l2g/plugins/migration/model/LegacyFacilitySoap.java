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
public class LegacyFacilitySoap implements Serializable {
	public static LegacyFacilitySoap toSoapModel(LegacyFacility model) {
		LegacyFacilitySoap soapModel = new LegacyFacilitySoap();

		soapModel.setId(model.getId());
		soapModel.setParentId(model.getParentId());
		soapModel.setName(model.getName());
		soapModel.setTyp(model.getTyp());
		soapModel.setWww(model.getWww());
		soapModel.setLevel(model.getLevel());
		soapModel.setSort(model.getSort());

		return soapModel;
	}

	public static LegacyFacilitySoap[] toSoapModels(LegacyFacility[] models) {
		LegacyFacilitySoap[] soapModels = new LegacyFacilitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyFacilitySoap[][] toSoapModels(LegacyFacility[][] models) {
		LegacyFacilitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyFacilitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyFacilitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyFacilitySoap[] toSoapModels(List<LegacyFacility> models) {
		List<LegacyFacilitySoap> soapModels = new ArrayList<LegacyFacilitySoap>(models.size());

		for (LegacyFacility model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyFacilitySoap[soapModels.size()]);
	}

	public LegacyFacilitySoap() {
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

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTyp() {
		return _typ;
	}

	public void setTyp(String typ) {
		_typ = typ;
	}

	public String getWww() {
		return _www;
	}

	public void setWww(String www) {
		_www = www;
	}

	public int getLevel() {
		return _level;
	}

	public void setLevel(int level) {
		_level = level;
	}

	public int getSort() {
		return _sort;
	}

	public void setSort(int sort) {
		_sort = sort;
	}

	private long _id;
	private long _parentId;
	private String _name;
	private String _typ;
	private String _www;
	private int _level;
	private int _sort;
}