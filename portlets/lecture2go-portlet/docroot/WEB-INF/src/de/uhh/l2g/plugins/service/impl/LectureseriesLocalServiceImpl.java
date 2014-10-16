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

package de.uhh.l2g.plugins.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.service.base.LectureseriesLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.LectureseriesFinderUtil;

/**
 * The implementation of the lectureseries local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.LectureseriesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.LectureseriesLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil
 */
public class LectureseriesLocalServiceImpl
	extends LectureseriesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil} to access the lectureseries local service.
	 */
	
	public List<String> getAllSemesters(int begin, int end) throws SystemException {
		List <String> sl = new ArrayList<String>();
		sl = LectureseriesFinderUtil.findAllSemesters(begin, end);
		return sl;
	}
	
	public List<Lectureseries> getFilteredBySemesterFacultyProducer(Integer approved, String semester, Long facultyId, Long producerId) {
		List<Lectureseries> l = LectureseriesFinderUtil.findeFilteredByApprovedSemesterFacultyProducer(approved, semester, facultyId, producerId);
		try{
			l.isEmpty();//check
		}catch(NullPointerException npe){
			l = new ArrayList<Lectureseries>();
		}
		return l;
	}
}