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

import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.service.base.Video_FacilityLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.Video_FacilityUtil;

/**
 * The implementation of the video_ facility local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.Video_FacilityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.Video_FacilityLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.Video_FacilityLocalServiceUtil
 */
public class Video_FacilityLocalServiceImpl
	extends Video_FacilityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.Video_FacilityLocalServiceUtil} to access the video_ facility local service.
	 */
	
	public boolean removeByVideoId(Long videoId) {
		boolean ret = false;
		try {
			Video_FacilityUtil.removeByVideo(videoId);
		} catch (SystemException e) {
			ret = true;
			e.printStackTrace();
		}
		return ret;
	}

	public boolean removeByFacilityId(Long facilityId) {
		boolean ret = false;
		try {
			Video_FacilityUtil.removeByFacility(facilityId);
		} catch (SystemException e) {
			ret = true;
			e.printStackTrace();
		}
		return ret;
	}
}