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

import de.uhh.l2g.plugins.model.Video_Creator;

import java.util.List;

/**
 * The persistence utility for the video_ creator service. This utility wraps {@link Video_CreatorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_CreatorPersistence
 * @see Video_CreatorPersistenceImpl
 * @generated
 */
public class Video_CreatorUtil {
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
	public static void clearCache(Video_Creator video_Creator) {
		getPersistence().clearCache(video_Creator);
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
	public static List<Video_Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Video_Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Video_Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Video_Creator update(Video_Creator video_Creator)
		throws SystemException {
		return getPersistence().update(video_Creator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Video_Creator update(Video_Creator video_Creator,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(video_Creator, serviceContext);
	}

	/**
	* Returns all the video_ creators where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByVideo(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideo(videoId);
	}

	/**
	* Returns a range of all the video_ creators where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @return the range of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByVideo(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	* Returns an ordered range of all the video_ creators where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideo(videoId, start, end, orderByComparator);
	}

	/**
	* Returns the first video_ creator in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator findByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException {
		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the first video_ creator in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the last video_ creator in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator findByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException {
		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the last video_ creator in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63;.
	*
	* @param videoCreatorId the primary key of the current video_ creator
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator[] findByVideo_PrevAndNext(
		long videoCreatorId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException {
		return getPersistence()
				   .findByVideo_PrevAndNext(videoCreatorId, videoId,
			orderByComparator);
	}

	/**
	* Removes all the video_ creators where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVideo(videoId);
	}

	/**
	* Returns the number of video_ creators where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVideo(videoId);
	}

	/**
	* Returns all the video_ creators where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByCreator(
		long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreator(creatorId);
	}

	/**
	* Returns a range of all the video_ creators where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @return the range of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByCreator(
		long creatorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreator(creatorId, start, end);
	}

	/**
	* Returns an ordered range of all the video_ creators where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByCreator(
		long creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreator(creatorId, start, end, orderByComparator);
	}

	/**
	* Returns the first video_ creator in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator findByCreator_First(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException {
		return getPersistence().findByCreator_First(creatorId, orderByComparator);
	}

	/**
	* Returns the first video_ creator in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator fetchByCreator_First(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreator_First(creatorId, orderByComparator);
	}

	/**
	* Returns the last video_ creator in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator findByCreator_Last(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException {
		return getPersistence().findByCreator_Last(creatorId, orderByComparator);
	}

	/**
	* Returns the last video_ creator in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator fetchByCreator_Last(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCreator_Last(creatorId, orderByComparator);
	}

	/**
	* Returns the video_ creators before and after the current video_ creator in the ordered set where creatorId = &#63;.
	*
	* @param videoCreatorId the primary key of the current video_ creator
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator[] findByCreator_PrevAndNext(
		long videoCreatorId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException {
		return getPersistence()
				   .findByCreator_PrevAndNext(videoCreatorId, creatorId,
			orderByComparator);
	}

	/**
	* Removes all the video_ creators where creatorId = &#63; from the database.
	*
	* @param creatorId the creator ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCreator(creatorId);
	}

	/**
	* Returns the number of video_ creators where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the number of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCreator(creatorId);
	}

	/**
	* Returns all the video_ creators where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @return the matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByVideoCreator(
		long videoId, long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideoCreator(videoId, creatorId);
	}

	/**
	* Returns a range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @return the range of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideoCreator(videoId, creatorId, start, end);
	}

	/**
	* Returns an ordered range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideoCreator(videoId, creatorId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator findByVideoCreator_First(
		long videoId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException {
		return getPersistence()
				   .findByVideoCreator_First(videoId, creatorId,
			orderByComparator);
	}

	/**
	* Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator fetchByVideoCreator_First(
		long videoId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVideoCreator_First(videoId, creatorId,
			orderByComparator);
	}

	/**
	* Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator findByVideoCreator_Last(
		long videoId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException {
		return getPersistence()
				   .findByVideoCreator_Last(videoId, creatorId,
			orderByComparator);
	}

	/**
	* Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator fetchByVideoCreator_Last(
		long videoId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVideoCreator_Last(videoId, creatorId,
			orderByComparator);
	}

	/**
	* Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoCreatorId the primary key of the current video_ creator
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator[] findByVideoCreator_PrevAndNext(
		long videoCreatorId, long videoId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException {
		return getPersistence()
				   .findByVideoCreator_PrevAndNext(videoCreatorId, videoId,
			creatorId, orderByComparator);
	}

	/**
	* Removes all the video_ creators where videoId = &#63; and creatorId = &#63; from the database.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideoCreator(long videoId, long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVideoCreator(videoId, creatorId);
	}

	/**
	* Returns the number of video_ creators where videoId = &#63; and creatorId = &#63;.
	*
	* @param videoId the video ID
	* @param creatorId the creator ID
	* @return the number of matching video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideoCreator(long videoId, long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVideoCreator(videoId, creatorId);
	}

	/**
	* Caches the video_ creator in the entity cache if it is enabled.
	*
	* @param video_Creator the video_ creator
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator) {
		getPersistence().cacheResult(video_Creator);
	}

	/**
	* Caches the video_ creators in the entity cache if it is enabled.
	*
	* @param video_Creators the video_ creators
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Video_Creator> video_Creators) {
		getPersistence().cacheResult(video_Creators);
	}

	/**
	* Creates a new video_ creator with the primary key. Does not add the video_ creator to the database.
	*
	* @param videoCreatorId the primary key for the new video_ creator
	* @return the new video_ creator
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator create(
		long videoCreatorId) {
		return getPersistence().create(videoCreatorId);
	}

	/**
	* Removes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoCreatorId the primary key of the video_ creator
	* @return the video_ creator that was removed
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator remove(
		long videoCreatorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException {
		return getPersistence().remove(videoCreatorId);
	}

	public static de.uhh.l2g.plugins.model.Video_Creator updateImpl(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(video_Creator);
	}

	/**
	* Returns the video_ creator with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideo_CreatorException} if it could not be found.
	*
	* @param videoCreatorId the primary key of the video_ creator
	* @return the video_ creator
	* @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator findByPrimaryKey(
		long videoCreatorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_CreatorException {
		return getPersistence().findByPrimaryKey(videoCreatorId);
	}

	/**
	* Returns the video_ creator with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoCreatorId the primary key of the video_ creator
	* @return the video_ creator, or <code>null</code> if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Creator fetchByPrimaryKey(
		long videoCreatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videoCreatorId);
	}

	/**
	* Returns all the video_ creators.
	*
	* @return the video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video_ creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @return the range of video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video_ creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Creator> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video_ creators from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video_ creators.
	*
	* @return the number of video_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Video_CreatorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Video_CreatorPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					Video_CreatorPersistence.class.getName());

			ReferenceRegistry.registerReference(Video_CreatorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Video_CreatorPersistence persistence) {
	}

	private static Video_CreatorPersistence _persistence;
}