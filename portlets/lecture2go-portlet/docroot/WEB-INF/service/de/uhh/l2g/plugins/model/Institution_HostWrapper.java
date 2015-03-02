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
 * This class is a wrapper for {@link Institution_Host}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Institution_Host
 * @generated
 */
public class Institution_HostWrapper implements Institution_Host,
	ModelWrapper<Institution_Host> {
	public Institution_HostWrapper(Institution_Host institution_Host) {
		_institution_Host = institution_Host;
	}

	@Override
	public Class<?> getModelClass() {
		return Institution_Host.class;
	}

	@Override
	public String getModelClassName() {
		return Institution_Host.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("institutionHostId", getInstitutionHostId());
		attributes.put("institutionId", getInstitutionId());
		attributes.put("hostId", getHostId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long institutionHostId = (Long)attributes.get("institutionHostId");

		if (institutionHostId != null) {
			setInstitutionHostId(institutionHostId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}
	}

	/**
	* Returns the primary key of this institution_ host.
	*
	* @return the primary key of this institution_ host
	*/
	@Override
	public long getPrimaryKey() {
		return _institution_Host.getPrimaryKey();
	}

	/**
	* Sets the primary key of this institution_ host.
	*
	* @param primaryKey the primary key of this institution_ host
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_institution_Host.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the institution host ID of this institution_ host.
	*
	* @return the institution host ID of this institution_ host
	*/
	@Override
	public long getInstitutionHostId() {
		return _institution_Host.getInstitutionHostId();
	}

	/**
	* Sets the institution host ID of this institution_ host.
	*
	* @param institutionHostId the institution host ID of this institution_ host
	*/
	@Override
	public void setInstitutionHostId(long institutionHostId) {
		_institution_Host.setInstitutionHostId(institutionHostId);
	}

	/**
	* Returns the institution ID of this institution_ host.
	*
	* @return the institution ID of this institution_ host
	*/
	@Override
	public long getInstitutionId() {
		return _institution_Host.getInstitutionId();
	}

	/**
	* Sets the institution ID of this institution_ host.
	*
	* @param institutionId the institution ID of this institution_ host
	*/
	@Override
	public void setInstitutionId(long institutionId) {
		_institution_Host.setInstitutionId(institutionId);
	}

	/**
	* Returns the host ID of this institution_ host.
	*
	* @return the host ID of this institution_ host
	*/
	@Override
	public long getHostId() {
		return _institution_Host.getHostId();
	}

	/**
	* Sets the host ID of this institution_ host.
	*
	* @param hostId the host ID of this institution_ host
	*/
	@Override
	public void setHostId(long hostId) {
		_institution_Host.setHostId(hostId);
	}

	@Override
	public boolean isNew() {
		return _institution_Host.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_institution_Host.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _institution_Host.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_institution_Host.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _institution_Host.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _institution_Host.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_institution_Host.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _institution_Host.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_institution_Host.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_institution_Host.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_institution_Host.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Institution_HostWrapper((Institution_Host)_institution_Host.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.Institution_Host institution_Host) {
		return _institution_Host.compareTo(institution_Host);
	}

	@Override
	public int hashCode() {
		return _institution_Host.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Institution_Host> toCacheModel() {
		return _institution_Host.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution_Host toEscapedModel() {
		return new Institution_HostWrapper(_institution_Host.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution_Host toUnescapedModel() {
		return new Institution_HostWrapper(_institution_Host.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _institution_Host.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _institution_Host.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_institution_Host.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Institution_HostWrapper)) {
			return false;
		}

		Institution_HostWrapper institution_HostWrapper = (Institution_HostWrapper)obj;

		if (Validator.equals(_institution_Host,
					institution_HostWrapper._institution_Host)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Institution_Host getWrappedInstitution_Host() {
		return _institution_Host;
	}

	@Override
	public Institution_Host getWrappedModel() {
		return _institution_Host;
	}

	@Override
	public void resetOriginalValues() {
		_institution_Host.resetOriginalValues();
	}

	private Institution_Host _institution_Host;
}