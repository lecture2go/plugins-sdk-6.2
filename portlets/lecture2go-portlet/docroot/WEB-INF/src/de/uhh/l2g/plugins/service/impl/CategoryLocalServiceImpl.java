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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Coordinator;
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
	protected static Log LOG = LogFactoryUtil.getLog(Category.class.getName());

	public Category addCategory(Category object){
		Long id;
		try {
			id = counterLocalService.increment(Category.class.getName());
			object.setPrimaryKey(id);
			super.addCategory(object);
		} catch (SystemException e) {
			LOG.error("can't add new object with id " + object.getPrimaryKey() + "!");
		}
		return object;
	}
	
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