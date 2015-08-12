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
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyLectureSeriesFacility in entity cache.
 *
 * @author unihh
 * @see LegacyLectureSeriesFacility
 * @generated
 */
public class LegacyLectureSeriesFacilityCacheModel implements CacheModel<LegacyLectureSeriesFacility>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{lectureseriesFacilityId=");
		sb.append(lectureseriesFacilityId);
		sb.append(", facilityId=");
		sb.append(facilityId);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append(", isLinkFrom=");
		sb.append(isLinkFrom);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyLectureSeriesFacility toEntityModel() {
		LegacyLectureSeriesFacilityImpl legacyLectureSeriesFacilityImpl = new LegacyLectureSeriesFacilityImpl();

		legacyLectureSeriesFacilityImpl.setLectureseriesFacilityId(lectureseriesFacilityId);
		legacyLectureSeriesFacilityImpl.setFacilityId(facilityId);
		legacyLectureSeriesFacilityImpl.setLectureseriesId(lectureseriesId);
		legacyLectureSeriesFacilityImpl.setIsLinkFrom(isLinkFrom);

		legacyLectureSeriesFacilityImpl.resetOriginalValues();

		return legacyLectureSeriesFacilityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lectureseriesFacilityId = objectInput.readLong();
		facilityId = objectInput.readLong();
		lectureseriesId = objectInput.readLong();
		isLinkFrom = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(lectureseriesFacilityId);
		objectOutput.writeLong(facilityId);
		objectOutput.writeLong(lectureseriesId);
		objectOutput.writeLong(isLinkFrom);
	}

	public long lectureseriesFacilityId;
	public long facilityId;
	public long lectureseriesId;
	public long isLinkFrom;
}