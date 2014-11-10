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

import com.liferay.portal.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.model.Segment_User_Video;

/**
 * The persistence interface for the segment_ user_ video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Segment_User_VideoPersistenceImpl
 * @see Segment_User_VideoUtil
 * @generated
 */
public interface Segment_User_VideoPersistence extends BasePersistence<Segment_User_Video> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Segment_User_VideoUtil} to access the segment_ user_ video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the segment_ user_ videos where segmentId = &#63;.
	*
	* @param segmentId the segment ID
	* @return the matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findBySegment(
		long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findBySegment(
		long segmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findBySegment(
		long segmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first segment_ user_ video in the ordered set where segmentId = &#63;.
	*
	* @param segmentId the segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video findBySegment_First(
		long segmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException;

	/**
	* Returns the first segment_ user_ video in the ordered set where segmentId = &#63;.
	*
	* @param segmentId the segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video fetchBySegment_First(
		long segmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last segment_ user_ video in the ordered set where segmentId = &#63;.
	*
	* @param segmentId the segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video findBySegment_Last(
		long segmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException;

	/**
	* Returns the last segment_ user_ video in the ordered set where segmentId = &#63;.
	*
	* @param segmentId the segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video fetchBySegment_Last(
		long segmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Segment_User_Video[] findBySegment_PrevAndNext(
		long segmentUserVideoId, long segmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException;

	/**
	* Removes all the segment_ user_ videos where segmentId = &#63; from the database.
	*
	* @param segmentId the segment ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySegment(long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of segment_ user_ videos where segmentId = &#63;.
	*
	* @param segmentId the segment ID
	* @return the number of matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public int countBySegment(long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the segment_ user_ videos where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first segment_ user_ video in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException;

	/**
	* Returns the first segment_ user_ video in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last segment_ user_ video in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException;

	/**
	* Returns the last segment_ user_ video in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Segment_User_Video[] findByUser_PrevAndNext(
		long segmentUserVideoId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException;

	/**
	* Removes all the segment_ user_ videos where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of segment_ user_ videos where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the segment_ user_ videos where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findByVideo(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findByVideo(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first segment_ user_ video in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video findByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException;

	/**
	* Returns the first segment_ user_ video in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last segment_ user_ video in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video findByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException;

	/**
	* Returns the last segment_ user_ video in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Segment_User_Video[] findByVideo_PrevAndNext(
		long segmentUserVideoId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException;

	/**
	* Removes all the segment_ user_ videos where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of segment_ user_ videos where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the segment_ user_ video in the entity cache if it is enabled.
	*
	* @param segment_User_Video the segment_ user_ video
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.model.Segment_User_Video segment_User_Video);

	/**
	* Caches the segment_ user_ videos in the entity cache if it is enabled.
	*
	* @param segment_User_Videos the segment_ user_ videos
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> segment_User_Videos);

	/**
	* Creates a new segment_ user_ video with the primary key. Does not add the segment_ user_ video to the database.
	*
	* @param segmentUserVideoId the primary key for the new segment_ user_ video
	* @return the new segment_ user_ video
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video create(
		long segmentUserVideoId);

	/**
	* Removes the segment_ user_ video with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param segmentUserVideoId the primary key of the segment_ user_ video
	* @return the segment_ user_ video that was removed
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a segment_ user_ video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video remove(
		long segmentUserVideoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException;

	public de.uhh.l2g.plugins.model.Segment_User_Video updateImpl(
		de.uhh.l2g.plugins.model.Segment_User_Video segment_User_Video)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the segment_ user_ video with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchSegment_User_VideoException} if it could not be found.
	*
	* @param segmentUserVideoId the primary key of the segment_ user_ video
	* @return the segment_ user_ video
	* @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a segment_ user_ video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video findByPrimaryKey(
		long segmentUserVideoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchSegment_User_VideoException;

	/**
	* Returns the segment_ user_ video with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param segmentUserVideoId the primary key of the segment_ user_ video
	* @return the segment_ user_ video, or <code>null</code> if a segment_ user_ video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Segment_User_Video fetchByPrimaryKey(
		long segmentUserVideoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the segment_ user_ videos.
	*
	* @return the segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the segment_ user_ videos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of segment_ user_ videos.
	*
	* @return the number of segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}