/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
public class LectureseriesFinderUtil {
	public static java.util.List<java.lang.String> findAllSemesters(int begin,
		int end) {
		return getFinder().findAllSemesters(begin, end);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findeFilteredByApprovedSemesterFacultyProducer(
		java.lang.Integer approved, java.lang.String semester, int facultyId,
		int producerId) {
		return getFinder()
				   .findeFilteredByApprovedSemesterFacultyProducer(approved,
			semester, facultyId, producerId);
	}

	public static LectureseriesFinder getFinder() {
		if (_finder == null) {
			_finder = (LectureseriesFinder)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					LectureseriesFinder.class.getName());

			ReferenceRegistry.registerReference(LectureseriesFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(LectureseriesFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(LectureseriesFinderUtil.class,
			"_finder");
	}

	private static LectureseriesFinder _finder;
}