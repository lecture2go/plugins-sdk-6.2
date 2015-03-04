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

import de.uhh.l2g.plugins.NoSuchVideo_CreatorException;
import de.uhh.l2g.plugins.model.Video_Creator;
import de.uhh.l2g.plugins.model.impl.Video_CreatorImpl;
import de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video_ creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_CreatorPersistence
 * @see Video_CreatorUtil
 * @generated
 */
public class Video_CreatorPersistenceImpl extends BasePersistenceImpl<Video_Creator>
	implements Video_CreatorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Video_CreatorUtil} to access the video_ creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Video_CreatorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public Video_CreatorPersistenceImpl() {
		setModelClass(Video_Creator.class);
	}

	/**
	 * Caches the video_ creator in the entity cache if it is enabled.
	 *
	 * @param video_Creator the video_ creator
	 */
	@Override
	public void cacheResult(Video_Creator video_Creator) {
		EntityCacheUtil.putResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorImpl.class, video_Creator.getPrimaryKey(),
			video_Creator);

		video_Creator.resetOriginalValues();
	}

	/**
	 * Caches the video_ creators in the entity cache if it is enabled.
	 *
	 * @param video_Creators the video_ creators
	 */
	@Override
	public void cacheResult(List<Video_Creator> video_Creators) {
		for (Video_Creator video_Creator : video_Creators) {
			if (EntityCacheUtil.getResult(
						Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
						Video_CreatorImpl.class, video_Creator.getPrimaryKey()) == null) {
				cacheResult(video_Creator);
			}
			else {
				video_Creator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ creators.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Video_CreatorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Video_CreatorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ creator.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_Creator video_Creator) {
		EntityCacheUtil.removeResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorImpl.class, video_Creator.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_Creator> video_Creators) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_Creator video_Creator : video_Creators) {
			EntityCacheUtil.removeResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
				Video_CreatorImpl.class, video_Creator.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video_ creator with the primary key. Does not add the video_ creator to the database.
	 *
	 * @param videoCreatorId the primary key for the new video_ creator
	 * @return the new video_ creator
	 */
	@Override
	public Video_Creator create(long videoCreatorId) {
		Video_Creator video_Creator = new Video_CreatorImpl();

		video_Creator.setNew(true);
		video_Creator.setPrimaryKey(videoCreatorId);

		return video_Creator;
	}

	/**
	 * Removes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator remove(long videoCreatorId)
		throws NoSuchVideo_CreatorException, SystemException {
		return remove((Serializable)videoCreatorId);
	}

	/**
	 * Removes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ creator
	 * @return the video_ creator that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator remove(Serializable primaryKey)
		throws NoSuchVideo_CreatorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Video_Creator video_Creator = (Video_Creator)session.get(Video_CreatorImpl.class,
					primaryKey);

			if (video_Creator == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_CreatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(video_Creator);
		}
		catch (NoSuchVideo_CreatorException nsee) {
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
	protected Video_Creator removeImpl(Video_Creator video_Creator)
		throws SystemException {
		video_Creator = toUnwrappedModel(video_Creator);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_Creator)) {
				video_Creator = (Video_Creator)session.get(Video_CreatorImpl.class,
						video_Creator.getPrimaryKeyObj());
			}

			if (video_Creator != null) {
				session.delete(video_Creator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video_Creator != null) {
			clearCache(video_Creator);
		}

		return video_Creator;
	}

	@Override
	public Video_Creator updateImpl(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator)
		throws SystemException {
		video_Creator = toUnwrappedModel(video_Creator);

		boolean isNew = video_Creator.isNew();

		Session session = null;

		try {
			session = openSession();

			if (video_Creator.isNew()) {
				session.save(video_Creator);

				video_Creator.setNew(false);
			}
			else {
				session.merge(video_Creator);
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

		EntityCacheUtil.putResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorImpl.class, video_Creator.getPrimaryKey(),
			video_Creator);

		return video_Creator;
	}

	protected Video_Creator toUnwrappedModel(Video_Creator video_Creator) {
		if (video_Creator instanceof Video_CreatorImpl) {
			return video_Creator;
		}

		Video_CreatorImpl video_CreatorImpl = new Video_CreatorImpl();

		video_CreatorImpl.setNew(video_Creator.isNew());
		video_CreatorImpl.setPrimaryKey(video_Creator.getPrimaryKey());

		video_CreatorImpl.setVideoCreatorId(video_Creator.getVideoCreatorId());
		video_CreatorImpl.setCreatorId(video_Creator.getCreatorId());

		return video_CreatorImpl;
	}

	/**
	 * Returns the video_ creator with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ creator
	 * @return the video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_CreatorException, SystemException {
		Video_Creator video_Creator = fetchByPrimaryKey(primaryKey);

		if (video_Creator == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_CreatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return video_Creator;
	}

	/**
	 * Returns the video_ creator with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideo_CreatorException} if it could not be found.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator
	 * @throws de.uhh.l2g.plugins.NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator findByPrimaryKey(long videoCreatorId)
		throws NoSuchVideo_CreatorException, SystemException {
		return findByPrimaryKey((Serializable)videoCreatorId);
	}

	/**
	 * Returns the video_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ creator
	 * @return the video_ creator, or <code>null</code> if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Video_Creator video_Creator = (Video_Creator)EntityCacheUtil.getResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
				Video_CreatorImpl.class, primaryKey);

		if (video_Creator == _nullVideo_Creator) {
			return null;
		}

		if (video_Creator == null) {
			Session session = null;

			try {
				session = openSession();

				video_Creator = (Video_Creator)session.get(Video_CreatorImpl.class,
						primaryKey);

				if (video_Creator != null) {
					cacheResult(video_Creator);
				}
				else {
					EntityCacheUtil.putResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
						Video_CreatorImpl.class, primaryKey, _nullVideo_Creator);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
					Video_CreatorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return video_Creator;
	}

	/**
	 * Returns the video_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator, or <code>null</code> if a video_ creator with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Video_Creator fetchByPrimaryKey(long videoCreatorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)videoCreatorId);
	}

	/**
	 * Returns all the video_ creators.
	 *
	 * @return the video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ creators
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Video_Creator> findAll(int start, int end,
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

		List<Video_Creator> list = (List<Video_Creator>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEO_CREATOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_CREATOR;

				if (pagination) {
					sql = sql.concat(Video_CreatorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Video_Creator>(list);
				}
				else {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the video_ creators from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Video_Creator video_Creator : findAll()) {
			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators.
	 *
	 * @return the number of video_ creators
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

				Query q = session.createQuery(_SQL_COUNT_VIDEO_CREATOR);

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
	 * Initializes the video_ creator persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Video_Creator")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Video_Creator>> listenersList = new ArrayList<ModelListener<Video_Creator>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Video_Creator>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Video_CreatorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEO_CREATOR = "SELECT video_Creator FROM Video_Creator video_Creator";
	private static final String _SQL_COUNT_VIDEO_CREATOR = "SELECT COUNT(video_Creator) FROM Video_Creator video_Creator";
	private static final String _ORDER_BY_ENTITY_ALIAS = "video_Creator.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Video_Creator exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Video_CreatorPersistenceImpl.class);
	private static Video_Creator _nullVideo_Creator = new Video_CreatorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Video_Creator> toCacheModel() {
				return _nullVideo_CreatorCacheModel;
			}
		};

	private static CacheModel<Video_Creator> _nullVideo_CreatorCacheModel = new CacheModel<Video_Creator>() {
			@Override
			public Video_Creator toEntityModel() {
				return _nullVideo_Creator;
			}
		};
}