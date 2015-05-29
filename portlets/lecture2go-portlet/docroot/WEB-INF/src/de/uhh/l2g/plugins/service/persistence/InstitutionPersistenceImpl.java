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

import de.uhh.l2g.plugins.NoSuchInstitutionException;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.impl.InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.InstitutionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the institution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see InstitutionPersistence
 * @see InstitutionUtil
 * @generated
 */
public class InstitutionPersistenceImpl extends BasePersistenceImpl<Institution>
	implements InstitutionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InstitutionUtil} to access the institution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InstitutionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParent",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT =
		new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParent",
			new String[] { Long.class.getName() },
			InstitutionModelImpl.PARENTID_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENT = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParent",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the institutions where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByParent(long parentId)
		throws SystemException {
		return findByParent(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByParent(long parentId, int start, int end)
		throws SystemException {
		return findByParent(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByParent(long parentId, int start, int end,
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

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if ((parentId != institution.getParentId())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByParent_First(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByParent_First(parentId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByParent_First(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByParent(parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByParent_Last(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByParent_Last(parentId, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByParent_Last(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParent(parentId);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByParent(parentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where parentId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByParent_PrevAndNext(long institutionId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByParent_PrevAndNext(session, institution, parentId,
					orderByComparator, true);

			array[1] = institution;

			array[2] = getByParent_PrevAndNext(session, institution, parentId,
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

	protected Institution getByParent_PrevAndNext(Session session,
		Institution institution, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParent(long parentId) throws SystemException {
		for (Institution institution : findByParent(parentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching institutions
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

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

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

	private static final String _FINDER_COLUMN_PARENT_PARENTID_2 = "institution.parentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			InstitutionModelImpl.NAME_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the institutions where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByName(String name, int start, int end,
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

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if (!Validator.equals(name, institution.getName())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

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
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
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
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByName_First(name, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByName_Last(name, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where name = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByName_PrevAndNext(long institutionId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByName_PrevAndNext(session, institution, name,
					orderByComparator, true);

			array[1] = institution;

			array[2] = getByName_PrevAndNext(session, institution, name,
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

	protected Institution getByName_PrevAndNext(Session session,
		Institution institution, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (Institution institution : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching institutions
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

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "institution.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "institution.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(institution.name IS NULL OR institution.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYP = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTyp",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTyp",
			new String[] { String.class.getName() },
			InstitutionModelImpl.TYP_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYP = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTyp",
			new String[] { String.class.getName() });

	/**
	 * Returns all the institutions where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByTyp(String typ) throws SystemException {
		return findByTyp(typ, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByTyp(String typ, int start, int end)
		throws SystemException {
		return findByTyp(typ, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByTyp(String typ, int start, int end,
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

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if (!Validator.equals(typ, institution.getTyp())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

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
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
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
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByTyp_First(String typ,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByTyp_First(typ, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typ=");
		msg.append(typ);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByTyp_First(String typ,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByTyp(typ, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByTyp_Last(String typ,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByTyp_Last(typ, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typ=");
		msg.append(typ);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByTyp_Last(String typ,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTyp(typ);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByTyp(typ, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where typ = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByTyp_PrevAndNext(long institutionId, String typ,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByTyp_PrevAndNext(session, institution, typ,
					orderByComparator, true);

			array[1] = institution;

			array[2] = getByTyp_PrevAndNext(session, institution, typ,
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

	protected Institution getByTyp_PrevAndNext(Session session,
		Institution institution, String typ,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where typ = &#63; from the database.
	 *
	 * @param typ the typ
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTyp(String typ) throws SystemException {
		for (Institution institution : findByTyp(typ, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the number of matching institutions
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

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

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

	private static final String _FINDER_COLUMN_TYP_TYP_1 = "institution.typ IS NULL";
	private static final String _FINDER_COLUMN_TYP_TYP_2 = "institution.typ = ?";
	private static final String _FINDER_COLUMN_TYP_TYP_3 = "(institution.typ IS NULL OR institution.typ = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WWW = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWww",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WWW = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWww",
			new String[] { String.class.getName() },
			InstitutionModelImpl.WWW_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WWW = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWww",
			new String[] { String.class.getName() });

	/**
	 * Returns all the institutions where www = &#63;.
	 *
	 * @param www the www
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByWww(String www) throws SystemException {
		return findByWww(www, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByWww(String www, int start, int end)
		throws SystemException {
		return findByWww(www, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByWww(String www, int start, int end,
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

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if (!Validator.equals(www, institution.getWww())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

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
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
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
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByWww_First(String www,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByWww_First(www, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("www=");
		msg.append(www);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByWww_First(String www,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByWww(www, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByWww_Last(String www,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByWww_Last(www, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("www=");
		msg.append(www);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByWww_Last(String www,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByWww(www);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByWww(www, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where www = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByWww_PrevAndNext(long institutionId, String www,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByWww_PrevAndNext(session, institution, www,
					orderByComparator, true);

			array[1] = institution;

			array[2] = getByWww_PrevAndNext(session, institution, www,
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

	protected Institution getByWww_PrevAndNext(Session session,
		Institution institution, String www,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where www = &#63; from the database.
	 *
	 * @param www the www
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByWww(String www) throws SystemException {
		for (Institution institution : findByWww(www, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where www = &#63;.
	 *
	 * @param www the www
	 * @return the number of matching institutions
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

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

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

	private static final String _FINDER_COLUMN_WWW_WWW_1 = "institution.www IS NULL";
	private static final String _FINDER_COLUMN_WWW_WWW_2 = "institution.www = ?";
	private static final String _FINDER_COLUMN_WWW_WWW_3 = "(institution.www IS NULL OR institution.www = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVEL = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylevel",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylevel",
			new String[] { Integer.class.getName() },
			InstitutionModelImpl.LEVEL_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEVEL = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylevel",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the institutions where level = &#63;.
	 *
	 * @param level the level
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findBylevel(int level) throws SystemException {
		return findBylevel(level, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findBylevel(int level, int start, int end)
		throws SystemException {
		return findBylevel(level, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findBylevel(int level, int start, int end,
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

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if ((level != institution.getLevel())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_LEVEL_LEVEL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findBylevel_First(int level,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchBylevel_First(level, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchBylevel_First(int level,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findBylevel(level, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findBylevel_Last(int level,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchBylevel_Last(level, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchBylevel_Last(int level,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBylevel(level);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findBylevel(level, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where level = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findBylevel_PrevAndNext(long institutionId, int level,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getBylevel_PrevAndNext(session, institution, level,
					orderByComparator, true);

			array[1] = institution;

			array[2] = getBylevel_PrevAndNext(session, institution, level,
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

	protected Institution getBylevel_PrevAndNext(Session session,
		Institution institution, int level,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(level);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where level = &#63; from the database.
	 *
	 * @param level the level
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBylevel(int level) throws SystemException {
		for (Institution institution : findBylevel(level, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where level = &#63;.
	 *
	 * @param level the level
	 * @return the number of matching institutions
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

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

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

	private static final String _FINDER_COLUMN_LEVEL_LEVEL_2 = "institution.level = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SORT = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySort",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SORT = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySort",
			new String[] { Integer.class.getName() },
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SORT = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySort",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the institutions where sort = &#63;.
	 *
	 * @param sort the sort
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findBySort(int sort) throws SystemException {
		return findBySort(sort, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findBySort(int sort, int start, int end)
		throws SystemException {
		return findBySort(sort, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findBySort(int sort, int start, int end,
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

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if ((sort != institution.getSort())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_SORT_SORT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sort);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findBySort_First(int sort,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchBySort_First(sort, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sort=");
		msg.append(sort);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchBySort_First(int sort,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findBySort(sort, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findBySort_Last(int sort,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchBySort_Last(sort, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sort=");
		msg.append(sort);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchBySort_Last(int sort,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySort(sort);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findBySort(sort, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where sort = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findBySort_PrevAndNext(long institutionId, int sort,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getBySort_PrevAndNext(session, institution, sort,
					orderByComparator, true);

			array[1] = institution;

			array[2] = getBySort_PrevAndNext(session, institution, sort,
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

	protected Institution getBySort_PrevAndNext(Session session,
		Institution institution, int sort, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sort);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where sort = &#63; from the database.
	 *
	 * @param sort the sort
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySort(int sort) throws SystemException {
		for (Institution institution : findBySort(sort, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where sort = &#63;.
	 *
	 * @param sort the sort
	 * @return the number of matching institutions
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

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

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

	private static final String _FINDER_COLUMN_SORT_SORT_2 = "institution.sort = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVELANDTYPE =
		new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLevelAndType",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDTYPE =
		new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLevelAndType",
			new String[] { Integer.class.getName(), String.class.getName() },
			InstitutionModelImpl.LEVEL_COLUMN_BITMASK |
			InstitutionModelImpl.TYP_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEVELANDTYPE = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLevelAndType",
			new String[] { Integer.class.getName(), String.class.getName() });

	/**
	 * Returns all the institutions where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByLevelAndType(int level, String typ)
		throws SystemException {
		return findByLevelAndType(level, typ, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where level = &#63; and typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByLevelAndType(int level, String typ,
		int start, int end) throws SystemException {
		return findByLevelAndType(level, typ, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByLevelAndType(int level, String typ,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDTYPE;
			finderArgs = new Object[] { level, typ };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVELANDTYPE;
			finderArgs = new Object[] { level, typ, start, end, orderByComparator };
		}

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if ((level != institution.getLevel()) ||
						!Validator.equals(typ, institution.getTyp())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_LEVELANDTYPE_LEVEL_2);

			boolean bindTyp = false;

			if (typ == null) {
				query.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_1);
			}
			else if (typ.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_3);
			}
			else {
				bindTyp = true;

				query.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

				if (bindTyp) {
					qPos.add(typ);
				}

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByLevelAndType_First(int level, String typ,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByLevelAndType_First(level, typ,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(", typ=");
		msg.append(typ);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByLevelAndType_First(int level, String typ,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByLevelAndType(level, typ, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByLevelAndType_Last(int level, String typ,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByLevelAndType_Last(level, typ,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(", typ=");
		msg.append(typ);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByLevelAndType_Last(int level, String typ,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLevelAndType(level, typ);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByLevelAndType(level, typ, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByLevelAndType_PrevAndNext(long institutionId,
		int level, String typ, OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByLevelAndType_PrevAndNext(session, institution,
					level, typ, orderByComparator, true);

			array[1] = institution;

			array[2] = getByLevelAndType_PrevAndNext(session, institution,
					level, typ, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByLevelAndType_PrevAndNext(Session session,
		Institution institution, int level, String typ,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_LEVELANDTYPE_LEVEL_2);

		boolean bindTyp = false;

		if (typ == null) {
			query.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_1);
		}
		else if (typ.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_3);
		}
		else {
			bindTyp = true;

			query.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_2);
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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(level);

		if (bindTyp) {
			qPos.add(typ);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where level = &#63; and typ = &#63; from the database.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLevelAndType(int level, String typ)
		throws SystemException {
		for (Institution institution : findByLevelAndType(level, typ,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @return the number of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLevelAndType(int level, String typ)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEVELANDTYPE;

		Object[] finderArgs = new Object[] { level, typ };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_LEVELANDTYPE_LEVEL_2);

			boolean bindTyp = false;

			if (typ == null) {
				query.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_1);
			}
			else if (typ.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_3);
			}
			else {
				bindTyp = true;

				query.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

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

	private static final String _FINDER_COLUMN_LEVELANDTYPE_LEVEL_2 = "institution.level = ? AND ";
	private static final String _FINDER_COLUMN_LEVELANDTYPE_TYP_1 = "institution.typ IS NULL";
	private static final String _FINDER_COLUMN_LEVELANDTYPE_TYP_2 = "institution.typ = ?";
	private static final String _FINDER_COLUMN_LEVELANDTYPE_TYP_3 = "(institution.typ IS NULL OR institution.typ = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			InstitutionModelImpl.GROUPID_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the institutions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if ((groupId != institution.getGroupId())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByGroupId_First(groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByGroupId_Last(groupId, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByGroupId_PrevAndNext(long institutionId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, institution, groupId,
					orderByComparator, true);

			array[1] = institution;

			array[2] = getByGroupId_PrevAndNext(session, institution, groupId,
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

	protected Institution getByGroupId_PrevAndNext(Session session,
		Institution institution, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Institution institution : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "institution.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_P = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_P",
			new String[] { Long.class.getName(), Long.class.getName() },
			InstitutionModelImpl.GROUPID_COLUMN_BITMASK |
			InstitutionModelImpl.PARENTID_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_P",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the institutions where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_P(long groupId, long parentId)
		throws SystemException {
		return findByG_P(groupId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_P(long groupId, long parentId, int start,
		int end) throws SystemException {
		return findByG_P(groupId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_P(long groupId, long parentId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P;
			finderArgs = new Object[] { groupId, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_P;
			finderArgs = new Object[] {
					groupId, parentId,
					
					start, end, orderByComparator
				};
		}

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if ((groupId != institution.getGroupId()) ||
						(parentId != institution.getParentId())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_P_First(long groupId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_P_First(groupId, parentId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_P_First(long groupId, long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByG_P(groupId, parentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_P_Last(long groupId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_P_Last(groupId, parentId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_P_Last(long groupId, long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_P(groupId, parentId);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByG_P(groupId, parentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByG_P_PrevAndNext(long institutionId,
		long groupId, long parentId, OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByG_P_PrevAndNext(session, institution, groupId,
					parentId, orderByComparator, true);

			array[1] = institution;

			array[2] = getByG_P_PrevAndNext(session, institution, groupId,
					parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByG_P_PrevAndNext(Session session,
		Institution institution, long groupId, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_PARENTID_2);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where groupId = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_P(long groupId, long parentId)
		throws SystemException {
		for (Institution institution : findByG_P(groupId, parentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the number of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_P(long groupId, long parentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_P;

		Object[] finderArgs = new Object[] { groupId, parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_P_GROUPID_2 = "institution.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_PARENTID_2 = "institution.parentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_N",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_N = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_N",
			new String[] { String.class.getName(), Long.class.getName() },
			InstitutionModelImpl.NAME_COLUMN_BITMASK |
			InstitutionModelImpl.GROUPID_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_N = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_N",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the institutions where name = &#63; and groupId = &#63;.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_N(String name, long groupId)
		throws SystemException {
		return findByG_N(name, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the institutions where name = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_N(String name, long groupId, int start,
		int end) throws SystemException {
		return findByG_N(name, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where name = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_N(String name, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_N;
			finderArgs = new Object[] { name, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N;
			finderArgs = new Object[] {
					name, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if (!Validator.equals(name, institution.getName()) ||
						(groupId != institution.getGroupId())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_G_N_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_N_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_G_N_NAME_2);
			}

			query.append(_FINDER_COLUMN_G_N_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
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

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where name = &#63; and groupId = &#63;.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_N_First(String name, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_N_First(name, groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where name = &#63; and groupId = &#63;.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_N_First(String name, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByG_N(name, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where name = &#63; and groupId = &#63;.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_N_Last(String name, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_N_Last(name, groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where name = &#63; and groupId = &#63;.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_N_Last(String name, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_N(name, groupId);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByG_N(name, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where name = &#63; and groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param name the name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByG_N_PrevAndNext(long institutionId, String name,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByG_N_PrevAndNext(session, institution, name,
					groupId, orderByComparator, true);

			array[1] = institution;

			array[2] = getByG_N_PrevAndNext(session, institution, name,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByG_N_PrevAndNext(Session session,
		Institution institution, String name, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_G_N_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_G_N_NAME_2);
		}

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where name = &#63; and groupId = &#63; from the database.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_N(String name, long groupId)
		throws SystemException {
		for (Institution institution : findByG_N(name, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where name = &#63; and groupId = &#63;.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_N(String name, long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_N;

		Object[] finderArgs = new Object[] { name, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_G_N_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_N_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_G_N_NAME_2);
			}

			query.append(_FINDER_COLUMN_G_N_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_N_NAME_1 = "institution.name IS NULL AND ";
	private static final String _FINDER_COLUMN_G_N_NAME_2 = "institution.name = ? AND ";
	private static final String _FINDER_COLUMN_G_N_NAME_3 = "(institution.name IS NULL OR institution.name = '') AND ";
	private static final String _FINDER_COLUMN_G_N_GROUPID_2 = "institution.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_T",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_T",
			new String[] { String.class.getName(), Long.class.getName() },
			InstitutionModelImpl.TYP_COLUMN_BITMASK |
			InstitutionModelImpl.GROUPID_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_T = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_T",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the institutions where typ = &#63; and groupId = &#63;.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_T(String typ, long groupId)
		throws SystemException {
		return findByG_T(typ, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the institutions where typ = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_T(String typ, long groupId, int start,
		int end) throws SystemException {
		return findByG_T(typ, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where typ = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_T(String typ, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T;
			finderArgs = new Object[] { typ, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T;
			finderArgs = new Object[] {
					typ, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if (!Validator.equals(typ, institution.getTyp()) ||
						(groupId != institution.getGroupId())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			boolean bindTyp = false;

			if (typ == null) {
				query.append(_FINDER_COLUMN_G_T_TYP_1);
			}
			else if (typ.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_T_TYP_3);
			}
			else {
				bindTyp = true;

				query.append(_FINDER_COLUMN_G_T_TYP_2);
			}

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
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

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where typ = &#63; and groupId = &#63;.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_T_First(String typ, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_T_First(typ, groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typ=");
		msg.append(typ);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where typ = &#63; and groupId = &#63;.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_T_First(String typ, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByG_T(typ, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where typ = &#63; and groupId = &#63;.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_T_Last(String typ, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_T_Last(typ, groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typ=");
		msg.append(typ);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where typ = &#63; and groupId = &#63;.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_T_Last(String typ, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_T(typ, groupId);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByG_T(typ, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where typ = &#63; and groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByG_T_PrevAndNext(long institutionId, String typ,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByG_T_PrevAndNext(session, institution, typ, groupId,
					orderByComparator, true);

			array[1] = institution;

			array[2] = getByG_T_PrevAndNext(session, institution, typ, groupId,
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

	protected Institution getByG_T_PrevAndNext(Session session,
		Institution institution, String typ, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

		boolean bindTyp = false;

		if (typ == null) {
			query.append(_FINDER_COLUMN_G_T_TYP_1);
		}
		else if (typ.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_T_TYP_3);
		}
		else {
			bindTyp = true;

			query.append(_FINDER_COLUMN_G_T_TYP_2);
		}

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTyp) {
			qPos.add(typ);
		}

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where typ = &#63; and groupId = &#63; from the database.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_T(String typ, long groupId) throws SystemException {
		for (Institution institution : findByG_T(typ, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where typ = &#63; and groupId = &#63;.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_T(String typ, long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_T;

		Object[] finderArgs = new Object[] { typ, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

			boolean bindTyp = false;

			if (typ == null) {
				query.append(_FINDER_COLUMN_G_T_TYP_1);
			}
			else if (typ.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_T_TYP_3);
			}
			else {
				bindTyp = true;

				query.append(_FINDER_COLUMN_G_T_TYP_2);
			}

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTyp) {
					qPos.add(typ);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_T_TYP_1 = "institution.typ IS NULL AND ";
	private static final String _FINDER_COLUMN_G_T_TYP_2 = "institution.typ = ? AND ";
	private static final String _FINDER_COLUMN_G_T_TYP_3 = "(institution.typ IS NULL OR institution.typ = '') AND ";
	private static final String _FINDER_COLUMN_G_T_GROUPID_2 = "institution.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_W = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_W",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_W",
			new String[] { String.class.getName(), Long.class.getName() },
			InstitutionModelImpl.WWW_COLUMN_BITMASK |
			InstitutionModelImpl.GROUPID_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_W = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_W",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the institutions where www = &#63; and groupId = &#63;.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_W(String www, long groupId)
		throws SystemException {
		return findByG_W(www, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the institutions where www = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_W(String www, long groupId, int start,
		int end) throws SystemException {
		return findByG_W(www, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where www = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_W(String www, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W;
			finderArgs = new Object[] { www, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_W;
			finderArgs = new Object[] {
					www, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if (!Validator.equals(www, institution.getWww()) ||
						(groupId != institution.getGroupId())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			boolean bindWww = false;

			if (www == null) {
				query.append(_FINDER_COLUMN_G_W_WWW_1);
			}
			else if (www.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_W_WWW_3);
			}
			else {
				bindWww = true;

				query.append(_FINDER_COLUMN_G_W_WWW_2);
			}

			query.append(_FINDER_COLUMN_G_W_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
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

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where www = &#63; and groupId = &#63;.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_W_First(String www, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_W_First(www, groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("www=");
		msg.append(www);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where www = &#63; and groupId = &#63;.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_W_First(String www, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByG_W(www, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where www = &#63; and groupId = &#63;.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_W_Last(String www, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_W_Last(www, groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("www=");
		msg.append(www);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where www = &#63; and groupId = &#63;.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_W_Last(String www, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_W(www, groupId);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByG_W(www, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where www = &#63; and groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param www the www
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByG_W_PrevAndNext(long institutionId, String www,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByG_W_PrevAndNext(session, institution, www, groupId,
					orderByComparator, true);

			array[1] = institution;

			array[2] = getByG_W_PrevAndNext(session, institution, www, groupId,
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

	protected Institution getByG_W_PrevAndNext(Session session,
		Institution institution, String www, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

		boolean bindWww = false;

		if (www == null) {
			query.append(_FINDER_COLUMN_G_W_WWW_1);
		}
		else if (www.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_W_WWW_3);
		}
		else {
			bindWww = true;

			query.append(_FINDER_COLUMN_G_W_WWW_2);
		}

		query.append(_FINDER_COLUMN_G_W_GROUPID_2);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindWww) {
			qPos.add(www);
		}

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where www = &#63; and groupId = &#63; from the database.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_W(String www, long groupId) throws SystemException {
		for (Institution institution : findByG_W(www, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where www = &#63; and groupId = &#63;.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_W(String www, long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_W;

		Object[] finderArgs = new Object[] { www, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

			boolean bindWww = false;

			if (www == null) {
				query.append(_FINDER_COLUMN_G_W_WWW_1);
			}
			else if (www.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_W_WWW_3);
			}
			else {
				bindWww = true;

				query.append(_FINDER_COLUMN_G_W_WWW_2);
			}

			query.append(_FINDER_COLUMN_G_W_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWww) {
					qPos.add(www);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_W_WWW_1 = "institution.www IS NULL AND ";
	private static final String _FINDER_COLUMN_G_W_WWW_2 = "institution.www = ? AND ";
	private static final String _FINDER_COLUMN_G_W_WWW_3 = "(institution.www IS NULL OR institution.www = '') AND ";
	private static final String _FINDER_COLUMN_G_W_GROUPID_2 = "institution.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] { Integer.class.getName(), Long.class.getName() },
			InstitutionModelImpl.LEVEL_COLUMN_BITMASK |
			InstitutionModelImpl.GROUPID_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the institutions where level = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_L(int level, long groupId)
		throws SystemException {
		return findByG_L(level, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the institutions where level = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_L(int level, long groupId, int start,
		int end) throws SystemException {
		return findByG_L(level, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_L(int level, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L;
			finderArgs = new Object[] { level, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L;
			finderArgs = new Object[] {
					level, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if ((level != institution.getLevel()) ||
						(groupId != institution.getGroupId())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_G_L_LEVEL_2);

			query.append(_FINDER_COLUMN_G_L_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where level = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_L_First(int level, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_L_First(level, groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_L_First(int level, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByG_L(level, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_L_Last(int level, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_L_Last(level, groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_L_Last(int level, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_L(level, groupId);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByG_L(level, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where level = &#63; and groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param level the level
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByG_L_PrevAndNext(long institutionId, int level,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByG_L_PrevAndNext(session, institution, level,
					groupId, orderByComparator, true);

			array[1] = institution;

			array[2] = getByG_L_PrevAndNext(session, institution, level,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByG_L_PrevAndNext(Session session,
		Institution institution, int level, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_G_L_LEVEL_2);

		query.append(_FINDER_COLUMN_G_L_GROUPID_2);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(level);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where level = &#63; and groupId = &#63; from the database.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_L(int level, long groupId) throws SystemException {
		for (Institution institution : findByG_L(level, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where level = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_L(int level, long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_L;

		Object[] finderArgs = new Object[] { level, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_G_L_LEVEL_2);

			query.append(_FINDER_COLUMN_G_L_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_L_LEVEL_2 = "institution.level = ? AND ";
	private static final String _FINDER_COLUMN_G_L_GROUPID_2 = "institution.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] { Integer.class.getName(), Long.class.getName() },
			InstitutionModelImpl.SORT_COLUMN_BITMASK |
			InstitutionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the institutions where sort = &#63; and groupId = &#63;.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_S(int sort, long groupId)
		throws SystemException {
		return findByG_S(sort, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the institutions where sort = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_S(int sort, long groupId, int start,
		int end) throws SystemException {
		return findByG_S(sort, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where sort = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_S(int sort, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] { sort, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] {
					sort, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if ((sort != institution.getSort()) ||
						(groupId != institution.getGroupId())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_G_S_SORT_2);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sort);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where sort = &#63; and groupId = &#63;.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_S_First(int sort, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_S_First(sort, groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sort=");
		msg.append(sort);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where sort = &#63; and groupId = &#63;.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_S_First(int sort, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByG_S(sort, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where sort = &#63; and groupId = &#63;.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_S_Last(int sort, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_S_Last(sort, groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sort=");
		msg.append(sort);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where sort = &#63; and groupId = &#63;.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_S_Last(int sort, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_S(sort, groupId);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByG_S(sort, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where sort = &#63; and groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByG_S_PrevAndNext(long institutionId, int sort,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByG_S_PrevAndNext(session, institution, sort,
					groupId, orderByComparator, true);

			array[1] = institution;

			array[2] = getByG_S_PrevAndNext(session, institution, sort,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByG_S_PrevAndNext(Session session,
		Institution institution, int sort, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_G_S_SORT_2);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sort);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where sort = &#63; and groupId = &#63; from the database.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_S(int sort, long groupId) throws SystemException {
		for (Institution institution : findByG_S(sort, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where sort = &#63; and groupId = &#63;.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_S(int sort, long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S;

		Object[] finderArgs = new Object[] { sort, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_G_S_SORT_2);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sort);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_S_SORT_2 = "institution.sort = ? AND ";
	private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "institution.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_T = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_T",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_T = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_T",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			InstitutionModelImpl.LEVEL_COLUMN_BITMASK |
			InstitutionModelImpl.TYP_COLUMN_BITMASK |
			InstitutionModelImpl.GROUPID_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L_T = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_T",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_L_T(int level, String typ, long groupId)
		throws SystemException {
		return findByG_L_T(level, typ, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_L_T(int level, String typ, long groupId,
		int start, int end) throws SystemException {
		return findByG_L_T(level, typ, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_L_T(int level, String typ, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_T;
			finderArgs = new Object[] { level, typ, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_T;
			finderArgs = new Object[] {
					level, typ, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if ((level != institution.getLevel()) ||
						!Validator.equals(typ, institution.getTyp()) ||
						(groupId != institution.getGroupId())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_G_L_T_LEVEL_2);

			boolean bindTyp = false;

			if (typ == null) {
				query.append(_FINDER_COLUMN_G_L_T_TYP_1);
			}
			else if (typ.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_L_T_TYP_3);
			}
			else {
				bindTyp = true;

				query.append(_FINDER_COLUMN_G_L_T_TYP_2);
			}

			query.append(_FINDER_COLUMN_G_L_T_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

				if (bindTyp) {
					qPos.add(typ);
				}

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_L_T_First(int level, String typ, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_L_T_First(level, typ, groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(", typ=");
		msg.append(typ);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_L_T_First(int level, String typ, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Institution> list = findByG_L_T(level, typ, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_L_T_Last(int level, String typ, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_L_T_Last(level, typ, groupId,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(", typ=");
		msg.append(typ);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_L_T_Last(int level, String typ, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_L_T(level, typ, groupId);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByG_L_T(level, typ, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByG_L_T_PrevAndNext(long institutionId, int level,
		String typ, long groupId, OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByG_L_T_PrevAndNext(session, institution, level, typ,
					groupId, orderByComparator, true);

			array[1] = institution;

			array[2] = getByG_L_T_PrevAndNext(session, institution, level, typ,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByG_L_T_PrevAndNext(Session session,
		Institution institution, int level, String typ, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_G_L_T_LEVEL_2);

		boolean bindTyp = false;

		if (typ == null) {
			query.append(_FINDER_COLUMN_G_L_T_TYP_1);
		}
		else if (typ.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_L_T_TYP_3);
		}
		else {
			bindTyp = true;

			query.append(_FINDER_COLUMN_G_L_T_TYP_2);
		}

		query.append(_FINDER_COLUMN_G_L_T_GROUPID_2);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(level);

		if (bindTyp) {
			qPos.add(typ);
		}

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where level = &#63; and typ = &#63; and groupId = &#63; from the database.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_L_T(int level, String typ, long groupId)
		throws SystemException {
		for (Institution institution : findByG_L_T(level, typ, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_L_T(int level, String typ, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_L_T;

		Object[] finderArgs = new Object[] { level, typ, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_G_L_T_LEVEL_2);

			boolean bindTyp = false;

			if (typ == null) {
				query.append(_FINDER_COLUMN_G_L_T_TYP_1);
			}
			else if (typ.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_L_T_TYP_3);
			}
			else {
				bindTyp = true;

				query.append(_FINDER_COLUMN_G_L_T_TYP_2);
			}

			query.append(_FINDER_COLUMN_G_L_T_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

				if (bindTyp) {
					qPos.add(typ);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_L_T_LEVEL_2 = "institution.level = ? AND ";
	private static final String _FINDER_COLUMN_G_L_T_TYP_1 = "institution.typ IS NULL AND ";
	private static final String _FINDER_COLUMN_G_L_T_TYP_2 = "institution.typ = ? AND ";
	private static final String _FINDER_COLUMN_G_L_T_TYP_3 = "(institution.typ IS NULL OR institution.typ = '') AND ";
	private static final String _FINDER_COLUMN_G_L_T_GROUPID_2 = "institution.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_P_S = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_P_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P_S = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_P_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			InstitutionModelImpl.GROUPID_COLUMN_BITMASK |
			InstitutionModelImpl.PARENTID_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P_S = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_P_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @return the matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_P_S(long groupId, long parentId, int sort)
		throws SystemException {
		return findByG_P_S(groupId, parentId, sort, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_P_S(long groupId, long parentId, int sort,
		int start, int end) throws SystemException {
		return findByG_P_S(groupId, parentId, sort, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findByG_P_S(long groupId, long parentId, int sort,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P_S;
			finderArgs = new Object[] { groupId, parentId, sort };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_P_S;
			finderArgs = new Object[] {
					groupId, parentId, sort,
					
					start, end, orderByComparator
				};
		}

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Institution institution : list) {
				if ((groupId != institution.getGroupId()) ||
						(parentId != institution.getParentId()) ||
						(sort != institution.getSort())) {
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

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_G_P_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_S_PARENTID_2);

			query.append(_FINDER_COLUMN_G_P_S_SORT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentId);

				qPos.add(sort);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_P_S_First(long groupId, long parentId, int sort,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_P_S_First(groupId, parentId, sort,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(", sort=");
		msg.append(sort);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_P_S_First(long groupId, long parentId,
		int sort, OrderByComparator orderByComparator)
		throws SystemException {
		List<Institution> list = findByG_P_S(groupId, parentId, sort, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_P_S_Last(long groupId, long parentId, int sort,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_P_S_Last(groupId, parentId, sort,
				orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(", sort=");
		msg.append(sort);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInstitutionException(msg.toString());
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_P_S_Last(long groupId, long parentId, int sort,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_P_S(groupId, parentId, sort);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByG_P_S(groupId, parentId, sort,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution[] findByG_P_S_PrevAndNext(long institutionId,
		long groupId, long parentId, int sort,
		OrderByComparator orderByComparator)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByG_P_S_PrevAndNext(session, institution, groupId,
					parentId, sort, orderByComparator, true);

			array[1] = institution;

			array[2] = getByG_P_S_PrevAndNext(session, institution, groupId,
					parentId, sort, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByG_P_S_PrevAndNext(Session session,
		Institution institution, long groupId, long parentId, int sort,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_G_P_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_S_PARENTID_2);

		query.append(_FINDER_COLUMN_G_P_S_SORT_2);

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
			query.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentId);

		qPos.add(sort);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_P_S(long groupId, long parentId, int sort)
		throws SystemException {
		for (Institution institution : findByG_P_S(groupId, parentId, sort,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @return the number of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_P_S(long groupId, long parentId, int sort)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_P_S;

		Object[] finderArgs = new Object[] { groupId, parentId, sort };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_G_P_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_S_PARENTID_2);

			query.append(_FINDER_COLUMN_G_P_S_SORT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_G_P_S_GROUPID_2 = "institution.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_S_PARENTID_2 = "institution.parentId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_S_SORT_2 = "institution.sort = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TOPLEVEL = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTopLevel",
			new String[] { Long.class.getName() },
			InstitutionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TOPLEVEL = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTopLevel",
			new String[] { Long.class.getName() });

	/**
	 * Returns the institution where groupId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchInstitutionException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @return the matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByTopLevel(long groupId)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByTopLevel(groupId);

		if (institution == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchInstitutionException(msg.toString());
		}

		return institution;
	}

	/**
	 * Returns the institution where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @return the matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByTopLevel(long groupId) throws SystemException {
		return fetchByTopLevel(groupId, true);
	}

	/**
	 * Returns the institution where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByTopLevel(long groupId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TOPLEVEL,
					finderArgs, this);
		}

		if (result instanceof Institution) {
			Institution institution = (Institution)result;

			if ((groupId != institution.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_TOPLEVEL_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				List<Institution> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOPLEVEL,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"InstitutionPersistenceImpl.fetchByTopLevel(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Institution institution = list.get(0);

					result = institution;

					cacheResult(institution);

					if ((institution.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOPLEVEL,
							finderArgs, institution);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOPLEVEL,
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
			return (Institution)result;
		}
	}

	/**
	 * Removes the institution where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @return the institution that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution removeByTopLevel(long groupId)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByTopLevel(groupId);

		return remove(institution);
	}

	/**
	 * Returns the number of institutions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTopLevel(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TOPLEVEL;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_TOPLEVEL_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_TOPLEVEL_GROUPID_2 = "institution.groupId = ? AND institution.parentId = 0";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_I = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_I",
			new String[] { Long.class.getName(), Long.class.getName() },
			InstitutionModelImpl.GROUPID_COLUMN_BITMASK |
			InstitutionModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_I = new FinderPath(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_I",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the institution where groupId = &#63; and institutionId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchInstitutionException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the matching institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByG_I(long groupId, long institutionId)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByG_I(groupId, institutionId);

		if (institution == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", institutionId=");
			msg.append(institutionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchInstitutionException(msg.toString());
		}

		return institution;
	}

	/**
	 * Returns the institution where groupId = &#63; and institutionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_I(long groupId, long institutionId)
		throws SystemException {
		return fetchByG_I(groupId, institutionId, true);
	}

	/**
	 * Returns the institution where groupId = &#63; and institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching institution, or <code>null</code> if a matching institution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByG_I(long groupId, long institutionId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, institutionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_I,
					finderArgs, this);
		}

		if (result instanceof Institution) {
			Institution institution = (Institution)result;

			if ((groupId != institution.getGroupId()) ||
					(institutionId != institution.getInstitutionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_G_I_GROUPID_2);

			query.append(_FINDER_COLUMN_G_I_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(institutionId);

				List<Institution> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_I,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"InstitutionPersistenceImpl.fetchByG_I(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Institution institution = list.get(0);

					result = institution;

					cacheResult(institution);

					if ((institution.getGroupId() != groupId) ||
							(institution.getInstitutionId() != institutionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_I,
							finderArgs, institution);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_I,
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
			return (Institution)result;
		}
	}

	/**
	 * Removes the institution where groupId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the institution that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution removeByG_I(long groupId, long institutionId)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = findByG_I(groupId, institutionId);

		return remove(institution);
	}

	/**
	 * Returns the number of institutions where groupId = &#63; and institutionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the number of matching institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_I(long groupId, long institutionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_I;

		Object[] finderArgs = new Object[] { groupId, institutionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_G_I_GROUPID_2);

			query.append(_FINDER_COLUMN_G_I_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_I_GROUPID_2 = "institution.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_I_INSTITUTIONID_2 = "institution.institutionId = ?";

	public InstitutionPersistenceImpl() {
		setModelClass(Institution.class);
	}

	/**
	 * Caches the institution in the entity cache if it is enabled.
	 *
	 * @param institution the institution
	 */
	@Override
	public void cacheResult(Institution institution) {
		EntityCacheUtil.putResult(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionImpl.class, institution.getPrimaryKey(), institution);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOPLEVEL,
			new Object[] { institution.getGroupId() }, institution);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_I,
			new Object[] {
				institution.getGroupId(), institution.getInstitutionId()
			}, institution);

		institution.resetOriginalValues();
	}

	/**
	 * Caches the institutions in the entity cache if it is enabled.
	 *
	 * @param institutions the institutions
	 */
	@Override
	public void cacheResult(List<Institution> institutions) {
		for (Institution institution : institutions) {
			if (EntityCacheUtil.getResult(
						InstitutionModelImpl.ENTITY_CACHE_ENABLED,
						InstitutionImpl.class, institution.getPrimaryKey()) == null) {
				cacheResult(institution);
			}
			else {
				institution.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all institutions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InstitutionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InstitutionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the institution.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Institution institution) {
		EntityCacheUtil.removeResult(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionImpl.class, institution.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(institution);
	}

	@Override
	public void clearCache(List<Institution> institutions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Institution institution : institutions) {
			EntityCacheUtil.removeResult(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
				InstitutionImpl.class, institution.getPrimaryKey());

			clearUniqueFindersCache(institution);
		}
	}

	protected void cacheUniqueFindersCache(Institution institution) {
		if (institution.isNew()) {
			Object[] args = new Object[] { institution.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOPLEVEL, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOPLEVEL, args,
				institution);

			args = new Object[] {
					institution.getGroupId(), institution.getInstitutionId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_I, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_I, args,
				institution);
		}
		else {
			InstitutionModelImpl institutionModelImpl = (InstitutionModelImpl)institution;

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TOPLEVEL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { institution.getGroupId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOPLEVEL, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOPLEVEL, args,
					institution);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_I.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institution.getGroupId(), institution.getInstitutionId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_I, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_I, args,
					institution);
			}
		}
	}

	protected void clearUniqueFindersCache(Institution institution) {
		InstitutionModelImpl institutionModelImpl = (InstitutionModelImpl)institution;

		Object[] args = new Object[] { institution.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOPLEVEL, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOPLEVEL, args);

		if ((institutionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TOPLEVEL.getColumnBitmask()) != 0) {
			args = new Object[] { institutionModelImpl.getOriginalGroupId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOPLEVEL, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOPLEVEL, args);
		}

		args = new Object[] {
				institution.getGroupId(), institution.getInstitutionId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_I, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_I, args);

		if ((institutionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_I.getColumnBitmask()) != 0) {
			args = new Object[] {
					institutionModelImpl.getOriginalGroupId(),
					institutionModelImpl.getOriginalInstitutionId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_I, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_I, args);
		}
	}

	/**
	 * Creates a new institution with the primary key. Does not add the institution to the database.
	 *
	 * @param institutionId the primary key for the new institution
	 * @return the new institution
	 */
	@Override
	public Institution create(long institutionId) {
		Institution institution = new InstitutionImpl();

		institution.setNew(true);
		institution.setPrimaryKey(institutionId);

		return institution;
	}

	/**
	 * Removes the institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution remove(long institutionId)
		throws NoSuchInstitutionException, SystemException {
		return remove((Serializable)institutionId);
	}

	/**
	 * Removes the institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the institution
	 * @return the institution that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution remove(Serializable primaryKey)
		throws NoSuchInstitutionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Institution institution = (Institution)session.get(InstitutionImpl.class,
					primaryKey);

			if (institution == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInstitutionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(institution);
		}
		catch (NoSuchInstitutionException nsee) {
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
	protected Institution removeImpl(Institution institution)
		throws SystemException {
		institution = toUnwrappedModel(institution);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(institution)) {
				institution = (Institution)session.get(InstitutionImpl.class,
						institution.getPrimaryKeyObj());
			}

			if (institution != null) {
				session.delete(institution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (institution != null) {
			clearCache(institution);
		}

		return institution;
	}

	@Override
	public Institution updateImpl(
		de.uhh.l2g.plugins.model.Institution institution)
		throws SystemException {
		institution = toUnwrappedModel(institution);

		boolean isNew = institution.isNew();

		InstitutionModelImpl institutionModelImpl = (InstitutionModelImpl)institution;

		Session session = null;

		try {
			session = openSession();

			if (institution.isNew()) {
				session.save(institution);

				institution.setNew(false);
			}
			else {
				session.merge(institution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !InstitutionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);

				args = new Object[] { institutionModelImpl.getParentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { institutionModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalTyp()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP,
					args);

				args = new Object[] { institutionModelImpl.getTyp() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYP,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WWW.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalWww()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WWW, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WWW,
					args);

				args = new Object[] { institutionModelImpl.getWww() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WWW, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WWW,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalLevel()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVEL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL,
					args);

				args = new Object[] { institutionModelImpl.getLevel() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVEL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SORT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalSort()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SORT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SORT,
					args);

				args = new Object[] { institutionModelImpl.getSort() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SORT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SORT,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalLevel(),
						institutionModelImpl.getOriginalTyp()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVELANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDTYPE,
					args);

				args = new Object[] {
						institutionModelImpl.getLevel(),
						institutionModelImpl.getTyp()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVELANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDTYPE,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { institutionModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalGroupId(),
						institutionModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P,
					args);

				args = new Object[] {
						institutionModelImpl.getGroupId(),
						institutionModelImpl.getParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_N.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalName(),
						institutionModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_N, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_N,
					args);

				args = new Object[] {
						institutionModelImpl.getName(),
						institutionModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_N, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_N,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalTyp(),
						institutionModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
					args);

				args = new Object[] {
						institutionModelImpl.getTyp(),
						institutionModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalWww(),
						institutionModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_W, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W,
					args);

				args = new Object[] {
						institutionModelImpl.getWww(),
						institutionModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_W, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalLevel(),
						institutionModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L,
					args);

				args = new Object[] {
						institutionModelImpl.getLevel(),
						institutionModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalSort(),
						institutionModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);

				args = new Object[] {
						institutionModelImpl.getSort(),
						institutionModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalLevel(),
						institutionModelImpl.getOriginalTyp(),
						institutionModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_T,
					args);

				args = new Object[] {
						institutionModelImpl.getLevel(),
						institutionModelImpl.getTyp(),
						institutionModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_T,
					args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						institutionModelImpl.getOriginalGroupId(),
						institutionModelImpl.getOriginalParentId(),
						institutionModelImpl.getOriginalSort()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_P_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P_S,
					args);

				args = new Object[] {
						institutionModelImpl.getGroupId(),
						institutionModelImpl.getParentId(),
						institutionModelImpl.getSort()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_P_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P_S,
					args);
			}
		}

		EntityCacheUtil.putResult(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionImpl.class, institution.getPrimaryKey(), institution);

		clearUniqueFindersCache(institution);
		cacheUniqueFindersCache(institution);

		return institution;
	}

	protected Institution toUnwrappedModel(Institution institution) {
		if (institution instanceof InstitutionImpl) {
			return institution;
		}

		InstitutionImpl institutionImpl = new InstitutionImpl();

		institutionImpl.setNew(institution.isNew());
		institutionImpl.setPrimaryKey(institution.getPrimaryKey());

		institutionImpl.setInstitutionId(institution.getInstitutionId());
		institutionImpl.setParentId(institution.getParentId());
		institutionImpl.setName(institution.getName());
		institutionImpl.setTyp(institution.getTyp());
		institutionImpl.setWww(institution.getWww());
		institutionImpl.setLevel(institution.getLevel());
		institutionImpl.setSort(institution.getSort());
		institutionImpl.setGroupId(institution.getGroupId());

		return institutionImpl;
	}

	/**
	 * Returns the institution with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the institution
	 * @return the institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInstitutionException, SystemException {
		Institution institution = fetchByPrimaryKey(primaryKey);

		if (institution == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInstitutionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return institution;
	}

	/**
	 * Returns the institution with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchInstitutionException} if it could not be found.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution
	 * @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution findByPrimaryKey(long institutionId)
		throws NoSuchInstitutionException, SystemException {
		return findByPrimaryKey((Serializable)institutionId);
	}

	/**
	 * Returns the institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the institution
	 * @return the institution, or <code>null</code> if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Institution institution = (Institution)EntityCacheUtil.getResult(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
				InstitutionImpl.class, primaryKey);

		if (institution == _nullInstitution) {
			return null;
		}

		if (institution == null) {
			Session session = null;

			try {
				session = openSession();

				institution = (Institution)session.get(InstitutionImpl.class,
						primaryKey);

				if (institution != null) {
					cacheResult(institution);
				}
				else {
					EntityCacheUtil.putResult(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
						InstitutionImpl.class, primaryKey, _nullInstitution);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InstitutionModelImpl.ENTITY_CACHE_ENABLED,
					InstitutionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return institution;
	}

	/**
	 * Returns the institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution, or <code>null</code> if a institution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Institution fetchByPrimaryKey(long institutionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)institutionId);
	}

	/**
	 * Returns all the institutions.
	 *
	 * @return the institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of institutions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Institution> findAll(int start, int end,
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

		List<Institution> list = (List<Institution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INSTITUTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INSTITUTION;

				if (pagination) {
					sql = sql.concat(InstitutionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Institution>(list);
				}
				else {
					list = (List<Institution>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the institutions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Institution institution : findAll()) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions.
	 *
	 * @return the number of institutions
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

				Query q = session.createQuery(_SQL_COUNT_INSTITUTION);

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
	 * Initializes the institution persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Institution")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Institution>> listenersList = new ArrayList<ModelListener<Institution>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Institution>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InstitutionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INSTITUTION = "SELECT institution FROM Institution institution";
	private static final String _SQL_SELECT_INSTITUTION_WHERE = "SELECT institution FROM Institution institution WHERE ";
	private static final String _SQL_COUNT_INSTITUTION = "SELECT COUNT(institution) FROM Institution institution";
	private static final String _SQL_COUNT_INSTITUTION_WHERE = "SELECT COUNT(institution) FROM Institution institution WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "institution.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Institution exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Institution exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InstitutionPersistenceImpl.class);
	private static Institution _nullInstitution = new InstitutionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Institution> toCacheModel() {
				return _nullInstitutionCacheModel;
			}
		};

	private static CacheModel<Institution> _nullInstitutionCacheModel = new CacheModel<Institution>() {
			@Override
			public Institution toEntityModel() {
				return _nullInstitution;
			}
		};
}