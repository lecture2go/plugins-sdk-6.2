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

import de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException;
import de.uhh.l2g.plugins.migration.model.LegacyFacility;
import de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyFacilityPersistence
 * @see LegacyFacilityUtil
 * @generated
 */
public class LegacyFacilityPersistenceImpl extends BasePersistenceImpl<LegacyFacility>
	implements LegacyFacilityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyFacilityUtil} to access the legacy facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyFacilityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyFacilityModelImpl.FINDER_CACHE_ENABLED,
			LegacyFacilityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyFacilityModelImpl.FINDER_CACHE_ENABLED,
			LegacyFacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyFacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyFacilityPersistenceImpl() {
		setModelClass(LegacyFacility.class);
	}

	/**
	 * Caches the legacy facility in the entity cache if it is enabled.
	 *
	 * @param legacyFacility the legacy facility
	 */
	@Override
	public void cacheResult(LegacyFacility legacyFacility) {
		EntityCacheUtil.putResult(LegacyFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyFacilityImpl.class, legacyFacility.getPrimaryKey(),
			legacyFacility);

		legacyFacility.resetOriginalValues();
	}

	/**
	 * Caches the legacy facilities in the entity cache if it is enabled.
	 *
	 * @param legacyFacilities the legacy facilities
	 */
	@Override
	public void cacheResult(List<LegacyFacility> legacyFacilities) {
		for (LegacyFacility legacyFacility : legacyFacilities) {
			if (EntityCacheUtil.getResult(
						LegacyFacilityModelImpl.ENTITY_CACHE_ENABLED,
						LegacyFacilityImpl.class, legacyFacility.getPrimaryKey()) == null) {
				cacheResult(legacyFacility);
			}
			else {
				legacyFacility.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy facilities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyFacilityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyFacilityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy facility.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyFacility legacyFacility) {
		EntityCacheUtil.removeResult(LegacyFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyFacilityImpl.class, legacyFacility.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyFacility> legacyFacilities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyFacility legacyFacility : legacyFacilities) {
			EntityCacheUtil.removeResult(LegacyFacilityModelImpl.ENTITY_CACHE_ENABLED,
				LegacyFacilityImpl.class, legacyFacility.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy facility with the primary key. Does not add the legacy facility to the database.
	 *
	 * @param id the primary key for the new legacy facility
	 * @return the new legacy facility
	 */
	@Override
	public LegacyFacility create(long id) {
		LegacyFacility legacyFacility = new LegacyFacilityImpl();

		legacyFacility.setNew(true);
		legacyFacility.setPrimaryKey(id);

		return legacyFacility;
	}

	/**
	 * Removes the legacy facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy facility
	 * @return the legacy facility that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException if a legacy facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyFacility remove(long id)
		throws NoSuchLegacyFacilityException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy facility
	 * @return the legacy facility that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException if a legacy facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyFacility remove(Serializable primaryKey)
		throws NoSuchLegacyFacilityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyFacility legacyFacility = (LegacyFacility)session.get(LegacyFacilityImpl.class,
					primaryKey);

			if (legacyFacility == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyFacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyFacility);
		}
		catch (NoSuchLegacyFacilityException nsee) {
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
	protected LegacyFacility removeImpl(LegacyFacility legacyFacility)
		throws SystemException {
		legacyFacility = toUnwrappedModel(legacyFacility);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyFacility)) {
				legacyFacility = (LegacyFacility)session.get(LegacyFacilityImpl.class,
						legacyFacility.getPrimaryKeyObj());
			}

			if (legacyFacility != null) {
				session.delete(legacyFacility);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyFacility != null) {
			clearCache(legacyFacility);
		}

		return legacyFacility;
	}

	@Override
	public LegacyFacility updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyFacility legacyFacility)
		throws SystemException {
		legacyFacility = toUnwrappedModel(legacyFacility);

		boolean isNew = legacyFacility.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyFacility.isNew()) {
				session.save(legacyFacility);

				legacyFacility.setNew(false);
			}
			else {
				session.merge(legacyFacility);
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

		EntityCacheUtil.putResult(LegacyFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyFacilityImpl.class, legacyFacility.getPrimaryKey(),
			legacyFacility);

		return legacyFacility;
	}

	protected LegacyFacility toUnwrappedModel(LegacyFacility legacyFacility) {
		if (legacyFacility instanceof LegacyFacilityImpl) {
			return legacyFacility;
		}

		LegacyFacilityImpl legacyFacilityImpl = new LegacyFacilityImpl();

		legacyFacilityImpl.setNew(legacyFacility.isNew());
		legacyFacilityImpl.setPrimaryKey(legacyFacility.getPrimaryKey());

		legacyFacilityImpl.setId(legacyFacility.getId());
		legacyFacilityImpl.setParentId(legacyFacility.getParentId());
		legacyFacilityImpl.setName(legacyFacility.getName());
		legacyFacilityImpl.setTyp(legacyFacility.getTyp());
		legacyFacilityImpl.setWww(legacyFacility.getWww());
		legacyFacilityImpl.setLevel(legacyFacility.getLevel());
		legacyFacilityImpl.setSort(legacyFacility.getSort());

		return legacyFacilityImpl;
	}

	/**
	 * Returns the legacy facility with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy facility
	 * @return the legacy facility
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException if a legacy facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyFacility findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyFacilityException, SystemException {
		LegacyFacility legacyFacility = fetchByPrimaryKey(primaryKey);

		if (legacyFacility == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyFacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyFacility;
	}

	/**
	 * Returns the legacy facility with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException} if it could not be found.
	 *
	 * @param id the primary key of the legacy facility
	 * @return the legacy facility
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException if a legacy facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyFacility findByPrimaryKey(long id)
		throws NoSuchLegacyFacilityException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy facility
	 * @return the legacy facility, or <code>null</code> if a legacy facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyFacility fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyFacility legacyFacility = (LegacyFacility)EntityCacheUtil.getResult(LegacyFacilityModelImpl.ENTITY_CACHE_ENABLED,
				LegacyFacilityImpl.class, primaryKey);

		if (legacyFacility == _nullLegacyFacility) {
			return null;
		}

		if (legacyFacility == null) {
			Session session = null;

			try {
				session = openSession();

				legacyFacility = (LegacyFacility)session.get(LegacyFacilityImpl.class,
						primaryKey);

				if (legacyFacility != null) {
					cacheResult(legacyFacility);
				}
				else {
					EntityCacheUtil.putResult(LegacyFacilityModelImpl.ENTITY_CACHE_ENABLED,
						LegacyFacilityImpl.class, primaryKey,
						_nullLegacyFacility);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyFacilityModelImpl.ENTITY_CACHE_ENABLED,
					LegacyFacilityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyFacility;
	}

	/**
	 * Returns the legacy facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy facility
	 * @return the legacy facility, or <code>null</code> if a legacy facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyFacility fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy facilities.
	 *
	 * @return the legacy facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyFacility> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy facilities
	 * @param end the upper bound of the range of legacy facilities (not inclusive)
	 * @return the range of legacy facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyFacility> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy facilities
	 * @param end the upper bound of the range of legacy facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyFacility> findAll(int start, int end,
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

		List<LegacyFacility> list = (List<LegacyFacility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYFACILITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYFACILITY;

				if (pagination) {
					sql = sql.concat(LegacyFacilityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyFacility>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyFacility>(list);
				}
				else {
					list = (List<LegacyFacility>)QueryUtil.list(q,
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
	 * Removes all the legacy facilities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyFacility legacyFacility : findAll()) {
			remove(legacyFacility);
		}
	}

	/**
	 * Returns the number of legacy facilities.
	 *
	 * @return the number of legacy facilities
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYFACILITY);

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
	 * Initializes the legacy facility persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyFacility")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyFacility>> listenersList = new ArrayList<ModelListener<LegacyFacility>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyFacility>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyFacilityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYFACILITY = "SELECT legacyFacility FROM LegacyFacility legacyFacility";
	private static final String _SQL_COUNT_LEGACYFACILITY = "SELECT COUNT(legacyFacility) FROM LegacyFacility legacyFacility";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyFacility.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyFacility exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyFacilityPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static LegacyFacility _nullLegacyFacility = new LegacyFacilityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyFacility> toCacheModel() {
				return _nullLegacyFacilityCacheModel;
			}
		};

	private static CacheModel<LegacyFacility> _nullLegacyFacilityCacheModel = new CacheModel<LegacyFacility>() {
			@Override
			public LegacyFacility toEntityModel() {
				return _nullLegacyFacility;
			}
		};
}