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
public class AutocompleteSoap implements Serializable {
	public static AutocompleteSoap toSoapModel(Autocomplete model) {
		AutocompleteSoap soapModel = new AutocompleteSoap();

		soapModel.setAutocompleteId(model.getAutocompleteId());
		soapModel.setSearchWordsJson(model.getSearchWordsJson());

		return soapModel;
	}

	public static AutocompleteSoap[] toSoapModels(Autocomplete[] models) {
		AutocompleteSoap[] soapModels = new AutocompleteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AutocompleteSoap[][] toSoapModels(Autocomplete[][] models) {
		AutocompleteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AutocompleteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AutocompleteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AutocompleteSoap[] toSoapModels(List<Autocomplete> models) {
		List<AutocompleteSoap> soapModels = new ArrayList<AutocompleteSoap>(models.size());

		for (Autocomplete model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AutocompleteSoap[soapModels.size()]);
	}

	public AutocompleteSoap() {
	}

	public long getPrimaryKey() {
		return _autocompleteId;
	}

	public void setPrimaryKey(long pk) {
		setAutocompleteId(pk);
	}

	public long getAutocompleteId() {
		return _autocompleteId;
	}

	public void setAutocompleteId(long autocompleteId) {
		_autocompleteId = autocompleteId;
	}

	public String getSearchWordsJson() {
		return _searchWordsJson;
	}

	public void setSearchWordsJson(String searchWordsJson) {
		_searchWordsJson = searchWordsJson;
	}

	private long _autocompleteId;
	private String _searchWordsJson;
}