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

import de.uhh.l2g.plugins.NoSuchOaiSetException;
import de.uhh.l2g.plugins.model.OaiSet;
import de.uhh.l2g.plugins.model.impl.OaiSetImpl;
import de.uhh.l2g.plugins.model.impl.OaiSetModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the oai set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiSetPersistence
 * @see OaiSetUtil
 * @generated
 */
public class OaiSetPersistenceImpl extends BasePersistenceImpl<OaiSet>
	implements OaiSetPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OaiSetUtil} to access the oai set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OaiSetImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiSetModelImpl.FINDER_CACHE_ENABLED, OaiSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiSetModelImpl.FINDER_CACHE_ENABLED, OaiSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OaiSetPersistenceImpl() {
		setModelClass(OaiSet.class);
	}

	/**
	 * Caches the oai set in the entity cache if it is enabled.
	 *
	 * @param oaiSet the oai set
	 */
	@Override
	public void cacheResult(OaiSet oaiSet) {
		EntityCacheUtil.putResult(OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiSetImpl.class, oaiSet.getPrimaryKey(), oaiSet);

		oaiSet.resetOriginalValues();
	}

	/**
	 * Caches the oai sets in the entity cache if it is enabled.
	 *
	 * @param oaiSets the oai sets
	 */
	@Override
	public void cacheResult(List<OaiSet> oaiSets) {
		for (OaiSet oaiSet : oaiSets) {
			if (EntityCacheUtil.getResult(
						OaiSetModelImpl.ENTITY_CACHE_ENABLED, OaiSetImpl.class,
						oaiSet.getPrimaryKey()) == null) {
				cacheResult(oaiSet);
			}
			else {
				oaiSet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all oai sets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OaiSetImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OaiSetImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the oai set.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OaiSet oaiSet) {
		EntityCacheUtil.removeResult(OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiSetImpl.class, oaiSet.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OaiSet> oaiSets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OaiSet oaiSet : oaiSets) {
			EntityCacheUtil.removeResult(OaiSetModelImpl.ENTITY_CACHE_ENABLED,
				OaiSetImpl.class, oaiSet.getPrimaryKey());
		}
	}

	/**
	 * Creates a new oai set with the primary key. Does not add the oai set to the database.
	 *
	 * @param oaiSetId the primary key for the new oai set
	 * @return the new oai set
	 */
	@Override
	public OaiSet create(long oaiSetId) {
		OaiSet oaiSet = new OaiSetImpl();

		oaiSet.setNew(true);
		oaiSet.setPrimaryKey(oaiSetId);

		return oaiSet;
	}

	/**
	 * Removes the oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchOaiSetException if a oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiSet remove(long oaiSetId)
		throws NoSuchOaiSetException, SystemException {
		return remove((Serializable)oaiSetId);
	}

	/**
	 * Removes the oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the oai set
	 * @return the oai set that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchOaiSetException if a oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiSet remove(Serializable primaryKey)
		throws NoSuchOaiSetException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OaiSet oaiSet = (OaiSet)session.get(OaiSetImpl.class, primaryKey);

			if (oaiSet == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOaiSetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(oaiSet);
		}
		catch (NoSuchOaiSetException nsee) {
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
	protected OaiSet removeImpl(OaiSet oaiSet) throws SystemException {
		oaiSet = toUnwrappedModel(oaiSet);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(oaiSet)) {
				oaiSet = (OaiSet)session.get(OaiSetImpl.class,
						oaiSet.getPrimaryKeyObj());
			}

			if (oaiSet != null) {
				session.delete(oaiSet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (oaiSet != null) {
			clearCache(oaiSet);
		}

		return oaiSet;
	}

	@Override
	public OaiSet updateImpl(de.uhh.l2g.plugins.model.OaiSet oaiSet)
		throws SystemException {
		oaiSet = toUnwrappedModel(oaiSet);

		boolean isNew = oaiSet.isNew();

		Session session = null;

		try {
			session = openSession();

			if (oaiSet.isNew()) {
				session.save(oaiSet);

				oaiSet.setNew(false);
			}
			else {
				session.merge(oaiSet);
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

		EntityCacheUtil.putResult(OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiSetImpl.class, oaiSet.getPrimaryKey(), oaiSet);

		return oaiSet;
	}

	protected OaiSet toUnwrappedModel(OaiSet oaiSet) {
		if (oaiSet instanceof OaiSetImpl) {
			return oaiSet;
		}

		OaiSetImpl oaiSetImpl = new OaiSetImpl();

		oaiSetImpl.setNew(oaiSet.isNew());
		oaiSetImpl.setPrimaryKey(oaiSet.getPrimaryKey());

		oaiSetImpl.setOaiSetId(oaiSet.getOaiSetId());
		oaiSetImpl.setSetSpec(oaiSet.getSetSpec());
		oaiSetImpl.setSetName(oaiSet.getSetName());
		oaiSetImpl.setSetDescription(oaiSet.getSetDescription());

		return oaiSetImpl;
	}

	/**
	 * Returns the oai set with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the oai set
	 * @return the oai set
	 * @throws de.uhh.l2g.plugins.NoSuchOaiSetException if a oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiSet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOaiSetException, SystemException {
		OaiSet oaiSet = fetchByPrimaryKey(primaryKey);

		if (oaiSet == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOaiSetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return oaiSet;
	}

	/**
	 * Returns the oai set with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchOaiSetException} if it could not be found.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set
	 * @throws de.uhh.l2g.plugins.NoSuchOaiSetException if a oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiSet findByPrimaryKey(long oaiSetId)
		throws NoSuchOaiSetException, SystemException {
		return findByPrimaryKey((Serializable)oaiSetId);
	}

	/**
	 * Returns the oai set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the oai set
	 * @return the oai set, or <code>null</code> if a oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiSet fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OaiSet oaiSet = (OaiSet)EntityCacheUtil.getResult(OaiSetModelImpl.ENTITY_CACHE_ENABLED,
				OaiSetImpl.class, primaryKey);

		if (oaiSet == _nullOaiSet) {
			return null;
		}

		if (oaiSet == null) {
			Session session = null;

			try {
				session = openSession();

				oaiSet = (OaiSet)session.get(OaiSetImpl.class, primaryKey);

				if (oaiSet != null) {
					cacheResult(oaiSet);
				}
				else {
					EntityCacheUtil.putResult(OaiSetModelImpl.ENTITY_CACHE_ENABLED,
						OaiSetImpl.class, primaryKey, _nullOaiSet);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OaiSetModelImpl.ENTITY_CACHE_ENABLED,
					OaiSetImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return oaiSet;
	}

	/**
	 * Returns the oai set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set, or <code>null</code> if a oai set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiSet fetchByPrimaryKey(long oaiSetId) throws SystemException {
		return fetchByPrimaryKey((Serializable)oaiSetId);
	}

	/**
	 * Returns all the oai sets.
	 *
	 * @return the oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiSet> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai sets
	 * @param end the upper bound of the range of oai sets (not inclusive)
	 * @return the range of oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiSet> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai sets
	 * @param end the upper bound of the range of oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oai sets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiSet> findAll(int start, int end,
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

		List<OaiSet> list = (List<OaiSet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OAISET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OAISET;

				if (pagination) {
					sql = sql.concat(OaiSetModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OaiSet>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OaiSet>(list);
				}
				else {
					list = (List<OaiSet>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the oai sets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OaiSet oaiSet : findAll()) {
			remove(oaiSet);
		}
	}

	/**
	 * Returns the number of oai sets.
	 *
	 * @return the number of oai sets
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

				Query q = session.createQuery(_SQL_COUNT_OAISET);

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
	 * Initializes the oai set persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.OaiSet")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OaiSet>> listenersList = new ArrayList<ModelListener<OaiSet>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OaiSet>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OaiSetImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OAISET = "SELECT oaiSet FROM OaiSet oaiSet";
	private static final String _SQL_COUNT_OAISET = "SELECT COUNT(oaiSet) FROM OaiSet oaiSet";
	private static final String _ORDER_BY_ENTITY_ALIAS = "oaiSet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OaiSet exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OaiSetPersistenceImpl.class);
	private static OaiSet _nullOaiSet = new OaiSetImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OaiSet> toCacheModel() {
				return _nullOaiSetCacheModel;
			}
		};

	private static CacheModel<OaiSet> _nullOaiSetCacheModel = new CacheModel<OaiSet>() {
			@Override
			public OaiSet toEntityModel() {
				return _nullOaiSet;
			}
		};
}