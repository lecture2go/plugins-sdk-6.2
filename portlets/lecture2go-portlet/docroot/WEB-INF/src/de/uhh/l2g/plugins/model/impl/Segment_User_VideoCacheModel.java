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

import de.uhh.l2g.plugins.model.Segment_User_Video;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Segment_User_Video in entity cache.
 *
 * @author Iavor Sturm
 * @see Segment_User_Video
 * @generated
 */
public class Segment_User_VideoCacheModel implements CacheModel<Segment_User_Video>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{segmentId=");
		sb.append(segmentId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", segmentUserVideoId=");
		sb.append(segmentUserVideoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Segment_User_Video toEntityModel() {
		Segment_User_VideoImpl segment_User_VideoImpl = new Segment_User_VideoImpl();

		segment_User_VideoImpl.setSegmentId(segmentId);
		segment_User_VideoImpl.setUserId(userId);
		segment_User_VideoImpl.setVideoId(videoId);
		segment_User_VideoImpl.setSegmentUserVideoId(segmentUserVideoId);

		segment_User_VideoImpl.resetOriginalValues();

		return segment_User_VideoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		segmentId = objectInput.readLong();
		userId = objectInput.readLong();
		videoId = objectInput.readLong();
		segmentUserVideoId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(segmentId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(videoId);
		objectOutput.writeLong(segmentUserVideoId);
	}

	public long segmentId;
	public long userId;
	public long videoId;
	public long segmentUserVideoId;
}