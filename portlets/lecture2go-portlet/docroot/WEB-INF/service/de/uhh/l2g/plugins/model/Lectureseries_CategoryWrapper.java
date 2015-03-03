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
 * This class is a wrapper for {@link Lectureseries_Category}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_Category
 * @generated
 */
public class Lectureseries_CategoryWrapper implements Lectureseries_Category,
	ModelWrapper<Lectureseries_Category> {
	public Lectureseries_CategoryWrapper(
		Lectureseries_Category lectureseries_Category) {
		_lectureseries_Category = lectureseries_Category;
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries_Category.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries_Category.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lectureseriesCategoryId", getLectureseriesCategoryId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("lectureseriesId", getLectureseriesId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesCategoryId = (Long)attributes.get(
				"lectureseriesCategoryId");

		if (lectureseriesCategoryId != null) {
			setLectureseriesCategoryId(lectureseriesCategoryId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}
	}

	/**
	* Returns the primary key of this lectureseries_ category.
	*
	* @return the primary key of this lectureseries_ category
	*/
	@Override
	public long getPrimaryKey() {
		return _lectureseries_Category.getPrimaryKey();
	}

	/**
	* Sets the primary key of this lectureseries_ category.
	*
	* @param primaryKey the primary key of this lectureseries_ category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lectureseries_Category.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the lectureseries category ID of this lectureseries_ category.
	*
	* @return the lectureseries category ID of this lectureseries_ category
	*/
	@Override
	public long getLectureseriesCategoryId() {
		return _lectureseries_Category.getLectureseriesCategoryId();
	}

	/**
	* Sets the lectureseries category ID of this lectureseries_ category.
	*
	* @param lectureseriesCategoryId the lectureseries category ID of this lectureseries_ category
	*/
	@Override
	public void setLectureseriesCategoryId(long lectureseriesCategoryId) {
		_lectureseries_Category.setLectureseriesCategoryId(lectureseriesCategoryId);
	}

	/**
	* Returns the category ID of this lectureseries_ category.
	*
	* @return the category ID of this lectureseries_ category
	*/
	@Override
	public long getCategoryId() {
		return _lectureseries_Category.getCategoryId();
	}

	/**
	* Sets the category ID of this lectureseries_ category.
	*
	* @param categoryId the category ID of this lectureseries_ category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_lectureseries_Category.setCategoryId(categoryId);
	}

	/**
	* Returns the lectureseries ID of this lectureseries_ category.
	*
	* @return the lectureseries ID of this lectureseries_ category
	*/
	@Override
	public long getLectureseriesId() {
		return _lectureseries_Category.getLectureseriesId();
	}

	/**
	* Sets the lectureseries ID of this lectureseries_ category.
	*
	* @param lectureseriesId the lectureseries ID of this lectureseries_ category
	*/
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_lectureseries_Category.setLectureseriesId(lectureseriesId);
	}

	@Override
	public boolean isNew() {
		return _lectureseries_Category.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lectureseries_Category.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lectureseries_Category.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lectureseries_Category.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lectureseries_Category.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lectureseries_Category.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lectureseries_Category.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lectureseries_Category.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lectureseries_Category.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lectureseries_Category.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lectureseries_Category.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Lectureseries_CategoryWrapper((Lectureseries_Category)_lectureseries_Category.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.Lectureseries_Category lectureseries_Category) {
		return _lectureseries_Category.compareTo(lectureseries_Category);
	}

	@Override
	public int hashCode() {
		return _lectureseries_Category.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Lectureseries_Category> toCacheModel() {
		return _lectureseries_Category.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Category toEscapedModel() {
		return new Lectureseries_CategoryWrapper(_lectureseries_Category.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Category toUnescapedModel() {
		return new Lectureseries_CategoryWrapper(_lectureseries_Category.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lectureseries_Category.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lectureseries_Category.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lectureseries_Category.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Lectureseries_CategoryWrapper)) {
			return false;
		}

		Lectureseries_CategoryWrapper lectureseries_CategoryWrapper = (Lectureseries_CategoryWrapper)obj;

		if (Validator.equals(_lectureseries_Category,
					lectureseries_CategoryWrapper._lectureseries_Category)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Lectureseries_Category getWrappedLectureseries_Category() {
		return _lectureseries_Category;
	}

	@Override
	public Lectureseries_Category getWrappedModel() {
		return _lectureseries_Category;
	}

	@Override
	public void resetOriginalValues() {
		_lectureseries_Category.resetOriginalValues();
	}

	private Lectureseries_Category _lectureseries_Category;
}