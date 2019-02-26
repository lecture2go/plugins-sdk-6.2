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

import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.VideoStatisticLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class VideoStatisticClp extends BaseModelImpl<VideoStatistic>
	implements VideoStatistic {
	public VideoStatisticClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VideoStatistic.class;
	}

	@Override
	public String getModelClassName() {
		return VideoStatistic.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _videoStatisticId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVideoStatisticId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _videoStatisticId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoStatisticId", getVideoStatisticId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("compareDate", getCompareDate());
		attributes.put("totalVideos", getTotalVideos());
		attributes.put("publicVideos", getPublicVideos());
		attributes.put("privateVideos", getPrivateVideos());
		attributes.put("currentTotal", getCurrentTotal());
		attributes.put("currentPublic", getCurrentPublic());
		attributes.put("currentPrivate", getCurrentPrivate());
		attributes.put("pubPercent", getPubPercent());
		attributes.put("privPercent", getPrivPercent());
		attributes.put("currentPubPercent", getCurrentPubPercent());
		attributes.put("currentPrivPercent", getCurrentPrivPercent());
		attributes.put("intervalName", getIntervalName());
		attributes.put("publicDiff", getPublicDiff());
		attributes.put("privateDiff", getPrivateDiff());
		attributes.put("totalDiff", getTotalDiff());
		attributes.put("dateDiff", getDateDiff());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoStatisticId = (Long)attributes.get("videoStatisticId");

		if (videoStatisticId != null) {
			setVideoStatisticId(videoStatisticId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date compareDate = (Date)attributes.get("compareDate");

		if (compareDate != null) {
			setCompareDate(compareDate);
		}

		Long totalVideos = (Long)attributes.get("totalVideos");

		if (totalVideos != null) {
			setTotalVideos(totalVideos);
		}

		Long publicVideos = (Long)attributes.get("publicVideos");

		if (publicVideos != null) {
			setPublicVideos(publicVideos);
		}

		Long privateVideos = (Long)attributes.get("privateVideos");

		if (privateVideos != null) {
			setPrivateVideos(privateVideos);
		}

		Long currentTotal = (Long)attributes.get("currentTotal");

		if (currentTotal != null) {
			setCurrentTotal(currentTotal);
		}

		Long currentPublic = (Long)attributes.get("currentPublic");

		if (currentPublic != null) {
			setCurrentPublic(currentPublic);
		}

		Long currentPrivate = (Long)attributes.get("currentPrivate");

		if (currentPrivate != null) {
			setCurrentPrivate(currentPrivate);
		}

		Integer pubPercent = (Integer)attributes.get("pubPercent");

		if (pubPercent != null) {
			setPubPercent(pubPercent);
		}

		Integer privPercent = (Integer)attributes.get("privPercent");

		if (privPercent != null) {
			setPrivPercent(privPercent);
		}

		Integer currentPubPercent = (Integer)attributes.get("currentPubPercent");

		if (currentPubPercent != null) {
			setCurrentPubPercent(currentPubPercent);
		}

		Integer currentPrivPercent = (Integer)attributes.get(
				"currentPrivPercent");

		if (currentPrivPercent != null) {
			setCurrentPrivPercent(currentPrivPercent);
		}

		String intervalName = (String)attributes.get("intervalName");

		if (intervalName != null) {
			setIntervalName(intervalName);
		}

		Integer publicDiff = (Integer)attributes.get("publicDiff");

		if (publicDiff != null) {
			setPublicDiff(publicDiff);
		}

		Integer privateDiff = (Integer)attributes.get("privateDiff");

		if (privateDiff != null) {
			setPrivateDiff(privateDiff);
		}

		Integer totalDiff = (Integer)attributes.get("totalDiff");

		if (totalDiff != null) {
			setTotalDiff(totalDiff);
		}

		Integer dateDiff = (Integer)attributes.get("dateDiff");

		if (dateDiff != null) {
			setDateDiff(dateDiff);
		}
	}

	@Override
	public long getVideoStatisticId() {
		return _videoStatisticId;
	}

	@Override
	public void setVideoStatisticId(long videoStatisticId) {
		_videoStatisticId = videoStatisticId;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoStatisticId",
						long.class);

				method.invoke(_videoStatisticRemoteModel, videoStatisticId);
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

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_videoStatisticRemoteModel, groupId);
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

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_videoStatisticRemoteModel, companyId);
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

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_videoStatisticRemoteModel, createDate);
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

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_videoStatisticRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCompareDate() {
		return _compareDate;
	}

	@Override
	public void setCompareDate(Date compareDate) {
		_compareDate = compareDate;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setCompareDate", Date.class);

				method.invoke(_videoStatisticRemoteModel, compareDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTotalVideos() {
		return _totalVideos;
	}

	@Override
	public void setTotalVideos(long totalVideos) {
		_totalVideos = totalVideos;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalVideos", long.class);

				method.invoke(_videoStatisticRemoteModel, totalVideos);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublicVideos() {
		return _publicVideos;
	}

	@Override
	public void setPublicVideos(long publicVideos) {
		_publicVideos = publicVideos;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setPublicVideos", long.class);

				method.invoke(_videoStatisticRemoteModel, publicVideos);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPrivateVideos() {
		return _privateVideos;
	}

	@Override
	public void setPrivateVideos(long privateVideos) {
		_privateVideos = privateVideos;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setPrivateVideos", long.class);

				method.invoke(_videoStatisticRemoteModel, privateVideos);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCurrentTotal() {
		return _currentTotal;
	}

	@Override
	public void setCurrentTotal(long currentTotal) {
		_currentTotal = currentTotal;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentTotal", long.class);

				method.invoke(_videoStatisticRemoteModel, currentTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCurrentPublic() {
		return _currentPublic;
	}

	@Override
	public void setCurrentPublic(long currentPublic) {
		_currentPublic = currentPublic;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentPublic", long.class);

				method.invoke(_videoStatisticRemoteModel, currentPublic);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCurrentPrivate() {
		return _currentPrivate;
	}

	@Override
	public void setCurrentPrivate(long currentPrivate) {
		_currentPrivate = currentPrivate;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentPrivate", long.class);

				method.invoke(_videoStatisticRemoteModel, currentPrivate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPubPercent() {
		return _pubPercent;
	}

	@Override
	public void setPubPercent(int pubPercent) {
		_pubPercent = pubPercent;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setPubPercent", int.class);

				method.invoke(_videoStatisticRemoteModel, pubPercent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPrivPercent() {
		return _privPercent;
	}

	@Override
	public void setPrivPercent(int privPercent) {
		_privPercent = privPercent;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setPrivPercent", int.class);

				method.invoke(_videoStatisticRemoteModel, privPercent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCurrentPubPercent() {
		return _currentPubPercent;
	}

	@Override
	public void setCurrentPubPercent(int currentPubPercent) {
		_currentPubPercent = currentPubPercent;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentPubPercent",
						int.class);

				method.invoke(_videoStatisticRemoteModel, currentPubPercent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCurrentPrivPercent() {
		return _currentPrivPercent;
	}

	@Override
	public void setCurrentPrivPercent(int currentPrivPercent) {
		_currentPrivPercent = currentPrivPercent;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentPrivPercent",
						int.class);

				method.invoke(_videoStatisticRemoteModel, currentPrivPercent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIntervalName() {
		return _intervalName;
	}

	@Override
	public void setIntervalName(String intervalName) {
		_intervalName = intervalName;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setIntervalName", String.class);

				method.invoke(_videoStatisticRemoteModel, intervalName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPublicDiff() {
		return _publicDiff;
	}

	@Override
	public void setPublicDiff(int publicDiff) {
		_publicDiff = publicDiff;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setPublicDiff", int.class);

				method.invoke(_videoStatisticRemoteModel, publicDiff);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPrivateDiff() {
		return _privateDiff;
	}

	@Override
	public void setPrivateDiff(int privateDiff) {
		_privateDiff = privateDiff;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setPrivateDiff", int.class);

				method.invoke(_videoStatisticRemoteModel, privateDiff);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTotalDiff() {
		return _totalDiff;
	}

	@Override
	public void setTotalDiff(int totalDiff) {
		_totalDiff = totalDiff;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalDiff", int.class);

				method.invoke(_videoStatisticRemoteModel, totalDiff);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDateDiff() {
		return _dateDiff;
	}

	@Override
	public void setDateDiff(int dateDiff) {
		_dateDiff = dateDiff;

		if (_videoStatisticRemoteModel != null) {
			try {
				Class<?> clazz = _videoStatisticRemoteModel.getClass();

				Method method = clazz.getMethod("setDateDiff", int.class);

				method.invoke(_videoStatisticRemoteModel, dateDiff);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVideoStatisticRemoteModel() {
		return _videoStatisticRemoteModel;
	}

	public void setVideoStatisticRemoteModel(
		BaseModel<?> videoStatisticRemoteModel) {
		_videoStatisticRemoteModel = videoStatisticRemoteModel;
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

		Class<?> remoteModelClass = _videoStatisticRemoteModel.getClass();

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

		Object returnValue = method.invoke(_videoStatisticRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoStatisticLocalServiceUtil.addVideoStatistic(this);
		}
		else {
			VideoStatisticLocalServiceUtil.updateVideoStatistic(this);
		}
	}

	@Override
	public VideoStatistic toEscapedModel() {
		return (VideoStatistic)ProxyUtil.newProxyInstance(VideoStatistic.class.getClassLoader(),
			new Class[] { VideoStatistic.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoStatisticClp clone = new VideoStatisticClp();

		clone.setVideoStatisticId(getVideoStatisticId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCompareDate(getCompareDate());
		clone.setTotalVideos(getTotalVideos());
		clone.setPublicVideos(getPublicVideos());
		clone.setPrivateVideos(getPrivateVideos());
		clone.setCurrentTotal(getCurrentTotal());
		clone.setCurrentPublic(getCurrentPublic());
		clone.setCurrentPrivate(getCurrentPrivate());
		clone.setPubPercent(getPubPercent());
		clone.setPrivPercent(getPrivPercent());
		clone.setCurrentPubPercent(getCurrentPubPercent());
		clone.setCurrentPrivPercent(getCurrentPrivPercent());
		clone.setIntervalName(getIntervalName());
		clone.setPublicDiff(getPublicDiff());
		clone.setPrivateDiff(getPrivateDiff());
		clone.setTotalDiff(getTotalDiff());
		clone.setDateDiff(getDateDiff());

		return clone;
	}

	@Override
	public int compareTo(VideoStatistic videoStatistic) {
		long primaryKey = videoStatistic.getPrimaryKey();

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

		if (!(obj instanceof VideoStatisticClp)) {
			return false;
		}

		VideoStatisticClp videoStatistic = (VideoStatisticClp)obj;

		long primaryKey = videoStatistic.getPrimaryKey();

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
		StringBundler sb = new StringBundler(43);

		sb.append("{videoStatisticId=");
		sb.append(getVideoStatisticId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", compareDate=");
		sb.append(getCompareDate());
		sb.append(", totalVideos=");
		sb.append(getTotalVideos());
		sb.append(", publicVideos=");
		sb.append(getPublicVideos());
		sb.append(", privateVideos=");
		sb.append(getPrivateVideos());
		sb.append(", currentTotal=");
		sb.append(getCurrentTotal());
		sb.append(", currentPublic=");
		sb.append(getCurrentPublic());
		sb.append(", currentPrivate=");
		sb.append(getCurrentPrivate());
		sb.append(", pubPercent=");
		sb.append(getPubPercent());
		sb.append(", privPercent=");
		sb.append(getPrivPercent());
		sb.append(", currentPubPercent=");
		sb.append(getCurrentPubPercent());
		sb.append(", currentPrivPercent=");
		sb.append(getCurrentPrivPercent());
		sb.append(", intervalName=");
		sb.append(getIntervalName());
		sb.append(", publicDiff=");
		sb.append(getPublicDiff());
		sb.append(", privateDiff=");
		sb.append(getPrivateDiff());
		sb.append(", totalDiff=");
		sb.append(getTotalDiff());
		sb.append(", dateDiff=");
		sb.append(getDateDiff());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.VideoStatistic");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoStatisticId</column-name><column-value><![CDATA[");
		sb.append(getVideoStatisticId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>compareDate</column-name><column-value><![CDATA[");
		sb.append(getCompareDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalVideos</column-name><column-value><![CDATA[");
		sb.append(getTotalVideos());
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
			"<column><column-name>currentTotal</column-name><column-value><![CDATA[");
		sb.append(getCurrentTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentPublic</column-name><column-value><![CDATA[");
		sb.append(getCurrentPublic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentPrivate</column-name><column-value><![CDATA[");
		sb.append(getCurrentPrivate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pubPercent</column-name><column-value><![CDATA[");
		sb.append(getPubPercent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privPercent</column-name><column-value><![CDATA[");
		sb.append(getPrivPercent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentPubPercent</column-name><column-value><![CDATA[");
		sb.append(getCurrentPubPercent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentPrivPercent</column-name><column-value><![CDATA[");
		sb.append(getCurrentPrivPercent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>intervalName</column-name><column-value><![CDATA[");
		sb.append(getIntervalName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publicDiff</column-name><column-value><![CDATA[");
		sb.append(getPublicDiff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privateDiff</column-name><column-value><![CDATA[");
		sb.append(getPrivateDiff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDiff</column-name><column-value><![CDATA[");
		sb.append(getTotalDiff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateDiff</column-name><column-value><![CDATA[");
		sb.append(getDateDiff());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _videoStatisticRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}