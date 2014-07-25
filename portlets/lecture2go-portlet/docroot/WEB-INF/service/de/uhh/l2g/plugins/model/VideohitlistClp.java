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
	public int getPrimaryKey() {
		return _videohitlistId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setVideohitlistId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _videohitlistId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videohitlistId", getVideohitlistId());
		attributes.put("hitsPerDay", getHitsPerDay());
		attributes.put("hitsPerWeek", getHitsPerWeek());
		attributes.put("hitsPerMonth", getHitsPerMonth());
		attributes.put("hitsPerYear", getHitsPerYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer videohitlistId = (Integer)attributes.get("videohitlistId");

		if (videohitlistId != null) {
			setVideohitlistId(videohitlistId);
		}

		Integer hitsPerDay = (Integer)attributes.get("hitsPerDay");

		if (hitsPerDay != null) {
			setHitsPerDay(hitsPerDay);
		}

		Integer hitsPerWeek = (Integer)attributes.get("hitsPerWeek");

		if (hitsPerWeek != null) {
			setHitsPerWeek(hitsPerWeek);
		}

		Integer hitsPerMonth = (Integer)attributes.get("hitsPerMonth");

		if (hitsPerMonth != null) {
			setHitsPerMonth(hitsPerMonth);
		}

		Integer hitsPerYear = (Integer)attributes.get("hitsPerYear");

		if (hitsPerYear != null) {
			setHitsPerYear(hitsPerYear);
		}
	}

	@Override
	public int getVideohitlistId() {
		return _videohitlistId;
	}

	@Override
	public void setVideohitlistId(int videohitlistId) {
		_videohitlistId = videohitlistId;

		if (_videohitlistRemoteModel != null) {
			try {
				Class<?> clazz = _videohitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setVideohitlistId", int.class);

				method.invoke(_videohitlistRemoteModel, videohitlistId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHitsPerDay() {
		return _hitsPerDay;
	}

	@Override
	public void setHitsPerDay(int hitsPerDay) {
		_hitsPerDay = hitsPerDay;

		if (_videohitlistRemoteModel != null) {
			try {
				Class<?> clazz = _videohitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setHitsPerDay", int.class);

				method.invoke(_videohitlistRemoteModel, hitsPerDay);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHitsPerWeek() {
		return _hitsPerWeek;
	}

	@Override
	public void setHitsPerWeek(int hitsPerWeek) {
		_hitsPerWeek = hitsPerWeek;

		if (_videohitlistRemoteModel != null) {
			try {
				Class<?> clazz = _videohitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setHitsPerWeek", int.class);

				method.invoke(_videohitlistRemoteModel, hitsPerWeek);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHitsPerMonth() {
		return _hitsPerMonth;
	}

	@Override
	public void setHitsPerMonth(int hitsPerMonth) {
		_hitsPerMonth = hitsPerMonth;

		if (_videohitlistRemoteModel != null) {
			try {
				Class<?> clazz = _videohitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setHitsPerMonth", int.class);

				method.invoke(_videohitlistRemoteModel, hitsPerMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHitsPerYear() {
		return _hitsPerYear;
	}

	@Override
	public void setHitsPerYear(int hitsPerYear) {
		_hitsPerYear = hitsPerYear;

		if (_videohitlistRemoteModel != null) {
			try {
				Class<?> clazz = _videohitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setHitsPerYear", int.class);

				method.invoke(_videohitlistRemoteModel, hitsPerYear);
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

		return clone;
	}

	@Override
	public int compareTo(Videohitlist videohitlist) {
		int primaryKey = videohitlist.getPrimaryKey();

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

		int primaryKey = videohitlist.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

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

		sb.append("</model>");

		return sb.toString();
	}

	private int _videohitlistId;
	private int _hitsPerDay;
	private int _hitsPerWeek;
	private int _hitsPerMonth;
	private int _hitsPerYear;
	private BaseModel<?> _videohitlistRemoteModel;
}