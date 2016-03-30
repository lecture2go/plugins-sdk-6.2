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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchStatisticsException;
import de.uhh.l2g.plugins.model.Statistics;
import de.uhh.l2g.plugins.model.impl.StatisticsImpl;
import de.uhh.l2g.plugins.model.impl.StatisticsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the statistics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see StatisticsPersistence
 * @see StatisticsUtil
 * @generated
 */
public class StatisticsPersistenceImpl extends BasePersistenceImpl<Statistics>
	implements StatisticsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatisticsUtil} to access the statistics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatisticsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, StatisticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, StatisticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_STATISTICSID = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, StatisticsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByStatisticsId",
			new String[] { Long.class.getName() },
			StatisticsModelImpl.STATISTICSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATISTICSID = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatisticsId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the statistics where statisticsId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchStatisticsException} if it could not be found.
	 *
	 * @param statisticsId the statistics ID
	 * @return the matching statistics
	 * @throws de.uhh.l2g.plugins.NoSuchStatisticsException if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics findByStatisticsId(long statisticsId)
		throws NoSuchStatisticsException, SystemException {
		Statistics statistics = fetchByStatisticsId(statisticsId);

		if (statistics == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("statisticsId=");
			msg.append(statisticsId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStatisticsException(msg.toString());
		}

		return statistics;
	}

	/**
	 * Returns the statistics where statisticsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param statisticsId the statistics ID
	 * @return the matching statistics, or <code>null</code> if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics fetchByStatisticsId(long statisticsId)
		throws SystemException {
		return fetchByStatisticsId(statisticsId, true);
	}

	/**
	 * Returns the statistics where statisticsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param statisticsId the statistics ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching statistics, or <code>null</code> if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics fetchByStatisticsId(long statisticsId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { statisticsId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STATISTICSID,
					finderArgs, this);
		}

		if (result instanceof Statistics) {
			Statistics statistics = (Statistics)result;

			if ((statisticsId != statistics.getStatisticsId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STATISTICS_WHERE);

			query.append(_FINDER_COLUMN_STATISTICSID_STATISTICSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statisticsId);

				List<Statistics> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATISTICSID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StatisticsPersistenceImpl.fetchByStatisticsId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Statistics statistics = list.get(0);

					result = statistics;

					cacheResult(statistics);

					if ((statistics.getStatisticsId() != statisticsId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATISTICSID,
							finderArgs, statistics);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATISTICSID,
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
			return (Statistics)result;
		}
	}

	/**
	 * Removes the statistics where statisticsId = &#63; from the database.
	 *
	 * @param statisticsId the statistics ID
	 * @return the statistics that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics removeByStatisticsId(long statisticsId)
		throws NoSuchStatisticsException, SystemException {
		Statistics statistics = findByStatisticsId(statisticsId);

		return remove(statistics);
	}

	/**
	 * Returns the number of statisticses where statisticsId = &#63;.
	 *
	 * @param statisticsId the statistics ID
	 * @return the number of matching statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatisticsId(long statisticsId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATISTICSID;

		Object[] finderArgs = new Object[] { statisticsId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STATISTICS_WHERE);

			query.append(_FINDER_COLUMN_STATISTICSID_STATISTICSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statisticsId);

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

	private static final String _FINDER_COLUMN_STATISTICSID_STATISTICSID_2 = "statistics.statisticsId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_G_S = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, StatisticsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			StatisticsModelImpl.COMPANYID_COLUMN_BITMASK |
			StatisticsModelImpl.GROUPID_COLUMN_BITMASK |
			StatisticsModelImpl.STATISTICSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_S = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the statistics where companyId = &#63; and groupId = &#63; and statisticsId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchStatisticsException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticsId the statistics ID
	 * @return the matching statistics
	 * @throws de.uhh.l2g.plugins.NoSuchStatisticsException if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics findByC_G_S(long companyId, long groupId,
		long statisticsId) throws NoSuchStatisticsException, SystemException {
		Statistics statistics = fetchByC_G_S(companyId, groupId, statisticsId);

		if (statistics == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", statisticsId=");
			msg.append(statisticsId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStatisticsException(msg.toString());
		}

		return statistics;
	}

	/**
	 * Returns the statistics where companyId = &#63; and groupId = &#63; and statisticsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticsId the statistics ID
	 * @return the matching statistics, or <code>null</code> if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics fetchByC_G_S(long companyId, long groupId,
		long statisticsId) throws SystemException {
		return fetchByC_G_S(companyId, groupId, statisticsId, true);
	}

	/**
	 * Returns the statistics where companyId = &#63; and groupId = &#63; and statisticsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticsId the statistics ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching statistics, or <code>null</code> if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics fetchByC_G_S(long companyId, long groupId,
		long statisticsId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, statisticsId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_G_S,
					finderArgs, this);
		}

		if (result instanceof Statistics) {
			Statistics statistics = (Statistics)result;

			if ((companyId != statistics.getCompanyId()) ||
					(groupId != statistics.getGroupId()) ||
					(statisticsId != statistics.getStatisticsId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_STATISTICS_WHERE);

			query.append(_FINDER_COLUMN_C_G_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_S_STATISTICSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(statisticsId);

				List<Statistics> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_S,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StatisticsPersistenceImpl.fetchByC_G_S(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Statistics statistics = list.get(0);

					result = statistics;

					cacheResult(statistics);

					if ((statistics.getCompanyId() != companyId) ||
							(statistics.getGroupId() != groupId) ||
							(statistics.getStatisticsId() != statisticsId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_S,
							finderArgs, statistics);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_S,
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
			return (Statistics)result;
		}
	}

	/**
	 * Removes the statistics where companyId = &#63; and groupId = &#63; and statisticsId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticsId the statistics ID
	 * @return the statistics that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics removeByC_G_S(long companyId, long groupId,
		long statisticsId) throws NoSuchStatisticsException, SystemException {
		Statistics statistics = findByC_G_S(companyId, groupId, statisticsId);

		return remove(statistics);
	}

	/**
	 * Returns the number of statisticses where companyId = &#63; and groupId = &#63; and statisticsId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticsId the statistics ID
	 * @return the number of matching statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_S(long companyId, long groupId, long statisticsId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_S;

		Object[] finderArgs = new Object[] { companyId, groupId, statisticsId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STATISTICS_WHERE);

			query.append(_FINDER_COLUMN_C_G_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_S_STATISTICSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(statisticsId);

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

	private static final String _FINDER_COLUMN_C_G_S_COMPANYID_2 = "statistics.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_S_GROUPID_2 = "statistics.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_S_STATISTICSID_2 = "statistics.statisticsId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_G_D = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, StatisticsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_G_D",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			StatisticsModelImpl.COMPANYID_COLUMN_BITMASK |
			StatisticsModelImpl.GROUPID_COLUMN_BITMASK |
			StatisticsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_D = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_D",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			});

	/**
	 * Returns the statistics where companyId = &#63; and groupId = &#63; and createDate = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchStatisticsException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the matching statistics
	 * @throws de.uhh.l2g.plugins.NoSuchStatisticsException if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics findByC_G_D(long companyId, long groupId, Date createDate)
		throws NoSuchStatisticsException, SystemException {
		Statistics statistics = fetchByC_G_D(companyId, groupId, createDate);

		if (statistics == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", createDate=");
			msg.append(createDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStatisticsException(msg.toString());
		}

		return statistics;
	}

	/**
	 * Returns the statistics where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the matching statistics, or <code>null</code> if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics fetchByC_G_D(long companyId, long groupId, Date createDate)
		throws SystemException {
		return fetchByC_G_D(companyId, groupId, createDate, true);
	}

	/**
	 * Returns the statistics where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching statistics, or <code>null</code> if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics fetchByC_G_D(long companyId, long groupId,
		Date createDate, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, createDate };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_G_D,
					finderArgs, this);
		}

		if (result instanceof Statistics) {
			Statistics statistics = (Statistics)result;

			if ((companyId != statistics.getCompanyId()) ||
					(groupId != statistics.getGroupId()) ||
					!Validator.equals(createDate, statistics.getCreateDate())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_STATISTICS_WHERE);

			query.append(_FINDER_COLUMN_C_G_D_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_D_GROUPID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_G_D_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_G_D_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindCreateDate) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				List<Statistics> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_D,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StatisticsPersistenceImpl.fetchByC_G_D(long, long, Date, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Statistics statistics = list.get(0);

					result = statistics;

					cacheResult(statistics);

					if ((statistics.getCompanyId() != companyId) ||
							(statistics.getGroupId() != groupId) ||
							(statistics.getCreateDate() == null) ||
							!statistics.getCreateDate().equals(createDate)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_D,
							finderArgs, statistics);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_D,
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
			return (Statistics)result;
		}
	}

	/**
	 * Removes the statistics where companyId = &#63; and groupId = &#63; and createDate = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the statistics that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics removeByC_G_D(long companyId, long groupId,
		Date createDate) throws NoSuchStatisticsException, SystemException {
		Statistics statistics = findByC_G_D(companyId, groupId, createDate);

		return remove(statistics);
	}

	/**
	 * Returns the number of statisticses where companyId = &#63; and groupId = &#63; and createDate = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the number of matching statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_D(long companyId, long groupId, Date createDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_D;

		Object[] finderArgs = new Object[] { companyId, groupId, createDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STATISTICS_WHERE);

			query.append(_FINDER_COLUMN_C_G_D_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_D_GROUPID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_G_D_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_G_D_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindCreateDate) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

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

	private static final String _FINDER_COLUMN_C_G_D_COMPANYID_2 = "statistics.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_D_GROUPID_2 = "statistics.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_D_CREATEDATE_1 = "statistics.createDate IS NULL";
	private static final String _FINDER_COLUMN_C_G_D_CREATEDATE_2 = "statistics.createDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, StatisticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, StatisticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			StatisticsModelImpl.COMPANYID_COLUMN_BITMASK |
			StatisticsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the statisticses where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Statistics> findByC_G(long companyId, long groupId)
		throws SystemException {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the statisticses where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of statisticses
	 * @param end the upper bound of the range of statisticses (not inclusive)
	 * @return the range of matching statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Statistics> findByC_G(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the statisticses where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of statisticses
	 * @param end the upper bound of the range of statisticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Statistics> findByC_G(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Statistics> list = (List<Statistics>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Statistics statistics : list) {
				if ((companyId != statistics.getCompanyId()) ||
						(groupId != statistics.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_STATISTICS_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StatisticsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Statistics>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Statistics>(list);
				}
				else {
					list = (List<Statistics>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first statistics in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistics
	 * @throws de.uhh.l2g.plugins.NoSuchStatisticsException if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics findByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchStatisticsException, SystemException {
		Statistics statistics = fetchByC_G_First(companyId, groupId,
				orderByComparator);

		if (statistics != null) {
			return statistics;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatisticsException(msg.toString());
	}

	/**
	 * Returns the first statistics in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistics, or <code>null</code> if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics fetchByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Statistics> list = findByC_G(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last statistics in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistics
	 * @throws de.uhh.l2g.plugins.NoSuchStatisticsException if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics findByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchStatisticsException, SystemException {
		Statistics statistics = fetchByC_G_Last(companyId, groupId,
				orderByComparator);

		if (statistics != null) {
			return statistics;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStatisticsException(msg.toString());
	}

	/**
	 * Returns the last statistics in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistics, or <code>null</code> if a matching statistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Statistics> list = findByC_G(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the statisticses before and after the current statistics in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param statisticsId the primary key of the current statistics
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next statistics
	 * @throws de.uhh.l2g.plugins.NoSuchStatisticsException if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics[] findByC_G_PrevAndNext(long statisticsId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchStatisticsException, SystemException {
		Statistics statistics = findByPrimaryKey(statisticsId);

		Session session = null;

		try {
			session = openSession();

			Statistics[] array = new StatisticsImpl[3];

			array[0] = getByC_G_PrevAndNext(session, statistics, companyId,
					groupId, orderByComparator, true);

			array[1] = statistics;

			array[2] = getByC_G_PrevAndNext(session, statistics, companyId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Statistics getByC_G_PrevAndNext(Session session,
		Statistics statistics, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STATISTICS_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StatisticsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(statistics);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Statistics> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the statisticses where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G(long companyId, long groupId)
		throws SystemException {
		for (Statistics statistics : findByC_G(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(statistics);
		}
	}

	/**
	 * Returns the number of statisticses where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STATISTICS_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "statistics.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "statistics.groupId = ?";

	public StatisticsPersistenceImpl() {
		setModelClass(Statistics.class);
	}

	/**
	 * Caches the statistics in the entity cache if it is enabled.
	 *
	 * @param statistics the statistics
	 */
	@Override
	public void cacheResult(Statistics statistics) {
		EntityCacheUtil.putResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsImpl.class, statistics.getPrimaryKey(), statistics);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATISTICSID,
			new Object[] { statistics.getStatisticsId() }, statistics);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_S,
			new Object[] {
				statistics.getCompanyId(), statistics.getGroupId(),
				statistics.getStatisticsId()
			}, statistics);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_D,
			new Object[] {
				statistics.getCompanyId(), statistics.getGroupId(),
				statistics.getCreateDate()
			}, statistics);

		statistics.resetOriginalValues();
	}

	/**
	 * Caches the statisticses in the entity cache if it is enabled.
	 *
	 * @param statisticses the statisticses
	 */
	@Override
	public void cacheResult(List<Statistics> statisticses) {
		for (Statistics statistics : statisticses) {
			if (EntityCacheUtil.getResult(
						StatisticsModelImpl.ENTITY_CACHE_ENABLED,
						StatisticsImpl.class, statistics.getPrimaryKey()) == null) {
				cacheResult(statistics);
			}
			else {
				statistics.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all statisticses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StatisticsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StatisticsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the statistics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Statistics statistics) {
		EntityCacheUtil.removeResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsImpl.class, statistics.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(statistics);
	}

	@Override
	public void clearCache(List<Statistics> statisticses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Statistics statistics : statisticses) {
			EntityCacheUtil.removeResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
				StatisticsImpl.class, statistics.getPrimaryKey());

			clearUniqueFindersCache(statistics);
		}
	}

	protected void cacheUniqueFindersCache(Statistics statistics) {
		if (statistics.isNew()) {
			Object[] args = new Object[] { statistics.getStatisticsId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATISTICSID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATISTICSID, args,
				statistics);

			args = new Object[] {
					statistics.getCompanyId(), statistics.getGroupId(),
					statistics.getStatisticsId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_S, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_S, args,
				statistics);

			args = new Object[] {
					statistics.getCompanyId(), statistics.getGroupId(),
					statistics.getCreateDate()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_D, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_D, args,
				statistics);
		}
		else {
			StatisticsModelImpl statisticsModelImpl = (StatisticsModelImpl)statistics;

			if ((statisticsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STATISTICSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { statistics.getStatisticsId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATISTICSID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATISTICSID,
					args, statistics);
			}

			if ((statisticsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_G_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statistics.getCompanyId(), statistics.getGroupId(),
						statistics.getStatisticsId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_S, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_S, args,
					statistics);
			}

			if ((statisticsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_G_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statistics.getCompanyId(), statistics.getGroupId(),
						statistics.getCreateDate()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_D, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_D, args,
					statistics);
			}
		}
	}

	protected void clearUniqueFindersCache(Statistics statistics) {
		StatisticsModelImpl statisticsModelImpl = (StatisticsModelImpl)statistics;

		Object[] args = new Object[] { statistics.getStatisticsId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATISTICSID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATISTICSID, args);

		if ((statisticsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STATISTICSID.getColumnBitmask()) != 0) {
			args = new Object[] { statisticsModelImpl.getOriginalStatisticsId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATISTICSID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATISTICSID, args);
		}

		args = new Object[] {
				statistics.getCompanyId(), statistics.getGroupId(),
				statistics.getStatisticsId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_S, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_S, args);

		if ((statisticsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_G_S.getColumnBitmask()) != 0) {
			args = new Object[] {
					statisticsModelImpl.getOriginalCompanyId(),
					statisticsModelImpl.getOriginalGroupId(),
					statisticsModelImpl.getOriginalStatisticsId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_S, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_S, args);
		}

		args = new Object[] {
				statistics.getCompanyId(), statistics.getGroupId(),
				statistics.getCreateDate()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_D, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_D, args);

		if ((statisticsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_G_D.getColumnBitmask()) != 0) {
			args = new Object[] {
					statisticsModelImpl.getOriginalCompanyId(),
					statisticsModelImpl.getOriginalGroupId(),
					statisticsModelImpl.getOriginalCreateDate()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_D, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_D, args);
		}
	}

	/**
	 * Creates a new statistics with the primary key. Does not add the statistics to the database.
	 *
	 * @param statisticsId the primary key for the new statistics
	 * @return the new statistics
	 */
	@Override
	public Statistics create(long statisticsId) {
		Statistics statistics = new StatisticsImpl();

		statistics.setNew(true);
		statistics.setPrimaryKey(statisticsId);

		return statistics;
	}

	/**
	 * Removes the statistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statisticsId the primary key of the statistics
	 * @return the statistics that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchStatisticsException if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics remove(long statisticsId)
		throws NoSuchStatisticsException, SystemException {
		return remove((Serializable)statisticsId);
	}

	/**
	 * Removes the statistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the statistics
	 * @return the statistics that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchStatisticsException if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics remove(Serializable primaryKey)
		throws NoSuchStatisticsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Statistics statistics = (Statistics)session.get(StatisticsImpl.class,
					primaryKey);

			if (statistics == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatisticsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statistics);
		}
		catch (NoSuchStatisticsException nsee) {
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
	protected Statistics removeImpl(Statistics statistics)
		throws SystemException {
		statistics = toUnwrappedModel(statistics);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statistics)) {
				statistics = (Statistics)session.get(StatisticsImpl.class,
						statistics.getPrimaryKeyObj());
			}

			if (statistics != null) {
				session.delete(statistics);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statistics != null) {
			clearCache(statistics);
		}

		return statistics;
	}

	@Override
	public Statistics updateImpl(de.uhh.l2g.plugins.model.Statistics statistics)
		throws SystemException {
		statistics = toUnwrappedModel(statistics);

		boolean isNew = statistics.isNew();

		StatisticsModelImpl statisticsModelImpl = (StatisticsModelImpl)statistics;

		Session session = null;

		try {
			session = openSession();

			if (statistics.isNew()) {
				session.save(statistics);

				statistics.setNew(false);
			}
			else {
				session.merge(statistics);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatisticsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((statisticsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statisticsModelImpl.getOriginalCompanyId(),
						statisticsModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						statisticsModelImpl.getCompanyId(),
						statisticsModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}
		}

		EntityCacheUtil.putResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsImpl.class, statistics.getPrimaryKey(), statistics);

		clearUniqueFindersCache(statistics);
		cacheUniqueFindersCache(statistics);

		return statistics;
	}

	protected Statistics toUnwrappedModel(Statistics statistics) {
		if (statistics instanceof StatisticsImpl) {
			return statistics;
		}

		StatisticsImpl statisticsImpl = new StatisticsImpl();

		statisticsImpl.setNew(statistics.isNew());
		statisticsImpl.setPrimaryKey(statistics.getPrimaryKey());

		statisticsImpl.setStatisticsId(statistics.getStatisticsId());
		statisticsImpl.setGroupId(statistics.getGroupId());
		statisticsImpl.setCompanyId(statistics.getCompanyId());
		statisticsImpl.setPublicVideos(statistics.getPublicVideos());
		statisticsImpl.setPrivateVideos(statistics.getPrivateVideos());
		statisticsImpl.setAutofillRow(statistics.getAutofillRow());
		statisticsImpl.setUserId(statistics.getUserId());
		statisticsImpl.setUserName(statistics.getUserName());
		statisticsImpl.setCreateDate(statistics.getCreateDate());
		statisticsImpl.setModifiedDate(statistics.getModifiedDate());

		return statisticsImpl;
	}

	/**
	 * Returns the statistics with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the statistics
	 * @return the statistics
	 * @throws de.uhh.l2g.plugins.NoSuchStatisticsException if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatisticsException, SystemException {
		Statistics statistics = fetchByPrimaryKey(primaryKey);

		if (statistics == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatisticsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statistics;
	}

	/**
	 * Returns the statistics with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchStatisticsException} if it could not be found.
	 *
	 * @param statisticsId the primary key of the statistics
	 * @return the statistics
	 * @throws de.uhh.l2g.plugins.NoSuchStatisticsException if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics findByPrimaryKey(long statisticsId)
		throws NoSuchStatisticsException, SystemException {
		return findByPrimaryKey((Serializable)statisticsId);
	}

	/**
	 * Returns the statistics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the statistics
	 * @return the statistics, or <code>null</code> if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Statistics statistics = (Statistics)EntityCacheUtil.getResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
				StatisticsImpl.class, primaryKey);

		if (statistics == _nullStatistics) {
			return null;
		}

		if (statistics == null) {
			Session session = null;

			try {
				session = openSession();

				statistics = (Statistics)session.get(StatisticsImpl.class,
						primaryKey);

				if (statistics != null) {
					cacheResult(statistics);
				}
				else {
					EntityCacheUtil.putResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
						StatisticsImpl.class, primaryKey, _nullStatistics);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
					StatisticsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statistics;
	}

	/**
	 * Returns the statistics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statisticsId the primary key of the statistics
	 * @return the statistics, or <code>null</code> if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics fetchByPrimaryKey(long statisticsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)statisticsId);
	}

	/**
	 * Returns all the statisticses.
	 *
	 * @return the statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Statistics> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of statisticses
	 * @param end the upper bound of the range of statisticses (not inclusive)
	 * @return the range of statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Statistics> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of statisticses
	 * @param end the upper bound of the range of statisticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of statisticses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Statistics> findAll(int start, int end,
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

		List<Statistics> list = (List<Statistics>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STATISTICS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATISTICS;

				if (pagination) {
					sql = sql.concat(StatisticsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Statistics>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Statistics>(list);
				}
				else {
					list = (List<Statistics>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the statisticses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Statistics statistics : findAll()) {
			remove(statistics);
		}
	}

	/**
	 * Returns the number of statisticses.
	 *
	 * @return the number of statisticses
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

				Query q = session.createQuery(_SQL_COUNT_STATISTICS);

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
	 * Initializes the statistics persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Statistics")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Statistics>> listenersList = new ArrayList<ModelListener<Statistics>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Statistics>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StatisticsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STATISTICS = "SELECT statistics FROM Statistics statistics";
	private static final String _SQL_SELECT_STATISTICS_WHERE = "SELECT statistics FROM Statistics statistics WHERE ";
	private static final String _SQL_COUNT_STATISTICS = "SELECT COUNT(statistics) FROM Statistics statistics";
	private static final String _SQL_COUNT_STATISTICS_WHERE = "SELECT COUNT(statistics) FROM Statistics statistics WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statistics.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Statistics exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Statistics exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StatisticsPersistenceImpl.class);
	private static Statistics _nullStatistics = new StatisticsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Statistics> toCacheModel() {
				return _nullStatisticsCacheModel;
			}
		};

	private static CacheModel<Statistics> _nullStatisticsCacheModel = new CacheModel<Statistics>() {
			@Override
			public Statistics toEntityModel() {
				return _nullStatistics;
			}
		};
}