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

package de.uhh.l2g.plugins.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Iavor Sturm
 * @generated
 */
public class InstallWizardSoap implements Serializable {
	public static InstallWizardSoap toSoapModel(InstallWizard model) {
		InstallWizardSoap soapModel = new InstallWizardSoap();

		soapModel.setInstallWizardId(model.getInstallWizardId());
		soapModel.setWizartActive(model.getWizartActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static InstallWizardSoap[] toSoapModels(InstallWizard[] models) {
		InstallWizardSoap[] soapModels = new InstallWizardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InstallWizardSoap[][] toSoapModels(InstallWizard[][] models) {
		InstallWizardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InstallWizardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InstallWizardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InstallWizardSoap[] toSoapModels(List<InstallWizard> models) {
		List<InstallWizardSoap> soapModels = new ArrayList<InstallWizardSoap>(models.size());

		for (InstallWizard model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InstallWizardSoap[soapModels.size()]);
	}

	public InstallWizardSoap() {
	}

	public long getPrimaryKey() {
		return _installWizardId;
	}

	public void setPrimaryKey(long pk) {
		setInstallWizardId(pk);
	}

	public long getInstallWizardId() {
		return _installWizardId;
	}

	public void setInstallWizardId(long installWizardId) {
		_installWizardId = installWizardId;
	}

	public int getWizartActive() {
		return _wizartActive;
	}

	public void setWizartActive(int wizartActive) {
		_wizartActive = wizartActive;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	private long _installWizardId;
	private int _wizartActive;
	private long _groupId;
	private long _companyId;
}