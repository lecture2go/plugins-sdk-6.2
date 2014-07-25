/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.model.Lectureseries_Facility;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Lectureseries_Facility in entity cache.
 *
 * @author Iavor Sturm
 * @see Lectureseries_Facility
 * @generated
 */
public class Lectureseries_FacilityCacheModel implements CacheModel<Lectureseries_Facility>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{lectureseriesFacilityId=");
		sb.append(lectureseriesFacilityId);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append(", facilityId=");
		sb.append(facilityId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Lectureseries_Facility toEntityModel() {
		Lectureseries_FacilityImpl lectureseries_FacilityImpl = new Lectureseries_FacilityImpl();

		lectureseries_FacilityImpl.setLectureseriesFacilityId(lectureseriesFacilityId);
		lectureseries_FacilityImpl.setLectureseriesId(lectureseriesId);
		lectureseries_FacilityImpl.setFacilityId(facilityId);

		lectureseries_FacilityImpl.resetOriginalValues();

		return lectureseries_FacilityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lectureseriesFacilityId = objectInput.readLong();
		lectureseriesId = objectInput.readLong();
		facilityId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(lectureseriesFacilityId);
		objectOutput.writeLong(lectureseriesId);
		objectOutput.writeLong(facilityId);
	}

	public long lectureseriesFacilityId;
	public long lectureseriesId;
	public long facilityId;
}