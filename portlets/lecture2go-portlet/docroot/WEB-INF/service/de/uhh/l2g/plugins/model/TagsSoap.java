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
public class TagsSoap implements Serializable {
	public static TagsSoap toSoapModel(Tags model) {
		TagsSoap soapModel = new TagsSoap();

		soapModel.setTagId(model.getTagId());
		soapModel.setIsVideo(model.getIsVideo());
		soapModel.setIsLectureseries(model.getIsLectureseries());
		soapModel.setTags(model.getTags());

		return soapModel;
	}

	public static TagsSoap[] toSoapModels(Tags[] models) {
		TagsSoap[] soapModels = new TagsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TagsSoap[][] toSoapModels(Tags[][] models) {
		TagsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TagsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TagsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TagsSoap[] toSoapModels(List<Tags> models) {
		List<TagsSoap> soapModels = new ArrayList<TagsSoap>(models.size());

		for (Tags model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TagsSoap[soapModels.size()]);
	}

	public TagsSoap() {
	}

	public long getPrimaryKey() {
		return _tagId;
	}

	public void setPrimaryKey(long pk) {
		setTagId(pk);
	}

	public long getTagId() {
		return _tagId;
	}

	public void setTagId(long tagId) {
		_tagId = tagId;
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

	private long _tagId;
	private int _isVideo;
	private int _isLectureseries;
	private String _tags;
}