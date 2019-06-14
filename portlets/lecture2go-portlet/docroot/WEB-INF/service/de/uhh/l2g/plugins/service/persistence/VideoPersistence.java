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

import de.uhh.l2g.plugins.model.Video;

/**
 * The persistence interface for the video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideoPersistenceImpl
 * @see VideoUtil
 * @generated
 */
public interface VideoPersistence extends BasePersistence<Video> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoUtil} to access the video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the videos where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByProducer(
		long producerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where producerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByProducer(
		long producerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where producerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByProducer(
		long producerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByProducer_First(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByProducer_First(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByProducer_Last(long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByProducer_Last(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where producerId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByProducer_PrevAndNext(
		long videoId, long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where producerId = &#63; from the database.
	*
	* @param producerId the producer ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProducer(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByProducer(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByLectureseries(
		long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByLectureseries(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where lectureseriesId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByLectureseries_PrevAndNext(
		long videoId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where producerId = &#63; and lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where producerId = &#63; and lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByProducerAndLectureseries_First(
		long producerId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByProducerAndLectureseries_First(
		long producerId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByProducerAndLectureseries_Last(
		long producerId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByProducerAndLectureseries_Last(
		long producerId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByProducerAndLectureseries_PrevAndNext(
		long videoId, long producerId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where producerId = &#63; and lectureseriesId = &#63; from the database.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProducerAndLectureseries(long producerId,
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where producerId = &#63; and lectureseriesId = &#63;.
	*
	* @param producerId the producer ID
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByProducerAndLectureseries(long producerId,
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where producerId = &#63; and downloadLink = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where producerId = &#63; and downloadLink = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByProducerAndDownloadLink_First(
		long producerId, int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByProducerAndDownloadLink_First(
		long producerId, int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByProducerAndDownloadLink_Last(
		long producerId, int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByProducerAndDownloadLink_Last(
		long producerId, int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByProducerAndDownloadLink_PrevAndNext(
		long videoId, long producerId, int downloadLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where producerId = &#63; and downloadLink = &#63; from the database.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProducerAndDownloadLink(long producerId,
		int downloadLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where producerId = &#63; and downloadLink = &#63;.
	*
	* @param producerId the producer ID
	* @param downloadLink the download link
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByProducerAndDownloadLink(long producerId, int downloadLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByLectureseriesAndOpenaccess_First(
		long lectureseriesId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByLectureseriesAndOpenaccess_First(
		long lectureseriesId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByLectureseriesAndOpenaccess_Last(
		long lectureseriesId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByLectureseriesAndOpenaccess_Last(
		long lectureseriesId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByLectureseriesAndOpenaccess_PrevAndNext(
		long videoId, long lectureseriesId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where lectureseriesId = &#63; and openAccess = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLectureseriesAndOpenaccess(long lectureseriesId,
		int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where lectureseriesId = &#63; and openAccess = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param openAccess the open access
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByLectureseriesAndOpenaccess(long lectureseriesId,
		int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos where filename = &#63;.
	*
	* @param filename the filename
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByFilename(
		java.lang.String filename)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where filename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filename the filename
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByFilename(
		java.lang.String filename, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where filename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filename the filename
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByFilename(
		java.lang.String filename, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByFilename_First(
		java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByFilename_First(
		java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByFilename_Last(
		java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByFilename_Last(
		java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where filename = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByFilename_PrevAndNext(
		long videoId, java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where filename = &#63; from the database.
	*
	* @param filename the filename
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFilename(java.lang.String filename)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where filename = &#63;.
	*
	* @param filename the filename
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByFilename(java.lang.String filename)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByUploadDate(
		java.util.Date uploadDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where uploadDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uploadDate the upload date
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByUploadDate(
		java.util.Date uploadDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where uploadDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uploadDate the upload date
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByUploadDate(
		java.util.Date uploadDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByUploadDate_First(
		java.util.Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByUploadDate_First(
		java.util.Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByUploadDate_Last(
		java.util.Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByUploadDate_Last(
		java.util.Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where uploadDate = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param uploadDate the upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByUploadDate_PrevAndNext(
		long videoId, java.util.Date uploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where uploadDate = &#63; from the database.
	*
	* @param uploadDate the upload date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUploadDate(java.util.Date uploadDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where uploadDate = &#63;.
	*
	* @param uploadDate the upload date
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUploadDate(java.util.Date uploadDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByRootInstitution(
		long rootInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where rootInstitutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rootInstitutionId the root institution ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByRootInstitution(
		long rootInstitutionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where rootInstitutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rootInstitutionId the root institution ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByRootInstitution(
		long rootInstitutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByRootInstitution_First(
		long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByRootInstitution_First(
		long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByRootInstitution_Last(
		long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByRootInstitution_Last(
		long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where rootInstitutionId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param rootInstitutionId the root institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByRootInstitution_PrevAndNext(
		long videoId, long rootInstitutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where rootInstitutionId = &#63; from the database.
	*
	* @param rootInstitutionId the root institution ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRootInstitution(long rootInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where rootInstitutionId = &#63;.
	*
	* @param rootInstitutionId the root institution ID
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByRootInstitution(long rootInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos where password = &#63;.
	*
	* @param password the password
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByPassword(
		java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where password = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param password the password
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByPassword(
		java.lang.String password, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where password = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param password the password
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByPassword(
		java.lang.String password, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByPassword_First(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByPassword_First(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByPassword_Last(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByPassword_Last(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where password = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByPassword_PrevAndNext(
		long videoId, java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where password = &#63; from the database.
	*
	* @param password the password
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPassword(java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where password = &#63;.
	*
	* @param password the password
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByPassword(java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByOpenAccess(
		int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where openAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param openAccess the open access
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByOpenAccess(
		int openAccess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where openAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param openAccess the open access
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByOpenAccess(
		int openAccess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByOpenAccess_First(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByOpenAccess_First(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByOpenAccess_Last(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByOpenAccess_Last(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where openAccess = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByOpenAccess_PrevAndNext(
		long videoId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where openAccess = &#63; from the database.
	*
	* @param openAccess the open access
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOpenAccess(int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByOpenAccess(int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos where termId = &#63;.
	*
	* @param termId the term ID
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByTerm(
		long termId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where termId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param termId the term ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByTerm(
		long termId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where termId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param termId the term ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByTerm(
		long termId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByTerm_First(long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByTerm_First(long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByTerm_Last(long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByTerm_Last(long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where termId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByTerm_PrevAndNext(
		long videoId, long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where termId = &#63; from the database.
	*
	* @param termId the term ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTerm(long termId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where termId = &#63;.
	*
	* @param termId the term ID
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByTerm(long termId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByOpenAccessAndUploadedFile(
		int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where openAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param openAccess the open access
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where openAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param openAccess the open access
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByOpenAccessAndUploadedFile_First(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByOpenAccessAndUploadedFile_First(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByOpenAccessAndUploadedFile_Last(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByOpenAccessAndUploadedFile_Last(
		int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where openAccess = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param openAccess the open access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByOpenAccessAndUploadedFile_PrevAndNext(
		long videoId, int openAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where openAccess = &#63; from the database.
	*
	* @param openAccess the open access
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOpenAccessAndUploadedFile(int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where openAccess = &#63;.
	*
	* @param openAccess the open access
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByOpenAccessAndUploadedFile(int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos where licenseId = &#63;.
	*
	* @param licenseId the license ID
	* @return the matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByLicense(
		long licenseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos where licenseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param licenseId the license ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByLicense(
		long licenseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos where licenseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param licenseId the license ID
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findByLicense(
		long licenseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video in the ordered set where licenseId = &#63;.
	*
	* @param licenseId the license ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByLicense_First(long licenseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the first video in the ordered set where licenseId = &#63;.
	*
	* @param licenseId the license ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByLicense_First(long licenseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last video in the ordered set where licenseId = &#63;.
	*
	* @param licenseId the license ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByLicense_Last(long licenseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the last video in the ordered set where licenseId = &#63;.
	*
	* @param licenseId the license ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video, or <code>null</code> if a matching video could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByLicense_Last(long licenseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videos before and after the current video in the ordered set where licenseId = &#63;.
	*
	* @param videoId the primary key of the current video
	* @param licenseId the license ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video[] findByLicense_PrevAndNext(
		long videoId, long licenseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Removes all the videos where licenseId = &#63; from the database.
	*
	* @param licenseId the license ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLicense(long licenseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos where licenseId = &#63;.
	*
	* @param licenseId the license ID
	* @return the number of matching videos
	* @throws SystemException if a system exception occurred
	*/
	public int countByLicense(long licenseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the video in the entity cache if it is enabled.
	*
	* @param video the video
	*/
	public void cacheResult(de.uhh.l2g.plugins.model.Video video);

	/**
	* Caches the videos in the entity cache if it is enabled.
	*
	* @param videos the videos
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Video> videos);

	/**
	* Creates a new video with the primary key. Does not add the video to the database.
	*
	* @param videoId the primary key for the new video
	* @return the new video
	*/
	public de.uhh.l2g.plugins.model.Video create(long videoId);

	/**
	* Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoId the primary key of the video
	* @return the video that was removed
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video remove(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	public de.uhh.l2g.plugins.model.Video updateImpl(
		de.uhh.l2g.plugins.model.Video video)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideoException} if it could not be found.
	*
	* @param videoId the primary key of the video
	* @return the video
	* @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video findByPrimaryKey(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoException;

	/**
	* Returns the video with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoId the primary key of the video
	* @return the video, or <code>null</code> if a video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Video fetchByPrimaryKey(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videos.
	*
	* @return the videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @return the range of videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videos
	* @param end the upper bound of the range of videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of videos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Video> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the videos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videos.
	*
	* @return the number of videos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}