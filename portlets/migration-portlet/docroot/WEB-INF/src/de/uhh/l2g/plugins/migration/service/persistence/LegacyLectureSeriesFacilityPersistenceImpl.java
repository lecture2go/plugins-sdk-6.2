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

package de.uhh.l2g.plugins.migration.service.persistence;

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

import de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException;
import de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility;
import de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesFacilityImpl;
import de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesFacilityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legacy lecture series facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyLectureSeriesFacilityPersistence
 * @see LegacyLectureSeriesFacilityUtil
 * @generated
 */
public class LegacyLectureSeriesFacilityPersistenceImpl
	extends BasePersistenceImpl<LegacyLectureSeriesFacility>
	implements LegacyLectureSeriesFacilityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacyLectureSeriesFacilityUtil} to access the legacy lecture series facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacyLectureSeriesFacilityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesFacilityModelImpl.FINDER_CACHE_ENABLED,
			LegacyLectureSeriesFacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesFacilityModelImpl.FINDER_CACHE_ENABLED,
			LegacyLectureSeriesFacilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesFacilityModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_FACILITYIDLECTURESERIESID =
		new FinderPath(LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesFacilityModelImpl.FINDER_CACHE_ENABLED,
			LegacyLectureSeriesFacilityImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFacilityIdlectureseriesId",
			new String[] { Long.class.getName(), Long.class.getName() },
			LegacyLectureSeriesFacilityModelImpl.FACILITYID_COLUMN_BITMASK |
			LegacyLectureSeriesFacilityModelImpl.LECTURESERIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FACILITYIDLECTURESERIESID =
		new FinderPath(LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesFacilityModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFacilityIdlectureseriesId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the legacy lecture series facility where facilityId = &#63; and lectureseriesId = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException} if it could not be found.
	 *
	 * @param facilityId the facility ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching legacy lecture series facility
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException if a matching legacy lecture series facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeriesFacility findByFacilityIdlectureseriesId(
		long facilityId, long lectureseriesId)
		throws NoSuchLegacyLectureSeriesFacilityException, SystemException {
		LegacyLectureSeriesFacility legacyLectureSeriesFacility = fetchByFacilityIdlectureseriesId(facilityId,
				lectureseriesId);

		if (legacyLectureSeriesFacility == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("facilityId=");
			msg.append(facilityId);

			msg.append(", lectureseriesId=");
			msg.append(lectureseriesId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLegacyLectureSeriesFacilityException(msg.toString());
		}

		return legacyLectureSeriesFacility;
	}

	/**
	 * Returns the legacy lecture series facility where facilityId = &#63; and lectureseriesId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param facilityId the facility ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching legacy lecture series facility, or <code>null</code> if a matching legacy lecture series facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeriesFacility fetchByFacilityIdlectureseriesId(
		long facilityId, long lectureseriesId) throws SystemException {
		return fetchByFacilityIdlectureseriesId(facilityId, lectureseriesId,
			true);
	}

	/**
	 * Returns the legacy lecture series facility where facilityId = &#63; and lectureseriesId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param facilityId the facility ID
	 * @param lectureseriesId the lectureseries ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching legacy lecture series facility, or <code>null</code> if a matching legacy lecture series facility could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeriesFacility fetchByFacilityIdlectureseriesId(
		long facilityId, long lectureseriesId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { facilityId, lectureseriesId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FACILITYIDLECTURESERIESID,
					finderArgs, this);
		}

		if (result instanceof LegacyLectureSeriesFacility) {
			LegacyLectureSeriesFacility legacyLectureSeriesFacility = (LegacyLectureSeriesFacility)result;

			if ((facilityId != legacyLectureSeriesFacility.getFacilityId()) ||
					(lectureseriesId != legacyLectureSeriesFacility.getLectureseriesId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGACYLECTURESERIESFACILITY_WHERE);

			query.append(_FINDER_COLUMN_FACILITYIDLECTURESERIESID_FACILITYID_2);

			query.append(_FINDER_COLUMN_FACILITYIDLECTURESERIESID_LECTURESERIESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facilityId);

				qPos.add(lectureseriesId);

				List<LegacyLectureSeriesFacility> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITYIDLECTURESERIESID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LegacyLectureSeriesFacilityPersistenceImpl.fetchByFacilityIdlectureseriesId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LegacyLectureSeriesFacility legacyLectureSeriesFacility = list.get(0);

					result = legacyLectureSeriesFacility;

					cacheResult(legacyLectureSeriesFacility);

					if ((legacyLectureSeriesFacility.getFacilityId() != facilityId) ||
							(legacyLectureSeriesFacility.getLectureseriesId() != lectureseriesId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITYIDLECTURESERIESID,
							finderArgs, legacyLectureSeriesFacility);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FACILITYIDLECTURESERIESID,
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
			return (LegacyLectureSeriesFacility)result;
		}
	}

	/**
	 * Removes the legacy lecture series facility where facilityId = &#63; and lectureseriesId = &#63; from the database.
	 *
	 * @param facilityId the facility ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the legacy lecture series facility that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeriesFacility removeByFacilityIdlectureseriesId(
		long facilityId, long lectureseriesId)
		throws NoSuchLegacyLectureSeriesFacilityException, SystemException {
		LegacyLectureSeriesFacility legacyLectureSeriesFacility = findByFacilityIdlectureseriesId(facilityId,
				lectureseriesId);

		return remove(legacyLectureSeriesFacility);
	}

	/**
	 * Returns the number of legacy lecture series facilities where facilityId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param facilityId the facility ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching legacy lecture series facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFacilityIdlectureseriesId(long facilityId,
		long lectureseriesId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FACILITYIDLECTURESERIESID;

		Object[] finderArgs = new Object[] { facilityId, lectureseriesId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGACYLECTURESERIESFACILITY_WHERE);

			query.append(_FINDER_COLUMN_FACILITYIDLECTURESERIESID_FACILITYID_2);

			query.append(_FINDER_COLUMN_FACILITYIDLECTURESERIESID_LECTURESERIESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facilityId);

				qPos.add(lectureseriesId);

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

	private static final String _FINDER_COLUMN_FACILITYIDLECTURESERIESID_FACILITYID_2 =
		"legacyLectureSeriesFacility.facilityId = ? AND ";
	private static final String _FINDER_COLUMN_FACILITYIDLECTURESERIESID_LECTURESERIESID_2 =
		"legacyLectureSeriesFacility.lectureseriesId = ?";

	public LegacyLectureSeriesFacilityPersistenceImpl() {
		setModelClass(LegacyLectureSeriesFacility.class);
	}

	/**
	 * Caches the legacy lecture series facility in the entity cache if it is enabled.
	 *
	 * @param legacyLectureSeriesFacility the legacy lecture series facility
	 */
	@Override
	public void cacheResult(
		LegacyLectureSeriesFacility legacyLectureSeriesFacility) {
		EntityCacheUtil.putResult(LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesFacilityImpl.class,
			legacyLectureSeriesFacility.getPrimaryKey(),
			legacyLectureSeriesFacility);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITYIDLECTURESERIESID,
			new Object[] {
				legacyLectureSeriesFacility.getFacilityId(),
				legacyLectureSeriesFacility.getLectureseriesId()
			}, legacyLectureSeriesFacility);

		legacyLectureSeriesFacility.resetOriginalValues();
	}

	/**
	 * Caches the legacy lecture series facilities in the entity cache if it is enabled.
	 *
	 * @param legacyLectureSeriesFacilities the legacy lecture series facilities
	 */
	@Override
	public void cacheResult(
		List<LegacyLectureSeriesFacility> legacyLectureSeriesFacilities) {
		for (LegacyLectureSeriesFacility legacyLectureSeriesFacility : legacyLectureSeriesFacilities) {
			if (EntityCacheUtil.getResult(
						LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
						LegacyLectureSeriesFacilityImpl.class,
						legacyLectureSeriesFacility.getPrimaryKey()) == null) {
				cacheResult(legacyLectureSeriesFacility);
			}
			else {
				legacyLectureSeriesFacility.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacy lecture series facilities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacyLectureSeriesFacilityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacyLectureSeriesFacilityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacy lecture series facility.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		LegacyLectureSeriesFacility legacyLectureSeriesFacility) {
		EntityCacheUtil.removeResult(LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesFacilityImpl.class,
			legacyLectureSeriesFacility.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(legacyLectureSeriesFacility);
	}

	@Override
	public void clearCache(
		List<LegacyLectureSeriesFacility> legacyLectureSeriesFacilities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegacyLectureSeriesFacility legacyLectureSeriesFacility : legacyLectureSeriesFacilities) {
			EntityCacheUtil.removeResult(LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
				LegacyLectureSeriesFacilityImpl.class,
				legacyLectureSeriesFacility.getPrimaryKey());

			clearUniqueFindersCache(legacyLectureSeriesFacility);
		}
	}

	protected void cacheUniqueFindersCache(
		LegacyLectureSeriesFacility legacyLectureSeriesFacility) {
		if (legacyLectureSeriesFacility.isNew()) {
			Object[] args = new Object[] {
					legacyLectureSeriesFacility.getFacilityId(),
					legacyLectureSeriesFacility.getLectureseriesId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FACILITYIDLECTURESERIESID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITYIDLECTURESERIESID,
				args, legacyLectureSeriesFacility);
		}
		else {
			LegacyLectureSeriesFacilityModelImpl legacyLectureSeriesFacilityModelImpl =
				(LegacyLectureSeriesFacilityModelImpl)legacyLectureSeriesFacility;

			if ((legacyLectureSeriesFacilityModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FACILITYIDLECTURESERIESID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						legacyLectureSeriesFacility.getFacilityId(),
						legacyLectureSeriesFacility.getLectureseriesId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FACILITYIDLECTURESERIESID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FACILITYIDLECTURESERIESID,
					args, legacyLectureSeriesFacility);
			}
		}
	}

	protected void clearUniqueFindersCache(
		LegacyLectureSeriesFacility legacyLectureSeriesFacility) {
		LegacyLectureSeriesFacilityModelImpl legacyLectureSeriesFacilityModelImpl =
			(LegacyLectureSeriesFacilityModelImpl)legacyLectureSeriesFacility;

		Object[] args = new Object[] {
				legacyLectureSeriesFacility.getFacilityId(),
				legacyLectureSeriesFacility.getLectureseriesId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITYIDLECTURESERIESID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FACILITYIDLECTURESERIESID,
			args);

		if ((legacyLectureSeriesFacilityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FACILITYIDLECTURESERIESID.getColumnBitmask()) != 0) {
			args = new Object[] {
					legacyLectureSeriesFacilityModelImpl.getOriginalFacilityId(),
					legacyLectureSeriesFacilityModelImpl.getOriginalLectureseriesId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACILITYIDLECTURESERIESID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FACILITYIDLECTURESERIESID,
				args);
		}
	}

	/**
	 * Creates a new legacy lecture series facility with the primary key. Does not add the legacy lecture series facility to the database.
	 *
	 * @param lectureseriesFacilityId the primary key for the new legacy lecture series facility
	 * @return the new legacy lecture series facility
	 */
	@Override
	public LegacyLectureSeriesFacility create(long lectureseriesFacilityId) {
		LegacyLectureSeriesFacility legacyLectureSeriesFacility = new LegacyLectureSeriesFacilityImpl();

		legacyLectureSeriesFacility.setNew(true);
		legacyLectureSeriesFacility.setPrimaryKey(lectureseriesFacilityId);

		return legacyLectureSeriesFacility;
	}

	/**
	 * Removes the legacy lecture series facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesFacilityId the primary key of the legacy lecture series facility
	 * @return the legacy lecture series facility that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException if a legacy lecture series facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeriesFacility remove(long lectureseriesFacilityId)
		throws NoSuchLegacyLectureSeriesFacilityException, SystemException {
		return remove((Serializable)lectureseriesFacilityId);
	}

	/**
	 * Removes the legacy lecture series facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacy lecture series facility
	 * @return the legacy lecture series facility that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException if a legacy lecture series facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeriesFacility remove(Serializable primaryKey)
		throws NoSuchLegacyLectureSeriesFacilityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LegacyLectureSeriesFacility legacyLectureSeriesFacility = (LegacyLectureSeriesFacility)session.get(LegacyLectureSeriesFacilityImpl.class,
					primaryKey);

			if (legacyLectureSeriesFacility == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacyLectureSeriesFacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacyLectureSeriesFacility);
		}
		catch (NoSuchLegacyLectureSeriesFacilityException nsee) {
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
	protected LegacyLectureSeriesFacility removeImpl(
		LegacyLectureSeriesFacility legacyLectureSeriesFacility)
		throws SystemException {
		legacyLectureSeriesFacility = toUnwrappedModel(legacyLectureSeriesFacility);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacyLectureSeriesFacility)) {
				legacyLectureSeriesFacility = (LegacyLectureSeriesFacility)session.get(LegacyLectureSeriesFacilityImpl.class,
						legacyLectureSeriesFacility.getPrimaryKeyObj());
			}

			if (legacyLectureSeriesFacility != null) {
				session.delete(legacyLectureSeriesFacility);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacyLectureSeriesFacility != null) {
			clearCache(legacyLectureSeriesFacility);
		}

		return legacyLectureSeriesFacility;
	}

	@Override
	public LegacyLectureSeriesFacility updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility legacyLectureSeriesFacility)
		throws SystemException {
		legacyLectureSeriesFacility = toUnwrappedModel(legacyLectureSeriesFacility);

		boolean isNew = legacyLectureSeriesFacility.isNew();

		Session session = null;

		try {
			session = openSession();

			if (legacyLectureSeriesFacility.isNew()) {
				session.save(legacyLectureSeriesFacility);

				legacyLectureSeriesFacility.setNew(false);
			}
			else {
				session.merge(legacyLectureSeriesFacility);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!LegacyLectureSeriesFacilityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
			LegacyLectureSeriesFacilityImpl.class,
			legacyLectureSeriesFacility.getPrimaryKey(),
			legacyLectureSeriesFacility);

		clearUniqueFindersCache(legacyLectureSeriesFacility);
		cacheUniqueFindersCache(legacyLectureSeriesFacility);

		return legacyLectureSeriesFacility;
	}

	protected LegacyLectureSeriesFacility toUnwrappedModel(
		LegacyLectureSeriesFacility legacyLectureSeriesFacility) {
		if (legacyLectureSeriesFacility instanceof LegacyLectureSeriesFacilityImpl) {
			return legacyLectureSeriesFacility;
		}

		LegacyLectureSeriesFacilityImpl legacyLectureSeriesFacilityImpl = new LegacyLectureSeriesFacilityImpl();

		legacyLectureSeriesFacilityImpl.setNew(legacyLectureSeriesFacility.isNew());
		legacyLectureSeriesFacilityImpl.setPrimaryKey(legacyLectureSeriesFacility.getPrimaryKey());

		legacyLectureSeriesFacilityImpl.setLectureseriesFacilityId(legacyLectureSeriesFacility.getLectureseriesFacilityId());
		legacyLectureSeriesFacilityImpl.setFacilityId(legacyLectureSeriesFacility.getFacilityId());
		legacyLectureSeriesFacilityImpl.setLectureseriesId(legacyLectureSeriesFacility.getLectureseriesId());
		legacyLectureSeriesFacilityImpl.setIsLinkFrom(legacyLectureSeriesFacility.getIsLinkFrom());

		return legacyLectureSeriesFacilityImpl;
	}

	/**
	 * Returns the legacy lecture series facility with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy lecture series facility
	 * @return the legacy lecture series facility
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException if a legacy lecture series facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeriesFacility findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacyLectureSeriesFacilityException, SystemException {
		LegacyLectureSeriesFacility legacyLectureSeriesFacility = fetchByPrimaryKey(primaryKey);

		if (legacyLectureSeriesFacility == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacyLectureSeriesFacilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacyLectureSeriesFacility;
	}

	/**
	 * Returns the legacy lecture series facility with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException} if it could not be found.
	 *
	 * @param lectureseriesFacilityId the primary key of the legacy lecture series facility
	 * @return the legacy lecture series facility
	 * @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException if a legacy lecture series facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeriesFacility findByPrimaryKey(
		long lectureseriesFacilityId)
		throws NoSuchLegacyLectureSeriesFacilityException, SystemException {
		return findByPrimaryKey((Serializable)lectureseriesFacilityId);
	}

	/**
	 * Returns the legacy lecture series facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacy lecture series facility
	 * @return the legacy lecture series facility, or <code>null</code> if a legacy lecture series facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeriesFacility fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		LegacyLectureSeriesFacility legacyLectureSeriesFacility = (LegacyLectureSeriesFacility)EntityCacheUtil.getResult(LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
				LegacyLectureSeriesFacilityImpl.class, primaryKey);

		if (legacyLectureSeriesFacility == _nullLegacyLectureSeriesFacility) {
			return null;
		}

		if (legacyLectureSeriesFacility == null) {
			Session session = null;

			try {
				session = openSession();

				legacyLectureSeriesFacility = (LegacyLectureSeriesFacility)session.get(LegacyLectureSeriesFacilityImpl.class,
						primaryKey);

				if (legacyLectureSeriesFacility != null) {
					cacheResult(legacyLectureSeriesFacility);
				}
				else {
					EntityCacheUtil.putResult(LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
						LegacyLectureSeriesFacilityImpl.class, primaryKey,
						_nullLegacyLectureSeriesFacility);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacyLectureSeriesFacilityModelImpl.ENTITY_CACHE_ENABLED,
					LegacyLectureSeriesFacilityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacyLectureSeriesFacility;
	}

	/**
	 * Returns the legacy lecture series facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesFacilityId the primary key of the legacy lecture series facility
	 * @return the legacy lecture series facility, or <code>null</code> if a legacy lecture series facility with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyLectureSeriesFacility fetchByPrimaryKey(
		long lectureseriesFacilityId) throws SystemException {
		return fetchByPrimaryKey((Serializable)lectureseriesFacilityId);
	}

	/**
	 * Returns all the legacy lecture series facilities.
	 *
	 * @return the legacy lecture series facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyLectureSeriesFacility> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legacy lecture series facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy lecture series facilities
	 * @param end the upper bound of the range of legacy lecture series facilities (not inclusive)
	 * @return the range of legacy lecture series facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyLectureSeriesFacility> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legacy lecture series facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy lecture series facilities
	 * @param end the upper bound of the range of legacy lecture series facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legacy lecture series facilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyLectureSeriesFacility> findAll(int start, int end,
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

		List<LegacyLectureSeriesFacility> list = (List<LegacyLectureSeriesFacility>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYLECTURESERIESFACILITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYLECTURESERIESFACILITY;

				if (pagination) {
					sql = sql.concat(LegacyLectureSeriesFacilityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LegacyLectureSeriesFacility>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LegacyLectureSeriesFacility>(list);
				}
				else {
					list = (List<LegacyLectureSeriesFacility>)QueryUtil.list(q,
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
	 * Removes all the legacy lecture series facilities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LegacyLectureSeriesFacility legacyLectureSeriesFacility : findAll()) {
			remove(legacyLectureSeriesFacility);
		}
	}

	/**
	 * Returns the number of legacy lecture series facilities.
	 *
	 * @return the number of legacy lecture series facilities
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYLECTURESERIESFACILITY);

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
	 * Initializes the legacy lecture series facility persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LegacyLectureSeriesFacility>> listenersList = new ArrayList<ModelListener<LegacyLectureSeriesFacility>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LegacyLectureSeriesFacility>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacyLectureSeriesFacilityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYLECTURESERIESFACILITY = "SELECT legacyLectureSeriesFacility FROM LegacyLectureSeriesFacility legacyLectureSeriesFacility";
	private static final String _SQL_SELECT_LEGACYLECTURESERIESFACILITY_WHERE = "SELECT legacyLectureSeriesFacility FROM LegacyLectureSeriesFacility legacyLectureSeriesFacility WHERE ";
	private static final String _SQL_COUNT_LEGACYLECTURESERIESFACILITY = "SELECT COUNT(legacyLectureSeriesFacility) FROM LegacyLectureSeriesFacility legacyLectureSeriesFacility";
	private static final String _SQL_COUNT_LEGACYLECTURESERIESFACILITY_WHERE = "SELECT COUNT(legacyLectureSeriesFacility) FROM LegacyLectureSeriesFacility legacyLectureSeriesFacility WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacyLectureSeriesFacility.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LegacyLectureSeriesFacility exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LegacyLectureSeriesFacility exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacyLectureSeriesFacilityPersistenceImpl.class);
	private static LegacyLectureSeriesFacility _nullLegacyLectureSeriesFacility = new LegacyLectureSeriesFacilityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LegacyLectureSeriesFacility> toCacheModel() {
				return _nullLegacyLectureSeriesFacilityCacheModel;
			}
		};

	private static CacheModel<LegacyLectureSeriesFacility> _nullLegacyLectureSeriesFacilityCacheModel =
		new CacheModel<LegacyLectureSeriesFacility>() {
			@Override
			public LegacyLectureSeriesFacility toEntityModel() {
				return _nullLegacyLectureSeriesFacility;
			}
		};
}