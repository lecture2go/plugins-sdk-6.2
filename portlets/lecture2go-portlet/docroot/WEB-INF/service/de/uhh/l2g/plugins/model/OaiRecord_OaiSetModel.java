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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the OaiRecord_OaiSet service. Represents a row in the &quot;LG_OaiRecord_OaiSet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecord_OaiSet
 * @see de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetImpl
 * @see de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl
 * @generated
 */
public interface OaiRecord_OaiSetModel extends BaseModel<OaiRecord_OaiSet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a oai record_ oai set model instance should use the {@link OaiRecord_OaiSet} interface instead.
	 */

	/**
	 * Returns the primary key of this oai record_ oai set.
	 *
	 * @return the primary key of this oai record_ oai set
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this oai record_ oai set.
	 *
	 * @param primaryKey the primary key of this oai record_ oai set
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the oai record oai set ID of this oai record_ oai set.
	 *
	 * @return the oai record oai set ID of this oai record_ oai set
	 */
	public long getOaiRecordOaiSetId();

	/**
	 * Sets the oai record oai set ID of this oai record_ oai set.
	 *
	 * @param oaiRecordOaiSetId the oai record oai set ID of this oai record_ oai set
	 */
	public void setOaiRecordOaiSetId(long oaiRecordOaiSetId);

	/**
	 * Returns the oai record ID of this oai record_ oai set.
	 *
	 * @return the oai record ID of this oai record_ oai set
	 */
	public long getOaiRecordId();

	/**
	 * Sets the oai record ID of this oai record_ oai set.
	 *
	 * @param oaiRecordId the oai record ID of this oai record_ oai set
	 */
	public void setOaiRecordId(long oaiRecordId);

	/**
	 * Returns the oai set ID of this oai record_ oai set.
	 *
	 * @return the oai set ID of this oai record_ oai set
	 */
	public long getOaiSetId();

	/**
	 * Sets the oai set ID of this oai record_ oai set.
	 *
	 * @param oaiSetId the oai set ID of this oai record_ oai set
	 */
	public void setOaiSetId(long oaiSetId);

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
	public int compareTo(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet);

	@Override
	public int hashCode();

	@Override
	public CacheModel<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> toCacheModel();

	@Override
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet toEscapedModel();

	@Override
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}