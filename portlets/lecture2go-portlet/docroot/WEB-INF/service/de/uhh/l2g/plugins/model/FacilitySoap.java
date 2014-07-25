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
public class FacilitySoap implements Serializable {
	public static FacilitySoap toSoapModel(Facility model) {
		FacilitySoap soapModel = new FacilitySoap();

		soapModel.setFacilityId(model.getFacilityId());
		soapModel.setParentId(model.getParentId());
		soapModel.setName(model.getName());
		soapModel.setTyp(model.getTyp());
		soapModel.setWww(model.getWww());
		soapModel.setLevel(model.getLevel());
		soapModel.setSort(model.getSort());

		return soapModel;
	}

	public static FacilitySoap[] toSoapModels(Facility[] models) {
		FacilitySoap[] soapModels = new FacilitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FacilitySoap[][] toSoapModels(Facility[][] models) {
		FacilitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FacilitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new FacilitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FacilitySoap[] toSoapModels(List<Facility> models) {
		List<FacilitySoap> soapModels = new ArrayList<FacilitySoap>(models.size());

		for (Facility model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FacilitySoap[soapModels.size()]);
	}

	public FacilitySoap() {
	}

	public long getPrimaryKey() {
		return _facilityId;
	}

	public void setPrimaryKey(long pk) {
		setFacilityId(pk);
	}

	public long getFacilityId() {
		return _facilityId;
	}

	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;
	}

	public int getParentId() {
		return _parentId;
	}

	public void setParentId(int parentId) {
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

	private long _facilityId;
	private int _parentId;
	private String _name;
	private String _typ;
	private String _www;
	private int _level;
	private int _sort;
}