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

import de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticsException;
import de.uhh.l2g.plugins.migration.model.LegacyStatistics;
import de.uhh.l2g.plugins.migration.model.impl.LegacyStatisticsImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyStatisticsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy statistics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyStatisticsPersistence
 * @see LegacyStatisticsUtil
 * @generated
 */
public class LegacyStatisticsPersistenceImpl extends BasePersistenceImpl<LegacyStatistics>
	implements LegacyStatisticsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyStatisticsUtil} to access the legacy statistics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyStatisticsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			LegacyStatisticsModelImpl.FINDER_CACHE_ENABLED,
			LegacyStatisticsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			LegacyStatisticsModelImpl.FINDER_CACHE_ENABLED,
			LegacyStatisticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			LegacyStatisticsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyStatisticsPersistenceImpl() {
		setModelClass(LegacyStatistics.class);
	}

	/**
	 * Caches the legacy statistics in the entity cache if it is enabled.
	 *
	 * @param legacyStatistics the legacy statistics
	 */
	@Override
	public void cacheResult(LegacyStatistics legacyStatistics) {
		EntityCacheUtil.putResult(LegacyStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			LegacyStatisticsImpl.class, legacyStatistics.getPrimaryKey(),
			legacyStatistics);

		legacyStatistics.resetOriginalValues();
	}

	/**
	 * Caches the legacy statisticses in the entity cache if it is enabled.
	 *
	 * @param legacyStatisticses the legacy statisticses
	 */
	@Override
	public void cacheResult(List<LegacyStatistics> legacyStatisticses) {
		for (LegacyStatistics legacyStatistics : legacyStatisticses) {
			if (EntityCacheUtil.getResult(
						LegacyStatisticsModelImpl.ENTITY_CACHE_ENABLED,
						LegacyStatisticsImpl.class,
						legacyStatistics.getPrimaryKey()) == null) {
				cacheResult(legacyStatistics);
			}
			else {
				legacyStatistics.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy statisticses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyStatisticsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyStatisticsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy statistics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyStatistics legacyStatistics) {
		EntityCacheUtil.removeResult(LegacyStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			LegacyStatisticsImpl.class, legacyStatistics.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyStatistics> legacyStatisticses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyStatistics legacyStatistics : legacyStatisticses) {
			EntityCacheUtil.removeResult(LegacyStatisticsModelImpl.ENTITY_CACHE_ENABLED,
				LegacyStatisticsImpl.class, legacyStatistics.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy statistics with the primary key. Does not add the legacy statistics to the database.
	 *
	 * @param id the primary key for the new legacy statistics
	 * @return the new legacy statistics
	 */
	@Override
	public LegacyStatistics create(int id) {
		LegacyStatistics legacyStatistics = new LegacyStatisticsImpl();

		legacyStatistics.setNew(true);
		legacyStatistics.setPrimaryKey(id);

		return legacyStatistics;
	}

	/**
	 * Removes the legacy statistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy statistics
	 * @return the legacy statistics that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticsException if a legacy statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyStatistics remove(int id)
		throws NoSuchLegacyStatisticsException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy statistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy statistics
	 * @return the legacy statistics that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticsException if a legacy statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyStatistics remove(Serializable primaryKey)
		throws NoSuchLegacyStatisticsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyStatistics legacyStatistics = (LegacyStatistics)session.get(LegacyStatisticsImpl.class,
					primaryKey);

			if (legacyStatistics == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyStatisticsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyStatistics);
		}
		catch (NoSuchLegacyStatisticsException nsee) {
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
	protected LegacyStatistics removeImpl(LegacyStatistics legacyStatistics)
		throws SystemException {
		legacyStatistics = toUnwrappedModel(legacyStatistics);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyStatistics)) {
				legacyStatistics = (LegacyStatistics)session.get(LegacyStatisticsImpl.class,
						legacyStatistics.getPrimaryKeyObj());
			}

			if (legacyStatistics != null) {
				session.delete(legacyStatistics);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyStatistics != null) {
			clearCache(legacyStatistics);
		}

		return legacyStatistics;
	}

	@Override
	public LegacyStatistics updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyStatistics legacyStatistics)
		throws SystemException {
		legacyStatistics = toUnwrappedModel(legacyStatistics);

		boolean isNew = legacyStatistics.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyStatistics.isNew()) {
				session.save(legacyStatistics);

				legacyStatistics.setNew(false);
			}
			else {
				session.merge(legacyStatistics);
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

		EntityCacheUtil.putResult(LegacyStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			LegacyStatisticsImpl.class, legacyStatistics.getPrimaryKey(),
			legacyStatistics);

		return legacyStatistics;
	}

	protected LegacyStatistics toUnwrappedModel(
		LegacyStatistics legacyStatistics) {
		if (legacyStatistics instanceof LegacyStatisticsImpl) {
			return legacyStatistics;
		}

		LegacyStatisticsImpl legacyStatisticsImpl = new LegacyStatisticsImpl();

		legacyStatisticsImpl.setNew(legacyStatistics.isNew());
		legacyStatisticsImpl.setPrimaryKey(legacyStatistics.getPrimaryKey());

		legacyStatisticsImpl.setId(legacyStatistics.getId());
		legacyStatisticsImpl.setPublic(legacyStatistics.getPublic());
		legacyStatisticsImpl.setPrivate(legacyStatistics.getPrivate());
		legacyStatisticsImpl.setAutofill(legacyStatistics.getAutofill());
		legacyStatisticsImpl.setDate(legacyStatistics.getDate());

		return legacyStatisticsImpl;
	}

	/**
	 * Returns the legacy statistics with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy statistics
	 * @return the legacy statistics
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticsException if a legacy statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyStatistics findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyStatisticsException, SystemException {
		LegacyStatistics legacyStatistics = fetchByPrimaryKey(primaryKey);

		if (legacyStatistics == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyStatisticsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyStatistics;
	}

	/**
	 * Returns the legacy statistics with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticsException} if it could not be found.
	 *
	 * @param id the primary key of the legacy statistics
	 * @return the legacy statistics
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticsException if a legacy statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyStatistics findByPrimaryKey(int id)
		throws NoSuchLegacyStatisticsException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy statistics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy statistics
	 * @return the legacy statistics, or <code>null</code> if a legacy statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyStatistics fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyStatistics legacyStatistics = (LegacyStatistics)EntityCacheUtil.getResult(LegacyStatisticsModelImpl.ENTITY_CACHE_ENABLED,
				LegacyStatisticsImpl.class, primaryKey);

		if (legacyStatistics == _nullLegacyStatistics) {
			return null;
		}

		if (legacyStatistics == null) {
			Session session = null;

			try {
				session = openSession();

				legacyStatistics = (LegacyStatistics)session.get(LegacyStatisticsImpl.class,
						primaryKey);

				if (legacyStatistics != null) {
					cacheResult(legacyStatistics);
				}
				else {
					EntityCacheUtil.putResult(LegacyStatisticsModelImpl.ENTITY_CACHE_ENABLED,
						LegacyStatisticsImpl.class, primaryKey,
						_nullLegacyStatistics);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyStatisticsModelImpl.ENTITY_CACHE_ENABLED,
					LegacyStatisticsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyStatistics;
	}

	/**
	 * Returns the legacy statistics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy statistics
	 * @return the legacy statistics, or <code>null</code> if a legacy statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyStatistics fetchByPrimaryKey(int id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy statisticses.
	 *
	 * @return the legacy statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyStatistics> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy statisticses
	 * @param end the upper bound of the range of legacy statisticses (not inclusive)
	 * @return the range of legacy statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyStatistics> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy statisticses
	 * @param end the upper bound of the range of legacy statisticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyStatistics> findAll(int start, int end,
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

		List<LegacyStatistics> list = (List<LegacyStatistics>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYSTATISTICS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYSTATISTICS;

				if (pagination) {
					sql = sql.concat(LegacyStatisticsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyStatistics>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyStatistics>(list);
				}
				else {
					list = (List<LegacyStatistics>)QueryUtil.list(q,
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
	 * Removes all the legacy statisticses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyStatistics legacyStatistics : findAll()) {
			remove(legacyStatistics);
		}
	}

	/**
	 * Returns the number of legacy statisticses.
	 *
	 * @return the number of legacy statisticses
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYSTATISTICS);

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
	 * Initializes the legacy statistics persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyStatistics")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyStatistics>> listenersList = new ArrayList<ModelListener<LegacyStatistics>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyStatistics>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyStatisticsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYSTATISTICS = "SELECT legacyStatistics FROM LegacyStatistics legacyStatistics";
	private static final String _SQL_COUNT_LEGACYSTATISTICS = "SELECT COUNT(legacyStatistics) FROM LegacyStatistics legacyStatistics";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyStatistics.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyStatistics exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyStatisticsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "public", "private", "date"
			});
	private static LegacyStatistics _nullLegacyStatistics = new LegacyStatisticsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyStatistics> toCacheModel() {
				return _nullLegacyStatisticsCacheModel;
			}
		};

	private static CacheModel<LegacyStatistics> _nullLegacyStatisticsCacheModel = new CacheModel<LegacyStatistics>() {
			@Override
			public LegacyStatistics toEntityModel() {
				return _nullLegacyStatistics;
			}
		};
}