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
 * This class is a wrapper for {@link LegacyLastVideoList}.
 * </p>
 *
 * @author unihh
 * @see LegacyLastVideoList
 * @generated
 */
public class LegacyLastVideoListWrapper implements LegacyLastVideoList,
	ModelWrapper<LegacyLastVideoList> {
	public LegacyLastVideoListWrapper(LegacyLastVideoList legacyLastVideoList) {
		_legacyLastVideoList = legacyLastVideoList;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyLastVideoList.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyLastVideoList.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("videoId", getVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}
	}

	/**
	* Returns the primary key of this legacy last video list.
	*
	* @return the primary key of this legacy last video list
	*/
	@Override
	public int getPrimaryKey() {
		return _legacyLastVideoList.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy last video list.
	*
	* @param primaryKey the primary key of this legacy last video list
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_legacyLastVideoList.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy last video list.
	*
	* @return the ID of this legacy last video list
	*/
	@Override
	public int getId() {
		return _legacyLastVideoList.getId();
	}

	/**
	* Sets the ID of this legacy last video list.
	*
	* @param id the ID of this legacy last video list
	*/
	@Override
	public void setId(int id) {
		_legacyLastVideoList.setId(id);
	}

	/**
	* Returns the video ID of this legacy last video list.
	*
	* @return the video ID of this legacy last video list
	*/
	@Override
	public long getVideoId() {
		return _legacyLastVideoList.getVideoId();
	}

	/**
	* Sets the video ID of this legacy last video list.
	*
	* @param videoId the video ID of this legacy last video list
	*/
	@Override
	public void setVideoId(long videoId) {
		_legacyLastVideoList.setVideoId(videoId);
	}

	@Override
	public boolean isNew() {
		return _legacyLastVideoList.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyLastVideoList.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyLastVideoList.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyLastVideoList.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyLastVideoList.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyLastVideoList.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyLastVideoList.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyLastVideoList.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyLastVideoList.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyLastVideoList.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyLastVideoList.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyLastVideoListWrapper((LegacyLastVideoList)_legacyLastVideoList.clone());
	}

	@Override
	public int compareTo(LegacyLastVideoList legacyLastVideoList) {
		return _legacyLastVideoList.compareTo(legacyLastVideoList);
	}

	@Override
	public int hashCode() {
		return _legacyLastVideoList.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<LegacyLastVideoList> toCacheModel() {
		return _legacyLastVideoList.toCacheModel();
	}

	@Override
	public LegacyLastVideoList toEscapedModel() {
		return new LegacyLastVideoListWrapper(_legacyLastVideoList.toEscapedModel());
	}

	@Override
	public LegacyLastVideoList toUnescapedModel() {
		return new LegacyLastVideoListWrapper(_legacyLastVideoList.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyLastVideoList.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyLastVideoList.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyLastVideoList.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyLastVideoListWrapper)) {
			return false;
		}

		LegacyLastVideoListWrapper legacyLastVideoListWrapper = (LegacyLastVideoListWrapper)obj;

		if (Validator.equals(_legacyLastVideoList,
					legacyLastVideoListWrapper._legacyLastVideoList)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyLastVideoList getWrappedLegacyLastVideoList() {
		return _legacyLastVideoList;
	}

	@Override
	public LegacyLastVideoList getWrappedModel() {
		return _legacyLastVideoList;
	}

	@Override
	public void resetOriginalValues() {
		_legacyLastVideoList.resetOriginalValues();
	}

	private LegacyLastVideoList _legacyLastVideoList;
}