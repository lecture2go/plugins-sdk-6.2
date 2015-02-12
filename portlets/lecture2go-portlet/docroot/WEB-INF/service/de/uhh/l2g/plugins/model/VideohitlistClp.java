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
import de.uhh.l2g.plugins.service.VideohitlistLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class VideohitlistClp extends BaseModelImpl<Videohitlist>
	implements Videohitlist {
	public VideohitlistClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Videohitlist.class;
	}

	@Override
	public String getModelClassName() {
		return Videohitlist.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _videohitlistId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVideohitlistId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _videohitlistId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videohitlistId", getVideohitlistId());
		attributes.put("hitsPerDay", getHitsPerDay());
		attributes.put("hitsPerWeek", getHitsPerWeek());
		attributes.put("hitsPerMonth", getHitsPerMonth());
		attributes.put("hitsPerYear", getHitsPerYear());
		attributes.put("videoId", getVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videohitlistId = (Long)attributes.get("videohitlistId");

		if (videohitlistId != null) {
			setVideohitlistId(videohitlistId);
		}

		Long hitsPerDay = (Long)attributes.get("hitsPerDay");

		if (hitsPerDay != null) {
			setHitsPerDay(hitsPerDay);
		}

		Long hitsPerWeek = (Long)attributes.get("hitsPerWeek");

		if (hitsPerWeek != null) {
			setHitsPerWeek(hitsPerWeek);
		}

		Long hitsPerMonth = (Long)attributes.get("hitsPerMonth");

		if (hitsPerMonth != null) {
			setHitsPerMonth(hitsPerMonth);
		}

		Long hitsPerYear = (Long)attributes.get("hitsPerYear");

		if (hitsPerYear != null) {
			setHitsPerYear(hitsPerYear);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}
	}

	@Override
	public long getVideohitlistId() {
		return _videohitlistId;
	}

	@Override
	public void setVideohitlistId(long videohitlistId) {
		_videohitlistId = videohitlistId;

		if (_videohitlistRemoteModel != null) {
			try {
				Class<?> clazz = _videohitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setVideohitlistId", long.class);

				method.invoke(_videohitlistRemoteModel, videohitlistId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHitsPerDay() {
		return _hitsPerDay;
	}

	@Override
	public void setHitsPerDay(long hitsPerDay) {
		_hitsPerDay = hitsPerDay;

		if (_videohitlistRemoteModel != null) {
			try {
				Class<?> clazz = _videohitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setHitsPerDay", long.class);

				method.invoke(_videohitlistRemoteModel, hitsPerDay);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHitsPerWeek() {
		return _hitsPerWeek;
	}

	@Override
	public void setHitsPerWeek(long hitsPerWeek) {
		_hitsPerWeek = hitsPerWeek;

		if (_videohitlistRemoteModel != null) {
			try {
				Class<?> clazz = _videohitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setHitsPerWeek", long.class);

				method.invoke(_videohitlistRemoteModel, hitsPerWeek);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHitsPerMonth() {
		return _hitsPerMonth;
	}

	@Override
	public void setHitsPerMonth(long hitsPerMonth) {
		_hitsPerMonth = hitsPerMonth;

		if (_videohitlistRemoteModel != null) {
			try {
				Class<?> clazz = _videohitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setHitsPerMonth", long.class);

				method.invoke(_videohitlistRemoteModel, hitsPerMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHitsPerYear() {
		return _hitsPerYear;
	}

	@Override
	public void setHitsPerYear(long hitsPerYear) {
		_hitsPerYear = hitsPerYear;

		if (_videohitlistRemoteModel != null) {
			try {
				Class<?> clazz = _videohitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setHitsPerYear", long.class);

				method.invoke(_videohitlistRemoteModel, hitsPerYear);
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

		if (_videohitlistRemoteModel != null) {
			try {
				Class<?> clazz = _videohitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", long.class);

				method.invoke(_videohitlistRemoteModel, videoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVideohitlistRemoteModel() {
		return _videohitlistRemoteModel;
	}

	public void setVideohitlistRemoteModel(BaseModel<?> videohitlistRemoteModel) {
		_videohitlistRemoteModel = videohitlistRemoteModel;
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

		Class<?> remoteModelClass = _videohitlistRemoteModel.getClass();

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

		Object returnValue = method.invoke(_videohitlistRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VideohitlistLocalServiceUtil.addVideohitlist(this);
		}
		else {
			VideohitlistLocalServiceUtil.updateVideohitlist(this);
		}
	}

	@Override
	public Videohitlist toEscapedModel() {
		return (Videohitlist)ProxyUtil.newProxyInstance(Videohitlist.class.getClassLoader(),
			new Class[] { Videohitlist.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideohitlistClp clone = new VideohitlistClp();

		clone.setVideohitlistId(getVideohitlistId());
		clone.setHitsPerDay(getHitsPerDay());
		clone.setHitsPerWeek(getHitsPerWeek());
		clone.setHitsPerMonth(getHitsPerMonth());
		clone.setHitsPerYear(getHitsPerYear());
		clone.setVideoId(getVideoId());

		return clone;
	}

	@Override
	public int compareTo(Videohitlist videohitlist) {
		long primaryKey = videohitlist.getPrimaryKey();

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

		if (!(obj instanceof VideohitlistClp)) {
			return false;
		}

		VideohitlistClp videohitlist = (VideohitlistClp)obj;

		long primaryKey = videohitlist.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{videohitlistId=");
		sb.append(getVideohitlistId());
		sb.append(", hitsPerDay=");
		sb.append(getHitsPerDay());
		sb.append(", hitsPerWeek=");
		sb.append(getHitsPerWeek());
		sb.append(", hitsPerMonth=");
		sb.append(getHitsPerMonth());
		sb.append(", hitsPerYear=");
		sb.append(getHitsPerYear());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Videohitlist");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videohitlistId</column-name><column-value><![CDATA[");
		sb.append(getVideohitlistId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hitsPerDay</column-name><column-value><![CDATA[");
		sb.append(getHitsPerDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hitsPerWeek</column-name><column-value><![CDATA[");
		sb.append(getHitsPerWeek());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hitsPerMonth</column-name><column-value><![CDATA[");
		sb.append(getHitsPerMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hitsPerYear</column-name><column-value><![CDATA[");
		sb.append(getHitsPerYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videohitlistId;
	private long _hitsPerDay;
	private long _hitsPerWeek;
	private long _hitsPerMonth;
	private long _hitsPerYear;
	private long _videoId;
	private BaseModel<?> _videohitlistRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}