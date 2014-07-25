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

import de.uhh.l2g.plugins.NoSuchLicenseException;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.impl.LicenseImpl;
import de.uhh.l2g.plugins.model.impl.LicenseModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LicensePersistence
 * @see LicenseUtil
 * @generated
 */
public class LicensePersistenceImpl extends BasePersistenceImpl<License>
	implements LicensePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LicenseUtil} to access the license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LicenseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LicensePersistenceImpl() {
		setModelClass(License.class);
	}

	/**
	 * Caches the license in the entity cache if it is enabled.
	 *
	 * @param license the license
	 */
	@Override
	public void cacheResult(License license) {
		EntityCacheUtil.putResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseImpl.class, license.getPrimaryKey(), license);

		license.resetOriginalValues();
	}

	/**
	 * Caches the licenses in the entity cache if it is enabled.
	 *
	 * @param licenses the licenses
	 */
	@Override
	public void cacheResult(List<License> licenses) {
		for (License license : licenses) {
			if (EntityCacheUtil.getResult(
						LicenseModelImpl.ENTITY_CACHE_ENABLED,
						LicenseImpl.class, license.getPrimaryKey()) == null) {
				cacheResult(license);
			}
			else {
				license.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all licenses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LicenseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LicenseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the license.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(License license) {
		EntityCacheUtil.removeResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseImpl.class, license.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<License> licenses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (License license : licenses) {
			EntityCacheUtil.removeResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
				LicenseImpl.class, license.getPrimaryKey());
		}
	}

	/**
	 * Creates a new license with the primary key. Does not add the license to the database.
	 *
	 * @param licenseId the primary key for the new license
	 * @return the new license
	 */
	@Override
	public License create(int licenseId) {
		License license = new LicenseImpl();

		license.setNew(true);
		license.setPrimaryKey(licenseId);

		return license;
	}

	/**
	 * Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLicenseException if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License remove(int licenseId)
		throws NoSuchLicenseException, SystemException {
		return remove((Serializable)licenseId);
	}

	/**
	 * Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the license
	 * @return the license that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchLicenseException if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License remove(Serializable primaryKey)
		throws NoSuchLicenseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			License license = (License)session.get(LicenseImpl.class, primaryKey);

			if (license == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLicenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(license);
		}
		catch (NoSuchLicenseException nsee) {
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
	protected License removeImpl(License license) throws SystemException {
		license = toUnwrappedModel(license);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(license)) {
				license = (License)session.get(LicenseImpl.class,
						license.getPrimaryKeyObj());
			}

			if (license != null) {
				session.delete(license);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (license != null) {
			clearCache(license);
		}

		return license;
	}

	@Override
	public License updateImpl(de.uhh.l2g.plugins.model.License license)
		throws SystemException {
		license = toUnwrappedModel(license);

		boolean isNew = license.isNew();

		Session session = null;

		try {
			session = openSession();

			if (license.isNew()) {
				session.save(license);

				license.setNew(false);
			}
			else {
				session.merge(license);
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

		EntityCacheUtil.putResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseImpl.class, license.getPrimaryKey(), license);

		return license;
	}

	protected License toUnwrappedModel(License license) {
		if (license instanceof LicenseImpl) {
			return license;
		}

		LicenseImpl licenseImpl = new LicenseImpl();

		licenseImpl.setNew(license.isNew());
		licenseImpl.setPrimaryKey(license.getPrimaryKey());

		licenseImpl.setLicenseId(license.getLicenseId());
		licenseImpl.setVideoId(license.getVideoId());
		licenseImpl.setCcby(license.getCcby());
		licenseImpl.setCcbybc(license.getCcbybc());
		licenseImpl.setCcbyncnd(license.getCcbyncnd());
		licenseImpl.setCcbyncsa(license.getCcbyncsa());
		licenseImpl.setCcbysa(license.getCcbysa());
		licenseImpl.setCcbync(license.getCcbync());
		licenseImpl.setL2go(license.getL2go());

		return licenseImpl;
	}

	/**
	 * Returns the license with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the license
	 * @return the license
	 * @throws de.uhh.l2g.plugins.NoSuchLicenseException if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLicenseException, SystemException {
		License license = fetchByPrimaryKey(primaryKey);

		if (license == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLicenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return license;
	}

	/**
	 * Returns the license with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLicenseException} if it could not be found.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license
	 * @throws de.uhh.l2g.plugins.NoSuchLicenseException if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License findByPrimaryKey(int licenseId)
		throws NoSuchLicenseException, SystemException {
		return findByPrimaryKey((Serializable)licenseId);
	}

	/**
	 * Returns the license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the license
	 * @return the license, or <code>null</code> if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		License license = (License)EntityCacheUtil.getResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
				LicenseImpl.class, primaryKey);

		if (license == _nullLicense) {
			return null;
		}

		if (license == null) {
			Session session = null;

			try {
				session = openSession();

				license = (License)session.get(LicenseImpl.class, primaryKey);

				if (license != null) {
					cacheResult(license);
				}
				else {
					EntityCacheUtil.putResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
						LicenseImpl.class, primaryKey, _nullLicense);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LicenseModelImpl.ENTITY_CACHE_ENABLED,
					LicenseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return license;
	}

	/**
	 * Returns the license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license, or <code>null</code> if a license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public License fetchByPrimaryKey(int licenseId) throws SystemException {
		return fetchByPrimaryKey((Serializable)licenseId);
	}

	/**
	 * Returns all the licenses.
	 *
	 * @return the licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<License> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @return the range of licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<License> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<License> findAll(int start, int end,
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

		List<License> list = (List<License>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LICENSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LICENSE;

				if (pagination) {
					sql = sql.concat(LicenseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<License>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<License>(list);
				}
				else {
					list = (List<License>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the licenses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (License license : findAll()) {
			remove(license);
		}
	}

	/**
	 * Returns the number of licenses.
	 *
	 * @return the number of licenses
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

				Query q = session.createQuery(_SQL_COUNT_LICENSE);

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
	 * Initializes the license persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.License")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<License>> listenersList = new ArrayList<ModelListener<License>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<License>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LicenseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LICENSE = "SELECT license FROM License license";
	private static final String _SQL_COUNT_LICENSE = "SELECT COUNT(license) FROM License license";
	private static final String _ORDER_BY_ENTITY_ALIAS = "license.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No License exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LicensePersistenceImpl.class);
	private static License _nullLicense = new LicenseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<License> toCacheModel() {
				return _nullLicenseCacheModel;
			}
		};

	private static CacheModel<License> _nullLicenseCacheModel = new CacheModel<License>() {
			@Override
			public License toEntityModel() {
				return _nullLicense;
			}
		};
}