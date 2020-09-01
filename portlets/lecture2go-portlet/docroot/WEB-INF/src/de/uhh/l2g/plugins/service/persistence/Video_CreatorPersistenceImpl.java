/*******************************************************************************
 * License
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++
 * 
 * Lecture2Go 
 * 
 * The Lecture2Go software is based on the liferay portal 6.2-ga6
 * <http://www.liferay.com> (Copyright notice see below)
 * Lecture2Go <http://lecture2go.uni-hamburg.de> is an open source
 * platform for media management and distribution. Our goal is to
 * support the free access to knowledge because this is a component
 * of each democratic society. The open source software is aimed at
 * academic institutions and has to strengthen the blended learning.
 * All Lecture2Go plugins are continuously being developed and improved.
 * For more details please visit <http://lecture2go-open-source.rrz.uni-hamburg.de>
 * Copyright (c) 2013 - present University of Hamburg / Computer and Data Center (RRZ)
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *  
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++
 * 
 * The Liferay Plugins SDK:
 * 
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++
 * 
 * Third Party Software
 * 
 * Lecture2Go uses third-party libraries which may be distributed under different licenses
 * to the above (but are compatible with the used GPL license). Informations about these
 * licenses and copyright informations are mostly detailed in the library source code or jars themselves.
 * You must agree to the terms of these licenses, in addition tothe above Lecture2Go source code license,
 * in order to use this software.
 ******************************************************************************/
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

import de.uhh.l2g.plugins.NoSuchVideo_CreatorException;
import de.uhh.l2g.plugins.model.Video_Creator;
import de.uhh.l2g.plugins.model.impl.Video_CreatorImpl;
import de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video_ creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_CreatorPersistence
 * @see Video_CreatorUtil
 * @generated
 */
