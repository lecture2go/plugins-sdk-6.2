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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.model.Statistic;

/**
 * The persistence interface for the statistic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see StatisticPersistenceImpl
 * @see StatisticUtil
 * @generated
 */
public interface StatisticPersistence extends BasePersistence<Statistic> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatisticUtil} to access the statistic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the statistic where statisticId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchStatisticException} if it could not be found.
	*
	* @param statisticId the statistic ID
	* @return the matching statistic
	* @throws de.uhh.l2g.plugins.NoSuchStatisticException if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic findByStatisticId(
		long statisticId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchStatisticException;

	/**
	* Returns the statistic where statisticId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param statisticId the statistic ID
	* @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic fetchByStatisticId(
		long statisticId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the statistic where statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param statisticId the statistic ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic fetchByStatisticId(
		long statisticId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the statistic where statisticId = &#63; from the database.
	*
	* @param statisticId the statistic ID
	* @return the statistic that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic removeByStatisticId(
		long statisticId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchStatisticException;

	/**
	* Returns the number of statistics where statisticId = &#63;.
	*
	* @param statisticId the statistic ID
	* @return the number of matching statistics
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatisticId(long statisticId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchStatisticException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statisticId the statistic ID
	* @return the matching statistic
	* @throws de.uhh.l2g.plugins.NoSuchStatisticException if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic findByC_G_S(long companyId,
		long groupId, long statisticId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchStatisticException;

	/**
	* Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statisticId the statistic ID
	* @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic fetchByC_G_S(long companyId,
		long groupId, long statisticId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statisticId the statistic ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic fetchByC_G_S(long companyId,
		long groupId, long statisticId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statisticId the statistic ID
	* @return the statistic that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic removeByC_G_S(long companyId,
		long groupId, long statisticId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchStatisticException;

	/**
	* Returns the number of statistics where companyId = &#63; and groupId = &#63; and statisticId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param statisticId the statistic ID
	* @return the number of matching statistics
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_S(long companyId, long groupId, long statisticId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchStatisticException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param createDate the create date
	* @return the matching statistic
	* @throws de.uhh.l2g.plugins.NoSuchStatisticException if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic findByC_G_D(long companyId,
		long groupId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchStatisticException;

	/**
	* Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param createDate the create date
	* @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic fetchByC_G_D(long companyId,
		long groupId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param createDate the create date
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic fetchByC_G_D(long companyId,
		long groupId, java.util.Date createDate, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param createDate the create date
	* @return the statistic that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic removeByC_G_D(long companyId,
		long groupId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchStatisticException;

	/**
	* Returns the number of statistics where companyId = &#63; and groupId = &#63; and createDate = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param createDate the create date
	* @return the number of matching statistics
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_D(long companyId, long groupId,
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the statistics where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching statistics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Statistic> findByC_G(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the statistics where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of statistics
	* @param end the upper bound of the range of statistics (not inclusive)
	* @return the range of matching statistics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Statistic> findByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the statistics where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of statistics
	* @param end the upper bound of the range of statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching statistics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Statistic> findByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching statistic
	* @throws de.uhh.l2g.plugins.NoSuchStatisticException if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic findByC_G_First(long companyId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchStatisticException;

	/**
	* Returns the first statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching statistic, or <code>null</code> if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic fetchByC_G_First(long companyId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching statistic
	* @throws de.uhh.l2g.plugins.NoSuchStatisticException if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic findByC_G_Last(long companyId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchStatisticException;

	/**
	* Returns the last statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching statistic, or <code>null</code> if a matching statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic fetchByC_G_Last(long companyId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the statistics before and after the current statistic in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param statisticId the primary key of the current statistic
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next statistic
	* @throws de.uhh.l2g.plugins.NoSuchStatisticException if a statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic[] findByC_G_PrevAndNext(
		long statisticId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchStatisticException;

	/**
	* Removes all the statistics where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of statistics where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching statistics
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the statistic in the entity cache if it is enabled.
	*
	* @param statistic the statistic
	*/
	public void cacheResult(de.uhh.l2g.plugins.model.Statistic statistic);

	/**
	* Caches the statistics in the entity cache if it is enabled.
	*
	* @param statistics the statistics
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Statistic> statistics);

	/**
	* Creates a new statistic with the primary key. Does not add the statistic to the database.
	*
	* @param statisticId the primary key for the new statistic
	* @return the new statistic
	*/
	public de.uhh.l2g.plugins.model.Statistic create(long statisticId);

	/**
	* Removes the statistic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statisticId the primary key of the statistic
	* @return the statistic that was removed
	* @throws de.uhh.l2g.plugins.NoSuchStatisticException if a statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic remove(long statisticId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchStatisticException;

	public de.uhh.l2g.plugins.model.Statistic updateImpl(
		de.uhh.l2g.plugins.model.Statistic statistic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the statistic with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchStatisticException} if it could not be found.
	*
	* @param statisticId the primary key of the statistic
	* @return the statistic
	* @throws de.uhh.l2g.plugins.NoSuchStatisticException if a statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic findByPrimaryKey(long statisticId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchStatisticException;

	/**
	* Returns the statistic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param statisticId the primary key of the statistic
	* @return the statistic, or <code>null</code> if a statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Statistic fetchByPrimaryKey(
		long statisticId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the statistics.
	*
	* @return the statistics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Statistic> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statistics
	* @param end the upper bound of the range of statistics (not inclusive)
	* @return the range of statistics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Statistic> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statistics
	* @param end the upper bound of the range of statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of statistics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Statistic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the statistics from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of statistics.
	*
	* @return the number of statistics
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}