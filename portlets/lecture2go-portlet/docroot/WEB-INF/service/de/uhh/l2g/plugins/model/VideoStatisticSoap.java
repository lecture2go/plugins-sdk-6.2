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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Iavor Sturm
 * @generated
 */
public class VideoStatisticSoap implements Serializable {
	public static VideoStatisticSoap toSoapModel(VideoStatistic model) {
		VideoStatisticSoap soapModel = new VideoStatisticSoap();

		soapModel.setVideoStatisticId(model.getVideoStatisticId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCompareDate(model.getCompareDate());
		soapModel.setTotalVideos(model.getTotalVideos());
		soapModel.setPublicVideos(model.getPublicVideos());
		soapModel.setPrivateVideos(model.getPrivateVideos());
		soapModel.setCurrentTotal(model.getCurrentTotal());
		soapModel.setCurrentPublic(model.getCurrentPublic());
		soapModel.setCurrentPrivate(model.getCurrentPrivate());
		soapModel.setPubPercent(model.getPubPercent());
		soapModel.setPrivPercent(model.getPrivPercent());
		soapModel.setCurrentPubPercent(model.getCurrentPubPercent());
		soapModel.setCurrentPrivPercent(model.getCurrentPrivPercent());
		soapModel.setIntervalName(model.getIntervalName());
		soapModel.setPublicDiff(model.getPublicDiff());
		soapModel.setPrivateDiff(model.getPrivateDiff());
		soapModel.setTotalDiff(model.getTotalDiff());
		soapModel.setDateDiff(model.getDateDiff());

		return soapModel;
	}

	public static VideoStatisticSoap[] toSoapModels(VideoStatistic[] models) {
		VideoStatisticSoap[] soapModels = new VideoStatisticSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoStatisticSoap[][] toSoapModels(VideoStatistic[][] models) {
		VideoStatisticSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoStatisticSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoStatisticSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoStatisticSoap[] toSoapModels(List<VideoStatistic> models) {
		List<VideoStatisticSoap> soapModels = new ArrayList<VideoStatisticSoap>(models.size());

		for (VideoStatistic model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoStatisticSoap[soapModels.size()]);
	}

	public VideoStatisticSoap() {
	}

	public long getPrimaryKey() {
		return _videoStatisticId;
	}

	public void setPrimaryKey(long pk) {
		setVideoStatisticId(pk);
	}

	public long getVideoStatisticId() {
		return _videoStatisticId;
	}

	public void setVideoStatisticId(long videoStatisticId) {
		_videoStatisticId = videoStatisticId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getCompareDate() {
		return _compareDate;
	}

	public void setCompareDate(Date compareDate) {
		_compareDate = compareDate;
	}

	public long getTotalVideos() {
		return _totalVideos;
	}

	public void setTotalVideos(long totalVideos) {
		_totalVideos = totalVideos;
	}

	public long getPublicVideos() {
		return _publicVideos;
	}

	public void setPublicVideos(long publicVideos) {
		_publicVideos = publicVideos;
	}

	public long getPrivateVideos() {
		return _privateVideos;
	}

	public void setPrivateVideos(long privateVideos) {
		_privateVideos = privateVideos;
	}

	public long getCurrentTotal() {
		return _currentTotal;
	}

	public void setCurrentTotal(long currentTotal) {
		_currentTotal = currentTotal;
	}

	public long getCurrentPublic() {
		return _currentPublic;
	}

	public void setCurrentPublic(long currentPublic) {
		_currentPublic = currentPublic;
	}

	public long getCurrentPrivate() {
		return _currentPrivate;
	}

	public void setCurrentPrivate(long currentPrivate) {
		_currentPrivate = currentPrivate;
	}

	public int getPubPercent() {
		return _pubPercent;
	}

	public void setPubPercent(int pubPercent) {
		_pubPercent = pubPercent;
	}

	public int getPrivPercent() {
		return _privPercent;
	}

	public void setPrivPercent(int privPercent) {
		_privPercent = privPercent;
	}

	public int getCurrentPubPercent() {
		return _currentPubPercent;
	}

	public void setCurrentPubPercent(int currentPubPercent) {
		_currentPubPercent = currentPubPercent;
	}

	public int getCurrentPrivPercent() {
		return _currentPrivPercent;
	}

	public void setCurrentPrivPercent(int currentPrivPercent) {
		_currentPrivPercent = currentPrivPercent;
	}

	public String getIntervalName() {
		return _intervalName;
	}

	public void setIntervalName(String intervalName) {
		_intervalName = intervalName;
	}

	public int getPublicDiff() {
		return _publicDiff;
	}

	public void setPublicDiff(int publicDiff) {
		_publicDiff = publicDiff;
	}

	public int getPrivateDiff() {
		return _privateDiff;
	}

	public void setPrivateDiff(int privateDiff) {
		_privateDiff = privateDiff;
	}

	public int getTotalDiff() {
		return _totalDiff;
	}

	public void setTotalDiff(int totalDiff) {
		_totalDiff = totalDiff;
	}

	public int getDateDiff() {
		return _dateDiff;
	}

	public void setDateDiff(int dateDiff) {
		_dateDiff = dateDiff;
	}

	private long _videoStatisticId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _compareDate;
	private long _totalVideos;
	private long _publicVideos;
	private long _privateVideos;
	private long _currentTotal;
	private long _currentPublic;
	private long _currentPrivate;
	private int _pubPercent;
	private int _privPercent;
	private int _currentPubPercent;
	private int _currentPrivPercent;
	private String _intervalName;
	private int _publicDiff;
	private int _privateDiff;
	private int _totalDiff;
	private int _dateDiff;
}