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

import de.uhh.l2g.plugins.model.License;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing License in entity cache.
 *
 * @author Iavor Sturm
 * @see License
 * @generated
 */
public class LicenseCacheModel implements CacheModel<License>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{licenseId=");
		sb.append(licenseId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", shortIdentifier=");
		sb.append(shortIdentifier);
		sb.append(", url=");
		sb.append(url);
		sb.append(", schemeName=");
		sb.append(schemeName);
		sb.append(", schemeUrl=");
		sb.append(schemeUrl);
		sb.append(", selectable=");
		sb.append(selectable);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public License toEntityModel() {
		LicenseImpl licenseImpl = new LicenseImpl();

		licenseImpl.setLicenseId(licenseId);

		if (fullName == null) {
			licenseImpl.setFullName(StringPool.BLANK);
		}
		else {
			licenseImpl.setFullName(fullName);
		}

		if (shortIdentifier == null) {
			licenseImpl.setShortIdentifier(StringPool.BLANK);
		}
		else {
			licenseImpl.setShortIdentifier(shortIdentifier);
		}

		if (url == null) {
			licenseImpl.setUrl(StringPool.BLANK);
		}
		else {
			licenseImpl.setUrl(url);
		}

		if (schemeName == null) {
			licenseImpl.setSchemeName(StringPool.BLANK);
		}
		else {
			licenseImpl.setSchemeName(schemeName);
		}

		if (schemeUrl == null) {
			licenseImpl.setSchemeUrl(StringPool.BLANK);
		}
		else {
			licenseImpl.setSchemeUrl(schemeUrl);
		}

		licenseImpl.setSelectable(selectable);

		if (description == null) {
			licenseImpl.setDescription(StringPool.BLANK);
		}
		else {
			licenseImpl.setDescription(description);
		}

		licenseImpl.resetOriginalValues();

		return licenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		licenseId = objectInput.readLong();
		fullName = objectInput.readUTF();
		shortIdentifier = objectInput.readUTF();
		url = objectInput.readUTF();
		schemeName = objectInput.readUTF();
		schemeUrl = objectInput.readUTF();
		selectable = objectInput.readBoolean();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(licenseId);

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (shortIdentifier == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortIdentifier);
		}

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (schemeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(schemeName);
		}

		if (schemeUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(schemeUrl);
		}

		objectOutput.writeBoolean(selectable);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long licenseId;
	public String fullName;
	public String shortIdentifier;
	public String url;
	public String schemeName;
	public String schemeUrl;
	public boolean selectable;
	public String description;
}