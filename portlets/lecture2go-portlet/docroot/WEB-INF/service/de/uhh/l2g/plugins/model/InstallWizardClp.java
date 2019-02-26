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
import de.uhh.l2g.plugins.service.InstallWizardLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class InstallWizardClp extends BaseModelImpl<InstallWizard>
	implements InstallWizard {
	public InstallWizardClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return InstallWizard.class;
	}

	@Override
	public String getModelClassName() {
		return InstallWizard.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _installWizardId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInstallWizardId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _installWizardId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("installWizardId", getInstallWizardId());
		attributes.put("wizartActive", getWizartActive());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long installWizardId = (Long)attributes.get("installWizardId");

		if (installWizardId != null) {
			setInstallWizardId(installWizardId);
		}

		Integer wizartActive = (Integer)attributes.get("wizartActive");

		if (wizartActive != null) {
			setWizartActive(wizartActive);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public long getInstallWizardId() {
		return _installWizardId;
	}

	@Override
	public void setInstallWizardId(long installWizardId) {
		_installWizardId = installWizardId;

		if (_installWizardRemoteModel != null) {
			try {
				Class<?> clazz = _installWizardRemoteModel.getClass();

				Method method = clazz.getMethod("setInstallWizardId", long.class);

				method.invoke(_installWizardRemoteModel, installWizardId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getWizartActive() {
		return _wizartActive;
	}

	@Override
	public void setWizartActive(int wizartActive) {
		_wizartActive = wizartActive;

		if (_installWizardRemoteModel != null) {
			try {
				Class<?> clazz = _installWizardRemoteModel.getClass();

				Method method = clazz.getMethod("setWizartActive", int.class);

				method.invoke(_installWizardRemoteModel, wizartActive);
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

		if (_installWizardRemoteModel != null) {
			try {
				Class<?> clazz = _installWizardRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_installWizardRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_installWizardRemoteModel != null) {
			try {
				Class<?> clazz = _installWizardRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_installWizardRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getInstallWizardRemoteModel() {
		return _installWizardRemoteModel;
	}

	public void setInstallWizardRemoteModel(
		BaseModel<?> installWizardRemoteModel) {
		_installWizardRemoteModel = installWizardRemoteModel;
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

		Class<?> remoteModelClass = _installWizardRemoteModel.getClass();

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

		Object returnValue = method.invoke(_installWizardRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			InstallWizardLocalServiceUtil.addInstallWizard(this);
		}
		else {
			InstallWizardLocalServiceUtil.updateInstallWizard(this);
		}
	}

	@Override
	public InstallWizard toEscapedModel() {
		return (InstallWizard)ProxyUtil.newProxyInstance(InstallWizard.class.getClassLoader(),
			new Class[] { InstallWizard.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InstallWizardClp clone = new InstallWizardClp();

		clone.setInstallWizardId(getInstallWizardId());
		clone.setWizartActive(getWizartActive());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());

		return clone;
	}

	@Override
	public int compareTo(InstallWizard installWizard) {
		long primaryKey = installWizard.getPrimaryKey();

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

		if (!(obj instanceof InstallWizardClp)) {
			return false;
		}

		InstallWizardClp installWizard = (InstallWizardClp)obj;

		long primaryKey = installWizard.getPrimaryKey();

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

		sb.append("{installWizardId=");
		sb.append(getInstallWizardId());
		sb.append(", wizartActive=");
		sb.append(getWizartActive());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.InstallWizard");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>installWizardId</column-name><column-value><![CDATA[");
		sb.append(getInstallWizardId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wizartActive</column-name><column-value><![CDATA[");
		sb.append(getWizartActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _installWizardId;
	private int _wizartActive;
	private long _groupId;
	private long _companyId;
	private BaseModel<?> _installWizardRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}