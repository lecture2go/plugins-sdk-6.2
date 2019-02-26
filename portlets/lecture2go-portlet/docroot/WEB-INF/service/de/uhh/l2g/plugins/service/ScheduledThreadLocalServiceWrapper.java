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

package de.uhh.l2g.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScheduledThreadLocalService}.
 *
 * @author Iavor Sturm
 * @see ScheduledThreadLocalService
 * @generated
 */
public class ScheduledThreadLocalServiceWrapper
	implements ScheduledThreadLocalService,
		ServiceWrapper<ScheduledThreadLocalService> {
	public ScheduledThreadLocalServiceWrapper(
		ScheduledThreadLocalService scheduledThreadLocalService) {
		_scheduledThreadLocalService = scheduledThreadLocalService;
	}

	/**
	* Adds the scheduled thread to the database. Also notifies the appropriate model listeners.
	*
	* @param scheduledThread the scheduled thread
	* @return the scheduled thread that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread addScheduledThread(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.addScheduledThread(scheduledThread);
	}

	/**
	* Creates a new scheduled thread with the primary key. Does not add the scheduled thread to the database.
	*
	* @param scheduledThreadId the primary key for the new scheduled thread
	* @return the new scheduled thread
	*/
	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread createScheduledThread(
		long scheduledThreadId) {
		return _scheduledThreadLocalService.createScheduledThread(scheduledThreadId);
	}

	/**
	* Deletes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduledThreadId the primary key of the scheduled thread
	* @return the scheduled thread that was removed
	* @throws PortalException if a scheduled thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread deleteScheduledThread(
		long scheduledThreadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.deleteScheduledThread(scheduledThreadId);
	}

	/**
	* Deletes the scheduled thread from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduledThread the scheduled thread
	* @return the scheduled thread that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread deleteScheduledThread(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.deleteScheduledThread(scheduledThread);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scheduledThreadLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ScheduledThreadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ScheduledThreadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread fetchScheduledThread(
		long scheduledThreadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.fetchScheduledThread(scheduledThreadId);
	}

	/**
	* Returns the scheduled thread with the primary key.
	*
	* @param scheduledThreadId the primary key of the scheduled thread
	* @return the scheduled thread
	* @throws PortalException if a scheduled thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread getScheduledThread(
		long scheduledThreadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.getScheduledThread(scheduledThreadId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.ScheduledThread> getScheduledThreads(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.getScheduledThreads(start, end);
	}

	/**
	* Returns the number of scheduled threads.
	*
	* @return the number of scheduled threads
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getScheduledThreadsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.getScheduledThreadsCount();
	}

	/**
	* Updates the scheduled thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scheduledThread the scheduled thread
	* @return the scheduled thread that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread updateScheduledThread(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.updateScheduledThread(scheduledThread);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scheduledThreadLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scheduledThreadLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scheduledThreadLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String getCronBySchedulerName(
		java.lang.String schedulerClassName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.getCronBySchedulerName(schedulerClassName);
	}

	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread addScheduledThread(
		java.lang.String schedulerClassName, java.lang.String cronText,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.addScheduledThread(schedulerClassName,
			cronText, serviceContext);
	}

	@Override
	public de.uhh.l2g.plugins.model.ScheduledThread updateScheduledThread(
		java.lang.String schedulerClassName, java.lang.String cronText,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduledThreadLocalService.updateScheduledThread(schedulerClassName,
			cronText, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScheduledThreadLocalService getWrappedScheduledThreadLocalService() {
		return _scheduledThreadLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScheduledThreadLocalService(
		ScheduledThreadLocalService scheduledThreadLocalService) {
		_scheduledThreadLocalService = scheduledThreadLocalService;
	}

	@Override
	public ScheduledThreadLocalService getWrappedService() {
		return _scheduledThreadLocalService;
	}

	@Override
	public void setWrappedService(
		ScheduledThreadLocalService scheduledThreadLocalService) {
		_scheduledThreadLocalService = scheduledThreadLocalService;
	}

	private ScheduledThreadLocalService _scheduledThreadLocalService;
}