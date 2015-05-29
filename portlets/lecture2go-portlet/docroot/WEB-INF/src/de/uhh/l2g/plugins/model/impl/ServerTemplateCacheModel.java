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

import de.uhh.l2g.plugins.model.ServerTemplate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ServerTemplate in entity cache.
 *
 * @author Iavor Sturm
 * @see ServerTemplate
 * @generated
 */
public class ServerTemplateCacheModel implements CacheModel<ServerTemplate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{serverTemplateId=");
		sb.append(serverTemplateId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append(", prefixURL=");
		sb.append(prefixURL);
		sb.append(", suffixURL=");
		sb.append(suffixURL);
		sb.append(", secExt=");
		sb.append(secExt);
		sb.append(", templateURL=");
		sb.append(templateURL);
		sb.append(", prefixFile=");
		sb.append(prefixFile);
		sb.append(", suffixFile=");
		sb.append(suffixFile);
		sb.append(", templateFile=");
		sb.append(templateFile);
		sb.append(", templateIOS=");
		sb.append(templateIOS);
		sb.append(", templateAndroid=");
		sb.append(templateAndroid);
		sb.append(", defaultServer=");
		sb.append(defaultServer);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServerTemplate toEntityModel() {
		ServerTemplateImpl serverTemplateImpl = new ServerTemplateImpl();

		serverTemplateImpl.setServerTemplateId(serverTemplateId);
		serverTemplateImpl.setGroupId(groupId);

		if (name == null) {
			serverTemplateImpl.setName(StringPool.BLANK);
		}
		else {
			serverTemplateImpl.setName(name);
		}

		serverTemplateImpl.setType(type);

		if (prefixURL == null) {
			serverTemplateImpl.setPrefixURL(StringPool.BLANK);
		}
		else {
			serverTemplateImpl.setPrefixURL(prefixURL);
		}

		if (suffixURL == null) {
			serverTemplateImpl.setSuffixURL(StringPool.BLANK);
		}
		else {
			serverTemplateImpl.setSuffixURL(suffixURL);
		}

		if (secExt == null) {
			serverTemplateImpl.setSecExt(StringPool.BLANK);
		}
		else {
			serverTemplateImpl.setSecExt(secExt);
		}

		if (templateURL == null) {
			serverTemplateImpl.setTemplateURL(StringPool.BLANK);
		}
		else {
			serverTemplateImpl.setTemplateURL(templateURL);
		}

		if (prefixFile == null) {
			serverTemplateImpl.setPrefixFile(StringPool.BLANK);
		}
		else {
			serverTemplateImpl.setPrefixFile(prefixFile);
		}

		if (suffixFile == null) {
			serverTemplateImpl.setSuffixFile(StringPool.BLANK);
		}
		else {
			serverTemplateImpl.setSuffixFile(suffixFile);
		}

		if (templateFile == null) {
			serverTemplateImpl.setTemplateFile(StringPool.BLANK);
		}
		else {
			serverTemplateImpl.setTemplateFile(templateFile);
		}

		serverTemplateImpl.setTemplateIOS(templateIOS);
		serverTemplateImpl.setTemplateAndroid(templateAndroid);
		serverTemplateImpl.setDefaultServer(defaultServer);

		serverTemplateImpl.resetOriginalValues();

		return serverTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		serverTemplateId = objectInput.readLong();
		groupId = objectInput.readLong();
		name = objectInput.readUTF();
		type = objectInput.readInt();
		prefixURL = objectInput.readUTF();
		suffixURL = objectInput.readUTF();
		secExt = objectInput.readUTF();
		templateURL = objectInput.readUTF();
		prefixFile = objectInput.readUTF();
		suffixFile = objectInput.readUTF();
		templateFile = objectInput.readUTF();
		templateIOS = objectInput.readLong();
		templateAndroid = objectInput.readLong();
		defaultServer = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(serverTemplateId);
		objectOutput.writeLong(groupId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(type);

		if (prefixURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(prefixURL);
		}

		if (suffixURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(suffixURL);
		}

		if (secExt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secExt);
		}

		if (templateURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateURL);
		}

		if (prefixFile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(prefixFile);
		}

		if (suffixFile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(suffixFile);
		}

		if (templateFile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateFile);
		}

		objectOutput.writeLong(templateIOS);
		objectOutput.writeLong(templateAndroid);
		objectOutput.writeInt(defaultServer);
	}

	public long serverTemplateId;
	public long groupId;
	public String name;
	public int type;
	public String prefixURL;
	public String suffixURL;
	public String secExt;
	public String templateURL;
	public String prefixFile;
	public String suffixFile;
	public String templateFile;
	public long templateIOS;
	public long templateAndroid;
	public int defaultServer;
}