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
 * This class is a wrapper for {@link Producer_Lectureseries}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Producer_Lectureseries
 * @generated
 */
public class Producer_LectureseriesWrapper implements Producer_Lectureseries,
	ModelWrapper<Producer_Lectureseries> {
	public Producer_LectureseriesWrapper(
		Producer_Lectureseries producer_Lectureseries) {
		_producer_Lectureseries = producer_Lectureseries;
	}

	@Override
	public Class<?> getModelClass() {
		return Producer_Lectureseries.class;
	}

	@Override
	public String getModelClassName() {
		return Producer_Lectureseries.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("producerLectureseriesId", getProducerLectureseriesId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("producerId", getProducerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long producerLectureseriesId = (Long)attributes.get(
				"producerLectureseriesId");

		if (producerLectureseriesId != null) {
			setProducerLectureseriesId(producerLectureseriesId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}
	}

	/**
	* Returns the primary key of this producer_ lectureseries.
	*
	* @return the primary key of this producer_ lectureseries
	*/
	@Override
	public long getPrimaryKey() {
		return _producer_Lectureseries.getPrimaryKey();
	}

	/**
	* Sets the primary key of this producer_ lectureseries.
	*
	* @param primaryKey the primary key of this producer_ lectureseries
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_producer_Lectureseries.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the producer lectureseries ID of this producer_ lectureseries.
	*
	* @return the producer lectureseries ID of this producer_ lectureseries
	*/
	@Override
	public long getProducerLectureseriesId() {
		return _producer_Lectureseries.getProducerLectureseriesId();
	}

	/**
	* Sets the producer lectureseries ID of this producer_ lectureseries.
	*
	* @param producerLectureseriesId the producer lectureseries ID of this producer_ lectureseries
	*/
	@Override
	public void setProducerLectureseriesId(long producerLectureseriesId) {
		_producer_Lectureseries.setProducerLectureseriesId(producerLectureseriesId);
	}

	/**
	* Returns the lectureseries ID of this producer_ lectureseries.
	*
	* @return the lectureseries ID of this producer_ lectureseries
	*/
	@Override
	public long getLectureseriesId() {
		return _producer_Lectureseries.getLectureseriesId();
	}

	/**
	* Sets the lectureseries ID of this producer_ lectureseries.
	*
	* @param lectureseriesId the lectureseries ID of this producer_ lectureseries
	*/
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_producer_Lectureseries.setLectureseriesId(lectureseriesId);
	}

	/**
	* Returns the producer ID of this producer_ lectureseries.
	*
	* @return the producer ID of this producer_ lectureseries
	*/
	@Override
	public long getProducerId() {
		return _producer_Lectureseries.getProducerId();
	}

	/**
	* Sets the producer ID of this producer_ lectureseries.
	*
	* @param producerId the producer ID of this producer_ lectureseries
	*/
	@Override
	public void setProducerId(long producerId) {
		_producer_Lectureseries.setProducerId(producerId);
	}

	@Override
	public boolean isNew() {
		return _producer_Lectureseries.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_producer_Lectureseries.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _producer_Lectureseries.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_producer_Lectureseries.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _producer_Lectureseries.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _producer_Lectureseries.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_producer_Lectureseries.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _producer_Lectureseries.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_producer_Lectureseries.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_producer_Lectureseries.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_producer_Lectureseries.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Producer_LectureseriesWrapper((Producer_Lectureseries)_producer_Lectureseries.clone());
	}

	@Override
	public int compareTo(Producer_Lectureseries producer_Lectureseries) {
		return _producer_Lectureseries.compareTo(producer_Lectureseries);
	}

	@Override
	public int hashCode() {
		return _producer_Lectureseries.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Producer_Lectureseries> toCacheModel() {
		return _producer_Lectureseries.toCacheModel();
	}

	@Override
	public Producer_Lectureseries toEscapedModel() {
		return new Producer_LectureseriesWrapper(_producer_Lectureseries.toEscapedModel());
	}

	@Override
	public Producer_Lectureseries toUnescapedModel() {
		return new Producer_LectureseriesWrapper(_producer_Lectureseries.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _producer_Lectureseries.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _producer_Lectureseries.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_producer_Lectureseries.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Producer_LectureseriesWrapper)) {
			return false;
		}

		Producer_LectureseriesWrapper producer_LectureseriesWrapper = (Producer_LectureseriesWrapper)obj;

		if (Validator.equals(_producer_Lectureseries,
					producer_LectureseriesWrapper._producer_Lectureseries)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Producer_Lectureseries getWrappedProducer_Lectureseries() {
		return _producer_Lectureseries;
	}

	@Override
	public Producer_Lectureseries getWrappedModel() {
		return _producer_Lectureseries;
	}

	@Override
	public void resetOriginalValues() {
		_producer_Lectureseries.resetOriginalValues();
	}

	private Producer_Lectureseries _producer_Lectureseries;
}