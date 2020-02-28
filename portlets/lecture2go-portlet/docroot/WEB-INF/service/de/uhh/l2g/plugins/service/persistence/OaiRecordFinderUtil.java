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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Iavor Sturm
 */
public class OaiRecordFinderUtil {
	public static java.util.Date findEarliestDatestamp() {
		return getFinder().findEarliestDatestamp();
	}

	public static OaiRecordFinder getFinder() {
		if (_finder == null) {
			_finder = (OaiRecordFinder)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					OaiRecordFinder.class.getName());

			ReferenceRegistry.registerReference(OaiRecordFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(OaiRecordFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(OaiRecordFinderUtil.class, "_finder");
	}

	private static OaiRecordFinder _finder;
}