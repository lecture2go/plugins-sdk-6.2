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
 * This class is a wrapper for {@link Term}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Term
 * @generated
 */
public class TermWrapper implements Term, ModelWrapper<Term> {
	public TermWrapper(Term term) {
		_term = term;
	}

	@Override
	public Class<?> getModelClass() {
		return Term.class;
	}

	@Override
	public String getModelClassName() {
		return Term.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("termId", getTermId());
		attributes.put("parentId", getParentId());
		attributes.put("languageId", getLanguageId());
		attributes.put("prefix", getPrefix());
		attributes.put("year", getYear());
		attributes.put("translation", getTranslation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
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

		String year = (String)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String translation = (String)attributes.get("translation");

		if (translation != null) {
			setTranslation(translation);
		}
	}

	/**
	* Returns the primary key of this term.
	*
	* @return the primary key of this term
	*/
	@Override
	public long getPrimaryKey() {
		return _term.getPrimaryKey();
	}

	/**
	* Sets the primary key of this term.
	*
	* @param primaryKey the primary key of this term
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_term.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the term ID of this term.
	*
	* @return the term ID of this term
	*/
	@Override
	public long getTermId() {
		return _term.getTermId();
	}

	/**
	* Sets the term ID of this term.
	*
	* @param termId the term ID of this term
	*/
	@Override
	public void setTermId(long termId) {
		_term.setTermId(termId);
	}

	/**
	* Returns the parent ID of this term.
	*
	* @return the parent ID of this term
	*/
	@Override
	public long getParentId() {
		return _term.getParentId();
	}

	/**
	* Sets the parent ID of this term.
	*
	* @param parentId the parent ID of this term
	*/
	@Override
	public void setParentId(long parentId) {
		_term.setParentId(parentId);
	}

	/**
	* Returns the language ID of this term.
	*
	* @return the language ID of this term
	*/
	@Override
	public java.lang.String getLanguageId() {
		return _term.getLanguageId();
	}

	/**
	* Sets the language ID of this term.
	*
	* @param languageId the language ID of this term
	*/
	@Override
	public void setLanguageId(java.lang.String languageId) {
		_term.setLanguageId(languageId);
	}

	/**
	* Returns the prefix of this term.
	*
	* @return the prefix of this term
	*/
	@Override
	public java.lang.String getPrefix() {
		return _term.getPrefix();
	}

	/**
	* Sets the prefix of this term.
	*
	* @param prefix the prefix of this term
	*/
	@Override
	public void setPrefix(java.lang.String prefix) {
		_term.setPrefix(prefix);
	}

	/**
	* Returns the year of this term.
	*
	* @return the year of this term
	*/
	@Override
	public java.lang.String getYear() {
		return _term.getYear();
	}

	/**
	* Sets the year of this term.
	*
	* @param year the year of this term
	*/
	@Override
	public void setYear(java.lang.String year) {
		_term.setYear(year);
	}

	/**
	* Returns the translation of this term.
	*
	* @return the translation of this term
	*/
	@Override
	public java.lang.String getTranslation() {
		return _term.getTranslation();
	}

	/**
	* Sets the translation of this term.
	*
	* @param translation the translation of this term
	*/
	@Override
	public void setTranslation(java.lang.String translation) {
		_term.setTranslation(translation);
	}

	@Override
	public boolean isNew() {
		return _term.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_term.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _term.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_term.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _term.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _term.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_term.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _term.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_term.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_term.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_term.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TermWrapper((Term)_term.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Term term) {
		return _term.compareTo(term);
	}

	@Override
	public int hashCode() {
		return _term.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Term> toCacheModel() {
		return _term.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Term toEscapedModel() {
		return new TermWrapper(_term.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Term toUnescapedModel() {
		return new TermWrapper(_term.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _term.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _term.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_term.persist();
	}

	@Override
	public java.lang.String getFullName() {
		return _term.getFullName();
	}

	@Override
	public void setFullName(java.lang.String fullName) {
		_term.setFullName(fullName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TermWrapper)) {
			return false;
		}

		TermWrapper termWrapper = (TermWrapper)obj;

		if (Validator.equals(_term, termWrapper._term)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Term getWrappedTerm() {
		return _term;
	}

	@Override
	public Term getWrappedModel() {
		return _term;
	}

	@Override
	public void resetOriginalValues() {
		_term.resetOriginalValues();
	}

	private Term _term;
}