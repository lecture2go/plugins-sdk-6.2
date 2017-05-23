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

package de.uhh.l2g.plugins.migration.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LegacyProducerLectureseries. This utility wraps
 * {@link de.uhh.l2g.plugins.migration.service.impl.LegacyProducerLectureseriesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author unihh
 * @see LegacyProducerLectureseriesLocalService
 * @see de.uhh.l2g.plugins.migration.service.base.LegacyProducerLectureseriesLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.migration.service.impl.LegacyProducerLectureseriesLocalServiceImpl
 * @generated
 */
public class LegacyProducerLectureseriesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.migration.service.impl.LegacyProducerLectureseriesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the legacy producer lectureseries to the database. Also notifies the appropriate model listeners.
	*
	* @param legacyProducerLectureseries the legacy producer lectureseries
	* @return the legacy producer lectureseries that was added
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries addLegacyProducerLectureseries(
		de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries legacyProducerLectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addLegacyProducerLectureseries(legacyProducerLectureseries);
	}

	/**
	* Creates a new legacy producer lectureseries with the primary key. Does not add the legacy producer lectureseries to the database.
	*
	* @param id the primary key for the new legacy producer lectureseries
	* @return the new legacy producer lectureseries
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries createLegacyProducerLectureseries(
		long id) {
		return getService().createLegacyProducerLectureseries(id);
	}

	/**
	* Deletes the legacy producer lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy producer lectureseries
	* @return the legacy producer lectureseries that was removed
	* @throws PortalException if a legacy producer lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries deleteLegacyProducerLectureseries(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLegacyProducerLectureseries(id);
	}

	/**
	* Deletes the legacy producer lectureseries from the database. Also notifies the appropriate model listeners.
	*
	* @param legacyProducerLectureseries the legacy producer lectureseries
	* @return the legacy producer lectureseries that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries deleteLegacyProducerLectureseries(
		de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries legacyProducerLectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteLegacyProducerLectureseries(legacyProducerLectureseries);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyProducerLectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyProducerLectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries fetchLegacyProducerLectureseries(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLegacyProducerLectureseries(id);
	}

	/**
	* Returns the legacy producer lectureseries with the primary key.
	*
	* @param id the primary key of the legacy producer lectureseries
	* @return the legacy producer lectureseries
	* @throws PortalException if a legacy producer lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries getLegacyProducerLectureseries(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegacyProducerLectureseries(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legacy producer lectureserieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyProducerLectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy producer lectureserieses
	* @param end the upper bound of the range of legacy producer lectureserieses (not inclusive)
	* @return the range of legacy producer lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries> getLegacyProducerLectureserieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegacyProducerLectureserieses(start, end);
	}

	/**
	* Returns the number of legacy producer lectureserieses.
	*
	* @return the number of legacy producer lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int getLegacyProducerLectureseriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegacyProducerLectureseriesesCount();
	}

	/**
	* Updates the legacy producer lectureseries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legacyProducerLectureseries the legacy producer lectureseries
	* @return the legacy producer lectureseries that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries updateLegacyProducerLectureseries(
		de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries legacyProducerLectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLegacyProducerLectureseries(legacyProducerLectureseries);
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

	public static void clearService() {
		_service = null;
	}

	public static LegacyProducerLectureseriesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LegacyProducerLectureseriesLocalService.class.getName());

			if (invokableLocalService instanceof LegacyProducerLectureseriesLocalService) {
				_service = (LegacyProducerLectureseriesLocalService)invokableLocalService;
			}
			else {
				_service = new LegacyProducerLectureseriesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LegacyProducerLectureseriesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LegacyProducerLectureseriesLocalService service) {
	}

	private static LegacyProducerLectureseriesLocalService _service;
}