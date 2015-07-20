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

package de.uhh.l2g.plugins.migration.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author unihh
 * @generated
 */
public class TestEntityTwoSoap implements Serializable {
	public static TestEntityTwoSoap toSoapModel(TestEntityTwo model) {
		TestEntityTwoSoap soapModel = new TestEntityTwoSoap();

		soapModel.setPlid(model.getPlid());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static TestEntityTwoSoap[] toSoapModels(TestEntityTwo[] models) {
		TestEntityTwoSoap[] soapModels = new TestEntityTwoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TestEntityTwoSoap[][] toSoapModels(TestEntityTwo[][] models) {
		TestEntityTwoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TestEntityTwoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TestEntityTwoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TestEntityTwoSoap[] toSoapModels(List<TestEntityTwo> models) {
		List<TestEntityTwoSoap> soapModels = new ArrayList<TestEntityTwoSoap>(models.size());

		for (TestEntityTwo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TestEntityTwoSoap[soapModels.size()]);
	}

	public TestEntityTwoSoap() {
	}

	public long getPrimaryKey() {
		return _plid;
	}

	public void setPrimaryKey(long pk) {
		setPlid(pk);
	}

	public long getPlid() {
		return _plid;
	}

	public void setPlid(long plid) {
		_plid = plid;
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

	private long _plid;
	private long _groupId;
	private long _companyId;
}