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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.model.Lectureseries_Category;

import java.util.List;

/**
 * The persistence utility for the lectureseries_ category service. This utility wraps {@link Lectureseries_CategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_CategoryPersistence
 * @see Lectureseries_CategoryPersistenceImpl
 * @generated
 */
public class Lectureseries_CategoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Lectureseries_Category lectureseries_Category) {
		getPersistence().clearCache(lectureseries_Category);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Lectureseries_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lectureseries_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lectureseries_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Lectureseries_Category update(
		Lectureseries_Category lectureseries_Category)
		throws SystemException {
		return getPersistence().update(lectureseries_Category);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Lectureseries_Category update(
		Lectureseries_Category lectureseries_Category,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lectureseries_Category, serviceContext);
	}

	/**
	* Returns all the lectureseries_ categories where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLectureseries(lectureseriesId);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByLectureseries(
		long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLectureseries(lectureseriesId, start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByLectureseries(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseries(lectureseriesId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category findByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByLectureseries_First(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the first lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category fetchByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseries_First(lectureseriesId,
			orderByComparator);
	}

	/**
	* Returns the last lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category findByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByLectureseries_Last(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category fetchByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseries_Last(lectureseriesId, orderByComparator);
	}

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
	public static de.uhh.l2g.plugins.model.Lectureseries_Category[] findByLectureseries_PrevAndNext(
		long lectureseriesCategoryId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByLectureseries_PrevAndNext(lectureseriesCategoryId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ categories where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLectureseries(lectureseriesId);
	}

	/**
	* Returns the number of lectureseries_ categories where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLectureseries(lectureseriesId);
	}

	/**
	* Returns all the lectureseries_ categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId, start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory(categoryId, start, end, orderByComparator);
	}

	/**
	* Returns the first lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the first lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByCategory_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_Last(categoryId, orderByComparator);
	}

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
	public static de.uhh.l2g.plugins.model.Lectureseries_Category[] findByCategory_PrevAndNext(
		long lectureseriesCategoryId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByCategory_PrevAndNext(lectureseriesCategoryId,
			categoryId, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ categories where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategory(categoryId);
	}

	/**
	* Returns the number of lectureseries_ categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(categoryId);
	}

	/**
	* Caches the lectureseries_ category in the entity cache if it is enabled.
	*
	* @param lectureseries_Category the lectureseries_ category
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Lectureseries_Category lectureseries_Category) {
		getPersistence().cacheResult(lectureseries_Category);
	}

	/**
	* Caches the lectureseries_ categories in the entity cache if it is enabled.
	*
	* @param lectureseries_Categories the lectureseries_ categories
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> lectureseries_Categories) {
		getPersistence().cacheResult(lectureseries_Categories);
	}

	/**
	* Creates a new lectureseries_ category with the primary key. Does not add the lectureseries_ category to the database.
	*
	* @param lectureseriesCategoryId the primary key for the new lectureseries_ category
	* @return the new lectureseries_ category
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category create(
		long lectureseriesCategoryId) {
		return getPersistence().create(lectureseriesCategoryId);
	}

	/**
	* Removes the lectureseries_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesCategoryId the primary key of the lectureseries_ category
	* @return the lectureseries_ category that was removed
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category remove(
		long lectureseriesCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException {
		return getPersistence().remove(lectureseriesCategoryId);
	}

	public static de.uhh.l2g.plugins.model.Lectureseries_Category updateImpl(
		de.uhh.l2g.plugins.model.Lectureseries_Category lectureseries_Category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lectureseries_Category);
	}

	/**
	* Returns the lectureseries_ category with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException} if it could not be found.
	*
	* @param lectureseriesCategoryId the primary key of the lectureseries_ category
	* @return the lectureseries_ category
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category findByPrimaryKey(
		long lectureseriesCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException {
		return getPersistence().findByPrimaryKey(lectureseriesCategoryId);
	}

	/**
	* Returns the lectureseries_ category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lectureseriesCategoryId the primary key of the lectureseries_ category
	* @return the lectureseries_ category, or <code>null</code> if a lectureseries_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Category fetchByPrimaryKey(
		long lectureseriesCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(lectureseriesCategoryId);
	}

	/**
	* Returns all the lectureseries_ categories.
	*
	* @return the lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lectureseries_ categories.
	*
	* @return the number of lectureseries_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Lectureseries_CategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Lectureseries_CategoryPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					Lectureseries_CategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(Lectureseries_CategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Lectureseries_CategoryPersistence persistence) {
	}

	private static Lectureseries_CategoryPersistence _persistence;
}