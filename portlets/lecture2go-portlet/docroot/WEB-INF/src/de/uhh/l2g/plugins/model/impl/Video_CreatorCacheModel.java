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

import de.uhh.l2g.plugins.model.Video_Creator;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Video_Creator in entity cache.
 *
 * @author Iavor Sturm
 * @see Video_Creator
 * @generated
 */
public class Video_CreatorCacheModel implements CacheModel<Video_Creator>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{videoCreatorId=");
		sb.append(videoCreatorId);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Video_Creator toEntityModel() {
		Video_CreatorImpl video_CreatorImpl = new Video_CreatorImpl();

		video_CreatorImpl.setVideoCreatorId(videoCreatorId);
		video_CreatorImpl.setCreatorId(creatorId);

		video_CreatorImpl.resetOriginalValues();

		return video_CreatorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		videoCreatorId = objectInput.readLong();
		creatorId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(videoCreatorId);
		objectOutput.writeLong(creatorId);
	}

	public long videoCreatorId;
	public long creatorId;
}