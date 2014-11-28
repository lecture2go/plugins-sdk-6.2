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
 * This class is a wrapper for {@link Lectureseries_Institution}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_Institution
 * @generated
 */
public class Lectureseries_InstitutionWrapper
	implements Lectureseries_Institution,
		ModelWrapper<Lectureseries_Institution> {
	public Lectureseries_InstitutionWrapper(
		Lectureseries_Institution lectureseries_Institution) {
		_lectureseries_Institution = lectureseries_Institution;
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries_Institution.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries_Institution.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lectureseriesInstitutionId",
			getLectureseriesInstitutionId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("institutionId", getInstitutionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesInstitutionId = (Long)attributes.get(
				"lectureseriesInstitutionId");

		if (lectureseriesInstitutionId != null) {
			setLectureseriesInstitutionId(lectureseriesInstitutionId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}
	}

	/**
	* Returns the primary key of this lectureseries_ institution.
	*
	* @return the primary key of this lectureseries_ institution
	*/
	@Override
	public long getPrimaryKey() {
		return _lectureseries_Institution.getPrimaryKey();
	}

	/**
	* Sets the primary key of this lectureseries_ institution.
	*
	* @param primaryKey the primary key of this lectureseries_ institution
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lectureseries_Institution.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the lectureseries institution ID of this lectureseries_ institution.
	*
	* @return the lectureseries institution ID of this lectureseries_ institution
	*/
	@Override
	public long getLectureseriesInstitutionId() {
		return _lectureseries_Institution.getLectureseriesInstitutionId();
	}

	/**
	* Sets the lectureseries institution ID of this lectureseries_ institution.
	*
	* @param lectureseriesInstitutionId the lectureseries institution ID of this lectureseries_ institution
	*/
	@Override
	public void setLectureseriesInstitutionId(long lectureseriesInstitutionId) {
		_lectureseries_Institution.setLectureseriesInstitutionId(lectureseriesInstitutionId);
	}

	/**
	* Returns the lectureseries ID of this lectureseries_ institution.
	*
	* @return the lectureseries ID of this lectureseries_ institution
	*/
	@Override
	public long getLectureseriesId() {
		return _lectureseries_Institution.getLectureseriesId();
	}

	/**
	* Sets the lectureseries ID of this lectureseries_ institution.
	*
	* @param lectureseriesId the lectureseries ID of this lectureseries_ institution
	*/
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_lectureseries_Institution.setLectureseriesId(lectureseriesId);
	}

	/**
	* Returns the institution ID of this lectureseries_ institution.
	*
	* @return the institution ID of this lectureseries_ institution
	*/
	@Override
	public long getInstitutionId() {
		return _lectureseries_Institution.getInstitutionId();
	}

	/**
	* Sets the institution ID of this lectureseries_ institution.
	*
	* @param institutionId the institution ID of this lectureseries_ institution
	*/
	@Override
	public void setInstitutionId(long institutionId) {
		_lectureseries_Institution.setInstitutionId(institutionId);
	}

	@Override
	public boolean isNew() {
		return _lectureseries_Institution.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lectureseries_Institution.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lectureseries_Institution.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lectureseries_Institution.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lectureseries_Institution.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lectureseries_Institution.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lectureseries_Institution.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lectureseries_Institution.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lectureseries_Institution.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lectureseries_Institution.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lectureseries_Institution.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Lectureseries_InstitutionWrapper((Lectureseries_Institution)_lectureseries_Institution.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.Lectureseries_Institution lectureseries_Institution) {
		return _lectureseries_Institution.compareTo(lectureseries_Institution);
	}

	@Override
	public int hashCode() {
		return _lectureseries_Institution.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Lectureseries_Institution> toCacheModel() {
		return _lectureseries_Institution.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Institution toEscapedModel() {
		return new Lectureseries_InstitutionWrapper(_lectureseries_Institution.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Institution toUnescapedModel() {
		return new Lectureseries_InstitutionWrapper(_lectureseries_Institution.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lectureseries_Institution.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lectureseries_Institution.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lectureseries_Institution.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Lectureseries_InstitutionWrapper)) {
			return false;
		}

		Lectureseries_InstitutionWrapper lectureseries_InstitutionWrapper = (Lectureseries_InstitutionWrapper)obj;

		if (Validator.equals(_lectureseries_Institution,
					lectureseries_InstitutionWrapper._lectureseries_Institution)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Lectureseries_Institution getWrappedLectureseries_Institution() {
		return _lectureseries_Institution;
	}

	@Override
	public Lectureseries_Institution getWrappedModel() {
		return _lectureseries_Institution;
	}

	@Override
	public void resetOriginalValues() {
		_lectureseries_Institution.resetOriginalValues();
	}

	private Lectureseries_Institution _lectureseries_Institution;
}