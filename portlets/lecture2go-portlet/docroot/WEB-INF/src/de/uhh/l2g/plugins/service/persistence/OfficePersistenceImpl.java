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

import de.uhh.l2g.plugins.NoSuchOfficeException;
import de.uhh.l2g.plugins.model.Office;
import de.uhh.l2g.plugins.model.impl.OfficeImpl;
import de.uhh.l2g.plugins.model.impl.OfficeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the office service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OfficePersistence
 * @see OfficeUtil
 * @generated
 */
public class OfficePersistenceImpl extends BasePersistenceImpl<Office>
	implements OfficePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OfficeUtil} to access the office persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OfficeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OfficeModelImpl.ENTITY_CACHE_ENABLED,
			OfficeModelImpl.FINDER_CACHE_ENABLED, OfficeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OfficeModelImpl.ENTITY_CACHE_ENABLED,
			OfficeModelImpl.FINDER_CACHE_ENABLED, OfficeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OfficeModelImpl.ENTITY_CACHE_ENABLED,
			OfficeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_INSTITUTION = new FinderPath(OfficeModelImpl.ENTITY_CACHE_ENABLED,
			OfficeModelImpl.FINDER_CACHE_ENABLED, OfficeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByInstitution",
			new String[] { Long.class.getName() },
			OfficeModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTITUTION = new FinderPath(OfficeModelImpl.ENTITY_CACHE_ENABLED,
			OfficeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstitution",
			new String[] { Long.class.getName() });

	/**
	 * Returns the office where institutionId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchOfficeException} if it could not be found.
	 *
	 * @param institutionId the institution ID
	 * @return the matching office
	 * @throws de.uhh.l2g.plugins.NoSuchOfficeException if a matching office could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Office findByInstitution(long institutionId)
		throws NoSuchOfficeException, SystemException {
		Office office = fetchByInstitution(institutionId);

		if (office == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("institutionId=");
			msg.append(institutionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOfficeException(msg.toString());
		}

		return office;
	}

	/**
	 * Returns the office where institutionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param institutionId the institution ID
	 * @return the matching office, or <code>null</code> if a matching office could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Office fetchByInstitution(long institutionId)
		throws SystemException {
		return fetchByInstitution(institutionId, true);
	}

	/**
	 * Returns the office where institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param institutionId the institution ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching office, or <code>null</code> if a matching office could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Office fetchByInstitution(long institutionId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { institutionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_INSTITUTION,
					finderArgs, this);
		}

		if (result instanceof Office) {
			Office office = (Office)result;

			if ((institutionId != office.getInstitutionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_OFFICE_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

				List<Office> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INSTITUTION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"OfficePersistenceImpl.fetchByInstitution(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Office office = list.get(0);

					result = office;

					cacheResult(office);

					if ((office.getInstitutionId() != institutionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INSTITUTION,
							finderArgs, office);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INSTITUTION,
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
			return (Office)result;
		}
	}

	/**
	 * Removes the office where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 * @return the office that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Office removeByInstitution(long institutionId)
		throws NoSuchOfficeException, SystemException {
		Office office = findByInstitution(institutionId);

		return remove(office);
	}

	/**
	 * Returns the number of offices where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByInstitution(long institutionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTITUTION;

		Object[] finderArgs = new Object[] { institutionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OFFICE_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

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

	private static final String _FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2 = "office.institutionId = ?";

	public OfficePersistenceImpl() {
		setModelClass(Office.class);
	}

	/**
	 * Caches the office in the entity cache if it is enabled.
	 *
	 * @param office the office
	 */
	@Override
	public void cacheResult(Office office) {
		EntityCacheUtil.putResult(OfficeModelImpl.ENTITY_CACHE_ENABLED,
			OfficeImpl.class, office.getPrimaryKey(), office);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INSTITUTION,
			new Object[] { office.getInstitutionId() }, office);

		office.resetOriginalValues();
	}

	/**
	 * Caches the offices in the entity cache if it is enabled.
	 *
	 * @param offices the offices
	 */
	@Override
	public void cacheResult(List<Office> offices) {
		for (Office office : offices) {
			if (EntityCacheUtil.getResult(
						OfficeModelImpl.ENTITY_CACHE_ENABLED, OfficeImpl.class,
						office.getPrimaryKey()) == null) {
				cacheResult(office);
			}
			else {
				office.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all offices.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OfficeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OfficeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the office.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Office office) {
		EntityCacheUtil.removeResult(OfficeModelImpl.ENTITY_CACHE_ENABLED,
			OfficeImpl.class, office.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(office);
	}

	@Override
	public void clearCache(List<Office> offices) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Office office : offices) {
			EntityCacheUtil.removeResult(OfficeModelImpl.ENTITY_CACHE_ENABLED,
				OfficeImpl.class, office.getPrimaryKey());

			clearUniqueFindersCache(office);
		}
	}

	protected void cacheUniqueFindersCache(Office office) {
		if (office.isNew()) {
			Object[] args = new Object[] { office.getInstitutionId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INSTITUTION, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INSTITUTION, args,
				office);
		}
		else {
			OfficeModelImpl officeModelImpl = (OfficeModelImpl)office;

			if ((officeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_INSTITUTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { office.getInstitutionId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INSTITUTION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INSTITUTION,
					args, office);
			}
		}
	}

	protected void clearUniqueFindersCache(Office office) {
		OfficeModelImpl officeModelImpl = (OfficeModelImpl)office;

		Object[] args = new Object[] { office.getInstitutionId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INSTITUTION, args);

		if ((officeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_INSTITUTION.getColumnBitmask()) != 0) {
			args = new Object[] { officeModelImpl.getOriginalInstitutionId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INSTITUTION, args);
		}
	}

	/**
	 * Creates a new office with the primary key. Does not add the office to the database.
	 *
	 * @param officeId the primary key for the new office
	 * @return the new office
	 */
	@Override
	public Office create(long officeId) {
		Office office = new OfficeImpl();

		office.setNew(true);
		office.setPrimaryKey(officeId);

		return office;
	}

	/**
	 * Removes the office with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeId the primary key of the office
	 * @return the office that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchOfficeException if a office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Office remove(long officeId)
		throws NoSuchOfficeException, SystemException {
		return remove((Serializable)officeId);
	}

	/**
	 * Removes the office with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the office
	 * @return the office that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchOfficeException if a office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Office remove(Serializable primaryKey)
		throws NoSuchOfficeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Office office = (Office)session.get(OfficeImpl.class, primaryKey);

			if (office == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOfficeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(office);
		}
		catch (NoSuchOfficeException nsee) {
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
	protected Office removeImpl(Office office) throws SystemException {
		office = toUnwrappedModel(office);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(office)) {
				office = (Office)session.get(OfficeImpl.class,
						office.getPrimaryKeyObj());
			}

			if (office != null) {
				session.delete(office);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (office != null) {
			clearCache(office);
		}

		return office;
	}

	@Override
	public Office updateImpl(de.uhh.l2g.plugins.model.Office office)
		throws SystemException {
		office = toUnwrappedModel(office);

		boolean isNew = office.isNew();

		Session session = null;

		try {
			session = openSession();

			if (office.isNew()) {
				session.save(office);

				office.setNew(false);
			}
			else {
				session.merge(office);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OfficeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(OfficeModelImpl.ENTITY_CACHE_ENABLED,
			OfficeImpl.class, office.getPrimaryKey(), office);

		clearUniqueFindersCache(office);
		cacheUniqueFindersCache(office);

		return office;
	}

	protected Office toUnwrappedModel(Office office) {
		if (office instanceof OfficeImpl) {
			return office;
		}

		OfficeImpl officeImpl = new OfficeImpl();

		officeImpl.setNew(office.isNew());
		officeImpl.setPrimaryKey(office.getPrimaryKey());

		officeImpl.setOfficeId(office.getOfficeId());
		officeImpl.setName(office.getName());
		officeImpl.setWww(office.getWww());
		officeImpl.setEmail(office.getEmail());
		officeImpl.setInstitutionId(office.getInstitutionId());

		return officeImpl;
	}

	/**
	 * Returns the office with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the office
	 * @return the office
	 * @throws de.uhh.l2g.plugins.NoSuchOfficeException if a office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Office findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOfficeException, SystemException {
		Office office = fetchByPrimaryKey(primaryKey);

		if (office == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOfficeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return office;
	}

	/**
	 * Returns the office with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchOfficeException} if it could not be found.
	 *
	 * @param officeId the primary key of the office
	 * @return the office
	 * @throws de.uhh.l2g.plugins.NoSuchOfficeException if a office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Office findByPrimaryKey(long officeId)
		throws NoSuchOfficeException, SystemException {
		return findByPrimaryKey((Serializable)officeId);
	}

	/**
	 * Returns the office with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the office
	 * @return the office, or <code>null</code> if a office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Office fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Office office = (Office)EntityCacheUtil.getResult(OfficeModelImpl.ENTITY_CACHE_ENABLED,
				OfficeImpl.class, primaryKey);

		if (office == _nullOffice) {
			return null;
		}

		if (office == null) {
			Session session = null;

			try {
				session = openSession();

				office = (Office)session.get(OfficeImpl.class, primaryKey);

				if (office != null) {
					cacheResult(office);
				}
				else {
					EntityCacheUtil.putResult(OfficeModelImpl.ENTITY_CACHE_ENABLED,
						OfficeImpl.class, primaryKey, _nullOffice);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OfficeModelImpl.ENTITY_CACHE_ENABLED,
					OfficeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return office;
	}

	/**
	 * Returns the office with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param officeId the primary key of the office
	 * @return the office, or <code>null</code> if a office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Office fetchByPrimaryKey(long officeId) throws SystemException {
		return fetchByPrimaryKey((Serializable)officeId);
	}

	/**
	 * Returns all the offices.
	 *
	 * @return the offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Office> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @return the range of offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Office> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Office> findAll(int start, int end,
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

		List<Office> list = (List<Office>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OFFICE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OFFICE;

				if (pagination) {
					sql = sql.concat(OfficeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Office>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Office>(list);
				}
				else {
					list = (List<Office>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the offices from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Office office : findAll()) {
			remove(office);
		}
	}

	/**
	 * Returns the number of offices.
	 *
	 * @return the number of offices
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

				Query q = session.createQuery(_SQL_COUNT_OFFICE);

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
	 * Initializes the office persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Office")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Office>> listenersList = new ArrayList<ModelListener<Office>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Office>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OfficeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OFFICE = "SELECT office FROM Office office";
	private static final String _SQL_SELECT_OFFICE_WHERE = "SELECT office FROM Office office WHERE ";
	private static final String _SQL_COUNT_OFFICE = "SELECT COUNT(office) FROM Office office";
	private static final String _SQL_COUNT_OFFICE_WHERE = "SELECT COUNT(office) FROM Office office WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "office.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Office exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Office exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OfficePersistenceImpl.class);
	private static Office _nullOffice = new OfficeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Office> toCacheModel() {
				return _nullOfficeCacheModel;
			}
		};

	private static CacheModel<Office> _nullOfficeCacheModel = new CacheModel<Office>() {
			@Override
			public Office toEntityModel() {
				return _nullOffice;
			}
		};
}