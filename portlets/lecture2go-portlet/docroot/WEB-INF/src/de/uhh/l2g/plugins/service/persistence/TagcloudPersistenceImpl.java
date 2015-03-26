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

import de.uhh.l2g.plugins.NoSuchTagcloudException;
import de.uhh.l2g.plugins.model.Tagcloud;
import de.uhh.l2g.plugins.model.impl.TagcloudImpl;
import de.uhh.l2g.plugins.model.impl.TagcloudModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tagcloud service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see TagcloudPersistence
 * @see TagcloudUtil
 * @generated
 */
public class TagcloudPersistenceImpl extends BasePersistenceImpl<Tagcloud>
	implements TagcloudPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TagcloudUtil} to access the tagcloud persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TagcloudImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISVIDEO = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsVideo",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISVIDEO =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsVideo",
			new String[] { Integer.class.getName() },
			TagcloudModelImpl.ISVIDEO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISVIDEO = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsVideo",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the tagclouds where isVideo = &#63;.
	 *
	 * @param isVideo the is video
	 * @return the matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findByIsVideo(int isVideo) throws SystemException {
		return findByIsVideo(isVideo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds where isVideo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isVideo the is video
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findByIsVideo(int isVideo, int start, int end)
		throws SystemException {
		return findByIsVideo(isVideo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds where isVideo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isVideo the is video
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findByIsVideo(int isVideo, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISVIDEO;
			finderArgs = new Object[] { isVideo };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISVIDEO;
			finderArgs = new Object[] { isVideo, start, end, orderByComparator };
		}

		List<Tagcloud> list = (List<Tagcloud>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tagcloud tagcloud : list) {
				if ((isVideo != tagcloud.getIsVideo())) {
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

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_ISVIDEO_ISVIDEO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TagcloudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isVideo);

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tagcloud>(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tagcloud in the ordered set where isVideo = &#63;.
	 *
	 * @param isVideo the is video
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByIsVideo_First(int isVideo,
		OrderByComparator orderByComparator)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = fetchByIsVideo_First(isVideo, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isVideo=");
		msg.append(isVideo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the first tagcloud in the ordered set where isVideo = &#63;.
	 *
	 * @param isVideo the is video
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByIsVideo_First(int isVideo,
		OrderByComparator orderByComparator) throws SystemException {
		List<Tagcloud> list = findByIsVideo(isVideo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tagcloud in the ordered set where isVideo = &#63;.
	 *
	 * @param isVideo the is video
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByIsVideo_Last(int isVideo,
		OrderByComparator orderByComparator)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = fetchByIsVideo_Last(isVideo, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isVideo=");
		msg.append(isVideo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the last tagcloud in the ordered set where isVideo = &#63;.
	 *
	 * @param isVideo the is video
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByIsVideo_Last(int isVideo,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIsVideo(isVideo);

		if (count == 0) {
			return null;
		}

		List<Tagcloud> list = findByIsVideo(isVideo, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where isVideo = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param isVideo the is video
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud[] findByIsVideo_PrevAndNext(long tagcloudId, int isVideo,
		OrderByComparator orderByComparator)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = findByPrimaryKey(tagcloudId);

		Session session = null;

		try {
			session = openSession();

			Tagcloud[] array = new TagcloudImpl[3];

			array[0] = getByIsVideo_PrevAndNext(session, tagcloud, isVideo,
					orderByComparator, true);

			array[1] = tagcloud;

			array[2] = getByIsVideo_PrevAndNext(session, tagcloud, isVideo,
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

	protected Tagcloud getByIsVideo_PrevAndNext(Session session,
		Tagcloud tagcloud, int isVideo, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAGCLOUD_WHERE);

		query.append(_FINDER_COLUMN_ISVIDEO_ISVIDEO_2);

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
			query.append(TagcloudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isVideo);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tagcloud);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tagcloud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tagclouds where isVideo = &#63; from the database.
	 *
	 * @param isVideo the is video
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIsVideo(int isVideo) throws SystemException {
		for (Tagcloud tagcloud : findByIsVideo(isVideo, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds where isVideo = &#63;.
	 *
	 * @param isVideo the is video
	 * @return the number of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIsVideo(int isVideo) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISVIDEO;

		Object[] finderArgs = new Object[] { isVideo };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_ISVIDEO_ISVIDEO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isVideo);

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

	private static final String _FINDER_COLUMN_ISVIDEO_ISVIDEO_2 = "tagcloud.isVideo = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISLECTURESERIES =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsLectureseries",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISLECTURESERIES =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsLectureseries",
			new String[] { Integer.class.getName() },
			TagcloudModelImpl.ISLECTURESERIES_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISLECTURESERIES = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIsLectureseries", new String[] { Integer.class.getName() });

	/**
	 * Returns all the tagclouds where isLectureseries = &#63;.
	 *
	 * @param isLectureseries the is lectureseries
	 * @return the matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findByIsLectureseries(int isLectureseries)
		throws SystemException {
		return findByIsLectureseries(isLectureseries, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds where isLectureseries = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isLectureseries the is lectureseries
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findByIsLectureseries(int isLectureseries, int start,
		int end) throws SystemException {
		return findByIsLectureseries(isLectureseries, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds where isLectureseries = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isLectureseries the is lectureseries
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findByIsLectureseries(int isLectureseries, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISLECTURESERIES;
			finderArgs = new Object[] { isLectureseries };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISLECTURESERIES;
			finderArgs = new Object[] {
					isLectureseries,
					
					start, end, orderByComparator
				};
		}

		List<Tagcloud> list = (List<Tagcloud>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tagcloud tagcloud : list) {
				if ((isLectureseries != tagcloud.getIsLectureseries())) {
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

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_ISLECTURESERIES_ISLECTURESERIES_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TagcloudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isLectureseries);

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tagcloud>(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tagcloud in the ordered set where isLectureseries = &#63;.
	 *
	 * @param isLectureseries the is lectureseries
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByIsLectureseries_First(int isLectureseries,
		OrderByComparator orderByComparator)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = fetchByIsLectureseries_First(isLectureseries,
				orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isLectureseries=");
		msg.append(isLectureseries);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the first tagcloud in the ordered set where isLectureseries = &#63;.
	 *
	 * @param isLectureseries the is lectureseries
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByIsLectureseries_First(int isLectureseries,
		OrderByComparator orderByComparator) throws SystemException {
		List<Tagcloud> list = findByIsLectureseries(isLectureseries, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tagcloud in the ordered set where isLectureseries = &#63;.
	 *
	 * @param isLectureseries the is lectureseries
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByIsLectureseries_Last(int isLectureseries,
		OrderByComparator orderByComparator)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = fetchByIsLectureseries_Last(isLectureseries,
				orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isLectureseries=");
		msg.append(isLectureseries);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the last tagcloud in the ordered set where isLectureseries = &#63;.
	 *
	 * @param isLectureseries the is lectureseries
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByIsLectureseries_Last(int isLectureseries,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIsLectureseries(isLectureseries);

		if (count == 0) {
			return null;
		}

		List<Tagcloud> list = findByIsLectureseries(isLectureseries, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where isLectureseries = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param isLectureseries the is lectureseries
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud[] findByIsLectureseries_PrevAndNext(long tagcloudId,
		int isLectureseries, OrderByComparator orderByComparator)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = findByPrimaryKey(tagcloudId);

		Session session = null;

		try {
			session = openSession();

			Tagcloud[] array = new TagcloudImpl[3];

			array[0] = getByIsLectureseries_PrevAndNext(session, tagcloud,
					isLectureseries, orderByComparator, true);

			array[1] = tagcloud;

			array[2] = getByIsLectureseries_PrevAndNext(session, tagcloud,
					isLectureseries, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tagcloud getByIsLectureseries_PrevAndNext(Session session,
		Tagcloud tagcloud, int isLectureseries,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAGCLOUD_WHERE);

		query.append(_FINDER_COLUMN_ISLECTURESERIES_ISLECTURESERIES_2);

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
			query.append(TagcloudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isLectureseries);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tagcloud);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tagcloud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tagclouds where isLectureseries = &#63; from the database.
	 *
	 * @param isLectureseries the is lectureseries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIsLectureseries(int isLectureseries)
		throws SystemException {
		for (Tagcloud tagcloud : findByIsLectureseries(isLectureseries,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds where isLectureseries = &#63;.
	 *
	 * @param isLectureseries the is lectureseries
	 * @return the number of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIsLectureseries(int isLectureseries)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISLECTURESERIES;

		Object[] finderArgs = new Object[] { isLectureseries };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_ISLECTURESERIES_ISLECTURESERIES_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isLectureseries);

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

	private static final String _FINDER_COLUMN_ISLECTURESERIES_ISLECTURESERIES_2 =
		"tagcloud.isLectureseries = ?";

	public TagcloudPersistenceImpl() {
		setModelClass(Tagcloud.class);
	}

	/**
	 * Caches the tagcloud in the entity cache if it is enabled.
	 *
	 * @param tagcloud the tagcloud
	 */
	@Override
	public void cacheResult(Tagcloud tagcloud) {
		EntityCacheUtil.putResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudImpl.class, tagcloud.getPrimaryKey(), tagcloud);

		tagcloud.resetOriginalValues();
	}

	/**
	 * Caches the tagclouds in the entity cache if it is enabled.
	 *
	 * @param tagclouds the tagclouds
	 */
	@Override
	public void cacheResult(List<Tagcloud> tagclouds) {
		for (Tagcloud tagcloud : tagclouds) {
			if (EntityCacheUtil.getResult(
						TagcloudModelImpl.ENTITY_CACHE_ENABLED,
						TagcloudImpl.class, tagcloud.getPrimaryKey()) == null) {
				cacheResult(tagcloud);
			}
			else {
				tagcloud.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tagclouds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TagcloudImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TagcloudImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tagcloud.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tagcloud tagcloud) {
		EntityCacheUtil.removeResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudImpl.class, tagcloud.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Tagcloud> tagclouds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Tagcloud tagcloud : tagclouds) {
			EntityCacheUtil.removeResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
				TagcloudImpl.class, tagcloud.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tagcloud with the primary key. Does not add the tagcloud to the database.
	 *
	 * @param tagcloudId the primary key for the new tagcloud
	 * @return the new tagcloud
	 */
	@Override
	public Tagcloud create(long tagcloudId) {
		Tagcloud tagcloud = new TagcloudImpl();

		tagcloud.setNew(true);
		tagcloud.setPrimaryKey(tagcloudId);

		return tagcloud;
	}

	/**
	 * Removes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud remove(long tagcloudId)
		throws NoSuchTagcloudException, SystemException {
		return remove((Serializable)tagcloudId);
	}

	/**
	 * Removes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tagcloud
	 * @return the tagcloud that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud remove(Serializable primaryKey)
		throws NoSuchTagcloudException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Tagcloud tagcloud = (Tagcloud)session.get(TagcloudImpl.class,
					primaryKey);

			if (tagcloud == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTagcloudException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tagcloud);
		}
		catch (NoSuchTagcloudException nsee) {
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
	protected Tagcloud removeImpl(Tagcloud tagcloud) throws SystemException {
		tagcloud = toUnwrappedModel(tagcloud);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tagcloud)) {
				tagcloud = (Tagcloud)session.get(TagcloudImpl.class,
						tagcloud.getPrimaryKeyObj());
			}

			if (tagcloud != null) {
				session.delete(tagcloud);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tagcloud != null) {
			clearCache(tagcloud);
		}

		return tagcloud;
	}

	@Override
	public Tagcloud updateImpl(de.uhh.l2g.plugins.model.Tagcloud tagcloud)
		throws SystemException {
		tagcloud = toUnwrappedModel(tagcloud);

		boolean isNew = tagcloud.isNew();

		TagcloudModelImpl tagcloudModelImpl = (TagcloudModelImpl)tagcloud;

		Session session = null;

		try {
			session = openSession();

			if (tagcloud.isNew()) {
				session.save(tagcloud);

				tagcloud.setNew(false);
			}
			else {
				session.merge(tagcloud);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TagcloudModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tagcloudModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISVIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tagcloudModelImpl.getOriginalIsVideo()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISVIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISVIDEO,
					args);

				args = new Object[] { tagcloudModelImpl.getIsVideo() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISVIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISVIDEO,
					args);
			}

			if ((tagcloudModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISLECTURESERIES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tagcloudModelImpl.getOriginalIsLectureseries()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISLECTURESERIES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISLECTURESERIES,
					args);

				args = new Object[] { tagcloudModelImpl.getIsLectureseries() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISLECTURESERIES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISLECTURESERIES,
					args);
			}
		}

		EntityCacheUtil.putResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudImpl.class, tagcloud.getPrimaryKey(), tagcloud);

		return tagcloud;
	}

	protected Tagcloud toUnwrappedModel(Tagcloud tagcloud) {
		if (tagcloud instanceof TagcloudImpl) {
			return tagcloud;
		}

		TagcloudImpl tagcloudImpl = new TagcloudImpl();

		tagcloudImpl.setNew(tagcloud.isNew());
		tagcloudImpl.setPrimaryKey(tagcloud.getPrimaryKey());

		tagcloudImpl.setTagcloudId(tagcloud.getTagcloudId());
		tagcloudImpl.setIsVideo(tagcloud.getIsVideo());
		tagcloudImpl.setIsLectureseries(tagcloud.getIsLectureseries());
		tagcloudImpl.setTags(tagcloud.getTags());

		return tagcloudImpl;
	}

	/**
	 * Returns the tagcloud with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tagcloud
	 * @return the tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = fetchByPrimaryKey(primaryKey);

		if (tagcloud == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTagcloudException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tagcloud;
	}

	/**
	 * Returns the tagcloud with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchTagcloudException} if it could not be found.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByPrimaryKey(long tagcloudId)
		throws NoSuchTagcloudException, SystemException {
		return findByPrimaryKey((Serializable)tagcloudId);
	}

	/**
	 * Returns the tagcloud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tagcloud
	 * @return the tagcloud, or <code>null</code> if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Tagcloud tagcloud = (Tagcloud)EntityCacheUtil.getResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
				TagcloudImpl.class, primaryKey);

		if (tagcloud == _nullTagcloud) {
			return null;
		}

		if (tagcloud == null) {
			Session session = null;

			try {
				session = openSession();

				tagcloud = (Tagcloud)session.get(TagcloudImpl.class, primaryKey);

				if (tagcloud != null) {
					cacheResult(tagcloud);
				}
				else {
					EntityCacheUtil.putResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
						TagcloudImpl.class, primaryKey, _nullTagcloud);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
					TagcloudImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tagcloud;
	}

	/**
	 * Returns the tagcloud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud, or <code>null</code> if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByPrimaryKey(long tagcloudId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)tagcloudId);
	}

	/**
	 * Returns all the tagclouds.
	 *
	 * @return the tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findAll(int start, int end,
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

		List<Tagcloud> list = (List<Tagcloud>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAGCLOUD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAGCLOUD;

				if (pagination) {
					sql = sql.concat(TagcloudModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tagcloud>(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tagclouds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Tagcloud tagcloud : findAll()) {
			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds.
	 *
	 * @return the number of tagclouds
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

				Query q = session.createQuery(_SQL_COUNT_TAGCLOUD);

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
	 * Initializes the tagcloud persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Tagcloud")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Tagcloud>> listenersList = new ArrayList<ModelListener<Tagcloud>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Tagcloud>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TagcloudImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAGCLOUD = "SELECT tagcloud FROM Tagcloud tagcloud";
	private static final String _SQL_SELECT_TAGCLOUD_WHERE = "SELECT tagcloud FROM Tagcloud tagcloud WHERE ";
	private static final String _SQL_COUNT_TAGCLOUD = "SELECT COUNT(tagcloud) FROM Tagcloud tagcloud";
	private static final String _SQL_COUNT_TAGCLOUD_WHERE = "SELECT COUNT(tagcloud) FROM Tagcloud tagcloud WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tagcloud.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Tagcloud exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Tagcloud exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TagcloudPersistenceImpl.class);
	private static Tagcloud _nullTagcloud = new TagcloudImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Tagcloud> toCacheModel() {
				return _nullTagcloudCacheModel;
			}
		};

	private static CacheModel<Tagcloud> _nullTagcloudCacheModel = new CacheModel<Tagcloud>() {
			@Override
			public Tagcloud toEntityModel() {
				return _nullTagcloud;
			}
		};
}