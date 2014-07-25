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
		StringBundler sb = new StringBundler(19);

		sb.append("{licenseId=");
		sb.append(licenseId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", ccby=");
		sb.append(ccby);
		sb.append(", ccbybc=");
		sb.append(ccbybc);
		sb.append(", ccbyncnd=");
		sb.append(ccbyncnd);
		sb.append(", ccbyncsa=");
		sb.append(ccbyncsa);
		sb.append(", ccbysa=");
		sb.append(ccbysa);
		sb.append(", ccbync=");
		sb.append(ccbync);
		sb.append(", l2go=");
		sb.append(l2go);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public License toEntityModel() {
		LicenseImpl licenseImpl = new LicenseImpl();

		licenseImpl.setLicenseId(licenseId);
		licenseImpl.setVideoId(videoId);

		if (ccby == null) {
			licenseImpl.setCcby(StringPool.BLANK);
		}
		else {
			licenseImpl.setCcby(ccby);
		}

		if (ccbybc == null) {
			licenseImpl.setCcbybc(StringPool.BLANK);
		}
		else {
			licenseImpl.setCcbybc(ccbybc);
		}

		if (ccbyncnd == null) {
			licenseImpl.setCcbyncnd(StringPool.BLANK);
		}
		else {
			licenseImpl.setCcbyncnd(ccbyncnd);
		}

		if (ccbyncsa == null) {
			licenseImpl.setCcbyncsa(StringPool.BLANK);
		}
		else {
			licenseImpl.setCcbyncsa(ccbyncsa);
		}

		if (ccbysa == null) {
			licenseImpl.setCcbysa(StringPool.BLANK);
		}
		else {
			licenseImpl.setCcbysa(ccbysa);
		}

		if (ccbync == null) {
			licenseImpl.setCcbync(StringPool.BLANK);
		}
		else {
			licenseImpl.setCcbync(ccbync);
		}

		if (l2go == null) {
			licenseImpl.setL2go(StringPool.BLANK);
		}
		else {
			licenseImpl.setL2go(l2go);
		}

		licenseImpl.resetOriginalValues();

		return licenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		licenseId = objectInput.readInt();
		videoId = objectInput.readInt();
		ccby = objectInput.readUTF();
		ccbybc = objectInput.readUTF();
		ccbyncnd = objectInput.readUTF();
		ccbyncsa = objectInput.readUTF();
		ccbysa = objectInput.readUTF();
		ccbync = objectInput.readUTF();
		l2go = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(licenseId);
		objectOutput.writeInt(videoId);

		if (ccby == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ccby);
		}

		if (ccbybc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ccbybc);
		}

		if (ccbyncnd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ccbyncnd);
		}

		if (ccbyncsa == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ccbyncsa);
		}

		if (ccbysa == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ccbysa);
		}

		if (ccbync == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ccbync);
		}

		if (l2go == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(l2go);
		}
	}

	public int licenseId;
	public int videoId;
	public String ccby;
	public String ccbybc;
	public String ccbyncnd;
	public String ccbyncsa;
	public String ccbysa;
	public String ccbync;
	public String l2go;
}