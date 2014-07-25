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
import de.uhh.l2g.plugins.service.FacilityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class FacilityClp extends BaseModelImpl<Facility> implements Facility {
	public FacilityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Facility.class;
	}

	@Override
	public String getModelClassName() {
		return Facility.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _facilityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFacilityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _facilityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facilityId", getFacilityId());
		attributes.put("parentId", getParentId());
		attributes.put("name", getName());
		attributes.put("typ", getTyp());
		attributes.put("www", getWww());
		attributes.put("level", getLevel());
		attributes.put("sort", getSort());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Integer parentId = (Integer)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String typ = (String)attributes.get("typ");

		if (typ != null) {
			setTyp(typ);
		}

		String www = (String)attributes.get("www");

		if (www != null) {
			setWww(www);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Integer sort = (Integer)attributes.get("sort");

		if (sort != null) {
			setSort(sort);
		}
	}

	@Override
	public long getFacilityId() {
		return _facilityId;
	}

	@Override
	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;

		if (_facilityRemoteModel != null) {
			try {
				Class<?> clazz = _facilityRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityId", long.class);

				method.invoke(_facilityRemoteModel, facilityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(int parentId) {
		_parentId = parentId;

		if (_facilityRemoteModel != null) {
			try {
				Class<?> clazz = _facilityRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", int.class);

				method.invoke(_facilityRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_facilityRemoteModel != null) {
			try {
				Class<?> clazz = _facilityRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_facilityRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTyp() {
		return _typ;
	}

	@Override
	public void setTyp(String typ) {
		_typ = typ;

		if (_facilityRemoteModel != null) {
			try {
				Class<?> clazz = _facilityRemoteModel.getClass();

				Method method = clazz.getMethod("setTyp", String.class);

				method.invoke(_facilityRemoteModel, typ);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWww() {
		return _www;
	}

	@Override
	public void setWww(String www) {
		_www = www;

		if (_facilityRemoteModel != null) {
			try {
				Class<?> clazz = _facilityRemoteModel.getClass();

				Method method = clazz.getMethod("setWww", String.class);

				method.invoke(_facilityRemoteModel, www);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLevel() {
		return _level;
	}

	@Override
	public void setLevel(int level) {
		_level = level;

		if (_facilityRemoteModel != null) {
			try {
				Class<?> clazz = _facilityRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel", int.class);

				method.invoke(_facilityRemoteModel, level);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSort() {
		return _sort;
	}

	@Override
	public void setSort(int sort) {
		_sort = sort;

		if (_facilityRemoteModel != null) {
			try {
				Class<?> clazz = _facilityRemoteModel.getClass();

				Method method = clazz.getMethod("setSort", int.class);

				method.invoke(_facilityRemoteModel, sort);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFacilityRemoteModel() {
		return _facilityRemoteModel;
	}

	public void setFacilityRemoteModel(BaseModel<?> facilityRemoteModel) {
		_facilityRemoteModel = facilityRemoteModel;
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

		Class<?> remoteModelClass = _facilityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_facilityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FacilityLocalServiceUtil.addFacility(this);
		}
		else {
			FacilityLocalServiceUtil.updateFacility(this);
		}
	}

	@Override
	public Facility toEscapedModel() {
		return (Facility)ProxyUtil.newProxyInstance(Facility.class.getClassLoader(),
			new Class[] { Facility.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FacilityClp clone = new FacilityClp();

		clone.setFacilityId(getFacilityId());
		clone.setParentId(getParentId());
		clone.setName(getName());
		clone.setTyp(getTyp());
		clone.setWww(getWww());
		clone.setLevel(getLevel());
		clone.setSort(getSort());

		return clone;
	}

	@Override
	public int compareTo(Facility facility) {
		long primaryKey = facility.getPrimaryKey();

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

		if (!(obj instanceof FacilityClp)) {
			return false;
		}

		FacilityClp facility = (FacilityClp)obj;

		long primaryKey = facility.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{facilityId=");
		sb.append(getFacilityId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", typ=");
		sb.append(getTyp());
		sb.append(", www=");
		sb.append(getWww());
		sb.append(", level=");
		sb.append(getLevel());
		sb.append(", sort=");
		sb.append(getSort());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Facility");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>facilityId</column-name><column-value><![CDATA[");
		sb.append(getFacilityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typ</column-name><column-value><![CDATA[");
		sb.append(getTyp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>www</column-name><column-value><![CDATA[");
		sb.append(getWww());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level</column-name><column-value><![CDATA[");
		sb.append(getLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sort</column-name><column-value><![CDATA[");
		sb.append(getSort());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _facilityId;
	private int _parentId;
	private String _name;
	private String _typ;
	private String _www;
	private int _level;
	private int _sort;
	private BaseModel<?> _facilityRemoteModel;
}