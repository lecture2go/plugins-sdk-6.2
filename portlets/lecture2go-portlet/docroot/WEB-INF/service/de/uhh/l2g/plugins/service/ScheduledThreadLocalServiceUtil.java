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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ScheduledThread. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.ScheduledThreadLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see ScheduledThreadLocalService
 * @see de.uhh.l2g.plugins.service.base.ScheduledThreadLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.ScheduledThreadLocalServiceImpl
 * @generated
 */
public class ScheduledThreadLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.ScheduledThreadLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the scheduled thread to the database. Also notifies the appropriate model listeners.
	*
	* @param scheduledThread the scheduled thread
	* @return the scheduled thread that was added
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread addScheduledThread(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addScheduledThread(scheduledThread);
	}

	/**
	* Creates a new scheduled thread with the primary key. Does not add the scheduled thread to the database.
	*
	* @param scheduledThreadId the primary key for the new scheduled thread
	* @return the new scheduled thread
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread createScheduledThread(
		long scheduledThreadId) {
		return getService().createScheduledThread(scheduledThreadId);
	}

	/**
	* Deletes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduledThreadId the primary key of the scheduled thread
	* @return the scheduled thread that was removed
	* @throws PortalException if a scheduled thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread deleteScheduledThread(
		long scheduledThreadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteScheduledThread(scheduledThreadId);
	}

	/**
	* Deletes the scheduled thread from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduledThread the scheduled thread
	* @return the scheduled thread that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread deleteScheduledThread(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteScheduledThread(scheduledThread);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static de.uhh.l2g.plugins.model.ScheduledThread fetchScheduledThread(
		long scheduledThreadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchScheduledThread(scheduledThreadId);
	}

	/**
	* Returns the scheduled thread with the primary key.
	*
	* @param scheduledThreadId the primary key of the scheduled thread
	* @return the scheduled thread
	* @throws PortalException if a scheduled thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread getScheduledThread(
		long scheduledThreadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getScheduledThread(scheduledThreadId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<de.uhh.l2g.plugins.model.ScheduledThread> getScheduledThreads(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScheduledThreads(start, end);
	}

	/**
	* Returns the number of scheduled threads.
	*
	* @return the number of scheduled threads
	* @throws SystemException if a system exception occurred
	*/
	public static int getScheduledThreadsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScheduledThreadsCount();
	}

	/**
	* Updates the scheduled thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scheduledThread the scheduled thread
	* @return the scheduled thread that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ScheduledThread updateScheduledThread(
		de.uhh.l2g.plugins.model.ScheduledThread scheduledThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateScheduledThread(scheduledThread);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.lang.String getCronBySchedulerName(
		java.lang.String schedulerClassName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCronBySchedulerName(schedulerClassName);
	}

	public static de.uhh.l2g.plugins.model.ScheduledThread addScheduledThread(
		java.lang.String schedulerClassName, java.lang.String cronText,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addScheduledThread(schedulerClassName, cronText,
			serviceContext);
	}

	public static de.uhh.l2g.plugins.model.ScheduledThread updateScheduledThread(
		java.lang.String schedulerClassName, java.lang.String cronText,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateScheduledThread(schedulerClassName, cronText,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ScheduledThreadLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ScheduledThreadLocalService.class.getName());

			if (invokableLocalService instanceof ScheduledThreadLocalService) {
				_service = (ScheduledThreadLocalService)invokableLocalService;
			}
			else {
				_service = new ScheduledThreadLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ScheduledThreadLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ScheduledThreadLocalService service) {
	}

	private static ScheduledThreadLocalService _service;
}