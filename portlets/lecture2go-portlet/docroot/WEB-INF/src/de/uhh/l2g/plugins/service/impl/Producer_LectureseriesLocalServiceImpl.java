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

import de.uhh.l2g.plugins.model.Producer_Lectureseries;
import de.uhh.l2g.plugins.service.base.Producer_LectureseriesLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.Producer_LectureseriesUtil;

/**
 * The implementation of the producer_ lectureseries local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.Producer_LectureseriesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.Producer_LectureseriesLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.Producer_LectureseriesLocalServiceUtil
 */
public class Producer_LectureseriesLocalServiceImpl
	extends Producer_LectureseriesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.Producer_LectureseriesLocalServiceUtil} to access the producer_ lectureseries local service.
	 */
	
	public boolean removeByLectureseriesId(Long lectureseriesId) {
		boolean ret = false;
		try {
			Producer_LectureseriesUtil.removeByLectureseriesId(lectureseriesId);
		} catch (SystemException e) {
			ret = true;
			e.printStackTrace();
		}
		return ret;
	}	
	
	public boolean producerAssignedToLectureseries(Producer_Lectureseries pl){
		boolean ret = false;
				List<Producer_Lectureseries> pId = new ArrayList();
				try {
					pId = producer_LectureseriesPersistence.findByLectureseriesIdAndProducerId(pl.getLectureseriesId(), pl.getProducerId());
				} catch (Exception e) {
					e.printStackTrace();
				}
		if (pId.size()>0) ret=true;
		return ret;
	}
}