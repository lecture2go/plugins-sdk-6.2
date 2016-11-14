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
import java.util.ListIterator;

import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Video_Category;
import de.uhh.l2g.plugins.service.base.Video_CategoryLocalServiceBaseImpl;

/**
 * The implementation of the video_ category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.Video_CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.Video_CategoryLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil
 */
public class Video_CategoryLocalServiceImpl extends Video_CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil} to access the video_ category local service.
	 */
	
	public List<Video_Category> getByVideo(Long videoId) throws SystemException{
		return video_CategoryPersistence.findByVideo(videoId);
	}
	
	public List<Video_Category> getByCategory(Long categoryId) throws SystemException{
		return video_CategoryPersistence.findByCategory(categoryId);
	}
	
	public void removeByVideo(Long videoId) throws SystemException{
		video_CategoryPersistence.removeByVideo(videoId);
	}
	
	public void updateCategoryByVideoAndCategory(Long videoId, Long categoryId, Long newCategoryId){
		List<Video_Category> vca = new ArrayList<Video_Category>();
		try {
			vca = video_CategoryPersistence.findByVideoCategory(videoId, categoryId);
			ListIterator<Video_Category> vci = vca.listIterator();
			while(vci.hasNext()){
				//new object
				Video_Category nvc = vci.next();
				nvc.setCategoryId(newCategoryId);
				video_CategoryPersistence.update(nvc);
			}
		} catch (SystemException e) {}
	}	
	
}