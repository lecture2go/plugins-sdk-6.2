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

import de.uhh.l2g.plugins.NoSuchCoordinatorException;
import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.impl.CoordinatorImpl;
import de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the coordinator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see CoordinatorPersistence
 * @see CoordinatorUtil
 * @generated
 */
public class CoordinatorPersistenceImpl extends BasePersistenceImpl<Coordinator>
	implements CoordinatorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CoordinatorUtil} to access the coordinator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CoordinatorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_INSTITUTION = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByInstitution",
			new String[] { Long.class.getName() },
			CoordinatorModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTITUTION = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstitution",
			new String[] { Long.class.getName() });

	/**
	 * Returns the coordinator where institutionId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchCoordinatorException} if it could not be found.
	 *
	 * @param institutionId the institution ID
	 * @return the matching coordinator
	 * @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a matching coordinator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator findByInstitution(long institutionId)
		throws NoSuchCoordinatorException, SystemException {
		Coordinator coordinator = fetchByInstitution(institutionId);

		if (coordinator == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("institutionId=");
			msg.append(institutionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCoordinatorException(msg.toString());
		}

		return coordinator;
	}

	/**
	 * Returns the coordinator where institutionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param institutionId the institution ID
	 * @return the matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator fetchByInstitution(long institutionId)
		throws SystemException {
		return fetchByInstitution(institutionId, true);
	}

	/**
	 * Returns the coordinator where institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param institutionId the institution ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator fetchByInstitution(long institutionId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { institutionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_INSTITUTION,
					finderArgs, this);
		}

		if (result instanceof Coordinator) {
			Coordinator coordinator = (Coordinator)result;

			if ((institutionId != coordinator.getInstitutionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

				List<Coordinator> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INSTITUTION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CoordinatorPersistenceImpl.fetchByInstitution(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Coordinator coordinator = list.get(0);

					result = coordinator;

					cacheResult(coordinator);

					if ((coordinator.getInstitutionId() != institutionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INSTITUTION,
							finderArgs, coordinator);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INSTITUTION,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Coordinator)result;
		}
	}

	/**
	 * Removes the coordinator where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 * @return the coordinator that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator removeByInstitution(long institutionId)
		throws NoSuchCoordinatorException, SystemException {
		Coordinator coordinator = findByInstitution(institutionId);

		return remove(coordinator);
	}

	/**
	 * Returns the number of coordinators where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching coordinators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByInstitution(long institutionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTITUTION;

		Object[] finderArgs = new Object[] { institutionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

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

	private static final String _FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2 = "coordinator.institutionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OFFICE = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOffice",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICE =
		new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOffice",
			new String[] { Long.class.getName() },
			CoordinatorModelImpl.OFFICEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OFFICE = new FinderPath(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOffice",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the coordinators where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the matching coordinators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coordinator> findByOffice(long officeId)
		throws SystemException {
		return findByOffice(officeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coordinators where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of matching coordinators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coordinator> findByOffice(long officeId, int start, int end)
		throws SystemException {
		return findByOffice(officeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the coordinators where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coordinators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coordinator> findByOffice(long officeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICE;
			finderArgs = new Object[] { officeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OFFICE;
			finderArgs = new Object[] { officeId, start, end, orderByComparator };
		}

		List<Coordinator> list = (List<Coordinator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Coordinator coordinator : list) {
				if ((officeId != coordinator.getOfficeId())) {
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

			query.append(_SQL_SELECT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_OFFICE_OFFICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CoordinatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(officeId);

				if (!pagination) {
					list = (List<Coordinator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Coordinator>(list);
				}
				else {
					list = (List<Coordinator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a matching coordinator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator findByOffice_First(long officeId,
		OrderByComparator orderByComparator)
		throws NoSuchCoordinatorException, SystemException {
		Coordinator coordinator = fetchByOffice_First(officeId,
				orderByComparator);

		if (coordinator != null) {
			return coordinator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("officeId=");
		msg.append(officeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoordinatorException(msg.toString());
	}

	/**
	 * Returns the first coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator fetchByOffice_First(long officeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Coordinator> list = findByOffice(officeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a matching coordinator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator findByOffice_Last(long officeId,
		OrderByComparator orderByComparator)
		throws NoSuchCoordinatorException, SystemException {
		Coordinator coordinator = fetchByOffice_Last(officeId, orderByComparator);

		if (coordinator != null) {
			return coordinator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("officeId=");
		msg.append(officeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoordinatorException(msg.toString());
	}

	/**
	 * Returns the last coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator fetchByOffice_Last(long officeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOffice(officeId);

		if (count == 0) {
			return null;
		}

		List<Coordinator> list = findByOffice(officeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator[] findByOffice_PrevAndNext(long coordinatorId,
		long officeId, OrderByComparator orderByComparator)
		throws NoSuchCoordinatorException, SystemException {
		Coordinator coordinator = findByPrimaryKey(coordinatorId);

		Session session = null;

		try {
			session = openSession();

			Coordinator[] array = new CoordinatorImpl[3];

			array[0] = getByOffice_PrevAndNext(session, coordinator, officeId,
					orderByComparator, true);

			array[1] = coordinator;

			array[2] = getByOffice_PrevAndNext(session, coordinator, officeId,
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

	protected Coordinator getByOffice_PrevAndNext(Session session,
		Coordinator coordinator, long officeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COORDINATOR_WHERE);

		query.append(_FINDER_COLUMN_OFFICE_OFFICEID_2);

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
			query.append(CoordinatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(officeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(coordinator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Coordinator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the coordinators where officeId = &#63; from the database.
	 *
	 * @param officeId the office ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOffice(long officeId) throws SystemException {
		for (Coordinator coordinator : findByOffice(officeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(coordinator);
		}
	}

	/**
	 * Returns the number of coordinators where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the number of matching coordinators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOffice(long officeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OFFICE;

		Object[] finderArgs = new Object[] { officeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_OFFICE_OFFICEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(officeId);

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

	private static final String _FINDER_COLUMN_OFFICE_OFFICEID_2 = "coordinator.officeId = ?";

	public CoordinatorPersistenceImpl() {
		setModelClass(Coordinator.class);
	}

	/**
	 * Caches the coordinator in the entity cache if it is enabled.
	 *
	 * @param coordinator the coordinator
	 */
	@Override
	public void cacheResult(Coordinator coordinator) {
		EntityCacheUtil.putResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorImpl.class, coordinator.getPrimaryKey(), coordinator);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INSTITUTION,
			new Object[] { coordinator.getInstitutionId() }, coordinator);

		coordinator.resetOriginalValues();
	}

	/**
	 * Caches the coordinators in the entity cache if it is enabled.
	 *
	 * @param coordinators the coordinators
	 */
	@Override
	public void cacheResult(List<Coordinator> coordinators) {
		for (Coordinator coordinator : coordinators) {
			if (EntityCacheUtil.getResult(
						CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
						CoordinatorImpl.class, coordinator.getPrimaryKey()) == null) {
				cacheResult(coordinator);
			}
			else {
				coordinator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all coordinators.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CoordinatorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CoordinatorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the coordinator.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Coordinator coordinator) {
		EntityCacheUtil.removeResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorImpl.class, coordinator.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(coordinator);
	}

	@Override
	public void clearCache(List<Coordinator> coordinators) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Coordinator coordinator : coordinators) {
			EntityCacheUtil.removeResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
				CoordinatorImpl.class, coordinator.getPrimaryKey());

			clearUniqueFindersCache(coordinator);
		}
	}

	protected void cacheUniqueFindersCache(Coordinator coordinator) {
		if (coordinator.isNew()) {
			Object[] args = new Object[] { coordinator.getInstitutionId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INSTITUTION, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INSTITUTION, args,
				coordinator);
		}
		else {
			CoordinatorModelImpl coordinatorModelImpl = (CoordinatorModelImpl)coordinator;

			if ((coordinatorModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_INSTITUTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { coordinator.getInstitutionId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INSTITUTION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INSTITUTION,
					args, coordinator);
			}
		}
	}

	protected void clearUniqueFindersCache(Coordinator coordinator) {
		CoordinatorModelImpl coordinatorModelImpl = (CoordinatorModelImpl)coordinator;

		Object[] args = new Object[] { coordinator.getInstitutionId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INSTITUTION, args);

		if ((coordinatorModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_INSTITUTION.getColumnBitmask()) != 0) {
			args = new Object[] { coordinatorModelImpl.getOriginalInstitutionId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INSTITUTION, args);
		}
	}

	/**
	 * Creates a new coordinator with the primary key. Does not add the coordinator to the database.
	 *
	 * @param coordinatorId the primary key for the new coordinator
	 * @return the new coordinator
	 */
	@Override
	public Coordinator create(long coordinatorId) {
		Coordinator coordinator = new CoordinatorImpl();

		coordinator.setNew(true);
		coordinator.setPrimaryKey(coordinatorId);

		return coordinator;
	}

	/**
	 * Removes the coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator remove(long coordinatorId)
		throws NoSuchCoordinatorException, SystemException {
		return remove((Serializable)coordinatorId);
	}

	/**
	 * Removes the coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the coordinator
	 * @return the coordinator that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator remove(Serializable primaryKey)
		throws NoSuchCoordinatorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Coordinator coordinator = (Coordinator)session.get(CoordinatorImpl.class,
					primaryKey);

			if (coordinator == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCoordinatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(coordinator);
		}
		catch (NoSuchCoordinatorException nsee) {
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
	protected Coordinator removeImpl(Coordinator coordinator)
		throws SystemException {
		coordinator = toUnwrappedModel(coordinator);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(coordinator)) {
				coordinator = (Coordinator)session.get(CoordinatorImpl.class,
						coordinator.getPrimaryKeyObj());
			}

			if (coordinator != null) {
				session.delete(coordinator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (coordinator != null) {
			clearCache(coordinator);
		}

		return coordinator;
	}

	@Override
	public Coordinator updateImpl(
		de.uhh.l2g.plugins.model.Coordinator coordinator)
		throws SystemException {
		coordinator = toUnwrappedModel(coordinator);

		boolean isNew = coordinator.isNew();

		CoordinatorModelImpl coordinatorModelImpl = (CoordinatorModelImpl)coordinator;

		Session session = null;

		try {
			session = openSession();

			if (coordinator.isNew()) {
				session.save(coordinator);

				coordinator.setNew(false);
			}
			else {
				session.merge(coordinator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CoordinatorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((coordinatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						coordinatorModelImpl.getOriginalOfficeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OFFICE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICE,
					args);

				args = new Object[] { coordinatorModelImpl.getOfficeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OFFICE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICE,
					args);
			}
		}

		EntityCacheUtil.putResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorImpl.class, coordinator.getPrimaryKey(), coordinator);

		clearUniqueFindersCache(coordinator);
		cacheUniqueFindersCache(coordinator);

		return coordinator;
	}

	protected Coordinator toUnwrappedModel(Coordinator coordinator) {
		if (coordinator instanceof CoordinatorImpl) {
			return coordinator;
		}

		CoordinatorImpl coordinatorImpl = new CoordinatorImpl();

		coordinatorImpl.setNew(coordinator.isNew());
		coordinatorImpl.setPrimaryKey(coordinator.getPrimaryKey());

		coordinatorImpl.setCoordinatorId(coordinator.getCoordinatorId());
		coordinatorImpl.setInstitutionId(coordinator.getInstitutionId());
		coordinatorImpl.setOfficeId(coordinator.getOfficeId());

		return coordinatorImpl;
	}

	/**
	 * Returns the coordinator with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the coordinator
	 * @return the coordinator
	 * @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCoordinatorException, SystemException {
		Coordinator coordinator = fetchByPrimaryKey(primaryKey);

		if (coordinator == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCoordinatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return coordinator;
	}

	/**
	 * Returns the coordinator with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchCoordinatorException} if it could not be found.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator
	 * @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator findByPrimaryKey(long coordinatorId)
		throws NoSuchCoordinatorException, SystemException {
		return findByPrimaryKey((Serializable)coordinatorId);
	}

	/**
	 * Returns the coordinator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the coordinator
	 * @return the coordinator, or <code>null</code> if a coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Coordinator coordinator = (Coordinator)EntityCacheUtil.getResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
				CoordinatorImpl.class, primaryKey);

		if (coordinator == _nullCoordinator) {
			return null;
		}

		if (coordinator == null) {
			Session session = null;

			try {
				session = openSession();

				coordinator = (Coordinator)session.get(CoordinatorImpl.class,
						primaryKey);

				if (coordinator != null) {
					cacheResult(coordinator);
				}
				else {
					EntityCacheUtil.putResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
						CoordinatorImpl.class, primaryKey, _nullCoordinator);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
					CoordinatorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return coordinator;
	}

	/**
	 * Returns the coordinator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator, or <code>null</code> if a coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinator fetchByPrimaryKey(long coordinatorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)coordinatorId);
	}

	/**
	 * Returns all the coordinators.
	 *
	 * @return the coordinators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coordinator> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of coordinators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coordinator> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of coordinators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coordinator> findAll(int start, int end,
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

		List<Coordinator> list = (List<Coordinator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COORDINATOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COORDINATOR;

				if (pagination) {
					sql = sql.concat(CoordinatorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Coordinator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Coordinator>(list);
				}
				else {
					list = (List<Coordinator>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the coordinators from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Coordinator coordinator : findAll()) {
			remove(coordinator);
		}
	}

	/**
	 * Returns the number of coordinators.
	 *
	 * @return the number of coordinators
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

				Query q = session.createQuery(_SQL_COUNT_COORDINATOR);

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
	 * Initializes the coordinator persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Coordinator")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Coordinator>> listenersList = new ArrayList<ModelListener<Coordinator>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Coordinator>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CoordinatorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COORDINATOR = "SELECT coordinator FROM Coordinator coordinator";
	private static final String _SQL_SELECT_COORDINATOR_WHERE = "SELECT coordinator FROM Coordinator coordinator WHERE ";
	private static final String _SQL_COUNT_COORDINATOR = "SELECT COUNT(coordinator) FROM Coordinator coordinator";
	private static final String _SQL_COUNT_COORDINATOR_WHERE = "SELECT COUNT(coordinator) FROM Coordinator coordinator WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "coordinator.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Coordinator exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Coordinator exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CoordinatorPersistenceImpl.class);
	private static Coordinator _nullCoordinator = new CoordinatorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Coordinator> toCacheModel() {
				return _nullCoordinatorCacheModel;
			}
		};

	private static CacheModel<Coordinator> _nullCoordinatorCacheModel = new CacheModel<Coordinator>() {
			@Override
			public Coordinator toEntityModel() {
				return _nullCoordinator;
			}
		};
}
