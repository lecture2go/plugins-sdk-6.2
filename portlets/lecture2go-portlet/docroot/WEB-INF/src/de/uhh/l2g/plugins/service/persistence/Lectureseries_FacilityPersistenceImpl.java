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

import de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException;
import de.uhh.l2g.plugins.model.Lectureseries_Facility;
import de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityImpl;
import de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the lectureseries_ facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_FacilityPersistence
 * @see Lectureseries_FacilityUtil
 * @generated
 */
public class Lectureseries_FacilityPersistenceImpl extends BasePersistenceImpl<Lectureseries_Facility>
	implements Lectureseries_FacilityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Lectureseries_FacilityUtil} to access the lectureseries_ facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Lectureseries_FacilityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESID =
		new FinderPath(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseriesId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID =
		new FinderPath(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseriesId",
			new String[] { Long.class.getName() },
			Lectureseries_FacilityModelImpl.LECTURESERIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIESID = new FinderPath(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLectureseriesId", new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureseries_ facilities where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Facility> findByLectureseriesId(
		long lectureseriesId) throws SystemException {
		return findByLectureseriesId(lectureseriesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ facilities where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ facilities
	 * @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	 * @return the range of matching lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Facility> findByLectureseriesId(
		long lectureseriesId, int start, int end) throws SystemException {
		return findByLectureseriesId(lectureseriesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ facilities where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ facilities
	 * @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Facility> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID;
			finderArgs = new Object[] { lectureseriesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESID;
			finderArgs = new Object[] {
					lectureseriesId,
					
					start, end, orderByComparator
				};
		}

		List<Lectureseries_Facility> list = (List<Lectureseries_Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Lectureseries_Facility lectureseries_Facility : list) {
				if ((lectureseriesId != lectureseries_Facility.getLectureseriesId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESID_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_FacilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Lectureseries_Facility>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Facility>(list);
				}
				else {
					list = (List<Lectureseries_Facility>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ facility in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a matching lectureseries_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility findByLectureseriesId_First(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_FacilityException, SystemException {
		Lectureseries_Facility lectureseries_Facility = fetchByLectureseriesId_First(lectureseriesId,
				orderByComparator);

		if (lectureseries_Facility != null) {
			return lectureseries_Facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_FacilityException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ facility in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ facility, or <code>null</code> if a matching lectureseries_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility fetchByLectureseriesId_First(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Lectureseries_Facility> list = findByLectureseriesId(lectureseriesId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ facility in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a matching lectureseries_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility findByLectureseriesId_Last(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_FacilityException, SystemException {
		Lectureseries_Facility lectureseries_Facility = fetchByLectureseriesId_Last(lectureseriesId,
				orderByComparator);

		if (lectureseries_Facility != null) {
			return lectureseries_Facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_FacilityException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ facility in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ facility, or <code>null</code> if a matching lectureseries_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility fetchByLectureseriesId_Last(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLectureseriesId(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Facility> list = findByLectureseriesId(lectureseriesId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ facilities before and after the current lectureseries_ facility in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesFacilityId the primary key of the current lectureseries_ facility
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a lectureseries_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility[] findByLectureseriesId_PrevAndNext(
		long lectureseriesFacilityId, long lectureseriesId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_FacilityException, SystemException {
		Lectureseries_Facility lectureseries_Facility = findByPrimaryKey(lectureseriesFacilityId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Facility[] array = new Lectureseries_FacilityImpl[3];

			array[0] = getByLectureseriesId_PrevAndNext(session,
					lectureseries_Facility, lectureseriesId, orderByComparator,
					true);

			array[1] = lectureseries_Facility;

			array[2] = getByLectureseriesId_PrevAndNext(session,
					lectureseries_Facility, lectureseriesId, orderByComparator,
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

	protected Lectureseries_Facility getByLectureseriesId_PrevAndNext(
		Session session, Lectureseries_Facility lectureseries_Facility,
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

		query.append(_SQL_SELECT_LECTURESERIES_FACILITY_WHERE);

		query.append(_FINDER_COLUMN_LECTURESERIESID_LECTURESERIESID_2);

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
			query.append(Lectureseries_FacilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Facility);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Facility> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ facilities where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLectureseriesId(long lectureseriesId)
		throws SystemException {
		for (Lectureseries_Facility lectureseries_Facility : findByLectureseriesId(
				lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Facility);
		}
	}

	/**
	 * Returns the number of lectureseries_ facilities where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLectureseriesId(long lectureseriesId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LECTURESERIESID;

		Object[] finderArgs = new Object[] { lectureseriesId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESID_LECTURESERIESID_2);

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

	private static final String _FINDER_COLUMN_LECTURESERIESID_LECTURESERIESID_2 =
		"lectureseries_Facility.lectureseriesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FACILITYID =
		new FinderPath(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFacilityId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITYID =
		new FinderPath(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFacilityId",
			new String[] { Long.class.getName() },
			Lectureseries_FacilityModelImpl.FACILITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FACILITYID = new FinderPath(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFacilityId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureseries_ facilities where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @return the matching lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Facility> findByFacilityId(long facilityId)
		throws SystemException {
		return findByFacilityId(facilityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ facilities where facilityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facilityId the facility ID
	 * @param start the lower bound of the range of lectureseries_ facilities
	 * @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	 * @return the range of matching lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Facility> findByFacilityId(long facilityId,
		int start, int end) throws SystemException {
		return findByFacilityId(facilityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ facilities where facilityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facilityId the facility ID
	 * @param start the lower bound of the range of lectureseries_ facilities
	 * @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Facility> findByFacilityId(long facilityId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITYID;
			finderArgs = new Object[] { facilityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FACILITYID;
			finderArgs = new Object[] { facilityId, start, end, orderByComparator };
		}

		List<Lectureseries_Facility> list = (List<Lectureseries_Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Lectureseries_Facility lectureseries_Facility : list) {
				if ((facilityId != lectureseries_Facility.getFacilityId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_FACILITYID_FACILITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_FacilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facilityId);

				if (!pagination) {
					list = (List<Lectureseries_Facility>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Facility>(list);
				}
				else {
					list = (List<Lectureseries_Facility>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ facility in the ordered set where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a matching lectureseries_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility findByFacilityId_First(long facilityId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_FacilityException, SystemException {
		Lectureseries_Facility lectureseries_Facility = fetchByFacilityId_First(facilityId,
				orderByComparator);

		if (lectureseries_Facility != null) {
			return lectureseries_Facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facilityId=");
		msg.append(facilityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_FacilityException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ facility in the ordered set where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ facility, or <code>null</code> if a matching lectureseries_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility fetchByFacilityId_First(long facilityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Lectureseries_Facility> list = findByFacilityId(facilityId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ facility in the ordered set where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a matching lectureseries_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility findByFacilityId_Last(long facilityId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_FacilityException, SystemException {
		Lectureseries_Facility lectureseries_Facility = fetchByFacilityId_Last(facilityId,
				orderByComparator);

		if (lectureseries_Facility != null) {
			return lectureseries_Facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facilityId=");
		msg.append(facilityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_FacilityException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ facility in the ordered set where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ facility, or <code>null</code> if a matching lectureseries_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility fetchByFacilityId_Last(long facilityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFacilityId(facilityId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Facility> list = findByFacilityId(facilityId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ facilities before and after the current lectureseries_ facility in the ordered set where facilityId = &#63;.
	 *
	 * @param lectureseriesFacilityId the primary key of the current lectureseries_ facility
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a lectureseries_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility[] findByFacilityId_PrevAndNext(
		long lectureseriesFacilityId, long facilityId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_FacilityException, SystemException {
		Lectureseries_Facility lectureseries_Facility = findByPrimaryKey(lectureseriesFacilityId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Facility[] array = new Lectureseries_FacilityImpl[3];

			array[0] = getByFacilityId_PrevAndNext(session,
					lectureseries_Facility, facilityId, orderByComparator, true);

			array[1] = lectureseries_Facility;

			array[2] = getByFacilityId_PrevAndNext(session,
					lectureseries_Facility, facilityId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lectureseries_Facility getByFacilityId_PrevAndNext(
		Session session, Lectureseries_Facility lectureseries_Facility,
		long facilityId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_FACILITY_WHERE);

		query.append(_FINDER_COLUMN_FACILITYID_FACILITYID_2);

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
			query.append(Lectureseries_FacilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(facilityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Facility);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Facility> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ facilities where facilityId = &#63; from the database.
	 *
	 * @param facilityId the facility ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFacilityId(long facilityId) throws SystemException {
		for (Lectureseries_Facility lectureseries_Facility : findByFacilityId(
				facilityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Facility);
		}
	}

	/**
	 * Returns the number of lectureseries_ facilities where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @return the number of matching lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFacilityId(long facilityId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FACILITYID;

		Object[] finderArgs = new Object[] { facilityId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_FACILITYID_FACILITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facilityId);

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

	private static final String _FINDER_COLUMN_FACILITYID_FACILITYID_2 = "lectureseries_Facility.facilityId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESIDANDFACILITYID =
		new FinderPath(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLectureseriesIdAndFacilityId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDFACILITYID =
		new FinderPath(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLectureseriesIdAndFacilityId",
			new String[] { Long.class.getName(), Long.class.getName() },
			Lectureseries_FacilityModelImpl.LECTURESERIESID_COLUMN_BITMASK |
			Lectureseries_FacilityModelImpl.FACILITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIESIDANDFACILITYID =
		new FinderPath(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLectureseriesIdAndFacilityId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the lectureseries_ facilities where lectureseriesId = &#63; and facilityId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param facilityId the facility ID
	 * @return the matching lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Facility> findByLectureseriesIdAndFacilityId(
		long lectureseriesId, long facilityId) throws SystemException {
		return findByLectureseriesIdAndFacilityId(lectureseriesId, facilityId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ facilities where lectureseriesId = &#63; and facilityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param facilityId the facility ID
	 * @param start the lower bound of the range of lectureseries_ facilities
	 * @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	 * @return the range of matching lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Facility> findByLectureseriesIdAndFacilityId(
		long lectureseriesId, long facilityId, int start, int end)
		throws SystemException {
		return findByLectureseriesIdAndFacilityId(lectureseriesId, facilityId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ facilities where lectureseriesId = &#63; and facilityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param facilityId the facility ID
	 * @param start the lower bound of the range of lectureseries_ facilities
	 * @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Facility> findByLectureseriesIdAndFacilityId(
		long lectureseriesId, long facilityId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDFACILITYID;
			finderArgs = new Object[] { lectureseriesId, facilityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESIDANDFACILITYID;
			finderArgs = new Object[] {
					lectureseriesId, facilityId,
					
					start, end, orderByComparator
				};
		}

		List<Lectureseries_Facility> list = (List<Lectureseries_Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Lectureseries_Facility lectureseries_Facility : list) {
				if ((lectureseriesId != lectureseries_Facility.getLectureseriesId()) ||
						(facilityId != lectureseries_Facility.getFacilityId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESIDANDFACILITYID_LECTURESERIESID_2);

			query.append(_FINDER_COLUMN_LECTURESERIESIDANDFACILITYID_FACILITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_FacilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				qPos.add(facilityId);

				if (!pagination) {
					list = (List<Lectureseries_Facility>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Facility>(list);
				}
				else {
					list = (List<Lectureseries_Facility>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ facility in the ordered set where lectureseriesId = &#63; and facilityId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a matching lectureseries_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility findByLectureseriesIdAndFacilityId_First(
		long lectureseriesId, long facilityId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_FacilityException, SystemException {
		Lectureseries_Facility lectureseries_Facility = fetchByLectureseriesIdAndFacilityId_First(lectureseriesId,
				facilityId, orderByComparator);

		if (lectureseries_Facility != null) {
			return lectureseries_Facility;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", facilityId=");
		msg.append(facilityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_FacilityException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ facility in the ordered set where lectureseriesId = &#63; and facilityId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ facility, or <code>null</code> if a matching lectureseries_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility fetchByLectureseriesIdAndFacilityId_First(
		long lectureseriesId, long facilityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Lectureseries_Facility> list = findByLectureseriesIdAndFacilityId(lectureseriesId,
				facilityId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ facility in the ordered set where lectureseriesId = &#63; and facilityId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a matching lectureseries_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility findByLectureseriesIdAndFacilityId_Last(
		long lectureseriesId, long facilityId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_FacilityException, SystemException {
		Lectureseries_Facility lectureseries_Facility = fetchByLectureseriesIdAndFacilityId_Last(lectureseriesId,
				facilityId, orderByComparator);

		if (lectureseries_Facility != null) {
			return lectureseries_Facility;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", facilityId=");
		msg.append(facilityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_FacilityException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ facility in the ordered set where lectureseriesId = &#63; and facilityId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ facility, or <code>null</code> if a matching lectureseries_ facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility fetchByLectureseriesIdAndFacilityId_Last(
		long lectureseriesId, long facilityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLectureseriesIdAndFacilityId(lectureseriesId,
				facilityId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Facility> list = findByLectureseriesIdAndFacilityId(lectureseriesId,
				facilityId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ facilities before and after the current lectureseries_ facility in the ordered set where lectureseriesId = &#63; and facilityId = &#63;.
	 *
	 * @param lectureseriesFacilityId the primary key of the current lectureseries_ facility
	 * @param lectureseriesId the lectureseries ID
	 * @param facilityId the facility ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a lectureseries_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility[] findByLectureseriesIdAndFacilityId_PrevAndNext(
		long lectureseriesFacilityId, long lectureseriesId, long facilityId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_FacilityException, SystemException {
		Lectureseries_Facility lectureseries_Facility = findByPrimaryKey(lectureseriesFacilityId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Facility[] array = new Lectureseries_FacilityImpl[3];

			array[0] = getByLectureseriesIdAndFacilityId_PrevAndNext(session,
					lectureseries_Facility, lectureseriesId, facilityId,
					orderByComparator, true);

			array[1] = lectureseries_Facility;

			array[2] = getByLectureseriesIdAndFacilityId_PrevAndNext(session,
					lectureseries_Facility, lectureseriesId, facilityId,
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

	protected Lectureseries_Facility getByLectureseriesIdAndFacilityId_PrevAndNext(
		Session session, Lectureseries_Facility lectureseries_Facility,
		long lectureseriesId, long facilityId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_FACILITY_WHERE);

		query.append(_FINDER_COLUMN_LECTURESERIESIDANDFACILITYID_LECTURESERIESID_2);

		query.append(_FINDER_COLUMN_LECTURESERIESIDANDFACILITYID_FACILITYID_2);

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
			query.append(Lectureseries_FacilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		qPos.add(facilityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Facility);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Facility> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ facilities where lectureseriesId = &#63; and facilityId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param facilityId the facility ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLectureseriesIdAndFacilityId(long lectureseriesId,
		long facilityId) throws SystemException {
		for (Lectureseries_Facility lectureseries_Facility : findByLectureseriesIdAndFacilityId(
				lectureseriesId, facilityId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Facility);
		}
	}

	/**
	 * Returns the number of lectureseries_ facilities where lectureseriesId = &#63; and facilityId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param facilityId the facility ID
	 * @return the number of matching lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLectureseriesIdAndFacilityId(long lectureseriesId,
		long facilityId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LECTURESERIESIDANDFACILITYID;

		Object[] finderArgs = new Object[] { lectureseriesId, facilityId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LECTURESERIES_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESIDANDFACILITYID_LECTURESERIESID_2);

			query.append(_FINDER_COLUMN_LECTURESERIESIDANDFACILITYID_FACILITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				qPos.add(facilityId);

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

	private static final String _FINDER_COLUMN_LECTURESERIESIDANDFACILITYID_LECTURESERIESID_2 =
		"lectureseries_Facility.lectureseriesId = ? AND ";
	private static final String _FINDER_COLUMN_LECTURESERIESIDANDFACILITYID_FACILITYID_2 =
		"lectureseries_Facility.facilityId = ?";

	public Lectureseries_FacilityPersistenceImpl() {
		setModelClass(Lectureseries_Facility.class);
	}

	/**
	 * Caches the lectureseries_ facility in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Facility the lectureseries_ facility
	 */
	@Override
	public void cacheResult(Lectureseries_Facility lectureseries_Facility) {
		EntityCacheUtil.putResult(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityImpl.class,
			lectureseries_Facility.getPrimaryKey(), lectureseries_Facility);

		lectureseries_Facility.resetOriginalValues();
	}

	/**
	 * Caches the lectureseries_ facilities in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Facilities the lectureseries_ facilities
	 */
	@Override
	public void cacheResult(
		List<Lectureseries_Facility> lectureseries_Facilities) {
		for (Lectureseries_Facility lectureseries_Facility : lectureseries_Facilities) {
			if (EntityCacheUtil.getResult(
						Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
						Lectureseries_FacilityImpl.class,
						lectureseries_Facility.getPrimaryKey()) == null) {
				cacheResult(lectureseries_Facility);
			}
			else {
				lectureseries_Facility.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lectureseries_ facilities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Lectureseries_FacilityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Lectureseries_FacilityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lectureseries_ facility.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lectureseries_Facility lectureseries_Facility) {
		EntityCacheUtil.removeResult(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityImpl.class,
			lectureseries_Facility.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Lectureseries_Facility> lectureseries_Facilities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lectureseries_Facility lectureseries_Facility : lectureseries_Facilities) {
			EntityCacheUtil.removeResult(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
				Lectureseries_FacilityImpl.class,
				lectureseries_Facility.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lectureseries_ facility with the primary key. Does not add the lectureseries_ facility to the database.
	 *
	 * @param lectureseriesFacilityId the primary key for the new lectureseries_ facility
	 * @return the new lectureseries_ facility
	 */
	@Override
	public Lectureseries_Facility create(long lectureseriesFacilityId) {
		Lectureseries_Facility lectureseries_Facility = new Lectureseries_FacilityImpl();

		lectureseries_Facility.setNew(true);
		lectureseries_Facility.setPrimaryKey(lectureseriesFacilityId);

		return lectureseries_Facility;
	}

	/**
	 * Removes the lectureseries_ facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesFacilityId the primary key of the lectureseries_ facility
	 * @return the lectureseries_ facility that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a lectureseries_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility remove(long lectureseriesFacilityId)
		throws NoSuchLectureseries_FacilityException, SystemException {
		return remove((Serializable)lectureseriesFacilityId);
	}

	/**
	 * Removes the lectureseries_ facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lectureseries_ facility
	 * @return the lectureseries_ facility that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a lectureseries_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility remove(Serializable primaryKey)
		throws NoSuchLectureseries_FacilityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Lectureseries_Facility lectureseries_Facility = (Lectureseries_Facility)session.get(Lectureseries_FacilityImpl.class,
					primaryKey);

			if (lectureseries_Facility == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLectureseries_FacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lectureseries_Facility);
		}
		catch (NoSuchLectureseries_FacilityException nsee) {
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
	protected Lectureseries_Facility removeImpl(
		Lectureseries_Facility lectureseries_Facility)
		throws SystemException {
		lectureseries_Facility = toUnwrappedModel(lectureseries_Facility);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lectureseries_Facility)) {
				lectureseries_Facility = (Lectureseries_Facility)session.get(Lectureseries_FacilityImpl.class,
						lectureseries_Facility.getPrimaryKeyObj());
			}

			if (lectureseries_Facility != null) {
				session.delete(lectureseries_Facility);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lectureseries_Facility != null) {
			clearCache(lectureseries_Facility);
		}

		return lectureseries_Facility;
	}

	@Override
	public Lectureseries_Facility updateImpl(
		de.uhh.l2g.plugins.model.Lectureseries_Facility lectureseries_Facility)
		throws SystemException {
		lectureseries_Facility = toUnwrappedModel(lectureseries_Facility);

		boolean isNew = lectureseries_Facility.isNew();

		Lectureseries_FacilityModelImpl lectureseries_FacilityModelImpl = (Lectureseries_FacilityModelImpl)lectureseries_Facility;

		Session session = null;

		try {
			session = openSession();

			if (lectureseries_Facility.isNew()) {
				session.save(lectureseries_Facility);

				lectureseries_Facility.setNew(false);
			}
			else {
				session.merge(lectureseries_Facility);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Lectureseries_FacilityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lectureseries_FacilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_FacilityModelImpl.getOriginalLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID,
					args);

				args = new Object[] {
						lectureseries_FacilityModelImpl.getLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID,
					args);
			}

			if ((lectureseries_FacilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_FacilityModelImpl.getOriginalFacilityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITYID,
					args);

				args = new Object[] {
						lectureseries_FacilityModelImpl.getFacilityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACILITYID,
					args);
			}

			if ((lectureseries_FacilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDFACILITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_FacilityModelImpl.getOriginalLectureseriesId(),
						lectureseries_FacilityModelImpl.getOriginalFacilityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESIDANDFACILITYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDFACILITYID,
					args);

				args = new Object[] {
						lectureseries_FacilityModelImpl.getLectureseriesId(),
						lectureseries_FacilityModelImpl.getFacilityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESIDANDFACILITYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDFACILITYID,
					args);
			}
		}

		EntityCacheUtil.putResult(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_FacilityImpl.class,
			lectureseries_Facility.getPrimaryKey(), lectureseries_Facility);

		return lectureseries_Facility;
	}

	protected Lectureseries_Facility toUnwrappedModel(
		Lectureseries_Facility lectureseries_Facility) {
		if (lectureseries_Facility instanceof Lectureseries_FacilityImpl) {
			return lectureseries_Facility;
		}

		Lectureseries_FacilityImpl lectureseries_FacilityImpl = new Lectureseries_FacilityImpl();

		lectureseries_FacilityImpl.setNew(lectureseries_Facility.isNew());
		lectureseries_FacilityImpl.setPrimaryKey(lectureseries_Facility.getPrimaryKey());

		lectureseries_FacilityImpl.setLectureseriesFacilityId(lectureseries_Facility.getLectureseriesFacilityId());
		lectureseries_FacilityImpl.setLectureseriesId(lectureseries_Facility.getLectureseriesId());
		lectureseries_FacilityImpl.setFacilityId(lectureseries_Facility.getFacilityId());

		return lectureseries_FacilityImpl;
	}

	/**
	 * Returns the lectureseries_ facility with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries_ facility
	 * @return the lectureseries_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a lectureseries_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLectureseries_FacilityException, SystemException {
		Lectureseries_Facility lectureseries_Facility = fetchByPrimaryKey(primaryKey);

		if (lectureseries_Facility == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLectureseries_FacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lectureseries_Facility;
	}

	/**
	 * Returns the lectureseries_ facility with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException} if it could not be found.
	 *
	 * @param lectureseriesFacilityId the primary key of the lectureseries_ facility
	 * @return the lectureseries_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a lectureseries_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility findByPrimaryKey(long lectureseriesFacilityId)
		throws NoSuchLectureseries_FacilityException, SystemException {
		return findByPrimaryKey((Serializable)lectureseriesFacilityId);
	}

	/**
	 * Returns the lectureseries_ facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries_ facility
	 * @return the lectureseries_ facility, or <code>null</code> if a lectureseries_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Lectureseries_Facility lectureseries_Facility = (Lectureseries_Facility)EntityCacheUtil.getResult(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
				Lectureseries_FacilityImpl.class, primaryKey);

		if (lectureseries_Facility == _nullLectureseries_Facility) {
			return null;
		}

		if (lectureseries_Facility == null) {
			Session session = null;

			try {
				session = openSession();

				lectureseries_Facility = (Lectureseries_Facility)session.get(Lectureseries_FacilityImpl.class,
						primaryKey);

				if (lectureseries_Facility != null) {
					cacheResult(lectureseries_Facility);
				}
				else {
					EntityCacheUtil.putResult(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
						Lectureseries_FacilityImpl.class, primaryKey,
						_nullLectureseries_Facility);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Lectureseries_FacilityModelImpl.ENTITY_CACHE_ENABLED,
					Lectureseries_FacilityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lectureseries_Facility;
	}

	/**
	 * Returns the lectureseries_ facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesFacilityId the primary key of the lectureseries_ facility
	 * @return the lectureseries_ facility, or <code>null</code> if a lectureseries_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Facility fetchByPrimaryKey(
		long lectureseriesFacilityId) throws SystemException {
		return fetchByPrimaryKey((Serializable)lectureseriesFacilityId);
	}

	/**
	 * Returns all the lectureseries_ facilities.
	 *
	 * @return the lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Facility> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ facilities
	 * @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	 * @return the range of lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Facility> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ facilities
	 * @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lectureseries_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Facility> findAll(int start, int end,
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

		List<Lectureseries_Facility> list = (List<Lectureseries_Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LECTURESERIES_FACILITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LECTURESERIES_FACILITY;

				if (pagination) {
					sql = sql.concat(Lectureseries_FacilityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Lectureseries_Facility>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Facility>(list);
				}
				else {
					list = (List<Lectureseries_Facility>)QueryUtil.list(q,
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
	 * Removes all the lectureseries_ facilities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Lectureseries_Facility lectureseries_Facility : findAll()) {
			remove(lectureseries_Facility);
		}
	}

	/**
	 * Returns the number of lectureseries_ facilities.
	 *
	 * @return the number of lectureseries_ facilities
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

				Query q = session.createQuery(_SQL_COUNT_LECTURESERIES_FACILITY);

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
	 * Initializes the lectureseries_ facility persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Lectureseries_Facility")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Lectureseries_Facility>> listenersList = new ArrayList<ModelListener<Lectureseries_Facility>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Lectureseries_Facility>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Lectureseries_FacilityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LECTURESERIES_FACILITY = "SELECT lectureseries_Facility FROM Lectureseries_Facility lectureseries_Facility";
	private static final String _SQL_SELECT_LECTURESERIES_FACILITY_WHERE = "SELECT lectureseries_Facility FROM Lectureseries_Facility lectureseries_Facility WHERE ";
	private static final String _SQL_COUNT_LECTURESERIES_FACILITY = "SELECT COUNT(lectureseries_Facility) FROM Lectureseries_Facility lectureseries_Facility";
	private static final String _SQL_COUNT_LECTURESERIES_FACILITY_WHERE = "SELECT COUNT(lectureseries_Facility) FROM Lectureseries_Facility lectureseries_Facility WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lectureseries_Facility.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lectureseries_Facility exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Lectureseries_Facility exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Lectureseries_FacilityPersistenceImpl.class);
	private static Lectureseries_Facility _nullLectureseries_Facility = new Lectureseries_FacilityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Lectureseries_Facility> toCacheModel() {
				return _nullLectureseries_FacilityCacheModel;
			}
		};

	private static CacheModel<Lectureseries_Facility> _nullLectureseries_FacilityCacheModel =
		new CacheModel<Lectureseries_Facility>() {
			@Override
			public Lectureseries_Facility toEntityModel() {
				return _nullLectureseries_Facility;
			}
		};
}