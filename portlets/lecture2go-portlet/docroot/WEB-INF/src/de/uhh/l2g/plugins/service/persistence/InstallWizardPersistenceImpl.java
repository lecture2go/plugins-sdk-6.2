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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchInstallWizardException;
import de.uhh.l2g.plugins.model.InstallWizard;
import de.uhh.l2g.plugins.model.impl.InstallWizardImpl;
import de.uhh.l2g.plugins.model.impl.InstallWizardModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the install wizard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see InstallWizardPersistence
 * @see InstallWizardUtil
 * @generated
 */
public class InstallWizardPersistenceImpl extends BasePersistenceImpl<InstallWizard>
	implements InstallWizardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InstallWizardUtil} to access the install wizard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InstallWizardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
			InstallWizardModelImpl.FINDER_CACHE_ENABLED,
			InstallWizardImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
			InstallWizardModelImpl.FINDER_CACHE_ENABLED,
			InstallWizardImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
			InstallWizardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPANDCOMPYNY = new FinderPath(InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
			InstallWizardModelImpl.FINDER_CACHE_ENABLED,
			InstallWizardImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBygroupAndCompyny",
			new String[] { Long.class.getName(), Long.class.getName() },
			InstallWizardModelImpl.GROUPID_COLUMN_BITMASK |
			InstallWizardModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDCOMPYNY = new FinderPath(InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
			InstallWizardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygroupAndCompyny",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the install wizard where groupId = &#63; and companyId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchInstallWizardException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching install wizard
	 * @throws de.uhh.l2g.plugins.NoSuchInstallWizardException if a matching install wizard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstallWizard findBygroupAndCompyny(long groupId, long companyId)
		throws NoSuchInstallWizardException, SystemException {
		InstallWizard installWizard = fetchBygroupAndCompyny(groupId, companyId);

		if (installWizard == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchInstallWizardException(msg.toString());
		}

		return installWizard;
	}

	/**
	 * Returns the install wizard where groupId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching install wizard, or <code>null</code> if a matching install wizard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstallWizard fetchBygroupAndCompyny(long groupId, long companyId)
		throws SystemException {
		return fetchBygroupAndCompyny(groupId, companyId, true);
	}

	/**
	 * Returns the install wizard where groupId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching install wizard, or <code>null</code> if a matching install wizard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstallWizard fetchBygroupAndCompyny(long groupId, long companyId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, companyId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPANDCOMPYNY,
					finderArgs, this);
		}

		if (result instanceof InstallWizard) {
			InstallWizard installWizard = (InstallWizard)result;

			if ((groupId != installWizard.getGroupId()) ||
					(companyId != installWizard.getCompanyId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_INSTALLWIZARD_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDCOMPYNY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDCOMPYNY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				List<InstallWizard> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPANDCOMPYNY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"InstallWizardPersistenceImpl.fetchBygroupAndCompyny(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					InstallWizard installWizard = list.get(0);

					result = installWizard;

					cacheResult(installWizard);

					if ((installWizard.getGroupId() != groupId) ||
							(installWizard.getCompanyId() != companyId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPANDCOMPYNY,
							finderArgs, installWizard);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPANDCOMPYNY,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (InstallWizard)result;
		}
	}

	/**
	 * Removes the install wizard where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the install wizard that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstallWizard removeBygroupAndCompyny(long groupId, long companyId)
		throws NoSuchInstallWizardException, SystemException {
		InstallWizard installWizard = findBygroupAndCompyny(groupId, companyId);

		return remove(installWizard);
	}

	/**
	 * Returns the number of install wizards where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching install wizards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBygroupAndCompyny(long groupId, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPANDCOMPYNY;

		Object[] finderArgs = new Object[] { groupId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INSTALLWIZARD_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDCOMPYNY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDCOMPYNY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPANDCOMPYNY_GROUPID_2 = "installWizard.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDCOMPYNY_COMPANYID_2 = "installWizard.companyId = ?";

	public InstallWizardPersistenceImpl() {
		setModelClass(InstallWizard.class);
	}

	/**
	 * Caches the install wizard in the entity cache if it is enabled.
	 *
	 * @param installWizard the install wizard
	 */
	@Override
	public void cacheResult(InstallWizard installWizard) {
		EntityCacheUtil.putResult(InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
			InstallWizardImpl.class, installWizard.getPrimaryKey(),
			installWizard);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPANDCOMPYNY,
			new Object[] {
				installWizard.getGroupId(), installWizard.getCompanyId()
			}, installWizard);

		installWizard.resetOriginalValues();
	}

	/**
	 * Caches the install wizards in the entity cache if it is enabled.
	 *
	 * @param installWizards the install wizards
	 */
	@Override
	public void cacheResult(List<InstallWizard> installWizards) {
		for (InstallWizard installWizard : installWizards) {
			if (EntityCacheUtil.getResult(
						InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
						InstallWizardImpl.class, installWizard.getPrimaryKey()) == null) {
				cacheResult(installWizard);
			}
			else {
				installWizard.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all install wizards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InstallWizardImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InstallWizardImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the install wizard.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InstallWizard installWizard) {
		EntityCacheUtil.removeResult(InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
			InstallWizardImpl.class, installWizard.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(installWizard);
	}

	@Override
	public void clearCache(List<InstallWizard> installWizards) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InstallWizard installWizard : installWizards) {
			EntityCacheUtil.removeResult(InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
				InstallWizardImpl.class, installWizard.getPrimaryKey());

			clearUniqueFindersCache(installWizard);
		}
	}

	protected void cacheUniqueFindersCache(InstallWizard installWizard) {
		if (installWizard.isNew()) {
			Object[] args = new Object[] {
					installWizard.getGroupId(), installWizard.getCompanyId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPANDCOMPYNY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPANDCOMPYNY,
				args, installWizard);
		}
		else {
			InstallWizardModelImpl installWizardModelImpl = (InstallWizardModelImpl)installWizard;

			if ((installWizardModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPANDCOMPYNY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						installWizard.getGroupId(), installWizard.getCompanyId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPANDCOMPYNY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPANDCOMPYNY,
					args, installWizard);
			}
		}
	}

	protected void clearUniqueFindersCache(InstallWizard installWizard) {
		InstallWizardModelImpl installWizardModelImpl = (InstallWizardModelImpl)installWizard;

		Object[] args = new Object[] {
				installWizard.getGroupId(), installWizard.getCompanyId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDCOMPYNY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPANDCOMPYNY, args);

		if ((installWizardModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPANDCOMPYNY.getColumnBitmask()) != 0) {
			args = new Object[] {
					installWizardModelImpl.getOriginalGroupId(),
					installWizardModelImpl.getOriginalCompanyId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDCOMPYNY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPANDCOMPYNY,
				args);
		}
	}

	/**
	 * Creates a new install wizard with the primary key. Does not add the install wizard to the database.
	 *
	 * @param installWizardId the primary key for the new install wizard
	 * @return the new install wizard
	 */
	@Override
	public InstallWizard create(long installWizardId) {
		InstallWizard installWizard = new InstallWizardImpl();

		installWizard.setNew(true);
		installWizard.setPrimaryKey(installWizardId);

		return installWizard;
	}

	/**
	 * Removes the install wizard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param installWizardId the primary key of the install wizard
	 * @return the install wizard that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchInstallWizardException if a install wizard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstallWizard remove(long installWizardId)
		throws NoSuchInstallWizardException, SystemException {
		return remove((Serializable)installWizardId);
	}

	/**
	 * Removes the install wizard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the install wizard
	 * @return the install wizard that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchInstallWizardException if a install wizard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstallWizard remove(Serializable primaryKey)
		throws NoSuchInstallWizardException, SystemException {
		Session session = null;

		try {
			session = openSession();

			InstallWizard installWizard = (InstallWizard)session.get(InstallWizardImpl.class,
					primaryKey);

			if (installWizard == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInstallWizardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(installWizard);
		}
		catch (NoSuchInstallWizardException nsee) {
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
	protected InstallWizard removeImpl(InstallWizard installWizard)
		throws SystemException {
		installWizard = toUnwrappedModel(installWizard);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(installWizard)) {
				installWizard = (InstallWizard)session.get(InstallWizardImpl.class,
						installWizard.getPrimaryKeyObj());
			}

			if (installWizard != null) {
				session.delete(installWizard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (installWizard != null) {
			clearCache(installWizard);
		}

		return installWizard;
	}

	@Override
	public InstallWizard updateImpl(
		de.uhh.l2g.plugins.model.InstallWizard installWizard)
		throws SystemException {
		installWizard = toUnwrappedModel(installWizard);

		boolean isNew = installWizard.isNew();

		Session session = null;

		try {
			session = openSession();

			if (installWizard.isNew()) {
				session.save(installWizard);

				installWizard.setNew(false);
			}
			else {
				session.merge(installWizard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !InstallWizardModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
			InstallWizardImpl.class, installWizard.getPrimaryKey(),
			installWizard);

		clearUniqueFindersCache(installWizard);
		cacheUniqueFindersCache(installWizard);

		return installWizard;
	}

	protected InstallWizard toUnwrappedModel(InstallWizard installWizard) {
		if (installWizard instanceof InstallWizardImpl) {
			return installWizard;
		}

		InstallWizardImpl installWizardImpl = new InstallWizardImpl();

		installWizardImpl.setNew(installWizard.isNew());
		installWizardImpl.setPrimaryKey(installWizard.getPrimaryKey());

		installWizardImpl.setInstallWizardId(installWizard.getInstallWizardId());
		installWizardImpl.setWizartActive(installWizard.getWizartActive());
		installWizardImpl.setGroupId(installWizard.getGroupId());
		installWizardImpl.setCompanyId(installWizard.getCompanyId());

		return installWizardImpl;
	}

	/**
	 * Returns the install wizard with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the install wizard
	 * @return the install wizard
	 * @throws de.uhh.l2g.plugins.NoSuchInstallWizardException if a install wizard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstallWizard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInstallWizardException, SystemException {
		InstallWizard installWizard = fetchByPrimaryKey(primaryKey);

		if (installWizard == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInstallWizardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return installWizard;
	}

	/**
	 * Returns the install wizard with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchInstallWizardException} if it could not be found.
	 *
	 * @param installWizardId the primary key of the install wizard
	 * @return the install wizard
	 * @throws de.uhh.l2g.plugins.NoSuchInstallWizardException if a install wizard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstallWizard findByPrimaryKey(long installWizardId)
		throws NoSuchInstallWizardException, SystemException {
		return findByPrimaryKey((Serializable)installWizardId);
	}

	/**
	 * Returns the install wizard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the install wizard
	 * @return the install wizard, or <code>null</code> if a install wizard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstallWizard fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		InstallWizard installWizard = (InstallWizard)EntityCacheUtil.getResult(InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
				InstallWizardImpl.class, primaryKey);

		if (installWizard == _nullInstallWizard) {
			return null;
		}

		if (installWizard == null) {
			Session session = null;

			try {
				session = openSession();

				installWizard = (InstallWizard)session.get(InstallWizardImpl.class,
						primaryKey);

				if (installWizard != null) {
					cacheResult(installWizard);
				}
				else {
					EntityCacheUtil.putResult(InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
						InstallWizardImpl.class, primaryKey, _nullInstallWizard);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InstallWizardModelImpl.ENTITY_CACHE_ENABLED,
					InstallWizardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return installWizard;
	}

	/**
	 * Returns the install wizard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param installWizardId the primary key of the install wizard
	 * @return the install wizard, or <code>null</code> if a install wizard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstallWizard fetchByPrimaryKey(long installWizardId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)installWizardId);
	}

	/**
	 * Returns all the install wizards.
	 *
	 * @return the install wizards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InstallWizard> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the install wizards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstallWizardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of install wizards
	 * @param end the upper bound of the range of install wizards (not inclusive)
	 * @return the range of install wizards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InstallWizard> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the install wizards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstallWizardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of install wizards
	 * @param end the upper bound of the range of install wizards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of install wizards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InstallWizard> findAll(int start, int end,
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

		List<InstallWizard> list = (List<InstallWizard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INSTALLWIZARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INSTALLWIZARD;

				if (pagination) {
					sql = sql.concat(InstallWizardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<InstallWizard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<InstallWizard>(list);
				}
				else {
					list = (List<InstallWizard>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the install wizards from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (InstallWizard installWizard : findAll()) {
			remove(installWizard);
		}
	}

	/**
	 * Returns the number of install wizards.
	 *
	 * @return the number of install wizards
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

				Query q = session.createQuery(_SQL_COUNT_INSTALLWIZARD);

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
	 * Initializes the install wizard persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.InstallWizard")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<InstallWizard>> listenersList = new ArrayList<ModelListener<InstallWizard>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<InstallWizard>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InstallWizardImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INSTALLWIZARD = "SELECT installWizard FROM InstallWizard installWizard";
	private static final String _SQL_SELECT_INSTALLWIZARD_WHERE = "SELECT installWizard FROM InstallWizard installWizard WHERE ";
	private static final String _SQL_COUNT_INSTALLWIZARD = "SELECT COUNT(installWizard) FROM InstallWizard installWizard";
	private static final String _SQL_COUNT_INSTALLWIZARD_WHERE = "SELECT COUNT(installWizard) FROM InstallWizard installWizard WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "installWizard.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No InstallWizard exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No InstallWizard exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InstallWizardPersistenceImpl.class);
	private static InstallWizard _nullInstallWizard = new InstallWizardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<InstallWizard> toCacheModel() {
				return _nullInstallWizardCacheModel;
			}
		};

	private static CacheModel<InstallWizard> _nullInstallWizardCacheModel = new CacheModel<InstallWizard>() {
			@Override
			public InstallWizard toEntityModel() {
				return _nullInstallWizard;
			}
		};
}