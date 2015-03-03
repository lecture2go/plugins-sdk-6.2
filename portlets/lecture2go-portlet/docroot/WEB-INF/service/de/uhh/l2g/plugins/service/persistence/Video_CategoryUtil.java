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

import de.uhh.l2g.plugins.model.Video_Category;

import java.util.List;

/**
 * The persistence utility for the video_ category service. This utility wraps {@link Video_CategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_CategoryPersistence
 * @see Video_CategoryPersistenceImpl
 * @generated
 */
public class Video_CategoryUtil {
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
	public static void clearCache(Video_Category video_Category) {
		getPersistence().clearCache(video_Category);
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
	public static List<Video_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Video_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Video_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Video_Category update(Video_Category video_Category)
		throws SystemException {
		return getPersistence().update(video_Category);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Video_Category update(Video_Category video_Category,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(video_Category, serviceContext);
	}

	/**
	* Returns all the video_ categories where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching video_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Category> findByVideo(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideo(videoId);
	}

	/**
	* Returns a range of all the video_ categories where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video_ categories
	* @param end the upper bound of the range of video_ categories (not inclusive)
	* @return the range of matching video_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Category> findByVideo(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	* Returns an ordered range of all the video_ categories where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video_ categories
	* @param end the upper bound of the range of video_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Category> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideo(videoId, start, end, orderByComparator);
	}

	/**
	* Returns the first video_ category in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ category
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a matching video_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category findByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CategoryException {
		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the first video_ category in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the last video_ category in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ category
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a matching video_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category findByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CategoryException {
		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the last video_ category in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the video_ categories before and after the current video_ category in the ordered set where videoId = &#63;.
	*
	* @param videoCategoryId the primary key of the current video_ category
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ category
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category[] findByVideo_PrevAndNext(
		long videoCategoryId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CategoryException {
		return getPersistence()
				   .findByVideo_PrevAndNext(videoCategoryId, videoId,
			orderByComparator);
	}

	/**
	* Removes all the video_ categories where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVideo(videoId);
	}

	/**
	* Returns the number of video_ categories where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching video_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVideo(videoId);
	}

	/**
	* Returns all the video_ categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching video_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Category> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId);
	}

	/**
	* Returns a range of all the video_ categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of video_ categories
	* @param end the upper bound of the range of video_ categories (not inclusive)
	* @return the range of matching video_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Category> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the video_ categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of video_ categories
	* @param end the upper bound of the range of video_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Category> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory(categoryId, start, end, orderByComparator);
	}

	/**
	* Returns the first video_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ category
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a matching video_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CategoryException {
		return getPersistence()
				   .findByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the first video_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the last video_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ category
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a matching video_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CategoryException {
		return getPersistence()
				   .findByCategory_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the last video_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the video_ categories before and after the current video_ category in the ordered set where categoryId = &#63;.
	*
	* @param videoCategoryId the primary key of the current video_ category
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ category
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category[] findByCategory_PrevAndNext(
		long videoCategoryId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CategoryException {
		return getPersistence()
				   .findByCategory_PrevAndNext(videoCategoryId, categoryId,
			orderByComparator);
	}

	/**
	* Removes all the video_ categories where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategory(categoryId);
	}

	/**
	* Returns the number of video_ categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching video_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(categoryId);
	}

	/**
	* Caches the video_ category in the entity cache if it is enabled.
	*
	* @param video_Category the video_ category
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Video_Category video_Category) {
		getPersistence().cacheResult(video_Category);
	}

	/**
	* Caches the video_ categories in the entity cache if it is enabled.
	*
	* @param video_Categories the video_ categories
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Video_Category> video_Categories) {
		getPersistence().cacheResult(video_Categories);
	}

	/**
	* Creates a new video_ category with the primary key. Does not add the video_ category to the database.
	*
	* @param videoCategoryId the primary key for the new video_ category
	* @return the new video_ category
	*/
	public static de.uhh.l2g.plugins.model.Video_Category create(
		long videoCategoryId) {
		return getPersistence().create(videoCategoryId);
	}

	/**
	* Removes the video_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoCategoryId the primary key of the video_ category
	* @return the video_ category that was removed
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category remove(
		long videoCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CategoryException {
		return getPersistence().remove(videoCategoryId);
	}

	public static de.uhh.l2g.plugins.model.Video_Category updateImpl(
		de.uhh.l2g.plugins.model.Video_Category video_Category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(video_Category);
	}

	/**
	* Returns the video_ category with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideo_CategoryException} if it could not be found.
	*
	* @param videoCategoryId the primary key of the video_ category
	* @return the video_ category
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category findByPrimaryKey(
		long videoCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CategoryException {
		return getPersistence().findByPrimaryKey(videoCategoryId);
	}

	/**
	* Returns the video_ category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoCategoryId the primary key of the video_ category
	* @return the video_ category, or <code>null</code> if a video_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Category fetchByPrimaryKey(
		long videoCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videoCategoryId);
	}

	/**
	* Returns all the video_ categories.
	*
	* @return the video_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ categories
	* @param end the upper bound of the range of video_ categories (not inclusive)
	* @return the range of video_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ categories
	* @param end the upper bound of the range of video_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video_ categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video_ categories.
	*
	* @return the number of video_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Video_CategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Video_CategoryPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					Video_CategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(Video_CategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Video_CategoryPersistence persistence) {
	}

	private static Video_CategoryPersistence _persistence;
}