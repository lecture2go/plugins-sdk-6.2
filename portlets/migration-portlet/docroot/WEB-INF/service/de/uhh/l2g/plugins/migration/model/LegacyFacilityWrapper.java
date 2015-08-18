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
 * This class is a wrapper for {@link LegacyFacility}.
 * </p>
 *
 * @author unihh
 * @see LegacyFacility
 * @generated
 */
public class LegacyFacilityWrapper implements LegacyFacility,
	ModelWrapper<LegacyFacility> {
	public LegacyFacilityWrapper(LegacyFacility legacyFacility) {
		_legacyFacility = legacyFacility;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyFacility.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyFacility.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
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
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
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
	* Returns the primary key of this legacy facility.
	*
	* @return the primary key of this legacy facility
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyFacility.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy facility.
	*
	* @param primaryKey the primary key of this legacy facility
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyFacility.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy facility.
	*
	* @return the ID of this legacy facility
	*/
	@Override
	public long getId() {
		return _legacyFacility.getId();
	}

	/**
	* Sets the ID of this legacy facility.
	*
	* @param id the ID of this legacy facility
	*/
	@Override
	public void setId(long id) {
		_legacyFacility.setId(id);
	}

	/**
	* Returns the parent ID of this legacy facility.
	*
	* @return the parent ID of this legacy facility
	*/
	@Override
	public long getParentId() {
		return _legacyFacility.getParentId();
	}

	/**
	* Sets the parent ID of this legacy facility.
	*
	* @param parentId the parent ID of this legacy facility
	*/
	@Override
	public void setParentId(long parentId) {
		_legacyFacility.setParentId(parentId);
	}

	/**
	* Returns the name of this legacy facility.
	*
	* @return the name of this legacy facility
	*/
	@Override
	public java.lang.String getName() {
		return _legacyFacility.getName();
	}

	/**
	* Sets the name of this legacy facility.
	*
	* @param name the name of this legacy facility
	*/
	@Override
	public void setName(java.lang.String name) {
		_legacyFacility.setName(name);
	}

	/**
	* Returns the typ of this legacy facility.
	*
	* @return the typ of this legacy facility
	*/
	@Override
	public java.lang.String getTyp() {
		return _legacyFacility.getTyp();
	}

	/**
	* Sets the typ of this legacy facility.
	*
	* @param typ the typ of this legacy facility
	*/
	@Override
	public void setTyp(java.lang.String typ) {
		_legacyFacility.setTyp(typ);
	}

	/**
	* Returns the www of this legacy facility.
	*
	* @return the www of this legacy facility
	*/
	@Override
	public java.lang.String getWww() {
		return _legacyFacility.getWww();
	}

	/**
	* Sets the www of this legacy facility.
	*
	* @param www the www of this legacy facility
	*/
	@Override
	public void setWww(java.lang.String www) {
		_legacyFacility.setWww(www);
	}

	/**
	* Returns the level of this legacy facility.
	*
	* @return the level of this legacy facility
	*/
	@Override
	public int getLevel() {
		return _legacyFacility.getLevel();
	}

	/**
	* Sets the level of this legacy facility.
	*
	* @param level the level of this legacy facility
	*/
	@Override
	public void setLevel(int level) {
		_legacyFacility.setLevel(level);
	}

	/**
	* Returns the sort of this legacy facility.
	*
	* @return the sort of this legacy facility
	*/
	@Override
	public int getSort() {
		return _legacyFacility.getSort();
	}

	/**
	* Sets the sort of this legacy facility.
	*
	* @param sort the sort of this legacy facility
	*/
	@Override
	public void setSort(int sort) {
		_legacyFacility.setSort(sort);
	}

	@Override
	public boolean isNew() {
		return _legacyFacility.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyFacility.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyFacility.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyFacility.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyFacility.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyFacility.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyFacility.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyFacility.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyFacility.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyFacility.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyFacility.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyFacilityWrapper((LegacyFacility)_legacyFacility.clone());
	}

	@Override
	public int compareTo(LegacyFacility legacyFacility) {
		return _legacyFacility.compareTo(legacyFacility);
	}

	@Override
	public int hashCode() {
		return _legacyFacility.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<LegacyFacility> toCacheModel() {
		return _legacyFacility.toCacheModel();
	}

	@Override
	public LegacyFacility toEscapedModel() {
		return new LegacyFacilityWrapper(_legacyFacility.toEscapedModel());
	}

	@Override
	public LegacyFacility toUnescapedModel() {
		return new LegacyFacilityWrapper(_legacyFacility.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyFacility.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyFacility.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyFacility.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyFacilityWrapper)) {
			return false;
		}

		LegacyFacilityWrapper legacyFacilityWrapper = (LegacyFacilityWrapper)obj;

		if (Validator.equals(_legacyFacility,
					legacyFacilityWrapper._legacyFacility)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyFacility getWrappedLegacyFacility() {
		return _legacyFacility;
	}

	@Override
	public LegacyFacility getWrappedModel() {
		return _legacyFacility;
	}

	@Override
	public void resetOriginalValues() {
		_legacyFacility.resetOriginalValues();
	}

	private LegacyFacility _legacyFacility;
}