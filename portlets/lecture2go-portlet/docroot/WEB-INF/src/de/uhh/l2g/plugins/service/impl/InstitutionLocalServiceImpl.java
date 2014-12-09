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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.base.InstitutionLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.InstitutionFinderUtil;

/**
 * The implementation of the institution local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.InstitutionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.InstitutionLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil
 */
public class InstitutionLocalServiceImpl extends InstitutionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil} to access the institution local service.
	 */
	
	public List<Institution> getByParentId(long parentId, String type) throws SystemException {
		return institutionPersistence.findByParent(parentId);
	}
	
	public Map<String, String> getByParent(long parentId) throws SystemException {
		Map<String,String> facilities = new LinkedHashMap<String, String>();
		List <Institution> fList = institutionPersistence.findByParent(parentId);

		for (Institution faculty : fList) {
			String id = "" + faculty.getInstitutionId();
			String name = "" + faculty.getName();
			facilities.put(id, name);
		}
		return facilities;
	}

	public List<Institution> getByLevel(int level) throws SystemException {
		return institutionPersistence.findBylevel(level);
	}

	public List<Institution> getByLectureseriesId(long lectureseriesId, int begin, int end) throws SystemException {
		return InstitutionFinderUtil.findByLectureseriesId(lectureseriesId, begin, end);
	}

	public Map<String, String> getAllSortedAsTree(int begin, int end) throws SystemException {
		Map<String,String> allFaculties = new LinkedHashMap<String, String>();
		List <Institution> einListAll = InstitutionFinderUtil.findAllSortedAsTree(begin, end);

		for (Institution faculty : einListAll) {
			String id = "" + faculty.getInstitutionId();
			String name = _indentFromPath(faculty.getPath(), "/") + faculty.getName();
			allFaculties.put(id, name);
		}
		
		return allFaculties;
	}
	
	private String _indentFromPath(String path, String sep) {
		String s = "";
		for (int i = 1; i <= path.split(sep).length - 1; i++) {
			s += "--";
		}
		return s;
	}
	
	
}