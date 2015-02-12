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
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.model.Lectureseries_Institution;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Lectureseries_Institution in entity cache.
 *
 * @author Iavor Sturm
 * @see Lectureseries_Institution
 * @generated
 */
public class Lectureseries_InstitutionCacheModel implements CacheModel<Lectureseries_Institution>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{lectureseriesInstitutionId=");
		sb.append(lectureseriesInstitutionId);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append(", institutionId=");
		sb.append(institutionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Lectureseries_Institution toEntityModel() {
		Lectureseries_InstitutionImpl lectureseries_InstitutionImpl = new Lectureseries_InstitutionImpl();

		lectureseries_InstitutionImpl.setLectureseriesInstitutionId(lectureseriesInstitutionId);
		lectureseries_InstitutionImpl.setLectureseriesId(lectureseriesId);
		lectureseries_InstitutionImpl.setInstitutionId(institutionId);

		lectureseries_InstitutionImpl.resetOriginalValues();

		return lectureseries_InstitutionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lectureseriesInstitutionId = objectInput.readLong();
		lectureseriesId = objectInput.readLong();
		institutionId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(lectureseriesInstitutionId);
		objectOutput.writeLong(lectureseriesId);
		objectOutput.writeLong(institutionId);
	}

	public long lectureseriesInstitutionId;
	public long lectureseriesId;
	public long institutionId;
}