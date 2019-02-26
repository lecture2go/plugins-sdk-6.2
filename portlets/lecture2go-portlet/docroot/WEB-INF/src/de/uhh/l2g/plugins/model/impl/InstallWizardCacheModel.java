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

import de.uhh.l2g.plugins.model.InstallWizard;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing InstallWizard in entity cache.
 *
 * @author Iavor Sturm
 * @see InstallWizard
 * @generated
 */
public class InstallWizardCacheModel implements CacheModel<InstallWizard>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{installWizardId=");
		sb.append(installWizardId);
		sb.append(", wizartActive=");
		sb.append(wizartActive);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InstallWizard toEntityModel() {
		InstallWizardImpl installWizardImpl = new InstallWizardImpl();

		installWizardImpl.setInstallWizardId(installWizardId);
		installWizardImpl.setWizartActive(wizartActive);
		installWizardImpl.setGroupId(groupId);
		installWizardImpl.setCompanyId(companyId);

		installWizardImpl.resetOriginalValues();

		return installWizardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		installWizardId = objectInput.readLong();
		wizartActive = objectInput.readInt();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(installWizardId);
		objectOutput.writeInt(wizartActive);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
	}

	public long installWizardId;
	public int wizartActive;
	public long groupId;
	public long companyId;
}