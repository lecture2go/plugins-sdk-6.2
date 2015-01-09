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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchSegmentException;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.impl.SegmentImpl;
import de.uhh.l2g.plugins.model.impl.SegmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see SegmentPersistence
 * @see SegmentUtil
 * @generated
 */
public class SegmentPersistenceImpl extends BasePersistenceImpl<Segment>
	implements SegmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SegmentUtil} to access the segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SegmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] { Long.class.getName() },
			SegmentModelImpl.VIDEOID_COLUMN_BITMASK |
			SegmentModelImpl.START_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the segments where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment> findByVideo(long videoId) throws SystemException {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment> findByVideo(long videoId, int start, int end)
		throws SystemException {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment> findByVideo(long videoId, int start, int end,
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

		List<Segment> list = (List<Segment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Segment segment : list) {
				if ((videoId != segment.getVideoId())) {
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

			query.append(_SQL_SELECT_SEGMENT_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Segment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Segment>(list);
				}
				else {
					list = (List<Segment>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first segment in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a matching segment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment findByVideo_First(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchSegmentException, SystemException {
		Segment segment = fetchByVideo_First(videoId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSegmentException(msg.toString());
	}

	/**
	 * Returns the first segment in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment fetchByVideo_First(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Segment> list = findByVideo(videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last segment in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a matching segment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment findByVideo_Last(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchSegmentException, SystemException {
		Segment segment = fetchByVideo_Last(videoId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSegmentException(msg.toString());
	}

	/**
	 * Returns the last segment in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment fetchByVideo_Last(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Segment> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the segments before and after the current segment in the ordered set where videoId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment[] findByVideo_PrevAndNext(long segmentId, long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchSegmentException, SystemException {
		Segment segment = findByPrimaryKey(segmentId);

		Session session = null;

		try {
			session = openSession();

			Segment[] array = new SegmentImpl[3];

			array[0] = getByVideo_PrevAndNext(session, segment, videoId,
					orderByComparator, true);

			array[1] = segment;

			array[2] = getByVideo_PrevAndNext(session, segment, videoId,
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

	protected Segment getByVideo_PrevAndNext(Session session, Segment segment,
		long videoId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEGMENT_WHERE);

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
			query.append(SegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(segment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Segment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segments where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideo(long videoId) throws SystemException {
		for (Segment segment : findByVideo(videoId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(segment);
		}
	}

	/**
	 * Returns the number of segments where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching segments
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

			query.append(_SQL_COUNT_SEGMENT_WHERE);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "segment.videoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			SegmentModelImpl.USERID_COLUMN_BITMASK |
			SegmentModelImpl.START_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the segments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment> findByUser(long userId) throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment> findByUser(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Segment> list = (List<Segment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Segment segment : list) {
				if ((userId != segment.getUserId())) {
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

			query.append(_SQL_SELECT_SEGMENT_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Segment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Segment>(list);
				}
				else {
					list = (List<Segment>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first segment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a matching segment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSegmentException, SystemException {
		Segment segment = fetchByUser_First(userId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSegmentException(msg.toString());
	}

	/**
	 * Returns the first segment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Segment> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last segment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a matching segment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSegmentException, SystemException {
		Segment segment = fetchByUser_Last(userId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSegmentException(msg.toString());
	}

	/**
	 * Returns the last segment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<Segment> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the segments before and after the current segment in the ordered set where userId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment[] findByUser_PrevAndNext(long segmentId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSegmentException, SystemException {
		Segment segment = findByPrimaryKey(segmentId);

		Session session = null;

		try {
			session = openSession();

			Segment[] array = new SegmentImpl[3];

			array[0] = getByUser_PrevAndNext(session, segment, userId,
					orderByComparator, true);

			array[1] = segment;

			array[2] = getByUser_PrevAndNext(session, segment, userId,
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

	protected Segment getByUser_PrevAndNext(Session session, Segment segment,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEGMENT_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

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
			query.append(SegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(segment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Segment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segments where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (Segment segment : findByUser(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(segment);
		}
	}

	/**
	 * Returns the number of segments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUser(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEGMENT_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "segment.userId = ?";

	public SegmentPersistenceImpl() {
		setModelClass(Segment.class);
	}

	/**
	 * Caches the segment in the entity cache if it is enabled.
	 *
	 * @param segment the segment
	 */
	@Override
	public void cacheResult(Segment segment) {
		EntityCacheUtil.putResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentImpl.class, segment.getPrimaryKey(), segment);

		segment.resetOriginalValues();
	}

	/**
	 * Caches the segments in the entity cache if it is enabled.
	 *
	 * @param segments the segments
	 */
	@Override
	public void cacheResult(List<Segment> segments) {
		for (Segment segment : segments) {
			if (EntityCacheUtil.getResult(
						SegmentModelImpl.ENTITY_CACHE_ENABLED,
						SegmentImpl.class, segment.getPrimaryKey()) == null) {
				cacheResult(segment);
			}
			else {
				segment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all segments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SegmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SegmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the segment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Segment segment) {
		EntityCacheUtil.removeResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentImpl.class, segment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Segment> segments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Segment segment : segments) {
			EntityCacheUtil.removeResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
				SegmentImpl.class, segment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new segment with the primary key. Does not add the segment to the database.
	 *
	 * @param segmentId the primary key for the new segment
	 * @return the new segment
	 */
	@Override
	public Segment create(long segmentId) {
		Segment segment = new SegmentImpl();

		segment.setNew(true);
		segment.setPrimaryKey(segmentId);

		return segment;
	}

	/**
	 * Removes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment remove(long segmentId)
		throws NoSuchSegmentException, SystemException {
		return remove((Serializable)segmentId);
	}

	/**
	 * Removes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the segment
	 * @return the segment that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment remove(Serializable primaryKey)
		throws NoSuchSegmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Segment segment = (Segment)session.get(SegmentImpl.class, primaryKey);

			if (segment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSegmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(segment);
		}
		catch (NoSuchSegmentException nsee) {
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
	protected Segment removeImpl(Segment segment) throws SystemException {
		segment = toUnwrappedModel(segment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(segment)) {
				segment = (Segment)session.get(SegmentImpl.class,
						segment.getPrimaryKeyObj());
			}

			if (segment != null) {
				session.delete(segment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (segment != null) {
			clearCache(segment);
		}

		return segment;
	}

	@Override
	public Segment updateImpl(de.uhh.l2g.plugins.model.Segment segment)
		throws SystemException {
		segment = toUnwrappedModel(segment);

		boolean isNew = segment.isNew();

		SegmentModelImpl segmentModelImpl = (SegmentModelImpl)segment;

		Session session = null;

		try {
			session = openSession();

			if (segment.isNew()) {
				session.save(segment);

				segment.setNew(false);
			}
			else {
				session.merge(segment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SegmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((segmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						segmentModelImpl.getOriginalVideoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { segmentModelImpl.getVideoId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}

			if ((segmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						segmentModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { segmentModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}
		}

		EntityCacheUtil.putResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentImpl.class, segment.getPrimaryKey(), segment);

		return segment;
	}

	protected Segment toUnwrappedModel(Segment segment) {
		if (segment instanceof SegmentImpl) {
			return segment;
		}

		SegmentImpl segmentImpl = new SegmentImpl();

		segmentImpl.setNew(segment.isNew());
		segmentImpl.setPrimaryKey(segment.getPrimaryKey());

		segmentImpl.setSegmentId(segment.getSegmentId());
		segmentImpl.setVideoId(segment.getVideoId());
		segmentImpl.setStart(segment.getStart());
		segmentImpl.setTitle(segment.getTitle());
		segmentImpl.setDescription(segment.getDescription());
		segmentImpl.setEnd(segment.getEnd());
		segmentImpl.setChapter(segment.getChapter());
		segmentImpl.setUserId(segment.getUserId());

		return segmentImpl;
	}

	/**
	 * Returns the segment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the segment
	 * @return the segment
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSegmentException, SystemException {
		Segment segment = fetchByPrimaryKey(primaryKey);

		if (segment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSegmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return segment;
	}

	/**
	 * Returns the segment with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchSegmentException} if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment findByPrimaryKey(long segmentId)
		throws NoSuchSegmentException, SystemException {
		return findByPrimaryKey((Serializable)segmentId);
	}

	/**
	 * Returns the segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the segment
	 * @return the segment, or <code>null</code> if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Segment segment = (Segment)EntityCacheUtil.getResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
				SegmentImpl.class, primaryKey);

		if (segment == _nullSegment) {
			return null;
		}

		if (segment == null) {
			Session session = null;

			try {
				session = openSession();

				segment = (Segment)session.get(SegmentImpl.class, primaryKey);

				if (segment != null) {
					cacheResult(segment);
				}
				else {
					EntityCacheUtil.putResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
						SegmentImpl.class, primaryKey, _nullSegment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
					SegmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return segment;
	}

	/**
	 * Returns the segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment, or <code>null</code> if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment fetchByPrimaryKey(long segmentId) throws SystemException {
		return fetchByPrimaryKey((Serializable)segmentId);
	}

	/**
	 * Returns all the segments.
	 *
	 * @return the segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment> findAll(int start, int end,
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

		List<Segment> list = (List<Segment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEGMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEGMENT;

				if (pagination) {
					sql = sql.concat(SegmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Segment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Segment>(list);
				}
				else {
					list = (List<Segment>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the segments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Segment segment : findAll()) {
			remove(segment);
		}
	}

	/**
	 * Returns the number of segments.
	 *
	 * @return the number of segments
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

				Query q = session.createQuery(_SQL_COUNT_SEGMENT);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the segment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Segment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Segment>> listenersList = new ArrayList<ModelListener<Segment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Segment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SegmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SEGMENT = "SELECT segment FROM Segment segment";
	private static final String _SQL_SELECT_SEGMENT_WHERE = "SELECT segment FROM Segment segment WHERE ";
	private static final String _SQL_COUNT_SEGMENT = "SELECT COUNT(segment) FROM Segment segment";
	private static final String _SQL_COUNT_SEGMENT_WHERE = "SELECT COUNT(segment) FROM Segment segment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "segment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Segment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Segment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SegmentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"start", "end"
			});
	private static Segment _nullSegment = new SegmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Segment> toCacheModel() {
				return _nullSegmentCacheModel;
			}
		};

	private static CacheModel<Segment> _nullSegmentCacheModel = new CacheModel<Segment>() {
			@Override
			public Segment toEntityModel() {
				return _nullSegment;
			}
		};
}