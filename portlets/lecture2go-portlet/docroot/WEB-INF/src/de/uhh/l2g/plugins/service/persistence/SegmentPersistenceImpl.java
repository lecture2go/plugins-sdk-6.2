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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchSegmentException;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.impl.SegmentImpl;
import de.uhh.l2g.plugins.model.impl.SegmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see SegmentPersistence
 * @see SegmentUtil
 * @generated
 */
public class SegmentPersistenceImpl extends BasePersistenceImpl<Segment>
	implements SegmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SegmentUtil} to access the segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SegmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SegmentPersistenceImpl() {
		setModelClass(Segment.class);
	}

	/**
	 * Caches the segment in the entity cache if it is enabled.
	 *
	 * @param segment the segment
	 */
	@Override
	public void cacheResult(Segment segment) {
		EntityCacheUtil.putResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentImpl.class, segment.getPrimaryKey(), segment);

		segment.resetOriginalValues();
	}

	/**
	 * Caches the segments in the entity cache if it is enabled.
	 *
	 * @param segments the segments
	 */
	@Override
	public void cacheResult(List<Segment> segments) {
		for (Segment segment : segments) {
			if (EntityCacheUtil.getResult(
						SegmentModelImpl.ENTITY_CACHE_ENABLED,
						SegmentImpl.class, segment.getPrimaryKey()) == null) {
				cacheResult(segment);
			}
			else {
				segment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all segments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SegmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SegmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the segment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Segment segment) {
		EntityCacheUtil.removeResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentImpl.class, segment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Segment> segments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Segment segment : segments) {
			EntityCacheUtil.removeResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
				SegmentImpl.class, segment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new segment with the primary key. Does not add the segment to the database.
	 *
	 * @param segmentId the primary key for the new segment
	 * @return the new segment
	 */
	@Override
	public Segment create(int segmentId) {
		Segment segment = new SegmentImpl();

		segment.setNew(true);
		segment.setPrimaryKey(segmentId);

		return segment;
	}

	/**
	 * Removes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment remove(int segmentId)
		throws NoSuchSegmentException, SystemException {
		return remove((Serializable)segmentId);
	}

	/**
	 * Removes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the segment
	 * @return the segment that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment remove(Serializable primaryKey)
		throws NoSuchSegmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Segment segment = (Segment)session.get(SegmentImpl.class, primaryKey);

			if (segment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSegmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(segment);
		}
		catch (NoSuchSegmentException nsee) {
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
	protected Segment removeImpl(Segment segment) throws SystemException {
		segment = toUnwrappedModel(segment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(segment)) {
				segment = (Segment)session.get(SegmentImpl.class,
						segment.getPrimaryKeyObj());
			}

			if (segment != null) {
				session.delete(segment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (segment != null) {
			clearCache(segment);
		}

		return segment;
	}

	@Override
	public Segment updateImpl(de.uhh.l2g.plugins.model.Segment segment)
		throws SystemException {
		segment = toUnwrappedModel(segment);

		boolean isNew = segment.isNew();

		Session session = null;

		try {
			session = openSession();

			if (segment.isNew()) {
				session.save(segment);

				segment.setNew(false);
			}
			else {
				session.merge(segment);
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

		EntityCacheUtil.putResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentImpl.class, segment.getPrimaryKey(), segment);

		return segment;
	}

	protected Segment toUnwrappedModel(Segment segment) {
		if (segment instanceof SegmentImpl) {
			return segment;
		}

		SegmentImpl segmentImpl = new SegmentImpl();

		segmentImpl.setNew(segment.isNew());
		segmentImpl.setPrimaryKey(segment.getPrimaryKey());

		segmentImpl.setSegmentId(segment.getSegmentId());
		segmentImpl.setVideoId(segment.getVideoId());
		segmentImpl.setStart(segment.getStart());
		segmentImpl.setTitle(segment.getTitle());
		segmentImpl.setDescription(segment.getDescription());
		segmentImpl.setEnd(segment.getEnd());
		segmentImpl.setChapter(segment.getChapter());
		segmentImpl.setUserId(segment.getUserId());

		return segmentImpl;
	}

	/**
	 * Returns the segment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the segment
	 * @return the segment
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSegmentException, SystemException {
		Segment segment = fetchByPrimaryKey(primaryKey);

		if (segment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSegmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return segment;
	}

	/**
	 * Returns the segment with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchSegmentException} if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment
	 * @throws de.uhh.l2g.plugins.NoSuchSegmentException if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment findByPrimaryKey(int segmentId)
		throws NoSuchSegmentException, SystemException {
		return findByPrimaryKey((Serializable)segmentId);
	}

	/**
	 * Returns the segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the segment
	 * @return the segment, or <code>null</code> if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Segment segment = (Segment)EntityCacheUtil.getResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
				SegmentImpl.class, primaryKey);

		if (segment == _nullSegment) {
			return null;
		}

		if (segment == null) {
			Session session = null;

			try {
				session = openSession();

				segment = (Segment)session.get(SegmentImpl.class, primaryKey);

				if (segment != null) {
					cacheResult(segment);
				}
				else {
					EntityCacheUtil.putResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
						SegmentImpl.class, primaryKey, _nullSegment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SegmentModelImpl.ENTITY_CACHE_ENABLED,
					SegmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return segment;
	}

	/**
	 * Returns the segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment, or <code>null</code> if a segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Segment fetchByPrimaryKey(int segmentId) throws SystemException {
		return fetchByPrimaryKey((Serializable)segmentId);
	}

	/**
	 * Returns all the segments.
	 *
	 * @return the segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Segment> findAll(int start, int end,
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

		List<Segment> list = (List<Segment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEGMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEGMENT;

				if (pagination) {
					sql = sql.concat(SegmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Segment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Segment>(list);
				}
				else {
					list = (List<Segment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the segments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Segment segment : findAll()) {
			remove(segment);
		}
	}

	/**
	 * Returns the number of segments.
	 *
	 * @return the number of segments
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

				Query q = session.createQuery(_SQL_COUNT_SEGMENT);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the segment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Segment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Segment>> listenersList = new ArrayList<ModelListener<Segment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Segment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SegmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SEGMENT = "SELECT segment FROM Segment segment";
	private static final String _SQL_COUNT_SEGMENT = "SELECT COUNT(segment) FROM Segment segment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "segment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Segment exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SegmentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"start", "end"
			});
	private static Segment _nullSegment = new SegmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Segment> toCacheModel() {
				return _nullSegmentCacheModel;
			}
		};

	private static CacheModel<Segment> _nullSegmentCacheModel = new CacheModel<Segment>() {
			@Override
			public Segment toEntityModel() {
				return _nullSegment;
			}
		};
}