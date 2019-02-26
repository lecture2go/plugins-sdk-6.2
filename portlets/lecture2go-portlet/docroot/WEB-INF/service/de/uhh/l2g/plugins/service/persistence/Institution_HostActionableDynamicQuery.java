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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;

/**
 * @author Iavor Sturm
 * @generated
 */
public abstract class Institution_HostActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public Institution_HostActionableDynamicQuery() throws SystemException {
		setBaseLocalService(Institution_HostLocalServiceUtil.getService());
		setClass(Institution_Host.class);

		setClassLoader(de.uhh.l2g.plugins.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("institutionHostId");
	}
}