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
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class InstitutionClp extends BaseModelImpl<Institution>
	implements Institution {
	public InstitutionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Institution.class;
	}

	@Override
	public String getModelClassName() {
		return Institution.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _institutionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInstitutionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _institutionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("institutionId", getInstitutionId());
		attributes.put("parentId", getParentId());
		attributes.put("name", getName());
		attributes.put("typ", getTyp());
		attributes.put("www", getWww());
		attributes.put("level", getLevel());
		attributes.put("sort", getSort());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long parentId = (Long)attributes.get("parentId");

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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public long getInstitutionId() {
		return _institutionId;
	}

	@Override
	public void setInstitutionId(long institutionId) {
		_institutionId = institutionId;

		if (_institutionRemoteModel != null) {
			try {
				Class<?> clazz = _institutionRemoteModel.getClass();

				Method method = clazz.getMethod("setInstitutionId", long.class);

				method.invoke(_institutionRemoteModel, institutionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_institutionRemoteModel != null) {
			try {
				Class<?> clazz = _institutionRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_institutionRemoteModel, parentId);
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

		if (_institutionRemoteModel != null) {
			try {
				Class<?> clazz = _institutionRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_institutionRemoteModel, name);
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

		if (_institutionRemoteModel != null) {
			try {
				Class<?> clazz = _institutionRemoteModel.getClass();

				Method method = clazz.getMethod("setTyp", String.class);

				method.invoke(_institutionRemoteModel, typ);
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

		if (_institutionRemoteModel != null) {
			try {
				Class<?> clazz = _institutionRemoteModel.getClass();

				Method method = clazz.getMethod("setWww", String.class);

				method.invoke(_institutionRemoteModel, www);
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

		if (_institutionRemoteModel != null) {
			try {
				Class<?> clazz = _institutionRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel", int.class);

				method.invoke(_institutionRemoteModel, level);
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

		if (_institutionRemoteModel != null) {
			try {
				Class<?> clazz = _institutionRemoteModel.getClass();

				Method method = clazz.getMethod("setSort", int.class);

				method.invoke(_institutionRemoteModel, sort);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_institutionRemoteModel != null) {
			try {
				Class<?> clazz = _institutionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_institutionRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getPath() {
		try {
			String methodName = "getPath";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setPath(java.lang.String path) {
		try {
			String methodName = "setPath";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { path };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getInstitutionRemoteModel() {
		return _institutionRemoteModel;
	}

	public void setInstitutionRemoteModel(BaseModel<?> institutionRemoteModel) {
		_institutionRemoteModel = institutionRemoteModel;
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

		Class<?> remoteModelClass = _institutionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_institutionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			InstitutionLocalServiceUtil.addInstitution(this);
		}
		else {
			InstitutionLocalServiceUtil.updateInstitution(this);
		}
	}

	@Override
	public Institution toEscapedModel() {
		return (Institution)ProxyUtil.newProxyInstance(Institution.class.getClassLoader(),
			new Class[] { Institution.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InstitutionClp clone = new InstitutionClp();

		clone.setInstitutionId(getInstitutionId());
		clone.setParentId(getParentId());
		clone.setName(getName());
		clone.setTyp(getTyp());
		clone.setWww(getWww());
		clone.setLevel(getLevel());
		clone.setSort(getSort());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(Institution institution) {
		long primaryKey = institution.getPrimaryKey();

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

		if (!(obj instanceof InstitutionClp)) {
			return false;
		}

		InstitutionClp institution = (InstitutionClp)obj;

		long primaryKey = institution.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{institutionId=");
		sb.append(getInstitutionId());
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
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Institution");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>institutionId</column-name><column-value><![CDATA[");
		sb.append(getInstitutionId());
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
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _institutionId;
	private long _parentId;
	private String _name;
	private String _typ;
	private String _www;
	private int _level;
	private int _sort;
	private long _groupId;
	private BaseModel<?> _institutionRemoteModel;
}