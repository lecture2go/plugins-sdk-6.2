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
 * This class is a wrapper for {@link OaiRecord_OaiSet}.
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecord_OaiSet
 * @generated
 */
public class OaiRecord_OaiSetWrapper implements OaiRecord_OaiSet,
	ModelWrapper<OaiRecord_OaiSet> {
	public OaiRecord_OaiSetWrapper(OaiRecord_OaiSet oaiRecord_OaiSet) {
		_oaiRecord_OaiSet = oaiRecord_OaiSet;
	}

	@Override
	public Class<?> getModelClass() {
		return OaiRecord_OaiSet.class;
	}

	@Override
	public String getModelClassName() {
		return OaiRecord_OaiSet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("oaiRecordOaiSetId", getOaiRecordOaiSetId());
		attributes.put("oaiRecordId", getOaiRecordId());
		attributes.put("oaiSetId", getOaiSetId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long oaiRecordOaiSetId = (Long)attributes.get("oaiRecordOaiSetId");

		if (oaiRecordOaiSetId != null) {
			setOaiRecordOaiSetId(oaiRecordOaiSetId);
		}

		Long oaiRecordId = (Long)attributes.get("oaiRecordId");

		if (oaiRecordId != null) {
			setOaiRecordId(oaiRecordId);
		}

		Long oaiSetId = (Long)attributes.get("oaiSetId");

		if (oaiSetId != null) {
			setOaiSetId(oaiSetId);
		}
	}

	/**
	* Returns the primary key of this oai record_ oai set.
	*
	* @return the primary key of this oai record_ oai set
	*/
	@Override
	public long getPrimaryKey() {
		return _oaiRecord_OaiSet.getPrimaryKey();
	}

	/**
	* Sets the primary key of this oai record_ oai set.
	*
	* @param primaryKey the primary key of this oai record_ oai set
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_oaiRecord_OaiSet.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the oai record oai set ID of this oai record_ oai set.
	*
	* @return the oai record oai set ID of this oai record_ oai set
	*/
	@Override
	public long getOaiRecordOaiSetId() {
		return _oaiRecord_OaiSet.getOaiRecordOaiSetId();
	}

	/**
	* Sets the oai record oai set ID of this oai record_ oai set.
	*
	* @param oaiRecordOaiSetId the oai record oai set ID of this oai record_ oai set
	*/
	@Override
	public void setOaiRecordOaiSetId(long oaiRecordOaiSetId) {
		_oaiRecord_OaiSet.setOaiRecordOaiSetId(oaiRecordOaiSetId);
	}

	/**
	* Returns the oai record ID of this oai record_ oai set.
	*
	* @return the oai record ID of this oai record_ oai set
	*/
	@Override
	public long getOaiRecordId() {
		return _oaiRecord_OaiSet.getOaiRecordId();
	}

	/**
	* Sets the oai record ID of this oai record_ oai set.
	*
	* @param oaiRecordId the oai record ID of this oai record_ oai set
	*/
	@Override
	public void setOaiRecordId(long oaiRecordId) {
		_oaiRecord_OaiSet.setOaiRecordId(oaiRecordId);
	}

	/**
	* Returns the oai set ID of this oai record_ oai set.
	*
	* @return the oai set ID of this oai record_ oai set
	*/
	@Override
	public long getOaiSetId() {
		return _oaiRecord_OaiSet.getOaiSetId();
	}

	/**
	* Sets the oai set ID of this oai record_ oai set.
	*
	* @param oaiSetId the oai set ID of this oai record_ oai set
	*/
	@Override
	public void setOaiSetId(long oaiSetId) {
		_oaiRecord_OaiSet.setOaiSetId(oaiSetId);
	}

	@Override
	public boolean isNew() {
		return _oaiRecord_OaiSet.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_oaiRecord_OaiSet.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _oaiRecord_OaiSet.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_oaiRecord_OaiSet.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _oaiRecord_OaiSet.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _oaiRecord_OaiSet.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_oaiRecord_OaiSet.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _oaiRecord_OaiSet.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_oaiRecord_OaiSet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_oaiRecord_OaiSet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_oaiRecord_OaiSet.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OaiRecord_OaiSetWrapper((OaiRecord_OaiSet)_oaiRecord_OaiSet.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet) {
		return _oaiRecord_OaiSet.compareTo(oaiRecord_OaiSet);
	}

	@Override
	public int hashCode() {
		return _oaiRecord_OaiSet.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> toCacheModel() {
		return _oaiRecord_OaiSet.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet toEscapedModel() {
		return new OaiRecord_OaiSetWrapper(_oaiRecord_OaiSet.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet toUnescapedModel() {
		return new OaiRecord_OaiSetWrapper(_oaiRecord_OaiSet.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _oaiRecord_OaiSet.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _oaiRecord_OaiSet.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_oaiRecord_OaiSet.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OaiRecord_OaiSetWrapper)) {
			return false;
		}

		OaiRecord_OaiSetWrapper oaiRecord_OaiSetWrapper = (OaiRecord_OaiSetWrapper)obj;

		if (Validator.equals(_oaiRecord_OaiSet,
					oaiRecord_OaiSetWrapper._oaiRecord_OaiSet)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OaiRecord_OaiSet getWrappedOaiRecord_OaiSet() {
		return _oaiRecord_OaiSet;
	}

	@Override
	public OaiRecord_OaiSet getWrappedModel() {
		return _oaiRecord_OaiSet;
	}

	@Override
	public void resetOriginalValues() {
		_oaiRecord_OaiSet.resetOriginalValues();
	}

	private OaiRecord_OaiSet _oaiRecord_OaiSet;
}