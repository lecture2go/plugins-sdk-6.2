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
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class Video_LectureseriesClp extends BaseModelImpl<Video_Lectureseries>
	implements Video_Lectureseries {
	public Video_LectureseriesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Video_Lectureseries.class;
	}

	@Override
	public String getModelClassName() {
		return Video_Lectureseries.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _videoLectureseriesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVideoLectureseriesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _videoLectureseriesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoLectureseriesId", getVideoLectureseriesId());
		attributes.put("videoId", getVideoId());
		attributes.put("lectureseriesId", getLectureseriesId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoLectureseriesId = (Long)attributes.get("videoLectureseriesId");

		if (videoLectureseriesId != null) {
			setVideoLectureseriesId(videoLectureseriesId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}
	}

	@Override
	public long getVideoLectureseriesId() {
		return _videoLectureseriesId;
	}

	@Override
	public void setVideoLectureseriesId(long videoLectureseriesId) {
		_videoLectureseriesId = videoLectureseriesId;

		if (_video_LectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _video_LectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoLectureseriesId",
						long.class);

				method.invoke(_video_LectureseriesRemoteModel,
					videoLectureseriesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVideoId() {
		return _videoId;
	}

	@Override
	public void setVideoId(long videoId) {
		_videoId = videoId;

		if (_video_LectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _video_LectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", long.class);

				method.invoke(_video_LectureseriesRemoteModel, videoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;

		if (_video_LectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _video_LectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesId", long.class);

				method.invoke(_video_LectureseriesRemoteModel, lectureseriesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVideo_LectureseriesRemoteModel() {
		return _video_LectureseriesRemoteModel;
	}

	public void setVideo_LectureseriesRemoteModel(
		BaseModel<?> video_LectureseriesRemoteModel) {
		_video_LectureseriesRemoteModel = video_LectureseriesRemoteModel;
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

		Class<?> remoteModelClass = _video_LectureseriesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_video_LectureseriesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Video_LectureseriesLocalServiceUtil.addVideo_Lectureseries(this);
		}
		else {
			Video_LectureseriesLocalServiceUtil.updateVideo_Lectureseries(this);
		}
	}

	@Override
	public Video_Lectureseries toEscapedModel() {
		return (Video_Lectureseries)ProxyUtil.newProxyInstance(Video_Lectureseries.class.getClassLoader(),
			new Class[] { Video_Lectureseries.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Video_LectureseriesClp clone = new Video_LectureseriesClp();

		clone.setVideoLectureseriesId(getVideoLectureseriesId());
		clone.setVideoId(getVideoId());
		clone.setLectureseriesId(getLectureseriesId());

		return clone;
	}

	@Override
	public int compareTo(Video_Lectureseries video_Lectureseries) {
		long primaryKey = video_Lectureseries.getPrimaryKey();

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

		if (!(obj instanceof Video_LectureseriesClp)) {
			return false;
		}

		Video_LectureseriesClp video_Lectureseries = (Video_LectureseriesClp)obj;

		long primaryKey = video_Lectureseries.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{videoLectureseriesId=");
		sb.append(getVideoLectureseriesId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Video_Lectureseries");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoLectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getVideoLectureseriesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videoLectureseriesId;
	private long _videoId;
	private long _lectureseriesId;
	private BaseModel<?> _video_LectureseriesRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}