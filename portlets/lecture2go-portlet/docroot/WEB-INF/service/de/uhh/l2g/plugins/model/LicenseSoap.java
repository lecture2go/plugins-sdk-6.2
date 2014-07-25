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
public class LicenseSoap implements Serializable {
	public static LicenseSoap toSoapModel(License model) {
		LicenseSoap soapModel = new LicenseSoap();

		soapModel.setLicenseId(model.getLicenseId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setCcby(model.getCcby());
		soapModel.setCcbybc(model.getCcbybc());
		soapModel.setCcbyncnd(model.getCcbyncnd());
		soapModel.setCcbyncsa(model.getCcbyncsa());
		soapModel.setCcbysa(model.getCcbysa());
		soapModel.setCcbync(model.getCcbync());
		soapModel.setL2go(model.getL2go());

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

	public int getPrimaryKey() {
		return _licenseId;
	}

	public void setPrimaryKey(int pk) {
		setLicenseId(pk);
	}

	public int getLicenseId() {
		return _licenseId;
	}

	public void setLicenseId(int licenseId) {
		_licenseId = licenseId;
	}

	public int getVideoId() {
		return _videoId;
	}

	public void setVideoId(int videoId) {
		_videoId = videoId;
	}

	public String getCcby() {
		return _ccby;
	}

	public void setCcby(String ccby) {
		_ccby = ccby;
	}

	public String getCcbybc() {
		return _ccbybc;
	}

	public void setCcbybc(String ccbybc) {
		_ccbybc = ccbybc;
	}

	public String getCcbyncnd() {
		return _ccbyncnd;
	}

	public void setCcbyncnd(String ccbyncnd) {
		_ccbyncnd = ccbyncnd;
	}

	public String getCcbyncsa() {
		return _ccbyncsa;
	}

	public void setCcbyncsa(String ccbyncsa) {
		_ccbyncsa = ccbyncsa;
	}

	public String getCcbysa() {
		return _ccbysa;
	}

	public void setCcbysa(String ccbysa) {
		_ccbysa = ccbysa;
	}

	public String getCcbync() {
		return _ccbync;
	}

	public void setCcbync(String ccbync) {
		_ccbync = ccbync;
	}

	public String getL2go() {
		return _l2go;
	}

	public void setL2go(String l2go) {
		_l2go = l2go;
	}

	private int _licenseId;
	private int _videoId;
	private String _ccby;
	private String _ccbybc;
	private String _ccbyncnd;
	private String _ccbyncsa;
	private String _ccbysa;
	private String _ccbync;
	private String _l2go;
}