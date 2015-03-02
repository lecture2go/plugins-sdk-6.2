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
 * This class is a wrapper for {@link Office}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Office
 * @generated
 */
public class OfficeWrapper implements Office, ModelWrapper<Office> {
	public OfficeWrapper(Office office) {
		_office = office;
	}

	@Override
	public Class<?> getModelClass() {
		return Office.class;
	}

	@Override
	public String getModelClassName() {
		return Office.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeId", getOfficeId());
		attributes.put("name", getName());
		attributes.put("www", getWww());
		attributes.put("email", getEmail());
		attributes.put("institutionId", getInstitutionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long officeId = (Long)attributes.get("officeId");

		if (officeId != null) {
			setOfficeId(officeId);
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

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}
	}

	/**
	* Returns the primary key of this office.
	*
	* @return the primary key of this office
	*/
	@Override
	public long getPrimaryKey() {
		return _office.getPrimaryKey();
	}

	/**
	* Sets the primary key of this office.
	*
	* @param primaryKey the primary key of this office
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_office.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the office ID of this office.
	*
	* @return the office ID of this office
	*/
	@Override
	public long getOfficeId() {
		return _office.getOfficeId();
	}

	/**
	* Sets the office ID of this office.
	*
	* @param officeId the office ID of this office
	*/
	@Override
	public void setOfficeId(long officeId) {
		_office.setOfficeId(officeId);
	}

	/**
	* Returns the name of this office.
	*
	* @return the name of this office
	*/
	@Override
	public java.lang.String getName() {
		return _office.getName();
	}

	/**
	* Sets the name of this office.
	*
	* @param name the name of this office
	*/
	@Override
	public void setName(java.lang.String name) {
		_office.setName(name);
	}

	/**
	* Returns the www of this office.
	*
	* @return the www of this office
	*/
	@Override
	public java.lang.String getWww() {
		return _office.getWww();
	}

	/**
	* Sets the www of this office.
	*
	* @param www the www of this office
	*/
	@Override
	public void setWww(java.lang.String www) {
		_office.setWww(www);
	}

	/**
	* Returns the email of this office.
	*
	* @return the email of this office
	*/
	@Override
	public java.lang.String getEmail() {
		return _office.getEmail();
	}

	/**
	* Sets the email of this office.
	*
	* @param email the email of this office
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_office.setEmail(email);
	}

	/**
	* Returns the institution ID of this office.
	*
	* @return the institution ID of this office
	*/
	@Override
	public long getInstitutionId() {
		return _office.getInstitutionId();
	}

	/**
	* Sets the institution ID of this office.
	*
	* @param institutionId the institution ID of this office
	*/
	@Override
	public void setInstitutionId(long institutionId) {
		_office.setInstitutionId(institutionId);
	}

	@Override
	public boolean isNew() {
		return _office.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_office.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _office.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_office.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _office.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _office.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_office.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _office.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_office.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_office.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_office.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OfficeWrapper((Office)_office.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Office office) {
		return _office.compareTo(office);
	}

	@Override
	public int hashCode() {
		return _office.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Office> toCacheModel() {
		return _office.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Office toEscapedModel() {
		return new OfficeWrapper(_office.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Office toUnescapedModel() {
		return new OfficeWrapper(_office.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _office.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _office.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_office.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeWrapper)) {
			return false;
		}

		OfficeWrapper officeWrapper = (OfficeWrapper)obj;

		if (Validator.equals(_office, officeWrapper._office)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Office getWrappedOffice() {
		return _office;
	}

	@Override
	public Office getWrappedModel() {
		return _office;
	}

	@Override
	public void resetOriginalValues() {
		_office.resetOriginalValues();
	}

	private Office _office;
}