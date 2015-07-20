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

import com.liferay.portal.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.migration.model.TestEntityTwo;

/**
 * The persistence interface for the test entity two service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see TestEntityTwoPersistenceImpl
 * @see TestEntityTwoUtil
 * @generated
 */
public interface TestEntityTwoPersistence extends BasePersistence<TestEntityTwo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TestEntityTwoUtil} to access the test entity two persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the test entity two in the entity cache if it is enabled.
	*
	* @param testEntityTwo the test entity two
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.migration.model.TestEntityTwo testEntityTwo);

	/**
	* Caches the test entity twos in the entity cache if it is enabled.
	*
	* @param testEntityTwos the test entity twos
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.TestEntityTwo> testEntityTwos);

	/**
	* Creates a new test entity two with the primary key. Does not add the test entity two to the database.
	*
	* @param plid the primary key for the new test entity two
	* @return the new test entity two
	*/
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo create(long plid);

	/**
	* Removes the test entity two with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param plid the primary key of the test entity two
	* @return the test entity two that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException if a test entity two with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo remove(long plid)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException;

	public de.uhh.l2g.plugins.migration.model.TestEntityTwo updateImpl(
		de.uhh.l2g.plugins.migration.model.TestEntityTwo testEntityTwo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the test entity two with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException} if it could not be found.
	*
	* @param plid the primary key of the test entity two
	* @return the test entity two
	* @throws de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException if a test entity two with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo findByPrimaryKey(
		long plid)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchTestEntityTwoException;

	/**
	* Returns the test entity two with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param plid the primary key of the test entity two
	* @return the test entity two, or <code>null</code> if a test entity two with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo fetchByPrimaryKey(
		long plid) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the test entity twos.
	*
	* @return the test entity twos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.TestEntityTwo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.migration.model.TestEntityTwo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.migration.model.TestEntityTwo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the test entity twos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of test entity twos.
	*
	* @return the number of test entity twos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}