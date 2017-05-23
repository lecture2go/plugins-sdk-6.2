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
public class LegacyVideoFacilitySoap implements Serializable {
	public static LegacyVideoFacilitySoap toSoapModel(LegacyVideoFacility model) {
		LegacyVideoFacilitySoap soapModel = new LegacyVideoFacilitySoap();

		soapModel.setVideoFacilityId(model.getVideoFacilityId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setFacilityId(model.getFacilityId());

		return soapModel;
	}

	public static LegacyVideoFacilitySoap[] toSoapModels(
		LegacyVideoFacility[] models) {
		LegacyVideoFacilitySoap[] soapModels = new LegacyVideoFacilitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyVideoFacilitySoap[][] toSoapModels(
		LegacyVideoFacility[][] models) {
		LegacyVideoFacilitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyVideoFacilitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyVideoFacilitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyVideoFacilitySoap[] toSoapModels(
		List<LegacyVideoFacility> models) {
		List<LegacyVideoFacilitySoap> soapModels = new ArrayList<LegacyVideoFacilitySoap>(models.size());

		for (LegacyVideoFacility model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyVideoFacilitySoap[soapModels.size()]);
	}

	public LegacyVideoFacilitySoap() {
	}

	public long getPrimaryKey() {
		return _videoFacilityId;
	}

	public void setPrimaryKey(long pk) {
		setVideoFacilityId(pk);
	}

	public long getVideoFacilityId() {
		return _videoFacilityId;
	}

	public void setVideoFacilityId(long videoFacilityId) {
		_videoFacilityId = videoFacilityId;
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public long getFacilityId() {
		return _facilityId;
	}

	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;
	}

	private long _videoFacilityId;
	private long _videoId;
	private long _facilityId;
}