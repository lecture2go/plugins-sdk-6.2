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

import de.uhh.l2g.plugins.NoSuchFacility_HostException;
import de.uhh.l2g.plugins.model.Facility_Host;
import de.uhh.l2g.plugins.model.impl.Facility_HostImpl;
import de.uhh.l2g.plugins.model.impl.Facility_HostModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the facility_ host service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Facility_HostPersistence
 * @see Facility_HostUtil
 * @generated
 */
public class Facility_HostPersistenceImpl extends BasePersistenceImpl<Facility_Host>
	implements Facility_HostPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Facility_HostUtil} to access the facility_ host persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Facility_HostImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
			Facility_HostModelImpl.FINDER_CACHE_ENABLED,
			Facility_HostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
			Facility_HostModelImpl.FINDER_CACHE_ENABLED,
			Facility_HostImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
			Facility_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_FACILITYID = new FinderPath(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
			Facility_HostModelImpl.FINDER_CACHE_ENABLED,
			Facility_HostImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByfacilityId", new String[] { Long.class.getName() },
			Facility_HostModelImpl.FACILITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FACILITYID = new FinderPath(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
			Facility_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfacilityId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the facility_ host where facilityId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchFacility_HostException} if it could not be found.
	 *
	 * @param facilityId the facility ID
	 * @return the matching facility_ host
	 * @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a matching facility_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host findByfacilityId(long facilityId)
		throws NoSuchFacility_HostException, SystemException {
		Facility_Host facility_Host = fetchByfacilityId(facilityId);

		if (facility_Host == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("facilityId=");
			msg.append(facilityId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFacility_HostException(msg.toString());
		}

		return facility_Host;
	}

	/**
	 * Returns the facility_ host where facilityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param facilityId the facility ID
	 * @return the matching facility_ host, or <code>null</code> if a matching facility_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host fetchByfacilityId(long facilityId)
		throws SystemException {
		return fetchByfacilityId(facilityId, true);
	}

	/**
	 * Returns the facility_ host where facilityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param facilityId the facility ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching facility_ host, or <code>null</code> if a matching facility_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host fetchByfacilityId(long facilityId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { facilityId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FACILITYID,
					finderArgs, this);
		}

		if (result instanceof Facility_Host) {
			Facility_Host facility_Host = (Facility_Host)result;

			if ((facilityId != facility_Host.getFacilityId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FACILITY_HOST_WHERE);

			query.append(_FINDER_COLUMN_FACILITYID_FACILITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facilityId);

				List<Facility_Host> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"Facility_HostPersistenceImpl.fetchByfacilityId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Facility_Host facility_Host = list.get(0);

					result = facility_Host;

					cacheResult(facility_Host);

					if ((facility_Host.getFacilityId() != facilityId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITYID,
							finderArgs, facility_Host);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FACILITYID,
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
			return (Facility_Host)result;
		}
	}

	/**
	 * Removes the facility_ host where facilityId = &#63; from the database.
	 *
	 * @param facilityId the facility ID
	 * @return the facility_ host that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host removeByfacilityId(long facilityId)
		throws NoSuchFacility_HostException, SystemException {
		Facility_Host facility_Host = findByfacilityId(facilityId);

		return remove(facility_Host);
	}

	/**
	 * Returns the number of facility_ hosts where facilityId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @return the number of matching facility_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfacilityId(long facilityId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FACILITYID;

		Object[] finderArgs = new Object[] { facilityId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACILITY_HOST_WHERE);

			query.append(_FINDER_COLUMN_FACILITYID_FACILITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facilityId);

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

	private static final String _FINDER_COLUMN_FACILITYID_FACILITYID_2 = "facility_Host.facilityId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_HOSTID = new FinderPath(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
			Facility_HostModelImpl.FINDER_CACHE_ENABLED,
			Facility_HostImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByhostId",
			new String[] { Long.class.getName() },
			Facility_HostModelImpl.HOSTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HOSTID = new FinderPath(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
			Facility_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByhostId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the facility_ host where hostId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchFacility_HostException} if it could not be found.
	 *
	 * @param hostId the host ID
	 * @return the matching facility_ host
	 * @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a matching facility_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host findByhostId(long hostId)
		throws NoSuchFacility_HostException, SystemException {
		Facility_Host facility_Host = fetchByhostId(hostId);

		if (facility_Host == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hostId=");
			msg.append(hostId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFacility_HostException(msg.toString());
		}

		return facility_Host;
	}

	/**
	 * Returns the facility_ host where hostId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param hostId the host ID
	 * @return the matching facility_ host, or <code>null</code> if a matching facility_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host fetchByhostId(long hostId) throws SystemException {
		return fetchByhostId(hostId, true);
	}

	/**
	 * Returns the facility_ host where hostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param hostId the host ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching facility_ host, or <code>null</code> if a matching facility_ host could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host fetchByhostId(long hostId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { hostId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_HOSTID,
					finderArgs, this);
		}

		if (result instanceof Facility_Host) {
			Facility_Host facility_Host = (Facility_Host)result;

			if ((hostId != facility_Host.getHostId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FACILITY_HOST_WHERE);

			query.append(_FINDER_COLUMN_HOSTID_HOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hostId);

				List<Facility_Host> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HOSTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"Facility_HostPersistenceImpl.fetchByhostId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Facility_Host facility_Host = list.get(0);

					result = facility_Host;

					cacheResult(facility_Host);

					if ((facility_Host.getHostId() != hostId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HOSTID,
							finderArgs, facility_Host);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HOSTID,
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
			return (Facility_Host)result;
		}
	}

	/**
	 * Removes the facility_ host where hostId = &#63; from the database.
	 *
	 * @param hostId the host ID
	 * @return the facility_ host that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host removeByhostId(long hostId)
		throws NoSuchFacility_HostException, SystemException {
		Facility_Host facility_Host = findByhostId(hostId);

		return remove(facility_Host);
	}

	/**
	 * Returns the number of facility_ hosts where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the number of matching facility_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByhostId(long hostId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HOSTID;

		Object[] finderArgs = new Object[] { hostId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACILITY_HOST_WHERE);

			query.append(_FINDER_COLUMN_HOSTID_HOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hostId);

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

	private static final String _FINDER_COLUMN_HOSTID_HOSTID_2 = "facility_Host.hostId = ?";

	public Facility_HostPersistenceImpl() {
		setModelClass(Facility_Host.class);
	}

	/**
	 * Caches the facility_ host in the entity cache if it is enabled.
	 *
	 * @param facility_Host the facility_ host
	 */
	@Override
	public void cacheResult(Facility_Host facility_Host) {
		EntityCacheUtil.putResult(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
			Facility_HostImpl.class, facility_Host.getPrimaryKey(),
			facility_Host);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITYID,
			new Object[] { facility_Host.getFacilityId() }, facility_Host);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HOSTID,
			new Object[] { facility_Host.getHostId() }, facility_Host);

		facility_Host.resetOriginalValues();
	}

	/**
	 * Caches the facility_ hosts in the entity cache if it is enabled.
	 *
	 * @param facility_Hosts the facility_ hosts
	 */
	@Override
	public void cacheResult(List<Facility_Host> facility_Hosts) {
		for (Facility_Host facility_Host : facility_Hosts) {
			if (EntityCacheUtil.getResult(
						Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
						Facility_HostImpl.class, facility_Host.getPrimaryKey()) == null) {
				cacheResult(facility_Host);
			}
			else {
				facility_Host.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all facility_ hosts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Facility_HostImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Facility_HostImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the facility_ host.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Facility_Host facility_Host) {
		EntityCacheUtil.removeResult(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
			Facility_HostImpl.class, facility_Host.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(facility_Host);
	}

	@Override
	public void clearCache(List<Facility_Host> facility_Hosts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Facility_Host facility_Host : facility_Hosts) {
			EntityCacheUtil.removeResult(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
				Facility_HostImpl.class, facility_Host.getPrimaryKey());

			clearUniqueFindersCache(facility_Host);
		}
	}

	protected void cacheUniqueFindersCache(Facility_Host facility_Host) {
		if (facility_Host.isNew()) {
			Object[] args = new Object[] { facility_Host.getFacilityId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FACILITYID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITYID, args,
				facility_Host);

			args = new Object[] { facility_Host.getHostId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HOSTID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HOSTID, args,
				facility_Host);
		}
		else {
			Facility_HostModelImpl facility_HostModelImpl = (Facility_HostModelImpl)facility_Host;

			if ((facility_HostModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FACILITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { facility_Host.getFacilityId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FACILITYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITYID,
					args, facility_Host);
			}

			if ((facility_HostModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_HOSTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { facility_Host.getHostId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HOSTID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HOSTID, args,
					facility_Host);
			}
		}
	}

	protected void clearUniqueFindersCache(Facility_Host facility_Host) {
		Facility_HostModelImpl facility_HostModelImpl = (Facility_HostModelImpl)facility_Host;

		Object[] args = new Object[] { facility_Host.getFacilityId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITYID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FACILITYID, args);

		if ((facility_HostModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FACILITYID.getColumnBitmask()) != 0) {
			args = new Object[] { facility_HostModelImpl.getOriginalFacilityId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITYID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FACILITYID, args);
		}

		args = new Object[] { facility_Host.getHostId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOSTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HOSTID, args);

		if ((facility_HostModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_HOSTID.getColumnBitmask()) != 0) {
			args = new Object[] { facility_HostModelImpl.getOriginalHostId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOSTID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HOSTID, args);
		}
	}

	/**
	 * Creates a new facility_ host with the primary key. Does not add the facility_ host to the database.
	 *
	 * @param fasilityHostId the primary key for the new facility_ host
	 * @return the new facility_ host
	 */
	@Override
	public Facility_Host create(long fasilityHostId) {
		Facility_Host facility_Host = new Facility_HostImpl();

		facility_Host.setNew(true);
		facility_Host.setPrimaryKey(fasilityHostId);

		return facility_Host;
	}

	/**
	 * Removes the facility_ host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fasilityHostId the primary key of the facility_ host
	 * @return the facility_ host that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a facility_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host remove(long fasilityHostId)
		throws NoSuchFacility_HostException, SystemException {
		return remove((Serializable)fasilityHostId);
	}

	/**
	 * Removes the facility_ host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the facility_ host
	 * @return the facility_ host that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a facility_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host remove(Serializable primaryKey)
		throws NoSuchFacility_HostException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Facility_Host facility_Host = (Facility_Host)session.get(Facility_HostImpl.class,
					primaryKey);

			if (facility_Host == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacility_HostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(facility_Host);
		}
		catch (NoSuchFacility_HostException nsee) {
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
	protected Facility_Host removeImpl(Facility_Host facility_Host)
		throws SystemException {
		facility_Host = toUnwrappedModel(facility_Host);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(facility_Host)) {
				facility_Host = (Facility_Host)session.get(Facility_HostImpl.class,
						facility_Host.getPrimaryKeyObj());
			}

			if (facility_Host != null) {
				session.delete(facility_Host);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (facility_Host != null) {
			clearCache(facility_Host);
		}

		return facility_Host;
	}

	@Override
	public Facility_Host updateImpl(
		de.uhh.l2g.plugins.model.Facility_Host facility_Host)
		throws SystemException {
		facility_Host = toUnwrappedModel(facility_Host);

		boolean isNew = facility_Host.isNew();

		Session session = null;

		try {
			session = openSession();

			if (facility_Host.isNew()) {
				session.save(facility_Host);

				facility_Host.setNew(false);
			}
			else {
				session.merge(facility_Host);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Facility_HostModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
			Facility_HostImpl.class, facility_Host.getPrimaryKey(),
			facility_Host);

		clearUniqueFindersCache(facility_Host);
		cacheUniqueFindersCache(facility_Host);

		return facility_Host;
	}

	protected Facility_Host toUnwrappedModel(Facility_Host facility_Host) {
		if (facility_Host instanceof Facility_HostImpl) {
			return facility_Host;
		}

		Facility_HostImpl facility_HostImpl = new Facility_HostImpl();

		facility_HostImpl.setNew(facility_Host.isNew());
		facility_HostImpl.setPrimaryKey(facility_Host.getPrimaryKey());

		facility_HostImpl.setFasilityHostId(facility_Host.getFasilityHostId());
		facility_HostImpl.setFacilityId(facility_Host.getFacilityId());
		facility_HostImpl.setHostId(facility_Host.getHostId());

		return facility_HostImpl;
	}

	/**
	 * Returns the facility_ host with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the facility_ host
	 * @return the facility_ host
	 * @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a facility_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacility_HostException, SystemException {
		Facility_Host facility_Host = fetchByPrimaryKey(primaryKey);

		if (facility_Host == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacility_HostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return facility_Host;
	}

	/**
	 * Returns the facility_ host with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchFacility_HostException} if it could not be found.
	 *
	 * @param fasilityHostId the primary key of the facility_ host
	 * @return the facility_ host
	 * @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a facility_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host findByPrimaryKey(long fasilityHostId)
		throws NoSuchFacility_HostException, SystemException {
		return findByPrimaryKey((Serializable)fasilityHostId);
	}

	/**
	 * Returns the facility_ host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the facility_ host
	 * @return the facility_ host, or <code>null</code> if a facility_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Facility_Host facility_Host = (Facility_Host)EntityCacheUtil.getResult(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
				Facility_HostImpl.class, primaryKey);

		if (facility_Host == _nullFacility_Host) {
			return null;
		}

		if (facility_Host == null) {
			Session session = null;

			try {
				session = openSession();

				facility_Host = (Facility_Host)session.get(Facility_HostImpl.class,
						primaryKey);

				if (facility_Host != null) {
					cacheResult(facility_Host);
				}
				else {
					EntityCacheUtil.putResult(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
						Facility_HostImpl.class, primaryKey, _nullFacility_Host);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Facility_HostModelImpl.ENTITY_CACHE_ENABLED,
					Facility_HostImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return facility_Host;
	}

	/**
	 * Returns the facility_ host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fasilityHostId the primary key of the facility_ host
	 * @return the facility_ host, or <code>null</code> if a facility_ host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Facility_Host fetchByPrimaryKey(long fasilityHostId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)fasilityHostId);
	}

	/**
	 * Returns all the facility_ hosts.
	 *
	 * @return the facility_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility_Host> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the facility_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Facility_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of facility_ hosts
	 * @param end the upper bound of the range of facility_ hosts (not inclusive)
	 * @return the range of facility_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility_Host> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the facility_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Facility_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of facility_ hosts
	 * @param end the upper bound of the range of facility_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of facility_ hosts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Facility_Host> findAll(int start, int end,
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

		List<Facility_Host> list = (List<Facility_Host>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACILITY_HOST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACILITY_HOST;

				if (pagination) {
					sql = sql.concat(Facility_HostModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Facility_Host>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Facility_Host>(list);
				}
				else {
					list = (List<Facility_Host>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the facility_ hosts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Facility_Host facility_Host : findAll()) {
			remove(facility_Host);
		}
	}

	/**
	 * Returns the number of facility_ hosts.
	 *
	 * @return the number of facility_ hosts
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

				Query q = session.createQuery(_SQL_COUNT_FACILITY_HOST);

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
	 * Initializes the facility_ host persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Facility_Host")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Facility_Host>> listenersList = new ArrayList<ModelListener<Facility_Host>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Facility_Host>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Facility_HostImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACILITY_HOST = "SELECT facility_Host FROM Facility_Host facility_Host";
	private static final String _SQL_SELECT_FACILITY_HOST_WHERE = "SELECT facility_Host FROM Facility_Host facility_Host WHERE ";
	private static final String _SQL_COUNT_FACILITY_HOST = "SELECT COUNT(facility_Host) FROM Facility_Host facility_Host";
	private static final String _SQL_COUNT_FACILITY_HOST_WHERE = "SELECT COUNT(facility_Host) FROM Facility_Host facility_Host WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "facility_Host.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Facility_Host exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Facility_Host exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Facility_HostPersistenceImpl.class);
	private static Facility_Host _nullFacility_Host = new Facility_HostImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Facility_Host> toCacheModel() {
				return _nullFacility_HostCacheModel;
			}
		};

	private static CacheModel<Facility_Host> _nullFacility_HostCacheModel = new CacheModel<Facility_Host>() {
			@Override
			public Facility_Host toEntityModel() {
				return _nullFacility_Host;
			}
		};
}