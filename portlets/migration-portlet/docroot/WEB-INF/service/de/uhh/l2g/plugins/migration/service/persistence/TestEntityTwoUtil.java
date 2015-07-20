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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.migration.model.TestEntityTwo;

import java.util.List;

/**
 * The persistence utility for the test entity two service. This utility wraps {@link TestEntityTwoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see TestEntityTwoPersistence
 * @see TestEntityTwoPersistenceImpl
 * @generated
 */
public class TestEntityTwoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TestEntityTwo testEntityTwo) {
		getPersistence().clearCache(testEntityTwo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TestEntityTwo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TestEntityTwo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TestEntityTwo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TestEntityTwo update(TestEntityTwo testEntityTwo)
		throws SystemException {
		return getPersistence().update(testEntityTwo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TestEntityTwo update(TestEntityTwo testEntityTwo,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(testEntityTwo, serviceContext);
	}

	/**
	* Caches the test entity two in the entity cache if it is enabled.
	*
	* @param testEntityTwo the test entity two
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.migration.model.TestEntityTwo testEntityTwo) {
		getPersistence().cacheResult(testEntityTwo);
	}

	/**
	* Caches the test entity twos in the entity cache if it is enabled.
	*
	* @param testEntityTwos the test entity twos
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.TestEntityTwo> testEntityTwos) {
		getPersistence().cacheResult(testEntityTwos);
	}

	/**
	* Creates a new test entity two with the primary key. Does not add the test entity two to the database.
	*
	* @param plid the primary key for the new test entity two
	* @return the new test entity two
	*/
	public static de.uhh.l2g.plugins.migration.model.TestEntityTwo create(
		long plid) {
		return getPersistence().create(plid);
	}

	/**
	* Removes the test entity two with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param plid the primary key of the test entity two
	* @return the test entity two that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException if a test entity two with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.TestEntityTwo remove(
		long plid)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException {
		return getPersistence().remove(plid);
	}

	public static de.uhh.l2g.plugins.migration.model.TestEntityTwo updateImpl(
		de.uhh.l2g.plugins.migration.model.TestEntityTwo testEntityTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(testEntityTwo);
	}

	/**
	* Returns the test entity two with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException} if it could not be found.
	*
	* @param plid the primary key of the test entity two
	* @return the test entity two
	* @throws de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException if a test entity two with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.TestEntityTwo findByPrimaryKey(
		long plid)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException {
		return getPersistence().findByPrimaryKey(plid);
	}

	/**
	* Returns the test entity two with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param plid the primary key of the test entity two
	* @return the test entity two, or <code>null</code> if a test entity two with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.TestEntityTwo fetchByPrimaryKey(
		long plid) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(plid);
	}

	/**
	* Returns all the test entity twos.
	*
	* @return the test entity twos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.TestEntityTwo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<de.uhh.l2g.plugins.migration.model.TestEntityTwo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<de.uhh.l2g.plugins.migration.model.TestEntityTwo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the test entity twos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of test entity twos.
	*
	* @return the number of test entity twos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TestEntityTwoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TestEntityTwoPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.migration.service.ClpSerializer.getServletContextName(),
					TestEntityTwoPersistence.class.getName());

			ReferenceRegistry.registerReference(TestEntityTwoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TestEntityTwoPersistence persistence) {
	}

	private static TestEntityTwoPersistence _persistence;
}