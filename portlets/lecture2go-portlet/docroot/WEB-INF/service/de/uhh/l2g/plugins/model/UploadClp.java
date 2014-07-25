/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
import de.uhh.l2g.plugins.service.UploadLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class UploadClp extends BaseModelImpl<Upload> implements Upload {
	public UploadClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Upload.class;
	}

	@Override
	public String getModelClassName() {
		return Upload.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _uploadId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUploadId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _uploadId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uploadId", getUploadId());
		attributes.put("userId", getUserId());
		attributes.put("contentLength", getContentLength());
		attributes.put("timestamp", getTimestamp());
		attributes.put("status", getStatus());
		attributes.put("videoId", getVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long uploadId = (Long)attributes.get("uploadId");

		if (uploadId != null) {
			setUploadId(uploadId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long contentLength = (Long)attributes.get("contentLength");

		if (contentLength != null) {
			setContentLength(contentLength);
		}

		Long timestamp = (Long)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer videoId = (Integer)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}
	}

	@Override
	public long getUploadId() {
		return _uploadId;
	}

	@Override
	public void setUploadId(long uploadId) {
		_uploadId = uploadId;

		if (_uploadRemoteModel != null) {
			try {
				Class<?> clazz = _uploadRemoteModel.getClass();

				Method method = clazz.getMethod("setUploadId", long.class);

				method.invoke(_uploadRemoteModel, uploadId);
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

		if (_uploadRemoteModel != null) {
			try {
				Class<?> clazz = _uploadRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_uploadRemoteModel, userId);
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
	public long getContentLength() {
		return _contentLength;
	}

	@Override
	public void setContentLength(long contentLength) {
		_contentLength = contentLength;

		if (_uploadRemoteModel != null) {
			try {
				Class<?> clazz = _uploadRemoteModel.getClass();

				Method method = clazz.getMethod("setContentLength", long.class);

				method.invoke(_uploadRemoteModel, contentLength);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTimestamp() {
		return _timestamp;
	}

	@Override
	public void setTimestamp(long timestamp) {
		_timestamp = timestamp;

		if (_uploadRemoteModel != null) {
			try {
				Class<?> clazz = _uploadRemoteModel.getClass();

				Method method = clazz.getMethod("setTimestamp", long.class);

				method.invoke(_uploadRemoteModel, timestamp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_uploadRemoteModel != null) {
			try {
				Class<?> clazz = _uploadRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_uploadRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getVideoId() {
		return _videoId;
	}

	@Override
	public void setVideoId(int videoId) {
		_videoId = videoId;

		if (_uploadRemoteModel != null) {
			try {
				Class<?> clazz = _uploadRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", int.class);

				method.invoke(_uploadRemoteModel, videoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUploadRemoteModel() {
		return _uploadRemoteModel;
	}

	public void setUploadRemoteModel(BaseModel<?> uploadRemoteModel) {
		_uploadRemoteModel = uploadRemoteModel;
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

		Class<?> remoteModelClass = _uploadRemoteModel.getClass();

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

		Object returnValue = method.invoke(_uploadRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UploadLocalServiceUtil.addUpload(this);
		}
		else {
			UploadLocalServiceUtil.updateUpload(this);
		}
	}

	@Override
	public Upload toEscapedModel() {
		return (Upload)ProxyUtil.newProxyInstance(Upload.class.getClassLoader(),
			new Class[] { Upload.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UploadClp clone = new UploadClp();

		clone.setUploadId(getUploadId());
		clone.setUserId(getUserId());
		clone.setContentLength(getContentLength());
		clone.setTimestamp(getTimestamp());
		clone.setStatus(getStatus());
		clone.setVideoId(getVideoId());

		return clone;
	}

	@Override
	public int compareTo(Upload upload) {
		long primaryKey = upload.getPrimaryKey();

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

		if (!(obj instanceof UploadClp)) {
			return false;
		}

		UploadClp upload = (UploadClp)obj;

		long primaryKey = upload.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uploadId=");
		sb.append(getUploadId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", contentLength=");
		sb.append(getContentLength());
		sb.append(", timestamp=");
		sb.append(getTimestamp());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Upload");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uploadId</column-name><column-value><![CDATA[");
		sb.append(getUploadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentLength</column-name><column-value><![CDATA[");
		sb.append(getContentLength());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timestamp</column-name><column-value><![CDATA[");
		sb.append(getTimestamp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _uploadId;
	private long _userId;
	private String _userUuid;
	private long _contentLength;
	private long _timestamp;
	private int _status;
	private int _videoId;
	private BaseModel<?> _uploadRemoteModel;
}