/*******************************************************************************
 * License
 * 
 * The Lecture2Go software is based on the liferay portal 6.2-ga6
 * <http://www.liferay.com> (Copyright notice see below)
 * 
 * Lecture2Go <http://lecture2go.uni-hamburg.de> is an open source
 * platform for media management and distribution. Our goal is to
 * support the free access to knowledge because this is a component
 * of each democratic society. The open source software is aimed at
 * academic institutions and has to strengthen the blended learning.
 * 
 * All Lecture2Go plugins are continuously being developed and improved.
 * For more details please visit <http://lecture2go-open-source.rrz.uni-hamburg.de>
 * 
 * Copyright (c) 2013 - present University of Hamburg / Computer and Data Center (RRZ)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++
 * 
 * The Liferay Plugins SDK:
 * 
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
 * 
 * Third Party Software
 * 
 * Lecture2Go uses third-party libraries which may be distributed under different licenses 
 * to the above (but are compatible with the used GPL license). Informations about these 
 * licenses and copyright informations are mostly detailed in the library source code or jars themselves. 
 * You must agree to the terms of these licenses, in addition to  the above Lecture2Go source code license, 
 * in order to use this software.
 ******************************************************************************/
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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.service.base.CategoryLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.CategoryFinderUtil;

/**
 * The implementation of the category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.CategoryLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.CategoryLocalServiceUtil
 */
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.CategoryLocalServiceUtil} to access the category local service.
	 */
	public List<Category> getAllCategories(int begin, int end) throws SystemException {
		List<Category> cl = new ArrayList<Category>();
		cl = categoryPersistence.findAll(begin, end);
		return cl;
	}
	
	public List<Category> getByName(String name) throws SystemException {
		List<Category> cl = new ArrayList<Category>();
		cl = categoryPersistence.findByName(name);
		return cl;
	}
	
	public Category getById(Long categoryId) throws NoSuchModelException, SystemException {
		return categoryPersistence.findByPrimaryKey(categoryId);
	}
	
	public List<Category> getCategoriesFromLectureseriesIdsAndVideoIds(ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds) {
		return CategoryFinderUtil.findCategoriesByLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
	}
	
	public void deleteById(Long id) throws NoSuchModelException, SystemException{
		categoryPersistence.remove(id);
	}
	
}
