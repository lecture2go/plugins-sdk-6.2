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
 * This class is a wrapper for {@link LegacyProducer}.
 * </p>
 *
 * @author unihh
 * @see LegacyProducer
 * @generated
 */
public class LegacyProducerWrapper implements LegacyProducer,
	ModelWrapper<LegacyProducer> {
	public LegacyProducerWrapper(LegacyProducer legacyProducer) {
		_legacyProducer = legacyProducer;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyProducer.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyProducer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("idNum", getIdNum());
		attributes.put("homeDir", getHomeDir());
		attributes.put("userId", getUserId());
		attributes.put("hostId", getHostId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("numberOfProductions", getNumberOfProductions());
		attributes.put("approved", getApproved());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String idNum = (String)attributes.get("idNum");

		if (idNum != null) {
			setIdNum(idNum);
		}

		String homeDir = (String)attributes.get("homeDir");

		if (homeDir != null) {
			setHomeDir(homeDir);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
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
	* Returns the primary key of this legacy producer.
	*
	* @return the primary key of this legacy producer
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyProducer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy producer.
	*
	* @param primaryKey the primary key of this legacy producer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyProducer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy producer.
	*
	* @return the ID of this legacy producer
	*/
	@Override
	public long getId() {
		return _legacyProducer.getId();
	}

	/**
	* Sets the ID of this legacy producer.
	*
	* @param id the ID of this legacy producer
	*/
	@Override
	public void setId(long id) {
		_legacyProducer.setId(id);
	}

	/**
	* Returns the id num of this legacy producer.
	*
	* @return the id num of this legacy producer
	*/
	@Override
	public java.lang.String getIdNum() {
		return _legacyProducer.getIdNum();
	}

	/**
	* Sets the id num of this legacy producer.
	*
	* @param idNum the id num of this legacy producer
	*/
	@Override
	public void setIdNum(java.lang.String idNum) {
		_legacyProducer.setIdNum(idNum);
	}

	/**
	* Returns the home dir of this legacy producer.
	*
	* @return the home dir of this legacy producer
	*/
	@Override
	public java.lang.String getHomeDir() {
		return _legacyProducer.getHomeDir();
	}

	/**
	* Sets the home dir of this legacy producer.
	*
	* @param homeDir the home dir of this legacy producer
	*/
	@Override
	public void setHomeDir(java.lang.String homeDir) {
		_legacyProducer.setHomeDir(homeDir);
	}

	/**
	* Returns the user ID of this legacy producer.
	*
	* @return the user ID of this legacy producer
	*/
	@Override
	public long getUserId() {
		return _legacyProducer.getUserId();
	}

	/**
	* Sets the user ID of this legacy producer.
	*
	* @param userId the user ID of this legacy producer
	*/
	@Override
	public void setUserId(long userId) {
		_legacyProducer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this legacy producer.
	*
	* @return the user uuid of this legacy producer
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyProducer.getUserUuid();
	}

	/**
	* Sets the user uuid of this legacy producer.
	*
	* @param userUuid the user uuid of this legacy producer
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_legacyProducer.setUserUuid(userUuid);
	}

	/**
	* Returns the host ID of this legacy producer.
	*
	* @return the host ID of this legacy producer
	*/
	@Override
	public long getHostId() {
		return _legacyProducer.getHostId();
	}

	/**
	* Sets the host ID of this legacy producer.
	*
	* @param hostId the host ID of this legacy producer
	*/
	@Override
	public void setHostId(long hostId) {
		_legacyProducer.setHostId(hostId);
	}

	/**
	* Returns the facility ID of this legacy producer.
	*
	* @return the facility ID of this legacy producer
	*/
	@Override
	public long getFacilityId() {
		return _legacyProducer.getFacilityId();
	}

	/**
	* Sets the facility ID of this legacy producer.
	*
	* @param facilityId the facility ID of this legacy producer
	*/
	@Override
	public void setFacilityId(long facilityId) {
		_legacyProducer.setFacilityId(facilityId);
	}

	/**
	* Returns the number of productions of this legacy producer.
	*
	* @return the number of productions of this legacy producer
	*/
	@Override
	public long getNumberOfProductions() {
		return _legacyProducer.getNumberOfProductions();
	}

	/**
	* Sets the number of productions of this legacy producer.
	*
	* @param numberOfProductions the number of productions of this legacy producer
	*/
	@Override
	public void setNumberOfProductions(long numberOfProductions) {
		_legacyProducer.setNumberOfProductions(numberOfProductions);
	}

	/**
	* Returns the approved of this legacy producer.
	*
	* @return the approved of this legacy producer
	*/
	@Override
	public int getApproved() {
		return _legacyProducer.getApproved();
	}

	/**
	* Sets the approved of this legacy producer.
	*
	* @param approved the approved of this legacy producer
	*/
	@Override
	public void setApproved(int approved) {
		_legacyProducer.setApproved(approved);
	}

	@Override
	public boolean isNew() {
		return _legacyProducer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyProducer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyProducer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyProducer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyProducer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyProducer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyProducer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyProducer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyProducer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyProducer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyProducer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyProducerWrapper((LegacyProducer)_legacyProducer.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyProducer legacyProducer) {
		return _legacyProducer.compareTo(legacyProducer);
	}

	@Override
	public int hashCode() {
		return _legacyProducer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyProducer> toCacheModel() {
		return _legacyProducer.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducer toEscapedModel() {
		return new LegacyProducerWrapper(_legacyProducer.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducer toUnescapedModel() {
		return new LegacyProducerWrapper(_legacyProducer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyProducer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyProducer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyProducer.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyProducerWrapper)) {
			return false;
		}

		LegacyProducerWrapper legacyProducerWrapper = (LegacyProducerWrapper)obj;

		if (Validator.equals(_legacyProducer,
					legacyProducerWrapper._legacyProducer)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyProducer getWrappedLegacyProducer() {
		return _legacyProducer;
	}

	@Override
	public LegacyProducer getWrappedModel() {
		return _legacyProducer;
	}

	@Override
	public void resetOriginalValues() {
		_legacyProducer.resetOriginalValues();
	}

	private LegacyProducer _legacyProducer;
}