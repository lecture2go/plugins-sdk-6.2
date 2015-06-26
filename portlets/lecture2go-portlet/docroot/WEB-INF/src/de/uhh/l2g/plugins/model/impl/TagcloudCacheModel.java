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

import de.uhh.l2g.plugins.model.Tagcloud;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Tagcloud in entity cache.
 *
 * @author Iavor Sturm
 * @see Tagcloud
 * @generated
 */
public class TagcloudCacheModel implements CacheModel<Tagcloud>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{tagcloudId=");
		sb.append(tagcloudId);
		sb.append(", objectClassType=");
		sb.append(objectClassType);
		sb.append(", objectId=");
		sb.append(objectId);
		sb.append(", tags=");
		sb.append(tags);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Tagcloud toEntityModel() {
		TagcloudImpl tagcloudImpl = new TagcloudImpl();

		tagcloudImpl.setTagcloudId(tagcloudId);

		if (objectClassType == null) {
			tagcloudImpl.setObjectClassType(StringPool.BLANK);
		}
		else {
			tagcloudImpl.setObjectClassType(objectClassType);
		}

		tagcloudImpl.setObjectId(objectId);

		if (tags == null) {
			tagcloudImpl.setTags(StringPool.BLANK);
		}
		else {
			tagcloudImpl.setTags(tags);
		}

		tagcloudImpl.resetOriginalValues();

		return tagcloudImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tagcloudId = objectInput.readLong();
		objectClassType = objectInput.readUTF();
		objectId = objectInput.readLong();
		tags = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tagcloudId);

		if (objectClassType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(objectClassType);
		}

		objectOutput.writeLong(objectId);

		if (tags == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tags);
		}
	}

	public long tagcloudId;
	public String objectClassType;
	public long objectId;
	public String tags;
}