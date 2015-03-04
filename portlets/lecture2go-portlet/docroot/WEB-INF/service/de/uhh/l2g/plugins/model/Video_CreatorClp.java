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
import de.uhh.l2g.plugins.service.Video_CreatorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class Video_CreatorClp extends BaseModelImpl<Video_Creator>
	implements Video_Creator {
	public Video_CreatorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Video_Creator.class;
	}

	@Override
	public String getModelClassName() {
		return Video_Creator.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _videoCreatorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVideoCreatorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _videoCreatorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoCreatorId", getVideoCreatorId());
		attributes.put("creatorId", getCreatorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoCreatorId = (Long)attributes.get("videoCreatorId");

		if (videoCreatorId != null) {
			setVideoCreatorId(videoCreatorId);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}
	}

	@Override
	public long getVideoCreatorId() {
		return _videoCreatorId;
	}

	@Override
	public void setVideoCreatorId(long videoCreatorId) {
		_videoCreatorId = videoCreatorId;

		if (_video_CreatorRemoteModel != null) {
			try {
				Class<?> clazz = _video_CreatorRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoCreatorId", long.class);

				method.invoke(_video_CreatorRemoteModel, videoCreatorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;

		if (_video_CreatorRemoteModel != null) {
			try {
				Class<?> clazz = _video_CreatorRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", long.class);

				method.invoke(_video_CreatorRemoteModel, creatorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVideo_CreatorRemoteModel() {
		return _video_CreatorRemoteModel;
	}

	public void setVideo_CreatorRemoteModel(
		BaseModel<?> video_CreatorRemoteModel) {
		_video_CreatorRemoteModel = video_CreatorRemoteModel;
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

		Class<?> remoteModelClass = _video_CreatorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_video_CreatorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Video_CreatorLocalServiceUtil.addVideo_Creator(this);
		}
		else {
			Video_CreatorLocalServiceUtil.updateVideo_Creator(this);
		}
	}

	@Override
	public Video_Creator toEscapedModel() {
		return (Video_Creator)ProxyUtil.newProxyInstance(Video_Creator.class.getClassLoader(),
			new Class[] { Video_Creator.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Video_CreatorClp clone = new Video_CreatorClp();

		clone.setVideoCreatorId(getVideoCreatorId());
		clone.setCreatorId(getCreatorId());

		return clone;
	}

	@Override
	public int compareTo(Video_Creator video_Creator) {
		long primaryKey = video_Creator.getPrimaryKey();

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

		if (!(obj instanceof Video_CreatorClp)) {
			return false;
		}

		Video_CreatorClp video_Creator = (Video_CreatorClp)obj;

		long primaryKey = video_Creator.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{videoCreatorId=");
		sb.append(getVideoCreatorId());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Video_Creator");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoCreatorId</column-name><column-value><![CDATA[");
		sb.append(getVideoCreatorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creatorId</column-name><column-value><![CDATA[");
		sb.append(getCreatorId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videoCreatorId;
	private long _creatorId;
	private BaseModel<?> _video_CreatorRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}