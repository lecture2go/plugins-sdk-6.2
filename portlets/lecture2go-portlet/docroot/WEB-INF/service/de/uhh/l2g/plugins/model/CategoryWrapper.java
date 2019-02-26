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
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Category
 * @generated
 */
public class CategoryWrapper implements Category, ModelWrapper<Category> {
	public CategoryWrapper(Category category) {
		_category = category;
	}

	@Override
	public Class<?> getModelClass() {
		return Category.class;
	}

	@Override
	public String getModelClassName() {
		return Category.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("parentId", getParentId());
		attributes.put("languageId", getLanguageId());
		attributes.put("name", getName());
		attributes.put("translation", getTranslation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
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
	* Returns the primary key of this category.
	*
	* @return the primary key of this category
	*/
	@Override
	public long getPrimaryKey() {
		return _category.getPrimaryKey();
	}

	/**
	* Sets the primary key of this category.
	*
	* @param primaryKey the primary key of this category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_category.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this category.
	*
	* @return the category ID of this category
	*/
	@Override
	public long getCategoryId() {
		return _category.getCategoryId();
	}

	/**
	* Sets the category ID of this category.
	*
	* @param categoryId the category ID of this category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_category.setCategoryId(categoryId);
	}

	/**
	* Returns the parent ID of this category.
	*
	* @return the parent ID of this category
	*/
	@Override
	public long getParentId() {
		return _category.getParentId();
	}

	/**
	* Sets the parent ID of this category.
	*
	* @param parentId the parent ID of this category
	*/
	@Override
	public void setParentId(long parentId) {
		_category.setParentId(parentId);
	}

	/**
	* Returns the language ID of this category.
	*
	* @return the language ID of this category
	*/
	@Override
	public java.lang.String getLanguageId() {
		return _category.getLanguageId();
	}

	/**
	* Sets the language ID of this category.
	*
	* @param languageId the language ID of this category
	*/
	@Override
	public void setLanguageId(java.lang.String languageId) {
		_category.setLanguageId(languageId);
	}

	/**
	* Returns the name of this category.
	*
	* @return the name of this category
	*/
	@Override
	public java.lang.String getName() {
		return _category.getName();
	}

	/**
	* Sets the name of this category.
	*
	* @param name the name of this category
	*/
	@Override
	public void setName(java.lang.String name) {
		_category.setName(name);
	}

	/**
	* Returns the translation of this category.
	*
	* @return the translation of this category
	*/
	@Override
	public java.lang.String getTranslation() {
		return _category.getTranslation();
	}

	/**
	* Sets the translation of this category.
	*
	* @param translation the translation of this category
	*/
	@Override
	public void setTranslation(java.lang.String translation) {
		_category.setTranslation(translation);
	}

	@Override
	public boolean isNew() {
		return _category.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_category.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _category.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_category.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _category.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _category.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_category.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _category.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_category.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_category.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_category.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CategoryWrapper((Category)_category.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Category category) {
		return _category.compareTo(category);
	}

	@Override
	public int hashCode() {
		return _category.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Category> toCacheModel() {
		return _category.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Category toEscapedModel() {
		return new CategoryWrapper(_category.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Category toUnescapedModel() {
		return new CategoryWrapper(_category.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _category.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _category.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_category.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CategoryWrapper)) {
			return false;
		}

		CategoryWrapper categoryWrapper = (CategoryWrapper)obj;

		if (Validator.equals(_category, categoryWrapper._category)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Category getWrappedCategory() {
		return _category;
	}

	@Override
	public Category getWrappedModel() {
		return _category;
	}

	@Override
	public void resetOriginalValues() {
		_category.resetOriginalValues();
	}

	private Category _category;
}