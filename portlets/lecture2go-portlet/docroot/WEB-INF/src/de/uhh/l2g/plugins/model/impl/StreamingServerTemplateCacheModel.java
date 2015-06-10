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

import de.uhh.l2g.plugins.model.StreamingServerTemplate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StreamingServerTemplate in entity cache.
 *
 * @author Iavor Sturm
 * @see StreamingServerTemplate
 * @generated
 */
public class StreamingServerTemplateCacheModel implements CacheModel<StreamingServerTemplate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{streamingServerTemplateId=");
		sb.append(streamingServerTemplateId);
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
	public StreamingServerTemplate toEntityModel() {
		StreamingServerTemplateImpl streamingServerTemplateImpl = new StreamingServerTemplateImpl();

		streamingServerTemplateImpl.setStreamingServerTemplateId(streamingServerTemplateId);
		streamingServerTemplateImpl.setGroupId(groupId);

		if (name == null) {
			streamingServerTemplateImpl.setName(StringPool.BLANK);
		}
		else {
			streamingServerTemplateImpl.setName(name);
		}

		streamingServerTemplateImpl.setType(type);

		if (prefixURL == null) {
			streamingServerTemplateImpl.setPrefixURL(StringPool.BLANK);
		}
		else {
			streamingServerTemplateImpl.setPrefixURL(prefixURL);
		}

		if (suffixURL == null) {
			streamingServerTemplateImpl.setSuffixURL(StringPool.BLANK);
		}
		else {
			streamingServerTemplateImpl.setSuffixURL(suffixURL);
		}

		if (secExt == null) {
			streamingServerTemplateImpl.setSecExt(StringPool.BLANK);
		}
		else {
			streamingServerTemplateImpl.setSecExt(secExt);
		}

		if (templateURL == null) {
			streamingServerTemplateImpl.setTemplateURL(StringPool.BLANK);
		}
		else {
			streamingServerTemplateImpl.setTemplateURL(templateURL);
		}

		if (prefixFile == null) {
			streamingServerTemplateImpl.setPrefixFile(StringPool.BLANK);
		}
		else {
			streamingServerTemplateImpl.setPrefixFile(prefixFile);
		}

		if (suffixFile == null) {
			streamingServerTemplateImpl.setSuffixFile(StringPool.BLANK);
		}
		else {
			streamingServerTemplateImpl.setSuffixFile(suffixFile);
		}

		if (templateFile == null) {
			streamingServerTemplateImpl.setTemplateFile(StringPool.BLANK);
		}
		else {
			streamingServerTemplateImpl.setTemplateFile(templateFile);
		}

		streamingServerTemplateImpl.setTemplateIOS(templateIOS);
		streamingServerTemplateImpl.setTemplateAndroid(templateAndroid);
		streamingServerTemplateImpl.setDefaultServer(defaultServer);

		streamingServerTemplateImpl.resetOriginalValues();

		return streamingServerTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		streamingServerTemplateId = objectInput.readLong();
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
		objectOutput.writeLong(streamingServerTemplateId);
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

	public long streamingServerTemplateId;
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