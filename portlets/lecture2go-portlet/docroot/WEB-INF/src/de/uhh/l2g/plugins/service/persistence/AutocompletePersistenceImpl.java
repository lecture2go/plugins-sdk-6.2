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

import de.uhh.l2g.plugins.NoSuchAutocompleteException;
import de.uhh.l2g.plugins.model.Autocomplete;
import de.uhh.l2g.plugins.model.impl.AutocompleteImpl;
import de.uhh.l2g.plugins.model.impl.AutocompleteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the autocomplete service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see AutocompletePersistence
 * @see AutocompleteUtil
 * @generated
 */
public class AutocompletePersistenceImpl extends BasePersistenceImpl<Autocomplete>
	implements AutocompletePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AutocompleteUtil} to access the autocomplete persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AutocompleteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AutocompleteModelImpl.ENTITY_CACHE_ENABLED,
			AutocompleteModelImpl.FINDER_CACHE_ENABLED, AutocompleteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AutocompleteModelImpl.ENTITY_CACHE_ENABLED,
			AutocompleteModelImpl.FINDER_CACHE_ENABLED, AutocompleteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AutocompleteModelImpl.ENTITY_CACHE_ENABLED,
			AutocompleteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AutocompletePersistenceImpl() {
		setModelClass(Autocomplete.class);
	}

	/**
	 * Caches the autocomplete in the entity cache if it is enabled.
	 *
	 * @param autocomplete the autocomplete
	 */
	@Override
	public void cacheResult(Autocomplete autocomplete) {
		EntityCacheUtil.putResult(AutocompleteModelImpl.ENTITY_CACHE_ENABLED,
			AutocompleteImpl.class, autocomplete.getPrimaryKey(), autocomplete);

		autocomplete.resetOriginalValues();
	}

	/**
	 * Caches the autocompletes in the entity cache if it is enabled.
	 *
	 * @param autocompletes the autocompletes
	 */
	@Override
	public void cacheResult(List<Autocomplete> autocompletes) {
		for (Autocomplete autocomplete : autocompletes) {
			if (EntityCacheUtil.getResult(
						AutocompleteModelImpl.ENTITY_CACHE_ENABLED,
						AutocompleteImpl.class, autocomplete.getPrimaryKey()) == null) {
				cacheResult(autocomplete);
			}
			else {
				autocomplete.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all autocompletes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AutocompleteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AutocompleteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the autocomplete.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Autocomplete autocomplete) {
		EntityCacheUtil.removeResult(AutocompleteModelImpl.ENTITY_CACHE_ENABLED,
			AutocompleteImpl.class, autocomplete.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Autocomplete> autocompletes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Autocomplete autocomplete : autocompletes) {
			EntityCacheUtil.removeResult(AutocompleteModelImpl.ENTITY_CACHE_ENABLED,
				AutocompleteImpl.class, autocomplete.getPrimaryKey());
		}
	}

	/**
	 * Creates a new autocomplete with the primary key. Does not add the autocomplete to the database.
	 *
	 * @param autocompleteId the primary key for the new autocomplete
	 * @return the new autocomplete
	 */
	@Override
	public Autocomplete create(long autocompleteId) {
		Autocomplete autocomplete = new AutocompleteImpl();

		autocomplete.setNew(true);
		autocomplete.setPrimaryKey(autocompleteId);

		return autocomplete;
	}

	/**
	 * Removes the autocomplete with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param autocompleteId the primary key of the autocomplete
	 * @return the autocomplete that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchAutocompleteException if a autocomplete with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Autocomplete remove(long autocompleteId)
		throws NoSuchAutocompleteException, SystemException {
		return remove((Serializable)autocompleteId);
	}

	/**
	 * Removes the autocomplete with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the autocomplete
	 * @return the autocomplete that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchAutocompleteException if a autocomplete with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Autocomplete remove(Serializable primaryKey)
		throws NoSuchAutocompleteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Autocomplete autocomplete = (Autocomplete)session.get(AutocompleteImpl.class,
					primaryKey);

			if (autocomplete == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAutocompleteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(autocomplete);
		}
		catch (NoSuchAutocompleteException nsee) {
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
	protected Autocomplete removeImpl(Autocomplete autocomplete)
		throws SystemException {
		autocomplete = toUnwrappedModel(autocomplete);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(autocomplete)) {
				autocomplete = (Autocomplete)session.get(AutocompleteImpl.class,
						autocomplete.getPrimaryKeyObj());
			}

			if (autocomplete != null) {
				session.delete(autocomplete);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (autocomplete != null) {
			clearCache(autocomplete);
		}

		return autocomplete;
	}

	@Override
	public Autocomplete updateImpl(
		de.uhh.l2g.plugins.model.Autocomplete autocomplete)
		throws SystemException {
		autocomplete = toUnwrappedModel(autocomplete);

		boolean isNew = autocomplete.isNew();

		Session session = null;

		try {
			session = openSession();

			if (autocomplete.isNew()) {
				session.save(autocomplete);

				autocomplete.setNew(false);
			}
			else {
				session.merge(autocomplete);
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

		EntityCacheUtil.putResult(AutocompleteModelImpl.ENTITY_CACHE_ENABLED,
			AutocompleteImpl.class, autocomplete.getPrimaryKey(), autocomplete);

		return autocomplete;
	}

	protected Autocomplete toUnwrappedModel(Autocomplete autocomplete) {
		if (autocomplete instanceof AutocompleteImpl) {
			return autocomplete;
		}

		AutocompleteImpl autocompleteImpl = new AutocompleteImpl();

		autocompleteImpl.setNew(autocomplete.isNew());
		autocompleteImpl.setPrimaryKey(autocomplete.getPrimaryKey());

		autocompleteImpl.setAutocompleteId(autocomplete.getAutocompleteId());
		autocompleteImpl.setSearchWordsJson(autocomplete.getSearchWordsJson());

		return autocompleteImpl;
	}

	/**
	 * Returns the autocomplete with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the autocomplete
	 * @return the autocomplete
	 * @throws de.uhh.l2g.plugins.NoSuchAutocompleteException if a autocomplete with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Autocomplete findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAutocompleteException, SystemException {
		Autocomplete autocomplete = fetchByPrimaryKey(primaryKey);

		if (autocomplete == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAutocompleteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return autocomplete;
	}

	/**
	 * Returns the autocomplete with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchAutocompleteException} if it could not be found.
	 *
	 * @param autocompleteId the primary key of the autocomplete
	 * @return the autocomplete
	 * @throws de.uhh.l2g.plugins.NoSuchAutocompleteException if a autocomplete with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Autocomplete findByPrimaryKey(long autocompleteId)
		throws NoSuchAutocompleteException, SystemException {
		return findByPrimaryKey((Serializable)autocompleteId);
	}

	/**
	 * Returns the autocomplete with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the autocomplete
	 * @return the autocomplete, or <code>null</code> if a autocomplete with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Autocomplete fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Autocomplete autocomplete = (Autocomplete)EntityCacheUtil.getResult(AutocompleteModelImpl.ENTITY_CACHE_ENABLED,
				AutocompleteImpl.class, primaryKey);

		if (autocomplete == _nullAutocomplete) {
			return null;
		}

		if (autocomplete == null) {
			Session session = null;

			try {
				session = openSession();

				autocomplete = (Autocomplete)session.get(AutocompleteImpl.class,
						primaryKey);

				if (autocomplete != null) {
					cacheResult(autocomplete);
				}
				else {
					EntityCacheUtil.putResult(AutocompleteModelImpl.ENTITY_CACHE_ENABLED,
						AutocompleteImpl.class, primaryKey, _nullAutocomplete);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AutocompleteModelImpl.ENTITY_CACHE_ENABLED,
					AutocompleteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return autocomplete;
	}

	/**
	 * Returns the autocomplete with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param autocompleteId the primary key of the autocomplete
	 * @return the autocomplete, or <code>null</code> if a autocomplete with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Autocomplete fetchByPrimaryKey(long autocompleteId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)autocompleteId);
	}

	/**
	 * Returns all the autocompletes.
	 *
	 * @return the autocompletes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Autocomplete> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the autocompletes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.AutocompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of autocompletes
	 * @param end the upper bound of the range of autocompletes (not inclusive)
	 * @return the range of autocompletes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Autocomplete> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the autocompletes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.AutocompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of autocompletes
	 * @param end the upper bound of the range of autocompletes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of autocompletes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Autocomplete> findAll(int start, int end,
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

		List<Autocomplete> list = (List<Autocomplete>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AUTOCOMPLETE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUTOCOMPLETE;

				if (pagination) {
					sql = sql.concat(AutocompleteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Autocomplete>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Autocomplete>(list);
				}
				else {
					list = (List<Autocomplete>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the autocompletes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Autocomplete autocomplete : findAll()) {
			remove(autocomplete);
		}
	}

	/**
	 * Returns the number of autocompletes.
	 *
	 * @return the number of autocompletes
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

				Query q = session.createQuery(_SQL_COUNT_AUTOCOMPLETE);

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
	 * Initializes the autocomplete persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Autocomplete")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Autocomplete>> listenersList = new ArrayList<ModelListener<Autocomplete>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Autocomplete>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AutocompleteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_AUTOCOMPLETE = "SELECT autocomplete FROM Autocomplete autocomplete";
	private static final String _SQL_COUNT_AUTOCOMPLETE = "SELECT COUNT(autocomplete) FROM Autocomplete autocomplete";
	private static final String _ORDER_BY_ENTITY_ALIAS = "autocomplete.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Autocomplete exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AutocompletePersistenceImpl.class);
	private static Autocomplete _nullAutocomplete = new AutocompleteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Autocomplete> toCacheModel() {
				return _nullAutocompleteCacheModel;
			}
		};

	private static CacheModel<Autocomplete> _nullAutocompleteCacheModel = new CacheModel<Autocomplete>() {
			@Override
			public Autocomplete toEntityModel() {
				return _nullAutocomplete;
			}
		};
}