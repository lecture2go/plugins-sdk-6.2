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
 * This class is a wrapper for {@link LegacyFacilityHost}.
 * </p>
 *
 * @author unihh
 * @see LegacyFacilityHost
 * @generated
 */
public class LegacyFacilityHostWrapper implements LegacyFacilityHost,
	ModelWrapper<LegacyFacilityHost> {
	public LegacyFacilityHostWrapper(LegacyFacilityHost legacyFacilityHost) {
		_legacyFacilityHost = legacyFacilityHost;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyFacilityHost.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyFacilityHost.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facilityHostId", getFacilityHostId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("hostId", getHostId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long facilityHostId = (Long)attributes.get("facilityHostId");

		if (facilityHostId != null) {
			setFacilityHostId(facilityHostId);
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
	* Returns the primary key of this legacy facility host.
	*
	* @return the primary key of this legacy facility host
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyFacilityHost.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy facility host.
	*
	* @param primaryKey the primary key of this legacy facility host
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyFacilityHost.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the facility host ID of this legacy facility host.
	*
	* @return the facility host ID of this legacy facility host
	*/
	@Override
	public long getFacilityHostId() {
		return _legacyFacilityHost.getFacilityHostId();
	}

	/**
	* Sets the facility host ID of this legacy facility host.
	*
	* @param facilityHostId the facility host ID of this legacy facility host
	*/
	@Override
	public void setFacilityHostId(long facilityHostId) {
		_legacyFacilityHost.setFacilityHostId(facilityHostId);
	}

	/**
	* Returns the facility ID of this legacy facility host.
	*
	* @return the facility ID of this legacy facility host
	*/
	@Override
	public long getFacilityId() {
		return _legacyFacilityHost.getFacilityId();
	}

	/**
	* Sets the facility ID of this legacy facility host.
	*
	* @param facilityId the facility ID of this legacy facility host
	*/
	@Override
	public void setFacilityId(long facilityId) {
		_legacyFacilityHost.setFacilityId(facilityId);
	}

	/**
	* Returns the host ID of this legacy facility host.
	*
	* @return the host ID of this legacy facility host
	*/
	@Override
	public long getHostId() {
		return _legacyFacilityHost.getHostId();
	}

	/**
	* Sets the host ID of this legacy facility host.
	*
	* @param hostId the host ID of this legacy facility host
	*/
	@Override
	public void setHostId(long hostId) {
		_legacyFacilityHost.setHostId(hostId);
	}

	@Override
	public boolean isNew() {
		return _legacyFacilityHost.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyFacilityHost.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyFacilityHost.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyFacilityHost.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyFacilityHost.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyFacilityHost.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyFacilityHost.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyFacilityHost.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyFacilityHost.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyFacilityHost.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyFacilityHost.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyFacilityHostWrapper((LegacyFacilityHost)_legacyFacilityHost.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyFacilityHost legacyFacilityHost) {
		return _legacyFacilityHost.compareTo(legacyFacilityHost);
	}

	@Override
	public int hashCode() {
		return _legacyFacilityHost.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyFacilityHost> toCacheModel() {
		return _legacyFacilityHost.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyFacilityHost toEscapedModel() {
		return new LegacyFacilityHostWrapper(_legacyFacilityHost.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyFacilityHost toUnescapedModel() {
		return new LegacyFacilityHostWrapper(_legacyFacilityHost.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyFacilityHost.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyFacilityHost.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyFacilityHost.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyFacilityHostWrapper)) {
			return false;
		}

		LegacyFacilityHostWrapper legacyFacilityHostWrapper = (LegacyFacilityHostWrapper)obj;

		if (Validator.equals(_legacyFacilityHost,
					legacyFacilityHostWrapper._legacyFacilityHost)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyFacilityHost getWrappedLegacyFacilityHost() {
		return _legacyFacilityHost;
	}

	@Override
	public LegacyFacilityHost getWrappedModel() {
		return _legacyFacilityHost;
	}

	@Override
	public void resetOriginalValues() {
		_legacyFacilityHost.resetOriginalValues();
	}

	private LegacyFacilityHost _legacyFacilityHost;
}