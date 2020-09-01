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

import de.uhh.l2g.plugins.NoSuchVideo_CategoryException;
import de.uhh.l2g.plugins.model.Video_Category;
import de.uhh.l2g.plugins.model.impl.Video_CategoryImpl;
import de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_CategoryPersistence
 * @see Video_CategoryUtil
 * @generated
 */
public class Video_CategoryPersistenceImpl extends BasePersistenceImpl<Video_Category>
	implements Video_CategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Video_CategoryUtil} to access the video_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Video_CategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] { Long.class.getName() },
			Video_CategoryModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ categories where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Category> findByVideo(long videoId)
		throws SystemException {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ categories where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of matching video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Category> findByVideo(long videoId, int start, int end)
		throws SystemException {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ categories where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Category> findByVideo(long videoId, int start, int end,
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

		List<Video_Category> list = (List<Video_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Category video_Category : list) {
				if ((videoId != video_Category.getVideoId())) {
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

			query.append(_SQL_SELECT_VIDEO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Video_Category>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Category>(list);
				}
				else {
					list = (List<Video_Category>)QueryUtil.list(q,
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
	 * Returns the first video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a matching video_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category findByVideo_First(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_CategoryException, SystemException {
		Video_Category video_Category = fetchByVideo_First(videoId,
				orderByComparator);

		if (video_Category != null) {
			return video_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CategoryException(msg.toString());
	}

	/**
	 * Returns the first video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category fetchByVideo_First(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Video_Category> list = findByVideo(videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a matching video_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category findByVideo_Last(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_CategoryException, SystemException {
		Video_Category video_Category = fetchByVideo_Last(videoId,
				orderByComparator);

		if (video_Category != null) {
			return video_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CategoryException(msg.toString());
	}

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category fetchByVideo_Last(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Video_Category> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ categories before and after the current video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoCategoryId the primary key of the current video_ category
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ category
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category[] findByVideo_PrevAndNext(long videoCategoryId,
		long videoId, OrderByComparator orderByComparator)
		throws NoSuchVideo_CategoryException, SystemException {
		Video_Category video_Category = findByPrimaryKey(videoCategoryId);

		Session session = null;

		try {
			session = openSession();

			Video_Category[] array = new Video_CategoryImpl[3];

			array[0] = getByVideo_PrevAndNext(session, video_Category, videoId,
					orderByComparator, true);

			array[1] = video_Category;

			array[2] = getByVideo_PrevAndNext(session, video_Category, videoId,
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

	protected Video_Category getByVideo_PrevAndNext(Session session,
		Video_Category video_Category, long videoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_CATEGORY_WHERE);

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
			query.append(Video_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ categories where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideo(long videoId) throws SystemException {
		for (Video_Category video_Category : findByVideo(videoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Category);
		}
	}

	/**
	 * Returns the number of video_ categories where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ categories
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

			query.append(_SQL_COUNT_VIDEO_CATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "video_Category.videoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategory",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName() },
			Video_CategoryModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Category> findByCategory(long categoryId)
		throws SystemException {
		return findByCategory(categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the video_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of matching video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Category> findByCategory(long categoryId, int start,
		int end) throws SystemException {
		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Category> findByCategory(long categoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<Video_Category> list = (List<Video_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Category video_Category : list) {
				if ((categoryId != video_Category.getCategoryId())) {
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

			query.append(_SQL_SELECT_VIDEO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<Video_Category>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Category>(list);
				}
				else {
					list = (List<Video_Category>)QueryUtil.list(q,
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
	 * Returns the first video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a matching video_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category findByCategory_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_CategoryException, SystemException {
		Video_Category video_Category = fetchByCategory_First(categoryId,
				orderByComparator);

		if (video_Category != null) {
			return video_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CategoryException(msg.toString());
	}

	/**
	 * Returns the first video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category fetchByCategory_First(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Video_Category> list = findByCategory(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a matching video_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category findByCategory_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_CategoryException, SystemException {
		Video_Category video_Category = fetchByCategory_Last(categoryId,
				orderByComparator);

		if (video_Category != null) {
			return video_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CategoryException(msg.toString());
	}

	/**
	 * Returns the last video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category fetchByCategory_Last(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(categoryId);

		if (count == 0) {
			return null;
		}

		List<Video_Category> list = findByCategory(categoryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ categories before and after the current video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param videoCategoryId the primary key of the current video_ category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ category
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category[] findByCategory_PrevAndNext(long videoCategoryId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchVideo_CategoryException, SystemException {
		Video_Category video_Category = findByPrimaryKey(videoCategoryId);

		Session session = null;

		try {
			session = openSession();

			Video_Category[] array = new Video_CategoryImpl[3];

			array[0] = getByCategory_PrevAndNext(session, video_Category,
					categoryId, orderByComparator, true);

			array[1] = video_Category;

			array[2] = getByCategory_PrevAndNext(session, video_Category,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Category getByCategory_PrevAndNext(Session session,
		Video_Category video_Category, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

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
			query.append(Video_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategory(long categoryId) throws SystemException {
		for (Video_Category video_Category : findByCategory(categoryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Category);
		}
	}

	/**
	 * Returns the number of video_ categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategory(long categoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "video_Category.categoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOCATEGORY =
		new FinderPath(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideoCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCATEGORY =
		new FinderPath(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideoCategory",
			new String[] { Long.class.getName(), Long.class.getName() },
			Video_CategoryModelImpl.VIDEOID_COLUMN_BITMASK |
			Video_CategoryModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOCATEGORY = new FinderPath(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideoCategory",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @return the matching video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Category> findByVideoCategory(long videoId,
		long categoryId) throws SystemException {
		return findByVideoCategory(videoId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of matching video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Category> findByVideoCategory(long videoId,
		long categoryId, int start, int end) throws SystemException {
		return findByVideoCategory(videoId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Category> findByVideoCategory(long videoId,
		long categoryId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCATEGORY;
			finderArgs = new Object[] { videoId, categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOCATEGORY;
			finderArgs = new Object[] {
					videoId, categoryId,
					
					start, end, orderByComparator
				};
		}

		List<Video_Category> list = (List<Video_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Category video_Category : list) {
				if ((videoId != video_Category.getVideoId()) ||
						(categoryId != video_Category.getCategoryId())) {
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

			query.append(_SQL_SELECT_VIDEO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOCATEGORY_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOCATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<Video_Category>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Category>(list);
				}
				else {
					list = (List<Video_Category>)QueryUtil.list(q,
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
	 * Returns the first video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a matching video_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category findByVideoCategory_First(long videoId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchVideo_CategoryException, SystemException {
		Video_Category video_Category = fetchByVideoCategory_First(videoId,
				categoryId, orderByComparator);

		if (video_Category != null) {
			return video_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CategoryException(msg.toString());
	}

	/**
	 * Returns the first video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category fetchByVideoCategory_First(long videoId,
		long categoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Video_Category> list = findByVideoCategory(videoId, categoryId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a matching video_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category findByVideoCategory_Last(long videoId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchVideo_CategoryException, SystemException {
		Video_Category video_Category = fetchByVideoCategory_Last(videoId,
				categoryId, orderByComparator);

		if (video_Category != null) {
			return video_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CategoryException(msg.toString());
	}

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category fetchByVideoCategory_Last(long videoId,
		long categoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByVideoCategory(videoId, categoryId);

		if (count == 0) {
			return null;
		}

		List<Video_Category> list = findByVideoCategory(videoId, categoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ categories before and after the current video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoCategoryId the primary key of the current video_ category
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ category
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category[] findByVideoCategory_PrevAndNext(
		long videoCategoryId, long videoId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchVideo_CategoryException, SystemException {
		Video_Category video_Category = findByPrimaryKey(videoCategoryId);

		Session session = null;

		try {
			session = openSession();

			Video_Category[] array = new Video_CategoryImpl[3];

			array[0] = getByVideoCategory_PrevAndNext(session, video_Category,
					videoId, categoryId, orderByComparator, true);

			array[1] = video_Category;

			array[2] = getByVideoCategory_PrevAndNext(session, video_Category,
					videoId, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Category getByVideoCategory_PrevAndNext(Session session,
		Video_Category video_Category, long videoId, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_VIDEOCATEGORY_VIDEOID_2);

		query.append(_FINDER_COLUMN_VIDEOCATEGORY_CATEGORYID_2);

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
			query.append(Video_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ categories where videoId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideoCategory(long videoId, long categoryId)
		throws SystemException {
		for (Video_Category video_Category : findByVideoCategory(videoId,
				categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Category);
		}
	}

	/**
	 * Returns the number of video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @return the number of matching video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVideoCategory(long videoId, long categoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEOCATEGORY;

		Object[] finderArgs = new Object[] { videoId, categoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOCATEGORY_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOCATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_VIDEOCATEGORY_VIDEOID_2 = "video_Category.videoId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEOCATEGORY_CATEGORYID_2 = "video_Category.categoryId = ?";

	public Video_CategoryPersistenceImpl() {
		setModelClass(Video_Category.class);
	}

	/**
	 * Caches the video_ category in the entity cache if it is enabled.
	 *
	 * @param video_Category the video_ category
	 */
	@Override
	public void cacheResult(Video_Category video_Category) {
		EntityCacheUtil.putResult(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryImpl.class, video_Category.getPrimaryKey(),
			video_Category);

		video_Category.resetOriginalValues();
	}

	/**
	 * Caches the video_ categories in the entity cache if it is enabled.
	 *
	 * @param video_Categories the video_ categories
	 */
	@Override
	public void cacheResult(List<Video_Category> video_Categories) {
		for (Video_Category video_Category : video_Categories) {
			if (EntityCacheUtil.getResult(
						Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						Video_CategoryImpl.class, video_Category.getPrimaryKey()) == null) {
				cacheResult(video_Category);
			}
			else {
				video_Category.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Video_CategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Video_CategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_Category video_Category) {
		EntityCacheUtil.removeResult(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryImpl.class, video_Category.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_Category> video_Categories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_Category video_Category : video_Categories) {
			EntityCacheUtil.removeResult(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				Video_CategoryImpl.class, video_Category.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video_ category with the primary key. Does not add the video_ category to the database.
	 *
	 * @param videoCategoryId the primary key for the new video_ category
	 * @return the new video_ category
	 */
	@Override
	public Video_Category create(long videoCategoryId) {
		Video_Category video_Category = new Video_CategoryImpl();

		video_Category.setNew(true);
		video_Category.setPrimaryKey(videoCategoryId);

		return video_Category;
	}

	/**
	 * Removes the video_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category remove(long videoCategoryId)
		throws NoSuchVideo_CategoryException, SystemException {
		return remove((Serializable)videoCategoryId);
	}

	/**
	 * Removes the video_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ category
	 * @return the video_ category that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category remove(Serializable primaryKey)
		throws NoSuchVideo_CategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Video_Category video_Category = (Video_Category)session.get(Video_CategoryImpl.class,
					primaryKey);

			if (video_Category == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(video_Category);
		}
		catch (NoSuchVideo_CategoryException nsee) {
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
	protected Video_Category removeImpl(Video_Category video_Category)
		throws SystemException {
		video_Category = toUnwrappedModel(video_Category);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_Category)) {
				video_Category = (Video_Category)session.get(Video_CategoryImpl.class,
						video_Category.getPrimaryKeyObj());
			}

			if (video_Category != null) {
				session.delete(video_Category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video_Category != null) {
			clearCache(video_Category);
		}

		return video_Category;
	}

	@Override
	public Video_Category updateImpl(
		de.uhh.l2g.plugins.model.Video_Category video_Category)
		throws SystemException {
		video_Category = toUnwrappedModel(video_Category);

		boolean isNew = video_Category.isNew();

		Video_CategoryModelImpl video_CategoryModelImpl = (Video_CategoryModelImpl)video_Category;

		Session session = null;

		try {
			session = openSession();

			if (video_Category.isNew()) {
				session.save(video_Category);

				video_Category.setNew(false);
			}
			else {
				session.merge(video_Category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Video_CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((video_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_CategoryModelImpl.getOriginalVideoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { video_CategoryModelImpl.getVideoId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}

			if ((video_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_CategoryModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] { video_CategoryModelImpl.getCategoryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}

			if ((video_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_CategoryModelImpl.getOriginalVideoId(),
						video_CategoryModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCATEGORY,
					args);

				args = new Object[] {
						video_CategoryModelImpl.getVideoId(),
						video_CategoryModelImpl.getCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryImpl.class, video_Category.getPrimaryKey(),
			video_Category);

		return video_Category;
	}

	protected Video_Category toUnwrappedModel(Video_Category video_Category) {
		if (video_Category instanceof Video_CategoryImpl) {
			return video_Category;
		}

		Video_CategoryImpl video_CategoryImpl = new Video_CategoryImpl();

		video_CategoryImpl.setNew(video_Category.isNew());
		video_CategoryImpl.setPrimaryKey(video_Category.getPrimaryKey());

		video_CategoryImpl.setVideoCategoryId(video_Category.getVideoCategoryId());
		video_CategoryImpl.setVideoId(video_Category.getVideoId());
		video_CategoryImpl.setCategoryId(video_Category.getCategoryId());

		return video_CategoryImpl;
	}

	/**
	 * Returns the video_ category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ category
	 * @return the video_ category
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_CategoryException, SystemException {
		Video_Category video_Category = fetchByPrimaryKey(primaryKey);

		if (video_Category == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return video_Category;
	}

	/**
	 * Returns the video_ category with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideo_CategoryException} if it could not be found.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category findByPrimaryKey(long videoCategoryId)
		throws NoSuchVideo_CategoryException, SystemException {
		return findByPrimaryKey((Serializable)videoCategoryId);
	}

	/**
	 * Returns the video_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ category
	 * @return the video_ category, or <code>null</code> if a video_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Video_Category video_Category = (Video_Category)EntityCacheUtil.getResult(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				Video_CategoryImpl.class, primaryKey);

		if (video_Category == _nullVideo_Category) {
			return null;
		}

		if (video_Category == null) {
			Session session = null;

			try {
				session = openSession();

				video_Category = (Video_Category)session.get(Video_CategoryImpl.class,
						primaryKey);

				if (video_Category != null) {
					cacheResult(video_Category);
				}
				else {
					EntityCacheUtil.putResult(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						Video_CategoryImpl.class, primaryKey,
						_nullVideo_Category);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
					Video_CategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return video_Category;
	}

	/**
	 * Returns the video_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category, or <code>null</code> if a video_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Category fetchByPrimaryKey(long videoCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)videoCategoryId);
	}

	/**
	 * Returns all the video_ categories.
	 *
	 * @return the video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Category> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Category> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Category> findAll(int start, int end,
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

		List<Video_Category> list = (List<Video_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEO_CATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_CATEGORY;

				if (pagination) {
					sql = sql.concat(Video_CategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video_Category>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Category>(list);
				}
				else {
					list = (List<Video_Category>)QueryUtil.list(q,
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
	 * Removes all the video_ categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Video_Category video_Category : findAll()) {
			remove(video_Category);
		}
	}

	/**
	 * Returns the number of video_ categories.
	 *
	 * @return the number of video_ categories
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

				Query q = session.createQuery(_SQL_COUNT_VIDEO_CATEGORY);

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
	 * Initializes the video_ category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Video_Category")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Video_Category>> listenersList = new ArrayList<ModelListener<Video_Category>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Video_Category>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Video_CategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEO_CATEGORY = "SELECT video_Category FROM Video_Category video_Category";
	private static final String _SQL_SELECT_VIDEO_CATEGORY_WHERE = "SELECT video_Category FROM Video_Category video_Category WHERE ";
	private static final String _SQL_COUNT_VIDEO_CATEGORY = "SELECT COUNT(video_Category) FROM Video_Category video_Category";
	private static final String _SQL_COUNT_VIDEO_CATEGORY_WHERE = "SELECT COUNT(video_Category) FROM Video_Category video_Category WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "video_Category.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Video_Category exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Video_Category exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Video_CategoryPersistenceImpl.class);
	private static Video_Category _nullVideo_Category = new Video_CategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Video_Category> toCacheModel() {
				return _nullVideo_CategoryCacheModel;
			}
		};

	private static CacheModel<Video_Category> _nullVideo_CategoryCacheModel = new CacheModel<Video_Category>() {
			@Override
			public Video_Category toEntityModel() {
				return _nullVideo_Category;
			}
		};
}
