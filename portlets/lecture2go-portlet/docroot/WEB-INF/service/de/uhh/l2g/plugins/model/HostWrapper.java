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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Host}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Host
 * @generated
 */
public class HostWrapper implements Host, ModelWrapper<Host> {
	public HostWrapper(Host host) {
		_host = host;
	}

	@Override
	public Class<?> getModelClass() {
		return Host.class;
	}

	@Override
	public String getModelClassName() {
		return Host.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hostId", getHostId());
		attributes.put("protocol", getProtocol());
		attributes.put("streamer", getStreamer());
		attributes.put("port", getPort());
		attributes.put("serverRoot", getServerRoot());
		attributes.put("serverTemplate", getServerTemplate());
		attributes.put("name", getName());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		String protocol = (String)attributes.get("protocol");

		if (protocol != null) {
			setProtocol(protocol);
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

		String serverTemplate = (String)attributes.get("serverTemplate");

		if (serverTemplate != null) {
			setServerTemplate(serverTemplate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this host.
	*
	* @return the primary key of this host
	*/
	@Override
	public long getPrimaryKey() {
		return _host.getPrimaryKey();
	}

	/**
	* Sets the primary key of this host.
	*
	* @param primaryKey the primary key of this host
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_host.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the host ID of this host.
	*
	* @return the host ID of this host
	*/
	@Override
	public long getHostId() {
		return _host.getHostId();
	}

	/**
	* Sets the host ID of this host.
	*
	* @param hostId the host ID of this host
	*/
	@Override
	public void setHostId(long hostId) {
		_host.setHostId(hostId);
	}

	/**
	* Returns the protocol of this host.
	*
	* @return the protocol of this host
	*/
	@Override
	public java.lang.String getProtocol() {
		return _host.getProtocol();
	}

	/**
	* Sets the protocol of this host.
	*
	* @param protocol the protocol of this host
	*/
	@Override
	public void setProtocol(java.lang.String protocol) {
		_host.setProtocol(protocol);
	}

	/**
	* Returns the streamer of this host.
	*
	* @return the streamer of this host
	*/
	@Override
	public java.lang.String getStreamer() {
		return _host.getStreamer();
	}

	/**
	* Sets the streamer of this host.
	*
	* @param streamer the streamer of this host
	*/
	@Override
	public void setStreamer(java.lang.String streamer) {
		_host.setStreamer(streamer);
	}

	/**
	* Returns the port of this host.
	*
	* @return the port of this host
	*/
	@Override
	public int getPort() {
		return _host.getPort();
	}

	/**
	* Sets the port of this host.
	*
	* @param port the port of this host
	*/
	@Override
	public void setPort(int port) {
		_host.setPort(port);
	}

	/**
	* Returns the server root of this host.
	*
	* @return the server root of this host
	*/
	@Override
	public java.lang.String getServerRoot() {
		return _host.getServerRoot();
	}

	/**
	* Sets the server root of this host.
	*
	* @param serverRoot the server root of this host
	*/
	@Override
	public void setServerRoot(java.lang.String serverRoot) {
		_host.setServerRoot(serverRoot);
	}

	/**
	* Returns the server template of this host.
	*
	* @return the server template of this host
	*/
	@Override
	public java.lang.String getServerTemplate() {
		return _host.getServerTemplate();
	}

	/**
	* Sets the server template of this host.
	*
	* @param serverTemplate the server template of this host
	*/
	@Override
	public void setServerTemplate(java.lang.String serverTemplate) {
		_host.setServerTemplate(serverTemplate);
	}

	/**
	* Returns the name of this host.
	*
	* @return the name of this host
	*/
	@Override
	public java.lang.String getName() {
		return _host.getName();
	}

	/**
	* Sets the name of this host.
	*
	* @param name the name of this host
	*/
	@Override
	public void setName(java.lang.String name) {
		_host.setName(name);
	}

	/**
	* Returns the group ID of this host.
	*
	* @return the group ID of this host
	*/
	@Override
	public long getGroupId() {
		return _host.getGroupId();
	}

	/**
	* Sets the group ID of this host.
	*
	* @param groupId the group ID of this host
	*/
	@Override
	public void setGroupId(long groupId) {
		_host.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _host.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_host.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _host.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_host.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _host.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _host.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_host.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _host.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_host.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_host.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_host.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HostWrapper((Host)_host.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Host host) {
		return _host.compareTo(host);
	}

	@Override
	public int hashCode() {
		return _host.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Host> toCacheModel() {
		return _host.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Host toEscapedModel() {
		return new HostWrapper(_host.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Host toUnescapedModel() {
		return new HostWrapper(_host.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _host.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _host.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_host.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HostWrapper)) {
			return false;
		}

		HostWrapper hostWrapper = (HostWrapper)obj;

		if (Validator.equals(_host, hostWrapper._host)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Host getWrappedHost() {
		return _host;
	}

	@Override
	public Host getWrappedModel() {
		return _host;
	}

	@Override
	public void resetOriginalValues() {
		_host.resetOriginalValues();
	}

	private Host _host;
}