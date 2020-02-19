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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OaiRecord}.
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecord
 * @generated
 */
public class OaiRecordWrapper implements OaiRecord, ModelWrapper<OaiRecord> {
	public OaiRecordWrapper(OaiRecord oaiRecord) {
		_oaiRecord = oaiRecord;
	}

	@Override
	public Class<?> getModelClass() {
		return OaiRecord.class;
	}

	@Override
	public String getModelClassName() {
		return OaiRecord.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("oaiRecordId", getOaiRecordId());
		attributes.put("videoId", getVideoId());
		attributes.put("identifier", getIdentifier());
		attributes.put("datestamp", getDatestamp());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long oaiRecordId = (Long)attributes.get("oaiRecordId");

		if (oaiRecordId != null) {
			setOaiRecordId(oaiRecordId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		String identifier = (String)attributes.get("identifier");

		if (identifier != null) {
			setIdentifier(identifier);
		}

		Date datestamp = (Date)attributes.get("datestamp");

		if (datestamp != null) {
			setDatestamp(datestamp);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	/**
	* Returns the primary key of this oai record.
	*
	* @return the primary key of this oai record
	*/
	@Override
	public long getPrimaryKey() {
		return _oaiRecord.getPrimaryKey();
	}

	/**
	* Sets the primary key of this oai record.
	*
	* @param primaryKey the primary key of this oai record
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_oaiRecord.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the oai record ID of this oai record.
	*
	* @return the oai record ID of this oai record
	*/
	@Override
	public long getOaiRecordId() {
		return _oaiRecord.getOaiRecordId();
	}

	/**
	* Sets the oai record ID of this oai record.
	*
	* @param oaiRecordId the oai record ID of this oai record
	*/
	@Override
	public void setOaiRecordId(long oaiRecordId) {
		_oaiRecord.setOaiRecordId(oaiRecordId);
	}

	/**
	* Returns the video ID of this oai record.
	*
	* @return the video ID of this oai record
	*/
	@Override
	public long getVideoId() {
		return _oaiRecord.getVideoId();
	}

	/**
	* Sets the video ID of this oai record.
	*
	* @param videoId the video ID of this oai record
	*/
	@Override
	public void setVideoId(long videoId) {
		_oaiRecord.setVideoId(videoId);
	}

	/**
	* Returns the identifier of this oai record.
	*
	* @return the identifier of this oai record
	*/
	@Override
	public java.lang.String getIdentifier() {
		return _oaiRecord.getIdentifier();
	}

	/**
	* Sets the identifier of this oai record.
	*
	* @param identifier the identifier of this oai record
	*/
	@Override
	public void setIdentifier(java.lang.String identifier) {
		_oaiRecord.setIdentifier(identifier);
	}

	/**
	* Returns the datestamp of this oai record.
	*
	* @return the datestamp of this oai record
	*/
	@Override
	public java.util.Date getDatestamp() {
		return _oaiRecord.getDatestamp();
	}

	/**
	* Sets the datestamp of this oai record.
	*
	* @param datestamp the datestamp of this oai record
	*/
	@Override
	public void setDatestamp(java.util.Date datestamp) {
		_oaiRecord.setDatestamp(datestamp);
	}

	/**
	* Returns the deleted of this oai record.
	*
	* @return the deleted of this oai record
	*/
	@Override
	public boolean getDeleted() {
		return _oaiRecord.getDeleted();
	}

	/**
	* Returns <code>true</code> if this oai record is deleted.
	*
	* @return <code>true</code> if this oai record is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _oaiRecord.isDeleted();
	}

	/**
	* Sets whether this oai record is deleted.
	*
	* @param deleted the deleted of this oai record
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_oaiRecord.setDeleted(deleted);
	}

	@Override
	public boolean isNew() {
		return _oaiRecord.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_oaiRecord.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _oaiRecord.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_oaiRecord.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _oaiRecord.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _oaiRecord.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_oaiRecord.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _oaiRecord.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_oaiRecord.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_oaiRecord.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_oaiRecord.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OaiRecordWrapper((OaiRecord)_oaiRecord.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.OaiRecord oaiRecord) {
		return _oaiRecord.compareTo(oaiRecord);
	}

	@Override
	public int hashCode() {
		return _oaiRecord.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.OaiRecord> toCacheModel() {
		return _oaiRecord.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.OaiRecord toEscapedModel() {
		return new OaiRecordWrapper(_oaiRecord.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.OaiRecord toUnescapedModel() {
		return new OaiRecordWrapper(_oaiRecord.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _oaiRecord.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _oaiRecord.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_oaiRecord.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OaiRecordWrapper)) {
			return false;
		}

		OaiRecordWrapper oaiRecordWrapper = (OaiRecordWrapper)obj;

		if (Validator.equals(_oaiRecord, oaiRecordWrapper._oaiRecord)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OaiRecord getWrappedOaiRecord() {
		return _oaiRecord;
	}

	@Override
	public OaiRecord getWrappedModel() {
		return _oaiRecord;
	}

	@Override
	public void resetOriginalValues() {
		_oaiRecord.resetOriginalValues();
	}

	private OaiRecord _oaiRecord;
}