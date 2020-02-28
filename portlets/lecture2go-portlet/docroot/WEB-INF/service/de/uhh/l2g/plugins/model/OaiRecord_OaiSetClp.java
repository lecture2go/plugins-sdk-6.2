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
import de.uhh.l2g.plugins.service.OaiRecord_OaiSetLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class OaiRecord_OaiSetClp extends BaseModelImpl<OaiRecord_OaiSet>
	implements OaiRecord_OaiSet {
	public OaiRecord_OaiSetClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return OaiRecord_OaiSet.class;
	}

	@Override
	public String getModelClassName() {
		return OaiRecord_OaiSet.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _oaiRecordOaiSetId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOaiRecordOaiSetId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _oaiRecordOaiSetId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("oaiRecordOaiSetId", getOaiRecordOaiSetId());
		attributes.put("oaiRecordId", getOaiRecordId());
		attributes.put("oaiSetId", getOaiSetId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long oaiRecordOaiSetId = (Long)attributes.get("oaiRecordOaiSetId");

		if (oaiRecordOaiSetId != null) {
			setOaiRecordOaiSetId(oaiRecordOaiSetId);
		}

		Long oaiRecordId = (Long)attributes.get("oaiRecordId");

		if (oaiRecordId != null) {
			setOaiRecordId(oaiRecordId);
		}

		Long oaiSetId = (Long)attributes.get("oaiSetId");

		if (oaiSetId != null) {
			setOaiSetId(oaiSetId);
		}
	}

	@Override
	public long getOaiRecordOaiSetId() {
		return _oaiRecordOaiSetId;
	}

	@Override
	public void setOaiRecordOaiSetId(long oaiRecordOaiSetId) {
		_oaiRecordOaiSetId = oaiRecordOaiSetId;

		if (_oaiRecord_OaiSetRemoteModel != null) {
			try {
				Class<?> clazz = _oaiRecord_OaiSetRemoteModel.getClass();

				Method method = clazz.getMethod("setOaiRecordOaiSetId",
						long.class);

				method.invoke(_oaiRecord_OaiSetRemoteModel, oaiRecordOaiSetId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOaiRecordId() {
		return _oaiRecordId;
	}

	@Override
	public void setOaiRecordId(long oaiRecordId) {
		_oaiRecordId = oaiRecordId;

		if (_oaiRecord_OaiSetRemoteModel != null) {
			try {
				Class<?> clazz = _oaiRecord_OaiSetRemoteModel.getClass();

				Method method = clazz.getMethod("setOaiRecordId", long.class);

				method.invoke(_oaiRecord_OaiSetRemoteModel, oaiRecordId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOaiSetId() {
		return _oaiSetId;
	}

	@Override
	public void setOaiSetId(long oaiSetId) {
		_oaiSetId = oaiSetId;

		if (_oaiRecord_OaiSetRemoteModel != null) {
			try {
				Class<?> clazz = _oaiRecord_OaiSetRemoteModel.getClass();

				Method method = clazz.getMethod("setOaiSetId", long.class);

				method.invoke(_oaiRecord_OaiSetRemoteModel, oaiSetId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOaiRecord_OaiSetRemoteModel() {
		return _oaiRecord_OaiSetRemoteModel;
	}

	public void setOaiRecord_OaiSetRemoteModel(
		BaseModel<?> oaiRecord_OaiSetRemoteModel) {
		_oaiRecord_OaiSetRemoteModel = oaiRecord_OaiSetRemoteModel;
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

		Class<?> remoteModelClass = _oaiRecord_OaiSetRemoteModel.getClass();

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

		Object returnValue = method.invoke(_oaiRecord_OaiSetRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OaiRecord_OaiSetLocalServiceUtil.addOaiRecord_OaiSet(this);
		}
		else {
			OaiRecord_OaiSetLocalServiceUtil.updateOaiRecord_OaiSet(this);
		}
	}

	@Override
	public OaiRecord_OaiSet toEscapedModel() {
		return (OaiRecord_OaiSet)ProxyUtil.newProxyInstance(OaiRecord_OaiSet.class.getClassLoader(),
			new Class[] { OaiRecord_OaiSet.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OaiRecord_OaiSetClp clone = new OaiRecord_OaiSetClp();

		clone.setOaiRecordOaiSetId(getOaiRecordOaiSetId());
		clone.setOaiRecordId(getOaiRecordId());
		clone.setOaiSetId(getOaiSetId());

		return clone;
	}

	@Override
	public int compareTo(OaiRecord_OaiSet oaiRecord_OaiSet) {
		long primaryKey = oaiRecord_OaiSet.getPrimaryKey();

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

		if (!(obj instanceof OaiRecord_OaiSetClp)) {
			return false;
		}

		OaiRecord_OaiSetClp oaiRecord_OaiSet = (OaiRecord_OaiSetClp)obj;

		long primaryKey = oaiRecord_OaiSet.getPrimaryKey();

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

		sb.append("{oaiRecordOaiSetId=");
		sb.append(getOaiRecordOaiSetId());
		sb.append(", oaiRecordId=");
		sb.append(getOaiRecordId());
		sb.append(", oaiSetId=");
		sb.append(getOaiSetId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.OaiRecord_OaiSet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>oaiRecordOaiSetId</column-name><column-value><![CDATA[");
		sb.append(getOaiRecordOaiSetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>oaiRecordId</column-name><column-value><![CDATA[");
		sb.append(getOaiRecordId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>oaiSetId</column-name><column-value><![CDATA[");
		sb.append(getOaiSetId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _oaiRecordOaiSetId;
	private long _oaiRecordId;
	private long _oaiSetId;
	private BaseModel<?> _oaiRecord_OaiSetRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}