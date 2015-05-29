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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ServerTemplate}.
 * </p>
 *
 * @author Iavor Sturm
 * @see ServerTemplate
 * @generated
 */
public class ServerTemplateWrapper implements ServerTemplate,
	ModelWrapper<ServerTemplate> {
	public ServerTemplateWrapper(ServerTemplate serverTemplate) {
		_serverTemplate = serverTemplate;
	}

	@Override
	public Class<?> getModelClass() {
		return ServerTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return ServerTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serverTemplateId", getServerTemplateId());
		attributes.put("groupId", getGroupId());
		attributes.put("name", getName());
		attributes.put("type", getType());
		attributes.put("prefixURL", getPrefixURL());
		attributes.put("suffixURL", getSuffixURL());
		attributes.put("secExt", getSecExt());
		attributes.put("templateURL", getTemplateURL());
		attributes.put("prefixFile", getPrefixFile());
		attributes.put("suffixFile", getSuffixFile());
		attributes.put("templateFile", getTemplateFile());
		attributes.put("templateIOS", getTemplateIOS());
		attributes.put("templateAndroid", getTemplateAndroid());
		attributes.put("defaultServer", getDefaultServer());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serverTemplateId = (Long)attributes.get("serverTemplateId");

		if (serverTemplateId != null) {
			setServerTemplateId(serverTemplateId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String prefixURL = (String)attributes.get("prefixURL");

		if (prefixURL != null) {
			setPrefixURL(prefixURL);
		}

		String suffixURL = (String)attributes.get("suffixURL");

		if (suffixURL != null) {
			setSuffixURL(suffixURL);
		}

		String secExt = (String)attributes.get("secExt");

		if (secExt != null) {
			setSecExt(secExt);
		}

		String templateURL = (String)attributes.get("templateURL");

		if (templateURL != null) {
			setTemplateURL(templateURL);
		}

		String prefixFile = (String)attributes.get("prefixFile");

		if (prefixFile != null) {
			setPrefixFile(prefixFile);
		}

		String suffixFile = (String)attributes.get("suffixFile");

		if (suffixFile != null) {
			setSuffixFile(suffixFile);
		}

		String templateFile = (String)attributes.get("templateFile");

		if (templateFile != null) {
			setTemplateFile(templateFile);
		}

		Long templateIOS = (Long)attributes.get("templateIOS");

		if (templateIOS != null) {
			setTemplateIOS(templateIOS);
		}

		Long templateAndroid = (Long)attributes.get("templateAndroid");

		if (templateAndroid != null) {
			setTemplateAndroid(templateAndroid);
		}

		Integer defaultServer = (Integer)attributes.get("defaultServer");

		if (defaultServer != null) {
			setDefaultServer(defaultServer);
		}
	}

	/**
	* Returns the primary key of this server template.
	*
	* @return the primary key of this server template
	*/
	@Override
	public long getPrimaryKey() {
		return _serverTemplate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this server template.
	*
	* @param primaryKey the primary key of this server template
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_serverTemplate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the server template ID of this server template.
	*
	* @return the server template ID of this server template
	*/
	@Override
	public long getServerTemplateId() {
		return _serverTemplate.getServerTemplateId();
	}

	/**
	* Sets the server template ID of this server template.
	*
	* @param serverTemplateId the server template ID of this server template
	*/
	@Override
	public void setServerTemplateId(long serverTemplateId) {
		_serverTemplate.setServerTemplateId(serverTemplateId);
	}

	/**
	* Returns the group ID of this server template.
	*
	* @return the group ID of this server template
	*/
	@Override
	public long getGroupId() {
		return _serverTemplate.getGroupId();
	}

	/**
	* Sets the group ID of this server template.
	*
	* @param groupId the group ID of this server template
	*/
	@Override
	public void setGroupId(long groupId) {
		_serverTemplate.setGroupId(groupId);
	}

	/**
	* Returns the name of this server template.
	*
	* @return the name of this server template
	*/
	@Override
	public java.lang.String getName() {
		return _serverTemplate.getName();
	}

	/**
	* Sets the name of this server template.
	*
	* @param name the name of this server template
	*/
	@Override
	public void setName(java.lang.String name) {
		_serverTemplate.setName(name);
	}

	/**
	* Returns the type of this server template.
	*
	* @return the type of this server template
	*/
	@Override
	public int getType() {
		return _serverTemplate.getType();
	}

	/**
	* Sets the type of this server template.
	*
	* @param type the type of this server template
	*/
	@Override
	public void setType(int type) {
		_serverTemplate.setType(type);
	}

	/**
	* Returns the prefix u r l of this server template.
	*
	* @return the prefix u r l of this server template
	*/
	@Override
	public java.lang.String getPrefixURL() {
		return _serverTemplate.getPrefixURL();
	}

	/**
	* Sets the prefix u r l of this server template.
	*
	* @param prefixURL the prefix u r l of this server template
	*/
	@Override
	public void setPrefixURL(java.lang.String prefixURL) {
		_serverTemplate.setPrefixURL(prefixURL);
	}

	/**
	* Returns the suffix u r l of this server template.
	*
	* @return the suffix u r l of this server template
	*/
	@Override
	public java.lang.String getSuffixURL() {
		return _serverTemplate.getSuffixURL();
	}

	/**
	* Sets the suffix u r l of this server template.
	*
	* @param suffixURL the suffix u r l of this server template
	*/
	@Override
	public void setSuffixURL(java.lang.String suffixURL) {
		_serverTemplate.setSuffixURL(suffixURL);
	}

	/**
	* Returns the sec ext of this server template.
	*
	* @return the sec ext of this server template
	*/
	@Override
	public java.lang.String getSecExt() {
		return _serverTemplate.getSecExt();
	}

	/**
	* Sets the sec ext of this server template.
	*
	* @param secExt the sec ext of this server template
	*/
	@Override
	public void setSecExt(java.lang.String secExt) {
		_serverTemplate.setSecExt(secExt);
	}

	/**
	* Returns the template u r l of this server template.
	*
	* @return the template u r l of this server template
	*/
	@Override
	public java.lang.String getTemplateURL() {
		return _serverTemplate.getTemplateURL();
	}

	/**
	* Sets the template u r l of this server template.
	*
	* @param templateURL the template u r l of this server template
	*/
	@Override
	public void setTemplateURL(java.lang.String templateURL) {
		_serverTemplate.setTemplateURL(templateURL);
	}

	/**
	* Returns the prefix file of this server template.
	*
	* @return the prefix file of this server template
	*/
	@Override
	public java.lang.String getPrefixFile() {
		return _serverTemplate.getPrefixFile();
	}

	/**
	* Sets the prefix file of this server template.
	*
	* @param prefixFile the prefix file of this server template
	*/
	@Override
	public void setPrefixFile(java.lang.String prefixFile) {
		_serverTemplate.setPrefixFile(prefixFile);
	}

	/**
	* Returns the suffix file of this server template.
	*
	* @return the suffix file of this server template
	*/
	@Override
	public java.lang.String getSuffixFile() {
		return _serverTemplate.getSuffixFile();
	}

	/**
	* Sets the suffix file of this server template.
	*
	* @param suffixFile the suffix file of this server template
	*/
	@Override
	public void setSuffixFile(java.lang.String suffixFile) {
		_serverTemplate.setSuffixFile(suffixFile);
	}

	/**
	* Returns the template file of this server template.
	*
	* @return the template file of this server template
	*/
	@Override
	public java.lang.String getTemplateFile() {
		return _serverTemplate.getTemplateFile();
	}

	/**
	* Sets the template file of this server template.
	*
	* @param templateFile the template file of this server template
	*/
	@Override
	public void setTemplateFile(java.lang.String templateFile) {
		_serverTemplate.setTemplateFile(templateFile);
	}

	/**
	* Returns the template i o s of this server template.
	*
	* @return the template i o s of this server template
	*/
	@Override
	public long getTemplateIOS() {
		return _serverTemplate.getTemplateIOS();
	}

	/**
	* Sets the template i o s of this server template.
	*
	* @param templateIOS the template i o s of this server template
	*/
	@Override
	public void setTemplateIOS(long templateIOS) {
		_serverTemplate.setTemplateIOS(templateIOS);
	}

	/**
	* Returns the template android of this server template.
	*
	* @return the template android of this server template
	*/
	@Override
	public long getTemplateAndroid() {
		return _serverTemplate.getTemplateAndroid();
	}

	/**
	* Sets the template android of this server template.
	*
	* @param templateAndroid the template android of this server template
	*/
	@Override
	public void setTemplateAndroid(long templateAndroid) {
		_serverTemplate.setTemplateAndroid(templateAndroid);
	}

	/**
	* Returns the default server of this server template.
	*
	* @return the default server of this server template
	*/
	@Override
	public int getDefaultServer() {
		return _serverTemplate.getDefaultServer();
	}

	/**
	* Sets the default server of this server template.
	*
	* @param defaultServer the default server of this server template
	*/
	@Override
	public void setDefaultServer(int defaultServer) {
		_serverTemplate.setDefaultServer(defaultServer);
	}

	@Override
	public boolean isNew() {
		return _serverTemplate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_serverTemplate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _serverTemplate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_serverTemplate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _serverTemplate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _serverTemplate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_serverTemplate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _serverTemplate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_serverTemplate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_serverTemplate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_serverTemplate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ServerTemplateWrapper((ServerTemplate)_serverTemplate.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.ServerTemplate serverTemplate) {
		return _serverTemplate.compareTo(serverTemplate);
	}

	@Override
	public int hashCode() {
		return _serverTemplate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.ServerTemplate> toCacheModel() {
		return _serverTemplate.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.ServerTemplate toEscapedModel() {
		return new ServerTemplateWrapper(_serverTemplate.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.ServerTemplate toUnescapedModel() {
		return new ServerTemplateWrapper(_serverTemplate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _serverTemplate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _serverTemplate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_serverTemplate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServerTemplateWrapper)) {
			return false;
		}

		ServerTemplateWrapper serverTemplateWrapper = (ServerTemplateWrapper)obj;

		if (Validator.equals(_serverTemplate,
					serverTemplateWrapper._serverTemplate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ServerTemplate getWrappedServerTemplate() {
		return _serverTemplate;
	}

	@Override
	public ServerTemplate getWrappedModel() {
		return _serverTemplate;
	}

	@Override
	public void resetOriginalValues() {
		_serverTemplate.resetOriginalValues();
	}

	private ServerTemplate _serverTemplate;
}