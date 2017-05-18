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

import de.uhh.l2g.plugins.model.Video_Lectureseries;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Video_Lectureseries in entity cache.
 *
 * @author Iavor Sturm
 * @see Video_Lectureseries
 * @generated
 */
public class Video_LectureseriesCacheModel implements CacheModel<Video_Lectureseries>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{videoLectureseriesId=");
		sb.append(videoLectureseriesId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append(", openAccess=");
		sb.append(openAccess);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Video_Lectureseries toEntityModel() {
		Video_LectureseriesImpl video_LectureseriesImpl = new Video_LectureseriesImpl();

		video_LectureseriesImpl.setVideoLectureseriesId(videoLectureseriesId);
		video_LectureseriesImpl.setVideoId(videoId);
		video_LectureseriesImpl.setLectureseriesId(lectureseriesId);
		video_LectureseriesImpl.setOpenAccess(openAccess);

		video_LectureseriesImpl.resetOriginalValues();

		return video_LectureseriesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		videoLectureseriesId = objectInput.readLong();
		videoId = objectInput.readLong();
		lectureseriesId = objectInput.readLong();
		openAccess = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(videoLectureseriesId);
		objectOutput.writeLong(videoId);
		objectOutput.writeLong(lectureseriesId);
		objectOutput.writeInt(openAccess);
	}

	public long videoLectureseriesId;
	public long videoId;
	public long lectureseriesId;
	public int openAccess;
}