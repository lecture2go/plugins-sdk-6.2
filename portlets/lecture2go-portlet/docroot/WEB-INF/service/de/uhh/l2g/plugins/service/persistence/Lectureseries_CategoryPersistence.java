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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.model.Lectureseries_Category;

/**
 * The persistence interface for the lectureseries_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_CategoryPersistenceImpl
 * @see Lectureseries_CategoryUtil
 * @generated
 */
public interface Lectureseries_CategoryPersistence extends BasePersistence<Lectureseries_Category> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Lectureseries_CategoryUtil} to access the lectureseries_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the lectureseries_ categories where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ categories where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @return the range of matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByLectureseries(
		long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ categories where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByLectureseries(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category findByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException;

	/**
	* Returns the first lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category fetchByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category findByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException;

	/**
	* Returns the last lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category fetchByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ categories before and after the current lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesCategoryId the primary key of the current lectureseries_ category
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category[] findByLectureseries_PrevAndNext(
		long lectureseriesCategoryId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException;

	/**
	* Removes all the lectureseries_ categories where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ categories where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureseries_ categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @return the range of matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException;

	/**
	* Returns the first lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException;

	/**
	* Returns the last lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ categories before and after the current lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param lectureseriesCategoryId the primary key of the current lectureseries_ category
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category[] findByCategory_PrevAndNext(
		long lectureseriesCategoryId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException;

	/**
	* Removes all the lectureseries_ categories where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @return the matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByCategoryLectureseries(
		long categoryId, long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @return the range of matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByCategoryLectureseries(
		long categoryId, long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByCategoryLectureseries(
		long categoryId, long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category findByCategoryLectureseries_First(
		long categoryId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException;

	/**
	* Returns the first lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category fetchByCategoryLectureseries_First(
		long categoryId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category findByCategoryLectureseries_Last(
		long categoryId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException;

	/**
	* Returns the last lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category fetchByCategoryLectureseries_Last(
		long categoryId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ categories before and after the current lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param lectureseriesCategoryId the primary key of the current lectureseries_ category
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category[] findByCategoryLectureseries_PrevAndNext(
		long lectureseriesCategoryId, long categoryId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException;

	/**
	* Removes all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryLectureseries(long categoryId,
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryLectureseries(long categoryId,
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the lectureseries_ category in the entity cache if it is enabled.
	*
	* @param lectureseries_Category the lectureseries_ category
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.model.Lectureseries_Category lectureseries_Category);

	/**
	* Caches the lectureseries_ categories in the entity cache if it is enabled.
	*
	* @param lectureseries_Categories the lectureseries_ categories
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> lectureseries_Categories);

	/**
	* Creates a new lectureseries_ category with the primary key. Does not add the lectureseries_ category to the database.
	*
	* @param lectureseriesCategoryId the primary key for the new lectureseries_ category
	* @return the new lectureseries_ category
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category create(
		long lectureseriesCategoryId);

	/**
	* Removes the lectureseries_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesCategoryId the primary key of the lectureseries_ category
	* @return the lectureseries_ category that was removed
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category remove(
		long lectureseriesCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException;

	public de.uhh.l2g.plugins.model.Lectureseries_Category updateImpl(
		de.uhh.l2g.plugins.model.Lectureseries_Category lectureseries_Category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ category with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException} if it could not be found.
	*
	* @param lectureseriesCategoryId the primary key of the lectureseries_ category
	* @return the lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category findByPrimaryKey(
		long lectureseriesCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException;

	/**
	* Returns the lectureseries_ category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lectureseriesCategoryId the primary key of the lectureseries_ category
	* @return the lectureseries_ category, or <code>null</code> if a lectureseries_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Category fetchByPrimaryKey(
		long lectureseriesCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureseries_ categories.
	*
	* @return the lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @return the range of lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lectureseries_ categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ categories.
	*
	* @return the number of lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}