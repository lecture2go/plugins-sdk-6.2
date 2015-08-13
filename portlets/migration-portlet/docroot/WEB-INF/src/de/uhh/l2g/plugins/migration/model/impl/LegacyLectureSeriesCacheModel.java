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

import de.uhh.l2g.plugins.migration.model.LegacyLectureSeries;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyLectureSeries in entity cache.
 *
 * @author unihh
 * @see LegacyLectureSeries
 * @generated
 */
public class LegacyLectureSeriesCacheModel implements CacheModel<LegacyLectureSeries>,
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
		sb.append(", id=");
		sb.append(id);
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
	public LegacyLectureSeries toEntityModel() {
		LegacyLectureSeriesImpl legacyLectureSeriesImpl = new LegacyLectureSeriesImpl();

		if (number == null) {
			legacyLectureSeriesImpl.setNumber(StringPool.BLANK);
		}
		else {
			legacyLectureSeriesImpl.setNumber(number);
		}

		if (eventType == null) {
			legacyLectureSeriesImpl.setEventType(StringPool.BLANK);
		}
		else {
			legacyLectureSeriesImpl.setEventType(eventType);
		}

		if (eventCategory == null) {
			legacyLectureSeriesImpl.setEventCategory(StringPool.BLANK);
		}
		else {
			legacyLectureSeriesImpl.setEventCategory(eventCategory);
		}

		if (name == null) {
			legacyLectureSeriesImpl.setName(StringPool.BLANK);
		}
		else {
			legacyLectureSeriesImpl.setName(name);
		}

		if (shortDesc == null) {
			legacyLectureSeriesImpl.setShortDesc(StringPool.BLANK);
		}
		else {
			legacyLectureSeriesImpl.setShortDesc(shortDesc);
		}

		if (semesterName == null) {
			legacyLectureSeriesImpl.setSemesterName(StringPool.BLANK);
		}
		else {
			legacyLectureSeriesImpl.setSemesterName(semesterName);
		}

		if (language == null) {
			legacyLectureSeriesImpl.setLanguage(StringPool.BLANK);
		}
		else {
			legacyLectureSeriesImpl.setLanguage(language);
		}

		if (facultyName == null) {
			legacyLectureSeriesImpl.setFacultyName(StringPool.BLANK);
		}
		else {
			legacyLectureSeriesImpl.setFacultyName(facultyName);
		}

		if (instructorsString == null) {
			legacyLectureSeriesImpl.setInstructorsString(StringPool.BLANK);
		}
		else {
			legacyLectureSeriesImpl.setInstructorsString(instructorsString);
		}

		legacyLectureSeriesImpl.setId(id);

		if (password == null) {
			legacyLectureSeriesImpl.setPassword(StringPool.BLANK);
		}
		else {
			legacyLectureSeriesImpl.setPassword(password);
		}

		legacyLectureSeriesImpl.setApproved(approved);

		if (longDesc == null) {
			legacyLectureSeriesImpl.setLongDesc(StringPool.BLANK);
		}
		else {
			legacyLectureSeriesImpl.setLongDesc(longDesc);
		}

		legacyLectureSeriesImpl.resetOriginalValues();

		return legacyLectureSeriesImpl;
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
		id = objectInput.readLong();
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

		objectOutput.writeLong(id);

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
	public long id;
	public String password;
	public int approved;
	public String longDesc;
}