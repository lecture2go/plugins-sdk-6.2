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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.model.Segment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Segment in entity cache.
 *
 * @author Iavor Sturm
 * @see Segment
 * @generated
 */
public class SegmentCacheModel implements CacheModel<Segment>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{segmentId=");
		sb.append(segmentId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", start=");
		sb.append(start);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", end=");
		sb.append(end);
		sb.append(", chapter=");
		sb.append(chapter);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Segment toEntityModel() {
		SegmentImpl segmentImpl = new SegmentImpl();

		segmentImpl.setSegmentId(segmentId);
		segmentImpl.setVideoId(videoId);

		if (start == null) {
			segmentImpl.setStart(StringPool.BLANK);
		}
		else {
			segmentImpl.setStart(start);
		}

		if (title == null) {
			segmentImpl.setTitle(StringPool.BLANK);
		}
		else {
			segmentImpl.setTitle(title);
		}

		if (description == null) {
			segmentImpl.setDescription(StringPool.BLANK);
		}
		else {
			segmentImpl.setDescription(description);
		}

		if (end == null) {
			segmentImpl.setEnd(StringPool.BLANK);
		}
		else {
			segmentImpl.setEnd(end);
		}

		segmentImpl.setChapter(chapter);
		segmentImpl.setUserId(userId);

		segmentImpl.resetOriginalValues();

		return segmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		segmentId = objectInput.readLong();
		videoId = objectInput.readLong();
		start = objectInput.readUTF();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		end = objectInput.readUTF();
		chapter = objectInput.readInt();
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(segmentId);
		objectOutput.writeLong(videoId);

		if (start == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(start);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (end == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(end);
		}

		objectOutput.writeInt(chapter);
		objectOutput.writeLong(userId);
	}

	public long segmentId;
	public long videoId;
	public String start;
	public String title;
	public String description;
	public String end;
	public int chapter;
	public long userId;
}