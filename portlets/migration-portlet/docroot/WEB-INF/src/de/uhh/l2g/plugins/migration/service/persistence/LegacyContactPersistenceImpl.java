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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.migration.NoSuchLegacyContactException;
import de.uhh.l2g.plugins.migration.model.LegacyContact;
import de.uhh.l2g.plugins.migration.model.impl.LegacyContactImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyContactModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legacy contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyContactPersistence
 * @see LegacyContactUtil
 * @generated
 */
public class LegacyContactPersistenceImpl extends BasePersistenceImpl<LegacyContact>
	implements LegacyContactPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyContactUtil} to access the legacy contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyContactImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
			LegacyContactModelImpl.FINDER_CACHE_ENABLED,
			LegacyContactImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
			LegacyContactModelImpl.FINDER_CACHE_ENABLED,
			LegacyContactImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
			LegacyContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
			LegacyContactModelImpl.FINDER_CACHE_ENABLED,
			LegacyContactImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
			LegacyContactModelImpl.FINDER_CACHE_ENABLED,
			LegacyContactImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyId", new String[] { Long.class.getName() },
			LegacyContactModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
			LegacyContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the legacy contacts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching legacy contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyContact> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legacy contacts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legacy contacts
	 * @param end the upper bound of the range of legacy contacts (not inclusive)
	 * @return the range of matching legacy contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyContact> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy contacts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legacy contacts
	 * @param end the upper bound of the range of legacy contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legacy contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyContact> findByCompanyId(long companyId, int start,
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

		List<LegacyContact> list = (List<LegacyContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegacyContact legacyContact : list) {
				if ((companyId != legacyContact.getCompanyId())) {
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

			query.append(_SQL_SELECT_LEGACYCONTACT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LegacyContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<LegacyContact>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyContact>(list);
				}
				else {
					list = (List<LegacyContact>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legacy contact in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy contact
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyContactException if a matching legacy contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyContactException, SystemException {
		LegacyContact legacyContact = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (legacyContact != null) {
			return legacyContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyContactException(msg.toString());
	}

	/**
	 * Returns the first legacy contact in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy contact, or <code>null</code> if a matching legacy contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegacyContact> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legacy contact in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy contact
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyContactException if a matching legacy contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyContactException, SystemException {
		LegacyContact legacyContact = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (legacyContact != null) {
			return legacyContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyContactException(msg.toString());
	}

	/**
	 * Returns the last legacy contact in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy contact, or <code>null</code> if a matching legacy contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<LegacyContact> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legacy contacts before and after the current legacy contact in the ordered set where companyId = &#63;.
	 *
	 * @param contactId the primary key of the current legacy contact
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legacy contact
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyContactException if a legacy contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact[] findByCompanyId_PrevAndNext(long contactId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchLegacyContactException, SystemException {
		LegacyContact legacyContact = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			LegacyContact[] array = new LegacyContactImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, legacyContact,
					companyId, orderByComparator, true);

			array[1] = legacyContact;

			array[2] = getByCompanyId_PrevAndNext(session, legacyContact,
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

	protected LegacyContact getByCompanyId_PrevAndNext(Session session,
		LegacyContact legacyContact, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGACYCONTACT_WHERE);

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
			query.append(LegacyContactModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legacyContact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegacyContact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legacy contacts where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (LegacyContact legacyContact : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legacyContact);
		}
	}

	/**
	 * Returns the number of legacy contacts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching legacy contacts
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

			query.append(_SQL_COUNT_LEGACYCONTACT_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "legacyContact.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
			LegacyContactModelImpl.FINDER_CACHE_ENABLED,
			LegacyContactImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
			LegacyContactModelImpl.FINDER_CACHE_ENABLED,
			LegacyContactImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserId", new String[] { Long.class.getName() },
			LegacyContactModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
			LegacyContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the legacy contacts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching legacy contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyContact> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy contacts where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of legacy contacts
	 * @param end the upper bound of the range of legacy contacts (not inclusive)
	 * @return the range of matching legacy contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyContact> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy contacts where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of legacy contacts
	 * @param end the upper bound of the range of legacy contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legacy contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyContact> findByUserId(long userId, int start, int end,
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

		List<LegacyContact> list = (List<LegacyContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LegacyContact legacyContact : list) {
				if ((userId != legacyContact.getUserId())) {
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

			query.append(_SQL_SELECT_LEGACYCONTACT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LegacyContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<LegacyContact>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyContact>(list);
				}
				else {
					list = (List<LegacyContact>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legacy contact in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy contact
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyContactException if a matching legacy contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyContactException, SystemException {
		LegacyContact legacyContact = fetchByUserId_First(userId,
				orderByComparator);

		if (legacyContact != null) {
			return legacyContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyContactException(msg.toString());
	}

	/**
	 * Returns the first legacy contact in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacy contact, or <code>null</code> if a matching legacy contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LegacyContact> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legacy contact in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy contact
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyContactException if a matching legacy contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLegacyContactException, SystemException {
		LegacyContact legacyContact = fetchByUserId_Last(userId,
				orderByComparator);

		if (legacyContact != null) {
			return legacyContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacyContactException(msg.toString());
	}

	/**
	 * Returns the last legacy contact in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacy contact, or <code>null</code> if a matching legacy contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<LegacyContact> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legacy contacts before and after the current legacy contact in the ordered set where userId = &#63;.
	 *
	 * @param contactId the primary key of the current legacy contact
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legacy contact
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyContactException if a legacy contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact[] findByUserId_PrevAndNext(long contactId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchLegacyContactException, SystemException {
		LegacyContact legacyContact = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			LegacyContact[] array = new LegacyContactImpl[3];

			array[0] = getByUserId_PrevAndNext(session, legacyContact, userId,
					orderByComparator, true);

			array[1] = legacyContact;

			array[2] = getByUserId_PrevAndNext(session, legacyContact, userId,
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

	protected LegacyContact getByUserId_PrevAndNext(Session session,
		LegacyContact legacyContact, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGACYCONTACT_WHERE);

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
			query.append(LegacyContactModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legacyContact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LegacyContact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legacy contacts where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (LegacyContact legacyContact : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(legacyContact);
		}
	}

	/**
	 * Returns the number of legacy contacts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching legacy contacts
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

			query.append(_SQL_COUNT_LEGACYCONTACT_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "legacyContact.userId = ?";

	public LegacyContactPersistenceImpl() {
		setModelClass(LegacyContact.class);
	}

	/**
	 * Caches the legacy contact in the entity cache if it is enabled.
	 *
	 * @param legacyContact the legacy contact
	 */
	@Override
	public void cacheResult(LegacyContact legacyContact) {
		EntityCacheUtil.putResult(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
			LegacyContactImpl.class, legacyContact.getPrimaryKey(),
			legacyContact);

		legacyContact.resetOriginalValues();
	}

	/**
	 * Caches the legacy contacts in the entity cache if it is enabled.
	 *
	 * @param legacyContacts the legacy contacts
	 */
	@Override
	public void cacheResult(List<LegacyContact> legacyContacts) {
		for (LegacyContact legacyContact : legacyContacts) {
			if (EntityCacheUtil.getResult(
						LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
						LegacyContactImpl.class, legacyContact.getPrimaryKey()) == null) {
				cacheResult(legacyContact);
			}
			else {
				legacyContact.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy contacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyContactImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyContactImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy contact.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyContact legacyContact) {
		EntityCacheUtil.removeResult(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
			LegacyContactImpl.class, legacyContact.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyContact> legacyContacts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyContact legacyContact : legacyContacts) {
			EntityCacheUtil.removeResult(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
				LegacyContactImpl.class, legacyContact.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy contact with the primary key. Does not add the legacy contact to the database.
	 *
	 * @param contactId the primary key for the new legacy contact
	 * @return the new legacy contact
	 */
	@Override
	public LegacyContact create(long contactId) {
		LegacyContact legacyContact = new LegacyContactImpl();

		legacyContact.setNew(true);
		legacyContact.setPrimaryKey(contactId);

		return legacyContact;
	}

	/**
	 * Removes the legacy contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactId the primary key of the legacy contact
	 * @return the legacy contact that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyContactException if a legacy contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact remove(long contactId)
		throws NoSuchLegacyContactException, SystemException {
		return remove((Serializable)contactId);
	}

	/**
	 * Removes the legacy contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy contact
	 * @return the legacy contact that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyContactException if a legacy contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact remove(Serializable primaryKey)
		throws NoSuchLegacyContactException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyContact legacyContact = (LegacyContact)session.get(LegacyContactImpl.class,
					primaryKey);

			if (legacyContact == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyContact);
		}
		catch (NoSuchLegacyContactException nsee) {
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
	protected LegacyContact removeImpl(LegacyContact legacyContact)
		throws SystemException {
		legacyContact = toUnwrappedModel(legacyContact);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyContact)) {
				legacyContact = (LegacyContact)session.get(LegacyContactImpl.class,
						legacyContact.getPrimaryKeyObj());
			}

			if (legacyContact != null) {
				session.delete(legacyContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyContact != null) {
			clearCache(legacyContact);
		}

		return legacyContact;
	}

	@Override
	public LegacyContact updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyContact legacyContact)
		throws SystemException {
		legacyContact = toUnwrappedModel(legacyContact);

		boolean isNew = legacyContact.isNew();

		LegacyContactModelImpl legacyContactModelImpl = (LegacyContactModelImpl)legacyContact;

		Session session = null;

		try {
			session = openSession();

			if (legacyContact.isNew()) {
				session.save(legacyContact);

				legacyContact.setNew(false);
			}
			else {
				session.merge(legacyContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LegacyContactModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((legacyContactModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyContactModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { legacyContactModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((legacyContactModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyContactModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { legacyContactModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
			LegacyContactImpl.class, legacyContact.getPrimaryKey(),
			legacyContact);

		return legacyContact;
	}

	protected LegacyContact toUnwrappedModel(LegacyContact legacyContact) {
		if (legacyContact instanceof LegacyContactImpl) {
			return legacyContact;
		}

		LegacyContactImpl legacyContactImpl = new LegacyContactImpl();

		legacyContactImpl.setNew(legacyContact.isNew());
		legacyContactImpl.setPrimaryKey(legacyContact.getPrimaryKey());

		legacyContactImpl.setContactId(legacyContact.getContactId());
		legacyContactImpl.setCompanyId(legacyContact.getCompanyId());
		legacyContactImpl.setUserId(legacyContact.getUserId());
		legacyContactImpl.setUserName(legacyContact.getUserName());
		legacyContactImpl.setCreateDate(legacyContact.getCreateDate());
		legacyContactImpl.setModifiedDate(legacyContact.getModifiedDate());
		legacyContactImpl.setAccountId(legacyContact.getAccountId());
		legacyContactImpl.setParentContactId(legacyContact.getParentContactId());
		legacyContactImpl.setFirstName(legacyContact.getFirstName());
		legacyContactImpl.setMiddleName(legacyContact.getMiddleName());
		legacyContactImpl.setLastName(legacyContact.getLastName());
		legacyContactImpl.setPrefixId(legacyContact.getPrefixId());
		legacyContactImpl.setSuffixId(legacyContact.getSuffixId());
		legacyContactImpl.setMale(legacyContact.isMale());
		legacyContactImpl.setBirthday(legacyContact.getBirthday());
		legacyContactImpl.setSmsSn(legacyContact.getSmsSn());
		legacyContactImpl.setAimSn(legacyContact.getAimSn());
		legacyContactImpl.setFacebookSn(legacyContact.getFacebookSn());
		legacyContactImpl.setIcqSn(legacyContact.getIcqSn());
		legacyContactImpl.setJabberSn(legacyContact.getJabberSn());
		legacyContactImpl.setMsnSn(legacyContact.getMsnSn());
		legacyContactImpl.setMySpaceSn(legacyContact.getMySpaceSn());
		legacyContactImpl.setSkypeSn(legacyContact.getSkypeSn());
		legacyContactImpl.setTwitterSn(legacyContact.getTwitterSn());
		legacyContactImpl.setYmSn(legacyContact.getYmSn());
		legacyContactImpl.setEmployeeStatusId(legacyContact.getEmployeeStatusId());
		legacyContactImpl.setEmployeeNumber(legacyContact.getEmployeeNumber());
		legacyContactImpl.setJobTitle(legacyContact.getJobTitle());
		legacyContactImpl.setJobClass(legacyContact.getJobClass());
		legacyContactImpl.setHoursOfOperation(legacyContact.getHoursOfOperation());

		return legacyContactImpl;
	}

	/**
	 * Returns the legacy contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy contact
	 * @return the legacy contact
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyContactException if a legacy contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyContactException, SystemException {
		LegacyContact legacyContact = fetchByPrimaryKey(primaryKey);

		if (legacyContact == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyContact;
	}

	/**
	 * Returns the legacy contact with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyContactException} if it could not be found.
	 *
	 * @param contactId the primary key of the legacy contact
	 * @return the legacy contact
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyContactException if a legacy contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact findByPrimaryKey(long contactId)
		throws NoSuchLegacyContactException, SystemException {
		return findByPrimaryKey((Serializable)contactId);
	}

	/**
	 * Returns the legacy contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy contact
	 * @return the legacy contact, or <code>null</code> if a legacy contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyContact legacyContact = (LegacyContact)EntityCacheUtil.getResult(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
				LegacyContactImpl.class, primaryKey);

		if (legacyContact == _nullLegacyContact) {
			return null;
		}

		if (legacyContact == null) {
			Session session = null;

			try {
				session = openSession();

				legacyContact = (LegacyContact)session.get(LegacyContactImpl.class,
						primaryKey);

				if (legacyContact != null) {
					cacheResult(legacyContact);
				}
				else {
					EntityCacheUtil.putResult(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
						LegacyContactImpl.class, primaryKey, _nullLegacyContact);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyContactModelImpl.ENTITY_CACHE_ENABLED,
					LegacyContactImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyContact;
	}

	/**
	 * Returns the legacy contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactId the primary key of the legacy contact
	 * @return the legacy contact, or <code>null</code> if a legacy contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyContact fetchByPrimaryKey(long contactId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)contactId);
	}

	/**
	 * Returns all the legacy contacts.
	 *
	 * @return the legacy contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyContact> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy contacts
	 * @param end the upper bound of the range of legacy contacts (not inclusive)
	 * @return the range of legacy contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyContact> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy contacts
	 * @param end the upper bound of the range of legacy contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyContact> findAll(int start, int end,
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

		List<LegacyContact> list = (List<LegacyContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYCONTACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYCONTACT;

				if (pagination) {
					sql = sql.concat(LegacyContactModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyContact>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyContact>(list);
				}
				else {
					list = (List<LegacyContact>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legacy contacts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyContact legacyContact : findAll()) {
			remove(legacyContact);
		}
	}

	/**
	 * Returns the number of legacy contacts.
	 *
	 * @return the number of legacy contacts
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYCONTACT);

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
	 * Initializes the legacy contact persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyContact")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyContact>> listenersList = new ArrayList<ModelListener<LegacyContact>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyContact>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyContactImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYCONTACT = "SELECT legacyContact FROM LegacyContact legacyContact";
	private static final String _SQL_SELECT_LEGACYCONTACT_WHERE = "SELECT legacyContact FROM LegacyContact legacyContact WHERE ";
	private static final String _SQL_COUNT_LEGACYCONTACT = "SELECT COUNT(legacyContact) FROM LegacyContact legacyContact";
	private static final String _SQL_COUNT_LEGACYCONTACT_WHERE = "SELECT COUNT(legacyContact) FROM LegacyContact legacyContact WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyContact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyContact exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LegacyContact exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyContactPersistenceImpl.class);
	private static LegacyContact _nullLegacyContact = new LegacyContactImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyContact> toCacheModel() {
				return _nullLegacyContactCacheModel;
			}
		};

	private static CacheModel<LegacyContact> _nullLegacyContactCacheModel = new CacheModel<LegacyContact>() {
			@Override
			public LegacyContact toEntityModel() {
				return _nullLegacyContact;
			}
		};
}