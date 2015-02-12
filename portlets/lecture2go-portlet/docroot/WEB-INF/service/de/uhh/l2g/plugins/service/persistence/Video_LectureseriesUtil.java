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

import de.uhh.l2g.plugins.model.Video_Lectureseries;

import java.util.List;

/**
 * The persistence utility for the video_ lectureseries service. This utility wraps {@link Video_LectureseriesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_LectureseriesPersistence
 * @see Video_LectureseriesPersistenceImpl
 * @generated
 */
public class Video_LectureseriesUtil {
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
	public static void clearCache(Video_Lectureseries video_Lectureseries) {
		getPersistence().clearCache(video_Lectureseries);
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
	public static List<Video_Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Video_Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Video_Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Video_Lectureseries update(
		Video_Lectureseries video_Lectureseries) throws SystemException {
		return getPersistence().update(video_Lectureseries);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Video_Lectureseries update(
		Video_Lectureseries video_Lectureseries, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(video_Lectureseries, serviceContext);
	}

	/**
	* Returns all the video_ lectureserieses where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries> findByVideo(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideo(videoId);
	}

	/**
	* Returns a range of all the video_ lectureserieses where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video_ lectureserieses
	* @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	* @return the range of matching video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries> findByVideo(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	* Returns an ordered range of all the video_ lectureserieses where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video_ lectureserieses
	* @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideo(videoId, start, end, orderByComparator);
	}

	/**
	* Returns the first video_ lectureseries in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException if a matching video_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries findByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException {
		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the first video_ lectureseries in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the last video_ lectureseries in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException if a matching video_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries findByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException {
		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the last video_ lectureseries in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the video_ lectureserieses before and after the current video_ lectureseries in the ordered set where videoId = &#63;.
	*
	* @param videoLectureseriesId the primary key of the current video_ lectureseries
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries[] findByVideo_PrevAndNext(
		long videoLectureseriesId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException {
		return getPersistence()
				   .findByVideo_PrevAndNext(videoLectureseriesId, videoId,
			orderByComparator);
	}

	/**
	* Removes all the video_ lectureserieses where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVideo(videoId);
	}

	/**
	* Returns the number of video_ lectureserieses where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVideo(videoId);
	}

	/**
	* Returns all the video_ lectureserieses where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries> findByLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLectureseries(lectureseriesId);
	}

	/**
	* Returns a range of all the video_ lectureserieses where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of video_ lectureserieses
	* @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	* @return the range of matching video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries> findByLectureseries(
		long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLectureseries(lectureseriesId, start, end);
	}

	/**
	* Returns an ordered range of all the video_ lectureserieses where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of video_ lectureserieses
	* @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries> findByLectureseries(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseries(lectureseriesId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first video_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException if a matching video_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries findByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException {
		return getPersistence()
				   .findByLectureseries_First(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the first video_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries fetchByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseries_First(lectureseriesId,
			orderByComparator);
	}

	/**
	* Returns the last video_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException if a matching video_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries findByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException {
		return getPersistence()
				   .findByLectureseries_Last(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the last video_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries fetchByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseries_Last(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the video_ lectureserieses before and after the current video_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param videoLectureseriesId the primary key of the current video_ lectureseries
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries[] findByLectureseries_PrevAndNext(
		long videoLectureseriesId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException {
		return getPersistence()
				   .findByLectureseries_PrevAndNext(videoLectureseriesId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Removes all the video_ lectureserieses where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLectureseries(lectureseriesId);
	}

	/**
	* Returns the number of video_ lectureserieses where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLectureseries(lectureseriesId);
	}

	/**
	* Caches the video_ lectureseries in the entity cache if it is enabled.
	*
	* @param video_Lectureseries the video_ lectureseries
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Video_Lectureseries video_Lectureseries) {
		getPersistence().cacheResult(video_Lectureseries);
	}

	/**
	* Caches the video_ lectureserieses in the entity cache if it is enabled.
	*
	* @param video_Lectureserieses the video_ lectureserieses
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries> video_Lectureserieses) {
		getPersistence().cacheResult(video_Lectureserieses);
	}

	/**
	* Creates a new video_ lectureseries with the primary key. Does not add the video_ lectureseries to the database.
	*
	* @param videoLectureseriesId the primary key for the new video_ lectureseries
	* @return the new video_ lectureseries
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries create(
		long videoLectureseriesId) {
		return getPersistence().create(videoLectureseriesId);
	}

	/**
	* Removes the video_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoLectureseriesId the primary key of the video_ lectureseries
	* @return the video_ lectureseries that was removed
	* @throws de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries remove(
		long videoLectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException {
		return getPersistence().remove(videoLectureseriesId);
	}

	public static de.uhh.l2g.plugins.model.Video_Lectureseries updateImpl(
		de.uhh.l2g.plugins.model.Video_Lectureseries video_Lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(video_Lectureseries);
	}

	/**
	* Returns the video_ lectureseries with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException} if it could not be found.
	*
	* @param videoLectureseriesId the primary key of the video_ lectureseries
	* @return the video_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries findByPrimaryKey(
		long videoLectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException {
		return getPersistence().findByPrimaryKey(videoLectureseriesId);
	}

	/**
	* Returns the video_ lectureseries with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoLectureseriesId the primary key of the video_ lectureseries
	* @return the video_ lectureseries, or <code>null</code> if a video_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Lectureseries fetchByPrimaryKey(
		long videoLectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videoLectureseriesId);
	}

	/**
	* Returns all the video_ lectureserieses.
	*
	* @return the video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video_ lectureserieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ lectureserieses
	* @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	* @return the range of video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video_ lectureserieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ lectureserieses
	* @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video_ lectureserieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video_ lectureserieses.
	*
	* @return the number of video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Video_LectureseriesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Video_LectureseriesPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					Video_LectureseriesPersistence.class.getName());

			ReferenceRegistry.registerReference(Video_LectureseriesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Video_LectureseriesPersistence persistence) {
	}

	private static Video_LectureseriesPersistence _persistence;
}