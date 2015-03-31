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

import de.uhh.l2g.plugins.NoSuchTagcloudException;
import de.uhh.l2g.plugins.model.Tagcloud;
import de.uhh.l2g.plugins.model.impl.TagcloudImpl;
import de.uhh.l2g.plugins.model.impl.TagcloudModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tagcloud service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see TagcloudPersistence
 * @see TagcloudUtil
 * @generated
 */
public class TagcloudPersistenceImpl extends BasePersistenceImpl<Tagcloud>
	implements TagcloudPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TagcloudUtil} to access the tagcloud persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TagcloudImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECTCLASSTYPE =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByObjectClassType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTCLASSTYPE =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByObjectClassType",
			new String[] { String.class.getName() },
			TagcloudModelImpl.OBJECTCLASSTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OBJECTCLASSTYPE = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByObjectClassType", new String[] { String.class.getName() });

	/**
	 * Returns all the tagclouds where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @return the matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findByObjectClassType(String objectClassType)
		throws SystemException {
		return findByObjectClassType(objectClassType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds where objectClassType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectClassType the object class type
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findByObjectClassType(String objectClassType,
		int start, int end) throws SystemException {
		return findByObjectClassType(objectClassType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectClassType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectClassType the object class type
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findByObjectClassType(String objectClassType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTCLASSTYPE;
			finderArgs = new Object[] { objectClassType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECTCLASSTYPE;
			finderArgs = new Object[] {
					objectClassType,
					
					start, end, orderByComparator
				};
		}

		List<Tagcloud> list = (List<Tagcloud>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tagcloud tagcloud : list) {
				if (!Validator.equals(objectClassType,
							tagcloud.getObjectClassType())) {
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

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			boolean bindObjectClassType = false;

			if (objectClassType == null) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_1);
			}
			else if (objectClassType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_3);
			}
			else {
				bindObjectClassType = true;

				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TagcloudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectClassType) {
					qPos.add(objectClassType);
				}

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tagcloud>(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByObjectClassType_First(String objectClassType,
		OrderByComparator orderByComparator)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = fetchByObjectClassType_First(objectClassType,
				orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectClassType=");
		msg.append(objectClassType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByObjectClassType_First(String objectClassType,
		OrderByComparator orderByComparator) throws SystemException {
		List<Tagcloud> list = findByObjectClassType(objectClassType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByObjectClassType_Last(String objectClassType,
		OrderByComparator orderByComparator)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = fetchByObjectClassType_Last(objectClassType,
				orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectClassType=");
		msg.append(objectClassType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByObjectClassType_Last(String objectClassType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByObjectClassType(objectClassType);

		if (count == 0) {
			return null;
		}

		List<Tagcloud> list = findByObjectClassType(objectClassType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud[] findByObjectClassType_PrevAndNext(long tagcloudId,
		String objectClassType, OrderByComparator orderByComparator)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = findByPrimaryKey(tagcloudId);

		Session session = null;

		try {
			session = openSession();

			Tagcloud[] array = new TagcloudImpl[3];

			array[0] = getByObjectClassType_PrevAndNext(session, tagcloud,
					objectClassType, orderByComparator, true);

			array[1] = tagcloud;

			array[2] = getByObjectClassType_PrevAndNext(session, tagcloud,
					objectClassType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tagcloud getByObjectClassType_PrevAndNext(Session session,
		Tagcloud tagcloud, String objectClassType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAGCLOUD_WHERE);

		boolean bindObjectClassType = false;

		if (objectClassType == null) {
			query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_1);
		}
		else if (objectClassType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_3);
		}
		else {
			bindObjectClassType = true;

			query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_2);
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
			query.append(TagcloudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindObjectClassType) {
			qPos.add(objectClassType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tagcloud);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tagcloud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tagclouds where objectClassType = &#63; from the database.
	 *
	 * @param objectClassType the object class type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByObjectClassType(String objectClassType)
		throws SystemException {
		for (Tagcloud tagcloud : findByObjectClassType(objectClassType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @return the number of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByObjectClassType(String objectClassType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OBJECTCLASSTYPE;

		Object[] finderArgs = new Object[] { objectClassType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			boolean bindObjectClassType = false;

			if (objectClassType == null) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_1);
			}
			else if (objectClassType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_3);
			}
			else {
				bindObjectClassType = true;

				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectClassType) {
					qPos.add(objectClassType);
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

	private static final String _FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_1 =
		"tagcloud.objectClassType IS NULL";
	private static final String _FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_2 =
		"tagcloud.objectClassType = ?";
	private static final String _FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_3 =
		"(tagcloud.objectClassType IS NULL OR tagcloud.objectClassType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECTID = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByObjectId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTID =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByObjectId",
			new String[] { Long.class.getName() },
			TagcloudModelImpl.OBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OBJECTID = new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByObjectId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tagclouds where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @return the matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findByObjectId(long objectId)
		throws SystemException {
		return findByObjectId(objectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the tagclouds where objectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectId the object ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findByObjectId(long objectId, int start, int end)
		throws SystemException {
		return findByObjectId(objectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectId the object ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findByObjectId(long objectId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTID;
			finderArgs = new Object[] { objectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECTID;
			finderArgs = new Object[] { objectId, start, end, orderByComparator };
		}

		List<Tagcloud> list = (List<Tagcloud>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tagcloud tagcloud : list) {
				if ((objectId != tagcloud.getObjectId())) {
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

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_OBJECTID_OBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TagcloudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(objectId);

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tagcloud>(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByObjectId_First(long objectId,
		OrderByComparator orderByComparator)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = fetchByObjectId_First(objectId, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectId=");
		msg.append(objectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the first tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByObjectId_First(long objectId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Tagcloud> list = findByObjectId(objectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByObjectId_Last(long objectId,
		OrderByComparator orderByComparator)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = fetchByObjectId_Last(objectId, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectId=");
		msg.append(objectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByObjectId_Last(long objectId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByObjectId(objectId);

		if (count == 0) {
			return null;
		}

		List<Tagcloud> list = findByObjectId(objectId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud[] findByObjectId_PrevAndNext(long tagcloudId,
		long objectId, OrderByComparator orderByComparator)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = findByPrimaryKey(tagcloudId);

		Session session = null;

		try {
			session = openSession();

			Tagcloud[] array = new TagcloudImpl[3];

			array[0] = getByObjectId_PrevAndNext(session, tagcloud, objectId,
					orderByComparator, true);

			array[1] = tagcloud;

			array[2] = getByObjectId_PrevAndNext(session, tagcloud, objectId,
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

	protected Tagcloud getByObjectId_PrevAndNext(Session session,
		Tagcloud tagcloud, long objectId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAGCLOUD_WHERE);

		query.append(_FINDER_COLUMN_OBJECTID_OBJECTID_2);

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
			query.append(TagcloudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(objectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tagcloud);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tagcloud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tagclouds where objectId = &#63; from the database.
	 *
	 * @param objectId the object ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByObjectId(long objectId) throws SystemException {
		for (Tagcloud tagcloud : findByObjectId(objectId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @return the number of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByObjectId(long objectId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OBJECTID;

		Object[] finderArgs = new Object[] { objectId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_OBJECTID_OBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(objectId);

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

	private static final String _FINDER_COLUMN_OBJECTID_OBJECTID_2 = "tagcloud.objectId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByObjectClassTypeAndObjectId",
			new String[] { String.class.getName(), Long.class.getName() },
			TagcloudModelImpl.OBJECTCLASSTYPE_COLUMN_BITMASK |
			TagcloudModelImpl.OBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OBJECTCLASSTYPEANDOBJECTID =
		new FinderPath(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByObjectClassTypeAndObjectId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchTagcloudException} if it could not be found.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the matching tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByObjectClassTypeAndObjectId(String objectClassType,
		long objectId) throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = fetchByObjectClassTypeAndObjectId(objectClassType,
				objectId);

		if (tagcloud == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("objectClassType=");
			msg.append(objectClassType);

			msg.append(", objectId=");
			msg.append(objectId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTagcloudException(msg.toString());
		}

		return tagcloud;
	}

	/**
	 * Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByObjectClassTypeAndObjectId(String objectClassType,
		long objectId) throws SystemException {
		return fetchByObjectClassTypeAndObjectId(objectClassType, objectId, true);
	}

	/**
	 * Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByObjectClassTypeAndObjectId(String objectClassType,
		long objectId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { objectClassType, objectId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
					finderArgs, this);
		}

		if (result instanceof Tagcloud) {
			Tagcloud tagcloud = (Tagcloud)result;

			if (!Validator.equals(objectClassType, tagcloud.getObjectClassType()) ||
					(objectId != tagcloud.getObjectId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			boolean bindObjectClassType = false;

			if (objectClassType == null) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_1);
			}
			else if (objectClassType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_3);
			}
			else {
				bindObjectClassType = true;

				query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_2);
			}

			query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectClassType) {
					qPos.add(objectClassType);
				}

				qPos.add(objectId);

				List<Tagcloud> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TagcloudPersistenceImpl.fetchByObjectClassTypeAndObjectId(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Tagcloud tagcloud = list.get(0);

					result = tagcloud;

					cacheResult(tagcloud);

					if ((tagcloud.getObjectClassType() == null) ||
							!tagcloud.getObjectClassType()
										 .equals(objectClassType) ||
							(tagcloud.getObjectId() != objectId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
							finderArgs, tagcloud);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
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
			return (Tagcloud)result;
		}
	}

	/**
	 * Removes the tagcloud where objectClassType = &#63; and objectId = &#63; from the database.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the tagcloud that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud removeByObjectClassTypeAndObjectId(String objectClassType,
		long objectId) throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = findByObjectClassTypeAndObjectId(objectClassType,
				objectId);

		return remove(tagcloud);
	}

	/**
	 * Returns the number of tagclouds where objectClassType = &#63; and objectId = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the number of matching tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByObjectClassTypeAndObjectId(String objectClassType,
		long objectId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OBJECTCLASSTYPEANDOBJECTID;

		Object[] finderArgs = new Object[] { objectClassType, objectId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			boolean bindObjectClassType = false;

			if (objectClassType == null) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_1);
			}
			else if (objectClassType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_3);
			}
			else {
				bindObjectClassType = true;

				query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_2);
			}

			query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectClassType) {
					qPos.add(objectClassType);
				}

				qPos.add(objectId);

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

	private static final String _FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_1 =
		"tagcloud.objectClassType IS NULL AND ";
	private static final String _FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_2 =
		"tagcloud.objectClassType = ? AND ";
	private static final String _FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_3 =
		"(tagcloud.objectClassType IS NULL OR tagcloud.objectClassType = '') AND ";
	private static final String _FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTID_2 =
		"tagcloud.objectId = ?";

	public TagcloudPersistenceImpl() {
		setModelClass(Tagcloud.class);
	}

	/**
	 * Caches the tagcloud in the entity cache if it is enabled.
	 *
	 * @param tagcloud the tagcloud
	 */
	@Override
	public void cacheResult(Tagcloud tagcloud) {
		EntityCacheUtil.putResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudImpl.class, tagcloud.getPrimaryKey(), tagcloud);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
			new Object[] { tagcloud.getObjectClassType(), tagcloud.getObjectId() },
			tagcloud);

		tagcloud.resetOriginalValues();
	}

	/**
	 * Caches the tagclouds in the entity cache if it is enabled.
	 *
	 * @param tagclouds the tagclouds
	 */
	@Override
	public void cacheResult(List<Tagcloud> tagclouds) {
		for (Tagcloud tagcloud : tagclouds) {
			if (EntityCacheUtil.getResult(
						TagcloudModelImpl.ENTITY_CACHE_ENABLED,
						TagcloudImpl.class, tagcloud.getPrimaryKey()) == null) {
				cacheResult(tagcloud);
			}
			else {
				tagcloud.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tagclouds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TagcloudImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TagcloudImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tagcloud.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tagcloud tagcloud) {
		EntityCacheUtil.removeResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudImpl.class, tagcloud.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(tagcloud);
	}

	@Override
	public void clearCache(List<Tagcloud> tagclouds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Tagcloud tagcloud : tagclouds) {
			EntityCacheUtil.removeResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
				TagcloudImpl.class, tagcloud.getPrimaryKey());

			clearUniqueFindersCache(tagcloud);
		}
	}

	protected void cacheUniqueFindersCache(Tagcloud tagcloud) {
		if (tagcloud.isNew()) {
			Object[] args = new Object[] {
					tagcloud.getObjectClassType(), tagcloud.getObjectId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OBJECTCLASSTYPEANDOBJECTID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
				args, tagcloud);
		}
		else {
			TagcloudModelImpl tagcloudModelImpl = (TagcloudModelImpl)tagcloud;

			if ((tagcloudModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tagcloud.getObjectClassType(), tagcloud.getObjectId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OBJECTCLASSTYPEANDOBJECTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
					args, tagcloud);
			}
		}
	}

	protected void clearUniqueFindersCache(Tagcloud tagcloud) {
		TagcloudModelImpl tagcloudModelImpl = (TagcloudModelImpl)tagcloud;

		Object[] args = new Object[] {
				tagcloud.getObjectClassType(), tagcloud.getObjectId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJECTCLASSTYPEANDOBJECTID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
			args);

		if ((tagcloudModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					tagcloudModelImpl.getOriginalObjectClassType(),
					tagcloudModelImpl.getOriginalObjectId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJECTCLASSTYPEANDOBJECTID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OBJECTCLASSTYPEANDOBJECTID,
				args);
		}
	}

	/**
	 * Creates a new tagcloud with the primary key. Does not add the tagcloud to the database.
	 *
	 * @param tagcloudId the primary key for the new tagcloud
	 * @return the new tagcloud
	 */
	@Override
	public Tagcloud create(long tagcloudId) {
		Tagcloud tagcloud = new TagcloudImpl();

		tagcloud.setNew(true);
		tagcloud.setPrimaryKey(tagcloudId);

		return tagcloud;
	}

	/**
	 * Removes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud remove(long tagcloudId)
		throws NoSuchTagcloudException, SystemException {
		return remove((Serializable)tagcloudId);
	}

	/**
	 * Removes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tagcloud
	 * @return the tagcloud that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud remove(Serializable primaryKey)
		throws NoSuchTagcloudException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Tagcloud tagcloud = (Tagcloud)session.get(TagcloudImpl.class,
					primaryKey);

			if (tagcloud == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTagcloudException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tagcloud);
		}
		catch (NoSuchTagcloudException nsee) {
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
	protected Tagcloud removeImpl(Tagcloud tagcloud) throws SystemException {
		tagcloud = toUnwrappedModel(tagcloud);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tagcloud)) {
				tagcloud = (Tagcloud)session.get(TagcloudImpl.class,
						tagcloud.getPrimaryKeyObj());
			}

			if (tagcloud != null) {
				session.delete(tagcloud);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tagcloud != null) {
			clearCache(tagcloud);
		}

		return tagcloud;
	}

	@Override
	public Tagcloud updateImpl(de.uhh.l2g.plugins.model.Tagcloud tagcloud)
		throws SystemException {
		tagcloud = toUnwrappedModel(tagcloud);

		boolean isNew = tagcloud.isNew();

		TagcloudModelImpl tagcloudModelImpl = (TagcloudModelImpl)tagcloud;

		Session session = null;

		try {
			session = openSession();

			if (tagcloud.isNew()) {
				session.save(tagcloud);

				tagcloud.setNew(false);
			}
			else {
				session.merge(tagcloud);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TagcloudModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tagcloudModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTCLASSTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tagcloudModelImpl.getOriginalObjectClassType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJECTCLASSTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTCLASSTYPE,
					args);

				args = new Object[] { tagcloudModelImpl.getObjectClassType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJECTCLASSTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTCLASSTYPE,
					args);
			}

			if ((tagcloudModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tagcloudModelImpl.getOriginalObjectId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJECTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTID,
					args);

				args = new Object[] { tagcloudModelImpl.getObjectId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJECTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTID,
					args);
			}
		}

		EntityCacheUtil.putResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudImpl.class, tagcloud.getPrimaryKey(), tagcloud);

		clearUniqueFindersCache(tagcloud);
		cacheUniqueFindersCache(tagcloud);

		return tagcloud;
	}

	protected Tagcloud toUnwrappedModel(Tagcloud tagcloud) {
		if (tagcloud instanceof TagcloudImpl) {
			return tagcloud;
		}

		TagcloudImpl tagcloudImpl = new TagcloudImpl();

		tagcloudImpl.setNew(tagcloud.isNew());
		tagcloudImpl.setPrimaryKey(tagcloud.getPrimaryKey());

		tagcloudImpl.setTagcloudId(tagcloud.getTagcloudId());
		tagcloudImpl.setObjectClassType(tagcloud.getObjectClassType());
		tagcloudImpl.setObjectId(tagcloud.getObjectId());
		tagcloudImpl.setTags(tagcloud.getTags());

		return tagcloudImpl;
	}

	/**
	 * Returns the tagcloud with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tagcloud
	 * @return the tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTagcloudException, SystemException {
		Tagcloud tagcloud = fetchByPrimaryKey(primaryKey);

		if (tagcloud == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTagcloudException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tagcloud;
	}

	/**
	 * Returns the tagcloud with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchTagcloudException} if it could not be found.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud
	 * @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud findByPrimaryKey(long tagcloudId)
		throws NoSuchTagcloudException, SystemException {
		return findByPrimaryKey((Serializable)tagcloudId);
	}

	/**
	 * Returns the tagcloud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tagcloud
	 * @return the tagcloud, or <code>null</code> if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Tagcloud tagcloud = (Tagcloud)EntityCacheUtil.getResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
				TagcloudImpl.class, primaryKey);

		if (tagcloud == _nullTagcloud) {
			return null;
		}

		if (tagcloud == null) {
			Session session = null;

			try {
				session = openSession();

				tagcloud = (Tagcloud)session.get(TagcloudImpl.class, primaryKey);

				if (tagcloud != null) {
					cacheResult(tagcloud);
				}
				else {
					EntityCacheUtil.putResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
						TagcloudImpl.class, primaryKey, _nullTagcloud);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TagcloudModelImpl.ENTITY_CACHE_ENABLED,
					TagcloudImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tagcloud;
	}

	/**
	 * Returns the tagcloud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud, or <code>null</code> if a tagcloud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tagcloud fetchByPrimaryKey(long tagcloudId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)tagcloudId);
	}

	/**
	 * Returns all the tagclouds.
	 *
	 * @return the tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tagclouds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tagcloud> findAll(int start, int end,
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

		List<Tagcloud> list = (List<Tagcloud>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAGCLOUD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAGCLOUD;

				if (pagination) {
					sql = sql.concat(TagcloudModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tagcloud>(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tagclouds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Tagcloud tagcloud : findAll()) {
			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds.
	 *
	 * @return the number of tagclouds
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

				Query q = session.createQuery(_SQL_COUNT_TAGCLOUD);

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
	 * Initializes the tagcloud persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Tagcloud")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Tagcloud>> listenersList = new ArrayList<ModelListener<Tagcloud>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Tagcloud>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TagcloudImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAGCLOUD = "SELECT tagcloud FROM Tagcloud tagcloud";
	private static final String _SQL_SELECT_TAGCLOUD_WHERE = "SELECT tagcloud FROM Tagcloud tagcloud WHERE ";
	private static final String _SQL_COUNT_TAGCLOUD = "SELECT COUNT(tagcloud) FROM Tagcloud tagcloud";
	private static final String _SQL_COUNT_TAGCLOUD_WHERE = "SELECT COUNT(tagcloud) FROM Tagcloud tagcloud WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tagcloud.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Tagcloud exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Tagcloud exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TagcloudPersistenceImpl.class);
	private static Tagcloud _nullTagcloud = new TagcloudImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Tagcloud> toCacheModel() {
				return _nullTagcloudCacheModel;
			}
		};

	private static CacheModel<Tagcloud> _nullTagcloudCacheModel = new CacheModel<Tagcloud>() {
			@Override
			public Tagcloud toEntityModel() {
				return _nullTagcloud;
			}
		};
}