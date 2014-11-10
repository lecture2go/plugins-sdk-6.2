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

import de.uhh.l2g.plugins.NoSuchVideo_FacilityException;
import de.uhh.l2g.plugins.model.Video_Facility;
import de.uhh.l2g.plugins.model.impl.Video_FacilityImpl;
import de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video_ facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_FacilityPersistence
 * @see Video_FacilityUtil
 * @generated
 */
public class Video_FacilityPersistenceImpl extends BasePersistenceImpl<Video_Facility>
	implements Video_FacilityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Video_FacilityUtil} to access the video_ facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Video_FacilityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Video_FacilityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Video_FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Video_FacilityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Video_FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] { Long.class.getName() },
			Video_FacilityModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ facilities where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Facility> findByVideo(long videoId)
		throws SystemException {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ facilities where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ facilities
	 * @param end the upper bound of the range of video_ facilities (not inclusive)
	 * @return the range of matching video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Facility> findByVideo(long videoId, int start, int end)
		throws SystemException {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ facilities where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ facilities
	 * @param end the upper bound of the range of video_ facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Facility> findByVideo(long videoId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Video_Facility> list = (List<Video_Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Facility video_Facility : list) {
				if ((videoId != video_Facility.getVideoId())) {
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

			query.append(_SQL_SELECT_VIDEO_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_FacilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Video_Facility>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Facility>(list);
				}
				else {
					list = (List<Video_Facility>)QueryUtil.list(q,
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
	 * Returns the first video_ facility in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a matching video_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility findByVideo_First(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_FacilityException, SystemException {
		Video_Facility video_Facility = fetchByVideo_First(videoId,
				orderByComparator);

		if (video_Facility != null) {
			return video_Facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_FacilityException(msg.toString());
	}

	/**
	 * Returns the first video_ facility in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ facility, or <code>null</code> if a matching video_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility fetchByVideo_First(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Video_Facility> list = findByVideo(videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ facility in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a matching video_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility findByVideo_Last(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_FacilityException, SystemException {
		Video_Facility video_Facility = fetchByVideo_Last(videoId,
				orderByComparator);

		if (video_Facility != null) {
			return video_Facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_FacilityException(msg.toString());
	}

	/**
	 * Returns the last video_ facility in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ facility, or <code>null</code> if a matching video_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility fetchByVideo_Last(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Video_Facility> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ facilities before and after the current video_ facility in the ordered set where videoId = &#63;.
	 *
	 * @param videoFacilityId the primary key of the current video_ facility
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility[] findByVideo_PrevAndNext(long videoFacilityId,
		long videoId, OrderByComparator orderByComparator)
		throws NoSuchVideo_FacilityException, SystemException {
		Video_Facility video_Facility = findByPrimaryKey(videoFacilityId);

		Session session = null;

		try {
			session = openSession();

			Video_Facility[] array = new Video_FacilityImpl[3];

			array[0] = getByVideo_PrevAndNext(session, video_Facility, videoId,
					orderByComparator, true);

			array[1] = video_Facility;

			array[2] = getByVideo_PrevAndNext(session, video_Facility, videoId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Facility getByVideo_PrevAndNext(Session session,
		Video_Facility video_Facility, long videoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_FACILITY_WHERE);

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
			query.append(Video_FacilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Facility);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Facility> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ facilities where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideo(long videoId) throws SystemException {
		for (Video_Facility video_Facility : findByVideo(videoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Facility);
		}
	}

	/**
	 * Returns the number of video_ facilities where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ facilities
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

			query.append(_SQL_COUNT_VIDEO_FACILITY_WHERE);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "video_Facility.videoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FACILITY = new FinderPath(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Video_FacilityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFacility",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITY =
		new FinderPath(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Video_FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFacility",
			new String[] { Long.class.getName() },
			Video_FacilityModelImpl.FACILITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FACILITY = new FinderPath(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFacility",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ facilities where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @return the matching video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Facility> findByFacility(long facilityId)
		throws SystemException {
		return findByFacility(facilityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the video_ facilities where facilityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facilityId the facility ID
	 * @param start the lower bound of the range of video_ facilities
	 * @param end the upper bound of the range of video_ facilities (not inclusive)
	 * @return the range of matching video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Facility> findByFacility(long facilityId, int start,
		int end) throws SystemException {
		return findByFacility(facilityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ facilities where facilityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facilityId the facility ID
	 * @param start the lower bound of the range of video_ facilities
	 * @param end the upper bound of the range of video_ facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Facility> findByFacility(long facilityId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITY;
			finderArgs = new Object[] { facilityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FACILITY;
			finderArgs = new Object[] { facilityId, start, end, orderByComparator };
		}

		List<Video_Facility> list = (List<Video_Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Facility video_Facility : list) {
				if ((facilityId != video_Facility.getFacilityId())) {
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

			query.append(_SQL_SELECT_VIDEO_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_FACILITY_FACILITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_FacilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facilityId);

				if (!pagination) {
					list = (List<Video_Facility>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Facility>(list);
				}
				else {
					list = (List<Video_Facility>)QueryUtil.list(q,
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
	 * Returns the first video_ facility in the ordered set where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a matching video_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility findByFacility_First(long facilityId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_FacilityException, SystemException {
		Video_Facility video_Facility = fetchByFacility_First(facilityId,
				orderByComparator);

		if (video_Facility != null) {
			return video_Facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facilityId=");
		msg.append(facilityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_FacilityException(msg.toString());
	}

	/**
	 * Returns the first video_ facility in the ordered set where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ facility, or <code>null</code> if a matching video_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility fetchByFacility_First(long facilityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Video_Facility> list = findByFacility(facilityId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ facility in the ordered set where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a matching video_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility findByFacility_Last(long facilityId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_FacilityException, SystemException {
		Video_Facility video_Facility = fetchByFacility_Last(facilityId,
				orderByComparator);

		if (video_Facility != null) {
			return video_Facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facilityId=");
		msg.append(facilityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_FacilityException(msg.toString());
	}

	/**
	 * Returns the last video_ facility in the ordered set where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ facility, or <code>null</code> if a matching video_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility fetchByFacility_Last(long facilityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFacility(facilityId);

		if (count == 0) {
			return null;
		}

		List<Video_Facility> list = findByFacility(facilityId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ facilities before and after the current video_ facility in the ordered set where facilityId = &#63;.
	 *
	 * @param videoFacilityId the primary key of the current video_ facility
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility[] findByFacility_PrevAndNext(long videoFacilityId,
		long facilityId, OrderByComparator orderByComparator)
		throws NoSuchVideo_FacilityException, SystemException {
		Video_Facility video_Facility = findByPrimaryKey(videoFacilityId);

		Session session = null;

		try {
			session = openSession();

			Video_Facility[] array = new Video_FacilityImpl[3];

			array[0] = getByFacility_PrevAndNext(session, video_Facility,
					facilityId, orderByComparator, true);

			array[1] = video_Facility;

			array[2] = getByFacility_PrevAndNext(session, video_Facility,
					facilityId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Facility getByFacility_PrevAndNext(Session session,
		Video_Facility video_Facility, long facilityId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_FACILITY_WHERE);

		query.append(_FINDER_COLUMN_FACILITY_FACILITYID_2);

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
			query.append(Video_FacilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(facilityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Facility);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Facility> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ facilities where facilityId = &#63; from the database.
	 *
	 * @param facilityId the facility ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFacility(long facilityId) throws SystemException {
		for (Video_Facility video_Facility : findByFacility(facilityId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Facility);
		}
	}

	/**
	 * Returns the number of video_ facilities where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @return the number of matching video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFacility(long facilityId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FACILITY;

		Object[] finderArgs = new Object[] { facilityId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_FACILITY_FACILITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facilityId);

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

	private static final String _FINDER_COLUMN_FACILITY_FACILITYID_2 = "video_Facility.facilityId = ?";

	public Video_FacilityPersistenceImpl() {
		setModelClass(Video_Facility.class);
	}

	/**
	 * Caches the video_ facility in the entity cache if it is enabled.
	 *
	 * @param video_Facility the video_ facility
	 */
	@Override
	public void cacheResult(Video_Facility video_Facility) {
		EntityCacheUtil.putResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityImpl.class, video_Facility.getPrimaryKey(),
			video_Facility);

		video_Facility.resetOriginalValues();
	}

	/**
	 * Caches the video_ facilities in the entity cache if it is enabled.
	 *
	 * @param video_Facilities the video_ facilities
	 */
	@Override
	public void cacheResult(List<Video_Facility> video_Facilities) {
		for (Video_Facility video_Facility : video_Facilities) {
			if (EntityCacheUtil.getResult(
						Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
						Video_FacilityImpl.class, video_Facility.getPrimaryKey()) == null) {
				cacheResult(video_Facility);
			}
			else {
				video_Facility.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ facilities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Video_FacilityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Video_FacilityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ facility.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_Facility video_Facility) {
		EntityCacheUtil.removeResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityImpl.class, video_Facility.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_Facility> video_Facilities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_Facility video_Facility : video_Facilities) {
			EntityCacheUtil.removeResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
				Video_FacilityImpl.class, video_Facility.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video_ facility with the primary key. Does not add the video_ facility to the database.
	 *
	 * @param videoFacilityId the primary key for the new video_ facility
	 * @return the new video_ facility
	 */
	@Override
	public Video_Facility create(long videoFacilityId) {
		Video_Facility video_Facility = new Video_FacilityImpl();

		video_Facility.setNew(true);
		video_Facility.setPrimaryKey(videoFacilityId);

		return video_Facility;
	}

	/**
	 * Removes the video_ facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoFacilityId the primary key of the video_ facility
	 * @return the video_ facility that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility remove(long videoFacilityId)
		throws NoSuchVideo_FacilityException, SystemException {
		return remove((Serializable)videoFacilityId);
	}

	/**
	 * Removes the video_ facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ facility
	 * @return the video_ facility that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility remove(Serializable primaryKey)
		throws NoSuchVideo_FacilityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Video_Facility video_Facility = (Video_Facility)session.get(Video_FacilityImpl.class,
					primaryKey);

			if (video_Facility == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_FacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(video_Facility);
		}
		catch (NoSuchVideo_FacilityException nsee) {
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
	protected Video_Facility removeImpl(Video_Facility video_Facility)
		throws SystemException {
		video_Facility = toUnwrappedModel(video_Facility);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_Facility)) {
				video_Facility = (Video_Facility)session.get(Video_FacilityImpl.class,
						video_Facility.getPrimaryKeyObj());
			}

			if (video_Facility != null) {
				session.delete(video_Facility);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video_Facility != null) {
			clearCache(video_Facility);
		}

		return video_Facility;
	}

	@Override
	public Video_Facility updateImpl(
		de.uhh.l2g.plugins.model.Video_Facility video_Facility)
		throws SystemException {
		video_Facility = toUnwrappedModel(video_Facility);

		boolean isNew = video_Facility.isNew();

		Video_FacilityModelImpl video_FacilityModelImpl = (Video_FacilityModelImpl)video_Facility;

		Session session = null;

		try {
			session = openSession();

			if (video_Facility.isNew()) {
				session.save(video_Facility);

				video_Facility.setNew(false);
			}
			else {
				session.merge(video_Facility);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Video_FacilityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((video_FacilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_FacilityModelImpl.getOriginalVideoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { video_FacilityModelImpl.getVideoId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}

			if ((video_FacilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_FacilityModelImpl.getOriginalFacilityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITY,
					args);

				args = new Object[] { video_FacilityModelImpl.getFacilityId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITY,
					args);
			}
		}

		EntityCacheUtil.putResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityImpl.class, video_Facility.getPrimaryKey(),
			video_Facility);

		return video_Facility;
	}

	protected Video_Facility toUnwrappedModel(Video_Facility video_Facility) {
		if (video_Facility instanceof Video_FacilityImpl) {
			return video_Facility;
		}

		Video_FacilityImpl video_FacilityImpl = new Video_FacilityImpl();

		video_FacilityImpl.setNew(video_Facility.isNew());
		video_FacilityImpl.setPrimaryKey(video_Facility.getPrimaryKey());

		video_FacilityImpl.setVideoFacilityId(video_Facility.getVideoFacilityId());
		video_FacilityImpl.setVideoId(video_Facility.getVideoId());
		video_FacilityImpl.setFacilityId(video_Facility.getFacilityId());

		return video_FacilityImpl;
	}

	/**
	 * Returns the video_ facility with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ facility
	 * @return the video_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_FacilityException, SystemException {
		Video_Facility video_Facility = fetchByPrimaryKey(primaryKey);

		if (video_Facility == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_FacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return video_Facility;
	}

	/**
	 * Returns the video_ facility with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideo_FacilityException} if it could not be found.
	 *
	 * @param videoFacilityId the primary key of the video_ facility
	 * @return the video_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility findByPrimaryKey(long videoFacilityId)
		throws NoSuchVideo_FacilityException, SystemException {
		return findByPrimaryKey((Serializable)videoFacilityId);
	}

	/**
	 * Returns the video_ facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ facility
	 * @return the video_ facility, or <code>null</code> if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Video_Facility video_Facility = (Video_Facility)EntityCacheUtil.getResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
				Video_FacilityImpl.class, primaryKey);

		if (video_Facility == _nullVideo_Facility) {
			return null;
		}

		if (video_Facility == null) {
			Session session = null;

			try {
				session = openSession();

				video_Facility = (Video_Facility)session.get(Video_FacilityImpl.class,
						primaryKey);

				if (video_Facility != null) {
					cacheResult(video_Facility);
				}
				else {
					EntityCacheUtil.putResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
						Video_FacilityImpl.class, primaryKey,
						_nullVideo_Facility);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
					Video_FacilityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return video_Facility;
	}

	/**
	 * Returns the video_ facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoFacilityId the primary key of the video_ facility
	 * @return the video_ facility, or <code>null</code> if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility fetchByPrimaryKey(long videoFacilityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)videoFacilityId);
	}

	/**
	 * Returns all the video_ facilities.
	 *
	 * @return the video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Facility> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ facilities
	 * @param end the upper bound of the range of video_ facilities (not inclusive)
	 * @return the range of video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Facility> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ facilities
	 * @param end the upper bound of the range of video_ facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Facility> findAll(int start, int end,
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

		List<Video_Facility> list = (List<Video_Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEO_FACILITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_FACILITY;

				if (pagination) {
					sql = sql.concat(Video_FacilityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video_Facility>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Facility>(list);
				}
				else {
					list = (List<Video_Facility>)QueryUtil.list(q,
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
	 * Removes all the video_ facilities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Video_Facility video_Facility : findAll()) {
			remove(video_Facility);
		}
	}

	/**
	 * Returns the number of video_ facilities.
	 *
	 * @return the number of video_ facilities
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

				Query q = session.createQuery(_SQL_COUNT_VIDEO_FACILITY);

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
	 * Initializes the video_ facility persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Video_Facility")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Video_Facility>> listenersList = new ArrayList<ModelListener<Video_Facility>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Video_Facility>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Video_FacilityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEO_FACILITY = "SELECT video_Facility FROM Video_Facility video_Facility";
	private static final String _SQL_SELECT_VIDEO_FACILITY_WHERE = "SELECT video_Facility FROM Video_Facility video_Facility WHERE ";
	private static final String _SQL_COUNT_VIDEO_FACILITY = "SELECT COUNT(video_Facility) FROM Video_Facility video_Facility";
	private static final String _SQL_COUNT_VIDEO_FACILITY_WHERE = "SELECT COUNT(video_Facility) FROM Video_Facility video_Facility WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "video_Facility.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Video_Facility exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Video_Facility exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Video_FacilityPersistenceImpl.class);
	private static Video_Facility _nullVideo_Facility = new Video_FacilityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Video_Facility> toCacheModel() {
				return _nullVideo_FacilityCacheModel;
			}
		};

	private static CacheModel<Video_Facility> _nullVideo_FacilityCacheModel = new CacheModel<Video_Facility>() {
			@Override
			public Video_Facility toEntityModel() {
				return _nullVideo_Facility;
			}
		};
}