/*******************************************************************************
 * License
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++
 * 
 * Lecture2Go 
 * 
 * The Lecture2Go software is based on the liferay portal 6.2-ga6
 * <http://www.liferay.com> (Copyright notice see below)
 * Lecture2Go <http://lecture2go.uni-hamburg.de> is an open source
 * platform for media management and distribution. Our goal is to
 * support the free access to knowledge because this is a component
 * of each democratic society. The open source software is aimed at
 * academic institutions and has to strengthen the blended learning.
 * All Lecture2Go plugins are continuously being developed and improved.
 * For more details please visit <http://lecture2go-open-source.rrz.uni-hamburg.de>
 * Copyright (c) 2013 - present University of Hamburg / Computer and Data Center (RRZ)
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *  
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++
 * 
 * The Liferay Plugins SDK:
 * 
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++
 * 
 * Third Party Software
 * 
 * Lecture2Go uses third-party libraries which may be distributed under different licenses
 * to the above (but are compatible with the used GPL license). Informations about these
 * licenses and copyright informations are mostly detailed in the library source code or jars themselves.
 * You must agree to the terms of these licenses, in addition tothe above Lecture2Go source code license,
 * in order to use this software.
 ******************************************************************************/
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
		StringBundler sb = new StringBundler(37);

		sb.append("{number=");
		sb.append(number);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", shortDesc=");
		sb.append(shortDesc);
		sb.append(", termId=");
		sb.append(termId);
		sb.append(", language=");
		sb.append(language);
		sb.append(", facultyName=");
		sb.append(facultyName);
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
		sb.append(", videoSort=");
		sb.append(videoSort);
		sb.append(", USID=");
		sb.append(USID);
		sb.append(", previewVideoId=");
		sb.append(previewVideoId);
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

		lectureseriesImpl.setCategoryId(categoryId);

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

		lectureseriesImpl.setTermId(termId);

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

		lectureseriesImpl.setVideoSort(videoSort);

		if (USID == null) {
			lectureseriesImpl.setUSID(StringPool.BLANK);
		}
		else {
			lectureseriesImpl.setUSID(USID);
		}

		lectureseriesImpl.setPreviewVideoId(previewVideoId);

		lectureseriesImpl.resetOriginalValues();

		return lectureseriesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		number = objectInput.readUTF();
		eventType = objectInput.readUTF();
		categoryId = objectInput.readLong();
		name = objectInput.readUTF();
		shortDesc = objectInput.readUTF();
		termId = objectInput.readLong();
		language = objectInput.readUTF();
		facultyName = objectInput.readUTF();
		lectureseriesId = objectInput.readLong();
		password = objectInput.readUTF();
		approved = objectInput.readInt();
		longDesc = objectInput.readUTF();
		latestOpenAccessVideoId = objectInput.readLong();
		latestVideoUploadDate = objectInput.readLong();
		latestVideoGenerationDate = objectInput.readUTF();
		videoSort = objectInput.readInt();
		USID = objectInput.readUTF();
		previewVideoId = objectInput.readLong();
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

		objectOutput.writeLong(categoryId);

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

		objectOutput.writeLong(termId);

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

		objectOutput.writeInt(videoSort);

		if (USID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(USID);
		}

		objectOutput.writeLong(previewVideoId);
	}

	public String number;
	public String eventType;
	public long categoryId;
	public String name;
	public String shortDesc;
	public long termId;
	public String language;
	public String facultyName;
	public long lectureseriesId;
	public String password;
	public int approved;
	public String longDesc;
	public long latestOpenAccessVideoId;
	public long latestVideoUploadDate;
	public String latestVideoGenerationDate;
	public int videoSort;
	public String USID;
	public long previewVideoId;
}
