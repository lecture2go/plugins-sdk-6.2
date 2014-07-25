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

import de.uhh.l2g.plugins.NoSuchLastvideolistException;
import de.uhh.l2g.plugins.model.Lastvideolist;
import de.uhh.l2g.plugins.model.impl.LastvideolistImpl;
import de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the lastvideolist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LastvideolistPersistence
 * @see LastvideolistUtil
 * @generated
 */
public class LastvideolistPersistenceImpl extends BasePersistenceImpl<Lastvideolist>
	implements LastvideolistPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LastvideolistUtil} to access the lastvideolist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LastvideolistImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LastvideolistPersistenceImpl() {
		setModelClass(Lastvideolist.class);
	}

	/**
	 * Caches the lastvideolist in the entity cache if it is enabled.
	 *
	 * @param lastvideolist the lastvideolist
	 */
	@Override
	public void cacheResult(Lastvideolist lastvideolist) {
		EntityCacheUtil.putResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistImpl.class, lastvideolist.getPrimaryKey(),
			lastvideolist);

		lastvideolist.resetOriginalValues();
	}

	/**
	 * Caches the lastvideolists in the entity cache if it is enabled.
	 *
	 * @param lastvideolists the lastvideolists
	 */
	@Override
	public void cacheResult(List<Lastvideolist> lastvideolists) {
		for (Lastvideolist lastvideolist : lastvideolists) {
			if (EntityCacheUtil.getResult(
						LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
						LastvideolistImpl.class, lastvideolist.getPrimaryKey()) == null) {
				cacheResult(lastvideolist);
			}
			else {
				lastvideolist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lastvideolists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LastvideolistImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LastvideolistImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lastvideolist.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lastvideolist lastvideolist) {
		EntityCacheUtil.removeResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistImpl.class, lastvideolist.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Lastvideolist> lastvideolists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lastvideolist lastvideolist : lastvideolists) {
			EntityCacheUtil.removeResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
				LastvideolistImpl.class, lastvideolist.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lastvideolist with the primary key. Does not add the lastvideolist to the database.
	 *
	 * @param lastvideolistId the primary key for the new lastvideolist
	 * @return the new lastvideolist
	 */
	@Override
	public Lastvideolist create(int lastvideolistId) {
		Lastvideolist lastvideolist = new LastvideolistImpl();

		lastvideolist.setNew(true);
		lastvideolist.setPrimaryKey(lastvideolistId);

		return lastvideolist;
	}

	/**
	 * Removes the lastvideolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lastvideolist remove(int lastvideolistId)
		throws NoSuchLastvideolistException, SystemException {
		return remove((Serializable)lastvideolistId);
	}

	/**
	 * Removes the lastvideolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lastvideolist
	 * @return the lastvideolist that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lastvideolist remove(Serializable primaryKey)
		throws NoSuchLastvideolistException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Lastvideolist lastvideolist = (Lastvideolist)session.get(LastvideolistImpl.class,
					primaryKey);

			if (lastvideolist == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLastvideolistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lastvideolist);
		}
		catch (NoSuchLastvideolistException nsee) {
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
	protected Lastvideolist removeImpl(Lastvideolist lastvideolist)
		throws SystemException {
		lastvideolist = toUnwrappedModel(lastvideolist);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lastvideolist)) {
				lastvideolist = (Lastvideolist)session.get(LastvideolistImpl.class,
						lastvideolist.getPrimaryKeyObj());
			}

			if (lastvideolist != null) {
				session.delete(lastvideolist);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lastvideolist != null) {
			clearCache(lastvideolist);
		}

		return lastvideolist;
	}

	@Override
	public Lastvideolist updateImpl(
		de.uhh.l2g.plugins.model.Lastvideolist lastvideolist)
		throws SystemException {
		lastvideolist = toUnwrappedModel(lastvideolist);

		boolean isNew = lastvideolist.isNew();

		Session session = null;

		try {
			session = openSession();

			if (lastvideolist.isNew()) {
				session.save(lastvideolist);

				lastvideolist.setNew(false);
			}
			else {
				session.merge(lastvideolist);
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

		EntityCacheUtil.putResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistImpl.class, lastvideolist.getPrimaryKey(),
			lastvideolist);

		return lastvideolist;
	}

	protected Lastvideolist toUnwrappedModel(Lastvideolist lastvideolist) {
		if (lastvideolist instanceof LastvideolistImpl) {
			return lastvideolist;
		}

		LastvideolistImpl lastvideolistImpl = new LastvideolistImpl();

		lastvideolistImpl.setNew(lastvideolist.isNew());
		lastvideolistImpl.setPrimaryKey(lastvideolist.getPrimaryKey());

		lastvideolistImpl.setLastvideolistId(lastvideolist.getLastvideolistId());
		lastvideolistImpl.setVideoId(lastvideolist.getVideoId());

		return lastvideolistImpl;
	}

	/**
	 * Returns the lastvideolist with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lastvideolist
	 * @return the lastvideolist
	 * @throws de.uhh.l2g.plugins.NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lastvideolist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLastvideolistException, SystemException {
		Lastvideolist lastvideolist = fetchByPrimaryKey(primaryKey);

		if (lastvideolist == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLastvideolistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lastvideolist;
	}

	/**
	 * Returns the lastvideolist with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLastvideolistException} if it could not be found.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist
	 * @throws de.uhh.l2g.plugins.NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lastvideolist findByPrimaryKey(int lastvideolistId)
		throws NoSuchLastvideolistException, SystemException {
		return findByPrimaryKey((Serializable)lastvideolistId);
	}

	/**
	 * Returns the lastvideolist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lastvideolist
	 * @return the lastvideolist, or <code>null</code> if a lastvideolist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lastvideolist fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Lastvideolist lastvideolist = (Lastvideolist)EntityCacheUtil.getResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
				LastvideolistImpl.class, primaryKey);

		if (lastvideolist == _nullLastvideolist) {
			return null;
		}

		if (lastvideolist == null) {
			Session session = null;

			try {
				session = openSession();

				lastvideolist = (Lastvideolist)session.get(LastvideolistImpl.class,
						primaryKey);

				if (lastvideolist != null) {
					cacheResult(lastvideolist);
				}
				else {
					EntityCacheUtil.putResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
						LastvideolistImpl.class, primaryKey, _nullLastvideolist);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
					LastvideolistImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lastvideolist;
	}

	/**
	 * Returns the lastvideolist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist, or <code>null</code> if a lastvideolist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lastvideolist fetchByPrimaryKey(int lastvideolistId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)lastvideolistId);
	}

	/**
	 * Returns all the lastvideolists.
	 *
	 * @return the lastvideolists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lastvideolist> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of lastvideolists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lastvideolist> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lastvideolists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lastvideolist> findAll(int start, int end,
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

		List<Lastvideolist> list = (List<Lastvideolist>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LASTVIDEOLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LASTVIDEOLIST;

				if (pagination) {
					sql = sql.concat(LastvideolistModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Lastvideolist>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lastvideolist>(list);
				}
				else {
					list = (List<Lastvideolist>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the lastvideolists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Lastvideolist lastvideolist : findAll()) {
			remove(lastvideolist);
		}
	}

	/**
	 * Returns the number of lastvideolists.
	 *
	 * @return the number of lastvideolists
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

				Query q = session.createQuery(_SQL_COUNT_LASTVIDEOLIST);

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
	 * Initializes the lastvideolist persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Lastvideolist")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Lastvideolist>> listenersList = new ArrayList<ModelListener<Lastvideolist>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Lastvideolist>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LastvideolistImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LASTVIDEOLIST = "SELECT lastvideolist FROM Lastvideolist lastvideolist";
	private static final String _SQL_COUNT_LASTVIDEOLIST = "SELECT COUNT(lastvideolist) FROM Lastvideolist lastvideolist";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lastvideolist.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lastvideolist exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LastvideolistPersistenceImpl.class);
	private static Lastvideolist _nullLastvideolist = new LastvideolistImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Lastvideolist> toCacheModel() {
				return _nullLastvideolistCacheModel;
			}
		};

	private static CacheModel<Lastvideolist> _nullLastvideolistCacheModel = new CacheModel<Lastvideolist>() {
			@Override
			public Lastvideolist toEntityModel() {
				return _nullLastvideolist;
			}
		};
}