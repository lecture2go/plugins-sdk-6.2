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
 * This class is a wrapper for {@link Creator}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Creator
 * @generated
 */
public class CreatorWrapper implements Creator, ModelWrapper<Creator> {
	public CreatorWrapper(Creator creator) {
		_creator = creator;
	}

	@Override
	public Class<?> getModelClass() {
		return Creator.class;
	}

	@Override
	public String getModelClassName() {
		return Creator.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("creatorId", getCreatorId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("middleName", getMiddleName());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("gender", getGender());
		attributes.put("fullName", getFullName());
		attributes.put("affiliation", getAffiliation());
		attributes.put("orcidId", getOrcidId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String affiliation = (String)attributes.get("affiliation");

		if (affiliation != null) {
			setAffiliation(affiliation);
		}

		String orcidId = (String)attributes.get("orcidId");

		if (orcidId != null) {
			setOrcidId(orcidId);
		}
	}

	/**
	* Returns the primary key of this creator.
	*
	* @return the primary key of this creator
	*/
	@Override
	public long getPrimaryKey() {
		return _creator.getPrimaryKey();
	}

	/**
	* Sets the primary key of this creator.
	*
	* @param primaryKey the primary key of this creator
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_creator.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the creator ID of this creator.
	*
	* @return the creator ID of this creator
	*/
	@Override
	public long getCreatorId() {
		return _creator.getCreatorId();
	}

	/**
	* Sets the creator ID of this creator.
	*
	* @param creatorId the creator ID of this creator
	*/
	@Override
	public void setCreatorId(long creatorId) {
		_creator.setCreatorId(creatorId);
	}

	/**
	* Returns the first name of this creator.
	*
	* @return the first name of this creator
	*/
	@Override
	public java.lang.String getFirstName() {
		return _creator.getFirstName();
	}

	/**
	* Sets the first name of this creator.
	*
	* @param firstName the first name of this creator
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_creator.setFirstName(firstName);
	}

	/**
	* Returns the last name of this creator.
	*
	* @return the last name of this creator
	*/
	@Override
	public java.lang.String getLastName() {
		return _creator.getLastName();
	}

	/**
	* Sets the last name of this creator.
	*
	* @param lastName the last name of this creator
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_creator.setLastName(lastName);
	}

	/**
	* Returns the middle name of this creator.
	*
	* @return the middle name of this creator
	*/
	@Override
	public java.lang.String getMiddleName() {
		return _creator.getMiddleName();
	}

	/**
	* Sets the middle name of this creator.
	*
	* @param middleName the middle name of this creator
	*/
	@Override
	public void setMiddleName(java.lang.String middleName) {
		_creator.setMiddleName(middleName);
	}

	/**
	* Returns the job title of this creator.
	*
	* @return the job title of this creator
	*/
	@Override
	public java.lang.String getJobTitle() {
		return _creator.getJobTitle();
	}

	/**
	* Sets the job title of this creator.
	*
	* @param jobTitle the job title of this creator
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		_creator.setJobTitle(jobTitle);
	}

	/**
	* Returns the gender of this creator.
	*
	* @return the gender of this creator
	*/
	@Override
	public java.lang.String getGender() {
		return _creator.getGender();
	}

	/**
	* Sets the gender of this creator.
	*
	* @param gender the gender of this creator
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_creator.setGender(gender);
	}

	/**
	* Returns the full name of this creator.
	*
	* @return the full name of this creator
	*/
	@Override
	public java.lang.String getFullName() {
		return _creator.getFullName();
	}

	/**
	* Sets the full name of this creator.
	*
	* @param fullName the full name of this creator
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_creator.setFullName(fullName);
	}

	/**
	* Returns the affiliation of this creator.
	*
	* @return the affiliation of this creator
	*/
	@Override
	public java.lang.String getAffiliation() {
		return _creator.getAffiliation();
	}

	/**
	* Sets the affiliation of this creator.
	*
	* @param affiliation the affiliation of this creator
	*/
	@Override
	public void setAffiliation(java.lang.String affiliation) {
		_creator.setAffiliation(affiliation);
	}

	/**
	* Returns the orcid ID of this creator.
	*
	* @return the orcid ID of this creator
	*/
	@Override
	public java.lang.String getOrcidId() {
		return _creator.getOrcidId();
	}

	/**
	* Sets the orcid ID of this creator.
	*
	* @param orcidId the orcid ID of this creator
	*/
	@Override
	public void setOrcidId(java.lang.String orcidId) {
		_creator.setOrcidId(orcidId);
	}

	@Override
	public boolean isNew() {
		return _creator.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_creator.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _creator.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_creator.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _creator.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _creator.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_creator.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _creator.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_creator.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_creator.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_creator.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CreatorWrapper((Creator)_creator.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Creator creator) {
		return _creator.compareTo(creator);
	}

	@Override
	public int hashCode() {
		return _creator.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Creator> toCacheModel() {
		return _creator.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Creator toEscapedModel() {
		return new CreatorWrapper(_creator.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Creator toUnescapedModel() {
		return new CreatorWrapper(_creator.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _creator.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _creator.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_creator.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreatorWrapper)) {
			return false;
		}

		CreatorWrapper creatorWrapper = (CreatorWrapper)obj;

		if (Validator.equals(_creator, creatorWrapper._creator)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Creator getWrappedCreator() {
		return _creator;
	}

	@Override
	public Creator getWrappedModel() {
		return _creator;
	}

	@Override
	public void resetOriginalValues() {
		_creator.resetOriginalValues();
	}

	private Creator _creator;
}