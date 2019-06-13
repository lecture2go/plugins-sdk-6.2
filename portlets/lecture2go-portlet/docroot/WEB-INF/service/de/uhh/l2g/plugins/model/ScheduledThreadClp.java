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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.ScheduledThreadLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class ScheduledThreadClp extends BaseModelImpl<ScheduledThread>
	implements ScheduledThread {
	public ScheduledThreadClp() {
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
	public long getPrimaryKey() {
		return _scheduledThreadId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScheduledThreadId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scheduledThreadId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getScheduledThreadId() {
		return _scheduledThreadId;
	}

	@Override
	public void setScheduledThreadId(long scheduledThreadId) {
		_scheduledThreadId = scheduledThreadId;

		if (_scheduledThreadRemoteModel != null) {
			try {
				Class<?> clazz = _scheduledThreadRemoteModel.getClass();

				Method method = clazz.getMethod("setScheduledThreadId",
						long.class);

				method.invoke(_scheduledThreadRemoteModel, scheduledThreadId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_scheduledThreadRemoteModel != null) {
			try {
				Class<?> clazz = _scheduledThreadRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_scheduledThreadRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_scheduledThreadRemoteModel != null) {
			try {
				Class<?> clazz = _scheduledThreadRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_scheduledThreadRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_scheduledThreadRemoteModel != null) {
			try {
				Class<?> clazz = _scheduledThreadRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_scheduledThreadRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_scheduledThreadRemoteModel != null) {
			try {
				Class<?> clazz = _scheduledThreadRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_scheduledThreadRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_scheduledThreadRemoteModel != null) {
			try {
				Class<?> clazz = _scheduledThreadRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_scheduledThreadRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_scheduledThreadRemoteModel != null) {
			try {
				Class<?> clazz = _scheduledThreadRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_scheduledThreadRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSchedulerClassName() {
		return _schedulerClassName;
	}

	@Override
	public void setSchedulerClassName(String schedulerClassName) {
		_schedulerClassName = schedulerClassName;

		if (_scheduledThreadRemoteModel != null) {
			try {
				Class<?> clazz = _scheduledThreadRemoteModel.getClass();

				Method method = clazz.getMethod("setSchedulerClassName",
						String.class);

				method.invoke(_scheduledThreadRemoteModel, schedulerClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCronText() {
		return _cronText;
	}

	@Override
	public void setCronText(String cronText) {
		_cronText = cronText;

		if (_scheduledThreadRemoteModel != null) {
			try {
				Class<?> clazz = _scheduledThreadRemoteModel.getClass();

				Method method = clazz.getMethod("setCronText", String.class);

				method.invoke(_scheduledThreadRemoteModel, cronText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getScheduledThreadRemoteModel() {
		return _scheduledThreadRemoteModel;
	}

	public void setScheduledThreadRemoteModel(
		BaseModel<?> scheduledThreadRemoteModel) {
		_scheduledThreadRemoteModel = scheduledThreadRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _scheduledThreadRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_scheduledThreadRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ScheduledThreadLocalServiceUtil.addScheduledThread(this);
		}
		else {
			ScheduledThreadLocalServiceUtil.updateScheduledThread(this);
		}
	}

	@Override
	public ScheduledThread toEscapedModel() {
		return (ScheduledThread)ProxyUtil.newProxyInstance(ScheduledThread.class.getClassLoader(),
			new Class[] { ScheduledThread.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScheduledThreadClp clone = new ScheduledThreadClp();

		clone.setScheduledThreadId(getScheduledThreadId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSchedulerClassName(getSchedulerClassName());
		clone.setCronText(getCronText());

		return clone;
	}

	@Override
	public int compareTo(ScheduledThread scheduledThread) {
		long primaryKey = scheduledThread.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScheduledThreadClp)) {
			return false;
		}

		ScheduledThreadClp scheduledThread = (ScheduledThreadClp)obj;

		long primaryKey = scheduledThread.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{scheduledThreadId=");
		sb.append(getScheduledThreadId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", schedulerClassName=");
		sb.append(getSchedulerClassName());
		sb.append(", cronText=");
		sb.append(getCronText());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.ScheduledThread");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scheduledThreadId</column-name><column-value><![CDATA[");
		sb.append(getScheduledThreadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>schedulerClassName</column-name><column-value><![CDATA[");
		sb.append(getSchedulerClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cronText</column-name><column-value><![CDATA[");
		sb.append(getCronText());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _scheduledThreadId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _schedulerClassName;
	private String _cronText;
	private BaseModel<?> _scheduledThreadRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}