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

import de.uhh.l2g.plugins.NoSuchVideoException;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.model.impl.VideoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideoPersistence
 * @see VideoUtil
 * @generated
 */
public class VideoPersistenceImpl extends BasePersistenceImpl<Video>
	implements VideoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoUtil} to access the video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FACILITY = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFacility",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITY =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFacility",
			new String[] { Long.class.getName() },
			VideoModelImpl.FACILITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FACILITY = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFacility",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the videos where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @return the matching videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video> findByFacility(long facilityId)
		throws SystemException {
		return findByFacility(facilityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the videos where facilityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facilityId the facility ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video> findByFacility(long facilityId, int start, int end)
		throws SystemException {
		return findByFacility(facilityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videos where facilityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facilityId the facility ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video> findByFacility(long facilityId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Video> list = (List<Video>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((facilityId != video.getFacilityId())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_FACILITY_FACILITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facilityId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video>(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first video in the ordered set where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video findByFacility_First(long facilityId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoException, SystemException {
		Video video = fetchByFacility_First(facilityId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facilityId=");
		msg.append(facilityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video fetchByFacility_First(long facilityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Video> list = findByFacility(facilityId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video findByFacility_Last(long facilityId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoException, SystemException {
		Video video = fetchByFacility_Last(facilityId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facilityId=");
		msg.append(facilityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video fetchByFacility_Last(long facilityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFacility(facilityId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByFacility(facilityId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where facilityId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video[] findByFacility_PrevAndNext(long videoId, long facilityId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoException, SystemException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByFacility_PrevAndNext(session, video, facilityId,
					orderByComparator, true);

			array[1] = video;

			array[2] = getByFacility_PrevAndNext(session, video, facilityId,
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

	protected Video getByFacility_PrevAndNext(Session session, Video video,
		long facilityId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(facilityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where facilityId = &#63; from the database.
	 *
	 * @param facilityId the facility ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFacility(long facilityId) throws SystemException {
		for (Video video : findByFacility(facilityId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @return the number of matching videos
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

			query.append(_SQL_COUNT_VIDEO_WHERE);

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

	private static final String _FINDER_COLUMN_FACILITY_FACILITYID_2 = "video.facilityId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCER = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProducer",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCER =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProducer",
			new String[] { Long.class.getName() },
			VideoModelImpl.PRODUCERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCER = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProducer",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the videos where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the matching videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video> findByProducer(long producerId)
		throws SystemException {
		return findByProducer(producerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<Video> findByProducer(long producerId, int start, int end)
		throws SystemException {
		return findByProducer(producerId, start, end, null);
	}

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
	@Override
	public List<Video> findByProducer(long producerId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCER;
			finderArgs = new Object[] { producerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCER;
			finderArgs = new Object[] { producerId, start, end, orderByComparator };
		}

		List<Video> list = (List<Video>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((producerId != video.getProducerId())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCER_PRODUCERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video>(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video findByProducer_First(long producerId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoException, SystemException {
		Video video = fetchByProducer_First(producerId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video fetchByProducer_First(long producerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Video> list = findByProducer(producerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video findByProducer_Last(long producerId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoException, SystemException {
		Video video = fetchByProducer_Last(producerId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video fetchByProducer_Last(long producerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProducer(producerId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByProducer(producerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Video[] findByProducer_PrevAndNext(long videoId, long producerId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoException, SystemException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByProducer_PrevAndNext(session, video, producerId,
					orderByComparator, true);

			array[1] = video;

			array[2] = getByProducer_PrevAndNext(session, video, producerId,
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

	protected Video getByProducer_PrevAndNext(Session session, Video video,
		long producerId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_PRODUCER_PRODUCERID_2);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(producerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where producerId = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProducer(long producerId) throws SystemException {
		for (Video video : findByProducer(producerId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the number of matching videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProducer(long producerId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCER;

		Object[] finderArgs = new Object[] { producerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCER_PRODUCERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

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

	private static final String _FINDER_COLUMN_PRODUCER_PRODUCERID_2 = "video.producerId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseries",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseries",
			new String[] { Long.class.getName() },
			VideoModelImpl.LECTURESERIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIES = new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLectureseries",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the videos where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video> findByLectureseries(long lectureseriesId)
		throws SystemException {
		return findByLectureseries(lectureseriesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Video> findByLectureseries(long lectureseriesId, int start,
		int end) throws SystemException {
		return findByLectureseries(lectureseriesId, start, end, null);
	}

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
	@Override
	public List<Video> findByLectureseries(long lectureseriesId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<Video> list = (List<Video>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((lectureseriesId != video.getLectureseriesId())) {
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

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video>(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video findByLectureseries_First(long lectureseriesId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoException, SystemException {
		Video video = fetchByLectureseries_First(lectureseriesId,
				orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video fetchByLectureseries_First(long lectureseriesId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Video> list = findByLectureseries(lectureseriesId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video findByLectureseries_Last(long lectureseriesId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoException, SystemException {
		Video video = fetchByLectureseries_Last(lectureseriesId,
				orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video fetchByLectureseries_Last(long lectureseriesId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLectureseries(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByLectureseries(lectureseriesId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Video[] findByLectureseries_PrevAndNext(long videoId,
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchVideoException, SystemException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByLectureseries_PrevAndNext(session, video,
					lectureseriesId, orderByComparator, true);

			array[1] = video;

			array[2] = getByLectureseries_PrevAndNext(session, video,
					lectureseriesId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByLectureseries_PrevAndNext(Session session,
		Video video, long lectureseriesId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLectureseries(long lectureseriesId)
		throws SystemException {
		for (Video video : findByLectureseries(lectureseriesId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching videos
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

			query.append(_SQL_COUNT_VIDEO_WHERE);

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

	private static final String _FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2 = "video.lectureseriesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProducerAndLectureseries",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProducerAndLectureseries",
			new String[] { Long.class.getName(), Long.class.getName() },
			VideoModelImpl.PRODUCERID_COLUMN_BITMASK |
			VideoModelImpl.LECTURESERIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCERANDLECTURESERIES =
		new FinderPath(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProducerAndLectureseries",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video> findByProducerAndLectureseries(long producerId,
		long lectureseriesId) throws SystemException {
		return findByProducerAndLectureseries(producerId, lectureseriesId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Video> findByProducerAndLectureseries(long producerId,
		long lectureseriesId, int start, int end) throws SystemException {
		return findByProducerAndLectureseries(producerId, lectureseriesId,
			start, end, null);
	}

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
	@Override
	public List<Video> findByProducerAndLectureseries(long producerId,
		long lectureseriesId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES;
			finderArgs = new Object[] { producerId, lectureseriesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES;
			finderArgs = new Object[] {
					producerId, lectureseriesId,
					
					start, end, orderByComparator
				};
		}

		List<Video> list = (List<Video>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((producerId != video.getProducerId()) ||
						(lectureseriesId != video.getLectureseriesId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_PRODUCERID_2);

			query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video>(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws de.uhh.l2g.plugins.NoSuchVideoException if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video findByProducerAndLectureseries_First(long producerId,
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchVideoException, SystemException {
		Video video = fetchByProducerAndLectureseries_First(producerId,
				lectureseriesId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(", lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video fetchByProducerAndLectureseries_First(long producerId,
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Video> list = findByProducerAndLectureseries(producerId,
				lectureseriesId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Video findByProducerAndLectureseries_Last(long producerId,
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchVideoException, SystemException {
		Video video = fetchByProducerAndLectureseries_Last(producerId,
				lectureseriesId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(", lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video fetchByProducerAndLectureseries_Last(long producerId,
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByProducerAndLectureseries(producerId, lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByProducerAndLectureseries(producerId,
				lectureseriesId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Video[] findByProducerAndLectureseries_PrevAndNext(long videoId,
		long producerId, long lectureseriesId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoException, SystemException {
		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByProducerAndLectureseries_PrevAndNext(session,
					video, producerId, lectureseriesId, orderByComparator, true);

			array[1] = video;

			array[2] = getByProducerAndLectureseries_PrevAndNext(session,
					video, producerId, lectureseriesId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByProducerAndLectureseries_PrevAndNext(Session session,
		Video video, long producerId, long lectureseriesId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_PRODUCERID_2);

		query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_LECTURESERIESID_2);

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(producerId);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where producerId = &#63; and lectureseriesId = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProducerAndLectureseries(long producerId,
		long lectureseriesId) throws SystemException {
		for (Video video : findByProducerAndLectureseries(producerId,
				lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProducerAndLectureseries(long producerId,
		long lectureseriesId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCERANDLECTURESERIES;

		Object[] finderArgs = new Object[] { producerId, lectureseriesId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_PRODUCERID_2);

			query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_LECTURESERIESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

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

	private static final String _FINDER_COLUMN_PRODUCERANDLECTURESERIES_PRODUCERID_2 =
		"video.producerId = ? AND ";
	private static final String _FINDER_COLUMN_PRODUCERANDLECTURESERIES_LECTURESERIESID_2 =
		"video.lectureseriesId = ?";

	public VideoPersistenceImpl() {
		setModelClass(Video.class);
	}

	/**
	 * Caches the video in the entity cache if it is enabled.
	 *
	 * @param video the video
	 */
	@Override
	public void cacheResult(Video video) {
		EntityCacheUtil.putResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoImpl.class, video.getPrimaryKey(), video);

		video.resetOriginalValues();
	}

	/**
	 * Caches the videos in the entity cache if it is enabled.
	 *
	 * @param videos the videos
	 */
	@Override
	public void cacheResult(List<Video> videos) {
		for (Video video : videos) {
			if (EntityCacheUtil.getResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
						VideoImpl.class, video.getPrimaryKey()) == null) {
				cacheResult(video);
			}
			else {
				video.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all videos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video video) {
		EntityCacheUtil.removeResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoImpl.class, video.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video> videos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video video : videos) {
			EntityCacheUtil.removeResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
				VideoImpl.class, video.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param videoId the primary key for the new video
	 * @return the new video
	 */
	@Override
	public Video create(long videoId) {
		Video video = new VideoImpl();

		video.setNew(true);
		video.setPrimaryKey(videoId);

		return video;
	}

	/**
	 * Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoId the primary key of the video
	 * @return the video that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video remove(long videoId)
		throws NoSuchVideoException, SystemException {
		return remove((Serializable)videoId);
	}

	/**
	 * Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video
	 * @return the video that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video remove(Serializable primaryKey)
		throws NoSuchVideoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Video video = (Video)session.get(VideoImpl.class, primaryKey);

			if (video == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(video);
		}
		catch (NoSuchVideoException nsee) {
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
	protected Video removeImpl(Video video) throws SystemException {
		video = toUnwrappedModel(video);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video)) {
				video = (Video)session.get(VideoImpl.class,
						video.getPrimaryKeyObj());
			}

			if (video != null) {
				session.delete(video);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video != null) {
			clearCache(video);
		}

		return video;
	}

	@Override
	public Video updateImpl(de.uhh.l2g.plugins.model.Video video)
		throws SystemException {
		video = toUnwrappedModel(video);

		boolean isNew = video.isNew();

		VideoModelImpl videoModelImpl = (VideoModelImpl)video;

		Session session = null;

		try {
			session = openSession();

			if (video.isNew()) {
				session.save(video);

				video.setNew(false);
			}
			else {
				session.merge(video);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VideoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalFacilityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITY,
					args);

				args = new Object[] { videoModelImpl.getFacilityId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITY,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalProducerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCER,
					args);

				args = new Object[] { videoModelImpl.getProducerId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCER,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);

				args = new Object[] { videoModelImpl.getLectureseriesId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoModelImpl.getOriginalProducerId(),
						videoModelImpl.getOriginalLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCERANDLECTURESERIES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES,
					args);

				args = new Object[] {
						videoModelImpl.getProducerId(),
						videoModelImpl.getLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCERANDLECTURESERIES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERANDLECTURESERIES,
					args);
			}
		}

		EntityCacheUtil.putResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoImpl.class, video.getPrimaryKey(), video);

		return video;
	}

	protected Video toUnwrappedModel(Video video) {
		if (video instanceof VideoImpl) {
			return video;
		}

		VideoImpl videoImpl = new VideoImpl();

		videoImpl.setNew(video.isNew());
		videoImpl.setPrimaryKey(video.getPrimaryKey());

		videoImpl.setVideoId(video.getVideoId());
		videoImpl.setTitle(video.getTitle());
		videoImpl.setTags(video.getTags());
		videoImpl.setLectureseriesId(video.getLectureseriesId());
		videoImpl.setProducerId(video.getProducerId());
		videoImpl.setContainerFormat(video.getContainerFormat());
		videoImpl.setFilename(video.getFilename());
		videoImpl.setResolution(video.getResolution());
		videoImpl.setDuration(video.getDuration());
		videoImpl.setHostId(video.getHostId());
		videoImpl.setFileSize(video.getFileSize());
		videoImpl.setGenerationDate(video.getGenerationDate());
		videoImpl.setOpenAccess(video.getOpenAccess());
		videoImpl.setDownloadLink(video.getDownloadLink());
		videoImpl.setMetadataId(video.getMetadataId());
		videoImpl.setSurl(video.getSurl());
		videoImpl.setHits(video.getHits());
		videoImpl.setUploadDate(video.getUploadDate());
		videoImpl.setPermittedToSegment(video.getPermittedToSegment());
		videoImpl.setFacilityId(video.getFacilityId());
		videoImpl.setCitation2go(video.getCitation2go());

		return videoImpl;
	}

	/**
	 * Returns the video with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video
	 * @return the video
	 * @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideoException, SystemException {
		Video video = fetchByPrimaryKey(primaryKey);

		if (video == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return video;
	}

	/**
	 * Returns the video with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideoException} if it could not be found.
	 *
	 * @param videoId the primary key of the video
	 * @return the video
	 * @throws de.uhh.l2g.plugins.NoSuchVideoException if a video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video findByPrimaryKey(long videoId)
		throws NoSuchVideoException, SystemException {
		return findByPrimaryKey((Serializable)videoId);
	}

	/**
	 * Returns the video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video
	 * @return the video, or <code>null</code> if a video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Video video = (Video)EntityCacheUtil.getResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
				VideoImpl.class, primaryKey);

		if (video == _nullVideo) {
			return null;
		}

		if (video == null) {
			Session session = null;

			try {
				session = openSession();

				video = (Video)session.get(VideoImpl.class, primaryKey);

				if (video != null) {
					cacheResult(video);
				}
				else {
					EntityCacheUtil.putResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
						VideoImpl.class, primaryKey, _nullVideo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VideoModelImpl.ENTITY_CACHE_ENABLED,
					VideoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return video;
	}

	/**
	 * Returns the video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoId the primary key of the video
	 * @return the video, or <code>null</code> if a video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video fetchByPrimaryKey(long videoId) throws SystemException {
		return fetchByPrimaryKey((Serializable)videoId);
	}

	/**
	 * Returns all the videos.
	 *
	 * @return the videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Video> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Video> findAll(int start, int end,
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

		List<Video> list = (List<Video>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO;

				if (pagination) {
					sql = sql.concat(VideoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video>(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the videos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Video video : findAll()) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
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

				Query q = session.createQuery(_SQL_COUNT_VIDEO);

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
	 * Initializes the video persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Video")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Video>> listenersList = new ArrayList<ModelListener<Video>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Video>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEO = "SELECT video FROM Video video";
	private static final String _SQL_SELECT_VIDEO_WHERE = "SELECT video FROM Video video WHERE ";
	private static final String _SQL_COUNT_VIDEO = "SELECT COUNT(video) FROM Video video";
	private static final String _SQL_COUNT_VIDEO_WHERE = "SELECT COUNT(video) FROM Video video WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "video.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Video exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Video exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoPersistenceImpl.class);
	private static Video _nullVideo = new VideoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Video> toCacheModel() {
				return _nullVideoCacheModel;
			}
		};

	private static CacheModel<Video> _nullVideoCacheModel = new CacheModel<Video>() {
			@Override
			public Video toEntityModel() {
				return _nullVideo;
			}
		};
}