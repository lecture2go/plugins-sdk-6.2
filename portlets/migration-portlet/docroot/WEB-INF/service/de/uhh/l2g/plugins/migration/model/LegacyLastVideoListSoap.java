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
public class LegacyLastVideoListSoap implements Serializable {
	public static LegacyLastVideoListSoap toSoapModel(LegacyLastVideoList model) {
		LegacyLastVideoListSoap soapModel = new LegacyLastVideoListSoap();

		soapModel.setId(model.getId());
		soapModel.setVideoId(model.getVideoId());

		return soapModel;
	}

	public static LegacyLastVideoListSoap[] toSoapModels(
		LegacyLastVideoList[] models) {
		LegacyLastVideoListSoap[] soapModels = new LegacyLastVideoListSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyLastVideoListSoap[][] toSoapModels(
		LegacyLastVideoList[][] models) {
		LegacyLastVideoListSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyLastVideoListSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyLastVideoListSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyLastVideoListSoap[] toSoapModels(
		List<LegacyLastVideoList> models) {
		List<LegacyLastVideoListSoap> soapModels = new ArrayList<LegacyLastVideoListSoap>(models.size());

		for (LegacyLastVideoList model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyLastVideoListSoap[soapModels.size()]);
	}

	public LegacyLastVideoListSoap() {
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

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	private int _id;
	private long _videoId;
}