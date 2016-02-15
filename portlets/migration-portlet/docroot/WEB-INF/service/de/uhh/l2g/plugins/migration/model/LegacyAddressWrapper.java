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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegacyAddress}.
 * </p>
 *
 * @author unihh
 * @see LegacyAddress
 * @generated
 */
public class LegacyAddressWrapper implements LegacyAddress,
	ModelWrapper<LegacyAddress> {
	public LegacyAddressWrapper(LegacyAddress legacyAddress) {
		_legacyAddress = legacyAddress;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyAddress.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyAddress.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressId", getAddressId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("street1", getStreet1());
		attributes.put("street2", getStreet2());
		attributes.put("street3", getStreet3());
		attributes.put("city", getCity());
		attributes.put("zip", getZip());
		attributes.put("regionId", getRegionId());
		attributes.put("countryId", getCountryId());
		attributes.put("typeId", getTypeId());
		attributes.put("mailing", getMailing());
		attributes.put("primary", getPrimary());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String street1 = (String)attributes.get("street1");

		if (street1 != null) {
			setStreet1(street1);
		}

		String street2 = (String)attributes.get("street2");

		if (street2 != null) {
			setStreet2(street2);
		}

		String street3 = (String)attributes.get("street3");

		if (street3 != null) {
			setStreet3(street3);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Integer typeId = (Integer)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		Boolean mailing = (Boolean)attributes.get("mailing");

		if (mailing != null) {
			setMailing(mailing);
		}

		Boolean primary = (Boolean)attributes.get("primary");

		if (primary != null) {
			setPrimary(primary);
		}
	}

	/**
	* Returns the primary key of this legacy address.
	*
	* @return the primary key of this legacy address
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyAddress.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy address.
	*
	* @param primaryKey the primary key of this legacy address
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyAddress.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the address ID of this legacy address.
	*
	* @return the address ID of this legacy address
	*/
	@Override
	public long getAddressId() {
		return _legacyAddress.getAddressId();
	}

	/**
	* Sets the address ID of this legacy address.
	*
	* @param addressId the address ID of this legacy address
	*/
	@Override
	public void setAddressId(long addressId) {
		_legacyAddress.setAddressId(addressId);
	}

	/**
	* Returns the company ID of this legacy address.
	*
	* @return the company ID of this legacy address
	*/
	@Override
	public long getCompanyId() {
		return _legacyAddress.getCompanyId();
	}

	/**
	* Sets the company ID of this legacy address.
	*
	* @param companyId the company ID of this legacy address
	*/
	@Override
	public void setCompanyId(long companyId) {
		_legacyAddress.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this legacy address.
	*
	* @return the user ID of this legacy address
	*/
	@Override
	public long getUserId() {
		return _legacyAddress.getUserId();
	}

	/**
	* Sets the user ID of this legacy address.
	*
	* @param userId the user ID of this legacy address
	*/
	@Override
	public void setUserId(long userId) {
		_legacyAddress.setUserId(userId);
	}

	/**
	* Returns the user uuid of this legacy address.
	*
	* @return the user uuid of this legacy address
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyAddress.getUserUuid();
	}

	/**
	* Sets the user uuid of this legacy address.
	*
	* @param userUuid the user uuid of this legacy address
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_legacyAddress.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this legacy address.
	*
	* @return the user name of this legacy address
	*/
	@Override
	public java.lang.String getUserName() {
		return _legacyAddress.getUserName();
	}

	/**
	* Sets the user name of this legacy address.
	*
	* @param userName the user name of this legacy address
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_legacyAddress.setUserName(userName);
	}

	/**
	* Returns the create date of this legacy address.
	*
	* @return the create date of this legacy address
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _legacyAddress.getCreateDate();
	}

	/**
	* Sets the create date of this legacy address.
	*
	* @param createDate the create date of this legacy address
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_legacyAddress.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this legacy address.
	*
	* @return the modified date of this legacy address
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _legacyAddress.getModifiedDate();
	}

	/**
	* Sets the modified date of this legacy address.
	*
	* @param modifiedDate the modified date of this legacy address
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_legacyAddress.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the fully qualified class name of this legacy address.
	*
	* @return the fully qualified class name of this legacy address
	*/
	@Override
	public java.lang.String getClassName() {
		return _legacyAddress.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_legacyAddress.setClassName(className);
	}

	/**
	* Returns the class name ID of this legacy address.
	*
	* @return the class name ID of this legacy address
	*/
	@Override
	public long getClassNameId() {
		return _legacyAddress.getClassNameId();
	}

	/**
	* Sets the class name ID of this legacy address.
	*
	* @param classNameId the class name ID of this legacy address
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_legacyAddress.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this legacy address.
	*
	* @return the class p k of this legacy address
	*/
	@Override
	public long getClassPK() {
		return _legacyAddress.getClassPK();
	}

	/**
	* Sets the class p k of this legacy address.
	*
	* @param classPK the class p k of this legacy address
	*/
	@Override
	public void setClassPK(long classPK) {
		_legacyAddress.setClassPK(classPK);
	}

	/**
	* Returns the street1 of this legacy address.
	*
	* @return the street1 of this legacy address
	*/
	@Override
	public java.lang.String getStreet1() {
		return _legacyAddress.getStreet1();
	}

	/**
	* Sets the street1 of this legacy address.
	*
	* @param street1 the street1 of this legacy address
	*/
	@Override
	public void setStreet1(java.lang.String street1) {
		_legacyAddress.setStreet1(street1);
	}

	/**
	* Returns the street2 of this legacy address.
	*
	* @return the street2 of this legacy address
	*/
	@Override
	public java.lang.String getStreet2() {
		return _legacyAddress.getStreet2();
	}

	/**
	* Sets the street2 of this legacy address.
	*
	* @param street2 the street2 of this legacy address
	*/
	@Override
	public void setStreet2(java.lang.String street2) {
		_legacyAddress.setStreet2(street2);
	}

	/**
	* Returns the street3 of this legacy address.
	*
	* @return the street3 of this legacy address
	*/
	@Override
	public java.lang.String getStreet3() {
		return _legacyAddress.getStreet3();
	}

	/**
	* Sets the street3 of this legacy address.
	*
	* @param street3 the street3 of this legacy address
	*/
	@Override
	public void setStreet3(java.lang.String street3) {
		_legacyAddress.setStreet3(street3);
	}

	/**
	* Returns the city of this legacy address.
	*
	* @return the city of this legacy address
	*/
	@Override
	public java.lang.String getCity() {
		return _legacyAddress.getCity();
	}

	/**
	* Sets the city of this legacy address.
	*
	* @param city the city of this legacy address
	*/
	@Override
	public void setCity(java.lang.String city) {
		_legacyAddress.setCity(city);
	}

	/**
	* Returns the zip of this legacy address.
	*
	* @return the zip of this legacy address
	*/
	@Override
	public java.lang.String getZip() {
		return _legacyAddress.getZip();
	}

	/**
	* Sets the zip of this legacy address.
	*
	* @param zip the zip of this legacy address
	*/
	@Override
	public void setZip(java.lang.String zip) {
		_legacyAddress.setZip(zip);
	}

	/**
	* Returns the region ID of this legacy address.
	*
	* @return the region ID of this legacy address
	*/
	@Override
	public long getRegionId() {
		return _legacyAddress.getRegionId();
	}

	/**
	* Sets the region ID of this legacy address.
	*
	* @param regionId the region ID of this legacy address
	*/
	@Override
	public void setRegionId(long regionId) {
		_legacyAddress.setRegionId(regionId);
	}

	/**
	* Returns the country ID of this legacy address.
	*
	* @return the country ID of this legacy address
	*/
	@Override
	public long getCountryId() {
		return _legacyAddress.getCountryId();
	}

	/**
	* Sets the country ID of this legacy address.
	*
	* @param countryId the country ID of this legacy address
	*/
	@Override
	public void setCountryId(long countryId) {
		_legacyAddress.setCountryId(countryId);
	}

	/**
	* Returns the type ID of this legacy address.
	*
	* @return the type ID of this legacy address
	*/
	@Override
	public int getTypeId() {
		return _legacyAddress.getTypeId();
	}

	/**
	* Sets the type ID of this legacy address.
	*
	* @param typeId the type ID of this legacy address
	*/
	@Override
	public void setTypeId(int typeId) {
		_legacyAddress.setTypeId(typeId);
	}

	/**
	* Returns the mailing of this legacy address.
	*
	* @return the mailing of this legacy address
	*/
	@Override
	public boolean getMailing() {
		return _legacyAddress.getMailing();
	}

	/**
	* Returns <code>true</code> if this legacy address is mailing.
	*
	* @return <code>true</code> if this legacy address is mailing; <code>false</code> otherwise
	*/
	@Override
	public boolean isMailing() {
		return _legacyAddress.isMailing();
	}

	/**
	* Sets whether this legacy address is mailing.
	*
	* @param mailing the mailing of this legacy address
	*/
	@Override
	public void setMailing(boolean mailing) {
		_legacyAddress.setMailing(mailing);
	}

	/**
	* Returns the primary of this legacy address.
	*
	* @return the primary of this legacy address
	*/
	@Override
	public boolean getPrimary() {
		return _legacyAddress.getPrimary();
	}

	/**
	* Returns <code>true</code> if this legacy address is primary.
	*
	* @return <code>true</code> if this legacy address is primary; <code>false</code> otherwise
	*/
	@Override
	public boolean isPrimary() {
		return _legacyAddress.isPrimary();
	}

	/**
	* Sets whether this legacy address is primary.
	*
	* @param primary the primary of this legacy address
	*/
	@Override
	public void setPrimary(boolean primary) {
		_legacyAddress.setPrimary(primary);
	}

	@Override
	public boolean isNew() {
		return _legacyAddress.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyAddress.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyAddress.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyAddress.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyAddress.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyAddress.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyAddress.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyAddress.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyAddress.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyAddress.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyAddress.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyAddressWrapper((LegacyAddress)_legacyAddress.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyAddress legacyAddress) {
		return _legacyAddress.compareTo(legacyAddress);
	}

	@Override
	public int hashCode() {
		return _legacyAddress.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyAddress> toCacheModel() {
		return _legacyAddress.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyAddress toEscapedModel() {
		return new LegacyAddressWrapper(_legacyAddress.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyAddress toUnescapedModel() {
		return new LegacyAddressWrapper(_legacyAddress.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyAddress.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyAddress.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyAddress.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyAddressWrapper)) {
			return false;
		}

		LegacyAddressWrapper legacyAddressWrapper = (LegacyAddressWrapper)obj;

		if (Validator.equals(_legacyAddress, legacyAddressWrapper._legacyAddress)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyAddress getWrappedLegacyAddress() {
		return _legacyAddress;
	}

	@Override
	public LegacyAddress getWrappedModel() {
		return _legacyAddress;
	}

	@Override
	public void resetOriginalValues() {
		_legacyAddress.resetOriginalValues();
	}

	private LegacyAddress _legacyAddress;
}