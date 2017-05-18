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

import de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException;
import de.uhh.l2g.plugins.migration.model.LegacyProducer;
import de.uhh.l2g.plugins.migration.model.impl.LegacyProducerImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyProducerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy producer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyProducerPersistence
 * @see LegacyProducerUtil
 * @generated
 */
public class LegacyProducerPersistenceImpl extends BasePersistenceImpl<LegacyProducer>
	implements LegacyProducerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyProducerUtil} to access the legacy producer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyProducerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyProducerModelImpl.ENTITY_CACHE_ENABLED,
			LegacyProducerModelImpl.FINDER_CACHE_ENABLED,
			LegacyProducerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyProducerModelImpl.ENTITY_CACHE_ENABLED,
			LegacyProducerModelImpl.FINDER_CACHE_ENABLED,
			LegacyProducerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyProducerModelImpl.ENTITY_CACHE_ENABLED,
			LegacyProducerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyProducerPersistenceImpl() {
		setModelClass(LegacyProducer.class);
	}

	/**
	 * Caches the legacy producer in the entity cache if it is enabled.
	 *
	 * @param legacyProducer the legacy producer
	 */
	@Override
	public void cacheResult(LegacyProducer legacyProducer) {
		EntityCacheUtil.putResult(LegacyProducerModelImpl.ENTITY_CACHE_ENABLED,
			LegacyProducerImpl.class, legacyProducer.getPrimaryKey(),
			legacyProducer);

		legacyProducer.resetOriginalValues();
	}

	/**
	 * Caches the legacy producers in the entity cache if it is enabled.
	 *
	 * @param legacyProducers the legacy producers
	 */
	@Override
	public void cacheResult(List<LegacyProducer> legacyProducers) {
		for (LegacyProducer legacyProducer : legacyProducers) {
			if (EntityCacheUtil.getResult(
						LegacyProducerModelImpl.ENTITY_CACHE_ENABLED,
						LegacyProducerImpl.class, legacyProducer.getPrimaryKey()) == null) {
				cacheResult(legacyProducer);
			}
			else {
				legacyProducer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy producers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyProducerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyProducerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy producer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyProducer legacyProducer) {
		EntityCacheUtil.removeResult(LegacyProducerModelImpl.ENTITY_CACHE_ENABLED,
			LegacyProducerImpl.class, legacyProducer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyProducer> legacyProducers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyProducer legacyProducer : legacyProducers) {
			EntityCacheUtil.removeResult(LegacyProducerModelImpl.ENTITY_CACHE_ENABLED,
				LegacyProducerImpl.class, legacyProducer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy producer with the primary key. Does not add the legacy producer to the database.
	 *
	 * @param id the primary key for the new legacy producer
	 * @return the new legacy producer
	 */
	@Override
	public LegacyProducer create(long id) {
		LegacyProducer legacyProducer = new LegacyProducerImpl();

		legacyProducer.setNew(true);
		legacyProducer.setPrimaryKey(id);

		return legacyProducer;
	}

	/**
	 * Removes the legacy producer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy producer
	 * @return the legacy producer that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException if a legacy producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyProducer remove(long id)
		throws NoSuchLegacyProducerException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy producer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy producer
	 * @return the legacy producer that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException if a legacy producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyProducer remove(Serializable primaryKey)
		throws NoSuchLegacyProducerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyProducer legacyProducer = (LegacyProducer)session.get(LegacyProducerImpl.class,
					primaryKey);

			if (legacyProducer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyProducerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyProducer);
		}
		catch (NoSuchLegacyProducerException nsee) {
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
	protected LegacyProducer removeImpl(LegacyProducer legacyProducer)
		throws SystemException {
		legacyProducer = toUnwrappedModel(legacyProducer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyProducer)) {
				legacyProducer = (LegacyProducer)session.get(LegacyProducerImpl.class,
						legacyProducer.getPrimaryKeyObj());
			}

			if (legacyProducer != null) {
				session.delete(legacyProducer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyProducer != null) {
			clearCache(legacyProducer);
		}

		return legacyProducer;
	}

	@Override
	public LegacyProducer updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyProducer legacyProducer)
		throws SystemException {
		legacyProducer = toUnwrappedModel(legacyProducer);

		boolean isNew = legacyProducer.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyProducer.isNew()) {
				session.save(legacyProducer);

				legacyProducer.setNew(false);
			}
			else {
				session.merge(legacyProducer);
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

		EntityCacheUtil.putResult(LegacyProducerModelImpl.ENTITY_CACHE_ENABLED,
			LegacyProducerImpl.class, legacyProducer.getPrimaryKey(),
			legacyProducer);

		return legacyProducer;
	}

	protected LegacyProducer toUnwrappedModel(LegacyProducer legacyProducer) {
		if (legacyProducer instanceof LegacyProducerImpl) {
			return legacyProducer;
		}

		LegacyProducerImpl legacyProducerImpl = new LegacyProducerImpl();

		legacyProducerImpl.setNew(legacyProducer.isNew());
		legacyProducerImpl.setPrimaryKey(legacyProducer.getPrimaryKey());

		legacyProducerImpl.setId(legacyProducer.getId());
		legacyProducerImpl.setIdNum(legacyProducer.getIdNum());
		legacyProducerImpl.setHomeDir(legacyProducer.getHomeDir());
		legacyProducerImpl.setUserId(legacyProducer.getUserId());
		legacyProducerImpl.setHostId(legacyProducer.getHostId());
		legacyProducerImpl.setFacilityId(legacyProducer.getFacilityId());
		legacyProducerImpl.setNumberOfProductions(legacyProducer.getNumberOfProductions());
		legacyProducerImpl.setApproved(legacyProducer.getApproved());

		return legacyProducerImpl;
	}

	/**
	 * Returns the legacy producer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy producer
	 * @return the legacy producer
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException if a legacy producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyProducer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyProducerException, SystemException {
		LegacyProducer legacyProducer = fetchByPrimaryKey(primaryKey);

		if (legacyProducer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyProducerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyProducer;
	}

	/**
	 * Returns the legacy producer with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException} if it could not be found.
	 *
	 * @param id the primary key of the legacy producer
	 * @return the legacy producer
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException if a legacy producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyProducer findByPrimaryKey(long id)
		throws NoSuchLegacyProducerException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy producer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy producer
	 * @return the legacy producer, or <code>null</code> if a legacy producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyProducer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyProducer legacyProducer = (LegacyProducer)EntityCacheUtil.getResult(LegacyProducerModelImpl.ENTITY_CACHE_ENABLED,
				LegacyProducerImpl.class, primaryKey);

		if (legacyProducer == _nullLegacyProducer) {
			return null;
		}

		if (legacyProducer == null) {
			Session session = null;

			try {
				session = openSession();

				legacyProducer = (LegacyProducer)session.get(LegacyProducerImpl.class,
						primaryKey);

				if (legacyProducer != null) {
					cacheResult(legacyProducer);
				}
				else {
					EntityCacheUtil.putResult(LegacyProducerModelImpl.ENTITY_CACHE_ENABLED,
						LegacyProducerImpl.class, primaryKey,
						_nullLegacyProducer);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyProducerModelImpl.ENTITY_CACHE_ENABLED,
					LegacyProducerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyProducer;
	}

	/**
	 * Returns the legacy producer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy producer
	 * @return the legacy producer, or <code>null</code> if a legacy producer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyProducer fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy producers.
	 *
	 * @return the legacy producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyProducer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy producers
	 * @param end the upper bound of the range of legacy producers (not inclusive)
	 * @return the range of legacy producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyProducer> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy producers
	 * @param end the upper bound of the range of legacy producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy producers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyProducer> findAll(int start, int end,
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

		List<LegacyProducer> list = (List<LegacyProducer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYPRODUCER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYPRODUCER;

				if (pagination) {
					sql = sql.concat(LegacyProducerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyProducer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyProducer>(list);
				}
				else {
					list = (List<LegacyProducer>)QueryUtil.list(q,
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
	 * Removes all the legacy producers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyProducer legacyProducer : findAll()) {
			remove(legacyProducer);
		}
	}

	/**
	 * Returns the number of legacy producers.
	 *
	 * @return the number of legacy producers
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYPRODUCER);

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
	 * Initializes the legacy producer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyProducer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyProducer>> listenersList = new ArrayList<ModelListener<LegacyProducer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyProducer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyProducerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYPRODUCER = "SELECT legacyProducer FROM LegacyProducer legacyProducer";
	private static final String _SQL_COUNT_LEGACYPRODUCER = "SELECT COUNT(legacyProducer) FROM LegacyProducer legacyProducer";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyProducer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyProducer exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyProducerPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static LegacyProducer _nullLegacyProducer = new LegacyProducerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyProducer> toCacheModel() {
				return _nullLegacyProducerCacheModel;
			}
		};

	private static CacheModel<LegacyProducer> _nullLegacyProducerCacheModel = new CacheModel<LegacyProducer>() {
			@Override
			public LegacyProducer toEntityModel() {
				return _nullLegacyProducer;
			}
		};
}