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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.OaiRecordLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class OaiRecordClp extends BaseModelImpl<OaiRecord> implements OaiRecord {
	public OaiRecordClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return OaiRecord.class;
	}

	@Override
	public String getModelClassName() {
		return OaiRecord.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _oaiRecordId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOaiRecordId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _oaiRecordId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("oaiRecordId", getOaiRecordId());
		attributes.put("videoId", getVideoId());
		attributes.put("identifier", getIdentifier());
		attributes.put("datestamp", getDatestamp());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long oaiRecordId = (Long)attributes.get("oaiRecordId");

		if (oaiRecordId != null) {
			setOaiRecordId(oaiRecordId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		String identifier = (String)attributes.get("identifier");

		if (identifier != null) {
			setIdentifier(identifier);
		}

		Date datestamp = (Date)attributes.get("datestamp");

		if (datestamp != null) {
			setDatestamp(datestamp);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	@Override
	public long getOaiRecordId() {
		return _oaiRecordId;
	}

	@Override
	public void setOaiRecordId(long oaiRecordId) {
		_oaiRecordId = oaiRecordId;

		if (_oaiRecordRemoteModel != null) {
			try {
				Class<?> clazz = _oaiRecordRemoteModel.getClass();

				Method method = clazz.getMethod("setOaiRecordId", long.class);

				method.invoke(_oaiRecordRemoteModel, oaiRecordId);
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

		if (_oaiRecordRemoteModel != null) {
			try {
				Class<?> clazz = _oaiRecordRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", long.class);

				method.invoke(_oaiRecordRemoteModel, videoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdentifier() {
		return _identifier;
	}

	@Override
	public void setIdentifier(String identifier) {
		_identifier = identifier;

		if (_oaiRecordRemoteModel != null) {
			try {
				Class<?> clazz = _oaiRecordRemoteModel.getClass();

				Method method = clazz.getMethod("setIdentifier", String.class);

				method.invoke(_oaiRecordRemoteModel, identifier);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDatestamp() {
		return _datestamp;
	}

	@Override
	public void setDatestamp(Date datestamp) {
		_datestamp = datestamp;

		if (_oaiRecordRemoteModel != null) {
			try {
				Class<?> clazz = _oaiRecordRemoteModel.getClass();

				Method method = clazz.getMethod("setDatestamp", Date.class);

				method.invoke(_oaiRecordRemoteModel, datestamp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDeleted() {
		return _deleted;
	}

	@Override
	public boolean isDeleted() {
		return _deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		_deleted = deleted;

		if (_oaiRecordRemoteModel != null) {
			try {
				Class<?> clazz = _oaiRecordRemoteModel.getClass();

				Method method = clazz.getMethod("setDeleted", boolean.class);

				method.invoke(_oaiRecordRemoteModel, deleted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOaiRecordRemoteModel() {
		return _oaiRecordRemoteModel;
	}

	public void setOaiRecordRemoteModel(BaseModel<?> oaiRecordRemoteModel) {
		_oaiRecordRemoteModel = oaiRecordRemoteModel;
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

		Class<?> remoteModelClass = _oaiRecordRemoteModel.getClass();

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

		Object returnValue = method.invoke(_oaiRecordRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OaiRecordLocalServiceUtil.addOaiRecord(this);
		}
		else {
			OaiRecordLocalServiceUtil.updateOaiRecord(this);
		}
	}

	@Override
	public OaiRecord toEscapedModel() {
		return (OaiRecord)ProxyUtil.newProxyInstance(OaiRecord.class.getClassLoader(),
			new Class[] { OaiRecord.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OaiRecordClp clone = new OaiRecordClp();

		clone.setOaiRecordId(getOaiRecordId());
		clone.setVideoId(getVideoId());
		clone.setIdentifier(getIdentifier());
		clone.setDatestamp(getDatestamp());
		clone.setDeleted(getDeleted());

		return clone;
	}

	@Override
	public int compareTo(OaiRecord oaiRecord) {
		int value = 0;

		value = DateUtil.compareTo(getDatestamp(), oaiRecord.getDatestamp());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OaiRecordClp)) {
			return false;
		}

		OaiRecordClp oaiRecord = (OaiRecordClp)obj;

		long primaryKey = oaiRecord.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{oaiRecordId=");
		sb.append(getOaiRecordId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", identifier=");
		sb.append(getIdentifier());
		sb.append(", datestamp=");
		sb.append(getDatestamp());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.OaiRecord");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>oaiRecordId</column-name><column-value><![CDATA[");
		sb.append(getOaiRecordId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>identifier</column-name><column-value><![CDATA[");
		sb.append(getIdentifier());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>datestamp</column-name><column-value><![CDATA[");
		sb.append(getDatestamp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _oaiRecordId;
	private long _videoId;
	private String _identifier;
	private Date _datestamp;
	private boolean _deleted;
	private BaseModel<?> _oaiRecordRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}