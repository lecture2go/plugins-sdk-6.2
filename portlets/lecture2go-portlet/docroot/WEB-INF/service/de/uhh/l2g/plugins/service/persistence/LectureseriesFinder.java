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

/**
 * @author Iavor Sturm
 */
public interface LectureseriesFinder {
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findAllLectureseriesWhithPassword();

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findAllLectureseriesForVideo(
		de.uhh.l2g.plugins.model.Video video);

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findAllLectureseriesWhithOpenaccessVideos();

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findLatest(
		int limit);

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(
		java.lang.Long institutionId, java.lang.Long parentInstitutionId,
		java.lang.Long termId, java.lang.Long categoryId,
		java.lang.Long creatorId, java.lang.String searchQuery);

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(
		java.lang.Long institutionId, java.lang.Long parentInstitutionId,
		java.lang.Long termId, java.lang.Long categoryId,
		java.lang.Long creatorId, java.lang.String searchQuery, int limit);

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findFilteredByApprovedSemesterFacultyProducer(
		java.lang.Integer approved, java.lang.Long termId,
		java.lang.Long facultyId, java.lang.Long producerId);
}