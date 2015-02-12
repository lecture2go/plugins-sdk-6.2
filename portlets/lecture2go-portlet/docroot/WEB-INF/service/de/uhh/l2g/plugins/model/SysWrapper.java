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
 * This class is a wrapper for {@link Sys}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Sys
 * @generated
 */
public class SysWrapper implements Sys, ModelWrapper<Sys> {
	public SysWrapper(Sys sys) {
		_sys = sys;
	}

	@Override
	public Class<?> getModelClass() {
		return Sys.class;
	}

	@Override
	public String getModelClassName() {
		return Sys.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sysId", getSysId());
		attributes.put("version", getVersion());
		attributes.put("setupWizard", getSetupWizard());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer sysId = (Integer)attributes.get("sysId");

		if (sysId != null) {
			setSysId(sysId);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Integer setupWizard = (Integer)attributes.get("setupWizard");

		if (setupWizard != null) {
			setSetupWizard(setupWizard);
		}
	}

	/**
	* Returns the primary key of this sys.
	*
	* @return the primary key of this sys
	*/
	@Override
	public int getPrimaryKey() {
		return _sys.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sys.
	*
	* @param primaryKey the primary key of this sys
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_sys.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sys ID of this sys.
	*
	* @return the sys ID of this sys
	*/
	@Override
	public int getSysId() {
		return _sys.getSysId();
	}

	/**
	* Sets the sys ID of this sys.
	*
	* @param sysId the sys ID of this sys
	*/
	@Override
	public void setSysId(int sysId) {
		_sys.setSysId(sysId);
	}

	/**
	* Returns the version of this sys.
	*
	* @return the version of this sys
	*/
	@Override
	public java.lang.String getVersion() {
		return _sys.getVersion();
	}

	/**
	* Sets the version of this sys.
	*
	* @param version the version of this sys
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_sys.setVersion(version);
	}

	/**
	* Returns the setup wizard of this sys.
	*
	* @return the setup wizard of this sys
	*/
	@Override
	public int getSetupWizard() {
		return _sys.getSetupWizard();
	}

	/**
	* Sets the setup wizard of this sys.
	*
	* @param setupWizard the setup wizard of this sys
	*/
	@Override
	public void setSetupWizard(int setupWizard) {
		_sys.setSetupWizard(setupWizard);
	}

	@Override
	public boolean isNew() {
		return _sys.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sys.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sys.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sys.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sys.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sys.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sys.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sys.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sys.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sys.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sys.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SysWrapper((Sys)_sys.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Sys sys) {
		return _sys.compareTo(sys);
	}

	@Override
	public int hashCode() {
		return _sys.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Sys> toCacheModel() {
		return _sys.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Sys toEscapedModel() {
		return new SysWrapper(_sys.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Sys toUnescapedModel() {
		return new SysWrapper(_sys.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sys.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sys.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sys.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SysWrapper)) {
			return false;
		}

		SysWrapper sysWrapper = (SysWrapper)obj;

		if (Validator.equals(_sys, sysWrapper._sys)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Sys getWrappedSys() {
		return _sys;
	}

	@Override
	public Sys getWrappedModel() {
		return _sys;
	}

	@Override
	public void resetOriginalValues() {
		_sys.resetOriginalValues();
	}

	private Sys _sys;
}