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

import de.uhh.l2g.plugins.migration.NoSuchLegacyUploadException;
import de.uhh.l2g.plugins.migration.model.LegacyUpload;
import de.uhh.l2g.plugins.migration.model.impl.LegacyUploadImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyUploadModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy upload service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyUploadPersistence
 * @see LegacyUploadUtil
 * @generated
 */
public class LegacyUploadPersistenceImpl extends BasePersistenceImpl<LegacyUpload>
	implements LegacyUploadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyUploadUtil} to access the legacy upload persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyUploadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyUploadModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUploadModelImpl.FINDER_CACHE_ENABLED, LegacyUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyUploadModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUploadModelImpl.FINDER_CACHE_ENABLED, LegacyUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyUploadModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUploadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyUploadPersistenceImpl() {
		setModelClass(LegacyUpload.class);
	}

	/**
	 * Caches the legacy upload in the entity cache if it is enabled.
	 *
	 * @param legacyUpload the legacy upload
	 */
	@Override
	public void cacheResult(LegacyUpload legacyUpload) {
		EntityCacheUtil.putResult(LegacyUploadModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUploadImpl.class, legacyUpload.getPrimaryKey(), legacyUpload);

		legacyUpload.resetOriginalValues();
	}

	/**
	 * Caches the legacy uploads in the entity cache if it is enabled.
	 *
	 * @param legacyUploads the legacy uploads
	 */
	@Override
	public void cacheResult(List<LegacyUpload> legacyUploads) {
		for (LegacyUpload legacyUpload : legacyUploads) {
			if (EntityCacheUtil.getResult(
						LegacyUploadModelImpl.ENTITY_CACHE_ENABLED,
						LegacyUploadImpl.class, legacyUpload.getPrimaryKey()) == null) {
				cacheResult(legacyUpload);
			}
			else {
				legacyUpload.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy uploads.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyUploadImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyUploadImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy upload.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyUpload legacyUpload) {
		EntityCacheUtil.removeResult(LegacyUploadModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUploadImpl.class, legacyUpload.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyUpload> legacyUploads) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyUpload legacyUpload : legacyUploads) {
			EntityCacheUtil.removeResult(LegacyUploadModelImpl.ENTITY_CACHE_ENABLED,
				LegacyUploadImpl.class, legacyUpload.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy upload with the primary key. Does not add the legacy upload to the database.
	 *
	 * @param id the primary key for the new legacy upload
	 * @return the new legacy upload
	 */
	@Override
	public LegacyUpload create(long id) {
		LegacyUpload legacyUpload = new LegacyUploadImpl();

		legacyUpload.setNew(true);
		legacyUpload.setPrimaryKey(id);

		return legacyUpload;
	}

	/**
	 * Removes the legacy upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy upload
	 * @return the legacy upload that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUploadException if a legacy upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUpload remove(long id)
		throws NoSuchLegacyUploadException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy upload
	 * @return the legacy upload that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUploadException if a legacy upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUpload remove(Serializable primaryKey)
		throws NoSuchLegacyUploadException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyUpload legacyUpload = (LegacyUpload)session.get(LegacyUploadImpl.class,
					primaryKey);

			if (legacyUpload == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyUpload);
		}
		catch (NoSuchLegacyUploadException nsee) {
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
	protected LegacyUpload removeImpl(LegacyUpload legacyUpload)
		throws SystemException {
		legacyUpload = toUnwrappedModel(legacyUpload);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyUpload)) {
				legacyUpload = (LegacyUpload)session.get(LegacyUploadImpl.class,
						legacyUpload.getPrimaryKeyObj());
			}

			if (legacyUpload != null) {
				session.delete(legacyUpload);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyUpload != null) {
			clearCache(legacyUpload);
		}

		return legacyUpload;
	}

	@Override
	public LegacyUpload updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyUpload legacyUpload)
		throws SystemException {
		legacyUpload = toUnwrappedModel(legacyUpload);

		boolean isNew = legacyUpload.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyUpload.isNew()) {
				session.save(legacyUpload);

				legacyUpload.setNew(false);
			}
			else {
				session.merge(legacyUpload);
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

		EntityCacheUtil.putResult(LegacyUploadModelImpl.ENTITY_CACHE_ENABLED,
			LegacyUploadImpl.class, legacyUpload.getPrimaryKey(), legacyUpload);

		return legacyUpload;
	}

	protected LegacyUpload toUnwrappedModel(LegacyUpload legacyUpload) {
		if (legacyUpload instanceof LegacyUploadImpl) {
			return legacyUpload;
		}

		LegacyUploadImpl legacyUploadImpl = new LegacyUploadImpl();

		legacyUploadImpl.setNew(legacyUpload.isNew());
		legacyUploadImpl.setPrimaryKey(legacyUpload.getPrimaryKey());

		legacyUploadImpl.setId(legacyUpload.getId());
		legacyUploadImpl.setUserId(legacyUpload.getUserId());
		legacyUploadImpl.setContentLength(legacyUpload.getContentLength());
		legacyUploadImpl.setTimestamp(legacyUpload.getTimestamp());
		legacyUploadImpl.setStatus(legacyUpload.getStatus());
		legacyUploadImpl.setVideoId(legacyUpload.getVideoId());

		return legacyUploadImpl;
	}

	/**
	 * Returns the legacy upload with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy upload
	 * @return the legacy upload
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUploadException if a legacy upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUpload findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyUploadException, SystemException {
		LegacyUpload legacyUpload = fetchByPrimaryKey(primaryKey);

		if (legacyUpload == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyUpload;
	}

	/**
	 * Returns the legacy upload with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUploadException} if it could not be found.
	 *
	 * @param id the primary key of the legacy upload
	 * @return the legacy upload
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUploadException if a legacy upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUpload findByPrimaryKey(long id)
		throws NoSuchLegacyUploadException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy upload
	 * @return the legacy upload, or <code>null</code> if a legacy upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUpload fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyUpload legacyUpload = (LegacyUpload)EntityCacheUtil.getResult(LegacyUploadModelImpl.ENTITY_CACHE_ENABLED,
				LegacyUploadImpl.class, primaryKey);

		if (legacyUpload == _nullLegacyUpload) {
			return null;
		}

		if (legacyUpload == null) {
			Session session = null;

			try {
				session = openSession();

				legacyUpload = (LegacyUpload)session.get(LegacyUploadImpl.class,
						primaryKey);

				if (legacyUpload != null) {
					cacheResult(legacyUpload);
				}
				else {
					EntityCacheUtil.putResult(LegacyUploadModelImpl.ENTITY_CACHE_ENABLED,
						LegacyUploadImpl.class, primaryKey, _nullLegacyUpload);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyUploadModelImpl.ENTITY_CACHE_ENABLED,
					LegacyUploadImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyUpload;
	}

	/**
	 * Returns the legacy upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy upload
	 * @return the legacy upload, or <code>null</code> if a legacy upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyUpload fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy uploads.
	 *
	 * @return the legacy uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyUpload> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy uploads
	 * @param end the upper bound of the range of legacy uploads (not inclusive)
	 * @return the range of legacy uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyUpload> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy uploads
	 * @param end the upper bound of the range of legacy uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyUpload> findAll(int start, int end,
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

		List<LegacyUpload> list = (List<LegacyUpload>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYUPLOAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYUPLOAD;

				if (pagination) {
					sql = sql.concat(LegacyUploadModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyUpload>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyUpload>(list);
				}
				else {
					list = (List<LegacyUpload>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legacy uploads from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyUpload legacyUpload : findAll()) {
			remove(legacyUpload);
		}
	}

	/**
	 * Returns the number of legacy uploads.
	 *
	 * @return the number of legacy uploads
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYUPLOAD);

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
	 * Initializes the legacy upload persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyUpload")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyUpload>> listenersList = new ArrayList<ModelListener<LegacyUpload>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyUpload>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyUploadImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYUPLOAD = "SELECT legacyUpload FROM LegacyUpload legacyUpload";
	private static final String _SQL_COUNT_LEGACYUPLOAD = "SELECT COUNT(legacyUpload) FROM LegacyUpload legacyUpload";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyUpload.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyUpload exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyUploadPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static LegacyUpload _nullLegacyUpload = new LegacyUploadImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyUpload> toCacheModel() {
				return _nullLegacyUploadCacheModel;
			}
		};

	private static CacheModel<LegacyUpload> _nullLegacyUploadCacheModel = new CacheModel<LegacyUpload>() {
			@Override
			public LegacyUpload toEntityModel() {
				return _nullLegacyUpload;
			}
		};
}