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

import de.uhh.l2g.plugins.model.Institution;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Institution in entity cache.
 *
 * @author Iavor Sturm
 * @see Institution
 * @generated
 */
public class InstitutionCacheModel implements CacheModel<Institution>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{institutionId=");
		sb.append(institutionId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", typ=");
		sb.append(typ);
		sb.append(", www=");
		sb.append(www);
		sb.append(", level=");
		sb.append(level);
		sb.append(", sort=");
		sb.append(sort);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Institution toEntityModel() {
		InstitutionImpl institutionImpl = new InstitutionImpl();

		institutionImpl.setInstitutionId(institutionId);
		institutionImpl.setParentId(parentId);

		if (name == null) {
			institutionImpl.setName(StringPool.BLANK);
		}
		else {
			institutionImpl.setName(name);
		}

		if (typ == null) {
			institutionImpl.setTyp(StringPool.BLANK);
		}
		else {
			institutionImpl.setTyp(typ);
		}

		if (www == null) {
			institutionImpl.setWww(StringPool.BLANK);
		}
		else {
			institutionImpl.setWww(www);
		}

		institutionImpl.setLevel(level);
		institutionImpl.setSort(sort);
		institutionImpl.setGroupId(groupId);

		institutionImpl.resetOriginalValues();

		return institutionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		institutionId = objectInput.readLong();
		parentId = objectInput.readLong();
		name = objectInput.readUTF();
		typ = objectInput.readUTF();
		www = objectInput.readUTF();
		level = objectInput.readInt();
		sort = objectInput.readInt();
		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(institutionId);
		objectOutput.writeLong(parentId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (typ == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typ);
		}

		if (www == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(www);
		}

		objectOutput.writeInt(level);
		objectOutput.writeInt(sort);
		objectOutput.writeLong(groupId);
	}

	public long institutionId;
	public long parentId;
	public String name;
	public String typ;
	public String www;
	public int level;
	public int sort;
	public long groupId;
}