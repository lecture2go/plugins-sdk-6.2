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

import de.uhh.l2g.plugins.migration.model.LegacySegment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacySegment in entity cache.
 *
 * @author unihh
 * @see LegacySegment
 * @generated
 */
public class LegacySegmentCacheModel implements CacheModel<LegacySegment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
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
	public LegacySegment toEntityModel() {
		LegacySegmentImpl legacySegmentImpl = new LegacySegmentImpl();

		legacySegmentImpl.setId(id);
		legacySegmentImpl.setVideoId(videoId);

		if (start == null) {
			legacySegmentImpl.setStart(StringPool.BLANK);
		}
		else {
			legacySegmentImpl.setStart(start);
		}

		if (title == null) {
			legacySegmentImpl.setTitle(StringPool.BLANK);
		}
		else {
			legacySegmentImpl.setTitle(title);
		}

		if (description == null) {
			legacySegmentImpl.setDescription(StringPool.BLANK);
		}
		else {
			legacySegmentImpl.setDescription(description);
		}

		if (end == null) {
			legacySegmentImpl.setEnd(StringPool.BLANK);
		}
		else {
			legacySegmentImpl.setEnd(end);
		}

		legacySegmentImpl.setChapter(chapter);
		legacySegmentImpl.setUserId(userId);

		legacySegmentImpl.resetOriginalValues();

		return legacySegmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
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
		objectOutput.writeLong(id);
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

	public long id;
	public long videoId;
	public String start;
	public String title;
	public String description;
	public String end;
	public int chapter;
	public long userId;
}