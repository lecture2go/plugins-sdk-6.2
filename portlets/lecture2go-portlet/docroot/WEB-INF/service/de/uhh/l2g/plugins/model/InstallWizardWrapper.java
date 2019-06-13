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
 * This class is a wrapper for {@link InstallWizard}.
 * </p>
 *
 * @author Iavor Sturm
 * @see InstallWizard
 * @generated
 */
public class InstallWizardWrapper implements InstallWizard,
	ModelWrapper<InstallWizard> {
	public InstallWizardWrapper(InstallWizard installWizard) {
		_installWizard = installWizard;
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

	/**
	* Returns the primary key of this install wizard.
	*
	* @return the primary key of this install wizard
	*/
	@Override
	public long getPrimaryKey() {
		return _installWizard.getPrimaryKey();
	}

	/**
	* Sets the primary key of this install wizard.
	*
	* @param primaryKey the primary key of this install wizard
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_installWizard.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the install wizard ID of this install wizard.
	*
	* @return the install wizard ID of this install wizard
	*/
	@Override
	public long getInstallWizardId() {
		return _installWizard.getInstallWizardId();
	}

	/**
	* Sets the install wizard ID of this install wizard.
	*
	* @param installWizardId the install wizard ID of this install wizard
	*/
	@Override
	public void setInstallWizardId(long installWizardId) {
		_installWizard.setInstallWizardId(installWizardId);
	}

	/**
	* Returns the wizart active of this install wizard.
	*
	* @return the wizart active of this install wizard
	*/
	@Override
	public int getWizartActive() {
		return _installWizard.getWizartActive();
	}

	/**
	* Sets the wizart active of this install wizard.
	*
	* @param wizartActive the wizart active of this install wizard
	*/
	@Override
	public void setWizartActive(int wizartActive) {
		_installWizard.setWizartActive(wizartActive);
	}

	/**
	* Returns the group ID of this install wizard.
	*
	* @return the group ID of this install wizard
	*/
	@Override
	public long getGroupId() {
		return _installWizard.getGroupId();
	}

	/**
	* Sets the group ID of this install wizard.
	*
	* @param groupId the group ID of this install wizard
	*/
	@Override
	public void setGroupId(long groupId) {
		_installWizard.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this install wizard.
	*
	* @return the company ID of this install wizard
	*/
	@Override
	public long getCompanyId() {
		return _installWizard.getCompanyId();
	}

	/**
	* Sets the company ID of this install wizard.
	*
	* @param companyId the company ID of this install wizard
	*/
	@Override
	public void setCompanyId(long companyId) {
		_installWizard.setCompanyId(companyId);
	}

	@Override
	public boolean isNew() {
		return _installWizard.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_installWizard.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _installWizard.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_installWizard.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _installWizard.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _installWizard.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_installWizard.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _installWizard.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_installWizard.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_installWizard.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_installWizard.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InstallWizardWrapper((InstallWizard)_installWizard.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.InstallWizard installWizard) {
		return _installWizard.compareTo(installWizard);
	}

	@Override
	public int hashCode() {
		return _installWizard.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.InstallWizard> toCacheModel() {
		return _installWizard.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.InstallWizard toEscapedModel() {
		return new InstallWizardWrapper(_installWizard.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.InstallWizard toUnescapedModel() {
		return new InstallWizardWrapper(_installWizard.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _installWizard.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _installWizard.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_installWizard.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InstallWizardWrapper)) {
			return false;
		}

		InstallWizardWrapper installWizardWrapper = (InstallWizardWrapper)obj;

		if (Validator.equals(_installWizard, installWizardWrapper._installWizard)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public InstallWizard getWrappedInstallWizard() {
		return _installWizard;
	}

	@Override
	public InstallWizard getWrappedModel() {
		return _installWizard;
	}

	@Override
	public void resetOriginalValues() {
		_installWizard.resetOriginalValues();
	}

	private InstallWizard _installWizard;
}