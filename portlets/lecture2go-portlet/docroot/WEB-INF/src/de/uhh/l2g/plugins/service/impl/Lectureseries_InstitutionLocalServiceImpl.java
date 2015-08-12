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

import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.service.base.Lectureseries_InstitutionLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.Lectureseries_InstitutionUtil;

/**
 * The implementation of the lectureseries_ institution local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.Lectureseries_InstitutionLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil
 */
public class Lectureseries_InstitutionLocalServiceImpl
	extends Lectureseries_InstitutionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil} to access the lectureseries_ institution local service.
	 */
	
	public boolean removeByLectureseriesId(Long lectureseriesId) {
		boolean ret = false;
		try {
			Lectureseries_InstitutionUtil.removeByLectureseriesId(lectureseriesId);
		} catch (SystemException e) {
			ret = true;
			e.printStackTrace();
		}
		return ret;
	}

	public boolean removeByacilityId(Long institutionId){
		boolean ret = false;
		try {
			Lectureseries_InstitutionUtil.removeByInstitutionId(institutionId);
		} catch (SystemException e) {
			ret = true;
			e.printStackTrace();
		}
		return ret;
	}
	
	public boolean institutionAssignedToLectureseries(Lectureseries_Institution lf){
		boolean ret = false;
				List<Lectureseries_Institution> lfL = new ArrayList();
				try {
					lfL = lectureseries_InstitutionPersistence.findByLectureseriesIdAndInstitutionId(lf.getLectureseriesId(), lf.getInstitutionId());
				} catch (Exception e) {
					e.printStackTrace();
				}
		if (lfL.size()>0) ret=true;
		return ret;
	}
	
	public List<Lectureseries_Institution> getByLectureseries(long lectureseriesId) throws SystemException{
		return lectureseries_InstitutionPersistence.findByLectureseriesId(lectureseriesId);
	}
	
	
	public Lectureseries_Institution findFirstByLectureseriesIdAndInstitutionId(long lectureseriesId, long institutionId) throws SystemException{
		List<Lectureseries_Institution> result = lectureseries_InstitutionPersistence.findByLectureseriesIdAndInstitutionId(lectureseriesId, institutionId);
		if (result != null && result.size() > 0 ) {
			return result.get(0);
		} else {
			return null;
		}
		
	}
}