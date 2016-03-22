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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegacyStatistics}.
 * </p>
 *
 * @author unihh
 * @see LegacyStatistics
 * @generated
 */
public class LegacyStatisticsWrapper implements LegacyStatistics,
	ModelWrapper<LegacyStatistics> {
	public LegacyStatisticsWrapper(LegacyStatistics legacyStatistics) {
		_legacyStatistics = legacyStatistics;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyStatistics.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyStatistics.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("public_", getPublic_());
		attributes.put("private_", getPrivate_());
		attributes.put("autofill", getAutofill());
		attributes.put("date_", getDate_());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer public_ = (Integer)attributes.get("public_");

		if (public_ != null) {
			setPublic_(public_);
		}

		Integer private_ = (Integer)attributes.get("private_");

		if (private_ != null) {
			setPrivate_(private_);
		}

		Integer autofill = (Integer)attributes.get("autofill");

		if (autofill != null) {
			setAutofill(autofill);
		}

		Date date_ = (Date)attributes.get("date_");

		if (date_ != null) {
			setDate_(date_);
		}
	}

	/**
	* Returns the primary key of this legacy statistics.
	*
	* @return the primary key of this legacy statistics
	*/
	@Override
	public int getPrimaryKey() {
		return _legacyStatistics.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy statistics.
	*
	* @param primaryKey the primary key of this legacy statistics
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_legacyStatistics.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy statistics.
	*
	* @return the ID of this legacy statistics
	*/
	@Override
	public int getId() {
		return _legacyStatistics.getId();
	}

	/**
	* Sets the ID of this legacy statistics.
	*
	* @param id the ID of this legacy statistics
	*/
	@Override
	public void setId(int id) {
		_legacyStatistics.setId(id);
	}

	/**
	* Returns the public_ of this legacy statistics.
	*
	* @return the public_ of this legacy statistics
	*/
	@Override
	public int getPublic_() {
		return _legacyStatistics.getPublic_();
	}

	/**
	* Sets the public_ of this legacy statistics.
	*
	* @param public_ the public_ of this legacy statistics
	*/
	@Override
	public void setPublic_(int public_) {
		_legacyStatistics.setPublic_(public_);
	}

	/**
	* Returns the private_ of this legacy statistics.
	*
	* @return the private_ of this legacy statistics
	*/
	@Override
	public int getPrivate_() {
		return _legacyStatistics.getPrivate_();
	}

	/**
	* Sets the private_ of this legacy statistics.
	*
	* @param private_ the private_ of this legacy statistics
	*/
	@Override
	public void setPrivate_(int private_) {
		_legacyStatistics.setPrivate_(private_);
	}

	/**
	* Returns the autofill of this legacy statistics.
	*
	* @return the autofill of this legacy statistics
	*/
	@Override
	public int getAutofill() {
		return _legacyStatistics.getAutofill();
	}

	/**
	* Sets the autofill of this legacy statistics.
	*
	* @param autofill the autofill of this legacy statistics
	*/
	@Override
	public void setAutofill(int autofill) {
		_legacyStatistics.setAutofill(autofill);
	}

	/**
	* Returns the date_ of this legacy statistics.
	*
	* @return the date_ of this legacy statistics
	*/
	@Override
	public java.util.Date getDate_() {
		return _legacyStatistics.getDate_();
	}

	/**
	* Sets the date_ of this legacy statistics.
	*
	* @param date_ the date_ of this legacy statistics
	*/
	@Override
	public void setDate_(java.util.Date date_) {
		_legacyStatistics.setDate_(date_);
	}

	@Override
	public boolean isNew() {
		return _legacyStatistics.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyStatistics.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyStatistics.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyStatistics.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyStatistics.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyStatistics.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyStatistics.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyStatistics.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyStatistics.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyStatistics.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyStatistics.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyStatisticsWrapper((LegacyStatistics)_legacyStatistics.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyStatistics legacyStatistics) {
		return _legacyStatistics.compareTo(legacyStatistics);
	}

	@Override
	public int hashCode() {
		return _legacyStatistics.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyStatistics> toCacheModel() {
		return _legacyStatistics.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyStatistics toEscapedModel() {
		return new LegacyStatisticsWrapper(_legacyStatistics.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyStatistics toUnescapedModel() {
		return new LegacyStatisticsWrapper(_legacyStatistics.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyStatistics.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyStatistics.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyStatistics.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyStatisticsWrapper)) {
			return false;
		}

		LegacyStatisticsWrapper legacyStatisticsWrapper = (LegacyStatisticsWrapper)obj;

		if (Validator.equals(_legacyStatistics,
					legacyStatisticsWrapper._legacyStatistics)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyStatistics getWrappedLegacyStatistics() {
		return _legacyStatistics;
	}

	@Override
	public LegacyStatistics getWrappedModel() {
		return _legacyStatistics;
	}

	@Override
	public void resetOriginalValues() {
		_legacyStatistics.resetOriginalValues();
	}

	private LegacyStatistics _legacyStatistics;
}