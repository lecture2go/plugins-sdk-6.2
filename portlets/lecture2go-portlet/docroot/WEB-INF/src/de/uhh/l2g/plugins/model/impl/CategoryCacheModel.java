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

import de.uhh.l2g.plugins.model.Category;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Category in entity cache.
 *
 * @author Iavor Sturm
 * @see Category
 * @generated
 */
public class CategoryCacheModel implements CacheModel<Category>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", translation=");
		sb.append(translation);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Category toEntityModel() {
		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setCategoryId(categoryId);
		categoryImpl.setParentId(parentId);

		if (languageId == null) {
			categoryImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			categoryImpl.setLanguageId(languageId);
		}

		if (name == null) {
			categoryImpl.setName(StringPool.BLANK);
		}
		else {
			categoryImpl.setName(name);
		}

		if (translation == null) {
			categoryImpl.setTranslation(StringPool.BLANK);
		}
		else {
			categoryImpl.setTranslation(translation);
		}

		categoryImpl.resetOriginalValues();

		return categoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		categoryId = objectInput.readLong();
		parentId = objectInput.readLong();
		languageId = objectInput.readUTF();
		name = objectInput.readUTF();
		translation = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(parentId);

		if (languageId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageId);
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

	public long categoryId;
	public long parentId;
	public String languageId;
	public String name;
	public String translation;
}