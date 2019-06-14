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
 * This class is a wrapper for {@link License}.
 * </p>
 *
 * @author Iavor Sturm
 * @see License
 * @generated
 */
public class LicenseWrapper implements License, ModelWrapper<License> {
	public LicenseWrapper(License license) {
		_license = license;
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

	/**
	* Returns the primary key of this license.
	*
	* @return the primary key of this license
	*/
	@Override
	public long getPrimaryKey() {
		return _license.getPrimaryKey();
	}

	/**
	* Sets the primary key of this license.
	*
	* @param primaryKey the primary key of this license
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_license.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the license ID of this license.
	*
	* @return the license ID of this license
	*/
	@Override
	public long getLicenseId() {
		return _license.getLicenseId();
	}

	/**
	* Sets the license ID of this license.
	*
	* @param licenseId the license ID of this license
	*/
	@Override
	public void setLicenseId(long licenseId) {
		_license.setLicenseId(licenseId);
	}

	/**
	* Returns the full name of this license.
	*
	* @return the full name of this license
	*/
	@Override
	public java.lang.String getFullName() {
		return _license.getFullName();
	}

	/**
	* Sets the full name of this license.
	*
	* @param fullName the full name of this license
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_license.setFullName(fullName);
	}

	/**
	* Returns the short identifier of this license.
	*
	* @return the short identifier of this license
	*/
	@Override
	public java.lang.String getShortIdentifier() {
		return _license.getShortIdentifier();
	}

	/**
	* Sets the short identifier of this license.
	*
	* @param shortIdentifier the short identifier of this license
	*/
	@Override
	public void setShortIdentifier(java.lang.String shortIdentifier) {
		_license.setShortIdentifier(shortIdentifier);
	}

	/**
	* Returns the url of this license.
	*
	* @return the url of this license
	*/
	@Override
	public java.lang.String getUrl() {
		return _license.getUrl();
	}

	/**
	* Sets the url of this license.
	*
	* @param url the url of this license
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_license.setUrl(url);
	}

	/**
	* Returns the scheme name of this license.
	*
	* @return the scheme name of this license
	*/
	@Override
	public java.lang.String getSchemeName() {
		return _license.getSchemeName();
	}

	/**
	* Sets the scheme name of this license.
	*
	* @param schemeName the scheme name of this license
	*/
	@Override
	public void setSchemeName(java.lang.String schemeName) {
		_license.setSchemeName(schemeName);
	}

	/**
	* Returns the scheme url of this license.
	*
	* @return the scheme url of this license
	*/
	@Override
	public java.lang.String getSchemeUrl() {
		return _license.getSchemeUrl();
	}

	/**
	* Sets the scheme url of this license.
	*
	* @param schemeUrl the scheme url of this license
	*/
	@Override
	public void setSchemeUrl(java.lang.String schemeUrl) {
		_license.setSchemeUrl(schemeUrl);
	}

	/**
	* Returns the selectable of this license.
	*
	* @return the selectable of this license
	*/
	@Override
	public boolean getSelectable() {
		return _license.getSelectable();
	}

	/**
	* Returns <code>true</code> if this license is selectable.
	*
	* @return <code>true</code> if this license is selectable; <code>false</code> otherwise
	*/
	@Override
	public boolean isSelectable() {
		return _license.isSelectable();
	}

	/**
	* Sets whether this license is selectable.
	*
	* @param selectable the selectable of this license
	*/
	@Override
	public void setSelectable(boolean selectable) {
		_license.setSelectable(selectable);
	}

	/**
	* Returns the description of this license.
	*
	* @return the description of this license
	*/
	@Override
	public java.lang.String getDescription() {
		return _license.getDescription();
	}

	/**
	* Sets the description of this license.
	*
	* @param description the description of this license
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_license.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _license.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_license.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _license.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_license.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _license.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _license.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_license.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _license.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_license.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_license.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_license.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LicenseWrapper((License)_license.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.License license) {
		return _license.compareTo(license);
	}

	@Override
	public int hashCode() {
		return _license.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.License> toCacheModel() {
		return _license.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.License toEscapedModel() {
		return new LicenseWrapper(_license.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.License toUnescapedModel() {
		return new LicenseWrapper(_license.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _license.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _license.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_license.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LicenseWrapper)) {
			return false;
		}

		LicenseWrapper licenseWrapper = (LicenseWrapper)obj;

		if (Validator.equals(_license, licenseWrapper._license)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public License getWrappedLicense() {
		return _license;
	}

	@Override
	public License getWrappedModel() {
		return _license;
	}

	@Override
	public void resetOriginalValues() {
		_license.resetOriginalValues();
	}

	private License _license;
}