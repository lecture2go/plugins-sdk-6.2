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

import de.uhh.l2g.plugins.NoSuchVideohitlistException;
import de.uhh.l2g.plugins.model.Videohitlist;
import de.uhh.l2g.plugins.model.impl.VideohitlistImpl;
import de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the videohitlist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideohitlistPersistence
 * @see VideohitlistUtil
 * @generated
 */
public class VideohitlistPersistenceImpl extends BasePersistenceImpl<Videohitlist>
	implements VideohitlistPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideohitlistUtil} to access the videohitlist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideohitlistImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public VideohitlistPersistenceImpl() {
		setModelClass(Videohitlist.class);
	}

	/**
	 * Caches the videohitlist in the entity cache if it is enabled.
	 *
	 * @param videohitlist the videohitlist
	 */
	@Override
	public void cacheResult(Videohitlist videohitlist) {
		EntityCacheUtil.putResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistImpl.class, videohitlist.getPrimaryKey(), videohitlist);

		videohitlist.resetOriginalValues();
	}

	/**
	 * Caches the videohitlists in the entity cache if it is enabled.
	 *
	 * @param videohitlists the videohitlists
	 */
	@Override
	public void cacheResult(List<Videohitlist> videohitlists) {
		for (Videohitlist videohitlist : videohitlists) {
			if (EntityCacheUtil.getResult(
						VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
						VideohitlistImpl.class, videohitlist.getPrimaryKey()) == null) {
				cacheResult(videohitlist);
			}
			else {
				videohitlist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all videohitlists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideohitlistImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideohitlistImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the videohitlist.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Videohitlist videohitlist) {
		EntityCacheUtil.removeResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistImpl.class, videohitlist.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Videohitlist> videohitlists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Videohitlist videohitlist : videohitlists) {
			EntityCacheUtil.removeResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
				VideohitlistImpl.class, videohitlist.getPrimaryKey());
		}
	}

	/**
	 * Creates a new videohitlist with the primary key. Does not add the videohitlist to the database.
	 *
	 * @param videohitlistId the primary key for the new videohitlist
	 * @return the new videohitlist
	 */
	@Override
	public Videohitlist create(long videohitlistId) {
		Videohitlist videohitlist = new VideohitlistImpl();

		videohitlist.setNew(true);
		videohitlist.setPrimaryKey(videohitlistId);

		return videohitlist;
	}

	/**
	 * Removes the videohitlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Videohitlist remove(long videohitlistId)
		throws NoSuchVideohitlistException, SystemException {
		return remove((Serializable)videohitlistId);
	}

	/**
	 * Removes the videohitlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the videohitlist
	 * @return the videohitlist that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Videohitlist remove(Serializable primaryKey)
		throws NoSuchVideohitlistException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Videohitlist videohitlist = (Videohitlist)session.get(VideohitlistImpl.class,
					primaryKey);

			if (videohitlist == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideohitlistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videohitlist);
		}
		catch (NoSuchVideohitlistException nsee) {
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
	protected Videohitlist removeImpl(Videohitlist videohitlist)
		throws SystemException {
		videohitlist = toUnwrappedModel(videohitlist);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(videohitlist)) {
				videohitlist = (Videohitlist)session.get(VideohitlistImpl.class,
						videohitlist.getPrimaryKeyObj());
			}

			if (videohitlist != null) {
				session.delete(videohitlist);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (videohitlist != null) {
			clearCache(videohitlist);
		}

		return videohitlist;
	}

	@Override
	public Videohitlist updateImpl(
		de.uhh.l2g.plugins.model.Videohitlist videohitlist)
		throws SystemException {
		videohitlist = toUnwrappedModel(videohitlist);

		boolean isNew = videohitlist.isNew();

		Session session = null;

		try {
			session = openSession();

			if (videohitlist.isNew()) {
				session.save(videohitlist);

				videohitlist.setNew(false);
			}
			else {
				session.merge(videohitlist);
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

		EntityCacheUtil.putResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistImpl.class, videohitlist.getPrimaryKey(), videohitlist);

		return videohitlist;
	}

	protected Videohitlist toUnwrappedModel(Videohitlist videohitlist) {
		if (videohitlist instanceof VideohitlistImpl) {
			return videohitlist;
		}

		VideohitlistImpl videohitlistImpl = new VideohitlistImpl();

		videohitlistImpl.setNew(videohitlist.isNew());
		videohitlistImpl.setPrimaryKey(videohitlist.getPrimaryKey());

		videohitlistImpl.setVideohitlistId(videohitlist.getVideohitlistId());
		videohitlistImpl.setHitsPerDay(videohitlist.getHitsPerDay());
		videohitlistImpl.setHitsPerWeek(videohitlist.getHitsPerWeek());
		videohitlistImpl.setHitsPerMonth(videohitlist.getHitsPerMonth());
		videohitlistImpl.setHitsPerYear(videohitlist.getHitsPerYear());
		videohitlistImpl.setVideoId(videohitlist.getVideoId());

		return videohitlistImpl;
	}

	/**
	 * Returns the videohitlist with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the videohitlist
	 * @return the videohitlist
	 * @throws de.uhh.l2g.plugins.NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Videohitlist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideohitlistException, SystemException {
		Videohitlist videohitlist = fetchByPrimaryKey(primaryKey);

		if (videohitlist == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideohitlistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return videohitlist;
	}

	/**
	 * Returns the videohitlist with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideohitlistException} if it could not be found.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist
	 * @throws de.uhh.l2g.plugins.NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Videohitlist findByPrimaryKey(long videohitlistId)
		throws NoSuchVideohitlistException, SystemException {
		return findByPrimaryKey((Serializable)videohitlistId);
	}

	/**
	 * Returns the videohitlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the videohitlist
	 * @return the videohitlist, or <code>null</code> if a videohitlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Videohitlist fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Videohitlist videohitlist = (Videohitlist)EntityCacheUtil.getResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
				VideohitlistImpl.class, primaryKey);

		if (videohitlist == _nullVideohitlist) {
			return null;
		}

		if (videohitlist == null) {
			Session session = null;

			try {
				session = openSession();

				videohitlist = (Videohitlist)session.get(VideohitlistImpl.class,
						primaryKey);

				if (videohitlist != null) {
					cacheResult(videohitlist);
				}
				else {
					EntityCacheUtil.putResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
						VideohitlistImpl.class, primaryKey, _nullVideohitlist);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
					VideohitlistImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return videohitlist;
	}

	/**
	 * Returns the videohitlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist, or <code>null</code> if a videohitlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Videohitlist fetchByPrimaryKey(long videohitlistId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)videohitlistId);
	}

	/**
	 * Returns all the videohitlists.
	 *
	 * @return the videohitlists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Videohitlist> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of videohitlists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Videohitlist> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of videohitlists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Videohitlist> findAll(int start, int end,
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

		List<Videohitlist> list = (List<Videohitlist>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOHITLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOHITLIST;

				if (pagination) {
					sql = sql.concat(VideohitlistModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Videohitlist>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Videohitlist>(list);
				}
				else {
					list = (List<Videohitlist>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the videohitlists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Videohitlist videohitlist : findAll()) {
			remove(videohitlist);
		}
	}

	/**
	 * Returns the number of videohitlists.
	 *
	 * @return the number of videohitlists
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

				Query q = session.createQuery(_SQL_COUNT_VIDEOHITLIST);

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
	 * Initializes the videohitlist persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Videohitlist")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Videohitlist>> listenersList = new ArrayList<ModelListener<Videohitlist>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Videohitlist>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideohitlistImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEOHITLIST = "SELECT videohitlist FROM Videohitlist videohitlist";
	private static final String _SQL_COUNT_VIDEOHITLIST = "SELECT COUNT(videohitlist) FROM Videohitlist videohitlist";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videohitlist.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Videohitlist exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideohitlistPersistenceImpl.class);
	private static Videohitlist _nullVideohitlist = new VideohitlistImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Videohitlist> toCacheModel() {
				return _nullVideohitlistCacheModel;
			}
		};

	private static CacheModel<Videohitlist> _nullVideohitlistCacheModel = new CacheModel<Videohitlist>() {
			@Override
			public Videohitlist toEntityModel() {
				return _nullVideohitlist;
			}
		};
}