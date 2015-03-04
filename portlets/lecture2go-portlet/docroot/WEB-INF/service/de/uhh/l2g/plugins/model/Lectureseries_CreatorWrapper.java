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
 * This class is a wrapper for {@link Lectureseries_Creator}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_Creator
 * @generated
 */
public class Lectureseries_CreatorWrapper implements Lectureseries_Creator,
	ModelWrapper<Lectureseries_Creator> {
	public Lectureseries_CreatorWrapper(
		Lectureseries_Creator lectureseries_Creator) {
		_lectureseries_Creator = lectureseries_Creator;
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries_Creator.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries_Creator.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lectureseriesCreatorId", getLectureseriesCreatorId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("creatorId", getCreatorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesCreatorId = (Long)attributes.get(
				"lectureseriesCreatorId");

		if (lectureseriesCreatorId != null) {
			setLectureseriesCreatorId(lectureseriesCreatorId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}
	}

	/**
	* Returns the primary key of this lectureseries_ creator.
	*
	* @return the primary key of this lectureseries_ creator
	*/
	@Override
	public long getPrimaryKey() {
		return _lectureseries_Creator.getPrimaryKey();
	}

	/**
	* Sets the primary key of this lectureseries_ creator.
	*
	* @param primaryKey the primary key of this lectureseries_ creator
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lectureseries_Creator.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the lectureseries creator ID of this lectureseries_ creator.
	*
	* @return the lectureseries creator ID of this lectureseries_ creator
	*/
	@Override
	public long getLectureseriesCreatorId() {
		return _lectureseries_Creator.getLectureseriesCreatorId();
	}

	/**
	* Sets the lectureseries creator ID of this lectureseries_ creator.
	*
	* @param lectureseriesCreatorId the lectureseries creator ID of this lectureseries_ creator
	*/
	@Override
	public void setLectureseriesCreatorId(long lectureseriesCreatorId) {
		_lectureseries_Creator.setLectureseriesCreatorId(lectureseriesCreatorId);
	}

	/**
	* Returns the lectureseries ID of this lectureseries_ creator.
	*
	* @return the lectureseries ID of this lectureseries_ creator
	*/
	@Override
	public long getLectureseriesId() {
		return _lectureseries_Creator.getLectureseriesId();
	}

	/**
	* Sets the lectureseries ID of this lectureseries_ creator.
	*
	* @param lectureseriesId the lectureseries ID of this lectureseries_ creator
	*/
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_lectureseries_Creator.setLectureseriesId(lectureseriesId);
	}

	/**
	* Returns the creator ID of this lectureseries_ creator.
	*
	* @return the creator ID of this lectureseries_ creator
	*/
	@Override
	public long getCreatorId() {
		return _lectureseries_Creator.getCreatorId();
	}

	/**
	* Sets the creator ID of this lectureseries_ creator.
	*
	* @param creatorId the creator ID of this lectureseries_ creator
	*/
	@Override
	public void setCreatorId(long creatorId) {
		_lectureseries_Creator.setCreatorId(creatorId);
	}

	@Override
	public boolean isNew() {
		return _lectureseries_Creator.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_lectureseries_Creator.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _lectureseries_Creator.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lectureseries_Creator.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _lectureseries_Creator.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _lectureseries_Creator.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lectureseries_Creator.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lectureseries_Creator.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_lectureseries_Creator.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_lectureseries_Creator.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lectureseries_Creator.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Lectureseries_CreatorWrapper((Lectureseries_Creator)_lectureseries_Creator.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.Lectureseries_Creator lectureseries_Creator) {
		return _lectureseries_Creator.compareTo(lectureseries_Creator);
	}

	@Override
	public int hashCode() {
		return _lectureseries_Creator.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Lectureseries_Creator> toCacheModel() {
		return _lectureseries_Creator.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Creator toEscapedModel() {
		return new Lectureseries_CreatorWrapper(_lectureseries_Creator.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Creator toUnescapedModel() {
		return new Lectureseries_CreatorWrapper(_lectureseries_Creator.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lectureseries_Creator.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lectureseries_Creator.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lectureseries_Creator.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Lectureseries_CreatorWrapper)) {
			return false;
		}

		Lectureseries_CreatorWrapper lectureseries_CreatorWrapper = (Lectureseries_CreatorWrapper)obj;

		if (Validator.equals(_lectureseries_Creator,
					lectureseries_CreatorWrapper._lectureseries_Creator)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Lectureseries_Creator getWrappedLectureseries_Creator() {
		return _lectureseries_Creator;
	}

	@Override
	public Lectureseries_Creator getWrappedModel() {
		return _lectureseries_Creator;
	}

	@Override
	public void resetOriginalValues() {
		_lectureseries_Creator.resetOriginalValues();
	}

	private Lectureseries_Creator _lectureseries_Creator;
}