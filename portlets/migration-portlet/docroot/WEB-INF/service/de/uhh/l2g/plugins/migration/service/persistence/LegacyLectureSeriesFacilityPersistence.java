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

import de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility;

/**
 * The persistence interface for the legacy lecture series facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyLectureSeriesFacilityPersistenceImpl
 * @see LegacyLectureSeriesFacilityUtil
 * @generated
 */
public interface LegacyLectureSeriesFacilityPersistence extends BasePersistence<LegacyLectureSeriesFacility> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegacyLectureSeriesFacilityUtil} to access the legacy lecture series facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the legacy lecture series facility in the entity cache if it is enabled.
	*
	* @param legacyLectureSeriesFacility the legacy lecture series facility
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility legacyLectureSeriesFacility);

	/**
	* Caches the legacy lecture series facilities in the entity cache if it is enabled.
	*
	* @param legacyLectureSeriesFacilities the legacy lecture series facilities
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility> legacyLectureSeriesFacilities);

	/**
	* Creates a new legacy lecture series facility with the primary key. Does not add the legacy lecture series facility to the database.
	*
	* @param facilityId the primary key for the new legacy lecture series facility
	* @return the new legacy lecture series facility
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility create(
		long facilityId);

	/**
	* Removes the legacy lecture series facility with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param facilityId the primary key of the legacy lecture series facility
	* @return the legacy lecture series facility that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException if a legacy lecture series facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility remove(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException;

	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility legacyLectureSeriesFacility)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legacy lecture series facility with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException} if it could not be found.
	*
	* @param facilityId the primary key of the legacy lecture series facility
	* @return the legacy lecture series facility
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException if a legacy lecture series facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility findByPrimaryKey(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException;

	/**
	* Returns the legacy lecture series facility with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param facilityId the primary key of the legacy lecture series facility
	* @return the legacy lecture series facility, or <code>null</code> if a legacy lecture series facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility fetchByPrimaryKey(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legacy lecture series facilities.
	*
	* @return the legacy lecture series facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legacy lecture series facilities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legacy lecture series facilities.
	*
	* @return the number of legacy lecture series facilities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}