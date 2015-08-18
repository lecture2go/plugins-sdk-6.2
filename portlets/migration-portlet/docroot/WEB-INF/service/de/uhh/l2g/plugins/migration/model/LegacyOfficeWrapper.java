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
 * This class is a wrapper for {@link LegacyOffice}.
 * </p>
 *
 * @author unihh
 * @see LegacyOffice
 * @generated
 */
public class LegacyOfficeWrapper implements LegacyOffice,
	ModelWrapper<LegacyOffice> {
	public LegacyOfficeWrapper(LegacyOffice legacyOffice) {
		_legacyOffice = legacyOffice;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyOffice.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyOffice.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("www", getWww());
		attributes.put("email", getEmail());
		attributes.put("facilityId", getFacilityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String www = (String)attributes.get("www");

		if (www != null) {
			setWww(www);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}
	}

	/**
	* Returns the primary key of this legacy office.
	*
	* @return the primary key of this legacy office
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyOffice.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy office.
	*
	* @param primaryKey the primary key of this legacy office
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyOffice.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy office.
	*
	* @return the ID of this legacy office
	*/
	@Override
	public long getId() {
		return _legacyOffice.getId();
	}

	/**
	* Sets the ID of this legacy office.
	*
	* @param id the ID of this legacy office
	*/
	@Override
	public void setId(long id) {
		_legacyOffice.setId(id);
	}

	/**
	* Returns the name of this legacy office.
	*
	* @return the name of this legacy office
	*/
	@Override
	public java.lang.String getName() {
		return _legacyOffice.getName();
	}

	/**
	* Sets the name of this legacy office.
	*
	* @param name the name of this legacy office
	*/
	@Override
	public void setName(java.lang.String name) {
		_legacyOffice.setName(name);
	}

	/**
	* Returns the www of this legacy office.
	*
	* @return the www of this legacy office
	*/
	@Override
	public java.lang.String getWww() {
		return _legacyOffice.getWww();
	}

	/**
	* Sets the www of this legacy office.
	*
	* @param www the www of this legacy office
	*/
	@Override
	public void setWww(java.lang.String www) {
		_legacyOffice.setWww(www);
	}

	/**
	* Returns the email of this legacy office.
	*
	* @return the email of this legacy office
	*/
	@Override
	public java.lang.String getEmail() {
		return _legacyOffice.getEmail();
	}

	/**
	* Sets the email of this legacy office.
	*
	* @param email the email of this legacy office
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_legacyOffice.setEmail(email);
	}

	/**
	* Returns the facility ID of this legacy office.
	*
	* @return the facility ID of this legacy office
	*/
	@Override
	public long getFacilityId() {
		return _legacyOffice.getFacilityId();
	}

	/**
	* Sets the facility ID of this legacy office.
	*
	* @param facilityId the facility ID of this legacy office
	*/
	@Override
	public void setFacilityId(long facilityId) {
		_legacyOffice.setFacilityId(facilityId);
	}

	@Override
	public boolean isNew() {
		return _legacyOffice.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyOffice.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyOffice.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyOffice.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyOffice.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyOffice.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyOffice.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyOffice.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyOffice.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyOffice.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyOffice.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyOfficeWrapper((LegacyOffice)_legacyOffice.clone());
	}

	@Override
	public int compareTo(LegacyOffice legacyOffice) {
		return _legacyOffice.compareTo(legacyOffice);
	}

	@Override
	public int hashCode() {
		return _legacyOffice.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<LegacyOffice> toCacheModel() {
		return _legacyOffice.toCacheModel();
	}

	@Override
	public LegacyOffice toEscapedModel() {
		return new LegacyOfficeWrapper(_legacyOffice.toEscapedModel());
	}

	@Override
	public LegacyOffice toUnescapedModel() {
		return new LegacyOfficeWrapper(_legacyOffice.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyOffice.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyOffice.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyOffice.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyOfficeWrapper)) {
			return false;
		}

		LegacyOfficeWrapper legacyOfficeWrapper = (LegacyOfficeWrapper)obj;

		if (Validator.equals(_legacyOffice, legacyOfficeWrapper._legacyOffice)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyOffice getWrappedLegacyOffice() {
		return _legacyOffice;
	}

	@Override
	public LegacyOffice getWrappedModel() {
		return _legacyOffice;
	}

	@Override
	public void resetOriginalValues() {
		_legacyOffice.resetOriginalValues();
	}

	private LegacyOffice _legacyOffice;
}