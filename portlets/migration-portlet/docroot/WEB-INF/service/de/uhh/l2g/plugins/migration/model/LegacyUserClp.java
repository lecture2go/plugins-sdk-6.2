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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import de.uhh.l2g.plugins.migration.service.ClpSerializer;
import de.uhh.l2g.plugins.migration.service.LegacyUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyUserClp extends BaseModelImpl<LegacyUser>
	implements LegacyUser {
	public LegacyUserClp() {
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
	public long getPrimaryKey() {
		return _userId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_legacyUserRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_legacyUserRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_legacyUserRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_legacyUserRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDefaultUser() {
		return _defaultUser;
	}

	@Override
	public boolean isDefaultUser() {
		return _defaultUser;
	}

	@Override
	public void setDefaultUser(boolean defaultUser) {
		_defaultUser = defaultUser;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setDefaultUser", boolean.class);

				method.invoke(_legacyUserRemoteModel, defaultUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactId() {
		return _contactId;
	}

	@Override
	public void setContactId(long contactId) {
		_contactId = contactId;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setContactId", long.class);

				method.invoke(_legacyUserRemoteModel, contactId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPassword() {
		return _password;
	}

	@Override
	public void setPassword(String password) {
		_password = password;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPassword", String.class);

				method.invoke(_legacyUserRemoteModel, password);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPasswordEncrypted() {
		return _passwordEncrypted;
	}

	@Override
	public boolean isPasswordEncrypted() {
		return _passwordEncrypted;
	}

	@Override
	public void setPasswordEncrypted(boolean passwordEncrypted) {
		_passwordEncrypted = passwordEncrypted;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPasswordEncrypted",
						boolean.class);

				method.invoke(_legacyUserRemoteModel, passwordEncrypted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPasswordReset() {
		return _passwordReset;
	}

	@Override
	public boolean isPasswordReset() {
		return _passwordReset;
	}

	@Override
	public void setPasswordReset(boolean passwordReset) {
		_passwordReset = passwordReset;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPasswordReset",
						boolean.class);

				method.invoke(_legacyUserRemoteModel, passwordReset);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPasswordModifiedDate() {
		return _passwordModifiedDate;
	}

	@Override
	public void setPasswordModifiedDate(Date passwordModifiedDate) {
		_passwordModifiedDate = passwordModifiedDate;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPasswordModifiedDate",
						Date.class);

				method.invoke(_legacyUserRemoteModel, passwordModifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReminderQueryQuestion() {
		return _reminderQueryQuestion;
	}

	@Override
	public void setReminderQueryQuestion(String reminderQueryQuestion) {
		_reminderQueryQuestion = reminderQueryQuestion;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setReminderQueryQuestion",
						String.class);

				method.invoke(_legacyUserRemoteModel, reminderQueryQuestion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReminderQueryAnswer() {
		return _reminderQueryAnswer;
	}

	@Override
	public void setReminderQueryAnswer(String reminderQueryAnswer) {
		_reminderQueryAnswer = reminderQueryAnswer;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setReminderQueryAnswer",
						String.class);

				method.invoke(_legacyUserRemoteModel, reminderQueryAnswer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGraceLoginCount() {
		return _graceLoginCount;
	}

	@Override
	public void setGraceLoginCount(int graceLoginCount) {
		_graceLoginCount = graceLoginCount;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setGraceLoginCount", int.class);

				method.invoke(_legacyUserRemoteModel, graceLoginCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getScreenName() {
		return _screenName;
	}

	@Override
	public void setScreenName(String screenName) {
		_screenName = screenName;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setScreenName", String.class);

				method.invoke(_legacyUserRemoteModel, screenName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_legacyUserRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOpenId() {
		return _openId;
	}

	@Override
	public void setOpenId(String openId) {
		_openId = openId;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setOpenId", String.class);

				method.invoke(_legacyUserRemoteModel, openId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPortraitId() {
		return _portraitId;
	}

	@Override
	public void setPortraitId(long portraitId) {
		_portraitId = portraitId;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPortraitId", long.class);

				method.invoke(_legacyUserRemoteModel, portraitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLanguageId() {
		return _languageId;
	}

	@Override
	public void setLanguageId(String languageId) {
		_languageId = languageId;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageId", String.class);

				method.invoke(_legacyUserRemoteModel, languageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTimeZoneId() {
		return _timeZoneId;
	}

	@Override
	public void setTimeZoneId(String timeZoneId) {
		_timeZoneId = timeZoneId;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setTimeZoneId", String.class);

				method.invoke(_legacyUserRemoteModel, timeZoneId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGreeting() {
		return _greeting;
	}

	@Override
	public void setGreeting(String greeting) {
		_greeting = greeting;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setGreeting", String.class);

				method.invoke(_legacyUserRemoteModel, greeting);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _comments;
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_legacyUserRemoteModel, comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLoginDate() {
		return _loginDate;
	}

	@Override
	public void setLoginDate(Date loginDate) {
		_loginDate = loginDate;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLoginDate", Date.class);

				method.invoke(_legacyUserRemoteModel, loginDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLoginIP() {
		return _loginIP;
	}

	@Override
	public void setLoginIP(String loginIP) {
		_loginIP = loginIP;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLoginIP", String.class);

				method.invoke(_legacyUserRemoteModel, loginIP);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastLoginDate() {
		return _lastLoginDate;
	}

	@Override
	public void setLastLoginDate(Date lastLoginDate) {
		_lastLoginDate = lastLoginDate;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLastLoginDate", Date.class);

				method.invoke(_legacyUserRemoteModel, lastLoginDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastLoginIP() {
		return _lastLoginIP;
	}

	@Override
	public void setLastLoginIP(String lastLoginIP) {
		_lastLoginIP = lastLoginIP;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLastLoginIP", String.class);

				method.invoke(_legacyUserRemoteModel, lastLoginIP);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastFailedLoginDate() {
		return _lastFailedLoginDate;
	}

	@Override
	public void setLastFailedLoginDate(Date lastFailedLoginDate) {
		_lastFailedLoginDate = lastFailedLoginDate;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLastFailedLoginDate",
						Date.class);

				method.invoke(_legacyUserRemoteModel, lastFailedLoginDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFailedLoginAttempts() {
		return _failedLoginAttempts;
	}

	@Override
	public void setFailedLoginAttempts(int failedLoginAttempts) {
		_failedLoginAttempts = failedLoginAttempts;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setFailedLoginAttempts",
						int.class);

				method.invoke(_legacyUserRemoteModel, failedLoginAttempts);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLockout() {
		return _lockout;
	}

	@Override
	public boolean isLockout() {
		return _lockout;
	}

	@Override
	public void setLockout(boolean lockout) {
		_lockout = lockout;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLockout", boolean.class);

				method.invoke(_legacyUserRemoteModel, lockout);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLockoutDate() {
		return _lockoutDate;
	}

	@Override
	public void setLockoutDate(Date lockoutDate) {
		_lockoutDate = lockoutDate;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLockoutDate", Date.class);

				method.invoke(_legacyUserRemoteModel, lockoutDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAgreedToTermsOfUse() {
		return _agreedToTermsOfUse;
	}

	@Override
	public boolean isAgreedToTermsOfUse() {
		return _agreedToTermsOfUse;
	}

	@Override
	public void setAgreedToTermsOfUse(boolean agreedToTermsOfUse) {
		_agreedToTermsOfUse = agreedToTermsOfUse;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setAgreedToTermsOfUse",
						boolean.class);

				method.invoke(_legacyUserRemoteModel, agreedToTermsOfUse);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_legacyUserRemoteModel != null) {
			try {
				Class<?> clazz = _legacyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_legacyUserRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyUserRemoteModel() {
		return _legacyUserRemoteModel;
	}

	public void setLegacyUserRemoteModel(BaseModel<?> legacyUserRemoteModel) {
		_legacyUserRemoteModel = legacyUserRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _legacyUserRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_legacyUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyUserLocalServiceUtil.addLegacyUser(this);
		}
		else {
			LegacyUserLocalServiceUtil.updateLegacyUser(this);
		}
	}

	@Override
	public LegacyUser toEscapedModel() {
		return (LegacyUser)ProxyUtil.newProxyInstance(LegacyUser.class.getClassLoader(),
			new Class[] { LegacyUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyUserClp clone = new LegacyUserClp();

		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDefaultUser(getDefaultUser());
		clone.setContactId(getContactId());
		clone.setPassword(getPassword());
		clone.setPasswordEncrypted(getPasswordEncrypted());
		clone.setPasswordReset(getPasswordReset());
		clone.setPasswordModifiedDate(getPasswordModifiedDate());
		clone.setReminderQueryQuestion(getReminderQueryQuestion());
		clone.setReminderQueryAnswer(getReminderQueryAnswer());
		clone.setGraceLoginCount(getGraceLoginCount());
		clone.setScreenName(getScreenName());
		clone.setEmailAddress(getEmailAddress());
		clone.setOpenId(getOpenId());
		clone.setPortraitId(getPortraitId());
		clone.setLanguageId(getLanguageId());
		clone.setTimeZoneId(getTimeZoneId());
		clone.setGreeting(getGreeting());
		clone.setComments(getComments());
		clone.setLoginDate(getLoginDate());
		clone.setLoginIP(getLoginIP());
		clone.setLastLoginDate(getLastLoginDate());
		clone.setLastLoginIP(getLastLoginIP());
		clone.setLastFailedLoginDate(getLastFailedLoginDate());
		clone.setFailedLoginAttempts(getFailedLoginAttempts());
		clone.setLockout(getLockout());
		clone.setLockoutDate(getLockoutDate());
		clone.setAgreedToTermsOfUse(getAgreedToTermsOfUse());
		clone.setActive(getActive());

		return clone;
	}

	@Override
	public int compareTo(LegacyUser legacyUser) {
		long primaryKey = legacyUser.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyUserClp)) {
			return false;
		}

		LegacyUserClp legacyUser = (LegacyUserClp)obj;

		long primaryKey = legacyUser.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", defaultUser=");
		sb.append(getDefaultUser());
		sb.append(", contactId=");
		sb.append(getContactId());
		sb.append(", password=");
		sb.append(getPassword());
		sb.append(", passwordEncrypted=");
		sb.append(getPasswordEncrypted());
		sb.append(", passwordReset=");
		sb.append(getPasswordReset());
		sb.append(", passwordModifiedDate=");
		sb.append(getPasswordModifiedDate());
		sb.append(", reminderQueryQuestion=");
		sb.append(getReminderQueryQuestion());
		sb.append(", reminderQueryAnswer=");
		sb.append(getReminderQueryAnswer());
		sb.append(", graceLoginCount=");
		sb.append(getGraceLoginCount());
		sb.append(", screenName=");
		sb.append(getScreenName());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", openId=");
		sb.append(getOpenId());
		sb.append(", portraitId=");
		sb.append(getPortraitId());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", timeZoneId=");
		sb.append(getTimeZoneId());
		sb.append(", greeting=");
		sb.append(getGreeting());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", loginDate=");
		sb.append(getLoginDate());
		sb.append(", loginIP=");
		sb.append(getLoginIP());
		sb.append(", lastLoginDate=");
		sb.append(getLastLoginDate());
		sb.append(", lastLoginIP=");
		sb.append(getLastLoginIP());
		sb.append(", lastFailedLoginDate=");
		sb.append(getLastFailedLoginDate());
		sb.append(", failedLoginAttempts=");
		sb.append(getFailedLoginAttempts());
		sb.append(", lockout=");
		sb.append(getLockout());
		sb.append(", lockoutDate=");
		sb.append(getLockoutDate());
		sb.append(", agreedToTermsOfUse=");
		sb.append(getAgreedToTermsOfUse());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(97);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultUser</column-name><column-value><![CDATA[");
		sb.append(getDefaultUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>password</column-name><column-value><![CDATA[");
		sb.append(getPassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passwordEncrypted</column-name><column-value><![CDATA[");
		sb.append(getPasswordEncrypted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passwordReset</column-name><column-value><![CDATA[");
		sb.append(getPasswordReset());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passwordModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getPasswordModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reminderQueryQuestion</column-name><column-value><![CDATA[");
		sb.append(getReminderQueryQuestion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reminderQueryAnswer</column-name><column-value><![CDATA[");
		sb.append(getReminderQueryAnswer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>graceLoginCount</column-name><column-value><![CDATA[");
		sb.append(getGraceLoginCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>screenName</column-name><column-value><![CDATA[");
		sb.append(getScreenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>openId</column-name><column-value><![CDATA[");
		sb.append(getOpenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portraitId</column-name><column-value><![CDATA[");
		sb.append(getPortraitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeZoneId</column-name><column-value><![CDATA[");
		sb.append(getTimeZoneId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>greeting</column-name><column-value><![CDATA[");
		sb.append(getGreeting());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loginDate</column-name><column-value><![CDATA[");
		sb.append(getLoginDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loginIP</column-name><column-value><![CDATA[");
		sb.append(getLoginIP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastLoginDate</column-name><column-value><![CDATA[");
		sb.append(getLastLoginDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastLoginIP</column-name><column-value><![CDATA[");
		sb.append(getLastLoginIP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastFailedLoginDate</column-name><column-value><![CDATA[");
		sb.append(getLastFailedLoginDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>failedLoginAttempts</column-name><column-value><![CDATA[");
		sb.append(getFailedLoginAttempts());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lockout</column-name><column-value><![CDATA[");
		sb.append(getLockout());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lockoutDate</column-name><column-value><![CDATA[");
		sb.append(getLockoutDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agreedToTermsOfUse</column-name><column-value><![CDATA[");
		sb.append(getAgreedToTermsOfUse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _legacyUserRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}