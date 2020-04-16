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

package de.uhh.l2g.plugins.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.model.Creator;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Creator in entity cache.
 *
 * @author Iavor Sturm
 * @see Creator
 * @generated
 */
public class CreatorCacheModel implements CacheModel<Creator>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{creatorId=");
		sb.append(creatorId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", affiliation=");
		sb.append(affiliation);
		sb.append(", orcidId=");
		sb.append(orcidId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Creator toEntityModel() {
		CreatorImpl creatorImpl = new CreatorImpl();

		creatorImpl.setCreatorId(creatorId);

		if (firstName == null) {
			creatorImpl.setFirstName(StringPool.BLANK);
		}
		else {
			creatorImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			creatorImpl.setLastName(StringPool.BLANK);
		}
		else {
			creatorImpl.setLastName(lastName);
		}

		if (middleName == null) {
			creatorImpl.setMiddleName(StringPool.BLANK);
		}
		else {
			creatorImpl.setMiddleName(middleName);
		}

		if (jobTitle == null) {
			creatorImpl.setJobTitle(StringPool.BLANK);
		}
		else {
			creatorImpl.setJobTitle(jobTitle);
		}

		if (gender == null) {
			creatorImpl.setGender(StringPool.BLANK);
		}
		else {
			creatorImpl.setGender(gender);
		}

		if (fullName == null) {
			creatorImpl.setFullName(StringPool.BLANK);
		}
		else {
			creatorImpl.setFullName(fullName);
		}

		if (affiliation == null) {
			creatorImpl.setAffiliation(StringPool.BLANK);
		}
		else {
			creatorImpl.setAffiliation(affiliation);
		}

		if (orcidId == null) {
			creatorImpl.setOrcidId(StringPool.BLANK);
		}
		else {
			creatorImpl.setOrcidId(orcidId);
		}

		creatorImpl.resetOriginalValues();

		return creatorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		creatorId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		middleName = objectInput.readUTF();
		jobTitle = objectInput.readUTF();
		gender = objectInput.readUTF();
		fullName = objectInput.readUTF();
		affiliation = objectInput.readUTF();
		orcidId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(creatorId);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (middleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(middleName);
		}

		if (jobTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		if (gender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (affiliation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(affiliation);
		}

		if (orcidId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orcidId);
		}
	}

	public long creatorId;
	public String firstName;
	public String lastName;
	public String middleName;
	public String jobTitle;
	public String gender;
	public String fullName;
	public String affiliation;
	public String orcidId;
}