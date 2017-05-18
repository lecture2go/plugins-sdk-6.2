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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException;
import de.uhh.l2g.plugins.migration.model.LegacyCoordinator;
import de.uhh.l2g.plugins.migration.model.impl.LegacyCoordinatorImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyCoordinatorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legacy coordinator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyCoordinatorPersistence
 * @see LegacyCoordinatorUtil
 * @generated
 */
public class LegacyCoordinatorPersistenceImpl extends BasePersistenceImpl<LegacyCoordinator>
	implements LegacyCoordinatorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyCoordinatorUtil} to access the legacy coordinator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyCoordinatorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyCoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			LegacyCoordinatorModelImpl.FINDER_CACHE_ENABLED,
			LegacyCoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyCoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			LegacyCoordinatorModelImpl.FINDER_CACHE_ENABLED,
			LegacyCoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyCoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			LegacyCoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyCoordinatorPersistenceImpl() {
		setModelClass(LegacyCoordinator.class);
	}

	/**
	 * Caches the legacy coordinator in the entity cache if it is enabled.
	 *
	 * @param legacyCoordinator the legacy coordinator
	 */
	@Override
	public void cacheResult(LegacyCoordinator legacyCoordinator) {
		EntityCacheUtil.putResult(LegacyCoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			LegacyCoordinatorImpl.class, legacyCoordinator.getPrimaryKey(),
			legacyCoordinator);

		legacyCoordinator.resetOriginalValues();
	}

	/**
	 * Caches the legacy coordinators in the entity cache if it is enabled.
	 *
	 * @param legacyCoordinators the legacy coordinators
	 */
	@Override
	public void cacheResult(List<LegacyCoordinator> legacyCoordinators) {
		for (LegacyCoordinator legacyCoordinator : legacyCoordinators) {
			if (EntityCacheUtil.getResult(
						LegacyCoordinatorModelImpl.ENTITY_CACHE_ENABLED,
						LegacyCoordinatorImpl.class,
						legacyCoordinator.getPrimaryKey()) == null) {
				cacheResult(legacyCoordinator);
			}
			else {
				legacyCoordinator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy coordinators.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyCoordinatorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyCoordinatorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy coordinator.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyCoordinator legacyCoordinator) {
		EntityCacheUtil.removeResult(LegacyCoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			LegacyCoordinatorImpl.class, legacyCoordinator.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyCoordinator> legacyCoordinators) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyCoordinator legacyCoordinator : legacyCoordinators) {
			EntityCacheUtil.removeResult(LegacyCoordinatorModelImpl.ENTITY_CACHE_ENABLED,
				LegacyCoordinatorImpl.class, legacyCoordinator.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy coordinator with the primary key. Does not add the legacy coordinator to the database.
	 *
	 * @param userId the primary key for the new legacy coordinator
	 * @return the new legacy coordinator
	 */
	@Override
	public LegacyCoordinator create(long userId) {
		LegacyCoordinator legacyCoordinator = new LegacyCoordinatorImpl();

		legacyCoordinator.setNew(true);
		legacyCoordinator.setPrimaryKey(userId);

		return legacyCoordinator;
	}

	/**
	 * Removes the legacy coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the legacy coordinator
	 * @return the legacy coordinator that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException if a legacy coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyCoordinator remove(long userId)
		throws NoSuchLegacyCoordinatorException, SystemException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the legacy coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy coordinator
	 * @return the legacy coordinator that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException if a legacy coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyCoordinator remove(Serializable primaryKey)
		throws NoSuchLegacyCoordinatorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyCoordinator legacyCoordinator = (LegacyCoordinator)session.get(LegacyCoordinatorImpl.class,
					primaryKey);

			if (legacyCoordinator == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyCoordinatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyCoordinator);
		}
		catch (NoSuchLegacyCoordinatorException nsee) {
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
	protected LegacyCoordinator removeImpl(LegacyCoordinator legacyCoordinator)
		throws SystemException {
		legacyCoordinator = toUnwrappedModel(legacyCoordinator);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyCoordinator)) {
				legacyCoordinator = (LegacyCoordinator)session.get(LegacyCoordinatorImpl.class,
						legacyCoordinator.getPrimaryKeyObj());
			}

			if (legacyCoordinator != null) {
				session.delete(legacyCoordinator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyCoordinator != null) {
			clearCache(legacyCoordinator);
		}

		return legacyCoordinator;
	}

	@Override
	public LegacyCoordinator updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyCoordinator legacyCoordinator)
		throws SystemException {
		legacyCoordinator = toUnwrappedModel(legacyCoordinator);

		boolean isNew = legacyCoordinator.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyCoordinator.isNew()) {
				session.save(legacyCoordinator);

				legacyCoordinator.setNew(false);
			}
			else {
				session.merge(legacyCoordinator);
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

		EntityCacheUtil.putResult(LegacyCoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			LegacyCoordinatorImpl.class, legacyCoordinator.getPrimaryKey(),
			legacyCoordinator);

		return legacyCoordinator;
	}

	protected LegacyCoordinator toUnwrappedModel(
		LegacyCoordinator legacyCoordinator) {
		if (legacyCoordinator instanceof LegacyCoordinatorImpl) {
			return legacyCoordinator;
		}

		LegacyCoordinatorImpl legacyCoordinatorImpl = new LegacyCoordinatorImpl();

		legacyCoordinatorImpl.setNew(legacyCoordinator.isNew());
		legacyCoordinatorImpl.setPrimaryKey(legacyCoordinator.getPrimaryKey());

		legacyCoordinatorImpl.setUserId(legacyCoordinator.getUserId());
		legacyCoordinatorImpl.setFacilityId(legacyCoordinator.getFacilityId());
		legacyCoordinatorImpl.setOfficeId(legacyCoordinator.getOfficeId());

		return legacyCoordinatorImpl;
	}

	/**
	 * Returns the legacy coordinator with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy coordinator
	 * @return the legacy coordinator
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException if a legacy coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyCoordinator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyCoordinatorException, SystemException {
		LegacyCoordinator legacyCoordinator = fetchByPrimaryKey(primaryKey);

		if (legacyCoordinator == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyCoordinatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyCoordinator;
	}

	/**
	 * Returns the legacy coordinator with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException} if it could not be found.
	 *
	 * @param userId the primary key of the legacy coordinator
	 * @return the legacy coordinator
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException if a legacy coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyCoordinator findByPrimaryKey(long userId)
		throws NoSuchLegacyCoordinatorException, SystemException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the legacy coordinator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy coordinator
	 * @return the legacy coordinator, or <code>null</code> if a legacy coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyCoordinator fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyCoordinator legacyCoordinator = (LegacyCoordinator)EntityCacheUtil.getResult(LegacyCoordinatorModelImpl.ENTITY_CACHE_ENABLED,
				LegacyCoordinatorImpl.class, primaryKey);

		if (legacyCoordinator == _nullLegacyCoordinator) {
			return null;
		}

		if (legacyCoordinator == null) {
			Session session = null;

			try {
				session = openSession();

				legacyCoordinator = (LegacyCoordinator)session.get(LegacyCoordinatorImpl.class,
						primaryKey);

				if (legacyCoordinator != null) {
					cacheResult(legacyCoordinator);
				}
				else {
					EntityCacheUtil.putResult(LegacyCoordinatorModelImpl.ENTITY_CACHE_ENABLED,
						LegacyCoordinatorImpl.class, primaryKey,
						_nullLegacyCoordinator);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyCoordinatorModelImpl.ENTITY_CACHE_ENABLED,
					LegacyCoordinatorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyCoordinator;
	}

	/**
	 * Returns the legacy coordinator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the legacy coordinator
	 * @return the legacy coordinator, or <code>null</code> if a legacy coordinator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyCoordinator fetchByPrimaryKey(long userId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns all the legacy coordinators.
	 *
	 * @return the legacy coordinators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyCoordinator> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyCoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy coordinators
	 * @param end the upper bound of the range of legacy coordinators (not inclusive)
	 * @return the range of legacy coordinators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyCoordinator> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyCoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy coordinators
	 * @param end the upper bound of the range of legacy coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy coordinators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyCoordinator> findAll(int start, int end,
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

		List<LegacyCoordinator> list = (List<LegacyCoordinator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYCOORDINATOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYCOORDINATOR;

				if (pagination) {
					sql = sql.concat(LegacyCoordinatorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyCoordinator>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyCoordinator>(list);
				}
				else {
					list = (List<LegacyCoordinator>)QueryUtil.list(q,
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
	 * Removes all the legacy coordinators from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyCoordinator legacyCoordinator : findAll()) {
			remove(legacyCoordinator);
		}
	}

	/**
	 * Returns the number of legacy coordinators.
	 *
	 * @return the number of legacy coordinators
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYCOORDINATOR);

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
	 * Initializes the legacy coordinator persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyCoordinator")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyCoordinator>> listenersList = new ArrayList<ModelListener<LegacyCoordinator>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyCoordinator>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyCoordinatorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYCOORDINATOR = "SELECT legacyCoordinator FROM LegacyCoordinator legacyCoordinator";
	private static final String _SQL_COUNT_LEGACYCOORDINATOR = "SELECT COUNT(legacyCoordinator) FROM LegacyCoordinator legacyCoordinator";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyCoordinator.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyCoordinator exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyCoordinatorPersistenceImpl.class);
	private static LegacyCoordinator _nullLegacyCoordinator = new LegacyCoordinatorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyCoordinator> toCacheModel() {
				return _nullLegacyCoordinatorCacheModel;
			}
		};

	private static CacheModel<LegacyCoordinator> _nullLegacyCoordinatorCacheModel =
		new CacheModel<LegacyCoordinator>() {
			@Override
			public LegacyCoordinator toEntityModel() {
				return _nullLegacyCoordinator;
			}
		};
}