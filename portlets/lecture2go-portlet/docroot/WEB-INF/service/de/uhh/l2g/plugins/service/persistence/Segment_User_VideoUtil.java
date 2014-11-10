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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.model.Segment_User_Video;

import java.util.List;

/**
 * The persistence utility for the segment_ user_ video service. This utility wraps {@link Segment_User_VideoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Segment_User_VideoPersistence
 * @see Segment_User_VideoPersistenceImpl
 * @generated
 */
public class Segment_User_VideoUtil {
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
	public static void clearCache(Segment_User_Video segment_User_Video) {
		getPersistence().clearCache(segment_User_Video);
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
	public static List<Segment_User_Video> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Segment_User_Video> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Segment_User_Video> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Segment_User_Video update(
		Segment_User_Video segment_User_Video) throws SystemException {
		return getPersistence().update(segment_User_Video);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Segment_User_Video update(
		Segment_User_Video segment_User_Video, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(segment_User_Video, serviceContext);
	}

	/**
	* Returns all the segment_ user_ videos where segmentId = &#63;.
	*
	* @param segmentId the segment ID
	* @return the matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findBySegment(
		long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySegment(segmentId);
	}

	/**
	* Returns a range of all the segment_ user_ videos where segmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Segment_User_VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param segmentId the segment ID
	* @param start the lower bound of the range of segment_ user_ videos
	* @param end the upper bound of the range of segment_ user_ videos (not inclusive)
	* @return the range of matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findBySegment(
		long segmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySegment(segmentId, start, end);
	}

	/**
	* Returns an ordered range of all the segment_ user_ videos where segmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Segment_User_VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param segmentId the segment ID
	* @param start the lower bound of the range of segment_ user_ videos
	* @param end the upper bound of the range of segment_ user_ videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findBySegment(
		long segmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySegment(segmentId, start, end, orderByComparator);
	}

	/**
	* Returns the first segment_ user_ video in the ordered set where segmentId = &#63;.
	*
	* @param segmentId the segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video findBySegment_First(
		long segmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException {
		return getPersistence().findBySegment_First(segmentId, orderByComparator);
	}

	/**
	* Returns the first segment_ user_ video in the ordered set where segmentId = &#63;.
	*
	* @param segmentId the segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video fetchBySegment_First(
		long segmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySegment_First(segmentId, orderByComparator);
	}

	/**
	* Returns the last segment_ user_ video in the ordered set where segmentId = &#63;.
	*
	* @param segmentId the segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video findBySegment_Last(
		long segmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException {
		return getPersistence().findBySegment_Last(segmentId, orderByComparator);
	}

	/**
	* Returns the last segment_ user_ video in the ordered set where segmentId = &#63;.
	*
	* @param segmentId the segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video fetchBySegment_Last(
		long segmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySegment_Last(segmentId, orderByComparator);
	}

	/**
	* Returns the segment_ user_ videos before and after the current segment_ user_ video in the ordered set where segmentId = &#63;.
	*
	* @param segmentUserVideoId the primary key of the current segment_ user_ video
	* @param segmentId the segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a segment_ user_ video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video[] findBySegment_PrevAndNext(
		long segmentUserVideoId, long segmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException {
		return getPersistence()
				   .findBySegment_PrevAndNext(segmentUserVideoId, segmentId,
			orderByComparator);
	}

	/**
	* Removes all the segment_ user_ videos where segmentId = &#63; from the database.
	*
	* @param segmentId the segment ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySegment(long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySegment(segmentId);
	}

	/**
	* Returns the number of segment_ user_ videos where segmentId = &#63;.
	*
	* @param segmentId the segment ID
	* @return the number of matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySegment(long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySegment(segmentId);
	}

	/**
	* Returns all the segment_ user_ videos where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId);
	}

	/**
	* Returns a range of all the segment_ user_ videos where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Segment_User_VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of segment_ user_ videos
	* @param end the upper bound of the range of segment_ user_ videos (not inclusive)
	* @return the range of matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the segment_ user_ videos where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Segment_User_VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of segment_ user_ videos
	* @param end the upper bound of the range of segment_ user_ videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first segment_ user_ video in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first segment_ user_ video in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last segment_ user_ video in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last segment_ user_ video in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the segment_ user_ videos before and after the current segment_ user_ video in the ordered set where userId = &#63;.
	*
	* @param segmentUserVideoId the primary key of the current segment_ user_ video
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a segment_ user_ video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video[] findByUser_PrevAndNext(
		long segmentUserVideoId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException {
		return getPersistence()
				   .findByUser_PrevAndNext(segmentUserVideoId, userId,
			orderByComparator);
	}

	/**
	* Removes all the segment_ user_ videos where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of segment_ user_ videos where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns all the segment_ user_ videos where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findByVideo(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideo(videoId);
	}

	/**
	* Returns a range of all the segment_ user_ videos where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Segment_User_VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of segment_ user_ videos
	* @param end the upper bound of the range of segment_ user_ videos (not inclusive)
	* @return the range of matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findByVideo(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	* Returns an ordered range of all the segment_ user_ videos where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Segment_User_VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of segment_ user_ videos
	* @param end the upper bound of the range of segment_ user_ videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideo(videoId, start, end, orderByComparator);
	}

	/**
	* Returns the first segment_ user_ video in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video findByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException {
		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the first segment_ user_ video in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the last segment_ user_ video in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video findByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException {
		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the last segment_ user_ video in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the segment_ user_ videos before and after the current segment_ user_ video in the ordered set where videoId = &#63;.
	*
	* @param segmentUserVideoId the primary key of the current segment_ user_ video
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a segment_ user_ video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video[] findByVideo_PrevAndNext(
		long segmentUserVideoId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException {
		return getPersistence()
				   .findByVideo_PrevAndNext(segmentUserVideoId, videoId,
			orderByComparator);
	}

	/**
	* Removes all the segment_ user_ videos where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVideo(videoId);
	}

	/**
	* Returns the number of segment_ user_ videos where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVideo(videoId);
	}

	/**
	* Caches the segment_ user_ video in the entity cache if it is enabled.
	*
	* @param segment_User_Video the segment_ user_ video
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Segment_User_Video segment_User_Video) {
		getPersistence().cacheResult(segment_User_Video);
	}

	/**
	* Caches the segment_ user_ videos in the entity cache if it is enabled.
	*
	* @param segment_User_Videos the segment_ user_ videos
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> segment_User_Videos) {
		getPersistence().cacheResult(segment_User_Videos);
	}

	/**
	* Creates a new segment_ user_ video with the primary key. Does not add the segment_ user_ video to the database.
	*
	* @param segmentUserVideoId the primary key for the new segment_ user_ video
	* @return the new segment_ user_ video
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video create(
		long segmentUserVideoId) {
		return getPersistence().create(segmentUserVideoId);
	}

	/**
	* Removes the segment_ user_ video with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param segmentUserVideoId the primary key of the segment_ user_ video
	* @return the segment_ user_ video that was removed
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a segment_ user_ video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video remove(
		long segmentUserVideoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException {
		return getPersistence().remove(segmentUserVideoId);
	}

	public static de.uhh.l2g.plugins.model.Segment_User_Video updateImpl(
		de.uhh.l2g.plugins.model.Segment_User_Video segment_User_Video)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(segment_User_Video);
	}

	/**
	* Returns the segment_ user_ video with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchSegment_User_VideoException} if it could not be found.
	*
	* @param segmentUserVideoId the primary key of the segment_ user_ video
	* @return the segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a segment_ user_ video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video findByPrimaryKey(
		long segmentUserVideoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException {
		return getPersistence().findByPrimaryKey(segmentUserVideoId);
	}

	/**
	* Returns the segment_ user_ video with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param segmentUserVideoId the primary key of the segment_ user_ video
	* @return the segment_ user_ video, or <code>null</code> if a segment_ user_ video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video fetchByPrimaryKey(
		long segmentUserVideoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(segmentUserVideoId);
	}

	/**
	* Returns all the segment_ user_ videos.
	*
	* @return the segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the segment_ user_ videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Segment_User_VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segment_ user_ videos
	* @param end the upper bound of the range of segment_ user_ videos (not inclusive)
	* @return the range of segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the segment_ user_ videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Segment_User_VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segment_ user_ videos
	* @param end the upper bound of the range of segment_ user_ videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the segment_ user_ videos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of segment_ user_ videos.
	*
	* @return the number of segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Segment_User_VideoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Segment_User_VideoPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					Segment_User_VideoPersistence.class.getName());

			ReferenceRegistry.registerReference(Segment_User_VideoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Segment_User_VideoPersistence persistence) {
	}

	private static Segment_User_VideoPersistence _persistence;
}