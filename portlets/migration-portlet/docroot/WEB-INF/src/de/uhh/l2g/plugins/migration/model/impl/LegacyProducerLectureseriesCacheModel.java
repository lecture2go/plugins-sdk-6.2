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

import de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyProducerLectureseries in entity cache.
 *
 * @author unihh
 * @see LegacyProducerLectureseries
 * @generated
 */
public class LegacyProducerLectureseriesCacheModel implements CacheModel<LegacyProducerLectureseries>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", producerId=");
		sb.append(producerId);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyProducerLectureseries toEntityModel() {
		LegacyProducerLectureseriesImpl legacyProducerLectureseriesImpl = new LegacyProducerLectureseriesImpl();

		legacyProducerLectureseriesImpl.setId(id);
		legacyProducerLectureseriesImpl.setProducerId(producerId);
		legacyProducerLectureseriesImpl.setLectureseriesId(lectureseriesId);

		legacyProducerLectureseriesImpl.resetOriginalValues();

		return legacyProducerLectureseriesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		producerId = objectInput.readLong();
		lectureseriesId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(producerId);
		objectOutput.writeLong(lectureseriesId);
	}

	public long id;
	public long producerId;
	public long lectureseriesId;
}