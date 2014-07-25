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

import de.uhh.l2g.plugins.model.Producer_Lectureseries;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Producer_Lectureseries in entity cache.
 *
 * @author Iavor Sturm
 * @see Producer_Lectureseries
 * @generated
 */
public class Producer_LectureseriesCacheModel implements CacheModel<Producer_Lectureseries>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{producerLectureseries=");
		sb.append(producerLectureseries);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append(", producerId=");
		sb.append(producerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Producer_Lectureseries toEntityModel() {
		Producer_LectureseriesImpl producer_LectureseriesImpl = new Producer_LectureseriesImpl();

		producer_LectureseriesImpl.setProducerLectureseries(producerLectureseries);
		producer_LectureseriesImpl.setLectureseriesId(lectureseriesId);
		producer_LectureseriesImpl.setProducerId(producerId);

		producer_LectureseriesImpl.resetOriginalValues();

		return producer_LectureseriesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		producerLectureseries = objectInput.readLong();
		lectureseriesId = objectInput.readLong();
		producerId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(producerLectureseries);
		objectOutput.writeLong(lectureseriesId);
		objectOutput.writeLong(producerId);
	}

	public long producerLectureseries;
	public long lectureseriesId;
	public long producerId;
}