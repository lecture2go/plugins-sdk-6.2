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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LegacyLectureSeriesFacilityLocalService}.
 *
 * @author unihh
 * @see LegacyLectureSeriesFacilityLocalService
 * @generated
 */
public class LegacyLectureSeriesFacilityLocalServiceWrapper
	implements LegacyLectureSeriesFacilityLocalService,
		ServiceWrapper<LegacyLectureSeriesFacilityLocalService> {
	public LegacyLectureSeriesFacilityLocalServiceWrapper(
		LegacyLectureSeriesFacilityLocalService legacyLectureSeriesFacilityLocalService) {
		_legacyLectureSeriesFacilityLocalService = legacyLectureSeriesFacilityLocalService;
	}

	/**
	* Adds the legacy lecture series facility to the database. Also notifies the appropriate model listeners.
	*
	* @param legacyLectureSeriesFacility the legacy lecture series facility
	* @return the legacy lecture series facility that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility addLegacyLectureSeriesFacility(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility legacyLectureSeriesFacility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesFacilityLocalService.addLegacyLectureSeriesFacility(legacyLectureSeriesFacility);
	}

	/**
	* Creates a new legacy lecture series facility with the primary key. Does not add the legacy lecture series facility to the database.
	*
	* @param facilityId the primary key for the new legacy lecture series facility
	* @return the new legacy lecture series facility
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility createLegacyLectureSeriesFacility(
		long facilityId) {
		return _legacyLectureSeriesFacilityLocalService.createLegacyLectureSeriesFacility(facilityId);
	}

	/**
	* Deletes the legacy lecture series facility with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param facilityId the primary key of the legacy lecture series facility
	* @return the legacy lecture series facility that was removed
	* @throws PortalException if a legacy lecture series facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility deleteLegacyLectureSeriesFacility(
		long facilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesFacilityLocalService.deleteLegacyLectureSeriesFacility(facilityId);
	}

	/**
	* Deletes the legacy lecture series facility from the database. Also notifies the appropriate model listeners.
	*
	* @param legacyLectureSeriesFacility the legacy lecture series facility
	* @return the legacy lecture series facility that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility deleteLegacyLectureSeriesFacility(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility legacyLectureSeriesFacility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesFacilityLocalService.deleteLegacyLectureSeriesFacility(legacyLectureSeriesFacility);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legacyLectureSeriesFacilityLocalService.dynamicQuery();
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
		return _legacyLectureSeriesFacilityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyLectureSeriesFacilityLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyLectureSeriesFacilityLocalService.dynamicQuery(dynamicQuery,
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
		return _legacyLectureSeriesFacilityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _legacyLectureSeriesFacilityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility fetchLegacyLectureSeriesFacility(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesFacilityLocalService.fetchLegacyLectureSeriesFacility(facilityId);
	}

	/**
	* Returns the legacy lecture series facility with the primary key.
	*
	* @param facilityId the primary key of the legacy lecture series facility
	* @return the legacy lecture series facility
	* @throws PortalException if a legacy lecture series facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility getLegacyLectureSeriesFacility(
		long facilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesFacilityLocalService.getLegacyLectureSeriesFacility(facilityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesFacilityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legacy lecture series facilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy lecture series facilities
	* @param end the upper bound of the range of legacy lecture series facilities (not inclusive)
	* @return the range of legacy lecture series facilities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility> getLegacyLectureSeriesFacilities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesFacilityLocalService.getLegacyLectureSeriesFacilities(start,
			end);
	}

	/**
	* Returns the number of legacy lecture series facilities.
	*
	* @return the number of legacy lecture series facilities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegacyLectureSeriesFacilitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesFacilityLocalService.getLegacyLectureSeriesFacilitiesCount();
	}

	/**
	* Updates the legacy lecture series facility in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legacyLectureSeriesFacility the legacy lecture series facility
	* @return the legacy lecture series facility that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility updateLegacyLectureSeriesFacility(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility legacyLectureSeriesFacility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesFacilityLocalService.updateLegacyLectureSeriesFacility(legacyLectureSeriesFacility);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legacyLectureSeriesFacilityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legacyLectureSeriesFacilityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legacyLectureSeriesFacilityLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LegacyLectureSeriesFacilityLocalService getWrappedLegacyLectureSeriesFacilityLocalService() {
		return _legacyLectureSeriesFacilityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegacyLectureSeriesFacilityLocalService(
		LegacyLectureSeriesFacilityLocalService legacyLectureSeriesFacilityLocalService) {
		_legacyLectureSeriesFacilityLocalService = legacyLectureSeriesFacilityLocalService;
	}

	@Override
	public LegacyLectureSeriesFacilityLocalService getWrappedService() {
		return _legacyLectureSeriesFacilityLocalService;
	}

	@Override
	public void setWrappedService(
		LegacyLectureSeriesFacilityLocalService legacyLectureSeriesFacilityLocalService) {
		_legacyLectureSeriesFacilityLocalService = legacyLectureSeriesFacilityLocalService;
	}

	private LegacyLectureSeriesFacilityLocalService _legacyLectureSeriesFacilityLocalService;
}