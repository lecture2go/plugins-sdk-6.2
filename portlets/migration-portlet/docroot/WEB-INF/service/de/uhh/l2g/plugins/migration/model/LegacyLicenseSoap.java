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
public class LegacyLicenseSoap implements Serializable {
	public static LegacyLicenseSoap toSoapModel(LegacyLicense model) {
		LegacyLicenseSoap soapModel = new LegacyLicenseSoap();

		soapModel.setId(model.getId());
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

	public static LegacyLicenseSoap[] toSoapModels(LegacyLicense[] models) {
		LegacyLicenseSoap[] soapModels = new LegacyLicenseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyLicenseSoap[][] toSoapModels(LegacyLicense[][] models) {
		LegacyLicenseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyLicenseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyLicenseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyLicenseSoap[] toSoapModels(List<LegacyLicense> models) {
		List<LegacyLicenseSoap> soapModels = new ArrayList<LegacyLicenseSoap>(models.size());

		for (LegacyLicense model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyLicenseSoap[soapModels.size()]);
	}

	public LegacyLicenseSoap() {
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

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public int getCcby() {
		return _ccby;
	}

	public void setCcby(int ccby) {
		_ccby = ccby;
	}

	public int getCcbybc() {
		return _ccbybc;
	}

	public void setCcbybc(int ccbybc) {
		_ccbybc = ccbybc;
	}

	public int getCcbyncnd() {
		return _ccbyncnd;
	}

	public void setCcbyncnd(int ccbyncnd) {
		_ccbyncnd = ccbyncnd;
	}

	public int getCcbyncsa() {
		return _ccbyncsa;
	}

	public void setCcbyncsa(int ccbyncsa) {
		_ccbyncsa = ccbyncsa;
	}

	public int getCcbysa() {
		return _ccbysa;
	}

	public void setCcbysa(int ccbysa) {
		_ccbysa = ccbysa;
	}

	public int getCcbync() {
		return _ccbync;
	}

	public void setCcbync(int ccbync) {
		_ccbync = ccbync;
	}

	public int getL2go() {
		return _l2go;
	}

	public void setL2go(int l2go) {
		_l2go = l2go;
	}

	private long _id;
	private long _videoId;
	private int _ccby;
	private int _ccbybc;
	private int _ccbyncnd;
	private int _ccbyncsa;
	private int _ccbysa;
	private int _ccbync;
	private int _l2go;
}