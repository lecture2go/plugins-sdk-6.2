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

import de.uhh.l2g.plugins.model.Term;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Term in entity cache.
 *
 * @author Iavor Sturm
 * @see Term
 * @generated
 */
public class TermCacheModel implements CacheModel<Term>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{termId=");
		sb.append(termId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", prefix=");
		sb.append(prefix);
		sb.append(", year=");
		sb.append(year);
		sb.append(", translation=");
		sb.append(translation);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Term toEntityModel() {
		TermImpl termImpl = new TermImpl();

		termImpl.setTermId(termId);
		termImpl.setParentId(parentId);

		if (languageId == null) {
			termImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			termImpl.setLanguageId(languageId);
		}

		if (prefix == null) {
			termImpl.setPrefix(StringPool.BLANK);
		}
		else {
			termImpl.setPrefix(prefix);
		}

		if (year == null) {
			termImpl.setYear(StringPool.BLANK);
		}
		else {
			termImpl.setYear(year);
		}

		if (translation == null) {
			termImpl.setTranslation(StringPool.BLANK);
		}
		else {
			termImpl.setTranslation(translation);
		}

		termImpl.resetOriginalValues();

		return termImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		termId = objectInput.readLong();
		parentId = objectInput.readLong();
		languageId = objectInput.readUTF();
		prefix = objectInput.readUTF();
		year = objectInput.readUTF();
		translation = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(termId);
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

		if (year == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(year);
		}

		if (translation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(translation);
		}
	}

	public long termId;
	public long parentId;
	public String languageId;
	public String prefix;
	public String year;
	public String translation;
}