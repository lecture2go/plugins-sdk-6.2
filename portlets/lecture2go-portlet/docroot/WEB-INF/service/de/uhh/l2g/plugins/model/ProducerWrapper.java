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
 * This class is a wrapper for {@link Producer}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Producer
 * @generated
 */
public class ProducerWrapper implements Producer, ModelWrapper<Producer> {
	public ProducerWrapper(Producer producer) {
		_producer = producer;
	}

	@Override
	public Class<?> getModelClass() {
		return Producer.class;
	}

	@Override
	public String getModelClassName() {
		return Producer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("producerId", getProducerId());
		attributes.put("idNum", getIdNum());
		attributes.put("homeDir", getHomeDir());
		attributes.put("hostId", getHostId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("numberOfProductions", getNumberOfProductions());
		attributes.put("approved", getApproved());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}

		String idNum = (String)attributes.get("idNum");

		if (idNum != null) {
			setIdNum(idNum);
		}

		String homeDir = (String)attributes.get("homeDir");

		if (homeDir != null) {
			setHomeDir(homeDir);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Long numberOfProductions = (Long)attributes.get("numberOfProductions");

		if (numberOfProductions != null) {
			setNumberOfProductions(numberOfProductions);
		}

		Integer approved = (Integer)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}
	}

	/**
	* Returns the primary key of this producer.
	*
	* @return the primary key of this producer
	*/
	@Override
	public long getPrimaryKey() {
		return _producer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this producer.
	*
	* @param primaryKey the primary key of this producer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_producer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the producer ID of this producer.
	*
	* @return the producer ID of this producer
	*/
	@Override
	public long getProducerId() {
		return _producer.getProducerId();
	}

	/**
	* Sets the producer ID of this producer.
	*
	* @param producerId the producer ID of this producer
	*/
	@Override
	public void setProducerId(long producerId) {
		_producer.setProducerId(producerId);
	}

	/**
	* Returns the id num of this producer.
	*
	* @return the id num of this producer
	*/
	@Override
	public java.lang.String getIdNum() {
		return _producer.getIdNum();
	}

	/**
	* Sets the id num of this producer.
	*
	* @param idNum the id num of this producer
	*/
	@Override
	public void setIdNum(java.lang.String idNum) {
		_producer.setIdNum(idNum);
	}

	/**
	* Returns the home dir of this producer.
	*
	* @return the home dir of this producer
	*/
	@Override
	public java.lang.String getHomeDir() {
		return _producer.getHomeDir();
	}

	/**
	* Sets the home dir of this producer.
	*
	* @param homeDir the home dir of this producer
	*/
	@Override
	public void setHomeDir(java.lang.String homeDir) {
		_producer.setHomeDir(homeDir);
	}

	/**
	* Returns the host ID of this producer.
	*
	* @return the host ID of this producer
	*/
	@Override
	public long getHostId() {
		return _producer.getHostId();
	}

	/**
	* Sets the host ID of this producer.
	*
	* @param hostId the host ID of this producer
	*/
	@Override
	public void setHostId(long hostId) {
		_producer.setHostId(hostId);
	}

	/**
	* Returns the facility ID of this producer.
	*
	* @return the facility ID of this producer
	*/
	@Override
	public long getFacilityId() {
		return _producer.getFacilityId();
	}

	/**
	* Sets the facility ID of this producer.
	*
	* @param facilityId the facility ID of this producer
	*/
	@Override
	public void setFacilityId(long facilityId) {
		_producer.setFacilityId(facilityId);
	}

	/**
	* Returns the number of productions of this producer.
	*
	* @return the number of productions of this producer
	*/
	@Override
	public long getNumberOfProductions() {
		return _producer.getNumberOfProductions();
	}

	/**
	* Sets the number of productions of this producer.
	*
	* @param numberOfProductions the number of productions of this producer
	*/
	@Override
	public void setNumberOfProductions(long numberOfProductions) {
		_producer.setNumberOfProductions(numberOfProductions);
	}

	/**
	* Returns the approved of this producer.
	*
	* @return the approved of this producer
	*/
	@Override
	public int getApproved() {
		return _producer.getApproved();
	}

	/**
	* Sets the approved of this producer.
	*
	* @param approved the approved of this producer
	*/
	@Override
	public void setApproved(int approved) {
		_producer.setApproved(approved);
	}

	@Override
	public boolean isNew() {
		return _producer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_producer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _producer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_producer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _producer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _producer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_producer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _producer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_producer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_producer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_producer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProducerWrapper((Producer)_producer.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Producer producer) {
		return _producer.compareTo(producer);
	}

	@Override
	public int hashCode() {
		return _producer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Producer> toCacheModel() {
		return _producer.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Producer toEscapedModel() {
		return new ProducerWrapper(_producer.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Producer toUnescapedModel() {
		return new ProducerWrapper(_producer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _producer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _producer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_producer.persist();
	}

	@Override
	public java.lang.String getLastName() {
		return _producer.getLastName();
	}

	@Override
	public void setLastName(java.lang.String lastName) {
		_producer.setLastName(lastName);
	}

	@Override
	public java.lang.String getFirstName() {
		return _producer.getFirstName();
	}

	@Override
	public void setFirstName(java.lang.String firstName) {
		_producer.setFirstName(firstName);
	}

	@Override
	public java.lang.String getEmailAddress() {
		return _producer.getEmailAddress();
	}

	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_producer.setEmailAddress(emailAddress);
	}

	@Override
	public java.util.Date getLastLoginDate() {
		return _producer.getLastLoginDate();
	}

	@Override
	public void setLastLoginDate(java.util.Date lastLoginDate) {
		_producer.setLastLoginDate(lastLoginDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProducerWrapper)) {
			return false;
		}

		ProducerWrapper producerWrapper = (ProducerWrapper)obj;

		if (Validator.equals(_producer, producerWrapper._producer)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Producer getWrappedProducer() {
		return _producer;
	}

	@Override
	public Producer getWrappedModel() {
		return _producer;
	}

	@Override
	public void resetOriginalValues() {
		_producer.resetOriginalValues();
	}

	private Producer _producer;
}