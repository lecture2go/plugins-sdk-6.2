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

import de.uhh.l2g.plugins.migration.NoSuchLegacyLicenseException;
import de.uhh.l2g.plugins.migration.model.LegacyLicense;
import de.uhh.l2g.plugins.migration.model.impl.LegacyLicenseImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyLicenseModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyLicensePersistence
 * @see LegacyLicenseUtil
 * @generated
 */
public class LegacyLicensePersistenceImpl extends BasePersistenceImpl<LegacyLicense>
	implements LegacyLicensePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyLicenseUtil} to access the legacy license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyLicenseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyLicenseModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLicenseModelImpl.FINDER_CACHE_ENABLED,
			LegacyLicenseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyLicenseModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLicenseModelImpl.FINDER_CACHE_ENABLED,
			LegacyLicenseImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyLicenseModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLicenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyLicensePersistenceImpl() {
		setModelClass(LegacyLicense.class);
	}

	/**
	 * Caches the legacy license in the entity cache if it is enabled.
	 *
	 * @param legacyLicense the legacy license
	 */
	@Override
	public void cacheResult(LegacyLicense legacyLicense) {
		EntityCacheUtil.putResult(LegacyLicenseModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLicenseImpl.class, legacyLicense.getPrimaryKey(),
			legacyLicense);

		legacyLicense.resetOriginalValues();
	}

	/**
	 * Caches the legacy licenses in the entity cache if it is enabled.
	 *
	 * @param legacyLicenses the legacy licenses
	 */
	@Override
	public void cacheResult(List<LegacyLicense> legacyLicenses) {
		for (LegacyLicense legacyLicense : legacyLicenses) {
			if (EntityCacheUtil.getResult(
						LegacyLicenseModelImpl.ENTITY_CACHE_ENABLED,
						LegacyLicenseImpl.class, legacyLicense.getPrimaryKey()) == null) {
				cacheResult(legacyLicense);
			}
			else {
				legacyLicense.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy licenses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyLicenseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyLicenseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy license.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyLicense legacyLicense) {
		EntityCacheUtil.removeResult(LegacyLicenseModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLicenseImpl.class, legacyLicense.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyLicense> legacyLicenses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyLicense legacyLicense : legacyLicenses) {
			EntityCacheUtil.removeResult(LegacyLicenseModelImpl.ENTITY_CACHE_ENABLED,
				LegacyLicenseImpl.class, legacyLicense.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy license with the primary key. Does not add the legacy license to the database.
	 *
	 * @param id the primary key for the new legacy license
	 * @return the new legacy license
	 */
	@Override
	public LegacyLicense create(long id) {
		LegacyLicense legacyLicense = new LegacyLicenseImpl();

		legacyLicense.setNew(true);
		legacyLicense.setPrimaryKey(id);

		return legacyLicense;
	}

	/**
	 * Removes the legacy license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy license
	 * @return the legacy license that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLicenseException if a legacy license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLicense remove(long id)
		throws NoSuchLegacyLicenseException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy license
	 * @return the legacy license that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLicenseException if a legacy license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLicense remove(Serializable primaryKey)
		throws NoSuchLegacyLicenseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyLicense legacyLicense = (LegacyLicense)session.get(LegacyLicenseImpl.class,
					primaryKey);

			if (legacyLicense == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyLicenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyLicense);
		}
		catch (NoSuchLegacyLicenseException nsee) {
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
	protected LegacyLicense removeImpl(LegacyLicense legacyLicense)
		throws SystemException {
		legacyLicense = toUnwrappedModel(legacyLicense);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyLicense)) {
				legacyLicense = (LegacyLicense)session.get(LegacyLicenseImpl.class,
						legacyLicense.getPrimaryKeyObj());
			}

			if (legacyLicense != null) {
				session.delete(legacyLicense);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyLicense != null) {
			clearCache(legacyLicense);
		}

		return legacyLicense;
	}

	@Override
	public LegacyLicense updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyLicense legacyLicense)
		throws SystemException {
		legacyLicense = toUnwrappedModel(legacyLicense);

		boolean isNew = legacyLicense.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyLicense.isNew()) {
				session.save(legacyLicense);

				legacyLicense.setNew(false);
			}
			else {
				session.merge(legacyLicense);
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

		EntityCacheUtil.putResult(LegacyLicenseModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLicenseImpl.class, legacyLicense.getPrimaryKey(),
			legacyLicense);

		return legacyLicense;
	}

	protected LegacyLicense toUnwrappedModel(LegacyLicense legacyLicense) {
		if (legacyLicense instanceof LegacyLicenseImpl) {
			return legacyLicense;
		}

		LegacyLicenseImpl legacyLicenseImpl = new LegacyLicenseImpl();

		legacyLicenseImpl.setNew(legacyLicense.isNew());
		legacyLicenseImpl.setPrimaryKey(legacyLicense.getPrimaryKey());

		legacyLicenseImpl.setId(legacyLicense.getId());
		legacyLicenseImpl.setVideoId(legacyLicense.getVideoId());
		legacyLicenseImpl.setCcby(legacyLicense.getCcby());
		legacyLicenseImpl.setCcbybc(legacyLicense.getCcbybc());
		legacyLicenseImpl.setCcbyncnd(legacyLicense.getCcbyncnd());
		legacyLicenseImpl.setCcbyncsa(legacyLicense.getCcbyncsa());
		legacyLicenseImpl.setCcbysa(legacyLicense.getCcbysa());
		legacyLicenseImpl.setCcbync(legacyLicense.getCcbync());
		legacyLicenseImpl.setL2go(legacyLicense.getL2go());

		return legacyLicenseImpl;
	}

	/**
	 * Returns the legacy license with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy license
	 * @return the legacy license
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLicenseException if a legacy license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLicense findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyLicenseException, SystemException {
		LegacyLicense legacyLicense = fetchByPrimaryKey(primaryKey);

		if (legacyLicense == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyLicenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyLicense;
	}

	/**
	 * Returns the legacy license with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyLicenseException} if it could not be found.
	 *
	 * @param id the primary key of the legacy license
	 * @return the legacy license
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLicenseException if a legacy license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLicense findByPrimaryKey(long id)
		throws NoSuchLegacyLicenseException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy license
	 * @return the legacy license, or <code>null</code> if a legacy license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLicense fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyLicense legacyLicense = (LegacyLicense)EntityCacheUtil.getResult(LegacyLicenseModelImpl.ENTITY_CACHE_ENABLED,
				LegacyLicenseImpl.class, primaryKey);

		if (legacyLicense == _nullLegacyLicense) {
			return null;
		}

		if (legacyLicense == null) {
			Session session = null;

			try {
				session = openSession();

				legacyLicense = (LegacyLicense)session.get(LegacyLicenseImpl.class,
						primaryKey);

				if (legacyLicense != null) {
					cacheResult(legacyLicense);
				}
				else {
					EntityCacheUtil.putResult(LegacyLicenseModelImpl.ENTITY_CACHE_ENABLED,
						LegacyLicenseImpl.class, primaryKey, _nullLegacyLicense);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyLicenseModelImpl.ENTITY_CACHE_ENABLED,
					LegacyLicenseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyLicense;
	}

	/**
	 * Returns the legacy license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy license
	 * @return the legacy license, or <code>null</code> if a legacy license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLicense fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy licenses.
	 *
	 * @return the legacy licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyLicense> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy licenses
	 * @param end the upper bound of the range of legacy licenses (not inclusive)
	 * @return the range of legacy licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyLicense> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy licenses
	 * @param end the upper bound of the range of legacy licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyLicense> findAll(int start, int end,
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

		List<LegacyLicense> list = (List<LegacyLicense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYLICENSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYLICENSE;

				if (pagination) {
					sql = sql.concat(LegacyLicenseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyLicense>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyLicense>(list);
				}
				else {
					list = (List<LegacyLicense>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legacy licenses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyLicense legacyLicense : findAll()) {
			remove(legacyLicense);
		}
	}

	/**
	 * Returns the number of legacy licenses.
	 *
	 * @return the number of legacy licenses
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYLICENSE);

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
	 * Initializes the legacy license persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyLicense")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyLicense>> listenersList = new ArrayList<ModelListener<LegacyLicense>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyLicense>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyLicenseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYLICENSE = "SELECT legacyLicense FROM LegacyLicense legacyLicense";
	private static final String _SQL_COUNT_LEGACYLICENSE = "SELECT COUNT(legacyLicense) FROM LegacyLicense legacyLicense";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyLicense.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyLicense exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyLicensePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static LegacyLicense _nullLegacyLicense = new LegacyLicenseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyLicense> toCacheModel() {
				return _nullLegacyLicenseCacheModel;
			}
		};

	private static CacheModel<LegacyLicense> _nullLegacyLicenseCacheModel = new CacheModel<LegacyLicense>() {
			@Override
			public LegacyLicense toEntityModel() {
				return _nullLegacyLicense;
			}
		};
}