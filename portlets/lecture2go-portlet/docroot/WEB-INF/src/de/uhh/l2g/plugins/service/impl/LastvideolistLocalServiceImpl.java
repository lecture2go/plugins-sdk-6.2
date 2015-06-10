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

import de.uhh.l2g.plugins.service.base.LastvideolistLocalServiceBaseImpl;

/**
 * The implementation of the lastvideolist local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.LastvideolistLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.LastvideolistLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.LastvideolistLocalServiceUtil
 */
public class LastvideolistLocalServiceImpl
	extends LastvideolistLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.LastvideolistLocalServiceUtil} to access the lastvideolist local service.
	 */
	
	public void deleteByVideoId(Long videoId) {
		try {
			lastvideolistPersistence.removeByVideo(videoId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
}