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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.model.ScheduledThread;

import java.util.List;

/**
 * The persistence utility for the scheduled thread service. This utility wraps {@link ScheduledThreadPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ScheduledThreadPersistence
 * @see ScheduledThreadPersistenceImpl
 * @generated
 */
public class ScheduledThreadUtil {
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
	public static void clearCache(ScheduledThread scheduledThread) {
		getPersistence().clearCache(scheduledThread);
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
	public static List<ScheduledThread> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ScheduledThread> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ScheduledThread> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ScheduledThread update(ScheduledThread scheduledThread)
		throws SystemException {
		return getPersistence().update(scheduledThread);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ScheduledThread update(ScheduledThread scheduledThread,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(scheduledThread, serviceContext);
	}

	/**
	* Returns the scheduled thread where schedulerClassName = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchScheduledThreadException} if it could not be found.
	*
	* @param schedulerClassName the scheduler class name
	* @return the matching scheduled thread
	* @throws de.uhh.l2g.plugins.NoSuchScheduledThreadException if a matching scheduled thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread findBySchedulerClassName(
		java.lang.String schedulerClassName)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchScheduledThreadException {
		return getPersistence().findBySchedulerClassName(schedulerClassName);
	}

	/**
	* Returns the scheduled thread where schedulerClassName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param schedulerClassName the scheduler class name
	* @return the matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread fetchBySchedulerClassName(
		java.lang.String schedulerClassName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySchedulerClassName(schedulerClassName);
	}

	/**
	* Returns the scheduled thread where schedulerClassName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param schedulerClassName the scheduler class name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread fetchBySchedulerClassName(
		java.lang.String schedulerClassName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySchedulerClassName(schedulerClassName,
			retrieveFromCache);
	}

	/**
	* Removes the scheduled thread where schedulerClassName = &#63; from the database.
	*
	* @param schedulerClassName the scheduler class name
	* @return the scheduled thread that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread removeBySchedulerClassName(
		java.lang.String schedulerClassName)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchScheduledThreadException {
		return getPersistence().removeBySchedulerClassName(schedulerClassName);
	}

	/**
	* Returns the number of scheduled threads where schedulerClassName = &#63;.
	*
	* @param schedulerClassName the scheduler class name
	* @return the number of matching scheduled threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySchedulerClassName(
		java.lang.String schedulerClassName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySchedulerClassName(schedulerClassName);
	}

	/**
	* Caches the scheduled thread in the entity cache if it is enabled.
	*
	* @param scheduledThread the scheduled thread
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread) {
		getPersistence().cacheResult(scheduledThread);
	}

	/**
	* Caches the scheduled threads in the entity cache if it is enabled.
	*
	* @param scheduledThreads the scheduled threads
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.ScheduledThread> scheduledThreads) {
		getPersistence().cacheResult(scheduledThreads);
	}

	/**
	* Creates a new scheduled thread with the primary key. Does not add the scheduled thread to the database.
	*
	* @param scheduledThreadId the primary key for the new scheduled thread
	* @return the new scheduled thread
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread create(
		long scheduledThreadId) {
		return getPersistence().create(scheduledThreadId);
	}

	/**
	* Removes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduledThreadId the primary key of the scheduled thread
	* @return the scheduled thread that was removed
	* @throws de.uhh.l2g.plugins.NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread remove(
		long scheduledThreadId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchScheduledThreadException {
		return getPersistence().remove(scheduledThreadId);
	}

	public static de.uhh.l2g.plugins.model.ScheduledThread updateImpl(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(scheduledThread);
	}

	/**
	* Returns the scheduled thread with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchScheduledThreadException} if it could not be found.
	*
	* @param scheduledThreadId the primary key of the scheduled thread
	* @return the scheduled thread
	* @throws de.uhh.l2g.plugins.NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread findByPrimaryKey(
		long scheduledThreadId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchScheduledThreadException {
		return getPersistence().findByPrimaryKey(scheduledThreadId);
	}

	/**
	* Returns the scheduled thread with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scheduledThreadId the primary key of the scheduled thread
	* @return the scheduled thread, or <code>null</code> if a scheduled thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread fetchByPrimaryKey(
		long scheduledThreadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(scheduledThreadId);
	}

	/**
	* Returns all the scheduled threads.
	*
	* @return the scheduled threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ScheduledThread> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the scheduled threads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ScheduledThreadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scheduled threads
	* @param end the upper bound of the range of scheduled threads (not inclusive)
	* @return the range of scheduled threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ScheduledThread> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the scheduled threads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ScheduledThreadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scheduled threads
	* @param end the upper bound of the range of scheduled threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of scheduled threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ScheduledThread> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the scheduled threads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of scheduled threads.
	*
	* @return the number of scheduled threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ScheduledThreadPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ScheduledThreadPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					ScheduledThreadPersistence.class.getName());

			ReferenceRegistry.registerReference(ScheduledThreadUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ScheduledThreadPersistence persistence) {
	}

	private static ScheduledThreadPersistence _persistence;
}