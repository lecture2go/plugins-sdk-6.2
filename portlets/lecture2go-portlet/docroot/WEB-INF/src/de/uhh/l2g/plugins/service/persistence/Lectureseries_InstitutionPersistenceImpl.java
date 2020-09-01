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

import de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;
import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the lectureseries_ institution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_InstitutionPersistence
 * @see Lectureseries_InstitutionUtil
 * @generated
 */
public class Lectureseries_InstitutionPersistenceImpl
	extends BasePersistenceImpl<Lectureseries_Institution>
	implements Lectureseries_InstitutionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Lectureseries_InstitutionUtil} to access the lectureseries_ institution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Lectureseries_InstitutionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESID =
		new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseriesId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID =
		new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseriesId",
			new String[] { Long.class.getName() },
			Lectureseries_InstitutionModelImpl.LECTURESERIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIESID = new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLectureseriesId", new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureseries_ institutions where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findByLectureseriesId(
		long lectureseriesId) throws SystemException {
		return findByLectureseriesId(lectureseriesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ institutions where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @return the range of matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findByLectureseriesId(
		long lectureseriesId, int start, int end) throws SystemException {
		return findByLectureseriesId(lectureseriesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ institutions where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findByLectureseriesId(
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

		List<Lectureseries_Institution> list = (List<Lectureseries_Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Lectureseries_Institution lectureseries_Institution : list) {
				if ((lectureseriesId != lectureseries_Institution.getLectureseriesId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESID_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Lectureseries_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Institution>(list);
				}
				else {
					list = (List<Lectureseries_Institution>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution findByLectureseriesId_First(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = fetchByLectureseriesId_First(lectureseriesId,
				orderByComparator);

		if (lectureseries_Institution != null) {
			return lectureseries_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_InstitutionException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution fetchByLectureseriesId_First(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Lectureseries_Institution> list = findByLectureseriesId(lectureseriesId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution findByLectureseriesId_Last(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = fetchByLectureseriesId_Last(lectureseriesId,
				orderByComparator);

		if (lectureseries_Institution != null) {
			return lectureseries_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_InstitutionException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution fetchByLectureseriesId_Last(
		long lectureseriesId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLectureseriesId(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Institution> list = findByLectureseriesId(lectureseriesId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ institutions before and after the current lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesInstitutionId the primary key of the current lectureseries_ institution
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution[] findByLectureseriesId_PrevAndNext(
		long lectureseriesInstitutionId, long lectureseriesId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = findByPrimaryKey(lectureseriesInstitutionId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Institution[] array = new Lectureseries_InstitutionImpl[3];

			array[0] = getByLectureseriesId_PrevAndNext(session,
					lectureseries_Institution, lectureseriesId,
					orderByComparator, true);

			array[1] = lectureseries_Institution;

			array[2] = getByLectureseriesId_PrevAndNext(session,
					lectureseries_Institution, lectureseriesId,
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

	protected Lectureseries_Institution getByLectureseriesId_PrevAndNext(
		Session session, Lectureseries_Institution lectureseries_Institution,
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

		query.append(_SQL_SELECT_LECTURESERIES_INSTITUTION_WHERE);

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
			query.append(Lectureseries_InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ institutions where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLectureseriesId(long lectureseriesId)
		throws SystemException {
		for (Lectureseries_Institution lectureseries_Institution : findByLectureseriesId(
				lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Institution);
		}
	}

	/**
	 * Returns the number of lectureseries_ institutions where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching lectureseries_ institutions
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

			query.append(_SQL_COUNT_LECTURESERIES_INSTITUTION_WHERE);

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
		"lectureseries_Institution.lectureseriesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTIONID =
		new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInstitutionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID =
		new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInstitutionId",
			new String[] { Long.class.getName() },
			Lectureseries_InstitutionModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTITUTIONID = new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByInstitutionId", new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureseries_ institutions where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findByInstitutionId(
		long institutionId) throws SystemException {
		return findByInstitutionId(institutionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @return the range of matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findByInstitutionId(
		long institutionId, int start, int end) throws SystemException {
		return findByInstitutionId(institutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findByInstitutionId(
		long institutionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID;
			finderArgs = new Object[] { institutionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTIONID;
			finderArgs = new Object[] {
					institutionId,
					
					start, end, orderByComparator
				};
		}

		List<Lectureseries_Institution> list = (List<Lectureseries_Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Lectureseries_Institution lectureseries_Institution : list) {
				if ((institutionId != lectureseries_Institution.getInstitutionId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

				if (!pagination) {
					list = (List<Lectureseries_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Institution>(list);
				}
				else {
					list = (List<Lectureseries_Institution>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution findByInstitutionId_First(
		long institutionId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = fetchByInstitutionId_First(institutionId,
				orderByComparator);

		if (lectureseries_Institution != null) {
			return lectureseries_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_InstitutionException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution fetchByInstitutionId_First(
		long institutionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Lectureseries_Institution> list = findByInstitutionId(institutionId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution findByInstitutionId_Last(
		long institutionId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = fetchByInstitutionId_Last(institutionId,
				orderByComparator);

		if (lectureseries_Institution != null) {
			return lectureseries_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_InstitutionException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution fetchByInstitutionId_Last(
		long institutionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByInstitutionId(institutionId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Institution> list = findByInstitutionId(institutionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ institutions before and after the current lectureseries_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param lectureseriesInstitutionId the primary key of the current lectureseries_ institution
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution[] findByInstitutionId_PrevAndNext(
		long lectureseriesInstitutionId, long institutionId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = findByPrimaryKey(lectureseriesInstitutionId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Institution[] array = new Lectureseries_InstitutionImpl[3];

			array[0] = getByInstitutionId_PrevAndNext(session,
					lectureseries_Institution, institutionId,
					orderByComparator, true);

			array[1] = lectureseries_Institution;

			array[2] = getByInstitutionId_PrevAndNext(session,
					lectureseries_Institution, institutionId,
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

	protected Lectureseries_Institution getByInstitutionId_PrevAndNext(
		Session session, Lectureseries_Institution lectureseries_Institution,
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

		query.append(_SQL_SELECT_LECTURESERIES_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2);

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
			query.append(Lectureseries_InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(institutionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ institutions where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByInstitutionId(long institutionId)
		throws SystemException {
		for (Lectureseries_Institution lectureseries_Institution : findByInstitutionId(
				institutionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Institution);
		}
	}

	/**
	 * Returns the number of lectureseries_ institutions where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByInstitutionId(long institutionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTITUTIONID;

		Object[] finderArgs = new Object[] { institutionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2);

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

	private static final String _FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2 = "lectureseries_Institution.institutionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESIDANDINSTITUTIONID =
		new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLectureseriesIdAndInstitutionId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDINSTITUTIONID =
		new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLectureseriesIdAndInstitutionId",
			new String[] { Long.class.getName(), Long.class.getName() },
			Lectureseries_InstitutionModelImpl.LECTURESERIESID_COLUMN_BITMASK |
			Lectureseries_InstitutionModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIESIDANDINSTITUTIONID =
		new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLectureseriesIdAndInstitutionId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @return the matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId) throws SystemException {
		return findByLectureseriesIdAndInstitutionId(lectureseriesId,
			institutionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @return the range of matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId, int start, int end)
		throws SystemException {
		return findByLectureseriesIdAndInstitutionId(lectureseriesId,
			institutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDINSTITUTIONID;
			finderArgs = new Object[] { lectureseriesId, institutionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESIDANDINSTITUTIONID;
			finderArgs = new Object[] {
					lectureseriesId, institutionId,
					
					start, end, orderByComparator
				};
		}

		List<Lectureseries_Institution> list = (List<Lectureseries_Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Lectureseries_Institution lectureseries_Institution : list) {
				if ((lectureseriesId != lectureseries_Institution.getLectureseriesId()) ||
						(institutionId != lectureseries_Institution.getInstitutionId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESIDANDINSTITUTIONID_LECTURESERIESID_2);

			query.append(_FINDER_COLUMN_LECTURESERIESIDANDINSTITUTIONID_INSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				qPos.add(institutionId);

				if (!pagination) {
					list = (List<Lectureseries_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Institution>(list);
				}
				else {
					list = (List<Lectureseries_Institution>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution findByLectureseriesIdAndInstitutionId_First(
		long lectureseriesId, long institutionId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = fetchByLectureseriesIdAndInstitutionId_First(lectureseriesId,
				institutionId, orderByComparator);

		if (lectureseries_Institution != null) {
			return lectureseries_Institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_InstitutionException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution fetchByLectureseriesIdAndInstitutionId_First(
		long lectureseriesId, long institutionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Lectureseries_Institution> list = findByLectureseriesIdAndInstitutionId(lectureseriesId,
				institutionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution findByLectureseriesIdAndInstitutionId_Last(
		long lectureseriesId, long institutionId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = fetchByLectureseriesIdAndInstitutionId_Last(lectureseriesId,
				institutionId, orderByComparator);

		if (lectureseries_Institution != null) {
			return lectureseries_Institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_InstitutionException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution fetchByLectureseriesIdAndInstitutionId_Last(
		long lectureseriesId, long institutionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLectureseriesIdAndInstitutionId(lectureseriesId,
				institutionId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Institution> list = findByLectureseriesIdAndInstitutionId(lectureseriesId,
				institutionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ institutions before and after the current lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesInstitutionId the primary key of the current lectureseries_ institution
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution[] findByLectureseriesIdAndInstitutionId_PrevAndNext(
		long lectureseriesInstitutionId, long lectureseriesId,
		long institutionId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = findByPrimaryKey(lectureseriesInstitutionId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Institution[] array = new Lectureseries_InstitutionImpl[3];

			array[0] = getByLectureseriesIdAndInstitutionId_PrevAndNext(session,
					lectureseries_Institution, lectureseriesId, institutionId,
					orderByComparator, true);

			array[1] = lectureseries_Institution;

			array[2] = getByLectureseriesIdAndInstitutionId_PrevAndNext(session,
					lectureseries_Institution, lectureseriesId, institutionId,
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

	protected Lectureseries_Institution getByLectureseriesIdAndInstitutionId_PrevAndNext(
		Session session, Lectureseries_Institution lectureseries_Institution,
		long lectureseriesId, long institutionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_LECTURESERIESIDANDINSTITUTIONID_LECTURESERIESID_2);

		query.append(_FINDER_COLUMN_LECTURESERIESIDANDINSTITUTIONID_INSTITUTIONID_2);

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
			query.append(Lectureseries_InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		qPos.add(institutionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLectureseriesIdAndInstitutionId(long lectureseriesId,
		long institutionId) throws SystemException {
		for (Lectureseries_Institution lectureseries_Institution : findByLectureseriesIdAndInstitutionId(
				lectureseriesId, institutionId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Institution);
		}
	}

	/**
	 * Returns the number of lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @return the number of matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLectureseriesIdAndInstitutionId(long lectureseriesId,
		long institutionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LECTURESERIESIDANDINSTITUTIONID;

		Object[] finderArgs = new Object[] { lectureseriesId, institutionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LECTURESERIES_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESIDANDINSTITUTIONID_LECTURESERIESID_2);

			query.append(_FINDER_COLUMN_LECTURESERIESIDANDINSTITUTIONID_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

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

	private static final String _FINDER_COLUMN_LECTURESERIESIDANDINSTITUTIONID_LECTURESERIESID_2 =
		"lectureseries_Institution.lectureseriesId = ? AND ";
	private static final String _FINDER_COLUMN_LECTURESERIESIDANDINSTITUTIONID_INSTITUTIONID_2 =
		"lectureseries_Institution.institutionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTIONPARENTID =
		new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByInstitutionParentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONPARENTID =
		new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByInstitutionParentId", new String[] { Long.class.getName() },
			Lectureseries_InstitutionModelImpl.INSTITUTIONPARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTITUTIONPARENTID = new FinderPath(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByInstitutionParentId", new String[] { Long.class.getName() });

	/**
	 * Returns all the lectureseries_ institutions where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @return the matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findByInstitutionParentId(
		long institutionParentId) throws SystemException {
		return findByInstitutionParentId(institutionParentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @return the range of matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end) throws SystemException {
		return findByInstitutionParentId(institutionParentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONPARENTID;
			finderArgs = new Object[] { institutionParentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTIONPARENTID;
			finderArgs = new Object[] {
					institutionParentId,
					
					start, end, orderByComparator
				};
		}

		List<Lectureseries_Institution> list = (List<Lectureseries_Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Lectureseries_Institution lectureseries_Institution : list) {
				if ((institutionParentId != lectureseries_Institution.getInstitutionParentId())) {
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

			query.append(_SQL_SELECT_LECTURESERIES_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTIONPARENTID_INSTITUTIONPARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Lectureseries_InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionParentId);

				if (!pagination) {
					list = (List<Lectureseries_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Institution>(list);
				}
				else {
					list = (List<Lectureseries_Institution>)QueryUtil.list(q,
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
	 * Returns the first lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution findByInstitutionParentId_First(
		long institutionParentId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = fetchByInstitutionParentId_First(institutionParentId,
				orderByComparator);

		if (lectureseries_Institution != null) {
			return lectureseries_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionParentId=");
		msg.append(institutionParentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_InstitutionException(msg.toString());
	}

	/**
	 * Returns the first lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution fetchByInstitutionParentId_First(
		long institutionParentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Lectureseries_Institution> list = findByInstitutionParentId(institutionParentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution findByInstitutionParentId_Last(
		long institutionParentId, OrderByComparator orderByComparator)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = fetchByInstitutionParentId_Last(institutionParentId,
				orderByComparator);

		if (lectureseries_Institution != null) {
			return lectureseries_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionParentId=");
		msg.append(institutionParentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLectureseries_InstitutionException(msg.toString());
	}

	/**
	 * Returns the last lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution fetchByInstitutionParentId_Last(
		long institutionParentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByInstitutionParentId(institutionParentId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Institution> list = findByInstitutionParentId(institutionParentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ institutions before and after the current lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param lectureseriesInstitutionId the primary key of the current lectureseries_ institution
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution[] findByInstitutionParentId_PrevAndNext(
		long lectureseriesInstitutionId, long institutionParentId,
		OrderByComparator orderByComparator)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = findByPrimaryKey(lectureseriesInstitutionId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Institution[] array = new Lectureseries_InstitutionImpl[3];

			array[0] = getByInstitutionParentId_PrevAndNext(session,
					lectureseries_Institution, institutionParentId,
					orderByComparator, true);

			array[1] = lectureseries_Institution;

			array[2] = getByInstitutionParentId_PrevAndNext(session,
					lectureseries_Institution, institutionParentId,
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

	protected Lectureseries_Institution getByInstitutionParentId_PrevAndNext(
		Session session, Lectureseries_Institution lectureseries_Institution,
		long institutionParentId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LECTURESERIES_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_INSTITUTIONPARENTID_INSTITUTIONPARENTID_2);

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
			query.append(Lectureseries_InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(institutionParentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lectureseries_Institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lectureseries_Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ institutions where institutionParentId = &#63; from the database.
	 *
	 * @param institutionParentId the institution parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByInstitutionParentId(long institutionParentId)
		throws SystemException {
		for (Lectureseries_Institution lectureseries_Institution : findByInstitutionParentId(
				institutionParentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(lectureseries_Institution);
		}
	}

	/**
	 * Returns the number of lectureseries_ institutions where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @return the number of matching lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByInstitutionParentId(long institutionParentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTITUTIONPARENTID;

		Object[] finderArgs = new Object[] { institutionParentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURESERIES_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTIONPARENTID_INSTITUTIONPARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionParentId);

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

	private static final String _FINDER_COLUMN_INSTITUTIONPARENTID_INSTITUTIONPARENTID_2 =
		"lectureseries_Institution.institutionParentId = ?";

	public Lectureseries_InstitutionPersistenceImpl() {
		setModelClass(Lectureseries_Institution.class);
	}

	/**
	 * Caches the lectureseries_ institution in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Institution the lectureseries_ institution
	 */
	@Override
	public void cacheResult(Lectureseries_Institution lectureseries_Institution) {
		EntityCacheUtil.putResult(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			lectureseries_Institution.getPrimaryKey(), lectureseries_Institution);

		lectureseries_Institution.resetOriginalValues();
	}

	/**
	 * Caches the lectureseries_ institutions in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Institutions the lectureseries_ institutions
	 */
	@Override
	public void cacheResult(
		List<Lectureseries_Institution> lectureseries_Institutions) {
		for (Lectureseries_Institution lectureseries_Institution : lectureseries_Institutions) {
			if (EntityCacheUtil.getResult(
						Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
						Lectureseries_InstitutionImpl.class,
						lectureseries_Institution.getPrimaryKey()) == null) {
				cacheResult(lectureseries_Institution);
			}
			else {
				lectureseries_Institution.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lectureseries_ institutions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Lectureseries_InstitutionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Lectureseries_InstitutionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lectureseries_ institution.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lectureseries_Institution lectureseries_Institution) {
		EntityCacheUtil.removeResult(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			lectureseries_Institution.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Lectureseries_Institution> lectureseries_Institutions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lectureseries_Institution lectureseries_Institution : lectureseries_Institutions) {
			EntityCacheUtil.removeResult(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
				Lectureseries_InstitutionImpl.class,
				lectureseries_Institution.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lectureseries_ institution with the primary key. Does not add the lectureseries_ institution to the database.
	 *
	 * @param lectureseriesInstitutionId the primary key for the new lectureseries_ institution
	 * @return the new lectureseries_ institution
	 */
	@Override
	public Lectureseries_Institution create(long lectureseriesInstitutionId) {
		Lectureseries_Institution lectureseries_Institution = new Lectureseries_InstitutionImpl();

		lectureseries_Institution.setNew(true);
		lectureseries_Institution.setPrimaryKey(lectureseriesInstitutionId);

		return lectureseries_Institution;
	}

	/**
	 * Removes the lectureseries_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution remove(long lectureseriesInstitutionId)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		return remove((Serializable)lectureseriesInstitutionId);
	}

	/**
	 * Removes the lectureseries_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution remove(Serializable primaryKey)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Lectureseries_Institution lectureseries_Institution = (Lectureseries_Institution)session.get(Lectureseries_InstitutionImpl.class,
					primaryKey);

			if (lectureseries_Institution == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLectureseries_InstitutionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lectureseries_Institution);
		}
		catch (NoSuchLectureseries_InstitutionException nsee) {
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
	protected Lectureseries_Institution removeImpl(
		Lectureseries_Institution lectureseries_Institution)
		throws SystemException {
		lectureseries_Institution = toUnwrappedModel(lectureseries_Institution);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lectureseries_Institution)) {
				lectureseries_Institution = (Lectureseries_Institution)session.get(Lectureseries_InstitutionImpl.class,
						lectureseries_Institution.getPrimaryKeyObj());
			}

			if (lectureseries_Institution != null) {
				session.delete(lectureseries_Institution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lectureseries_Institution != null) {
			clearCache(lectureseries_Institution);
		}

		return lectureseries_Institution;
	}

	@Override
	public Lectureseries_Institution updateImpl(
		de.uhh.l2g.plugins.model.Lectureseries_Institution lectureseries_Institution)
		throws SystemException {
		lectureseries_Institution = toUnwrappedModel(lectureseries_Institution);

		boolean isNew = lectureseries_Institution.isNew();

		Lectureseries_InstitutionModelImpl lectureseries_InstitutionModelImpl = (Lectureseries_InstitutionModelImpl)lectureseries_Institution;

		Session session = null;

		try {
			session = openSession();

			if (lectureseries_Institution.isNew()) {
				session.save(lectureseries_Institution);

				lectureseries_Institution.setNew(false);
			}
			else {
				session.merge(lectureseries_Institution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!Lectureseries_InstitutionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((lectureseries_InstitutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_InstitutionModelImpl.getOriginalLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID,
					args);

				args = new Object[] {
						lectureseries_InstitutionModelImpl.getLectureseriesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESID,
					args);
			}

			if ((lectureseries_InstitutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_InstitutionModelImpl.getOriginalInstitutionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID,
					args);

				args = new Object[] {
						lectureseries_InstitutionModelImpl.getInstitutionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID,
					args);
			}

			if ((lectureseries_InstitutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDINSTITUTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_InstitutionModelImpl.getOriginalLectureseriesId(),
						lectureseries_InstitutionModelImpl.getOriginalInstitutionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESIDANDINSTITUTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDINSTITUTIONID,
					args);

				args = new Object[] {
						lectureseries_InstitutionModelImpl.getLectureseriesId(),
						lectureseries_InstitutionModelImpl.getInstitutionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESIDANDINSTITUTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESIDANDINSTITUTIONID,
					args);
			}

			if ((lectureseries_InstitutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONPARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						lectureseries_InstitutionModelImpl.getOriginalInstitutionParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTIONPARENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONPARENTID,
					args);

				args = new Object[] {
						lectureseries_InstitutionModelImpl.getInstitutionParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTIONPARENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONPARENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_InstitutionImpl.class,
			lectureseries_Institution.getPrimaryKey(), lectureseries_Institution);

		return lectureseries_Institution;
	}

	protected Lectureseries_Institution toUnwrappedModel(
		Lectureseries_Institution lectureseries_Institution) {
		if (lectureseries_Institution instanceof Lectureseries_InstitutionImpl) {
			return lectureseries_Institution;
		}

		Lectureseries_InstitutionImpl lectureseries_InstitutionImpl = new Lectureseries_InstitutionImpl();

		lectureseries_InstitutionImpl.setNew(lectureseries_Institution.isNew());
		lectureseries_InstitutionImpl.setPrimaryKey(lectureseries_Institution.getPrimaryKey());

		lectureseries_InstitutionImpl.setLectureseriesInstitutionId(lectureseries_Institution.getLectureseriesInstitutionId());
		lectureseries_InstitutionImpl.setLectureseriesId(lectureseries_Institution.getLectureseriesId());
		lectureseries_InstitutionImpl.setInstitutionId(lectureseries_Institution.getInstitutionId());
		lectureseries_InstitutionImpl.setInstitutionParentId(lectureseries_Institution.getInstitutionParentId());

		return lectureseries_InstitutionImpl;
	}

	/**
	 * Returns the lectureseries_ institution with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		Lectureseries_Institution lectureseries_Institution = fetchByPrimaryKey(primaryKey);

		if (lectureseries_Institution == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLectureseries_InstitutionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lectureseries_Institution;
	}

	/**
	 * Returns the lectureseries_ institution with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException} if it could not be found.
	 *
	 * @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution
	 * @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution findByPrimaryKey(
		long lectureseriesInstitutionId)
		throws NoSuchLectureseries_InstitutionException, SystemException {
		return findByPrimaryKey((Serializable)lectureseriesInstitutionId);
	}

	/**
	 * Returns the lectureseries_ institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution, or <code>null</code> if a lectureseries_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Lectureseries_Institution lectureseries_Institution = (Lectureseries_Institution)EntityCacheUtil.getResult(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
				Lectureseries_InstitutionImpl.class, primaryKey);

		if (lectureseries_Institution == _nullLectureseries_Institution) {
			return null;
		}

		if (lectureseries_Institution == null) {
			Session session = null;

			try {
				session = openSession();

				lectureseries_Institution = (Lectureseries_Institution)session.get(Lectureseries_InstitutionImpl.class,
						primaryKey);

				if (lectureseries_Institution != null) {
					cacheResult(lectureseries_Institution);
				}
				else {
					EntityCacheUtil.putResult(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
						Lectureseries_InstitutionImpl.class, primaryKey,
						_nullLectureseries_Institution);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Lectureseries_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
					Lectureseries_InstitutionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lectureseries_Institution;
	}

	/**
	 * Returns the lectureseries_ institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution, or <code>null</code> if a lectureseries_ institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lectureseries_Institution fetchByPrimaryKey(
		long lectureseriesInstitutionId) throws SystemException {
		return fetchByPrimaryKey((Serializable)lectureseriesInstitutionId);
	}

	/**
	 * Returns all the lectureseries_ institutions.
	 *
	 * @return the lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @return the range of lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lectureseries_ institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lectureseries_Institution> findAll(int start, int end,
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

		List<Lectureseries_Institution> list = (List<Lectureseries_Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LECTURESERIES_INSTITUTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LECTURESERIES_INSTITUTION;

				if (pagination) {
					sql = sql.concat(Lectureseries_InstitutionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Lectureseries_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lectureseries_Institution>(list);
				}
				else {
					list = (List<Lectureseries_Institution>)QueryUtil.list(q,
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
	 * Removes all the lectureseries_ institutions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Lectureseries_Institution lectureseries_Institution : findAll()) {
			remove(lectureseries_Institution);
		}
	}

	/**
	 * Returns the number of lectureseries_ institutions.
	 *
	 * @return the number of lectureseries_ institutions
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

				Query q = session.createQuery(_SQL_COUNT_LECTURESERIES_INSTITUTION);

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
	 * Initializes the lectureseries_ institution persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Lectureseries_Institution")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Lectureseries_Institution>> listenersList = new ArrayList<ModelListener<Lectureseries_Institution>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Lectureseries_Institution>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Lectureseries_InstitutionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LECTURESERIES_INSTITUTION = "SELECT lectureseries_Institution FROM Lectureseries_Institution lectureseries_Institution";
	private static final String _SQL_SELECT_LECTURESERIES_INSTITUTION_WHERE = "SELECT lectureseries_Institution FROM Lectureseries_Institution lectureseries_Institution WHERE ";
	private static final String _SQL_COUNT_LECTURESERIES_INSTITUTION = "SELECT COUNT(lectureseries_Institution) FROM Lectureseries_Institution lectureseries_Institution";
	private static final String _SQL_COUNT_LECTURESERIES_INSTITUTION_WHERE = "SELECT COUNT(lectureseries_Institution) FROM Lectureseries_Institution lectureseries_Institution WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lectureseries_Institution.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lectureseries_Institution exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Lectureseries_Institution exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Lectureseries_InstitutionPersistenceImpl.class);
	private static Lectureseries_Institution _nullLectureseries_Institution = new Lectureseries_InstitutionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Lectureseries_Institution> toCacheModel() {
				return _nullLectureseries_InstitutionCacheModel;
			}
		};

	private static CacheModel<Lectureseries_Institution> _nullLectureseries_InstitutionCacheModel =
		new CacheModel<Lectureseries_Institution>() {
			@Override
			public Lectureseries_Institution toEntityModel() {
				return _nullLectureseries_Institution;
			}
		};
}
