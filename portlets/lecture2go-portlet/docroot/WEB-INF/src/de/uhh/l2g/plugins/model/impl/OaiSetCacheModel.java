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

import de.uhh.l2g.plugins.model.OaiSet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OaiSet in entity cache.
 *
 * @author Iavor Sturm
 * @see OaiSet
 * @generated
 */
public class OaiSetCacheModel implements CacheModel<OaiSet>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{oaiSetId=");
		sb.append(oaiSetId);
		sb.append(", setSpec=");
		sb.append(setSpec);
		sb.append(", setName=");
		sb.append(setName);
		sb.append(", setDescription=");
		sb.append(setDescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OaiSet toEntityModel() {
		OaiSetImpl oaiSetImpl = new OaiSetImpl();

		oaiSetImpl.setOaiSetId(oaiSetId);

		if (setSpec == null) {
			oaiSetImpl.setSetSpec(StringPool.BLANK);
		}
		else {
			oaiSetImpl.setSetSpec(setSpec);
		}

		if (setName == null) {
			oaiSetImpl.setSetName(StringPool.BLANK);
		}
		else {
			oaiSetImpl.setSetName(setName);
		}

		if (setDescription == null) {
			oaiSetImpl.setSetDescription(StringPool.BLANK);
		}
		else {
			oaiSetImpl.setSetDescription(setDescription);
		}

		oaiSetImpl.resetOriginalValues();

		return oaiSetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		oaiSetId = objectInput.readLong();
		setSpec = objectInput.readUTF();
		setName = objectInput.readUTF();
		setDescription = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(oaiSetId);

		if (setSpec == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(setSpec);
		}

		if (setName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(setName);
		}

		if (setDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(setDescription);
		}
	}

	public long oaiSetId;
	public String setSpec;
	public String setName;
	public String setDescription;
}