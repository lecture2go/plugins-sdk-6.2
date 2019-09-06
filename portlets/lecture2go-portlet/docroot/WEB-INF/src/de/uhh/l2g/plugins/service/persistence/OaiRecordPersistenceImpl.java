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

import de.uhh.l2g.plugins.NoSuchOaiRecordException;
import de.uhh.l2g.plugins.model.OaiRecord;
import de.uhh.l2g.plugins.model.impl.OaiRecordImpl;
import de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the oai record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecordPersistence
 * @see OaiRecordUtil
 * @generated
 */
public class OaiRecordPersistenceImpl extends BasePersistenceImpl<OaiRecord>
	implements OaiRecordPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OaiRecordUtil} to access the oai record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OaiRecordImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordModelImpl.FINDER_CACHE_ENABLED, OaiRecordImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordModelImpl.FINDER_CACHE_ENABLED, OaiRecordImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_VIDEO = new FinderPath(OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordModelImpl.FINDER_CACHE_ENABLED, OaiRecordImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByVideo",
			new String[] { Long.class.getName() },
			OaiRecordModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns the oai record where videoId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchOaiRecordException} if it could not be found.
	 *
	 * @param videoId the video ID
	 * @return the matching oai record
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecordException if a matching oai record could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord findByVideo(long videoId)
		throws NoSuchOaiRecordException, SystemException {
		OaiRecord oaiRecord = fetchByVideo(videoId);

		if (oaiRecord == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOaiRecordException(msg.toString());
		}

		return oaiRecord;
	}

	/**
	 * Returns the oai record where videoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param videoId the video ID
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord fetchByVideo(long videoId) throws SystemException {
		return fetchByVideo(videoId, true);
	}

	/**
	 * Returns the oai record where videoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param videoId the video ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord fetchByVideo(long videoId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { videoId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_VIDEO,
					finderArgs, this);
		}

		if (result instanceof OaiRecord) {
			OaiRecord oaiRecord = (OaiRecord)result;

			if ((videoId != oaiRecord.getVideoId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_OAIRECORD_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				List<OaiRecord> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEO,
						finderArgs, list);
				}
				else {
					OaiRecord oaiRecord = list.get(0);

					result = oaiRecord;

					cacheResult(oaiRecord);

					if ((oaiRecord.getVideoId() != videoId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEO,
							finderArgs, oaiRecord);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VIDEO,
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
			return (OaiRecord)result;
		}
	}

	/**
	 * Removes the oai record where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @return the oai record that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord removeByVideo(long videoId)
		throws NoSuchOaiRecordException, SystemException {
		OaiRecord oaiRecord = findByVideo(videoId);

		return remove(oaiRecord);
	}

	/**
	 * Returns the number of oai records where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching oai records
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVideo(long videoId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEO;

		Object[] finderArgs = new Object[] { videoId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OAIRECORD_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "oaiRecord.videoId = ?";

	public OaiRecordPersistenceImpl() {
		setModelClass(OaiRecord.class);
	}

	/**
	 * Caches the oai record in the entity cache if it is enabled.
	 *
	 * @param oaiRecord the oai record
	 */
	@Override
	public void cacheResult(OaiRecord oaiRecord) {
		EntityCacheUtil.putResult(OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordImpl.class, oaiRecord.getPrimaryKey(), oaiRecord);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEO,
			new Object[] { oaiRecord.getVideoId() }, oaiRecord);

		oaiRecord.resetOriginalValues();
	}

	/**
	 * Caches the oai records in the entity cache if it is enabled.
	 *
	 * @param oaiRecords the oai records
	 */
	@Override
	public void cacheResult(List<OaiRecord> oaiRecords) {
		for (OaiRecord oaiRecord : oaiRecords) {
			if (EntityCacheUtil.getResult(
						OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
						OaiRecordImpl.class, oaiRecord.getPrimaryKey()) == null) {
				cacheResult(oaiRecord);
			}
			else {
				oaiRecord.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all oai records.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OaiRecordImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OaiRecordImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the oai record.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OaiRecord oaiRecord) {
		EntityCacheUtil.removeResult(OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordImpl.class, oaiRecord.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(oaiRecord);
	}

	@Override
	public void clearCache(List<OaiRecord> oaiRecords) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OaiRecord oaiRecord : oaiRecords) {
			EntityCacheUtil.removeResult(OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
				OaiRecordImpl.class, oaiRecord.getPrimaryKey());

			clearUniqueFindersCache(oaiRecord);
		}
	}

	protected void cacheUniqueFindersCache(OaiRecord oaiRecord) {
		if (oaiRecord.isNew()) {
			Object[] args = new Object[] { oaiRecord.getVideoId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VIDEO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEO, args,
				oaiRecord);
		}
		else {
			OaiRecordModelImpl oaiRecordModelImpl = (OaiRecordModelImpl)oaiRecord;

			if ((oaiRecordModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { oaiRecord.getVideoId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VIDEO, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEO, args,
					oaiRecord);
			}
		}
	}

	protected void clearUniqueFindersCache(OaiRecord oaiRecord) {
		OaiRecordModelImpl oaiRecordModelImpl = (OaiRecordModelImpl)oaiRecord;

		Object[] args = new Object[] { oaiRecord.getVideoId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VIDEO, args);

		if ((oaiRecordModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_VIDEO.getColumnBitmask()) != 0) {
			args = new Object[] { oaiRecordModelImpl.getOriginalVideoId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VIDEO, args);
		}
	}

	/**
	 * Creates a new oai record with the primary key. Does not add the oai record to the database.
	 *
	 * @param oaiRecordId the primary key for the new oai record
	 * @return the new oai record
	 */
	@Override
	public OaiRecord create(long oaiRecordId) {
		OaiRecord oaiRecord = new OaiRecordImpl();

		oaiRecord.setNew(true);
		oaiRecord.setPrimaryKey(oaiRecordId);

		return oaiRecord;
	}

	/**
	 * Removes the oai record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecordException if a oai record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord remove(long oaiRecordId)
		throws NoSuchOaiRecordException, SystemException {
		return remove((Serializable)oaiRecordId);
	}

	/**
	 * Removes the oai record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the oai record
	 * @return the oai record that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecordException if a oai record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord remove(Serializable primaryKey)
		throws NoSuchOaiRecordException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OaiRecord oaiRecord = (OaiRecord)session.get(OaiRecordImpl.class,
					primaryKey);

			if (oaiRecord == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOaiRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(oaiRecord);
		}
		catch (NoSuchOaiRecordException nsee) {
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
	protected OaiRecord removeImpl(OaiRecord oaiRecord)
		throws SystemException {
		oaiRecord = toUnwrappedModel(oaiRecord);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(oaiRecord)) {
				oaiRecord = (OaiRecord)session.get(OaiRecordImpl.class,
						oaiRecord.getPrimaryKeyObj());
			}

			if (oaiRecord != null) {
				session.delete(oaiRecord);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (oaiRecord != null) {
			clearCache(oaiRecord);
		}

		return oaiRecord;
	}

	@Override
	public OaiRecord updateImpl(de.uhh.l2g.plugins.model.OaiRecord oaiRecord)
		throws SystemException {
		oaiRecord = toUnwrappedModel(oaiRecord);

		boolean isNew = oaiRecord.isNew();

		Session session = null;

		try {
			session = openSession();

			if (oaiRecord.isNew()) {
				session.save(oaiRecord);

				oaiRecord.setNew(false);
			}
			else {
				session.merge(oaiRecord);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OaiRecordModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordImpl.class, oaiRecord.getPrimaryKey(), oaiRecord);

		clearUniqueFindersCache(oaiRecord);
		cacheUniqueFindersCache(oaiRecord);

		return oaiRecord;
	}

	protected OaiRecord toUnwrappedModel(OaiRecord oaiRecord) {
		if (oaiRecord instanceof OaiRecordImpl) {
			return oaiRecord;
		}

		OaiRecordImpl oaiRecordImpl = new OaiRecordImpl();

		oaiRecordImpl.setNew(oaiRecord.isNew());
		oaiRecordImpl.setPrimaryKey(oaiRecord.getPrimaryKey());

		oaiRecordImpl.setOaiRecordId(oaiRecord.getOaiRecordId());
		oaiRecordImpl.setVideoId(oaiRecord.getVideoId());
		oaiRecordImpl.setIdentifier(oaiRecord.getIdentifier());
		oaiRecordImpl.setDatestamp(oaiRecord.getDatestamp());
		oaiRecordImpl.setDeleted(oaiRecord.isDeleted());

		return oaiRecordImpl;
	}

	/**
	 * Returns the oai record with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the oai record
	 * @return the oai record
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecordException if a oai record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOaiRecordException, SystemException {
		OaiRecord oaiRecord = fetchByPrimaryKey(primaryKey);

		if (oaiRecord == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOaiRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return oaiRecord;
	}

	/**
	 * Returns the oai record with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchOaiRecordException} if it could not be found.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record
	 * @throws de.uhh.l2g.plugins.NoSuchOaiRecordException if a oai record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord findByPrimaryKey(long oaiRecordId)
		throws NoSuchOaiRecordException, SystemException {
		return findByPrimaryKey((Serializable)oaiRecordId);
	}

	/**
	 * Returns the oai record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the oai record
	 * @return the oai record, or <code>null</code> if a oai record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OaiRecord oaiRecord = (OaiRecord)EntityCacheUtil.getResult(OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
				OaiRecordImpl.class, primaryKey);

		if (oaiRecord == _nullOaiRecord) {
			return null;
		}

		if (oaiRecord == null) {
			Session session = null;

			try {
				session = openSession();

				oaiRecord = (OaiRecord)session.get(OaiRecordImpl.class,
						primaryKey);

				if (oaiRecord != null) {
					cacheResult(oaiRecord);
				}
				else {
					EntityCacheUtil.putResult(OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
						OaiRecordImpl.class, primaryKey, _nullOaiRecord);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
					OaiRecordImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return oaiRecord;
	}

	/**
	 * Returns the oai record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record, or <code>null</code> if a oai record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OaiRecord fetchByPrimaryKey(long oaiRecordId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)oaiRecordId);
	}

	/**
	 * Returns all the oai records.
	 *
	 * @return the oai records
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiRecord> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the oai records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai records
	 * @param end the upper bound of the range of oai records (not inclusive)
	 * @return the range of oai records
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiRecord> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the oai records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai records
	 * @param end the upper bound of the range of oai records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oai records
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OaiRecord> findAll(int start, int end,
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

		List<OaiRecord> list = (List<OaiRecord>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OAIRECORD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OAIRECORD;

				if (pagination) {
					sql = sql.concat(OaiRecordModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OaiRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OaiRecord>(list);
				}
				else {
					list = (List<OaiRecord>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the oai records from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OaiRecord oaiRecord : findAll()) {
			remove(oaiRecord);
		}
	}

	/**
	 * Returns the number of oai records.
	 *
	 * @return the number of oai records
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

				Query q = session.createQuery(_SQL_COUNT_OAIRECORD);

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
	 * Initializes the oai record persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.OaiRecord")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OaiRecord>> listenersList = new ArrayList<ModelListener<OaiRecord>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OaiRecord>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OaiRecordImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OAIRECORD = "SELECT oaiRecord FROM OaiRecord oaiRecord";
	private static final String _SQL_SELECT_OAIRECORD_WHERE = "SELECT oaiRecord FROM OaiRecord oaiRecord WHERE ";
	private static final String _SQL_COUNT_OAIRECORD = "SELECT COUNT(oaiRecord) FROM OaiRecord oaiRecord";
	private static final String _SQL_COUNT_OAIRECORD_WHERE = "SELECT COUNT(oaiRecord) FROM OaiRecord oaiRecord WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "oaiRecord.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OaiRecord exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OaiRecord exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OaiRecordPersistenceImpl.class);
	private static OaiRecord _nullOaiRecord = new OaiRecordImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OaiRecord> toCacheModel() {
				return _nullOaiRecordCacheModel;
			}
		};

	private static CacheModel<OaiRecord> _nullOaiRecordCacheModel = new CacheModel<OaiRecord>() {
			@Override
			public OaiRecord toEntityModel() {
				return _nullOaiRecord;
			}
		};
}