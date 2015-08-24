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
 * This class is a wrapper for {@link LegacyVideoFacility}.
 * </p>
 *
 * @author unihh
 * @see LegacyVideoFacility
 * @generated
 */
public class LegacyVideoFacilityWrapper implements LegacyVideoFacility,
	ModelWrapper<LegacyVideoFacility> {
	public LegacyVideoFacilityWrapper(LegacyVideoFacility legacyVideoFacility) {
		_legacyVideoFacility = legacyVideoFacility;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyVideoFacility.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyVideoFacility.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoFacilityId", getVideoFacilityId());
		attributes.put("videoId", getVideoId());
		attributes.put("facilityId", getFacilityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoFacilityId = (Long)attributes.get("videoFacilityId");

		if (videoFacilityId != null) {
			setVideoFacilityId(videoFacilityId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}
	}

	/**
	* Returns the primary key of this legacy video facility.
	*
	* @return the primary key of this legacy video facility
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyVideoFacility.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy video facility.
	*
	* @param primaryKey the primary key of this legacy video facility
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyVideoFacility.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the video facility ID of this legacy video facility.
	*
	* @return the video facility ID of this legacy video facility
	*/
	@Override
	public long getVideoFacilityId() {
		return _legacyVideoFacility.getVideoFacilityId();
	}

	/**
	* Sets the video facility ID of this legacy video facility.
	*
	* @param videoFacilityId the video facility ID of this legacy video facility
	*/
	@Override
	public void setVideoFacilityId(long videoFacilityId) {
		_legacyVideoFacility.setVideoFacilityId(videoFacilityId);
	}

	/**
	* Returns the video ID of this legacy video facility.
	*
	* @return the video ID of this legacy video facility
	*/
	@Override
	public long getVideoId() {
		return _legacyVideoFacility.getVideoId();
	}

	/**
	* Sets the video ID of this legacy video facility.
	*
	* @param videoId the video ID of this legacy video facility
	*/
	@Override
	public void setVideoId(long videoId) {
		_legacyVideoFacility.setVideoId(videoId);
	}

	/**
	* Returns the facility ID of this legacy video facility.
	*
	* @return the facility ID of this legacy video facility
	*/
	@Override
	public long getFacilityId() {
		return _legacyVideoFacility.getFacilityId();
	}

	/**
	* Sets the facility ID of this legacy video facility.
	*
	* @param facilityId the facility ID of this legacy video facility
	*/
	@Override
	public void setFacilityId(long facilityId) {
		_legacyVideoFacility.setFacilityId(facilityId);
	}

	@Override
	public boolean isNew() {
		return _legacyVideoFacility.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyVideoFacility.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyVideoFacility.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyVideoFacility.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyVideoFacility.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyVideoFacility.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyVideoFacility.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyVideoFacility.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyVideoFacility.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyVideoFacility.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyVideoFacility.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyVideoFacilityWrapper((LegacyVideoFacility)_legacyVideoFacility.clone());
	}

	@Override
	public int compareTo(LegacyVideoFacility legacyVideoFacility) {
		return _legacyVideoFacility.compareTo(legacyVideoFacility);
	}

	@Override
	public int hashCode() {
		return _legacyVideoFacility.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<LegacyVideoFacility> toCacheModel() {
		return _legacyVideoFacility.toCacheModel();
	}

	@Override
	public LegacyVideoFacility toEscapedModel() {
		return new LegacyVideoFacilityWrapper(_legacyVideoFacility.toEscapedModel());
	}

	@Override
	public LegacyVideoFacility toUnescapedModel() {
		return new LegacyVideoFacilityWrapper(_legacyVideoFacility.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyVideoFacility.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyVideoFacility.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyVideoFacility.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyVideoFacilityWrapper)) {
			return false;
		}

		LegacyVideoFacilityWrapper legacyVideoFacilityWrapper = (LegacyVideoFacilityWrapper)obj;

		if (Validator.equals(_legacyVideoFacility,
					legacyVideoFacilityWrapper._legacyVideoFacility)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyVideoFacility getWrappedLegacyVideoFacility() {
		return _legacyVideoFacility;
	}

	@Override
	public LegacyVideoFacility getWrappedModel() {
		return _legacyVideoFacility;
	}

	@Override
	public void resetOriginalValues() {
		_legacyVideoFacility.resetOriginalValues();
	}

	private LegacyVideoFacility _legacyVideoFacility;
}