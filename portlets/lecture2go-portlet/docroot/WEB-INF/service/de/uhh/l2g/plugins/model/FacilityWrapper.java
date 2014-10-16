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
 * This class is a wrapper for {@link Facility}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Facility
 * @generated
 */
public class FacilityWrapper implements Facility, ModelWrapper<Facility> {
	public FacilityWrapper(Facility facility) {
		_facility = facility;
	}

	@Override
	public Class<?> getModelClass() {
		return Facility.class;
	}

	@Override
	public String getModelClassName() {
		return Facility.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facilityId", getFacilityId());
		attributes.put("parentId", getParentId());
		attributes.put("name", getName());
		attributes.put("typ", getTyp());
		attributes.put("www", getWww());
		attributes.put("level", getLevel());
		attributes.put("sort", getSort());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String typ = (String)attributes.get("typ");

		if (typ != null) {
			setTyp(typ);
		}

		String www = (String)attributes.get("www");

		if (www != null) {
			setWww(www);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Integer sort = (Integer)attributes.get("sort");

		if (sort != null) {
			setSort(sort);
		}
	}

	/**
	* Returns the primary key of this facility.
	*
	* @return the primary key of this facility
	*/
	@Override
	public long getPrimaryKey() {
		return _facility.getPrimaryKey();
	}

	/**
	* Sets the primary key of this facility.
	*
	* @param primaryKey the primary key of this facility
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_facility.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the facility ID of this facility.
	*
	* @return the facility ID of this facility
	*/
	@Override
	public long getFacilityId() {
		return _facility.getFacilityId();
	}

	/**
	* Sets the facility ID of this facility.
	*
	* @param facilityId the facility ID of this facility
	*/
	@Override
	public void setFacilityId(long facilityId) {
		_facility.setFacilityId(facilityId);
	}

	/**
	* Returns the parent ID of this facility.
	*
	* @return the parent ID of this facility
	*/
	@Override
	public long getParentId() {
		return _facility.getParentId();
	}

	/**
	* Sets the parent ID of this facility.
	*
	* @param parentId the parent ID of this facility
	*/
	@Override
	public void setParentId(long parentId) {
		_facility.setParentId(parentId);
	}

	/**
	* Returns the name of this facility.
	*
	* @return the name of this facility
	*/
	@Override
	public java.lang.String getName() {
		return _facility.getName();
	}

	/**
	* Sets the name of this facility.
	*
	* @param name the name of this facility
	*/
	@Override
	public void setName(java.lang.String name) {
		_facility.setName(name);
	}

	/**
	* Returns the typ of this facility.
	*
	* @return the typ of this facility
	*/
	@Override
	public java.lang.String getTyp() {
		return _facility.getTyp();
	}

	/**
	* Sets the typ of this facility.
	*
	* @param typ the typ of this facility
	*/
	@Override
	public void setTyp(java.lang.String typ) {
		_facility.setTyp(typ);
	}

	/**
	* Returns the www of this facility.
	*
	* @return the www of this facility
	*/
	@Override
	public java.lang.String getWww() {
		return _facility.getWww();
	}

	/**
	* Sets the www of this facility.
	*
	* @param www the www of this facility
	*/
	@Override
	public void setWww(java.lang.String www) {
		_facility.setWww(www);
	}

	/**
	* Returns the level of this facility.
	*
	* @return the level of this facility
	*/
	@Override
	public int getLevel() {
		return _facility.getLevel();
	}

	/**
	* Sets the level of this facility.
	*
	* @param level the level of this facility
	*/
	@Override
	public void setLevel(int level) {
		_facility.setLevel(level);
	}

	/**
	* Returns the sort of this facility.
	*
	* @return the sort of this facility
	*/
	@Override
	public int getSort() {
		return _facility.getSort();
	}

	/**
	* Sets the sort of this facility.
	*
	* @param sort the sort of this facility
	*/
	@Override
	public void setSort(int sort) {
		_facility.setSort(sort);
	}

	@Override
	public boolean isNew() {
		return _facility.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_facility.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _facility.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_facility.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _facility.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _facility.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_facility.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _facility.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_facility.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_facility.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_facility.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FacilityWrapper((Facility)_facility.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Facility facility) {
		return _facility.compareTo(facility);
	}

	@Override
	public int hashCode() {
		return _facility.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Facility> toCacheModel() {
		return _facility.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Facility toEscapedModel() {
		return new FacilityWrapper(_facility.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Facility toUnescapedModel() {
		return new FacilityWrapper(_facility.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _facility.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _facility.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_facility.persist();
	}

	@Override
	public java.lang.String getPath() {
		return _facility.getPath();
	}

	@Override
	public void setPath(java.lang.String path) {
		_facility.setPath(path);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FacilityWrapper)) {
			return false;
		}

		FacilityWrapper facilityWrapper = (FacilityWrapper)obj;

		if (Validator.equals(_facility, facilityWrapper._facility)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Facility getWrappedFacility() {
		return _facility;
	}

	@Override
	public Facility getWrappedModel() {
		return _facility;
	}

	@Override
	public void resetOriginalValues() {
		_facility.resetOriginalValues();
	}

	private Facility _facility;
}