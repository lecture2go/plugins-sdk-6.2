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

import de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException;
import de.uhh.l2g.plugins.migration.model.LegacyVideo;
import de.uhh.l2g.plugins.migration.model.impl.LegacyVideoImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyVideoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the legacy video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyVideoPersistence
 * @see LegacyVideoUtil
 * @generated
 */
public class LegacyVideoPersistenceImpl extends BasePersistenceImpl<LegacyVideo>
	implements LegacyVideoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyVideoUtil} to access the legacy video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyVideoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyVideoModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoModelImpl.FINDER_CACHE_ENABLED, LegacyVideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyVideoModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoModelImpl.FINDER_CACHE_ENABLED, LegacyVideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyVideoModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LegacyVideoPersistenceImpl() {
		setModelClass(LegacyVideo.class);
	}

	/**
	 * Caches the legacy video in the entity cache if it is enabled.
	 *
	 * @param legacyVideo the legacy video
	 */
	@Override
	public void cacheResult(LegacyVideo legacyVideo) {
		EntityCacheUtil.putResult(LegacyVideoModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoImpl.class, legacyVideo.getPrimaryKey(), legacyVideo);

		legacyVideo.resetOriginalValues();
	}

	/**
	 * Caches the legacy videos in the entity cache if it is enabled.
	 *
	 * @param legacyVideos the legacy videos
	 */
	@Override
	public void cacheResult(List<LegacyVideo> legacyVideos) {
		for (LegacyVideo legacyVideo : legacyVideos) {
			if (EntityCacheUtil.getResult(
						LegacyVideoModelImpl.ENTITY_CACHE_ENABLED,
						LegacyVideoImpl.class, legacyVideo.getPrimaryKey()) == null) {
				cacheResult(legacyVideo);
			}
			else {
				legacyVideo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy videos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyVideoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyVideoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy video.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegacyVideo legacyVideo) {
		EntityCacheUtil.removeResult(LegacyVideoModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoImpl.class, legacyVideo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegacyVideo> legacyVideos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyVideo legacyVideo : legacyVideos) {
			EntityCacheUtil.removeResult(LegacyVideoModelImpl.ENTITY_CACHE_ENABLED,
				LegacyVideoImpl.class, legacyVideo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacy video with the primary key. Does not add the legacy video to the database.
	 *
	 * @param id the primary key for the new legacy video
	 * @return the new legacy video
	 */
	@Override
	public LegacyVideo create(long id) {
		LegacyVideo legacyVideo = new LegacyVideoImpl();

		legacyVideo.setNew(true);
		legacyVideo.setPrimaryKey(id);

		return legacyVideo;
	}

	/**
	 * Removes the legacy video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy video
	 * @return the legacy video that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException if a legacy video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideo remove(long id)
		throws NoSuchLegacyVideoException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the legacy video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy video
	 * @return the legacy video that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException if a legacy video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideo remove(Serializable primaryKey)
		throws NoSuchLegacyVideoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyVideo legacyVideo = (LegacyVideo)session.get(LegacyVideoImpl.class,
					primaryKey);

			if (legacyVideo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyVideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyVideo);
		}
		catch (NoSuchLegacyVideoException nsee) {
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
	protected LegacyVideo removeImpl(LegacyVideo legacyVideo)
		throws SystemException {
		legacyVideo = toUnwrappedModel(legacyVideo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyVideo)) {
				legacyVideo = (LegacyVideo)session.get(LegacyVideoImpl.class,
						legacyVideo.getPrimaryKeyObj());
			}

			if (legacyVideo != null) {
				session.delete(legacyVideo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyVideo != null) {
			clearCache(legacyVideo);
		}

		return legacyVideo;
	}

	@Override
	public LegacyVideo updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyVideo legacyVideo)
		throws SystemException {
		legacyVideo = toUnwrappedModel(legacyVideo);

		boolean isNew = legacyVideo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyVideo.isNew()) {
				session.save(legacyVideo);

				legacyVideo.setNew(false);
			}
			else {
				session.merge(legacyVideo);
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

		EntityCacheUtil.putResult(LegacyVideoModelImpl.ENTITY_CACHE_ENABLED,
			LegacyVideoImpl.class, legacyVideo.getPrimaryKey(), legacyVideo);

		return legacyVideo;
	}

	protected LegacyVideo toUnwrappedModel(LegacyVideo legacyVideo) {
		if (legacyVideo instanceof LegacyVideoImpl) {
			return legacyVideo;
		}

		LegacyVideoImpl legacyVideoImpl = new LegacyVideoImpl();

		legacyVideoImpl.setNew(legacyVideo.isNew());
		legacyVideoImpl.setPrimaryKey(legacyVideo.getPrimaryKey());

		legacyVideoImpl.setId(legacyVideo.getId());
		legacyVideoImpl.setTitle(legacyVideo.getTitle());
		legacyVideoImpl.setTags(legacyVideo.getTags());
		legacyVideoImpl.setLectureseriesId(legacyVideo.getLectureseriesId());
		legacyVideoImpl.setOwnerId(legacyVideo.getOwnerId());
		legacyVideoImpl.setProducerId(legacyVideo.getProducerId());
		legacyVideoImpl.setContainerFormat(legacyVideo.getContainerFormat());
		legacyVideoImpl.setFilename(legacyVideo.getFilename());
		legacyVideoImpl.setResolution(legacyVideo.getResolution());
		legacyVideoImpl.setDuration(legacyVideo.getDuration());
		legacyVideoImpl.setHostId(legacyVideo.getHostId());
		legacyVideoImpl.setTextId(legacyVideo.getTextId());
		legacyVideoImpl.setFileSize(legacyVideo.getFileSize());
		legacyVideoImpl.setGenerationDate(legacyVideo.getGenerationDate());
		legacyVideoImpl.setOpenAccess(legacyVideo.getOpenAccess());
		legacyVideoImpl.setDownloadLink(legacyVideo.getDownloadLink());
		legacyVideoImpl.setMetadataId(legacyVideo.getMetadataId());
		legacyVideoImpl.setSurl(legacyVideo.getSurl());
		legacyVideoImpl.setHits(legacyVideo.getHits());
		legacyVideoImpl.setUploadDate(legacyVideo.getUploadDate());
		legacyVideoImpl.setPermittedToSegment(legacyVideo.getPermittedToSegment());
		legacyVideoImpl.setFacilityId(legacyVideo.getFacilityId());
		legacyVideoImpl.setCitation2go(legacyVideo.getCitation2go());

		return legacyVideoImpl;
	}

	/**
	 * Returns the legacy video with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy video
	 * @return the legacy video
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException if a legacy video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyVideoException, SystemException {
		LegacyVideo legacyVideo = fetchByPrimaryKey(primaryKey);

		if (legacyVideo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyVideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyVideo;
	}

	/**
	 * Returns the legacy video with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException} if it could not be found.
	 *
	 * @param id the primary key of the legacy video
	 * @return the legacy video
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException if a legacy video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideo findByPrimaryKey(long id)
		throws NoSuchLegacyVideoException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the legacy video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy video
	 * @return the legacy video, or <code>null</code> if a legacy video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LegacyVideo legacyVideo = (LegacyVideo)EntityCacheUtil.getResult(LegacyVideoModelImpl.ENTITY_CACHE_ENABLED,
				LegacyVideoImpl.class, primaryKey);

		if (legacyVideo == _nullLegacyVideo) {
			return null;
		}

		if (legacyVideo == null) {
			Session session = null;

			try {
				session = openSession();

				legacyVideo = (LegacyVideo)session.get(LegacyVideoImpl.class,
						primaryKey);

				if (legacyVideo != null) {
					cacheResult(legacyVideo);
				}
				else {
					EntityCacheUtil.putResult(LegacyVideoModelImpl.ENTITY_CACHE_ENABLED,
						LegacyVideoImpl.class, primaryKey, _nullLegacyVideo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyVideoModelImpl.ENTITY_CACHE_ENABLED,
					LegacyVideoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyVideo;
	}

	/**
	 * Returns the legacy video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the legacy video
	 * @return the legacy video, or <code>null</code> if a legacy video with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyVideo fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the legacy videos.
	 *
	 * @return the legacy videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyVideo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy videos
	 * @param end the upper bound of the range of legacy videos (not inclusive)
	 * @return the range of legacy videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyVideo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy videos
	 * @param end the upper bound of the range of legacy videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy videos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyVideo> findAll(int start, int end,
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

		List<LegacyVideo> list = (List<LegacyVideo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYVIDEO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYVIDEO;

				if (pagination) {
					sql = sql.concat(LegacyVideoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyVideo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyVideo>(list);
				}
				else {
					list = (List<LegacyVideo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legacy videos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyVideo legacyVideo : findAll()) {
			remove(legacyVideo);
		}
	}

	/**
	 * Returns the number of legacy videos.
	 *
	 * @return the number of legacy videos
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYVIDEO);

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
	 * Initializes the legacy video persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyVideo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyVideo>> listenersList = new ArrayList<ModelListener<LegacyVideo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyVideo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyVideoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYVIDEO = "SELECT legacyVideo FROM LegacyVideo legacyVideo";
	private static final String _SQL_COUNT_LEGACYVIDEO = "SELECT COUNT(legacyVideo) FROM LegacyVideo legacyVideo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyVideo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyVideo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyVideoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static LegacyVideo _nullLegacyVideo = new LegacyVideoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyVideo> toCacheModel() {
				return _nullLegacyVideoCacheModel;
			}
		};

	private static CacheModel<LegacyVideo> _nullLegacyVideoCacheModel = new CacheModel<LegacyVideo>() {
			@Override
			public LegacyVideo toEntityModel() {
				return _nullLegacyVideo;
			}
		};
}