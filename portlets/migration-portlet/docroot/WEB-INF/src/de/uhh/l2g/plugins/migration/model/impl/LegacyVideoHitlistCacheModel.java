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

import de.uhh.l2g.plugins.migration.model.LegacyVideoHitlist;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyVideoHitlist in entity cache.
 *
 * @author unihh
 * @see LegacyVideoHitlist
 * @generated
 */
public class LegacyVideoHitlistCacheModel implements CacheModel<LegacyVideoHitlist>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", hitsperday=");
		sb.append(hitsperday);
		sb.append(", hitsperweek=");
		sb.append(hitsperweek);
		sb.append(", hitspermonth=");
		sb.append(hitspermonth);
		sb.append(", hitsperyear=");
		sb.append(hitsperyear);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyVideoHitlist toEntityModel() {
		LegacyVideoHitlistImpl legacyVideoHitlistImpl = new LegacyVideoHitlistImpl();

		legacyVideoHitlistImpl.setId(id);
		legacyVideoHitlistImpl.setHitsperday(hitsperday);
		legacyVideoHitlistImpl.setHitsperweek(hitsperweek);
		legacyVideoHitlistImpl.setHitspermonth(hitspermonth);
		legacyVideoHitlistImpl.setHitsperyear(hitsperyear);

		legacyVideoHitlistImpl.resetOriginalValues();

		return legacyVideoHitlistImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		hitsperday = objectInput.readLong();
		hitsperweek = objectInput.readLong();
		hitspermonth = objectInput.readLong();
		hitsperyear = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(hitsperday);
		objectOutput.writeLong(hitsperweek);
		objectOutput.writeLong(hitspermonth);
		objectOutput.writeLong(hitsperyear);
	}

	public long id;
	public long hitsperday;
	public long hitsperweek;
	public long hitspermonth;
	public long hitsperyear;
}