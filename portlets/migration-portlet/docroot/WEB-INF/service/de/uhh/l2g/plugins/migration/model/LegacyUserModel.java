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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LegacyUser service. Represents a row in the &quot;User_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserImpl}.
 * </p>
 *
 * @author unihh
 * @see LegacyUser
 * @see de.uhh.l2g.plugins.migration.model.impl.LegacyUserImpl
 * @see de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl
 * @generated
 */
public interface LegacyUserModel extends BaseModel<LegacyUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a legacy user model instance should use the {@link LegacyUser} interface instead.
	 */

	/**
	 * Returns the primary key of this legacy user.
	 *
	 * @return the primary key of this legacy user
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this legacy user.
	 *
	 * @param primaryKey the primary key of this legacy user
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the user ID of this legacy user.
	 *
	 * @return the user ID of this legacy user
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this legacy user.
	 *
	 * @param userId the user ID of this legacy user
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this legacy user.
	 *
	 * @return the user uuid of this legacy user
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this legacy user.
	 *
	 * @param userUuid the user uuid of this legacy user
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the company ID of this legacy user.
	 *
	 * @return the company ID of this legacy user
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this legacy user.
	 *
	 * @param companyId the company ID of this legacy user
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this legacy user.
	 *
	 * @return the create date of this legacy user
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this legacy user.
	 *
	 * @param createDate the create date of this legacy user
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this legacy user.
	 *
	 * @return the modified date of this legacy user
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this legacy user.
	 *
	 * @param modifiedDate the modified date of this legacy user
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the default user of this legacy user.
	 *
	 * @return the default user of this legacy user
	 */
	public boolean getDefaultUser();

	/**
	 * Returns <code>true</code> if this legacy user is default user.
	 *
	 * @return <code>true</code> if this legacy user is default user; <code>false</code> otherwise
	 */
	public boolean isDefaultUser();

	/**
	 * Sets whether this legacy user is default user.
	 *
	 * @param defaultUser the default user of this legacy user
	 */
	public void setDefaultUser(boolean defaultUser);

	/**
	 * Returns the contact ID of this legacy user.
	 *
	 * @return the contact ID of this legacy user
	 */
	public long getContactId();

	/**
	 * Sets the contact ID of this legacy user.
	 *
	 * @param contactId the contact ID of this legacy user
	 */
	public void setContactId(long contactId);

	/**
	 * Returns the password of this legacy user.
	 *
	 * @return the password of this legacy user
	 */
	@AutoEscape
	public String getPassword();

	/**
	 * Sets the password of this legacy user.
	 *
	 * @param password the password of this legacy user
	 */
	public void setPassword(String password);

	/**
	 * Returns the password encrypted of this legacy user.
	 *
	 * @return the password encrypted of this legacy user
	 */
	public boolean getPasswordEncrypted();

	/**
	 * Returns <code>true</code> if this legacy user is password encrypted.
	 *
	 * @return <code>true</code> if this legacy user is password encrypted; <code>false</code> otherwise
	 */
	public boolean isPasswordEncrypted();

	/**
	 * Sets whether this legacy user is password encrypted.
	 *
	 * @param passwordEncrypted the password encrypted of this legacy user
	 */
	public void setPasswordEncrypted(boolean passwordEncrypted);

	/**
	 * Returns the password reset of this legacy user.
	 *
	 * @return the password reset of this legacy user
	 */
	public boolean getPasswordReset();

	/**
	 * Returns <code>true</code> if this legacy user is password reset.
	 *
	 * @return <code>true</code> if this legacy user is password reset; <code>false</code> otherwise
	 */
	public boolean isPasswordReset();

	/**
	 * Sets whether this legacy user is password reset.
	 *
	 * @param passwordReset the password reset of this legacy user
	 */
	public void setPasswordReset(boolean passwordReset);

	/**
	 * Returns the password modified date of this legacy user.
	 *
	 * @return the password modified date of this legacy user
	 */
	public Date getPasswordModifiedDate();

	/**
	 * Sets the password modified date of this legacy user.
	 *
	 * @param passwordModifiedDate the password modified date of this legacy user
	 */
	public void setPasswordModifiedDate(Date passwordModifiedDate);

	/**
	 * Returns the reminder query question of this legacy user.
	 *
	 * @return the reminder query question of this legacy user
	 */
	@AutoEscape
	public String getReminderQueryQuestion();

	/**
	 * Sets the reminder query question of this legacy user.
	 *
	 * @param reminderQueryQuestion the reminder query question of this legacy user
	 */
	public void setReminderQueryQuestion(String reminderQueryQuestion);

	/**
	 * Returns the reminder query answer of this legacy user.
	 *
	 * @return the reminder query answer of this legacy user
	 */
	@AutoEscape
	public String getReminderQueryAnswer();

	/**
	 * Sets the reminder query answer of this legacy user.
	 *
	 * @param reminderQueryAnswer the reminder query answer of this legacy user
	 */
	public void setReminderQueryAnswer(String reminderQueryAnswer);

	/**
	 * Returns the grace login count of this legacy user.
	 *
	 * @return the grace login count of this legacy user
	 */
	public int getGraceLoginCount();

	/**
	 * Sets the grace login count of this legacy user.
	 *
	 * @param graceLoginCount the grace login count of this legacy user
	 */
	public void setGraceLoginCount(int graceLoginCount);

	/**
	 * Returns the screen name of this legacy user.
	 *
	 * @return the screen name of this legacy user
	 */
	@AutoEscape
	public String getScreenName();

	/**
	 * Sets the screen name of this legacy user.
	 *
	 * @param screenName the screen name of this legacy user
	 */
	public void setScreenName(String screenName);

	/**
	 * Returns the email address of this legacy user.
	 *
	 * @return the email address of this legacy user
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this legacy user.
	 *
	 * @param emailAddress the email address of this legacy user
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the open ID of this legacy user.
	 *
	 * @return the open ID of this legacy user
	 */
	@AutoEscape
	public String getOpenId();

	/**
	 * Sets the open ID of this legacy user.
	 *
	 * @param openId the open ID of this legacy user
	 */
	public void setOpenId(String openId);

	/**
	 * Returns the portrait ID of this legacy user.
	 *
	 * @return the portrait ID of this legacy user
	 */
	public long getPortraitId();

	/**
	 * Sets the portrait ID of this legacy user.
	 *
	 * @param portraitId the portrait ID of this legacy user
	 */
	public void setPortraitId(long portraitId);

	/**
	 * Returns the language ID of this legacy user.
	 *
	 * @return the language ID of this legacy user
	 */
	@AutoEscape
	public String getLanguageId();

	/**
	 * Sets the language ID of this legacy user.
	 *
	 * @param languageId the language ID of this legacy user
	 */
	public void setLanguageId(String languageId);

	/**
	 * Returns the time zone ID of this legacy user.
	 *
	 * @return the time zone ID of this legacy user
	 */
	@AutoEscape
	public String getTimeZoneId();

	/**
	 * Sets the time zone ID of this legacy user.
	 *
	 * @param timeZoneId the time zone ID of this legacy user
	 */
	public void setTimeZoneId(String timeZoneId);

	/**
	 * Returns the greeting of this legacy user.
	 *
	 * @return the greeting of this legacy user
	 */
	@AutoEscape
	public String getGreeting();

	/**
	 * Sets the greeting of this legacy user.
	 *
	 * @param greeting the greeting of this legacy user
	 */
	public void setGreeting(String greeting);

	/**
	 * Returns the comments of this legacy user.
	 *
	 * @return the comments of this legacy user
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this legacy user.
	 *
	 * @param comments the comments of this legacy user
	 */
	public void setComments(String comments);

	/**
	 * Returns the login date of this legacy user.
	 *
	 * @return the login date of this legacy user
	 */
	public Date getLoginDate();

	/**
	 * Sets the login date of this legacy user.
	 *
	 * @param loginDate the login date of this legacy user
	 */
	public void setLoginDate(Date loginDate);

	/**
	 * Returns the login i p of this legacy user.
	 *
	 * @return the login i p of this legacy user
	 */
	@AutoEscape
	public String getLoginIP();

	/**
	 * Sets the login i p of this legacy user.
	 *
	 * @param loginIP the login i p of this legacy user
	 */
	public void setLoginIP(String loginIP);

	/**
	 * Returns the last login date of this legacy user.
	 *
	 * @return the last login date of this legacy user
	 */
	public Date getLastLoginDate();

	/**
	 * Sets the last login date of this legacy user.
	 *
	 * @param lastLoginDate the last login date of this legacy user
	 */
	public void setLastLoginDate(Date lastLoginDate);

	/**
	 * Returns the last login i p of this legacy user.
	 *
	 * @return the last login i p of this legacy user
	 */
	@AutoEscape
	public String getLastLoginIP();

	/**
	 * Sets the last login i p of this legacy user.
	 *
	 * @param lastLoginIP the last login i p of this legacy user
	 */
	public void setLastLoginIP(String lastLoginIP);

	/**
	 * Returns the last failed login date of this legacy user.
	 *
	 * @return the last failed login date of this legacy user
	 */
	public Date getLastFailedLoginDate();

	/**
	 * Sets the last failed login date of this legacy user.
	 *
	 * @param lastFailedLoginDate the last failed login date of this legacy user
	 */
	public void setLastFailedLoginDate(Date lastFailedLoginDate);

	/**
	 * Returns the failed login attempts of this legacy user.
	 *
	 * @return the failed login attempts of this legacy user
	 */
	public int getFailedLoginAttempts();

	/**
	 * Sets the failed login attempts of this legacy user.
	 *
	 * @param failedLoginAttempts the failed login attempts of this legacy user
	 */
	public void setFailedLoginAttempts(int failedLoginAttempts);

	/**
	 * Returns the lockout of this legacy user.
	 *
	 * @return the lockout of this legacy user
	 */
	public boolean getLockout();

	/**
	 * Returns <code>true</code> if this legacy user is lockout.
	 *
	 * @return <code>true</code> if this legacy user is lockout; <code>false</code> otherwise
	 */
	public boolean isLockout();

	/**
	 * Sets whether this legacy user is lockout.
	 *
	 * @param lockout the lockout of this legacy user
	 */
	public void setLockout(boolean lockout);

	/**
	 * Returns the lockout date of this legacy user.
	 *
	 * @return the lockout date of this legacy user
	 */
	public Date getLockoutDate();

	/**
	 * Sets the lockout date of this legacy user.
	 *
	 * @param lockoutDate the lockout date of this legacy user
	 */
	public void setLockoutDate(Date lockoutDate);

	/**
	 * Returns the agreed to terms of use of this legacy user.
	 *
	 * @return the agreed to terms of use of this legacy user
	 */
	public boolean getAgreedToTermsOfUse();

	/**
	 * Returns <code>true</code> if this legacy user is agreed to terms of use.
	 *
	 * @return <code>true</code> if this legacy user is agreed to terms of use; <code>false</code> otherwise
	 */
	public boolean isAgreedToTermsOfUse();

	/**
	 * Sets whether this legacy user is agreed to terms of use.
	 *
	 * @param agreedToTermsOfUse the agreed to terms of use of this legacy user
	 */
	public void setAgreedToTermsOfUse(boolean agreedToTermsOfUse);

	/**
	 * Returns the active of this legacy user.
	 *
	 * @return the active of this legacy user
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this legacy user is active.
	 *
	 * @return <code>true</code> if this legacy user is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this legacy user is active.
	 *
	 * @param active the active of this legacy user
	 */
	public void setActive(boolean active);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(LegacyUser legacyUser);

	@Override
	public int hashCode();

	@Override
	public CacheModel<LegacyUser> toCacheModel();

	@Override
	public LegacyUser toEscapedModel();

	@Override
	public LegacyUser toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}