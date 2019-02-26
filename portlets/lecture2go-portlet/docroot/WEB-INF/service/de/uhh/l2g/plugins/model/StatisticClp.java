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
import de.uhh.l2g.plugins.service.StatisticLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class StatisticClp extends BaseModelImpl<Statistic> implements Statistic {
	public StatisticClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Statistic.class;
	}

	@Override
	public String getModelClassName() {
		return Statistic.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _statisticId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStatisticId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statisticId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("createDate", getCreateDate());
		attributes.put("publicVideos", getPublicVideos());
		attributes.put("privateVideos", getPrivateVideos());
		attributes.put("autofillRow", getAutofillRow());
		attributes.put("statisticId", getStatisticId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Integer publicVideos = (Integer)attributes.get("publicVideos");

		if (publicVideos != null) {
			setPublicVideos(publicVideos);
		}

		Integer privateVideos = (Integer)attributes.get("privateVideos");

		if (privateVideos != null) {
			setPrivateVideos(privateVideos);
		}

		Integer autofillRow = (Integer)attributes.get("autofillRow");

		if (autofillRow != null) {
			setAutofillRow(autofillRow);
		}

		Long statisticId = (Long)attributes.get("statisticId");

		if (statisticId != null) {
			setStatisticId(statisticId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_statisticRemoteModel != null) {
			try {
				Class<?> clazz = _statisticRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_statisticRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPublicVideos() {
		return _publicVideos;
	}

	@Override
	public void setPublicVideos(int publicVideos) {
		_publicVideos = publicVideos;

		if (_statisticRemoteModel != null) {
			try {
				Class<?> clazz = _statisticRemoteModel.getClass();

				Method method = clazz.getMethod("setPublicVideos", int.class);

				method.invoke(_statisticRemoteModel, publicVideos);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPrivateVideos() {
		return _privateVideos;
	}

	@Override
	public void setPrivateVideos(int privateVideos) {
		_privateVideos = privateVideos;

		if (_statisticRemoteModel != null) {
			try {
				Class<?> clazz = _statisticRemoteModel.getClass();

				Method method = clazz.getMethod("setPrivateVideos", int.class);

				method.invoke(_statisticRemoteModel, privateVideos);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAutofillRow() {
		return _autofillRow;
	}

	@Override
	public void setAutofillRow(int autofillRow) {
		_autofillRow = autofillRow;

		if (_statisticRemoteModel != null) {
			try {
				Class<?> clazz = _statisticRemoteModel.getClass();

				Method method = clazz.getMethod("setAutofillRow", int.class);

				method.invoke(_statisticRemoteModel, autofillRow);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatisticId() {
		return _statisticId;
	}

	@Override
	public void setStatisticId(long statisticId) {
		_statisticId = statisticId;

		if (_statisticRemoteModel != null) {
			try {
				Class<?> clazz = _statisticRemoteModel.getClass();

				Method method = clazz.getMethod("setStatisticId", long.class);

				method.invoke(_statisticRemoteModel, statisticId);
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

		if (_statisticRemoteModel != null) {
			try {
				Class<?> clazz = _statisticRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_statisticRemoteModel, groupId);
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

		if (_statisticRemoteModel != null) {
			try {
				Class<?> clazz = _statisticRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_statisticRemoteModel, companyId);
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

		if (_statisticRemoteModel != null) {
			try {
				Class<?> clazz = _statisticRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_statisticRemoteModel, userId);
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

		if (_statisticRemoteModel != null) {
			try {
				Class<?> clazz = _statisticRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_statisticRemoteModel, userName);
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

		if (_statisticRemoteModel != null) {
			try {
				Class<?> clazz = _statisticRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_statisticRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStatisticRemoteModel() {
		return _statisticRemoteModel;
	}

	public void setStatisticRemoteModel(BaseModel<?> statisticRemoteModel) {
		_statisticRemoteModel = statisticRemoteModel;
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

		Class<?> remoteModelClass = _statisticRemoteModel.getClass();

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

		Object returnValue = method.invoke(_statisticRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StatisticLocalServiceUtil.addStatistic(this);
		}
		else {
			StatisticLocalServiceUtil.updateStatistic(this);
		}
	}

	@Override
	public Statistic toEscapedModel() {
		return (Statistic)ProxyUtil.newProxyInstance(Statistic.class.getClassLoader(),
			new Class[] { Statistic.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StatisticClp clone = new StatisticClp();

		clone.setCreateDate(getCreateDate());
		clone.setPublicVideos(getPublicVideos());
		clone.setPrivateVideos(getPrivateVideos());
		clone.setAutofillRow(getAutofillRow());
		clone.setStatisticId(getStatisticId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Statistic statistic) {
		long primaryKey = statistic.getPrimaryKey();

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

		if (!(obj instanceof StatisticClp)) {
			return false;
		}

		StatisticClp statistic = (StatisticClp)obj;

		long primaryKey = statistic.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{createDate=");
		sb.append(getCreateDate());
		sb.append(", publicVideos=");
		sb.append(getPublicVideos());
		sb.append(", privateVideos=");
		sb.append(getPrivateVideos());
		sb.append(", autofillRow=");
		sb.append(getAutofillRow());
		sb.append(", statisticId=");
		sb.append(getStatisticId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Statistic");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publicVideos</column-name><column-value><![CDATA[");
		sb.append(getPublicVideos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privateVideos</column-name><column-value><![CDATA[");
		sb.append(getPrivateVideos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>autofillRow</column-name><column-value><![CDATA[");
		sb.append(getAutofillRow());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statisticId</column-name><column-value><![CDATA[");
		sb.append(getStatisticId());
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
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Date _createDate;
	private int _publicVideos;
	private int _privateVideos;
	private int _autofillRow;
	private long _statisticId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _modifiedDate;
	private BaseModel<?> _statisticRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}