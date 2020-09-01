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

import de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException;
import de.uhh.l2g.plugins.model.OaiRecord_OaiSet;
import de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetImpl;
import de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the oai record_ oai set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecord_OaiSetPersistence
 * @see OaiRecord_OaiSetUtil
 * @generated
 */
public class OaiRecord_OaiSetPersistenceImpl extends BasePersistenceImpl<OaiRecord_OaiSet>
	implements OaiRecord_OaiSetPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OaiRecord_OaiSetUtil} to access the oai record_ oai set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OaiRecord_OaiSetImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OAISET = new FinderPath(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByoaiSet",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OAISET =
		new FinderPath(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByoaiSet",
			new String[] { Long.class.getName() },
			OaiRecord_OaiSetModelImpl.OAISETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OAISET = new FinderPath(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByoaiSet",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @return the matching oai record_ oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiSet(long oaiSetId)
		throws SystemException {
		return findByoaiSet(oaiSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param oaiSetId the oai set ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of matching oai record_ oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiSet(long oaiSetId, int start, int end)
		throws SystemException {
		return findByoaiSet(oaiSetId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param oaiSetId the oai set ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching oai record_ oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiSet(long oaiSetId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OAISET;
			finderArgs = new Object[] { oaiSetId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OAISET;
			finderArgs = new Object[] { oaiSetId, start, end, orderByComparator };
		}

		List<OaiRecord_OaiSet> list = (List<OaiRecord_OaiSet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OaiRecord_OaiSet oaiRecord_OaiSet : list) {
				if ((oaiSetId != oaiRecord_OaiSet.getOaiSetId())) {
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

			query.append(_SQL_SELECT_OAIRECORD_OAISET_WHERE);

			query.append(_FINDER_COLUMN_OAISET_OAISETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OaiRecord_OaiSetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(oaiSetId);

				if (!pagination) {
					list = (List<OaiRecord_OaiSet>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OaiRecord_OaiSet>(list);
				}
				else {
					list = (List<OaiRecord_OaiSet>)QueryUtil.list(q,
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
	 * Returns the first oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet findByoaiSet_First(long oaiSetId,
		OrderByComparator orderByComparator)
		throws NoSuchOaiRecord_OaiSetException, SystemException {
		OaiRecord_OaiSet oaiRecord_OaiSet = fetchByoaiSet_First(oaiSetId,
				orderByComparator);

		if (oaiRecord_OaiSet != null) {
			return oaiRecord_OaiSet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("oaiSetId=");
		msg.append(oaiSetId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOaiRecord_OaiSetException(msg.toString());
	}

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet fetchByoaiSet_First(long oaiSetId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OaiRecord_OaiSet> list = findByoaiSet(oaiSetId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet findByoaiSet_Last(long oaiSetId,
		OrderByComparator orderByComparator)
		throws NoSuchOaiRecord_OaiSetException, SystemException {
		OaiRecord_OaiSet oaiRecord_OaiSet = fetchByoaiSet_Last(oaiSetId,
				orderByComparator);

		if (oaiRecord_OaiSet != null) {
			return oaiRecord_OaiSet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("oaiSetId=");
		msg.append(oaiSetId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOaiRecord_OaiSetException(msg.toString());
	}

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet fetchByoaiSet_Last(long oaiSetId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByoaiSet(oaiSetId);

		if (count == 0) {
			return null;
		}

		List<OaiRecord_OaiSet> list = findByoaiSet(oaiSetId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the oai record_ oai sets before and after the current oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiRecordOaiSetId the primary key of the current oai record_ oai set
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next oai record_ oai set
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet[] findByoaiSet_PrevAndNext(long oaiRecordOaiSetId,
		long oaiSetId, OrderByComparator orderByComparator)
		throws NoSuchOaiRecord_OaiSetException, SystemException {
		OaiRecord_OaiSet oaiRecord_OaiSet = findByPrimaryKey(oaiRecordOaiSetId);

		Session session = null;

		try {
			session = openSession();

			OaiRecord_OaiSet[] array = new OaiRecord_OaiSetImpl[3];

			array[0] = getByoaiSet_PrevAndNext(session, oaiRecord_OaiSet,
					oaiSetId, orderByComparator, true);

			array[1] = oaiRecord_OaiSet;

			array[2] = getByoaiSet_PrevAndNext(session, oaiRecord_OaiSet,
					oaiSetId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OaiRecord_OaiSet getByoaiSet_PrevAndNext(Session session,
		OaiRecord_OaiSet oaiRecord_OaiSet, long oaiSetId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OAIRECORD_OAISET_WHERE);

		query.append(_FINDER_COLUMN_OAISET_OAISETID_2);

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
			query.append(OaiRecord_OaiSetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(oaiSetId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oaiRecord_OaiSet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OaiRecord_OaiSet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the oai record_ oai sets where oaiSetId = &#63; from the database.
	 *
	 * @param oaiSetId the oai set ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByoaiSet(long oaiSetId) throws SystemException {
		for (OaiRecord_OaiSet oaiRecord_OaiSet : findByoaiSet(oaiSetId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(oaiRecord_OaiSet);
		}
	}

	/**
	 * Returns the number of oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @return the number of matching oai record_ oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByoaiSet(long oaiSetId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OAISET;

		Object[] finderArgs = new Object[] { oaiSetId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OAIRECORD_OAISET_WHERE);

			query.append(_FINDER_COLUMN_OAISET_OAISETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(oaiSetId);

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

	private static final String _FINDER_COLUMN_OAISET_OAISETID_2 = "oaiRecord_OaiSet.oaiSetId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OAIRECORD =
		new FinderPath(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByoaiRecord",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OAIRECORD =
		new FinderPath(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByoaiRecord",
			new String[] { Long.class.getName() },
			OaiRecord_OaiSetModelImpl.OAIRECORDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OAIRECORD = new FinderPath(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByoaiRecord",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @return the matching oai record_ oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiRecord(long oaiRecordId)
		throws SystemException {
		return findByoaiRecord(oaiRecordId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param oaiRecordId the oai record ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of matching oai record_ oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiRecord(long oaiRecordId, int start,
		int end) throws SystemException {
		return findByoaiRecord(oaiRecordId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param oaiRecordId the oai record ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching oai record_ oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiRecord(long oaiRecordId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OAIRECORD;
			finderArgs = new Object[] { oaiRecordId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OAIRECORD;
			finderArgs = new Object[] { oaiRecordId, start, end, orderByComparator };
		}

		List<OaiRecord_OaiSet> list = (List<OaiRecord_OaiSet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OaiRecord_OaiSet oaiRecord_OaiSet : list) {
				if ((oaiRecordId != oaiRecord_OaiSet.getOaiRecordId())) {
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

			query.append(_SQL_SELECT_OAIRECORD_OAISET_WHERE);

			query.append(_FINDER_COLUMN_OAIRECORD_OAIRECORDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OaiRecord_OaiSetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(oaiRecordId);

				if (!pagination) {
					list = (List<OaiRecord_OaiSet>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OaiRecord_OaiSet>(list);
				}
				else {
					list = (List<OaiRecord_OaiSet>)QueryUtil.list(q,
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
	 * Returns the first oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet findByoaiRecord_First(long oaiRecordId,
		OrderByComparator orderByComparator)
		throws NoSuchOaiRecord_OaiSetException, SystemException {
		OaiRecord_OaiSet oaiRecord_OaiSet = fetchByoaiRecord_First(oaiRecordId,
				orderByComparator);

		if (oaiRecord_OaiSet != null) {
			return oaiRecord_OaiSet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("oaiRecordId=");
		msg.append(oaiRecordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOaiRecord_OaiSetException(msg.toString());
	}

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet fetchByoaiRecord_First(long oaiRecordId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OaiRecord_OaiSet> list = findByoaiRecord(oaiRecordId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet findByoaiRecord_Last(long oaiRecordId,
		OrderByComparator orderByComparator)
		throws NoSuchOaiRecord_OaiSetException, SystemException {
		OaiRecord_OaiSet oaiRecord_OaiSet = fetchByoaiRecord_Last(oaiRecordId,
				orderByComparator);

		if (oaiRecord_OaiSet != null) {
			return oaiRecord_OaiSet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("oaiRecordId=");
		msg.append(oaiRecordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOaiRecord_OaiSetException(msg.toString());
	}

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet fetchByoaiRecord_Last(long oaiRecordId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByoaiRecord(oaiRecordId);

		if (count == 0) {
			return null;
		}

		List<OaiRecord_OaiSet> list = findByoaiRecord(oaiRecordId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the oai record_ oai sets before and after the current oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordOaiSetId the primary key of the current oai record_ oai set
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next oai record_ oai set
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet[] findByoaiRecord_PrevAndNext(
		long oaiRecordOaiSetId, long oaiRecordId,
		OrderByComparator orderByComparator)
		throws NoSuchOaiRecord_OaiSetException, SystemException {
		OaiRecord_OaiSet oaiRecord_OaiSet = findByPrimaryKey(oaiRecordOaiSetId);

		Session session = null;

		try {
			session = openSession();

			OaiRecord_OaiSet[] array = new OaiRecord_OaiSetImpl[3];

			array[0] = getByoaiRecord_PrevAndNext(session, oaiRecord_OaiSet,
					oaiRecordId, orderByComparator, true);

			array[1] = oaiRecord_OaiSet;

			array[2] = getByoaiRecord_PrevAndNext(session, oaiRecord_OaiSet,
					oaiRecordId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OaiRecord_OaiSet getByoaiRecord_PrevAndNext(Session session,
		OaiRecord_OaiSet oaiRecord_OaiSet, long oaiRecordId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OAIRECORD_OAISET_WHERE);

		query.append(_FINDER_COLUMN_OAIRECORD_OAIRECORDID_2);

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
			query.append(OaiRecord_OaiSetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(oaiRecordId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oaiRecord_OaiSet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OaiRecord_OaiSet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the oai record_ oai sets where oaiRecordId = &#63; from the database.
	 *
	 * @param oaiRecordId the oai record ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByoaiRecord(long oaiRecordId) throws SystemException {
		for (OaiRecord_OaiSet oaiRecord_OaiSet : findByoaiRecord(oaiRecordId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(oaiRecord_OaiSet);
		}
	}

	/**
	 * Returns the number of oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @return the number of matching oai record_ oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByoaiRecord(long oaiRecordId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OAIRECORD;

		Object[] finderArgs = new Object[] { oaiRecordId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OAIRECORD_OAISET_WHERE);

			query.append(_FINDER_COLUMN_OAIRECORD_OAIRECORDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(oaiRecordId);

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

	private static final String _FINDER_COLUMN_OAIRECORD_OAIRECORDID_2 = "oaiRecord_OaiSet.oaiRecordId = ?";

	public OaiRecord_OaiSetPersistenceImpl() {
		setModelClass(OaiRecord_OaiSet.class);
	}

	/**
	 * Caches the oai record_ oai set in the entity cache if it is enabled.
	 *
	 * @param oaiRecord_OaiSet the oai record_ oai set
	 */
	@Override
	public void cacheResult(OaiRecord_OaiSet oaiRecord_OaiSet) {
		EntityCacheUtil.putResult(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class, oaiRecord_OaiSet.getPrimaryKey(),
			oaiRecord_OaiSet);

		oaiRecord_OaiSet.resetOriginalValues();
	}

	/**
	 * Caches the oai record_ oai sets in the entity cache if it is enabled.
	 *
	 * @param oaiRecord_OaiSets the oai record_ oai sets
	 */
	@Override
	public void cacheResult(List<OaiRecord_OaiSet> oaiRecord_OaiSets) {
		for (OaiRecord_OaiSet oaiRecord_OaiSet : oaiRecord_OaiSets) {
			if (EntityCacheUtil.getResult(
						OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
						OaiRecord_OaiSetImpl.class,
						oaiRecord_OaiSet.getPrimaryKey()) == null) {
				cacheResult(oaiRecord_OaiSet);
			}
			else {
				oaiRecord_OaiSet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all oai record_ oai sets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OaiRecord_OaiSetImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OaiRecord_OaiSetImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the oai record_ oai set.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OaiRecord_OaiSet oaiRecord_OaiSet) {
		EntityCacheUtil.removeResult(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class, oaiRecord_OaiSet.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OaiRecord_OaiSet> oaiRecord_OaiSets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OaiRecord_OaiSet oaiRecord_OaiSet : oaiRecord_OaiSets) {
			EntityCacheUtil.removeResult(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
				OaiRecord_OaiSetImpl.class, oaiRecord_OaiSet.getPrimaryKey());
		}
	}

	/**
	 * Creates a new oai record_ oai set with the primary key. Does not add the oai record_ oai set to the database.
	 *
	 * @param oaiRecordOaiSetId the primary key for the new oai record_ oai set
	 * @return the new oai record_ oai set
	 */
	@Override
	public OaiRecord_OaiSet create(long oaiRecordOaiSetId) {
		OaiRecord_OaiSet oaiRecord_OaiSet = new OaiRecord_OaiSetImpl();

		oaiRecord_OaiSet.setNew(true);
		oaiRecord_OaiSet.setPrimaryKey(oaiRecordOaiSetId);

		return oaiRecord_OaiSet;
	}

	/**
	 * Removes the oai record_ oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet remove(long oaiRecordOaiSetId)
		throws NoSuchOaiRecord_OaiSetException, SystemException {
		return remove((Serializable)oaiRecordOaiSetId);
	}

	/**
	 * Removes the oai record_ oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the oai record_ oai set
	 * @return the oai record_ oai set that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet remove(Serializable primaryKey)
		throws NoSuchOaiRecord_OaiSetException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OaiRecord_OaiSet oaiRecord_OaiSet = (OaiRecord_OaiSet)session.get(OaiRecord_OaiSetImpl.class,
					primaryKey);

			if (oaiRecord_OaiSet == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOaiRecord_OaiSetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(oaiRecord_OaiSet);
		}
		catch (NoSuchOaiRecord_OaiSetException nsee) {
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
	protected OaiRecord_OaiSet removeImpl(OaiRecord_OaiSet oaiRecord_OaiSet)
		throws SystemException {
		oaiRecord_OaiSet = toUnwrappedModel(oaiRecord_OaiSet);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(oaiRecord_OaiSet)) {
				oaiRecord_OaiSet = (OaiRecord_OaiSet)session.get(OaiRecord_OaiSetImpl.class,
						oaiRecord_OaiSet.getPrimaryKeyObj());
			}

			if (oaiRecord_OaiSet != null) {
				session.delete(oaiRecord_OaiSet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (oaiRecord_OaiSet != null) {
			clearCache(oaiRecord_OaiSet);
		}

		return oaiRecord_OaiSet;
	}

	@Override
	public OaiRecord_OaiSet updateImpl(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet)
		throws SystemException {
		oaiRecord_OaiSet = toUnwrappedModel(oaiRecord_OaiSet);

		boolean isNew = oaiRecord_OaiSet.isNew();

		OaiRecord_OaiSetModelImpl oaiRecord_OaiSetModelImpl = (OaiRecord_OaiSetModelImpl)oaiRecord_OaiSet;

		Session session = null;

		try {
			session = openSession();

			if (oaiRecord_OaiSet.isNew()) {
				session.save(oaiRecord_OaiSet);

				oaiRecord_OaiSet.setNew(false);
			}
			else {
				session.merge(oaiRecord_OaiSet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OaiRecord_OaiSetModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((oaiRecord_OaiSetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OAISET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						oaiRecord_OaiSetModelImpl.getOriginalOaiSetId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OAISET, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OAISET,
					args);

				args = new Object[] { oaiRecord_OaiSetModelImpl.getOaiSetId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OAISET, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OAISET,
					args);
			}

			if ((oaiRecord_OaiSetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OAIRECORD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						oaiRecord_OaiSetModelImpl.getOriginalOaiRecordId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OAIRECORD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OAIRECORD,
					args);

				args = new Object[] { oaiRecord_OaiSetModelImpl.getOaiRecordId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OAIRECORD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OAIRECORD,
					args);
			}
		}

		EntityCacheUtil.putResult(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class, oaiRecord_OaiSet.getPrimaryKey(),
			oaiRecord_OaiSet);

		return oaiRecord_OaiSet;
	}

	protected OaiRecord_OaiSet toUnwrappedModel(
		OaiRecord_OaiSet oaiRecord_OaiSet) {
		if (oaiRecord_OaiSet instanceof OaiRecord_OaiSetImpl) {
			return oaiRecord_OaiSet;
		}

		OaiRecord_OaiSetImpl oaiRecord_OaiSetImpl = new OaiRecord_OaiSetImpl();

		oaiRecord_OaiSetImpl.setNew(oaiRecord_OaiSet.isNew());
		oaiRecord_OaiSetImpl.setPrimaryKey(oaiRecord_OaiSet.getPrimaryKey());

		oaiRecord_OaiSetImpl.setOaiRecordOaiSetId(oaiRecord_OaiSet.getOaiRecordOaiSetId());
		oaiRecord_OaiSetImpl.setOaiRecordId(oaiRecord_OaiSet.getOaiRecordId());
		oaiRecord_OaiSetImpl.setOaiSetId(oaiRecord_OaiSet.getOaiSetId());

		return oaiRecord_OaiSetImpl;
	}

	/**
	 * Returns the oai record_ oai set with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the oai record_ oai set
	 * @return the oai record_ oai set
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOaiRecord_OaiSetException, SystemException {
		OaiRecord_OaiSet oaiRecord_OaiSet = fetchByPrimaryKey(primaryKey);

		if (oaiRecord_OaiSet == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOaiRecord_OaiSetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return oaiRecord_OaiSet;
	}

	/**
	 * Returns the oai record_ oai set with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException} if it could not be found.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet findByPrimaryKey(long oaiRecordOaiSetId)
		throws NoSuchOaiRecord_OaiSetException, SystemException {
		return findByPrimaryKey((Serializable)oaiRecordOaiSetId);
	}

	/**
	 * Returns the oai record_ oai set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the oai record_ oai set
	 * @return the oai record_ oai set, or <code>null</code> if a oai record_ oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OaiRecord_OaiSet oaiRecord_OaiSet = (OaiRecord_OaiSet)EntityCacheUtil.getResult(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
				OaiRecord_OaiSetImpl.class, primaryKey);

		if (oaiRecord_OaiSet == _nullOaiRecord_OaiSet) {
			return null;
		}

		if (oaiRecord_OaiSet == null) {
			Session session = null;

			try {
				session = openSession();

				oaiRecord_OaiSet = (OaiRecord_OaiSet)session.get(OaiRecord_OaiSetImpl.class,
						primaryKey);

				if (oaiRecord_OaiSet != null) {
					cacheResult(oaiRecord_OaiSet);
				}
				else {
					EntityCacheUtil.putResult(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
						OaiRecord_OaiSetImpl.class, primaryKey,
						_nullOaiRecord_OaiSet);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
					OaiRecord_OaiSetImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return oaiRecord_OaiSet;
	}

	/**
	 * Returns the oai record_ oai set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set, or <code>null</code> if a oai record_ oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord_OaiSet fetchByPrimaryKey(long oaiRecordOaiSetId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)oaiRecordOaiSetId);
	}

	/**
	 * Returns all the oai record_ oai sets.
	 *
	 * @return the oai record_ oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiRecord_OaiSet> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the oai record_ oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of oai record_ oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiRecord_OaiSet> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oai record_ oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiRecord_OaiSet> findAll(int start, int end,
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

		List<OaiRecord_OaiSet> list = (List<OaiRecord_OaiSet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OAIRECORD_OAISET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OAIRECORD_OAISET;

				if (pagination) {
					sql = sql.concat(OaiRecord_OaiSetModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OaiRecord_OaiSet>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OaiRecord_OaiSet>(list);
				}
				else {
					list = (List<OaiRecord_OaiSet>)QueryUtil.list(q,
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
	 * Removes all the oai record_ oai sets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OaiRecord_OaiSet oaiRecord_OaiSet : findAll()) {
			remove(oaiRecord_OaiSet);
		}
	}

	/**
	 * Returns the number of oai record_ oai sets.
	 *
	 * @return the number of oai record_ oai sets
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

				Query q = session.createQuery(_SQL_COUNT_OAIRECORD_OAISET);

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
	 * Initializes the oai record_ oai set persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.OaiRecord_OaiSet")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OaiRecord_OaiSet>> listenersList = new ArrayList<ModelListener<OaiRecord_OaiSet>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OaiRecord_OaiSet>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OaiRecord_OaiSetImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OAIRECORD_OAISET = "SELECT oaiRecord_OaiSet FROM OaiRecord_OaiSet oaiRecord_OaiSet";
	private static final String _SQL_SELECT_OAIRECORD_OAISET_WHERE = "SELECT oaiRecord_OaiSet FROM OaiRecord_OaiSet oaiRecord_OaiSet WHERE ";
	private static final String _SQL_COUNT_OAIRECORD_OAISET = "SELECT COUNT(oaiRecord_OaiSet) FROM OaiRecord_OaiSet oaiRecord_OaiSet";
	private static final String _SQL_COUNT_OAIRECORD_OAISET_WHERE = "SELECT COUNT(oaiRecord_OaiSet) FROM OaiRecord_OaiSet oaiRecord_OaiSet WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "oaiRecord_OaiSet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OaiRecord_OaiSet exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OaiRecord_OaiSet exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OaiRecord_OaiSetPersistenceImpl.class);
	private static OaiRecord_OaiSet _nullOaiRecord_OaiSet = new OaiRecord_OaiSetImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OaiRecord_OaiSet> toCacheModel() {
				return _nullOaiRecord_OaiSetCacheModel;
			}
		};

	private static CacheModel<OaiRecord_OaiSet> _nullOaiRecord_OaiSetCacheModel = new CacheModel<OaiRecord_OaiSet>() {
			@Override
			public OaiRecord_OaiSet toEntityModel() {
				return _nullOaiRecord_OaiSet;
			}
		};
}
