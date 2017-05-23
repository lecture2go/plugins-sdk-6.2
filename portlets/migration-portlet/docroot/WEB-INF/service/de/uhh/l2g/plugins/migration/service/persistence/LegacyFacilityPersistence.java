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

import de.uhh.l2g.plugins.migration.model.LegacyFacility;

/**
 * The persistence interface for the legacy facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyFacilityPersistenceImpl
 * @see LegacyFacilityUtil
 * @generated
 */
public interface LegacyFacilityPersistence extends BasePersistence<LegacyFacility> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegacyFacilityUtil} to access the legacy facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the legacy facility in the entity cache if it is enabled.
	*
	* @param legacyFacility the legacy facility
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacyFacility legacyFacility);

	/**
	* Caches the legacy facilities in the entity cache if it is enabled.
	*
	* @param legacyFacilities the legacy facilities
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacyFacility> legacyFacilities);

	/**
	* Creates a new legacy facility with the primary key. Does not add the legacy facility to the database.
	*
	* @param id the primary key for the new legacy facility
	* @return the new legacy facility
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyFacility create(long id);

	/**
	* Removes the legacy facility with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy facility
	* @return the legacy facility that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException if a legacy facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyFacility remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException;

	public de.uhh.l2g.plugins.migration.model.LegacyFacility updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyFacility legacyFacility)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legacy facility with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException} if it could not be found.
	*
	* @param id the primary key of the legacy facility
	* @return the legacy facility
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException if a legacy facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyFacility findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException;

	/**
	* Returns the legacy facility with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the legacy facility
	* @return the legacy facility, or <code>null</code> if a legacy facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyFacility fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legacy facilities.
	*
	* @return the legacy facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyFacility> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legacy facilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy facilities
	* @param end the upper bound of the range of legacy facilities (not inclusive)
	* @return the range of legacy facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyFacility> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legacy facilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy facilities
	* @param end the upper bound of the range of legacy facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacy facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyFacility> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legacy facilities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legacy facilities.
	*
	* @return the number of legacy facilities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}