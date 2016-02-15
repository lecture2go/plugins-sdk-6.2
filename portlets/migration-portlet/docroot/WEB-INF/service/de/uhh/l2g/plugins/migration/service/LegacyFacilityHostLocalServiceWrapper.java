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
 * Provides a wrapper for {@link LegacyFacilityHostLocalService}.
 *
 * @author unihh
 * @see LegacyFacilityHostLocalService
 * @generated
 */
public class LegacyFacilityHostLocalServiceWrapper
	implements LegacyFacilityHostLocalService,
		ServiceWrapper<LegacyFacilityHostLocalService> {
	public LegacyFacilityHostLocalServiceWrapper(
		LegacyFacilityHostLocalService legacyFacilityHostLocalService) {
		_legacyFacilityHostLocalService = legacyFacilityHostLocalService;
	}

	/**
	* Adds the legacy facility host to the database. Also notifies the appropriate model listeners.
	*
	* @param legacyFacilityHost the legacy facility host
	* @return the legacy facility host that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyFacilityHost addLegacyFacilityHost(
		de.uhh.l2g.plugins.migration.model.LegacyFacilityHost legacyFacilityHost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyFacilityHostLocalService.addLegacyFacilityHost(legacyFacilityHost);
	}

	/**
	* Creates a new legacy facility host with the primary key. Does not add the legacy facility host to the database.
	*
	* @param facilityHostId the primary key for the new legacy facility host
	* @return the new legacy facility host
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyFacilityHost createLegacyFacilityHost(
		long facilityHostId) {
		return _legacyFacilityHostLocalService.createLegacyFacilityHost(facilityHostId);
	}

	/**
	* Deletes the legacy facility host with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param facilityHostId the primary key of the legacy facility host
	* @return the legacy facility host that was removed
	* @throws PortalException if a legacy facility host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyFacilityHost deleteLegacyFacilityHost(
		long facilityHostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyFacilityHostLocalService.deleteLegacyFacilityHost(facilityHostId);
	}

	/**
	* Deletes the legacy facility host from the database. Also notifies the appropriate model listeners.
	*
	* @param legacyFacilityHost the legacy facility host
	* @return the legacy facility host that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyFacilityHost deleteLegacyFacilityHost(
		de.uhh.l2g.plugins.migration.model.LegacyFacilityHost legacyFacilityHost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyFacilityHostLocalService.deleteLegacyFacilityHost(legacyFacilityHost);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legacyFacilityHostLocalService.dynamicQuery();
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
		return _legacyFacilityHostLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityHostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyFacilityHostLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityHostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyFacilityHostLocalService.dynamicQuery(dynamicQuery,
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
		return _legacyFacilityHostLocalService.dynamicQueryCount(dynamicQuery);
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
		return _legacyFacilityHostLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyFacilityHost fetchLegacyFacilityHost(
		long facilityHostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyFacilityHostLocalService.fetchLegacyFacilityHost(facilityHostId);
	}

	/**
	* Returns the legacy facility host with the primary key.
	*
	* @param facilityHostId the primary key of the legacy facility host
	* @return the legacy facility host
	* @throws PortalException if a legacy facility host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyFacilityHost getLegacyFacilityHost(
		long facilityHostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyFacilityHostLocalService.getLegacyFacilityHost(facilityHostId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyFacilityHostLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legacy facility hosts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityHostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy facility hosts
	* @param end the upper bound of the range of legacy facility hosts (not inclusive)
	* @return the range of legacy facility hosts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyFacilityHost> getLegacyFacilityHosts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyFacilityHostLocalService.getLegacyFacilityHosts(start, end);
	}

	/**
	* Returns the number of legacy facility hosts.
	*
	* @return the number of legacy facility hosts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegacyFacilityHostsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyFacilityHostLocalService.getLegacyFacilityHostsCount();
	}

	/**
	* Updates the legacy facility host in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legacyFacilityHost the legacy facility host
	* @return the legacy facility host that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyFacilityHost updateLegacyFacilityHost(
		de.uhh.l2g.plugins.migration.model.LegacyFacilityHost legacyFacilityHost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyFacilityHostLocalService.updateLegacyFacilityHost(legacyFacilityHost);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legacyFacilityHostLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legacyFacilityHostLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legacyFacilityHostLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LegacyFacilityHostLocalService getWrappedLegacyFacilityHostLocalService() {
		return _legacyFacilityHostLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegacyFacilityHostLocalService(
		LegacyFacilityHostLocalService legacyFacilityHostLocalService) {
		_legacyFacilityHostLocalService = legacyFacilityHostLocalService;
	}

	@Override
	public LegacyFacilityHostLocalService getWrappedService() {
		return _legacyFacilityHostLocalService;
	}

	@Override
	public void setWrappedService(
		LegacyFacilityHostLocalService legacyFacilityHostLocalService) {
		_legacyFacilityHostLocalService = legacyFacilityHostLocalService;
	}

	private LegacyFacilityHostLocalService _legacyFacilityHostLocalService;
}