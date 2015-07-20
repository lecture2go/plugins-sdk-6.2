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
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.migration.model.TestEntityTwo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TestEntityTwo in entity cache.
 *
 * @author unihh
 * @see TestEntityTwo
 * @generated
 */
public class TestEntityTwoCacheModel implements CacheModel<TestEntityTwo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{plid=");
		sb.append(plid);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TestEntityTwo toEntityModel() {
		TestEntityTwoImpl testEntityTwoImpl = new TestEntityTwoImpl();

		testEntityTwoImpl.setPlid(plid);
		testEntityTwoImpl.setGroupId(groupId);
		testEntityTwoImpl.setCompanyId(companyId);

		testEntityTwoImpl.resetOriginalValues();

		return testEntityTwoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		plid = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(plid);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
	}

	public long plid;
	public long groupId;
	public long companyId;
}