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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.model.VideoStatistic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VideoStatistic in entity cache.
 *
 * @author Iavor Sturm
 * @see VideoStatistic
 * @generated
 */
public class VideoStatisticCacheModel implements CacheModel<VideoStatistic>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{videoStatisticId=");
		sb.append(videoStatisticId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", compareDate=");
		sb.append(compareDate);
		sb.append(", totalVideos=");
		sb.append(totalVideos);
		sb.append(", publicVideos=");
		sb.append(publicVideos);
		sb.append(", privateVideos=");
		sb.append(privateVideos);
		sb.append(", currentTotal=");
		sb.append(currentTotal);
		sb.append(", currentPublic=");
		sb.append(currentPublic);
		sb.append(", currentPrivate=");
		sb.append(currentPrivate);
		sb.append(", pubPercent=");
		sb.append(pubPercent);
		sb.append(", privPercent=");
		sb.append(privPercent);
		sb.append(", currentPubPercent=");
		sb.append(currentPubPercent);
		sb.append(", currentPrivPercent=");
		sb.append(currentPrivPercent);
		sb.append(", intervalName=");
		sb.append(intervalName);
		sb.append(", publicDiff=");
		sb.append(publicDiff);
		sb.append(", privateDiff=");
		sb.append(privateDiff);
		sb.append(", totalDiff=");
		sb.append(totalDiff);
		sb.append(", dateDiff=");
		sb.append(dateDiff);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VideoStatistic toEntityModel() {
		VideoStatisticImpl videoStatisticImpl = new VideoStatisticImpl();

		videoStatisticImpl.setVideoStatisticId(videoStatisticId);
		videoStatisticImpl.setGroupId(groupId);
		videoStatisticImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			videoStatisticImpl.setCreateDate(null);
		}
		else {
			videoStatisticImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			videoStatisticImpl.setModifiedDate(null);
		}
		else {
			videoStatisticImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (compareDate == Long.MIN_VALUE) {
			videoStatisticImpl.setCompareDate(null);
		}
		else {
			videoStatisticImpl.setCompareDate(new Date(compareDate));
		}

		videoStatisticImpl.setTotalVideos(totalVideos);
		videoStatisticImpl.setPublicVideos(publicVideos);
		videoStatisticImpl.setPrivateVideos(privateVideos);
		videoStatisticImpl.setCurrentTotal(currentTotal);
		videoStatisticImpl.setCurrentPublic(currentPublic);
		videoStatisticImpl.setCurrentPrivate(currentPrivate);
		videoStatisticImpl.setPubPercent(pubPercent);
		videoStatisticImpl.setPrivPercent(privPercent);
		videoStatisticImpl.setCurrentPubPercent(currentPubPercent);
		videoStatisticImpl.setCurrentPrivPercent(currentPrivPercent);

		if (intervalName == null) {
			videoStatisticImpl.setIntervalName(StringPool.BLANK);
		}
		else {
			videoStatisticImpl.setIntervalName(intervalName);
		}

		videoStatisticImpl.setPublicDiff(publicDiff);
		videoStatisticImpl.setPrivateDiff(privateDiff);
		videoStatisticImpl.setTotalDiff(totalDiff);
		videoStatisticImpl.setDateDiff(dateDiff);

		videoStatisticImpl.resetOriginalValues();

		return videoStatisticImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		videoStatisticId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		compareDate = objectInput.readLong();
		totalVideos = objectInput.readLong();
		publicVideos = objectInput.readLong();
		privateVideos = objectInput.readLong();
		currentTotal = objectInput.readLong();
		currentPublic = objectInput.readLong();
		currentPrivate = objectInput.readLong();
		pubPercent = objectInput.readInt();
		privPercent = objectInput.readInt();
		currentPubPercent = objectInput.readInt();
		currentPrivPercent = objectInput.readInt();
		intervalName = objectInput.readUTF();
		publicDiff = objectInput.readInt();
		privateDiff = objectInput.readInt();
		totalDiff = objectInput.readInt();
		dateDiff = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(videoStatisticId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(compareDate);
		objectOutput.writeLong(totalVideos);
		objectOutput.writeLong(publicVideos);
		objectOutput.writeLong(privateVideos);
		objectOutput.writeLong(currentTotal);
		objectOutput.writeLong(currentPublic);
		objectOutput.writeLong(currentPrivate);
		objectOutput.writeInt(pubPercent);
		objectOutput.writeInt(privPercent);
		objectOutput.writeInt(currentPubPercent);
		objectOutput.writeInt(currentPrivPercent);

		if (intervalName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(intervalName);
		}

		objectOutput.writeInt(publicDiff);
		objectOutput.writeInt(privateDiff);
		objectOutput.writeInt(totalDiff);
		objectOutput.writeInt(dateDiff);
	}

	public long videoStatisticId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long compareDate;
	public long totalVideos;
	public long publicVideos;
	public long privateVideos;
	public long currentTotal;
	public long currentPublic;
	public long currentPrivate;
	public int pubPercent;
	public int privPercent;
	public int currentPubPercent;
	public int currentPrivPercent;
	public String intervalName;
	public int publicDiff;
	public int privateDiff;
	public int totalDiff;
	public int dateDiff;
}