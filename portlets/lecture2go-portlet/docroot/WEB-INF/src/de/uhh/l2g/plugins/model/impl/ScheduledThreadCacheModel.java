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

import de.uhh.l2g.plugins.model.ScheduledThread;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ScheduledThread in entity cache.
 *
 * @author Iavor Sturm
 * @see ScheduledThread
 * @generated
 */
public class ScheduledThreadCacheModel implements CacheModel<ScheduledThread>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{scheduledThreadId=");
		sb.append(scheduledThreadId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", schedulerClassName=");
		sb.append(schedulerClassName);
		sb.append(", cronText=");
		sb.append(cronText);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ScheduledThread toEntityModel() {
		ScheduledThreadImpl scheduledThreadImpl = new ScheduledThreadImpl();

		scheduledThreadImpl.setScheduledThreadId(scheduledThreadId);
		scheduledThreadImpl.setGroupId(groupId);
		scheduledThreadImpl.setCompanyId(companyId);
		scheduledThreadImpl.setUserId(userId);

		if (userName == null) {
			scheduledThreadImpl.setUserName(StringPool.BLANK);
		}
		else {
			scheduledThreadImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			scheduledThreadImpl.setCreateDate(null);
		}
		else {
			scheduledThreadImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			scheduledThreadImpl.setModifiedDate(null);
		}
		else {
			scheduledThreadImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (schedulerClassName == null) {
			scheduledThreadImpl.setSchedulerClassName(StringPool.BLANK);
		}
		else {
			scheduledThreadImpl.setSchedulerClassName(schedulerClassName);
		}

		if (cronText == null) {
			scheduledThreadImpl.setCronText(StringPool.BLANK);
		}
		else {
			scheduledThreadImpl.setCronText(cronText);
		}

		scheduledThreadImpl.resetOriginalValues();

		return scheduledThreadImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		scheduledThreadId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		schedulerClassName = objectInput.readUTF();
		cronText = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(scheduledThreadId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (schedulerClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(schedulerClassName);
		}

		if (cronText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cronText);
		}
	}

	public long scheduledThreadId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String schedulerClassName;
	public String cronText;
}