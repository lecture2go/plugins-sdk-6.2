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
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.model.OaiRecord_OaiSet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OaiRecord_OaiSet in entity cache.
 *
 * @author Iavor Sturm
 * @see OaiRecord_OaiSet
 * @generated
 */
public class OaiRecord_OaiSetCacheModel implements CacheModel<OaiRecord_OaiSet>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{oaiRecordOaiSetId=");
		sb.append(oaiRecordOaiSetId);
		sb.append(", oaiRecordId=");
		sb.append(oaiRecordId);
		sb.append(", oaiSetId=");
		sb.append(oaiSetId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OaiRecord_OaiSet toEntityModel() {
		OaiRecord_OaiSetImpl oaiRecord_OaiSetImpl = new OaiRecord_OaiSetImpl();

		oaiRecord_OaiSetImpl.setOaiRecordOaiSetId(oaiRecordOaiSetId);
		oaiRecord_OaiSetImpl.setOaiRecordId(oaiRecordId);
		oaiRecord_OaiSetImpl.setOaiSetId(oaiSetId);

		oaiRecord_OaiSetImpl.resetOriginalValues();

		return oaiRecord_OaiSetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		oaiRecordOaiSetId = objectInput.readLong();
		oaiRecordId = objectInput.readLong();
		oaiSetId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(oaiRecordOaiSetId);
		objectOutput.writeLong(oaiRecordId);
		objectOutput.writeLong(oaiSetId);
	}

	public long oaiRecordOaiSetId;
	public long oaiRecordId;
	public long oaiSetId;
}