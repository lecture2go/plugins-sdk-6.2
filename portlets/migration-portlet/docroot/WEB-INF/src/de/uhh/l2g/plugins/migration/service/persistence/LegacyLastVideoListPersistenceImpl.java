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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.migration.NoSuchLegacyLastVideoListException;
import de.uhh.l2g.plugins.migration.model.LegacyLastVideoList;
import de.uhh.l2g.plugins.migration.model.impl.LegacyLastVideoListImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyLastVideoListModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy last video list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyLastVideoListPersistence
 * @see LegacyLastVideoListUtil
 * @generated
 */
public class LegacyLastVideoListPersistenceImpl extends BasePersistenceImpl<LegacyLastVideoList>
	implements LegacyLastVideoListPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyLastVideoListUtil} to access the legacy last video list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyLastVideoListImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyLastVideoListModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLastVideoListModelImpl.FINDER_CACHE_ENABLED,
			LegacyLastVideoListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyLastVideoListModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLastVideoListModelImpl.FINDER_CACHE_ENABLED,
			LegacyLastVideoListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyLastVideoListModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLastVideoListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyLastVideoListPersistenceImpl() {
		setModelClass(LegacyLastVideoList.class);
	}

	/**
	 * Caches the legacy last video list in the entity cache if it is enabled.
	 *
	 * @param legacyLastVideoList the legacy last video list
	 */
	@Override
	public void cacheResult(LegacyLastVideoList legacyLastVideoList) {
		EntityCacheUtil.putResult(LegacyLastVideoListModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLastVideoListImpl.class, legacyLastVideoList.getPrimaryKey(),
			legacyLastVideoList);

		legacyLastVideoList.resetOriginalValues();
	}

	/**
	 * Caches the legacy last video lists in the entity cache if it is enabled.
	 *
	 * @param legacyLastVideoLists the legacy last video lists
	 */
	@Override
	public void cacheResult(List<LegacyLastVideoList> legacyLastVideoLists) {
		for (LegacyLastVideoList legacyLastVideoList : legacyLastVideoLists) {
			if (EntityCacheUtil.getResult(
						LegacyLastVideoListModelImpl.ENTITY_CACHE_ENABLED,
						LegacyLastVideoListImpl.class,
						legacyLastVideoList.getPrimaryKey()) == null) {
				cacheResult(legacyLastVideoList);
			}
			else {
				legacyLastVideoList.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy last video lists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyLastVideoListImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyLastVideoListImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy last video list.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyLastVideoList legacyLastVideoList) {
		EntityCacheUtil.removeResult(LegacyLastVideoListModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLastVideoListImpl.class, legacyLastVideoList.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyLastVideoList> legacyLastVideoLists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyLastVideoList legacyLastVideoList : legacyLastVideoLists) {
			EntityCacheUtil.removeResult(LegacyLastVideoListModelImpl.ENTITY_CACHE_ENABLED,
				LegacyLastVideoListImpl.class,
				legacyLastVideoList.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy last video list with the primary key. Does not add the legacy last video list to the database.
	 *
	 * @param id the primary key for the new legacy last video list
	 * @return the new legacy last video list
	 */
	@Override
	public LegacyLastVideoList create(int id) {
		LegacyLastVideoList legacyLastVideoList = new LegacyLastVideoListImpl();

		legacyLastVideoList.setNew(true);
		legacyLastVideoList.setPrimaryKey(id);

		return legacyLastVideoList;
	}

	/**
	 * Removes the legacy last video list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy last video list
	 * @return the legacy last video list that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLastVideoListException if a legacy last video list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLastVideoList remove(int id)
		throws NoSuchLegacyLastVideoListException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy last video list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy last video list
	 * @return the legacy last video list that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLastVideoListException if a legacy last video list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLastVideoList remove(Serializable primaryKey)
		throws NoSuchLegacyLastVideoListException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyLastVideoList legacyLastVideoList = (LegacyLastVideoList)session.get(LegacyLastVideoListImpl.class,
					primaryKey);

			if (legacyLastVideoList == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyLastVideoListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyLastVideoList);
		}
		catch (NoSuchLegacyLastVideoListException nsee) {
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
	protected LegacyLastVideoList removeImpl(
		LegacyLastVideoList legacyLastVideoList) throws SystemException {
		legacyLastVideoList = toUnwrappedModel(legacyLastVideoList);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyLastVideoList)) {
				legacyLastVideoList = (LegacyLastVideoList)session.get(LegacyLastVideoListImpl.class,
						legacyLastVideoList.getPrimaryKeyObj());
			}

			if (legacyLastVideoList != null) {
				session.delete(legacyLastVideoList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyLastVideoList != null) {
			clearCache(legacyLastVideoList);
		}

		return legacyLastVideoList;
	}

	@Override
	public LegacyLastVideoList updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyLastVideoList legacyLastVideoList)
		throws SystemException {
		legacyLastVideoList = toUnwrappedModel(legacyLastVideoList);

		boolean isNew = legacyLastVideoList.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyLastVideoList.isNew()) {
				session.save(legacyLastVideoList);

				legacyLastVideoList.setNew(false);
			}
			else {
				session.merge(legacyLastVideoList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LegacyLastVideoListModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLastVideoListImpl.class, legacyLastVideoList.getPrimaryKey(),
			legacyLastVideoList);

		return legacyLastVideoList;
	}

	protected LegacyLastVideoList toUnwrappedModel(
		LegacyLastVideoList legacyLastVideoList) {
		if (legacyLastVideoList instanceof LegacyLastVideoListImpl) {
			return legacyLastVideoList;
		}

		LegacyLastVideoListImpl legacyLastVideoListImpl = new LegacyLastVideoListImpl();

		legacyLastVideoListImpl.setNew(legacyLastVideoList.isNew());
		legacyLastVideoListImpl.setPrimaryKey(legacyLastVideoList.getPrimaryKey());

		legacyLastVideoListImpl.setId(legacyLastVideoList.getId());
		legacyLastVideoListImpl.setVideoId(legacyLastVideoList.getVideoId());

		return legacyLastVideoListImpl;
	}

	/**
	 * Returns the legacy last video list with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy last video list
	 * @return the legacy last video list
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLastVideoListException if a legacy last video list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLastVideoList findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyLastVideoListException, SystemException {
		LegacyLastVideoList legacyLastVideoList = fetchByPrimaryKey(primaryKey);

		if (legacyLastVideoList == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyLastVideoListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyLastVideoList;
	}

	/**
	 * Returns the legacy last video list with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyLastVideoListException} if it could not be found.
	 *
	 * @param id the primary key of the legacy last video list
	 * @return the legacy last video list
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLastVideoListException if a legacy last video list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLastVideoList findByPrimaryKey(int id)
		throws NoSuchLegacyLastVideoListException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy last video list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy last video list
	 * @return the legacy last video list, or <code>null</code> if a legacy last video list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLastVideoList fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyLastVideoList legacyLastVideoList = (LegacyLastVideoList)EntityCacheUtil.getResult(LegacyLastVideoListModelImpl.ENTITY_CACHE_ENABLED,
				LegacyLastVideoListImpl.class, primaryKey);

		if (legacyLastVideoList == _nullLegacyLastVideoList) {
			return null;
		}

		if (legacyLastVideoList == null) {
			Session session = null;

			try {
				session = openSession();

				legacyLastVideoList = (LegacyLastVideoList)session.get(LegacyLastVideoListImpl.class,
						primaryKey);

				if (legacyLastVideoList != null) {
					cacheResult(legacyLastVideoList);
				}
				else {
					EntityCacheUtil.putResult(LegacyLastVideoListModelImpl.ENTITY_CACHE_ENABLED,
						LegacyLastVideoListImpl.class, primaryKey,
						_nullLegacyLastVideoList);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyLastVideoListModelImpl.ENTITY_CACHE_ENABLED,
					LegacyLastVideoListImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyLastVideoList;
	}

	/**
	 * Returns the legacy last video list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy last video list
	 * @return the legacy last video list, or <code>null</code> if a legacy last video list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLastVideoList fetchByPrimaryKey(int id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy last video lists.
	 *
	 * @return the legacy last video lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyLastVideoList> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy last video lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLastVideoListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy last video lists
	 * @param end the upper bound of the range of legacy last video lists (not inclusive)
	 * @return the range of legacy last video lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyLastVideoList> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy last video lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLastVideoListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy last video lists
	 * @param end the upper bound of the range of legacy last video lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy last video lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyLastVideoList> findAll(int start, int end,
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

		List<LegacyLastVideoList> list = (List<LegacyLastVideoList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYLASTVIDEOLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYLASTVIDEOLIST;

				if (pagination) {
					sql = sql.concat(LegacyLastVideoListModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyLastVideoList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyLastVideoList>(list);
				}
				else {
					list = (List<LegacyLastVideoList>)QueryUtil.list(q,
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
	 * Removes all the legacy last video lists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyLastVideoList legacyLastVideoList : findAll()) {
			remove(legacyLastVideoList);
		}
	}

	/**
	 * Returns the number of legacy last video lists.
	 *
	 * @return the number of legacy last video lists
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYLASTVIDEOLIST);

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
	 * Initializes the legacy last video list persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyLastVideoList")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyLastVideoList>> listenersList = new ArrayList<ModelListener<LegacyLastVideoList>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyLastVideoList>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyLastVideoListImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYLASTVIDEOLIST = "SELECT legacyLastVideoList FROM LegacyLastVideoList legacyLastVideoList";
	private static final String _SQL_COUNT_LEGACYLASTVIDEOLIST = "SELECT COUNT(legacyLastVideoList) FROM LegacyLastVideoList legacyLastVideoList";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyLastVideoList.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyLastVideoList exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyLastVideoListPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static LegacyLastVideoList _nullLegacyLastVideoList = new LegacyLastVideoListImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyLastVideoList> toCacheModel() {
				return _nullLegacyLastVideoListCacheModel;
			}
		};

	private static CacheModel<LegacyLastVideoList> _nullLegacyLastVideoListCacheModel =
		new CacheModel<LegacyLastVideoList>() {
			@Override
			public LegacyLastVideoList toEntityModel() {
				return _nullLegacyLastVideoList;
			}
		};
}