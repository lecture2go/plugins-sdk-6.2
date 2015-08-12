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
import java.util.ListIterator;

import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;
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
public class LectureseriesLocalServiceImpl extends LectureseriesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil} to access the lectureseries local service.
	 */
	
	public List<Lectureseries> getFilteredBySemesterFacultyProducer(Integer approved, Long semester, Long facultyId, Long producerId) {
		List<Lectureseries> l = LectureseriesFinderUtil.findFilteredByApprovedSemesterFacultyProducer(approved, semester, facultyId, producerId);
		try{
			l.isEmpty();//check
		}catch(NullPointerException npe){
			l = new ArrayList<Lectureseries>();
		}
		return l;
	}
	
	public List<Lectureseries> getAllLectureseriesWhithOpenaccessVideos(){
		return LectureseriesFinderUtil.findAllLectureseriesWhithOpenaccessVideos();
	}
	
	public List<Lectureseries> getAllLectureseriesWhithPassword(){
		return LectureseriesFinderUtil.findAllLectureseriesWhithPassword();
	}
	
	public List<Lectureseries> getAllForVideo(Video video){
		return LectureseriesFinderUtil.findAllLectureseriesForVideo(video);
	}
	
	public List<Lectureseries> getByLatestVideoId(Long latestVideoId) throws SystemException{
		return lectureseriesPersistence.findByLatestOpenAccessVideo(latestVideoId);
	} 
	
	
	public void updateOpenAccess(Video video, Lectureseries lectureseries) throws SystemException{
		// video lecture series table by video
		Video_LectureseriesLocalServiceUtil.updateOpenAccessByVideo(video);
		
		//lecture series
		Video latestOpenAccessVideo = VideoLocalServiceUtil.getLatestOpenAccessVideoForLectureseries(lectureseries.getLectureseriesId());
		lectureseries.setLatestOpenAccessVideoId(latestOpenAccessVideo.getVideoId());
		lectureseries.setLatestVideoUploadDate(latestOpenAccessVideo.getUploadDate());
		lectureseries.setLatestVideoGenerationDate(latestOpenAccessVideo.getGenerationDate());
		LectureseriesLocalServiceUtil.updateLectureseries(lectureseries);
		
		// update old entries in the lecture series table for video
		List<Lectureseries> ls = new ArrayList<Lectureseries>();
		ls = LectureseriesLocalServiceUtil.getByLatestVideoId(video.getVideoId());
		ListIterator<Lectureseries> it = ls.listIterator();
		while(it.hasNext()){
			Lectureseries l = it.next();
			Video ov = VideoLocalServiceUtil.getLatestOpenAccessVideoForLectureseries(l.getLectureseriesId());
			l.setLatestOpenAccessVideoId(ov.getVideoId());
			lectureseries.setLatestVideoUploadDate(ov.getUploadDate());
			lectureseries.setLatestVideoGenerationDate(ov.getGenerationDate());			
			LectureseriesLocalServiceUtil.updateLectureseries(l);
		}
	}
		
	public List<Lectureseries> getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(Long institutionId, Long parentInstitutionId, Long termId, Long categoryId, Long creatorId, String searchQuery){
		return LectureseriesFinderUtil.findFilteredByInstitutionParentInstitutionTermCategoryCreator(institutionId, parentInstitutionId, termId, categoryId, creatorId, searchQuery);
	}
}