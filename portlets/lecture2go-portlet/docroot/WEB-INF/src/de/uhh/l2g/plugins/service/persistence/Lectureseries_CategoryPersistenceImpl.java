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

import de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException;
import de.uhh.l2g.plugins.model.Lectureseries_Category;
import de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryImpl;
import de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the lectureseries_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_CategoryPersistence
 * @see Lectureseries_CategoryUtil
 * @generated
 */
public class Lectureseries_CategoryPersistenceImpl extends BasePersistenceImpl<Lectureseries_Category>
	implements Lectureseries_CategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Lectureseries_CategoryUtil} to access the lectureseries_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Lectureseries_CategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseries",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseries",
			new String[] { Long.class.getName() },
			Lectureseries_CategoryModelImpl.LECTURESERIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIES = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLectureseries",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureseries_ categories where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching lectureseries_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Category> findByLectureseries(
		long lectureseriesId) throws SystemException {
		return findByLectureseries(lectureseriesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ categories where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @return the range of matching lectureseries_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Category> findByLectureseries(
		long lectureseriesId, int start, int end) throws SystemException {
		return findByLectureseries(lectureseriesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ categories where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Category> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Lectureseries_Category> list = (List<Lectureseries_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Lectureseries_Category lectureseries_Category : list) {
				if ((lectureseriesId != lectureseries_Category.getLectureseriesId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Category>(list);
				}
				else {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ category
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category findByLectureseries_First(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_CategoryException, SystemException {
		Lectureseries_Category lectureseries_Category = fetchByLectureseries_First(lectureseriesId,
				orderByComparator);

		if (lectureseries_Category != null) {
			return lectureseries_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CategoryException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category fetchByLectureseries_First(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Lectureseries_Category> list = findByLectureseries(lectureseriesId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ category
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category findByLectureseries_Last(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_CategoryException, SystemException {
		Lectureseries_Category lectureseries_Category = fetchByLectureseries_Last(lectureseriesId,
				orderByComparator);

		if (lectureseries_Category != null) {
			return lectureseries_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CategoryException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category fetchByLectureseries_Last(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLectureseries(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Category> list = findByLectureseries(lectureseriesId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ categories before and after the current lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesCategoryId the primary key of the current lectureseries_ category
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ category
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category[] findByLectureseries_PrevAndNext(
		long lectureseriesCategoryId, long lectureseriesId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_CategoryException, SystemException {
		Lectureseries_Category lectureseries_Category = findByPrimaryKey(lectureseriesCategoryId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Category[] array = new Lectureseries_CategoryImpl[3];

			array[0] = getByLectureseries_PrevAndNext(session,
					lectureseries_Category, lectureseriesId, orderByComparator,
					true);

			array[1] = lectureseries_Category;

			array[2] = getByLectureseries_PrevAndNext(session,
					lectureseries_Category, lectureseriesId, orderByComparator,
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

	protected Lectureseries_Category getByLectureseries_PrevAndNext(
		Session session, Lectureseries_Category lectureseries_Category,
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

		query.append(_SQL_SELECT_LECTURESERIES_CATEGORY_WHERE);

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
			query.append(Lectureseries_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ categories where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLectureseries(long lectureseriesId)
		throws SystemException {
		for (Lectureseries_Category lectureseries_Category : findByLectureseries(
				lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Category);
		}
	}

	/**
	 * Returns the number of lectureseries_ categories where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching lectureseries_ categories
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

			query.append(_SQL_COUNT_LECTURESERIES_CATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2 = "lectureseries_Category.lectureseriesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName() },
			Lectureseries_CategoryModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureseries_ categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching lectureseries_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Category> findByCategory(long categoryId)
		throws SystemException {
		return findByCategory(categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the lectureseries_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @return the range of matching lectureseries_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Category> findByCategory(long categoryId,
		int start, int end) throws SystemException {
		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Category> findByCategory(long categoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<Lectureseries_Category> list = (List<Lectureseries_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Lectureseries_Category lectureseries_Category : list) {
				if ((categoryId != lectureseries_Category.getCategoryId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Category>(list);
				}
				else {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ category
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category findByCategory_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_CategoryException, SystemException {
		Lectureseries_Category lectureseries_Category = fetchByCategory_First(categoryId,
				orderByComparator);

		if (lectureseries_Category != null) {
			return lectureseries_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CategoryException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category fetchByCategory_First(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Lectureseries_Category> list = findByCategory(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ category
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category findByCategory_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_CategoryException, SystemException {
		Lectureseries_Category lectureseries_Category = fetchByCategory_Last(categoryId,
				orderByComparator);

		if (lectureseries_Category != null) {
			return lectureseries_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CategoryException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category fetchByCategory_Last(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(categoryId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Category> list = findByCategory(categoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ categories before and after the current lectureseries_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param lectureseriesCategoryId the primary key of the current lectureseries_ category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ category
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category[] findByCategory_PrevAndNext(
		long lectureseriesCategoryId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_CategoryException, SystemException {
		Lectureseries_Category lectureseries_Category = findByPrimaryKey(lectureseriesCategoryId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Category[] array = new Lectureseries_CategoryImpl[3];

			array[0] = getByCategory_PrevAndNext(session,
					lectureseries_Category, categoryId, orderByComparator, true);

			array[1] = lectureseries_Category;

			array[2] = getByCategory_PrevAndNext(session,
					lectureseries_Category, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lectureseries_Category getByCategory_PrevAndNext(
		Session session, Lectureseries_Category lectureseries_Category,
		long categoryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_CATEGORY_WHERE);

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
			query.append(Lectureseries_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Category);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategory(long categoryId) throws SystemException {
		for (Lectureseries_Category lectureseries_Category : findByCategory(
				categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Category);
		}
	}

	/**
	 * Returns the number of lectureseries_ categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching lectureseries_ categories
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

			query.append(_SQL_COUNT_LECTURESERIES_CATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "lectureseries_Category.categoryId = ?";

	public Lectureseries_CategoryPersistenceImpl() {
		setModelClass(Lectureseries_Category.class);
	}

	/**
	 * Caches the lectureseries_ category in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Category the lectureseries_ category
	 */
	@Override
	public void cacheResult(Lectureseries_Category lectureseries_Category) {
		EntityCacheUtil.putResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			lectureseries_Category.getPrimaryKey(), lectureseries_Category);

		lectureseries_Category.resetOriginalValues();
	}

	/**
	 * Caches the lectureseries_ categories in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Categories the lectureseries_ categories
	 */
	@Override
	public void cacheResult(
		List<Lectureseries_Category> lectureseries_Categories) {
		for (Lectureseries_Category lectureseries_Category : lectureseries_Categories) {
			if (EntityCacheUtil.getResult(
						Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						Lectureseries_CategoryImpl.class,
						lectureseries_Category.getPrimaryKey()) == null) {
				cacheResult(lectureseries_Category);
			}
			else {
				lectureseries_Category.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lectureseries_ categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Lectureseries_CategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Lectureseries_CategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lectureseries_ category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lectureseries_Category lectureseries_Category) {
		EntityCacheUtil.removeResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			lectureseries_Category.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Lectureseries_Category> lectureseries_Categories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lectureseries_Category lectureseries_Category : lectureseries_Categories) {
			EntityCacheUtil.removeResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				Lectureseries_CategoryImpl.class,
				lectureseries_Category.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lectureseries_ category with the primary key. Does not add the lectureseries_ category to the database.
	 *
	 * @param lectureseriesCategoryId the primary key for the new lectureseries_ category
	 * @return the new lectureseries_ category
	 */
	@Override
	public Lectureseries_Category create(long lectureseriesCategoryId) {
		Lectureseries_Category lectureseries_Category = new Lectureseries_CategoryImpl();

		lectureseries_Category.setNew(true);
		lectureseries_Category.setPrimaryKey(lectureseriesCategoryId);

		return lectureseries_Category;
	}

	/**
	 * Removes the lectureseries_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesCategoryId the primary key of the lectureseries_ category
	 * @return the lectureseries_ category that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category remove(long lectureseriesCategoryId)
		throws NoSuchLectureseries_CategoryException, SystemException {
		return remove((Serializable)lectureseriesCategoryId);
	}

	/**
	 * Removes the lectureseries_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lectureseries_ category
	 * @return the lectureseries_ category that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category remove(Serializable primaryKey)
		throws NoSuchLectureseries_CategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Lectureseries_Category lectureseries_Category = (Lectureseries_Category)session.get(Lectureseries_CategoryImpl.class,
					primaryKey);

			if (lectureseries_Category == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLectureseries_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lectureseries_Category);
		}
		catch (NoSuchLectureseries_CategoryException nsee) {
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
	protected Lectureseries_Category removeImpl(
		Lectureseries_Category lectureseries_Category)
		throws SystemException {
		lectureseries_Category = toUnwrappedModel(lectureseries_Category);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lectureseries_Category)) {
				lectureseries_Category = (Lectureseries_Category)session.get(Lectureseries_CategoryImpl.class,
						lectureseries_Category.getPrimaryKeyObj());
			}

			if (lectureseries_Category != null) {
				session.delete(lectureseries_Category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lectureseries_Category != null) {
			clearCache(lectureseries_Category);
		}

		return lectureseries_Category;
	}

	@Override
	public Lectureseries_Category updateImpl(
		de.uhh.l2g.plugins.model.Lectureseries_Category lectureseries_Category)
		throws SystemException {
		lectureseries_Category = toUnwrappedModel(lectureseries_Category);

		boolean isNew = lectureseries_Category.isNew();

		Lectureseries_CategoryModelImpl lectureseries_CategoryModelImpl = (Lectureseries_CategoryModelImpl)lectureseries_Category;

		Session session = null;

		try {
			session = openSession();

			if (lectureseries_Category.isNew()) {
				session.save(lectureseries_Category);

				lectureseries_Category.setNew(false);
			}
			else {
				session.merge(lectureseries_Category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Lectureseries_CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lectureseries_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_CategoryModelImpl.getOriginalLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);

				args = new Object[] {
						lectureseries_CategoryModelImpl.getLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);
			}

			if ((lectureseries_CategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_CategoryModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] {
						lectureseries_CategoryModelImpl.getCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CategoryImpl.class,
			lectureseries_Category.getPrimaryKey(), lectureseries_Category);

		return lectureseries_Category;
	}

	protected Lectureseries_Category toUnwrappedModel(
		Lectureseries_Category lectureseries_Category) {
		if (lectureseries_Category instanceof Lectureseries_CategoryImpl) {
			return lectureseries_Category;
		}

		Lectureseries_CategoryImpl lectureseries_CategoryImpl = new Lectureseries_CategoryImpl();

		lectureseries_CategoryImpl.setNew(lectureseries_Category.isNew());
		lectureseries_CategoryImpl.setPrimaryKey(lectureseries_Category.getPrimaryKey());

		lectureseries_CategoryImpl.setLectureseriesCategoryId(lectureseries_Category.getLectureseriesCategoryId());
		lectureseries_CategoryImpl.setCategoryId(lectureseries_Category.getCategoryId());
		lectureseries_CategoryImpl.setLectureseriesId(lectureseries_Category.getLectureseriesId());

		return lectureseries_CategoryImpl;
	}

	/**
	 * Returns the lectureseries_ category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries_ category
	 * @return the lectureseries_ category
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLectureseries_CategoryException, SystemException {
		Lectureseries_Category lectureseries_Category = fetchByPrimaryKey(primaryKey);

		if (lectureseries_Category == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLectureseries_CategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lectureseries_Category;
	}

	/**
	 * Returns the lectureseries_ category with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException} if it could not be found.
	 *
	 * @param lectureseriesCategoryId the primary key of the lectureseries_ category
	 * @return the lectureseries_ category
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category findByPrimaryKey(long lectureseriesCategoryId)
		throws NoSuchLectureseries_CategoryException, SystemException {
		return findByPrimaryKey((Serializable)lectureseriesCategoryId);
	}

	/**
	 * Returns the lectureseries_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries_ category
	 * @return the lectureseries_ category, or <code>null</code> if a lectureseries_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Lectureseries_Category lectureseries_Category = (Lectureseries_Category)EntityCacheUtil.getResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				Lectureseries_CategoryImpl.class, primaryKey);

		if (lectureseries_Category == _nullLectureseries_Category) {
			return null;
		}

		if (lectureseries_Category == null) {
			Session session = null;

			try {
				session = openSession();

				lectureseries_Category = (Lectureseries_Category)session.get(Lectureseries_CategoryImpl.class,
						primaryKey);

				if (lectureseries_Category != null) {
					cacheResult(lectureseries_Category);
				}
				else {
					EntityCacheUtil.putResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
						Lectureseries_CategoryImpl.class, primaryKey,
						_nullLectureseries_Category);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Lectureseries_CategoryModelImpl.ENTITY_CACHE_ENABLED,
					Lectureseries_CategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lectureseries_Category;
	}

	/**
	 * Returns the lectureseries_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesCategoryId the primary key of the lectureseries_ category
	 * @return the lectureseries_ category, or <code>null</code> if a lectureseries_ category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Category fetchByPrimaryKey(
		long lectureseriesCategoryId) throws SystemException {
		return fetchByPrimaryKey((Serializable)lectureseriesCategoryId);
	}

	/**
	 * Returns all the lectureseries_ categories.
	 *
	 * @return the lectureseries_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Category> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @return the range of lectureseries_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Category> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lectureseries_ categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Category> findAll(int start, int end,
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

		List<Lectureseries_Category> list = (List<Lectureseries_Category>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LECTURESERIES_CATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LECTURESERIES_CATEGORY;

				if (pagination) {
					sql = sql.concat(Lectureseries_CategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Category>(list);
				}
				else {
					list = (List<Lectureseries_Category>)QueryUtil.list(q,
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
	 * Removes all the lectureseries_ categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Lectureseries_Category lectureseries_Category : findAll()) {
			remove(lectureseries_Category);
		}
	}

	/**
	 * Returns the number of lectureseries_ categories.
	 *
	 * @return the number of lectureseries_ categories
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

				Query q = session.createQuery(_SQL_COUNT_LECTURESERIES_CATEGORY);

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
	 * Initializes the lectureseries_ category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Lectureseries_Category")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Lectureseries_Category>> listenersList = new ArrayList<ModelListener<Lectureseries_Category>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Lectureseries_Category>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Lectureseries_CategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LECTURESERIES_CATEGORY = "SELECT lectureseries_Category FROM Lectureseries_Category lectureseries_Category";
	private static final String _SQL_SELECT_LECTURESERIES_CATEGORY_WHERE = "SELECT lectureseries_Category FROM Lectureseries_Category lectureseries_Category WHERE ";
	private static final String _SQL_COUNT_LECTURESERIES_CATEGORY = "SELECT COUNT(lectureseries_Category) FROM Lectureseries_Category lectureseries_Category";
	private static final String _SQL_COUNT_LECTURESERIES_CATEGORY_WHERE = "SELECT COUNT(lectureseries_Category) FROM Lectureseries_Category lectureseries_Category WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lectureseries_Category.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lectureseries_Category exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Lectureseries_Category exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Lectureseries_CategoryPersistenceImpl.class);
	private static Lectureseries_Category _nullLectureseries_Category = new Lectureseries_CategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Lectureseries_Category> toCacheModel() {
				return _nullLectureseries_CategoryCacheModel;
			}
		};

	private static CacheModel<Lectureseries_Category> _nullLectureseries_CategoryCacheModel =
		new CacheModel<Lectureseries_Category>() {
			@Override
			public Lectureseries_Category toEntityModel() {
				return _nullLectureseries_Category;
			}
		};
}