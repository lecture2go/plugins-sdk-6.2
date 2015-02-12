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
 * This class is a wrapper for {@link Videohitlist}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Videohitlist
 * @generated
 */
public class VideohitlistWrapper implements Videohitlist,
	ModelWrapper<Videohitlist> {
	public VideohitlistWrapper(Videohitlist videohitlist) {
		_videohitlist = videohitlist;
	}

	@Override
	public Class<?> getModelClass() {
		return Videohitlist.class;
	}

	@Override
	public String getModelClassName() {
		return Videohitlist.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videohitlistId", getVideohitlistId());
		attributes.put("hitsPerDay", getHitsPerDay());
		attributes.put("hitsPerWeek", getHitsPerWeek());
		attributes.put("hitsPerMonth", getHitsPerMonth());
		attributes.put("hitsPerYear", getHitsPerYear());
		attributes.put("videoId", getVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videohitlistId = (Long)attributes.get("videohitlistId");

		if (videohitlistId != null) {
			setVideohitlistId(videohitlistId);
		}

		Long hitsPerDay = (Long)attributes.get("hitsPerDay");

		if (hitsPerDay != null) {
			setHitsPerDay(hitsPerDay);
		}

		Long hitsPerWeek = (Long)attributes.get("hitsPerWeek");

		if (hitsPerWeek != null) {
			setHitsPerWeek(hitsPerWeek);
		}

		Long hitsPerMonth = (Long)attributes.get("hitsPerMonth");

		if (hitsPerMonth != null) {
			setHitsPerMonth(hitsPerMonth);
		}

		Long hitsPerYear = (Long)attributes.get("hitsPerYear");

		if (hitsPerYear != null) {
			setHitsPerYear(hitsPerYear);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}
	}

	/**
	* Returns the primary key of this videohitlist.
	*
	* @return the primary key of this videohitlist
	*/
	@Override
	public long getPrimaryKey() {
		return _videohitlist.getPrimaryKey();
	}

	/**
	* Sets the primary key of this videohitlist.
	*
	* @param primaryKey the primary key of this videohitlist
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_videohitlist.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the videohitlist ID of this videohitlist.
	*
	* @return the videohitlist ID of this videohitlist
	*/
	@Override
	public long getVideohitlistId() {
		return _videohitlist.getVideohitlistId();
	}

	/**
	* Sets the videohitlist ID of this videohitlist.
	*
	* @param videohitlistId the videohitlist ID of this videohitlist
	*/
	@Override
	public void setVideohitlistId(long videohitlistId) {
		_videohitlist.setVideohitlistId(videohitlistId);
	}

	/**
	* Returns the hits per day of this videohitlist.
	*
	* @return the hits per day of this videohitlist
	*/
	@Override
	public long getHitsPerDay() {
		return _videohitlist.getHitsPerDay();
	}

	/**
	* Sets the hits per day of this videohitlist.
	*
	* @param hitsPerDay the hits per day of this videohitlist
	*/
	@Override
	public void setHitsPerDay(long hitsPerDay) {
		_videohitlist.setHitsPerDay(hitsPerDay);
	}

	/**
	* Returns the hits per week of this videohitlist.
	*
	* @return the hits per week of this videohitlist
	*/
	@Override
	public long getHitsPerWeek() {
		return _videohitlist.getHitsPerWeek();
	}

	/**
	* Sets the hits per week of this videohitlist.
	*
	* @param hitsPerWeek the hits per week of this videohitlist
	*/
	@Override
	public void setHitsPerWeek(long hitsPerWeek) {
		_videohitlist.setHitsPerWeek(hitsPerWeek);
	}

	/**
	* Returns the hits per month of this videohitlist.
	*
	* @return the hits per month of this videohitlist
	*/
	@Override
	public long getHitsPerMonth() {
		return _videohitlist.getHitsPerMonth();
	}

	/**
	* Sets the hits per month of this videohitlist.
	*
	* @param hitsPerMonth the hits per month of this videohitlist
	*/
	@Override
	public void setHitsPerMonth(long hitsPerMonth) {
		_videohitlist.setHitsPerMonth(hitsPerMonth);
	}

	/**
	* Returns the hits per year of this videohitlist.
	*
	* @return the hits per year of this videohitlist
	*/
	@Override
	public long getHitsPerYear() {
		return _videohitlist.getHitsPerYear();
	}

	/**
	* Sets the hits per year of this videohitlist.
	*
	* @param hitsPerYear the hits per year of this videohitlist
	*/
	@Override
	public void setHitsPerYear(long hitsPerYear) {
		_videohitlist.setHitsPerYear(hitsPerYear);
	}

	/**
	* Returns the video ID of this videohitlist.
	*
	* @return the video ID of this videohitlist
	*/
	@Override
	public long getVideoId() {
		return _videohitlist.getVideoId();
	}

	/**
	* Sets the video ID of this videohitlist.
	*
	* @param videoId the video ID of this videohitlist
	*/
	@Override
	public void setVideoId(long videoId) {
		_videohitlist.setVideoId(videoId);
	}

	@Override
	public boolean isNew() {
		return _videohitlist.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_videohitlist.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _videohitlist.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_videohitlist.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _videohitlist.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _videohitlist.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videohitlist.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videohitlist.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_videohitlist.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_videohitlist.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videohitlist.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideohitlistWrapper((Videohitlist)_videohitlist.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Videohitlist videohitlist) {
		return _videohitlist.compareTo(videohitlist);
	}

	@Override
	public int hashCode() {
		return _videohitlist.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Videohitlist> toCacheModel() {
		return _videohitlist.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Videohitlist toEscapedModel() {
		return new VideohitlistWrapper(_videohitlist.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Videohitlist toUnescapedModel() {
		return new VideohitlistWrapper(_videohitlist.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videohitlist.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _videohitlist.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videohitlist.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideohitlistWrapper)) {
			return false;
		}

		VideohitlistWrapper videohitlistWrapper = (VideohitlistWrapper)obj;

		if (Validator.equals(_videohitlist, videohitlistWrapper._videohitlist)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Videohitlist getWrappedVideohitlist() {
		return _videohitlist;
	}

	@Override
	public Videohitlist getWrappedModel() {
		return _videohitlist;
	}

	@Override
	public void resetOriginalValues() {
		_videohitlist.resetOriginalValues();
	}

	private Videohitlist _videohitlist;
}