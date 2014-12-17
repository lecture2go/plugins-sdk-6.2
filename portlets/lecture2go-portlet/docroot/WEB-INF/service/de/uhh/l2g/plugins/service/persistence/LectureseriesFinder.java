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

/**
 * @author Iavor Sturm
 */
public interface LectureseriesFinder {
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findAllLectureseriesWhithPassword();

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findAllLectureseriesWhithOpenaccessVideos();

	public java.util.List<java.lang.String> findAllSemesters(int begin, int end);

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findeFilteredByApprovedSemesterFacultyProducer(
		java.lang.Integer approved, java.lang.String semester,
		java.lang.Long facultyId, java.lang.Long producerId);
}