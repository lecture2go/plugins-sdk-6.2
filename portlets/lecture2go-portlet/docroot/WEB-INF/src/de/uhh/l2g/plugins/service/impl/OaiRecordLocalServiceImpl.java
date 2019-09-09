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

package de.uhh.l2g.plugins.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.NoSuchOaiRecordException;
import de.uhh.l2g.plugins.model.OaiRecord;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Category;
import de.uhh.l2g.plugins.model.Video_Creator;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.OaiRecordLocalServiceBaseImpl;

/**
 * The implementation of the oai record local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.OaiRecordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.OaiRecordLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.OaiRecordLocalServiceUtil
 */
public class OaiRecordLocalServiceImpl extends OaiRecordLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.OaiRecordLocalServiceUtil} to access the oai record local service.
	 */
	
	public OaiRecord getByVideo(Long videoId) throws SystemException, NoSuchOaiRecordException {
		return oaiRecordPersistence.findByVideo(videoId);
	}
	
	public OaiRecord getByIdentifier(String identifier) throws SystemException, NoSuchOaiRecordException {
		return oaiRecordPersistence.findByIdentifier(identifier);
	}
	
	public List<OaiRecord> getByCreator(Long creatorId) throws SystemException, NoSuchOaiRecordException {
		List<Video_Creator>  vcl = Video_CreatorLocalServiceUtil.getByCreator(creatorId);
		List<OaiRecord> oaiRecords = new ArrayList<OaiRecord>();

		for (Video_Creator vc: vcl) {
			try {
				OaiRecord oaiRecord = getByVideo(vc.getVideoId());
				oaiRecords.add(oaiRecord);
			} catch (NoSuchOaiRecordException e) {
				// no OAIrecord for video, do nothing
			}
		}
		return oaiRecords;
	}
	
	public List<OaiRecord> getByCategory(Long categoryId) throws SystemException, NoSuchOaiRecordException {
		List<Video_Category>  vcl = Video_CategoryLocalServiceUtil.getByCategory(categoryId);
		List<OaiRecord> oaiRecords = new ArrayList<OaiRecord>();

		for (Video_Category vc: vcl) {
			try {
				OaiRecord oaiRecord = getByVideo(vc.getVideoId());
				oaiRecords.add(oaiRecord);
			} catch (NoSuchOaiRecordException e) {
				// no OAIrecord for video, do nothing
			}
		}
		return oaiRecords;
	}
	
	public List<OaiRecord> getByLectureseries(Long lectureseriesId) throws SystemException, NoSuchOaiRecordException {
		List<Video> vl = VideoLocalServiceUtil.getByLectureseries(lectureseriesId);
		
		List<OaiRecord> oaiRecords = new ArrayList<OaiRecord>();

		for (Video v: vl) {
			try {
				OaiRecord oaiRecord = getByVideo(v.getVideoId());
				oaiRecords.add(oaiRecord);
			} catch (NoSuchOaiRecordException e) {
				// no OAIrecord for video, do nothing
			}
		}
		return oaiRecords;
	}
}