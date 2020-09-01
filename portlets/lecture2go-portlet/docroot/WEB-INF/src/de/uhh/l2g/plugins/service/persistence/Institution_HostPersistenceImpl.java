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

import de.uhh.l2g.plugins.NoSuchInstitution_HostException;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.model.impl.Institution_HostImpl;
import de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the institution_ host service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Institution_HostPersistence
 * @see Institution_HostUtil
 * @generated
 */
public class Institution_HostPersistenceImpl extends BasePersistenceImpl<Institution_Host>
	implements Institution_HostPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Institution_HostUtil} to access the institution_ host persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Institution_HostImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTIONID =
		new FinderPath(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByinstitutionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID =
		new FinderPath(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByinstitutionId",
			new String[] { Long.class.getName() },
			Institution_HostModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTITUTIONID = new FinderPath(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByinstitutionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the institution_ hosts where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching institution_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution_Host> findByinstitutionId(long institutionId)
		throws SystemException {
		return findByinstitutionId(institutionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institution_ hosts where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution_Host> findByinstitutionId(long institutionId,
		int start, int end) throws SystemException {
		return findByinstitutionId(institutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution_Host> findByinstitutionId(long institutionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<Institution_Host> list = (List<Institution_Host>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution_Host institution_Host : list) {
				if ((institutionId != institution_Host.getInstitutionId())) {
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

			query.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Institution_HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

				if (!pagination) {
					list = (List<Institution_Host>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution_Host>(list);
				}
				else {
					list = (List<Institution_Host>)QueryUtil.list(q,
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
	 * Returns the first institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a matching institution_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host findByinstitutionId_First(long institutionId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitution_HostException, SystemException {
		Institution_Host institution_Host = fetchByinstitutionId_First(institutionId,
				orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitution_HostException(msg.toString());
	}

	/**
	 * Returns the first institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host fetchByinstitutionId_First(long institutionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution_Host> list = findByinstitutionId(institutionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a matching institution_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host findByinstitutionId_Last(long institutionId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitution_HostException, SystemException {
		Institution_Host institution_Host = fetchByinstitutionId_Last(institutionId,
				orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitution_HostException(msg.toString());
	}

	/**
	 * Returns the last institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host fetchByinstitutionId_Last(long institutionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByinstitutionId(institutionId);

		if (count == 0) {
			return null;
		}

		List<Institution_Host> list = findByinstitutionId(institutionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host[] findByinstitutionId_PrevAndNext(
		long institutionHostId, long institutionId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitution_HostException, SystemException {
		Institution_Host institution_Host = findByPrimaryKey(institutionHostId);

		Session session = null;

		try {
			session = openSession();

			Institution_Host[] array = new Institution_HostImpl[3];

			array[0] = getByinstitutionId_PrevAndNext(session,
					institution_Host, institutionId, orderByComparator, true);

			array[1] = institution_Host;

			array[2] = getByinstitutionId_PrevAndNext(session,
					institution_Host, institutionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution_Host getByinstitutionId_PrevAndNext(Session session,
		Institution_Host institution_Host, long institutionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

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
			query.append(Institution_HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(institutionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution_Host);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution_Host> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institution_ hosts where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByinstitutionId(long institutionId)
		throws SystemException {
		for (Institution_Host institution_Host : findByinstitutionId(
				institutionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution_Host);
		}
	}

	/**
	 * Returns the number of institution_ hosts where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching institution_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByinstitutionId(long institutionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTITUTIONID;

		Object[] finderArgs = new Object[] { institutionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INSTITUTION_HOST_WHERE);

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

	private static final String _FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2 = "institution_Host.institutionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HOSTID = new FinderPath(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByhostId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSTID =
		new FinderPath(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByhostId",
			new String[] { Long.class.getName() },
			Institution_HostModelImpl.HOSTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HOSTID = new FinderPath(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByhostId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the institution_ hosts where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution_Host> findByhostId(long hostId)
		throws SystemException {
		return findByhostId(hostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institution_ hosts where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution_Host> findByhostId(long hostId, int start, int end)
		throws SystemException {
		return findByhostId(hostId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution_Host> findByhostId(long hostId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSTID;
			finderArgs = new Object[] { hostId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HOSTID;
			finderArgs = new Object[] { hostId, start, end, orderByComparator };
		}

		List<Institution_Host> list = (List<Institution_Host>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution_Host institution_Host : list) {
				if ((hostId != institution_Host.getHostId())) {
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

			query.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

			query.append(_FINDER_COLUMN_HOSTID_HOSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Institution_HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hostId);

				if (!pagination) {
					list = (List<Institution_Host>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution_Host>(list);
				}
				else {
					list = (List<Institution_Host>)QueryUtil.list(q,
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
	 * Returns the first institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a matching institution_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host findByhostId_First(long hostId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitution_HostException, SystemException {
		Institution_Host institution_Host = fetchByhostId_First(hostId,
				orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hostId=");
		msg.append(hostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitution_HostException(msg.toString());
	}

	/**
	 * Returns the first institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host fetchByhostId_First(long hostId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution_Host> list = findByhostId(hostId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a matching institution_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host findByhostId_Last(long hostId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitution_HostException, SystemException {
		Institution_Host institution_Host = fetchByhostId_Last(hostId,
				orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hostId=");
		msg.append(hostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitution_HostException(msg.toString());
	}

	/**
	 * Returns the last institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host fetchByhostId_Last(long hostId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByhostId(hostId);

		if (count == 0) {
			return null;
		}

		List<Institution_Host> list = findByhostId(hostId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host[] findByhostId_PrevAndNext(long institutionHostId,
		long hostId, OrderByComparator orderByComparator)
		throws NoSuchInstitution_HostException, SystemException {
		Institution_Host institution_Host = findByPrimaryKey(institutionHostId);

		Session session = null;

		try {
			session = openSession();

			Institution_Host[] array = new Institution_HostImpl[3];

			array[0] = getByhostId_PrevAndNext(session, institution_Host,
					hostId, orderByComparator, true);

			array[1] = institution_Host;

			array[2] = getByhostId_PrevAndNext(session, institution_Host,
					hostId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution_Host getByhostId_PrevAndNext(Session session,
		Institution_Host institution_Host, long hostId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

		query.append(_FINDER_COLUMN_HOSTID_HOSTID_2);

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
			query.append(Institution_HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(hostId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution_Host);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution_Host> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institution_ hosts where hostId = &#63; from the database.
	 *
	 * @param hostId the host ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByhostId(long hostId) throws SystemException {
		for (Institution_Host institution_Host : findByhostId(hostId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution_Host);
		}
	}

	/**
	 * Returns the number of institution_ hosts where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByhostId(long hostId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HOSTID;

		Object[] finderArgs = new Object[] { hostId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INSTITUTION_HOST_WHERE);

			query.append(_FINDER_COLUMN_HOSTID_HOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hostId);

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

	private static final String _FINDER_COLUMN_HOSTID_HOSTID_2 = "institution_Host.hostId = ?";

	public Institution_HostPersistenceImpl() {
		setModelClass(Institution_Host.class);
	}

	/**
	 * Caches the institution_ host in the entity cache if it is enabled.
	 *
	 * @param institution_Host the institution_ host
	 */
	@Override
	public void cacheResult(Institution_Host institution_Host) {
		EntityCacheUtil.putResult(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostImpl.class, institution_Host.getPrimaryKey(),
			institution_Host);

		institution_Host.resetOriginalValues();
	}

	/**
	 * Caches the institution_ hosts in the entity cache if it is enabled.
	 *
	 * @param institution_Hosts the institution_ hosts
	 */
	@Override
	public void cacheResult(List<Institution_Host> institution_Hosts) {
		for (Institution_Host institution_Host : institution_Hosts) {
			if (EntityCacheUtil.getResult(
						Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
						Institution_HostImpl.class,
						institution_Host.getPrimaryKey()) == null) {
				cacheResult(institution_Host);
			}
			else {
				institution_Host.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all institution_ hosts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Institution_HostImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Institution_HostImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the institution_ host.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Institution_Host institution_Host) {
		EntityCacheUtil.removeResult(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostImpl.class, institution_Host.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Institution_Host> institution_Hosts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Institution_Host institution_Host : institution_Hosts) {
			EntityCacheUtil.removeResult(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
				Institution_HostImpl.class, institution_Host.getPrimaryKey());
		}
	}

	/**
	 * Creates a new institution_ host with the primary key. Does not add the institution_ host to the database.
	 *
	 * @param institutionHostId the primary key for the new institution_ host
	 * @return the new institution_ host
	 */
	@Override
	public Institution_Host create(long institutionHostId) {
		Institution_Host institution_Host = new Institution_HostImpl();

		institution_Host.setNew(true);
		institution_Host.setPrimaryKey(institutionHostId);

		return institution_Host;
	}

	/**
	 * Removes the institution_ host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host remove(long institutionHostId)
		throws NoSuchInstitution_HostException, SystemException {
		return remove((Serializable)institutionHostId);
	}

	/**
	 * Removes the institution_ host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the institution_ host
	 * @return the institution_ host that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host remove(Serializable primaryKey)
		throws NoSuchInstitution_HostException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Institution_Host institution_Host = (Institution_Host)session.get(Institution_HostImpl.class,
					primaryKey);

			if (institution_Host == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInstitution_HostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(institution_Host);
		}
		catch (NoSuchInstitution_HostException nsee) {
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
	protected Institution_Host removeImpl(Institution_Host institution_Host)
		throws SystemException {
		institution_Host = toUnwrappedModel(institution_Host);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(institution_Host)) {
				institution_Host = (Institution_Host)session.get(Institution_HostImpl.class,
						institution_Host.getPrimaryKeyObj());
			}

			if (institution_Host != null) {
				session.delete(institution_Host);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (institution_Host != null) {
			clearCache(institution_Host);
		}

		return institution_Host;
	}

	@Override
	public Institution_Host updateImpl(
		de.uhh.l2g.plugins.model.Institution_Host institution_Host)
		throws SystemException {
		institution_Host = toUnwrappedModel(institution_Host);

		boolean isNew = institution_Host.isNew();

		Institution_HostModelImpl institution_HostModelImpl = (Institution_HostModelImpl)institution_Host;

		Session session = null;

		try {
			session = openSession();

			if (institution_Host.isNew()) {
				session.save(institution_Host);

				institution_Host.setNew(false);
			}
			else {
				session.merge(institution_Host);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Institution_HostModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((institution_HostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institution_HostModelImpl.getOriginalInstitutionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID,
					args);

				args = new Object[] { institution_HostModelImpl.getInstitutionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID,
					args);
			}

			if ((institution_HostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institution_HostModelImpl.getOriginalHostId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOSTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSTID,
					args);

				args = new Object[] { institution_HostModelImpl.getHostId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOSTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOSTID,
					args);
			}
		}

		EntityCacheUtil.putResult(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostImpl.class, institution_Host.getPrimaryKey(),
			institution_Host);

		return institution_Host;
	}

	protected Institution_Host toUnwrappedModel(
		Institution_Host institution_Host) {
		if (institution_Host instanceof Institution_HostImpl) {
			return institution_Host;
		}

		Institution_HostImpl institution_HostImpl = new Institution_HostImpl();

		institution_HostImpl.setNew(institution_Host.isNew());
		institution_HostImpl.setPrimaryKey(institution_Host.getPrimaryKey());

		institution_HostImpl.setInstitutionHostId(institution_Host.getInstitutionHostId());
		institution_HostImpl.setInstitutionId(institution_Host.getInstitutionId());
		institution_HostImpl.setHostId(institution_Host.getHostId());

		return institution_HostImpl;
	}

	/**
	 * Returns the institution_ host with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the institution_ host
	 * @return the institution_ host
	 * @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInstitution_HostException, SystemException {
		Institution_Host institution_Host = fetchByPrimaryKey(primaryKey);

		if (institution_Host == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInstitution_HostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return institution_Host;
	}

	/**
	 * Returns the institution_ host with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchInstitution_HostException} if it could not be found.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host
	 * @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host findByPrimaryKey(long institutionHostId)
		throws NoSuchInstitution_HostException, SystemException {
		return findByPrimaryKey((Serializable)institutionHostId);
	}

	/**
	 * Returns the institution_ host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the institution_ host
	 * @return the institution_ host, or <code>null</code> if a institution_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Institution_Host institution_Host = (Institution_Host)EntityCacheUtil.getResult(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
				Institution_HostImpl.class, primaryKey);

		if (institution_Host == _nullInstitution_Host) {
			return null;
		}

		if (institution_Host == null) {
			Session session = null;

			try {
				session = openSession();

				institution_Host = (Institution_Host)session.get(Institution_HostImpl.class,
						primaryKey);

				if (institution_Host != null) {
					cacheResult(institution_Host);
				}
				else {
					EntityCacheUtil.putResult(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
						Institution_HostImpl.class, primaryKey,
						_nullInstitution_Host);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
					Institution_HostImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return institution_Host;
	}

	/**
	 * Returns the institution_ host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host, or <code>null</code> if a institution_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution_Host fetchByPrimaryKey(long institutionHostId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)institutionHostId);
	}

	/**
	 * Returns all the institution_ hosts.
	 *
	 * @return the institution_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution_Host> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of institution_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution_Host> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of institution_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution_Host> findAll(int start, int end,
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

		List<Institution_Host> list = (List<Institution_Host>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INSTITUTION_HOST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INSTITUTION_HOST;

				if (pagination) {
					sql = sql.concat(Institution_HostModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Institution_Host>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution_Host>(list);
				}
				else {
					list = (List<Institution_Host>)QueryUtil.list(q,
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
	 * Removes all the institution_ hosts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Institution_Host institution_Host : findAll()) {
			remove(institution_Host);
		}
	}

	/**
	 * Returns the number of institution_ hosts.
	 *
	 * @return the number of institution_ hosts
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

				Query q = session.createQuery(_SQL_COUNT_INSTITUTION_HOST);

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
	 * Initializes the institution_ host persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Institution_Host")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Institution_Host>> listenersList = new ArrayList<ModelListener<Institution_Host>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Institution_Host>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Institution_HostImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INSTITUTION_HOST = "SELECT institution_Host FROM Institution_Host institution_Host";
	private static final String _SQL_SELECT_INSTITUTION_HOST_WHERE = "SELECT institution_Host FROM Institution_Host institution_Host WHERE ";
	private static final String _SQL_COUNT_INSTITUTION_HOST = "SELECT COUNT(institution_Host) FROM Institution_Host institution_Host";
	private static final String _SQL_COUNT_INSTITUTION_HOST_WHERE = "SELECT COUNT(institution_Host) FROM Institution_Host institution_Host WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "institution_Host.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Institution_Host exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Institution_Host exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Institution_HostPersistenceImpl.class);
	private static Institution_Host _nullInstitution_Host = new Institution_HostImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Institution_Host> toCacheModel() {
				return _nullInstitution_HostCacheModel;
			}
		};

	private static CacheModel<Institution_Host> _nullInstitution_HostCacheModel = new CacheModel<Institution_Host>() {
			@Override
			public Institution_Host toEntityModel() {
				return _nullInstitution_Host;
			}
		};
}
