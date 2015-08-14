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
 * This class is a wrapper for {@link LegacyVideoHitlist}.
 * </p>
 *
 * @author unihh
 * @see LegacyVideoHitlist
 * @generated
 */
public class LegacyVideoHitlistWrapper implements LegacyVideoHitlist,
	ModelWrapper<LegacyVideoHitlist> {
	public LegacyVideoHitlistWrapper(LegacyVideoHitlist legacyVideoHitlist) {
		_legacyVideoHitlist = legacyVideoHitlist;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyVideoHitlist.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyVideoHitlist.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("hitsperday", getHitsperday());
		attributes.put("hitsperweek", getHitsperweek());
		attributes.put("hitspermonth", getHitspermonth());
		attributes.put("hitsperyear", getHitsperyear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long hitsperday = (Long)attributes.get("hitsperday");

		if (hitsperday != null) {
			setHitsperday(hitsperday);
		}

		Long hitsperweek = (Long)attributes.get("hitsperweek");

		if (hitsperweek != null) {
			setHitsperweek(hitsperweek);
		}

		Long hitspermonth = (Long)attributes.get("hitspermonth");

		if (hitspermonth != null) {
			setHitspermonth(hitspermonth);
		}

		Long hitsperyear = (Long)attributes.get("hitsperyear");

		if (hitsperyear != null) {
			setHitsperyear(hitsperyear);
		}
	}

	/**
	* Returns the primary key of this legacy video hitlist.
	*
	* @return the primary key of this legacy video hitlist
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyVideoHitlist.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy video hitlist.
	*
	* @param primaryKey the primary key of this legacy video hitlist
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyVideoHitlist.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy video hitlist.
	*
	* @return the ID of this legacy video hitlist
	*/
	@Override
	public long getId() {
		return _legacyVideoHitlist.getId();
	}

	/**
	* Sets the ID of this legacy video hitlist.
	*
	* @param id the ID of this legacy video hitlist
	*/
	@Override
	public void setId(long id) {
		_legacyVideoHitlist.setId(id);
	}

	/**
	* Returns the hitsperday of this legacy video hitlist.
	*
	* @return the hitsperday of this legacy video hitlist
	*/
	@Override
	public long getHitsperday() {
		return _legacyVideoHitlist.getHitsperday();
	}

	/**
	* Sets the hitsperday of this legacy video hitlist.
	*
	* @param hitsperday the hitsperday of this legacy video hitlist
	*/
	@Override
	public void setHitsperday(long hitsperday) {
		_legacyVideoHitlist.setHitsperday(hitsperday);
	}

	/**
	* Returns the hitsperweek of this legacy video hitlist.
	*
	* @return the hitsperweek of this legacy video hitlist
	*/
	@Override
	public long getHitsperweek() {
		return _legacyVideoHitlist.getHitsperweek();
	}

	/**
	* Sets the hitsperweek of this legacy video hitlist.
	*
	* @param hitsperweek the hitsperweek of this legacy video hitlist
	*/
	@Override
	public void setHitsperweek(long hitsperweek) {
		_legacyVideoHitlist.setHitsperweek(hitsperweek);
	}

	/**
	* Returns the hitspermonth of this legacy video hitlist.
	*
	* @return the hitspermonth of this legacy video hitlist
	*/
	@Override
	public long getHitspermonth() {
		return _legacyVideoHitlist.getHitspermonth();
	}

	/**
	* Sets the hitspermonth of this legacy video hitlist.
	*
	* @param hitspermonth the hitspermonth of this legacy video hitlist
	*/
	@Override
	public void setHitspermonth(long hitspermonth) {
		_legacyVideoHitlist.setHitspermonth(hitspermonth);
	}

	/**
	* Returns the hitsperyear of this legacy video hitlist.
	*
	* @return the hitsperyear of this legacy video hitlist
	*/
	@Override
	public long getHitsperyear() {
		return _legacyVideoHitlist.getHitsperyear();
	}

	/**
	* Sets the hitsperyear of this legacy video hitlist.
	*
	* @param hitsperyear the hitsperyear of this legacy video hitlist
	*/
	@Override
	public void setHitsperyear(long hitsperyear) {
		_legacyVideoHitlist.setHitsperyear(hitsperyear);
	}

	@Override
	public boolean isNew() {
		return _legacyVideoHitlist.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyVideoHitlist.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyVideoHitlist.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyVideoHitlist.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyVideoHitlist.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyVideoHitlist.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyVideoHitlist.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyVideoHitlist.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyVideoHitlist.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyVideoHitlist.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyVideoHitlist.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyVideoHitlistWrapper((LegacyVideoHitlist)_legacyVideoHitlist.clone());
	}

	@Override
	public int compareTo(LegacyVideoHitlist legacyVideoHitlist) {
		return _legacyVideoHitlist.compareTo(legacyVideoHitlist);
	}

	@Override
	public int hashCode() {
		return _legacyVideoHitlist.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<LegacyVideoHitlist> toCacheModel() {
		return _legacyVideoHitlist.toCacheModel();
	}

	@Override
	public LegacyVideoHitlist toEscapedModel() {
		return new LegacyVideoHitlistWrapper(_legacyVideoHitlist.toEscapedModel());
	}

	@Override
	public LegacyVideoHitlist toUnescapedModel() {
		return new LegacyVideoHitlistWrapper(_legacyVideoHitlist.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyVideoHitlist.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyVideoHitlist.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyVideoHitlist.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyVideoHitlistWrapper)) {
			return false;
		}

		LegacyVideoHitlistWrapper legacyVideoHitlistWrapper = (LegacyVideoHitlistWrapper)obj;

		if (Validator.equals(_legacyVideoHitlist,
					legacyVideoHitlistWrapper._legacyVideoHitlist)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyVideoHitlist getWrappedLegacyVideoHitlist() {
		return _legacyVideoHitlist;
	}

	@Override
	public LegacyVideoHitlist getWrappedModel() {
		return _legacyVideoHitlist;
	}

	@Override
	public void resetOriginalValues() {
		_legacyVideoHitlist.resetOriginalValues();
	}

	private LegacyVideoHitlist _legacyVideoHitlist;
}