/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
 * Provides the local service utility for Lectureseries_Facility. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.Lectureseries_FacilityLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see Lectureseries_FacilityLocalService
 * @see de.uhh.l2g.plugins.service.base.Lectureseries_FacilityLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.Lectureseries_FacilityLocalServiceImpl
 * @generated
 */
public class Lectureseries_FacilityLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.Lectureseries_FacilityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the lectureseries_ facility to the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries_Facility the lectureseries_ facility
	* @return the lectureseries_ facility that was added
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Facility addLectureseries_Facility(
		de.uhh.l2g.plugins.model.Lectureseries_Facility lectureseries_Facility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLectureseries_Facility(lectureseries_Facility);
	}

	/**
	* Creates a new lectureseries_ facility with the primary key. Does not add the lectureseries_ facility to the database.
	*
	* @param lectureseriesFacilityId the primary key for the new lectureseries_ facility
	* @return the new lectureseries_ facility
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Facility createLectureseries_Facility(
		long lectureseriesFacilityId) {
		return getService().createLectureseries_Facility(lectureseriesFacilityId);
	}

	/**
	* Deletes the lectureseries_ facility with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesFacilityId the primary key of the lectureseries_ facility
	* @return the lectureseries_ facility that was removed
	* @throws PortalException if a lectureseries_ facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Facility deleteLectureseries_Facility(
		long lectureseriesFacilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLectureseries_Facility(lectureseriesFacilityId);
	}

	/**
	* Deletes the lectureseries_ facility from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries_Facility the lectureseries_ facility
	* @return the lectureseries_ facility that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Facility deleteLectureseries_Facility(
		de.uhh.l2g.plugins.model.Lectureseries_Facility lectureseries_Facility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLectureseries_Facility(lectureseries_Facility);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.Lectureseries_Facility fetchLectureseries_Facility(
		long lectureseriesFacilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLectureseries_Facility(lectureseriesFacilityId);
	}

	/**
	* Returns the lectureseries_ facility with the primary key.
	*
	* @param lectureseriesFacilityId the primary key of the lectureseries_ facility
	* @return the lectureseries_ facility
	* @throws PortalException if a lectureseries_ facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Facility getLectureseries_Facility(
		long lectureseriesFacilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLectureseries_Facility(lectureseriesFacilityId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the lectureseries_ facilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ facilities
	* @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	* @return the range of lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> getLectureseries_Facilities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLectureseries_Facilities(start, end);
	}

	/**
	* Returns the number of lectureseries_ facilities.
	*
	* @return the number of lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public static int getLectureseries_FacilitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLectureseries_FacilitiesCount();
	}

	/**
	* Updates the lectureseries_ facility in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lectureseries_Facility the lectureseries_ facility
	* @return the lectureseries_ facility that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Facility updateLectureseries_Facility(
		de.uhh.l2g.plugins.model.Lectureseries_Facility lectureseries_Facility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLectureseries_Facility(lectureseries_Facility);
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

	public static boolean removeByLectureseriesId(
		java.lang.Long lectureseriesId) {
		return getService().removeByLectureseriesId(lectureseriesId);
	}

	public static boolean removeByacilityId(java.lang.Long facilityId) {
		return getService().removeByacilityId(facilityId);
	}

	public static boolean facilityAssignedToLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries_Facility lf) {
		return getService().facilityAssignedToLectureseries(lf);
	}

	public static void clearService() {
		_service = null;
	}

	public static Lectureseries_FacilityLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					Lectureseries_FacilityLocalService.class.getName());

			if (invokableLocalService instanceof Lectureseries_FacilityLocalService) {
				_service = (Lectureseries_FacilityLocalService)invokableLocalService;
			}
			else {
				_service = new Lectureseries_FacilityLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(Lectureseries_FacilityLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(Lectureseries_FacilityLocalService service) {
	}

	private static Lectureseries_FacilityLocalService _service;
}