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
import de.uhh.l2g.plugins.migration.service.LegacyLicenseLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyLicenseClp extends BaseModelImpl<LegacyLicense>
	implements LegacyLicense {
	public LegacyLicenseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyLicense.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyLicense.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("videoId", getVideoId());
		attributes.put("ccby", getCcby());
		attributes.put("ccbybc", getCcbybc());
		attributes.put("ccbyncnd", getCcbyncnd());
		attributes.put("ccbyncsa", getCcbyncsa());
		attributes.put("ccbysa", getCcbysa());
		attributes.put("ccbync", getCcbync());
		attributes.put("l2go", getL2go());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Integer ccby = (Integer)attributes.get("ccby");

		if (ccby != null) {
			setCcby(ccby);
		}

		Integer ccbybc = (Integer)attributes.get("ccbybc");

		if (ccbybc != null) {
			setCcbybc(ccbybc);
		}

		Integer ccbyncnd = (Integer)attributes.get("ccbyncnd");

		if (ccbyncnd != null) {
			setCcbyncnd(ccbyncnd);
		}

		Integer ccbyncsa = (Integer)attributes.get("ccbyncsa");

		if (ccbyncsa != null) {
			setCcbyncsa(ccbyncsa);
		}

		Integer ccbysa = (Integer)attributes.get("ccbysa");

		if (ccbysa != null) {
			setCcbysa(ccbysa);
		}

		Integer ccbync = (Integer)attributes.get("ccbync");

		if (ccbync != null) {
			setCcbync(ccbync);
		}

		Integer l2go = (Integer)attributes.get("l2go");

		if (l2go != null) {
			setL2go(l2go);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_legacyLicenseRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLicenseRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_legacyLicenseRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVideoId() {
		return _videoId;
	}

	@Override
	public void setVideoId(long videoId) {
		_videoId = videoId;

		if (_legacyLicenseRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLicenseRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", long.class);

				method.invoke(_legacyLicenseRemoteModel, videoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCcby() {
		return _ccby;
	}

	@Override
	public void setCcby(int ccby) {
		_ccby = ccby;

		if (_legacyLicenseRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLicenseRemoteModel.getClass();

				Method method = clazz.getMethod("setCcby", int.class);

				method.invoke(_legacyLicenseRemoteModel, ccby);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCcbybc() {
		return _ccbybc;
	}

	@Override
	public void setCcbybc(int ccbybc) {
		_ccbybc = ccbybc;

		if (_legacyLicenseRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLicenseRemoteModel.getClass();

				Method method = clazz.getMethod("setCcbybc", int.class);

				method.invoke(_legacyLicenseRemoteModel, ccbybc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCcbyncnd() {
		return _ccbyncnd;
	}

	@Override
	public void setCcbyncnd(int ccbyncnd) {
		_ccbyncnd = ccbyncnd;

		if (_legacyLicenseRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLicenseRemoteModel.getClass();

				Method method = clazz.getMethod("setCcbyncnd", int.class);

				method.invoke(_legacyLicenseRemoteModel, ccbyncnd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCcbyncsa() {
		return _ccbyncsa;
	}

	@Override
	public void setCcbyncsa(int ccbyncsa) {
		_ccbyncsa = ccbyncsa;

		if (_legacyLicenseRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLicenseRemoteModel.getClass();

				Method method = clazz.getMethod("setCcbyncsa", int.class);

				method.invoke(_legacyLicenseRemoteModel, ccbyncsa);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCcbysa() {
		return _ccbysa;
	}

	@Override
	public void setCcbysa(int ccbysa) {
		_ccbysa = ccbysa;

		if (_legacyLicenseRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLicenseRemoteModel.getClass();

				Method method = clazz.getMethod("setCcbysa", int.class);

				method.invoke(_legacyLicenseRemoteModel, ccbysa);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCcbync() {
		return _ccbync;
	}

	@Override
	public void setCcbync(int ccbync) {
		_ccbync = ccbync;

		if (_legacyLicenseRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLicenseRemoteModel.getClass();

				Method method = clazz.getMethod("setCcbync", int.class);

				method.invoke(_legacyLicenseRemoteModel, ccbync);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getL2go() {
		return _l2go;
	}

	@Override
	public void setL2go(int l2go) {
		_l2go = l2go;

		if (_legacyLicenseRemoteModel != null) {
			try {
				Class<?> clazz = _legacyLicenseRemoteModel.getClass();

				Method method = clazz.getMethod("setL2go", int.class);

				method.invoke(_legacyLicenseRemoteModel, l2go);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyLicenseRemoteModel() {
		return _legacyLicenseRemoteModel;
	}

	public void setLegacyLicenseRemoteModel(
		BaseModel<?> legacyLicenseRemoteModel) {
		_legacyLicenseRemoteModel = legacyLicenseRemoteModel;
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

		Class<?> remoteModelClass = _legacyLicenseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyLicenseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyLicenseLocalServiceUtil.addLegacyLicense(this);
		}
		else {
			LegacyLicenseLocalServiceUtil.updateLegacyLicense(this);
		}
	}

	@Override
	public LegacyLicense toEscapedModel() {
		return (LegacyLicense)ProxyUtil.newProxyInstance(LegacyLicense.class.getClassLoader(),
			new Class[] { LegacyLicense.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyLicenseClp clone = new LegacyLicenseClp();

		clone.setId(getId());
		clone.setVideoId(getVideoId());
		clone.setCcby(getCcby());
		clone.setCcbybc(getCcbybc());
		clone.setCcbyncnd(getCcbyncnd());
		clone.setCcbyncsa(getCcbyncsa());
		clone.setCcbysa(getCcbysa());
		clone.setCcbync(getCcbync());
		clone.setL2go(getL2go());

		return clone;
	}

	@Override
	public int compareTo(LegacyLicense legacyLicense) {
		long primaryKey = legacyLicense.getPrimaryKey();

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

		if (!(obj instanceof LegacyLicenseClp)) {
			return false;
		}

		LegacyLicenseClp legacyLicense = (LegacyLicenseClp)obj;

		long primaryKey = legacyLicense.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", ccby=");
		sb.append(getCcby());
		sb.append(", ccbybc=");
		sb.append(getCcbybc());
		sb.append(", ccbyncnd=");
		sb.append(getCcbyncnd());
		sb.append(", ccbyncsa=");
		sb.append(getCcbyncsa());
		sb.append(", ccbysa=");
		sb.append(getCcbysa());
		sb.append(", ccbync=");
		sb.append(getCcbync());
		sb.append(", l2go=");
		sb.append(getL2go());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyLicense");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccby</column-name><column-value><![CDATA[");
		sb.append(getCcby());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccbybc</column-name><column-value><![CDATA[");
		sb.append(getCcbybc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccbyncnd</column-name><column-value><![CDATA[");
		sb.append(getCcbyncnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccbyncsa</column-name><column-value><![CDATA[");
		sb.append(getCcbyncsa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccbysa</column-name><column-value><![CDATA[");
		sb.append(getCcbysa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccbync</column-name><column-value><![CDATA[");
		sb.append(getCcbync());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>l2go</column-name><column-value><![CDATA[");
		sb.append(getL2go());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _videoId;
	private int _ccby;
	private int _ccbybc;
	private int _ccbyncnd;
	private int _ccbyncsa;
	private int _ccbysa;
	private int _ccbync;
	private int _l2go;
	private BaseModel<?> _legacyLicenseRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}