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
public class TagcloudSoap implements Serializable {
	public static TagcloudSoap toSoapModel(Tagcloud model) {
		TagcloudSoap soapModel = new TagcloudSoap();

		soapModel.setTagcloudId(model.getTagcloudId());
		soapModel.setIsVideo(model.getIsVideo());
		soapModel.setIsLectureseries(model.getIsLectureseries());
		soapModel.setTags(model.getTags());

		return soapModel;
	}

	public static TagcloudSoap[] toSoapModels(Tagcloud[] models) {
		TagcloudSoap[] soapModels = new TagcloudSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TagcloudSoap[][] toSoapModels(Tagcloud[][] models) {
		TagcloudSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TagcloudSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TagcloudSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TagcloudSoap[] toSoapModels(List<Tagcloud> models) {
		List<TagcloudSoap> soapModels = new ArrayList<TagcloudSoap>(models.size());

		for (Tagcloud model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TagcloudSoap[soapModels.size()]);
	}

	public TagcloudSoap() {
	}

	public long getPrimaryKey() {
		return _tagcloudId;
	}

	public void setPrimaryKey(long pk) {
		setTagcloudId(pk);
	}

	public long getTagcloudId() {
		return _tagcloudId;
	}

	public void setTagcloudId(long tagcloudId) {
		_tagcloudId = tagcloudId;
	}

	public int getIsVideo() {
		return _isVideo;
	}

	public void setIsVideo(int isVideo) {
		_isVideo = isVideo;
	}

	public int getIsLectureseries() {
		return _isLectureseries;
	}

	public void setIsLectureseries(int isLectureseries) {
		_isLectureseries = isLectureseries;
	}

	public String getTags() {
		return _tags;
	}

	public void setTags(String tags) {
		_tags = tags;
	}

	private long _tagcloudId;
	private int _isVideo;
	private int _isLectureseries;
	private String _tags;
}