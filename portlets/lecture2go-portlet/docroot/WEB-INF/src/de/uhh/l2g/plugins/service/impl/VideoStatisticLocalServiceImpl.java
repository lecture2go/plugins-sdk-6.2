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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.VideoStatistic;
import de.uhh.l2g.plugins.service.base.VideoStatisticLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.VideoStatisticFinderUtil;

/**
 * The implementation of the video statistic local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.VideoStatisticLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.VideoStatisticLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.VideoStatisticLocalServiceUtil
 */
public class VideoStatisticLocalServiceImpl
	extends VideoStatisticLocalServiceBaseImpl {
    /*
	 * NOTE FOR DEVELOPERS:
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.VideoStatisticLocalServiceUtil} to access the video statistic local service.
    */
	
	protected static Log LOG = LogFactoryUtil.getLog(VideoStatistic.class.getName());

	public VideoStatistic addVideoStatistic(VideoStatistic object){
		Long id;
		try {
			id = counterLocalService.increment(VideoStatistic.class.getName());
			object.setPrimaryKey(id);
			super.addVideoStatistic(object);
		} catch (SystemException e) {
			LOG.error("can't add new object with id " + object.getPrimaryKey() + "!");
		}
		return object;
	}
	
	public List<VideoStatistic> getByCompanyIdAndGroupId(long companyId, long groupId) throws SystemException {
		return videoStatisticPersistence.findByCompanyIdAndGroupId(companyId, groupId);
	}
	
	public List<VideoStatistic> getAllStatistics() throws SystemException {
		return VideoStatisticFinderUtil.findAllStats();
	}
	
}