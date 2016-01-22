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
public class InstitutionFinderUtil {
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByLectureseriesId(
		long lectureseriesId, int begin, int end) {
		return getFinder().findByLectureseriesId(lectureseriesId, begin, end);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findAllSortedAsTree(
		int begin, int end) {
		return getFinder().findAllSortedAsTree(begin, end);
	}

	public static int findMaxSortByParent(long parentId) {
		return getFinder().findMaxSortByParent(parentId);
	}

	public static int findLockingElements(long institutionId) {
		return getFinder().findLockingElements(institutionId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findInstitutionsByLectureseriesIdsAndVideoIds(
		java.util.ArrayList<java.lang.Long> lectureseriesIds,
		java.util.ArrayList<java.lang.Long> videoIds, java.lang.Long parentId) {
		return getFinder()
				   .findInstitutionsByLectureseriesIdsAndVideoIds(lectureseriesIds,
			videoIds, parentId);
	}

	public static InstitutionFinder getFinder() {
		if (_finder == null) {
			_finder = (InstitutionFinder)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					InstitutionFinder.class.getName());

			ReferenceRegistry.registerReference(InstitutionFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(InstitutionFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(InstitutionFinderUtil.class,
			"_finder");
	}

	private static InstitutionFinder _finder;
}