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
public class LicenseSoap implements Serializable {
	public static LicenseSoap toSoapModel(License model) {
		LicenseSoap soapModel = new LicenseSoap();

		soapModel.setLicenseId(model.getLicenseId());
		soapModel.setFullName(model.getFullName());
		soapModel.setShortIdentifier(model.getShortIdentifier());
		soapModel.setUrl(model.getUrl());
		soapModel.setSchemeName(model.getSchemeName());
		soapModel.setSchemeUrl(model.getSchemeUrl());
		soapModel.setSelectable(model.getSelectable());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static LicenseSoap[] toSoapModels(License[] models) {
		LicenseSoap[] soapModels = new LicenseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LicenseSoap[][] toSoapModels(License[][] models) {
		LicenseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LicenseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LicenseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LicenseSoap[] toSoapModels(List<License> models) {
		List<LicenseSoap> soapModels = new ArrayList<LicenseSoap>(models.size());

		for (License model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LicenseSoap[soapModels.size()]);
	}

	public LicenseSoap() {
	}

	public long getPrimaryKey() {
		return _licenseId;
	}

	public void setPrimaryKey(long pk) {
		setLicenseId(pk);
	}

	public long getLicenseId() {
		return _licenseId;
	}

	public void setLicenseId(long licenseId) {
		_licenseId = licenseId;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getShortIdentifier() {
		return _shortIdentifier;
	}

	public void setShortIdentifier(String shortIdentifier) {
		_shortIdentifier = shortIdentifier;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getSchemeName() {
		return _schemeName;
	}

	public void setSchemeName(String schemeName) {
		_schemeName = schemeName;
	}

	public String getSchemeUrl() {
		return _schemeUrl;
	}

	public void setSchemeUrl(String schemeUrl) {
		_schemeUrl = schemeUrl;
	}

	public boolean getSelectable() {
		return _selectable;
	}

	public boolean isSelectable() {
		return _selectable;
	}

	public void setSelectable(boolean selectable) {
		_selectable = selectable;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _licenseId;
	private String _fullName;
	private String _shortIdentifier;
	private String _url;
	private String _schemeName;
	private String _schemeUrl;
	private boolean _selectable;
	private String _description;
}