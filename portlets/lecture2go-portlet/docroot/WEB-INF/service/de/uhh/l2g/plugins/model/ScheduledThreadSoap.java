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
public class ScheduledThreadSoap implements Serializable {
	public static ScheduledThreadSoap toSoapModel(ScheduledThread model) {
		ScheduledThreadSoap soapModel = new ScheduledThreadSoap();

		soapModel.setScheduledThreadId(model.getScheduledThreadId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSchedulerClassName(model.getSchedulerClassName());
		soapModel.setCronText(model.getCronText());

		return soapModel;
	}

	public static ScheduledThreadSoap[] toSoapModels(ScheduledThread[] models) {
		ScheduledThreadSoap[] soapModels = new ScheduledThreadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScheduledThreadSoap[][] toSoapModels(
		ScheduledThread[][] models) {
		ScheduledThreadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScheduledThreadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScheduledThreadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScheduledThreadSoap[] toSoapModels(
		List<ScheduledThread> models) {
		List<ScheduledThreadSoap> soapModels = new ArrayList<ScheduledThreadSoap>(models.size());

		for (ScheduledThread model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScheduledThreadSoap[soapModels.size()]);
	}

	public ScheduledThreadSoap() {
	}

	public long getPrimaryKey() {
		return _scheduledThreadId;
	}

	public void setPrimaryKey(long pk) {
		setScheduledThreadId(pk);
	}

	public long getScheduledThreadId() {
		return _scheduledThreadId;
	}

	public void setScheduledThreadId(long scheduledThreadId) {
		_scheduledThreadId = scheduledThreadId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public String getSchedulerClassName() {
		return _schedulerClassName;
	}

	public void setSchedulerClassName(String schedulerClassName) {
		_schedulerClassName = schedulerClassName;
	}

	public String getCronText() {
		return _cronText;
	}

	public void setCronText(String cronText) {
		_cronText = cronText;
	}

	private long _scheduledThreadId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _schedulerClassName;
	private String _cronText;
}