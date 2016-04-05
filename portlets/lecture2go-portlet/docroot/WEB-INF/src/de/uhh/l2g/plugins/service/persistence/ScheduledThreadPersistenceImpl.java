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

import de.uhh.l2g.plugins.NoSuchScheduledThreadException;
import de.uhh.l2g.plugins.model.ScheduledThread;
import de.uhh.l2g.plugins.model.impl.ScheduledThreadImpl;
import de.uhh.l2g.plugins.model.impl.ScheduledThreadModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the scheduled thread service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ScheduledThreadPersistence
 * @see ScheduledThreadUtil
 * @generated
 */
public class ScheduledThreadPersistenceImpl extends BasePersistenceImpl<ScheduledThread>
	implements ScheduledThreadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScheduledThreadUtil} to access the scheduled thread persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScheduledThreadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ScheduledThreadPersistenceImpl() {
		setModelClass(ScheduledThread.class);
	}

	/**
	 * Caches the scheduled thread in the entity cache if it is enabled.
	 *
	 * @param scheduledThread the scheduled thread
	 */
	@Override
	public void cacheResult(ScheduledThread scheduledThread) {
		EntityCacheUtil.putResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadImpl.class, scheduledThread.getPrimaryKey(),
			scheduledThread);

		scheduledThread.resetOriginalValues();
	}

	/**
	 * Caches the scheduled threads in the entity cache if it is enabled.
	 *
	 * @param scheduledThreads the scheduled threads
	 */
	@Override
	public void cacheResult(List<ScheduledThread> scheduledThreads) {
		for (ScheduledThread scheduledThread : scheduledThreads) {
			if (EntityCacheUtil.getResult(
						ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
						ScheduledThreadImpl.class,
						scheduledThread.getPrimaryKey()) == null) {
				cacheResult(scheduledThread);
			}
			else {
				scheduledThread.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all scheduled threads.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScheduledThreadImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScheduledThreadImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the scheduled thread.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScheduledThread scheduledThread) {
		EntityCacheUtil.removeResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadImpl.class, scheduledThread.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ScheduledThread> scheduledThreads) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScheduledThread scheduledThread : scheduledThreads) {
			EntityCacheUtil.removeResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
				ScheduledThreadImpl.class, scheduledThread.getPrimaryKey());
		}
	}

	/**
	 * Creates a new scheduled thread with the primary key. Does not add the scheduled thread to the database.
	 *
	 * @param scheduledThreadId the primary key for the new scheduled thread
	 * @return the new scheduled thread
	 */
	@Override
	public ScheduledThread create(long scheduledThreadId) {
		ScheduledThread scheduledThread = new ScheduledThreadImpl();

		scheduledThread.setNew(true);
		scheduledThread.setPrimaryKey(scheduledThreadId);

		return scheduledThread;
	}

	/**
	 * Removes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScheduledThread remove(long scheduledThreadId)
		throws NoSuchScheduledThreadException, SystemException {
		return remove((Serializable)scheduledThreadId);
	}

	/**
	 * Removes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the scheduled thread
	 * @return the scheduled thread that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScheduledThread remove(Serializable primaryKey)
		throws NoSuchScheduledThreadException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ScheduledThread scheduledThread = (ScheduledThread)session.get(ScheduledThreadImpl.class,
					primaryKey);

			if (scheduledThread == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScheduledThreadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scheduledThread);
		}
		catch (NoSuchScheduledThreadException nsee) {
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
	protected ScheduledThread removeImpl(ScheduledThread scheduledThread)
		throws SystemException {
		scheduledThread = toUnwrappedModel(scheduledThread);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scheduledThread)) {
				scheduledThread = (ScheduledThread)session.get(ScheduledThreadImpl.class,
						scheduledThread.getPrimaryKeyObj());
			}

			if (scheduledThread != null) {
				session.delete(scheduledThread);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scheduledThread != null) {
			clearCache(scheduledThread);
		}

		return scheduledThread;
	}

	@Override
	public ScheduledThread updateImpl(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread)
		throws SystemException {
		scheduledThread = toUnwrappedModel(scheduledThread);

		boolean isNew = scheduledThread.isNew();

		Session session = null;

		try {
			session = openSession();

			if (scheduledThread.isNew()) {
				session.save(scheduledThread);

				scheduledThread.setNew(false);
			}
			else {
				session.merge(scheduledThread);
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

		EntityCacheUtil.putResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadImpl.class, scheduledThread.getPrimaryKey(),
			scheduledThread);

		return scheduledThread;
	}

	protected ScheduledThread toUnwrappedModel(ScheduledThread scheduledThread) {
		if (scheduledThread instanceof ScheduledThreadImpl) {
			return scheduledThread;
		}

		ScheduledThreadImpl scheduledThreadImpl = new ScheduledThreadImpl();

		scheduledThreadImpl.setNew(scheduledThread.isNew());
		scheduledThreadImpl.setPrimaryKey(scheduledThread.getPrimaryKey());

		scheduledThreadImpl.setScheduledThreadId(scheduledThread.getScheduledThreadId());
		scheduledThreadImpl.setGroupId(scheduledThread.getGroupId());
		scheduledThreadImpl.setCompanyId(scheduledThread.getCompanyId());
		scheduledThreadImpl.setUserId(scheduledThread.getUserId());
		scheduledThreadImpl.setUserName(scheduledThread.getUserName());
		scheduledThreadImpl.setCreateDate(scheduledThread.getCreateDate());
		scheduledThreadImpl.setModifiedDate(scheduledThread.getModifiedDate());

		return scheduledThreadImpl;
	}

	/**
	 * Returns the scheduled thread with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the scheduled thread
	 * @return the scheduled thread
	 * @throws de.uhh.l2g.plugins.NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScheduledThread findByPrimaryKey(Serializable primaryKey)
		throws NoSuchScheduledThreadException, SystemException {
		ScheduledThread scheduledThread = fetchByPrimaryKey(primaryKey);

		if (scheduledThread == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchScheduledThreadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scheduledThread;
	}

	/**
	 * Returns the scheduled thread with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchScheduledThreadException} if it could not be found.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread
	 * @throws de.uhh.l2g.plugins.NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScheduledThread findByPrimaryKey(long scheduledThreadId)
		throws NoSuchScheduledThreadException, SystemException {
		return findByPrimaryKey((Serializable)scheduledThreadId);
	}

	/**
	 * Returns the scheduled thread with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the scheduled thread
	 * @return the scheduled thread, or <code>null</code> if a scheduled thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScheduledThread fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ScheduledThread scheduledThread = (ScheduledThread)EntityCacheUtil.getResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
				ScheduledThreadImpl.class, primaryKey);

		if (scheduledThread == _nullScheduledThread) {
			return null;
		}

		if (scheduledThread == null) {
			Session session = null;

			try {
				session = openSession();

				scheduledThread = (ScheduledThread)session.get(ScheduledThreadImpl.class,
						primaryKey);

				if (scheduledThread != null) {
					cacheResult(scheduledThread);
				}
				else {
					EntityCacheUtil.putResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
						ScheduledThreadImpl.class, primaryKey,
						_nullScheduledThread);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
					ScheduledThreadImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scheduledThread;
	}

	/**
	 * Returns the scheduled thread with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread, or <code>null</code> if a scheduled thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScheduledThread fetchByPrimaryKey(long scheduledThreadId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)scheduledThreadId);
	}

	/**
	 * Returns all the scheduled threads.
	 *
	 * @return the scheduled threads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScheduledThread> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the scheduled threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ScheduledThreadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of scheduled threads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScheduledThread> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the scheduled threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ScheduledThreadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of scheduled threads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScheduledThread> findAll(int start, int end,
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

		List<ScheduledThread> list = (List<ScheduledThread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCHEDULEDTHREAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCHEDULEDTHREAD;

				if (pagination) {
					sql = sql.concat(ScheduledThreadModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ScheduledThread>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScheduledThread>(list);
				}
				else {
					list = (List<ScheduledThread>)QueryUtil.list(q,
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
	 * Removes all the scheduled threads from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ScheduledThread scheduledThread : findAll()) {
			remove(scheduledThread);
		}
	}

	/**
	 * Returns the number of scheduled threads.
	 *
	 * @return the number of scheduled threads
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

				Query q = session.createQuery(_SQL_COUNT_SCHEDULEDTHREAD);

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
	 * Initializes the scheduled thread persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.ScheduledThread")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ScheduledThread>> listenersList = new ArrayList<ModelListener<ScheduledThread>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ScheduledThread>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScheduledThreadImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SCHEDULEDTHREAD = "SELECT scheduledThread FROM ScheduledThread scheduledThread";
	private static final String _SQL_COUNT_SCHEDULEDTHREAD = "SELECT COUNT(scheduledThread) FROM ScheduledThread scheduledThread";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scheduledThread.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ScheduledThread exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ScheduledThreadPersistenceImpl.class);
	private static ScheduledThread _nullScheduledThread = new ScheduledThreadImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ScheduledThread> toCacheModel() {
				return _nullScheduledThreadCacheModel;
			}
		};

	private static CacheModel<ScheduledThread> _nullScheduledThreadCacheModel = new CacheModel<ScheduledThread>() {
			@Override
			public ScheduledThread toEntityModel() {
				return _nullScheduledThread;
			}
		};
}