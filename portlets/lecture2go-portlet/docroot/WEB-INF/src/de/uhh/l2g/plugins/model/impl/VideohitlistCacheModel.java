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
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.model.Videohitlist;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Videohitlist in entity cache.
 *
 * @author Iavor Sturm
 * @see Videohitlist
 * @generated
 */
public class VideohitlistCacheModel implements CacheModel<Videohitlist>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{videohitlistId=");
		sb.append(videohitlistId);
		sb.append(", hitsPerDay=");
		sb.append(hitsPerDay);
		sb.append(", hitsPerWeek=");
		sb.append(hitsPerWeek);
		sb.append(", hitsPerMonth=");
		sb.append(hitsPerMonth);
		sb.append(", hitsPerYear=");
		sb.append(hitsPerYear);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Videohitlist toEntityModel() {
		VideohitlistImpl videohitlistImpl = new VideohitlistImpl();

		videohitlistImpl.setVideohitlistId(videohitlistId);
		videohitlistImpl.setHitsPerDay(hitsPerDay);
		videohitlistImpl.setHitsPerWeek(hitsPerWeek);
		videohitlistImpl.setHitsPerMonth(hitsPerMonth);
		videohitlistImpl.setHitsPerYear(hitsPerYear);

		videohitlistImpl.resetOriginalValues();

		return videohitlistImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		videohitlistId = objectInput.readInt();
		hitsPerDay = objectInput.readInt();
		hitsPerWeek = objectInput.readInt();
		hitsPerMonth = objectInput.readInt();
		hitsPerYear = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(videohitlistId);
		objectOutput.writeInt(hitsPerDay);
		objectOutput.writeInt(hitsPerWeek);
		objectOutput.writeInt(hitsPerMonth);
		objectOutput.writeInt(hitsPerYear);
	}

	public int videohitlistId;
	public int hitsPerDay;
	public int hitsPerWeek;
	public int hitsPerMonth;
	public int hitsPerYear;
}