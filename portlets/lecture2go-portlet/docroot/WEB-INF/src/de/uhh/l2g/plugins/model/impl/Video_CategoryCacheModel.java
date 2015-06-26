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

import de.uhh.l2g.plugins.model.Video_Category;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Video_Category in entity cache.
 *
 * @author Iavor Sturm
 * @see Video_Category
 * @generated
 */
public class Video_CategoryCacheModel implements CacheModel<Video_Category>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{videoCategoryId=");
		sb.append(videoCategoryId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Video_Category toEntityModel() {
		Video_CategoryImpl video_CategoryImpl = new Video_CategoryImpl();

		video_CategoryImpl.setVideoCategoryId(videoCategoryId);
		video_CategoryImpl.setVideoId(videoId);
		video_CategoryImpl.setCategoryId(categoryId);

		video_CategoryImpl.resetOriginalValues();

		return video_CategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		videoCategoryId = objectInput.readLong();
		videoId = objectInput.readLong();
		categoryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(videoCategoryId);
		objectOutput.writeLong(videoId);
		objectOutput.writeLong(categoryId);
	}

	public long videoCategoryId;
	public long videoId;
	public long categoryId;
}