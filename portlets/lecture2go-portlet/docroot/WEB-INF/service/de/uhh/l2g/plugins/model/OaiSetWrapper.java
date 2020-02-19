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
 * This class is a wrapper for {@link OaiSet}.
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiSet
 * @generated
 */
public class OaiSetWrapper implements OaiSet, ModelWrapper<OaiSet> {
	public OaiSetWrapper(OaiSet oaiSet) {
		_oaiSet = oaiSet;
	}

	@Override
	public Class<?> getModelClass() {
		return OaiSet.class;
	}

	@Override
	public String getModelClassName() {
		return OaiSet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("oaiSetId", getOaiSetId());
		attributes.put("setSpec", getSetSpec());
		attributes.put("setName", getSetName());
		attributes.put("setDescription", getSetDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long oaiSetId = (Long)attributes.get("oaiSetId");

		if (oaiSetId != null) {
			setOaiSetId(oaiSetId);
		}

		String setSpec = (String)attributes.get("setSpec");

		if (setSpec != null) {
			setSetSpec(setSpec);
		}

		String setName = (String)attributes.get("setName");

		if (setName != null) {
			setSetName(setName);
		}

		String setDescription = (String)attributes.get("setDescription");

		if (setDescription != null) {
			setSetDescription(setDescription);
		}
	}

	/**
	* Returns the primary key of this oai set.
	*
	* @return the primary key of this oai set
	*/
	@Override
	public long getPrimaryKey() {
		return _oaiSet.getPrimaryKey();
	}

	/**
	* Sets the primary key of this oai set.
	*
	* @param primaryKey the primary key of this oai set
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_oaiSet.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the oai set ID of this oai set.
	*
	* @return the oai set ID of this oai set
	*/
	@Override
	public long getOaiSetId() {
		return _oaiSet.getOaiSetId();
	}

	/**
	* Sets the oai set ID of this oai set.
	*
	* @param oaiSetId the oai set ID of this oai set
	*/
	@Override
	public void setOaiSetId(long oaiSetId) {
		_oaiSet.setOaiSetId(oaiSetId);
	}

	/**
	* Returns the set spec of this oai set.
	*
	* @return the set spec of this oai set
	*/
	@Override
	public java.lang.String getSetSpec() {
		return _oaiSet.getSetSpec();
	}

	/**
	* Sets the set spec of this oai set.
	*
	* @param setSpec the set spec of this oai set
	*/
	@Override
	public void setSetSpec(java.lang.String setSpec) {
		_oaiSet.setSetSpec(setSpec);
	}

	/**
	* Returns the set name of this oai set.
	*
	* @return the set name of this oai set
	*/
	@Override
	public java.lang.String getSetName() {
		return _oaiSet.getSetName();
	}

	/**
	* Sets the set name of this oai set.
	*
	* @param setName the set name of this oai set
	*/
	@Override
	public void setSetName(java.lang.String setName) {
		_oaiSet.setSetName(setName);
	}

	/**
	* Returns the set description of this oai set.
	*
	* @return the set description of this oai set
	*/
	@Override
	public java.lang.String getSetDescription() {
		return _oaiSet.getSetDescription();
	}

	/**
	* Sets the set description of this oai set.
	*
	* @param setDescription the set description of this oai set
	*/
	@Override
	public void setSetDescription(java.lang.String setDescription) {
		_oaiSet.setSetDescription(setDescription);
	}

	@Override
	public boolean isNew() {
		return _oaiSet.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_oaiSet.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _oaiSet.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_oaiSet.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _oaiSet.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _oaiSet.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_oaiSet.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _oaiSet.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_oaiSet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_oaiSet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_oaiSet.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OaiSetWrapper((OaiSet)_oaiSet.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.OaiSet oaiSet) {
		return _oaiSet.compareTo(oaiSet);
	}

	@Override
	public int hashCode() {
		return _oaiSet.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.OaiSet> toCacheModel() {
		return _oaiSet.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.OaiSet toEscapedModel() {
		return new OaiSetWrapper(_oaiSet.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.OaiSet toUnescapedModel() {
		return new OaiSetWrapper(_oaiSet.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _oaiSet.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _oaiSet.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_oaiSet.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OaiSetWrapper)) {
			return false;
		}

		OaiSetWrapper oaiSetWrapper = (OaiSetWrapper)obj;

		if (Validator.equals(_oaiSet, oaiSetWrapper._oaiSet)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OaiSet getWrappedOaiSet() {
		return _oaiSet;
	}

	@Override
	public OaiSet getWrappedModel() {
		return _oaiSet;
	}

	@Override
	public void resetOriginalValues() {
		_oaiSet.resetOriginalValues();
	}

	private OaiSet _oaiSet;
}