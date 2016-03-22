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

import de.uhh.l2g.plugins.migration.service.ClpSerializer;
import de.uhh.l2g.plugins.migration.service.LegacyStatisticsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyStatisticsClp extends BaseModelImpl<LegacyStatistics>
	implements LegacyStatistics {
	public LegacyStatisticsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyStatistics.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyStatistics.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("public_", getPublic_());
		attributes.put("private_", getPrivate_());
		attributes.put("autofill", getAutofill());
		attributes.put("date_", getDate_());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer public_ = (Integer)attributes.get("public_");

		if (public_ != null) {
			setPublic_(public_);
		}

		Integer private_ = (Integer)attributes.get("private_");

		if (private_ != null) {
			setPrivate_(private_);
		}

		Integer autofill = (Integer)attributes.get("autofill");

		if (autofill != null) {
			setAutofill(autofill);
		}

		Date date_ = (Date)attributes.get("date_");

		if (date_ != null) {
			setDate_(date_);
		}
	}

	@Override
	public int getId() {
		return _id;
	}

	@Override
	public void setId(int id) {
		_id = id;

		if (_legacyStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _legacyStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setId", int.class);

				method.invoke(_legacyStatisticsRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPublic_() {
		return _public_;
	}

	@Override
	public void setPublic_(int public_) {
		_public_ = public_;

		if (_legacyStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _legacyStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setPublic_", int.class);

				method.invoke(_legacyStatisticsRemoteModel, public_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPrivate_() {
		return _private_;
	}

	@Override
	public void setPrivate_(int private_) {
		_private_ = private_;

		if (_legacyStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _legacyStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setPrivate_", int.class);

				method.invoke(_legacyStatisticsRemoteModel, private_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAutofill() {
		return _autofill;
	}

	@Override
	public void setAutofill(int autofill) {
		_autofill = autofill;

		if (_legacyStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _legacyStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setAutofill", int.class);

				method.invoke(_legacyStatisticsRemoteModel, autofill);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDate_() {
		return _date_;
	}

	@Override
	public void setDate_(Date date_) {
		_date_ = date_;

		if (_legacyStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _legacyStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setDate_", Date.class);

				method.invoke(_legacyStatisticsRemoteModel, date_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyStatisticsRemoteModel() {
		return _legacyStatisticsRemoteModel;
	}

	public void setLegacyStatisticsRemoteModel(
		BaseModel<?> legacyStatisticsRemoteModel) {
		_legacyStatisticsRemoteModel = legacyStatisticsRemoteModel;
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

		Class<?> remoteModelClass = _legacyStatisticsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyStatisticsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyStatisticsLocalServiceUtil.addLegacyStatistics(this);
		}
		else {
			LegacyStatisticsLocalServiceUtil.updateLegacyStatistics(this);
		}
	}

	@Override
	public LegacyStatistics toEscapedModel() {
		return (LegacyStatistics)ProxyUtil.newProxyInstance(LegacyStatistics.class.getClassLoader(),
			new Class[] { LegacyStatistics.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyStatisticsClp clone = new LegacyStatisticsClp();

		clone.setId(getId());
		clone.setPublic_(getPublic_());
		clone.setPrivate_(getPrivate_());
		clone.setAutofill(getAutofill());
		clone.setDate_(getDate_());

		return clone;
	}

	@Override
	public int compareTo(LegacyStatistics legacyStatistics) {
		int primaryKey = legacyStatistics.getPrimaryKey();

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

		if (!(obj instanceof LegacyStatisticsClp)) {
			return false;
		}

		LegacyStatisticsClp legacyStatistics = (LegacyStatisticsClp)obj;

		int primaryKey = legacyStatistics.getPrimaryKey();

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
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", public_=");
		sb.append(getPublic_());
		sb.append(", private_=");
		sb.append(getPrivate_());
		sb.append(", autofill=");
		sb.append(getAutofill());
		sb.append(", date_=");
		sb.append(getDate_());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyStatistics");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>public_</column-name><column-value><![CDATA[");
		sb.append(getPublic_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>private_</column-name><column-value><![CDATA[");
		sb.append(getPrivate_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>autofill</column-name><column-value><![CDATA[");
		sb.append(getAutofill());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date_</column-name><column-value><![CDATA[");
		sb.append(getDate_());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id;
	private int _public_;
	private int _private_;
	private int _autofill;
	private Date _date_;
	private BaseModel<?> _legacyStatisticsRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}