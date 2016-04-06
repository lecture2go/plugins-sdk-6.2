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

import de.uhh.l2g.plugins.model.Statistic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Statistic in entity cache.
 *
 * @author Iavor Sturm
 * @see Statistic
 * @generated
 */
public class StatisticCacheModel implements CacheModel<Statistic>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{statisticId=");
		sb.append(statisticId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", publicVideos=");
		sb.append(publicVideos);
		sb.append(", privateVideos=");
		sb.append(privateVideos);
		sb.append(", autofillRow=");
		sb.append(autofillRow);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Statistic toEntityModel() {
		StatisticImpl statisticImpl = new StatisticImpl();

		statisticImpl.setStatisticId(statisticId);
		statisticImpl.setGroupId(groupId);
		statisticImpl.setCompanyId(companyId);
		statisticImpl.setPublicVideos(publicVideos);
		statisticImpl.setPrivateVideos(privateVideos);
		statisticImpl.setAutofillRow(autofillRow);
		statisticImpl.setUserId(userId);

		if (userName == null) {
			statisticImpl.setUserName(StringPool.BLANK);
		}
		else {
			statisticImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			statisticImpl.setCreateDate(null);
		}
		else {
			statisticImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			statisticImpl.setModifiedDate(null);
		}
		else {
			statisticImpl.setModifiedDate(new Date(modifiedDate));
		}

		statisticImpl.resetOriginalValues();

		return statisticImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		statisticId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		publicVideos = objectInput.readInt();
		privateVideos = objectInput.readInt();
		autofillRow = objectInput.readInt();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(statisticId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeInt(publicVideos);
		objectOutput.writeInt(privateVideos);
		objectOutput.writeInt(autofillRow);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long statisticId;
	public long groupId;
	public long companyId;
	public int publicVideos;
	public int privateVideos;
	public int autofillRow;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}