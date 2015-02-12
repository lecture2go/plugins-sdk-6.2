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

import de.uhh.l2g.plugins.model.Video_Institution;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Video_Institution in entity cache.
 *
 * @author Iavor Sturm
 * @see Video_Institution
 * @generated
 */
public class Video_InstitutionCacheModel implements CacheModel<Video_Institution>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{videoInstitutionId=");
		sb.append(videoInstitutionId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", institutionId=");
		sb.append(institutionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Video_Institution toEntityModel() {
		Video_InstitutionImpl video_InstitutionImpl = new Video_InstitutionImpl();

		video_InstitutionImpl.setVideoInstitutionId(videoInstitutionId);
		video_InstitutionImpl.setVideoId(videoId);
		video_InstitutionImpl.setInstitutionId(institutionId);

		video_InstitutionImpl.resetOriginalValues();

		return video_InstitutionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		videoInstitutionId = objectInput.readLong();
		videoId = objectInput.readLong();
		institutionId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(videoInstitutionId);
		objectOutput.writeLong(videoId);
		objectOutput.writeLong(institutionId);
	}

	public long videoInstitutionId;
	public long videoId;
	public long institutionId;
}