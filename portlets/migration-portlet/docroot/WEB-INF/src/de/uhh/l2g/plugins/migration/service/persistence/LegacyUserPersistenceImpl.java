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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.migration.NoSuchLegacyUserException;
import de.uhh.l2g.plugins.migration.model.LegacyUser;
import de.uhh.l2g.plugins.migration.model.impl.LegacyUserImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyUserPersistence
 * @see LegacyUserUtil
 * @generated
 */
public class LegacyUserPersistenceImpl extends BasePersistenceImpl<LegacyUser>
	implements LegacyUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyUserUtil} to access the legacy user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			LegacyUserModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the legacy users where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyUser> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legacy users where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legacy users
	 * @param end the upper bound of the range of legacy users (not inclusive)
	 * @return the range of matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyUser> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy users where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legacy users
	 * @param end the upper bound of the range of legacy users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyUser> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<LegacyUser> list = (List<LegacyUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegacyUser legacyUser : list) {
				if ((companyId != legacyUser.getCompanyId())) {
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

			query.append(_SQL_SELECT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LegacyUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<LegacyUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyUser>(list);
				}
				else {
					list = (List<LegacyUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legacy user in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (legacyUser != null) {
			return legacyUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyUserException(msg.toString());
	}

	/**
	 * Returns the first legacy user in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegacyUser> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legacy user in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (legacyUser != null) {
			return legacyUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyUserException(msg.toString());
	}

	/**
	 * Returns the last legacy user in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<LegacyUser> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legacy users before and after the current legacy user in the ordered set where companyId = &#63;.
	 *
	 * @param userId the primary key of the current legacy user
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a legacy user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser[] findByCompanyId_PrevAndNext(long userId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			LegacyUser[] array = new LegacyUserImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, legacyUser,
					companyId, orderByComparator, true);

			array[1] = legacyUser;

			array[2] = getByCompanyId_PrevAndNext(session, legacyUser,
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

	protected LegacyUser getByCompanyId_PrevAndNext(Session session,
		LegacyUser legacyUser, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGACYUSER_WHERE);

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
			query.append(LegacyUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legacyUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegacyUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legacy users where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (LegacyUser legacyUser : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legacyUser);
		}
	}

	/**
	 * Returns the number of legacy users where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching legacy users
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

			query.append(_SQL_COUNT_LEGACYUSER_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "legacyUser.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CONTACTID = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByContactId",
			new String[] { Long.class.getName() },
			LegacyUserModelImpl.CONTACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTID = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContactId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the legacy user where contactId = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	 *
	 * @param contactId the contact ID
	 * @return the matching legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByContactId(long contactId)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = fetchByContactId(contactId);

		if (legacyUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("contactId=");
			msg.append(contactId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLegacyUserException(msg.toString());
		}

		return legacyUser;
	}

	/**
	 * Returns the legacy user where contactId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contactId the contact ID
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByContactId(long contactId)
		throws SystemException {
		return fetchByContactId(contactId, true);
	}

	/**
	 * Returns the legacy user where contactId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contactId the contact ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByContactId(long contactId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { contactId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CONTACTID,
					finderArgs, this);
		}

		if (result instanceof LegacyUser) {
			LegacyUser legacyUser = (LegacyUser)result;

			if ((contactId != legacyUser.getContactId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				List<LegacyUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LegacyUserPersistenceImpl.fetchByContactId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LegacyUser legacyUser = list.get(0);

					result = legacyUser;

					cacheResult(legacyUser);

					if ((legacyUser.getContactId() != contactId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTID,
							finderArgs, legacyUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTID,
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
			return (LegacyUser)result;
		}
	}

	/**
	 * Removes the legacy user where contactId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @return the legacy user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser removeByContactId(long contactId)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = findByContactId(contactId);

		return remove(legacyUser);
	}

	/**
	 * Returns the number of legacy users where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the number of matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContactId(long contactId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTID;

		Object[] finderArgs = new Object[] { contactId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

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

	private static final String _FINDER_COLUMN_CONTACTID_CONTACTID_2 = "legacyUser.contactId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESS =
		new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmailAddress",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS =
		new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmailAddress",
			new String[] { String.class.getName() },
			LegacyUserModelImpl.EMAILADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESS = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailAddress",
			new String[] { String.class.getName() });

	/**
	 * Returns all the legacy users where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyUser> findByEmailAddress(String emailAddress)
		throws SystemException {
		return findByEmailAddress(emailAddress, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy users where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of legacy users
	 * @param end the upper bound of the range of legacy users (not inclusive)
	 * @return the range of matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyUser> findByEmailAddress(String emailAddress, int start,
		int end) throws SystemException {
		return findByEmailAddress(emailAddress, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy users where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of legacy users
	 * @param end the upper bound of the range of legacy users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyUser> findByEmailAddress(String emailAddress, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS;
			finderArgs = new Object[] { emailAddress };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESS;
			finderArgs = new Object[] {
					emailAddress,
					
					start, end, orderByComparator
				};
		}

		List<LegacyUser> list = (List<LegacyUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegacyUser legacyUser : list) {
				if (!Validator.equals(emailAddress, legacyUser.getEmailAddress())) {
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

			query.append(_SQL_SELECT_LEGACYUSER_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LegacyUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				if (!pagination) {
					list = (List<LegacyUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyUser>(list);
				}
				else {
					list = (List<LegacyUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legacy user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByEmailAddress_First(String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = fetchByEmailAddress_First(emailAddress,
				orderByComparator);

		if (legacyUser != null) {
			return legacyUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyUserException(msg.toString());
	}

	/**
	 * Returns the first legacy user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByEmailAddress_First(String emailAddress,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegacyUser> list = findByEmailAddress(emailAddress, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legacy user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByEmailAddress_Last(String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = fetchByEmailAddress_Last(emailAddress,
				orderByComparator);

		if (legacyUser != null) {
			return legacyUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyUserException(msg.toString());
	}

	/**
	 * Returns the last legacy user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByEmailAddress_Last(String emailAddress,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmailAddress(emailAddress);

		if (count == 0) {
			return null;
		}

		List<LegacyUser> list = findByEmailAddress(emailAddress, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legacy users before and after the current legacy user in the ordered set where emailAddress = &#63;.
	 *
	 * @param userId the primary key of the current legacy user
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a legacy user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser[] findByEmailAddress_PrevAndNext(long userId,
		String emailAddress, OrderByComparator orderByComparator)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			LegacyUser[] array = new LegacyUserImpl[3];

			array[0] = getByEmailAddress_PrevAndNext(session, legacyUser,
					emailAddress, orderByComparator, true);

			array[1] = legacyUser;

			array[2] = getByEmailAddress_PrevAndNext(session, legacyUser,
					emailAddress, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegacyUser getByEmailAddress_PrevAndNext(Session session,
		LegacyUser legacyUser, String emailAddress,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGACYUSER_WHERE);

		boolean bindEmailAddress = false;

		if (emailAddress == null) {
			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
		}
		else if (emailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
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
			query.append(LegacyUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEmailAddress) {
			qPos.add(emailAddress);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legacyUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegacyUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legacy users where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmailAddress(String emailAddress)
		throws SystemException {
		for (LegacyUser legacyUser : findByEmailAddress(emailAddress,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legacyUser);
		}
	}

	/**
	 * Returns the number of legacy users where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmailAddress(String emailAddress)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESS;

		Object[] finderArgs = new Object[] { emailAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGACYUSER_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
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

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1 = "legacyUser.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2 = "legacyUser.emailAddress = ?";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 = "(legacyUser.emailAddress IS NULL OR legacyUser.emailAddress = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_OPENID = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByOpenId",
			new String[] { String.class.getName() },
			LegacyUserModelImpl.OPENID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPENID = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOpenId",
			new String[] { String.class.getName() });

	/**
	 * Returns the legacy user where openId = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	 *
	 * @param openId the open ID
	 * @return the matching legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByOpenId(String openId)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = fetchByOpenId(openId);

		if (legacyUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("openId=");
			msg.append(openId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLegacyUserException(msg.toString());
		}

		return legacyUser;
	}

	/**
	 * Returns the legacy user where openId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param openId the open ID
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByOpenId(String openId) throws SystemException {
		return fetchByOpenId(openId, true);
	}

	/**
	 * Returns the legacy user where openId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param openId the open ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByOpenId(String openId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { openId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_OPENID,
					finderArgs, this);
		}

		if (result instanceof LegacyUser) {
			LegacyUser legacyUser = (LegacyUser)result;

			if (!Validator.equals(openId, legacyUser.getOpenId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEGACYUSER_WHERE);

			boolean bindOpenId = false;

			if (openId == null) {
				query.append(_FINDER_COLUMN_OPENID_OPENID_1);
			}
			else if (openId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPENID_OPENID_3);
			}
			else {
				bindOpenId = true;

				query.append(_FINDER_COLUMN_OPENID_OPENID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOpenId) {
					qPos.add(openId);
				}

				List<LegacyUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPENID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LegacyUserPersistenceImpl.fetchByOpenId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LegacyUser legacyUser = list.get(0);

					result = legacyUser;

					cacheResult(legacyUser);

					if ((legacyUser.getOpenId() == null) ||
							!legacyUser.getOpenId().equals(openId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPENID,
							finderArgs, legacyUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OPENID,
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
			return (LegacyUser)result;
		}
	}

	/**
	 * Removes the legacy user where openId = &#63; from the database.
	 *
	 * @param openId the open ID
	 * @return the legacy user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser removeByOpenId(String openId)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = findByOpenId(openId);

		return remove(legacyUser);
	}

	/**
	 * Returns the number of legacy users where openId = &#63;.
	 *
	 * @param openId the open ID
	 * @return the number of matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOpenId(String openId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPENID;

		Object[] finderArgs = new Object[] { openId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGACYUSER_WHERE);

			boolean bindOpenId = false;

			if (openId == null) {
				query.append(_FINDER_COLUMN_OPENID_OPENID_1);
			}
			else if (openId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPENID_OPENID_3);
			}
			else {
				bindOpenId = true;

				query.append(_FINDER_COLUMN_OPENID_OPENID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOpenId) {
					qPos.add(openId);
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

	private static final String _FINDER_COLUMN_OPENID_OPENID_1 = "legacyUser.openId IS NULL";
	private static final String _FINDER_COLUMN_OPENID_OPENID_2 = "legacyUser.openId = ?";
	private static final String _FINDER_COLUMN_OPENID_OPENID_3 = "(legacyUser.openId IS NULL OR legacyUser.openId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PORTRAITID = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPortraitId",
			new String[] { Long.class.getName() },
			LegacyUserModelImpl.PORTRAITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORTRAITID = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPortraitId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the legacy user where portraitId = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	 *
	 * @param portraitId the portrait ID
	 * @return the matching legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByPortraitId(long portraitId)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = fetchByPortraitId(portraitId);

		if (legacyUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("portraitId=");
			msg.append(portraitId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLegacyUserException(msg.toString());
		}

		return legacyUser;
	}

	/**
	 * Returns the legacy user where portraitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param portraitId the portrait ID
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByPortraitId(long portraitId)
		throws SystemException {
		return fetchByPortraitId(portraitId, true);
	}

	/**
	 * Returns the legacy user where portraitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param portraitId the portrait ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByPortraitId(long portraitId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { portraitId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PORTRAITID,
					finderArgs, this);
		}

		if (result instanceof LegacyUser) {
			LegacyUser legacyUser = (LegacyUser)result;

			if ((portraitId != legacyUser.getPortraitId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_PORTRAITID_PORTRAITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(portraitId);

				List<LegacyUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTRAITID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LegacyUserPersistenceImpl.fetchByPortraitId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LegacyUser legacyUser = list.get(0);

					result = legacyUser;

					cacheResult(legacyUser);

					if ((legacyUser.getPortraitId() != portraitId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTRAITID,
							finderArgs, legacyUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORTRAITID,
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
			return (LegacyUser)result;
		}
	}

	/**
	 * Removes the legacy user where portraitId = &#63; from the database.
	 *
	 * @param portraitId the portrait ID
	 * @return the legacy user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser removeByPortraitId(long portraitId)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = findByPortraitId(portraitId);

		return remove(legacyUser);
	}

	/**
	 * Returns the number of legacy users where portraitId = &#63;.
	 *
	 * @param portraitId the portrait ID
	 * @return the number of matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPortraitId(long portraitId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PORTRAITID;

		Object[] finderArgs = new Object[] { portraitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_PORTRAITID_PORTRAITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(portraitId);

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

	private static final String _FINDER_COLUMN_PORTRAITID_PORTRAITID_2 = "legacyUser.portraitId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_U = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			LegacyUserModelImpl.COMPANYID_COLUMN_BITMASK |
			LegacyUserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_U = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the legacy user where companyId = &#63; and userId = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByC_U(long companyId, long userId)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = fetchByC_U(companyId, userId);

		if (legacyUser == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLegacyUserException(msg.toString());
		}

		return legacyUser;
	}

	/**
	 * Returns the legacy user where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByC_U(long companyId, long userId)
		throws SystemException {
		return fetchByC_U(companyId, userId, true);
	}

	/**
	 * Returns the legacy user where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByC_U(long companyId, long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_U,
					finderArgs, this);
		}

		if (result instanceof LegacyUser) {
			LegacyUser legacyUser = (LegacyUser)result;

			if ((companyId != legacyUser.getCompanyId()) ||
					(userId != legacyUser.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_C_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				List<LegacyUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_U,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LegacyUserPersistenceImpl.fetchByC_U(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LegacyUser legacyUser = list.get(0);

					result = legacyUser;

					cacheResult(legacyUser);

					if ((legacyUser.getCompanyId() != companyId) ||
							(legacyUser.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_U,
							finderArgs, legacyUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_U,
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
			return (LegacyUser)result;
		}
	}

	/**
	 * Removes the legacy user where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the legacy user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser removeByC_U(long companyId, long userId)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = findByC_U(companyId, userId);

		return remove(legacyUser);
	}

	/**
	 * Returns the number of legacy users where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_U(long companyId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_U;

		Object[] finderArgs = new Object[] { companyId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_C_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_C_U_COMPANYID_2 = "legacyUser.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_U_USERID_2 = "legacyUser.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_DU = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_DU",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			LegacyUserModelImpl.COMPANYID_COLUMN_BITMASK |
			LegacyUserModelImpl.DEFAULTUSER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_DU = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_DU",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns the legacy user where companyId = &#63; and defaultUser = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param defaultUser the default user
	 * @return the matching legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByC_DU(long companyId, boolean defaultUser)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = fetchByC_DU(companyId, defaultUser);

		if (legacyUser == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", defaultUser=");
			msg.append(defaultUser);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLegacyUserException(msg.toString());
		}

		return legacyUser;
	}

	/**
	 * Returns the legacy user where companyId = &#63; and defaultUser = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param defaultUser the default user
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByC_DU(long companyId, boolean defaultUser)
		throws SystemException {
		return fetchByC_DU(companyId, defaultUser, true);
	}

	/**
	 * Returns the legacy user where companyId = &#63; and defaultUser = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param defaultUser the default user
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByC_DU(long companyId, boolean defaultUser,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, defaultUser };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_DU,
					finderArgs, this);
		}

		if (result instanceof LegacyUser) {
			LegacyUser legacyUser = (LegacyUser)result;

			if ((companyId != legacyUser.getCompanyId()) ||
					(defaultUser != legacyUser.getDefaultUser())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_C_DU_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_DU_DEFAULTUSER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(defaultUser);

				List<LegacyUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_DU,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LegacyUserPersistenceImpl.fetchByC_DU(long, boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LegacyUser legacyUser = list.get(0);

					result = legacyUser;

					cacheResult(legacyUser);

					if ((legacyUser.getCompanyId() != companyId) ||
							(legacyUser.getDefaultUser() != defaultUser)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_DU,
							finderArgs, legacyUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_DU,
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
			return (LegacyUser)result;
		}
	}

	/**
	 * Removes the legacy user where companyId = &#63; and defaultUser = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param defaultUser the default user
	 * @return the legacy user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser removeByC_DU(long companyId, boolean defaultUser)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = findByC_DU(companyId, defaultUser);

		return remove(legacyUser);
	}

	/**
	 * Returns the number of legacy users where companyId = &#63; and defaultUser = &#63;.
	 *
	 * @param companyId the company ID
	 * @param defaultUser the default user
	 * @return the number of matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_DU(long companyId, boolean defaultUser)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_DU;

		Object[] finderArgs = new Object[] { companyId, defaultUser };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_C_DU_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_DU_DEFAULTUSER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(defaultUser);

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

	private static final String _FINDER_COLUMN_C_DU_COMPANYID_2 = "legacyUser.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_DU_DEFAULTUSER_2 = "legacyUser.defaultUser = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_SN = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_SN",
			new String[] { Long.class.getName(), String.class.getName() },
			LegacyUserModelImpl.COMPANYID_COLUMN_BITMASK |
			LegacyUserModelImpl.SCREENNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_SN = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_SN",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the legacy user where companyId = &#63; and screenName = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param screenName the screen name
	 * @return the matching legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByC_SN(long companyId, String screenName)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = fetchByC_SN(companyId, screenName);

		if (legacyUser == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", screenName=");
			msg.append(screenName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLegacyUserException(msg.toString());
		}

		return legacyUser;
	}

	/**
	 * Returns the legacy user where companyId = &#63; and screenName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param screenName the screen name
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByC_SN(long companyId, String screenName)
		throws SystemException {
		return fetchByC_SN(companyId, screenName, true);
	}

	/**
	 * Returns the legacy user where companyId = &#63; and screenName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param screenName the screen name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByC_SN(long companyId, String screenName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, screenName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_SN,
					finderArgs, this);
		}

		if (result instanceof LegacyUser) {
			LegacyUser legacyUser = (LegacyUser)result;

			if ((companyId != legacyUser.getCompanyId()) ||
					!Validator.equals(screenName, legacyUser.getScreenName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_C_SN_COMPANYID_2);

			boolean bindScreenName = false;

			if (screenName == null) {
				query.append(_FINDER_COLUMN_C_SN_SCREENNAME_1);
			}
			else if (screenName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_SN_SCREENNAME_3);
			}
			else {
				bindScreenName = true;

				query.append(_FINDER_COLUMN_C_SN_SCREENNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindScreenName) {
					qPos.add(screenName);
				}

				List<LegacyUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_SN,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LegacyUserPersistenceImpl.fetchByC_SN(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LegacyUser legacyUser = list.get(0);

					result = legacyUser;

					cacheResult(legacyUser);

					if ((legacyUser.getCompanyId() != companyId) ||
							(legacyUser.getScreenName() == null) ||
							!legacyUser.getScreenName().equals(screenName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_SN,
							finderArgs, legacyUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_SN,
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
			return (LegacyUser)result;
		}
	}

	/**
	 * Removes the legacy user where companyId = &#63; and screenName = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param screenName the screen name
	 * @return the legacy user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser removeByC_SN(long companyId, String screenName)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = findByC_SN(companyId, screenName);

		return remove(legacyUser);
	}

	/**
	 * Returns the number of legacy users where companyId = &#63; and screenName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param screenName the screen name
	 * @return the number of matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_SN(long companyId, String screenName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_SN;

		Object[] finderArgs = new Object[] { companyId, screenName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_C_SN_COMPANYID_2);

			boolean bindScreenName = false;

			if (screenName == null) {
				query.append(_FINDER_COLUMN_C_SN_SCREENNAME_1);
			}
			else if (screenName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_SN_SCREENNAME_3);
			}
			else {
				bindScreenName = true;

				query.append(_FINDER_COLUMN_C_SN_SCREENNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindScreenName) {
					qPos.add(screenName);
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

	private static final String _FINDER_COLUMN_C_SN_COMPANYID_2 = "legacyUser.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_SN_SCREENNAME_1 = "legacyUser.screenName IS NULL";
	private static final String _FINDER_COLUMN_C_SN_SCREENNAME_2 = "legacyUser.screenName = ?";
	private static final String _FINDER_COLUMN_C_SN_SCREENNAME_3 = "(legacyUser.screenName IS NULL OR legacyUser.screenName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_EA = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, LegacyUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_EA",
			new String[] { Long.class.getName(), String.class.getName() },
			LegacyUserModelImpl.COMPANYID_COLUMN_BITMASK |
			LegacyUserModelImpl.EMAILADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_EA = new FinderPath(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_EA",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the legacy user where companyId = &#63; and emailAddress = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param emailAddress the email address
	 * @return the matching legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByC_EA(long companyId, String emailAddress)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = fetchByC_EA(companyId, emailAddress);

		if (legacyUser == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", emailAddress=");
			msg.append(emailAddress);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLegacyUserException(msg.toString());
		}

		return legacyUser;
	}

	/**
	 * Returns the legacy user where companyId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param emailAddress the email address
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByC_EA(long companyId, String emailAddress)
		throws SystemException {
		return fetchByC_EA(companyId, emailAddress, true);
	}

	/**
	 * Returns the legacy user where companyId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param emailAddress the email address
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByC_EA(long companyId, String emailAddress,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, emailAddress };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_EA,
					finderArgs, this);
		}

		if (result instanceof LegacyUser) {
			LegacyUser legacyUser = (LegacyUser)result;

			if ((companyId != legacyUser.getCompanyId()) ||
					!Validator.equals(emailAddress, legacyUser.getEmailAddress())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_C_EA_COMPANYID_2);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_C_EA_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_EA_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_C_EA_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				List<LegacyUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_EA,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LegacyUserPersistenceImpl.fetchByC_EA(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LegacyUser legacyUser = list.get(0);

					result = legacyUser;

					cacheResult(legacyUser);

					if ((legacyUser.getCompanyId() != companyId) ||
							(legacyUser.getEmailAddress() == null) ||
							!legacyUser.getEmailAddress().equals(emailAddress)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_EA,
							finderArgs, legacyUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_EA,
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
			return (LegacyUser)result;
		}
	}

	/**
	 * Removes the legacy user where companyId = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param emailAddress the email address
	 * @return the legacy user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser removeByC_EA(long companyId, String emailAddress)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = findByC_EA(companyId, emailAddress);

		return remove(legacyUser);
	}

	/**
	 * Returns the number of legacy users where companyId = &#63; and emailAddress = &#63;.
	 *
	 * @param companyId the company ID
	 * @param emailAddress the email address
	 * @return the number of matching legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_EA(long companyId, String emailAddress)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_EA;

		Object[] finderArgs = new Object[] { companyId, emailAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGACYUSER_WHERE);

			query.append(_FINDER_COLUMN_C_EA_COMPANYID_2);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_C_EA_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_EA_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_C_EA_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
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

	private static final String _FINDER_COLUMN_C_EA_COMPANYID_2 = "legacyUser.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_EA_EMAILADDRESS_1 = "legacyUser.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_C_EA_EMAILADDRESS_2 = "legacyUser.emailAddress = ?";
	private static final String _FINDER_COLUMN_C_EA_EMAILADDRESS_3 = "(legacyUser.emailAddress IS NULL OR legacyUser.emailAddress = '')";

	public LegacyUserPersistenceImpl() {
		setModelClass(LegacyUser.class);
	}

	/**
	 * Caches the legacy user in the entity cache if it is enabled.
	 *
	 * @param legacyUser the legacy user
	 */
	@Override
	public void cacheResult(LegacyUser legacyUser) {
		EntityCacheUtil.putResult(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserImpl.class, legacyUser.getPrimaryKey(), legacyUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTID,
			new Object[] { legacyUser.getContactId() }, legacyUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPENID,
			new Object[] { legacyUser.getOpenId() }, legacyUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTRAITID,
			new Object[] { legacyUser.getPortraitId() }, legacyUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_U,
			new Object[] { legacyUser.getCompanyId(), legacyUser.getUserId() },
			legacyUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_DU,
			new Object[] { legacyUser.getCompanyId(), legacyUser.getDefaultUser() },
			legacyUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_SN,
			new Object[] { legacyUser.getCompanyId(), legacyUser.getScreenName() },
			legacyUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_EA,
			new Object[] { legacyUser.getCompanyId(), legacyUser.getEmailAddress() },
			legacyUser);

		legacyUser.resetOriginalValues();
	}

	/**
	 * Caches the legacy users in the entity cache if it is enabled.
	 *
	 * @param legacyUsers the legacy users
	 */
	@Override
	public void cacheResult(List<LegacyUser> legacyUsers) {
		for (LegacyUser legacyUser : legacyUsers) {
			if (EntityCacheUtil.getResult(
						LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
						LegacyUserImpl.class, legacyUser.getPrimaryKey()) == null) {
				cacheResult(legacyUser);
			}
			else {
				legacyUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyUser legacyUser) {
		EntityCacheUtil.removeResult(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserImpl.class, legacyUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(legacyUser);
	}

	@Override
	public void clearCache(List<LegacyUser> legacyUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyUser legacyUser : legacyUsers) {
			EntityCacheUtil.removeResult(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
				LegacyUserImpl.class, legacyUser.getPrimaryKey());

			clearUniqueFindersCache(legacyUser);
		}
	}

	protected void cacheUniqueFindersCache(LegacyUser legacyUser) {
		if (legacyUser.isNew()) {
			Object[] args = new Object[] { legacyUser.getContactId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTID, args,
				legacyUser);

			args = new Object[] { legacyUser.getOpenId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OPENID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPENID, args,
				legacyUser);

			args = new Object[] { legacyUser.getPortraitId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORTRAITID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTRAITID, args,
				legacyUser);

			args = new Object[] {
					legacyUser.getCompanyId(), legacyUser.getUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_U, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_U, args, legacyUser);

			args = new Object[] {
					legacyUser.getCompanyId(), legacyUser.getDefaultUser()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_DU, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_DU, args,
				legacyUser);

			args = new Object[] {
					legacyUser.getCompanyId(), legacyUser.getScreenName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_SN, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_SN, args,
				legacyUser);

			args = new Object[] {
					legacyUser.getCompanyId(), legacyUser.getEmailAddress()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_EA, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_EA, args,
				legacyUser);
		}
		else {
			LegacyUserModelImpl legacyUserModelImpl = (LegacyUserModelImpl)legacyUser;

			if ((legacyUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CONTACTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { legacyUser.getContactId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTID, args,
					legacyUser);
			}

			if ((legacyUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_OPENID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { legacyUser.getOpenId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OPENID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OPENID, args,
					legacyUser);
			}

			if ((legacyUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PORTRAITID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { legacyUser.getPortraitId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORTRAITID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTRAITID,
					args, legacyUser);
			}

			if ((legacyUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyUser.getCompanyId(), legacyUser.getUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_U, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_U, args,
					legacyUser);
			}

			if ((legacyUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_DU.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyUser.getCompanyId(), legacyUser.getDefaultUser()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_DU, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_DU, args,
					legacyUser);
			}

			if ((legacyUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_SN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyUser.getCompanyId(), legacyUser.getScreenName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_SN, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_SN, args,
					legacyUser);
			}

			if ((legacyUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_EA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyUser.getCompanyId(), legacyUser.getEmailAddress()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_EA, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_EA, args,
					legacyUser);
			}
		}
	}

	protected void clearUniqueFindersCache(LegacyUser legacyUser) {
		LegacyUserModelImpl legacyUserModelImpl = (LegacyUserModelImpl)legacyUser;

		Object[] args = new Object[] { legacyUser.getContactId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTID, args);

		if ((legacyUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CONTACTID.getColumnBitmask()) != 0) {
			args = new Object[] { legacyUserModelImpl.getOriginalContactId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTID, args);
		}

		args = new Object[] { legacyUser.getOpenId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPENID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OPENID, args);

		if ((legacyUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_OPENID.getColumnBitmask()) != 0) {
			args = new Object[] { legacyUserModelImpl.getOriginalOpenId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPENID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OPENID, args);
		}

		args = new Object[] { legacyUser.getPortraitId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTRAITID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORTRAITID, args);

		if ((legacyUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PORTRAITID.getColumnBitmask()) != 0) {
			args = new Object[] { legacyUserModelImpl.getOriginalPortraitId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTRAITID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORTRAITID, args);
		}

		args = new Object[] { legacyUser.getCompanyId(), legacyUser.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_U, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_U, args);

		if ((legacyUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_U.getColumnBitmask()) != 0) {
			args = new Object[] {
					legacyUserModelImpl.getOriginalCompanyId(),
					legacyUserModelImpl.getOriginalUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_U, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_U, args);
		}

		args = new Object[] {
				legacyUser.getCompanyId(), legacyUser.getDefaultUser()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_DU, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_DU, args);

		if ((legacyUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_DU.getColumnBitmask()) != 0) {
			args = new Object[] {
					legacyUserModelImpl.getOriginalCompanyId(),
					legacyUserModelImpl.getOriginalDefaultUser()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_DU, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_DU, args);
		}

		args = new Object[] {
				legacyUser.getCompanyId(), legacyUser.getScreenName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_SN, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_SN, args);

		if ((legacyUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_SN.getColumnBitmask()) != 0) {
			args = new Object[] {
					legacyUserModelImpl.getOriginalCompanyId(),
					legacyUserModelImpl.getOriginalScreenName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_SN, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_SN, args);
		}

		args = new Object[] {
				legacyUser.getCompanyId(), legacyUser.getEmailAddress()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_EA, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_EA, args);

		if ((legacyUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_EA.getColumnBitmask()) != 0) {
			args = new Object[] {
					legacyUserModelImpl.getOriginalCompanyId(),
					legacyUserModelImpl.getOriginalEmailAddress()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_EA, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_EA, args);
		}
	}

	/**
	 * Creates a new legacy user with the primary key. Does not add the legacy user to the database.
	 *
	 * @param userId the primary key for the new legacy user
	 * @return the new legacy user
	 */
	@Override
	public LegacyUser create(long userId) {
		LegacyUser legacyUser = new LegacyUserImpl();

		legacyUser.setNew(true);
		legacyUser.setPrimaryKey(userId);

		return legacyUser;
	}

	/**
	 * Removes the legacy user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the legacy user
	 * @return the legacy user that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a legacy user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser remove(long userId)
		throws NoSuchLegacyUserException, SystemException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the legacy user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy user
	 * @return the legacy user that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a legacy user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser remove(Serializable primaryKey)
		throws NoSuchLegacyUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyUser legacyUser = (LegacyUser)session.get(LegacyUserImpl.class,
					primaryKey);

			if (legacyUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyUser);
		}
		catch (NoSuchLegacyUserException nsee) {
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
	protected LegacyUser removeImpl(LegacyUser legacyUser)
		throws SystemException {
		legacyUser = toUnwrappedModel(legacyUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyUser)) {
				legacyUser = (LegacyUser)session.get(LegacyUserImpl.class,
						legacyUser.getPrimaryKeyObj());
			}

			if (legacyUser != null) {
				session.delete(legacyUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyUser != null) {
			clearCache(legacyUser);
		}

		return legacyUser;
	}

	@Override
	public LegacyUser updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyUser legacyUser)
		throws SystemException {
		legacyUser = toUnwrappedModel(legacyUser);

		boolean isNew = legacyUser.isNew();

		LegacyUserModelImpl legacyUserModelImpl = (LegacyUserModelImpl)legacyUser;

		Session session = null;

		try {
			session = openSession();

			if (legacyUser.isNew()) {
				session.save(legacyUser);

				legacyUser.setNew(false);
			}
			else {
				session.merge(legacyUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LegacyUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((legacyUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyUserModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { legacyUserModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((legacyUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyUserModelImpl.getOriginalEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS,
					args);

				args = new Object[] { legacyUserModelImpl.getEmailAddress() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS,
					args);
			}
		}

		EntityCacheUtil.putResult(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUserImpl.class, legacyUser.getPrimaryKey(), legacyUser);

		clearUniqueFindersCache(legacyUser);
		cacheUniqueFindersCache(legacyUser);

		return legacyUser;
	}

	protected LegacyUser toUnwrappedModel(LegacyUser legacyUser) {
		if (legacyUser instanceof LegacyUserImpl) {
			return legacyUser;
		}

		LegacyUserImpl legacyUserImpl = new LegacyUserImpl();

		legacyUserImpl.setNew(legacyUser.isNew());
		legacyUserImpl.setPrimaryKey(legacyUser.getPrimaryKey());

		legacyUserImpl.setUserId(legacyUser.getUserId());
		legacyUserImpl.setCompanyId(legacyUser.getCompanyId());
		legacyUserImpl.setCreateDate(legacyUser.getCreateDate());
		legacyUserImpl.setModifiedDate(legacyUser.getModifiedDate());
		legacyUserImpl.setDefaultUser(legacyUser.isDefaultUser());
		legacyUserImpl.setContactId(legacyUser.getContactId());
		legacyUserImpl.setPassword(legacyUser.getPassword());
		legacyUserImpl.setPasswordEncrypted(legacyUser.isPasswordEncrypted());
		legacyUserImpl.setPasswordReset(legacyUser.isPasswordReset());
		legacyUserImpl.setPasswordModifiedDate(legacyUser.getPasswordModifiedDate());
		legacyUserImpl.setReminderQueryQuestion(legacyUser.getReminderQueryQuestion());
		legacyUserImpl.setReminderQueryAnswer(legacyUser.getReminderQueryAnswer());
		legacyUserImpl.setGraceLoginCount(legacyUser.getGraceLoginCount());
		legacyUserImpl.setScreenName(legacyUser.getScreenName());
		legacyUserImpl.setEmailAddress(legacyUser.getEmailAddress());
		legacyUserImpl.setOpenId(legacyUser.getOpenId());
		legacyUserImpl.setPortraitId(legacyUser.getPortraitId());
		legacyUserImpl.setLanguageId(legacyUser.getLanguageId());
		legacyUserImpl.setTimeZoneId(legacyUser.getTimeZoneId());
		legacyUserImpl.setGreeting(legacyUser.getGreeting());
		legacyUserImpl.setComments(legacyUser.getComments());
		legacyUserImpl.setLoginDate(legacyUser.getLoginDate());
		legacyUserImpl.setLoginIP(legacyUser.getLoginIP());
		legacyUserImpl.setLastLoginDate(legacyUser.getLastLoginDate());
		legacyUserImpl.setLastLoginIP(legacyUser.getLastLoginIP());
		legacyUserImpl.setLastFailedLoginDate(legacyUser.getLastFailedLoginDate());
		legacyUserImpl.setFailedLoginAttempts(legacyUser.getFailedLoginAttempts());
		legacyUserImpl.setLockout(legacyUser.isLockout());
		legacyUserImpl.setLockoutDate(legacyUser.getLockoutDate());
		legacyUserImpl.setAgreedToTermsOfUse(legacyUser.isAgreedToTermsOfUse());
		legacyUserImpl.setActive(legacyUser.isActive());

		return legacyUserImpl;
	}

	/**
	 * Returns the legacy user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy user
	 * @return the legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a legacy user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyUserException, SystemException {
		LegacyUser legacyUser = fetchByPrimaryKey(primaryKey);

		if (legacyUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyUser;
	}

	/**
	 * Returns the legacy user with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	 *
	 * @param userId the primary key of the legacy user
	 * @return the legacy user
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a legacy user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser findByPrimaryKey(long userId)
		throws NoSuchLegacyUserException, SystemException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the legacy user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy user
	 * @return the legacy user, or <code>null</code> if a legacy user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyUser legacyUser = (LegacyUser)EntityCacheUtil.getResult(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
				LegacyUserImpl.class, primaryKey);

		if (legacyUser == _nullLegacyUser) {
			return null;
		}

		if (legacyUser == null) {
			Session session = null;

			try {
				session = openSession();

				legacyUser = (LegacyUser)session.get(LegacyUserImpl.class,
						primaryKey);

				if (legacyUser != null) {
					cacheResult(legacyUser);
				}
				else {
					EntityCacheUtil.putResult(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
						LegacyUserImpl.class, primaryKey, _nullLegacyUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyUserModelImpl.ENTITY_CACHE_ENABLED,
					LegacyUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyUser;
	}

	/**
	 * Returns the legacy user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the legacy user
	 * @return the legacy user, or <code>null</code> if a legacy user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUser fetchByPrimaryKey(long userId) throws SystemException {
		return fetchByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns all the legacy users.
	 *
	 * @return the legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy users
	 * @param end the upper bound of the range of legacy users (not inclusive)
	 * @return the range of legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy users
	 * @param end the upper bound of the range of legacy users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyUser> findAll(int start, int end,
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

		List<LegacyUser> list = (List<LegacyUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYUSER;

				if (pagination) {
					sql = sql.concat(LegacyUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyUser>(list);
				}
				else {
					list = (List<LegacyUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legacy users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyUser legacyUser : findAll()) {
			remove(legacyUser);
		}
	}

	/**
	 * Returns the number of legacy users.
	 *
	 * @return the number of legacy users
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYUSER);

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
	 * Initializes the legacy user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyUser>> listenersList = new ArrayList<ModelListener<LegacyUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYUSER = "SELECT legacyUser FROM LegacyUser legacyUser";
	private static final String _SQL_SELECT_LEGACYUSER_WHERE = "SELECT legacyUser FROM LegacyUser legacyUser WHERE ";
	private static final String _SQL_COUNT_LEGACYUSER = "SELECT COUNT(legacyUser) FROM LegacyUser legacyUser";
	private static final String _SQL_COUNT_LEGACYUSER_WHERE = "SELECT COUNT(legacyUser) FROM LegacyUser legacyUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LegacyUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyUserPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"password", "active"
			});
	private static LegacyUser _nullLegacyUser = new LegacyUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyUser> toCacheModel() {
				return _nullLegacyUserCacheModel;
			}
		};

	private static CacheModel<LegacyUser> _nullLegacyUserCacheModel = new CacheModel<LegacyUser>() {
			@Override
			public LegacyUser toEntityModel() {
				return _nullLegacyUser;
			}
		};
}