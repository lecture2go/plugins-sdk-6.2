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

import de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException;
import de.uhh.l2g.plugins.model.StreamingServerTemplate;
import de.uhh.l2g.plugins.model.impl.StreamingServerTemplateImpl;
import de.uhh.l2g.plugins.model.impl.StreamingServerTemplateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the streaming server template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see StreamingServerTemplatePersistence
 * @see StreamingServerTemplateUtil
 * @generated
 */
public class StreamingServerTemplatePersistenceImpl extends BasePersistenceImpl<StreamingServerTemplate>
	implements StreamingServerTemplatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StreamingServerTemplateUtil} to access the streaming server template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StreamingServerTemplateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			StreamingServerTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			StreamingServerTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			StreamingServerTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			StreamingServerTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			StreamingServerTemplateModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the streaming server templates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StreamingServerTemplate> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the streaming server templates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StreamingServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of streaming server templates
	 * @param end the upper bound of the range of streaming server templates (not inclusive)
	 * @return the range of matching streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StreamingServerTemplate> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the streaming server templates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StreamingServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of streaming server templates
	 * @param end the upper bound of the range of streaming server templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StreamingServerTemplate> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<StreamingServerTemplate> list = (List<StreamingServerTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StreamingServerTemplate streamingServerTemplate : list) {
				if ((groupId != streamingServerTemplate.getGroupId())) {
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

			query.append(_SQL_SELECT_STREAMINGSERVERTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StreamingServerTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<StreamingServerTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StreamingServerTemplate>(list);
				}
				else {
					list = (List<StreamingServerTemplate>)QueryUtil.list(q,
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
	 * Returns the first streaming server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching streaming server template
	 * @throws de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException if a matching streaming server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchStreamingServerTemplateException, SystemException {
		StreamingServerTemplate streamingServerTemplate = fetchByGroupId_First(groupId,
				orderByComparator);

		if (streamingServerTemplate != null) {
			return streamingServerTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStreamingServerTemplateException(msg.toString());
	}

	/**
	 * Returns the first streaming server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching streaming server template, or <code>null</code> if a matching streaming server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StreamingServerTemplate> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last streaming server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching streaming server template
	 * @throws de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException if a matching streaming server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchStreamingServerTemplateException, SystemException {
		StreamingServerTemplate streamingServerTemplate = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (streamingServerTemplate != null) {
			return streamingServerTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStreamingServerTemplateException(msg.toString());
	}

	/**
	 * Returns the last streaming server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching streaming server template, or <code>null</code> if a matching streaming server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<StreamingServerTemplate> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the streaming server templates before and after the current streaming server template in the ordered set where groupId = &#63;.
	 *
	 * @param streamingServerTemplateId the primary key of the current streaming server template
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next streaming server template
	 * @throws de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException if a streaming server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate[] findByGroupId_PrevAndNext(
		long streamingServerTemplateId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchStreamingServerTemplateException, SystemException {
		StreamingServerTemplate streamingServerTemplate = findByPrimaryKey(streamingServerTemplateId);

		Session session = null;

		try {
			session = openSession();

			StreamingServerTemplate[] array = new StreamingServerTemplateImpl[3];

			array[0] = getByGroupId_PrevAndNext(session,
					streamingServerTemplate, groupId, orderByComparator, true);

			array[1] = streamingServerTemplate;

			array[2] = getByGroupId_PrevAndNext(session,
					streamingServerTemplate, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StreamingServerTemplate getByGroupId_PrevAndNext(
		Session session, StreamingServerTemplate streamingServerTemplate,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STREAMINGSERVERTEMPLATE_WHERE);

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
			query.append(StreamingServerTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(streamingServerTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StreamingServerTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the streaming server templates where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (StreamingServerTemplate streamingServerTemplate : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(streamingServerTemplate);
		}
	}

	/**
	 * Returns the number of streaming server templates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching streaming server templates
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

			query.append(_SQL_COUNT_STREAMINGSERVERTEMPLATE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "streamingServerTemplate.groupId = ? AND streamingServerTemplate.type < 1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVICESPECIFICURLS =
		new FinderPath(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			StreamingServerTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDeviceSpecificURLs",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICESPECIFICURLS =
		new FinderPath(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			StreamingServerTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDeviceSpecificURLs", new String[] { Long.class.getName() },
			StreamingServerTemplateModelImpl.STREAMINGSERVERTEMPLATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEVICESPECIFICURLS = new FinderPath(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDeviceSpecificURLs", new String[] { Long.class.getName() });

	/**
	 * Returns all the streaming server templates where streamingServerTemplateId = &#63;.
	 *
	 * @param streamingServerTemplateId the streaming server template ID
	 * @return the matching streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StreamingServerTemplate> findByDeviceSpecificURLs(
		long streamingServerTemplateId) throws SystemException {
		return findByDeviceSpecificURLs(streamingServerTemplateId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the streaming server templates where streamingServerTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StreamingServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param streamingServerTemplateId the streaming server template ID
	 * @param start the lower bound of the range of streaming server templates
	 * @param end the upper bound of the range of streaming server templates (not inclusive)
	 * @return the range of matching streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StreamingServerTemplate> findByDeviceSpecificURLs(
		long streamingServerTemplateId, int start, int end)
		throws SystemException {
		return findByDeviceSpecificURLs(streamingServerTemplateId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the streaming server templates where streamingServerTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StreamingServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param streamingServerTemplateId the streaming server template ID
	 * @param start the lower bound of the range of streaming server templates
	 * @param end the upper bound of the range of streaming server templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StreamingServerTemplate> findByDeviceSpecificURLs(
		long streamingServerTemplateId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICESPECIFICURLS;
			finderArgs = new Object[] { streamingServerTemplateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVICESPECIFICURLS;
			finderArgs = new Object[] {
					streamingServerTemplateId,
					
					start, end, orderByComparator
				};
		}

		List<StreamingServerTemplate> list = (List<StreamingServerTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StreamingServerTemplate streamingServerTemplate : list) {
				if ((streamingServerTemplateId != streamingServerTemplate.getStreamingServerTemplateId())) {
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

			query.append(_SQL_SELECT_STREAMINGSERVERTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_DEVICESPECIFICURLS_STREAMINGSERVERTEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StreamingServerTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(streamingServerTemplateId);

				if (!pagination) {
					list = (List<StreamingServerTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StreamingServerTemplate>(list);
				}
				else {
					list = (List<StreamingServerTemplate>)QueryUtil.list(q,
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
	 * Returns the first streaming server template in the ordered set where streamingServerTemplateId = &#63;.
	 *
	 * @param streamingServerTemplateId the streaming server template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching streaming server template
	 * @throws de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException if a matching streaming server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate findByDeviceSpecificURLs_First(
		long streamingServerTemplateId, OrderByComparator orderByComparator)
		throws NoSuchStreamingServerTemplateException, SystemException {
		StreamingServerTemplate streamingServerTemplate = fetchByDeviceSpecificURLs_First(streamingServerTemplateId,
				orderByComparator);

		if (streamingServerTemplate != null) {
			return streamingServerTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("streamingServerTemplateId=");
		msg.append(streamingServerTemplateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStreamingServerTemplateException(msg.toString());
	}

	/**
	 * Returns the first streaming server template in the ordered set where streamingServerTemplateId = &#63;.
	 *
	 * @param streamingServerTemplateId the streaming server template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching streaming server template, or <code>null</code> if a matching streaming server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate fetchByDeviceSpecificURLs_First(
		long streamingServerTemplateId, OrderByComparator orderByComparator)
		throws SystemException {
		List<StreamingServerTemplate> list = findByDeviceSpecificURLs(streamingServerTemplateId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last streaming server template in the ordered set where streamingServerTemplateId = &#63;.
	 *
	 * @param streamingServerTemplateId the streaming server template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching streaming server template
	 * @throws de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException if a matching streaming server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate findByDeviceSpecificURLs_Last(
		long streamingServerTemplateId, OrderByComparator orderByComparator)
		throws NoSuchStreamingServerTemplateException, SystemException {
		StreamingServerTemplate streamingServerTemplate = fetchByDeviceSpecificURLs_Last(streamingServerTemplateId,
				orderByComparator);

		if (streamingServerTemplate != null) {
			return streamingServerTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("streamingServerTemplateId=");
		msg.append(streamingServerTemplateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStreamingServerTemplateException(msg.toString());
	}

	/**
	 * Returns the last streaming server template in the ordered set where streamingServerTemplateId = &#63;.
	 *
	 * @param streamingServerTemplateId the streaming server template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching streaming server template, or <code>null</code> if a matching streaming server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate fetchByDeviceSpecificURLs_Last(
		long streamingServerTemplateId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDeviceSpecificURLs(streamingServerTemplateId);

		if (count == 0) {
			return null;
		}

		List<StreamingServerTemplate> list = findByDeviceSpecificURLs(streamingServerTemplateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the streaming server templates where streamingServerTemplateId = &#63; from the database.
	 *
	 * @param streamingServerTemplateId the streaming server template ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDeviceSpecificURLs(long streamingServerTemplateId)
		throws SystemException {
		for (StreamingServerTemplate streamingServerTemplate : findByDeviceSpecificURLs(
				streamingServerTemplateId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(streamingServerTemplate);
		}
	}

	/**
	 * Returns the number of streaming server templates where streamingServerTemplateId = &#63;.
	 *
	 * @param streamingServerTemplateId the streaming server template ID
	 * @return the number of matching streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDeviceSpecificURLs(long streamingServerTemplateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEVICESPECIFICURLS;

		Object[] finderArgs = new Object[] { streamingServerTemplateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STREAMINGSERVERTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_DEVICESPECIFICURLS_STREAMINGSERVERTEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(streamingServerTemplateId);

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

	private static final String _FINDER_COLUMN_DEVICESPECIFICURLS_STREAMINGSERVERTEMPLATEID_2 =
		"streamingServerTemplate.streamingServerTemplateId = ? AND streamingServerTemplate.type = 0 AND (streamingServerTemplate.templateIOS > 0 OR streamingServerTemplate.templateAndroid > 0)";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEFAULTSERVER =
		new FinderPath(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			StreamingServerTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDefaultServer",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTSERVER =
		new FinderPath(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateModelImpl.FINDER_CACHE_ENABLED,
			StreamingServerTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDefaultServer",
			new String[] { Long.class.getName() },
			StreamingServerTemplateModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEFAULTSERVER = new FinderPath(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDefaultServer",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the streaming server templates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StreamingServerTemplate> findByDefaultServer(long groupId)
		throws SystemException {
		return findByDefaultServer(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the streaming server templates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StreamingServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of streaming server templates
	 * @param end the upper bound of the range of streaming server templates (not inclusive)
	 * @return the range of matching streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StreamingServerTemplate> findByDefaultServer(long groupId,
		int start, int end) throws SystemException {
		return findByDefaultServer(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the streaming server templates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StreamingServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of streaming server templates
	 * @param end the upper bound of the range of streaming server templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StreamingServerTemplate> findByDefaultServer(long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<StreamingServerTemplate> list = (List<StreamingServerTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StreamingServerTemplate streamingServerTemplate : list) {
				if ((groupId != streamingServerTemplate.getGroupId())) {
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

			query.append(_SQL_SELECT_STREAMINGSERVERTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_DEFAULTSERVER_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StreamingServerTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<StreamingServerTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StreamingServerTemplate>(list);
				}
				else {
					list = (List<StreamingServerTemplate>)QueryUtil.list(q,
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
	 * Returns the first streaming server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching streaming server template
	 * @throws de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException if a matching streaming server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate findByDefaultServer_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchStreamingServerTemplateException, SystemException {
		StreamingServerTemplate streamingServerTemplate = fetchByDefaultServer_First(groupId,
				orderByComparator);

		if (streamingServerTemplate != null) {
			return streamingServerTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStreamingServerTemplateException(msg.toString());
	}

	/**
	 * Returns the first streaming server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching streaming server template, or <code>null</code> if a matching streaming server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate fetchByDefaultServer_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StreamingServerTemplate> list = findByDefaultServer(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last streaming server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching streaming server template
	 * @throws de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException if a matching streaming server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate findByDefaultServer_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchStreamingServerTemplateException, SystemException {
		StreamingServerTemplate streamingServerTemplate = fetchByDefaultServer_Last(groupId,
				orderByComparator);

		if (streamingServerTemplate != null) {
			return streamingServerTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStreamingServerTemplateException(msg.toString());
	}

	/**
	 * Returns the last streaming server template in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching streaming server template, or <code>null</code> if a matching streaming server template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate fetchByDefaultServer_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDefaultServer(groupId);

		if (count == 0) {
			return null;
		}

		List<StreamingServerTemplate> list = findByDefaultServer(groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the streaming server templates before and after the current streaming server template in the ordered set where groupId = &#63;.
	 *
	 * @param streamingServerTemplateId the primary key of the current streaming server template
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next streaming server template
	 * @throws de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException if a streaming server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate[] findByDefaultServer_PrevAndNext(
		long streamingServerTemplateId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchStreamingServerTemplateException, SystemException {
		StreamingServerTemplate streamingServerTemplate = findByPrimaryKey(streamingServerTemplateId);

		Session session = null;

		try {
			session = openSession();

			StreamingServerTemplate[] array = new StreamingServerTemplateImpl[3];

			array[0] = getByDefaultServer_PrevAndNext(session,
					streamingServerTemplate, groupId, orderByComparator, true);

			array[1] = streamingServerTemplate;

			array[2] = getByDefaultServer_PrevAndNext(session,
					streamingServerTemplate, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StreamingServerTemplate getByDefaultServer_PrevAndNext(
		Session session, StreamingServerTemplate streamingServerTemplate,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STREAMINGSERVERTEMPLATE_WHERE);

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
			query.append(StreamingServerTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(streamingServerTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StreamingServerTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the streaming server templates where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDefaultServer(long groupId) throws SystemException {
		for (StreamingServerTemplate streamingServerTemplate : findByDefaultServer(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(streamingServerTemplate);
		}
	}

	/**
	 * Returns the number of streaming server templates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching streaming server templates
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

			query.append(_SQL_COUNT_STREAMINGSERVERTEMPLATE_WHERE);

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

	private static final String _FINDER_COLUMN_DEFAULTSERVER_GROUPID_2 = "streamingServerTemplate.groupId = ? AND streamingServerTemplate.defaultServer > 0";

	public StreamingServerTemplatePersistenceImpl() {
		setModelClass(StreamingServerTemplate.class);
	}

	/**
	 * Caches the streaming server template in the entity cache if it is enabled.
	 *
	 * @param streamingServerTemplate the streaming server template
	 */
	@Override
	public void cacheResult(StreamingServerTemplate streamingServerTemplate) {
		EntityCacheUtil.putResult(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateImpl.class,
			streamingServerTemplate.getPrimaryKey(), streamingServerTemplate);

		streamingServerTemplate.resetOriginalValues();
	}

	/**
	 * Caches the streaming server templates in the entity cache if it is enabled.
	 *
	 * @param streamingServerTemplates the streaming server templates
	 */
	@Override
	public void cacheResult(
		List<StreamingServerTemplate> streamingServerTemplates) {
		for (StreamingServerTemplate streamingServerTemplate : streamingServerTemplates) {
			if (EntityCacheUtil.getResult(
						StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
						StreamingServerTemplateImpl.class,
						streamingServerTemplate.getPrimaryKey()) == null) {
				cacheResult(streamingServerTemplate);
			}
			else {
				streamingServerTemplate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all streaming server templates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StreamingServerTemplateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StreamingServerTemplateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the streaming server template.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StreamingServerTemplate streamingServerTemplate) {
		EntityCacheUtil.removeResult(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateImpl.class,
			streamingServerTemplate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<StreamingServerTemplate> streamingServerTemplates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StreamingServerTemplate streamingServerTemplate : streamingServerTemplates) {
			EntityCacheUtil.removeResult(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
				StreamingServerTemplateImpl.class,
				streamingServerTemplate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new streaming server template with the primary key. Does not add the streaming server template to the database.
	 *
	 * @param streamingServerTemplateId the primary key for the new streaming server template
	 * @return the new streaming server template
	 */
	@Override
	public StreamingServerTemplate create(long streamingServerTemplateId) {
		StreamingServerTemplate streamingServerTemplate = new StreamingServerTemplateImpl();

		streamingServerTemplate.setNew(true);
		streamingServerTemplate.setPrimaryKey(streamingServerTemplateId);

		return streamingServerTemplate;
	}

	/**
	 * Removes the streaming server template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param streamingServerTemplateId the primary key of the streaming server template
	 * @return the streaming server template that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException if a streaming server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate remove(long streamingServerTemplateId)
		throws NoSuchStreamingServerTemplateException, SystemException {
		return remove((Serializable)streamingServerTemplateId);
	}

	/**
	 * Removes the streaming server template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the streaming server template
	 * @return the streaming server template that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException if a streaming server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate remove(Serializable primaryKey)
		throws NoSuchStreamingServerTemplateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StreamingServerTemplate streamingServerTemplate = (StreamingServerTemplate)session.get(StreamingServerTemplateImpl.class,
					primaryKey);

			if (streamingServerTemplate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStreamingServerTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(streamingServerTemplate);
		}
		catch (NoSuchStreamingServerTemplateException nsee) {
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
	protected StreamingServerTemplate removeImpl(
		StreamingServerTemplate streamingServerTemplate)
		throws SystemException {
		streamingServerTemplate = toUnwrappedModel(streamingServerTemplate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(streamingServerTemplate)) {
				streamingServerTemplate = (StreamingServerTemplate)session.get(StreamingServerTemplateImpl.class,
						streamingServerTemplate.getPrimaryKeyObj());
			}

			if (streamingServerTemplate != null) {
				session.delete(streamingServerTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (streamingServerTemplate != null) {
			clearCache(streamingServerTemplate);
		}

		return streamingServerTemplate;
	}

	@Override
	public StreamingServerTemplate updateImpl(
		de.uhh.l2g.plugins.model.StreamingServerTemplate streamingServerTemplate)
		throws SystemException {
		streamingServerTemplate = toUnwrappedModel(streamingServerTemplate);

		boolean isNew = streamingServerTemplate.isNew();

		StreamingServerTemplateModelImpl streamingServerTemplateModelImpl = (StreamingServerTemplateModelImpl)streamingServerTemplate;

		Session session = null;

		try {
			session = openSession();

			if (streamingServerTemplate.isNew()) {
				session.save(streamingServerTemplate);

				streamingServerTemplate.setNew(false);
			}
			else {
				session.merge(streamingServerTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StreamingServerTemplateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((streamingServerTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						streamingServerTemplateModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						streamingServerTemplateModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((streamingServerTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICESPECIFICURLS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						streamingServerTemplateModelImpl.getOriginalStreamingServerTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVICESPECIFICURLS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICESPECIFICURLS,
					args);

				args = new Object[] {
						streamingServerTemplateModelImpl.getStreamingServerTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVICESPECIFICURLS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICESPECIFICURLS,
					args);
			}

			if ((streamingServerTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTSERVER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						streamingServerTemplateModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEFAULTSERVER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTSERVER,
					args);

				args = new Object[] {
						streamingServerTemplateModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEFAULTSERVER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTSERVER,
					args);
			}
		}

		EntityCacheUtil.putResult(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
			StreamingServerTemplateImpl.class,
			streamingServerTemplate.getPrimaryKey(), streamingServerTemplate);

		return streamingServerTemplate;
	}

	protected StreamingServerTemplate toUnwrappedModel(
		StreamingServerTemplate streamingServerTemplate) {
		if (streamingServerTemplate instanceof StreamingServerTemplateImpl) {
			return streamingServerTemplate;
		}

		StreamingServerTemplateImpl streamingServerTemplateImpl = new StreamingServerTemplateImpl();

		streamingServerTemplateImpl.setNew(streamingServerTemplate.isNew());
		streamingServerTemplateImpl.setPrimaryKey(streamingServerTemplate.getPrimaryKey());

		streamingServerTemplateImpl.setStreamingServerTemplateId(streamingServerTemplate.getStreamingServerTemplateId());
		streamingServerTemplateImpl.setGroupId(streamingServerTemplate.getGroupId());
		streamingServerTemplateImpl.setName(streamingServerTemplate.getName());
		streamingServerTemplateImpl.setType(streamingServerTemplate.getType());
		streamingServerTemplateImpl.setPrefixURL(streamingServerTemplate.getPrefixURL());
		streamingServerTemplateImpl.setSuffixURL(streamingServerTemplate.getSuffixURL());
		streamingServerTemplateImpl.setSecExt(streamingServerTemplate.getSecExt());
		streamingServerTemplateImpl.setTemplateURL(streamingServerTemplate.getTemplateURL());
		streamingServerTemplateImpl.setPrefixFile(streamingServerTemplate.getPrefixFile());
		streamingServerTemplateImpl.setSuffixFile(streamingServerTemplate.getSuffixFile());
		streamingServerTemplateImpl.setTemplateFile(streamingServerTemplate.getTemplateFile());
		streamingServerTemplateImpl.setTemplateIOS(streamingServerTemplate.getTemplateIOS());
		streamingServerTemplateImpl.setTemplateAndroid(streamingServerTemplate.getTemplateAndroid());
		streamingServerTemplateImpl.setDefaultServer(streamingServerTemplate.getDefaultServer());

		return streamingServerTemplateImpl;
	}

	/**
	 * Returns the streaming server template with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the streaming server template
	 * @return the streaming server template
	 * @throws de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException if a streaming server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStreamingServerTemplateException, SystemException {
		StreamingServerTemplate streamingServerTemplate = fetchByPrimaryKey(primaryKey);

		if (streamingServerTemplate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStreamingServerTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return streamingServerTemplate;
	}

	/**
	 * Returns the streaming server template with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException} if it could not be found.
	 *
	 * @param streamingServerTemplateId the primary key of the streaming server template
	 * @return the streaming server template
	 * @throws de.uhh.l2g.plugins.NoSuchStreamingServerTemplateException if a streaming server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate findByPrimaryKey(
		long streamingServerTemplateId)
		throws NoSuchStreamingServerTemplateException, SystemException {
		return findByPrimaryKey((Serializable)streamingServerTemplateId);
	}

	/**
	 * Returns the streaming server template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the streaming server template
	 * @return the streaming server template, or <code>null</code> if a streaming server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StreamingServerTemplate streamingServerTemplate = (StreamingServerTemplate)EntityCacheUtil.getResult(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
				StreamingServerTemplateImpl.class, primaryKey);

		if (streamingServerTemplate == _nullStreamingServerTemplate) {
			return null;
		}

		if (streamingServerTemplate == null) {
			Session session = null;

			try {
				session = openSession();

				streamingServerTemplate = (StreamingServerTemplate)session.get(StreamingServerTemplateImpl.class,
						primaryKey);

				if (streamingServerTemplate != null) {
					cacheResult(streamingServerTemplate);
				}
				else {
					EntityCacheUtil.putResult(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
						StreamingServerTemplateImpl.class, primaryKey,
						_nullStreamingServerTemplate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StreamingServerTemplateModelImpl.ENTITY_CACHE_ENABLED,
					StreamingServerTemplateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return streamingServerTemplate;
	}

	/**
	 * Returns the streaming server template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param streamingServerTemplateId the primary key of the streaming server template
	 * @return the streaming server template, or <code>null</code> if a streaming server template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StreamingServerTemplate fetchByPrimaryKey(
		long streamingServerTemplateId) throws SystemException {
		return fetchByPrimaryKey((Serializable)streamingServerTemplateId);
	}

	/**
	 * Returns all the streaming server templates.
	 *
	 * @return the streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StreamingServerTemplate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the streaming server templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StreamingServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of streaming server templates
	 * @param end the upper bound of the range of streaming server templates (not inclusive)
	 * @return the range of streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StreamingServerTemplate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the streaming server templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StreamingServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of streaming server templates
	 * @param end the upper bound of the range of streaming server templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of streaming server templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StreamingServerTemplate> findAll(int start, int end,
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

		List<StreamingServerTemplate> list = (List<StreamingServerTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STREAMINGSERVERTEMPLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STREAMINGSERVERTEMPLATE;

				if (pagination) {
					sql = sql.concat(StreamingServerTemplateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StreamingServerTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StreamingServerTemplate>(list);
				}
				else {
					list = (List<StreamingServerTemplate>)QueryUtil.list(q,
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
	 * Removes all the streaming server templates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StreamingServerTemplate streamingServerTemplate : findAll()) {
			remove(streamingServerTemplate);
		}
	}

	/**
	 * Returns the number of streaming server templates.
	 *
	 * @return the number of streaming server templates
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

				Query q = session.createQuery(_SQL_COUNT_STREAMINGSERVERTEMPLATE);

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
	 * Initializes the streaming server template persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.StreamingServerTemplate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StreamingServerTemplate>> listenersList = new ArrayList<ModelListener<StreamingServerTemplate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StreamingServerTemplate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StreamingServerTemplateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STREAMINGSERVERTEMPLATE = "SELECT streamingServerTemplate FROM StreamingServerTemplate streamingServerTemplate";
	private static final String _SQL_SELECT_STREAMINGSERVERTEMPLATE_WHERE = "SELECT streamingServerTemplate FROM StreamingServerTemplate streamingServerTemplate WHERE ";
	private static final String _SQL_COUNT_STREAMINGSERVERTEMPLATE = "SELECT COUNT(streamingServerTemplate) FROM StreamingServerTemplate streamingServerTemplate";
	private static final String _SQL_COUNT_STREAMINGSERVERTEMPLATE_WHERE = "SELECT COUNT(streamingServerTemplate) FROM StreamingServerTemplate streamingServerTemplate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "streamingServerTemplate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StreamingServerTemplate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StreamingServerTemplate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StreamingServerTemplatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static StreamingServerTemplate _nullStreamingServerTemplate = new StreamingServerTemplateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StreamingServerTemplate> toCacheModel() {
				return _nullStreamingServerTemplateCacheModel;
			}
		};

	private static CacheModel<StreamingServerTemplate> _nullStreamingServerTemplateCacheModel =
		new CacheModel<StreamingServerTemplate>() {
			@Override
			public StreamingServerTemplate toEntityModel() {
				return _nullStreamingServerTemplate;
			}
		};
}