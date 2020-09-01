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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchProducerException;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.impl.ProducerImpl;
import de.uhh.l2g.plugins.model.impl.ProducerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the producer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ProducerPersistence
 * @see ProducerUtil
 * @generated
 */
public class ProducerPersistenceImpl extends BasePersistenceImpl<Producer>
	implements ProducerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProducerUtil} to access the producer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProducerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HOST = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHost",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOST = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHost",
			new String[] { Long.class.getName() },
			ProducerModelImpl.HOSTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HOST = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHost",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the producers where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer> findByHost(long hostId) throws SystemException {
		return findByHost(hostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producers where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer> findByHost(long hostId, int start, int end)
		throws SystemException {
		return findByHost(hostId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producers where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer> findByHost(long hostId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOST;
			finderArgs = new Object[] { hostId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HOST;
			finderArgs = new Object[] { hostId, start, end, orderByComparator };
		}

		List<Producer> list = (List<Producer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Producer producer : list) {
				if ((hostId != producer.getHostId())) {
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

			query.append(_SQL_SELECT_PRODUCER_WHERE);

			query.append(_FINDER_COLUMN_HOST_HOSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProducerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hostId);

				if (!pagination) {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Producer>(list);
				}
				else {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer findByHost_First(long hostId,
		OrderByComparator orderByComparator)
		throws NoSuchProducerException, SystemException {
		Producer producer = fetchByHost_First(hostId, orderByComparator);

		if (producer != null) {
			return producer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hostId=");
		msg.append(hostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducerException(msg.toString());
	}

	/**
	 * Returns the first producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer fetchByHost_First(long hostId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Producer> list = findByHost(hostId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer findByHost_Last(long hostId,
		OrderByComparator orderByComparator)
		throws NoSuchProducerException, SystemException {
		Producer producer = fetchByHost_Last(hostId, orderByComparator);

		if (producer != null) {
			return producer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hostId=");
		msg.append(hostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducerException(msg.toString());
	}

	/**
	 * Returns the last producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer fetchByHost_Last(long hostId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByHost(hostId);

		if (count == 0) {
			return null;
		}

		List<Producer> list = findByHost(hostId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producers before and after the current producer in the ordered set where hostId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer[] findByHost_PrevAndNext(long producerId, long hostId,
		OrderByComparator orderByComparator)
		throws NoSuchProducerException, SystemException {
		Producer producer = findByPrimaryKey(producerId);

		Session session = null;

		try {
			session = openSession();

			Producer[] array = new ProducerImpl[3];

			array[0] = getByHost_PrevAndNext(session, producer, hostId,
					orderByComparator, true);

			array[1] = producer;

			array[2] = getByHost_PrevAndNext(session, producer, hostId,
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

	protected Producer getByHost_PrevAndNext(Session session,
		Producer producer, long hostId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCER_WHERE);

		query.append(_FINDER_COLUMN_HOST_HOSTID_2);

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
			query.append(ProducerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(hostId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(producer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Producer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producers where hostId = &#63; from the database.
	 *
	 * @param hostId the host ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByHost(long hostId) throws SystemException {
		for (Producer producer : findByHost(hostId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(producer);
		}
	}

	/**
	 * Returns the number of producers where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the number of matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByHost(long hostId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HOST;

		Object[] finderArgs = new Object[] { hostId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCER_WHERE);

			query.append(_FINDER_COLUMN_HOST_HOSTID_2);

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

	private static final String _FINDER_COLUMN_HOST_HOSTID_2 = "producer.hostId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTION =
		new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInstitution",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION =
		new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInstitution",
			new String[] { Long.class.getName() },
			ProducerModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTITUTION = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstitution",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the producers where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer> findByInstitution(long institutionId)
		throws SystemException {
		return findByInstitution(institutionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producers where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer> findByInstitution(long institutionId, int start,
		int end) throws SystemException {
		return findByInstitution(institutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producers where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer> findByInstitution(long institutionId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION;
			finderArgs = new Object[] { institutionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTION;
			finderArgs = new Object[] {
					institutionId,
					
					start, end, orderByComparator
				};
		}

		List<Producer> list = (List<Producer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Producer producer : list) {
				if ((institutionId != producer.getInstitutionId())) {
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

			query.append(_SQL_SELECT_PRODUCER_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProducerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

				if (!pagination) {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Producer>(list);
				}
				else {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer findByInstitution_First(long institutionId,
		OrderByComparator orderByComparator)
		throws NoSuchProducerException, SystemException {
		Producer producer = fetchByInstitution_First(institutionId,
				orderByComparator);

		if (producer != null) {
			return producer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducerException(msg.toString());
	}

	/**
	 * Returns the first producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer fetchByInstitution_First(long institutionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Producer> list = findByInstitution(institutionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer findByInstitution_Last(long institutionId,
		OrderByComparator orderByComparator)
		throws NoSuchProducerException, SystemException {
		Producer producer = fetchByInstitution_Last(institutionId,
				orderByComparator);

		if (producer != null) {
			return producer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducerException(msg.toString());
	}

	/**
	 * Returns the last producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer fetchByInstitution_Last(long institutionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByInstitution(institutionId);

		if (count == 0) {
			return null;
		}

		List<Producer> list = findByInstitution(institutionId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producers before and after the current producer in the ordered set where institutionId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer[] findByInstitution_PrevAndNext(long producerId,
		long institutionId, OrderByComparator orderByComparator)
		throws NoSuchProducerException, SystemException {
		Producer producer = findByPrimaryKey(producerId);

		Session session = null;

		try {
			session = openSession();

			Producer[] array = new ProducerImpl[3];

			array[0] = getByInstitution_PrevAndNext(session, producer,
					institutionId, orderByComparator, true);

			array[1] = producer;

			array[2] = getByInstitution_PrevAndNext(session, producer,
					institutionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Producer getByInstitution_PrevAndNext(Session session,
		Producer producer, long institutionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCER_WHERE);

		query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

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
			query.append(ProducerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(institutionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(producer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Producer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producers where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByInstitution(long institutionId)
		throws SystemException {
		for (Producer producer : findByInstitution(institutionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(producer);
		}
	}

	/**
	 * Returns the number of producers where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching producers
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

			query.append(_SQL_COUNT_PRODUCER_WHERE);

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

	private static final String _FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2 = "producer.institutionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			ProducerModelImpl.APPROVED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the producers where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer> findByStatus(int approved) throws SystemException {
		return findByStatus(approved, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer> findByStatus(int approved, int start, int end)
		throws SystemException {
		return findByStatus(approved, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer> findByStatus(int approved, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { approved };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { approved, start, end, orderByComparator };
		}

		List<Producer> list = (List<Producer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Producer producer : list) {
				if ((approved != producer.getApproved())) {
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

			query.append(_SQL_SELECT_PRODUCER_WHERE);

			query.append(_FINDER_COLUMN_STATUS_APPROVED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProducerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approved);

				if (!pagination) {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Producer>(list);
				}
				else {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer findByStatus_First(int approved,
		OrderByComparator orderByComparator)
		throws NoSuchProducerException, SystemException {
		Producer producer = fetchByStatus_First(approved, orderByComparator);

		if (producer != null) {
			return producer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("approved=");
		msg.append(approved);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducerException(msg.toString());
	}

	/**
	 * Returns the first producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer fetchByStatus_First(int approved,
		OrderByComparator orderByComparator) throws SystemException {
		List<Producer> list = findByStatus(approved, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer findByStatus_Last(int approved,
		OrderByComparator orderByComparator)
		throws NoSuchProducerException, SystemException {
		Producer producer = fetchByStatus_Last(approved, orderByComparator);

		if (producer != null) {
			return producer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("approved=");
		msg.append(approved);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProducerException(msg.toString());
	}

	/**
	 * Returns the last producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer fetchByStatus_Last(int approved,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(approved);

		if (count == 0) {
			return null;
		}

		List<Producer> list = findByStatus(approved, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producers before and after the current producer in the ordered set where approved = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer[] findByStatus_PrevAndNext(long producerId, int approved,
		OrderByComparator orderByComparator)
		throws NoSuchProducerException, SystemException {
		Producer producer = findByPrimaryKey(producerId);

		Session session = null;

		try {
			session = openSession();

			Producer[] array = new ProducerImpl[3];

			array[0] = getByStatus_PrevAndNext(session, producer, approved,
					orderByComparator, true);

			array[1] = producer;

			array[2] = getByStatus_PrevAndNext(session, producer, approved,
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

	protected Producer getByStatus_PrevAndNext(Session session,
		Producer producer, int approved, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCER_WHERE);

		query.append(_FINDER_COLUMN_STATUS_APPROVED_2);

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
			query.append(ProducerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(approved);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(producer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Producer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producers where approved = &#63; from the database.
	 *
	 * @param approved the approved
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(int approved) throws SystemException {
		for (Producer producer : findByStatus(approved, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(producer);
		}
	}

	/**
	 * Returns the number of producers where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the number of matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(int approved) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { approved };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCER_WHERE);

			query.append(_FINDER_COLUMN_STATUS_APPROVED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approved);

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

	private static final String _FINDER_COLUMN_STATUS_APPROVED_2 = "producer.approved = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_DIRECTORY = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDirectory",
			new String[] { String.class.getName() },
			ProducerModelImpl.HOMEDIR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DIRECTORY = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDirectory",
			new String[] { String.class.getName() });

	/**
	 * Returns the producer where homeDir = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchProducerException} if it could not be found.
	 *
	 * @param homeDir the home dir
	 * @return the matching producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer findByDirectory(String homeDir)
		throws NoSuchProducerException, SystemException {
		Producer producer = fetchByDirectory(homeDir);

		if (producer == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("homeDir=");
			msg.append(homeDir);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProducerException(msg.toString());
		}

		return producer;
	}

	/**
	 * Returns the producer where homeDir = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param homeDir the home dir
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer fetchByDirectory(String homeDir) throws SystemException {
		return fetchByDirectory(homeDir, true);
	}

	/**
	 * Returns the producer where homeDir = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param homeDir the home dir
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer fetchByDirectory(String homeDir, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { homeDir };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DIRECTORY,
					finderArgs, this);
		}

		if (result instanceof Producer) {
			Producer producer = (Producer)result;

			if (!Validator.equals(homeDir, producer.getHomeDir())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PRODUCER_WHERE);

			boolean bindHomeDir = false;

			if (homeDir == null) {
				query.append(_FINDER_COLUMN_DIRECTORY_HOMEDIR_1);
			}
			else if (homeDir.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIRECTORY_HOMEDIR_3);
			}
			else {
				bindHomeDir = true;

				query.append(_FINDER_COLUMN_DIRECTORY_HOMEDIR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHomeDir) {
					qPos.add(homeDir);
				}

				List<Producer> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DIRECTORY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ProducerPersistenceImpl.fetchByDirectory(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Producer producer = list.get(0);

					result = producer;

					cacheResult(producer);

					if ((producer.getHomeDir() == null) ||
							!producer.getHomeDir().equals(homeDir)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DIRECTORY,
							finderArgs, producer);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DIRECTORY,
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
			return (Producer)result;
		}
	}

	/**
	 * Removes the producer where homeDir = &#63; from the database.
	 *
	 * @param homeDir the home dir
	 * @return the producer that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer removeByDirectory(String homeDir)
		throws NoSuchProducerException, SystemException {
		Producer producer = findByDirectory(homeDir);

		return remove(producer);
	}

	/**
	 * Returns the number of producers where homeDir = &#63;.
	 *
	 * @param homeDir the home dir
	 * @return the number of matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDirectory(String homeDir) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DIRECTORY;

		Object[] finderArgs = new Object[] { homeDir };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCER_WHERE);

			boolean bindHomeDir = false;

			if (homeDir == null) {
				query.append(_FINDER_COLUMN_DIRECTORY_HOMEDIR_1);
			}
			else if (homeDir.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIRECTORY_HOMEDIR_3);
			}
			else {
				bindHomeDir = true;

				query.append(_FINDER_COLUMN_DIRECTORY_HOMEDIR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHomeDir) {
					qPos.add(homeDir);
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

	private static final String _FINDER_COLUMN_DIRECTORY_HOMEDIR_1 = "producer.homeDir IS NULL";
	private static final String _FINDER_COLUMN_DIRECTORY_HOMEDIR_2 = "producer.homeDir = ?";
	private static final String _FINDER_COLUMN_DIRECTORY_HOMEDIR_3 = "(producer.homeDir IS NULL OR producer.homeDir = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UID = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, ProducerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUID",
			new String[] { String.class.getName() },
			ProducerModelImpl.IDNUM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UID = new FinderPath(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUID",
			new String[] { String.class.getName() });

	/**
	 * Returns the producer where idNum = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchProducerException} if it could not be found.
	 *
	 * @param idNum the id num
	 * @return the matching producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer findByUID(String idNum)
		throws NoSuchProducerException, SystemException {
		Producer producer = fetchByUID(idNum);

		if (producer == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("idNum=");
			msg.append(idNum);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProducerException(msg.toString());
		}

		return producer;
	}

	/**
	 * Returns the producer where idNum = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idNum the id num
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer fetchByUID(String idNum) throws SystemException {
		return fetchByUID(idNum, true);
	}

	/**
	 * Returns the producer where idNum = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idNum the id num
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer fetchByUID(String idNum, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { idNum };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UID,
					finderArgs, this);
		}

		if (result instanceof Producer) {
			Producer producer = (Producer)result;

			if (!Validator.equals(idNum, producer.getIdNum())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PRODUCER_WHERE);

			boolean bindIdNum = false;

			if (idNum == null) {
				query.append(_FINDER_COLUMN_UID_IDNUM_1);
			}
			else if (idNum.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UID_IDNUM_3);
			}
			else {
				bindIdNum = true;

				query.append(_FINDER_COLUMN_UID_IDNUM_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdNum) {
					qPos.add(idNum);
				}

				List<Producer> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ProducerPersistenceImpl.fetchByUID(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Producer producer = list.get(0);

					result = producer;

					cacheResult(producer);

					if ((producer.getIdNum() == null) ||
							!producer.getIdNum().equals(idNum)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UID,
							finderArgs, producer);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UID,
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
			return (Producer)result;
		}
	}

	/**
	 * Removes the producer where idNum = &#63; from the database.
	 *
	 * @param idNum the id num
	 * @return the producer that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer removeByUID(String idNum)
		throws NoSuchProducerException, SystemException {
		Producer producer = findByUID(idNum);

		return remove(producer);
	}

	/**
	 * Returns the number of producers where idNum = &#63;.
	 *
	 * @param idNum the id num
	 * @return the number of matching producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUID(String idNum) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UID;

		Object[] finderArgs = new Object[] { idNum };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCER_WHERE);

			boolean bindIdNum = false;

			if (idNum == null) {
				query.append(_FINDER_COLUMN_UID_IDNUM_1);
			}
			else if (idNum.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UID_IDNUM_3);
			}
			else {
				bindIdNum = true;

				query.append(_FINDER_COLUMN_UID_IDNUM_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdNum) {
					qPos.add(idNum);
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

	private static final String _FINDER_COLUMN_UID_IDNUM_1 = "producer.idNum IS NULL";
	private static final String _FINDER_COLUMN_UID_IDNUM_2 = "producer.idNum = ?";
	private static final String _FINDER_COLUMN_UID_IDNUM_3 = "(producer.idNum IS NULL OR producer.idNum = '')";

	public ProducerPersistenceImpl() {
		setModelClass(Producer.class);
	}

	/**
	 * Caches the producer in the entity cache if it is enabled.
	 *
	 * @param producer the producer
	 */
	@Override
	public void cacheResult(Producer producer) {
		EntityCacheUtil.putResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerImpl.class, producer.getPrimaryKey(), producer);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DIRECTORY,
			new Object[] { producer.getHomeDir() }, producer);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UID,
			new Object[] { producer.getIdNum() }, producer);

		producer.resetOriginalValues();
	}

	/**
	 * Caches the producers in the entity cache if it is enabled.
	 *
	 * @param producers the producers
	 */
	@Override
	public void cacheResult(List<Producer> producers) {
		for (Producer producer : producers) {
			if (EntityCacheUtil.getResult(
						ProducerModelImpl.ENTITY_CACHE_ENABLED,
						ProducerImpl.class, producer.getPrimaryKey()) == null) {
				cacheResult(producer);
			}
			else {
				producer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all producers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProducerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProducerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the producer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Producer producer) {
		EntityCacheUtil.removeResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerImpl.class, producer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(producer);
	}

	@Override
	public void clearCache(List<Producer> producers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Producer producer : producers) {
			EntityCacheUtil.removeResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
				ProducerImpl.class, producer.getPrimaryKey());

			clearUniqueFindersCache(producer);
		}
	}

	protected void cacheUniqueFindersCache(Producer producer) {
		if (producer.isNew()) {
			Object[] args = new Object[] { producer.getHomeDir() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DIRECTORY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DIRECTORY, args,
				producer);

			args = new Object[] { producer.getIdNum() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UID, args, producer);
		}
		else {
			ProducerModelImpl producerModelImpl = (ProducerModelImpl)producer;

			if ((producerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DIRECTORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { producer.getHomeDir() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DIRECTORY, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DIRECTORY, args,
					producer);
			}

			if ((producerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { producer.getIdNum() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UID, args,
					producer);
			}
		}
	}

	protected void clearUniqueFindersCache(Producer producer) {
		ProducerModelImpl producerModelImpl = (ProducerModelImpl)producer;

		Object[] args = new Object[] { producer.getHomeDir() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DIRECTORY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DIRECTORY, args);

		if ((producerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DIRECTORY.getColumnBitmask()) != 0) {
			args = new Object[] { producerModelImpl.getOriginalHomeDir() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DIRECTORY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DIRECTORY, args);
		}

		args = new Object[] { producer.getIdNum() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UID, args);

		if ((producerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UID.getColumnBitmask()) != 0) {
			args = new Object[] { producerModelImpl.getOriginalIdNum() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UID, args);
		}
	}

	/**
	 * Creates a new producer with the primary key. Does not add the producer to the database.
	 *
	 * @param producerId the primary key for the new producer
	 * @return the new producer
	 */
	@Override
	public Producer create(long producerId) {
		Producer producer = new ProducerImpl();

		producer.setNew(true);
		producer.setPrimaryKey(producerId);

		return producer;
	}

	/**
	 * Removes the producer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param producerId the primary key of the producer
	 * @return the producer that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer remove(long producerId)
		throws NoSuchProducerException, SystemException {
		return remove((Serializable)producerId);
	}

	/**
	 * Removes the producer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the producer
	 * @return the producer that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer remove(Serializable primaryKey)
		throws NoSuchProducerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Producer producer = (Producer)session.get(ProducerImpl.class,
					primaryKey);

			if (producer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProducerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(producer);
		}
		catch (NoSuchProducerException nsee) {
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
	protected Producer removeImpl(Producer producer) throws SystemException {
		producer = toUnwrappedModel(producer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(producer)) {
				producer = (Producer)session.get(ProducerImpl.class,
						producer.getPrimaryKeyObj());
			}

			if (producer != null) {
				session.delete(producer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (producer != null) {
			clearCache(producer);
		}

		return producer;
	}

	@Override
	public Producer updateImpl(de.uhh.l2g.plugins.model.Producer producer)
		throws SystemException {
		producer = toUnwrappedModel(producer);

		boolean isNew = producer.isNew();

		ProducerModelImpl producerModelImpl = (ProducerModelImpl)producer;

		Session session = null;

		try {
			session = openSession();

			if (producer.isNew()) {
				session.save(producer);

				producer.setNew(false);
			}
			else {
				session.merge(producer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProducerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((producerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOST.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						producerModelImpl.getOriginalHostId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOST, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOST,
					args);

				args = new Object[] { producerModelImpl.getHostId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOST, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOST,
					args);
			}

			if ((producerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						producerModelImpl.getOriginalInstitutionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION,
					args);

				args = new Object[] { producerModelImpl.getInstitutionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION,
					args);
			}

			if ((producerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						producerModelImpl.getOriginalApproved()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { producerModelImpl.getApproved() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
			ProducerImpl.class, producer.getPrimaryKey(), producer);

		clearUniqueFindersCache(producer);
		cacheUniqueFindersCache(producer);

		return producer;
	}

	protected Producer toUnwrappedModel(Producer producer) {
		if (producer instanceof ProducerImpl) {
			return producer;
		}

		ProducerImpl producerImpl = new ProducerImpl();

		producerImpl.setNew(producer.isNew());
		producerImpl.setPrimaryKey(producer.getPrimaryKey());

		producerImpl.setProducerId(producer.getProducerId());
		producerImpl.setIdNum(producer.getIdNum());
		producerImpl.setHomeDir(producer.getHomeDir());
		producerImpl.setHostId(producer.getHostId());
		producerImpl.setInstitutionId(producer.getInstitutionId());
		producerImpl.setNumberOfProductions(producer.getNumberOfProductions());
		producerImpl.setApproved(producer.getApproved());

		return producerImpl;
	}

	/**
	 * Returns the producer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the producer
	 * @return the producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProducerException, SystemException {
		Producer producer = fetchByPrimaryKey(primaryKey);

		if (producer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProducerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return producer;
	}

	/**
	 * Returns the producer with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchProducerException} if it could not be found.
	 *
	 * @param producerId the primary key of the producer
	 * @return the producer
	 * @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer findByPrimaryKey(long producerId)
		throws NoSuchProducerException, SystemException {
		return findByPrimaryKey((Serializable)producerId);
	}

	/**
	 * Returns the producer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the producer
	 * @return the producer, or <code>null</code> if a producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Producer producer = (Producer)EntityCacheUtil.getResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
				ProducerImpl.class, primaryKey);

		if (producer == _nullProducer) {
			return null;
		}

		if (producer == null) {
			Session session = null;

			try {
				session = openSession();

				producer = (Producer)session.get(ProducerImpl.class, primaryKey);

				if (producer != null) {
					cacheResult(producer);
				}
				else {
					EntityCacheUtil.putResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
						ProducerImpl.class, primaryKey, _nullProducer);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProducerModelImpl.ENTITY_CACHE_ENABLED,
					ProducerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return producer;
	}

	/**
	 * Returns the producer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param producerId the primary key of the producer
	 * @return the producer, or <code>null</code> if a producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Producer fetchByPrimaryKey(long producerId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)producerId);
	}

	/**
	 * Returns all the producers.
	 *
	 * @return the producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Producer> findAll(int start, int end,
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

		List<Producer> list = (List<Producer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRODUCER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCER;

				if (pagination) {
					sql = sql.concat(ProducerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Producer>(list);
				}
				else {
					list = (List<Producer>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the producers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Producer producer : findAll()) {
			remove(producer);
		}
	}

	/**
	 * Returns the number of producers.
	 *
	 * @return the number of producers
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

				Query q = session.createQuery(_SQL_COUNT_PRODUCER);

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
	 * Initializes the producer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Producer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Producer>> listenersList = new ArrayList<ModelListener<Producer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Producer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProducerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PRODUCER = "SELECT producer FROM Producer producer";
	private static final String _SQL_SELECT_PRODUCER_WHERE = "SELECT producer FROM Producer producer WHERE ";
	private static final String _SQL_COUNT_PRODUCER = "SELECT COUNT(producer) FROM Producer producer";
	private static final String _SQL_COUNT_PRODUCER_WHERE = "SELECT COUNT(producer) FROM Producer producer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "producer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Producer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Producer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProducerPersistenceImpl.class);
	private static Producer _nullProducer = new ProducerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Producer> toCacheModel() {
				return _nullProducerCacheModel;
			}
		};

	private static CacheModel<Producer> _nullProducerCacheModel = new CacheModel<Producer>() {
			@Override
			public Producer toEntityModel() {
				return _nullProducer;
			}
		};
}
