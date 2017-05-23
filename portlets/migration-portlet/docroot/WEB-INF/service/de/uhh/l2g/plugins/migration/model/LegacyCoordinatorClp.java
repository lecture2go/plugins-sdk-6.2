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
import de.uhh.l2g.plugins.migration.service.LegacyCoordinatorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyCoordinatorClp extends BaseModelImpl<LegacyCoordinator>
	implements LegacyCoordinator {
	public LegacyCoordinatorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyCoordinator.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyCoordinator.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _userId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("officeId", getOfficeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
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
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_legacyCoordinatorRemoteModel != null) {
			try {
				Class<?> clazz = _legacyCoordinatorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_legacyCoordinatorRemoteModel, userId);
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

	@Override
	public long getFacilityId() {
		return _facilityId;
	}

	@Override
	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;

		if (_legacyCoordinatorRemoteModel != null) {
			try {
				Class<?> clazz = _legacyCoordinatorRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityId", long.class);

				method.invoke(_legacyCoordinatorRemoteModel, facilityId);
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

		if (_legacyCoordinatorRemoteModel != null) {
			try {
				Class<?> clazz = _legacyCoordinatorRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeId", long.class);

				method.invoke(_legacyCoordinatorRemoteModel, officeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyCoordinatorRemoteModel() {
		return _legacyCoordinatorRemoteModel;
	}

	public void setLegacyCoordinatorRemoteModel(
		BaseModel<?> legacyCoordinatorRemoteModel) {
		_legacyCoordinatorRemoteModel = legacyCoordinatorRemoteModel;
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

		Class<?> remoteModelClass = _legacyCoordinatorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyCoordinatorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyCoordinatorLocalServiceUtil.addLegacyCoordinator(this);
		}
		else {
			LegacyCoordinatorLocalServiceUtil.updateLegacyCoordinator(this);
		}
	}

	@Override
	public LegacyCoordinator toEscapedModel() {
		return (LegacyCoordinator)ProxyUtil.newProxyInstance(LegacyCoordinator.class.getClassLoader(),
			new Class[] { LegacyCoordinator.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyCoordinatorClp clone = new LegacyCoordinatorClp();

		clone.setUserId(getUserId());
		clone.setFacilityId(getFacilityId());
		clone.setOfficeId(getOfficeId());

		return clone;
	}

	@Override
	public int compareTo(LegacyCoordinator legacyCoordinator) {
		long primaryKey = legacyCoordinator.getPrimaryKey();

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

		if (!(obj instanceof LegacyCoordinatorClp)) {
			return false;
		}

		LegacyCoordinatorClp legacyCoordinator = (LegacyCoordinatorClp)obj;

		long primaryKey = legacyCoordinator.getPrimaryKey();

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

		sb.append("{userId=");
		sb.append(getUserId());
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
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyCoordinator");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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

	private long _userId;
	private String _userUuid;
	private long _facilityId;
	private long _officeId;
	private BaseModel<?> _legacyCoordinatorRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}