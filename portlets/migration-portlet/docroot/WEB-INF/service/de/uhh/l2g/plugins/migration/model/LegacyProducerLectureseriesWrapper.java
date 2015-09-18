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
 * This class is a wrapper for {@link LegacyProducerLectureseries}.
 * </p>
 *
 * @author unihh
 * @see LegacyProducerLectureseries
 * @generated
 */
public class LegacyProducerLectureseriesWrapper
	implements LegacyProducerLectureseries,
		ModelWrapper<LegacyProducerLectureseries> {
	public LegacyProducerLectureseriesWrapper(
		LegacyProducerLectureseries legacyProducerLectureseries) {
		_legacyProducerLectureseries = legacyProducerLectureseries;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyProducerLectureseries.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyProducerLectureseries.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("producerId", getProducerId());
		attributes.put("lectureseriesId", getLectureseriesId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}
	}

	/**
	* Returns the primary key of this legacy producer lectureseries.
	*
	* @return the primary key of this legacy producer lectureseries
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyProducerLectureseries.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy producer lectureseries.
	*
	* @param primaryKey the primary key of this legacy producer lectureseries
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyProducerLectureseries.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy producer lectureseries.
	*
	* @return the ID of this legacy producer lectureseries
	*/
	@Override
	public long getId() {
		return _legacyProducerLectureseries.getId();
	}

	/**
	* Sets the ID of this legacy producer lectureseries.
	*
	* @param id the ID of this legacy producer lectureseries
	*/
	@Override
	public void setId(long id) {
		_legacyProducerLectureseries.setId(id);
	}

	/**
	* Returns the producer ID of this legacy producer lectureseries.
	*
	* @return the producer ID of this legacy producer lectureseries
	*/
	@Override
	public long getProducerId() {
		return _legacyProducerLectureseries.getProducerId();
	}

	/**
	* Sets the producer ID of this legacy producer lectureseries.
	*
	* @param producerId the producer ID of this legacy producer lectureseries
	*/
	@Override
	public void setProducerId(long producerId) {
		_legacyProducerLectureseries.setProducerId(producerId);
	}

	/**
	* Returns the lectureseries ID of this legacy producer lectureseries.
	*
	* @return the lectureseries ID of this legacy producer lectureseries
	*/
	@Override
	public long getLectureseriesId() {
		return _legacyProducerLectureseries.getLectureseriesId();
	}

	/**
	* Sets the lectureseries ID of this legacy producer lectureseries.
	*
	* @param lectureseriesId the lectureseries ID of this legacy producer lectureseries
	*/
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_legacyProducerLectureseries.setLectureseriesId(lectureseriesId);
	}

	@Override
	public boolean isNew() {
		return _legacyProducerLectureseries.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyProducerLectureseries.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyProducerLectureseries.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyProducerLectureseries.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyProducerLectureseries.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyProducerLectureseries.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyProducerLectureseries.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyProducerLectureseries.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyProducerLectureseries.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyProducerLectureseries.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyProducerLectureseries.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyProducerLectureseriesWrapper((LegacyProducerLectureseries)_legacyProducerLectureseries.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries legacyProducerLectureseries) {
		return _legacyProducerLectureseries.compareTo(legacyProducerLectureseries);
	}

	@Override
	public int hashCode() {
		return _legacyProducerLectureseries.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries> toCacheModel() {
		return _legacyProducerLectureseries.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries toEscapedModel() {
		return new LegacyProducerLectureseriesWrapper(_legacyProducerLectureseries.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries toUnescapedModel() {
		return new LegacyProducerLectureseriesWrapper(_legacyProducerLectureseries.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyProducerLectureseries.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyProducerLectureseries.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyProducerLectureseries.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyProducerLectureseriesWrapper)) {
			return false;
		}

		LegacyProducerLectureseriesWrapper legacyProducerLectureseriesWrapper = (LegacyProducerLectureseriesWrapper)obj;

		if (Validator.equals(_legacyProducerLectureseries,
					legacyProducerLectureseriesWrapper._legacyProducerLectureseries)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyProducerLectureseries getWrappedLegacyProducerLectureseries() {
		return _legacyProducerLectureseries;
	}

	@Override
	public LegacyProducerLectureseries getWrappedModel() {
		return _legacyProducerLectureseries;
	}

	@Override
	public void resetOriginalValues() {
		_legacyProducerLectureseries.resetOriginalValues();
	}

	private LegacyProducerLectureseries _legacyProducerLectureseries;
}