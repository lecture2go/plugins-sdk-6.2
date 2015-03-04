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

import de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException;
import de.uhh.l2g.plugins.model.Lectureseries_Creator;
import de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorImpl;
import de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the lectureseries_ creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_CreatorPersistence
 * @see Lectureseries_CreatorUtil
 * @generated
 */
public class Lectureseries_CreatorPersistenceImpl extends BasePersistenceImpl<Lectureseries_Creator>
	implements Lectureseries_CreatorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Lectureseries_CreatorUtil} to access the lectureseries_ creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Lectureseries_CreatorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseries",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseries",
			new String[] { Long.class.getName() },
			Lectureseries_CreatorModelImpl.LECTURESERIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIES = new FinderPath(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLectureseries",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching lectureseries_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Creator> findByLectureseries(long lectureseriesId)
		throws SystemException {
		return findByLectureseries(lectureseriesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of matching lectureseries_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId, int start, int end) throws SystemException {
		return findByLectureseries(lectureseriesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Creator> findByLectureseries(
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

		List<Lectureseries_Creator> list = (List<Lectureseries_Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Lectureseries_Creator lectureseries_Creator : list) {
				if ((lectureseriesId != lectureseries_Creator.getLectureseriesId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_CREATOR_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Lectureseries_Creator>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Creator>(list);
				}
				else {
					list = (List<Lectureseries_Creator>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator findByLectureseries_First(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_CreatorException, SystemException {
		Lectureseries_Creator lectureseries_Creator = fetchByLectureseries_First(lectureseriesId,
				orderByComparator);

		if (lectureseries_Creator != null) {
			return lectureseries_Creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CreatorException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator fetchByLectureseries_First(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Lectureseries_Creator> list = findByLectureseries(lectureseriesId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator findByLectureseries_Last(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_CreatorException, SystemException {
		Lectureseries_Creator lectureseries_Creator = fetchByLectureseries_Last(lectureseriesId,
				orderByComparator);

		if (lectureseries_Creator != null) {
			return lectureseries_Creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CreatorException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator fetchByLectureseries_Last(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLectureseries(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Creator> list = findByLectureseries(lectureseriesId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator[] findByLectureseries_PrevAndNext(
		long lectureseriesCreatorId, long lectureseriesId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_CreatorException, SystemException {
		Lectureseries_Creator lectureseries_Creator = findByPrimaryKey(lectureseriesCreatorId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Creator[] array = new Lectureseries_CreatorImpl[3];

			array[0] = getByLectureseries_PrevAndNext(session,
					lectureseries_Creator, lectureseriesId, orderByComparator,
					true);

			array[1] = lectureseries_Creator;

			array[2] = getByLectureseries_PrevAndNext(session,
					lectureseries_Creator, lectureseriesId, orderByComparator,
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

	protected Lectureseries_Creator getByLectureseries_PrevAndNext(
		Session session, Lectureseries_Creator lectureseries_Creator,
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

		query.append(_SQL_SELECT_LECTURESERIES_CREATOR_WHERE);

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
			query.append(Lectureseries_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ creators where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLectureseries(long lectureseriesId)
		throws SystemException {
		for (Lectureseries_Creator lectureseries_Creator : findByLectureseries(
				lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Creator);
		}
	}

	/**
	 * Returns the number of lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching lectureseries_ creators
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

			query.append(_SQL_COUNT_LECTURESERIES_CREATOR_WHERE);

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

	private static final String _FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2 = "lectureseries_Creator.lectureseriesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATOR = new FinderPath(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreator",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR =
		new FinderPath(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreator",
			new String[] { Long.class.getName() },
			Lectureseries_CreatorModelImpl.CREATORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATOR = new FinderPath(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreator",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching lectureseries_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Creator> findByCreator(long creatorId)
		throws SystemException {
		return findByCreator(creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of matching lectureseries_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Creator> findByCreator(long creatorId, int start,
		int end) throws SystemException {
		return findByCreator(creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Creator> findByCreator(long creatorId, int start,
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

		List<Lectureseries_Creator> list = (List<Lectureseries_Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Lectureseries_Creator lectureseries_Creator : list) {
				if ((creatorId != lectureseries_Creator.getCreatorId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_CREATOR_WHERE);

			query.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creatorId);

				if (!pagination) {
					list = (List<Lectureseries_Creator>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Creator>(list);
				}
				else {
					list = (List<Lectureseries_Creator>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator findByCreator_First(long creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_CreatorException, SystemException {
		Lectureseries_Creator lectureseries_Creator = fetchByCreator_First(creatorId,
				orderByComparator);

		if (lectureseries_Creator != null) {
			return lectureseries_Creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CreatorException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator fetchByCreator_First(long creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Lectureseries_Creator> list = findByCreator(creatorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator findByCreator_Last(long creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_CreatorException, SystemException {
		Lectureseries_Creator lectureseries_Creator = fetchByCreator_Last(creatorId,
				orderByComparator);

		if (lectureseries_Creator != null) {
			return lectureseries_Creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_CreatorException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator fetchByCreator_Last(long creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCreator(creatorId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Creator> list = findByCreator(creatorId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator[] findByCreator_PrevAndNext(
		long lectureseriesCreatorId, long creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_CreatorException, SystemException {
		Lectureseries_Creator lectureseries_Creator = findByPrimaryKey(lectureseriesCreatorId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Creator[] array = new Lectureseries_CreatorImpl[3];

			array[0] = getByCreator_PrevAndNext(session, lectureseries_Creator,
					creatorId, orderByComparator, true);

			array[1] = lectureseries_Creator;

			array[2] = getByCreator_PrevAndNext(session, lectureseries_Creator,
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

	protected Lectureseries_Creator getByCreator_PrevAndNext(Session session,
		Lectureseries_Creator lectureseries_Creator, long creatorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_CREATOR_WHERE);

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
			query.append(Lectureseries_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(creatorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ creators where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreator(long creatorId) throws SystemException {
		for (Lectureseries_Creator lectureseries_Creator : findByCreator(
				creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Creator);
		}
	}

	/**
	 * Returns the number of lectureseries_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching lectureseries_ creators
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

			query.append(_SQL_COUNT_LECTURESERIES_CREATOR_WHERE);

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

	private static final String _FINDER_COLUMN_CREATOR_CREATORID_2 = "lectureseries_Creator.creatorId = ?";

	public Lectureseries_CreatorPersistenceImpl() {
		setModelClass(Lectureseries_Creator.class);
	}

	/**
	 * Caches the lectureseries_ creator in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Creator the lectureseries_ creator
	 */
	@Override
	public void cacheResult(Lectureseries_Creator lectureseries_Creator) {
		EntityCacheUtil.putResult(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			lectureseries_Creator.getPrimaryKey(), lectureseries_Creator);

		lectureseries_Creator.resetOriginalValues();
	}

	/**
	 * Caches the lectureseries_ creators in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Creators the lectureseries_ creators
	 */
	@Override
	public void cacheResult(List<Lectureseries_Creator> lectureseries_Creators) {
		for (Lectureseries_Creator lectureseries_Creator : lectureseries_Creators) {
			if (EntityCacheUtil.getResult(
						Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
						Lectureseries_CreatorImpl.class,
						lectureseries_Creator.getPrimaryKey()) == null) {
				cacheResult(lectureseries_Creator);
			}
			else {
				lectureseries_Creator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lectureseries_ creators.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Lectureseries_CreatorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Lectureseries_CreatorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lectureseries_ creator.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lectureseries_Creator lectureseries_Creator) {
		EntityCacheUtil.removeResult(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			lectureseries_Creator.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Lectureseries_Creator> lectureseries_Creators) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lectureseries_Creator lectureseries_Creator : lectureseries_Creators) {
			EntityCacheUtil.removeResult(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
				Lectureseries_CreatorImpl.class,
				lectureseries_Creator.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lectureseries_ creator with the primary key. Does not add the lectureseries_ creator to the database.
	 *
	 * @param lectureseriesCreatorId the primary key for the new lectureseries_ creator
	 * @return the new lectureseries_ creator
	 */
	@Override
	public Lectureseries_Creator create(long lectureseriesCreatorId) {
		Lectureseries_Creator lectureseries_Creator = new Lectureseries_CreatorImpl();

		lectureseries_Creator.setNew(true);
		lectureseries_Creator.setPrimaryKey(lectureseriesCreatorId);

		return lectureseries_Creator;
	}

	/**
	 * Removes the lectureseries_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator remove(long lectureseriesCreatorId)
		throws NoSuchLectureseries_CreatorException, SystemException {
		return remove((Serializable)lectureseriesCreatorId);
	}

	/**
	 * Removes the lectureseries_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator remove(Serializable primaryKey)
		throws NoSuchLectureseries_CreatorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Lectureseries_Creator lectureseries_Creator = (Lectureseries_Creator)session.get(Lectureseries_CreatorImpl.class,
					primaryKey);

			if (lectureseries_Creator == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLectureseries_CreatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lectureseries_Creator);
		}
		catch (NoSuchLectureseries_CreatorException nsee) {
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
	protected Lectureseries_Creator removeImpl(
		Lectureseries_Creator lectureseries_Creator) throws SystemException {
		lectureseries_Creator = toUnwrappedModel(lectureseries_Creator);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lectureseries_Creator)) {
				lectureseries_Creator = (Lectureseries_Creator)session.get(Lectureseries_CreatorImpl.class,
						lectureseries_Creator.getPrimaryKeyObj());
			}

			if (lectureseries_Creator != null) {
				session.delete(lectureseries_Creator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lectureseries_Creator != null) {
			clearCache(lectureseries_Creator);
		}

		return lectureseries_Creator;
	}

	@Override
	public Lectureseries_Creator updateImpl(
		de.uhh.l2g.plugins.model.Lectureseries_Creator lectureseries_Creator)
		throws SystemException {
		lectureseries_Creator = toUnwrappedModel(lectureseries_Creator);

		boolean isNew = lectureseries_Creator.isNew();

		Lectureseries_CreatorModelImpl lectureseries_CreatorModelImpl = (Lectureseries_CreatorModelImpl)lectureseries_Creator;

		Session session = null;

		try {
			session = openSession();

			if (lectureseries_Creator.isNew()) {
				session.save(lectureseries_Creator);

				lectureseries_Creator.setNew(false);
			}
			else {
				session.merge(lectureseries_Creator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Lectureseries_CreatorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lectureseries_CreatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_CreatorModelImpl.getOriginalLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);

				args = new Object[] {
						lectureseries_CreatorModelImpl.getLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);
			}

			if ((lectureseries_CreatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_CreatorModelImpl.getOriginalCreatorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR,
					args);

				args = new Object[] {
						lectureseries_CreatorModelImpl.getCreatorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR,
					args);
			}
		}

		EntityCacheUtil.putResult(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			lectureseries_Creator.getPrimaryKey(), lectureseries_Creator);

		return lectureseries_Creator;
	}

	protected Lectureseries_Creator toUnwrappedModel(
		Lectureseries_Creator lectureseries_Creator) {
		if (lectureseries_Creator instanceof Lectureseries_CreatorImpl) {
			return lectureseries_Creator;
		}

		Lectureseries_CreatorImpl lectureseries_CreatorImpl = new Lectureseries_CreatorImpl();

		lectureseries_CreatorImpl.setNew(lectureseries_Creator.isNew());
		lectureseries_CreatorImpl.setPrimaryKey(lectureseries_Creator.getPrimaryKey());

		lectureseries_CreatorImpl.setLectureseriesCreatorId(lectureseries_Creator.getLectureseriesCreatorId());
		lectureseries_CreatorImpl.setLectureseriesId(lectureseries_Creator.getLectureseriesId());
		lectureseries_CreatorImpl.setCreatorId(lectureseries_Creator.getCreatorId());

		return lectureseries_CreatorImpl;
	}

	/**
	 * Returns the lectureseries_ creator with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLectureseries_CreatorException, SystemException {
		Lectureseries_Creator lectureseries_Creator = fetchByPrimaryKey(primaryKey);

		if (lectureseries_Creator == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLectureseries_CreatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lectureseries_Creator;
	}

	/**
	 * Returns the lectureseries_ creator with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException} if it could not be found.
	 *
	 * @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator findByPrimaryKey(long lectureseriesCreatorId)
		throws NoSuchLectureseries_CreatorException, SystemException {
		return findByPrimaryKey((Serializable)lectureseriesCreatorId);
	}

	/**
	 * Returns the lectureseries_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator, or <code>null</code> if a lectureseries_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Lectureseries_Creator lectureseries_Creator = (Lectureseries_Creator)EntityCacheUtil.getResult(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
				Lectureseries_CreatorImpl.class, primaryKey);

		if (lectureseries_Creator == _nullLectureseries_Creator) {
			return null;
		}

		if (lectureseries_Creator == null) {
			Session session = null;

			try {
				session = openSession();

				lectureseries_Creator = (Lectureseries_Creator)session.get(Lectureseries_CreatorImpl.class,
						primaryKey);

				if (lectureseries_Creator != null) {
					cacheResult(lectureseries_Creator);
				}
				else {
					EntityCacheUtil.putResult(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
						Lectureseries_CreatorImpl.class, primaryKey,
						_nullLectureseries_Creator);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
					Lectureseries_CreatorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lectureseries_Creator;
	}

	/**
	 * Returns the lectureseries_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator, or <code>null</code> if a lectureseries_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Creator fetchByPrimaryKey(long lectureseriesCreatorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)lectureseriesCreatorId);
	}

	/**
	 * Returns all the lectureseries_ creators.
	 *
	 * @return the lectureseries_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Creator> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of lectureseries_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Creator> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lectureseries_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Creator> findAll(int start, int end,
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

		List<Lectureseries_Creator> list = (List<Lectureseries_Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LECTURESERIES_CREATOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LECTURESERIES_CREATOR;

				if (pagination) {
					sql = sql.concat(Lectureseries_CreatorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Lectureseries_Creator>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Creator>(list);
				}
				else {
					list = (List<Lectureseries_Creator>)QueryUtil.list(q,
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
	 * Removes all the lectureseries_ creators from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Lectureseries_Creator lectureseries_Creator : findAll()) {
			remove(lectureseries_Creator);
		}
	}

	/**
	 * Returns the number of lectureseries_ creators.
	 *
	 * @return the number of lectureseries_ creators
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

				Query q = session.createQuery(_SQL_COUNT_LECTURESERIES_CREATOR);

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
	 * Initializes the lectureseries_ creator persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Lectureseries_Creator")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Lectureseries_Creator>> listenersList = new ArrayList<ModelListener<Lectureseries_Creator>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Lectureseries_Creator>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Lectureseries_CreatorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LECTURESERIES_CREATOR = "SELECT lectureseries_Creator FROM Lectureseries_Creator lectureseries_Creator";
	private static final String _SQL_SELECT_LECTURESERIES_CREATOR_WHERE = "SELECT lectureseries_Creator FROM Lectureseries_Creator lectureseries_Creator WHERE ";
	private static final String _SQL_COUNT_LECTURESERIES_CREATOR = "SELECT COUNT(lectureseries_Creator) FROM Lectureseries_Creator lectureseries_Creator";
	private static final String _SQL_COUNT_LECTURESERIES_CREATOR_WHERE = "SELECT COUNT(lectureseries_Creator) FROM Lectureseries_Creator lectureseries_Creator WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lectureseries_Creator.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lectureseries_Creator exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Lectureseries_Creator exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Lectureseries_CreatorPersistenceImpl.class);
	private static Lectureseries_Creator _nullLectureseries_Creator = new Lectureseries_CreatorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Lectureseries_Creator> toCacheModel() {
				return _nullLectureseries_CreatorCacheModel;
			}
		};

	private static CacheModel<Lectureseries_Creator> _nullLectureseries_CreatorCacheModel =
		new CacheModel<Lectureseries_Creator>() {
			@Override
			public Lectureseries_Creator toEntityModel() {
				return _nullLectureseries_Creator;
			}
		};
}