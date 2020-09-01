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

import de.uhh.l2g.plugins.NoSuchCreatorException;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.impl.CreatorImpl;
import de.uhh.l2g.plugins.model.impl.CreatorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see CreatorPersistence
 * @see CreatorUtil
 * @generated
 */
public class CreatorPersistenceImpl extends BasePersistenceImpl<Creator>
	implements CreatorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CreatorUtil} to access the creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CreatorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAME =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFirstName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFirstName",
			new String[] { String.class.getName() },
			CreatorModelImpl.FIRSTNAME_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIRSTNAME = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFirstName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the creators where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByFirstName(String firstName)
		throws SystemException {
		return findByFirstName(firstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the creators where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByFirstName(String firstName, int start, int end)
		throws SystemException {
		return findByFirstName(firstName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByFirstName(String firstName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME;
			finderArgs = new Object[] { firstName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAME;
			finderArgs = new Object[] { firstName, start, end, orderByComparator };
		}

		List<Creator> list = (List<Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Creator creator : list) {
				if (!Validator.equals(firstName, creator.getFirstName())) {
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

			query.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				if (!pagination) {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Creator>(list);
				}
				else {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator findByFirstName_First(String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = fetchByFirstName_First(firstName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the first creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator fetchByFirstName_First(String firstName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Creator> list = findByFirstName(firstName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator findByFirstName_Last(String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = fetchByFirstName_Last(firstName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the last creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator fetchByFirstName_Last(String firstName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFirstName(firstName);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByFirstName(firstName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where firstName = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator[] findByFirstName_PrevAndNext(long creatorId,
		String firstName, OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByFirstName_PrevAndNext(session, creator, firstName,
					orderByComparator, true);

			array[1] = creator;

			array[2] = getByFirstName_PrevAndNext(session, creator, firstName,
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

	protected Creator getByFirstName_PrevAndNext(Session session,
		Creator creator, String firstName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
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
			query.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFirstName) {
			qPos.add(firstName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where firstName = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFirstName(String firstName) throws SystemException {
		for (Creator creator : findByFirstName(firstName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the number of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFirstName(String firstName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIRSTNAME;

		Object[] finderArgs = new Object[] { firstName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
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

	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1 = "creator.firstName IS NULL";
	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2 = "creator.firstName = ?";
	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3 = "(creator.firstName IS NULL OR creator.firstName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LASTNAME = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLastName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLastName",
			new String[] { String.class.getName() },
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LASTNAME = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLastName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the creators where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByLastName(String lastName)
		throws SystemException {
		return findByLastName(lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the creators where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByLastName(String lastName, int start, int end)
		throws SystemException {
		return findByLastName(lastName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByLastName(String lastName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME;
			finderArgs = new Object[] { lastName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LASTNAME;
			finderArgs = new Object[] { lastName, start, end, orderByComparator };
		}

		List<Creator> list = (List<Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Creator creator : list) {
				if (!Validator.equals(lastName, creator.getLastName())) {
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

			query.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
				}

				if (!pagination) {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Creator>(list);
				}
				else {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator findByLastName_First(String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = fetchByLastName_First(lastName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the first creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator fetchByLastName_First(String lastName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Creator> list = findByLastName(lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator findByLastName_Last(String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = fetchByLastName_Last(lastName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the last creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator fetchByLastName_Last(String lastName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLastName(lastName);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByLastName(lastName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where lastName = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator[] findByLastName_PrevAndNext(long creatorId,
		String lastName, OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByLastName_PrevAndNext(session, creator, lastName,
					orderByComparator, true);

			array[1] = creator;

			array[2] = getByLastName_PrevAndNext(session, creator, lastName,
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

	protected Creator getByLastName_PrevAndNext(Session session,
		Creator creator, String lastName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindLastName = false;

		if (lastName == null) {
			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_1);
		}
		else if (lastName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
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
			query.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLastName) {
			qPos.add(lastName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLastName(String lastName) throws SystemException {
		for (Creator creator : findByLastName(lastName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLastName(String lastName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LASTNAME;

		Object[] finderArgs = new Object[] { lastName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
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

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_1 = "creator.lastName IS NULL";
	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_2 = "creator.lastName = ?";
	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_3 = "(creator.lastName IS NULL OR creator.lastName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MIDDLENAME =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMiddleName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MIDDLENAME =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMiddleName",
			new String[] { String.class.getName() },
			CreatorModelImpl.MIDDLENAME_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MIDDLENAME = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMiddleName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the creators where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByMiddleName(String middleName)
		throws SystemException {
		return findByMiddleName(middleName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the creators where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByMiddleName(String middleName, int start, int end)
		throws SystemException {
		return findByMiddleName(middleName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByMiddleName(String middleName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MIDDLENAME;
			finderArgs = new Object[] { middleName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MIDDLENAME;
			finderArgs = new Object[] { middleName, start, end, orderByComparator };
		}

		List<Creator> list = (List<Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Creator creator : list) {
				if (!Validator.equals(middleName, creator.getMiddleName())) {
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

			query.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindMiddleName = false;

			if (middleName == null) {
				query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_1);
			}
			else if (middleName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3);
			}
			else {
				bindMiddleName = true;

				query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMiddleName) {
					qPos.add(middleName);
				}

				if (!pagination) {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Creator>(list);
				}
				else {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator findByMiddleName_First(String middleName,
		OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = fetchByMiddleName_First(middleName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("middleName=");
		msg.append(middleName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the first creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator fetchByMiddleName_First(String middleName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Creator> list = findByMiddleName(middleName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator findByMiddleName_Last(String middleName,
		OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = fetchByMiddleName_Last(middleName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("middleName=");
		msg.append(middleName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the last creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator fetchByMiddleName_Last(String middleName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMiddleName(middleName);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByMiddleName(middleName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where middleName = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator[] findByMiddleName_PrevAndNext(long creatorId,
		String middleName, OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByMiddleName_PrevAndNext(session, creator,
					middleName, orderByComparator, true);

			array[1] = creator;

			array[2] = getByMiddleName_PrevAndNext(session, creator,
					middleName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Creator getByMiddleName_PrevAndNext(Session session,
		Creator creator, String middleName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindMiddleName = false;

		if (middleName == null) {
			query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_1);
		}
		else if (middleName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3);
		}
		else {
			bindMiddleName = true;

			query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2);
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
			query.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindMiddleName) {
			qPos.add(middleName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where middleName = &#63; from the database.
	 *
	 * @param middleName the middle name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMiddleName(String middleName) throws SystemException {
		for (Creator creator : findByMiddleName(middleName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the number of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMiddleName(String middleName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MIDDLENAME;

		Object[] finderArgs = new Object[] { middleName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindMiddleName = false;

			if (middleName == null) {
				query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_1);
			}
			else if (middleName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3);
			}
			else {
				bindMiddleName = true;

				query.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMiddleName) {
					qPos.add(middleName);
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

	private static final String _FINDER_COLUMN_MIDDLENAME_MIDDLENAME_1 = "creator.middleName IS NULL";
	private static final String _FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2 = "creator.middleName = ?";
	private static final String _FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3 = "(creator.middleName IS NULL OR creator.middleName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FULLNAME = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFullName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FULLNAME =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFullName",
			new String[] { String.class.getName() },
			CreatorModelImpl.FULLNAME_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FULLNAME = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFullName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the creators where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByFullName(String fullName)
		throws SystemException {
		return findByFullName(fullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the creators where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByFullName(String fullName, int start, int end)
		throws SystemException {
		return findByFullName(fullName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByFullName(String fullName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FULLNAME;
			finderArgs = new Object[] { fullName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FULLNAME;
			finderArgs = new Object[] { fullName, start, end, orderByComparator };
		}

		List<Creator> list = (List<Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Creator creator : list) {
				if (!Validator.equals(fullName, creator.getFullName())) {
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

			query.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindFullName = false;

			if (fullName == null) {
				query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_1);
			}
			else if (fullName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFullName) {
					qPos.add(fullName);
				}

				if (!pagination) {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Creator>(list);
				}
				else {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator findByFullName_First(String fullName,
		OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = fetchByFullName_First(fullName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fullName=");
		msg.append(fullName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the first creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator fetchByFullName_First(String fullName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Creator> list = findByFullName(fullName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator findByFullName_Last(String fullName,
		OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = fetchByFullName_Last(fullName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fullName=");
		msg.append(fullName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the last creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator fetchByFullName_Last(String fullName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFullName(fullName);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByFullName(fullName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where fullName = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator[] findByFullName_PrevAndNext(long creatorId,
		String fullName, OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByFullName_PrevAndNext(session, creator, fullName,
					orderByComparator, true);

			array[1] = creator;

			array[2] = getByFullName_PrevAndNext(session, creator, fullName,
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

	protected Creator getByFullName_PrevAndNext(Session session,
		Creator creator, String fullName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_2);
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
			query.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFullName) {
			qPos.add(fullName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where fullName = &#63; from the database.
	 *
	 * @param fullName the full name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFullName(String fullName) throws SystemException {
		for (Creator creator : findByFullName(fullName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the number of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFullName(String fullName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FULLNAME;

		Object[] finderArgs = new Object[] { fullName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindFullName = false;

			if (fullName == null) {
				query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_1);
			}
			else if (fullName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_FULLNAME_FULLNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFullName) {
					qPos.add(fullName);
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

	private static final String _FINDER_COLUMN_FULLNAME_FULLNAME_1 = "creator.fullName IS NULL";
	private static final String _FINDER_COLUMN_FULLNAME_FULLNAME_2 = "creator.fullName = ?";
	private static final String _FINDER_COLUMN_FULLNAME_FULLNAME_3 = "(creator.fullName IS NULL OR creator.fullName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AFFILIATION =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAffiliation",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AFFILIATION =
		new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAffiliation",
			new String[] { String.class.getName() },
			CreatorModelImpl.AFFILIATION_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AFFILIATION = new FinderPath(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAffiliation",
			new String[] { String.class.getName() });

	/**
	 * Returns all the creators where affiliation = &#63;.
	 *
	 * @param affiliation the affiliation
	 * @return the matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByAffiliation(String affiliation)
		throws SystemException {
		return findByAffiliation(affiliation, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the creators where affiliation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param affiliation the affiliation
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByAffiliation(String affiliation, int start,
		int end) throws SystemException {
		return findByAffiliation(affiliation, start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators where affiliation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param affiliation the affiliation
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findByAffiliation(String affiliation, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AFFILIATION;
			finderArgs = new Object[] { affiliation };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AFFILIATION;
			finderArgs = new Object[] { affiliation, start, end, orderByComparator };
		}

		List<Creator> list = (List<Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Creator creator : list) {
				if (!Validator.equals(affiliation, creator.getAffiliation())) {
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

			query.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindAffiliation = false;

			if (affiliation == null) {
				query.append(_FINDER_COLUMN_AFFILIATION_AFFILIATION_1);
			}
			else if (affiliation.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AFFILIATION_AFFILIATION_3);
			}
			else {
				bindAffiliation = true;

				query.append(_FINDER_COLUMN_AFFILIATION_AFFILIATION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAffiliation) {
					qPos.add(affiliation);
				}

				if (!pagination) {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Creator>(list);
				}
				else {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first creator in the ordered set where affiliation = &#63;.
	 *
	 * @param affiliation the affiliation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator findByAffiliation_First(String affiliation,
		OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = fetchByAffiliation_First(affiliation,
				orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("affiliation=");
		msg.append(affiliation);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the first creator in the ordered set where affiliation = &#63;.
	 *
	 * @param affiliation the affiliation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator fetchByAffiliation_First(String affiliation,
		OrderByComparator orderByComparator) throws SystemException {
		List<Creator> list = findByAffiliation(affiliation, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where affiliation = &#63;.
	 *
	 * @param affiliation the affiliation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator findByAffiliation_Last(String affiliation,
		OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = fetchByAffiliation_Last(affiliation, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("affiliation=");
		msg.append(affiliation);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreatorException(msg.toString());
	}

	/**
	 * Returns the last creator in the ordered set where affiliation = &#63;.
	 *
	 * @param affiliation the affiliation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator fetchByAffiliation_Last(String affiliation,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAffiliation(affiliation);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByAffiliation(affiliation, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where affiliation = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param affiliation the affiliation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator[] findByAffiliation_PrevAndNext(long creatorId,
		String affiliation, OrderByComparator orderByComparator)
		throws NoSuchCreatorException, SystemException {
		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByAffiliation_PrevAndNext(session, creator,
					affiliation, orderByComparator, true);

			array[1] = creator;

			array[2] = getByAffiliation_PrevAndNext(session, creator,
					affiliation, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Creator getByAffiliation_PrevAndNext(Session session,
		Creator creator, String affiliation,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindAffiliation = false;

		if (affiliation == null) {
			query.append(_FINDER_COLUMN_AFFILIATION_AFFILIATION_1);
		}
		else if (affiliation.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_AFFILIATION_AFFILIATION_3);
		}
		else {
			bindAffiliation = true;

			query.append(_FINDER_COLUMN_AFFILIATION_AFFILIATION_2);
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
			query.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAffiliation) {
			qPos.add(affiliation);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where affiliation = &#63; from the database.
	 *
	 * @param affiliation the affiliation
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAffiliation(String affiliation)
		throws SystemException {
		for (Creator creator : findByAffiliation(affiliation,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where affiliation = &#63;.
	 *
	 * @param affiliation the affiliation
	 * @return the number of matching creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAffiliation(String affiliation) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AFFILIATION;

		Object[] finderArgs = new Object[] { affiliation };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindAffiliation = false;

			if (affiliation == null) {
				query.append(_FINDER_COLUMN_AFFILIATION_AFFILIATION_1);
			}
			else if (affiliation.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AFFILIATION_AFFILIATION_3);
			}
			else {
				bindAffiliation = true;

				query.append(_FINDER_COLUMN_AFFILIATION_AFFILIATION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAffiliation) {
					qPos.add(affiliation);
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

	private static final String _FINDER_COLUMN_AFFILIATION_AFFILIATION_1 = "creator.affiliation IS NULL";
	private static final String _FINDER_COLUMN_AFFILIATION_AFFILIATION_2 = "creator.affiliation = ?";
	private static final String _FINDER_COLUMN_AFFILIATION_AFFILIATION_3 = "(creator.affiliation IS NULL OR creator.affiliation = '')";

	public CreatorPersistenceImpl() {
		setModelClass(Creator.class);
	}

	/**
	 * Caches the creator in the entity cache if it is enabled.
	 *
	 * @param creator the creator
	 */
	@Override
	public void cacheResult(Creator creator) {
		EntityCacheUtil.putResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorImpl.class, creator.getPrimaryKey(), creator);

		creator.resetOriginalValues();
	}

	/**
	 * Caches the creators in the entity cache if it is enabled.
	 *
	 * @param creators the creators
	 */
	@Override
	public void cacheResult(List<Creator> creators) {
		for (Creator creator : creators) {
			if (EntityCacheUtil.getResult(
						CreatorModelImpl.ENTITY_CACHE_ENABLED,
						CreatorImpl.class, creator.getPrimaryKey()) == null) {
				cacheResult(creator);
			}
			else {
				creator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all creators.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CreatorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CreatorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the creator.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Creator creator) {
		EntityCacheUtil.removeResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorImpl.class, creator.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Creator> creators) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Creator creator : creators) {
			EntityCacheUtil.removeResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
				CreatorImpl.class, creator.getPrimaryKey());
		}
	}

	/**
	 * Creates a new creator with the primary key. Does not add the creator to the database.
	 *
	 * @param creatorId the primary key for the new creator
	 * @return the new creator
	 */
	@Override
	public Creator create(long creatorId) {
		Creator creator = new CreatorImpl();

		creator.setNew(true);
		creator.setPrimaryKey(creatorId);

		return creator;
	}

	/**
	 * Removes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator remove(long creatorId)
		throws NoSuchCreatorException, SystemException {
		return remove((Serializable)creatorId);
	}

	/**
	 * Removes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the creator
	 * @return the creator that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator remove(Serializable primaryKey)
		throws NoSuchCreatorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Creator creator = (Creator)session.get(CreatorImpl.class, primaryKey);

			if (creator == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCreatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(creator);
		}
		catch (NoSuchCreatorException nsee) {
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
	protected Creator removeImpl(Creator creator) throws SystemException {
		creator = toUnwrappedModel(creator);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(creator)) {
				creator = (Creator)session.get(CreatorImpl.class,
						creator.getPrimaryKeyObj());
			}

			if (creator != null) {
				session.delete(creator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (creator != null) {
			clearCache(creator);
		}

		return creator;
	}

	@Override
	public Creator updateImpl(de.uhh.l2g.plugins.model.Creator creator)
		throws SystemException {
		creator = toUnwrappedModel(creator);

		boolean isNew = creator.isNew();

		CreatorModelImpl creatorModelImpl = (CreatorModelImpl)creator;

		Session session = null;

		try {
			session = openSession();

			if (creator.isNew()) {
				session.save(creator);

				creator.setNew(false);
			}
			else {
				session.merge(creator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CreatorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((creatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creatorModelImpl.getOriginalFirstName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME,
					args);

				args = new Object[] { creatorModelImpl.getFirstName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME,
					args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creatorModelImpl.getOriginalLastName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LASTNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME,
					args);

				args = new Object[] { creatorModelImpl.getLastName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LASTNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME,
					args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MIDDLENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creatorModelImpl.getOriginalMiddleName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MIDDLENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MIDDLENAME,
					args);

				args = new Object[] { creatorModelImpl.getMiddleName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MIDDLENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MIDDLENAME,
					args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FULLNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creatorModelImpl.getOriginalFullName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FULLNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FULLNAME,
					args);

				args = new Object[] { creatorModelImpl.getFullName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FULLNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FULLNAME,
					args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AFFILIATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creatorModelImpl.getOriginalAffiliation()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AFFILIATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AFFILIATION,
					args);

				args = new Object[] { creatorModelImpl.getAffiliation() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AFFILIATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AFFILIATION,
					args);
			}
		}

		EntityCacheUtil.putResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorImpl.class, creator.getPrimaryKey(), creator);

		return creator;
	}

	protected Creator toUnwrappedModel(Creator creator) {
		if (creator instanceof CreatorImpl) {
			return creator;
		}

		CreatorImpl creatorImpl = new CreatorImpl();

		creatorImpl.setNew(creator.isNew());
		creatorImpl.setPrimaryKey(creator.getPrimaryKey());

		creatorImpl.setCreatorId(creator.getCreatorId());
		creatorImpl.setFirstName(creator.getFirstName());
		creatorImpl.setLastName(creator.getLastName());
		creatorImpl.setMiddleName(creator.getMiddleName());
		creatorImpl.setJobTitle(creator.getJobTitle());
		creatorImpl.setGender(creator.getGender());
		creatorImpl.setFullName(creator.getFullName());
		creatorImpl.setAffiliation(creator.getAffiliation());
		creatorImpl.setOrcidId(creator.getOrcidId());

		return creatorImpl;
	}

	/**
	 * Returns the creator with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the creator
	 * @return the creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCreatorException, SystemException {
		Creator creator = fetchByPrimaryKey(primaryKey);

		if (creator == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCreatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return creator;
	}

	/**
	 * Returns the creator with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchCreatorException} if it could not be found.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator
	 * @throws de.uhh.l2g.plugins.NoSuchCreatorException if a creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator findByPrimaryKey(long creatorId)
		throws NoSuchCreatorException, SystemException {
		return findByPrimaryKey((Serializable)creatorId);
	}

	/**
	 * Returns the creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the creator
	 * @return the creator, or <code>null</code> if a creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Creator creator = (Creator)EntityCacheUtil.getResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
				CreatorImpl.class, primaryKey);

		if (creator == _nullCreator) {
			return null;
		}

		if (creator == null) {
			Session session = null;

			try {
				session = openSession();

				creator = (Creator)session.get(CreatorImpl.class, primaryKey);

				if (creator != null) {
					cacheResult(creator);
				}
				else {
					EntityCacheUtil.putResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
						CreatorImpl.class, primaryKey, _nullCreator);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CreatorModelImpl.ENTITY_CACHE_ENABLED,
					CreatorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return creator;
	}

	/**
	 * Returns the creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator, or <code>null</code> if a creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Creator fetchByPrimaryKey(long creatorId) throws SystemException {
		return fetchByPrimaryKey((Serializable)creatorId);
	}

	/**
	 * Returns all the creators.
	 *
	 * @return the creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Creator> findAll(int start, int end,
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

		List<Creator> list = (List<Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CREATOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CREATOR;

				if (pagination) {
					sql = sql.concat(CreatorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Creator>(list);
				}
				else {
					list = (List<Creator>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the creators from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Creator creator : findAll()) {
			remove(creator);
		}
	}

	/**
	 * Returns the number of creators.
	 *
	 * @return the number of creators
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

				Query q = session.createQuery(_SQL_COUNT_CREATOR);

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
	 * Initializes the creator persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Creator")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Creator>> listenersList = new ArrayList<ModelListener<Creator>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Creator>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CreatorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CREATOR = "SELECT creator FROM Creator creator";
	private static final String _SQL_SELECT_CREATOR_WHERE = "SELECT creator FROM Creator creator WHERE ";
	private static final String _SQL_COUNT_CREATOR = "SELECT COUNT(creator) FROM Creator creator";
	private static final String _SQL_COUNT_CREATOR_WHERE = "SELECT COUNT(creator) FROM Creator creator WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "creator.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Creator exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Creator exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CreatorPersistenceImpl.class);
	private static Creator _nullCreator = new CreatorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Creator> toCacheModel() {
				return _nullCreatorCacheModel;
			}
		};

	private static CacheModel<Creator> _nullCreatorCacheModel = new CacheModel<Creator>() {
			@Override
			public Creator toEntityModel() {
				return _nullCreator;
			}
		};
}