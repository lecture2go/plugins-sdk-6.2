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
 * This class is a wrapper for {@link LegacyLectureSeriesFacility}.
 * </p>
 *
 * @author unihh
 * @see LegacyLectureSeriesFacility
 * @generated
 */
public class LegacyLectureSeriesFacilityWrapper
	implements LegacyLectureSeriesFacility,
		ModelWrapper<LegacyLectureSeriesFacility> {
	public LegacyLectureSeriesFacilityWrapper(
		LegacyLectureSeriesFacility legacyLectureSeriesFacility) {
		_legacyLectureSeriesFacility = legacyLectureSeriesFacility;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyLectureSeriesFacility.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyLectureSeriesFacility.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lectureseriesFacilityId", getLectureseriesFacilityId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("isLinkFrom", getIsLinkFrom());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesFacilityId = (Long)attributes.get(
				"lectureseriesFacilityId");

		if (lectureseriesFacilityId != null) {
			setLectureseriesFacilityId(lectureseriesFacilityId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long isLinkFrom = (Long)attributes.get("isLinkFrom");

		if (isLinkFrom != null) {
			setIsLinkFrom(isLinkFrom);
		}
	}

	/**
	* Returns the primary key of this legacy lecture series facility.
	*
	* @return the primary key of this legacy lecture series facility
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyLectureSeriesFacility.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy lecture series facility.
	*
	* @param primaryKey the primary key of this legacy lecture series facility
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyLectureSeriesFacility.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the lectureseries facility ID of this legacy lecture series facility.
	*
	* @return the lectureseries facility ID of this legacy lecture series facility
	*/
	@Override
	public long getLectureseriesFacilityId() {
		return _legacyLectureSeriesFacility.getLectureseriesFacilityId();
	}

	/**
	* Sets the lectureseries facility ID of this legacy lecture series facility.
	*
	* @param lectureseriesFacilityId the lectureseries facility ID of this legacy lecture series facility
	*/
	@Override
	public void setLectureseriesFacilityId(long lectureseriesFacilityId) {
		_legacyLectureSeriesFacility.setLectureseriesFacilityId(lectureseriesFacilityId);
	}

	/**
	* Returns the facility ID of this legacy lecture series facility.
	*
	* @return the facility ID of this legacy lecture series facility
	*/
	@Override
	public long getFacilityId() {
		return _legacyLectureSeriesFacility.getFacilityId();
	}

	/**
	* Sets the facility ID of this legacy lecture series facility.
	*
	* @param facilityId the facility ID of this legacy lecture series facility
	*/
	@Override
	public void setFacilityId(long facilityId) {
		_legacyLectureSeriesFacility.setFacilityId(facilityId);
	}

	/**
	* Returns the lectureseries ID of this legacy lecture series facility.
	*
	* @return the lectureseries ID of this legacy lecture series facility
	*/
	@Override
	public long getLectureseriesId() {
		return _legacyLectureSeriesFacility.getLectureseriesId();
	}

	/**
	* Sets the lectureseries ID of this legacy lecture series facility.
	*
	* @param lectureseriesId the lectureseries ID of this legacy lecture series facility
	*/
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_legacyLectureSeriesFacility.setLectureseriesId(lectureseriesId);
	}

	/**
	* Returns the is link from of this legacy lecture series facility.
	*
	* @return the is link from of this legacy lecture series facility
	*/
	@Override
	public long getIsLinkFrom() {
		return _legacyLectureSeriesFacility.getIsLinkFrom();
	}

	/**
	* Sets the is link from of this legacy lecture series facility.
	*
	* @param isLinkFrom the is link from of this legacy lecture series facility
	*/
	@Override
	public void setIsLinkFrom(long isLinkFrom) {
		_legacyLectureSeriesFacility.setIsLinkFrom(isLinkFrom);
	}

	@Override
	public boolean isNew() {
		return _legacyLectureSeriesFacility.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyLectureSeriesFacility.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyLectureSeriesFacility.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyLectureSeriesFacility.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyLectureSeriesFacility.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyLectureSeriesFacility.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyLectureSeriesFacility.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyLectureSeriesFacility.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyLectureSeriesFacility.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyLectureSeriesFacility.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyLectureSeriesFacility.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyLectureSeriesFacilityWrapper((LegacyLectureSeriesFacility)_legacyLectureSeriesFacility.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility legacyLectureSeriesFacility) {
		return _legacyLectureSeriesFacility.compareTo(legacyLectureSeriesFacility);
	}

	@Override
	public int hashCode() {
		return _legacyLectureSeriesFacility.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility> toCacheModel() {
		return _legacyLectureSeriesFacility.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility toEscapedModel() {
		return new LegacyLectureSeriesFacilityWrapper(_legacyLectureSeriesFacility.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility toUnescapedModel() {
		return new LegacyLectureSeriesFacilityWrapper(_legacyLectureSeriesFacility.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyLectureSeriesFacility.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyLectureSeriesFacility.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyLectureSeriesFacility.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyLectureSeriesFacilityWrapper)) {
			return false;
		}

		LegacyLectureSeriesFacilityWrapper legacyLectureSeriesFacilityWrapper = (LegacyLectureSeriesFacilityWrapper)obj;

		if (Validator.equals(_legacyLectureSeriesFacility,
					legacyLectureSeriesFacilityWrapper._legacyLectureSeriesFacility)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyLectureSeriesFacility getWrappedLegacyLectureSeriesFacility() {
		return _legacyLectureSeriesFacility;
	}

	@Override
	public LegacyLectureSeriesFacility getWrappedModel() {
		return _legacyLectureSeriesFacility;
	}

	@Override
	public void resetOriginalValues() {
		_legacyLectureSeriesFacility.resetOriginalValues();
	}

	private LegacyLectureSeriesFacility _legacyLectureSeriesFacility;
}