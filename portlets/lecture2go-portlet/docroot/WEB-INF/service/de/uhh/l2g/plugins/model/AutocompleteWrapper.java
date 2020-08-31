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
 * This class is a wrapper for {@link Autocomplete}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Autocomplete
 * @generated
 */
public class AutocompleteWrapper implements Autocomplete,
	ModelWrapper<Autocomplete> {
	public AutocompleteWrapper(Autocomplete autocomplete) {
		_autocomplete = autocomplete;
	}

	@Override
	public Class<?> getModelClass() {
		return Autocomplete.class;
	}

	@Override
	public String getModelClassName() {
		return Autocomplete.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("autocompleteId", getAutocompleteId());
		attributes.put("searchWordsJson", getSearchWordsJson());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long autocompleteId = (Long)attributes.get("autocompleteId");

		if (autocompleteId != null) {
			setAutocompleteId(autocompleteId);
		}

		String searchWordsJson = (String)attributes.get("searchWordsJson");

		if (searchWordsJson != null) {
			setSearchWordsJson(searchWordsJson);
		}
	}

	/**
	* Returns the primary key of this autocomplete.
	*
	* @return the primary key of this autocomplete
	*/
	@Override
	public long getPrimaryKey() {
		return _autocomplete.getPrimaryKey();
	}

	/**
	* Sets the primary key of this autocomplete.
	*
	* @param primaryKey the primary key of this autocomplete
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_autocomplete.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the autocomplete ID of this autocomplete.
	*
	* @return the autocomplete ID of this autocomplete
	*/
	@Override
	public long getAutocompleteId() {
		return _autocomplete.getAutocompleteId();
	}

	/**
	* Sets the autocomplete ID of this autocomplete.
	*
	* @param autocompleteId the autocomplete ID of this autocomplete
	*/
	@Override
	public void setAutocompleteId(long autocompleteId) {
		_autocomplete.setAutocompleteId(autocompleteId);
	}

	/**
	* Returns the search words json of this autocomplete.
	*
	* @return the search words json of this autocomplete
	*/
	@Override
	public java.lang.String getSearchWordsJson() {
		return _autocomplete.getSearchWordsJson();
	}

	/**
	* Sets the search words json of this autocomplete.
	*
	* @param searchWordsJson the search words json of this autocomplete
	*/
	@Override
	public void setSearchWordsJson(java.lang.String searchWordsJson) {
		_autocomplete.setSearchWordsJson(searchWordsJson);
	}

	@Override
	public boolean isNew() {
		return _autocomplete.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_autocomplete.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _autocomplete.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_autocomplete.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _autocomplete.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _autocomplete.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_autocomplete.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _autocomplete.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_autocomplete.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_autocomplete.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_autocomplete.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AutocompleteWrapper((Autocomplete)_autocomplete.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Autocomplete autocomplete) {
		return _autocomplete.compareTo(autocomplete);
	}

	@Override
	public int hashCode() {
		return _autocomplete.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Autocomplete> toCacheModel() {
		return _autocomplete.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Autocomplete toEscapedModel() {
		return new AutocompleteWrapper(_autocomplete.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Autocomplete toUnescapedModel() {
		return new AutocompleteWrapper(_autocomplete.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _autocomplete.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _autocomplete.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_autocomplete.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AutocompleteWrapper)) {
			return false;
		}

		AutocompleteWrapper autocompleteWrapper = (AutocompleteWrapper)obj;

		if (Validator.equals(_autocomplete, autocompleteWrapper._autocomplete)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Autocomplete getWrappedAutocomplete() {
		return _autocomplete;
	}

	@Override
	public Autocomplete getWrappedModel() {
		return _autocomplete;
	}

	@Override
	public void resetOriginalValues() {
		_autocomplete.resetOriginalValues();
	}

	private Autocomplete _autocomplete;
}