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

import de.uhh.l2g.plugins.NoSuchVideoStatisticException;
import de.uhh.l2g.plugins.model.VideoStatistic;
import de.uhh.l2g.plugins.model.impl.VideoStatisticImpl;
import de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video statistic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideoStatisticPersistence
 * @see VideoStatisticUtil
 * @generated
 */
public class VideoStatisticPersistenceImpl extends BasePersistenceImpl<VideoStatistic>
	implements VideoStatisticPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoStatisticUtil} to access the video statistic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoStatisticImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED,
			VideoStatisticImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED,
			VideoStatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public VideoStatisticPersistenceImpl() {
		setModelClass(VideoStatistic.class);
	}

	/**
	 * Caches the video statistic in the entity cache if it is enabled.
	 *
	 * @param videoStatistic the video statistic
	 */
	@Override
	public void cacheResult(VideoStatistic videoStatistic) {
		EntityCacheUtil.putResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticImpl.class, videoStatistic.getPrimaryKey(),
			videoStatistic);

		videoStatistic.resetOriginalValues();
	}

	/**
	 * Caches the video statistics in the entity cache if it is enabled.
	 *
	 * @param videoStatistics the video statistics
	 */
	@Override
	public void cacheResult(List<VideoStatistic> videoStatistics) {
		for (VideoStatistic videoStatistic : videoStatistics) {
			if (EntityCacheUtil.getResult(
						VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
						VideoStatisticImpl.class, videoStatistic.getPrimaryKey()) == null) {
				cacheResult(videoStatistic);
			}
			else {
				videoStatistic.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video statistics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoStatisticImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoStatisticImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video statistic.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoStatistic videoStatistic) {
		EntityCacheUtil.removeResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticImpl.class, videoStatistic.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VideoStatistic> videoStatistics) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoStatistic videoStatistic : videoStatistics) {
			EntityCacheUtil.removeResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
				VideoStatisticImpl.class, videoStatistic.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video statistic with the primary key. Does not add the video statistic to the database.
	 *
	 * @param videoStatisticId the primary key for the new video statistic
	 * @return the new video statistic
	 */
	@Override
	public VideoStatistic create(long videoStatisticId) {
		VideoStatistic videoStatistic = new VideoStatisticImpl();

		videoStatistic.setNew(true);
		videoStatistic.setPrimaryKey(videoStatisticId);

		return videoStatistic;
	}

	/**
	 * Removes the video statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoStatisticId the primary key of the video statistic
	 * @return the video statistic that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoStatistic remove(long videoStatisticId)
		throws NoSuchVideoStatisticException, SystemException {
		return remove((Serializable)videoStatisticId);
	}

	/**
	 * Removes the video statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video statistic
	 * @return the video statistic that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoStatistic remove(Serializable primaryKey)
		throws NoSuchVideoStatisticException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoStatistic videoStatistic = (VideoStatistic)session.get(VideoStatisticImpl.class,
					primaryKey);

			if (videoStatistic == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoStatisticException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoStatistic);
		}
		catch (NoSuchVideoStatisticException nsee) {
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
	protected VideoStatistic removeImpl(VideoStatistic videoStatistic)
		throws SystemException {
		videoStatistic = toUnwrappedModel(videoStatistic);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(videoStatistic)) {
				videoStatistic = (VideoStatistic)session.get(VideoStatisticImpl.class,
						videoStatistic.getPrimaryKeyObj());
			}

			if (videoStatistic != null) {
				session.delete(videoStatistic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (videoStatistic != null) {
			clearCache(videoStatistic);
		}

		return videoStatistic;
	}

	@Override
	public VideoStatistic updateImpl(
		de.uhh.l2g.plugins.model.VideoStatistic videoStatistic)
		throws SystemException {
		videoStatistic = toUnwrappedModel(videoStatistic);

		boolean isNew = videoStatistic.isNew();

		Session session = null;

		try {
			session = openSession();

			if (videoStatistic.isNew()) {
				session.save(videoStatistic);

				videoStatistic.setNew(false);
			}
			else {
				session.merge(videoStatistic);
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

		EntityCacheUtil.putResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticImpl.class, videoStatistic.getPrimaryKey(),
			videoStatistic);

		return videoStatistic;
	}

	protected VideoStatistic toUnwrappedModel(VideoStatistic videoStatistic) {
		if (videoStatistic instanceof VideoStatisticImpl) {
			return videoStatistic;
		}

		VideoStatisticImpl videoStatisticImpl = new VideoStatisticImpl();

		videoStatisticImpl.setNew(videoStatistic.isNew());
		videoStatisticImpl.setPrimaryKey(videoStatistic.getPrimaryKey());

		videoStatisticImpl.setVideoStatisticId(videoStatistic.getVideoStatisticId());
		videoStatisticImpl.setGroupId(videoStatistic.getGroupId());
		videoStatisticImpl.setCompanyId(videoStatistic.getCompanyId());
		videoStatisticImpl.setCreateDate(videoStatistic.getCreateDate());
		videoStatisticImpl.setModifiedDate(videoStatistic.getModifiedDate());
		videoStatisticImpl.setCompareDate(videoStatistic.getCompareDate());
		videoStatisticImpl.setTotalVideos(videoStatistic.getTotalVideos());
		videoStatisticImpl.setPublicVideos(videoStatistic.getPublicVideos());
		videoStatisticImpl.setPrivateVideos(videoStatistic.getPrivateVideos());
		videoStatisticImpl.setCurrentTotal(videoStatistic.getCurrentTotal());
		videoStatisticImpl.setCurrentPublic(videoStatistic.getCurrentPublic());
		videoStatisticImpl.setCurrentPrivate(videoStatistic.getCurrentPrivate());
		videoStatisticImpl.setPubPercent(videoStatistic.getPubPercent());
		videoStatisticImpl.setPrivPercent(videoStatistic.getPrivPercent());
		videoStatisticImpl.setCurrentPubPercent(videoStatistic.getCurrentPubPercent());
		videoStatisticImpl.setCurrentPrivPercent(videoStatistic.getCurrentPrivPercent());
		videoStatisticImpl.setIntervalName(videoStatistic.getIntervalName());

		return videoStatisticImpl;
	}

	/**
	 * Returns the video statistic with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video statistic
	 * @return the video statistic
	 * @throws de.uhh.l2g.plugins.NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoStatistic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideoStatisticException, SystemException {
		VideoStatistic videoStatistic = fetchByPrimaryKey(primaryKey);

		if (videoStatistic == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideoStatisticException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return videoStatistic;
	}

	/**
	 * Returns the video statistic with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideoStatisticException} if it could not be found.
	 *
	 * @param videoStatisticId the primary key of the video statistic
	 * @return the video statistic
	 * @throws de.uhh.l2g.plugins.NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoStatistic findByPrimaryKey(long videoStatisticId)
		throws NoSuchVideoStatisticException, SystemException {
		return findByPrimaryKey((Serializable)videoStatisticId);
	}

	/**
	 * Returns the video statistic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video statistic
	 * @return the video statistic, or <code>null</code> if a video statistic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoStatistic fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VideoStatistic videoStatistic = (VideoStatistic)EntityCacheUtil.getResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
				VideoStatisticImpl.class, primaryKey);

		if (videoStatistic == _nullVideoStatistic) {
			return null;
		}

		if (videoStatistic == null) {
			Session session = null;

			try {
				session = openSession();

				videoStatistic = (VideoStatistic)session.get(VideoStatisticImpl.class,
						primaryKey);

				if (videoStatistic != null) {
					cacheResult(videoStatistic);
				}
				else {
					EntityCacheUtil.putResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
						VideoStatisticImpl.class, primaryKey,
						_nullVideoStatistic);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
					VideoStatisticImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return videoStatistic;
	}

	/**
	 * Returns the video statistic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoStatisticId the primary key of the video statistic
	 * @return the video statistic, or <code>null</code> if a video statistic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoStatistic fetchByPrimaryKey(long videoStatisticId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)videoStatisticId);
	}

	/**
	 * Returns all the video statistics.
	 *
	 * @return the video statistics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoStatistic> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @return the range of video statistics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoStatistic> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video statistics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoStatistic> findAll(int start, int end,
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

		List<VideoStatistic> list = (List<VideoStatistic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOSTATISTIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOSTATISTIC;

				if (pagination) {
					sql = sql.concat(VideoStatisticModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VideoStatistic>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VideoStatistic>(list);
				}
				else {
					list = (List<VideoStatistic>)QueryUtil.list(q,
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
	 * Removes all the video statistics from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VideoStatistic videoStatistic : findAll()) {
			remove(videoStatistic);
		}
	}

	/**
	 * Returns the number of video statistics.
	 *
	 * @return the number of video statistics
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

				Query q = session.createQuery(_SQL_COUNT_VIDEOSTATISTIC);

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
	 * Initializes the video statistic persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.VideoStatistic")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoStatistic>> listenersList = new ArrayList<ModelListener<VideoStatistic>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoStatistic>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoStatisticImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEOSTATISTIC = "SELECT videoStatistic FROM VideoStatistic videoStatistic";
	private static final String _SQL_COUNT_VIDEOSTATISTIC = "SELECT COUNT(videoStatistic) FROM VideoStatistic videoStatistic";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoStatistic.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoStatistic exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoStatisticPersistenceImpl.class);
	private static VideoStatistic _nullVideoStatistic = new VideoStatisticImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoStatistic> toCacheModel() {
				return _nullVideoStatisticCacheModel;
			}
		};

	private static CacheModel<VideoStatistic> _nullVideoStatisticCacheModel = new CacheModel<VideoStatistic>() {
			@Override
			public VideoStatistic toEntityModel() {
				return _nullVideoStatistic;
			}
		};
}