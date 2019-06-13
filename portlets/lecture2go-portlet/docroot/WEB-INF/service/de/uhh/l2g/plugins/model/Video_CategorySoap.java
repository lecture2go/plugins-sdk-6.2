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
public class Video_CategorySoap implements Serializable {
	public static Video_CategorySoap toSoapModel(Video_Category model) {
		Video_CategorySoap soapModel = new Video_CategorySoap();

		soapModel.setVideoCategoryId(model.getVideoCategoryId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setCategoryId(model.getCategoryId());

		return soapModel;
	}

	public static Video_CategorySoap[] toSoapModels(Video_Category[] models) {
		Video_CategorySoap[] soapModels = new Video_CategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Video_CategorySoap[][] toSoapModels(Video_Category[][] models) {
		Video_CategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Video_CategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new Video_CategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Video_CategorySoap[] toSoapModels(List<Video_Category> models) {
		List<Video_CategorySoap> soapModels = new ArrayList<Video_CategorySoap>(models.size());

		for (Video_Category model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Video_CategorySoap[soapModels.size()]);
	}

	public Video_CategorySoap() {
	}

	public long getPrimaryKey() {
		return _videoCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setVideoCategoryId(pk);
	}

	public long getVideoCategoryId() {
		return _videoCategoryId;
	}

	public void setVideoCategoryId(long videoCategoryId) {
		_videoCategoryId = videoCategoryId;
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	private long _videoCategoryId;
	private long _videoId;
	private long _categoryId;
}