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
import de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class Video_CategoryClp extends BaseModelImpl<Video_Category>
	implements Video_Category {
	public Video_CategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Video_Category.class;
	}

	@Override
	public String getModelClassName() {
		return Video_Category.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _videoCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVideoCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _videoCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoCategoryId", getVideoCategoryId());
		attributes.put("videoId", getVideoId());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoCategoryId = (Long)attributes.get("videoCategoryId");

		if (videoCategoryId != null) {
			setVideoCategoryId(videoCategoryId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	@Override
	public long getVideoCategoryId() {
		return _videoCategoryId;
	}

	@Override
	public void setVideoCategoryId(long videoCategoryId) {
		_videoCategoryId = videoCategoryId;

		if (_video_CategoryRemoteModel != null) {
			try {
				Class<?> clazz = _video_CategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoCategoryId", long.class);

				method.invoke(_video_CategoryRemoteModel, videoCategoryId);
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

		if (_video_CategoryRemoteModel != null) {
			try {
				Class<?> clazz = _video_CategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", long.class);

				method.invoke(_video_CategoryRemoteModel, videoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_video_CategoryRemoteModel != null) {
			try {
				Class<?> clazz = _video_CategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_video_CategoryRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVideo_CategoryRemoteModel() {
		return _video_CategoryRemoteModel;
	}

	public void setVideo_CategoryRemoteModel(
		BaseModel<?> video_CategoryRemoteModel) {
		_video_CategoryRemoteModel = video_CategoryRemoteModel;
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

		Class<?> remoteModelClass = _video_CategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_video_CategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Video_CategoryLocalServiceUtil.addVideo_Category(this);
		}
		else {
			Video_CategoryLocalServiceUtil.updateVideo_Category(this);
		}
	}

	@Override
	public Video_Category toEscapedModel() {
		return (Video_Category)ProxyUtil.newProxyInstance(Video_Category.class.getClassLoader(),
			new Class[] { Video_Category.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Video_CategoryClp clone = new Video_CategoryClp();

		clone.setVideoCategoryId(getVideoCategoryId());
		clone.setVideoId(getVideoId());
		clone.setCategoryId(getCategoryId());

		return clone;
	}

	@Override
	public int compareTo(Video_Category video_Category) {
		long primaryKey = video_Category.getPrimaryKey();

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

		if (!(obj instanceof Video_CategoryClp)) {
			return false;
		}

		Video_CategoryClp video_Category = (Video_CategoryClp)obj;

		long primaryKey = video_Category.getPrimaryKey();

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

		sb.append("{videoCategoryId=");
		sb.append(getVideoCategoryId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Video_Category");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoCategoryId</column-name><column-value><![CDATA[");
		sb.append(getVideoCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videoCategoryId;
	private long _videoId;
	private long _categoryId;
	private BaseModel<?> _video_CategoryRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}