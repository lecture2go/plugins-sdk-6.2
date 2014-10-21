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
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class CoordinatorClp extends BaseModelImpl<Coordinator>
	implements Coordinator {
	public CoordinatorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Coordinator.class;
	}

	@Override
	public String getModelClassName() {
		return Coordinator.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _coordinatorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCoordinatorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _coordinatorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("coordinatorId", getCoordinatorId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("officeId", getOfficeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long coordinatorId = (Long)attributes.get("coordinatorId");

		if (coordinatorId != null) {
			setCoordinatorId(coordinatorId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Long officeId = (Long)attributes.get("officeId");

		if (officeId != null) {
			setOfficeId(officeId);
		}
	}

	@Override
	public long getCoordinatorId() {
		return _coordinatorId;
	}

	@Override
	public void setCoordinatorId(long coordinatorId) {
		_coordinatorId = coordinatorId;

		if (_coordinatorRemoteModel != null) {
			try {
				Class<?> clazz = _coordinatorRemoteModel.getClass();

				Method method = clazz.getMethod("setCoordinatorId", long.class);

				method.invoke(_coordinatorRemoteModel, coordinatorId);
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

		if (_coordinatorRemoteModel != null) {
			try {
				Class<?> clazz = _coordinatorRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityId", long.class);

				method.invoke(_coordinatorRemoteModel, facilityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOfficeId() {
		return _officeId;
	}

	@Override
	public void setOfficeId(long officeId) {
		_officeId = officeId;

		if (_coordinatorRemoteModel != null) {
			try {
				Class<?> clazz = _coordinatorRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeId", long.class);

				method.invoke(_coordinatorRemoteModel, officeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getLastName() {
		try {
			String methodName = "getLastName";

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
	public java.lang.String getEmailAddress() {
		try {
			String methodName = "getEmailAddress";

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
	public void setLastName(java.lang.String lastName) {
		try {
			String methodName = "setLastName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { lastName };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.Date getLastLoginDate() {
		try {
			String methodName = "getLastLoginDate";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.Date returnObj = (java.util.Date)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setLastLoginDate(java.util.Date lastLoginDate) {
		try {
			String methodName = "setLastLoginDate";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.Date.class };

			Object[] parameterValues = new Object[] { lastLoginDate };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		try {
			String methodName = "setEmailAddress";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { emailAddress };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setFirstName(java.lang.String firstName) {
		try {
			String methodName = "setFirstName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { firstName };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getFirstName() {
		try {
			String methodName = "getFirstName";

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

	public BaseModel<?> getCoordinatorRemoteModel() {
		return _coordinatorRemoteModel;
	}

	public void setCoordinatorRemoteModel(BaseModel<?> coordinatorRemoteModel) {
		_coordinatorRemoteModel = coordinatorRemoteModel;
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

		Class<?> remoteModelClass = _coordinatorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_coordinatorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CoordinatorLocalServiceUtil.addCoordinator(this);
		}
		else {
			CoordinatorLocalServiceUtil.updateCoordinator(this);
		}
	}

	@Override
	public Coordinator toEscapedModel() {
		return (Coordinator)ProxyUtil.newProxyInstance(Coordinator.class.getClassLoader(),
			new Class[] { Coordinator.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CoordinatorClp clone = new CoordinatorClp();

		clone.setCoordinatorId(getCoordinatorId());
		clone.setFacilityId(getFacilityId());
		clone.setOfficeId(getOfficeId());

		return clone;
	}

	@Override
	public int compareTo(Coordinator coordinator) {
		long primaryKey = coordinator.getPrimaryKey();

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

		if (!(obj instanceof CoordinatorClp)) {
			return false;
		}

		CoordinatorClp coordinator = (CoordinatorClp)obj;

		long primaryKey = coordinator.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{coordinatorId=");
		sb.append(getCoordinatorId());
		sb.append(", facilityId=");
		sb.append(getFacilityId());
		sb.append(", officeId=");
		sb.append(getOfficeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Coordinator");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>coordinatorId</column-name><column-value><![CDATA[");
		sb.append(getCoordinatorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilityId</column-name><column-value><![CDATA[");
		sb.append(getFacilityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeId</column-name><column-value><![CDATA[");
		sb.append(getOfficeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _coordinatorId;
	private long _facilityId;
	private long _officeId;
	private BaseModel<?> _coordinatorRemoteModel;
}