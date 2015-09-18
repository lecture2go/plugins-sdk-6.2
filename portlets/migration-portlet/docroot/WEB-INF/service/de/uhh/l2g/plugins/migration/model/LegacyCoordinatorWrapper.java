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
 * This class is a wrapper for {@link LegacyCoordinator}.
 * </p>
 *
 * @author unihh
 * @see LegacyCoordinator
 * @generated
 */
public class LegacyCoordinatorWrapper implements LegacyCoordinator,
	ModelWrapper<LegacyCoordinator> {
	public LegacyCoordinatorWrapper(LegacyCoordinator legacyCoordinator) {
		_legacyCoordinator = legacyCoordinator;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyCoordinator.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyCoordinator.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("officeId", getOfficeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Long officeId = (Long)attributes.get("officeId");

		if (officeId != null) {
			setOfficeId(officeId);
		}
	}

	/**
	* Returns the primary key of this legacy coordinator.
	*
	* @return the primary key of this legacy coordinator
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyCoordinator.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy coordinator.
	*
	* @param primaryKey the primary key of this legacy coordinator
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyCoordinator.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this legacy coordinator.
	*
	* @return the user ID of this legacy coordinator
	*/
	@Override
	public long getUserId() {
		return _legacyCoordinator.getUserId();
	}

	/**
	* Sets the user ID of this legacy coordinator.
	*
	* @param userId the user ID of this legacy coordinator
	*/
	@Override
	public void setUserId(long userId) {
		_legacyCoordinator.setUserId(userId);
	}

	/**
	* Returns the user uuid of this legacy coordinator.
	*
	* @return the user uuid of this legacy coordinator
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyCoordinator.getUserUuid();
	}

	/**
	* Sets the user uuid of this legacy coordinator.
	*
	* @param userUuid the user uuid of this legacy coordinator
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_legacyCoordinator.setUserUuid(userUuid);
	}

	/**
	* Returns the facility ID of this legacy coordinator.
	*
	* @return the facility ID of this legacy coordinator
	*/
	@Override
	public long getFacilityId() {
		return _legacyCoordinator.getFacilityId();
	}

	/**
	* Sets the facility ID of this legacy coordinator.
	*
	* @param facilityId the facility ID of this legacy coordinator
	*/
	@Override
	public void setFacilityId(long facilityId) {
		_legacyCoordinator.setFacilityId(facilityId);
	}

	/**
	* Returns the office ID of this legacy coordinator.
	*
	* @return the office ID of this legacy coordinator
	*/
	@Override
	public long getOfficeId() {
		return _legacyCoordinator.getOfficeId();
	}

	/**
	* Sets the office ID of this legacy coordinator.
	*
	* @param officeId the office ID of this legacy coordinator
	*/
	@Override
	public void setOfficeId(long officeId) {
		_legacyCoordinator.setOfficeId(officeId);
	}

	@Override
	public boolean isNew() {
		return _legacyCoordinator.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyCoordinator.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyCoordinator.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyCoordinator.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyCoordinator.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyCoordinator.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyCoordinator.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyCoordinator.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyCoordinator.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyCoordinator.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyCoordinator.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyCoordinatorWrapper((LegacyCoordinator)_legacyCoordinator.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyCoordinator legacyCoordinator) {
		return _legacyCoordinator.compareTo(legacyCoordinator);
	}

	@Override
	public int hashCode() {
		return _legacyCoordinator.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyCoordinator> toCacheModel() {
		return _legacyCoordinator.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyCoordinator toEscapedModel() {
		return new LegacyCoordinatorWrapper(_legacyCoordinator.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyCoordinator toUnescapedModel() {
		return new LegacyCoordinatorWrapper(_legacyCoordinator.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyCoordinator.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyCoordinator.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyCoordinator.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyCoordinatorWrapper)) {
			return false;
		}

		LegacyCoordinatorWrapper legacyCoordinatorWrapper = (LegacyCoordinatorWrapper)obj;

		if (Validator.equals(_legacyCoordinator,
					legacyCoordinatorWrapper._legacyCoordinator)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyCoordinator getWrappedLegacyCoordinator() {
		return _legacyCoordinator;
	}

	@Override
	public LegacyCoordinator getWrappedModel() {
		return _legacyCoordinator;
	}

	@Override
	public void resetOriginalValues() {
		_legacyCoordinator.resetOriginalValues();
	}

	private LegacyCoordinator _legacyCoordinator;
}