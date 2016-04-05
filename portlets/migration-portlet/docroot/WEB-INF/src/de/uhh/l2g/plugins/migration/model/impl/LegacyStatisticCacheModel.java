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

import de.uhh.l2g.plugins.migration.model.LegacyStatistic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegacyStatistic in entity cache.
 *
 * @author unihh
 * @see LegacyStatistic
 * @generated
 */
public class LegacyStatisticCacheModel implements CacheModel<LegacyStatistic>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", public_=");
		sb.append(public_);
		sb.append(", private_=");
		sb.append(private_);
		sb.append(", autofill=");
		sb.append(autofill);
		sb.append(", date_=");
		sb.append(date_);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyStatistic toEntityModel() {
		LegacyStatisticImpl legacyStatisticImpl = new LegacyStatisticImpl();

		legacyStatisticImpl.setId(id);
		legacyStatisticImpl.setPublic_(public_);
		legacyStatisticImpl.setPrivate_(private_);
		legacyStatisticImpl.setAutofill(autofill);

		if (date_ == Long.MIN_VALUE) {
			legacyStatisticImpl.setDate_(null);
		}
		else {
			legacyStatisticImpl.setDate_(new Date(date_));
		}

		legacyStatisticImpl.resetOriginalValues();

		return legacyStatisticImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		public_ = objectInput.readInt();
		private_ = objectInput.readInt();
		autofill = objectInput.readInt();
		date_ = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(id);
		objectOutput.writeInt(public_);
		objectOutput.writeInt(private_);
		objectOutput.writeInt(autofill);
		objectOutput.writeLong(date_);
	}

	public int id;
	public int public_;
	public int private_;
	public int autofill;
	public long date_;
}