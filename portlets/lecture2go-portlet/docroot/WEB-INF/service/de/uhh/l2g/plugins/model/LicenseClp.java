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
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class LicenseClp extends BaseModelImpl<License> implements License {
	public LicenseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return License.class;
	}

	@Override
	public String getModelClassName() {
		return License.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _licenseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLicenseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _licenseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("licenseId", getLicenseId());
		attributes.put("fullName", getFullName());
		attributes.put("shortIdentifier", getShortIdentifier());
		attributes.put("url", getUrl());
		attributes.put("schemeName", getSchemeName());
		attributes.put("schemeUrl", getSchemeUrl());
		attributes.put("selectable", getSelectable());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long licenseId = (Long)attributes.get("licenseId");

		if (licenseId != null) {
			setLicenseId(licenseId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String shortIdentifier = (String)attributes.get("shortIdentifier");

		if (shortIdentifier != null) {
			setShortIdentifier(shortIdentifier);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String schemeName = (String)attributes.get("schemeName");

		if (schemeName != null) {
			setSchemeName(schemeName);
		}

		String schemeUrl = (String)attributes.get("schemeUrl");

		if (schemeUrl != null) {
			setSchemeUrl(schemeUrl);
		}

		Boolean selectable = (Boolean)attributes.get("selectable");

		if (selectable != null) {
			setSelectable(selectable);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getLicenseId() {
		return _licenseId;
	}

	@Override
	public void setLicenseId(long licenseId) {
		_licenseId = licenseId;

		if (_licenseRemoteModel != null) {
			try {
				Class<?> clazz = _licenseRemoteModel.getClass();

				Method method = clazz.getMethod("setLicenseId", long.class);

				method.invoke(_licenseRemoteModel, licenseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFullName() {
		return _fullName;
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;

		if (_licenseRemoteModel != null) {
			try {
				Class<?> clazz = _licenseRemoteModel.getClass();

				Method method = clazz.getMethod("setFullName", String.class);

				method.invoke(_licenseRemoteModel, fullName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShortIdentifier() {
		return _shortIdentifier;
	}

	@Override
	public void setShortIdentifier(String shortIdentifier) {
		_shortIdentifier = shortIdentifier;

		if (_licenseRemoteModel != null) {
			try {
				Class<?> clazz = _licenseRemoteModel.getClass();

				Method method = clazz.getMethod("setShortIdentifier",
						String.class);

				method.invoke(_licenseRemoteModel, shortIdentifier);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_licenseRemoteModel != null) {
			try {
				Class<?> clazz = _licenseRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_licenseRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSchemeName() {
		return _schemeName;
	}

	@Override
	public void setSchemeName(String schemeName) {
		_schemeName = schemeName;

		if (_licenseRemoteModel != null) {
			try {
				Class<?> clazz = _licenseRemoteModel.getClass();

				Method method = clazz.getMethod("setSchemeName", String.class);

				method.invoke(_licenseRemoteModel, schemeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSchemeUrl() {
		return _schemeUrl;
	}

	@Override
	public void setSchemeUrl(String schemeUrl) {
		_schemeUrl = schemeUrl;

		if (_licenseRemoteModel != null) {
			try {
				Class<?> clazz = _licenseRemoteModel.getClass();

				Method method = clazz.getMethod("setSchemeUrl", String.class);

				method.invoke(_licenseRemoteModel, schemeUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSelectable() {
		return _selectable;
	}

	@Override
	public boolean isSelectable() {
		return _selectable;
	}

	@Override
	public void setSelectable(boolean selectable) {
		_selectable = selectable;

		if (_licenseRemoteModel != null) {
			try {
				Class<?> clazz = _licenseRemoteModel.getClass();

				Method method = clazz.getMethod("setSelectable", boolean.class);

				method.invoke(_licenseRemoteModel, selectable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_licenseRemoteModel != null) {
			try {
				Class<?> clazz = _licenseRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_licenseRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLicenseRemoteModel() {
		return _licenseRemoteModel;
	}

	public void setLicenseRemoteModel(BaseModel<?> licenseRemoteModel) {
		_licenseRemoteModel = licenseRemoteModel;
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

		Class<?> remoteModelClass = _licenseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_licenseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LicenseLocalServiceUtil.addLicense(this);
		}
		else {
			LicenseLocalServiceUtil.updateLicense(this);
		}
	}

	@Override
	public License toEscapedModel() {
		return (License)ProxyUtil.newProxyInstance(License.class.getClassLoader(),
			new Class[] { License.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LicenseClp clone = new LicenseClp();

		clone.setLicenseId(getLicenseId());
		clone.setFullName(getFullName());
		clone.setShortIdentifier(getShortIdentifier());
		clone.setUrl(getUrl());
		clone.setSchemeName(getSchemeName());
		clone.setSchemeUrl(getSchemeUrl());
		clone.setSelectable(getSelectable());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(License license) {
		long primaryKey = license.getPrimaryKey();

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

		if (!(obj instanceof LicenseClp)) {
			return false;
		}

		LicenseClp license = (LicenseClp)obj;

		long primaryKey = license.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{licenseId=");
		sb.append(getLicenseId());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", shortIdentifier=");
		sb.append(getShortIdentifier());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", schemeName=");
		sb.append(getSchemeName());
		sb.append(", schemeUrl=");
		sb.append(getSchemeUrl());
		sb.append(", selectable=");
		sb.append(getSelectable());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.License");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>licenseId</column-name><column-value><![CDATA[");
		sb.append(getLicenseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortIdentifier</column-name><column-value><![CDATA[");
		sb.append(getShortIdentifier());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>schemeName</column-name><column-value><![CDATA[");
		sb.append(getSchemeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>schemeUrl</column-name><column-value><![CDATA[");
		sb.append(getSchemeUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>selectable</column-name><column-value><![CDATA[");
		sb.append(getSelectable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _licenseId;
	private String _fullName;
	private String _shortIdentifier;
	private String _url;
	private String _schemeName;
	private String _schemeUrl;
	private boolean _selectable;
	private String _description;
	private BaseModel<?> _licenseRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}