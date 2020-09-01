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

import de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException;
import de.uhh.l2g.plugins.model.Producer_Lectureseries;
import de.uhh.l2g.plugins.model.impl.Producer_LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the producer_ lectureseries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Producer_LectureseriesPersistence
 * @see Producer_LectureseriesUtil
 * @generated
 */
public class Producer_LectureseriesPersistenceImpl extends BasePersistenceImpl<Producer_Lectureseries>
	implements Producer_LectureseriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Producer_LectureseriesUtil} to access the producer_ lectureseries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Producer_LectureseriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESID =
		new FinderPath(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseriesId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID =
		new FinderPath(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseriesId",
			new String[] { Long.class.getName() },
			Producer_LectureseriesModelImpl.LECTURESERIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIESID = new FinderPath(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLectureseriesId", new String[] { Long.class.getName() });

	/**
	 * Returns all the producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId) throws SystemException {
		return findByLectureseriesId(lectureseriesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of matching producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId, int start, int end) throws SystemException {
		return findByLectureseriesId(lectureseriesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer_Lectureseries> findByLectureseriesId(
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

		List<Producer_Lectureseries> list = (List<Producer_Lectureseries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Producer_Lectureseries producer_Lectureseries : list) {
				if ((lectureseriesId != producer_Lectureseries.getLectureseriesId())) {
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

			query.append(_SQL_SELECT_PRODUCER_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESID_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Producer_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Producer_Lectureseries>(list);
				}
				else {
					list = (List<Producer_Lectureseries>)QueryUtil.list(q,
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
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries findByLectureseriesId_First(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchProducer_LectureseriesException, SystemException {
		Producer_Lectureseries producer_Lectureseries = fetchByLectureseriesId_First(lectureseriesId,
				orderByComparator);

		if (producer_Lectureseries != null) {
			return producer_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducer_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries fetchByLectureseriesId_First(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Producer_Lectureseries> list = findByLectureseriesId(lectureseriesId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries findByLectureseriesId_Last(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchProducer_LectureseriesException, SystemException {
		Producer_Lectureseries producer_Lectureseries = fetchByLectureseriesId_Last(lectureseriesId,
				orderByComparator);

		if (producer_Lectureseries != null) {
			return producer_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducer_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries fetchByLectureseriesId_Last(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLectureseriesId(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Producer_Lectureseries> list = findByLectureseriesId(lectureseriesId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param producerLectureseriesId the primary key of the current producer_ lectureseries
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries[] findByLectureseriesId_PrevAndNext(
		long producerLectureseriesId, long lectureseriesId,
		OrderByComparator orderByComparator)
		throws NoSuchProducer_LectureseriesException, SystemException {
		Producer_Lectureseries producer_Lectureseries = findByPrimaryKey(producerLectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Producer_Lectureseries[] array = new Producer_LectureseriesImpl[3];

			array[0] = getByLectureseriesId_PrevAndNext(session,
					producer_Lectureseries, lectureseriesId, orderByComparator,
					true);

			array[1] = producer_Lectureseries;

			array[2] = getByLectureseriesId_PrevAndNext(session,
					producer_Lectureseries, lectureseriesId, orderByComparator,
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

	protected Producer_Lectureseries getByLectureseriesId_PrevAndNext(
		Session session, Producer_Lectureseries producer_Lectureseries,
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

		query.append(_SQL_SELECT_PRODUCER_LECTURESERIES_WHERE);

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
			query.append(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(producer_Lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Producer_Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producer_ lectureserieses where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLectureseriesId(long lectureseriesId)
		throws SystemException {
		for (Producer_Lectureseries producer_Lectureseries : findByLectureseriesId(
				lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(producer_Lectureseries);
		}
	}

	/**
	 * Returns the number of producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching producer_ lectureserieses
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

			query.append(_SQL_COUNT_PRODUCER_LECTURESERIES_WHERE);

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
		"producer_Lectureseries.lectureseriesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCERID =
		new FinderPath(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProducerId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERID =
		new FinderPath(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProducerId",
			new String[] { Long.class.getName() },
			Producer_LectureseriesModelImpl.PRODUCERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCERID = new FinderPath(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProducerId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the producer_ lectureserieses where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the matching producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer_Lectureseries> findByProducerId(long producerId)
		throws SystemException {
		return findByProducerId(producerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producer_ lectureserieses where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of matching producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer_Lectureseries> findByProducerId(long producerId,
		int start, int end) throws SystemException {
		return findByProducerId(producerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer_Lectureseries> findByProducerId(long producerId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERID;
			finderArgs = new Object[] { producerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCERID;
			finderArgs = new Object[] { producerId, start, end, orderByComparator };
		}

		List<Producer_Lectureseries> list = (List<Producer_Lectureseries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Producer_Lectureseries producer_Lectureseries : list) {
				if ((producerId != producer_Lectureseries.getProducerId())) {
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

			query.append(_SQL_SELECT_PRODUCER_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERID_PRODUCERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				if (!pagination) {
					list = (List<Producer_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Producer_Lectureseries>(list);
				}
				else {
					list = (List<Producer_Lectureseries>)QueryUtil.list(q,
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
	 * Returns the first producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries findByProducerId_First(long producerId,
		OrderByComparator orderByComparator)
		throws NoSuchProducer_LectureseriesException, SystemException {
		Producer_Lectureseries producer_Lectureseries = fetchByProducerId_First(producerId,
				orderByComparator);

		if (producer_Lectureseries != null) {
			return producer_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducer_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries fetchByProducerId_First(long producerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Producer_Lectureseries> list = findByProducerId(producerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries findByProducerId_Last(long producerId,
		OrderByComparator orderByComparator)
		throws NoSuchProducer_LectureseriesException, SystemException {
		Producer_Lectureseries producer_Lectureseries = fetchByProducerId_Last(producerId,
				orderByComparator);

		if (producer_Lectureseries != null) {
			return producer_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducer_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries fetchByProducerId_Last(long producerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProducerId(producerId);

		if (count == 0) {
			return null;
		}

		List<Producer_Lectureseries> list = findByProducerId(producerId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerLectureseriesId the primary key of the current producer_ lectureseries
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries[] findByProducerId_PrevAndNext(
		long producerLectureseriesId, long producerId,
		OrderByComparator orderByComparator)
		throws NoSuchProducer_LectureseriesException, SystemException {
		Producer_Lectureseries producer_Lectureseries = findByPrimaryKey(producerLectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Producer_Lectureseries[] array = new Producer_LectureseriesImpl[3];

			array[0] = getByProducerId_PrevAndNext(session,
					producer_Lectureseries, producerId, orderByComparator, true);

			array[1] = producer_Lectureseries;

			array[2] = getByProducerId_PrevAndNext(session,
					producer_Lectureseries, producerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Producer_Lectureseries getByProducerId_PrevAndNext(
		Session session, Producer_Lectureseries producer_Lectureseries,
		long producerId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCER_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_PRODUCERID_PRODUCERID_2);

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
			query.append(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(producerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(producer_Lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Producer_Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producer_ lectureserieses where producerId = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProducerId(long producerId) throws SystemException {
		for (Producer_Lectureseries producer_Lectureseries : findByProducerId(
				producerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(producer_Lectureseries);
		}
	}

	/**
	 * Returns the number of producer_ lectureserieses where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the number of matching producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProducerId(long producerId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCERID;

		Object[] finderArgs = new Object[] { producerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCER_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERID_PRODUCERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

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

	private static final String _FINDER_COLUMN_PRODUCERID_PRODUCERID_2 = "producer_Lectureseries.producerId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESIDANDPRODUCERID =
		new FinderPath(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLectureseriesIdAndProducerId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDPRODUCERID =
		new FinderPath(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLectureseriesIdAndProducerId",
			new String[] { Long.class.getName(), Long.class.getName() },
			Producer_LectureseriesModelImpl.LECTURESERIESID_COLUMN_BITMASK |
			Producer_LectureseriesModelImpl.PRODUCERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIESIDANDPRODUCERID =
		new FinderPath(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLectureseriesIdAndProducerId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @return the matching producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer_Lectureseries> findByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId) throws SystemException {
		return findByLectureseriesIdAndProducerId(lectureseriesId, producerId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of matching producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer_Lectureseries> findByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId, int start, int end)
		throws SystemException {
		return findByLectureseriesIdAndProducerId(lectureseriesId, producerId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer_Lectureseries> findByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDPRODUCERID;
			finderArgs = new Object[] { lectureseriesId, producerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESIDANDPRODUCERID;
			finderArgs = new Object[] {
					lectureseriesId, producerId,
					
					start, end, orderByComparator
				};
		}

		List<Producer_Lectureseries> list = (List<Producer_Lectureseries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Producer_Lectureseries producer_Lectureseries : list) {
				if ((lectureseriesId != producer_Lectureseries.getLectureseriesId()) ||
						(producerId != producer_Lectureseries.getProducerId())) {
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

			query.append(_SQL_SELECT_PRODUCER_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_LECTURESERIESID_2);

			query.append(_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_PRODUCERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				qPos.add(producerId);

				if (!pagination) {
					list = (List<Producer_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Producer_Lectureseries>(list);
				}
				else {
					list = (List<Producer_Lectureseries>)QueryUtil.list(q,
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
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries findByLectureseriesIdAndProducerId_First(
		long lectureseriesId, long producerId,
		OrderByComparator orderByComparator)
		throws NoSuchProducer_LectureseriesException, SystemException {
		Producer_Lectureseries producer_Lectureseries = fetchByLectureseriesIdAndProducerId_First(lectureseriesId,
				producerId, orderByComparator);

		if (producer_Lectureseries != null) {
			return producer_Lectureseries;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", producerId=");
		msg.append(producerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducer_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries fetchByLectureseriesIdAndProducerId_First(
		long lectureseriesId, long producerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Producer_Lectureseries> list = findByLectureseriesIdAndProducerId(lectureseriesId,
				producerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries findByLectureseriesIdAndProducerId_Last(
		long lectureseriesId, long producerId,
		OrderByComparator orderByComparator)
		throws NoSuchProducer_LectureseriesException, SystemException {
		Producer_Lectureseries producer_Lectureseries = fetchByLectureseriesIdAndProducerId_Last(lectureseriesId,
				producerId, orderByComparator);

		if (producer_Lectureseries != null) {
			return producer_Lectureseries;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", producerId=");
		msg.append(producerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducer_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries fetchByLectureseriesIdAndProducerId_Last(
		long lectureseriesId, long producerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLectureseriesIdAndProducerId(lectureseriesId,
				producerId);

		if (count == 0) {
			return null;
		}

		List<Producer_Lectureseries> list = findByLectureseriesIdAndProducerId(lectureseriesId,
				producerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param producerLectureseriesId the primary key of the current producer_ lectureseries
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries[] findByLectureseriesIdAndProducerId_PrevAndNext(
		long producerLectureseriesId, long lectureseriesId, long producerId,
		OrderByComparator orderByComparator)
		throws NoSuchProducer_LectureseriesException, SystemException {
		Producer_Lectureseries producer_Lectureseries = findByPrimaryKey(producerLectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Producer_Lectureseries[] array = new Producer_LectureseriesImpl[3];

			array[0] = getByLectureseriesIdAndProducerId_PrevAndNext(session,
					producer_Lectureseries, lectureseriesId, producerId,
					orderByComparator, true);

			array[1] = producer_Lectureseries;

			array[2] = getByLectureseriesIdAndProducerId_PrevAndNext(session,
					producer_Lectureseries, lectureseriesId, producerId,
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

	protected Producer_Lectureseries getByLectureseriesIdAndProducerId_PrevAndNext(
		Session session, Producer_Lectureseries producer_Lectureseries,
		long lectureseriesId, long producerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCER_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_LECTURESERIESID_2);

		query.append(_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_PRODUCERID_2);

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
			query.append(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		qPos.add(producerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(producer_Lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Producer_Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLectureseriesIdAndProducerId(long lectureseriesId,
		long producerId) throws SystemException {
		for (Producer_Lectureseries producer_Lectureseries : findByLectureseriesIdAndProducerId(
				lectureseriesId, producerId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(producer_Lectureseries);
		}
	}

	/**
	 * Returns the number of producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @return the number of matching producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLectureseriesIdAndProducerId(long lectureseriesId,
		long producerId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LECTURESERIESIDANDPRODUCERID;

		Object[] finderArgs = new Object[] { lectureseriesId, producerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRODUCER_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_LECTURESERIESID_2);

			query.append(_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_PRODUCERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				qPos.add(producerId);

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

	private static final String _FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_LECTURESERIESID_2 =
		"producer_Lectureseries.lectureseriesId = ? AND ";
	private static final String _FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_PRODUCERID_2 =
		"producer_Lectureseries.producerId = ?";

	public Producer_LectureseriesPersistenceImpl() {
		setModelClass(Producer_Lectureseries.class);
	}

	/**
	 * Caches the producer_ lectureseries in the entity cache if it is enabled.
	 *
	 * @param producer_Lectureseries the producer_ lectureseries
	 */
	@Override
	public void cacheResult(Producer_Lectureseries producer_Lectureseries) {
		EntityCacheUtil.putResult(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			producer_Lectureseries.getPrimaryKey(), producer_Lectureseries);

		producer_Lectureseries.resetOriginalValues();
	}

	/**
	 * Caches the producer_ lectureserieses in the entity cache if it is enabled.
	 *
	 * @param producer_Lectureserieses the producer_ lectureserieses
	 */
	@Override
	public void cacheResult(
		List<Producer_Lectureseries> producer_Lectureserieses) {
		for (Producer_Lectureseries producer_Lectureseries : producer_Lectureserieses) {
			if (EntityCacheUtil.getResult(
						Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
						Producer_LectureseriesImpl.class,
						producer_Lectureseries.getPrimaryKey()) == null) {
				cacheResult(producer_Lectureseries);
			}
			else {
				producer_Lectureseries.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all producer_ lectureserieses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Producer_LectureseriesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Producer_LectureseriesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the producer_ lectureseries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Producer_Lectureseries producer_Lectureseries) {
		EntityCacheUtil.removeResult(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			producer_Lectureseries.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Producer_Lectureseries> producer_Lectureserieses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Producer_Lectureseries producer_Lectureseries : producer_Lectureserieses) {
			EntityCacheUtil.removeResult(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
				Producer_LectureseriesImpl.class,
				producer_Lectureseries.getPrimaryKey());
		}
	}

	/**
	 * Creates a new producer_ lectureseries with the primary key. Does not add the producer_ lectureseries to the database.
	 *
	 * @param producerLectureseriesId the primary key for the new producer_ lectureseries
	 * @return the new producer_ lectureseries
	 */
	@Override
	public Producer_Lectureseries create(long producerLectureseriesId) {
		Producer_Lectureseries producer_Lectureseries = new Producer_LectureseriesImpl();

		producer_Lectureseries.setNew(true);
		producer_Lectureseries.setPrimaryKey(producerLectureseriesId);

		return producer_Lectureseries;
	}

	/**
	 * Removes the producer_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries remove(long producerLectureseriesId)
		throws NoSuchProducer_LectureseriesException, SystemException {
		return remove((Serializable)producerLectureseriesId);
	}

	/**
	 * Removes the producer_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries remove(Serializable primaryKey)
		throws NoSuchProducer_LectureseriesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Producer_Lectureseries producer_Lectureseries = (Producer_Lectureseries)session.get(Producer_LectureseriesImpl.class,
					primaryKey);

			if (producer_Lectureseries == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProducer_LectureseriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(producer_Lectureseries);
		}
		catch (NoSuchProducer_LectureseriesException nsee) {
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
	protected Producer_Lectureseries removeImpl(
		Producer_Lectureseries producer_Lectureseries)
		throws SystemException {
		producer_Lectureseries = toUnwrappedModel(producer_Lectureseries);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(producer_Lectureseries)) {
				producer_Lectureseries = (Producer_Lectureseries)session.get(Producer_LectureseriesImpl.class,
						producer_Lectureseries.getPrimaryKeyObj());
			}

			if (producer_Lectureseries != null) {
				session.delete(producer_Lectureseries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (producer_Lectureseries != null) {
			clearCache(producer_Lectureseries);
		}

		return producer_Lectureseries;
	}

	@Override
	public Producer_Lectureseries updateImpl(
		de.uhh.l2g.plugins.model.Producer_Lectureseries producer_Lectureseries)
		throws SystemException {
		producer_Lectureseries = toUnwrappedModel(producer_Lectureseries);

		boolean isNew = producer_Lectureseries.isNew();

		Producer_LectureseriesModelImpl producer_LectureseriesModelImpl = (Producer_LectureseriesModelImpl)producer_Lectureseries;

		Session session = null;

		try {
			session = openSession();

			if (producer_Lectureseries.isNew()) {
				session.save(producer_Lectureseries);

				producer_Lectureseries.setNew(false);
			}
			else {
				session.merge(producer_Lectureseries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Producer_LectureseriesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((producer_LectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						producer_LectureseriesModelImpl.getOriginalLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID,
					args);

				args = new Object[] {
						producer_LectureseriesModelImpl.getLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID,
					args);
			}

			if ((producer_LectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						producer_LectureseriesModelImpl.getOriginalProducerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERID,
					args);

				args = new Object[] {
						producer_LectureseriesModelImpl.getProducerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCERID,
					args);
			}

			if ((producer_LectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDPRODUCERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						producer_LectureseriesModelImpl.getOriginalLectureseriesId(),
						producer_LectureseriesModelImpl.getOriginalProducerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESIDANDPRODUCERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDPRODUCERID,
					args);

				args = new Object[] {
						producer_LectureseriesModelImpl.getLectureseriesId(),
						producer_LectureseriesModelImpl.getProducerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESIDANDPRODUCERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDPRODUCERID,
					args);
			}
		}

		EntityCacheUtil.putResult(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			producer_Lectureseries.getPrimaryKey(), producer_Lectureseries);

		return producer_Lectureseries;
	}

	protected Producer_Lectureseries toUnwrappedModel(
		Producer_Lectureseries producer_Lectureseries) {
		if (producer_Lectureseries instanceof Producer_LectureseriesImpl) {
			return producer_Lectureseries;
		}

		Producer_LectureseriesImpl producer_LectureseriesImpl = new Producer_LectureseriesImpl();

		producer_LectureseriesImpl.setNew(producer_Lectureseries.isNew());
		producer_LectureseriesImpl.setPrimaryKey(producer_Lectureseries.getPrimaryKey());

		producer_LectureseriesImpl.setProducerLectureseriesId(producer_Lectureseries.getProducerLectureseriesId());
		producer_LectureseriesImpl.setLectureseriesId(producer_Lectureseries.getLectureseriesId());
		producer_LectureseriesImpl.setProducerId(producer_Lectureseries.getProducerId());

		return producer_LectureseriesImpl;
	}

	/**
	 * Returns the producer_ lectureseries with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProducer_LectureseriesException, SystemException {
		Producer_Lectureseries producer_Lectureseries = fetchByPrimaryKey(primaryKey);

		if (producer_Lectureseries == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProducer_LectureseriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return producer_Lectureseries;
	}

	/**
	 * Returns the producer_ lectureseries with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException} if it could not be found.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries
	 * @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries findByPrimaryKey(long producerLectureseriesId)
		throws NoSuchProducer_LectureseriesException, SystemException {
		return findByPrimaryKey((Serializable)producerLectureseriesId);
	}

	/**
	 * Returns the producer_ lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries, or <code>null</code> if a producer_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Producer_Lectureseries producer_Lectureseries = (Producer_Lectureseries)EntityCacheUtil.getResult(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
				Producer_LectureseriesImpl.class, primaryKey);

		if (producer_Lectureseries == _nullProducer_Lectureseries) {
			return null;
		}

		if (producer_Lectureseries == null) {
			Session session = null;

			try {
				session = openSession();

				producer_Lectureseries = (Producer_Lectureseries)session.get(Producer_LectureseriesImpl.class,
						primaryKey);

				if (producer_Lectureseries != null) {
					cacheResult(producer_Lectureseries);
				}
				else {
					EntityCacheUtil.putResult(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
						Producer_LectureseriesImpl.class, primaryKey,
						_nullProducer_Lectureseries);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
					Producer_LectureseriesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return producer_Lectureseries;
	}

	/**
	 * Returns the producer_ lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries, or <code>null</code> if a producer_ lectureseries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer_Lectureseries fetchByPrimaryKey(
		long producerLectureseriesId) throws SystemException {
		return fetchByPrimaryKey((Serializable)producerLectureseriesId);
	}

	/**
	 * Returns all the producer_ lectureserieses.
	 *
	 * @return the producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer_Lectureseries> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producer_ lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer_Lectureseries> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the producer_ lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of producer_ lectureserieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer_Lectureseries> findAll(int start, int end,
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

		List<Producer_Lectureseries> list = (List<Producer_Lectureseries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRODUCER_LECTURESERIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCER_LECTURESERIES;

				if (pagination) {
					sql = sql.concat(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Producer_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Producer_Lectureseries>(list);
				}
				else {
					list = (List<Producer_Lectureseries>)QueryUtil.list(q,
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
	 * Removes all the producer_ lectureserieses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Producer_Lectureseries producer_Lectureseries : findAll()) {
			remove(producer_Lectureseries);
		}
	}

	/**
	 * Returns the number of producer_ lectureserieses.
	 *
	 * @return the number of producer_ lectureserieses
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

				Query q = session.createQuery(_SQL_COUNT_PRODUCER_LECTURESERIES);

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
	 * Initializes the producer_ lectureseries persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Producer_Lectureseries")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Producer_Lectureseries>> listenersList = new ArrayList<ModelListener<Producer_Lectureseries>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Producer_Lectureseries>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Producer_LectureseriesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PRODUCER_LECTURESERIES = "SELECT producer_Lectureseries FROM Producer_Lectureseries producer_Lectureseries";
	private static final String _SQL_SELECT_PRODUCER_LECTURESERIES_WHERE = "SELECT producer_Lectureseries FROM Producer_Lectureseries producer_Lectureseries WHERE ";
	private static final String _SQL_COUNT_PRODUCER_LECTURESERIES = "SELECT COUNT(producer_Lectureseries) FROM Producer_Lectureseries producer_Lectureseries";
	private static final String _SQL_COUNT_PRODUCER_LECTURESERIES_WHERE = "SELECT COUNT(producer_Lectureseries) FROM Producer_Lectureseries producer_Lectureseries WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "producer_Lectureseries.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Producer_Lectureseries exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Producer_Lectureseries exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Producer_LectureseriesPersistenceImpl.class);
	private static Producer_Lectureseries _nullProducer_Lectureseries = new Producer_LectureseriesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Producer_Lectureseries> toCacheModel() {
				return _nullProducer_LectureseriesCacheModel;
			}
		};

	private static CacheModel<Producer_Lectureseries> _nullProducer_LectureseriesCacheModel =
		new CacheModel<Producer_Lectureseries>() {
			@Override
			public Producer_Lectureseries toEntityModel() {
				return _nullProducer_Lectureseries;
			}
		};
}
