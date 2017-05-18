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

import de.uhh.l2g.plugins.model.Lectureseries_Creator;
import de.uhh.l2g.plugins.service.base.Lectureseries_CreatorLocalServiceBaseImpl;

/**
 * The implementation of the lectureseries_ creator local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.Lectureseries_CreatorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.Lectureseries_CreatorLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.Lectureseries_CreatorLocalServiceUtil
 */
public class Lectureseries_CreatorLocalServiceImpl
	extends Lectureseries_CreatorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.Lectureseries_CreatorLocalServiceUtil} to access the lectureseries_ creator local service.
	 */
	
	public void removeByLectureseriesId(Long lectureseriesId) throws SystemException{
		lectureseries_CreatorPersistence.removeByLectureseries(lectureseriesId);
	}
	
	public List<Lectureseries_Creator> getByCreatorId(Long creatorId) throws SystemException{
		return lectureseries_CreatorPersistence.findByCreator(creatorId);
	}
	
	public List<Lectureseries_Creator> getByLectureseriesId(Long lectureseriesId) throws SystemException{
		return lectureseries_CreatorPersistence.findByLectureseries(lectureseriesId);
	}
	
	public List<Lectureseries_Creator> getByLectureseriesIdAndCreatorId(Long lectureseriesId, Long creatorId) throws SystemException{
		return lectureseries_CreatorPersistence.findByLectureseriesCreator(lectureseriesId, creatorId);
	}
	
	public List<Lectureseries_Creator> getByCreator(Long creatorId) throws SystemException{
		return lectureseries_CreatorPersistence.findByCreator(creatorId);
	}
}