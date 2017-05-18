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

import de.uhh.l2g.plugins.migration.NoSuchLegacyL2gSysException;
import de.uhh.l2g.plugins.migration.model.LegacyL2gSys;
import de.uhh.l2g.plugins.migration.model.impl.LegacyL2gSysImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyL2gSysModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy l2g sys service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyL2gSysPersistence
 * @see LegacyL2gSysUtil
 * @generated
 */
public class LegacyL2gSysPersistenceImpl extends BasePersistenceImpl<LegacyL2gSys>
	implements LegacyL2gSysPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyL2gSysUtil} to access the legacy l2g sys persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyL2gSysImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyL2gSysModelImpl.ENTITY_CACHE_ENABLED,
			LegacyL2gSysModelImpl.FINDER_CACHE_ENABLED, LegacyL2gSysImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyL2gSysModelImpl.ENTITY_CACHE_ENABLED,
			LegacyL2gSysModelImpl.FINDER_CACHE_ENABLED, LegacyL2gSysImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyL2gSysModelImpl.ENTITY_CACHE_ENABLED,
			LegacyL2gSysModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyL2gSysPersistenceImpl() {
		setModelClass(LegacyL2gSys.class);
	}

	/**
	 * Caches the legacy l2g sys in the entity cache if it is enabled.
	 *
	 * @param legacyL2gSys the legacy l2g sys
	 */
	@Override
	public void cacheResult(LegacyL2gSys legacyL2gSys) {
		EntityCacheUtil.putResult(LegacyL2gSysModelImpl.ENTITY_CACHE_ENABLED,
			LegacyL2gSysImpl.class, legacyL2gSys.getPrimaryKey(), legacyL2gSys);

		legacyL2gSys.resetOriginalValues();
	}

	/**
	 * Caches the legacy l2g syses in the entity cache if it is enabled.
	 *
	 * @param legacyL2gSyses the legacy l2g syses
	 */
	@Override
	public void cacheResult(List<LegacyL2gSys> legacyL2gSyses) {
		for (LegacyL2gSys legacyL2gSys : legacyL2gSyses) {
			if (EntityCacheUtil.getResult(
						LegacyL2gSysModelImpl.ENTITY_CACHE_ENABLED,
						LegacyL2gSysImpl.class, legacyL2gSys.getPrimaryKey()) == null) {
				cacheResult(legacyL2gSys);
			}
			else {
				legacyL2gSys.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy l2g syses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyL2gSysImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyL2gSysImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy l2g sys.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyL2gSys legacyL2gSys) {
		EntityCacheUtil.removeResult(LegacyL2gSysModelImpl.ENTITY_CACHE_ENABLED,
			LegacyL2gSysImpl.class, legacyL2gSys.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyL2gSys> legacyL2gSyses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyL2gSys legacyL2gSys : legacyL2gSyses) {
			EntityCacheUtil.removeResult(LegacyL2gSysModelImpl.ENTITY_CACHE_ENABLED,
				LegacyL2gSysImpl.class, legacyL2gSys.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy l2g sys with the primary key. Does not add the legacy l2g sys to the database.
	 *
	 * @param id the primary key for the new legacy l2g sys
	 * @return the new legacy l2g sys
	 */
	@Override
	public LegacyL2gSys create(int id) {
		LegacyL2gSys legacyL2gSys = new LegacyL2gSysImpl();

		legacyL2gSys.setNew(true);
		legacyL2gSys.setPrimaryKey(id);

		return legacyL2gSys;
	}

	/**
	 * Removes the legacy l2g sys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy l2g sys
	 * @return the legacy l2g sys that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyL2gSysException if a legacy l2g sys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyL2gSys remove(int id)
		throws NoSuchLegacyL2gSysException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy l2g sys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy l2g sys
	 * @return the legacy l2g sys that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyL2gSysException if a legacy l2g sys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyL2gSys remove(Serializable primaryKey)
		throws NoSuchLegacyL2gSysException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyL2gSys legacyL2gSys = (LegacyL2gSys)session.get(LegacyL2gSysImpl.class,
					primaryKey);

			if (legacyL2gSys == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyL2gSysException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyL2gSys);
		}
		catch (NoSuchLegacyL2gSysException nsee) {
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
	protected LegacyL2gSys removeImpl(LegacyL2gSys legacyL2gSys)
		throws SystemException {
		legacyL2gSys = toUnwrappedModel(legacyL2gSys);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyL2gSys)) {
				legacyL2gSys = (LegacyL2gSys)session.get(LegacyL2gSysImpl.class,
						legacyL2gSys.getPrimaryKeyObj());
			}

			if (legacyL2gSys != null) {
				session.delete(legacyL2gSys);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyL2gSys != null) {
			clearCache(legacyL2gSys);
		}

		return legacyL2gSys;
	}

	@Override
	public LegacyL2gSys updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyL2gSys legacyL2gSys)
		throws SystemException {
		legacyL2gSys = toUnwrappedModel(legacyL2gSys);

		boolean isNew = legacyL2gSys.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyL2gSys.isNew()) {
				session.save(legacyL2gSys);

				legacyL2gSys.setNew(false);
			}
			else {
				session.merge(legacyL2gSys);
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

		EntityCacheUtil.putResult(LegacyL2gSysModelImpl.ENTITY_CACHE_ENABLED,
			LegacyL2gSysImpl.class, legacyL2gSys.getPrimaryKey(), legacyL2gSys);

		return legacyL2gSys;
	}

	protected LegacyL2gSys toUnwrappedModel(LegacyL2gSys legacyL2gSys) {
		if (legacyL2gSys instanceof LegacyL2gSysImpl) {
			return legacyL2gSys;
		}

		LegacyL2gSysImpl legacyL2gSysImpl = new LegacyL2gSysImpl();

		legacyL2gSysImpl.setNew(legacyL2gSys.isNew());
		legacyL2gSysImpl.setPrimaryKey(legacyL2gSys.getPrimaryKey());

		legacyL2gSysImpl.setId(legacyL2gSys.getId());
		legacyL2gSysImpl.setVersion(legacyL2gSys.getVersion());
		legacyL2gSysImpl.setSetupwizard(legacyL2gSys.getSetupwizard());

		return legacyL2gSysImpl;
	}

	/**
	 * Returns the legacy l2g sys with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy l2g sys
	 * @return the legacy l2g sys
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyL2gSysException if a legacy l2g sys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyL2gSys findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyL2gSysException, SystemException {
		LegacyL2gSys legacyL2gSys = fetchByPrimaryKey(primaryKey);

		if (legacyL2gSys == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyL2gSysException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyL2gSys;
	}

	/**
	 * Returns the legacy l2g sys with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyL2gSysException} if it could not be found.
	 *
	 * @param id the primary key of the legacy l2g sys
	 * @return the legacy l2g sys
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyL2gSysException if a legacy l2g sys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyL2gSys findByPrimaryKey(int id)
		throws NoSuchLegacyL2gSysException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy l2g sys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy l2g sys
	 * @return the legacy l2g sys, or <code>null</code> if a legacy l2g sys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyL2gSys fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyL2gSys legacyL2gSys = (LegacyL2gSys)EntityCacheUtil.getResult(LegacyL2gSysModelImpl.ENTITY_CACHE_ENABLED,
				LegacyL2gSysImpl.class, primaryKey);

		if (legacyL2gSys == _nullLegacyL2gSys) {
			return null;
		}

		if (legacyL2gSys == null) {
			Session session = null;

			try {
				session = openSession();

				legacyL2gSys = (LegacyL2gSys)session.get(LegacyL2gSysImpl.class,
						primaryKey);

				if (legacyL2gSys != null) {
					cacheResult(legacyL2gSys);
				}
				else {
					EntityCacheUtil.putResult(LegacyL2gSysModelImpl.ENTITY_CACHE_ENABLED,
						LegacyL2gSysImpl.class, primaryKey, _nullLegacyL2gSys);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyL2gSysModelImpl.ENTITY_CACHE_ENABLED,
					LegacyL2gSysImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyL2gSys;
	}

	/**
	 * Returns the legacy l2g sys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy l2g sys
	 * @return the legacy l2g sys, or <code>null</code> if a legacy l2g sys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyL2gSys fetchByPrimaryKey(int id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy l2g syses.
	 *
	 * @return the legacy l2g syses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyL2gSys> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy l2g syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyL2gSysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy l2g syses
	 * @param end the upper bound of the range of legacy l2g syses (not inclusive)
	 * @return the range of legacy l2g syses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyL2gSys> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy l2g syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyL2gSysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy l2g syses
	 * @param end the upper bound of the range of legacy l2g syses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy l2g syses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyL2gSys> findAll(int start, int end,
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

		List<LegacyL2gSys> list = (List<LegacyL2gSys>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYL2GSYS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYL2GSYS;

				if (pagination) {
					sql = sql.concat(LegacyL2gSysModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyL2gSys>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyL2gSys>(list);
				}
				else {
					list = (List<LegacyL2gSys>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legacy l2g syses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyL2gSys legacyL2gSys : findAll()) {
			remove(legacyL2gSys);
		}
	}

	/**
	 * Returns the number of legacy l2g syses.
	 *
	 * @return the number of legacy l2g syses
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYL2GSYS);

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
	 * Initializes the legacy l2g sys persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyL2gSys")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyL2gSys>> listenersList = new ArrayList<ModelListener<LegacyL2gSys>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyL2gSys>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyL2gSysImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYL2GSYS = "SELECT legacyL2gSys FROM LegacyL2gSys legacyL2gSys";
	private static final String _SQL_COUNT_LEGACYL2GSYS = "SELECT COUNT(legacyL2gSys) FROM LegacyL2gSys legacyL2gSys";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyL2gSys.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyL2gSys exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyL2gSysPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static LegacyL2gSys _nullLegacyL2gSys = new LegacyL2gSysImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyL2gSys> toCacheModel() {
				return _nullLegacyL2gSysCacheModel;
			}
		};

	private static CacheModel<LegacyL2gSys> _nullLegacyL2gSysCacheModel = new CacheModel<LegacyL2gSys>() {
			@Override
			public LegacyL2gSys toEntityModel() {
				return _nullLegacyL2gSys;
			}
		};
}