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

package de.uhh.l2g.plugins.migration.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import de.uhh.l2g.plugins.migration.service.ClpSerializer;
import de.uhh.l2g.plugins.migration.service.LegacySegmentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacySegmentClp extends BaseModelImpl<LegacySegment>
	implements LegacySegment {
	public LegacySegmentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacySegment.class;
	}

	@Override
	public String getModelClassName() {
		return LegacySegment.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("videoId", getVideoId());
		attributes.put("start", getStart());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("end", getEnd());
		attributes.put("chapter", getChapter());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		String start = (String)attributes.get("start");

		if (start != null) {
			setStart(start);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String end = (String)attributes.get("end");

		if (end != null) {
			setEnd(end);
		}

		Integer chapter = (Integer)attributes.get("chapter");

		if (chapter != null) {
			setChapter(chapter);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_legacySegmentRemoteModel != null) {
			try {
				Class<?> clazz = _legacySegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_legacySegmentRemoteModel, id);
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

		if (_legacySegmentRemoteModel != null) {
			try {
				Class<?> clazz = _legacySegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", long.class);

				method.invoke(_legacySegmentRemoteModel, videoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStart() {
		return _start;
	}

	@Override
	public void setStart(String start) {
		_start = start;

		if (_legacySegmentRemoteModel != null) {
			try {
				Class<?> clazz = _legacySegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setStart", String.class);

				method.invoke(_legacySegmentRemoteModel, start);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_legacySegmentRemoteModel != null) {
			try {
				Class<?> clazz = _legacySegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_legacySegmentRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_legacySegmentRemoteModel != null) {
			try {
				Class<?> clazz = _legacySegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_legacySegmentRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEnd() {
		return _end;
	}

	@Override
	public void setEnd(String end) {
		_end = end;

		if (_legacySegmentRemoteModel != null) {
			try {
				Class<?> clazz = _legacySegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setEnd", String.class);

				method.invoke(_legacySegmentRemoteModel, end);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getChapter() {
		return _chapter;
	}

	@Override
	public void setChapter(int chapter) {
		_chapter = chapter;

		if (_legacySegmentRemoteModel != null) {
			try {
				Class<?> clazz = _legacySegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setChapter", int.class);

				method.invoke(_legacySegmentRemoteModel, chapter);
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

		if (_legacySegmentRemoteModel != null) {
			try {
				Class<?> clazz = _legacySegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_legacySegmentRemoteModel, userId);
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

	public BaseModel<?> getLegacySegmentRemoteModel() {
		return _legacySegmentRemoteModel;
	}

	public void setLegacySegmentRemoteModel(
		BaseModel<?> legacySegmentRemoteModel) {
		_legacySegmentRemoteModel = legacySegmentRemoteModel;
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

		Class<?> remoteModelClass = _legacySegmentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacySegmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacySegmentLocalServiceUtil.addLegacySegment(this);
		}
		else {
			LegacySegmentLocalServiceUtil.updateLegacySegment(this);
		}
	}

	@Override
	public LegacySegment toEscapedModel() {
		return (LegacySegment)ProxyUtil.newProxyInstance(LegacySegment.class.getClassLoader(),
			new Class[] { LegacySegment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacySegmentClp clone = new LegacySegmentClp();

		clone.setId(getId());
		clone.setVideoId(getVideoId());
		clone.setStart(getStart());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setEnd(getEnd());
		clone.setChapter(getChapter());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(LegacySegment legacySegment) {
		long primaryKey = legacySegment.getPrimaryKey();

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

		if (!(obj instanceof LegacySegmentClp)) {
			return false;
		}

		LegacySegmentClp legacySegment = (LegacySegmentClp)obj;

		long primaryKey = legacySegment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", start=");
		sb.append(getStart());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", end=");
		sb.append(getEnd());
		sb.append(", chapter=");
		sb.append(getChapter());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacySegment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>start</column-name><column-value><![CDATA[");
		sb.append(getStart());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>end</column-name><column-value><![CDATA[");
		sb.append(getEnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chapter</column-name><column-value><![CDATA[");
		sb.append(getChapter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _videoId;
	private String _start;
	private String _title;
	private String _description;
	private String _end;
	private int _chapter;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _legacySegmentRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}