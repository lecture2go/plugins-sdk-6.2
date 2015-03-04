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
public class CreatorSoap implements Serializable {
	public static CreatorSoap toSoapModel(Creator model) {
		CreatorSoap soapModel = new CreatorSoap();

		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setJobTitle(model.getJobTitle());
		soapModel.setGender(model.getGender());

		return soapModel;
	}

	public static CreatorSoap[] toSoapModels(Creator[] models) {
		CreatorSoap[] soapModels = new CreatorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CreatorSoap[][] toSoapModels(Creator[][] models) {
		CreatorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CreatorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CreatorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CreatorSoap[] toSoapModels(List<Creator> models) {
		List<CreatorSoap> soapModels = new ArrayList<CreatorSoap>(models.size());

		for (Creator model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CreatorSoap[soapModels.size()]);
	}

	public CreatorSoap() {
	}

	public long getPrimaryKey() {
		return _creatorId;
	}

	public void setPrimaryKey(long pk) {
		setCreatorId(pk);
	}

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	private long _creatorId;
	private String _firstName;
	private String _lastName;
	private String _middleName;
	private String _jobTitle;
	private String _gender;
}