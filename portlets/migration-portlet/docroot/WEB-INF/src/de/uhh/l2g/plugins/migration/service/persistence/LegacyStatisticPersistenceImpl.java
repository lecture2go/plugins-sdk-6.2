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

import de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticException;
import de.uhh.l2g.plugins.migration.model.LegacyStatistic;
import de.uhh.l2g.plugins.migration.model.impl.LegacyStatisticImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyStatisticModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy statistic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyStatisticPersistence
 * @see LegacyStatisticUtil
 * @generated
 */
public class LegacyStatisticPersistenceImpl extends BasePersistenceImpl<LegacyStatistic>
	implements LegacyStatisticPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyStatisticUtil} to access the legacy statistic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyStatisticImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyStatisticModelImpl.ENTITY_CACHE_ENABLED,
			LegacyStatisticModelImpl.FINDER_CACHE_ENABLED,
			LegacyStatisticImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyStatisticModelImpl.ENTITY_CACHE_ENABLED,
			LegacyStatisticModelImpl.FINDER_CACHE_ENABLED,
			LegacyStatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyStatisticModelImpl.ENTITY_CACHE_ENABLED,
			LegacyStatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyStatisticPersistenceImpl() {
		setModelClass(LegacyStatistic.class);
	}

	/**
	 * Caches the legacy statistic in the entity cache if it is enabled.
	 *
	 * @param legacyStatistic the legacy statistic
	 */
	@Override
	public void cacheResult(LegacyStatistic legacyStatistic) {
		EntityCacheUtil.putResult(LegacyStatisticModelImpl.ENTITY_CACHE_ENABLED,
			LegacyStatisticImpl.class, legacyStatistic.getPrimaryKey(),
			legacyStatistic);

		legacyStatistic.resetOriginalValues();
	}

	/**
	 * Caches the legacy statistics in the entity cache if it is enabled.
	 *
	 * @param legacyStatistics the legacy statistics
	 */
	@Override
	public void cacheResult(List<LegacyStatistic> legacyStatistics) {
		for (LegacyStatistic legacyStatistic : legacyStatistics) {
			if (EntityCacheUtil.getResult(
						LegacyStatisticModelImpl.ENTITY_CACHE_ENABLED,
						LegacyStatisticImpl.class,
						legacyStatistic.getPrimaryKey()) == null) {
				cacheResult(legacyStatistic);
			}
			else {
				legacyStatistic.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy statistics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyStatisticImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyStatisticImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy statistic.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyStatistic legacyStatistic) {
		EntityCacheUtil.removeResult(LegacyStatisticModelImpl.ENTITY_CACHE_ENABLED,
			LegacyStatisticImpl.class, legacyStatistic.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyStatistic> legacyStatistics) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyStatistic legacyStatistic : legacyStatistics) {
			EntityCacheUtil.removeResult(LegacyStatisticModelImpl.ENTITY_CACHE_ENABLED,
				LegacyStatisticImpl.class, legacyStatistic.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy statistic with the primary key. Does not add the legacy statistic to the database.
	 *
	 * @param id the primary key for the new legacy statistic
	 * @return the new legacy statistic
	 */
	@Override
	public LegacyStatistic create(int id) {
		LegacyStatistic legacyStatistic = new LegacyStatisticImpl();

		legacyStatistic.setNew(true);
		legacyStatistic.setPrimaryKey(id);

		return legacyStatistic;
	}

	/**
	 * Removes the legacy statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy statistic
	 * @return the legacy statistic that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticException if a legacy statistic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyStatistic remove(int id)
		throws NoSuchLegacyStatisticException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy statistic
	 * @return the legacy statistic that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticException if a legacy statistic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyStatistic remove(Serializable primaryKey)
		throws NoSuchLegacyStatisticException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyStatistic legacyStatistic = (LegacyStatistic)session.get(LegacyStatisticImpl.class,
					primaryKey);

			if (legacyStatistic == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyStatisticException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyStatistic);
		}
		catch (NoSuchLegacyStatisticException nsee) {
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
	protected LegacyStatistic removeImpl(LegacyStatistic legacyStatistic)
		throws SystemException {
		legacyStatistic = toUnwrappedModel(legacyStatistic);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyStatistic)) {
				legacyStatistic = (LegacyStatistic)session.get(LegacyStatisticImpl.class,
						legacyStatistic.getPrimaryKeyObj());
			}

			if (legacyStatistic != null) {
				session.delete(legacyStatistic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyStatistic != null) {
			clearCache(legacyStatistic);
		}

		return legacyStatistic;
	}

	@Override
	public LegacyStatistic updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyStatistic legacyStatistic)
		throws SystemException {
		legacyStatistic = toUnwrappedModel(legacyStatistic);

		boolean isNew = legacyStatistic.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyStatistic.isNew()) {
				session.save(legacyStatistic);

				legacyStatistic.setNew(false);
			}
			else {
				session.merge(legacyStatistic);
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

		EntityCacheUtil.putResult(LegacyStatisticModelImpl.ENTITY_CACHE_ENABLED,
			LegacyStatisticImpl.class, legacyStatistic.getPrimaryKey(),
			legacyStatistic);

		return legacyStatistic;
	}

	protected LegacyStatistic toUnwrappedModel(LegacyStatistic legacyStatistic) {
		if (legacyStatistic instanceof LegacyStatisticImpl) {
			return legacyStatistic;
		}

		LegacyStatisticImpl legacyStatisticImpl = new LegacyStatisticImpl();

		legacyStatisticImpl.setNew(legacyStatistic.isNew());
		legacyStatisticImpl.setPrimaryKey(legacyStatistic.getPrimaryKey());

		legacyStatisticImpl.setId(legacyStatistic.getId());
		legacyStatisticImpl.setPublic_(legacyStatistic.getPublic_());
		legacyStatisticImpl.setPrivate_(legacyStatistic.getPrivate_());
		legacyStatisticImpl.setAutofill(legacyStatistic.getAutofill());
		legacyStatisticImpl.setDate_(legacyStatistic.getDate_());

		return legacyStatisticImpl;
	}

	/**
	 * Returns the legacy statistic with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy statistic
	 * @return the legacy statistic
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticException if a legacy statistic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyStatistic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyStatisticException, SystemException {
		LegacyStatistic legacyStatistic = fetchByPrimaryKey(primaryKey);

		if (legacyStatistic == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyStatisticException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyStatistic;
	}

	/**
	 * Returns the legacy statistic with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticException} if it could not be found.
	 *
	 * @param id the primary key of the legacy statistic
	 * @return the legacy statistic
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticException if a legacy statistic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyStatistic findByPrimaryKey(int id)
		throws NoSuchLegacyStatisticException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy statistic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy statistic
	 * @return the legacy statistic, or <code>null</code> if a legacy statistic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyStatistic fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyStatistic legacyStatistic = (LegacyStatistic)EntityCacheUtil.getResult(LegacyStatisticModelImpl.ENTITY_CACHE_ENABLED,
				LegacyStatisticImpl.class, primaryKey);

		if (legacyStatistic == _nullLegacyStatistic) {
			return null;
		}

		if (legacyStatistic == null) {
			Session session = null;

			try {
				session = openSession();

				legacyStatistic = (LegacyStatistic)session.get(LegacyStatisticImpl.class,
						primaryKey);

				if (legacyStatistic != null) {
					cacheResult(legacyStatistic);
				}
				else {
					EntityCacheUtil.putResult(LegacyStatisticModelImpl.ENTITY_CACHE_ENABLED,
						LegacyStatisticImpl.class, primaryKey,
						_nullLegacyStatistic);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyStatisticModelImpl.ENTITY_CACHE_ENABLED,
					LegacyStatisticImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyStatistic;
	}

	/**
	 * Returns the legacy statistic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy statistic
	 * @return the legacy statistic, or <code>null</code> if a legacy statistic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyStatistic fetchByPrimaryKey(int id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy statistics.
	 *
	 * @return the legacy statistics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyStatistic> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy statistics
	 * @param end the upper bound of the range of legacy statistics (not inclusive)
	 * @return the range of legacy statistics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyStatistic> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy statistics
	 * @param end the upper bound of the range of legacy statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy statistics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyStatistic> findAll(int start, int end,
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

		List<LegacyStatistic> list = (List<LegacyStatistic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYSTATISTIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYSTATISTIC;

				if (pagination) {
					sql = sql.concat(LegacyStatisticModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyStatistic>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyStatistic>(list);
				}
				else {
					list = (List<LegacyStatistic>)QueryUtil.list(q,
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
	 * Removes all the legacy statistics from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyStatistic legacyStatistic : findAll()) {
			remove(legacyStatistic);
		}
	}

	/**
	 * Returns the number of legacy statistics.
	 *
	 * @return the number of legacy statistics
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYSTATISTIC);

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
	 * Initializes the legacy statistic persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyStatistic")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyStatistic>> listenersList = new ArrayList<ModelListener<LegacyStatistic>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyStatistic>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyStatisticImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYSTATISTIC = "SELECT legacyStatistic FROM LegacyStatistic legacyStatistic";
	private static final String _SQL_COUNT_LEGACYSTATISTIC = "SELECT COUNT(legacyStatistic) FROM LegacyStatistic legacyStatistic";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyStatistic.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyStatistic exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyStatisticPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static LegacyStatistic _nullLegacyStatistic = new LegacyStatisticImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyStatistic> toCacheModel() {
				return _nullLegacyStatisticCacheModel;
			}
		};

	private static CacheModel<LegacyStatistic> _nullLegacyStatisticCacheModel = new CacheModel<LegacyStatistic>() {
			@Override
			public LegacyStatistic toEntityModel() {
				return _nullLegacyStatistic;
			}
		};
}