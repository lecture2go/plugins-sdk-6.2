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
 * This class is a wrapper for {@link LegacyStatistic}.
 * </p>
 *
 * @author unihh
 * @see LegacyStatistic
 * @generated
 */
public class LegacyStatisticWrapper implements LegacyStatistic,
	ModelWrapper<LegacyStatistic> {
	public LegacyStatisticWrapper(LegacyStatistic legacyStatistic) {
		_legacyStatistic = legacyStatistic;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyStatistic.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyStatistic.class.getName();
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
	* Returns the primary key of this legacy statistic.
	*
	* @return the primary key of this legacy statistic
	*/
	@Override
	public int getPrimaryKey() {
		return _legacyStatistic.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy statistic.
	*
	* @param primaryKey the primary key of this legacy statistic
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_legacyStatistic.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy statistic.
	*
	* @return the ID of this legacy statistic
	*/
	@Override
	public int getId() {
		return _legacyStatistic.getId();
	}

	/**
	* Sets the ID of this legacy statistic.
	*
	* @param id the ID of this legacy statistic
	*/
	@Override
	public void setId(int id) {
		_legacyStatistic.setId(id);
	}

	/**
	* Returns the public_ of this legacy statistic.
	*
	* @return the public_ of this legacy statistic
	*/
	@Override
	public int getPublic_() {
		return _legacyStatistic.getPublic_();
	}

	/**
	* Sets the public_ of this legacy statistic.
	*
	* @param public_ the public_ of this legacy statistic
	*/
	@Override
	public void setPublic_(int public_) {
		_legacyStatistic.setPublic_(public_);
	}

	/**
	* Returns the private_ of this legacy statistic.
	*
	* @return the private_ of this legacy statistic
	*/
	@Override
	public int getPrivate_() {
		return _legacyStatistic.getPrivate_();
	}

	/**
	* Sets the private_ of this legacy statistic.
	*
	* @param private_ the private_ of this legacy statistic
	*/
	@Override
	public void setPrivate_(int private_) {
		_legacyStatistic.setPrivate_(private_);
	}

	/**
	* Returns the autofill of this legacy statistic.
	*
	* @return the autofill of this legacy statistic
	*/
	@Override
	public int getAutofill() {
		return _legacyStatistic.getAutofill();
	}

	/**
	* Sets the autofill of this legacy statistic.
	*
	* @param autofill the autofill of this legacy statistic
	*/
	@Override
	public void setAutofill(int autofill) {
		_legacyStatistic.setAutofill(autofill);
	}

	/**
	* Returns the date_ of this legacy statistic.
	*
	* @return the date_ of this legacy statistic
	*/
	@Override
	public java.util.Date getDate_() {
		return _legacyStatistic.getDate_();
	}

	/**
	* Sets the date_ of this legacy statistic.
	*
	* @param date_ the date_ of this legacy statistic
	*/
	@Override
	public void setDate_(java.util.Date date_) {
		_legacyStatistic.setDate_(date_);
	}

	@Override
	public boolean isNew() {
		return _legacyStatistic.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyStatistic.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyStatistic.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyStatistic.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyStatistic.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyStatistic.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyStatistic.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyStatistic.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyStatistic.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyStatistic.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyStatistic.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyStatisticWrapper((LegacyStatistic)_legacyStatistic.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyStatistic legacyStatistic) {
		return _legacyStatistic.compareTo(legacyStatistic);
	}

	@Override
	public int hashCode() {
		return _legacyStatistic.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyStatistic> toCacheModel() {
		return _legacyStatistic.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyStatistic toEscapedModel() {
		return new LegacyStatisticWrapper(_legacyStatistic.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyStatistic toUnescapedModel() {
		return new LegacyStatisticWrapper(_legacyStatistic.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyStatistic.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyStatistic.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyStatistic.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyStatisticWrapper)) {
			return false;
		}

		LegacyStatisticWrapper legacyStatisticWrapper = (LegacyStatisticWrapper)obj;

		if (Validator.equals(_legacyStatistic,
					legacyStatisticWrapper._legacyStatistic)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyStatistic getWrappedLegacyStatistic() {
		return _legacyStatistic;
	}

	@Override
	public LegacyStatistic getWrappedModel() {
		return _legacyStatistic;
	}

	@Override
	public void resetOriginalValues() {
		_legacyStatistic.resetOriginalValues();
	}

	private LegacyStatistic _legacyStatistic;
}