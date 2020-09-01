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

import de.uhh.l2g.plugins.NoSuchTermException;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.impl.TermImpl;
import de.uhh.l2g.plugins.model.impl.TermModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the term service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see TermPersistence
 * @see TermUtil
 * @generated
 */
public class TermPersistenceImpl extends BasePersistenceImpl<Term>
	implements TermPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TermUtil} to access the term persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TermImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PREFIX = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPrefix",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX =
		new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrefix",
			new String[] { String.class.getName() },
			TermModelImpl.PREFIX_COLUMN_BITMASK |
			TermModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PREFIX = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrefix",
			new String[] { String.class.getName() });

	/**
	 * Returns all the terms where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @return the matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findByPrefix(String prefix) throws SystemException {
		return findByPrefix(prefix, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findByPrefix(String prefix, int start, int end)
		throws SystemException {
		return findByPrefix(prefix, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findByPrefix(String prefix, int start, int end,
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

		List<Term> list = (List<Term>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Term term : list) {
				if (!Validator.equals(prefix, term.getPrefix())) {
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

			query.append(_SQL_SELECT_TERM_WHERE);

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
				query.append(TermModelImpl.ORDER_BY_JPQL);
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
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Term>(list);
				}
				else {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term findByPrefix_First(String prefix,
		OrderByComparator orderByComparator)
		throws NoSuchTermException, SystemException {
		Term term = fetchByPrefix_First(prefix, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("prefix=");
		msg.append(prefix);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTermException(msg.toString());
	}

	/**
	 * Returns the first term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term fetchByPrefix_First(String prefix,
		OrderByComparator orderByComparator) throws SystemException {
		List<Term> list = findByPrefix(prefix, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term findByPrefix_Last(String prefix,
		OrderByComparator orderByComparator)
		throws NoSuchTermException, SystemException {
		Term term = fetchByPrefix_Last(prefix, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("prefix=");
		msg.append(prefix);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTermException(msg.toString());
	}

	/**
	 * Returns the last term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term fetchByPrefix_Last(String prefix,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPrefix(prefix);

		if (count == 0) {
			return null;
		}

		List<Term> list = findByPrefix(prefix, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terms before and after the current term in the ordered set where prefix = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term[] findByPrefix_PrevAndNext(long termId, String prefix,
		OrderByComparator orderByComparator)
		throws NoSuchTermException, SystemException {
		Term term = findByPrimaryKey(termId);

		Session session = null;

		try {
			session = openSession();

			Term[] array = new TermImpl[3];

			array[0] = getByPrefix_PrevAndNext(session, term, prefix,
					orderByComparator, true);

			array[1] = term;

			array[2] = getByPrefix_PrevAndNext(session, term, prefix,
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

	protected Term getByPrefix_PrevAndNext(Session session, Term term,
		String prefix, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TERM_WHERE);

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
			query.append(TermModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(term);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Term> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terms where prefix = &#63; from the database.
	 *
	 * @param prefix the prefix
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPrefix(String prefix) throws SystemException {
		for (Term term : findByPrefix(prefix, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(term);
		}
	}

	/**
	 * Returns the number of terms where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @return the number of matching terms
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

			query.append(_SQL_COUNT_TERM_WHERE);

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

	private static final String _FINDER_COLUMN_PREFIX_PREFIX_1 = "term.prefix IS NULL";
	private static final String _FINDER_COLUMN_PREFIX_PREFIX_2 = "term.prefix = ?";
	private static final String _FINDER_COLUMN_PREFIX_PREFIX_3 = "(term.prefix IS NULL OR term.prefix = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYear",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYear",
			new String[] { String.class.getName() },
			TermModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YEAR = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYear",
			new String[] { String.class.getName() });

	/**
	 * Returns all the terms where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findByYear(String year) throws SystemException {
		return findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findByYear(String year, int start, int end)
		throws SystemException {
		return findByYear(year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findByYear(String year, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { year, start, end, orderByComparator };
		}

		List<Term> list = (List<Term>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Term term : list) {
				if (!Validator.equals(year, term.getYear())) {
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

			query.append(_SQL_SELECT_TERM_WHERE);

			boolean bindYear = false;

			if (year == null) {
				query.append(_FINDER_COLUMN_YEAR_YEAR_1);
			}
			else if (year.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_YEAR_YEAR_3);
			}
			else {
				bindYear = true;

				query.append(_FINDER_COLUMN_YEAR_YEAR_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TermModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindYear) {
					qPos.add(year);
				}

				if (!pagination) {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Term>(list);
				}
				else {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term findByYear_First(String year,
		OrderByComparator orderByComparator)
		throws NoSuchTermException, SystemException {
		Term term = fetchByYear_First(year, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTermException(msg.toString());
	}

	/**
	 * Returns the first term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term fetchByYear_First(String year,
		OrderByComparator orderByComparator) throws SystemException {
		List<Term> list = findByYear(year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term findByYear_Last(String year, OrderByComparator orderByComparator)
		throws NoSuchTermException, SystemException {
		Term term = fetchByYear_Last(year, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTermException(msg.toString());
	}

	/**
	 * Returns the last term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term fetchByYear_Last(String year,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByYear(year);

		if (count == 0) {
			return null;
		}

		List<Term> list = findByYear(year, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terms before and after the current term in the ordered set where year = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term[] findByYear_PrevAndNext(long termId, String year,
		OrderByComparator orderByComparator)
		throws NoSuchTermException, SystemException {
		Term term = findByPrimaryKey(termId);

		Session session = null;

		try {
			session = openSession();

			Term[] array = new TermImpl[3];

			array[0] = getByYear_PrevAndNext(session, term, year,
					orderByComparator, true);

			array[1] = term;

			array[2] = getByYear_PrevAndNext(session, term, year,
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

	protected Term getByYear_PrevAndNext(Session session, Term term,
		String year, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TERM_WHERE);

		boolean bindYear = false;

		if (year == null) {
			query.append(_FINDER_COLUMN_YEAR_YEAR_1);
		}
		else if (year.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_YEAR_YEAR_3);
		}
		else {
			bindYear = true;

			query.append(_FINDER_COLUMN_YEAR_YEAR_2);
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
			query.append(TermModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindYear) {
			qPos.add(year);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(term);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Term> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terms where year = &#63; from the database.
	 *
	 * @param year the year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByYear(String year) throws SystemException {
		for (Term term : findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(term);
		}
	}

	/**
	 * Returns the number of terms where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByYear(String year) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_YEAR;

		Object[] finderArgs = new Object[] { year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TERM_WHERE);

			boolean bindYear = false;

			if (year == null) {
				query.append(_FINDER_COLUMN_YEAR_YEAR_1);
			}
			else if (year.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_YEAR_YEAR_3);
			}
			else {
				bindYear = true;

				query.append(_FINDER_COLUMN_YEAR_YEAR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindYear) {
					qPos.add(year);
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

	private static final String _FINDER_COLUMN_YEAR_YEAR_1 = "term.year IS NULL";
	private static final String _FINDER_COLUMN_YEAR_YEAR_2 = "term.year = ?";
	private static final String _FINDER_COLUMN_YEAR_YEAR_3 = "(term.year IS NULL OR term.year = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PREFIXANDYEAR =
		new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPrefixAndYear",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIXANDYEAR =
		new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrefixAndYear",
			new String[] { String.class.getName(), String.class.getName() },
			TermModelImpl.PREFIX_COLUMN_BITMASK |
			TermModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PREFIXANDYEAR = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrefixAndYear",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the terms where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @return the matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findByPrefixAndYear(String prefix, String year)
		throws SystemException {
		return findByPrefixAndYear(prefix, year, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms where prefix = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findByPrefixAndYear(String prefix, String year,
		int start, int end) throws SystemException {
		return findByPrefixAndYear(prefix, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms where prefix = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findByPrefixAndYear(String prefix, String year,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIXANDYEAR;
			finderArgs = new Object[] { prefix, year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PREFIXANDYEAR;
			finderArgs = new Object[] {
					prefix, year,
					
					start, end, orderByComparator
				};
		}

		List<Term> list = (List<Term>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Term term : list) {
				if (!Validator.equals(prefix, term.getPrefix()) ||
						!Validator.equals(year, term.getYear())) {
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

			query.append(_SQL_SELECT_TERM_WHERE);

			boolean bindPrefix = false;

			if (prefix == null) {
				query.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_1);
			}
			else if (prefix.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_3);
			}
			else {
				bindPrefix = true;

				query.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_2);
			}

			boolean bindYear = false;

			if (year == null) {
				query.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_1);
			}
			else if (year.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_3);
			}
			else {
				bindYear = true;

				query.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TermModelImpl.ORDER_BY_JPQL);
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

				if (bindYear) {
					qPos.add(year);
				}

				if (!pagination) {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Term>(list);
				}
				else {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term findByPrefixAndYear_First(String prefix, String year,
		OrderByComparator orderByComparator)
		throws NoSuchTermException, SystemException {
		Term term = fetchByPrefixAndYear_First(prefix, year, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("prefix=");
		msg.append(prefix);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTermException(msg.toString());
	}

	/**
	 * Returns the first term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term fetchByPrefixAndYear_First(String prefix, String year,
		OrderByComparator orderByComparator) throws SystemException {
		List<Term> list = findByPrefixAndYear(prefix, year, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term findByPrefixAndYear_Last(String prefix, String year,
		OrderByComparator orderByComparator)
		throws NoSuchTermException, SystemException {
		Term term = fetchByPrefixAndYear_Last(prefix, year, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("prefix=");
		msg.append(prefix);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTermException(msg.toString());
	}

	/**
	 * Returns the last term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term fetchByPrefixAndYear_Last(String prefix, String year,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPrefixAndYear(prefix, year);

		if (count == 0) {
			return null;
		}

		List<Term> list = findByPrefixAndYear(prefix, year, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terms before and after the current term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term[] findByPrefixAndYear_PrevAndNext(long termId, String prefix,
		String year, OrderByComparator orderByComparator)
		throws NoSuchTermException, SystemException {
		Term term = findByPrimaryKey(termId);

		Session session = null;

		try {
			session = openSession();

			Term[] array = new TermImpl[3];

			array[0] = getByPrefixAndYear_PrevAndNext(session, term, prefix,
					year, orderByComparator, true);

			array[1] = term;

			array[2] = getByPrefixAndYear_PrevAndNext(session, term, prefix,
					year, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Term getByPrefixAndYear_PrevAndNext(Session session, Term term,
		String prefix, String year, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TERM_WHERE);

		boolean bindPrefix = false;

		if (prefix == null) {
			query.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_1);
		}
		else if (prefix.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_3);
		}
		else {
			bindPrefix = true;

			query.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_2);
		}

		boolean bindYear = false;

		if (year == null) {
			query.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_1);
		}
		else if (year.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_3);
		}
		else {
			bindYear = true;

			query.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_2);
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
			query.append(TermModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPrefix) {
			qPos.add(prefix);
		}

		if (bindYear) {
			qPos.add(year);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(term);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Term> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terms where prefix = &#63; and year = &#63; from the database.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPrefixAndYear(String prefix, String year)
		throws SystemException {
		for (Term term : findByPrefixAndYear(prefix, year, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(term);
		}
	}

	/**
	 * Returns the number of terms where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @return the number of matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPrefixAndYear(String prefix, String year)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PREFIXANDYEAR;

		Object[] finderArgs = new Object[] { prefix, year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TERM_WHERE);

			boolean bindPrefix = false;

			if (prefix == null) {
				query.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_1);
			}
			else if (prefix.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_3);
			}
			else {
				bindPrefix = true;

				query.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_2);
			}

			boolean bindYear = false;

			if (year == null) {
				query.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_1);
			}
			else if (year.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_3);
			}
			else {
				bindYear = true;

				query.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_2);
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

				if (bindYear) {
					qPos.add(year);
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

	private static final String _FINDER_COLUMN_PREFIXANDYEAR_PREFIX_1 = "term.prefix IS NULL AND ";
	private static final String _FINDER_COLUMN_PREFIXANDYEAR_PREFIX_2 = "term.prefix = ? AND ";
	private static final String _FINDER_COLUMN_PREFIXANDYEAR_PREFIX_3 = "(term.prefix IS NULL OR term.prefix = '') AND ";
	private static final String _FINDER_COLUMN_PREFIXANDYEAR_YEAR_1 = "term.year IS NULL";
	private static final String _FINDER_COLUMN_PREFIXANDYEAR_YEAR_2 = "term.year = ?";
	private static final String _FINDER_COLUMN_PREFIXANDYEAR_YEAR_3 = "(term.year IS NULL OR term.year = '')";

	public TermPersistenceImpl() {
		setModelClass(Term.class);
	}

	/**
	 * Caches the term in the entity cache if it is enabled.
	 *
	 * @param term the term
	 */
	@Override
	public void cacheResult(Term term) {
		EntityCacheUtil.putResult(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermImpl.class, term.getPrimaryKey(), term);

		term.resetOriginalValues();
	}

	/**
	 * Caches the terms in the entity cache if it is enabled.
	 *
	 * @param terms the terms
	 */
	@Override
	public void cacheResult(List<Term> terms) {
		for (Term term : terms) {
			if (EntityCacheUtil.getResult(TermModelImpl.ENTITY_CACHE_ENABLED,
						TermImpl.class, term.getPrimaryKey()) == null) {
				cacheResult(term);
			}
			else {
				term.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all terms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TermImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TermImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the term.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Term term) {
		EntityCacheUtil.removeResult(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermImpl.class, term.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Term> terms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Term term : terms) {
			EntityCacheUtil.removeResult(TermModelImpl.ENTITY_CACHE_ENABLED,
				TermImpl.class, term.getPrimaryKey());
		}
	}

	/**
	 * Creates a new term with the primary key. Does not add the term to the database.
	 *
	 * @param termId the primary key for the new term
	 * @return the new term
	 */
	@Override
	public Term create(long termId) {
		Term term = new TermImpl();

		term.setNew(true);
		term.setPrimaryKey(termId);

		return term;
	}

	/**
	 * Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param termId the primary key of the term
	 * @return the term that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term remove(long termId) throws NoSuchTermException, SystemException {
		return remove((Serializable)termId);
	}

	/**
	 * Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the term
	 * @return the term that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term remove(Serializable primaryKey)
		throws NoSuchTermException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Term term = (Term)session.get(TermImpl.class, primaryKey);

			if (term == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTermException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(term);
		}
		catch (NoSuchTermException nsee) {
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
	protected Term removeImpl(Term term) throws SystemException {
		term = toUnwrappedModel(term);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(term)) {
				term = (Term)session.get(TermImpl.class, term.getPrimaryKeyObj());
			}

			if (term != null) {
				session.delete(term);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (term != null) {
			clearCache(term);
		}

		return term;
	}

	@Override
	public Term updateImpl(de.uhh.l2g.plugins.model.Term term)
		throws SystemException {
		term = toUnwrappedModel(term);

		boolean isNew = term.isNew();

		TermModelImpl termModelImpl = (TermModelImpl)term;

		Session session = null;

		try {
			session = openSession();

			if (term.isNew()) {
				session.save(term);

				term.setNew(false);
			}
			else {
				session.merge(term);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TermModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((termModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { termModelImpl.getOriginalPrefix() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PREFIX, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX,
					args);

				args = new Object[] { termModelImpl.getPrefix() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PREFIX, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIX,
					args);
			}

			if ((termModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { termModelImpl.getOriginalYear() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);

				args = new Object[] { termModelImpl.getYear() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);
			}

			if ((termModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIXANDYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						termModelImpl.getOriginalPrefix(),
						termModelImpl.getOriginalYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PREFIXANDYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIXANDYEAR,
					args);

				args = new Object[] {
						termModelImpl.getPrefix(), termModelImpl.getYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PREFIXANDYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PREFIXANDYEAR,
					args);
			}
		}

		EntityCacheUtil.putResult(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermImpl.class, term.getPrimaryKey(), term);

		return term;
	}

	protected Term toUnwrappedModel(Term term) {
		if (term instanceof TermImpl) {
			return term;
		}

		TermImpl termImpl = new TermImpl();

		termImpl.setNew(term.isNew());
		termImpl.setPrimaryKey(term.getPrimaryKey());

		termImpl.setTermId(term.getTermId());
		termImpl.setParentId(term.getParentId());
		termImpl.setLanguageId(term.getLanguageId());
		termImpl.setPrefix(term.getPrefix());
		termImpl.setYear(term.getYear());
		termImpl.setTranslation(term.getTranslation());

		return termImpl;
	}

	/**
	 * Returns the term with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the term
	 * @return the term
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTermException, SystemException {
		Term term = fetchByPrimaryKey(primaryKey);

		if (term == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTermException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return term;
	}

	/**
	 * Returns the term with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchTermException} if it could not be found.
	 *
	 * @param termId the primary key of the term
	 * @return the term
	 * @throws de.uhh.l2g.plugins.NoSuchTermException if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term findByPrimaryKey(long termId)
		throws NoSuchTermException, SystemException {
		return findByPrimaryKey((Serializable)termId);
	}

	/**
	 * Returns the term with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the term
	 * @return the term, or <code>null</code> if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Term term = (Term)EntityCacheUtil.getResult(TermModelImpl.ENTITY_CACHE_ENABLED,
				TermImpl.class, primaryKey);

		if (term == _nullTerm) {
			return null;
		}

		if (term == null) {
			Session session = null;

			try {
				session = openSession();

				term = (Term)session.get(TermImpl.class, primaryKey);

				if (term != null) {
					cacheResult(term);
				}
				else {
					EntityCacheUtil.putResult(TermModelImpl.ENTITY_CACHE_ENABLED,
						TermImpl.class, primaryKey, _nullTerm);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TermModelImpl.ENTITY_CACHE_ENABLED,
					TermImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return term;
	}

	/**
	 * Returns the term with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param termId the primary key of the term
	 * @return the term, or <code>null</code> if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term fetchByPrimaryKey(long termId) throws SystemException {
		return fetchByPrimaryKey((Serializable)termId);
	}

	/**
	 * Returns all the terms.
	 *
	 * @return the terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findAll(int start, int end,
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

		List<Term> list = (List<Term>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TERM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TERM;

				if (pagination) {
					sql = sql.concat(TermModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Term>(list);
				}
				else {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the terms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Term term : findAll()) {
			remove(term);
		}
	}

	/**
	 * Returns the number of terms.
	 *
	 * @return the number of terms
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

				Query q = session.createQuery(_SQL_COUNT_TERM);

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
	 * Initializes the term persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Term")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Term>> listenersList = new ArrayList<ModelListener<Term>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Term>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TermImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TERM = "SELECT term FROM Term term";
	private static final String _SQL_SELECT_TERM_WHERE = "SELECT term FROM Term term WHERE ";
	private static final String _SQL_COUNT_TERM = "SELECT COUNT(term) FROM Term term";
	private static final String _SQL_COUNT_TERM_WHERE = "SELECT COUNT(term) FROM Term term WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "term.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Term exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Term exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TermPersistenceImpl.class);
	private static Term _nullTerm = new TermImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Term> toCacheModel() {
				return _nullTermCacheModel;
			}
		};

	private static CacheModel<Term> _nullTermCacheModel = new CacheModel<Term>() {
			@Override
			public Term toEntityModel() {
				return _nullTerm;
			}
		};
}