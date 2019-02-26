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
public class TermFinderUtil {
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findTermsByLectureseriesIdsAndVideoIds(
		java.util.ArrayList<java.lang.Long> lectureseriesIds,
		java.util.ArrayList<java.lang.Long> videoIds) {
		return getFinder()
				   .findTermsByLectureseriesIdsAndVideoIds(lectureseriesIds,
			videoIds);
	}

	public static TermFinder getFinder() {
		if (_finder == null) {
			_finder = (TermFinder)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					TermFinder.class.getName());

			ReferenceRegistry.registerReference(TermFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(TermFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TermFinderUtil.class, "_finder");
	}

	private static TermFinder _finder;
}