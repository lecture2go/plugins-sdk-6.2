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
 * The base model interface for the Lastvideolist service. Represents a row in the &quot;LG_Lastvideolist&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.uhh.l2g.plugins.model.impl.LastvideolistImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lastvideolist
 * @see de.uhh.l2g.plugins.model.impl.LastvideolistImpl
 * @see de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl
 * @generated
 */
public interface LastvideolistModel extends BaseModel<Lastvideolist> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a lastvideolist model instance should use the {@link Lastvideolist} interface instead.
	 */

	/**
	 * Returns the primary key of this lastvideolist.
	 *
	 * @return the primary key of this lastvideolist
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this lastvideolist.
	 *
	 * @param primaryKey the primary key of this lastvideolist
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the lastvideolist ID of this lastvideolist.
	 *
	 * @return the lastvideolist ID of this lastvideolist
	 */
	public long getLastvideolistId();

	/**
	 * Sets the lastvideolist ID of this lastvideolist.
	 *
	 * @param lastvideolistId the lastvideolist ID of this lastvideolist
	 */
	public void setLastvideolistId(long lastvideolistId);

	/**
	 * Returns the video ID of this lastvideolist.
	 *
	 * @return the video ID of this lastvideolist
	 */
	public long getVideoId();

	/**
	 * Sets the video ID of this lastvideolist.
	 *
	 * @param videoId the video ID of this lastvideolist
	 */
	public void setVideoId(long videoId);

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
	public int compareTo(de.uhh.l2g.plugins.model.Lastvideolist lastvideolist);

	@Override
	public int hashCode();

	@Override
	public CacheModel<de.uhh.l2g.plugins.model.Lastvideolist> toCacheModel();

	@Override
	public de.uhh.l2g.plugins.model.Lastvideolist toEscapedModel();

	@Override
	public de.uhh.l2g.plugins.model.Lastvideolist toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}