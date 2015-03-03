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

import de.uhh.l2g.plugins.model.Year;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Year in entity cache.
 *
 * @author Iavor Sturm
 * @see Year
 * @generated
 */
public class YearCacheModel implements CacheModel<Year>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{yearId=");
		sb.append(yearId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", prefix=");
		sb.append(prefix);
		sb.append(", name=");
		sb.append(name);
		sb.append(", translation=");
		sb.append(translation);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Year toEntityModel() {
		YearImpl yearImpl = new YearImpl();

		yearImpl.setYearId(yearId);
		yearImpl.setParentId(parentId);

		if (languageId == null) {
			yearImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			yearImpl.setLanguageId(languageId);
		}

		if (prefix == null) {
			yearImpl.setPrefix(StringPool.BLANK);
		}
		else {
			yearImpl.setPrefix(prefix);
		}

		if (name == null) {
			yearImpl.setName(StringPool.BLANK);
		}
		else {
			yearImpl.setName(name);
		}

		if (translation == null) {
			yearImpl.setTranslation(StringPool.BLANK);
		}
		else {
			yearImpl.setTranslation(translation);
		}

		yearImpl.resetOriginalValues();

		return yearImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		yearId = objectInput.readLong();
		parentId = objectInput.readLong();
		languageId = objectInput.readUTF();
		prefix = objectInput.readUTF();
		name = objectInput.readUTF();
		translation = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(yearId);
		objectOutput.writeLong(parentId);

		if (languageId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageId);
		}

		if (prefix == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(prefix);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (translation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(translation);
		}
	}

	public long yearId;
	public long parentId;
	public String languageId;
	public String prefix;
	public String name;
	public String translation;
}