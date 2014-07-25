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
 * This class is a wrapper for {@link Lectureseries_Facility}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_Facility
 * @generated
 */
public class Lectureseries_FacilityWrapper implements Lectureseries_Facility,
	ModelWrapper<Lectureseries_Facility> {
	public Lectureseries_FacilityWrapper(
		Lectureseries_Facility lectureseries_Facility) {
		_lectureseries_Facility = lectureseries_Facility;
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries_Facility.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries_Facility.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lectureseriesFacilityId", getLectureseriesFacilityId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("facilityId", getFacilityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesFacilityId = (Long)attributes.get(
				"lectureseriesFacilityId");

		if (lectureseriesFacilityId != null) {
			setLectureseriesFacilityId(lectureseriesFacilityId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}
	}

	/**
	* Returns the primary key of this lectureseries_ facility.
	*
	* @return the primary key of this lectureseries_ facility
	*/
	@Override
	public long getPrimaryKey() {
		return _lectureseries_Facility.getPrimaryKey();
	}

	/**
	* Sets the primary key of this lectureseries_ facility.
	*
	* @param primaryKey the primary key of this lectureseries_ facility
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lectureseries_Facility.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the lectureseries facility ID of this lectureseries_ facility.
	*
	* @return the lectureseries facility ID of this lectureseries_ facility
	*/
	@Override
	public long getLectureseriesFacilityId() {
		return _lectureseries_Facility.getLectureseriesFacilityId();
	}

	/**
	* Sets the lectureseries facility ID of this lectureseries_ facility.
	*
	* @param lectureseriesFacilityId the lectureseries facility ID of this lectureseries_ facility
	*/
	@Override
	public void setLectureseriesFacilityId(long lectureseriesFacilityId) {
		_lectureseries_Facility.setLectureseriesFacilityId(lectureseriesFacilityId);
	}

	/**
	* Returns the lectureseries ID of this lectureseries_ facility.
	*
	* @return the lectureseries ID of this lectureseries_ facility
	*/
	@Override
	public long getLectureseriesId() {
		return _lectureseries_Facility.getLectureseriesId();
	}

	/**
	* Sets the lectureseries ID of this lectureseries_ facility.
	*
	* @param lectureseriesId the lectureseries ID of this lectureseries_ facility
	*/
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_lectureseries_Facility.setLectureseriesId(lectureseriesId);
	}

	/**
	* Returns the facility ID of this lectureseries_ facility.
	*
	* @return the facility ID of this lectureseries_ facility
	*/
	@Override
	public long getFacilityId() {
		return _lectureseries_Facility.getFacilityId();
	}

	/**
	* Sets the facility ID of this lectureseries_ facility.
	*
	* @param facilityId the facility ID of this lectureseries_ facility
	*/
	@Override
	public void setFacilityId(long facilityId) {
		_lectureseries_Facility.setFacilityId(facilityId);
	}

	@Override
	public boolean isNew() {
		return _lectureseries_Facility.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lectureseries_Facility.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lectureseries_Facility.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lectureseries_Facility.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lectureseries_Facility.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lectureseries_Facility.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lectureseries_Facility.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lectureseries_Facility.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lectureseries_Facility.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lectureseries_Facility.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lectureseries_Facility.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Lectureseries_FacilityWrapper((Lectureseries_Facility)_lectureseries_Facility.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.Lectureseries_Facility lectureseries_Facility) {
		return _lectureseries_Facility.compareTo(lectureseries_Facility);
	}

	@Override
	public int hashCode() {
		return _lectureseries_Facility.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Lectureseries_Facility> toCacheModel() {
		return _lectureseries_Facility.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Facility toEscapedModel() {
		return new Lectureseries_FacilityWrapper(_lectureseries_Facility.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Facility toUnescapedModel() {
		return new Lectureseries_FacilityWrapper(_lectureseries_Facility.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lectureseries_Facility.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lectureseries_Facility.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lectureseries_Facility.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Lectureseries_FacilityWrapper)) {
			return false;
		}

		Lectureseries_FacilityWrapper lectureseries_FacilityWrapper = (Lectureseries_FacilityWrapper)obj;

		if (Validator.equals(_lectureseries_Facility,
					lectureseries_FacilityWrapper._lectureseries_Facility)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Lectureseries_Facility getWrappedLectureseries_Facility() {
		return _lectureseries_Facility;
	}

	@Override
	public Lectureseries_Facility getWrappedModel() {
		return _lectureseries_Facility;
	}

	@Override
	public void resetOriginalValues() {
		_lectureseries_Facility.resetOriginalValues();
	}

	private Lectureseries_Facility _lectureseries_Facility;
}