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

import de.uhh.l2g.plugins.migration.model.LegacyLectureSeries;

/**
 * The persistence interface for the legacy lecture series service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyLectureSeriesPersistenceImpl
 * @see LegacyLectureSeriesUtil
 * @generated
 */
public interface LegacyLectureSeriesPersistence extends BasePersistence<LegacyLectureSeries> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegacyLectureSeriesUtil} to access the legacy lecture series persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the legacy lecture series in the entity cache if it is enabled.
	*
	* @param legacyLectureSeries the legacy lecture series
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeries legacyLectureSeries);

	/**
	* Caches the legacy lecture serieses in the entity cache if it is enabled.
	*
	* @param legacyLectureSerieses the legacy lecture serieses
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeries> legacyLectureSerieses);

	/**
	* Creates a new legacy lecture series with the primary key. Does not add the legacy lecture series to the database.
	*
	* @param id the primary key for the new legacy lecture series
	* @return the new legacy lecture series
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries create(
		long id);

	/**
	* Removes the legacy lecture series with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy lecture series
	* @return the legacy lecture series that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException if a legacy lecture series with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException;

	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeries legacyLectureSeries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legacy lecture series with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException} if it could not be found.
	*
	* @param id the primary key of the legacy lecture series
	* @return the legacy lecture series
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException if a legacy lecture series with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException;

	/**
	* Returns the legacy lecture series with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the legacy lecture series
	* @return the legacy lecture series, or <code>null</code> if a legacy lecture series with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legacy lecture serieses.
	*
	* @return the legacy lecture serieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeries> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legacy lecture serieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy lecture serieses
	* @param end the upper bound of the range of legacy lecture serieses (not inclusive)
	* @return the range of legacy lecture serieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeries> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legacy lecture serieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy lecture serieses
	* @param end the upper bound of the range of legacy lecture serieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacy lecture serieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legacy lecture serieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legacy lecture serieses.
	*
	* @return the number of legacy lecture serieses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}