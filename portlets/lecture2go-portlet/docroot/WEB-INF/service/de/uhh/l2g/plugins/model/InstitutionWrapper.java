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
 * This class is a wrapper for {@link Institution}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Institution
 * @generated
 */
public class InstitutionWrapper implements Institution,
	ModelWrapper<Institution> {
	public InstitutionWrapper(Institution institution) {
		_institution = institution;
	}

	@Override
	public Class<?> getModelClass() {
		return Institution.class;
	}

	@Override
	public String getModelClassName() {
		return Institution.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("institutionId", getInstitutionId());
		attributes.put("parentId", getParentId());
		attributes.put("name", getName());
		attributes.put("typ", getTyp());
		attributes.put("www", getWww());
		attributes.put("level", getLevel());
		attributes.put("sort", getSort());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this institution.
	*
	* @return the primary key of this institution
	*/
	@Override
	public long getPrimaryKey() {
		return _institution.getPrimaryKey();
	}

	/**
	* Sets the primary key of this institution.
	*
	* @param primaryKey the primary key of this institution
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_institution.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the institution ID of this institution.
	*
	* @return the institution ID of this institution
	*/
	@Override
	public long getInstitutionId() {
		return _institution.getInstitutionId();
	}

	/**
	* Sets the institution ID of this institution.
	*
	* @param institutionId the institution ID of this institution
	*/
	@Override
	public void setInstitutionId(long institutionId) {
		_institution.setInstitutionId(institutionId);
	}

	/**
	* Returns the parent ID of this institution.
	*
	* @return the parent ID of this institution
	*/
	@Override
	public long getParentId() {
		return _institution.getParentId();
	}

	/**
	* Sets the parent ID of this institution.
	*
	* @param parentId the parent ID of this institution
	*/
	@Override
	public void setParentId(long parentId) {
		_institution.setParentId(parentId);
	}

	/**
	* Returns the name of this institution.
	*
	* @return the name of this institution
	*/
	@Override
	public java.lang.String getName() {
		return _institution.getName();
	}

	/**
	* Sets the name of this institution.
	*
	* @param name the name of this institution
	*/
	@Override
	public void setName(java.lang.String name) {
		_institution.setName(name);
	}

	/**
	* Returns the typ of this institution.
	*
	* @return the typ of this institution
	*/
	@Override
	public java.lang.String getTyp() {
		return _institution.getTyp();
	}

	/**
	* Sets the typ of this institution.
	*
	* @param typ the typ of this institution
	*/
	@Override
	public void setTyp(java.lang.String typ) {
		_institution.setTyp(typ);
	}

	/**
	* Returns the www of this institution.
	*
	* @return the www of this institution
	*/
	@Override
	public java.lang.String getWww() {
		return _institution.getWww();
	}

	/**
	* Sets the www of this institution.
	*
	* @param www the www of this institution
	*/
	@Override
	public void setWww(java.lang.String www) {
		_institution.setWww(www);
	}

	/**
	* Returns the level of this institution.
	*
	* @return the level of this institution
	*/
	@Override
	public int getLevel() {
		return _institution.getLevel();
	}

	/**
	* Sets the level of this institution.
	*
	* @param level the level of this institution
	*/
	@Override
	public void setLevel(int level) {
		_institution.setLevel(level);
	}

	/**
	* Returns the sort of this institution.
	*
	* @return the sort of this institution
	*/
	@Override
	public int getSort() {
		return _institution.getSort();
	}

	/**
	* Sets the sort of this institution.
	*
	* @param sort the sort of this institution
	*/
	@Override
	public void setSort(int sort) {
		_institution.setSort(sort);
	}

	/**
	* Returns the group ID of this institution.
	*
	* @return the group ID of this institution
	*/
	@Override
	public long getGroupId() {
		return _institution.getGroupId();
	}

	/**
	* Sets the group ID of this institution.
	*
	* @param groupId the group ID of this institution
	*/
	@Override
	public void setGroupId(long groupId) {
		_institution.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _institution.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_institution.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _institution.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_institution.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _institution.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _institution.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_institution.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _institution.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_institution.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_institution.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_institution.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InstitutionWrapper((Institution)_institution.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Institution institution) {
		return _institution.compareTo(institution);
	}

	@Override
	public int hashCode() {
		return _institution.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Institution> toCacheModel() {
		return _institution.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution toEscapedModel() {
		return new InstitutionWrapper(_institution.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution toUnescapedModel() {
		return new InstitutionWrapper(_institution.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _institution.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _institution.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_institution.persist();
	}

	@Override
	public java.lang.String getPath() {
		return _institution.getPath();
	}

	@Override
	public void setPath(java.lang.String path) {
		_institution.setPath(path);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InstitutionWrapper)) {
			return false;
		}

		InstitutionWrapper institutionWrapper = (InstitutionWrapper)obj;

		if (Validator.equals(_institution, institutionWrapper._institution)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Institution getWrappedInstitution() {
		return _institution;
	}

	@Override
	public Institution getWrappedModel() {
		return _institution;
	}

	@Override
	public void resetOriginalValues() {
		_institution.resetOriginalValues();
	}

	private Institution _institution;
}