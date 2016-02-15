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

package de.uhh.l2g.plugins.migration.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.migration.model.LegacyUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegacyUser in entity cache.
 *
 * @author unihh
 * @see LegacyUser
 * @generated
 */
public class LegacyUserCacheModel implements CacheModel<LegacyUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", defaultUser=");
		sb.append(defaultUser);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", password=");
		sb.append(password);
		sb.append(", passwordEncrypted=");
		sb.append(passwordEncrypted);
		sb.append(", passwordReset=");
		sb.append(passwordReset);
		sb.append(", passwordModifiedDate=");
		sb.append(passwordModifiedDate);
		sb.append(", reminderQueryQuestion=");
		sb.append(reminderQueryQuestion);
		sb.append(", reminderQueryAnswer=");
		sb.append(reminderQueryAnswer);
		sb.append(", graceLoginCount=");
		sb.append(graceLoginCount);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", openId=");
		sb.append(openId);
		sb.append(", portraitId=");
		sb.append(portraitId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", timeZoneId=");
		sb.append(timeZoneId);
		sb.append(", greeting=");
		sb.append(greeting);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", loginDate=");
		sb.append(loginDate);
		sb.append(", loginIP=");
		sb.append(loginIP);
		sb.append(", lastLoginDate=");
		sb.append(lastLoginDate);
		sb.append(", lastLoginIP=");
		sb.append(lastLoginIP);
		sb.append(", lastFailedLoginDate=");
		sb.append(lastFailedLoginDate);
		sb.append(", failedLoginAttempts=");
		sb.append(failedLoginAttempts);
		sb.append(", lockout=");
		sb.append(lockout);
		sb.append(", lockoutDate=");
		sb.append(lockoutDate);
		sb.append(", agreedToTermsOfUse=");
		sb.append(agreedToTermsOfUse);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyUser toEntityModel() {
		LegacyUserImpl legacyUserImpl = new LegacyUserImpl();

		legacyUserImpl.setUserId(userId);
		legacyUserImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			legacyUserImpl.setCreateDate(null);
		}
		else {
			legacyUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legacyUserImpl.setModifiedDate(null);
		}
		else {
			legacyUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		legacyUserImpl.setDefaultUser(defaultUser);
		legacyUserImpl.setContactId(contactId);

		if (password == null) {
			legacyUserImpl.setPassword(StringPool.BLANK);
		}
		else {
			legacyUserImpl.setPassword(password);
		}

		legacyUserImpl.setPasswordEncrypted(passwordEncrypted);
		legacyUserImpl.setPasswordReset(passwordReset);

		if (passwordModifiedDate == Long.MIN_VALUE) {
			legacyUserImpl.setPasswordModifiedDate(null);
		}
		else {
			legacyUserImpl.setPasswordModifiedDate(new Date(
					passwordModifiedDate));
		}

		if (reminderQueryQuestion == null) {
			legacyUserImpl.setReminderQueryQuestion(StringPool.BLANK);
		}
		else {
			legacyUserImpl.setReminderQueryQuestion(reminderQueryQuestion);
		}

		if (reminderQueryAnswer == null) {
			legacyUserImpl.setReminderQueryAnswer(StringPool.BLANK);
		}
		else {
			legacyUserImpl.setReminderQueryAnswer(reminderQueryAnswer);
		}

		legacyUserImpl.setGraceLoginCount(graceLoginCount);

		if (screenName == null) {
			legacyUserImpl.setScreenName(StringPool.BLANK);
		}
		else {
			legacyUserImpl.setScreenName(screenName);
		}

		if (emailAddress == null) {
			legacyUserImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			legacyUserImpl.setEmailAddress(emailAddress);
		}

		if (openId == null) {
			legacyUserImpl.setOpenId(StringPool.BLANK);
		}
		else {
			legacyUserImpl.setOpenId(openId);
		}

		legacyUserImpl.setPortraitId(portraitId);

		if (languageId == null) {
			legacyUserImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			legacyUserImpl.setLanguageId(languageId);
		}

		if (timeZoneId == null) {
			legacyUserImpl.setTimeZoneId(StringPool.BLANK);
		}
		else {
			legacyUserImpl.setTimeZoneId(timeZoneId);
		}

		if (greeting == null) {
			legacyUserImpl.setGreeting(StringPool.BLANK);
		}
		else {
			legacyUserImpl.setGreeting(greeting);
		}

		if (comments == null) {
			legacyUserImpl.setComments(StringPool.BLANK);
		}
		else {
			legacyUserImpl.setComments(comments);
		}

		if (loginDate == Long.MIN_VALUE) {
			legacyUserImpl.setLoginDate(null);
		}
		else {
			legacyUserImpl.setLoginDate(new Date(loginDate));
		}

		if (loginIP == null) {
			legacyUserImpl.setLoginIP(StringPool.BLANK);
		}
		else {
			legacyUserImpl.setLoginIP(loginIP);
		}

		if (lastLoginDate == Long.MIN_VALUE) {
			legacyUserImpl.setLastLoginDate(null);
		}
		else {
			legacyUserImpl.setLastLoginDate(new Date(lastLoginDate));
		}

		if (lastLoginIP == null) {
			legacyUserImpl.setLastLoginIP(StringPool.BLANK);
		}
		else {
			legacyUserImpl.setLastLoginIP(lastLoginIP);
		}

		if (lastFailedLoginDate == Long.MIN_VALUE) {
			legacyUserImpl.setLastFailedLoginDate(null);
		}
		else {
			legacyUserImpl.setLastFailedLoginDate(new Date(lastFailedLoginDate));
		}

		legacyUserImpl.setFailedLoginAttempts(failedLoginAttempts);
		legacyUserImpl.setLockout(lockout);

		if (lockoutDate == Long.MIN_VALUE) {
			legacyUserImpl.setLockoutDate(null);
		}
		else {
			legacyUserImpl.setLockoutDate(new Date(lockoutDate));
		}

		legacyUserImpl.setAgreedToTermsOfUse(agreedToTermsOfUse);
		legacyUserImpl.setActive(active);

		legacyUserImpl.resetOriginalValues();

		return legacyUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		defaultUser = objectInput.readBoolean();
		contactId = objectInput.readLong();
		password = objectInput.readUTF();
		passwordEncrypted = objectInput.readBoolean();
		passwordReset = objectInput.readBoolean();
		passwordModifiedDate = objectInput.readLong();
		reminderQueryQuestion = objectInput.readUTF();
		reminderQueryAnswer = objectInput.readUTF();
		graceLoginCount = objectInput.readInt();
		screenName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		openId = objectInput.readUTF();
		portraitId = objectInput.readLong();
		languageId = objectInput.readUTF();
		timeZoneId = objectInput.readUTF();
		greeting = objectInput.readUTF();
		comments = objectInput.readUTF();
		loginDate = objectInput.readLong();
		loginIP = objectInput.readUTF();
		lastLoginDate = objectInput.readLong();
		lastLoginIP = objectInput.readUTF();
		lastFailedLoginDate = objectInput.readLong();
		failedLoginAttempts = objectInput.readInt();
		lockout = objectInput.readBoolean();
		lockoutDate = objectInput.readLong();
		agreedToTermsOfUse = objectInput.readBoolean();
		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeBoolean(defaultUser);
		objectOutput.writeLong(contactId);

		if (password == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(password);
		}

		objectOutput.writeBoolean(passwordEncrypted);
		objectOutput.writeBoolean(passwordReset);
		objectOutput.writeLong(passwordModifiedDate);

		if (reminderQueryQuestion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reminderQueryQuestion);
		}

		if (reminderQueryAnswer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reminderQueryAnswer);
		}

		objectOutput.writeInt(graceLoginCount);

		if (screenName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screenName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (openId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(openId);
		}

		objectOutput.writeLong(portraitId);

		if (languageId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageId);
		}

		if (timeZoneId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(timeZoneId);
		}

		if (greeting == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(greeting);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeLong(loginDate);

		if (loginIP == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(loginIP);
		}

		objectOutput.writeLong(lastLoginDate);

		if (lastLoginIP == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastLoginIP);
		}

		objectOutput.writeLong(lastFailedLoginDate);
		objectOutput.writeInt(failedLoginAttempts);
		objectOutput.writeBoolean(lockout);
		objectOutput.writeLong(lockoutDate);
		objectOutput.writeBoolean(agreedToTermsOfUse);
		objectOutput.writeBoolean(active);
	}

	public long userId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public boolean defaultUser;
	public long contactId;
	public String password;
	public boolean passwordEncrypted;
	public boolean passwordReset;
	public long passwordModifiedDate;
	public String reminderQueryQuestion;
	public String reminderQueryAnswer;
	public int graceLoginCount;
	public String screenName;
	public String emailAddress;
	public String openId;
	public long portraitId;
	public String languageId;
	public String timeZoneId;
	public String greeting;
	public String comments;
	public long loginDate;
	public String loginIP;
	public long lastLoginDate;
	public String lastLoginIP;
	public long lastFailedLoginDate;
	public int failedLoginAttempts;
	public boolean lockout;
	public long lockoutDate;
	public boolean agreedToTermsOfUse;
	public boolean active;
}