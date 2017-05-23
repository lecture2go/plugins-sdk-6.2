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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author unihh
 * @generated
 */
public class LegacyUserSoap implements Serializable {
	public static LegacyUserSoap toSoapModel(LegacyUser model) {
		LegacyUserSoap soapModel = new LegacyUserSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDefaultUser(model.getDefaultUser());
		soapModel.setContactId(model.getContactId());
		soapModel.setPassword(model.getPassword());
		soapModel.setPasswordEncrypted(model.getPasswordEncrypted());
		soapModel.setPasswordReset(model.getPasswordReset());
		soapModel.setPasswordModifiedDate(model.getPasswordModifiedDate());
		soapModel.setReminderQueryQuestion(model.getReminderQueryQuestion());
		soapModel.setReminderQueryAnswer(model.getReminderQueryAnswer());
		soapModel.setGraceLoginCount(model.getGraceLoginCount());
		soapModel.setScreenName(model.getScreenName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setOpenId(model.getOpenId());
		soapModel.setPortraitId(model.getPortraitId());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setTimeZoneId(model.getTimeZoneId());
		soapModel.setGreeting(model.getGreeting());
		soapModel.setComments(model.getComments());
		soapModel.setLoginDate(model.getLoginDate());
		soapModel.setLoginIP(model.getLoginIP());
		soapModel.setLastLoginDate(model.getLastLoginDate());
		soapModel.setLastLoginIP(model.getLastLoginIP());
		soapModel.setLastFailedLoginDate(model.getLastFailedLoginDate());
		soapModel.setFailedLoginAttempts(model.getFailedLoginAttempts());
		soapModel.setLockout(model.getLockout());
		soapModel.setLockoutDate(model.getLockoutDate());
		soapModel.setAgreedToTermsOfUse(model.getAgreedToTermsOfUse());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static LegacyUserSoap[] toSoapModels(LegacyUser[] models) {
		LegacyUserSoap[] soapModels = new LegacyUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyUserSoap[][] toSoapModels(LegacyUser[][] models) {
		LegacyUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyUserSoap[] toSoapModels(List<LegacyUser> models) {
		List<LegacyUserSoap> soapModels = new ArrayList<LegacyUserSoap>(models.size());

		for (LegacyUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyUserSoap[soapModels.size()]);
	}

	public LegacyUserSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getDefaultUser() {
		return _defaultUser;
	}

	public boolean isDefaultUser() {
		return _defaultUser;
	}

	public void setDefaultUser(boolean defaultUser) {
		_defaultUser = defaultUser;
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public boolean getPasswordEncrypted() {
		return _passwordEncrypted;
	}

	public boolean isPasswordEncrypted() {
		return _passwordEncrypted;
	}

	public void setPasswordEncrypted(boolean passwordEncrypted) {
		_passwordEncrypted = passwordEncrypted;
	}

	public boolean getPasswordReset() {
		return _passwordReset;
	}

	public boolean isPasswordReset() {
		return _passwordReset;
	}

	public void setPasswordReset(boolean passwordReset) {
		_passwordReset = passwordReset;
	}

	public Date getPasswordModifiedDate() {
		return _passwordModifiedDate;
	}

	public void setPasswordModifiedDate(Date passwordModifiedDate) {
		_passwordModifiedDate = passwordModifiedDate;
	}

	public String getReminderQueryQuestion() {
		return _reminderQueryQuestion;
	}

	public void setReminderQueryQuestion(String reminderQueryQuestion) {
		_reminderQueryQuestion = reminderQueryQuestion;
	}

	public String getReminderQueryAnswer() {
		return _reminderQueryAnswer;
	}

	public void setReminderQueryAnswer(String reminderQueryAnswer) {
		_reminderQueryAnswer = reminderQueryAnswer;
	}

	public int getGraceLoginCount() {
		return _graceLoginCount;
	}

	public void setGraceLoginCount(int graceLoginCount) {
		_graceLoginCount = graceLoginCount;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getOpenId() {
		return _openId;
	}

	public void setOpenId(String openId) {
		_openId = openId;
	}

	public long getPortraitId() {
		return _portraitId;
	}

	public void setPortraitId(long portraitId) {
		_portraitId = portraitId;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public String getTimeZoneId() {
		return _timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId) {
		_timeZoneId = timeZoneId;
	}

	public String getGreeting() {
		return _greeting;
	}

	public void setGreeting(String greeting) {
		_greeting = greeting;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public Date getLoginDate() {
		return _loginDate;
	}

	public void setLoginDate(Date loginDate) {
		_loginDate = loginDate;
	}

	public String getLoginIP() {
		return _loginIP;
	}

	public void setLoginIP(String loginIP) {
		_loginIP = loginIP;
	}

	public Date getLastLoginDate() {
		return _lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		_lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIP() {
		return _lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		_lastLoginIP = lastLoginIP;
	}

	public Date getLastFailedLoginDate() {
		return _lastFailedLoginDate;
	}

	public void setLastFailedLoginDate(Date lastFailedLoginDate) {
		_lastFailedLoginDate = lastFailedLoginDate;
	}

	public int getFailedLoginAttempts() {
		return _failedLoginAttempts;
	}

	public void setFailedLoginAttempts(int failedLoginAttempts) {
		_failedLoginAttempts = failedLoginAttempts;
	}

	public boolean getLockout() {
		return _lockout;
	}

	public boolean isLockout() {
		return _lockout;
	}

	public void setLockout(boolean lockout) {
		_lockout = lockout;
	}

	public Date getLockoutDate() {
		return _lockoutDate;
	}

	public void setLockoutDate(Date lockoutDate) {
		_lockoutDate = lockoutDate;
	}

	public boolean getAgreedToTermsOfUse() {
		return _agreedToTermsOfUse;
	}

	public boolean isAgreedToTermsOfUse() {
		return _agreedToTermsOfUse;
	}

	public void setAgreedToTermsOfUse(boolean agreedToTermsOfUse) {
		_agreedToTermsOfUse = agreedToTermsOfUse;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _userId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _defaultUser;
	private long _contactId;
	private String _password;
	private boolean _passwordEncrypted;
	private boolean _passwordReset;
	private Date _passwordModifiedDate;
	private String _reminderQueryQuestion;
	private String _reminderQueryAnswer;
	private int _graceLoginCount;
	private String _screenName;
	private String _emailAddress;
	private String _openId;
	private long _portraitId;
	private String _languageId;
	private String _timeZoneId;
	private String _greeting;
	private String _comments;
	private Date _loginDate;
	private String _loginIP;
	private Date _lastLoginDate;
	private String _lastLoginIP;
	private Date _lastFailedLoginDate;
	private int _failedLoginAttempts;
	private boolean _lockout;
	private Date _lockoutDate;
	private boolean _agreedToTermsOfUse;
	private boolean _active;
}