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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ScheduledThread}.
 * </p>
 *
 * @author Iavor Sturm
 * @see ScheduledThread
 * @generated
 */
public class ScheduledThreadWrapper implements ScheduledThread,
	ModelWrapper<ScheduledThread> {
	public ScheduledThreadWrapper(ScheduledThread scheduledThread) {
		_scheduledThread = scheduledThread;
	}

	@Override
	public Class<?> getModelClass() {
		return ScheduledThread.class;
	}

	@Override
	public String getModelClassName() {
		return ScheduledThread.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scheduledThreadId", getScheduledThreadId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("schedulerClassName", getSchedulerClassName());
		attributes.put("cronText", getCronText());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scheduledThreadId = (Long)attributes.get("scheduledThreadId");

		if (scheduledThreadId != null) {
			setScheduledThreadId(scheduledThreadId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String schedulerClassName = (String)attributes.get("schedulerClassName");

		if (schedulerClassName != null) {
			setSchedulerClassName(schedulerClassName);
		}

		String cronText = (String)attributes.get("cronText");

		if (cronText != null) {
			setCronText(cronText);
		}
	}

	/**
	* Returns the primary key of this scheduled thread.
	*
	* @return the primary key of this scheduled thread
	*/
	@Override
	public long getPrimaryKey() {
		return _scheduledThread.getPrimaryKey();
	}

	/**
	* Sets the primary key of this scheduled thread.
	*
	* @param primaryKey the primary key of this scheduled thread
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_scheduledThread.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the scheduled thread ID of this scheduled thread.
	*
	* @return the scheduled thread ID of this scheduled thread
	*/
	@Override
	public long getScheduledThreadId() {
		return _scheduledThread.getScheduledThreadId();
	}

	/**
	* Sets the scheduled thread ID of this scheduled thread.
	*
	* @param scheduledThreadId the scheduled thread ID of this scheduled thread
	*/
	@Override
	public void setScheduledThreadId(long scheduledThreadId) {
		_scheduledThread.setScheduledThreadId(scheduledThreadId);
	}

	/**
	* Returns the group ID of this scheduled thread.
	*
	* @return the group ID of this scheduled thread
	*/
	@Override
	public long getGroupId() {
		return _scheduledThread.getGroupId();
	}

	/**
	* Sets the group ID of this scheduled thread.
	*
	* @param groupId the group ID of this scheduled thread
	*/
	@Override
	public void setGroupId(long groupId) {
		_scheduledThread.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this scheduled thread.
	*
	* @return the company ID of this scheduled thread
	*/
	@Override
	public long getCompanyId() {
		return _scheduledThread.getCompanyId();
	}

	/**
	* Sets the company ID of this scheduled thread.
	*
	* @param companyId the company ID of this scheduled thread
	*/
	@Override
	public void setCompanyId(long companyId) {
		_scheduledThread.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this scheduled thread.
	*
	* @return the user ID of this scheduled thread
	*/
	@Override
	public long getUserId() {
		return _scheduledThread.getUserId();
	}

	/**
	* Sets the user ID of this scheduled thread.
	*
	* @param userId the user ID of this scheduled thread
	*/
	@Override
	public void setUserId(long userId) {
		_scheduledThread.setUserId(userId);
	}

	/**
	* Returns the user uuid of this scheduled thread.
	*
	* @return the user uuid of this scheduled thread
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThread.getUserUuid();
	}

	/**
	* Sets the user uuid of this scheduled thread.
	*
	* @param userUuid the user uuid of this scheduled thread
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_scheduledThread.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this scheduled thread.
	*
	* @return the user name of this scheduled thread
	*/
	@Override
	public java.lang.String getUserName() {
		return _scheduledThread.getUserName();
	}

	/**
	* Sets the user name of this scheduled thread.
	*
	* @param userName the user name of this scheduled thread
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_scheduledThread.setUserName(userName);
	}

	/**
	* Returns the create date of this scheduled thread.
	*
	* @return the create date of this scheduled thread
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _scheduledThread.getCreateDate();
	}

	/**
	* Sets the create date of this scheduled thread.
	*
	* @param createDate the create date of this scheduled thread
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_scheduledThread.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this scheduled thread.
	*
	* @return the modified date of this scheduled thread
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _scheduledThread.getModifiedDate();
	}

	/**
	* Sets the modified date of this scheduled thread.
	*
	* @param modifiedDate the modified date of this scheduled thread
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_scheduledThread.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the scheduler class name of this scheduled thread.
	*
	* @return the scheduler class name of this scheduled thread
	*/
	@Override
	public java.lang.String getSchedulerClassName() {
		return _scheduledThread.getSchedulerClassName();
	}

	/**
	* Sets the scheduler class name of this scheduled thread.
	*
	* @param schedulerClassName the scheduler class name of this scheduled thread
	*/
	@Override
	public void setSchedulerClassName(java.lang.String schedulerClassName) {
		_scheduledThread.setSchedulerClassName(schedulerClassName);
	}

	/**
	* Returns the cron text of this scheduled thread.
	*
	* @return the cron text of this scheduled thread
	*/
	@Override
	public java.lang.String getCronText() {
		return _scheduledThread.getCronText();
	}

	/**
	* Sets the cron text of this scheduled thread.
	*
	* @param cronText the cron text of this scheduled thread
	*/
	@Override
	public void setCronText(java.lang.String cronText) {
		_scheduledThread.setCronText(cronText);
	}

	@Override
	public boolean isNew() {
		return _scheduledThread.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_scheduledThread.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _scheduledThread.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scheduledThread.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _scheduledThread.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _scheduledThread.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_scheduledThread.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scheduledThread.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_scheduledThread.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_scheduledThread.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scheduledThread.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ScheduledThreadWrapper((ScheduledThread)_scheduledThread.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread) {
		return _scheduledThread.compareTo(scheduledThread);
	}

	@Override
	public int hashCode() {
		return _scheduledThread.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.ScheduledThread> toCacheModel() {
		return _scheduledThread.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread toEscapedModel() {
		return new ScheduledThreadWrapper(_scheduledThread.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread toUnescapedModel() {
		return new ScheduledThreadWrapper(_scheduledThread.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _scheduledThread.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _scheduledThread.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scheduledThread.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScheduledThreadWrapper)) {
			return false;
		}

		ScheduledThreadWrapper scheduledThreadWrapper = (ScheduledThreadWrapper)obj;

		if (Validator.equals(_scheduledThread,
					scheduledThreadWrapper._scheduledThread)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ScheduledThread getWrappedScheduledThread() {
		return _scheduledThread;
	}

	@Override
	public ScheduledThread getWrappedModel() {
		return _scheduledThread;
	}

	@Override
	public void resetOriginalValues() {
		_scheduledThread.resetOriginalValues();
	}

	private ScheduledThread _scheduledThread;
}