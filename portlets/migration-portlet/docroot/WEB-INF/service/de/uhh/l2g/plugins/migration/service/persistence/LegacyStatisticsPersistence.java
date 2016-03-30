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

import de.uhh.l2g.plugins.migration.model.LegacyStatistics;

/**
 * The persistence interface for the legacy statistics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyStatisticsPersistenceImpl
 * @see LegacyStatisticsUtil
 * @generated
 */
public interface LegacyStatisticsPersistence extends BasePersistence<LegacyStatistics> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegacyStatisticsUtil} to access the legacy statistics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the legacy statistics in the entity cache if it is enabled.
	*
	* @param legacyStatistics the legacy statistics
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacyStatistics legacyStatistics);

	/**
	* Caches the legacy statisticses in the entity cache if it is enabled.
	*
	* @param legacyStatisticses the legacy statisticses
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacyStatistics> legacyStatisticses);

	/**
	* Creates a new legacy statistics with the primary key. Does not add the legacy statistics to the database.
	*
	* @param id the primary key for the new legacy statistics
	* @return the new legacy statistics
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyStatistics create(int id);

	/**
	* Removes the legacy statistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy statistics
	* @return the legacy statistics that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticsException if a legacy statistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyStatistics remove(int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticsException;

	public de.uhh.l2g.plugins.migration.model.LegacyStatistics updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyStatistics legacyStatistics)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legacy statistics with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticsException} if it could not be found.
	*
	* @param id the primary key of the legacy statistics
	* @return the legacy statistics
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticsException if a legacy statistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyStatistics findByPrimaryKey(
		int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticsException;

	/**
	* Returns the legacy statistics with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the legacy statistics
	* @return the legacy statistics, or <code>null</code> if a legacy statistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyStatistics fetchByPrimaryKey(
		int id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legacy statisticses.
	*
	* @return the legacy statisticses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyStatistics> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legacy statisticses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy statisticses
	* @param end the upper bound of the range of legacy statisticses (not inclusive)
	* @return the range of legacy statisticses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyStatistics> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legacy statisticses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy statisticses
	* @param end the upper bound of the range of legacy statisticses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacy statisticses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyStatistics> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legacy statisticses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legacy statisticses.
	*
	* @return the number of legacy statisticses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}