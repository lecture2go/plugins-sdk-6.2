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
 * This class is a wrapper for {@link Facility_Host}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Facility_Host
 * @generated
 */
public class Facility_HostWrapper implements Facility_Host,
	ModelWrapper<Facility_Host> {
	public Facility_HostWrapper(Facility_Host facility_Host) {
		_facility_Host = facility_Host;
	}

	@Override
	public Class<?> getModelClass() {
		return Facility_Host.class;
	}

	@Override
	public String getModelClassName() {
		return Facility_Host.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fasilityHostId", getFasilityHostId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("hostId", getHostId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fasilityHostId = (Long)attributes.get("fasilityHostId");

		if (fasilityHostId != null) {
			setFasilityHostId(fasilityHostId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}
	}

	/**
	* Returns the primary key of this facility_ host.
	*
	* @return the primary key of this facility_ host
	*/
	@Override
	public long getPrimaryKey() {
		return _facility_Host.getPrimaryKey();
	}

	/**
	* Sets the primary key of this facility_ host.
	*
	* @param primaryKey the primary key of this facility_ host
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_facility_Host.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fasility host ID of this facility_ host.
	*
	* @return the fasility host ID of this facility_ host
	*/
	@Override
	public long getFasilityHostId() {
		return _facility_Host.getFasilityHostId();
	}

	/**
	* Sets the fasility host ID of this facility_ host.
	*
	* @param fasilityHostId the fasility host ID of this facility_ host
	*/
	@Override
	public void setFasilityHostId(long fasilityHostId) {
		_facility_Host.setFasilityHostId(fasilityHostId);
	}

	/**
	* Returns the facility ID of this facility_ host.
	*
	* @return the facility ID of this facility_ host
	*/
	@Override
	public long getFacilityId() {
		return _facility_Host.getFacilityId();
	}

	/**
	* Sets the facility ID of this facility_ host.
	*
	* @param facilityId the facility ID of this facility_ host
	*/
	@Override
	public void setFacilityId(long facilityId) {
		_facility_Host.setFacilityId(facilityId);
	}

	/**
	* Returns the host ID of this facility_ host.
	*
	* @return the host ID of this facility_ host
	*/
	@Override
	public long getHostId() {
		return _facility_Host.getHostId();
	}

	/**
	* Sets the host ID of this facility_ host.
	*
	* @param hostId the host ID of this facility_ host
	*/
	@Override
	public void setHostId(long hostId) {
		_facility_Host.setHostId(hostId);
	}

	@Override
	public boolean isNew() {
		return _facility_Host.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_facility_Host.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _facility_Host.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_facility_Host.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _facility_Host.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _facility_Host.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_facility_Host.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _facility_Host.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_facility_Host.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_facility_Host.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_facility_Host.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Facility_HostWrapper((Facility_Host)_facility_Host.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Facility_Host facility_Host) {
		return _facility_Host.compareTo(facility_Host);
	}

	@Override
	public int hashCode() {
		return _facility_Host.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Facility_Host> toCacheModel() {
		return _facility_Host.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Facility_Host toEscapedModel() {
		return new Facility_HostWrapper(_facility_Host.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Facility_Host toUnescapedModel() {
		return new Facility_HostWrapper(_facility_Host.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _facility_Host.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _facility_Host.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_facility_Host.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Facility_HostWrapper)) {
			return false;
		}

		Facility_HostWrapper facility_HostWrapper = (Facility_HostWrapper)obj;

		if (Validator.equals(_facility_Host, facility_HostWrapper._facility_Host)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Facility_Host getWrappedFacility_Host() {
		return _facility_Host;
	}

	@Override
	public Facility_Host getWrappedModel() {
		return _facility_Host;
	}

	@Override
	public void resetOriginalValues() {
		_facility_Host.resetOriginalValues();
	}

	private Facility_Host _facility_Host;
}