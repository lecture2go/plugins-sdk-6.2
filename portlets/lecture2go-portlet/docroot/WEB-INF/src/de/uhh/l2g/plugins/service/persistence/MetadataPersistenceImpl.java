/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchMetadataException;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.impl.MetadataImpl;
import de.uhh.l2g.plugins.model.impl.MetadataModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the metadata service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see MetadataPersistence
 * @see MetadataUtil
 * @generated
 */
public class MetadataPersistenceImpl extends BasePersistenceImpl<Metadata>
	implements MetadataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MetadataUtil} to access the metadata persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MetadataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, MetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, MetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MetadataPersistenceImpl() {
		setModelClass(Metadata.class);
	}

	/**
	 * Caches the metadata in the entity cache if it is enabled.
	 *
	 * @param metadata the metadata
	 */
	@Override
	public void cacheResult(Metadata metadata) {
		EntityCacheUtil.putResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataImpl.class, metadata.getPrimaryKey(), metadata);

		metadata.resetOriginalValues();
	}

	/**
	 * Caches the metadatas in the entity cache if it is enabled.
	 *
	 * @param metadatas the metadatas
	 */
	@Override
	public void cacheResult(List<Metadata> metadatas) {
		for (Metadata metadata : metadatas) {
			if (EntityCacheUtil.getResult(
						MetadataModelImpl.ENTITY_CACHE_ENABLED,
						MetadataImpl.class, metadata.getPrimaryKey()) == null) {
				cacheResult(metadata);
			}
			else {
				metadata.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all metadatas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MetadataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MetadataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the metadata.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Metadata metadata) {
		EntityCacheUtil.removeResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataImpl.class, metadata.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Metadata> metadatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Metadata metadata : metadatas) {
			EntityCacheUtil.removeResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
				MetadataImpl.class, metadata.getPrimaryKey());
		}
	}

	/**
	 * Creates a new metadata with the primary key. Does not add the metadata to the database.
	 *
	 * @param metadataId the primary key for the new metadata
	 * @return the new metadata
	 */
	@Override
	public Metadata create(long metadataId) {
		Metadata metadata = new MetadataImpl();

		metadata.setNew(true);
		metadata.setPrimaryKey(metadataId);

		return metadata;
	}

	/**
	 * Removes the metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchMetadataException if a metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Metadata remove(long metadataId)
		throws NoSuchMetadataException, SystemException {
		return remove((Serializable)metadataId);
	}

	/**
	 * Removes the metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the metadata
	 * @return the metadata that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchMetadataException if a metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Metadata remove(Serializable primaryKey)
		throws NoSuchMetadataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Metadata metadata = (Metadata)session.get(MetadataImpl.class,
					primaryKey);

			if (metadata == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMetadataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(metadata);
		}
		catch (NoSuchMetadataException nsee) {
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
	protected Metadata removeImpl(Metadata metadata) throws SystemException {
		metadata = toUnwrappedModel(metadata);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(metadata)) {
				metadata = (Metadata)session.get(MetadataImpl.class,
						metadata.getPrimaryKeyObj());
			}

			if (metadata != null) {
				session.delete(metadata);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (metadata != null) {
			clearCache(metadata);
		}

		return metadata;
	}

	@Override
	public Metadata updateImpl(de.uhh.l2g.plugins.model.Metadata metadata)
		throws SystemException {
		metadata = toUnwrappedModel(metadata);

		boolean isNew = metadata.isNew();

		Session session = null;

		try {
			session = openSession();

			if (metadata.isNew()) {
				session.save(metadata);

				metadata.setNew(false);
			}
			else {
				session.merge(metadata);
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

		EntityCacheUtil.putResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataImpl.class, metadata.getPrimaryKey(), metadata);

		return metadata;
	}

	protected Metadata toUnwrappedModel(Metadata metadata) {
		if (metadata instanceof MetadataImpl) {
			return metadata;
		}

		MetadataImpl metadataImpl = new MetadataImpl();

		metadataImpl.setNew(metadata.isNew());
		metadataImpl.setPrimaryKey(metadata.getPrimaryKey());

		metadataImpl.setMetadataId(metadata.getMetadataId());
		metadataImpl.setURLID(metadata.getURLID());
		metadataImpl.setFormat(metadata.getFormat());
		metadataImpl.setType(metadata.getType());
		metadataImpl.setLanguage(metadata.getLanguage());
		metadataImpl.setTitle(metadata.getTitle());
		metadataImpl.setSubject(metadata.getSubject());
		metadataImpl.setCoverage(metadata.getCoverage());
		metadataImpl.setDescription(metadata.getDescription());
		metadataImpl.setCreator(metadata.getCreator());
		metadataImpl.setPublisher(metadata.getPublisher());
		metadataImpl.setContributor(metadata.getContributor());
		metadataImpl.setRightsHolder(metadata.getRightsHolder());
		metadataImpl.setRights(metadata.getRights());
		metadataImpl.setProvenance(metadata.getProvenance());
		metadataImpl.setSource(metadata.getSource());
		metadataImpl.setRelation(metadata.getRelation());
		metadataImpl.setAudience(metadata.getAudience());
		metadataImpl.setInstructionalMethods(metadata.getInstructionalMethods());
		metadataImpl.setDate(metadata.getDate());

		return metadataImpl;
	}

	/**
	 * Returns the metadata with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata
	 * @return the metadata
	 * @throws de.uhh.l2g.plugins.NoSuchMetadataException if a metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Metadata findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMetadataException, SystemException {
		Metadata metadata = fetchByPrimaryKey(primaryKey);

		if (metadata == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMetadataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return metadata;
	}

	/**
	 * Returns the metadata with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchMetadataException} if it could not be found.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata
	 * @throws de.uhh.l2g.plugins.NoSuchMetadataException if a metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Metadata findByPrimaryKey(long metadataId)
		throws NoSuchMetadataException, SystemException {
		return findByPrimaryKey((Serializable)metadataId);
	}

	/**
	 * Returns the metadata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata
	 * @return the metadata, or <code>null</code> if a metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Metadata fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Metadata metadata = (Metadata)EntityCacheUtil.getResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
				MetadataImpl.class, primaryKey);

		if (metadata == _nullMetadata) {
			return null;
		}

		if (metadata == null) {
			Session session = null;

			try {
				session = openSession();

				metadata = (Metadata)session.get(MetadataImpl.class, primaryKey);

				if (metadata != null) {
					cacheResult(metadata);
				}
				else {
					EntityCacheUtil.putResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
						MetadataImpl.class, primaryKey, _nullMetadata);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
					MetadataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return metadata;
	}

	/**
	 * Returns the metadata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata, or <code>null</code> if a metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Metadata fetchByPrimaryKey(long metadataId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)metadataId);
	}

	/**
	 * Returns all the metadatas.
	 *
	 * @return the metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Metadata> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.MetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Metadata> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.MetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Metadata> findAll(int start, int end,
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

		List<Metadata> list = (List<Metadata>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_METADATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_METADATA;

				if (pagination) {
					sql = sql.concat(MetadataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Metadata>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Metadata>(list);
				}
				else {
					list = (List<Metadata>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the metadatas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Metadata metadata : findAll()) {
			remove(metadata);
		}
	}

	/**
	 * Returns the number of metadatas.
	 *
	 * @return the number of metadatas
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

				Query q = session.createQuery(_SQL_COUNT_METADATA);

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
	 * Initializes the metadata persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Metadata")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Metadata>> listenersList = new ArrayList<ModelListener<Metadata>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Metadata>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MetadataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_METADATA = "SELECT metadata FROM Metadata metadata";
	private static final String _SQL_COUNT_METADATA = "SELECT COUNT(metadata) FROM Metadata metadata";
	private static final String _ORDER_BY_ENTITY_ALIAS = "metadata.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Metadata exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MetadataPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type", "date"
			});
	private static Metadata _nullMetadata = new MetadataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Metadata> toCacheModel() {
				return _nullMetadataCacheModel;
			}
		};

	private static CacheModel<Metadata> _nullMetadataCacheModel = new CacheModel<Metadata>() {
			@Override
			public Metadata toEntityModel() {
				return _nullMetadata;
			}
		};
}