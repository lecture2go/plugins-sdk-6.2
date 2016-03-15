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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Video_Creator;
import de.uhh.l2g.plugins.service.base.Video_CreatorLocalServiceBaseImpl;

/**
 * The implementation of the video_ creator local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.Video_CreatorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.Video_CreatorLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.Video_CreatorLocalServiceUtil
 */
public class Video_CreatorLocalServiceImpl
	extends Video_CreatorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.Video_CreatorLocalServiceUtil} to access the video_ creator local service.
	 */
	
	public void deleteByVideoId(Long videoId) throws SystemException{
		video_CreatorPersistence.removeByVideo(videoId);
	}
	
	public void deleteByCreatorId(Long creatorId) throws SystemException{
		video_CreatorPersistence.removeByCreator(creatorId);
	}
	
	public List<Video_Creator> getByVideoCreator(Long videoId, Long creatorId) throws SystemException{
		return video_CreatorPersistence.findByVideoCreator(videoId, creatorId);
	}
	
	public List<Video_Creator> getByVideo(Long videoId) throws SystemException{
		return video_CreatorPersistence.findByVideo(videoId);
	}
	
	public List<Video_Creator> getByCreator(Long creatorId) throws SystemException{
		return video_CreatorPersistence.findByCreator(creatorId);
	}
	
}