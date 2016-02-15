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

import de.uhh.l2g.plugins.migration.model.LegacyCoordinator;

/**
 * The persistence interface for the legacy coordinator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyCoordinatorPersistenceImpl
 * @see LegacyCoordinatorUtil
 * @generated
 */
public interface LegacyCoordinatorPersistence extends BasePersistence<LegacyCoordinator> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegacyCoordinatorUtil} to access the legacy coordinator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the legacy coordinator in the entity cache if it is enabled.
	*
	* @param legacyCoordinator the legacy coordinator
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacyCoordinator legacyCoordinator);

	/**
	* Caches the legacy coordinators in the entity cache if it is enabled.
	*
	* @param legacyCoordinators the legacy coordinators
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacyCoordinator> legacyCoordinators);

	/**
	* Creates a new legacy coordinator with the primary key. Does not add the legacy coordinator to the database.
	*
	* @param userId the primary key for the new legacy coordinator
	* @return the new legacy coordinator
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyCoordinator create(
		long userId);

	/**
	* Removes the legacy coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the legacy coordinator
	* @return the legacy coordinator that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException if a legacy coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyCoordinator remove(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException;

	public de.uhh.l2g.plugins.migration.model.LegacyCoordinator updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyCoordinator legacyCoordinator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legacy coordinator with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException} if it could not be found.
	*
	* @param userId the primary key of the legacy coordinator
	* @return the legacy coordinator
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException if a legacy coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyCoordinator findByPrimaryKey(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException;

	/**
	* Returns the legacy coordinator with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the legacy coordinator
	* @return the legacy coordinator, or <code>null</code> if a legacy coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyCoordinator fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legacy coordinators.
	*
	* @return the legacy coordinators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyCoordinator> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legacy coordinators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyCoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy coordinators
	* @param end the upper bound of the range of legacy coordinators (not inclusive)
	* @return the range of legacy coordinators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyCoordinator> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legacy coordinators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyCoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy coordinators
	* @param end the upper bound of the range of legacy coordinators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacy coordinators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyCoordinator> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legacy coordinators from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legacy coordinators.
	*
	* @return the number of legacy coordinators
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}