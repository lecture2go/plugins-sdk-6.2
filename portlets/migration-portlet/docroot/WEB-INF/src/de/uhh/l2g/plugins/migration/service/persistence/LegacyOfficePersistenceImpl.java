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

import de.uhh.l2g.plugins.migration.NoSuchLegacyOfficeException;
import de.uhh.l2g.plugins.migration.model.LegacyOffice;
import de.uhh.l2g.plugins.migration.model.impl.LegacyOfficeImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyOfficeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy office service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyOfficePersistence
 * @see LegacyOfficeUtil
 * @generated
 */
public class LegacyOfficePersistenceImpl extends BasePersistenceImpl<LegacyOffice>
	implements LegacyOfficePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyOfficeUtil} to access the legacy office persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyOfficeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyOfficeModelImpl.ENTITY_CACHE_ENABLED,
			LegacyOfficeModelImpl.FINDER_CACHE_ENABLED, LegacyOfficeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyOfficeModelImpl.ENTITY_CACHE_ENABLED,
			LegacyOfficeModelImpl.FINDER_CACHE_ENABLED, LegacyOfficeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyOfficeModelImpl.ENTITY_CACHE_ENABLED,
			LegacyOfficeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyOfficePersistenceImpl() {
		setModelClass(LegacyOffice.class);
	}

	/**
	 * Caches the legacy office in the entity cache if it is enabled.
	 *
	 * @param legacyOffice the legacy office
	 */
	@Override
	public void cacheResult(LegacyOffice legacyOffice) {
		EntityCacheUtil.putResult(LegacyOfficeModelImpl.ENTITY_CACHE_ENABLED,
			LegacyOfficeImpl.class, legacyOffice.getPrimaryKey(), legacyOffice);

		legacyOffice.resetOriginalValues();
	}

	/**
	 * Caches the legacy offices in the entity cache if it is enabled.
	 *
	 * @param legacyOffices the legacy offices
	 */
	@Override
	public void cacheResult(List<LegacyOffice> legacyOffices) {
		for (LegacyOffice legacyOffice : legacyOffices) {
			if (EntityCacheUtil.getResult(
						LegacyOfficeModelImpl.ENTITY_CACHE_ENABLED,
						LegacyOfficeImpl.class, legacyOffice.getPrimaryKey()) == null) {
				cacheResult(legacyOffice);
			}
			else {
				legacyOffice.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy offices.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyOfficeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyOfficeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy office.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyOffice legacyOffice) {
		EntityCacheUtil.removeResult(LegacyOfficeModelImpl.ENTITY_CACHE_ENABLED,
			LegacyOfficeImpl.class, legacyOffice.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyOffice> legacyOffices) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyOffice legacyOffice : legacyOffices) {
			EntityCacheUtil.removeResult(LegacyOfficeModelImpl.ENTITY_CACHE_ENABLED,
				LegacyOfficeImpl.class, legacyOffice.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy office with the primary key. Does not add the legacy office to the database.
	 *
	 * @param id the primary key for the new legacy office
	 * @return the new legacy office
	 */
	@Override
	public LegacyOffice create(long id) {
		LegacyOffice legacyOffice = new LegacyOfficeImpl();

		legacyOffice.setNew(true);
		legacyOffice.setPrimaryKey(id);

		return legacyOffice;
	}

	/**
	 * Removes the legacy office with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy office
	 * @return the legacy office that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyOfficeException if a legacy office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyOffice remove(long id)
		throws NoSuchLegacyOfficeException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy office with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy office
	 * @return the legacy office that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyOfficeException if a legacy office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyOffice remove(Serializable primaryKey)
		throws NoSuchLegacyOfficeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyOffice legacyOffice = (LegacyOffice)session.get(LegacyOfficeImpl.class,
					primaryKey);

			if (legacyOffice == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyOfficeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyOffice);
		}
		catch (NoSuchLegacyOfficeException nsee) {
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
	protected LegacyOffice removeImpl(LegacyOffice legacyOffice)
		throws SystemException {
		legacyOffice = toUnwrappedModel(legacyOffice);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyOffice)) {
				legacyOffice = (LegacyOffice)session.get(LegacyOfficeImpl.class,
						legacyOffice.getPrimaryKeyObj());
			}

			if (legacyOffice != null) {
				session.delete(legacyOffice);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyOffice != null) {
			clearCache(legacyOffice);
		}

		return legacyOffice;
	}

	@Override
	public LegacyOffice updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyOffice legacyOffice)
		throws SystemException {
		legacyOffice = toUnwrappedModel(legacyOffice);

		boolean isNew = legacyOffice.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyOffice.isNew()) {
				session.save(legacyOffice);

				legacyOffice.setNew(false);
			}
			else {
				session.merge(legacyOffice);
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

		EntityCacheUtil.putResult(LegacyOfficeModelImpl.ENTITY_CACHE_ENABLED,
			LegacyOfficeImpl.class, legacyOffice.getPrimaryKey(), legacyOffice);

		return legacyOffice;
	}

	protected LegacyOffice toUnwrappedModel(LegacyOffice legacyOffice) {
		if (legacyOffice instanceof LegacyOfficeImpl) {
			return legacyOffice;
		}

		LegacyOfficeImpl legacyOfficeImpl = new LegacyOfficeImpl();

		legacyOfficeImpl.setNew(legacyOffice.isNew());
		legacyOfficeImpl.setPrimaryKey(legacyOffice.getPrimaryKey());

		legacyOfficeImpl.setId(legacyOffice.getId());
		legacyOfficeImpl.setName(legacyOffice.getName());
		legacyOfficeImpl.setWww(legacyOffice.getWww());
		legacyOfficeImpl.setEmail(legacyOffice.getEmail());
		legacyOfficeImpl.setFacilityId(legacyOffice.getFacilityId());

		return legacyOfficeImpl;
	}

	/**
	 * Returns the legacy office with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy office
	 * @return the legacy office
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyOfficeException if a legacy office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyOffice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyOfficeException, SystemException {
		LegacyOffice legacyOffice = fetchByPrimaryKey(primaryKey);

		if (legacyOffice == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyOfficeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyOffice;
	}

	/**
	 * Returns the legacy office with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyOfficeException} if it could not be found.
	 *
	 * @param id the primary key of the legacy office
	 * @return the legacy office
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyOfficeException if a legacy office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyOffice findByPrimaryKey(long id)
		throws NoSuchLegacyOfficeException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy office with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy office
	 * @return the legacy office, or <code>null</code> if a legacy office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyOffice fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyOffice legacyOffice = (LegacyOffice)EntityCacheUtil.getResult(LegacyOfficeModelImpl.ENTITY_CACHE_ENABLED,
				LegacyOfficeImpl.class, primaryKey);

		if (legacyOffice == _nullLegacyOffice) {
			return null;
		}

		if (legacyOffice == null) {
			Session session = null;

			try {
				session = openSession();

				legacyOffice = (LegacyOffice)session.get(LegacyOfficeImpl.class,
						primaryKey);

				if (legacyOffice != null) {
					cacheResult(legacyOffice);
				}
				else {
					EntityCacheUtil.putResult(LegacyOfficeModelImpl.ENTITY_CACHE_ENABLED,
						LegacyOfficeImpl.class, primaryKey, _nullLegacyOffice);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyOfficeModelImpl.ENTITY_CACHE_ENABLED,
					LegacyOfficeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyOffice;
	}

	/**
	 * Returns the legacy office with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy office
	 * @return the legacy office, or <code>null</code> if a legacy office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyOffice fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy offices.
	 *
	 * @return the legacy offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyOffice> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy offices
	 * @param end the upper bound of the range of legacy offices (not inclusive)
	 * @return the range of legacy offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyOffice> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy offices
	 * @param end the upper bound of the range of legacy offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyOffice> findAll(int start, int end,
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

		List<LegacyOffice> list = (List<LegacyOffice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYOFFICE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYOFFICE;

				if (pagination) {
					sql = sql.concat(LegacyOfficeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyOffice>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyOffice>(list);
				}
				else {
					list = (List<LegacyOffice>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legacy offices from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyOffice legacyOffice : findAll()) {
			remove(legacyOffice);
		}
	}

	/**
	 * Returns the number of legacy offices.
	 *
	 * @return the number of legacy offices
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYOFFICE);

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
	 * Initializes the legacy office persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyOffice")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyOffice>> listenersList = new ArrayList<ModelListener<LegacyOffice>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyOffice>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyOfficeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYOFFICE = "SELECT legacyOffice FROM LegacyOffice legacyOffice";
	private static final String _SQL_COUNT_LEGACYOFFICE = "SELECT COUNT(legacyOffice) FROM LegacyOffice legacyOffice";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyOffice.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyOffice exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyOfficePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static LegacyOffice _nullLegacyOffice = new LegacyOfficeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyOffice> toCacheModel() {
				return _nullLegacyOfficeCacheModel;
			}
		};

	private static CacheModel<LegacyOffice> _nullLegacyOfficeCacheModel = new CacheModel<LegacyOffice>() {
			@Override
			public LegacyOffice toEntityModel() {
				return _nullLegacyOffice;
			}
		};
}