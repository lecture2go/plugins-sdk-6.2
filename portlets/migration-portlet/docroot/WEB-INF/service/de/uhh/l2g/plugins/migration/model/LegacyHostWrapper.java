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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegacyHost}.
 * </p>
 *
 * @author unihh
 * @see LegacyHost
 * @generated
 */
public class LegacyHostWrapper implements LegacyHost, ModelWrapper<LegacyHost> {
	public LegacyHostWrapper(LegacyHost legacyHost) {
		_legacyHost = legacyHost;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyHost.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyHost.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("protokoll", getProtokoll());
		attributes.put("streamer", getStreamer());
		attributes.put("port", getPort());
		attributes.put("serverRoot", getServerRoot());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String protokoll = (String)attributes.get("protokoll");

		if (protokoll != null) {
			setProtokoll(protokoll);
		}

		String streamer = (String)attributes.get("streamer");

		if (streamer != null) {
			setStreamer(streamer);
		}

		Integer port = (Integer)attributes.get("port");

		if (port != null) {
			setPort(port);
		}

		String serverRoot = (String)attributes.get("serverRoot");

		if (serverRoot != null) {
			setServerRoot(serverRoot);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this legacy host.
	*
	* @return the primary key of this legacy host
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyHost.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy host.
	*
	* @param primaryKey the primary key of this legacy host
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyHost.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy host.
	*
	* @return the ID of this legacy host
	*/
	@Override
	public long getId() {
		return _legacyHost.getId();
	}

	/**
	* Sets the ID of this legacy host.
	*
	* @param id the ID of this legacy host
	*/
	@Override
	public void setId(long id) {
		_legacyHost.setId(id);
	}

	/**
	* Returns the protokoll of this legacy host.
	*
	* @return the protokoll of this legacy host
	*/
	@Override
	public java.lang.String getProtokoll() {
		return _legacyHost.getProtokoll();
	}

	/**
	* Sets the protokoll of this legacy host.
	*
	* @param protokoll the protokoll of this legacy host
	*/
	@Override
	public void setProtokoll(java.lang.String protokoll) {
		_legacyHost.setProtokoll(protokoll);
	}

	/**
	* Returns the streamer of this legacy host.
	*
	* @return the streamer of this legacy host
	*/
	@Override
	public java.lang.String getStreamer() {
		return _legacyHost.getStreamer();
	}

	/**
	* Sets the streamer of this legacy host.
	*
	* @param streamer the streamer of this legacy host
	*/
	@Override
	public void setStreamer(java.lang.String streamer) {
		_legacyHost.setStreamer(streamer);
	}

	/**
	* Returns the port of this legacy host.
	*
	* @return the port of this legacy host
	*/
	@Override
	public int getPort() {
		return _legacyHost.getPort();
	}

	/**
	* Sets the port of this legacy host.
	*
	* @param port the port of this legacy host
	*/
	@Override
	public void setPort(int port) {
		_legacyHost.setPort(port);
	}

	/**
	* Returns the server root of this legacy host.
	*
	* @return the server root of this legacy host
	*/
	@Override
	public java.lang.String getServerRoot() {
		return _legacyHost.getServerRoot();
	}

	/**
	* Sets the server root of this legacy host.
	*
	* @param serverRoot the server root of this legacy host
	*/
	@Override
	public void setServerRoot(java.lang.String serverRoot) {
		_legacyHost.setServerRoot(serverRoot);
	}

	/**
	* Returns the name of this legacy host.
	*
	* @return the name of this legacy host
	*/
	@Override
	public java.lang.String getName() {
		return _legacyHost.getName();
	}

	/**
	* Sets the name of this legacy host.
	*
	* @param name the name of this legacy host
	*/
	@Override
	public void setName(java.lang.String name) {
		_legacyHost.setName(name);
	}

	@Override
	public boolean isNew() {
		return _legacyHost.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyHost.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyHost.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyHost.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyHost.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyHost.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyHost.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyHost.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyHost.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyHost.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyHost.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyHostWrapper((LegacyHost)_legacyHost.clone());
	}

	@Override
	public int compareTo(LegacyHost legacyHost) {
		return _legacyHost.compareTo(legacyHost);
	}

	@Override
	public int hashCode() {
		return _legacyHost.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<LegacyHost> toCacheModel() {
		return _legacyHost.toCacheModel();
	}

	@Override
	public LegacyHost toEscapedModel() {
		return new LegacyHostWrapper(_legacyHost.toEscapedModel());
	}

	@Override
	public LegacyHost toUnescapedModel() {
		return new LegacyHostWrapper(_legacyHost.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyHost.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyHost.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyHost.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyHostWrapper)) {
			return false;
		}

		LegacyHostWrapper legacyHostWrapper = (LegacyHostWrapper)obj;

		if (Validator.equals(_legacyHost, legacyHostWrapper._legacyHost)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyHost getWrappedLegacyHost() {
		return _legacyHost;
	}

	@Override
	public LegacyHost getWrappedModel() {
		return _legacyHost;
	}

	@Override
	public void resetOriginalValues() {
		_legacyHost.resetOriginalValues();
	}

	private LegacyHost _legacyHost;
}