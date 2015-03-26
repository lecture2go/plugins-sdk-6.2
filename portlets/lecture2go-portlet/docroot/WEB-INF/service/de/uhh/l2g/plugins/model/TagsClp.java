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
import de.uhh.l2g.plugins.service.TagsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class TagsClp extends BaseModelImpl<Tags> implements Tags {
	public TagsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Tags.class;
	}

	@Override
	public String getModelClassName() {
		return Tags.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tagId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTagId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tagId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagId", getTagId());
		attributes.put("isVideo", getIsVideo());
		attributes.put("isLectureseries", getIsLectureseries());
		attributes.put("tags", getTags());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}

		Integer isVideo = (Integer)attributes.get("isVideo");

		if (isVideo != null) {
			setIsVideo(isVideo);
		}

		Integer isLectureseries = (Integer)attributes.get("isLectureseries");

		if (isLectureseries != null) {
			setIsLectureseries(isLectureseries);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
		}
	}

	@Override
	public long getTagId() {
		return _tagId;
	}

	@Override
	public void setTagId(long tagId) {
		_tagId = tagId;

		if (_tagsRemoteModel != null) {
			try {
				Class<?> clazz = _tagsRemoteModel.getClass();

				Method method = clazz.getMethod("setTagId", long.class);

				method.invoke(_tagsRemoteModel, tagId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIsVideo() {
		return _isVideo;
	}

	@Override
	public void setIsVideo(int isVideo) {
		_isVideo = isVideo;

		if (_tagsRemoteModel != null) {
			try {
				Class<?> clazz = _tagsRemoteModel.getClass();

				Method method = clazz.getMethod("setIsVideo", int.class);

				method.invoke(_tagsRemoteModel, isVideo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIsLectureseries() {
		return _isLectureseries;
	}

	@Override
	public void setIsLectureseries(int isLectureseries) {
		_isLectureseries = isLectureseries;

		if (_tagsRemoteModel != null) {
			try {
				Class<?> clazz = _tagsRemoteModel.getClass();

				Method method = clazz.getMethod("setIsLectureseries", int.class);

				method.invoke(_tagsRemoteModel, isLectureseries);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTags() {
		return _tags;
	}

	@Override
	public void setTags(String tags) {
		_tags = tags;

		if (_tagsRemoteModel != null) {
			try {
				Class<?> clazz = _tagsRemoteModel.getClass();

				Method method = clazz.getMethod("setTags", String.class);

				method.invoke(_tagsRemoteModel, tags);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTagsRemoteModel() {
		return _tagsRemoteModel;
	}

	public void setTagsRemoteModel(BaseModel<?> tagsRemoteModel) {
		_tagsRemoteModel = tagsRemoteModel;
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

		Class<?> remoteModelClass = _tagsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tagsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TagsLocalServiceUtil.addTags(this);
		}
		else {
			TagsLocalServiceUtil.updateTags(this);
		}
	}

	@Override
	public Tags toEscapedModel() {
		return (Tags)ProxyUtil.newProxyInstance(Tags.class.getClassLoader(),
			new Class[] { Tags.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TagsClp clone = new TagsClp();

		clone.setTagId(getTagId());
		clone.setIsVideo(getIsVideo());
		clone.setIsLectureseries(getIsLectureseries());
		clone.setTags(getTags());

		return clone;
	}

	@Override
	public int compareTo(Tags tags) {
		long primaryKey = tags.getPrimaryKey();

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

		if (!(obj instanceof TagsClp)) {
			return false;
		}

		TagsClp tags = (TagsClp)obj;

		long primaryKey = tags.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{tagId=");
		sb.append(getTagId());
		sb.append(", isVideo=");
		sb.append(getIsVideo());
		sb.append(", isLectureseries=");
		sb.append(getIsLectureseries());
		sb.append(", tags=");
		sb.append(getTags());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Tags");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tagId</column-name><column-value><![CDATA[");
		sb.append(getTagId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isVideo</column-name><column-value><![CDATA[");
		sb.append(getIsVideo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isLectureseries</column-name><column-value><![CDATA[");
		sb.append(getIsLectureseries());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tags</column-name><column-value><![CDATA[");
		sb.append(getTags());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _tagId;
	private int _isVideo;
	private int _isLectureseries;
	private String _tags;
	private BaseModel<?> _tagsRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}