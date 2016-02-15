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

import de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityHostException;
import de.uhh.l2g.plugins.migration.model.LegacyFacilityHost;
import de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityHostImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityHostModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legacy facility host service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyFacilityHostPersistence
 * @see LegacyFacilityHostUtil
 * @generated
 */
public class LegacyFacilityHostPersistenceImpl extends BasePersistenceImpl<LegacyFacilityHost>
	implements LegacyFacilityHostPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyFacilityHostUtil} to access the legacy facility host persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyFacilityHostImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyFacilityHostModelImpl.ENTITY_CACHE_ENABLED,
			LegacyFacilityHostModelImpl.FINDER_CACHE_ENABLED,
			LegacyFacilityHostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyFacilityHostModelImpl.ENTITY_CACHE_ENABLED,
			LegacyFacilityHostModelImpl.FINDER_CACHE_ENABLED,
			LegacyFacilityHostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyFacilityHostModelImpl.ENTITY_CACHE_ENABLED,
			LegacyFacilityHostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyFacilityHostPersistenceImpl() {
		setModelClass(LegacyFacilityHost.class);
	}

	/**
	 * Caches the legacy facility host in the entity cache if it is enabled.
	 *
	 * @param legacyFacilityHost the legacy facility host
	 */
	@Override
	public void cacheResult(LegacyFacilityHost legacyFacilityHost) {
		EntityCacheUtil.putResult(LegacyFacilityHostModelImpl.ENTITY_CACHE_ENABLED,
			LegacyFacilityHostImpl.class, legacyFacilityHost.getPrimaryKey(),
			legacyFacilityHost);

		legacyFacilityHost.resetOriginalValues();
	}

	/**
	 * Caches the legacy facility hosts in the entity cache if it is enabled.
	 *
	 * @param legacyFacilityHosts the legacy facility hosts
	 */
	@Override
	public void cacheResult(List<LegacyFacilityHost> legacyFacilityHosts) {
		for (LegacyFacilityHost legacyFacilityHost : legacyFacilityHosts) {
			if (EntityCacheUtil.getResult(
						LegacyFacilityHostModelImpl.ENTITY_CACHE_ENABLED,
						LegacyFacilityHostImpl.class,
						legacyFacilityHost.getPrimaryKey()) == null) {
				cacheResult(legacyFacilityHost);
			}
			else {
				legacyFacilityHost.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy facility hosts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyFacilityHostImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyFacilityHostImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy facility host.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyFacilityHost legacyFacilityHost) {
		EntityCacheUtil.removeResult(LegacyFacilityHostModelImpl.ENTITY_CACHE_ENABLED,
			LegacyFacilityHostImpl.class, legacyFacilityHost.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyFacilityHost> legacyFacilityHosts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyFacilityHost legacyFacilityHost : legacyFacilityHosts) {
			EntityCacheUtil.removeResult(LegacyFacilityHostModelImpl.ENTITY_CACHE_ENABLED,
				LegacyFacilityHostImpl.class, legacyFacilityHost.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy facility host with the primary key. Does not add the legacy facility host to the database.
	 *
	 * @param facilityHostId the primary key for the new legacy facility host
	 * @return the new legacy facility host
	 */
	@Override
	public LegacyFacilityHost create(long facilityHostId) {
		LegacyFacilityHost legacyFacilityHost = new LegacyFacilityHostImpl();

		legacyFacilityHost.setNew(true);
		legacyFacilityHost.setPrimaryKey(facilityHostId);

		return legacyFacilityHost;
	}

	/**
	 * Removes the legacy facility host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facilityHostId the primary key of the legacy facility host
	 * @return the legacy facility host that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityHostException if a legacy facility host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyFacilityHost remove(long facilityHostId)
		throws NoSuchLegacyFacilityHostException, SystemException {
		return remove((Serializable)facilityHostId);
	}

	/**
	 * Removes the legacy facility host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy facility host
	 * @return the legacy facility host that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityHostException if a legacy facility host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyFacilityHost remove(Serializable primaryKey)
		throws NoSuchLegacyFacilityHostException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyFacilityHost legacyFacilityHost = (LegacyFacilityHost)session.get(LegacyFacilityHostImpl.class,
					primaryKey);

			if (legacyFacilityHost == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyFacilityHostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyFacilityHost);
		}
		catch (NoSuchLegacyFacilityHostException nsee) {
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
	protected LegacyFacilityHost removeImpl(
		LegacyFacilityHost legacyFacilityHost) throws SystemException {
		legacyFacilityHost = toUnwrappedModel(legacyFacilityHost);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyFacilityHost)) {
				legacyFacilityHost = (LegacyFacilityHost)session.get(LegacyFacilityHostImpl.class,
						legacyFacilityHost.getPrimaryKeyObj());
			}

			if (legacyFacilityHost != null) {
				session.delete(legacyFacilityHost);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyFacilityHost != null) {
			clearCache(legacyFacilityHost);
		}

		return legacyFacilityHost;
	}

	@Override
	public LegacyFacilityHost updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyFacilityHost legacyFacilityHost)
		throws SystemException {
		legacyFacilityHost = toUnwrappedModel(legacyFacilityHost);

		boolean isNew = legacyFacilityHost.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyFacilityHost.isNew()) {
				session.save(legacyFacilityHost);

				legacyFacilityHost.setNew(false);
			}
			else {
				session.merge(legacyFacilityHost);
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

		EntityCacheUtil.putResult(LegacyFacilityHostModelImpl.ENTITY_CACHE_ENABLED,
			LegacyFacilityHostImpl.class, legacyFacilityHost.getPrimaryKey(),
			legacyFacilityHost);

		return legacyFacilityHost;
	}

	protected LegacyFacilityHost toUnwrappedModel(
		LegacyFacilityHost legacyFacilityHost) {
		if (legacyFacilityHost instanceof LegacyFacilityHostImpl) {
			return legacyFacilityHost;
		}

		LegacyFacilityHostImpl legacyFacilityHostImpl = new LegacyFacilityHostImpl();

		legacyFacilityHostImpl.setNew(legacyFacilityHost.isNew());
		legacyFacilityHostImpl.setPrimaryKey(legacyFacilityHost.getPrimaryKey());

		legacyFacilityHostImpl.setFacilityHostId(legacyFacilityHost.getFacilityHostId());
		legacyFacilityHostImpl.setFacilityId(legacyFacilityHost.getFacilityId());
		legacyFacilityHostImpl.setHostId(legacyFacilityHost.getHostId());

		return legacyFacilityHostImpl;
	}

	/**
	 * Returns the legacy facility host with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy facility host
	 * @return the legacy facility host
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityHostException if a legacy facility host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyFacilityHost findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyFacilityHostException, SystemException {
		LegacyFacilityHost legacyFacilityHost = fetchByPrimaryKey(primaryKey);

		if (legacyFacilityHost == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyFacilityHostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyFacilityHost;
	}

	/**
	 * Returns the legacy facility host with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityHostException} if it could not be found.
	 *
	 * @param facilityHostId the primary key of the legacy facility host
	 * @return the legacy facility host
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityHostException if a legacy facility host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyFacilityHost findByPrimaryKey(long facilityHostId)
		throws NoSuchLegacyFacilityHostException, SystemException {
		return findByPrimaryKey((Serializable)facilityHostId);
	}

	/**
	 * Returns the legacy facility host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy facility host
	 * @return the legacy facility host, or <code>null</code> if a legacy facility host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyFacilityHost fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyFacilityHost legacyFacilityHost = (LegacyFacilityHost)EntityCacheUtil.getResult(LegacyFacilityHostModelImpl.ENTITY_CACHE_ENABLED,
				LegacyFacilityHostImpl.class, primaryKey);

		if (legacyFacilityHost == _nullLegacyFacilityHost) {
			return null;
		}

		if (legacyFacilityHost == null) {
			Session session = null;

			try {
				session = openSession();

				legacyFacilityHost = (LegacyFacilityHost)session.get(LegacyFacilityHostImpl.class,
						primaryKey);

				if (legacyFacilityHost != null) {
					cacheResult(legacyFacilityHost);
				}
				else {
					EntityCacheUtil.putResult(LegacyFacilityHostModelImpl.ENTITY_CACHE_ENABLED,
						LegacyFacilityHostImpl.class, primaryKey,
						_nullLegacyFacilityHost);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyFacilityHostModelImpl.ENTITY_CACHE_ENABLED,
					LegacyFacilityHostImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyFacilityHost;
	}

	/**
	 * Returns the legacy facility host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facilityHostId the primary key of the legacy facility host
	 * @return the legacy facility host, or <code>null</code> if a legacy facility host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyFacilityHost fetchByPrimaryKey(long facilityHostId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)facilityHostId);
	}

	/**
	 * Returns all the legacy facility hosts.
	 *
	 * @return the legacy facility hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyFacilityHost> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy facility hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityHostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy facility hosts
	 * @param end the upper bound of the range of legacy facility hosts (not inclusive)
	 * @return the range of legacy facility hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyFacilityHost> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy facility hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityHostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy facility hosts
	 * @param end the upper bound of the range of legacy facility hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy facility hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyFacilityHost> findAll(int start, int end,
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

		List<LegacyFacilityHost> list = (List<LegacyFacilityHost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYFACILITYHOST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYFACILITYHOST;

				if (pagination) {
					sql = sql.concat(LegacyFacilityHostModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyFacilityHost>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyFacilityHost>(list);
				}
				else {
					list = (List<LegacyFacilityHost>)QueryUtil.list(q,
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
	 * Removes all the legacy facility hosts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyFacilityHost legacyFacilityHost : findAll()) {
			remove(legacyFacilityHost);
		}
	}

	/**
	 * Returns the number of legacy facility hosts.
	 *
	 * @return the number of legacy facility hosts
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYFACILITYHOST);

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
	 * Initializes the legacy facility host persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyFacilityHost")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyFacilityHost>> listenersList = new ArrayList<ModelListener<LegacyFacilityHost>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyFacilityHost>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyFacilityHostImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYFACILITYHOST = "SELECT legacyFacilityHost FROM LegacyFacilityHost legacyFacilityHost";
	private static final String _SQL_COUNT_LEGACYFACILITYHOST = "SELECT COUNT(legacyFacilityHost) FROM LegacyFacilityHost legacyFacilityHost";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyFacilityHost.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyFacilityHost exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyFacilityHostPersistenceImpl.class);
	private static LegacyFacilityHost _nullLegacyFacilityHost = new LegacyFacilityHostImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyFacilityHost> toCacheModel() {
				return _nullLegacyFacilityHostCacheModel;
			}
		};

	private static CacheModel<LegacyFacilityHost> _nullLegacyFacilityHostCacheModel =
		new CacheModel<LegacyFacilityHost>() {
			@Override
			public LegacyFacilityHost toEntityModel() {
				return _nullLegacyFacilityHost;
			}
		};
}