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

import de.uhh.l2g.plugins.NoSuchVideo_InstitutionException;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.impl.Video_InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video_ institution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_InstitutionPersistence
 * @see Video_InstitutionUtil
 * @generated
 */
public class Video_InstitutionPersistenceImpl extends BasePersistenceImpl<Video_Institution>
	implements Video_InstitutionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Video_InstitutionUtil} to access the video_ institution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Video_InstitutionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] { Long.class.getName() },
			Video_InstitutionModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ institutions where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Institution> findByVideo(long videoId)
		throws SystemException {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ institutions where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Institution> findByVideo(long videoId, int start, int end)
		throws SystemException {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Institution> findByVideo(long videoId, int start,
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

		List<Video_Institution> list = (List<Video_Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Institution video_Institution : list) {
				if ((videoId != video_Institution.getVideoId())) {
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

			query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Institution>(list);
				}
				else {
					list = (List<Video_Institution>)QueryUtil.list(q,
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
	 * Returns the first video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution findByVideo_First(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_InstitutionException, SystemException {
		Video_Institution video_Institution = fetchByVideo_First(videoId,
				orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the first video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution fetchByVideo_First(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Video_Institution> list = findByVideo(videoId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution findByVideo_Last(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_InstitutionException, SystemException {
		Video_Institution video_Institution = fetchByVideo_Last(videoId,
				orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution fetchByVideo_Last(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Video_Institution> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution[] findByVideo_PrevAndNext(
		long videoInstitutionId, long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_InstitutionException, SystemException {
		Video_Institution video_Institution = findByPrimaryKey(videoInstitutionId);

		Session session = null;

		try {
			session = openSession();

			Video_Institution[] array = new Video_InstitutionImpl[3];

			array[0] = getByVideo_PrevAndNext(session, video_Institution,
					videoId, orderByComparator, true);

			array[1] = video_Institution;

			array[2] = getByVideo_PrevAndNext(session, video_Institution,
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

	protected Video_Institution getByVideo_PrevAndNext(Session session,
		Video_Institution video_Institution, long videoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

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
			query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ institutions where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideo(long videoId) throws SystemException {
		for (Video_Institution video_Institution : findByVideo(videoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Institution);
		}
	}

	/**
	 * Returns the number of video_ institutions where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ institutions
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

			query.append(_SQL_COUNT_VIDEO_INSTITUTION_WHERE);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "video_Institution.videoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTION =
		new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInstitution",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION =
		new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInstitution",
			new String[] { Long.class.getName() },
			Video_InstitutionModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTITUTION = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstitution",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ institutions where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Institution> findByInstitution(long institutionId)
		throws SystemException {
		return findByInstitution(institutionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Institution> findByInstitution(long institutionId,
		int start, int end) throws SystemException {
		return findByInstitution(institutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Institution> findByInstitution(long institutionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION;
			finderArgs = new Object[] { institutionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTION;
			finderArgs = new Object[] {
					institutionId,
					
					start, end, orderByComparator
				};
		}

		List<Video_Institution> list = (List<Video_Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Institution video_Institution : list) {
				if ((institutionId != video_Institution.getInstitutionId())) {
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

			query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

				if (!pagination) {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Institution>(list);
				}
				else {
					list = (List<Video_Institution>)QueryUtil.list(q,
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
	 * Returns the first video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution findByInstitution_First(long institutionId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_InstitutionException, SystemException {
		Video_Institution video_Institution = fetchByInstitution_First(institutionId,
				orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the first video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution fetchByInstitution_First(long institutionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Video_Institution> list = findByInstitution(institutionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution findByInstitution_Last(long institutionId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_InstitutionException, SystemException {
		Video_Institution video_Institution = fetchByInstitution_Last(institutionId,
				orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the last video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution fetchByInstitution_Last(long institutionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByInstitution(institutionId);

		if (count == 0) {
			return null;
		}

		List<Video_Institution> list = findByInstitution(institutionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution[] findByInstitution_PrevAndNext(
		long videoInstitutionId, long institutionId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_InstitutionException, SystemException {
		Video_Institution video_Institution = findByPrimaryKey(videoInstitutionId);

		Session session = null;

		try {
			session = openSession();

			Video_Institution[] array = new Video_InstitutionImpl[3];

			array[0] = getByInstitution_PrevAndNext(session, video_Institution,
					institutionId, orderByComparator, true);

			array[1] = video_Institution;

			array[2] = getByInstitution_PrevAndNext(session, video_Institution,
					institutionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Institution getByInstitution_PrevAndNext(Session session,
		Video_Institution video_Institution, long institutionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

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
			query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(institutionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ institutions where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByInstitution(long institutionId)
		throws SystemException {
		for (Video_Institution video_Institution : findByInstitution(
				institutionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Institution);
		}
	}

	/**
	 * Returns the number of video_ institutions where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByInstitution(long institutionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTITUTION;

		Object[] finderArgs = new Object[] { institutionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

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

	private static final String _FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2 = "video_Institution.institutionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOINSTITUTION =
		new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideoInstitution",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOINSTITUTION =
		new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVideoInstitution",
			new String[] { Long.class.getName(), Long.class.getName() },
			Video_InstitutionModelImpl.VIDEOID_COLUMN_BITMASK |
			Video_InstitutionModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOINSTITUTION = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVideoInstitution",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @return the matching video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Institution> findByVideoInstitution(long videoId,
		long institutionId) throws SystemException {
		return findByVideoInstitution(videoId, institutionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Institution> findByVideoInstitution(long videoId,
		long institutionId, int start, int end) throws SystemException {
		return findByVideoInstitution(videoId, institutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Institution> findByVideoInstitution(long videoId,
		long institutionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOINSTITUTION;
			finderArgs = new Object[] { videoId, institutionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOINSTITUTION;
			finderArgs = new Object[] {
					videoId, institutionId,
					
					start, end, orderByComparator
				};
		}

		List<Video_Institution> list = (List<Video_Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Institution video_Institution : list) {
				if ((videoId != video_Institution.getVideoId()) ||
						(institutionId != video_Institution.getInstitutionId())) {
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

			query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_VIDEOINSTITUTION_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOINSTITUTION_INSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(institutionId);

				if (!pagination) {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Institution>(list);
				}
				else {
					list = (List<Video_Institution>)QueryUtil.list(q,
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
	 * Returns the first video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution findByVideoInstitution_First(long videoId,
		long institutionId, OrderByComparator orderByComparator)
		throws NoSuchVideo_InstitutionException, SystemException {
		Video_Institution video_Institution = fetchByVideoInstitution_First(videoId,
				institutionId, orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the first video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution fetchByVideoInstitution_First(long videoId,
		long institutionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Video_Institution> list = findByVideoInstitution(videoId,
				institutionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution findByVideoInstitution_Last(long videoId,
		long institutionId, OrderByComparator orderByComparator)
		throws NoSuchVideo_InstitutionException, SystemException {
		Video_Institution video_Institution = fetchByVideoInstitution_Last(videoId,
				institutionId, orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution fetchByVideoInstitution_Last(long videoId,
		long institutionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByVideoInstitution(videoId, institutionId);

		if (count == 0) {
			return null;
		}

		List<Video_Institution> list = findByVideoInstitution(videoId,
				institutionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution[] findByVideoInstitution_PrevAndNext(
		long videoInstitutionId, long videoId, long institutionId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_InstitutionException, SystemException {
		Video_Institution video_Institution = findByPrimaryKey(videoInstitutionId);

		Session session = null;

		try {
			session = openSession();

			Video_Institution[] array = new Video_InstitutionImpl[3];

			array[0] = getByVideoInstitution_PrevAndNext(session,
					video_Institution, videoId, institutionId,
					orderByComparator, true);

			array[1] = video_Institution;

			array[2] = getByVideoInstitution_PrevAndNext(session,
					video_Institution, videoId, institutionId,
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

	protected Video_Institution getByVideoInstitution_PrevAndNext(
		Session session, Video_Institution video_Institution, long videoId,
		long institutionId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_VIDEOINSTITUTION_VIDEOID_2);

		query.append(_FINDER_COLUMN_VIDEOINSTITUTION_INSTITUTIONID_2);

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
			query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		qPos.add(institutionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ institutions where videoId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideoInstitution(long videoId, long institutionId)
		throws SystemException {
		for (Video_Institution video_Institution : findByVideoInstitution(
				videoId, institutionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(video_Institution);
		}
	}

	/**
	 * Returns the number of video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @return the number of matching video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVideoInstitution(long videoId, long institutionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEOINSTITUTION;

		Object[] finderArgs = new Object[] { videoId, institutionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_VIDEOINSTITUTION_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOINSTITUTION_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(institutionId);

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

	private static final String _FINDER_COLUMN_VIDEOINSTITUTION_VIDEOID_2 = "video_Institution.videoId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEOINSTITUTION_INSTITUTIONID_2 = "video_Institution.institutionId = ?";

	public Video_InstitutionPersistenceImpl() {
		setModelClass(Video_Institution.class);
	}

	/**
	 * Caches the video_ institution in the entity cache if it is enabled.
	 *
	 * @param video_Institution the video_ institution
	 */
	@Override
	public void cacheResult(Video_Institution video_Institution) {
		EntityCacheUtil.putResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionImpl.class, video_Institution.getPrimaryKey(),
			video_Institution);

		video_Institution.resetOriginalValues();
	}

	/**
	 * Caches the video_ institutions in the entity cache if it is enabled.
	 *
	 * @param video_Institutions the video_ institutions
	 */
	@Override
	public void cacheResult(List<Video_Institution> video_Institutions) {
		for (Video_Institution video_Institution : video_Institutions) {
			if (EntityCacheUtil.getResult(
						Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
						Video_InstitutionImpl.class,
						video_Institution.getPrimaryKey()) == null) {
				cacheResult(video_Institution);
			}
			else {
				video_Institution.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ institutions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Video_InstitutionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Video_InstitutionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ institution.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_Institution video_Institution) {
		EntityCacheUtil.removeResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionImpl.class, video_Institution.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_Institution> video_Institutions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_Institution video_Institution : video_Institutions) {
			EntityCacheUtil.removeResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
				Video_InstitutionImpl.class, video_Institution.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video_ institution with the primary key. Does not add the video_ institution to the database.
	 *
	 * @param videoInstitutionId the primary key for the new video_ institution
	 * @return the new video_ institution
	 */
	@Override
	public Video_Institution create(long videoInstitutionId) {
		Video_Institution video_Institution = new Video_InstitutionImpl();

		video_Institution.setNew(true);
		video_Institution.setPrimaryKey(videoInstitutionId);

		return video_Institution;
	}

	/**
	 * Removes the video_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoInstitutionId the primary key of the video_ institution
	 * @return the video_ institution that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution remove(long videoInstitutionId)
		throws NoSuchVideo_InstitutionException, SystemException {
		return remove((Serializable)videoInstitutionId);
	}

	/**
	 * Removes the video_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ institution
	 * @return the video_ institution that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution remove(Serializable primaryKey)
		throws NoSuchVideo_InstitutionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Video_Institution video_Institution = (Video_Institution)session.get(Video_InstitutionImpl.class,
					primaryKey);

			if (video_Institution == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_InstitutionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(video_Institution);
		}
		catch (NoSuchVideo_InstitutionException nsee) {
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
	protected Video_Institution removeImpl(Video_Institution video_Institution)
		throws SystemException {
		video_Institution = toUnwrappedModel(video_Institution);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_Institution)) {
				video_Institution = (Video_Institution)session.get(Video_InstitutionImpl.class,
						video_Institution.getPrimaryKeyObj());
			}

			if (video_Institution != null) {
				session.delete(video_Institution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video_Institution != null) {
			clearCache(video_Institution);
		}

		return video_Institution;
	}

	@Override
	public Video_Institution updateImpl(
		de.uhh.l2g.plugins.model.Video_Institution video_Institution)
		throws SystemException {
		video_Institution = toUnwrappedModel(video_Institution);

		boolean isNew = video_Institution.isNew();

		Video_InstitutionModelImpl video_InstitutionModelImpl = (Video_InstitutionModelImpl)video_Institution;

		Session session = null;

		try {
			session = openSession();

			if (video_Institution.isNew()) {
				session.save(video_Institution);

				video_Institution.setNew(false);
			}
			else {
				session.merge(video_Institution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Video_InstitutionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((video_InstitutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_InstitutionModelImpl.getOriginalVideoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { video_InstitutionModelImpl.getVideoId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}

			if ((video_InstitutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_InstitutionModelImpl.getOriginalInstitutionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION,
					args);

				args = new Object[] {
						video_InstitutionModelImpl.getInstitutionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION,
					args);
			}

			if ((video_InstitutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOINSTITUTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_InstitutionModelImpl.getOriginalVideoId(),
						video_InstitutionModelImpl.getOriginalInstitutionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOINSTITUTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOINSTITUTION,
					args);

				args = new Object[] {
						video_InstitutionModelImpl.getVideoId(),
						video_InstitutionModelImpl.getInstitutionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOINSTITUTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOINSTITUTION,
					args);
			}
		}

		EntityCacheUtil.putResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionImpl.class, video_Institution.getPrimaryKey(),
			video_Institution);

		return video_Institution;
	}

	protected Video_Institution toUnwrappedModel(
		Video_Institution video_Institution) {
		if (video_Institution instanceof Video_InstitutionImpl) {
			return video_Institution;
		}

		Video_InstitutionImpl video_InstitutionImpl = new Video_InstitutionImpl();

		video_InstitutionImpl.setNew(video_Institution.isNew());
		video_InstitutionImpl.setPrimaryKey(video_Institution.getPrimaryKey());

		video_InstitutionImpl.setVideoInstitutionId(video_Institution.getVideoInstitutionId());
		video_InstitutionImpl.setVideoId(video_Institution.getVideoId());
		video_InstitutionImpl.setInstitutionId(video_Institution.getInstitutionId());

		return video_InstitutionImpl;
	}

	/**
	 * Returns the video_ institution with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ institution
	 * @return the video_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_InstitutionException, SystemException {
		Video_Institution video_Institution = fetchByPrimaryKey(primaryKey);

		if (video_Institution == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_InstitutionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return video_Institution;
	}

	/**
	 * Returns the video_ institution with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideo_InstitutionException} if it could not be found.
	 *
	 * @param videoInstitutionId the primary key of the video_ institution
	 * @return the video_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution findByPrimaryKey(long videoInstitutionId)
		throws NoSuchVideo_InstitutionException, SystemException {
		return findByPrimaryKey((Serializable)videoInstitutionId);
	}

	/**
	 * Returns the video_ institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ institution
	 * @return the video_ institution, or <code>null</code> if a video_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Video_Institution video_Institution = (Video_Institution)EntityCacheUtil.getResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
				Video_InstitutionImpl.class, primaryKey);

		if (video_Institution == _nullVideo_Institution) {
			return null;
		}

		if (video_Institution == null) {
			Session session = null;

			try {
				session = openSession();

				video_Institution = (Video_Institution)session.get(Video_InstitutionImpl.class,
						primaryKey);

				if (video_Institution != null) {
					cacheResult(video_Institution);
				}
				else {
					EntityCacheUtil.putResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
						Video_InstitutionImpl.class, primaryKey,
						_nullVideo_Institution);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
					Video_InstitutionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return video_Institution;
	}

	/**
	 * Returns the video_ institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoInstitutionId the primary key of the video_ institution
	 * @return the video_ institution, or <code>null</code> if a video_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Institution fetchByPrimaryKey(long videoInstitutionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)videoInstitutionId);
	}

	/**
	 * Returns all the video_ institutions.
	 *
	 * @return the video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Institution> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Institution> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Institution> findAll(int start, int end,
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

		List<Video_Institution> list = (List<Video_Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEO_INSTITUTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_INSTITUTION;

				if (pagination) {
					sql = sql.concat(Video_InstitutionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Institution>(list);
				}
				else {
					list = (List<Video_Institution>)QueryUtil.list(q,
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
	 * Removes all the video_ institutions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Video_Institution video_Institution : findAll()) {
			remove(video_Institution);
		}
	}

	/**
	 * Returns the number of video_ institutions.
	 *
	 * @return the number of video_ institutions
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

				Query q = session.createQuery(_SQL_COUNT_VIDEO_INSTITUTION);

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
	 * Initializes the video_ institution persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Video_Institution")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Video_Institution>> listenersList = new ArrayList<ModelListener<Video_Institution>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Video_Institution>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Video_InstitutionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEO_INSTITUTION = "SELECT video_Institution FROM Video_Institution video_Institution";
	private static final String _SQL_SELECT_VIDEO_INSTITUTION_WHERE = "SELECT video_Institution FROM Video_Institution video_Institution WHERE ";
	private static final String _SQL_COUNT_VIDEO_INSTITUTION = "SELECT COUNT(video_Institution) FROM Video_Institution video_Institution";
	private static final String _SQL_COUNT_VIDEO_INSTITUTION_WHERE = "SELECT COUNT(video_Institution) FROM Video_Institution video_Institution WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "video_Institution.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Video_Institution exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Video_Institution exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Video_InstitutionPersistenceImpl.class);
	private static Video_Institution _nullVideo_Institution = new Video_InstitutionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Video_Institution> toCacheModel() {
				return _nullVideo_InstitutionCacheModel;
			}
		};

	private static CacheModel<Video_Institution> _nullVideo_InstitutionCacheModel =
		new CacheModel<Video_Institution>() {
			@Override
			public Video_Institution toEntityModel() {
				return _nullVideo_Institution;
			}
		};
}