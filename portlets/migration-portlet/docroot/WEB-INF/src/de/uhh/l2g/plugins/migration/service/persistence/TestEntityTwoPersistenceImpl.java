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

import de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException;
import de.uhh.l2g.plugins.migration.model.TestEntityTwo;
import de.uhh.l2g.plugins.migration.model.impl.TestEntityTwoImpl;
import de.uhh.l2g.plugins.migration.model.impl.TestEntityTwoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the test entity two service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see TestEntityTwoPersistence
 * @see TestEntityTwoUtil
 * @generated
 */
public class TestEntityTwoPersistenceImpl extends BasePersistenceImpl<TestEntityTwo>
	implements TestEntityTwoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TestEntityTwoUtil} to access the test entity two persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TestEntityTwoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TestEntityTwoModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityTwoModelImpl.FINDER_CACHE_ENABLED,
			TestEntityTwoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TestEntityTwoModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityTwoModelImpl.FINDER_CACHE_ENABLED,
			TestEntityTwoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TestEntityTwoModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityTwoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TestEntityTwoPersistenceImpl() {
		setModelClass(TestEntityTwo.class);
	}

	/**
	 * Caches the test entity two in the entity cache if it is enabled.
	 *
	 * @param testEntityTwo the test entity two
	 */
	@Override
	public void cacheResult(TestEntityTwo testEntityTwo) {
		EntityCacheUtil.putResult(TestEntityTwoModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityTwoImpl.class, testEntityTwo.getPrimaryKey(),
			testEntityTwo);

		testEntityTwo.resetOriginalValues();
	}

	/**
	 * Caches the test entity twos in the entity cache if it is enabled.
	 *
	 * @param testEntityTwos the test entity twos
	 */
	@Override
	public void cacheResult(List<TestEntityTwo> testEntityTwos) {
		for (TestEntityTwo testEntityTwo : testEntityTwos) {
			if (EntityCacheUtil.getResult(
						TestEntityTwoModelImpl.ENTITY_CACHE_ENABLED,
						TestEntityTwoImpl.class, testEntityTwo.getPrimaryKey()) == null) {
				cacheResult(testEntityTwo);
			}
			else {
				testEntityTwo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all test entity twos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TestEntityTwoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TestEntityTwoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the test entity two.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TestEntityTwo testEntityTwo) {
		EntityCacheUtil.removeResult(TestEntityTwoModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityTwoImpl.class, testEntityTwo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TestEntityTwo> testEntityTwos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TestEntityTwo testEntityTwo : testEntityTwos) {
			EntityCacheUtil.removeResult(TestEntityTwoModelImpl.ENTITY_CACHE_ENABLED,
				TestEntityTwoImpl.class, testEntityTwo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new test entity two with the primary key. Does not add the test entity two to the database.
	 *
	 * @param plid the primary key for the new test entity two
	 * @return the new test entity two
	 */
	@Override
	public TestEntityTwo create(long plid) {
		TestEntityTwo testEntityTwo = new TestEntityTwoImpl();

		testEntityTwo.setNew(true);
		testEntityTwo.setPrimaryKey(plid);

		return testEntityTwo;
	}

	/**
	 * Removes the test entity two with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param plid the primary key of the test entity two
	 * @return the test entity two that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException if a test entity two with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntityTwo remove(long plid)
		throws NoSuchTestEntityTwoException, SystemException {
		return remove((Serializable)plid);
	}

	/**
	 * Removes the test entity two with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the test entity two
	 * @return the test entity two that was removed
	 * @throws de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException if a test entity two with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntityTwo remove(Serializable primaryKey)
		throws NoSuchTestEntityTwoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TestEntityTwo testEntityTwo = (TestEntityTwo)session.get(TestEntityTwoImpl.class,
					primaryKey);

			if (testEntityTwo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTestEntityTwoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(testEntityTwo);
		}
		catch (NoSuchTestEntityTwoException nsee) {
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
	protected TestEntityTwo removeImpl(TestEntityTwo testEntityTwo)
		throws SystemException {
		testEntityTwo = toUnwrappedModel(testEntityTwo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(testEntityTwo)) {
				testEntityTwo = (TestEntityTwo)session.get(TestEntityTwoImpl.class,
						testEntityTwo.getPrimaryKeyObj());
			}

			if (testEntityTwo != null) {
				session.delete(testEntityTwo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (testEntityTwo != null) {
			clearCache(testEntityTwo);
		}

		return testEntityTwo;
	}

	@Override
	public TestEntityTwo updateImpl(
		de.uhh.l2g.plugins.migration.model.TestEntityTwo testEntityTwo)
		throws SystemException {
		testEntityTwo = toUnwrappedModel(testEntityTwo);

		boolean isNew = testEntityTwo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (testEntityTwo.isNew()) {
				session.save(testEntityTwo);

				testEntityTwo.setNew(false);
			}
			else {
				session.merge(testEntityTwo);
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

		EntityCacheUtil.putResult(TestEntityTwoModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityTwoImpl.class, testEntityTwo.getPrimaryKey(),
			testEntityTwo);

		return testEntityTwo;
	}

	protected TestEntityTwo toUnwrappedModel(TestEntityTwo testEntityTwo) {
		if (testEntityTwo instanceof TestEntityTwoImpl) {
			return testEntityTwo;
		}

		TestEntityTwoImpl testEntityTwoImpl = new TestEntityTwoImpl();

		testEntityTwoImpl.setNew(testEntityTwo.isNew());
		testEntityTwoImpl.setPrimaryKey(testEntityTwo.getPrimaryKey());

		testEntityTwoImpl.setPlid(testEntityTwo.getPlid());
		testEntityTwoImpl.setGroupId(testEntityTwo.getGroupId());
		testEntityTwoImpl.setCompanyId(testEntityTwo.getCompanyId());

		return testEntityTwoImpl;
	}

	/**
	 * Returns the test entity two with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the test entity two
	 * @return the test entity two
	 * @throws de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException if a test entity two with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntityTwo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTestEntityTwoException, SystemException {
		TestEntityTwo testEntityTwo = fetchByPrimaryKey(primaryKey);

		if (testEntityTwo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTestEntityTwoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return testEntityTwo;
	}

	/**
	 * Returns the test entity two with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException} if it could not be found.
	 *
	 * @param plid the primary key of the test entity two
	 * @return the test entity two
	 * @throws de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException if a test entity two with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntityTwo findByPrimaryKey(long plid)
		throws NoSuchTestEntityTwoException, SystemException {
		return findByPrimaryKey((Serializable)plid);
	}

	/**
	 * Returns the test entity two with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the test entity two
	 * @return the test entity two, or <code>null</code> if a test entity two with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntityTwo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TestEntityTwo testEntityTwo = (TestEntityTwo)EntityCacheUtil.getResult(TestEntityTwoModelImpl.ENTITY_CACHE_ENABLED,
				TestEntityTwoImpl.class, primaryKey);

		if (testEntityTwo == _nullTestEntityTwo) {
			return null;
		}

		if (testEntityTwo == null) {
			Session session = null;

			try {
				session = openSession();

				testEntityTwo = (TestEntityTwo)session.get(TestEntityTwoImpl.class,
						primaryKey);

				if (testEntityTwo != null) {
					cacheResult(testEntityTwo);
				}
				else {
					EntityCacheUtil.putResult(TestEntityTwoModelImpl.ENTITY_CACHE_ENABLED,
						TestEntityTwoImpl.class, primaryKey, _nullTestEntityTwo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TestEntityTwoModelImpl.ENTITY_CACHE_ENABLED,
					TestEntityTwoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return testEntityTwo;
	}

	/**
	 * Returns the test entity two with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param plid the primary key of the test entity two
	 * @return the test entity two, or <code>null</code> if a test entity two with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntityTwo fetchByPrimaryKey(long plid) throws SystemException {
		return fetchByPrimaryKey((Serializable)plid);
	}

	/**
	 * Returns all the test entity twos.
	 *
	 * @return the test entity twos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestEntityTwo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the test entity twos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.TestEntityTwoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of test entity twos
	 * @param end the upper bound of the range of test entity twos (not inclusive)
	 * @return the range of test entity twos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestEntityTwo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the test entity twos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.TestEntityTwoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of test entity twos
	 * @param end the upper bound of the range of test entity twos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of test entity twos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestEntityTwo> findAll(int start, int end,
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

		List<TestEntityTwo> list = (List<TestEntityTwo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TESTENTITYTWO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TESTENTITYTWO;

				if (pagination) {
					sql = sql.concat(TestEntityTwoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TestEntityTwo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TestEntityTwo>(list);
				}
				else {
					list = (List<TestEntityTwo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the test entity twos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TestEntityTwo testEntityTwo : findAll()) {
			remove(testEntityTwo);
		}
	}

	/**
	 * Returns the number of test entity twos.
	 *
	 * @return the number of test entity twos
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

				Query q = session.createQuery(_SQL_COUNT_TESTENTITYTWO);

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
	 * Initializes the test entity two persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.migration.model.TestEntityTwo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TestEntityTwo>> listenersList = new ArrayList<ModelListener<TestEntityTwo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TestEntityTwo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TestEntityTwoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TESTENTITYTWO = "SELECT testEntityTwo FROM TestEntityTwo testEntityTwo";
	private static final String _SQL_COUNT_TESTENTITYTWO = "SELECT COUNT(testEntityTwo) FROM TestEntityTwo testEntityTwo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "testEntityTwo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TestEntityTwo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TestEntityTwoPersistenceImpl.class);
	private static TestEntityTwo _nullTestEntityTwo = new TestEntityTwoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TestEntityTwo> toCacheModel() {
				return _nullTestEntityTwoCacheModel;
			}
		};

	private static CacheModel<TestEntityTwo> _nullTestEntityTwoCacheModel = new CacheModel<TestEntityTwo>() {
			@Override
			public TestEntityTwo toEntityModel() {
				return _nullTestEntityTwo;
			}
		};
}