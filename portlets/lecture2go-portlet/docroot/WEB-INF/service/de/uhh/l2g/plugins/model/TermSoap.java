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
public class TermSoap implements Serializable {
	public static TermSoap toSoapModel(Term model) {
		TermSoap soapModel = new TermSoap();

		soapModel.setTermId(model.getTermId());
		soapModel.setParentId(model.getParentId());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setPrefix(model.getPrefix());
		soapModel.setYear(model.getYear());
		soapModel.setTranslation(model.getTranslation());

		return soapModel;
	}

	public static TermSoap[] toSoapModels(Term[] models) {
		TermSoap[] soapModels = new TermSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TermSoap[][] toSoapModels(Term[][] models) {
		TermSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TermSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TermSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TermSoap[] toSoapModels(List<Term> models) {
		List<TermSoap> soapModels = new ArrayList<TermSoap>(models.size());

		for (Term model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TermSoap[soapModels.size()]);
	}

	public TermSoap() {
	}

	public long getPrimaryKey() {
		return _termId;
	}

	public void setPrimaryKey(long pk) {
		setTermId(pk);
	}

	public long getTermId() {
		return _termId;
	}

	public void setTermId(long termId) {
		_termId = termId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public String getPrefix() {
		return _prefix;
	}

	public void setPrefix(String prefix) {
		_prefix = prefix;
	}

	public String getYear() {
		return _year;
	}

	public void setYear(String year) {
		_year = year;
	}

	public String getTranslation() {
		return _translation;
	}

	public void setTranslation(String translation) {
		_translation = translation;
	}

	private long _termId;
	private long _parentId;
	private String _languageId;
	private String _prefix;
	private String _year;
	private String _translation;
}