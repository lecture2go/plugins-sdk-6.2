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

import de.uhh.l2g.plugins.model.Lectureseries;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Lectureseries in entity cache.
 *
 * @author Iavor Sturm
 * @see Lectureseries
 * @generated
 */
public class LectureseriesCacheModel implements CacheModel<Lectureseries>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{number=");
		sb.append(number);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", eventCategory=");
		sb.append(eventCategory);
		sb.append(", name=");
		sb.append(name);
		sb.append(", shortDesc=");
		sb.append(shortDesc);
		sb.append(", yearId=");
		sb.append(yearId);
		sb.append(", language=");
		sb.append(language);
		sb.append(", facultyName=");
		sb.append(facultyName);
		sb.append(", instructorsString=");
		sb.append(instructorsString);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append(", password=");
		sb.append(password);
		sb.append(", approved=");
		sb.append(approved);
		sb.append(", longDesc=");
		sb.append(longDesc);
		sb.append(", latestOpenAccessVideoId=");
		sb.append(latestOpenAccessVideoId);
		sb.append(", latestVideoUploadDate=");
		sb.append(latestVideoUploadDate);
		sb.append(", latestVideoGenerationDate=");
		sb.append(latestVideoGenerationDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Lectureseries toEntityModel() {
		LectureseriesImpl lectureseriesImpl = new LectureseriesImpl();

		if (number == null) {
			lectureseriesImpl.setNumber(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setNumber(number);
		}

		if (eventType == null) {
			lectureseriesImpl.setEventType(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setEventType(eventType);
		}

		if (eventCategory == null) {
			lectureseriesImpl.setEventCategory(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setEventCategory(eventCategory);
		}

		if (name == null) {
			lectureseriesImpl.setName(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setName(name);
		}

		if (shortDesc == null) {
			lectureseriesImpl.setShortDesc(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setShortDesc(shortDesc);
		}

		lectureseriesImpl.setYearId(yearId);

		if (language == null) {
			lectureseriesImpl.setLanguage(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setLanguage(language);
		}

		if (facultyName == null) {
			lectureseriesImpl.setFacultyName(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setFacultyName(facultyName);
		}

		if (instructorsString == null) {
			lectureseriesImpl.setInstructorsString(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setInstructorsString(instructorsString);
		}

		lectureseriesImpl.setLectureseriesId(lectureseriesId);

		if (password == null) {
			lectureseriesImpl.setPassword(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setPassword(password);
		}

		lectureseriesImpl.setApproved(approved);

		if (longDesc == null) {
			lectureseriesImpl.setLongDesc(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setLongDesc(longDesc);
		}

		lectureseriesImpl.setLatestOpenAccessVideoId(latestOpenAccessVideoId);

		if (latestVideoUploadDate == Long.MIN_VALUE) {
			lectureseriesImpl.setLatestVideoUploadDate(null);
		}
		else {
			lectureseriesImpl.setLatestVideoUploadDate(new Date(
					latestVideoUploadDate));
		}

		if (latestVideoGenerationDate == null) {
			lectureseriesImpl.setLatestVideoGenerationDate(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setLatestVideoGenerationDate(latestVideoGenerationDate);
		}

		lectureseriesImpl.resetOriginalValues();

		return lectureseriesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		number = objectInput.readUTF();
		eventType = objectInput.readUTF();
		eventCategory = objectInput.readUTF();
		name = objectInput.readUTF();
		shortDesc = objectInput.readUTF();
		yearId = objectInput.readLong();
		language = objectInput.readUTF();
		facultyName = objectInput.readUTF();
		instructorsString = objectInput.readUTF();
		lectureseriesId = objectInput.readLong();
		password = objectInput.readUTF();
		approved = objectInput.readInt();
		longDesc = objectInput.readUTF();
		latestOpenAccessVideoId = objectInput.readLong();
		latestVideoUploadDate = objectInput.readLong();
		latestVideoGenerationDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (number == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(number);
		}

		if (eventType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		if (eventCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventCategory);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (shortDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortDesc);
		}

		objectOutput.writeLong(yearId);

		if (language == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (facultyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(facultyName);
		}

		if (instructorsString == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(instructorsString);
		}

		objectOutput.writeLong(lectureseriesId);

		if (password == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(password);
		}

		objectOutput.writeInt(approved);

		if (longDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(longDesc);
		}

		objectOutput.writeLong(latestOpenAccessVideoId);
		objectOutput.writeLong(latestVideoUploadDate);

		if (latestVideoGenerationDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(latestVideoGenerationDate);
		}
	}

	public String number;
	public String eventType;
	public String eventCategory;
	public String name;
	public String shortDesc;
	public long yearId;
	public String language;
	public String facultyName;
	public String instructorsString;
	public long lectureseriesId;
	public String password;
	public int approved;
	public String longDesc;
	public long latestOpenAccessVideoId;
	public long latestVideoUploadDate;
	public String latestVideoGenerationDate;
}