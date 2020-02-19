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
import de.uhh.l2g.plugins.service.OaiSetLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class OaiSetClp extends BaseModelImpl<OaiSet> implements OaiSet {
	public OaiSetClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return OaiSet.class;
	}

	@Override
	public String getModelClassName() {
		return OaiSet.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _oaiSetId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOaiSetId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _oaiSetId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("oaiSetId", getOaiSetId());
		attributes.put("setSpec", getSetSpec());
		attributes.put("setName", getSetName());
		attributes.put("setDescription", getSetDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long oaiSetId = (Long)attributes.get("oaiSetId");

		if (oaiSetId != null) {
			setOaiSetId(oaiSetId);
		}

		String setSpec = (String)attributes.get("setSpec");

		if (setSpec != null) {
			setSetSpec(setSpec);
		}

		String setName = (String)attributes.get("setName");

		if (setName != null) {
			setSetName(setName);
		}

		String setDescription = (String)attributes.get("setDescription");

		if (setDescription != null) {
			setSetDescription(setDescription);
		}
	}

	@Override
	public long getOaiSetId() {
		return _oaiSetId;
	}

	@Override
	public void setOaiSetId(long oaiSetId) {
		_oaiSetId = oaiSetId;

		if (_oaiSetRemoteModel != null) {
			try {
				Class<?> clazz = _oaiSetRemoteModel.getClass();

				Method method = clazz.getMethod("setOaiSetId", long.class);

				method.invoke(_oaiSetRemoteModel, oaiSetId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSetSpec() {
		return _setSpec;
	}

	@Override
	public void setSetSpec(String setSpec) {
		_setSpec = setSpec;

		if (_oaiSetRemoteModel != null) {
			try {
				Class<?> clazz = _oaiSetRemoteModel.getClass();

				Method method = clazz.getMethod("setSetSpec", String.class);

				method.invoke(_oaiSetRemoteModel, setSpec);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSetName() {
		return _setName;
	}

	@Override
	public void setSetName(String setName) {
		_setName = setName;

		if (_oaiSetRemoteModel != null) {
			try {
				Class<?> clazz = _oaiSetRemoteModel.getClass();

				Method method = clazz.getMethod("setSetName", String.class);

				method.invoke(_oaiSetRemoteModel, setName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSetDescription() {
		return _setDescription;
	}

	@Override
	public void setSetDescription(String setDescription) {
		_setDescription = setDescription;

		if (_oaiSetRemoteModel != null) {
			try {
				Class<?> clazz = _oaiSetRemoteModel.getClass();

				Method method = clazz.getMethod("setSetDescription",
						String.class);

				method.invoke(_oaiSetRemoteModel, setDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOaiSetRemoteModel() {
		return _oaiSetRemoteModel;
	}

	public void setOaiSetRemoteModel(BaseModel<?> oaiSetRemoteModel) {
		_oaiSetRemoteModel = oaiSetRemoteModel;
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

		Class<?> remoteModelClass = _oaiSetRemoteModel.getClass();

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

		Object returnValue = method.invoke(_oaiSetRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OaiSetLocalServiceUtil.addOaiSet(this);
		}
		else {
			OaiSetLocalServiceUtil.updateOaiSet(this);
		}
	}

	@Override
	public OaiSet toEscapedModel() {
		return (OaiSet)ProxyUtil.newProxyInstance(OaiSet.class.getClassLoader(),
			new Class[] { OaiSet.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OaiSetClp clone = new OaiSetClp();

		clone.setOaiSetId(getOaiSetId());
		clone.setSetSpec(getSetSpec());
		clone.setSetName(getSetName());
		clone.setSetDescription(getSetDescription());

		return clone;
	}

	@Override
	public int compareTo(OaiSet oaiSet) {
		long primaryKey = oaiSet.getPrimaryKey();

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

		if (!(obj instanceof OaiSetClp)) {
			return false;
		}

		OaiSetClp oaiSet = (OaiSetClp)obj;

		long primaryKey = oaiSet.getPrimaryKey();

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

		sb.append("{oaiSetId=");
		sb.append(getOaiSetId());
		sb.append(", setSpec=");
		sb.append(getSetSpec());
		sb.append(", setName=");
		sb.append(getSetName());
		sb.append(", setDescription=");
		sb.append(getSetDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.OaiSet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>oaiSetId</column-name><column-value><![CDATA[");
		sb.append(getOaiSetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>setSpec</column-name><column-value><![CDATA[");
		sb.append(getSetSpec());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>setName</column-name><column-value><![CDATA[");
		sb.append(getSetName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>setDescription</column-name><column-value><![CDATA[");
		sb.append(getSetDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _oaiSetId;
	private String _setSpec;
	private String _setName;
	private String _setDescription;
	private BaseModel<?> _oaiSetRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}