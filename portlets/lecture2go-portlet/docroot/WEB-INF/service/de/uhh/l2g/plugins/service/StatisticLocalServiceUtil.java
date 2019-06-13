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
 * Provides the local service utility for Statistic. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.StatisticLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see StatisticLocalService
 * @see de.uhh.l2g.plugins.service.base.StatisticLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.StatisticLocalServiceImpl
 * @generated
 */
public class StatisticLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.StatisticLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the statistic to the database. Also notifies the appropriate model listeners.
	*
	* @param statistic the statistic
	* @return the statistic that was added
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Statistic addStatistic(
		de.uhh.l2g.plugins.model.Statistic statistic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStatistic(statistic);
	}

	/**
	* Creates a new statistic with the primary key. Does not add the statistic to the database.
	*
	* @param statisticId the primary key for the new statistic
	* @return the new statistic
	*/
	public static de.uhh.l2g.plugins.model.Statistic createStatistic(
		long statisticId) {
		return getService().createStatistic(statisticId);
	}

	/**
	* Deletes the statistic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statisticId the primary key of the statistic
	* @return the statistic that was removed
	* @throws PortalException if a statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Statistic deleteStatistic(
		long statisticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStatistic(statisticId);
	}

	/**
	* Deletes the statistic from the database. Also notifies the appropriate model listeners.
	*
	* @param statistic the statistic
	* @return the statistic that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Statistic deleteStatistic(
		de.uhh.l2g.plugins.model.Statistic statistic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStatistic(statistic);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.Statistic fetchStatistic(
		long statisticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStatistic(statisticId);
	}

	/**
	* Returns the statistic with the primary key.
	*
	* @param statisticId the primary key of the statistic
	* @return the statistic
	* @throws PortalException if a statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Statistic getStatistic(
		long statisticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStatistic(statisticId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Statistic> getStatistics(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStatistics(start, end);
	}

	/**
	* Returns the number of statistics.
	*
	* @return the number of statistics
	* @throws SystemException if a system exception occurred
	*/
	public static int getStatisticsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStatisticsCount();
	}

	/**
	* Updates the statistic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statistic the statistic
	* @return the statistic that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Statistic updateStatistic(
		de.uhh.l2g.plugins.model.Statistic statistic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStatistic(statistic);
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

	public static org.json.JSONObject getAllStatistics()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllStatistics();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Statistic> getByCompanyIdandGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByCompanyIdandGroupId(companyId, groupId);
	}

	public static de.uhh.l2g.plugins.model.Statistic getByStatisticId(
		long statisticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByStatisticId(statisticId);
	}

	public static de.uhh.l2g.plugins.model.Statistic getByStatisticId(
		long companyId, long groupId, long statisticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByStatisticId(companyId, groupId, statisticId);
	}

	/**
	* Drop table via custom query
	* https://web.liferay.com/de/community/wiki/-/wiki/Main/Working+with+Database+Views+in+Liferay
	*/
	public static boolean removeVideoStatisticDefaultTable() {
		return getService().removeVideoStatisticDefaultTable();
	}

	/**
	* Add Database View with same Name
	*/
	public static boolean addVideoStatisticView() {
		return getService().addVideoStatisticView();
	}

	public static de.uhh.l2g.plugins.model.Statistic addDefaultEntry(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addDefaultEntry(serviceContext);
	}

	public static de.uhh.l2g.plugins.model.Statistic addEntry(
		int privateVideos, int publicVideos,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addEntry(privateVideos, publicVideos, serviceContext);
	}

	public static de.uhh.l2g.plugins.model.Statistic add(int privateVideos,
		int publicVideos)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().add(privateVideos, publicVideos);
	}

	public static de.uhh.l2g.plugins.model.Statistic updateEntry(
		long statisticId, int privateVideos, int publicVideos,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEntry(statisticId, privateVideos, publicVideos,
			serviceContext);
	}

	public static de.uhh.l2g.plugins.model.Statistic deleteLinkById(
		long statisticId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLinkById(statisticId, serviceContext);
	}

	public static long updateCounter()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCounter();
	}

	public static void clearService() {
		_service = null;
	}

	public static StatisticLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StatisticLocalService.class.getName());

			if (invokableLocalService instanceof StatisticLocalService) {
				_service = (StatisticLocalService)invokableLocalService;
			}
			else {
				_service = new StatisticLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StatisticLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StatisticLocalService service) {
	}

	private static StatisticLocalService _service;
}