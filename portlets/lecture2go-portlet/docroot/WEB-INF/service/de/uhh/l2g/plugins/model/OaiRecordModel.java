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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the OaiRecord service. Represents a row in the &quot;LG_OaiRecord&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.uhh.l2g.plugins.model.impl.OaiRecordImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecord
 * @see de.uhh.l2g.plugins.model.impl.OaiRecordImpl
 * @see de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl
 * @generated
 */
public interface OaiRecordModel extends BaseModel<OaiRecord> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a oai record model instance should use the {@link OaiRecord} interface instead.
	 */

	/**
	 * Returns the primary key of this oai record.
	 *
	 * @return the primary key of this oai record
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this oai record.
	 *
	 * @param primaryKey the primary key of this oai record
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the oai record ID of this oai record.
	 *
	 * @return the oai record ID of this oai record
	 */
	public long getOaiRecordId();

	/**
	 * Sets the oai record ID of this oai record.
	 *
	 * @param oaiRecordId the oai record ID of this oai record
	 */
	public void setOaiRecordId(long oaiRecordId);

	/**
	 * Returns the video ID of this oai record.
	 *
	 * @return the video ID of this oai record
	 */
	public long getVideoId();

	/**
	 * Sets the video ID of this oai record.
	 *
	 * @param videoId the video ID of this oai record
	 */
	public void setVideoId(long videoId);

	/**
	 * Returns the identifier of this oai record.
	 *
	 * @return the identifier of this oai record
	 */
	@AutoEscape
	public String getIdentifier();

	/**
	 * Sets the identifier of this oai record.
	 *
	 * @param identifier the identifier of this oai record
	 */
	public void setIdentifier(String identifier);

	/**
	 * Returns the datestamp of this oai record.
	 *
	 * @return the datestamp of this oai record
	 */
	public Date getDatestamp();

	/**
	 * Sets the datestamp of this oai record.
	 *
	 * @param datestamp the datestamp of this oai record
	 */
	public void setDatestamp(Date datestamp);

	/**
	 * Returns the deleted of this oai record.
	 *
	 * @return the deleted of this oai record
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this oai record is deleted.
	 *
	 * @return <code>true</code> if this oai record is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this oai record is deleted.
	 *
	 * @param deleted the deleted of this oai record
	 */
	public void setDeleted(boolean deleted);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.OaiRecord oaiRecord);

	@Override
	public int hashCode();

	@Override
	public CacheModel<de.uhh.l2g.plugins.model.OaiRecord> toCacheModel();

	@Override
	public de.uhh.l2g.plugins.model.OaiRecord toEscapedModel();

	@Override
	public de.uhh.l2g.plugins.model.OaiRecord toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}