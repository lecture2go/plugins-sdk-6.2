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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegacyLectureSeries}.
 * </p>
 *
 * @author unihh
 * @see LegacyLectureSeries
 * @generated
 */
public class LegacyLectureSeriesWrapper implements LegacyLectureSeries,
	ModelWrapper<LegacyLectureSeries> {
	public LegacyLectureSeriesWrapper(LegacyLectureSeries legacyLectureSeries) {
		_legacyLectureSeries = legacyLectureSeries;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyLectureSeries.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyLectureSeries.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("number", getNumber());
		attributes.put("eventType", getEventType());
		attributes.put("eventCategory", getEventCategory());
		attributes.put("name", getName());
		attributes.put("shortDesc", getShortDesc());
		attributes.put("semesterName", getSemesterName());
		attributes.put("language", getLanguage());
		attributes.put("facultyName", getFacultyName());
		attributes.put("instructorsString", getInstructorsString());
		attributes.put("id", getId());
		attributes.put("password", getPassword());
		attributes.put("approved", getApproved());
		attributes.put("longDesc", getLongDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String number = (String)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String eventCategory = (String)attributes.get("eventCategory");

		if (eventCategory != null) {
			setEventCategory(eventCategory);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String shortDesc = (String)attributes.get("shortDesc");

		if (shortDesc != null) {
			setShortDesc(shortDesc);
		}

		String semesterName = (String)attributes.get("semesterName");

		if (semesterName != null) {
			setSemesterName(semesterName);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String facultyName = (String)attributes.get("facultyName");

		if (facultyName != null) {
			setFacultyName(facultyName);
		}

		String instructorsString = (String)attributes.get("instructorsString");

		if (instructorsString != null) {
			setInstructorsString(instructorsString);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Integer approved = (Integer)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}

		String longDesc = (String)attributes.get("longDesc");

		if (longDesc != null) {
			setLongDesc(longDesc);
		}
	}

	/**
	* Returns the primary key of this legacy lecture series.
	*
	* @return the primary key of this legacy lecture series
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyLectureSeries.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy lecture series.
	*
	* @param primaryKey the primary key of this legacy lecture series
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyLectureSeries.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the number of this legacy lecture series.
	*
	* @return the number of this legacy lecture series
	*/
	@Override
	public java.lang.String getNumber() {
		return _legacyLectureSeries.getNumber();
	}

	/**
	* Sets the number of this legacy lecture series.
	*
	* @param number the number of this legacy lecture series
	*/
	@Override
	public void setNumber(java.lang.String number) {
		_legacyLectureSeries.setNumber(number);
	}

	/**
	* Returns the event type of this legacy lecture series.
	*
	* @return the event type of this legacy lecture series
	*/
	@Override
	public java.lang.String getEventType() {
		return _legacyLectureSeries.getEventType();
	}

	/**
	* Sets the event type of this legacy lecture series.
	*
	* @param eventType the event type of this legacy lecture series
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_legacyLectureSeries.setEventType(eventType);
	}

	/**
	* Returns the event category of this legacy lecture series.
	*
	* @return the event category of this legacy lecture series
	*/
	@Override
	public java.lang.String getEventCategory() {
		return _legacyLectureSeries.getEventCategory();
	}

	/**
	* Sets the event category of this legacy lecture series.
	*
	* @param eventCategory the event category of this legacy lecture series
	*/
	@Override
	public void setEventCategory(java.lang.String eventCategory) {
		_legacyLectureSeries.setEventCategory(eventCategory);
	}

	/**
	* Returns the name of this legacy lecture series.
	*
	* @return the name of this legacy lecture series
	*/
	@Override
	public java.lang.String getName() {
		return _legacyLectureSeries.getName();
	}

	/**
	* Sets the name of this legacy lecture series.
	*
	* @param name the name of this legacy lecture series
	*/
	@Override
	public void setName(java.lang.String name) {
		_legacyLectureSeries.setName(name);
	}

	/**
	* Returns the short desc of this legacy lecture series.
	*
	* @return the short desc of this legacy lecture series
	*/
	@Override
	public java.lang.String getShortDesc() {
		return _legacyLectureSeries.getShortDesc();
	}

	/**
	* Sets the short desc of this legacy lecture series.
	*
	* @param shortDesc the short desc of this legacy lecture series
	*/
	@Override
	public void setShortDesc(java.lang.String shortDesc) {
		_legacyLectureSeries.setShortDesc(shortDesc);
	}

	/**
	* Returns the semester name of this legacy lecture series.
	*
	* @return the semester name of this legacy lecture series
	*/
	@Override
	public java.lang.String getSemesterName() {
		return _legacyLectureSeries.getSemesterName();
	}

	/**
	* Sets the semester name of this legacy lecture series.
	*
	* @param semesterName the semester name of this legacy lecture series
	*/
	@Override
	public void setSemesterName(java.lang.String semesterName) {
		_legacyLectureSeries.setSemesterName(semesterName);
	}

	/**
	* Returns the language of this legacy lecture series.
	*
	* @return the language of this legacy lecture series
	*/
	@Override
	public java.lang.String getLanguage() {
		return _legacyLectureSeries.getLanguage();
	}

	/**
	* Sets the language of this legacy lecture series.
	*
	* @param language the language of this legacy lecture series
	*/
	@Override
	public void setLanguage(java.lang.String language) {
		_legacyLectureSeries.setLanguage(language);
	}

	/**
	* Returns the faculty name of this legacy lecture series.
	*
	* @return the faculty name of this legacy lecture series
	*/
	@Override
	public java.lang.String getFacultyName() {
		return _legacyLectureSeries.getFacultyName();
	}

	/**
	* Sets the faculty name of this legacy lecture series.
	*
	* @param facultyName the faculty name of this legacy lecture series
	*/
	@Override
	public void setFacultyName(java.lang.String facultyName) {
		_legacyLectureSeries.setFacultyName(facultyName);
	}

	/**
	* Returns the instructors string of this legacy lecture series.
	*
	* @return the instructors string of this legacy lecture series
	*/
	@Override
	public java.lang.String getInstructorsString() {
		return _legacyLectureSeries.getInstructorsString();
	}

	/**
	* Sets the instructors string of this legacy lecture series.
	*
	* @param instructorsString the instructors string of this legacy lecture series
	*/
	@Override
	public void setInstructorsString(java.lang.String instructorsString) {
		_legacyLectureSeries.setInstructorsString(instructorsString);
	}

	/**
	* Returns the ID of this legacy lecture series.
	*
	* @return the ID of this legacy lecture series
	*/
	@Override
	public long getId() {
		return _legacyLectureSeries.getId();
	}

	/**
	* Sets the ID of this legacy lecture series.
	*
	* @param id the ID of this legacy lecture series
	*/
	@Override
	public void setId(long id) {
		_legacyLectureSeries.setId(id);
	}

	/**
	* Returns the password of this legacy lecture series.
	*
	* @return the password of this legacy lecture series
	*/
	@Override
	public java.lang.String getPassword() {
		return _legacyLectureSeries.getPassword();
	}

	/**
	* Sets the password of this legacy lecture series.
	*
	* @param password the password of this legacy lecture series
	*/
	@Override
	public void setPassword(java.lang.String password) {
		_legacyLectureSeries.setPassword(password);
	}

	/**
	* Returns the approved of this legacy lecture series.
	*
	* @return the approved of this legacy lecture series
	*/
	@Override
	public int getApproved() {
		return _legacyLectureSeries.getApproved();
	}

	/**
	* Sets the approved of this legacy lecture series.
	*
	* @param approved the approved of this legacy lecture series
	*/
	@Override
	public void setApproved(int approved) {
		_legacyLectureSeries.setApproved(approved);
	}

	/**
	* Returns the long desc of this legacy lecture series.
	*
	* @return the long desc of this legacy lecture series
	*/
	@Override
	public java.lang.String getLongDesc() {
		return _legacyLectureSeries.getLongDesc();
	}

	/**
	* Sets the long desc of this legacy lecture series.
	*
	* @param longDesc the long desc of this legacy lecture series
	*/
	@Override
	public void setLongDesc(java.lang.String longDesc) {
		_legacyLectureSeries.setLongDesc(longDesc);
	}

	@Override
	public boolean isNew() {
		return _legacyLectureSeries.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyLectureSeries.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyLectureSeries.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyLectureSeries.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyLectureSeries.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyLectureSeries.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyLectureSeries.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyLectureSeries.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyLectureSeries.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyLectureSeries.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyLectureSeries.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyLectureSeriesWrapper((LegacyLectureSeries)_legacyLectureSeries.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeries legacyLectureSeries) {
		return _legacyLectureSeries.compareTo(legacyLectureSeries);
	}

	@Override
	public int hashCode() {
		return _legacyLectureSeries.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyLectureSeries> toCacheModel() {
		return _legacyLectureSeries.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries toEscapedModel() {
		return new LegacyLectureSeriesWrapper(_legacyLectureSeries.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries toUnescapedModel() {
		return new LegacyLectureSeriesWrapper(_legacyLectureSeries.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyLectureSeries.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyLectureSeries.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyLectureSeries.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyLectureSeriesWrapper)) {
			return false;
		}

		LegacyLectureSeriesWrapper legacyLectureSeriesWrapper = (LegacyLectureSeriesWrapper)obj;

		if (Validator.equals(_legacyLectureSeries,
					legacyLectureSeriesWrapper._legacyLectureSeries)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyLectureSeries getWrappedLegacyLectureSeries() {
		return _legacyLectureSeries;
	}

	@Override
	public LegacyLectureSeries getWrappedModel() {
		return _legacyLectureSeries;
	}

	@Override
	public void resetOriginalValues() {
		_legacyLectureSeries.resetOriginalValues();
	}

	private LegacyLectureSeries _legacyLectureSeries;
}