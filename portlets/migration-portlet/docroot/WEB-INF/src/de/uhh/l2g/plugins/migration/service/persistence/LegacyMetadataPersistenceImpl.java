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

import de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException;
import de.uhh.l2g.plugins.migration.model.LegacyMetadata;
import de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy metadata service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyMetadataPersistence
 * @see LegacyMetadataUtil
 * @generated
 */
public class LegacyMetadataPersistenceImpl extends BasePersistenceImpl<LegacyMetadata>
	implements LegacyMetadataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyMetadataUtil} to access the legacy metadata persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyMetadataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyMetadataModelImpl.ENTITY_CACHE_ENABLED,
			LegacyMetadataModelImpl.FINDER_CACHE_ENABLED,
			LegacyMetadataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyMetadataModelImpl.ENTITY_CACHE_ENABLED,
			LegacyMetadataModelImpl.FINDER_CACHE_ENABLED,
			LegacyMetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyMetadataModelImpl.ENTITY_CACHE_ENABLED,
			LegacyMetadataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyMetadataPersistenceImpl() {
		setModelClass(LegacyMetadata.class);
	}

	/**
	 * Caches the legacy metadata in the entity cache if it is enabled.
	 *
	 * @param legacyMetadata the legacy metadata
	 */
	@Override
	public void cacheResult(LegacyMetadata legacyMetadata) {
		EntityCacheUtil.putResult(LegacyMetadataModelImpl.ENTITY_CACHE_ENABLED,
			LegacyMetadataImpl.class, legacyMetadata.getPrimaryKey(),
			legacyMetadata);

		legacyMetadata.resetOriginalValues();
	}

	/**
	 * Caches the legacy metadatas in the entity cache if it is enabled.
	 *
	 * @param legacyMetadatas the legacy metadatas
	 */
	@Override
	public void cacheResult(List<LegacyMetadata> legacyMetadatas) {
		for (LegacyMetadata legacyMetadata : legacyMetadatas) {
			if (EntityCacheUtil.getResult(
						LegacyMetadataModelImpl.ENTITY_CACHE_ENABLED,
						LegacyMetadataImpl.class, legacyMetadata.getPrimaryKey()) == null) {
				cacheResult(legacyMetadata);
			}
			else {
				legacyMetadata.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy metadatas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyMetadataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyMetadataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy metadata.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyMetadata legacyMetadata) {
		EntityCacheUtil.removeResult(LegacyMetadataModelImpl.ENTITY_CACHE_ENABLED,
			LegacyMetadataImpl.class, legacyMetadata.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyMetadata> legacyMetadatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyMetadata legacyMetadata : legacyMetadatas) {
			EntityCacheUtil.removeResult(LegacyMetadataModelImpl.ENTITY_CACHE_ENABLED,
				LegacyMetadataImpl.class, legacyMetadata.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy metadata with the primary key. Does not add the legacy metadata to the database.
	 *
	 * @param id the primary key for the new legacy metadata
	 * @return the new legacy metadata
	 */
	@Override
	public LegacyMetadata create(long id) {
		LegacyMetadata legacyMetadata = new LegacyMetadataImpl();

		legacyMetadata.setNew(true);
		legacyMetadata.setPrimaryKey(id);

		return legacyMetadata;
	}

	/**
	 * Removes the legacy metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy metadata
	 * @return the legacy metadata that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException if a legacy metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyMetadata remove(long id)
		throws NoSuchLegacyMetadataException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy metadata
	 * @return the legacy metadata that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException if a legacy metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyMetadata remove(Serializable primaryKey)
		throws NoSuchLegacyMetadataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyMetadata legacyMetadata = (LegacyMetadata)session.get(LegacyMetadataImpl.class,
					primaryKey);

			if (legacyMetadata == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyMetadataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyMetadata);
		}
		catch (NoSuchLegacyMetadataException nsee) {
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
	protected LegacyMetadata removeImpl(LegacyMetadata legacyMetadata)
		throws SystemException {
		legacyMetadata = toUnwrappedModel(legacyMetadata);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyMetadata)) {
				legacyMetadata = (LegacyMetadata)session.get(LegacyMetadataImpl.class,
						legacyMetadata.getPrimaryKeyObj());
			}

			if (legacyMetadata != null) {
				session.delete(legacyMetadata);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyMetadata != null) {
			clearCache(legacyMetadata);
		}

		return legacyMetadata;
	}

	@Override
	public LegacyMetadata updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyMetadata legacyMetadata)
		throws SystemException {
		legacyMetadata = toUnwrappedModel(legacyMetadata);

		boolean isNew = legacyMetadata.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyMetadata.isNew()) {
				session.save(legacyMetadata);

				legacyMetadata.setNew(false);
			}
			else {
				session.merge(legacyMetadata);
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

		EntityCacheUtil.putResult(LegacyMetadataModelImpl.ENTITY_CACHE_ENABLED,
			LegacyMetadataImpl.class, legacyMetadata.getPrimaryKey(),
			legacyMetadata);

		return legacyMetadata;
	}

	protected LegacyMetadata toUnwrappedModel(LegacyMetadata legacyMetadata) {
		if (legacyMetadata instanceof LegacyMetadataImpl) {
			return legacyMetadata;
		}

		LegacyMetadataImpl legacyMetadataImpl = new LegacyMetadataImpl();

		legacyMetadataImpl.setNew(legacyMetadata.isNew());
		legacyMetadataImpl.setPrimaryKey(legacyMetadata.getPrimaryKey());

		legacyMetadataImpl.setId(legacyMetadata.getId());
		legacyMetadataImpl.setURLID(legacyMetadata.getURLID());
		legacyMetadataImpl.setFormat(legacyMetadata.getFormat());
		legacyMetadataImpl.setType(legacyMetadata.getType());
		legacyMetadataImpl.setLanguage(legacyMetadata.getLanguage());
		legacyMetadataImpl.setTitle(legacyMetadata.getTitle());
		legacyMetadataImpl.setSubject(legacyMetadata.getSubject());
		legacyMetadataImpl.setDescription(legacyMetadata.getDescription());
		legacyMetadataImpl.setPublisher(legacyMetadata.getPublisher());
		legacyMetadataImpl.setRightsHolder(legacyMetadata.getRightsHolder());

		return legacyMetadataImpl;
	}

	/**
	 * Returns the legacy metadata with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy metadata
	 * @return the legacy metadata
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException if a legacy metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyMetadata findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyMetadataException, SystemException {
		LegacyMetadata legacyMetadata = fetchByPrimaryKey(primaryKey);

		if (legacyMetadata == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyMetadataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyMetadata;
	}

	/**
	 * Returns the legacy metadata with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException} if it could not be found.
	 *
	 * @param id the primary key of the legacy metadata
	 * @return the legacy metadata
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException if a legacy metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyMetadata findByPrimaryKey(long id)
		throws NoSuchLegacyMetadataException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy metadata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy metadata
	 * @return the legacy metadata, or <code>null</code> if a legacy metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyMetadata fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyMetadata legacyMetadata = (LegacyMetadata)EntityCacheUtil.getResult(LegacyMetadataModelImpl.ENTITY_CACHE_ENABLED,
				LegacyMetadataImpl.class, primaryKey);

		if (legacyMetadata == _nullLegacyMetadata) {
			return null;
		}

		if (legacyMetadata == null) {
			Session session = null;

			try {
				session = openSession();

				legacyMetadata = (LegacyMetadata)session.get(LegacyMetadataImpl.class,
						primaryKey);

				if (legacyMetadata != null) {
					cacheResult(legacyMetadata);
				}
				else {
					EntityCacheUtil.putResult(LegacyMetadataModelImpl.ENTITY_CACHE_ENABLED,
						LegacyMetadataImpl.class, primaryKey,
						_nullLegacyMetadata);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyMetadataModelImpl.ENTITY_CACHE_ENABLED,
					LegacyMetadataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyMetadata;
	}

	/**
	 * Returns the legacy metadata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy metadata
	 * @return the legacy metadata, or <code>null</code> if a legacy metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyMetadata fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy metadatas.
	 *
	 * @return the legacy metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyMetadata> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy metadatas
	 * @param end the upper bound of the range of legacy metadatas (not inclusive)
	 * @return the range of legacy metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyMetadata> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy metadatas
	 * @param end the upper bound of the range of legacy metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyMetadata> findAll(int start, int end,
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

		List<LegacyMetadata> list = (List<LegacyMetadata>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYMETADATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYMETADATA;

				if (pagination) {
					sql = sql.concat(LegacyMetadataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyMetadata>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyMetadata>(list);
				}
				else {
					list = (List<LegacyMetadata>)QueryUtil.list(q,
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
	 * Removes all the legacy metadatas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyMetadata legacyMetadata : findAll()) {
			remove(legacyMetadata);
		}
	}

	/**
	 * Returns the number of legacy metadatas.
	 *
	 * @return the number of legacy metadatas
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYMETADATA);

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
	 * Initializes the legacy metadata persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyMetadata")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyMetadata>> listenersList = new ArrayList<ModelListener<LegacyMetadata>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyMetadata>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyMetadataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYMETADATA = "SELECT legacyMetadata FROM LegacyMetadata legacyMetadata";
	private static final String _SQL_COUNT_LEGACYMETADATA = "SELECT COUNT(legacyMetadata) FROM LegacyMetadata legacyMetadata";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyMetadata.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyMetadata exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyMetadataPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "type"
			});
	private static LegacyMetadata _nullLegacyMetadata = new LegacyMetadataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyMetadata> toCacheModel() {
				return _nullLegacyMetadataCacheModel;
			}
		};

	private static CacheModel<LegacyMetadata> _nullLegacyMetadataCacheModel = new CacheModel<LegacyMetadata>() {
			@Override
			public LegacyMetadata toEntityModel() {
				return _nullLegacyMetadata;
			}
		};
}