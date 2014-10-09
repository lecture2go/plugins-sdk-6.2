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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Lectureseries_FacilityLocalService}.
 *
 * @author Iavor Sturm
 * @see Lectureseries_FacilityLocalService
 * @generated
 */
public class Lectureseries_FacilityLocalServiceWrapper
	implements Lectureseries_FacilityLocalService,
		ServiceWrapper<Lectureseries_FacilityLocalService> {
	public Lectureseries_FacilityLocalServiceWrapper(
		Lectureseries_FacilityLocalService lectureseries_FacilityLocalService) {
		_lectureseries_FacilityLocalService = lectureseries_FacilityLocalService;
	}

	/**
	* Adds the lectureseries_ facility to the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries_Facility the lectureseries_ facility
	* @return the lectureseries_ facility that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Facility addLectureseries_Facility(
		de.uhh.l2g.plugins.model.Lectureseries_Facility lectureseries_Facility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_FacilityLocalService.addLectureseries_Facility(lectureseries_Facility);
	}

	/**
	* Creates a new lectureseries_ facility with the primary key. Does not add the lectureseries_ facility to the database.
	*
	* @param lectureseriesFacilityId the primary key for the new lectureseries_ facility
	* @return the new lectureseries_ facility
	*/
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Facility createLectureseries_Facility(
		long lectureseriesFacilityId) {
		return _lectureseries_FacilityLocalService.createLectureseries_Facility(lectureseriesFacilityId);
	}

	/**
	* Deletes the lectureseries_ facility with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesFacilityId the primary key of the lectureseries_ facility
	* @return the lectureseries_ facility that was removed
	* @throws PortalException if a lectureseries_ facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Facility deleteLectureseries_Facility(
		long lectureseriesFacilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_FacilityLocalService.deleteLectureseries_Facility(lectureseriesFacilityId);
	}

	/**
	* Deletes the lectureseries_ facility from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries_Facility the lectureseries_ facility
	* @return the lectureseries_ facility that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Facility deleteLectureseries_Facility(
		de.uhh.l2g.plugins.model.Lectureseries_Facility lectureseries_Facility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_FacilityLocalService.deleteLectureseries_Facility(lectureseries_Facility);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lectureseries_FacilityLocalService.dynamicQuery();
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
		return _lectureseries_FacilityLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_FacilityLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_FacilityLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _lectureseries_FacilityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _lectureseries_FacilityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Facility fetchLectureseries_Facility(
		long lectureseriesFacilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_FacilityLocalService.fetchLectureseries_Facility(lectureseriesFacilityId);
	}

	/**
	* Returns the lectureseries_ facility with the primary key.
	*
	* @param lectureseriesFacilityId the primary key of the lectureseries_ facility
	* @return the lectureseries_ facility
	* @throws PortalException if a lectureseries_ facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Facility getLectureseries_Facility(
		long lectureseriesFacilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_FacilityLocalService.getLectureseries_Facility(lectureseriesFacilityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_FacilityLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> getLectureseries_Facilities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_FacilityLocalService.getLectureseries_Facilities(start,
			end);
	}

	/**
	* Returns the number of lectureseries_ facilities.
	*
	* @return the number of lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLectureseries_FacilitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_FacilityLocalService.getLectureseries_FacilitiesCount();
	}

	/**
	* Updates the lectureseries_ facility in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lectureseries_Facility the lectureseries_ facility
	* @return the lectureseries_ facility that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Facility updateLectureseries_Facility(
		de.uhh.l2g.plugins.model.Lectureseries_Facility lectureseries_Facility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_FacilityLocalService.updateLectureseries_Facility(lectureseries_Facility);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _lectureseries_FacilityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lectureseries_FacilityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lectureseries_FacilityLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public boolean removeByLectureseriesId(java.lang.Long lectureseriesId) {
		return _lectureseries_FacilityLocalService.removeByLectureseriesId(lectureseriesId);
	}

	@Override
	public boolean removeByacilityId(java.lang.Long facilityId) {
		return _lectureseries_FacilityLocalService.removeByacilityId(facilityId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Lectureseries_FacilityLocalService getWrappedLectureseries_FacilityLocalService() {
		return _lectureseries_FacilityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLectureseries_FacilityLocalService(
		Lectureseries_FacilityLocalService lectureseries_FacilityLocalService) {
		_lectureseries_FacilityLocalService = lectureseries_FacilityLocalService;
	}

	@Override
	public Lectureseries_FacilityLocalService getWrappedService() {
		return _lectureseries_FacilityLocalService;
	}

	@Override
	public void setWrappedService(
		Lectureseries_FacilityLocalService lectureseries_FacilityLocalService) {
		_lectureseries_FacilityLocalService = lectureseries_FacilityLocalService;
	}

	private Lectureseries_FacilityLocalService _lectureseries_FacilityLocalService;
}