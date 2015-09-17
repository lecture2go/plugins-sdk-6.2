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
 * This class is a wrapper for {@link LegacyContact}.
 * </p>
 *
 * @author unihh
 * @see LegacyContact
 * @generated
 */
public class LegacyContactWrapper implements LegacyContact,
	ModelWrapper<LegacyContact> {
	public LegacyContactWrapper(LegacyContact legacyContact) {
		_legacyContact = legacyContact;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyContact.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyContact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("accountId", getAccountId());
		attributes.put("parentContactId", getParentContactId());
		attributes.put("firstName", getFirstName());
		attributes.put("middleName", getMiddleName());
		attributes.put("lastName", getLastName());
		attributes.put("prefixId", getPrefixId());
		attributes.put("suffixId", getSuffixId());
		attributes.put("male", getMale());
		attributes.put("birthday", getBirthday());
		attributes.put("smsSn", getSmsSn());
		attributes.put("aimSn", getAimSn());
		attributes.put("facebookSn", getFacebookSn());
		attributes.put("icqSn", getIcqSn());
		attributes.put("jabberSn", getJabberSn());
		attributes.put("msnSn", getMsnSn());
		attributes.put("mySpaceSn", getMySpaceSn());
		attributes.put("skypeSn", getSkypeSn());
		attributes.put("twitterSn", getTwitterSn());
		attributes.put("ymSn", getYmSn());
		attributes.put("employeeStatusId", getEmployeeStatusId());
		attributes.put("employeeNumber", getEmployeeNumber());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("jobClass", getJobClass());
		attributes.put("hoursOfOperation", getHoursOfOperation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
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

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Long parentContactId = (Long)attributes.get("parentContactId");

		if (parentContactId != null) {
			setParentContactId(parentContactId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Integer prefixId = (Integer)attributes.get("prefixId");

		if (prefixId != null) {
			setPrefixId(prefixId);
		}

		Integer suffixId = (Integer)attributes.get("suffixId");

		if (suffixId != null) {
			setSuffixId(suffixId);
		}

		Boolean male = (Boolean)attributes.get("male");

		if (male != null) {
			setMale(male);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String smsSn = (String)attributes.get("smsSn");

		if (smsSn != null) {
			setSmsSn(smsSn);
		}

		String aimSn = (String)attributes.get("aimSn");

		if (aimSn != null) {
			setAimSn(aimSn);
		}

		String facebookSn = (String)attributes.get("facebookSn");

		if (facebookSn != null) {
			setFacebookSn(facebookSn);
		}

		String icqSn = (String)attributes.get("icqSn");

		if (icqSn != null) {
			setIcqSn(icqSn);
		}

		String jabberSn = (String)attributes.get("jabberSn");

		if (jabberSn != null) {
			setJabberSn(jabberSn);
		}

		String msnSn = (String)attributes.get("msnSn");

		if (msnSn != null) {
			setMsnSn(msnSn);
		}

		String mySpaceSn = (String)attributes.get("mySpaceSn");

		if (mySpaceSn != null) {
			setMySpaceSn(mySpaceSn);
		}

		String skypeSn = (String)attributes.get("skypeSn");

		if (skypeSn != null) {
			setSkypeSn(skypeSn);
		}

		String twitterSn = (String)attributes.get("twitterSn");

		if (twitterSn != null) {
			setTwitterSn(twitterSn);
		}

		String ymSn = (String)attributes.get("ymSn");

		if (ymSn != null) {
			setYmSn(ymSn);
		}

		String employeeStatusId = (String)attributes.get("employeeStatusId");

		if (employeeStatusId != null) {
			setEmployeeStatusId(employeeStatusId);
		}

		String employeeNumber = (String)attributes.get("employeeNumber");

		if (employeeNumber != null) {
			setEmployeeNumber(employeeNumber);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String jobClass = (String)attributes.get("jobClass");

		if (jobClass != null) {
			setJobClass(jobClass);
		}

		String hoursOfOperation = (String)attributes.get("hoursOfOperation");

		if (hoursOfOperation != null) {
			setHoursOfOperation(hoursOfOperation);
		}
	}

	/**
	* Returns the primary key of this legacy contact.
	*
	* @return the primary key of this legacy contact
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyContact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy contact.
	*
	* @param primaryKey the primary key of this legacy contact
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyContact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact ID of this legacy contact.
	*
	* @return the contact ID of this legacy contact
	*/
	@Override
	public long getContactId() {
		return _legacyContact.getContactId();
	}

	/**
	* Sets the contact ID of this legacy contact.
	*
	* @param contactId the contact ID of this legacy contact
	*/
	@Override
	public void setContactId(long contactId) {
		_legacyContact.setContactId(contactId);
	}

	/**
	* Returns the company ID of this legacy contact.
	*
	* @return the company ID of this legacy contact
	*/
	@Override
	public long getCompanyId() {
		return _legacyContact.getCompanyId();
	}

	/**
	* Sets the company ID of this legacy contact.
	*
	* @param companyId the company ID of this legacy contact
	*/
	@Override
	public void setCompanyId(long companyId) {
		_legacyContact.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this legacy contact.
	*
	* @return the user ID of this legacy contact
	*/
	@Override
	public long getUserId() {
		return _legacyContact.getUserId();
	}

	/**
	* Sets the user ID of this legacy contact.
	*
	* @param userId the user ID of this legacy contact
	*/
	@Override
	public void setUserId(long userId) {
		_legacyContact.setUserId(userId);
	}

	/**
	* Returns the user uuid of this legacy contact.
	*
	* @return the user uuid of this legacy contact
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyContact.getUserUuid();
	}

	/**
	* Sets the user uuid of this legacy contact.
	*
	* @param userUuid the user uuid of this legacy contact
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_legacyContact.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this legacy contact.
	*
	* @return the user name of this legacy contact
	*/
	@Override
	public java.lang.String getUserName() {
		return _legacyContact.getUserName();
	}

	/**
	* Sets the user name of this legacy contact.
	*
	* @param userName the user name of this legacy contact
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_legacyContact.setUserName(userName);
	}

	/**
	* Returns the create date of this legacy contact.
	*
	* @return the create date of this legacy contact
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _legacyContact.getCreateDate();
	}

	/**
	* Sets the create date of this legacy contact.
	*
	* @param createDate the create date of this legacy contact
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_legacyContact.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this legacy contact.
	*
	* @return the modified date of this legacy contact
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _legacyContact.getModifiedDate();
	}

	/**
	* Sets the modified date of this legacy contact.
	*
	* @param modifiedDate the modified date of this legacy contact
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_legacyContact.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the account ID of this legacy contact.
	*
	* @return the account ID of this legacy contact
	*/
	@Override
	public long getAccountId() {
		return _legacyContact.getAccountId();
	}

	/**
	* Sets the account ID of this legacy contact.
	*
	* @param accountId the account ID of this legacy contact
	*/
	@Override
	public void setAccountId(long accountId) {
		_legacyContact.setAccountId(accountId);
	}

	/**
	* Returns the parent contact ID of this legacy contact.
	*
	* @return the parent contact ID of this legacy contact
	*/
	@Override
	public long getParentContactId() {
		return _legacyContact.getParentContactId();
	}

	/**
	* Sets the parent contact ID of this legacy contact.
	*
	* @param parentContactId the parent contact ID of this legacy contact
	*/
	@Override
	public void setParentContactId(long parentContactId) {
		_legacyContact.setParentContactId(parentContactId);
	}

	/**
	* Returns the first name of this legacy contact.
	*
	* @return the first name of this legacy contact
	*/
	@Override
	public java.lang.String getFirstName() {
		return _legacyContact.getFirstName();
	}

	/**
	* Sets the first name of this legacy contact.
	*
	* @param firstName the first name of this legacy contact
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_legacyContact.setFirstName(firstName);
	}

	/**
	* Returns the middle name of this legacy contact.
	*
	* @return the middle name of this legacy contact
	*/
	@Override
	public java.lang.String getMiddleName() {
		return _legacyContact.getMiddleName();
	}

	/**
	* Sets the middle name of this legacy contact.
	*
	* @param middleName the middle name of this legacy contact
	*/
	@Override
	public void setMiddleName(java.lang.String middleName) {
		_legacyContact.setMiddleName(middleName);
	}

	/**
	* Returns the last name of this legacy contact.
	*
	* @return the last name of this legacy contact
	*/
	@Override
	public java.lang.String getLastName() {
		return _legacyContact.getLastName();
	}

	/**
	* Sets the last name of this legacy contact.
	*
	* @param lastName the last name of this legacy contact
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_legacyContact.setLastName(lastName);
	}

	/**
	* Returns the prefix ID of this legacy contact.
	*
	* @return the prefix ID of this legacy contact
	*/
	@Override
	public int getPrefixId() {
		return _legacyContact.getPrefixId();
	}

	/**
	* Sets the prefix ID of this legacy contact.
	*
	* @param prefixId the prefix ID of this legacy contact
	*/
	@Override
	public void setPrefixId(int prefixId) {
		_legacyContact.setPrefixId(prefixId);
	}

	/**
	* Returns the suffix ID of this legacy contact.
	*
	* @return the suffix ID of this legacy contact
	*/
	@Override
	public int getSuffixId() {
		return _legacyContact.getSuffixId();
	}

	/**
	* Sets the suffix ID of this legacy contact.
	*
	* @param suffixId the suffix ID of this legacy contact
	*/
	@Override
	public void setSuffixId(int suffixId) {
		_legacyContact.setSuffixId(suffixId);
	}

	/**
	* Returns the male of this legacy contact.
	*
	* @return the male of this legacy contact
	*/
	@Override
	public boolean getMale() {
		return _legacyContact.getMale();
	}

	/**
	* Returns <code>true</code> if this legacy contact is male.
	*
	* @return <code>true</code> if this legacy contact is male; <code>false</code> otherwise
	*/
	@Override
	public boolean isMale() {
		return _legacyContact.isMale();
	}

	/**
	* Sets whether this legacy contact is male.
	*
	* @param male the male of this legacy contact
	*/
	@Override
	public void setMale(boolean male) {
		_legacyContact.setMale(male);
	}

	/**
	* Returns the birthday of this legacy contact.
	*
	* @return the birthday of this legacy contact
	*/
	@Override
	public java.util.Date getBirthday() {
		return _legacyContact.getBirthday();
	}

	/**
	* Sets the birthday of this legacy contact.
	*
	* @param birthday the birthday of this legacy contact
	*/
	@Override
	public void setBirthday(java.util.Date birthday) {
		_legacyContact.setBirthday(birthday);
	}

	/**
	* Returns the sms sn of this legacy contact.
	*
	* @return the sms sn of this legacy contact
	*/
	@Override
	public java.lang.String getSmsSn() {
		return _legacyContact.getSmsSn();
	}

	/**
	* Sets the sms sn of this legacy contact.
	*
	* @param smsSn the sms sn of this legacy contact
	*/
	@Override
	public void setSmsSn(java.lang.String smsSn) {
		_legacyContact.setSmsSn(smsSn);
	}

	/**
	* Returns the aim sn of this legacy contact.
	*
	* @return the aim sn of this legacy contact
	*/
	@Override
	public java.lang.String getAimSn() {
		return _legacyContact.getAimSn();
	}

	/**
	* Sets the aim sn of this legacy contact.
	*
	* @param aimSn the aim sn of this legacy contact
	*/
	@Override
	public void setAimSn(java.lang.String aimSn) {
		_legacyContact.setAimSn(aimSn);
	}

	/**
	* Returns the facebook sn of this legacy contact.
	*
	* @return the facebook sn of this legacy contact
	*/
	@Override
	public java.lang.String getFacebookSn() {
		return _legacyContact.getFacebookSn();
	}

	/**
	* Sets the facebook sn of this legacy contact.
	*
	* @param facebookSn the facebook sn of this legacy contact
	*/
	@Override
	public void setFacebookSn(java.lang.String facebookSn) {
		_legacyContact.setFacebookSn(facebookSn);
	}

	/**
	* Returns the icq sn of this legacy contact.
	*
	* @return the icq sn of this legacy contact
	*/
	@Override
	public java.lang.String getIcqSn() {
		return _legacyContact.getIcqSn();
	}

	/**
	* Sets the icq sn of this legacy contact.
	*
	* @param icqSn the icq sn of this legacy contact
	*/
	@Override
	public void setIcqSn(java.lang.String icqSn) {
		_legacyContact.setIcqSn(icqSn);
	}

	/**
	* Returns the jabber sn of this legacy contact.
	*
	* @return the jabber sn of this legacy contact
	*/
	@Override
	public java.lang.String getJabberSn() {
		return _legacyContact.getJabberSn();
	}

	/**
	* Sets the jabber sn of this legacy contact.
	*
	* @param jabberSn the jabber sn of this legacy contact
	*/
	@Override
	public void setJabberSn(java.lang.String jabberSn) {
		_legacyContact.setJabberSn(jabberSn);
	}

	/**
	* Returns the msn sn of this legacy contact.
	*
	* @return the msn sn of this legacy contact
	*/
	@Override
	public java.lang.String getMsnSn() {
		return _legacyContact.getMsnSn();
	}

	/**
	* Sets the msn sn of this legacy contact.
	*
	* @param msnSn the msn sn of this legacy contact
	*/
	@Override
	public void setMsnSn(java.lang.String msnSn) {
		_legacyContact.setMsnSn(msnSn);
	}

	/**
	* Returns the my space sn of this legacy contact.
	*
	* @return the my space sn of this legacy contact
	*/
	@Override
	public java.lang.String getMySpaceSn() {
		return _legacyContact.getMySpaceSn();
	}

	/**
	* Sets the my space sn of this legacy contact.
	*
	* @param mySpaceSn the my space sn of this legacy contact
	*/
	@Override
	public void setMySpaceSn(java.lang.String mySpaceSn) {
		_legacyContact.setMySpaceSn(mySpaceSn);
	}

	/**
	* Returns the skype sn of this legacy contact.
	*
	* @return the skype sn of this legacy contact
	*/
	@Override
	public java.lang.String getSkypeSn() {
		return _legacyContact.getSkypeSn();
	}

	/**
	* Sets the skype sn of this legacy contact.
	*
	* @param skypeSn the skype sn of this legacy contact
	*/
	@Override
	public void setSkypeSn(java.lang.String skypeSn) {
		_legacyContact.setSkypeSn(skypeSn);
	}

	/**
	* Returns the twitter sn of this legacy contact.
	*
	* @return the twitter sn of this legacy contact
	*/
	@Override
	public java.lang.String getTwitterSn() {
		return _legacyContact.getTwitterSn();
	}

	/**
	* Sets the twitter sn of this legacy contact.
	*
	* @param twitterSn the twitter sn of this legacy contact
	*/
	@Override
	public void setTwitterSn(java.lang.String twitterSn) {
		_legacyContact.setTwitterSn(twitterSn);
	}

	/**
	* Returns the ym sn of this legacy contact.
	*
	* @return the ym sn of this legacy contact
	*/
	@Override
	public java.lang.String getYmSn() {
		return _legacyContact.getYmSn();
	}

	/**
	* Sets the ym sn of this legacy contact.
	*
	* @param ymSn the ym sn of this legacy contact
	*/
	@Override
	public void setYmSn(java.lang.String ymSn) {
		_legacyContact.setYmSn(ymSn);
	}

	/**
	* Returns the employee status ID of this legacy contact.
	*
	* @return the employee status ID of this legacy contact
	*/
	@Override
	public java.lang.String getEmployeeStatusId() {
		return _legacyContact.getEmployeeStatusId();
	}

	/**
	* Sets the employee status ID of this legacy contact.
	*
	* @param employeeStatusId the employee status ID of this legacy contact
	*/
	@Override
	public void setEmployeeStatusId(java.lang.String employeeStatusId) {
		_legacyContact.setEmployeeStatusId(employeeStatusId);
	}

	/**
	* Returns the employee number of this legacy contact.
	*
	* @return the employee number of this legacy contact
	*/
	@Override
	public java.lang.String getEmployeeNumber() {
		return _legacyContact.getEmployeeNumber();
	}

	/**
	* Sets the employee number of this legacy contact.
	*
	* @param employeeNumber the employee number of this legacy contact
	*/
	@Override
	public void setEmployeeNumber(java.lang.String employeeNumber) {
		_legacyContact.setEmployeeNumber(employeeNumber);
	}

	/**
	* Returns the job title of this legacy contact.
	*
	* @return the job title of this legacy contact
	*/
	@Override
	public java.lang.String getJobTitle() {
		return _legacyContact.getJobTitle();
	}

	/**
	* Sets the job title of this legacy contact.
	*
	* @param jobTitle the job title of this legacy contact
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		_legacyContact.setJobTitle(jobTitle);
	}

	/**
	* Returns the job class of this legacy contact.
	*
	* @return the job class of this legacy contact
	*/
	@Override
	public java.lang.String getJobClass() {
		return _legacyContact.getJobClass();
	}

	/**
	* Sets the job class of this legacy contact.
	*
	* @param jobClass the job class of this legacy contact
	*/
	@Override
	public void setJobClass(java.lang.String jobClass) {
		_legacyContact.setJobClass(jobClass);
	}

	/**
	* Returns the hours of operation of this legacy contact.
	*
	* @return the hours of operation of this legacy contact
	*/
	@Override
	public java.lang.String getHoursOfOperation() {
		return _legacyContact.getHoursOfOperation();
	}

	/**
	* Sets the hours of operation of this legacy contact.
	*
	* @param hoursOfOperation the hours of operation of this legacy contact
	*/
	@Override
	public void setHoursOfOperation(java.lang.String hoursOfOperation) {
		_legacyContact.setHoursOfOperation(hoursOfOperation);
	}

	@Override
	public boolean isNew() {
		return _legacyContact.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyContact.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyContact.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyContact.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyContact.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyContact.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyContact.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyContact.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyContact.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyContact.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyContact.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyContactWrapper((LegacyContact)_legacyContact.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyContact legacyContact) {
		return _legacyContact.compareTo(legacyContact);
	}

	@Override
	public int hashCode() {
		return _legacyContact.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyContact> toCacheModel() {
		return _legacyContact.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyContact toEscapedModel() {
		return new LegacyContactWrapper(_legacyContact.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyContact toUnescapedModel() {
		return new LegacyContactWrapper(_legacyContact.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyContact.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyContact.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyContact.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyContactWrapper)) {
			return false;
		}

		LegacyContactWrapper legacyContactWrapper = (LegacyContactWrapper)obj;

		if (Validator.equals(_legacyContact, legacyContactWrapper._legacyContact)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyContact getWrappedLegacyContact() {
		return _legacyContact;
	}

	@Override
	public LegacyContact getWrappedModel() {
		return _legacyContact;
	}

	@Override
	public void resetOriginalValues() {
		_legacyContact.resetOriginalValues();
	}

	private LegacyContact _legacyContact;
}