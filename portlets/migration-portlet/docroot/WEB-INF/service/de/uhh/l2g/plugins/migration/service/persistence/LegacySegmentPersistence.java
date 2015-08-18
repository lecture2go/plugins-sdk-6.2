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

import de.uhh.l2g.plugins.migration.model.LegacySegment;

/**
 * The persistence interface for the legacy segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacySegmentPersistenceImpl
 * @see LegacySegmentUtil
 * @generated
 */
public interface LegacySegmentPersistence extends BasePersistence<LegacySegment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegacySegmentUtil} to access the legacy segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the legacy segment in the entity cache if it is enabled.
	*
	* @param legacySegment the legacy segment
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacySegment legacySegment);

	/**
	* Caches the legacy segments in the entity cache if it is enabled.
	*
	* @param legacySegments the legacy segments
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacySegment> legacySegments);

	/**
	* Creates a new legacy segment with the primary key. Does not add the legacy segment to the database.
	*
	* @param id the primary key for the new legacy segment
	* @return the new legacy segment
	*/
	public de.uhh.l2g.plugins.migration.model.LegacySegment create(long id);

	/**
	* Removes the legacy segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy segment
	* @return the legacy segment that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacySegmentException if a legacy segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacySegment remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacySegmentException;

	public de.uhh.l2g.plugins.migration.model.LegacySegment updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacySegment legacySegment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legacy segment with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacySegmentException} if it could not be found.
	*
	* @param id the primary key of the legacy segment
	* @return the legacy segment
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacySegmentException if a legacy segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacySegment findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacySegmentException;

	/**
	* Returns the legacy segment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the legacy segment
	* @return the legacy segment, or <code>null</code> if a legacy segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacySegment fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legacy segments.
	*
	* @return the legacy segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacySegment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legacy segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacySegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy segments
	* @param end the upper bound of the range of legacy segments (not inclusive)
	* @return the range of legacy segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacySegment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legacy segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacySegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy segments
	* @param end the upper bound of the range of legacy segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacy segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacySegment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legacy segments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legacy segments.
	*
	* @return the number of legacy segments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}