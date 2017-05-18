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

import de.uhh.l2g.plugins.migration.model.LegacyHost;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyHost in entity cache.
 *
 * @author unihh
 * @see LegacyHost
 * @generated
 */
public class LegacyHostCacheModel implements CacheModel<LegacyHost>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", protokoll=");
		sb.append(protokoll);
		sb.append(", streamer=");
		sb.append(streamer);
		sb.append(", port=");
		sb.append(port);
		sb.append(", serverRoot=");
		sb.append(serverRoot);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyHost toEntityModel() {
		LegacyHostImpl legacyHostImpl = new LegacyHostImpl();

		legacyHostImpl.setId(id);

		if (protokoll == null) {
			legacyHostImpl.setProtokoll(StringPool.BLANK);
		}
		else {
			legacyHostImpl.setProtokoll(protokoll);
		}

		if (streamer == null) {
			legacyHostImpl.setStreamer(StringPool.BLANK);
		}
		else {
			legacyHostImpl.setStreamer(streamer);
		}

		legacyHostImpl.setPort(port);

		if (serverRoot == null) {
			legacyHostImpl.setServerRoot(StringPool.BLANK);
		}
		else {
			legacyHostImpl.setServerRoot(serverRoot);
		}

		if (name == null) {
			legacyHostImpl.setName(StringPool.BLANK);
		}
		else {
			legacyHostImpl.setName(name);
		}

		legacyHostImpl.resetOriginalValues();

		return legacyHostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		protokoll = objectInput.readUTF();
		streamer = objectInput.readUTF();
		port = objectInput.readInt();
		serverRoot = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (protokoll == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(protokoll);
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
	}

	public long id;
	public String protokoll;
	public String streamer;
	public int port;
	public String serverRoot;
	public String name;
}