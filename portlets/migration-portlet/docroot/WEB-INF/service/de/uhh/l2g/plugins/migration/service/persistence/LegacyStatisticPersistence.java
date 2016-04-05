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

import de.uhh.l2g.plugins.migration.model.LegacyStatistic;

/**
 * The persistence interface for the legacy statistic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyStatisticPersistenceImpl
 * @see LegacyStatisticUtil
 * @generated
 */
public interface LegacyStatisticPersistence extends BasePersistence<LegacyStatistic> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegacyStatisticUtil} to access the legacy statistic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the legacy statistic in the entity cache if it is enabled.
	*
	* @param legacyStatistic the legacy statistic
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacyStatistic legacyStatistic);

	/**
	* Caches the legacy statistics in the entity cache if it is enabled.
	*
	* @param legacyStatistics the legacy statistics
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacyStatistic> legacyStatistics);

	/**
	* Creates a new legacy statistic with the primary key. Does not add the legacy statistic to the database.
	*
	* @param id the primary key for the new legacy statistic
	* @return the new legacy statistic
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyStatistic create(int id);

	/**
	* Removes the legacy statistic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy statistic
	* @return the legacy statistic that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticException if a legacy statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyStatistic remove(int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticException;

	public de.uhh.l2g.plugins.migration.model.LegacyStatistic updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyStatistic legacyStatistic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legacy statistic with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticException} if it could not be found.
	*
	* @param id the primary key of the legacy statistic
	* @return the legacy statistic
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticException if a legacy statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyStatistic findByPrimaryKey(
		int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyStatisticException;

	/**
	* Returns the legacy statistic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the legacy statistic
	* @return the legacy statistic, or <code>null</code> if a legacy statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyStatistic fetchByPrimaryKey(
		int id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legacy statistics.
	*
	* @return the legacy statistics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyStatistic> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legacy statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy statistics
	* @param end the upper bound of the range of legacy statistics (not inclusive)
	* @return the range of legacy statistics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyStatistic> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legacy statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy statistics
	* @param end the upper bound of the range of legacy statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacy statistics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyStatistic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legacy statistics from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legacy statistics.
	*
	* @return the number of legacy statistics
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}