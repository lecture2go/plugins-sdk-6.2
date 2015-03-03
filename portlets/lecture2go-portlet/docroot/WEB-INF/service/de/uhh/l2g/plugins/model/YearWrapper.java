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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Year}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Year
 * @generated
 */
public class YearWrapper implements Year, ModelWrapper<Year> {
	public YearWrapper(Year year) {
		_year = year;
	}

	@Override
	public Class<?> getModelClass() {
		return Year.class;
	}

	@Override
	public String getModelClassName() {
		return Year.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("yearId", getYearId());
		attributes.put("parentId", getParentId());
		attributes.put("languageId", getLanguageId());
		attributes.put("prefix", getPrefix());
		attributes.put("name", getName());
		attributes.put("translation", getTranslation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long yearId = (Long)attributes.get("yearId");

		if (yearId != null) {
			setYearId(yearId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String prefix = (String)attributes.get("prefix");

		if (prefix != null) {
			setPrefix(prefix);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String translation = (String)attributes.get("translation");

		if (translation != null) {
			setTranslation(translation);
		}
	}

	/**
	* Returns the primary key of this year.
	*
	* @return the primary key of this year
	*/
	@Override
	public long getPrimaryKey() {
		return _year.getPrimaryKey();
	}

	/**
	* Sets the primary key of this year.
	*
	* @param primaryKey the primary key of this year
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_year.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the year ID of this year.
	*
	* @return the year ID of this year
	*/
	@Override
	public long getYearId() {
		return _year.getYearId();
	}

	/**
	* Sets the year ID of this year.
	*
	* @param yearId the year ID of this year
	*/
	@Override
	public void setYearId(long yearId) {
		_year.setYearId(yearId);
	}

	/**
	* Returns the parent ID of this year.
	*
	* @return the parent ID of this year
	*/
	@Override
	public long getParentId() {
		return _year.getParentId();
	}

	/**
	* Sets the parent ID of this year.
	*
	* @param parentId the parent ID of this year
	*/
	@Override
	public void setParentId(long parentId) {
		_year.setParentId(parentId);
	}

	/**
	* Returns the language ID of this year.
	*
	* @return the language ID of this year
	*/
	@Override
	public java.lang.String getLanguageId() {
		return _year.getLanguageId();
	}

	/**
	* Sets the language ID of this year.
	*
	* @param languageId the language ID of this year
	*/
	@Override
	public void setLanguageId(java.lang.String languageId) {
		_year.setLanguageId(languageId);
	}

	/**
	* Returns the prefix of this year.
	*
	* @return the prefix of this year
	*/
	@Override
	public java.lang.String getPrefix() {
		return _year.getPrefix();
	}

	/**
	* Sets the prefix of this year.
	*
	* @param prefix the prefix of this year
	*/
	@Override
	public void setPrefix(java.lang.String prefix) {
		_year.setPrefix(prefix);
	}

	/**
	* Returns the name of this year.
	*
	* @return the name of this year
	*/
	@Override
	public java.lang.String getName() {
		return _year.getName();
	}

	/**
	* Sets the name of this year.
	*
	* @param name the name of this year
	*/
	@Override
	public void setName(java.lang.String name) {
		_year.setName(name);
	}

	/**
	* Returns the translation of this year.
	*
	* @return the translation of this year
	*/
	@Override
	public java.lang.String getTranslation() {
		return _year.getTranslation();
	}

	/**
	* Sets the translation of this year.
	*
	* @param translation the translation of this year
	*/
	@Override
	public void setTranslation(java.lang.String translation) {
		_year.setTranslation(translation);
	}

	@Override
	public boolean isNew() {
		return _year.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_year.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _year.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_year.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _year.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _year.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_year.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _year.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_year.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_year.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_year.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new YearWrapper((Year)_year.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Year year) {
		return _year.compareTo(year);
	}

	@Override
	public int hashCode() {
		return _year.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Year> toCacheModel() {
		return _year.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Year toEscapedModel() {
		return new YearWrapper(_year.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Year toUnescapedModel() {
		return new YearWrapper(_year.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _year.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _year.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_year.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof YearWrapper)) {
			return false;
		}

		YearWrapper yearWrapper = (YearWrapper)obj;

		if (Validator.equals(_year, yearWrapper._year)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Year getWrappedYear() {
		return _year;
	}

	@Override
	public Year getWrappedModel() {
		return _year;
	}

	@Override
	public void resetOriginalValues() {
		_year.resetOriginalValues();
	}

	private Year _year;
}