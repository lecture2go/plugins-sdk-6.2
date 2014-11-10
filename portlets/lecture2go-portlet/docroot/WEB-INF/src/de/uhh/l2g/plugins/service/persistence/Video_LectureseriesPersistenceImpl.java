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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException;
import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.model.impl.Video_LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.Video_LectureseriesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video_ lectureseries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_LectureseriesPersistence
 * @see Video_LectureseriesUtil
 * @generated
 */
public class Video_LectureseriesPersistenceImpl extends BasePersistenceImpl<Video_Lectureseries>
	implements Video_LectureseriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Video_LectureseriesUtil} to access the video_ lectureseries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Video_LectureseriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] { Long.class.getName() },
			Video_LectureseriesModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ lectureserieses where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Lectureseries> findByVideo(long videoId)
		throws SystemException {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video_Lectureseries> findByVideo(long videoId, int start,
		int end) throws SystemException {
		return findByVideo(videoId, start, end, null);
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
	@Override
	public List<Video_Lectureseries> findByVideo(long videoId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { videoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { videoId, start, end, orderByComparator };
		}

		List<Video_Lectureseries> list = (List<Video_Lectureseries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Lectureseries video_Lectureseries : list) {
				if ((videoId != video_Lectureseries.getVideoId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Lectureseries>(list);
				}
				else {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Video_Lectureseries findByVideo_First(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_LectureseriesException, SystemException {
		Video_Lectureseries video_Lectureseries = fetchByVideo_First(videoId,
				orderByComparator);

		if (video_Lectureseries != null) {
			return video_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the first video_ lectureseries in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Lectureseries fetchByVideo_First(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Video_Lectureseries> list = findByVideo(videoId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video_Lectureseries findByVideo_Last(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_LectureseriesException, SystemException {
		Video_Lectureseries video_Lectureseries = fetchByVideo_Last(videoId,
				orderByComparator);

		if (video_Lectureseries != null) {
			return video_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the last video_ lectureseries in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Lectureseries fetchByVideo_Last(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Video_Lectureseries> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video_Lectureseries[] findByVideo_PrevAndNext(
		long videoLectureseriesId, long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_LectureseriesException, SystemException {
		Video_Lectureseries video_Lectureseries = findByPrimaryKey(videoLectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Video_Lectureseries[] array = new Video_LectureseriesImpl[3];

			array[0] = getByVideo_PrevAndNext(session, video_Lectureseries,
					videoId, orderByComparator, true);

			array[1] = video_Lectureseries;

			array[2] = getByVideo_PrevAndNext(session, video_Lectureseries,
					videoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Lectureseries getByVideo_PrevAndNext(Session session,
		Video_Lectureseries video_Lectureseries, long videoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ lectureserieses where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideo(long videoId) throws SystemException {
		for (Video_Lectureseries video_Lectureseries : findByVideo(videoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Lectureseries);
		}
	}

	/**
	 * Returns the number of video_ lectureserieses where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVideo(long videoId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEO;

		Object[] finderArgs = new Object[] { videoId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "video_Lectureseries.videoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseries",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseries",
			new String[] { Long.class.getName() },
			Video_LectureseriesModelImpl.LECTURESERIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIES = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLectureseries",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching video_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Lectureseries> findByLectureseries(long lectureseriesId)
		throws SystemException {
		return findByLectureseries(lectureseriesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video_Lectureseries> findByLectureseries(long lectureseriesId,
		int start, int end) throws SystemException {
		return findByLectureseries(lectureseriesId, start, end, null);
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
	@Override
	public List<Video_Lectureseries> findByLectureseries(long lectureseriesId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES;
			finderArgs = new Object[] { lectureseriesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIES;
			finderArgs = new Object[] {
					lectureseriesId,
					
					start, end, orderByComparator
				};
		}

		List<Video_Lectureseries> list = (List<Video_Lectureseries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Lectureseries video_Lectureseries : list) {
				if ((lectureseriesId != video_Lectureseries.getLectureseriesId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Lectureseries>(list);
				}
				else {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Video_Lectureseries findByLectureseries_First(long lectureseriesId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_LectureseriesException, SystemException {
		Video_Lectureseries video_Lectureseries = fetchByLectureseries_First(lectureseriesId,
				orderByComparator);

		if (video_Lectureseries != null) {
			return video_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the first video_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Lectureseries fetchByLectureseries_First(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Video_Lectureseries> list = findByLectureseries(lectureseriesId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video_Lectureseries findByLectureseries_Last(long lectureseriesId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_LectureseriesException, SystemException {
		Video_Lectureseries video_Lectureseries = fetchByLectureseries_Last(lectureseriesId,
				orderByComparator);

		if (video_Lectureseries != null) {
			return video_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the last video_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Lectureseries fetchByLectureseries_Last(long lectureseriesId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLectureseries(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Video_Lectureseries> list = findByLectureseries(lectureseriesId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video_Lectureseries[] findByLectureseries_PrevAndNext(
		long videoLectureseriesId, long lectureseriesId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_LectureseriesException, SystemException {
		Video_Lectureseries video_Lectureseries = findByPrimaryKey(videoLectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Video_Lectureseries[] array = new Video_LectureseriesImpl[3];

			array[0] = getByLectureseries_PrevAndNext(session,
					video_Lectureseries, lectureseriesId, orderByComparator,
					true);

			array[1] = video_Lectureseries;

			array[2] = getByLectureseries_PrevAndNext(session,
					video_Lectureseries, lectureseriesId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Lectureseries getByLectureseries_PrevAndNext(
		Session session, Video_Lectureseries video_Lectureseries,
		long lectureseriesId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ lectureserieses where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLectureseries(long lectureseriesId)
		throws SystemException {
		for (Video_Lectureseries video_Lectureseries : findByLectureseries(
				lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Lectureseries);
		}
	}

	/**
	 * Returns the number of video_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching video_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLectureseries(long lectureseriesId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LECTURESERIES;

		Object[] finderArgs = new Object[] { lectureseriesId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2 = "video_Lectureseries.lectureseriesId = ?";

	public Video_LectureseriesPersistenceImpl() {
		setModelClass(Video_Lectureseries.class);
	}

	/**
	 * Caches the video_ lectureseries in the entity cache if it is enabled.
	 *
	 * @param video_Lectureseries the video_ lectureseries
	 */
	@Override
	public void cacheResult(Video_Lectureseries video_Lectureseries) {
		EntityCacheUtil.putResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesImpl.class, video_Lectureseries.getPrimaryKey(),
			video_Lectureseries);

		video_Lectureseries.resetOriginalValues();
	}

	/**
	 * Caches the video_ lectureserieses in the entity cache if it is enabled.
	 *
	 * @param video_Lectureserieses the video_ lectureserieses
	 */
	@Override
	public void cacheResult(List<Video_Lectureseries> video_Lectureserieses) {
		for (Video_Lectureseries video_Lectureseries : video_Lectureserieses) {
			if (EntityCacheUtil.getResult(
						Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
						Video_LectureseriesImpl.class,
						video_Lectureseries.getPrimaryKey()) == null) {
				cacheResult(video_Lectureseries);
			}
			else {
				video_Lectureseries.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ lectureserieses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Video_LectureseriesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Video_LectureseriesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ lectureseries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_Lectureseries video_Lectureseries) {
		EntityCacheUtil.removeResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesImpl.class, video_Lectureseries.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_Lectureseries> video_Lectureserieses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_Lectureseries video_Lectureseries : video_Lectureserieses) {
			EntityCacheUtil.removeResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
				Video_LectureseriesImpl.class,
				video_Lectureseries.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video_ lectureseries with the primary key. Does not add the video_ lectureseries to the database.
	 *
	 * @param videoLectureseriesId the primary key for the new video_ lectureseries
	 * @return the new video_ lectureseries
	 */
	@Override
	public Video_Lectureseries create(long videoLectureseriesId) {
		Video_Lectureseries video_Lectureseries = new Video_LectureseriesImpl();

		video_Lectureseries.setNew(true);
		video_Lectureseries.setPrimaryKey(videoLectureseriesId);

		return video_Lectureseries;
	}

	/**
	 * Removes the video_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoLectureseriesId the primary key of the video_ lectureseries
	 * @return the video_ lectureseries that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Lectureseries remove(long videoLectureseriesId)
		throws NoSuchVideo_LectureseriesException, SystemException {
		return remove((Serializable)videoLectureseriesId);
	}

	/**
	 * Removes the video_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ lectureseries
	 * @return the video_ lectureseries that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Lectureseries remove(Serializable primaryKey)
		throws NoSuchVideo_LectureseriesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Video_Lectureseries video_Lectureseries = (Video_Lectureseries)session.get(Video_LectureseriesImpl.class,
					primaryKey);

			if (video_Lectureseries == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_LectureseriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(video_Lectureseries);
		}
		catch (NoSuchVideo_LectureseriesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Video_Lectureseries removeImpl(
		Video_Lectureseries video_Lectureseries) throws SystemException {
		video_Lectureseries = toUnwrappedModel(video_Lectureseries);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_Lectureseries)) {
				video_Lectureseries = (Video_Lectureseries)session.get(Video_LectureseriesImpl.class,
						video_Lectureseries.getPrimaryKeyObj());
			}

			if (video_Lectureseries != null) {
				session.delete(video_Lectureseries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video_Lectureseries != null) {
			clearCache(video_Lectureseries);
		}

		return video_Lectureseries;
	}

	@Override
	public Video_Lectureseries updateImpl(
		de.uhh.l2g.plugins.model.Video_Lectureseries video_Lectureseries)
		throws SystemException {
		video_Lectureseries = toUnwrappedModel(video_Lectureseries);

		boolean isNew = video_Lectureseries.isNew();

		Video_LectureseriesModelImpl video_LectureseriesModelImpl = (Video_LectureseriesModelImpl)video_Lectureseries;

		Session session = null;

		try {
			session = openSession();

			if (video_Lectureseries.isNew()) {
				session.save(video_Lectureseries);

				video_Lectureseries.setNew(false);
			}
			else {
				session.merge(video_Lectureseries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Video_LectureseriesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((video_LectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_LectureseriesModelImpl.getOriginalVideoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { video_LectureseriesModelImpl.getVideoId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}

			if ((video_LectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_LectureseriesModelImpl.getOriginalLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);

				args = new Object[] {
						video_LectureseriesModelImpl.getLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);
			}
		}

		EntityCacheUtil.putResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesImpl.class, video_Lectureseries.getPrimaryKey(),
			video_Lectureseries);

		return video_Lectureseries;
	}

	protected Video_Lectureseries toUnwrappedModel(
		Video_Lectureseries video_Lectureseries) {
		if (video_Lectureseries instanceof Video_LectureseriesImpl) {
			return video_Lectureseries;
		}

		Video_LectureseriesImpl video_LectureseriesImpl = new Video_LectureseriesImpl();

		video_LectureseriesImpl.setNew(video_Lectureseries.isNew());
		video_LectureseriesImpl.setPrimaryKey(video_Lectureseries.getPrimaryKey());

		video_LectureseriesImpl.setVideoLectureseriesId(video_Lectureseries.getVideoLectureseriesId());
		video_LectureseriesImpl.setVideoId(video_Lectureseries.getVideoId());
		video_LectureseriesImpl.setLectureseriesId(video_Lectureseries.getLectureseriesId());

		return video_LectureseriesImpl;
	}

	/**
	 * Returns the video_ lectureseries with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ lectureseries
	 * @return the video_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Lectureseries findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_LectureseriesException, SystemException {
		Video_Lectureseries video_Lectureseries = fetchByPrimaryKey(primaryKey);

		if (video_Lectureseries == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_LectureseriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return video_Lectureseries;
	}

	/**
	 * Returns the video_ lectureseries with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException} if it could not be found.
	 *
	 * @param videoLectureseriesId the primary key of the video_ lectureseries
	 * @return the video_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Lectureseries findByPrimaryKey(long videoLectureseriesId)
		throws NoSuchVideo_LectureseriesException, SystemException {
		return findByPrimaryKey((Serializable)videoLectureseriesId);
	}

	/**
	 * Returns the video_ lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ lectureseries
	 * @return the video_ lectureseries, or <code>null</code> if a video_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Lectureseries fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Video_Lectureseries video_Lectureseries = (Video_Lectureseries)EntityCacheUtil.getResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
				Video_LectureseriesImpl.class, primaryKey);

		if (video_Lectureseries == _nullVideo_Lectureseries) {
			return null;
		}

		if (video_Lectureseries == null) {
			Session session = null;

			try {
				session = openSession();

				video_Lectureseries = (Video_Lectureseries)session.get(Video_LectureseriesImpl.class,
						primaryKey);

				if (video_Lectureseries != null) {
					cacheResult(video_Lectureseries);
				}
				else {
					EntityCacheUtil.putResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
						Video_LectureseriesImpl.class, primaryKey,
						_nullVideo_Lectureseries);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
					Video_LectureseriesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return video_Lectureseries;
	}

	/**
	 * Returns the video_ lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoLectureseriesId the primary key of the video_ lectureseries
	 * @return the video_ lectureseries, or <code>null</code> if a video_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Lectureseries fetchByPrimaryKey(long videoLectureseriesId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)videoLectureseriesId);
	}

	/**
	 * Returns all the video_ lectureserieses.
	 *
	 * @return the video_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Lectureseries> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video_Lectureseries> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Video_Lectureseries> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Video_Lectureseries> list = (List<Video_Lectureseries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEO_LECTURESERIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_LECTURESERIES;

				if (pagination) {
					sql = sql.concat(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Lectureseries>(list);
				}
				else {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the video_ lectureserieses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Video_Lectureseries video_Lectureseries : findAll()) {
			remove(video_Lectureseries);
		}
	}

	/**
	 * Returns the number of video_ lectureserieses.
	 *
	 * @return the number of video_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEO_LECTURESERIES);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the video_ lectureseries persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Video_Lectureseries")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Video_Lectureseries>> listenersList = new ArrayList<ModelListener<Video_Lectureseries>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Video_Lectureseries>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(Video_LectureseriesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEO_LECTURESERIES = "SELECT video_Lectureseries FROM Video_Lectureseries video_Lectureseries";
	private static final String _SQL_SELECT_VIDEO_LECTURESERIES_WHERE = "SELECT video_Lectureseries FROM Video_Lectureseries video_Lectureseries WHERE ";
	private static final String _SQL_COUNT_VIDEO_LECTURESERIES = "SELECT COUNT(video_Lectureseries) FROM Video_Lectureseries video_Lectureseries";
	private static final String _SQL_COUNT_VIDEO_LECTURESERIES_WHERE = "SELECT COUNT(video_Lectureseries) FROM Video_Lectureseries video_Lectureseries WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "video_Lectureseries.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Video_Lectureseries exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Video_Lectureseries exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Video_LectureseriesPersistenceImpl.class);
	private static Video_Lectureseries _nullVideo_Lectureseries = new Video_LectureseriesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Video_Lectureseries> toCacheModel() {
				return _nullVideo_LectureseriesCacheModel;
			}
		};

	private static CacheModel<Video_Lectureseries> _nullVideo_LectureseriesCacheModel =
		new CacheModel<Video_Lectureseries>() {
			@Override
			public Video_Lectureseries toEntityModel() {
				return _nullVideo_Lectureseries;
			}
		};
}