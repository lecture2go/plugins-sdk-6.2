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

import de.uhh.l2g.plugins.migration.model.LegacyAddress;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegacyAddress in entity cache.
 *
 * @author unihh
 * @see LegacyAddress
 * @generated
 */
public class LegacyAddressCacheModel implements CacheModel<LegacyAddress>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{addressId=");
		sb.append(addressId);
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
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", street1=");
		sb.append(street1);
		sb.append(", street2=");
		sb.append(street2);
		sb.append(", street3=");
		sb.append(street3);
		sb.append(", city=");
		sb.append(city);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", mailing=");
		sb.append(mailing);
		sb.append(", primary=");
		sb.append(primary);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyAddress toEntityModel() {
		LegacyAddressImpl legacyAddressImpl = new LegacyAddressImpl();

		legacyAddressImpl.setAddressId(addressId);
		legacyAddressImpl.setCompanyId(companyId);
		legacyAddressImpl.setUserId(userId);

		if (userName == null) {
			legacyAddressImpl.setUserName(StringPool.BLANK);
		}
		else {
			legacyAddressImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			legacyAddressImpl.setCreateDate(null);
		}
		else {
			legacyAddressImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legacyAddressImpl.setModifiedDate(null);
		}
		else {
			legacyAddressImpl.setModifiedDate(new Date(modifiedDate));
		}

		legacyAddressImpl.setClassNameId(classNameId);
		legacyAddressImpl.setClassPK(classPK);

		if (street1 == null) {
			legacyAddressImpl.setStreet1(StringPool.BLANK);
		}
		else {
			legacyAddressImpl.setStreet1(street1);
		}

		if (street2 == null) {
			legacyAddressImpl.setStreet2(StringPool.BLANK);
		}
		else {
			legacyAddressImpl.setStreet2(street2);
		}

		if (street3 == null) {
			legacyAddressImpl.setStreet3(StringPool.BLANK);
		}
		else {
			legacyAddressImpl.setStreet3(street3);
		}

		if (city == null) {
			legacyAddressImpl.setCity(StringPool.BLANK);
		}
		else {
			legacyAddressImpl.setCity(city);
		}

		if (zip == null) {
			legacyAddressImpl.setZip(StringPool.BLANK);
		}
		else {
			legacyAddressImpl.setZip(zip);
		}

		legacyAddressImpl.setRegionId(regionId);
		legacyAddressImpl.setCountryId(countryId);
		legacyAddressImpl.setTypeId(typeId);
		legacyAddressImpl.setMailing(mailing);
		legacyAddressImpl.setPrimary(primary);

		legacyAddressImpl.resetOriginalValues();

		return legacyAddressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
		street1 = objectInput.readUTF();
		street2 = objectInput.readUTF();
		street3 = objectInput.readUTF();
		city = objectInput.readUTF();
		zip = objectInput.readUTF();
		regionId = objectInput.readLong();
		countryId = objectInput.readLong();
		typeId = objectInput.readInt();
		mailing = objectInput.readBoolean();
		primary = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(addressId);
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
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);

		if (street1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street1);
		}

		if (street2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street2);
		}

		if (street3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street3);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (zip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zip);
		}

		objectOutput.writeLong(regionId);
		objectOutput.writeLong(countryId);
		objectOutput.writeInt(typeId);
		objectOutput.writeBoolean(mailing);
		objectOutput.writeBoolean(primary);
	}

	public long addressId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long classNameId;
	public long classPK;
	public String street1;
	public String street2;
	public String street3;
	public String city;
	public String zip;
	public long regionId;
	public long countryId;
	public int typeId;
	public boolean mailing;
	public boolean primary;
}