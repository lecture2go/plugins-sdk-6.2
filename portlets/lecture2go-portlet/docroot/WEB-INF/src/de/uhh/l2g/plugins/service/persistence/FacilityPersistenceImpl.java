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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchFacilityException;
import de.uhh.l2g.plugins.model.Facility;
import de.uhh.l2g.plugins.model.impl.FacilityImpl;
import de.uhh.l2g.plugins.model.impl.FacilityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see FacilityPersistence
 * @see FacilityUtil
 * @generated
 */
public class FacilityPersistenceImpl extends BasePersistenceImpl<Facility>
	implements FacilityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FacilityUtil} to access the facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FacilityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParent",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT =
		new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParent",
			new String[] { Long.class.getName() },
			FacilityModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENT = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParent",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the facilities where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findByParent(long parentId) throws SystemException {
		return findByParent(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the facilities where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @return the range of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findByParent(long parentId, int start, int end)
		throws SystemException {
		return findByParent(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the facilities where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findByParent(long parentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT;
			finderArgs = new Object[] { parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT;
			finderArgs = new Object[] { parentId, start, end, orderByComparator };
		}

		List<Facility> list = (List<Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Facility facility : list) {
				if ((parentId != facility.getParentId())) {
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

			query.append(_SQL_SELECT_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FacilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Facility>(list);
				}
				else {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first facility in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findByParent_First(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchByParent_First(parentId, orderByComparator);

		if (facility != null) {
			return facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFacilityException(msg.toString());
	}

	/**
	 * Returns the first facility in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching facility, or <code>null</code> if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchByParent_First(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Facility> list = findByParent(parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last facility in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findByParent_Last(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchByParent_Last(parentId, orderByComparator);

		if (facility != null) {
			return facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFacilityException(msg.toString());
	}

	/**
	 * Returns the last facility in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching facility, or <code>null</code> if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchByParent_Last(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParent(parentId);

		if (count == 0) {
			return null;
		}

		List<Facility> list = findByParent(parentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the facilities before and after the current facility in the ordered set where parentId = &#63;.
	 *
	 * @param facilityId the primary key of the current facility
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility[] findByParent_PrevAndNext(long facilityId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = findByPrimaryKey(facilityId);

		Session session = null;

		try {
			session = openSession();

			Facility[] array = new FacilityImpl[3];

			array[0] = getByParent_PrevAndNext(session, facility, parentId,
					orderByComparator, true);

			array[1] = facility;

			array[2] = getByParent_PrevAndNext(session, facility, parentId,
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

	protected Facility getByParent_PrevAndNext(Session session,
		Facility facility, long parentId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACILITY_WHERE);

		query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

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
			query.append(FacilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(facility);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Facility> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the facilities where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParent(long parentId) throws SystemException {
		for (Facility facility : findByParent(parentId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(facility);
		}
	}

	/**
	 * Returns the number of facilities where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParent(long parentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENT;

		Object[] finderArgs = new Object[] { parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_PARENT_PARENTID_2 = "facility.parentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			FacilityModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the facilities where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the facilities where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @return the range of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the facilities where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Facility> list = (List<Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Facility facility : list) {
				if (!Validator.equals(name, facility.getName())) {
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

			query.append(_SQL_SELECT_FACILITY_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FacilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Facility>(list);
				}
				else {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first facility in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchByName_First(name, orderByComparator);

		if (facility != null) {
			return facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFacilityException(msg.toString());
	}

	/**
	 * Returns the first facility in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching facility, or <code>null</code> if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<Facility> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last facility in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchByName_Last(name, orderByComparator);

		if (facility != null) {
			return facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFacilityException(msg.toString());
	}

	/**
	 * Returns the last facility in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching facility, or <code>null</code> if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Facility> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the facilities before and after the current facility in the ordered set where name = &#63;.
	 *
	 * @param facilityId the primary key of the current facility
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility[] findByName_PrevAndNext(long facilityId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = findByPrimaryKey(facilityId);

		Session session = null;

		try {
			session = openSession();

			Facility[] array = new FacilityImpl[3];

			array[0] = getByName_PrevAndNext(session, facility, name,
					orderByComparator, true);

			array[1] = facility;

			array[2] = getByName_PrevAndNext(session, facility, name,
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

	protected Facility getByName_PrevAndNext(Session session,
		Facility facility, String name, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACILITY_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
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
			query.append(FacilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(facility);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Facility> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the facilities where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (Facility facility : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(facility);
		}
	}

	/**
	 * Returns the number of facilities where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACILITY_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "facility.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "facility.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(facility.name IS NULL OR facility.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYP = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTyp",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTyp",
			new String[] { String.class.getName() },
			FacilityModelImpl.TYP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYP = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTyp",
			new String[] { String.class.getName() });

	/**
	 * Returns all the facilities where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findByTyp(String typ) throws SystemException {
		return findByTyp(typ, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the facilities where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @return the range of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findByTyp(String typ, int start, int end)
		throws SystemException {
		return findByTyp(typ, start, end, null);
	}

	/**
	 * Returns an ordered range of all the facilities where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findByTyp(String typ, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP;
			finderArgs = new Object[] { typ };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYP;
			finderArgs = new Object[] { typ, start, end, orderByComparator };
		}

		List<Facility> list = (List<Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Facility facility : list) {
				if (!Validator.equals(typ, facility.getTyp())) {
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

			query.append(_SQL_SELECT_FACILITY_WHERE);

			boolean bindTyp = false;

			if (typ == null) {
				query.append(_FINDER_COLUMN_TYP_TYP_1);
			}
			else if (typ.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYP_TYP_3);
			}
			else {
				bindTyp = true;

				query.append(_FINDER_COLUMN_TYP_TYP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FacilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTyp) {
					qPos.add(typ);
				}

				if (!pagination) {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Facility>(list);
				}
				else {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first facility in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findByTyp_First(String typ,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchByTyp_First(typ, orderByComparator);

		if (facility != null) {
			return facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typ=");
		msg.append(typ);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFacilityException(msg.toString());
	}

	/**
	 * Returns the first facility in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching facility, or <code>null</code> if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchByTyp_First(String typ,
		OrderByComparator orderByComparator) throws SystemException {
		List<Facility> list = findByTyp(typ, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last facility in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findByTyp_Last(String typ,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchByTyp_Last(typ, orderByComparator);

		if (facility != null) {
			return facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typ=");
		msg.append(typ);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFacilityException(msg.toString());
	}

	/**
	 * Returns the last facility in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching facility, or <code>null</code> if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchByTyp_Last(String typ,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTyp(typ);

		if (count == 0) {
			return null;
		}

		List<Facility> list = findByTyp(typ, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the facilities before and after the current facility in the ordered set where typ = &#63;.
	 *
	 * @param facilityId the primary key of the current facility
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility[] findByTyp_PrevAndNext(long facilityId, String typ,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = findByPrimaryKey(facilityId);

		Session session = null;

		try {
			session = openSession();

			Facility[] array = new FacilityImpl[3];

			array[0] = getByTyp_PrevAndNext(session, facility, typ,
					orderByComparator, true);

			array[1] = facility;

			array[2] = getByTyp_PrevAndNext(session, facility, typ,
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

	protected Facility getByTyp_PrevAndNext(Session session, Facility facility,
		String typ, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACILITY_WHERE);

		boolean bindTyp = false;

		if (typ == null) {
			query.append(_FINDER_COLUMN_TYP_TYP_1);
		}
		else if (typ.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYP_TYP_3);
		}
		else {
			bindTyp = true;

			query.append(_FINDER_COLUMN_TYP_TYP_2);
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
			query.append(FacilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTyp) {
			qPos.add(typ);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(facility);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Facility> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the facilities where typ = &#63; from the database.
	 *
	 * @param typ the typ
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTyp(String typ) throws SystemException {
		for (Facility facility : findByTyp(typ, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(facility);
		}
	}

	/**
	 * Returns the number of facilities where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the number of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTyp(String typ) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYP;

		Object[] finderArgs = new Object[] { typ };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACILITY_WHERE);

			boolean bindTyp = false;

			if (typ == null) {
				query.append(_FINDER_COLUMN_TYP_TYP_1);
			}
			else if (typ.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYP_TYP_3);
			}
			else {
				bindTyp = true;

				query.append(_FINDER_COLUMN_TYP_TYP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTyp) {
					qPos.add(typ);
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

	private static final String _FINDER_COLUMN_TYP_TYP_1 = "facility.typ IS NULL";
	private static final String _FINDER_COLUMN_TYP_TYP_2 = "facility.typ = ?";
	private static final String _FINDER_COLUMN_TYP_TYP_3 = "(facility.typ IS NULL OR facility.typ = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WWW = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWww",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WWW = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWww",
			new String[] { String.class.getName() },
			FacilityModelImpl.WWW_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WWW = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWww",
			new String[] { String.class.getName() });

	/**
	 * Returns all the facilities where www = &#63;.
	 *
	 * @param www the www
	 * @return the matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findByWww(String www) throws SystemException {
		return findByWww(www, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the facilities where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @return the range of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findByWww(String www, int start, int end)
		throws SystemException {
		return findByWww(www, start, end, null);
	}

	/**
	 * Returns an ordered range of all the facilities where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findByWww(String www, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WWW;
			finderArgs = new Object[] { www };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WWW;
			finderArgs = new Object[] { www, start, end, orderByComparator };
		}

		List<Facility> list = (List<Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Facility facility : list) {
				if (!Validator.equals(www, facility.getWww())) {
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

			query.append(_SQL_SELECT_FACILITY_WHERE);

			boolean bindWww = false;

			if (www == null) {
				query.append(_FINDER_COLUMN_WWW_WWW_1);
			}
			else if (www.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WWW_WWW_3);
			}
			else {
				bindWww = true;

				query.append(_FINDER_COLUMN_WWW_WWW_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FacilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWww) {
					qPos.add(www);
				}

				if (!pagination) {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Facility>(list);
				}
				else {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first facility in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findByWww_First(String www,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchByWww_First(www, orderByComparator);

		if (facility != null) {
			return facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("www=");
		msg.append(www);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFacilityException(msg.toString());
	}

	/**
	 * Returns the first facility in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching facility, or <code>null</code> if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchByWww_First(String www,
		OrderByComparator orderByComparator) throws SystemException {
		List<Facility> list = findByWww(www, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last facility in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findByWww_Last(String www,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchByWww_Last(www, orderByComparator);

		if (facility != null) {
			return facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("www=");
		msg.append(www);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFacilityException(msg.toString());
	}

	/**
	 * Returns the last facility in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching facility, or <code>null</code> if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchByWww_Last(String www,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByWww(www);

		if (count == 0) {
			return null;
		}

		List<Facility> list = findByWww(www, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the facilities before and after the current facility in the ordered set where www = &#63;.
	 *
	 * @param facilityId the primary key of the current facility
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility[] findByWww_PrevAndNext(long facilityId, String www,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = findByPrimaryKey(facilityId);

		Session session = null;

		try {
			session = openSession();

			Facility[] array = new FacilityImpl[3];

			array[0] = getByWww_PrevAndNext(session, facility, www,
					orderByComparator, true);

			array[1] = facility;

			array[2] = getByWww_PrevAndNext(session, facility, www,
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

	protected Facility getByWww_PrevAndNext(Session session, Facility facility,
		String www, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACILITY_WHERE);

		boolean bindWww = false;

		if (www == null) {
			query.append(_FINDER_COLUMN_WWW_WWW_1);
		}
		else if (www.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_WWW_WWW_3);
		}
		else {
			bindWww = true;

			query.append(_FINDER_COLUMN_WWW_WWW_2);
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
			query.append(FacilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindWww) {
			qPos.add(www);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(facility);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Facility> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the facilities where www = &#63; from the database.
	 *
	 * @param www the www
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByWww(String www) throws SystemException {
		for (Facility facility : findByWww(www, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(facility);
		}
	}

	/**
	 * Returns the number of facilities where www = &#63;.
	 *
	 * @param www the www
	 * @return the number of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByWww(String www) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WWW;

		Object[] finderArgs = new Object[] { www };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACILITY_WHERE);

			boolean bindWww = false;

			if (www == null) {
				query.append(_FINDER_COLUMN_WWW_WWW_1);
			}
			else if (www.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WWW_WWW_3);
			}
			else {
				bindWww = true;

				query.append(_FINDER_COLUMN_WWW_WWW_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWww) {
					qPos.add(www);
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

	private static final String _FINDER_COLUMN_WWW_WWW_1 = "facility.www IS NULL";
	private static final String _FINDER_COLUMN_WWW_WWW_2 = "facility.www = ?";
	private static final String _FINDER_COLUMN_WWW_WWW_3 = "(facility.www IS NULL OR facility.www = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVEL = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylevel",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylevel",
			new String[] { Integer.class.getName() },
			FacilityModelImpl.LEVEL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEVEL = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylevel",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the facilities where level = &#63;.
	 *
	 * @param level the level
	 * @return the matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findBylevel(int level) throws SystemException {
		return findBylevel(level, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the facilities where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @return the range of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findBylevel(int level, int start, int end)
		throws SystemException {
		return findBylevel(level, start, end, null);
	}

	/**
	 * Returns an ordered range of all the facilities where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findBylevel(int level, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL;
			finderArgs = new Object[] { level };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVEL;
			finderArgs = new Object[] { level, start, end, orderByComparator };
		}

		List<Facility> list = (List<Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Facility facility : list) {
				if ((level != facility.getLevel())) {
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

			query.append(_SQL_SELECT_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_LEVEL_LEVEL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FacilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

				if (!pagination) {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Facility>(list);
				}
				else {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first facility in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findBylevel_First(int level,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchBylevel_First(level, orderByComparator);

		if (facility != null) {
			return facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFacilityException(msg.toString());
	}

	/**
	 * Returns the first facility in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching facility, or <code>null</code> if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchBylevel_First(int level,
		OrderByComparator orderByComparator) throws SystemException {
		List<Facility> list = findBylevel(level, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last facility in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findBylevel_Last(int level,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchBylevel_Last(level, orderByComparator);

		if (facility != null) {
			return facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFacilityException(msg.toString());
	}

	/**
	 * Returns the last facility in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching facility, or <code>null</code> if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchBylevel_Last(int level,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBylevel(level);

		if (count == 0) {
			return null;
		}

		List<Facility> list = findBylevel(level, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the facilities before and after the current facility in the ordered set where level = &#63;.
	 *
	 * @param facilityId the primary key of the current facility
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility[] findBylevel_PrevAndNext(long facilityId, int level,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = findByPrimaryKey(facilityId);

		Session session = null;

		try {
			session = openSession();

			Facility[] array = new FacilityImpl[3];

			array[0] = getBylevel_PrevAndNext(session, facility, level,
					orderByComparator, true);

			array[1] = facility;

			array[2] = getBylevel_PrevAndNext(session, facility, level,
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

	protected Facility getBylevel_PrevAndNext(Session session,
		Facility facility, int level, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACILITY_WHERE);

		query.append(_FINDER_COLUMN_LEVEL_LEVEL_2);

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
			query.append(FacilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(level);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(facility);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Facility> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the facilities where level = &#63; from the database.
	 *
	 * @param level the level
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBylevel(int level) throws SystemException {
		for (Facility facility : findBylevel(level, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(facility);
		}
	}

	/**
	 * Returns the number of facilities where level = &#63;.
	 *
	 * @param level the level
	 * @return the number of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBylevel(int level) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEVEL;

		Object[] finderArgs = new Object[] { level };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_LEVEL_LEVEL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

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

	private static final String _FINDER_COLUMN_LEVEL_LEVEL_2 = "facility.level = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SORT = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySort",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SORT = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySort",
			new String[] { Integer.class.getName() },
			FacilityModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SORT = new FinderPath(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySort",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the facilities where sort = &#63;.
	 *
	 * @param sort the sort
	 * @return the matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findBySort(int sort) throws SystemException {
		return findBySort(sort, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the facilities where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @return the range of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findBySort(int sort, int start, int end)
		throws SystemException {
		return findBySort(sort, start, end, null);
	}

	/**
	 * Returns an ordered range of all the facilities where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findBySort(int sort, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SORT;
			finderArgs = new Object[] { sort };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SORT;
			finderArgs = new Object[] { sort, start, end, orderByComparator };
		}

		List<Facility> list = (List<Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Facility facility : list) {
				if ((sort != facility.getSort())) {
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

			query.append(_SQL_SELECT_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_SORT_SORT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FacilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sort);

				if (!pagination) {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Facility>(list);
				}
				else {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first facility in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findBySort_First(int sort,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchBySort_First(sort, orderByComparator);

		if (facility != null) {
			return facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sort=");
		msg.append(sort);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFacilityException(msg.toString());
	}

	/**
	 * Returns the first facility in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching facility, or <code>null</code> if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchBySort_First(int sort,
		OrderByComparator orderByComparator) throws SystemException {
		List<Facility> list = findBySort(sort, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last facility in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findBySort_Last(int sort,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchBySort_Last(sort, orderByComparator);

		if (facility != null) {
			return facility;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sort=");
		msg.append(sort);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFacilityException(msg.toString());
	}

	/**
	 * Returns the last facility in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching facility, or <code>null</code> if a matching facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchBySort_Last(int sort,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySort(sort);

		if (count == 0) {
			return null;
		}

		List<Facility> list = findBySort(sort, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the facilities before and after the current facility in the ordered set where sort = &#63;.
	 *
	 * @param facilityId the primary key of the current facility
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility[] findBySort_PrevAndNext(long facilityId, int sort,
		OrderByComparator orderByComparator)
		throws NoSuchFacilityException, SystemException {
		Facility facility = findByPrimaryKey(facilityId);

		Session session = null;

		try {
			session = openSession();

			Facility[] array = new FacilityImpl[3];

			array[0] = getBySort_PrevAndNext(session, facility, sort,
					orderByComparator, true);

			array[1] = facility;

			array[2] = getBySort_PrevAndNext(session, facility, sort,
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

	protected Facility getBySort_PrevAndNext(Session session,
		Facility facility, int sort, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACILITY_WHERE);

		query.append(_FINDER_COLUMN_SORT_SORT_2);

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
			query.append(FacilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sort);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(facility);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Facility> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the facilities where sort = &#63; from the database.
	 *
	 * @param sort the sort
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySort(int sort) throws SystemException {
		for (Facility facility : findBySort(sort, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(facility);
		}
	}

	/**
	 * Returns the number of facilities where sort = &#63;.
	 *
	 * @param sort the sort
	 * @return the number of matching facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySort(int sort) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SORT;

		Object[] finderArgs = new Object[] { sort };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACILITY_WHERE);

			query.append(_FINDER_COLUMN_SORT_SORT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sort);

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

	private static final String _FINDER_COLUMN_SORT_SORT_2 = "facility.sort = ?";

	public FacilityPersistenceImpl() {
		setModelClass(Facility.class);
	}

	/**
	 * Caches the facility in the entity cache if it is enabled.
	 *
	 * @param facility the facility
	 */
	@Override
	public void cacheResult(Facility facility) {
		EntityCacheUtil.putResult(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityImpl.class, facility.getPrimaryKey(), facility);

		facility.resetOriginalValues();
	}

	/**
	 * Caches the facilities in the entity cache if it is enabled.
	 *
	 * @param facilities the facilities
	 */
	@Override
	public void cacheResult(List<Facility> facilities) {
		for (Facility facility : facilities) {
			if (EntityCacheUtil.getResult(
						FacilityModelImpl.ENTITY_CACHE_ENABLED,
						FacilityImpl.class, facility.getPrimaryKey()) == null) {
				cacheResult(facility);
			}
			else {
				facility.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all facilities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FacilityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FacilityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the facility.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Facility facility) {
		EntityCacheUtil.removeResult(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityImpl.class, facility.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Facility> facilities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Facility facility : facilities) {
			EntityCacheUtil.removeResult(FacilityModelImpl.ENTITY_CACHE_ENABLED,
				FacilityImpl.class, facility.getPrimaryKey());
		}
	}

	/**
	 * Creates a new facility with the primary key. Does not add the facility to the database.
	 *
	 * @param facilityId the primary key for the new facility
	 * @return the new facility
	 */
	@Override
	public Facility create(long facilityId) {
		Facility facility = new FacilityImpl();

		facility.setNew(true);
		facility.setPrimaryKey(facilityId);

		return facility;
	}

	/**
	 * Removes the facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility remove(long facilityId)
		throws NoSuchFacilityException, SystemException {
		return remove((Serializable)facilityId);
	}

	/**
	 * Removes the facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the facility
	 * @return the facility that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility remove(Serializable primaryKey)
		throws NoSuchFacilityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Facility facility = (Facility)session.get(FacilityImpl.class,
					primaryKey);

			if (facility == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(facility);
		}
		catch (NoSuchFacilityException nsee) {
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
	protected Facility removeImpl(Facility facility) throws SystemException {
		facility = toUnwrappedModel(facility);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(facility)) {
				facility = (Facility)session.get(FacilityImpl.class,
						facility.getPrimaryKeyObj());
			}

			if (facility != null) {
				session.delete(facility);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (facility != null) {
			clearCache(facility);
		}

		return facility;
	}

	@Override
	public Facility updateImpl(de.uhh.l2g.plugins.model.Facility facility)
		throws SystemException {
		facility = toUnwrappedModel(facility);

		boolean isNew = facility.isNew();

		FacilityModelImpl facilityModelImpl = (FacilityModelImpl)facility;

		Session session = null;

		try {
			session = openSession();

			if (facility.isNew()) {
				session.save(facility);

				facility.setNew(false);
			}
			else {
				session.merge(facility);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FacilityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((facilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						facilityModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);

				args = new Object[] { facilityModelImpl.getParentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);
			}

			if ((facilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { facilityModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { facilityModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((facilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { facilityModelImpl.getOriginalTyp() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP,
					args);

				args = new Object[] { facilityModelImpl.getTyp() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP,
					args);
			}

			if ((facilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WWW.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { facilityModelImpl.getOriginalWww() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WWW, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WWW,
					args);

				args = new Object[] { facilityModelImpl.getWww() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WWW, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WWW,
					args);
			}

			if ((facilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						facilityModelImpl.getOriginalLevel()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVEL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL,
					args);

				args = new Object[] { facilityModelImpl.getLevel() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVEL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL,
					args);
			}

			if ((facilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SORT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { facilityModelImpl.getOriginalSort() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SORT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SORT,
					args);

				args = new Object[] { facilityModelImpl.getSort() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SORT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SORT,
					args);
			}
		}

		EntityCacheUtil.putResult(FacilityModelImpl.ENTITY_CACHE_ENABLED,
			FacilityImpl.class, facility.getPrimaryKey(), facility);

		return facility;
	}

	protected Facility toUnwrappedModel(Facility facility) {
		if (facility instanceof FacilityImpl) {
			return facility;
		}

		FacilityImpl facilityImpl = new FacilityImpl();

		facilityImpl.setNew(facility.isNew());
		facilityImpl.setPrimaryKey(facility.getPrimaryKey());

		facilityImpl.setFacilityId(facility.getFacilityId());
		facilityImpl.setParentId(facility.getParentId());
		facilityImpl.setName(facility.getName());
		facilityImpl.setTyp(facility.getTyp());
		facilityImpl.setWww(facility.getWww());
		facilityImpl.setLevel(facility.getLevel());
		facilityImpl.setSort(facility.getSort());

		return facilityImpl;
	}

	/**
	 * Returns the facility with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the facility
	 * @return the facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacilityException, SystemException {
		Facility facility = fetchByPrimaryKey(primaryKey);

		if (facility == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return facility;
	}

	/**
	 * Returns the facility with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchFacilityException} if it could not be found.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility
	 * @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility findByPrimaryKey(long facilityId)
		throws NoSuchFacilityException, SystemException {
		return findByPrimaryKey((Serializable)facilityId);
	}

	/**
	 * Returns the facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the facility
	 * @return the facility, or <code>null</code> if a facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Facility facility = (Facility)EntityCacheUtil.getResult(FacilityModelImpl.ENTITY_CACHE_ENABLED,
				FacilityImpl.class, primaryKey);

		if (facility == _nullFacility) {
			return null;
		}

		if (facility == null) {
			Session session = null;

			try {
				session = openSession();

				facility = (Facility)session.get(FacilityImpl.class, primaryKey);

				if (facility != null) {
					cacheResult(facility);
				}
				else {
					EntityCacheUtil.putResult(FacilityModelImpl.ENTITY_CACHE_ENABLED,
						FacilityImpl.class, primaryKey, _nullFacility);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FacilityModelImpl.ENTITY_CACHE_ENABLED,
					FacilityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return facility;
	}

	/**
	 * Returns the facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facilityId the primary key of the facility
	 * @return the facility, or <code>null</code> if a facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility fetchByPrimaryKey(long facilityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)facilityId);
	}

	/**
	 * Returns all the facilities.
	 *
	 * @return the facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @return the range of facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of facilities
	 * @param end the upper bound of the range of facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility> findAll(int start, int end,
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

		List<Facility> list = (List<Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACILITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACILITY;

				if (pagination) {
					sql = sql.concat(FacilityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Facility>(list);
				}
				else {
					list = (List<Facility>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the facilities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Facility facility : findAll()) {
			remove(facility);
		}
	}

	/**
	 * Returns the number of facilities.
	 *
	 * @return the number of facilities
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

				Query q = session.createQuery(_SQL_COUNT_FACILITY);

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
	 * Initializes the facility persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Facility")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Facility>> listenersList = new ArrayList<ModelListener<Facility>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Facility>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FacilityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACILITY = "SELECT facility FROM Facility facility";
	private static final String _SQL_SELECT_FACILITY_WHERE = "SELECT facility FROM Facility facility WHERE ";
	private static final String _SQL_COUNT_FACILITY = "SELECT COUNT(facility) FROM Facility facility";
	private static final String _SQL_COUNT_FACILITY_WHERE = "SELECT COUNT(facility) FROM Facility facility WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "facility.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Facility exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Facility exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FacilityPersistenceImpl.class);
	private static Facility _nullFacility = new FacilityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Facility> toCacheModel() {
				return _nullFacilityCacheModel;
			}
		};

	private static CacheModel<Facility> _nullFacilityCacheModel = new CacheModel<Facility>() {
			@Override
			public Facility toEntityModel() {
				return _nullFacility;
			}
		};
}