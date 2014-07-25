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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchVideo_FacilityException;
import de.uhh.l2g.plugins.model.Video_Facility;
import de.uhh.l2g.plugins.model.impl.Video_FacilityImpl;
import de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video_ facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_FacilityPersistence
 * @see Video_FacilityUtil
 * @generated
 */
public class Video_FacilityPersistenceImpl extends BasePersistenceImpl<Video_Facility>
	implements Video_FacilityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Video_FacilityUtil} to access the video_ facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Video_FacilityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Video_FacilityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityModelImpl.FINDER_CACHE_ENABLED,
			Video_FacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public Video_FacilityPersistenceImpl() {
		setModelClass(Video_Facility.class);
	}

	/**
	 * Caches the video_ facility in the entity cache if it is enabled.
	 *
	 * @param video_Facility the video_ facility
	 */
	@Override
	public void cacheResult(Video_Facility video_Facility) {
		EntityCacheUtil.putResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityImpl.class, video_Facility.getPrimaryKey(),
			video_Facility);

		video_Facility.resetOriginalValues();
	}

	/**
	 * Caches the video_ facilities in the entity cache if it is enabled.
	 *
	 * @param video_Facilities the video_ facilities
	 */
	@Override
	public void cacheResult(List<Video_Facility> video_Facilities) {
		for (Video_Facility video_Facility : video_Facilities) {
			if (EntityCacheUtil.getResult(
						Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
						Video_FacilityImpl.class, video_Facility.getPrimaryKey()) == null) {
				cacheResult(video_Facility);
			}
			else {
				video_Facility.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ facilities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Video_FacilityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Video_FacilityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ facility.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_Facility video_Facility) {
		EntityCacheUtil.removeResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityImpl.class, video_Facility.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_Facility> video_Facilities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_Facility video_Facility : video_Facilities) {
			EntityCacheUtil.removeResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
				Video_FacilityImpl.class, video_Facility.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video_ facility with the primary key. Does not add the video_ facility to the database.
	 *
	 * @param videoFacilityId the primary key for the new video_ facility
	 * @return the new video_ facility
	 */
	@Override
	public Video_Facility create(long videoFacilityId) {
		Video_Facility video_Facility = new Video_FacilityImpl();

		video_Facility.setNew(true);
		video_Facility.setPrimaryKey(videoFacilityId);

		return video_Facility;
	}

	/**
	 * Removes the video_ facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoFacilityId the primary key of the video_ facility
	 * @return the video_ facility that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility remove(long videoFacilityId)
		throws NoSuchVideo_FacilityException, SystemException {
		return remove((Serializable)videoFacilityId);
	}

	/**
	 * Removes the video_ facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ facility
	 * @return the video_ facility that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility remove(Serializable primaryKey)
		throws NoSuchVideo_FacilityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Video_Facility video_Facility = (Video_Facility)session.get(Video_FacilityImpl.class,
					primaryKey);

			if (video_Facility == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_FacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(video_Facility);
		}
		catch (NoSuchVideo_FacilityException nsee) {
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
	protected Video_Facility removeImpl(Video_Facility video_Facility)
		throws SystemException {
		video_Facility = toUnwrappedModel(video_Facility);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_Facility)) {
				video_Facility = (Video_Facility)session.get(Video_FacilityImpl.class,
						video_Facility.getPrimaryKeyObj());
			}

			if (video_Facility != null) {
				session.delete(video_Facility);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video_Facility != null) {
			clearCache(video_Facility);
		}

		return video_Facility;
	}

	@Override
	public Video_Facility updateImpl(
		de.uhh.l2g.plugins.model.Video_Facility video_Facility)
		throws SystemException {
		video_Facility = toUnwrappedModel(video_Facility);

		boolean isNew = video_Facility.isNew();

		Session session = null;

		try {
			session = openSession();

			if (video_Facility.isNew()) {
				session.save(video_Facility);

				video_Facility.setNew(false);
			}
			else {
				session.merge(video_Facility);
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

		EntityCacheUtil.putResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
			Video_FacilityImpl.class, video_Facility.getPrimaryKey(),
			video_Facility);

		return video_Facility;
	}

	protected Video_Facility toUnwrappedModel(Video_Facility video_Facility) {
		if (video_Facility instanceof Video_FacilityImpl) {
			return video_Facility;
		}

		Video_FacilityImpl video_FacilityImpl = new Video_FacilityImpl();

		video_FacilityImpl.setNew(video_Facility.isNew());
		video_FacilityImpl.setPrimaryKey(video_Facility.getPrimaryKey());

		video_FacilityImpl.setVideoFacilityId(video_Facility.getVideoFacilityId());
		video_FacilityImpl.setVideoId(video_Facility.getVideoId());
		video_FacilityImpl.setFacilityId(video_Facility.getFacilityId());

		return video_FacilityImpl;
	}

	/**
	 * Returns the video_ facility with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ facility
	 * @return the video_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_FacilityException, SystemException {
		Video_Facility video_Facility = fetchByPrimaryKey(primaryKey);

		if (video_Facility == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_FacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return video_Facility;
	}

	/**
	 * Returns the video_ facility with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideo_FacilityException} if it could not be found.
	 *
	 * @param videoFacilityId the primary key of the video_ facility
	 * @return the video_ facility
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_FacilityException if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility findByPrimaryKey(long videoFacilityId)
		throws NoSuchVideo_FacilityException, SystemException {
		return findByPrimaryKey((Serializable)videoFacilityId);
	}

	/**
	 * Returns the video_ facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ facility
	 * @return the video_ facility, or <code>null</code> if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Video_Facility video_Facility = (Video_Facility)EntityCacheUtil.getResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
				Video_FacilityImpl.class, primaryKey);

		if (video_Facility == _nullVideo_Facility) {
			return null;
		}

		if (video_Facility == null) {
			Session session = null;

			try {
				session = openSession();

				video_Facility = (Video_Facility)session.get(Video_FacilityImpl.class,
						primaryKey);

				if (video_Facility != null) {
					cacheResult(video_Facility);
				}
				else {
					EntityCacheUtil.putResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
						Video_FacilityImpl.class, primaryKey,
						_nullVideo_Facility);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Video_FacilityModelImpl.ENTITY_CACHE_ENABLED,
					Video_FacilityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return video_Facility;
	}

	/**
	 * Returns the video_ facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoFacilityId the primary key of the video_ facility
	 * @return the video_ facility, or <code>null</code> if a video_ facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Facility fetchByPrimaryKey(long videoFacilityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)videoFacilityId);
	}

	/**
	 * Returns all the video_ facilities.
	 *
	 * @return the video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Facility> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ facilities
	 * @param end the upper bound of the range of video_ facilities (not inclusive)
	 * @return the range of video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Facility> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ facilities
	 * @param end the upper bound of the range of video_ facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Facility> findAll(int start, int end,
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

		List<Video_Facility> list = (List<Video_Facility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEO_FACILITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_FACILITY;

				if (pagination) {
					sql = sql.concat(Video_FacilityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video_Facility>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Facility>(list);
				}
				else {
					list = (List<Video_Facility>)QueryUtil.list(q,
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
	 * Removes all the video_ facilities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Video_Facility video_Facility : findAll()) {
			remove(video_Facility);
		}
	}

	/**
	 * Returns the number of video_ facilities.
	 *
	 * @return the number of video_ facilities
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

				Query q = session.createQuery(_SQL_COUNT_VIDEO_FACILITY);

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
	 * Initializes the video_ facility persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Video_Facility")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Video_Facility>> listenersList = new ArrayList<ModelListener<Video_Facility>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Video_Facility>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Video_FacilityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEO_FACILITY = "SELECT video_Facility FROM Video_Facility video_Facility";
	private static final String _SQL_COUNT_VIDEO_FACILITY = "SELECT COUNT(video_Facility) FROM Video_Facility video_Facility";
	private static final String _ORDER_BY_ENTITY_ALIAS = "video_Facility.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Video_Facility exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Video_FacilityPersistenceImpl.class);
	private static Video_Facility _nullVideo_Facility = new Video_FacilityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Video_Facility> toCacheModel() {
				return _nullVideo_FacilityCacheModel;
			}
		};

	private static CacheModel<Video_Facility> _nullVideo_FacilityCacheModel = new CacheModel<Video_Facility>() {
			@Override
			public Video_Facility toEntityModel() {
				return _nullVideo_Facility;
			}
		};
}