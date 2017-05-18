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

package de.uhh.l2g.plugins.migration.service.persistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException;
import de.uhh.l2g.plugins.migration.model.LegacyAddress;
import de.uhh.l2g.plugins.migration.model.impl.LegacyAddressImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyAddressPersistence
 * @see LegacyAddressUtil
 * @generated
 */
public class LegacyAddressPersistenceImpl extends BasePersistenceImpl<LegacyAddress>
	implements LegacyAddressPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyAddressUtil} to access the legacy address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyAddressImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyId", new String[] { Long.class.getName() },
			LegacyAddressModelImpl.COMPANYID_COLUMN_BITMASK |
			LegacyAddressModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the legacy addresses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legacy addresses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @return the range of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy addresses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<LegacyAddress> list = (List<LegacyAddress>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegacyAddress legacyAddress : list) {
				if ((companyId != legacyAddress.getCompanyId())) {
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

			query.append(_SQL_SELECT_LEGACYADDRESS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LegacyAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyAddress>(list);
				}
				else {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legacy address in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (legacyAddress != null) {
			return legacyAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyAddressException(msg.toString());
	}

	/**
	 * Returns the first legacy address in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy address, or <code>null</code> if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegacyAddress> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legacy address in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (legacyAddress != null) {
			return legacyAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyAddressException(msg.toString());
	}

	/**
	 * Returns the last legacy address in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy address, or <code>null</code> if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<LegacyAddress> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legacy addresses before and after the current legacy address in the ordered set where companyId = &#63;.
	 *
	 * @param addressId the primary key of the current legacy address
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a legacy address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress[] findByCompanyId_PrevAndNext(long addressId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			LegacyAddress[] array = new LegacyAddressImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, legacyAddress,
					companyId, orderByComparator, true);

			array[1] = legacyAddress;

			array[2] = getByCompanyId_PrevAndNext(session, legacyAddress,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegacyAddress getByCompanyId_PrevAndNext(Session session,
		LegacyAddress legacyAddress, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGACYADDRESS_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(LegacyAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legacyAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegacyAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legacy addresses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (LegacyAddress legacyAddress : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legacyAddress);
		}
	}

	/**
	 * Returns the number of legacy addresses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGACYADDRESS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "legacyAddress.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserId", new String[] { Long.class.getName() },
			LegacyAddressModelImpl.USERID_COLUMN_BITMASK |
			LegacyAddressModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the legacy addresses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy addresses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @return the range of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy addresses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<LegacyAddress> list = (List<LegacyAddress>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegacyAddress legacyAddress : list) {
				if ((userId != legacyAddress.getUserId())) {
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

			query.append(_SQL_SELECT_LEGACYADDRESS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LegacyAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyAddress>(list);
				}
				else {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legacy address in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByUserId_First(userId,
				orderByComparator);

		if (legacyAddress != null) {
			return legacyAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyAddressException(msg.toString());
	}

	/**
	 * Returns the first legacy address in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy address, or <code>null</code> if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegacyAddress> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legacy address in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByUserId_Last(userId,
				orderByComparator);

		if (legacyAddress != null) {
			return legacyAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyAddressException(msg.toString());
	}

	/**
	 * Returns the last legacy address in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy address, or <code>null</code> if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<LegacyAddress> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legacy addresses before and after the current legacy address in the ordered set where userId = &#63;.
	 *
	 * @param addressId the primary key of the current legacy address
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a legacy address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress[] findByUserId_PrevAndNext(long addressId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			LegacyAddress[] array = new LegacyAddressImpl[3];

			array[0] = getByUserId_PrevAndNext(session, legacyAddress, userId,
					orderByComparator, true);

			array[1] = legacyAddress;

			array[2] = getByUserId_PrevAndNext(session, legacyAddress, userId,
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

	protected LegacyAddress getByUserId_PrevAndNext(Session session,
		LegacyAddress legacyAddress, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGACYADDRESS_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(LegacyAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legacyAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegacyAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legacy addresses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (LegacyAddress legacyAddress : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legacyAddress);
		}
	}

	/**
	 * Returns the number of legacy addresses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGACYADDRESS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "legacyAddress.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByC_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			LegacyAddressModelImpl.COMPANYID_COLUMN_BITMASK |
			LegacyAddressModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			LegacyAddressModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the legacy addresses where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @return the matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByC_C(long companyId, long classNameId)
		throws SystemException {
		return findByC_C(companyId, classNameId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy addresses where companyId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @return the range of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByC_C(long companyId, long classNameId,
		int start, int end) throws SystemException {
		return findByC_C(companyId, classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy addresses where companyId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByC_C(long companyId, long classNameId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C;
			finderArgs = new Object[] { companyId, classNameId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C;
			finderArgs = new Object[] {
					companyId, classNameId,
					
					start, end, orderByComparator
				};
		}

		List<LegacyAddress> list = (List<LegacyAddress>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegacyAddress legacyAddress : list) {
				if ((companyId != legacyAddress.getCompanyId()) ||
						(classNameId != legacyAddress.getClassNameId())) {
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

			query.append(_SQL_SELECT_LEGACYADDRESS_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LegacyAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				if (!pagination) {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyAddress>(list);
				}
				else {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legacy address in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByC_C_First(long companyId, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByC_C_First(companyId, classNameId,
				orderByComparator);

		if (legacyAddress != null) {
			return legacyAddress;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyAddressException(msg.toString());
	}

	/**
	 * Returns the first legacy address in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy address, or <code>null</code> if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByC_C_First(long companyId, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegacyAddress> list = findByC_C(companyId, classNameId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legacy address in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByC_C_Last(long companyId, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByC_C_Last(companyId, classNameId,
				orderByComparator);

		if (legacyAddress != null) {
			return legacyAddress;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyAddressException(msg.toString());
	}

	/**
	 * Returns the last legacy address in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy address, or <code>null</code> if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByC_C_Last(long companyId, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_C(companyId, classNameId);

		if (count == 0) {
			return null;
		}

		List<LegacyAddress> list = findByC_C(companyId, classNameId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legacy addresses before and after the current legacy address in the ordered set where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param addressId the primary key of the current legacy address
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a legacy address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress[] findByC_C_PrevAndNext(long addressId,
		long companyId, long classNameId, OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			LegacyAddress[] array = new LegacyAddressImpl[3];

			array[0] = getByC_C_PrevAndNext(session, legacyAddress, companyId,
					classNameId, orderByComparator, true);

			array[1] = legacyAddress;

			array[2] = getByC_C_PrevAndNext(session, legacyAddress, companyId,
					classNameId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegacyAddress getByC_C_PrevAndNext(Session session,
		LegacyAddress legacyAddress, long companyId, long classNameId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGACYADDRESS_WHERE);

		query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

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
			query.append(LegacyAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(classNameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legacyAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegacyAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legacy addresses where companyId = &#63; and classNameId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C(long companyId, long classNameId)
		throws SystemException {
		for (LegacyAddress legacyAddress : findByC_C(companyId, classNameId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legacyAddress);
		}
	}

	/**
	 * Returns the number of legacy addresses where companyId = &#63; and classNameId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @return the number of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C(long companyId, long classNameId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C;

		Object[] finderArgs = new Object[] { companyId, classNameId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGACYADDRESS_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

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

	private static final String _FINDER_COLUMN_C_C_COMPANYID_2 = "legacyAddress.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_CLASSNAMEID_2 = "legacyAddress.classNameId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			LegacyAddressModelImpl.COMPANYID_COLUMN_BITMASK |
			LegacyAddressModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			LegacyAddressModelImpl.CLASSPK_COLUMN_BITMASK |
			LegacyAddressModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_C = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByC_C_C(long companyId, long classNameId,
		long classPK) throws SystemException {
		return findByC_C_C(companyId, classNameId, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @return the range of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByC_C_C(long companyId, long classNameId,
		long classPK, int start, int end) throws SystemException {
		return findByC_C_C(companyId, classNameId, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByC_C_C(long companyId, long classNameId,
		long classPK, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C;
			finderArgs = new Object[] { companyId, classNameId, classPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C;
			finderArgs = new Object[] {
					companyId, classNameId, classPK,
					
					start, end, orderByComparator
				};
		}

		List<LegacyAddress> list = (List<LegacyAddress>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegacyAddress legacyAddress : list) {
				if ((companyId != legacyAddress.getCompanyId()) ||
						(classNameId != legacyAddress.getClassNameId()) ||
						(classPK != legacyAddress.getClassPK())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_LEGACYADDRESS_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LegacyAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				qPos.add(classPK);

				if (!pagination) {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyAddress>(list);
				}
				else {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByC_C_C_First(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByC_C_C_First(companyId,
				classNameId, classPK, orderByComparator);

		if (legacyAddress != null) {
			return legacyAddress;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyAddressException(msg.toString());
	}

	/**
	 * Returns the first legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy address, or <code>null</code> if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByC_C_C_First(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		List<LegacyAddress> list = findByC_C_C(companyId, classNameId, classPK,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByC_C_C_Last(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByC_C_C_Last(companyId, classNameId,
				classPK, orderByComparator);

		if (legacyAddress != null) {
			return legacyAddress;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyAddressException(msg.toString());
	}

	/**
	 * Returns the last legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy address, or <code>null</code> if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByC_C_C_Last(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C_C(companyId, classNameId, classPK);

		if (count == 0) {
			return null;
		}

		List<LegacyAddress> list = findByC_C_C(companyId, classNameId, classPK,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legacy addresses before and after the current legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param addressId the primary key of the current legacy address
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a legacy address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress[] findByC_C_C_PrevAndNext(long addressId,
		long companyId, long classNameId, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			LegacyAddress[] array = new LegacyAddressImpl[3];

			array[0] = getByC_C_C_PrevAndNext(session, legacyAddress,
					companyId, classNameId, classPK, orderByComparator, true);

			array[1] = legacyAddress;

			array[2] = getByC_C_C_PrevAndNext(session, legacyAddress,
					companyId, classNameId, classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegacyAddress getByC_C_C_PrevAndNext(Session session,
		LegacyAddress legacyAddress, long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGACYADDRESS_WHERE);

		query.append(_FINDER_COLUMN_C_C_C_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_C_C_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_C_C_C_CLASSPK_2);

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
			query.append(LegacyAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(classNameId);

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legacyAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegacyAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_C(long companyId, long classNameId, long classPK)
		throws SystemException {
		for (LegacyAddress legacyAddress : findByC_C_C(companyId, classNameId,
				classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legacyAddress);
		}
	}

	/**
	 * Returns the number of legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the number of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_C(long companyId, long classNameId, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_C;

		Object[] finderArgs = new Object[] { companyId, classNameId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGACYADDRESS_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_C_C_C_COMPANYID_2 = "legacyAddress.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_CLASSNAMEID_2 = "legacyAddress.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_CLASSPK_2 = "legacyAddress.classPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C_M = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_C_C_M",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_M =
		new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByC_C_C_M",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			LegacyAddressModelImpl.COMPANYID_COLUMN_BITMASK |
			LegacyAddressModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			LegacyAddressModelImpl.CLASSPK_COLUMN_BITMASK |
			LegacyAddressModelImpl.MAILING_COLUMN_BITMASK |
			LegacyAddressModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_C_M = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C_M",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63; and mailing = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param mailing the mailing
	 * @return the matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByC_C_C_M(long companyId, long classNameId,
		long classPK, boolean mailing) throws SystemException {
		return findByC_C_C_M(companyId, classNameId, classPK, mailing,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63; and mailing = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param mailing the mailing
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @return the range of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByC_C_C_M(long companyId, long classNameId,
		long classPK, boolean mailing, int start, int end)
		throws SystemException {
		return findByC_C_C_M(companyId, classNameId, classPK, mailing, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63; and mailing = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param mailing the mailing
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByC_C_C_M(long companyId, long classNameId,
		long classPK, boolean mailing, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_M;
			finderArgs = new Object[] { companyId, classNameId, classPK, mailing };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C_M;
			finderArgs = new Object[] {
					companyId, classNameId, classPK, mailing,
					
					start, end, orderByComparator
				};
		}

		List<LegacyAddress> list = (List<LegacyAddress>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegacyAddress legacyAddress : list) {
				if ((companyId != legacyAddress.getCompanyId()) ||
						(classNameId != legacyAddress.getClassNameId()) ||
						(classPK != legacyAddress.getClassPK()) ||
						(mailing != legacyAddress.getMailing())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_LEGACYADDRESS_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_M_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_M_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_M_CLASSPK_2);

			query.append(_FINDER_COLUMN_C_C_C_M_MAILING_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LegacyAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(mailing);

				if (!pagination) {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyAddress>(list);
				}
				else {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and mailing = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param mailing the mailing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByC_C_C_M_First(long companyId, long classNameId,
		long classPK, boolean mailing, OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByC_C_C_M_First(companyId,
				classNameId, classPK, mailing, orderByComparator);

		if (legacyAddress != null) {
			return legacyAddress;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", mailing=");
		msg.append(mailing);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyAddressException(msg.toString());
	}

	/**
	 * Returns the first legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and mailing = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param mailing the mailing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy address, or <code>null</code> if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByC_C_C_M_First(long companyId, long classNameId,
		long classPK, boolean mailing, OrderByComparator orderByComparator)
		throws SystemException {
		List<LegacyAddress> list = findByC_C_C_M(companyId, classNameId,
				classPK, mailing, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and mailing = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param mailing the mailing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByC_C_C_M_Last(long companyId, long classNameId,
		long classPK, boolean mailing, OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByC_C_C_M_Last(companyId,
				classNameId, classPK, mailing, orderByComparator);

		if (legacyAddress != null) {
			return legacyAddress;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", mailing=");
		msg.append(mailing);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyAddressException(msg.toString());
	}

	/**
	 * Returns the last legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and mailing = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param mailing the mailing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy address, or <code>null</code> if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByC_C_C_M_Last(long companyId, long classNameId,
		long classPK, boolean mailing, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C_C_M(companyId, classNameId, classPK, mailing);

		if (count == 0) {
			return null;
		}

		List<LegacyAddress> list = findByC_C_C_M(companyId, classNameId,
				classPK, mailing, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legacy addresses before and after the current legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and mailing = &#63;.
	 *
	 * @param addressId the primary key of the current legacy address
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param mailing the mailing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a legacy address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress[] findByC_C_C_M_PrevAndNext(long addressId,
		long companyId, long classNameId, long classPK, boolean mailing,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			LegacyAddress[] array = new LegacyAddressImpl[3];

			array[0] = getByC_C_C_M_PrevAndNext(session, legacyAddress,
					companyId, classNameId, classPK, mailing,
					orderByComparator, true);

			array[1] = legacyAddress;

			array[2] = getByC_C_C_M_PrevAndNext(session, legacyAddress,
					companyId, classNameId, classPK, mailing,
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

	protected LegacyAddress getByC_C_C_M_PrevAndNext(Session session,
		LegacyAddress legacyAddress, long companyId, long classNameId,
		long classPK, boolean mailing, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGACYADDRESS_WHERE);

		query.append(_FINDER_COLUMN_C_C_C_M_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_C_C_M_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_C_C_C_M_CLASSPK_2);

		query.append(_FINDER_COLUMN_C_C_C_M_MAILING_2);

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
			query.append(LegacyAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(classNameId);

		qPos.add(classPK);

		qPos.add(mailing);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legacyAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegacyAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63; and mailing = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param mailing the mailing
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_C_M(long companyId, long classNameId, long classPK,
		boolean mailing) throws SystemException {
		for (LegacyAddress legacyAddress : findByC_C_C_M(companyId,
				classNameId, classPK, mailing, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(legacyAddress);
		}
	}

	/**
	 * Returns the number of legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63; and mailing = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param mailing the mailing
	 * @return the number of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_C_M(long companyId, long classNameId, long classPK,
		boolean mailing) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_C_M;

		Object[] finderArgs = new Object[] {
				companyId, classNameId, classPK, mailing
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGACYADDRESS_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_M_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_M_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_M_CLASSPK_2);

			query.append(_FINDER_COLUMN_C_C_C_M_MAILING_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(mailing);

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

	private static final String _FINDER_COLUMN_C_C_C_M_COMPANYID_2 = "legacyAddress.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_M_CLASSNAMEID_2 = "legacyAddress.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_M_CLASSPK_2 = "legacyAddress.classPK = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_M_MAILING_2 = "legacyAddress.mailing = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C_P = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P =
		new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED,
			LegacyAddressImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			LegacyAddressModelImpl.COMPANYID_COLUMN_BITMASK |
			LegacyAddressModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			LegacyAddressModelImpl.CLASSPK_COLUMN_BITMASK |
			LegacyAddressModelImpl.PRIMARY_COLUMN_BITMASK |
			LegacyAddressModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_C_P = new FinderPath(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param primary the primary
	 * @return the matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean primary) throws SystemException {
		return findByC_C_C_P(companyId, classNameId, classPK, primary,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param primary the primary
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @return the range of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean primary, int start, int end)
		throws SystemException {
		return findByC_C_C_P(companyId, classNameId, classPK, primary, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param primary the primary
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findByC_C_C_P(long companyId, long classNameId,
		long classPK, boolean primary, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P;
			finderArgs = new Object[] { companyId, classNameId, classPK, primary };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C_P;
			finderArgs = new Object[] {
					companyId, classNameId, classPK, primary,
					
					start, end, orderByComparator
				};
		}

		List<LegacyAddress> list = (List<LegacyAddress>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegacyAddress legacyAddress : list) {
				if ((companyId != legacyAddress.getCompanyId()) ||
						(classNameId != legacyAddress.getClassNameId()) ||
						(classPK != legacyAddress.getClassPK()) ||
						(primary != legacyAddress.getPrimary())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_LEGACYADDRESS_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_P_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_P_CLASSPK_2);

			query.append(_FINDER_COLUMN_C_C_C_P_PRIMARY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LegacyAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(primary);

				if (!pagination) {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyAddress>(list);
				}
				else {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param primary the primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByC_C_C_P_First(long companyId, long classNameId,
		long classPK, boolean primary, OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByC_C_C_P_First(companyId,
				classNameId, classPK, primary, orderByComparator);

		if (legacyAddress != null) {
			return legacyAddress;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", primary=");
		msg.append(primary);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyAddressException(msg.toString());
	}

	/**
	 * Returns the first legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param primary the primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy address, or <code>null</code> if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByC_C_C_P_First(long companyId, long classNameId,
		long classPK, boolean primary, OrderByComparator orderByComparator)
		throws SystemException {
		List<LegacyAddress> list = findByC_C_C_P(companyId, classNameId,
				classPK, primary, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param primary the primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByC_C_C_P_Last(long companyId, long classNameId,
		long classPK, boolean primary, OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByC_C_C_P_Last(companyId,
				classNameId, classPK, primary, orderByComparator);

		if (legacyAddress != null) {
			return legacyAddress;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", primary=");
		msg.append(primary);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyAddressException(msg.toString());
	}

	/**
	 * Returns the last legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param primary the primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy address, or <code>null</code> if a matching legacy address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByC_C_C_P_Last(long companyId, long classNameId,
		long classPK, boolean primary, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C_C_P(companyId, classNameId, classPK, primary);

		if (count == 0) {
			return null;
		}

		List<LegacyAddress> list = findByC_C_C_P(companyId, classNameId,
				classPK, primary, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legacy addresses before and after the current legacy address in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	 *
	 * @param addressId the primary key of the current legacy address
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param primary the primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a legacy address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress[] findByC_C_C_P_PrevAndNext(long addressId,
		long companyId, long classNameId, long classPK, boolean primary,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			LegacyAddress[] array = new LegacyAddressImpl[3];

			array[0] = getByC_C_C_P_PrevAndNext(session, legacyAddress,
					companyId, classNameId, classPK, primary,
					orderByComparator, true);

			array[1] = legacyAddress;

			array[2] = getByC_C_C_P_PrevAndNext(session, legacyAddress,
					companyId, classNameId, classPK, primary,
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

	protected LegacyAddress getByC_C_C_P_PrevAndNext(Session session,
		LegacyAddress legacyAddress, long companyId, long classNameId,
		long classPK, boolean primary, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGACYADDRESS_WHERE);

		query.append(_FINDER_COLUMN_C_C_C_P_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_C_C_P_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_C_C_C_P_CLASSPK_2);

		query.append(_FINDER_COLUMN_C_C_C_P_PRIMARY_2);

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
			query.append(LegacyAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(classNameId);

		qPos.add(classPK);

		qPos.add(primary);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legacyAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegacyAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param primary the primary
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_C_P(long companyId, long classNameId, long classPK,
		boolean primary) throws SystemException {
		for (LegacyAddress legacyAddress : findByC_C_C_P(companyId,
				classNameId, classPK, primary, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(legacyAddress);
		}
	}

	/**
	 * Returns the number of legacy addresses where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param primary the primary
	 * @return the number of matching legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_C_P(long companyId, long classNameId, long classPK,
		boolean primary) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_C_P;

		Object[] finderArgs = new Object[] {
				companyId, classNameId, classPK, primary
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGACYADDRESS_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_P_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_P_CLASSPK_2);

			query.append(_FINDER_COLUMN_C_C_C_P_PRIMARY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(primary);

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

	private static final String _FINDER_COLUMN_C_C_C_P_COMPANYID_2 = "legacyAddress.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_P_CLASSNAMEID_2 = "legacyAddress.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_P_CLASSPK_2 = "legacyAddress.classPK = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_P_PRIMARY_2 = "legacyAddress.primary = ?";

	public LegacyAddressPersistenceImpl() {
		setModelClass(LegacyAddress.class);
	}

	/**
	 * Caches the legacy address in the entity cache if it is enabled.
	 *
	 * @param legacyAddress the legacy address
	 */
	@Override
	public void cacheResult(LegacyAddress legacyAddress) {
		EntityCacheUtil.putResult(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressImpl.class, legacyAddress.getPrimaryKey(),
			legacyAddress);

		legacyAddress.resetOriginalValues();
	}

	/**
	 * Caches the legacy addresses in the entity cache if it is enabled.
	 *
	 * @param legacyAddresses the legacy addresses
	 */
	@Override
	public void cacheResult(List<LegacyAddress> legacyAddresses) {
		for (LegacyAddress legacyAddress : legacyAddresses) {
			if (EntityCacheUtil.getResult(
						LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
						LegacyAddressImpl.class, legacyAddress.getPrimaryKey()) == null) {
				cacheResult(legacyAddress);
			}
			else {
				legacyAddress.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy addresses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyAddressImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyAddressImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy address.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyAddress legacyAddress) {
		EntityCacheUtil.removeResult(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressImpl.class, legacyAddress.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyAddress> legacyAddresses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyAddress legacyAddress : legacyAddresses) {
			EntityCacheUtil.removeResult(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
				LegacyAddressImpl.class, legacyAddress.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy address with the primary key. Does not add the legacy address to the database.
	 *
	 * @param addressId the primary key for the new legacy address
	 * @return the new legacy address
	 */
	@Override
	public LegacyAddress create(long addressId) {
		LegacyAddress legacyAddress = new LegacyAddressImpl();

		legacyAddress.setNew(true);
		legacyAddress.setPrimaryKey(addressId);

		return legacyAddress;
	}

	/**
	 * Removes the legacy address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the legacy address
	 * @return the legacy address that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a legacy address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress remove(long addressId)
		throws NoSuchLegacyAddressException, SystemException {
		return remove((Serializable)addressId);
	}

	/**
	 * Removes the legacy address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy address
	 * @return the legacy address that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a legacy address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress remove(Serializable primaryKey)
		throws NoSuchLegacyAddressException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyAddress legacyAddress = (LegacyAddress)session.get(LegacyAddressImpl.class,
					primaryKey);

			if (legacyAddress == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyAddressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyAddress);
		}
		catch (NoSuchLegacyAddressException nsee) {
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
	protected LegacyAddress removeImpl(LegacyAddress legacyAddress)
		throws SystemException {
		legacyAddress = toUnwrappedModel(legacyAddress);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyAddress)) {
				legacyAddress = (LegacyAddress)session.get(LegacyAddressImpl.class,
						legacyAddress.getPrimaryKeyObj());
			}

			if (legacyAddress != null) {
				session.delete(legacyAddress);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyAddress != null) {
			clearCache(legacyAddress);
		}

		return legacyAddress;
	}

	@Override
	public LegacyAddress updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyAddress legacyAddress)
		throws SystemException {
		legacyAddress = toUnwrappedModel(legacyAddress);

		boolean isNew = legacyAddress.isNew();

		LegacyAddressModelImpl legacyAddressModelImpl = (LegacyAddressModelImpl)legacyAddress;

		Session session = null;

		try {
			session = openSession();

			if (legacyAddress.isNew()) {
				session.save(legacyAddress);

				legacyAddress.setNew(false);
			}
			else {
				session.merge(legacyAddress);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LegacyAddressModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((legacyAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyAddressModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { legacyAddressModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((legacyAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyAddressModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { legacyAddressModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((legacyAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyAddressModelImpl.getOriginalCompanyId(),
						legacyAddressModelImpl.getOriginalClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C,
					args);

				args = new Object[] {
						legacyAddressModelImpl.getCompanyId(),
						legacyAddressModelImpl.getClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C,
					args);
			}

			if ((legacyAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyAddressModelImpl.getOriginalCompanyId(),
						legacyAddressModelImpl.getOriginalClassNameId(),
						legacyAddressModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C,
					args);

				args = new Object[] {
						legacyAddressModelImpl.getCompanyId(),
						legacyAddressModelImpl.getClassNameId(),
						legacyAddressModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C,
					args);
			}

			if ((legacyAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_M.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyAddressModelImpl.getOriginalCompanyId(),
						legacyAddressModelImpl.getOriginalClassNameId(),
						legacyAddressModelImpl.getOriginalClassPK(),
						legacyAddressModelImpl.getOriginalMailing()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C_M, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_M,
					args);

				args = new Object[] {
						legacyAddressModelImpl.getCompanyId(),
						legacyAddressModelImpl.getClassNameId(),
						legacyAddressModelImpl.getClassPK(),
						legacyAddressModelImpl.getMailing()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C_M, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_M,
					args);
			}

			if ((legacyAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyAddressModelImpl.getOriginalCompanyId(),
						legacyAddressModelImpl.getOriginalClassNameId(),
						legacyAddressModelImpl.getOriginalClassPK(),
						legacyAddressModelImpl.getOriginalPrimary()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P,
					args);

				args = new Object[] {
						legacyAddressModelImpl.getCompanyId(),
						legacyAddressModelImpl.getClassNameId(),
						legacyAddressModelImpl.getClassPK(),
						legacyAddressModelImpl.getPrimary()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_P,
					args);
			}
		}

		EntityCacheUtil.putResult(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
			LegacyAddressImpl.class, legacyAddress.getPrimaryKey(),
			legacyAddress);

		return legacyAddress;
	}

	protected LegacyAddress toUnwrappedModel(LegacyAddress legacyAddress) {
		if (legacyAddress instanceof LegacyAddressImpl) {
			return legacyAddress;
		}

		LegacyAddressImpl legacyAddressImpl = new LegacyAddressImpl();

		legacyAddressImpl.setNew(legacyAddress.isNew());
		legacyAddressImpl.setPrimaryKey(legacyAddress.getPrimaryKey());

		legacyAddressImpl.setAddressId(legacyAddress.getAddressId());
		legacyAddressImpl.setCompanyId(legacyAddress.getCompanyId());
		legacyAddressImpl.setUserId(legacyAddress.getUserId());
		legacyAddressImpl.setUserName(legacyAddress.getUserName());
		legacyAddressImpl.setCreateDate(legacyAddress.getCreateDate());
		legacyAddressImpl.setModifiedDate(legacyAddress.getModifiedDate());
		legacyAddressImpl.setClassNameId(legacyAddress.getClassNameId());
		legacyAddressImpl.setClassPK(legacyAddress.getClassPK());
		legacyAddressImpl.setStreet1(legacyAddress.getStreet1());
		legacyAddressImpl.setStreet2(legacyAddress.getStreet2());
		legacyAddressImpl.setStreet3(legacyAddress.getStreet3());
		legacyAddressImpl.setCity(legacyAddress.getCity());
		legacyAddressImpl.setZip(legacyAddress.getZip());
		legacyAddressImpl.setRegionId(legacyAddress.getRegionId());
		legacyAddressImpl.setCountryId(legacyAddress.getCountryId());
		legacyAddressImpl.setTypeId(legacyAddress.getTypeId());
		legacyAddressImpl.setMailing(legacyAddress.isMailing());
		legacyAddressImpl.setPrimary(legacyAddress.isPrimary());

		return legacyAddressImpl;
	}

	/**
	 * Returns the legacy address with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy address
	 * @return the legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a legacy address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyAddressException, SystemException {
		LegacyAddress legacyAddress = fetchByPrimaryKey(primaryKey);

		if (legacyAddress == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyAddressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyAddress;
	}

	/**
	 * Returns the legacy address with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException} if it could not be found.
	 *
	 * @param addressId the primary key of the legacy address
	 * @return the legacy address
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException if a legacy address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress findByPrimaryKey(long addressId)
		throws NoSuchLegacyAddressException, SystemException {
		return findByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns the legacy address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy address
	 * @return the legacy address, or <code>null</code> if a legacy address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyAddress legacyAddress = (LegacyAddress)EntityCacheUtil.getResult(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
				LegacyAddressImpl.class, primaryKey);

		if (legacyAddress == _nullLegacyAddress) {
			return null;
		}

		if (legacyAddress == null) {
			Session session = null;

			try {
				session = openSession();

				legacyAddress = (LegacyAddress)session.get(LegacyAddressImpl.class,
						primaryKey);

				if (legacyAddress != null) {
					cacheResult(legacyAddress);
				}
				else {
					EntityCacheUtil.putResult(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
						LegacyAddressImpl.class, primaryKey, _nullLegacyAddress);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyAddressModelImpl.ENTITY_CACHE_ENABLED,
					LegacyAddressImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyAddress;
	}

	/**
	 * Returns the legacy address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the legacy address
	 * @return the legacy address, or <code>null</code> if a legacy address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyAddress fetchByPrimaryKey(long addressId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns all the legacy addresses.
	 *
	 * @return the legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @return the range of legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy addresses
	 * @param end the upper bound of the range of legacy addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyAddress> findAll(int start, int end,
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

		List<LegacyAddress> list = (List<LegacyAddress>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYADDRESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYADDRESS;

				if (pagination) {
					sql = sql.concat(LegacyAddressModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyAddress>(list);
				}
				else {
					list = (List<LegacyAddress>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legacy addresses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyAddress legacyAddress : findAll()) {
			remove(legacyAddress);
		}
	}

	/**
	 * Returns the number of legacy addresses.
	 *
	 * @return the number of legacy addresses
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYADDRESS);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the legacy address persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyAddress")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyAddress>> listenersList = new ArrayList<ModelListener<LegacyAddress>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyAddress>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyAddressImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYADDRESS = "SELECT legacyAddress FROM LegacyAddress legacyAddress";
	private static final String _SQL_SELECT_LEGACYADDRESS_WHERE = "SELECT legacyAddress FROM LegacyAddress legacyAddress WHERE ";
	private static final String _SQL_COUNT_LEGACYADDRESS = "SELECT COUNT(legacyAddress) FROM LegacyAddress legacyAddress";
	private static final String _SQL_COUNT_LEGACYADDRESS_WHERE = "SELECT COUNT(legacyAddress) FROM LegacyAddress legacyAddress WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyAddress.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyAddress exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LegacyAddress exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyAddressPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"primary"
			});
	private static LegacyAddress _nullLegacyAddress = new LegacyAddressImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyAddress> toCacheModel() {
				return _nullLegacyAddressCacheModel;
			}
		};

	private static CacheModel<LegacyAddress> _nullLegacyAddressCacheModel = new CacheModel<LegacyAddress>() {
			@Override
			public LegacyAddress toEntityModel() {
				return _nullLegacyAddress;
			}
		};
}