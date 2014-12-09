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

import de.uhh.l2g.plugins.model.Host;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Host in entity cache.
 *
 * @author Iavor Sturm
 * @see Host
 * @generated
 */
public class HostCacheModel implements CacheModel<Host>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{hostId=");
		sb.append(hostId);
		sb.append(", protocol=");
		sb.append(protocol);
		sb.append(", streamer=");
		sb.append(streamer);
		sb.append(", port=");
		sb.append(port);
		sb.append(", serverRoot=");
		sb.append(serverRoot);
		sb.append(", name=");
		sb.append(name);
		sb.append(", serverTemplate=");
		sb.append(serverTemplate);
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
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Host toEntityModel() {
		HostImpl hostImpl = new HostImpl();

		hostImpl.setHostId(hostId);

		if (protocol == null) {
			hostImpl.setProtocol(StringPool.BLANK);
		}
		else {
			hostImpl.setProtocol(protocol);
		}

		if (streamer == null) {
			hostImpl.setStreamer(StringPool.BLANK);
		}
		else {
			hostImpl.setStreamer(streamer);
		}

		hostImpl.setPort(port);

		if (serverRoot == null) {
			hostImpl.setServerRoot(StringPool.BLANK);
		}
		else {
			hostImpl.setServerRoot(serverRoot);
		}

		if (name == null) {
			hostImpl.setName(StringPool.BLANK);
		}
		else {
			hostImpl.setName(name);
		}

		if (serverTemplate == null) {
			hostImpl.setServerTemplate(StringPool.BLANK);
		}
		else {
			hostImpl.setServerTemplate(serverTemplate);
		}

		hostImpl.setGroupId(groupId);
		hostImpl.setCompanyId(companyId);
		hostImpl.setUserId(userId);

		if (userName == null) {
			hostImpl.setUserName(StringPool.BLANK);
		}
		else {
			hostImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			hostImpl.setCreateDate(null);
		}
		else {
			hostImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			hostImpl.setModifiedDate(null);
		}
		else {
			hostImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (uuid == null) {
			hostImpl.setUuid(StringPool.BLANK);
		}
		else {
			hostImpl.setUuid(uuid);
		}

		hostImpl.resetOriginalValues();

		return hostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		hostId = objectInput.readLong();
		protocol = objectInput.readUTF();
		streamer = objectInput.readUTF();
		port = objectInput.readInt();
		serverRoot = objectInput.readUTF();
		name = objectInput.readUTF();
		serverTemplate = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		uuid = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(hostId);

		if (protocol == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(protocol);
		}

		if (streamer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(streamer);
		}

		objectOutput.writeInt(port);

		if (serverRoot == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serverRoot);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (serverTemplate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serverTemplate);
		}

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

		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}
	}

	public long hostId;
	public String protocol;
	public String streamer;
	public int port;
	public String serverRoot;
	public String name;
	public String serverTemplate;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String uuid;
}