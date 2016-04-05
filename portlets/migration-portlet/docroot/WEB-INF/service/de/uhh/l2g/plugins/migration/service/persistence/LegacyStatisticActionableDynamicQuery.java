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

package de.uhh.l2g.plugins.migration.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.migration.model.LegacyStatistic;
import de.uhh.l2g.plugins.migration.service.LegacyStatisticLocalServiceUtil;

/**
 * @author unihh
 * @generated
 */
public abstract class LegacyStatisticActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public LegacyStatisticActionableDynamicQuery() throws SystemException {
		setBaseLocalService(LegacyStatisticLocalServiceUtil.getService());
		setClass(LegacyStatistic.class);

		setClassLoader(de.uhh.l2g.plugins.migration.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("id");
	}
}