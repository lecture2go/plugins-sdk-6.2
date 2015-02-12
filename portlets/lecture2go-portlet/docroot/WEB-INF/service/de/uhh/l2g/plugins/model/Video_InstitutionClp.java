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
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class Video_InstitutionClp extends BaseModelImpl<Video_Institution>
	implements Video_Institution {
	public Video_InstitutionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Video_Institution.class;
	}

	@Override
	public String getModelClassName() {
		return Video_Institution.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _videoInstitutionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVideoInstitutionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _videoInstitutionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoInstitutionId", getVideoInstitutionId());
		attributes.put("videoId", getVideoId());
		attributes.put("institutionId", getInstitutionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoInstitutionId = (Long)attributes.get("videoInstitutionId");

		if (videoInstitutionId != null) {
			setVideoInstitutionId(videoInstitutionId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}
	}

	@Override
	public long getVideoInstitutionId() {
		return _videoInstitutionId;
	}

	@Override
	public void setVideoInstitutionId(long videoInstitutionId) {
		_videoInstitutionId = videoInstitutionId;

		if (_video_InstitutionRemoteModel != null) {
			try {
				Class<?> clazz = _video_InstitutionRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoInstitutionId",
						long.class);

				method.invoke(_video_InstitutionRemoteModel, videoInstitutionId);
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

		if (_video_InstitutionRemoteModel != null) {
			try {
				Class<?> clazz = _video_InstitutionRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", long.class);

				method.invoke(_video_InstitutionRemoteModel, videoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInstitutionId() {
		return _institutionId;
	}

	@Override
	public void setInstitutionId(long institutionId) {
		_institutionId = institutionId;

		if (_video_InstitutionRemoteModel != null) {
			try {
				Class<?> clazz = _video_InstitutionRemoteModel.getClass();

				Method method = clazz.getMethod("setInstitutionId", long.class);

				method.invoke(_video_InstitutionRemoteModel, institutionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVideo_InstitutionRemoteModel() {
		return _video_InstitutionRemoteModel;
	}

	public void setVideo_InstitutionRemoteModel(
		BaseModel<?> video_InstitutionRemoteModel) {
		_video_InstitutionRemoteModel = video_InstitutionRemoteModel;
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

		Class<?> remoteModelClass = _video_InstitutionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_video_InstitutionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Video_InstitutionLocalServiceUtil.addVideo_Institution(this);
		}
		else {
			Video_InstitutionLocalServiceUtil.updateVideo_Institution(this);
		}
	}

	@Override
	public Video_Institution toEscapedModel() {
		return (Video_Institution)ProxyUtil.newProxyInstance(Video_Institution.class.getClassLoader(),
			new Class[] { Video_Institution.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Video_InstitutionClp clone = new Video_InstitutionClp();

		clone.setVideoInstitutionId(getVideoInstitutionId());
		clone.setVideoId(getVideoId());
		clone.setInstitutionId(getInstitutionId());

		return clone;
	}

	@Override
	public int compareTo(Video_Institution video_Institution) {
		long primaryKey = video_Institution.getPrimaryKey();

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

		if (!(obj instanceof Video_InstitutionClp)) {
			return false;
		}

		Video_InstitutionClp video_Institution = (Video_InstitutionClp)obj;

		long primaryKey = video_Institution.getPrimaryKey();

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

		sb.append("{videoInstitutionId=");
		sb.append(getVideoInstitutionId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", institutionId=");
		sb.append(getInstitutionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Video_Institution");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoInstitutionId</column-name><column-value><![CDATA[");
		sb.append(getVideoInstitutionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>institutionId</column-name><column-value><![CDATA[");
		sb.append(getInstitutionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videoInstitutionId;
	private long _videoId;
	private long _institutionId;
	private BaseModel<?> _video_InstitutionRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}