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

import de.uhh.l2g.plugins.NoSuchSegment_User_VideoException;
import de.uhh.l2g.plugins.model.Segment_User_Video;
import de.uhh.l2g.plugins.model.impl.Segment_User_VideoImpl;
import de.uhh.l2g.plugins.model.impl.Segment_User_VideoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the segment_ user_ video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Segment_User_VideoPersistence
 * @see Segment_User_VideoUtil
 * @generated
 */
public class Segment_User_VideoPersistenceImpl extends BasePersistenceImpl<Segment_User_Video>
	implements Segment_User_VideoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Segment_User_VideoUtil} to access the segment_ user_ video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Segment_User_VideoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoModelImpl.FINDER_CACHE_ENABLED,
			Segment_User_VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoModelImpl.FINDER_CACHE_ENABLED,
			Segment_User_VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEGMENT = new FinderPath(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoModelImpl.FINDER_CACHE_ENABLED,
			Segment_User_VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySegment",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGMENT =
		new FinderPath(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoModelImpl.FINDER_CACHE_ENABLED,
			Segment_User_VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySegment",
			new String[] { Long.class.getName() },
			Segment_User_VideoModelImpl.SEGMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEGMENT = new FinderPath(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySegment",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the segment_ user_ videos where segmentId = &#63;.
	 *
	 * @param segmentId the segment ID
	 * @return the matching segment_ user_ videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment_User_Video> findBySegment(long segmentId)
		throws SystemException {
		return findBySegment(segmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Segment_User_Video> findBySegment(long segmentId, int start,
		int end) throws SystemException {
		return findBySegment(segmentId, start, end, null);
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
	@Override
	public List<Segment_User_Video> findBySegment(long segmentId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGMENT;
			finderArgs = new Object[] { segmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEGMENT;
			finderArgs = new Object[] { segmentId, start, end, orderByComparator };
		}

		List<Segment_User_Video> list = (List<Segment_User_Video>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Segment_User_Video segment_User_Video : list) {
				if ((segmentId != segment_User_Video.getSegmentId())) {
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

			query.append(_SQL_SELECT_SEGMENT_USER_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_SEGMENT_SEGMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Segment_User_VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(segmentId);

				if (!pagination) {
					list = (List<Segment_User_Video>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Segment_User_Video>(list);
				}
				else {
					list = (List<Segment_User_Video>)QueryUtil.list(q,
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
	 * Returns the first segment_ user_ video in the ordered set where segmentId = &#63;.
	 *
	 * @param segmentId the segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment_ user_ video
	 * @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video findBySegment_First(long segmentId,
		OrderByComparator orderByComparator)
		throws NoSuchSegment_User_VideoException, SystemException {
		Segment_User_Video segment_User_Video = fetchBySegment_First(segmentId,
				orderByComparator);

		if (segment_User_Video != null) {
			return segment_User_Video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("segmentId=");
		msg.append(segmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSegment_User_VideoException(msg.toString());
	}

	/**
	 * Returns the first segment_ user_ video in the ordered set where segmentId = &#63;.
	 *
	 * @param segmentId the segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video fetchBySegment_First(long segmentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Segment_User_Video> list = findBySegment(segmentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Segment_User_Video findBySegment_Last(long segmentId,
		OrderByComparator orderByComparator)
		throws NoSuchSegment_User_VideoException, SystemException {
		Segment_User_Video segment_User_Video = fetchBySegment_Last(segmentId,
				orderByComparator);

		if (segment_User_Video != null) {
			return segment_User_Video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("segmentId=");
		msg.append(segmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSegment_User_VideoException(msg.toString());
	}

	/**
	 * Returns the last segment_ user_ video in the ordered set where segmentId = &#63;.
	 *
	 * @param segmentId the segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video fetchBySegment_Last(long segmentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySegment(segmentId);

		if (count == 0) {
			return null;
		}

		List<Segment_User_Video> list = findBySegment(segmentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Segment_User_Video[] findBySegment_PrevAndNext(
		long segmentUserVideoId, long segmentId,
		OrderByComparator orderByComparator)
		throws NoSuchSegment_User_VideoException, SystemException {
		Segment_User_Video segment_User_Video = findByPrimaryKey(segmentUserVideoId);

		Session session = null;

		try {
			session = openSession();

			Segment_User_Video[] array = new Segment_User_VideoImpl[3];

			array[0] = getBySegment_PrevAndNext(session, segment_User_Video,
					segmentId, orderByComparator, true);

			array[1] = segment_User_Video;

			array[2] = getBySegment_PrevAndNext(session, segment_User_Video,
					segmentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Segment_User_Video getBySegment_PrevAndNext(Session session,
		Segment_User_Video segment_User_Video, long segmentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEGMENT_USER_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_SEGMENT_SEGMENTID_2);

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
			query.append(Segment_User_VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(segmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(segment_User_Video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Segment_User_Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segment_ user_ videos where segmentId = &#63; from the database.
	 *
	 * @param segmentId the segment ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySegment(long segmentId) throws SystemException {
		for (Segment_User_Video segment_User_Video : findBySegment(segmentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(segment_User_Video);
		}
	}

	/**
	 * Returns the number of segment_ user_ videos where segmentId = &#63;.
	 *
	 * @param segmentId the segment ID
	 * @return the number of matching segment_ user_ videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySegment(long segmentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEGMENT;

		Object[] finderArgs = new Object[] { segmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEGMENT_USER_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_SEGMENT_SEGMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(segmentId);

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

	private static final String _FINDER_COLUMN_SEGMENT_SEGMENTID_2 = "segment_User_Video.segmentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoModelImpl.FINDER_CACHE_ENABLED,
			Segment_User_VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoModelImpl.FINDER_CACHE_ENABLED,
			Segment_User_VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			Segment_User_VideoModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the segment_ user_ videos where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching segment_ user_ videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment_User_Video> findByUser(long userId)
		throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Segment_User_Video> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
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
	@Override
	public List<Segment_User_Video> findByUser(long userId, int start, int end,
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

		List<Segment_User_Video> list = (List<Segment_User_Video>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Segment_User_Video segment_User_Video : list) {
				if ((userId != segment_User_Video.getUserId())) {
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

			query.append(_SQL_SELECT_SEGMENT_USER_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Segment_User_VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Segment_User_Video>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Segment_User_Video>(list);
				}
				else {
					list = (List<Segment_User_Video>)QueryUtil.list(q,
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
	 * Returns the first segment_ user_ video in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment_ user_ video
	 * @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSegment_User_VideoException, SystemException {
		Segment_User_Video segment_User_Video = fetchByUser_First(userId,
				orderByComparator);

		if (segment_User_Video != null) {
			return segment_User_Video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSegment_User_VideoException(msg.toString());
	}

	/**
	 * Returns the first segment_ user_ video in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Segment_User_Video> list = findByUser(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Segment_User_Video findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSegment_User_VideoException, SystemException {
		Segment_User_Video segment_User_Video = fetchByUser_Last(userId,
				orderByComparator);

		if (segment_User_Video != null) {
			return segment_User_Video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSegment_User_VideoException(msg.toString());
	}

	/**
	 * Returns the last segment_ user_ video in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<Segment_User_Video> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Segment_User_Video[] findByUser_PrevAndNext(
		long segmentUserVideoId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSegment_User_VideoException, SystemException {
		Segment_User_Video segment_User_Video = findByPrimaryKey(segmentUserVideoId);

		Session session = null;

		try {
			session = openSession();

			Segment_User_Video[] array = new Segment_User_VideoImpl[3];

			array[0] = getByUser_PrevAndNext(session, segment_User_Video,
					userId, orderByComparator, true);

			array[1] = segment_User_Video;

			array[2] = getByUser_PrevAndNext(session, segment_User_Video,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Segment_User_Video getByUser_PrevAndNext(Session session,
		Segment_User_Video segment_User_Video, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEGMENT_USER_VIDEO_WHERE);

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
			query.append(Segment_User_VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(segment_User_Video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Segment_User_Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segment_ user_ videos where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (Segment_User_Video segment_User_Video : findByUser(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(segment_User_Video);
		}
	}

	/**
	 * Returns the number of segment_ user_ videos where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching segment_ user_ videos
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

			query.append(_SQL_COUNT_SEGMENT_USER_VIDEO_WHERE);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "segment_User_Video.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoModelImpl.FINDER_CACHE_ENABLED,
			Segment_User_VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoModelImpl.FINDER_CACHE_ENABLED,
			Segment_User_VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] { Long.class.getName() },
			Segment_User_VideoModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the segment_ user_ videos where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching segment_ user_ videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment_User_Video> findByVideo(long videoId)
		throws SystemException {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Segment_User_Video> findByVideo(long videoId, int start, int end)
		throws SystemException {
		return findByVideo(videoId, start, end, null);
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
	@Override
	public List<Segment_User_Video> findByVideo(long videoId, int start,
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

		List<Segment_User_Video> list = (List<Segment_User_Video>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Segment_User_Video segment_User_Video : list) {
				if ((videoId != segment_User_Video.getVideoId())) {
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

			query.append(_SQL_SELECT_SEGMENT_USER_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Segment_User_VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Segment_User_Video>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Segment_User_Video>(list);
				}
				else {
					list = (List<Segment_User_Video>)QueryUtil.list(q,
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
	 * Returns the first segment_ user_ video in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment_ user_ video
	 * @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a matching segment_ user_ video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video findByVideo_First(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchSegment_User_VideoException, SystemException {
		Segment_User_Video segment_User_Video = fetchByVideo_First(videoId,
				orderByComparator);

		if (segment_User_Video != null) {
			return segment_User_Video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSegment_User_VideoException(msg.toString());
	}

	/**
	 * Returns the first segment_ user_ video in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video fetchByVideo_First(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Segment_User_Video> list = findByVideo(videoId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Segment_User_Video findByVideo_Last(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchSegment_User_VideoException, SystemException {
		Segment_User_Video segment_User_Video = fetchByVideo_Last(videoId,
				orderByComparator);

		if (segment_User_Video != null) {
			return segment_User_Video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSegment_User_VideoException(msg.toString());
	}

	/**
	 * Returns the last segment_ user_ video in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment_ user_ video, or <code>null</code> if a matching segment_ user_ video could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video fetchByVideo_Last(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Segment_User_Video> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Segment_User_Video[] findByVideo_PrevAndNext(
		long segmentUserVideoId, long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchSegment_User_VideoException, SystemException {
		Segment_User_Video segment_User_Video = findByPrimaryKey(segmentUserVideoId);

		Session session = null;

		try {
			session = openSession();

			Segment_User_Video[] array = new Segment_User_VideoImpl[3];

			array[0] = getByVideo_PrevAndNext(session, segment_User_Video,
					videoId, orderByComparator, true);

			array[1] = segment_User_Video;

			array[2] = getByVideo_PrevAndNext(session, segment_User_Video,
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

	protected Segment_User_Video getByVideo_PrevAndNext(Session session,
		Segment_User_Video segment_User_Video, long videoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEGMENT_USER_VIDEO_WHERE);

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
			query.append(Segment_User_VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(segment_User_Video);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Segment_User_Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segment_ user_ videos where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideo(long videoId) throws SystemException {
		for (Segment_User_Video segment_User_Video : findByVideo(videoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(segment_User_Video);
		}
	}

	/**
	 * Returns the number of segment_ user_ videos where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching segment_ user_ videos
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

			query.append(_SQL_COUNT_SEGMENT_USER_VIDEO_WHERE);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "segment_User_Video.videoId = ?";

	public Segment_User_VideoPersistenceImpl() {
		setModelClass(Segment_User_Video.class);
	}

	/**
	 * Caches the segment_ user_ video in the entity cache if it is enabled.
	 *
	 * @param segment_User_Video the segment_ user_ video
	 */
	@Override
	public void cacheResult(Segment_User_Video segment_User_Video) {
		EntityCacheUtil.putResult(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoImpl.class, segment_User_Video.getPrimaryKey(),
			segment_User_Video);

		segment_User_Video.resetOriginalValues();
	}

	/**
	 * Caches the segment_ user_ videos in the entity cache if it is enabled.
	 *
	 * @param segment_User_Videos the segment_ user_ videos
	 */
	@Override
	public void cacheResult(List<Segment_User_Video> segment_User_Videos) {
		for (Segment_User_Video segment_User_Video : segment_User_Videos) {
			if (EntityCacheUtil.getResult(
						Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
						Segment_User_VideoImpl.class,
						segment_User_Video.getPrimaryKey()) == null) {
				cacheResult(segment_User_Video);
			}
			else {
				segment_User_Video.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all segment_ user_ videos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Segment_User_VideoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Segment_User_VideoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the segment_ user_ video.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Segment_User_Video segment_User_Video) {
		EntityCacheUtil.removeResult(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoImpl.class, segment_User_Video.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Segment_User_Video> segment_User_Videos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Segment_User_Video segment_User_Video : segment_User_Videos) {
			EntityCacheUtil.removeResult(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
				Segment_User_VideoImpl.class, segment_User_Video.getPrimaryKey());
		}
	}

	/**
	 * Creates a new segment_ user_ video with the primary key. Does not add the segment_ user_ video to the database.
	 *
	 * @param segmentUserVideoId the primary key for the new segment_ user_ video
	 * @return the new segment_ user_ video
	 */
	@Override
	public Segment_User_Video create(long segmentUserVideoId) {
		Segment_User_Video segment_User_Video = new Segment_User_VideoImpl();

		segment_User_Video.setNew(true);
		segment_User_Video.setPrimaryKey(segmentUserVideoId);

		return segment_User_Video;
	}

	/**
	 * Removes the segment_ user_ video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segmentUserVideoId the primary key of the segment_ user_ video
	 * @return the segment_ user_ video that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a segment_ user_ video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video remove(long segmentUserVideoId)
		throws NoSuchSegment_User_VideoException, SystemException {
		return remove((Serializable)segmentUserVideoId);
	}

	/**
	 * Removes the segment_ user_ video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the segment_ user_ video
	 * @return the segment_ user_ video that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a segment_ user_ video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video remove(Serializable primaryKey)
		throws NoSuchSegment_User_VideoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Segment_User_Video segment_User_Video = (Segment_User_Video)session.get(Segment_User_VideoImpl.class,
					primaryKey);

			if (segment_User_Video == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSegment_User_VideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(segment_User_Video);
		}
		catch (NoSuchSegment_User_VideoException nsee) {
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
	protected Segment_User_Video removeImpl(
		Segment_User_Video segment_User_Video) throws SystemException {
		segment_User_Video = toUnwrappedModel(segment_User_Video);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(segment_User_Video)) {
				segment_User_Video = (Segment_User_Video)session.get(Segment_User_VideoImpl.class,
						segment_User_Video.getPrimaryKeyObj());
			}

			if (segment_User_Video != null) {
				session.delete(segment_User_Video);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (segment_User_Video != null) {
			clearCache(segment_User_Video);
		}

		return segment_User_Video;
	}

	@Override
	public Segment_User_Video updateImpl(
		de.uhh.l2g.plugins.model.Segment_User_Video segment_User_Video)
		throws SystemException {
		segment_User_Video = toUnwrappedModel(segment_User_Video);

		boolean isNew = segment_User_Video.isNew();

		Segment_User_VideoModelImpl segment_User_VideoModelImpl = (Segment_User_VideoModelImpl)segment_User_Video;

		Session session = null;

		try {
			session = openSession();

			if (segment_User_Video.isNew()) {
				session.save(segment_User_Video);

				segment_User_Video.setNew(false);
			}
			else {
				session.merge(segment_User_Video);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Segment_User_VideoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((segment_User_VideoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						segment_User_VideoModelImpl.getOriginalSegmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEGMENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGMENT,
					args);

				args = new Object[] { segment_User_VideoModelImpl.getSegmentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEGMENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEGMENT,
					args);
			}

			if ((segment_User_VideoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						segment_User_VideoModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { segment_User_VideoModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((segment_User_VideoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						segment_User_VideoModelImpl.getOriginalVideoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { segment_User_VideoModelImpl.getVideoId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}
		}

		EntityCacheUtil.putResult(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
			Segment_User_VideoImpl.class, segment_User_Video.getPrimaryKey(),
			segment_User_Video);

		return segment_User_Video;
	}

	protected Segment_User_Video toUnwrappedModel(
		Segment_User_Video segment_User_Video) {
		if (segment_User_Video instanceof Segment_User_VideoImpl) {
			return segment_User_Video;
		}

		Segment_User_VideoImpl segment_User_VideoImpl = new Segment_User_VideoImpl();

		segment_User_VideoImpl.setNew(segment_User_Video.isNew());
		segment_User_VideoImpl.setPrimaryKey(segment_User_Video.getPrimaryKey());

		segment_User_VideoImpl.setSegmentId(segment_User_Video.getSegmentId());
		segment_User_VideoImpl.setUserId(segment_User_Video.getUserId());
		segment_User_VideoImpl.setVideoId(segment_User_Video.getVideoId());
		segment_User_VideoImpl.setSegmentUserVideoId(segment_User_Video.getSegmentUserVideoId());

		return segment_User_VideoImpl;
	}

	/**
	 * Returns the segment_ user_ video with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the segment_ user_ video
	 * @return the segment_ user_ video
	 * @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a segment_ user_ video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSegment_User_VideoException, SystemException {
		Segment_User_Video segment_User_Video = fetchByPrimaryKey(primaryKey);

		if (segment_User_Video == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSegment_User_VideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return segment_User_Video;
	}

	/**
	 * Returns the segment_ user_ video with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchSegment_User_VideoException} if it could not be found.
	 *
	 * @param segmentUserVideoId the primary key of the segment_ user_ video
	 * @return the segment_ user_ video
	 * @throws de.uhh.l2g.plugins.NoSuchSegment_User_VideoException if a segment_ user_ video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video findByPrimaryKey(long segmentUserVideoId)
		throws NoSuchSegment_User_VideoException, SystemException {
		return findByPrimaryKey((Serializable)segmentUserVideoId);
	}

	/**
	 * Returns the segment_ user_ video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the segment_ user_ video
	 * @return the segment_ user_ video, or <code>null</code> if a segment_ user_ video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Segment_User_Video segment_User_Video = (Segment_User_Video)EntityCacheUtil.getResult(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
				Segment_User_VideoImpl.class, primaryKey);

		if (segment_User_Video == _nullSegment_User_Video) {
			return null;
		}

		if (segment_User_Video == null) {
			Session session = null;

			try {
				session = openSession();

				segment_User_Video = (Segment_User_Video)session.get(Segment_User_VideoImpl.class,
						primaryKey);

				if (segment_User_Video != null) {
					cacheResult(segment_User_Video);
				}
				else {
					EntityCacheUtil.putResult(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
						Segment_User_VideoImpl.class, primaryKey,
						_nullSegment_User_Video);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Segment_User_VideoModelImpl.ENTITY_CACHE_ENABLED,
					Segment_User_VideoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return segment_User_Video;
	}

	/**
	 * Returns the segment_ user_ video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param segmentUserVideoId the primary key of the segment_ user_ video
	 * @return the segment_ user_ video, or <code>null</code> if a segment_ user_ video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment_User_Video fetchByPrimaryKey(long segmentUserVideoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)segmentUserVideoId);
	}

	/**
	 * Returns all the segment_ user_ videos.
	 *
	 * @return the segment_ user_ videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment_User_Video> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Segment_User_Video> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Segment_User_Video> findAll(int start, int end,
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

		List<Segment_User_Video> list = (List<Segment_User_Video>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEGMENT_USER_VIDEO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEGMENT_USER_VIDEO;

				if (pagination) {
					sql = sql.concat(Segment_User_VideoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Segment_User_Video>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Segment_User_Video>(list);
				}
				else {
					list = (List<Segment_User_Video>)QueryUtil.list(q,
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
	 * Removes all the segment_ user_ videos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Segment_User_Video segment_User_Video : findAll()) {
			remove(segment_User_Video);
		}
	}

	/**
	 * Returns the number of segment_ user_ videos.
	 *
	 * @return the number of segment_ user_ videos
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

				Query q = session.createQuery(_SQL_COUNT_SEGMENT_USER_VIDEO);

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
	 * Initializes the segment_ user_ video persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Segment_User_Video")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Segment_User_Video>> listenersList = new ArrayList<ModelListener<Segment_User_Video>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Segment_User_Video>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Segment_User_VideoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SEGMENT_USER_VIDEO = "SELECT segment_User_Video FROM Segment_User_Video segment_User_Video";
	private static final String _SQL_SELECT_SEGMENT_USER_VIDEO_WHERE = "SELECT segment_User_Video FROM Segment_User_Video segment_User_Video WHERE ";
	private static final String _SQL_COUNT_SEGMENT_USER_VIDEO = "SELECT COUNT(segment_User_Video) FROM Segment_User_Video segment_User_Video";
	private static final String _SQL_COUNT_SEGMENT_USER_VIDEO_WHERE = "SELECT COUNT(segment_User_Video) FROM Segment_User_Video segment_User_Video WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "segment_User_Video.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Segment_User_Video exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Segment_User_Video exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Segment_User_VideoPersistenceImpl.class);
	private static Segment_User_Video _nullSegment_User_Video = new Segment_User_VideoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Segment_User_Video> toCacheModel() {
				return _nullSegment_User_VideoCacheModel;
			}
		};

	private static CacheModel<Segment_User_Video> _nullSegment_User_VideoCacheModel =
		new CacheModel<Segment_User_Video>() {
			@Override
			public Segment_User_Video toEntityModel() {
				return _nullSegment_User_Video;
			}
		};
}