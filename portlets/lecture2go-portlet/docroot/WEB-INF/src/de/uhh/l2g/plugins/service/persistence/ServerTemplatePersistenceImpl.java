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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchServerTemplateException;
import de.uhh.l2g.plugins.model.ServerTemplate;
import de.uhh.l2g.plugins.model.impl.ServerTemplateImpl;
import de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the server template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ServerTemplatePersistence
 * @see ServerTemplateUtil
 * @generated
 */
public class ServerTemplatePersistenceImpl extends BasePersistenceImpl<ServerTemplate>
	implements ServerTemplatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServerTemplateUtil} to access the server template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServerTemplateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServerTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServerTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServerTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServerTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ServerTemplateModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the server templates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServerTemplate> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the server templates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of server templates
	 * @param end the upper bound of the range of server templates (not inclusive)
	 * @return the range of matching server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServerTemplate> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the server templates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of server templates
	 * @param end the upper bound of the range of server templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServerTemplate> findByGroupId(long groupId, int start, int end,
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

		List<ServerTemplate> list = (List<ServerTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServerTemplate serverTemplate : list) {
				if ((groupId != serverTemplate.getGroupId())) {
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

			query.append(_SQL_SELECT_SERVERTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServerTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ServerTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServerTemplate>(list);
				}
				else {
					list = (List<ServerTemplate>)QueryUtil.list(q,
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
	 * Returns the first server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server template
	 * @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a matching server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchServerTemplateException, SystemException {
		ServerTemplate serverTemplate = fetchByGroupId_First(groupId,
				orderByComparator);

		if (serverTemplate != null) {
			return serverTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServerTemplateException(msg.toString());
	}

	/**
	 * Returns the first server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server template, or <code>null</code> if a matching server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ServerTemplate> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server template
	 * @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a matching server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchServerTemplateException, SystemException {
		ServerTemplate serverTemplate = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (serverTemplate != null) {
			return serverTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServerTemplateException(msg.toString());
	}

	/**
	 * Returns the last server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server template, or <code>null</code> if a matching server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ServerTemplate> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the server templates before and after the current server template in the ordered set where groupId = &#63;.
	 *
	 * @param serverTemplateId the primary key of the current server template
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next server template
	 * @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate[] findByGroupId_PrevAndNext(long serverTemplateId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchServerTemplateException, SystemException {
		ServerTemplate serverTemplate = findByPrimaryKey(serverTemplateId);

		Session session = null;

		try {
			session = openSession();

			ServerTemplate[] array = new ServerTemplateImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, serverTemplate,
					groupId, orderByComparator, true);

			array[1] = serverTemplate;

			array[2] = getByGroupId_PrevAndNext(session, serverTemplate,
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

	protected ServerTemplate getByGroupId_PrevAndNext(Session session,
		ServerTemplate serverTemplate, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVERTEMPLATE_WHERE);

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
			query.append(ServerTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serverTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServerTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the server templates where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ServerTemplate serverTemplate : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serverTemplate);
		}
	}

	/**
	 * Returns the number of server templates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching server templates
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

			query.append(_SQL_COUNT_SERVERTEMPLATE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "serverTemplate.groupId = ? AND serverTemplate.type < 1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVICESPECIFICURLS =
		new FinderPath(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServerTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDeviceSpecificURLs",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICESPECIFICURLS =
		new FinderPath(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServerTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDeviceSpecificURLs", new String[] { Long.class.getName() },
			ServerTemplateModelImpl.SERVERTEMPLATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEVICESPECIFICURLS = new FinderPath(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDeviceSpecificURLs", new String[] { Long.class.getName() });

	/**
	 * Returns all the server templates where serverTemplateId = &#63;.
	 *
	 * @param serverTemplateId the server template ID
	 * @return the matching server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServerTemplate> findByDeviceSpecificURLs(long serverTemplateId)
		throws SystemException {
		return findByDeviceSpecificURLs(serverTemplateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the server templates where serverTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serverTemplateId the server template ID
	 * @param start the lower bound of the range of server templates
	 * @param end the upper bound of the range of server templates (not inclusive)
	 * @return the range of matching server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServerTemplate> findByDeviceSpecificURLs(
		long serverTemplateId, int start, int end) throws SystemException {
		return findByDeviceSpecificURLs(serverTemplateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the server templates where serverTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serverTemplateId the server template ID
	 * @param start the lower bound of the range of server templates
	 * @param end the upper bound of the range of server templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServerTemplate> findByDeviceSpecificURLs(
		long serverTemplateId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICESPECIFICURLS;
			finderArgs = new Object[] { serverTemplateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVICESPECIFICURLS;
			finderArgs = new Object[] {
					serverTemplateId,
					
					start, end, orderByComparator
				};
		}

		List<ServerTemplate> list = (List<ServerTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServerTemplate serverTemplate : list) {
				if ((serverTemplateId != serverTemplate.getServerTemplateId())) {
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

			query.append(_SQL_SELECT_SERVERTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_DEVICESPECIFICURLS_SERVERTEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServerTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serverTemplateId);

				if (!pagination) {
					list = (List<ServerTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServerTemplate>(list);
				}
				else {
					list = (List<ServerTemplate>)QueryUtil.list(q,
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
	 * Returns the first server template in the ordered set where serverTemplateId = &#63;.
	 *
	 * @param serverTemplateId the server template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server template
	 * @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a matching server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate findByDeviceSpecificURLs_First(
		long serverTemplateId, OrderByComparator orderByComparator)
		throws NoSuchServerTemplateException, SystemException {
		ServerTemplate serverTemplate = fetchByDeviceSpecificURLs_First(serverTemplateId,
				orderByComparator);

		if (serverTemplate != null) {
			return serverTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serverTemplateId=");
		msg.append(serverTemplateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServerTemplateException(msg.toString());
	}

	/**
	 * Returns the first server template in the ordered set where serverTemplateId = &#63;.
	 *
	 * @param serverTemplateId the server template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server template, or <code>null</code> if a matching server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate fetchByDeviceSpecificURLs_First(
		long serverTemplateId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ServerTemplate> list = findByDeviceSpecificURLs(serverTemplateId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last server template in the ordered set where serverTemplateId = &#63;.
	 *
	 * @param serverTemplateId the server template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server template
	 * @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a matching server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate findByDeviceSpecificURLs_Last(long serverTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchServerTemplateException, SystemException {
		ServerTemplate serverTemplate = fetchByDeviceSpecificURLs_Last(serverTemplateId,
				orderByComparator);

		if (serverTemplate != null) {
			return serverTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serverTemplateId=");
		msg.append(serverTemplateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServerTemplateException(msg.toString());
	}

	/**
	 * Returns the last server template in the ordered set where serverTemplateId = &#63;.
	 *
	 * @param serverTemplateId the server template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server template, or <code>null</code> if a matching server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate fetchByDeviceSpecificURLs_Last(
		long serverTemplateId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDeviceSpecificURLs(serverTemplateId);

		if (count == 0) {
			return null;
		}

		List<ServerTemplate> list = findByDeviceSpecificURLs(serverTemplateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the server templates where serverTemplateId = &#63; from the database.
	 *
	 * @param serverTemplateId the server template ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDeviceSpecificURLs(long serverTemplateId)
		throws SystemException {
		for (ServerTemplate serverTemplate : findByDeviceSpecificURLs(
				serverTemplateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serverTemplate);
		}
	}

	/**
	 * Returns the number of server templates where serverTemplateId = &#63;.
	 *
	 * @param serverTemplateId the server template ID
	 * @return the number of matching server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDeviceSpecificURLs(long serverTemplateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEVICESPECIFICURLS;

		Object[] finderArgs = new Object[] { serverTemplateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVERTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_DEVICESPECIFICURLS_SERVERTEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serverTemplateId);

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

	private static final String _FINDER_COLUMN_DEVICESPECIFICURLS_SERVERTEMPLATEID_2 =
		"serverTemplate.serverTemplateId = ? AND serverTemplate.type = 0 AND (serverTemplate.templateIOS > 0 OR serverTemplate.templateAndroid > 0)";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEFAULTSERVER =
		new FinderPath(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServerTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDefaultServer",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTSERVER =
		new FinderPath(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServerTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDefaultServer",
			new String[] { Long.class.getName() },
			ServerTemplateModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEFAULTSERVER = new FinderPath(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDefaultServer",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the server templates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServerTemplate> findByDefaultServer(long groupId)
		throws SystemException {
		return findByDefaultServer(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the server templates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of server templates
	 * @param end the upper bound of the range of server templates (not inclusive)
	 * @return the range of matching server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServerTemplate> findByDefaultServer(long groupId, int start,
		int end) throws SystemException {
		return findByDefaultServer(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the server templates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of server templates
	 * @param end the upper bound of the range of server templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServerTemplate> findByDefaultServer(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTSERVER;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEFAULTSERVER;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ServerTemplate> list = (List<ServerTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServerTemplate serverTemplate : list) {
				if ((groupId != serverTemplate.getGroupId())) {
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

			query.append(_SQL_SELECT_SERVERTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_DEFAULTSERVER_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServerTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ServerTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServerTemplate>(list);
				}
				else {
					list = (List<ServerTemplate>)QueryUtil.list(q,
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
	 * Returns the first server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server template
	 * @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a matching server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate findByDefaultServer_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchServerTemplateException, SystemException {
		ServerTemplate serverTemplate = fetchByDefaultServer_First(groupId,
				orderByComparator);

		if (serverTemplate != null) {
			return serverTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServerTemplateException(msg.toString());
	}

	/**
	 * Returns the first server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server template, or <code>null</code> if a matching server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate fetchByDefaultServer_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ServerTemplate> list = findByDefaultServer(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server template
	 * @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a matching server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate findByDefaultServer_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchServerTemplateException, SystemException {
		ServerTemplate serverTemplate = fetchByDefaultServer_Last(groupId,
				orderByComparator);

		if (serverTemplate != null) {
			return serverTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServerTemplateException(msg.toString());
	}

	/**
	 * Returns the last server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server template, or <code>null</code> if a matching server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate fetchByDefaultServer_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDefaultServer(groupId);

		if (count == 0) {
			return null;
		}

		List<ServerTemplate> list = findByDefaultServer(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the server templates before and after the current server template in the ordered set where groupId = &#63;.
	 *
	 * @param serverTemplateId the primary key of the current server template
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next server template
	 * @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate[] findByDefaultServer_PrevAndNext(
		long serverTemplateId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchServerTemplateException, SystemException {
		ServerTemplate serverTemplate = findByPrimaryKey(serverTemplateId);

		Session session = null;

		try {
			session = openSession();

			ServerTemplate[] array = new ServerTemplateImpl[3];

			array[0] = getByDefaultServer_PrevAndNext(session, serverTemplate,
					groupId, orderByComparator, true);

			array[1] = serverTemplate;

			array[2] = getByDefaultServer_PrevAndNext(session, serverTemplate,
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

	protected ServerTemplate getByDefaultServer_PrevAndNext(Session session,
		ServerTemplate serverTemplate, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVERTEMPLATE_WHERE);

		query.append(_FINDER_COLUMN_DEFAULTSERVER_GROUPID_2);

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
			query.append(ServerTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serverTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServerTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the server templates where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDefaultServer(long groupId) throws SystemException {
		for (ServerTemplate serverTemplate : findByDefaultServer(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serverTemplate);
		}
	}

	/**
	 * Returns the number of server templates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDefaultServer(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEFAULTSERVER;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVERTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_DEFAULTSERVER_GROUPID_2);

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

	private static final String _FINDER_COLUMN_DEFAULTSERVER_GROUPID_2 = "serverTemplate.groupId = ? AND serverTemplate.defaultServer > 0";

	public ServerTemplatePersistenceImpl() {
		setModelClass(ServerTemplate.class);
	}

	/**
	 * Caches the server template in the entity cache if it is enabled.
	 *
	 * @param serverTemplate the server template
	 */
	@Override
	public void cacheResult(ServerTemplate serverTemplate) {
		EntityCacheUtil.putResult(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateImpl.class, serverTemplate.getPrimaryKey(),
			serverTemplate);

		serverTemplate.resetOriginalValues();
	}

	/**
	 * Caches the server templates in the entity cache if it is enabled.
	 *
	 * @param serverTemplates the server templates
	 */
	@Override
	public void cacheResult(List<ServerTemplate> serverTemplates) {
		for (ServerTemplate serverTemplate : serverTemplates) {
			if (EntityCacheUtil.getResult(
						ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
						ServerTemplateImpl.class, serverTemplate.getPrimaryKey()) == null) {
				cacheResult(serverTemplate);
			}
			else {
				serverTemplate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all server templates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ServerTemplateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ServerTemplateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the server template.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServerTemplate serverTemplate) {
		EntityCacheUtil.removeResult(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateImpl.class, serverTemplate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ServerTemplate> serverTemplates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServerTemplate serverTemplate : serverTemplates) {
			EntityCacheUtil.removeResult(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
				ServerTemplateImpl.class, serverTemplate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new server template with the primary key. Does not add the server template to the database.
	 *
	 * @param serverTemplateId the primary key for the new server template
	 * @return the new server template
	 */
	@Override
	public ServerTemplate create(long serverTemplateId) {
		ServerTemplate serverTemplate = new ServerTemplateImpl();

		serverTemplate.setNew(true);
		serverTemplate.setPrimaryKey(serverTemplateId);

		return serverTemplate;
	}

	/**
	 * Removes the server template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serverTemplateId the primary key of the server template
	 * @return the server template that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate remove(long serverTemplateId)
		throws NoSuchServerTemplateException, SystemException {
		return remove((Serializable)serverTemplateId);
	}

	/**
	 * Removes the server template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the server template
	 * @return the server template that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate remove(Serializable primaryKey)
		throws NoSuchServerTemplateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ServerTemplate serverTemplate = (ServerTemplate)session.get(ServerTemplateImpl.class,
					primaryKey);

			if (serverTemplate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServerTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(serverTemplate);
		}
		catch (NoSuchServerTemplateException nsee) {
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
	protected ServerTemplate removeImpl(ServerTemplate serverTemplate)
		throws SystemException {
		serverTemplate = toUnwrappedModel(serverTemplate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serverTemplate)) {
				serverTemplate = (ServerTemplate)session.get(ServerTemplateImpl.class,
						serverTemplate.getPrimaryKeyObj());
			}

			if (serverTemplate != null) {
				session.delete(serverTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (serverTemplate != null) {
			clearCache(serverTemplate);
		}

		return serverTemplate;
	}

	@Override
	public ServerTemplate updateImpl(
		de.uhh.l2g.plugins.model.ServerTemplate serverTemplate)
		throws SystemException {
		serverTemplate = toUnwrappedModel(serverTemplate);

		boolean isNew = serverTemplate.isNew();

		ServerTemplateModelImpl serverTemplateModelImpl = (ServerTemplateModelImpl)serverTemplate;

		Session session = null;

		try {
			session = openSession();

			if (serverTemplate.isNew()) {
				session.save(serverTemplate);

				serverTemplate.setNew(false);
			}
			else {
				session.merge(serverTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServerTemplateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((serverTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serverTemplateModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { serverTemplateModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((serverTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICESPECIFICURLS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serverTemplateModelImpl.getOriginalServerTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVICESPECIFICURLS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICESPECIFICURLS,
					args);

				args = new Object[] {
						serverTemplateModelImpl.getServerTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVICESPECIFICURLS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICESPECIFICURLS,
					args);
			}

			if ((serverTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTSERVER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serverTemplateModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEFAULTSERVER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTSERVER,
					args);

				args = new Object[] { serverTemplateModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEFAULTSERVER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTSERVER,
					args);
			}
		}

		EntityCacheUtil.putResult(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServerTemplateImpl.class, serverTemplate.getPrimaryKey(),
			serverTemplate);

		return serverTemplate;
	}

	protected ServerTemplate toUnwrappedModel(ServerTemplate serverTemplate) {
		if (serverTemplate instanceof ServerTemplateImpl) {
			return serverTemplate;
		}

		ServerTemplateImpl serverTemplateImpl = new ServerTemplateImpl();

		serverTemplateImpl.setNew(serverTemplate.isNew());
		serverTemplateImpl.setPrimaryKey(serverTemplate.getPrimaryKey());

		serverTemplateImpl.setServerTemplateId(serverTemplate.getServerTemplateId());
		serverTemplateImpl.setGroupId(serverTemplate.getGroupId());
		serverTemplateImpl.setName(serverTemplate.getName());
		serverTemplateImpl.setType(serverTemplate.getType());
		serverTemplateImpl.setPrefixURL(serverTemplate.getPrefixURL());
		serverTemplateImpl.setSuffixURL(serverTemplate.getSuffixURL());
		serverTemplateImpl.setSecExt(serverTemplate.getSecExt());
		serverTemplateImpl.setTemplateURL(serverTemplate.getTemplateURL());
		serverTemplateImpl.setPrefixFile(serverTemplate.getPrefixFile());
		serverTemplateImpl.setSuffixFile(serverTemplate.getSuffixFile());
		serverTemplateImpl.setTemplateFile(serverTemplate.getTemplateFile());
		serverTemplateImpl.setTemplateIOS(serverTemplate.getTemplateIOS());
		serverTemplateImpl.setTemplateAndroid(serverTemplate.getTemplateAndroid());
		serverTemplateImpl.setDefaultServer(serverTemplate.getDefaultServer());

		return serverTemplateImpl;
	}

	/**
	 * Returns the server template with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the server template
	 * @return the server template
	 * @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServerTemplateException, SystemException {
		ServerTemplate serverTemplate = fetchByPrimaryKey(primaryKey);

		if (serverTemplate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServerTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return serverTemplate;
	}

	/**
	 * Returns the server template with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchServerTemplateException} if it could not be found.
	 *
	 * @param serverTemplateId the primary key of the server template
	 * @return the server template
	 * @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate findByPrimaryKey(long serverTemplateId)
		throws NoSuchServerTemplateException, SystemException {
		return findByPrimaryKey((Serializable)serverTemplateId);
	}

	/**
	 * Returns the server template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the server template
	 * @return the server template, or <code>null</code> if a server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ServerTemplate serverTemplate = (ServerTemplate)EntityCacheUtil.getResult(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
				ServerTemplateImpl.class, primaryKey);

		if (serverTemplate == _nullServerTemplate) {
			return null;
		}

		if (serverTemplate == null) {
			Session session = null;

			try {
				session = openSession();

				serverTemplate = (ServerTemplate)session.get(ServerTemplateImpl.class,
						primaryKey);

				if (serverTemplate != null) {
					cacheResult(serverTemplate);
				}
				else {
					EntityCacheUtil.putResult(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
						ServerTemplateImpl.class, primaryKey,
						_nullServerTemplate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
					ServerTemplateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return serverTemplate;
	}

	/**
	 * Returns the server template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serverTemplateId the primary key of the server template
	 * @return the server template, or <code>null</code> if a server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServerTemplate fetchByPrimaryKey(long serverTemplateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)serverTemplateId);
	}

	/**
	 * Returns all the server templates.
	 *
	 * @return the server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServerTemplate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the server templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of server templates
	 * @param end the upper bound of the range of server templates (not inclusive)
	 * @return the range of server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServerTemplate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the server templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of server templates
	 * @param end the upper bound of the range of server templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServerTemplate> findAll(int start, int end,
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

		List<ServerTemplate> list = (List<ServerTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SERVERTEMPLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVERTEMPLATE;

				if (pagination) {
					sql = sql.concat(ServerTemplateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServerTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServerTemplate>(list);
				}
				else {
					list = (List<ServerTemplate>)QueryUtil.list(q,
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
	 * Removes all the server templates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ServerTemplate serverTemplate : findAll()) {
			remove(serverTemplate);
		}
	}

	/**
	 * Returns the number of server templates.
	 *
	 * @return the number of server templates
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

				Query q = session.createQuery(_SQL_COUNT_SERVERTEMPLATE);

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
	 * Initializes the server template persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.ServerTemplate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ServerTemplate>> listenersList = new ArrayList<ModelListener<ServerTemplate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ServerTemplate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ServerTemplateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SERVERTEMPLATE = "SELECT serverTemplate FROM ServerTemplate serverTemplate";
	private static final String _SQL_SELECT_SERVERTEMPLATE_WHERE = "SELECT serverTemplate FROM ServerTemplate serverTemplate WHERE ";
	private static final String _SQL_COUNT_SERVERTEMPLATE = "SELECT COUNT(serverTemplate) FROM ServerTemplate serverTemplate";
	private static final String _SQL_COUNT_SERVERTEMPLATE_WHERE = "SELECT COUNT(serverTemplate) FROM ServerTemplate serverTemplate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "serverTemplate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServerTemplate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServerTemplate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ServerTemplatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static ServerTemplate _nullServerTemplate = new ServerTemplateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ServerTemplate> toCacheModel() {
				return _nullServerTemplateCacheModel;
			}
		};

	private static CacheModel<ServerTemplate> _nullServerTemplateCacheModel = new CacheModel<ServerTemplate>() {
			@Override
			public ServerTemplate toEntityModel() {
				return _nullServerTemplate;
			}
		};
}