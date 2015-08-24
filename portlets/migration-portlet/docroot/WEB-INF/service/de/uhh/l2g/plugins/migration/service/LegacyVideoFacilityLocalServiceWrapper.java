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
 * Provides a wrapper for {@link LegacyVideoFacilityLocalService}.
 *
 * @author unihh
 * @see LegacyVideoFacilityLocalService
 * @generated
 */
public class LegacyVideoFacilityLocalServiceWrapper
	implements LegacyVideoFacilityLocalService,
		ServiceWrapper<LegacyVideoFacilityLocalService> {
	public LegacyVideoFacilityLocalServiceWrapper(
		LegacyVideoFacilityLocalService legacyVideoFacilityLocalService) {
		_legacyVideoFacilityLocalService = legacyVideoFacilityLocalService;
	}

	/**
	* Adds the legacy video facility to the database. Also notifies the appropriate model listeners.
	*
	* @param legacyVideoFacility the legacy video facility
	* @return the legacy video facility that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyVideoFacility addLegacyVideoFacility(
		de.uhh.l2g.plugins.migration.model.LegacyVideoFacility legacyVideoFacility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyVideoFacilityLocalService.addLegacyVideoFacility(legacyVideoFacility);
	}

	/**
	* Creates a new legacy video facility with the primary key. Does not add the legacy video facility to the database.
	*
	* @param videoFacilityId the primary key for the new legacy video facility
	* @return the new legacy video facility
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyVideoFacility createLegacyVideoFacility(
		long videoFacilityId) {
		return _legacyVideoFacilityLocalService.createLegacyVideoFacility(videoFacilityId);
	}

	/**
	* Deletes the legacy video facility with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoFacilityId the primary key of the legacy video facility
	* @return the legacy video facility that was removed
	* @throws PortalException if a legacy video facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyVideoFacility deleteLegacyVideoFacility(
		long videoFacilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyVideoFacilityLocalService.deleteLegacyVideoFacility(videoFacilityId);
	}

	/**
	* Deletes the legacy video facility from the database. Also notifies the appropriate model listeners.
	*
	* @param legacyVideoFacility the legacy video facility
	* @return the legacy video facility that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyVideoFacility deleteLegacyVideoFacility(
		de.uhh.l2g.plugins.migration.model.LegacyVideoFacility legacyVideoFacility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyVideoFacilityLocalService.deleteLegacyVideoFacility(legacyVideoFacility);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legacyVideoFacilityLocalService.dynamicQuery();
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
		return _legacyVideoFacilityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyVideoFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyVideoFacilityLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyVideoFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyVideoFacilityLocalService.dynamicQuery(dynamicQuery,
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
		return _legacyVideoFacilityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _legacyVideoFacilityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyVideoFacility fetchLegacyVideoFacility(
		long videoFacilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyVideoFacilityLocalService.fetchLegacyVideoFacility(videoFacilityId);
	}

	/**
	* Returns the legacy video facility with the primary key.
	*
	* @param videoFacilityId the primary key of the legacy video facility
	* @return the legacy video facility
	* @throws PortalException if a legacy video facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyVideoFacility getLegacyVideoFacility(
		long videoFacilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyVideoFacilityLocalService.getLegacyVideoFacility(videoFacilityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyVideoFacilityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legacy video facilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyVideoFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy video facilities
	* @param end the upper bound of the range of legacy video facilities (not inclusive)
	* @return the range of legacy video facilities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyVideoFacility> getLegacyVideoFacilities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyVideoFacilityLocalService.getLegacyVideoFacilities(start,
			end);
	}

	/**
	* Returns the number of legacy video facilities.
	*
	* @return the number of legacy video facilities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegacyVideoFacilitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyVideoFacilityLocalService.getLegacyVideoFacilitiesCount();
	}

	/**
	* Updates the legacy video facility in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legacyVideoFacility the legacy video facility
	* @return the legacy video facility that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyVideoFacility updateLegacyVideoFacility(
		de.uhh.l2g.plugins.migration.model.LegacyVideoFacility legacyVideoFacility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyVideoFacilityLocalService.updateLegacyVideoFacility(legacyVideoFacility);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legacyVideoFacilityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legacyVideoFacilityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legacyVideoFacilityLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LegacyVideoFacilityLocalService getWrappedLegacyVideoFacilityLocalService() {
		return _legacyVideoFacilityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegacyVideoFacilityLocalService(
		LegacyVideoFacilityLocalService legacyVideoFacilityLocalService) {
		_legacyVideoFacilityLocalService = legacyVideoFacilityLocalService;
	}

	@Override
	public LegacyVideoFacilityLocalService getWrappedService() {
		return _legacyVideoFacilityLocalService;
	}

	@Override
	public void setWrappedService(
		LegacyVideoFacilityLocalService legacyVideoFacilityLocalService) {
		_legacyVideoFacilityLocalService = legacyVideoFacilityLocalService;
	}

	private LegacyVideoFacilityLocalService _legacyVideoFacilityLocalService;
}