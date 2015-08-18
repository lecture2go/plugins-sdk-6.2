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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.migration.model.LegacyL2gSys;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegacyL2gSys in entity cache.
 *
 * @author unihh
 * @see LegacyL2gSys
 * @generated
 */
public class LegacyL2gSysCacheModel implements CacheModel<LegacyL2gSys>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", version=");
		sb.append(version);
		sb.append(", setupwizard=");
		sb.append(setupwizard);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegacyL2gSys toEntityModel() {
		LegacyL2gSysImpl legacyL2gSysImpl = new LegacyL2gSysImpl();

		legacyL2gSysImpl.setId(id);

		if (version == null) {
			legacyL2gSysImpl.setVersion(StringPool.BLANK);
		}
		else {
			legacyL2gSysImpl.setVersion(version);
		}

		legacyL2gSysImpl.setSetupwizard(setupwizard);

		legacyL2gSysImpl.resetOriginalValues();

		return legacyL2gSysImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		version = objectInput.readUTF();
		setupwizard = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(id);

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}

		objectOutput.writeInt(setupwizard);
	}

	public int id;
	public String version;
	public int setupwizard;
}