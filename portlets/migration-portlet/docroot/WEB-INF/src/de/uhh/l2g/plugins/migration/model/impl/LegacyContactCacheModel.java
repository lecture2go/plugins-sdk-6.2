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

import de.uhh.l2g.plugins.migration.model.LegacyContact;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegacyContact in entity cache.
 *
 * @author unihh
 * @see LegacyContact
 * @generated
 */
public class LegacyContactCacheModel implements CacheModel<LegacyContact>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{contactId=");
		sb.append(contactId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", parentContactId=");
		sb.append(parentContactId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", prefixId=");
		sb.append(prefixId);
		sb.append(", suffixId=");
		sb.append(suffixId);
		sb.append(", male=");
		sb.append(male);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", smsSn=");
		sb.append(smsSn);
		sb.append(", aimSn=");
		sb.append(aimSn);
		sb.append(", facebookSn=");
		sb.append(facebookSn);
		sb.append(", icqSn=");
		sb.append(icqSn);
		sb.append(", jabberSn=");
		sb.append(jabberSn);
		sb.append(", msnSn=");
		sb.append(msnSn);
		sb.append(", mySpaceSn=");
		sb.append(mySpaceSn);
		sb.append(", skypeSn=");
		sb.append(skypeSn);
		sb.append(", twitterSn=");
		sb.append(twitterSn);
		sb.append(", ymSn=");
		sb.append(ymSn);
		sb.append(", employeeStatusId=");
		sb.append(employeeStatusId);
		sb.append(", employeeNumber=");
		sb.append(employeeNumber);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", jobClass=");
		sb.append(jobClass);
		sb.append(", hoursOfOperation=");
		sb.append(hoursOfOperation);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyContact toEntityModel() {
		LegacyContactImpl legacyContactImpl = new LegacyContactImpl();

		legacyContactImpl.setContactId(contactId);
		legacyContactImpl.setCompanyId(companyId);
		legacyContactImpl.setUserId(userId);

		if (userName == null) {
			legacyContactImpl.setUserName(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			legacyContactImpl.setCreateDate(null);
		}
		else {
			legacyContactImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legacyContactImpl.setModifiedDate(null);
		}
		else {
			legacyContactImpl.setModifiedDate(new Date(modifiedDate));
		}

		legacyContactImpl.setAccountId(accountId);
		legacyContactImpl.setParentContactId(parentContactId);

		if (firstName == null) {
			legacyContactImpl.setFirstName(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setFirstName(firstName);
		}

		if (middleName == null) {
			legacyContactImpl.setMiddleName(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setMiddleName(middleName);
		}

		if (lastName == null) {
			legacyContactImpl.setLastName(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setLastName(lastName);
		}

		legacyContactImpl.setPrefixId(prefixId);
		legacyContactImpl.setSuffixId(suffixId);
		legacyContactImpl.setMale(male);

		if (birthday == Long.MIN_VALUE) {
			legacyContactImpl.setBirthday(null);
		}
		else {
			legacyContactImpl.setBirthday(new Date(birthday));
		}

		if (smsSn == null) {
			legacyContactImpl.setSmsSn(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setSmsSn(smsSn);
		}

		if (aimSn == null) {
			legacyContactImpl.setAimSn(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setAimSn(aimSn);
		}

		if (facebookSn == null) {
			legacyContactImpl.setFacebookSn(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setFacebookSn(facebookSn);
		}

		if (icqSn == null) {
			legacyContactImpl.setIcqSn(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setIcqSn(icqSn);
		}

		if (jabberSn == null) {
			legacyContactImpl.setJabberSn(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setJabberSn(jabberSn);
		}

		if (msnSn == null) {
			legacyContactImpl.setMsnSn(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setMsnSn(msnSn);
		}

		if (mySpaceSn == null) {
			legacyContactImpl.setMySpaceSn(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setMySpaceSn(mySpaceSn);
		}

		if (skypeSn == null) {
			legacyContactImpl.setSkypeSn(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setSkypeSn(skypeSn);
		}

		if (twitterSn == null) {
			legacyContactImpl.setTwitterSn(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setTwitterSn(twitterSn);
		}

		if (ymSn == null) {
			legacyContactImpl.setYmSn(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setYmSn(ymSn);
		}

		if (employeeStatusId == null) {
			legacyContactImpl.setEmployeeStatusId(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setEmployeeStatusId(employeeStatusId);
		}

		if (employeeNumber == null) {
			legacyContactImpl.setEmployeeNumber(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setEmployeeNumber(employeeNumber);
		}

		if (jobTitle == null) {
			legacyContactImpl.setJobTitle(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setJobTitle(jobTitle);
		}

		if (jobClass == null) {
			legacyContactImpl.setJobClass(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setJobClass(jobClass);
		}

		if (hoursOfOperation == null) {
			legacyContactImpl.setHoursOfOperation(StringPool.BLANK);
		}
		else {
			legacyContactImpl.setHoursOfOperation(hoursOfOperation);
		}

		legacyContactImpl.resetOriginalValues();

		return legacyContactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contactId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		accountId = objectInput.readLong();
		parentContactId = objectInput.readLong();
		firstName = objectInput.readUTF();
		middleName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		prefixId = objectInput.readInt();
		suffixId = objectInput.readInt();
		male = objectInput.readBoolean();
		birthday = objectInput.readLong();
		smsSn = objectInput.readUTF();
		aimSn = objectInput.readUTF();
		facebookSn = objectInput.readUTF();
		icqSn = objectInput.readUTF();
		jabberSn = objectInput.readUTF();
		msnSn = objectInput.readUTF();
		mySpaceSn = objectInput.readUTF();
		skypeSn = objectInput.readUTF();
		twitterSn = objectInput.readUTF();
		ymSn = objectInput.readUTF();
		employeeStatusId = objectInput.readUTF();
		employeeNumber = objectInput.readUTF();
		jobTitle = objectInput.readUTF();
		jobClass = objectInput.readUTF();
		hoursOfOperation = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contactId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(accountId);
		objectOutput.writeLong(parentContactId);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (middleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(middleName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		objectOutput.writeInt(prefixId);
		objectOutput.writeInt(suffixId);
		objectOutput.writeBoolean(male);
		objectOutput.writeLong(birthday);

		if (smsSn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(smsSn);
		}

		if (aimSn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(aimSn);
		}

		if (facebookSn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(facebookSn);
		}

		if (icqSn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(icqSn);
		}

		if (jabberSn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jabberSn);
		}

		if (msnSn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(msnSn);
		}

		if (mySpaceSn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mySpaceSn);
		}

		if (skypeSn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(skypeSn);
		}

		if (twitterSn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(twitterSn);
		}

		if (ymSn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ymSn);
		}

		if (employeeStatusId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employeeStatusId);
		}

		if (employeeNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employeeNumber);
		}

		if (jobTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		if (jobClass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobClass);
		}

		if (hoursOfOperation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hoursOfOperation);
		}
	}

	public long contactId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long accountId;
	public long parentContactId;
	public String firstName;
	public String middleName;
	public String lastName;
	public int prefixId;
	public int suffixId;
	public boolean male;
	public long birthday;
	public String smsSn;
	public String aimSn;
	public String facebookSn;
	public String icqSn;
	public String jabberSn;
	public String msnSn;
	public String mySpaceSn;
	public String skypeSn;
	public String twitterSn;
	public String ymSn;
	public String employeeStatusId;
	public String employeeNumber;
	public String jobTitle;
	public String jobClass;
	public String hoursOfOperation;
}