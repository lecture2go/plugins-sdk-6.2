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

import de.uhh.l2g.plugins.migration.NoSuchLegacyVideoFacilityException;
import de.uhh.l2g.plugins.migration.model.LegacyVideoFacility;
import de.uhh.l2g.plugins.migration.model.impl.LegacyVideoFacilityImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyVideoFacilityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legacy video facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyVideoFacilityPersistence
 * @see LegacyVideoFacilityUtil
 * @generated
 */
public class LegacyVideoFacilityPersistenceImpl extends BasePersistenceImpl<LegacyVideoFacility>
	implements LegacyVideoFacilityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyVideoFacilityUtil} to access the legacy video facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyVideoFacilityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyVideoFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoFacilityModelImpl.FINDER_CACHE_ENABLED,
			LegacyVideoFacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyVideoFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoFacilityModelImpl.FINDER_CACHE_ENABLED,
			LegacyVideoFacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyVideoFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoFacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyVideoFacilityPersistenceImpl() {
		setModelClass(LegacyVideoFacility.class);
	}

	/**
	 * Caches the legacy video facility in the entity cache if it is enabled.
	 *
	 * @param legacyVideoFacility the legacy video facility
	 */
	@Override
	public void cacheResult(LegacyVideoFacility legacyVideoFacility) {
		EntityCacheUtil.putResult(LegacyVideoFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoFacilityImpl.class, legacyVideoFacility.getPrimaryKey(),
			legacyVideoFacility);

		legacyVideoFacility.resetOriginalValues();
	}

	/**
	 * Caches the legacy video facilities in the entity cache if it is enabled.
	 *
	 * @param legacyVideoFacilities the legacy video facilities
	 */
	@Override
	public void cacheResult(List<LegacyVideoFacility> legacyVideoFacilities) {
		for (LegacyVideoFacility legacyVideoFacility : legacyVideoFacilities) {
			if (EntityCacheUtil.getResult(
						LegacyVideoFacilityModelImpl.ENTITY_CACHE_ENABLED,
						LegacyVideoFacilityImpl.class,
						legacyVideoFacility.getPrimaryKey()) == null) {
				cacheResult(legacyVideoFacility);
			}
			else {
				legacyVideoFacility.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy video facilities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyVideoFacilityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyVideoFacilityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy video facility.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyVideoFacility legacyVideoFacility) {
		EntityCacheUtil.removeResult(LegacyVideoFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoFacilityImpl.class, legacyVideoFacility.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyVideoFacility> legacyVideoFacilities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyVideoFacility legacyVideoFacility : legacyVideoFacilities) {
			EntityCacheUtil.removeResult(LegacyVideoFacilityModelImpl.ENTITY_CACHE_ENABLED,
				LegacyVideoFacilityImpl.class,
				legacyVideoFacility.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy video facility with the primary key. Does not add the legacy video facility to the database.
	 *
	 * @param videoFacilityId the primary key for the new legacy video facility
	 * @return the new legacy video facility
	 */
	@Override
	public LegacyVideoFacility create(long videoFacilityId) {
		LegacyVideoFacility legacyVideoFacility = new LegacyVideoFacilityImpl();

		legacyVideoFacility.setNew(true);
		legacyVideoFacility.setPrimaryKey(videoFacilityId);

		return legacyVideoFacility;
	}

	/**
	 * Removes the legacy video facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoFacilityId the primary key of the legacy video facility
	 * @return the legacy video facility that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoFacilityException if a legacy video facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideoFacility remove(long videoFacilityId)
		throws NoSuchLegacyVideoFacilityException, SystemException {
		return remove((Serializable)videoFacilityId);
	}

	/**
	 * Removes the legacy video facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy video facility
	 * @return the legacy video facility that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoFacilityException if a legacy video facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideoFacility remove(Serializable primaryKey)
		throws NoSuchLegacyVideoFacilityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyVideoFacility legacyVideoFacility = (LegacyVideoFacility)session.get(LegacyVideoFacilityImpl.class,
					primaryKey);

			if (legacyVideoFacility == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyVideoFacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyVideoFacility);
		}
		catch (NoSuchLegacyVideoFacilityException nsee) {
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
	protected LegacyVideoFacility removeImpl(
		LegacyVideoFacility legacyVideoFacility) throws SystemException {
		legacyVideoFacility = toUnwrappedModel(legacyVideoFacility);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyVideoFacility)) {
				legacyVideoFacility = (LegacyVideoFacility)session.get(LegacyVideoFacilityImpl.class,
						legacyVideoFacility.getPrimaryKeyObj());
			}

			if (legacyVideoFacility != null) {
				session.delete(legacyVideoFacility);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyVideoFacility != null) {
			clearCache(legacyVideoFacility);
		}

		return legacyVideoFacility;
	}

	@Override
	public LegacyVideoFacility updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyVideoFacility legacyVideoFacility)
		throws SystemException {
		legacyVideoFacility = toUnwrappedModel(legacyVideoFacility);

		boolean isNew = legacyVideoFacility.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyVideoFacility.isNew()) {
				session.save(legacyVideoFacility);

				legacyVideoFacility.setNew(false);
			}
			else {
				session.merge(legacyVideoFacility);
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

		EntityCacheUtil.putResult(LegacyVideoFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoFacilityImpl.class, legacyVideoFacility.getPrimaryKey(),
			legacyVideoFacility);

		return legacyVideoFacility;
	}

	protected LegacyVideoFacility toUnwrappedModel(
		LegacyVideoFacility legacyVideoFacility) {
		if (legacyVideoFacility instanceof LegacyVideoFacilityImpl) {
			return legacyVideoFacility;
		}

		LegacyVideoFacilityImpl legacyVideoFacilityImpl = new LegacyVideoFacilityImpl();

		legacyVideoFacilityImpl.setNew(legacyVideoFacility.isNew());
		legacyVideoFacilityImpl.setPrimaryKey(legacyVideoFacility.getPrimaryKey());

		legacyVideoFacilityImpl.setVideoFacilityId(legacyVideoFacility.getVideoFacilityId());
		legacyVideoFacilityImpl.setVideoId(legacyVideoFacility.getVideoId());
		legacyVideoFacilityImpl.setFacilityId(legacyVideoFacility.getFacilityId());

		return legacyVideoFacilityImpl;
	}

	/**
	 * Returns the legacy video facility with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy video facility
	 * @return the legacy video facility
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoFacilityException if a legacy video facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideoFacility findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyVideoFacilityException, SystemException {
		LegacyVideoFacility legacyVideoFacility = fetchByPrimaryKey(primaryKey);

		if (legacyVideoFacility == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyVideoFacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyVideoFacility;
	}

	/**
	 * Returns the legacy video facility with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyVideoFacilityException} if it could not be found.
	 *
	 * @param videoFacilityId the primary key of the legacy video facility
	 * @return the legacy video facility
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoFacilityException if a legacy video facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideoFacility findByPrimaryKey(long videoFacilityId)
		throws NoSuchLegacyVideoFacilityException, SystemException {
		return findByPrimaryKey((Serializable)videoFacilityId);
	}

	/**
	 * Returns the legacy video facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy video facility
	 * @return the legacy video facility, or <code>null</code> if a legacy video facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideoFacility fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyVideoFacility legacyVideoFacility = (LegacyVideoFacility)EntityCacheUtil.getResult(LegacyVideoFacilityModelImpl.ENTITY_CACHE_ENABLED,
				LegacyVideoFacilityImpl.class, primaryKey);

		if (legacyVideoFacility == _nullLegacyVideoFacility) {
			return null;
		}

		if (legacyVideoFacility == null) {
			Session session = null;

			try {
				session = openSession();

				legacyVideoFacility = (LegacyVideoFacility)session.get(LegacyVideoFacilityImpl.class,
						primaryKey);

				if (legacyVideoFacility != null) {
					cacheResult(legacyVideoFacility);
				}
				else {
					EntityCacheUtil.putResult(LegacyVideoFacilityModelImpl.ENTITY_CACHE_ENABLED,
						LegacyVideoFacilityImpl.class, primaryKey,
						_nullLegacyVideoFacility);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyVideoFacilityModelImpl.ENTITY_CACHE_ENABLED,
					LegacyVideoFacilityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyVideoFacility;
	}

	/**
	 * Returns the legacy video facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoFacilityId the primary key of the legacy video facility
	 * @return the legacy video facility, or <code>null</code> if a legacy video facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideoFacility fetchByPrimaryKey(long videoFacilityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)videoFacilityId);
	}

	/**
	 * Returns all the legacy video facilities.
	 *
	 * @return the legacy video facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyVideoFacility> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy video facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyVideoFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy video facilities
	 * @param end the upper bound of the range of legacy video facilities (not inclusive)
	 * @return the range of legacy video facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyVideoFacility> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy video facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyVideoFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy video facilities
	 * @param end the upper bound of the range of legacy video facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy video facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyVideoFacility> findAll(int start, int end,
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

		List<LegacyVideoFacility> list = (List<LegacyVideoFacility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYVIDEOFACILITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYVIDEOFACILITY;

				if (pagination) {
					sql = sql.concat(LegacyVideoFacilityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyVideoFacility>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyVideoFacility>(list);
				}
				else {
					list = (List<LegacyVideoFacility>)QueryUtil.list(q,
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
	 * Removes all the legacy video facilities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyVideoFacility legacyVideoFacility : findAll()) {
			remove(legacyVideoFacility);
		}
	}

	/**
	 * Returns the number of legacy video facilities.
	 *
	 * @return the number of legacy video facilities
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYVIDEOFACILITY);

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
	 * Initializes the legacy video facility persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyVideoFacility")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyVideoFacility>> listenersList = new ArrayList<ModelListener<LegacyVideoFacility>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyVideoFacility>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyVideoFacilityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYVIDEOFACILITY = "SELECT legacyVideoFacility FROM LegacyVideoFacility legacyVideoFacility";
	private static final String _SQL_COUNT_LEGACYVIDEOFACILITY = "SELECT COUNT(legacyVideoFacility) FROM LegacyVideoFacility legacyVideoFacility";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyVideoFacility.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyVideoFacility exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyVideoFacilityPersistenceImpl.class);
	private static LegacyVideoFacility _nullLegacyVideoFacility = new LegacyVideoFacilityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyVideoFacility> toCacheModel() {
				return _nullLegacyVideoFacilityCacheModel;
			}
		};

	private static CacheModel<LegacyVideoFacility> _nullLegacyVideoFacilityCacheModel =
		new CacheModel<LegacyVideoFacility>() {
			@Override
			public LegacyVideoFacility toEntityModel() {
				return _nullLegacyVideoFacility;
			}
		};
}