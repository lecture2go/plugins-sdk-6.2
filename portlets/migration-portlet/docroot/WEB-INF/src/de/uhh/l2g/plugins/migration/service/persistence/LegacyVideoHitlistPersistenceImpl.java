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

import de.uhh.l2g.plugins.migration.NoSuchLegacyVideoHitlistException;
import de.uhh.l2g.plugins.migration.model.LegacyVideoHitlist;
import de.uhh.l2g.plugins.migration.model.impl.LegacyVideoHitlistImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyVideoHitlistModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy video hitlist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyVideoHitlistPersistence
 * @see LegacyVideoHitlistUtil
 * @generated
 */
public class LegacyVideoHitlistPersistenceImpl extends BasePersistenceImpl<LegacyVideoHitlist>
	implements LegacyVideoHitlistPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyVideoHitlistUtil} to access the legacy video hitlist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyVideoHitlistImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyVideoHitlistModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoHitlistModelImpl.FINDER_CACHE_ENABLED,
			LegacyVideoHitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyVideoHitlistModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoHitlistModelImpl.FINDER_CACHE_ENABLED,
			LegacyVideoHitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyVideoHitlistModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoHitlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyVideoHitlistPersistenceImpl() {
		setModelClass(LegacyVideoHitlist.class);
	}

	/**
	 * Caches the legacy video hitlist in the entity cache if it is enabled.
	 *
	 * @param legacyVideoHitlist the legacy video hitlist
	 */
	@Override
	public void cacheResult(LegacyVideoHitlist legacyVideoHitlist) {
		EntityCacheUtil.putResult(LegacyVideoHitlistModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoHitlistImpl.class, legacyVideoHitlist.getPrimaryKey(),
			legacyVideoHitlist);

		legacyVideoHitlist.resetOriginalValues();
	}

	/**
	 * Caches the legacy video hitlists in the entity cache if it is enabled.
	 *
	 * @param legacyVideoHitlists the legacy video hitlists
	 */
	@Override
	public void cacheResult(List<LegacyVideoHitlist> legacyVideoHitlists) {
		for (LegacyVideoHitlist legacyVideoHitlist : legacyVideoHitlists) {
			if (EntityCacheUtil.getResult(
						LegacyVideoHitlistModelImpl.ENTITY_CACHE_ENABLED,
						LegacyVideoHitlistImpl.class,
						legacyVideoHitlist.getPrimaryKey()) == null) {
				cacheResult(legacyVideoHitlist);
			}
			else {
				legacyVideoHitlist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy video hitlists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyVideoHitlistImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyVideoHitlistImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy video hitlist.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyVideoHitlist legacyVideoHitlist) {
		EntityCacheUtil.removeResult(LegacyVideoHitlistModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoHitlistImpl.class, legacyVideoHitlist.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyVideoHitlist> legacyVideoHitlists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyVideoHitlist legacyVideoHitlist : legacyVideoHitlists) {
			EntityCacheUtil.removeResult(LegacyVideoHitlistModelImpl.ENTITY_CACHE_ENABLED,
				LegacyVideoHitlistImpl.class, legacyVideoHitlist.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy video hitlist with the primary key. Does not add the legacy video hitlist to the database.
	 *
	 * @param id the primary key for the new legacy video hitlist
	 * @return the new legacy video hitlist
	 */
	@Override
	public LegacyVideoHitlist create(long id) {
		LegacyVideoHitlist legacyVideoHitlist = new LegacyVideoHitlistImpl();

		legacyVideoHitlist.setNew(true);
		legacyVideoHitlist.setPrimaryKey(id);

		return legacyVideoHitlist;
	}

	/**
	 * Removes the legacy video hitlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy video hitlist
	 * @return the legacy video hitlist that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoHitlistException if a legacy video hitlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideoHitlist remove(long id)
		throws NoSuchLegacyVideoHitlistException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy video hitlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy video hitlist
	 * @return the legacy video hitlist that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoHitlistException if a legacy video hitlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideoHitlist remove(Serializable primaryKey)
		throws NoSuchLegacyVideoHitlistException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyVideoHitlist legacyVideoHitlist = (LegacyVideoHitlist)session.get(LegacyVideoHitlistImpl.class,
					primaryKey);

			if (legacyVideoHitlist == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyVideoHitlistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyVideoHitlist);
		}
		catch (NoSuchLegacyVideoHitlistException nsee) {
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
	protected LegacyVideoHitlist removeImpl(
		LegacyVideoHitlist legacyVideoHitlist) throws SystemException {
		legacyVideoHitlist = toUnwrappedModel(legacyVideoHitlist);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyVideoHitlist)) {
				legacyVideoHitlist = (LegacyVideoHitlist)session.get(LegacyVideoHitlistImpl.class,
						legacyVideoHitlist.getPrimaryKeyObj());
			}

			if (legacyVideoHitlist != null) {
				session.delete(legacyVideoHitlist);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyVideoHitlist != null) {
			clearCache(legacyVideoHitlist);
		}

		return legacyVideoHitlist;
	}

	@Override
	public LegacyVideoHitlist updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyVideoHitlist legacyVideoHitlist)
		throws SystemException {
		legacyVideoHitlist = toUnwrappedModel(legacyVideoHitlist);

		boolean isNew = legacyVideoHitlist.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyVideoHitlist.isNew()) {
				session.save(legacyVideoHitlist);

				legacyVideoHitlist.setNew(false);
			}
			else {
				session.merge(legacyVideoHitlist);
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

		EntityCacheUtil.putResult(LegacyVideoHitlistModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoHitlistImpl.class, legacyVideoHitlist.getPrimaryKey(),
			legacyVideoHitlist);

		return legacyVideoHitlist;
	}

	protected LegacyVideoHitlist toUnwrappedModel(
		LegacyVideoHitlist legacyVideoHitlist) {
		if (legacyVideoHitlist instanceof LegacyVideoHitlistImpl) {
			return legacyVideoHitlist;
		}

		LegacyVideoHitlistImpl legacyVideoHitlistImpl = new LegacyVideoHitlistImpl();

		legacyVideoHitlistImpl.setNew(legacyVideoHitlist.isNew());
		legacyVideoHitlistImpl.setPrimaryKey(legacyVideoHitlist.getPrimaryKey());

		legacyVideoHitlistImpl.setId(legacyVideoHitlist.getId());
		legacyVideoHitlistImpl.setHitsperday(legacyVideoHitlist.getHitsperday());
		legacyVideoHitlistImpl.setHitsperweek(legacyVideoHitlist.getHitsperweek());
		legacyVideoHitlistImpl.setHitspermonth(legacyVideoHitlist.getHitspermonth());
		legacyVideoHitlistImpl.setHitsperyear(legacyVideoHitlist.getHitsperyear());

		return legacyVideoHitlistImpl;
	}

	/**
	 * Returns the legacy video hitlist with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy video hitlist
	 * @return the legacy video hitlist
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoHitlistException if a legacy video hitlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideoHitlist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyVideoHitlistException, SystemException {
		LegacyVideoHitlist legacyVideoHitlist = fetchByPrimaryKey(primaryKey);

		if (legacyVideoHitlist == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyVideoHitlistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyVideoHitlist;
	}

	/**
	 * Returns the legacy video hitlist with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyVideoHitlistException} if it could not be found.
	 *
	 * @param id the primary key of the legacy video hitlist
	 * @return the legacy video hitlist
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoHitlistException if a legacy video hitlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideoHitlist findByPrimaryKey(long id)
		throws NoSuchLegacyVideoHitlistException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy video hitlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy video hitlist
	 * @return the legacy video hitlist, or <code>null</code> if a legacy video hitlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideoHitlist fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyVideoHitlist legacyVideoHitlist = (LegacyVideoHitlist)EntityCacheUtil.getResult(LegacyVideoHitlistModelImpl.ENTITY_CACHE_ENABLED,
				LegacyVideoHitlistImpl.class, primaryKey);

		if (legacyVideoHitlist == _nullLegacyVideoHitlist) {
			return null;
		}

		if (legacyVideoHitlist == null) {
			Session session = null;

			try {
				session = openSession();

				legacyVideoHitlist = (LegacyVideoHitlist)session.get(LegacyVideoHitlistImpl.class,
						primaryKey);

				if (legacyVideoHitlist != null) {
					cacheResult(legacyVideoHitlist);
				}
				else {
					EntityCacheUtil.putResult(LegacyVideoHitlistModelImpl.ENTITY_CACHE_ENABLED,
						LegacyVideoHitlistImpl.class, primaryKey,
						_nullLegacyVideoHitlist);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyVideoHitlistModelImpl.ENTITY_CACHE_ENABLED,
					LegacyVideoHitlistImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyVideoHitlist;
	}

	/**
	 * Returns the legacy video hitlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy video hitlist
	 * @return the legacy video hitlist, or <code>null</code> if a legacy video hitlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideoHitlist fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy video hitlists.
	 *
	 * @return the legacy video hitlists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyVideoHitlist> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy video hitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyVideoHitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy video hitlists
	 * @param end the upper bound of the range of legacy video hitlists (not inclusive)
	 * @return the range of legacy video hitlists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyVideoHitlist> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy video hitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyVideoHitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy video hitlists
	 * @param end the upper bound of the range of legacy video hitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy video hitlists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyVideoHitlist> findAll(int start, int end,
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

		List<LegacyVideoHitlist> list = (List<LegacyVideoHitlist>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYVIDEOHITLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYVIDEOHITLIST;

				if (pagination) {
					sql = sql.concat(LegacyVideoHitlistModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyVideoHitlist>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyVideoHitlist>(list);
				}
				else {
					list = (List<LegacyVideoHitlist>)QueryUtil.list(q,
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
	 * Removes all the legacy video hitlists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyVideoHitlist legacyVideoHitlist : findAll()) {
			remove(legacyVideoHitlist);
		}
	}

	/**
	 * Returns the number of legacy video hitlists.
	 *
	 * @return the number of legacy video hitlists
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYVIDEOHITLIST);

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
	 * Initializes the legacy video hitlist persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyVideoHitlist")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyVideoHitlist>> listenersList = new ArrayList<ModelListener<LegacyVideoHitlist>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyVideoHitlist>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyVideoHitlistImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYVIDEOHITLIST = "SELECT legacyVideoHitlist FROM LegacyVideoHitlist legacyVideoHitlist";
	private static final String _SQL_COUNT_LEGACYVIDEOHITLIST = "SELECT COUNT(legacyVideoHitlist) FROM LegacyVideoHitlist legacyVideoHitlist";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyVideoHitlist.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyVideoHitlist exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyVideoHitlistPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static LegacyVideoHitlist _nullLegacyVideoHitlist = new LegacyVideoHitlistImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyVideoHitlist> toCacheModel() {
				return _nullLegacyVideoHitlistCacheModel;
			}
		};

	private static CacheModel<LegacyVideoHitlist> _nullLegacyVideoHitlistCacheModel =
		new CacheModel<LegacyVideoHitlist>() {
			@Override
			public LegacyVideoHitlist toEntityModel() {
				return _nullLegacyVideoHitlist;
			}
		};
}