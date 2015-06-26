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

package de.uhh.l2g.plugins.service.persistence;

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

import de.uhh.l2g.plugins.NoSuchSysException;
import de.uhh.l2g.plugins.model.Sys;
import de.uhh.l2g.plugins.model.impl.SysImpl;
import de.uhh.l2g.plugins.model.impl.SysModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sys service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see SysPersistence
 * @see SysUtil
 * @generated
 */
public class SysPersistenceImpl extends BasePersistenceImpl<Sys>
	implements SysPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SysUtil} to access the sys persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SysImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SysModelImpl.ENTITY_CACHE_ENABLED,
			SysModelImpl.FINDER_CACHE_ENABLED, SysImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SysModelImpl.ENTITY_CACHE_ENABLED,
			SysModelImpl.FINDER_CACHE_ENABLED, SysImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SysModelImpl.ENTITY_CACHE_ENABLED,
			SysModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SysPersistenceImpl() {
		setModelClass(Sys.class);
	}

	/**
	 * Caches the sys in the entity cache if it is enabled.
	 *
	 * @param sys the sys
	 */
	@Override
	public void cacheResult(Sys sys) {
		EntityCacheUtil.putResult(SysModelImpl.ENTITY_CACHE_ENABLED,
			SysImpl.class, sys.getPrimaryKey(), sys);

		sys.resetOriginalValues();
	}

	/**
	 * Caches the syses in the entity cache if it is enabled.
	 *
	 * @param syses the syses
	 */
	@Override
	public void cacheResult(List<Sys> syses) {
		for (Sys sys : syses) {
			if (EntityCacheUtil.getResult(SysModelImpl.ENTITY_CACHE_ENABLED,
						SysImpl.class, sys.getPrimaryKey()) == null) {
				cacheResult(sys);
			}
			else {
				sys.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all syses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SysImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SysImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sys.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Sys sys) {
		EntityCacheUtil.removeResult(SysModelImpl.ENTITY_CACHE_ENABLED,
			SysImpl.class, sys.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Sys> syses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Sys sys : syses) {
			EntityCacheUtil.removeResult(SysModelImpl.ENTITY_CACHE_ENABLED,
				SysImpl.class, sys.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sys with the primary key. Does not add the sys to the database.
	 *
	 * @param sysId the primary key for the new sys
	 * @return the new sys
	 */
	@Override
	public Sys create(int sysId) {
		Sys sys = new SysImpl();

		sys.setNew(true);
		sys.setPrimaryKey(sysId);

		return sys;
	}

	/**
	 * Removes the sys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sysId the primary key of the sys
	 * @return the sys that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchSysException if a sys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sys remove(int sysId) throws NoSuchSysException, SystemException {
		return remove((Serializable)sysId);
	}

	/**
	 * Removes the sys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sys
	 * @return the sys that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchSysException if a sys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sys remove(Serializable primaryKey)
		throws NoSuchSysException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Sys sys = (Sys)session.get(SysImpl.class, primaryKey);

			if (sys == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSysException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sys);
		}
		catch (NoSuchSysException nsee) {
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
	protected Sys removeImpl(Sys sys) throws SystemException {
		sys = toUnwrappedModel(sys);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sys)) {
				sys = (Sys)session.get(SysImpl.class, sys.getPrimaryKeyObj());
			}

			if (sys != null) {
				session.delete(sys);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sys != null) {
			clearCache(sys);
		}

		return sys;
	}

	@Override
	public Sys updateImpl(de.uhh.l2g.plugins.model.Sys sys)
		throws SystemException {
		sys = toUnwrappedModel(sys);

		boolean isNew = sys.isNew();

		Session session = null;

		try {
			session = openSession();

			if (sys.isNew()) {
				session.save(sys);

				sys.setNew(false);
			}
			else {
				session.merge(sys);
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

		EntityCacheUtil.putResult(SysModelImpl.ENTITY_CACHE_ENABLED,
			SysImpl.class, sys.getPrimaryKey(), sys);

		return sys;
	}

	protected Sys toUnwrappedModel(Sys sys) {
		if (sys instanceof SysImpl) {
			return sys;
		}

		SysImpl sysImpl = new SysImpl();

		sysImpl.setNew(sys.isNew());
		sysImpl.setPrimaryKey(sys.getPrimaryKey());

		sysImpl.setSysId(sys.getSysId());
		sysImpl.setVersion(sys.getVersion());
		sysImpl.setSetupWizard(sys.getSetupWizard());

		return sysImpl;
	}

	/**
	 * Returns the sys with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sys
	 * @return the sys
	 * @throws de.uhh.l2g.plugins.NoSuchSysException if a sys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sys findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSysException, SystemException {
		Sys sys = fetchByPrimaryKey(primaryKey);

		if (sys == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSysException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sys;
	}

	/**
	 * Returns the sys with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchSysException} if it could not be found.
	 *
	 * @param sysId the primary key of the sys
	 * @return the sys
	 * @throws de.uhh.l2g.plugins.NoSuchSysException if a sys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sys findByPrimaryKey(int sysId)
		throws NoSuchSysException, SystemException {
		return findByPrimaryKey((Serializable)sysId);
	}

	/**
	 * Returns the sys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sys
	 * @return the sys, or <code>null</code> if a sys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sys fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Sys sys = (Sys)EntityCacheUtil.getResult(SysModelImpl.ENTITY_CACHE_ENABLED,
				SysImpl.class, primaryKey);

		if (sys == _nullSys) {
			return null;
		}

		if (sys == null) {
			Session session = null;

			try {
				session = openSession();

				sys = (Sys)session.get(SysImpl.class, primaryKey);

				if (sys != null) {
					cacheResult(sys);
				}
				else {
					EntityCacheUtil.putResult(SysModelImpl.ENTITY_CACHE_ENABLED,
						SysImpl.class, primaryKey, _nullSys);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SysModelImpl.ENTITY_CACHE_ENABLED,
					SysImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sys;
	}

	/**
	 * Returns the sys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sysId the primary key of the sys
	 * @return the sys, or <code>null</code> if a sys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sys fetchByPrimaryKey(int sysId) throws SystemException {
		return fetchByPrimaryKey((Serializable)sysId);
	}

	/**
	 * Returns all the syses.
	 *
	 * @return the syses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sys> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of syses
	 * @param end the upper bound of the range of syses (not inclusive)
	 * @return the range of syses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sys> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of syses
	 * @param end the upper bound of the range of syses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of syses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sys> findAll(int start, int end,
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

		List<Sys> list = (List<Sys>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SYS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SYS;

				if (pagination) {
					sql = sql.concat(SysModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Sys>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Sys>(list);
				}
				else {
					list = (List<Sys>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the syses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Sys sys : findAll()) {
			remove(sys);
		}
	}

	/**
	 * Returns the number of syses.
	 *
	 * @return the number of syses
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

				Query q = session.createQuery(_SQL_COUNT_SYS);

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
	 * Initializes the sys persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Sys")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Sys>> listenersList = new ArrayList<ModelListener<Sys>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Sys>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SysImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SYS = "SELECT sys FROM Sys sys";
	private static final String _SQL_COUNT_SYS = "SELECT COUNT(sys) FROM Sys sys";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sys.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Sys exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SysPersistenceImpl.class);
	private static Sys _nullSys = new SysImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Sys> toCacheModel() {
				return _nullSysCacheModel;
			}
		};

	private static CacheModel<Sys> _nullSysCacheModel = new CacheModel<Sys>() {
			@Override
			public Sys toEntityModel() {
				return _nullSys;
			}
		};
}