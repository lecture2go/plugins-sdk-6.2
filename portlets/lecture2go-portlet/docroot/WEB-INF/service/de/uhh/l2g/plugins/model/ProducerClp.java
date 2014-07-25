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
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class ProducerClp extends BaseModelImpl<Producer> implements Producer {
	public ProducerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Producer.class;
	}

	@Override
	public String getModelClassName() {
		return Producer.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _producerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProducerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _producerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("producerId", getProducerId());
		attributes.put("idNum", getIdNum());
		attributes.put("homeDir", getHomeDir());
		attributes.put("hostId", getHostId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("numberOfProductions", getNumberOfProductions());
		attributes.put("approved", getApproved());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}

		String idNum = (String)attributes.get("idNum");

		if (idNum != null) {
			setIdNum(idNum);
		}

		String homeDir = (String)attributes.get("homeDir");

		if (homeDir != null) {
			setHomeDir(homeDir);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Long numberOfProductions = (Long)attributes.get("numberOfProductions");

		if (numberOfProductions != null) {
			setNumberOfProductions(numberOfProductions);
		}

		Integer approved = (Integer)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}
	}

	@Override
	public long getProducerId() {
		return _producerId;
	}

	@Override
	public void setProducerId(long producerId) {
		_producerId = producerId;

		if (_producerRemoteModel != null) {
			try {
				Class<?> clazz = _producerRemoteModel.getClass();

				Method method = clazz.getMethod("setProducerId", long.class);

				method.invoke(_producerRemoteModel, producerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdNum() {
		return _idNum;
	}

	@Override
	public void setIdNum(String idNum) {
		_idNum = idNum;

		if (_producerRemoteModel != null) {
			try {
				Class<?> clazz = _producerRemoteModel.getClass();

				Method method = clazz.getMethod("setIdNum", String.class);

				method.invoke(_producerRemoteModel, idNum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHomeDir() {
		return _homeDir;
	}

	@Override
	public void setHomeDir(String homeDir) {
		_homeDir = homeDir;

		if (_producerRemoteModel != null) {
			try {
				Class<?> clazz = _producerRemoteModel.getClass();

				Method method = clazz.getMethod("setHomeDir", String.class);

				method.invoke(_producerRemoteModel, homeDir);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHostId() {
		return _hostId;
	}

	@Override
	public void setHostId(long hostId) {
		_hostId = hostId;

		if (_producerRemoteModel != null) {
			try {
				Class<?> clazz = _producerRemoteModel.getClass();

				Method method = clazz.getMethod("setHostId", long.class);

				method.invoke(_producerRemoteModel, hostId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFacilityId() {
		return _facilityId;
	}

	@Override
	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;

		if (_producerRemoteModel != null) {
			try {
				Class<?> clazz = _producerRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityId", long.class);

				method.invoke(_producerRemoteModel, facilityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNumberOfProductions() {
		return _numberOfProductions;
	}

	@Override
	public void setNumberOfProductions(long numberOfProductions) {
		_numberOfProductions = numberOfProductions;

		if (_producerRemoteModel != null) {
			try {
				Class<?> clazz = _producerRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberOfProductions",
						long.class);

				method.invoke(_producerRemoteModel, numberOfProductions);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getApproved() {
		return _approved;
	}

	@Override
	public void setApproved(int approved) {
		_approved = approved;

		if (_producerRemoteModel != null) {
			try {
				Class<?> clazz = _producerRemoteModel.getClass();

				Method method = clazz.getMethod("setApproved", int.class);

				method.invoke(_producerRemoteModel, approved);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProducerRemoteModel() {
		return _producerRemoteModel;
	}

	public void setProducerRemoteModel(BaseModel<?> producerRemoteModel) {
		_producerRemoteModel = producerRemoteModel;
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

		Class<?> remoteModelClass = _producerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_producerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProducerLocalServiceUtil.addProducer(this);
		}
		else {
			ProducerLocalServiceUtil.updateProducer(this);
		}
	}

	@Override
	public Producer toEscapedModel() {
		return (Producer)ProxyUtil.newProxyInstance(Producer.class.getClassLoader(),
			new Class[] { Producer.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProducerClp clone = new ProducerClp();

		clone.setProducerId(getProducerId());
		clone.setIdNum(getIdNum());
		clone.setHomeDir(getHomeDir());
		clone.setHostId(getHostId());
		clone.setFacilityId(getFacilityId());
		clone.setNumberOfProductions(getNumberOfProductions());
		clone.setApproved(getApproved());

		return clone;
	}

	@Override
	public int compareTo(Producer producer) {
		long primaryKey = producer.getPrimaryKey();

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

		if (!(obj instanceof ProducerClp)) {
			return false;
		}

		ProducerClp producer = (ProducerClp)obj;

		long primaryKey = producer.getPrimaryKey();

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

		sb.append("{producerId=");
		sb.append(getProducerId());
		sb.append(", idNum=");
		sb.append(getIdNum());
		sb.append(", homeDir=");
		sb.append(getHomeDir());
		sb.append(", hostId=");
		sb.append(getHostId());
		sb.append(", facilityId=");
		sb.append(getFacilityId());
		sb.append(", numberOfProductions=");
		sb.append(getNumberOfProductions());
		sb.append(", approved=");
		sb.append(getApproved());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Producer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>producerId</column-name><column-value><![CDATA[");
		sb.append(getProducerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNum</column-name><column-value><![CDATA[");
		sb.append(getIdNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>homeDir</column-name><column-value><![CDATA[");
		sb.append(getHomeDir());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hostId</column-name><column-value><![CDATA[");
		sb.append(getHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilityId</column-name><column-value><![CDATA[");
		sb.append(getFacilityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfProductions</column-name><column-value><![CDATA[");
		sb.append(getNumberOfProductions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approved</column-name><column-value><![CDATA[");
		sb.append(getApproved());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _producerId;
	private String _idNum;
	private String _homeDir;
	private long _hostId;
	private long _facilityId;
	private long _numberOfProductions;
	private int _approved;
	private BaseModel<?> _producerRemoteModel;
}