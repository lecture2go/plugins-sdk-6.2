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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchYearException;
import de.uhh.l2g.plugins.model.Year;
import de.uhh.l2g.plugins.model.impl.YearImpl;
import de.uhh.l2g.plugins.model.impl.YearModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the year service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see YearPersistence
 * @see YearUtil
 * @generated
 */
public class YearPersistenceImpl extends BasePersistenceImpl<Year>
	implements YearPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link YearUtil} to access the year persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = YearImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(YearModelImpl.ENTITY_CACHE_ENABLED,
			YearModelImpl.FINDER_CACHE_ENABLED, YearImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(YearModelImpl.ENTITY_CACHE_ENABLED,
			YearModelImpl.FINDER_CACHE_ENABLED, YearImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(YearModelImpl.ENTITY_CACHE_ENABLED,
			YearModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PREFIX = new FinderPath(YearModelImpl.ENTITY_CACHE_ENABLED,
			YearModelImpl.FINDER_CACHE_ENABLED, YearImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPrefix",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX =
		new FinderPath(YearModelImpl.ENTITY_CACHE_ENABLED,
			YearModelImpl.FINDER_CACHE_ENABLED, YearImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrefix",
			new String[] { String.class.getName() },
			YearModelImpl.PREFIX_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PREFIX = new FinderPath(YearModelImpl.ENTITY_CACHE_ENABLED,
			YearModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrefix",
			new String[] { String.class.getName() });

	/**
	 * Returns all the years where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @return the matching years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Year> findByPrefix(String prefix) throws SystemException {
		return findByPrefix(prefix, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the years where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.YearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of years
	 * @param end the upper bound of the range of years (not inclusive)
	 * @return the range of matching years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Year> findByPrefix(String prefix, int start, int end)
		throws SystemException {
		return findByPrefix(prefix, start, end, null);
	}

	/**
	 * Returns an ordered range of all the years where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.YearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of years
	 * @param end the upper bound of the range of years (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Year> findByPrefix(String prefix, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX;
			finderArgs = new Object[] { prefix };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PREFIX;
			finderArgs = new Object[] { prefix, start, end, orderByComparator };
		}

		List<Year> list = (List<Year>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Year year : list) {
				if (!Validator.equals(prefix, year.getPrefix())) {
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

			query.append(_SQL_SELECT_YEAR_WHERE);

			boolean bindPrefix = false;

			if (prefix == null) {
				query.append(_FINDER_COLUMN_PREFIX_PREFIX_1);
			}
			else if (prefix.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PREFIX_PREFIX_3);
			}
			else {
				bindPrefix = true;

				query.append(_FINDER_COLUMN_PREFIX_PREFIX_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(YearModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPrefix) {
					qPos.add(prefix);
				}

				if (!pagination) {
					list = (List<Year>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Year>(list);
				}
				else {
					list = (List<Year>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first year in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching year
	 * @throws de.uhh.l2g.plugins.NoSuchYearException if a matching year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year findByPrefix_First(String prefix,
		OrderByComparator orderByComparator)
		throws NoSuchYearException, SystemException {
		Year year = fetchByPrefix_First(prefix, orderByComparator);

		if (year != null) {
			return year;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("prefix=");
		msg.append(prefix);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYearException(msg.toString());
	}

	/**
	 * Returns the first year in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching year, or <code>null</code> if a matching year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year fetchByPrefix_First(String prefix,
		OrderByComparator orderByComparator) throws SystemException {
		List<Year> list = findByPrefix(prefix, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last year in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching year
	 * @throws de.uhh.l2g.plugins.NoSuchYearException if a matching year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year findByPrefix_Last(String prefix,
		OrderByComparator orderByComparator)
		throws NoSuchYearException, SystemException {
		Year year = fetchByPrefix_Last(prefix, orderByComparator);

		if (year != null) {
			return year;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("prefix=");
		msg.append(prefix);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYearException(msg.toString());
	}

	/**
	 * Returns the last year in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching year, or <code>null</code> if a matching year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year fetchByPrefix_Last(String prefix,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPrefix(prefix);

		if (count == 0) {
			return null;
		}

		List<Year> list = findByPrefix(prefix, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the years before and after the current year in the ordered set where prefix = &#63;.
	 *
	 * @param yearId the primary key of the current year
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next year
	 * @throws de.uhh.l2g.plugins.NoSuchYearException if a year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year[] findByPrefix_PrevAndNext(long yearId, String prefix,
		OrderByComparator orderByComparator)
		throws NoSuchYearException, SystemException {
		Year year = findByPrimaryKey(yearId);

		Session session = null;

		try {
			session = openSession();

			Year[] array = new YearImpl[3];

			array[0] = getByPrefix_PrevAndNext(session, year, prefix,
					orderByComparator, true);

			array[1] = year;

			array[2] = getByPrefix_PrevAndNext(session, year, prefix,
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

	protected Year getByPrefix_PrevAndNext(Session session, Year year,
		String prefix, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YEAR_WHERE);

		boolean bindPrefix = false;

		if (prefix == null) {
			query.append(_FINDER_COLUMN_PREFIX_PREFIX_1);
		}
		else if (prefix.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PREFIX_PREFIX_3);
		}
		else {
			bindPrefix = true;

			query.append(_FINDER_COLUMN_PREFIX_PREFIX_2);
		}

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
			query.append(YearModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPrefix) {
			qPos.add(prefix);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(year);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Year> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the years where prefix = &#63; from the database.
	 *
	 * @param prefix the prefix
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPrefix(String prefix) throws SystemException {
		for (Year year : findByPrefix(prefix, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(year);
		}
	}

	/**
	 * Returns the number of years where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @return the number of matching years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPrefix(String prefix) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PREFIX;

		Object[] finderArgs = new Object[] { prefix };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YEAR_WHERE);

			boolean bindPrefix = false;

			if (prefix == null) {
				query.append(_FINDER_COLUMN_PREFIX_PREFIX_1);
			}
			else if (prefix.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PREFIX_PREFIX_3);
			}
			else {
				bindPrefix = true;

				query.append(_FINDER_COLUMN_PREFIX_PREFIX_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPrefix) {
					qPos.add(prefix);
				}

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

	private static final String _FINDER_COLUMN_PREFIX_PREFIX_1 = "year.prefix IS NULL";
	private static final String _FINDER_COLUMN_PREFIX_PREFIX_2 = "year.prefix = ?";
	private static final String _FINDER_COLUMN_PREFIX_PREFIX_3 = "(year.prefix IS NULL OR year.prefix = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(YearModelImpl.ENTITY_CACHE_ENABLED,
			YearModelImpl.FINDER_CACHE_ENABLED, YearImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(YearModelImpl.ENTITY_CACHE_ENABLED,
			YearModelImpl.FINDER_CACHE_ENABLED, YearImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			YearModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(YearModelImpl.ENTITY_CACHE_ENABLED,
			YearModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the years where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Year> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the years where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.YearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of years
	 * @param end the upper bound of the range of years (not inclusive)
	 * @return the range of matching years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Year> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the years where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.YearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of years
	 * @param end the upper bound of the range of years (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Year> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Year> list = (List<Year>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Year year : list) {
				if (!Validator.equals(name, year.getName())) {
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

			query.append(_SQL_SELECT_YEAR_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(YearModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<Year>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Year>(list);
				}
				else {
					list = (List<Year>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first year in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching year
	 * @throws de.uhh.l2g.plugins.NoSuchYearException if a matching year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchYearException, SystemException {
		Year year = fetchByName_First(name, orderByComparator);

		if (year != null) {
			return year;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYearException(msg.toString());
	}

	/**
	 * Returns the first year in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching year, or <code>null</code> if a matching year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<Year> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last year in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching year
	 * @throws de.uhh.l2g.plugins.NoSuchYearException if a matching year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year findByName_Last(String name, OrderByComparator orderByComparator)
		throws NoSuchYearException, SystemException {
		Year year = fetchByName_Last(name, orderByComparator);

		if (year != null) {
			return year;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYearException(msg.toString());
	}

	/**
	 * Returns the last year in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching year, or <code>null</code> if a matching year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Year> list = findByName(name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the years before and after the current year in the ordered set where name = &#63;.
	 *
	 * @param yearId the primary key of the current year
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next year
	 * @throws de.uhh.l2g.plugins.NoSuchYearException if a year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year[] findByName_PrevAndNext(long yearId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchYearException, SystemException {
		Year year = findByPrimaryKey(yearId);

		Session session = null;

		try {
			session = openSession();

			Year[] array = new YearImpl[3];

			array[0] = getByName_PrevAndNext(session, year, name,
					orderByComparator, true);

			array[1] = year;

			array[2] = getByName_PrevAndNext(session, year, name,
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

	protected Year getByName_PrevAndNext(Session session, Year year,
		String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YEAR_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

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
			query.append(YearModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(year);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Year> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the years where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (Year year : findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(year);
		}
	}

	/**
	 * Returns the number of years where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YEAR_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "year.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "year.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(year.name IS NULL OR year.name = '')";

	public YearPersistenceImpl() {
		setModelClass(Year.class);
	}

	/**
	 * Caches the year in the entity cache if it is enabled.
	 *
	 * @param year the year
	 */
	@Override
	public void cacheResult(Year year) {
		EntityCacheUtil.putResult(YearModelImpl.ENTITY_CACHE_ENABLED,
			YearImpl.class, year.getPrimaryKey(), year);

		year.resetOriginalValues();
	}

	/**
	 * Caches the years in the entity cache if it is enabled.
	 *
	 * @param years the years
	 */
	@Override
	public void cacheResult(List<Year> years) {
		for (Year year : years) {
			if (EntityCacheUtil.getResult(YearModelImpl.ENTITY_CACHE_ENABLED,
						YearImpl.class, year.getPrimaryKey()) == null) {
				cacheResult(year);
			}
			else {
				year.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all years.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(YearImpl.class.getName());
		}

		EntityCacheUtil.clearCache(YearImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the year.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Year year) {
		EntityCacheUtil.removeResult(YearModelImpl.ENTITY_CACHE_ENABLED,
			YearImpl.class, year.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Year> years) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Year year : years) {
			EntityCacheUtil.removeResult(YearModelImpl.ENTITY_CACHE_ENABLED,
				YearImpl.class, year.getPrimaryKey());
		}
	}

	/**
	 * Creates a new year with the primary key. Does not add the year to the database.
	 *
	 * @param yearId the primary key for the new year
	 * @return the new year
	 */
	@Override
	public Year create(long yearId) {
		Year year = new YearImpl();

		year.setNew(true);
		year.setPrimaryKey(yearId);

		return year;
	}

	/**
	 * Removes the year with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param yearId the primary key of the year
	 * @return the year that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchYearException if a year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year remove(long yearId) throws NoSuchYearException, SystemException {
		return remove((Serializable)yearId);
	}

	/**
	 * Removes the year with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the year
	 * @return the year that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchYearException if a year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year remove(Serializable primaryKey)
		throws NoSuchYearException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Year year = (Year)session.get(YearImpl.class, primaryKey);

			if (year == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchYearException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(year);
		}
		catch (NoSuchYearException nsee) {
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
	protected Year removeImpl(Year year) throws SystemException {
		year = toUnwrappedModel(year);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(year)) {
				year = (Year)session.get(YearImpl.class, year.getPrimaryKeyObj());
			}

			if (year != null) {
				session.delete(year);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (year != null) {
			clearCache(year);
		}

		return year;
	}

	@Override
	public Year updateImpl(de.uhh.l2g.plugins.model.Year year)
		throws SystemException {
		year = toUnwrappedModel(year);

		boolean isNew = year.isNew();

		YearModelImpl yearModelImpl = (YearModelImpl)year;

		Session session = null;

		try {
			session = openSession();

			if (year.isNew()) {
				session.save(year);

				year.setNew(false);
			}
			else {
				session.merge(year);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !YearModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((yearModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { yearModelImpl.getOriginalPrefix() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PREFIX, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX,
					args);

				args = new Object[] { yearModelImpl.getPrefix() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PREFIX, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX,
					args);
			}

			if ((yearModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { yearModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { yearModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(YearModelImpl.ENTITY_CACHE_ENABLED,
			YearImpl.class, year.getPrimaryKey(), year);

		return year;
	}

	protected Year toUnwrappedModel(Year year) {
		if (year instanceof YearImpl) {
			return year;
		}

		YearImpl yearImpl = new YearImpl();

		yearImpl.setNew(year.isNew());
		yearImpl.setPrimaryKey(year.getPrimaryKey());

		yearImpl.setYearId(year.getYearId());
		yearImpl.setParentId(year.getParentId());
		yearImpl.setLanguageId(year.getLanguageId());
		yearImpl.setPrefix(year.getPrefix());
		yearImpl.setName(year.getName());
		yearImpl.setTranslation(year.getTranslation());

		return yearImpl;
	}

	/**
	 * Returns the year with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the year
	 * @return the year
	 * @throws de.uhh.l2g.plugins.NoSuchYearException if a year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year findByPrimaryKey(Serializable primaryKey)
		throws NoSuchYearException, SystemException {
		Year year = fetchByPrimaryKey(primaryKey);

		if (year == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchYearException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return year;
	}

	/**
	 * Returns the year with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchYearException} if it could not be found.
	 *
	 * @param yearId the primary key of the year
	 * @return the year
	 * @throws de.uhh.l2g.plugins.NoSuchYearException if a year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year findByPrimaryKey(long yearId)
		throws NoSuchYearException, SystemException {
		return findByPrimaryKey((Serializable)yearId);
	}

	/**
	 * Returns the year with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the year
	 * @return the year, or <code>null</code> if a year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Year year = (Year)EntityCacheUtil.getResult(YearModelImpl.ENTITY_CACHE_ENABLED,
				YearImpl.class, primaryKey);

		if (year == _nullYear) {
			return null;
		}

		if (year == null) {
			Session session = null;

			try {
				session = openSession();

				year = (Year)session.get(YearImpl.class, primaryKey);

				if (year != null) {
					cacheResult(year);
				}
				else {
					EntityCacheUtil.putResult(YearModelImpl.ENTITY_CACHE_ENABLED,
						YearImpl.class, primaryKey, _nullYear);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(YearModelImpl.ENTITY_CACHE_ENABLED,
					YearImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return year;
	}

	/**
	 * Returns the year with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param yearId the primary key of the year
	 * @return the year, or <code>null</code> if a year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Year fetchByPrimaryKey(long yearId) throws SystemException {
		return fetchByPrimaryKey((Serializable)yearId);
	}

	/**
	 * Returns all the years.
	 *
	 * @return the years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Year> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the years.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.YearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of years
	 * @param end the upper bound of the range of years (not inclusive)
	 * @return the range of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Year> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the years.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.YearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of years
	 * @param end the upper bound of the range of years (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Year> findAll(int start, int end,
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

		List<Year> list = (List<Year>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_YEAR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_YEAR;

				if (pagination) {
					sql = sql.concat(YearModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Year>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Year>(list);
				}
				else {
					list = (List<Year>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the years from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Year year : findAll()) {
			remove(year);
		}
	}

	/**
	 * Returns the number of years.
	 *
	 * @return the number of years
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

				Query q = session.createQuery(_SQL_COUNT_YEAR);

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
	 * Initializes the year persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Year")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Year>> listenersList = new ArrayList<ModelListener<Year>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Year>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(YearImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_YEAR = "SELECT year FROM Year year";
	private static final String _SQL_SELECT_YEAR_WHERE = "SELECT year FROM Year year WHERE ";
	private static final String _SQL_COUNT_YEAR = "SELECT COUNT(year) FROM Year year";
	private static final String _SQL_COUNT_YEAR_WHERE = "SELECT COUNT(year) FROM Year year WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "year.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Year exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Year exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(YearPersistenceImpl.class);
	private static Year _nullYear = new YearImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Year> toCacheModel() {
				return _nullYearCacheModel;
			}
		};

	private static CacheModel<Year> _nullYearCacheModel = new CacheModel<Year>() {
			@Override
			public Year toEntityModel() {
				return _nullYear;
			}
		};
}