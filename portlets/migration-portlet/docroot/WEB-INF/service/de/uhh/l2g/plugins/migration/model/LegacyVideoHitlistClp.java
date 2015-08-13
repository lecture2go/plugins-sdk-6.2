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
import de.uhh.l2g.plugins.migration.service.LegacyVideoHitlistLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyVideoHitlistClp extends BaseModelImpl<LegacyVideoHitlist>
	implements LegacyVideoHitlist {
	public LegacyVideoHitlistClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyVideoHitlist.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyVideoHitlist.class.getName();
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
		attributes.put("hitsperday", getHitsperday());
		attributes.put("hitsperweek", getHitsperweek());
		attributes.put("hitspermonth", getHitspermonth());
		attributes.put("hitsperyear", getHitsperyear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long hitsperday = (Long)attributes.get("hitsperday");

		if (hitsperday != null) {
			setHitsperday(hitsperday);
		}

		Long hitsperweek = (Long)attributes.get("hitsperweek");

		if (hitsperweek != null) {
			setHitsperweek(hitsperweek);
		}

		Long hitspermonth = (Long)attributes.get("hitspermonth");

		if (hitspermonth != null) {
			setHitspermonth(hitspermonth);
		}

		Long hitsperyear = (Long)attributes.get("hitsperyear");

		if (hitsperyear != null) {
			setHitsperyear(hitsperyear);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_legacyVideoHitlistRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoHitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_legacyVideoHitlistRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHitsperday() {
		return _hitsperday;
	}

	@Override
	public void setHitsperday(long hitsperday) {
		_hitsperday = hitsperday;

		if (_legacyVideoHitlistRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoHitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setHitsperday", long.class);

				method.invoke(_legacyVideoHitlistRemoteModel, hitsperday);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHitsperweek() {
		return _hitsperweek;
	}

	@Override
	public void setHitsperweek(long hitsperweek) {
		_hitsperweek = hitsperweek;

		if (_legacyVideoHitlistRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoHitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setHitsperweek", long.class);

				method.invoke(_legacyVideoHitlistRemoteModel, hitsperweek);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHitspermonth() {
		return _hitspermonth;
	}

	@Override
	public void setHitspermonth(long hitspermonth) {
		_hitspermonth = hitspermonth;

		if (_legacyVideoHitlistRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoHitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setHitspermonth", long.class);

				method.invoke(_legacyVideoHitlistRemoteModel, hitspermonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHitsperyear() {
		return _hitsperyear;
	}

	@Override
	public void setHitsperyear(long hitsperyear) {
		_hitsperyear = hitsperyear;

		if (_legacyVideoHitlistRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoHitlistRemoteModel.getClass();

				Method method = clazz.getMethod("setHitsperyear", long.class);

				method.invoke(_legacyVideoHitlistRemoteModel, hitsperyear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyVideoHitlistRemoteModel() {
		return _legacyVideoHitlistRemoteModel;
	}

	public void setLegacyVideoHitlistRemoteModel(
		BaseModel<?> legacyVideoHitlistRemoteModel) {
		_legacyVideoHitlistRemoteModel = legacyVideoHitlistRemoteModel;
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

		Class<?> remoteModelClass = _legacyVideoHitlistRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyVideoHitlistRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyVideoHitlistLocalServiceUtil.addLegacyVideoHitlist(this);
		}
		else {
			LegacyVideoHitlistLocalServiceUtil.updateLegacyVideoHitlist(this);
		}
	}

	@Override
	public LegacyVideoHitlist toEscapedModel() {
		return (LegacyVideoHitlist)ProxyUtil.newProxyInstance(LegacyVideoHitlist.class.getClassLoader(),
			new Class[] { LegacyVideoHitlist.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyVideoHitlistClp clone = new LegacyVideoHitlistClp();

		clone.setId(getId());
		clone.setHitsperday(getHitsperday());
		clone.setHitsperweek(getHitsperweek());
		clone.setHitspermonth(getHitspermonth());
		clone.setHitsperyear(getHitsperyear());

		return clone;
	}

	@Override
	public int compareTo(LegacyVideoHitlist legacyVideoHitlist) {
		long primaryKey = legacyVideoHitlist.getPrimaryKey();

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

		if (!(obj instanceof LegacyVideoHitlistClp)) {
			return false;
		}

		LegacyVideoHitlistClp legacyVideoHitlist = (LegacyVideoHitlistClp)obj;

		long primaryKey = legacyVideoHitlist.getPrimaryKey();

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

		sb.append("{id=");
		sb.append(getId());
		sb.append(", hitsperday=");
		sb.append(getHitsperday());
		sb.append(", hitsperweek=");
		sb.append(getHitsperweek());
		sb.append(", hitspermonth=");
		sb.append(getHitspermonth());
		sb.append(", hitsperyear=");
		sb.append(getHitsperyear());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyVideoHitlist");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hitsperday</column-name><column-value><![CDATA[");
		sb.append(getHitsperday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hitsperweek</column-name><column-value><![CDATA[");
		sb.append(getHitsperweek());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hitspermonth</column-name><column-value><![CDATA[");
		sb.append(getHitspermonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hitsperyear</column-name><column-value><![CDATA[");
		sb.append(getHitsperyear());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _hitsperday;
	private long _hitsperweek;
	private long _hitspermonth;
	private long _hitsperyear;
	private BaseModel<?> _legacyVideoHitlistRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}