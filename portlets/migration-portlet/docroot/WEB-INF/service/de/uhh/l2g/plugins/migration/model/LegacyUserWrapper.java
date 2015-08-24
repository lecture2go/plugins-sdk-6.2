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
 * This class is a wrapper for {@link LegacyUser}.
 * </p>
 *
 * @author unihh
 * @see LegacyUser
 * @generated
 */
public class LegacyUserWrapper implements LegacyUser, ModelWrapper<LegacyUser> {
	public LegacyUserWrapper(LegacyUser legacyUser) {
		_legacyUser = legacyUser;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyUser.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("defaultUser", getDefaultUser());
		attributes.put("contactId", getContactId());
		attributes.put("password", getPassword());
		attributes.put("passwordEncrypted", getPasswordEncrypted());
		attributes.put("passwordReset", getPasswordReset());
		attributes.put("passwordModifiedDate", getPasswordModifiedDate());
		attributes.put("reminderQueryQuestion", getReminderQueryQuestion());
		attributes.put("reminderQueryAnswer", getReminderQueryAnswer());
		attributes.put("graceLoginCount", getGraceLoginCount());
		attributes.put("screenName", getScreenName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("openId", getOpenId());
		attributes.put("portraitId", getPortraitId());
		attributes.put("languageId", getLanguageId());
		attributes.put("timeZoneId", getTimeZoneId());
		attributes.put("greeting", getGreeting());
		attributes.put("comments", getComments());
		attributes.put("loginDate", getLoginDate());
		attributes.put("loginIP", getLoginIP());
		attributes.put("lastLoginDate", getLastLoginDate());
		attributes.put("lastLoginIP", getLastLoginIP());
		attributes.put("lastFailedLoginDate", getLastFailedLoginDate());
		attributes.put("failedLoginAttempts", getFailedLoginAttempts());
		attributes.put("lockout", getLockout());
		attributes.put("lockoutDate", getLockoutDate());
		attributes.put("agreedToTermsOfUse", getAgreedToTermsOfUse());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean defaultUser = (Boolean)attributes.get("defaultUser");

		if (defaultUser != null) {
			setDefaultUser(defaultUser);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Boolean passwordEncrypted = (Boolean)attributes.get("passwordEncrypted");

		if (passwordEncrypted != null) {
			setPasswordEncrypted(passwordEncrypted);
		}

		Boolean passwordReset = (Boolean)attributes.get("passwordReset");

		if (passwordReset != null) {
			setPasswordReset(passwordReset);
		}

		Date passwordModifiedDate = (Date)attributes.get("passwordModifiedDate");

		if (passwordModifiedDate != null) {
			setPasswordModifiedDate(passwordModifiedDate);
		}

		String reminderQueryQuestion = (String)attributes.get(
				"reminderQueryQuestion");

		if (reminderQueryQuestion != null) {
			setReminderQueryQuestion(reminderQueryQuestion);
		}

		String reminderQueryAnswer = (String)attributes.get(
				"reminderQueryAnswer");

		if (reminderQueryAnswer != null) {
			setReminderQueryAnswer(reminderQueryAnswer);
		}

		Integer graceLoginCount = (Integer)attributes.get("graceLoginCount");

		if (graceLoginCount != null) {
			setGraceLoginCount(graceLoginCount);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String openId = (String)attributes.get("openId");

		if (openId != null) {
			setOpenId(openId);
		}

		Long portraitId = (Long)attributes.get("portraitId");

		if (portraitId != null) {
			setPortraitId(portraitId);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String timeZoneId = (String)attributes.get("timeZoneId");

		if (timeZoneId != null) {
			setTimeZoneId(timeZoneId);
		}

		String greeting = (String)attributes.get("greeting");

		if (greeting != null) {
			setGreeting(greeting);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Date loginDate = (Date)attributes.get("loginDate");

		if (loginDate != null) {
			setLoginDate(loginDate);
		}

		String loginIP = (String)attributes.get("loginIP");

		if (loginIP != null) {
			setLoginIP(loginIP);
		}

		Date lastLoginDate = (Date)attributes.get("lastLoginDate");

		if (lastLoginDate != null) {
			setLastLoginDate(lastLoginDate);
		}

		String lastLoginIP = (String)attributes.get("lastLoginIP");

		if (lastLoginIP != null) {
			setLastLoginIP(lastLoginIP);
		}

		Date lastFailedLoginDate = (Date)attributes.get("lastFailedLoginDate");

		if (lastFailedLoginDate != null) {
			setLastFailedLoginDate(lastFailedLoginDate);
		}

		Integer failedLoginAttempts = (Integer)attributes.get(
				"failedLoginAttempts");

		if (failedLoginAttempts != null) {
			setFailedLoginAttempts(failedLoginAttempts);
		}

		Boolean lockout = (Boolean)attributes.get("lockout");

		if (lockout != null) {
			setLockout(lockout);
		}

		Date lockoutDate = (Date)attributes.get("lockoutDate");

		if (lockoutDate != null) {
			setLockoutDate(lockoutDate);
		}

		Boolean agreedToTermsOfUse = (Boolean)attributes.get(
				"agreedToTermsOfUse");

		if (agreedToTermsOfUse != null) {
			setAgreedToTermsOfUse(agreedToTermsOfUse);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this legacy user.
	*
	* @return the primary key of this legacy user
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy user.
	*
	* @param primaryKey the primary key of this legacy user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this legacy user.
	*
	* @return the user ID of this legacy user
	*/
	@Override
	public long getUserId() {
		return _legacyUser.getUserId();
	}

	/**
	* Sets the user ID of this legacy user.
	*
	* @param userId the user ID of this legacy user
	*/
	@Override
	public void setUserId(long userId) {
		_legacyUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this legacy user.
	*
	* @return the user uuid of this legacy user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this legacy user.
	*
	* @param userUuid the user uuid of this legacy user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_legacyUser.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this legacy user.
	*
	* @return the company ID of this legacy user
	*/
	@Override
	public long getCompanyId() {
		return _legacyUser.getCompanyId();
	}

	/**
	* Sets the company ID of this legacy user.
	*
	* @param companyId the company ID of this legacy user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_legacyUser.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this legacy user.
	*
	* @return the create date of this legacy user
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _legacyUser.getCreateDate();
	}

	/**
	* Sets the create date of this legacy user.
	*
	* @param createDate the create date of this legacy user
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_legacyUser.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this legacy user.
	*
	* @return the modified date of this legacy user
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _legacyUser.getModifiedDate();
	}

	/**
	* Sets the modified date of this legacy user.
	*
	* @param modifiedDate the modified date of this legacy user
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_legacyUser.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the default user of this legacy user.
	*
	* @return the default user of this legacy user
	*/
	@Override
	public boolean getDefaultUser() {
		return _legacyUser.getDefaultUser();
	}

	/**
	* Returns <code>true</code> if this legacy user is default user.
	*
	* @return <code>true</code> if this legacy user is default user; <code>false</code> otherwise
	*/
	@Override
	public boolean isDefaultUser() {
		return _legacyUser.isDefaultUser();
	}

	/**
	* Sets whether this legacy user is default user.
	*
	* @param defaultUser the default user of this legacy user
	*/
	@Override
	public void setDefaultUser(boolean defaultUser) {
		_legacyUser.setDefaultUser(defaultUser);
	}

	/**
	* Returns the contact ID of this legacy user.
	*
	* @return the contact ID of this legacy user
	*/
	@Override
	public long getContactId() {
		return _legacyUser.getContactId();
	}

	/**
	* Sets the contact ID of this legacy user.
	*
	* @param contactId the contact ID of this legacy user
	*/
	@Override
	public void setContactId(long contactId) {
		_legacyUser.setContactId(contactId);
	}

	/**
	* Returns the password of this legacy user.
	*
	* @return the password of this legacy user
	*/
	@Override
	public java.lang.String getPassword() {
		return _legacyUser.getPassword();
	}

	/**
	* Sets the password of this legacy user.
	*
	* @param password the password of this legacy user
	*/
	@Override
	public void setPassword(java.lang.String password) {
		_legacyUser.setPassword(password);
	}

	/**
	* Returns the password encrypted of this legacy user.
	*
	* @return the password encrypted of this legacy user
	*/
	@Override
	public boolean getPasswordEncrypted() {
		return _legacyUser.getPasswordEncrypted();
	}

	/**
	* Returns <code>true</code> if this legacy user is password encrypted.
	*
	* @return <code>true</code> if this legacy user is password encrypted; <code>false</code> otherwise
	*/
	@Override
	public boolean isPasswordEncrypted() {
		return _legacyUser.isPasswordEncrypted();
	}

	/**
	* Sets whether this legacy user is password encrypted.
	*
	* @param passwordEncrypted the password encrypted of this legacy user
	*/
	@Override
	public void setPasswordEncrypted(boolean passwordEncrypted) {
		_legacyUser.setPasswordEncrypted(passwordEncrypted);
	}

	/**
	* Returns the password reset of this legacy user.
	*
	* @return the password reset of this legacy user
	*/
	@Override
	public boolean getPasswordReset() {
		return _legacyUser.getPasswordReset();
	}

	/**
	* Returns <code>true</code> if this legacy user is password reset.
	*
	* @return <code>true</code> if this legacy user is password reset; <code>false</code> otherwise
	*/
	@Override
	public boolean isPasswordReset() {
		return _legacyUser.isPasswordReset();
	}

	/**
	* Sets whether this legacy user is password reset.
	*
	* @param passwordReset the password reset of this legacy user
	*/
	@Override
	public void setPasswordReset(boolean passwordReset) {
		_legacyUser.setPasswordReset(passwordReset);
	}

	/**
	* Returns the password modified date of this legacy user.
	*
	* @return the password modified date of this legacy user
	*/
	@Override
	public java.util.Date getPasswordModifiedDate() {
		return _legacyUser.getPasswordModifiedDate();
	}

	/**
	* Sets the password modified date of this legacy user.
	*
	* @param passwordModifiedDate the password modified date of this legacy user
	*/
	@Override
	public void setPasswordModifiedDate(java.util.Date passwordModifiedDate) {
		_legacyUser.setPasswordModifiedDate(passwordModifiedDate);
	}

	/**
	* Returns the reminder query question of this legacy user.
	*
	* @return the reminder query question of this legacy user
	*/
	@Override
	public java.lang.String getReminderQueryQuestion() {
		return _legacyUser.getReminderQueryQuestion();
	}

	/**
	* Sets the reminder query question of this legacy user.
	*
	* @param reminderQueryQuestion the reminder query question of this legacy user
	*/
	@Override
	public void setReminderQueryQuestion(java.lang.String reminderQueryQuestion) {
		_legacyUser.setReminderQueryQuestion(reminderQueryQuestion);
	}

	/**
	* Returns the reminder query answer of this legacy user.
	*
	* @return the reminder query answer of this legacy user
	*/
	@Override
	public java.lang.String getReminderQueryAnswer() {
		return _legacyUser.getReminderQueryAnswer();
	}

	/**
	* Sets the reminder query answer of this legacy user.
	*
	* @param reminderQueryAnswer the reminder query answer of this legacy user
	*/
	@Override
	public void setReminderQueryAnswer(java.lang.String reminderQueryAnswer) {
		_legacyUser.setReminderQueryAnswer(reminderQueryAnswer);
	}

	/**
	* Returns the grace login count of this legacy user.
	*
	* @return the grace login count of this legacy user
	*/
	@Override
	public int getGraceLoginCount() {
		return _legacyUser.getGraceLoginCount();
	}

	/**
	* Sets the grace login count of this legacy user.
	*
	* @param graceLoginCount the grace login count of this legacy user
	*/
	@Override
	public void setGraceLoginCount(int graceLoginCount) {
		_legacyUser.setGraceLoginCount(graceLoginCount);
	}

	/**
	* Returns the screen name of this legacy user.
	*
	* @return the screen name of this legacy user
	*/
	@Override
	public java.lang.String getScreenName() {
		return _legacyUser.getScreenName();
	}

	/**
	* Sets the screen name of this legacy user.
	*
	* @param screenName the screen name of this legacy user
	*/
	@Override
	public void setScreenName(java.lang.String screenName) {
		_legacyUser.setScreenName(screenName);
	}

	/**
	* Returns the email address of this legacy user.
	*
	* @return the email address of this legacy user
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _legacyUser.getEmailAddress();
	}

	/**
	* Sets the email address of this legacy user.
	*
	* @param emailAddress the email address of this legacy user
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_legacyUser.setEmailAddress(emailAddress);
	}

	/**
	* Returns the open ID of this legacy user.
	*
	* @return the open ID of this legacy user
	*/
	@Override
	public java.lang.String getOpenId() {
		return _legacyUser.getOpenId();
	}

	/**
	* Sets the open ID of this legacy user.
	*
	* @param openId the open ID of this legacy user
	*/
	@Override
	public void setOpenId(java.lang.String openId) {
		_legacyUser.setOpenId(openId);
	}

	/**
	* Returns the portrait ID of this legacy user.
	*
	* @return the portrait ID of this legacy user
	*/
	@Override
	public long getPortraitId() {
		return _legacyUser.getPortraitId();
	}

	/**
	* Sets the portrait ID of this legacy user.
	*
	* @param portraitId the portrait ID of this legacy user
	*/
	@Override
	public void setPortraitId(long portraitId) {
		_legacyUser.setPortraitId(portraitId);
	}

	/**
	* Returns the language ID of this legacy user.
	*
	* @return the language ID of this legacy user
	*/
	@Override
	public java.lang.String getLanguageId() {
		return _legacyUser.getLanguageId();
	}

	/**
	* Sets the language ID of this legacy user.
	*
	* @param languageId the language ID of this legacy user
	*/
	@Override
	public void setLanguageId(java.lang.String languageId) {
		_legacyUser.setLanguageId(languageId);
	}

	/**
	* Returns the time zone ID of this legacy user.
	*
	* @return the time zone ID of this legacy user
	*/
	@Override
	public java.lang.String getTimeZoneId() {
		return _legacyUser.getTimeZoneId();
	}

	/**
	* Sets the time zone ID of this legacy user.
	*
	* @param timeZoneId the time zone ID of this legacy user
	*/
	@Override
	public void setTimeZoneId(java.lang.String timeZoneId) {
		_legacyUser.setTimeZoneId(timeZoneId);
	}

	/**
	* Returns the greeting of this legacy user.
	*
	* @return the greeting of this legacy user
	*/
	@Override
	public java.lang.String getGreeting() {
		return _legacyUser.getGreeting();
	}

	/**
	* Sets the greeting of this legacy user.
	*
	* @param greeting the greeting of this legacy user
	*/
	@Override
	public void setGreeting(java.lang.String greeting) {
		_legacyUser.setGreeting(greeting);
	}

	/**
	* Returns the comments of this legacy user.
	*
	* @return the comments of this legacy user
	*/
	@Override
	public java.lang.String getComments() {
		return _legacyUser.getComments();
	}

	/**
	* Sets the comments of this legacy user.
	*
	* @param comments the comments of this legacy user
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_legacyUser.setComments(comments);
	}

	/**
	* Returns the login date of this legacy user.
	*
	* @return the login date of this legacy user
	*/
	@Override
	public java.util.Date getLoginDate() {
		return _legacyUser.getLoginDate();
	}

	/**
	* Sets the login date of this legacy user.
	*
	* @param loginDate the login date of this legacy user
	*/
	@Override
	public void setLoginDate(java.util.Date loginDate) {
		_legacyUser.setLoginDate(loginDate);
	}

	/**
	* Returns the login i p of this legacy user.
	*
	* @return the login i p of this legacy user
	*/
	@Override
	public java.lang.String getLoginIP() {
		return _legacyUser.getLoginIP();
	}

	/**
	* Sets the login i p of this legacy user.
	*
	* @param loginIP the login i p of this legacy user
	*/
	@Override
	public void setLoginIP(java.lang.String loginIP) {
		_legacyUser.setLoginIP(loginIP);
	}

	/**
	* Returns the last login date of this legacy user.
	*
	* @return the last login date of this legacy user
	*/
	@Override
	public java.util.Date getLastLoginDate() {
		return _legacyUser.getLastLoginDate();
	}

	/**
	* Sets the last login date of this legacy user.
	*
	* @param lastLoginDate the last login date of this legacy user
	*/
	@Override
	public void setLastLoginDate(java.util.Date lastLoginDate) {
		_legacyUser.setLastLoginDate(lastLoginDate);
	}

	/**
	* Returns the last login i p of this legacy user.
	*
	* @return the last login i p of this legacy user
	*/
	@Override
	public java.lang.String getLastLoginIP() {
		return _legacyUser.getLastLoginIP();
	}

	/**
	* Sets the last login i p of this legacy user.
	*
	* @param lastLoginIP the last login i p of this legacy user
	*/
	@Override
	public void setLastLoginIP(java.lang.String lastLoginIP) {
		_legacyUser.setLastLoginIP(lastLoginIP);
	}

	/**
	* Returns the last failed login date of this legacy user.
	*
	* @return the last failed login date of this legacy user
	*/
	@Override
	public java.util.Date getLastFailedLoginDate() {
		return _legacyUser.getLastFailedLoginDate();
	}

	/**
	* Sets the last failed login date of this legacy user.
	*
	* @param lastFailedLoginDate the last failed login date of this legacy user
	*/
	@Override
	public void setLastFailedLoginDate(java.util.Date lastFailedLoginDate) {
		_legacyUser.setLastFailedLoginDate(lastFailedLoginDate);
	}

	/**
	* Returns the failed login attempts of this legacy user.
	*
	* @return the failed login attempts of this legacy user
	*/
	@Override
	public int getFailedLoginAttempts() {
		return _legacyUser.getFailedLoginAttempts();
	}

	/**
	* Sets the failed login attempts of this legacy user.
	*
	* @param failedLoginAttempts the failed login attempts of this legacy user
	*/
	@Override
	public void setFailedLoginAttempts(int failedLoginAttempts) {
		_legacyUser.setFailedLoginAttempts(failedLoginAttempts);
	}

	/**
	* Returns the lockout of this legacy user.
	*
	* @return the lockout of this legacy user
	*/
	@Override
	public boolean getLockout() {
		return _legacyUser.getLockout();
	}

	/**
	* Returns <code>true</code> if this legacy user is lockout.
	*
	* @return <code>true</code> if this legacy user is lockout; <code>false</code> otherwise
	*/
	@Override
	public boolean isLockout() {
		return _legacyUser.isLockout();
	}

	/**
	* Sets whether this legacy user is lockout.
	*
	* @param lockout the lockout of this legacy user
	*/
	@Override
	public void setLockout(boolean lockout) {
		_legacyUser.setLockout(lockout);
	}

	/**
	* Returns the lockout date of this legacy user.
	*
	* @return the lockout date of this legacy user
	*/
	@Override
	public java.util.Date getLockoutDate() {
		return _legacyUser.getLockoutDate();
	}

	/**
	* Sets the lockout date of this legacy user.
	*
	* @param lockoutDate the lockout date of this legacy user
	*/
	@Override
	public void setLockoutDate(java.util.Date lockoutDate) {
		_legacyUser.setLockoutDate(lockoutDate);
	}

	/**
	* Returns the agreed to terms of use of this legacy user.
	*
	* @return the agreed to terms of use of this legacy user
	*/
	@Override
	public boolean getAgreedToTermsOfUse() {
		return _legacyUser.getAgreedToTermsOfUse();
	}

	/**
	* Returns <code>true</code> if this legacy user is agreed to terms of use.
	*
	* @return <code>true</code> if this legacy user is agreed to terms of use; <code>false</code> otherwise
	*/
	@Override
	public boolean isAgreedToTermsOfUse() {
		return _legacyUser.isAgreedToTermsOfUse();
	}

	/**
	* Sets whether this legacy user is agreed to terms of use.
	*
	* @param agreedToTermsOfUse the agreed to terms of use of this legacy user
	*/
	@Override
	public void setAgreedToTermsOfUse(boolean agreedToTermsOfUse) {
		_legacyUser.setAgreedToTermsOfUse(agreedToTermsOfUse);
	}

	/**
	* Returns the active of this legacy user.
	*
	* @return the active of this legacy user
	*/
	@Override
	public boolean getActive() {
		return _legacyUser.getActive();
	}

	/**
	* Returns <code>true</code> if this legacy user is active.
	*
	* @return <code>true</code> if this legacy user is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _legacyUser.isActive();
	}

	/**
	* Sets whether this legacy user is active.
	*
	* @param active the active of this legacy user
	*/
	@Override
	public void setActive(boolean active) {
		_legacyUser.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _legacyUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyUserWrapper((LegacyUser)_legacyUser.clone());
	}

	@Override
	public int compareTo(LegacyUser legacyUser) {
		return _legacyUser.compareTo(legacyUser);
	}

	@Override
	public int hashCode() {
		return _legacyUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<LegacyUser> toCacheModel() {
		return _legacyUser.toCacheModel();
	}

	@Override
	public LegacyUser toEscapedModel() {
		return new LegacyUserWrapper(_legacyUser.toEscapedModel());
	}

	@Override
	public LegacyUser toUnescapedModel() {
		return new LegacyUserWrapper(_legacyUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyUserWrapper)) {
			return false;
		}

		LegacyUserWrapper legacyUserWrapper = (LegacyUserWrapper)obj;

		if (Validator.equals(_legacyUser, legacyUserWrapper._legacyUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyUser getWrappedLegacyUser() {
		return _legacyUser;
	}

	@Override
	public LegacyUser getWrappedModel() {
		return _legacyUser;
	}

	@Override
	public void resetOriginalValues() {
		_legacyUser.resetOriginalValues();
	}

	private LegacyUser _legacyUser;
}