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

import de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException;
import de.uhh.l2g.plugins.migration.model.LegacyLectureSeries;
import de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy lecture series service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyLectureSeriesPersistence
 * @see LegacyLectureSeriesUtil
 * @generated
 */
public class LegacyLectureSeriesPersistenceImpl extends BasePersistenceImpl<LegacyLectureSeries>
	implements LegacyLectureSeriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyLectureSeriesUtil} to access the legacy lecture series persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyLectureSeriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyLectureSeriesModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesModelImpl.FINDER_CACHE_ENABLED,
			LegacyLectureSeriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyLectureSeriesModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesModelImpl.FINDER_CACHE_ENABLED,
			LegacyLectureSeriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyLectureSeriesModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyLectureSeriesPersistenceImpl() {
		setModelClass(LegacyLectureSeries.class);
	}

	/**
	 * Caches the legacy lecture series in the entity cache if it is enabled.
	 *
	 * @param legacyLectureSeries the legacy lecture series
	 */
	@Override
	public void cacheResult(LegacyLectureSeries legacyLectureSeries) {
		EntityCacheUtil.putResult(LegacyLectureSeriesModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesImpl.class, legacyLectureSeries.getPrimaryKey(),
			legacyLectureSeries);

		legacyLectureSeries.resetOriginalValues();
	}

	/**
	 * Caches the legacy lecture serieses in the entity cache if it is enabled.
	 *
	 * @param legacyLectureSerieses the legacy lecture serieses
	 */
	@Override
	public void cacheResult(List<LegacyLectureSeries> legacyLectureSerieses) {
		for (LegacyLectureSeries legacyLectureSeries : legacyLectureSerieses) {
			if (EntityCacheUtil.getResult(
						LegacyLectureSeriesModelImpl.ENTITY_CACHE_ENABLED,
						LegacyLectureSeriesImpl.class,
						legacyLectureSeries.getPrimaryKey()) == null) {
				cacheResult(legacyLectureSeries);
			}
			else {
				legacyLectureSeries.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy lecture serieses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyLectureSeriesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyLectureSeriesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy lecture series.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyLectureSeries legacyLectureSeries) {
		EntityCacheUtil.removeResult(LegacyLectureSeriesModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesImpl.class, legacyLectureSeries.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyLectureSeries> legacyLectureSerieses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyLectureSeries legacyLectureSeries : legacyLectureSerieses) {
			EntityCacheUtil.removeResult(LegacyLectureSeriesModelImpl.ENTITY_CACHE_ENABLED,
				LegacyLectureSeriesImpl.class,
				legacyLectureSeries.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy lecture series with the primary key. Does not add the legacy lecture series to the database.
	 *
	 * @param id the primary key for the new legacy lecture series
	 * @return the new legacy lecture series
	 */
	@Override
	public LegacyLectureSeries create(long id) {
		LegacyLectureSeries legacyLectureSeries = new LegacyLectureSeriesImpl();

		legacyLectureSeries.setNew(true);
		legacyLectureSeries.setPrimaryKey(id);

		return legacyLectureSeries;
	}

	/**
	 * Removes the legacy lecture series with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy lecture series
	 * @return the legacy lecture series that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException if a legacy lecture series with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeries remove(long id)
		throws NoSuchLegacyLectureSeriesException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy lecture series with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy lecture series
	 * @return the legacy lecture series that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException if a legacy lecture series with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeries remove(Serializable primaryKey)
		throws NoSuchLegacyLectureSeriesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyLectureSeries legacyLectureSeries = (LegacyLectureSeries)session.get(LegacyLectureSeriesImpl.class,
					primaryKey);

			if (legacyLectureSeries == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyLectureSeriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyLectureSeries);
		}
		catch (NoSuchLegacyLectureSeriesException nsee) {
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
	protected LegacyLectureSeries removeImpl(
		LegacyLectureSeries legacyLectureSeries) throws SystemException {
		legacyLectureSeries = toUnwrappedModel(legacyLectureSeries);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyLectureSeries)) {
				legacyLectureSeries = (LegacyLectureSeries)session.get(LegacyLectureSeriesImpl.class,
						legacyLectureSeries.getPrimaryKeyObj());
			}

			if (legacyLectureSeries != null) {
				session.delete(legacyLectureSeries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyLectureSeries != null) {
			clearCache(legacyLectureSeries);
		}

		return legacyLectureSeries;
	}

	@Override
	public LegacyLectureSeries updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeries legacyLectureSeries)
		throws SystemException {
		legacyLectureSeries = toUnwrappedModel(legacyLectureSeries);

		boolean isNew = legacyLectureSeries.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyLectureSeries.isNew()) {
				session.save(legacyLectureSeries);

				legacyLectureSeries.setNew(false);
			}
			else {
				session.merge(legacyLectureSeries);
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

		EntityCacheUtil.putResult(LegacyLectureSeriesModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesImpl.class, legacyLectureSeries.getPrimaryKey(),
			legacyLectureSeries);

		return legacyLectureSeries;
	}

	protected LegacyLectureSeries toUnwrappedModel(
		LegacyLectureSeries legacyLectureSeries) {
		if (legacyLectureSeries instanceof LegacyLectureSeriesImpl) {
			return legacyLectureSeries;
		}

		LegacyLectureSeriesImpl legacyLectureSeriesImpl = new LegacyLectureSeriesImpl();

		legacyLectureSeriesImpl.setNew(legacyLectureSeries.isNew());
		legacyLectureSeriesImpl.setPrimaryKey(legacyLectureSeries.getPrimaryKey());

		legacyLectureSeriesImpl.setNumber(legacyLectureSeries.getNumber());
		legacyLectureSeriesImpl.setEventType(legacyLectureSeries.getEventType());
		legacyLectureSeriesImpl.setEventCategory(legacyLectureSeries.getEventCategory());
		legacyLectureSeriesImpl.setName(legacyLectureSeries.getName());
		legacyLectureSeriesImpl.setShortDesc(legacyLectureSeries.getShortDesc());
		legacyLectureSeriesImpl.setSemesterName(legacyLectureSeries.getSemesterName());
		legacyLectureSeriesImpl.setLanguage(legacyLectureSeries.getLanguage());
		legacyLectureSeriesImpl.setFacultyName(legacyLectureSeries.getFacultyName());
		legacyLectureSeriesImpl.setInstructorsString(legacyLectureSeries.getInstructorsString());
		legacyLectureSeriesImpl.setId(legacyLectureSeries.getId());
		legacyLectureSeriesImpl.setPassword(legacyLectureSeries.getPassword());
		legacyLectureSeriesImpl.setApproved(legacyLectureSeries.getApproved());
		legacyLectureSeriesImpl.setLongDesc(legacyLectureSeries.getLongDesc());

		return legacyLectureSeriesImpl;
	}

	/**
	 * Returns the legacy lecture series with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy lecture series
	 * @return the legacy lecture series
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException if a legacy lecture series with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeries findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyLectureSeriesException, SystemException {
		LegacyLectureSeries legacyLectureSeries = fetchByPrimaryKey(primaryKey);

		if (legacyLectureSeries == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyLectureSeriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyLectureSeries;
	}

	/**
	 * Returns the legacy lecture series with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException} if it could not be found.
	 *
	 * @param id the primary key of the legacy lecture series
	 * @return the legacy lecture series
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException if a legacy lecture series with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeries findByPrimaryKey(long id)
		throws NoSuchLegacyLectureSeriesException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy lecture series with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy lecture series
	 * @return the legacy lecture series, or <code>null</code> if a legacy lecture series with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeries fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyLectureSeries legacyLectureSeries = (LegacyLectureSeries)EntityCacheUtil.getResult(LegacyLectureSeriesModelImpl.ENTITY_CACHE_ENABLED,
				LegacyLectureSeriesImpl.class, primaryKey);

		if (legacyLectureSeries == _nullLegacyLectureSeries) {
			return null;
		}

		if (legacyLectureSeries == null) {
			Session session = null;

			try {
				session = openSession();

				legacyLectureSeries = (LegacyLectureSeries)session.get(LegacyLectureSeriesImpl.class,
						primaryKey);

				if (legacyLectureSeries != null) {
					cacheResult(legacyLectureSeries);
				}
				else {
					EntityCacheUtil.putResult(LegacyLectureSeriesModelImpl.ENTITY_CACHE_ENABLED,
						LegacyLectureSeriesImpl.class, primaryKey,
						_nullLegacyLectureSeries);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyLectureSeriesModelImpl.ENTITY_CACHE_ENABLED,
					LegacyLectureSeriesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyLectureSeries;
	}

	/**
	 * Returns the legacy lecture series with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy lecture series
	 * @return the legacy lecture series, or <code>null</code> if a legacy lecture series with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeries fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy lecture serieses.
	 *
	 * @return the legacy lecture serieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyLectureSeries> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy lecture serieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy lecture serieses
	 * @param end the upper bound of the range of legacy lecture serieses (not inclusive)
	 * @return the range of legacy lecture serieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyLectureSeries> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy lecture serieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy lecture serieses
	 * @param end the upper bound of the range of legacy lecture serieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy lecture serieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyLectureSeries> findAll(int start, int end,
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

		List<LegacyLectureSeries> list = (List<LegacyLectureSeries>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYLECTURESERIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYLECTURESERIES;

				if (pagination) {
					sql = sql.concat(LegacyLectureSeriesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyLectureSeries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyLectureSeries>(list);
				}
				else {
					list = (List<LegacyLectureSeries>)QueryUtil.list(q,
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
	 * Removes all the legacy lecture serieses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyLectureSeries legacyLectureSeries : findAll()) {
			remove(legacyLectureSeries);
		}
	}

	/**
	 * Returns the number of legacy lecture serieses.
	 *
	 * @return the number of legacy lecture serieses
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYLECTURESERIES);

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
	 * Initializes the legacy lecture series persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyLectureSeries")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyLectureSeries>> listenersList = new ArrayList<ModelListener<LegacyLectureSeries>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyLectureSeries>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyLectureSeriesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYLECTURESERIES = "SELECT legacyLectureSeries FROM LegacyLectureSeries legacyLectureSeries";
	private static final String _SQL_COUNT_LEGACYLECTURESERIES = "SELECT COUNT(legacyLectureSeries) FROM LegacyLectureSeries legacyLectureSeries";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyLectureSeries.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyLectureSeries exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyLectureSeriesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"number", "id", "password"
			});
	private static LegacyLectureSeries _nullLegacyLectureSeries = new LegacyLectureSeriesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyLectureSeries> toCacheModel() {
				return _nullLegacyLectureSeriesCacheModel;
			}
		};

	private static CacheModel<LegacyLectureSeries> _nullLegacyLectureSeriesCacheModel =
		new CacheModel<LegacyLectureSeries>() {
			@Override
			public LegacyLectureSeries toEntityModel() {
				return _nullLegacyLectureSeries;
			}
		};
}