public class Video_CreatorPersistenceImpl extends BasePersistenceImpl<Video_Creator>
	implements Video_CreatorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Video_CreatorUtil} to access the video_ creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Video_CreatorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVideo", new String[] { Long.class.getName() },
			Video_CreatorModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ creators where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findByVideo(long videoId)
		throws SystemException {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findByVideo(long videoId, int start, int end)
		throws SystemException {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findByVideo(long videoId, int start, int end,
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

		List<Video_Creator> list = (List<Video_Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Creator video_Creator : list) {
				if ((videoId != video_Creator.getVideoId())) {
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

			query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Creator>(list);
				}
				else {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator findByVideo_First(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_CreatorException, SystemException {
		Video_Creator video_Creator = fetchByVideo_First(videoId,
				orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CreatorException(msg.toString());
	}

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator fetchByVideo_First(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Video_Creator> list = findByVideo(videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator findByVideo_Last(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_CreatorException, SystemException {
		Video_Creator video_Creator = fetchByVideo_Last(videoId,
				orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CreatorException(msg.toString());
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator fetchByVideo_Last(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Video_Creator> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator[] findByVideo_PrevAndNext(long videoCreatorId,
		long videoId, OrderByComparator orderByComparator)
		throws NoSuchVideo_CreatorException, SystemException {
		Video_Creator video_Creator = findByPrimaryKey(videoCreatorId);

		Session session = null;

		try {
			session = openSession();

			Video_Creator[] array = new Video_CreatorImpl[3];

			array[0] = getByVideo_PrevAndNext(session, video_Creator, videoId,
					orderByComparator, true);

			array[1] = video_Creator;

			array[2] = getByVideo_PrevAndNext(session, video_Creator, videoId,
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

	protected Video_Creator getByVideo_PrevAndNext(Session session,
		Video_Creator video_Creator, long videoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

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
			query.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ creators where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideo(long videoId) throws SystemException {
		for (Video_Creator video_Creator : findByVideo(videoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ creators
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

			query.append(_SQL_COUNT_VIDEO_CREATOR_WHERE);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "video_Creator.videoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATOR = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreator",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR =
		new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCreator", new String[] { Long.class.getName() },
			Video_CreatorModelImpl.CREATORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATOR = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreator",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findByCreator(long creatorId)
		throws SystemException {
		return findByCreator(creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findByCreator(long creatorId, int start, int end)
		throws SystemException {
		return findByCreator(creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findByCreator(long creatorId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR;
			finderArgs = new Object[] { creatorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATOR;
			finderArgs = new Object[] { creatorId, start, end, orderByComparator };
		}

		List<Video_Creator> list = (List<Video_Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Creator video_Creator : list) {
				if ((creatorId != video_Creator.getCreatorId())) {
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

			query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

			query.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creatorId);

				if (!pagination) {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Creator>(list);
				}
				else {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator findByCreator_First(long creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_CreatorException, SystemException {
		Video_Creator video_Creator = fetchByCreator_First(creatorId,
				orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CreatorException(msg.toString());
	}

	/**
	 * Returns the first video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator fetchByCreator_First(long creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Video_Creator> list = findByCreator(creatorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator findByCreator_Last(long creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_CreatorException, SystemException {
		Video_Creator video_Creator = fetchByCreator_Last(creatorId,
				orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CreatorException(msg.toString());
	}

	/**
	 * Returns the last video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator fetchByCreator_Last(long creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCreator(creatorId);

		if (count == 0) {
			return null;
		}

		List<Video_Creator> list = findByCreator(creatorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator[] findByCreator_PrevAndNext(long videoCreatorId,
		long creatorId, OrderByComparator orderByComparator)
		throws NoSuchVideo_CreatorException, SystemException {
		Video_Creator video_Creator = findByPrimaryKey(videoCreatorId);

		Session session = null;

		try {
			session = openSession();

			Video_Creator[] array = new Video_CreatorImpl[3];

			array[0] = getByCreator_PrevAndNext(session, video_Creator,
					creatorId, orderByComparator, true);

			array[1] = video_Creator;

			array[2] = getByCreator_PrevAndNext(session, video_Creator,
					creatorId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Creator getByCreator_PrevAndNext(Session session,
		Video_Creator video_Creator, long creatorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

		query.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

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
			query.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(creatorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ creators where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreator(long creatorId) throws SystemException {
		for (Video_Creator video_Creator : findByCreator(creatorId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCreator(long creatorId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATOR;

		Object[] finderArgs = new Object[] { creatorId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_CREATOR_WHERE);

			query.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creatorId);

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

	private static final String _FINDER_COLUMN_CREATOR_CREATORID_2 = "video_Creator.creatorId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOCREATOR =
		new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideoCreator",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCREATOR =
		new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVideoCreator",
			new String[] { Long.class.getName(), Long.class.getName() },
			Video_CreatorModelImpl.VIDEOID_COLUMN_BITMASK |
			Video_CreatorModelImpl.CREATORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOCREATOR = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideoCreator",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @return the matching video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findByVideoCreator(long videoId, long creatorId)
		throws SystemException {
		return findByVideoCreator(videoId, creatorId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findByVideoCreator(long videoId, long creatorId,
		int start, int end) throws SystemException {
		return findByVideoCreator(videoId, creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findByVideoCreator(long videoId, long creatorId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCREATOR;
			finderArgs = new Object[] { videoId, creatorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOCREATOR;
			finderArgs = new Object[] {
					videoId, creatorId,
					
					start, end, orderByComparator
				};
		}

		List<Video_Creator> list = (List<Video_Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Creator video_Creator : list) {
				if ((videoId != video_Creator.getVideoId()) ||
						(creatorId != video_Creator.getCreatorId())) {
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

			query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

			query.append(_FINDER_COLUMN_VIDEOCREATOR_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOCREATOR_CREATORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(creatorId);

				if (!pagination) {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Creator>(list);
				}
				else {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator findByVideoCreator_First(long videoId, long creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_CreatorException, SystemException {
		Video_Creator video_Creator = fetchByVideoCreator_First(videoId,
				creatorId, orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CreatorException(msg.toString());
	}

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator fetchByVideoCreator_First(long videoId,
		long creatorId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Video_Creator> list = findByVideoCreator(videoId, creatorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator findByVideoCreator_Last(long videoId, long creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_CreatorException, SystemException {
		Video_Creator video_Creator = fetchByVideoCreator_Last(videoId,
				creatorId, orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CreatorException(msg.toString());
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator fetchByVideoCreator_Last(long videoId, long creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVideoCreator(videoId, creatorId);

		if (count == 0) {
			return null;
		}

		List<Video_Creator> list = findByVideoCreator(videoId, creatorId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator[] findByVideoCreator_PrevAndNext(long videoCreatorId,
		long videoId, long creatorId, OrderByComparator orderByComparator)
		throws NoSuchVideo_CreatorException, SystemException {
		Video_Creator video_Creator = findByPrimaryKey(videoCreatorId);

		Session session = null;

		try {
			session = openSession();

			Video_Creator[] array = new Video_CreatorImpl[3];

			array[0] = getByVideoCreator_PrevAndNext(session, video_Creator,
					videoId, creatorId, orderByComparator, true);

			array[1] = video_Creator;

			array[2] = getByVideoCreator_PrevAndNext(session, video_Creator,
					videoId, creatorId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Creator getByVideoCreator_PrevAndNext(Session session,
		Video_Creator video_Creator, long videoId, long creatorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

		query.append(_FINDER_COLUMN_VIDEOCREATOR_VIDEOID_2);

		query.append(_FINDER_COLUMN_VIDEOCREATOR_CREATORID_2);

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
			query.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		qPos.add(creatorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ creators where videoId = &#63; and creatorId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideoCreator(long videoId, long creatorId)
		throws SystemException {
		for (Video_Creator video_Creator : findByVideoCreator(videoId,
				creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @return the number of matching video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVideoCreator(long videoId, long creatorId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEOCREATOR;

		Object[] finderArgs = new Object[] { videoId, creatorId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_CREATOR_WHERE);

			query.append(_FINDER_COLUMN_VIDEOCREATOR_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOCREATOR_CREATORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(creatorId);

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

	private static final String _FINDER_COLUMN_VIDEOCREATOR_VIDEOID_2 = "video_Creator.videoId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEOCREATOR_CREATORID_2 = "video_Creator.creatorId = ?";

	public Video_CreatorPersistenceImpl() {
		setModelClass(Video_Creator.class);
	}

	/**
	 * Caches the video_ creator in the entity cache if it is enabled.
	 *
	 * @param video_Creator the video_ creator
	 */
	@Override
	public void cacheResult(Video_Creator video_Creator) {
		EntityCacheUtil.putResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorImpl.class, video_Creator.getPrimaryKey(),
			video_Creator);

		video_Creator.resetOriginalValues();
	}

	/**
	 * Caches the video_ creators in the entity cache if it is enabled.
	 *
	 * @param video_Creators the video_ creators
	 */
	@Override
	public void cacheResult(List<Video_Creator> video_Creators) {
		for (Video_Creator video_Creator : video_Creators) {
			if (EntityCacheUtil.getResult(
						Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
						Video_CreatorImpl.class, video_Creator.getPrimaryKey()) == null) {
				cacheResult(video_Creator);
			}
			else {
				video_Creator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ creators.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Video_CreatorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Video_CreatorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ creator.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_Creator video_Creator) {
		EntityCacheUtil.removeResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorImpl.class, video_Creator.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_Creator> video_Creators) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_Creator video_Creator : video_Creators) {
			EntityCacheUtil.removeResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
				Video_CreatorImpl.class, video_Creator.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video_ creator with the primary key. Does not add the video_ creator to the database.
	 *
	 * @param videoCreatorId the primary key for the new video_ creator
	 * @return the new video_ creator
	 */
	@Override
	public Video_Creator create(long videoCreatorId) {
		Video_Creator video_Creator = new Video_CreatorImpl();

		video_Creator.setNew(true);
		video_Creator.setPrimaryKey(videoCreatorId);

		return video_Creator;
	}

	/**
	 * Removes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator remove(long videoCreatorId)
		throws NoSuchVideo_CreatorException, SystemException {
		return remove((Serializable)videoCreatorId);
	}

	/**
	 * Removes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ creator
	 * @return the video_ creator that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator remove(Serializable primaryKey)
		throws NoSuchVideo_CreatorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Video_Creator video_Creator = (Video_Creator)session.get(Video_CreatorImpl.class,
					primaryKey);

			if (video_Creator == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_CreatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(video_Creator);
		}
		catch (NoSuchVideo_CreatorException nsee) {
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
	protected Video_Creator removeImpl(Video_Creator video_Creator)
		throws SystemException {
		video_Creator = toUnwrappedModel(video_Creator);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_Creator)) {
				video_Creator = (Video_Creator)session.get(Video_CreatorImpl.class,
						video_Creator.getPrimaryKeyObj());
			}

			if (video_Creator != null) {
				session.delete(video_Creator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video_Creator != null) {
			clearCache(video_Creator);
		}

		return video_Creator;
	}

	@Override
	public Video_Creator updateImpl(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator)
		throws SystemException {
		video_Creator = toUnwrappedModel(video_Creator);

		boolean isNew = video_Creator.isNew();

		Video_CreatorModelImpl video_CreatorModelImpl = (Video_CreatorModelImpl)video_Creator;

		Session session = null;

		try {
			session = openSession();

			if (video_Creator.isNew()) {
				session.save(video_Creator);

				video_Creator.setNew(false);
			}
			else {
				session.merge(video_Creator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Video_CreatorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((video_CreatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_CreatorModelImpl.getOriginalVideoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { video_CreatorModelImpl.getVideoId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}

			if ((video_CreatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_CreatorModelImpl.getOriginalCreatorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR,
					args);

				args = new Object[] { video_CreatorModelImpl.getCreatorId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR,
					args);
			}

			if ((video_CreatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCREATOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_CreatorModelImpl.getOriginalVideoId(),
						video_CreatorModelImpl.getOriginalCreatorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOCREATOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCREATOR,
					args);

				args = new Object[] {
						video_CreatorModelImpl.getVideoId(),
						video_CreatorModelImpl.getCreatorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOCREATOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCREATOR,
					args);
			}
		}

		EntityCacheUtil.putResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorImpl.class, video_Creator.getPrimaryKey(),
			video_Creator);

		return video_Creator;
	}

	protected Video_Creator toUnwrappedModel(Video_Creator video_Creator) {
		if (video_Creator instanceof Video_CreatorImpl) {
			return video_Creator;
		}

		Video_CreatorImpl video_CreatorImpl = new Video_CreatorImpl();

		video_CreatorImpl.setNew(video_Creator.isNew());
		video_CreatorImpl.setPrimaryKey(video_Creator.getPrimaryKey());

		video_CreatorImpl.setVideoCreatorId(video_Creator.getVideoCreatorId());
		video_CreatorImpl.setCreatorId(video_Creator.getCreatorId());
		video_CreatorImpl.setVideoId(video_Creator.getVideoId());

		return video_CreatorImpl;
	}

	/**
	 * Returns the video_ creator with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ creator
	 * @return the video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_CreatorException, SystemException {
		Video_Creator video_Creator = fetchByPrimaryKey(primaryKey);

		if (video_Creator == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_CreatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return video_Creator;
	}

	/**
	 * Returns the video_ creator with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideo_CreatorException} if it could not be found.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator findByPrimaryKey(long videoCreatorId)
		throws NoSuchVideo_CreatorException, SystemException {
		return findByPrimaryKey((Serializable)videoCreatorId);
	}

	/**
	 * Returns the video_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ creator
	 * @return the video_ creator, or <code>null</code> if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Video_Creator video_Creator = (Video_Creator)EntityCacheUtil.getResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
				Video_CreatorImpl.class, primaryKey);

		if (video_Creator == _nullVideo_Creator) {
			return null;
		}

		if (video_Creator == null) {
			Session session = null;

			try {
				session = openSession();

				video_Creator = (Video_Creator)session.get(Video_CreatorImpl.class,
						primaryKey);

				if (video_Creator != null) {
					cacheResult(video_Creator);
				}
				else {
					EntityCacheUtil.putResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
						Video_CreatorImpl.class, primaryKey, _nullVideo_Creator);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
					Video_CreatorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return video_Creator;
	}

	/**
	 * Returns the video_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator, or <code>null</code> if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator fetchByPrimaryKey(long videoCreatorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)videoCreatorId);
	}

	/**
	 * Returns all the video_ creators.
	 *
	 * @return the video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findAll(int start, int end,
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

		List<Video_Creator> list = (List<Video_Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEO_CREATOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_CREATOR;

				if (pagination) {
					sql = sql.concat(Video_CreatorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Creator>(list);
				}
				else {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the video_ creators from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Video_Creator video_Creator : findAll()) {
			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators.
	 *
	 * @return the number of video_ creators
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

				Query q = session.createQuery(_SQL_COUNT_VIDEO_CREATOR);

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
	 * Initializes the video_ creator persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Video_Creator")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Video_Creator>> listenersList = new ArrayList<ModelListener<Video_Creator>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Video_Creator>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Video_CreatorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEO_CREATOR = "SELECT video_Creator FROM Video_Creator video_Creator";
	private static final String _SQL_SELECT_VIDEO_CREATOR_WHERE = "SELECT video_Creator FROM Video_Creator video_Creator WHERE ";
	private static final String _SQL_COUNT_VIDEO_CREATOR = "SELECT COUNT(video_Creator) FROM Video_Creator video_Creator";
	private static final String _SQL_COUNT_VIDEO_CREATOR_WHERE = "SELECT COUNT(video_Creator) FROM Video_Creator video_Creator WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "video_Creator.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Video_Creator exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Video_Creator exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Video_CreatorPersistenceImpl.class);
	private static Video_Creator _nullVideo_Creator = new Video_CreatorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Video_Creator> toCacheModel() {
				return _nullVideo_CreatorCacheModel;
			}
		};

	private static CacheModel<Video_Creator> _nullVideo_CreatorCacheModel = new CacheModel<Video_Creator>() {
			@Override
			public Video_Creator toEntityModel() {
				return _nullVideo_Creator;
			}
		};
}
