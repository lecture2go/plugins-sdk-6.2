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
import de.uhh.l2g.plugins.service.Segment_User_VideoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class Segment_User_VideoClp extends BaseModelImpl<Segment_User_Video>
	implements Segment_User_Video {
	public Segment_User_VideoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Segment_User_Video.class;
	}

	@Override
	public String getModelClassName() {
		return Segment_User_Video.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _segmentUserVideoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSegmentUserVideoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _segmentUserVideoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("segmentId", getSegmentId());
		attributes.put("userId", getUserId());
		attributes.put("videoId", getVideoId());
		attributes.put("segmentUserVideoId", getSegmentUserVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long segmentId = (Long)attributes.get("segmentId");

		if (segmentId != null) {
			setSegmentId(segmentId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long segmentUserVideoId = (Long)attributes.get("segmentUserVideoId");

		if (segmentUserVideoId != null) {
			setSegmentUserVideoId(segmentUserVideoId);
		}
	}

	@Override
	public long getSegmentId() {
		return _segmentId;
	}

	@Override
	public void setSegmentId(long segmentId) {
		_segmentId = segmentId;

		if (_segment_User_VideoRemoteModel != null) {
			try {
				Class<?> clazz = _segment_User_VideoRemoteModel.getClass();

				Method method = clazz.getMethod("setSegmentId", long.class);

				method.invoke(_segment_User_VideoRemoteModel, segmentId);
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

		if (_segment_User_VideoRemoteModel != null) {
			try {
				Class<?> clazz = _segment_User_VideoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_segment_User_VideoRemoteModel, userId);
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
	public long getVideoId() {
		return _videoId;
	}

	@Override
	public void setVideoId(long videoId) {
		_videoId = videoId;

		if (_segment_User_VideoRemoteModel != null) {
			try {
				Class<?> clazz = _segment_User_VideoRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", long.class);

				method.invoke(_segment_User_VideoRemoteModel, videoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSegmentUserVideoId() {
		return _segmentUserVideoId;
	}

	@Override
	public void setSegmentUserVideoId(long segmentUserVideoId) {
		_segmentUserVideoId = segmentUserVideoId;

		if (_segment_User_VideoRemoteModel != null) {
			try {
				Class<?> clazz = _segment_User_VideoRemoteModel.getClass();

				Method method = clazz.getMethod("setSegmentUserVideoId",
						long.class);

				method.invoke(_segment_User_VideoRemoteModel, segmentUserVideoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSegment_User_VideoRemoteModel() {
		return _segment_User_VideoRemoteModel;
	}

	public void setSegment_User_VideoRemoteModel(
		BaseModel<?> segment_User_VideoRemoteModel) {
		_segment_User_VideoRemoteModel = segment_User_VideoRemoteModel;
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

		Class<?> remoteModelClass = _segment_User_VideoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_segment_User_VideoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Segment_User_VideoLocalServiceUtil.addSegment_User_Video(this);
		}
		else {
			Segment_User_VideoLocalServiceUtil.updateSegment_User_Video(this);
		}
	}

	@Override
	public Segment_User_Video toEscapedModel() {
		return (Segment_User_Video)ProxyUtil.newProxyInstance(Segment_User_Video.class.getClassLoader(),
			new Class[] { Segment_User_Video.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Segment_User_VideoClp clone = new Segment_User_VideoClp();

		clone.setSegmentId(getSegmentId());
		clone.setUserId(getUserId());
		clone.setVideoId(getVideoId());
		clone.setSegmentUserVideoId(getSegmentUserVideoId());

		return clone;
	}

	@Override
	public int compareTo(Segment_User_Video segment_User_Video) {
		long primaryKey = segment_User_Video.getPrimaryKey();

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

		if (!(obj instanceof Segment_User_VideoClp)) {
			return false;
		}

		Segment_User_VideoClp segment_User_Video = (Segment_User_VideoClp)obj;

		long primaryKey = segment_User_Video.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{segmentId=");
		sb.append(getSegmentId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", segmentUserVideoId=");
		sb.append(getSegmentUserVideoId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Segment_User_Video");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>segmentId</column-name><column-value><![CDATA[");
		sb.append(getSegmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>segmentUserVideoId</column-name><column-value><![CDATA[");
		sb.append(getSegmentUserVideoId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _segmentId;
	private long _userId;
	private String _userUuid;
	private long _videoId;
	private long _segmentUserVideoId;
	private BaseModel<?> _segment_User_VideoRemoteModel;
}