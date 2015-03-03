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
public class YearSoap implements Serializable {
	public static YearSoap toSoapModel(Year model) {
		YearSoap soapModel = new YearSoap();

		soapModel.setYearId(model.getYearId());
		soapModel.setParentId(model.getParentId());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setPrefix(model.getPrefix());
		soapModel.setName(model.getName());
		soapModel.setTranslation(model.getTranslation());

		return soapModel;
	}

	public static YearSoap[] toSoapModels(Year[] models) {
		YearSoap[] soapModels = new YearSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static YearSoap[][] toSoapModels(Year[][] models) {
		YearSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new YearSoap[models.length][models[0].length];
		}
		else {
			soapModels = new YearSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static YearSoap[] toSoapModels(List<Year> models) {
		List<YearSoap> soapModels = new ArrayList<YearSoap>(models.size());

		for (Year model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new YearSoap[soapModels.size()]);
	}

	public YearSoap() {
	}

	public long getPrimaryKey() {
		return _yearId;
	}

	public void setPrimaryKey(long pk) {
		setYearId(pk);
	}

	public long getYearId() {
		return _yearId;
	}

	public void setYearId(long yearId) {
		_yearId = yearId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public String getPrefix() {
		return _prefix;
	}

	public void setPrefix(String prefix) {
		_prefix = prefix;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTranslation() {
		return _translation;
	}

	public void setTranslation(String translation) {
		_translation = translation;
	}

	private long _yearId;
	private long _parentId;
	private String _languageId;
	private String _prefix;
	private String _name;
	private String _translation;
}