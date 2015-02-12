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
		StringBundler sb = new StringBundler(27);

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
		sb.append(", semesterName=");
		sb.append(semesterName);
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

		if (semesterName == null) {
			lectureseriesImpl.setSemesterName(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setSemesterName(semesterName);
		}

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
		semesterName = objectInput.readUTF();
		language = objectInput.readUTF();
		facultyName = objectInput.readUTF();
		instructorsString = objectInput.readUTF();
		lectureseriesId = objectInput.readLong();
		password = objectInput.readUTF();
		approved = objectInput.readInt();
		longDesc = objectInput.readUTF();
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

		if (semesterName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(semesterName);
		}

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
	}

	public String number;
	public String eventType;
	public String eventCategory;
	public String name;
	public String shortDesc;
	public String semesterName;
	public String language;
	public String facultyName;
	public String instructorsString;
	public long lectureseriesId;
	public String password;
	public int approved;
	public String longDesc;
}