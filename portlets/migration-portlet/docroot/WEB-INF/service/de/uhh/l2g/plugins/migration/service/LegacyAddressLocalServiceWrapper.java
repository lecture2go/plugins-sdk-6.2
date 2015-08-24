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
 * Provides a wrapper for {@link LegacyAddressLocalService}.
 *
 * @author unihh
 * @see LegacyAddressLocalService
 * @generated
 */
public class LegacyAddressLocalServiceWrapper
	implements LegacyAddressLocalService,
		ServiceWrapper<LegacyAddressLocalService> {
	public LegacyAddressLocalServiceWrapper(
		LegacyAddressLocalService legacyAddressLocalService) {
		_legacyAddressLocalService = legacyAddressLocalService;
	}

	/**
	* Adds the legacy address to the database. Also notifies the appropriate model listeners.
	*
	* @param legacyAddress the legacy address
	* @return the legacy address that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyAddress addLegacyAddress(
		de.uhh.l2g.plugins.migration.model.LegacyAddress legacyAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyAddressLocalService.addLegacyAddress(legacyAddress);
	}

	/**
	* Creates a new legacy address with the primary key. Does not add the legacy address to the database.
	*
	* @param addressId the primary key for the new legacy address
	* @return the new legacy address
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyAddress createLegacyAddress(
		long addressId) {
		return _legacyAddressLocalService.createLegacyAddress(addressId);
	}

	/**
	* Deletes the legacy address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressId the primary key of the legacy address
	* @return the legacy address that was removed
	* @throws PortalException if a legacy address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyAddress deleteLegacyAddress(
		long addressId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyAddressLocalService.deleteLegacyAddress(addressId);
	}

	/**
	* Deletes the legacy address from the database. Also notifies the appropriate model listeners.
	*
	* @param legacyAddress the legacy address
	* @return the legacy address that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyAddress deleteLegacyAddress(
		de.uhh.l2g.plugins.migration.model.LegacyAddress legacyAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyAddressLocalService.deleteLegacyAddress(legacyAddress);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legacyAddressLocalService.dynamicQuery();
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
		return _legacyAddressLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyAddressLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyAddressLocalService.dynamicQuery(dynamicQuery, start,
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
		return _legacyAddressLocalService.dynamicQueryCount(dynamicQuery);
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
		return _legacyAddressLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyAddress fetchLegacyAddress(
		long addressId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyAddressLocalService.fetchLegacyAddress(addressId);
	}

	/**
	* Returns the legacy address with the primary key.
	*
	* @param addressId the primary key of the legacy address
	* @return the legacy address
	* @throws PortalException if a legacy address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyAddress getLegacyAddress(
		long addressId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyAddressLocalService.getLegacyAddress(addressId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyAddressLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legacy addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy addresses
	* @param end the upper bound of the range of legacy addresses (not inclusive)
	* @return the range of legacy addresses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyAddress> getLegacyAddresses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyAddressLocalService.getLegacyAddresses(start, end);
	}

	/**
	* Returns the number of legacy addresses.
	*
	* @return the number of legacy addresses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegacyAddressesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyAddressLocalService.getLegacyAddressesCount();
	}

	/**
	* Updates the legacy address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legacyAddress the legacy address
	* @return the legacy address that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyAddress updateLegacyAddress(
		de.uhh.l2g.plugins.migration.model.LegacyAddress legacyAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyAddressLocalService.updateLegacyAddress(legacyAddress);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legacyAddressLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legacyAddressLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legacyAddressLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LegacyAddressLocalService getWrappedLegacyAddressLocalService() {
		return _legacyAddressLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegacyAddressLocalService(
		LegacyAddressLocalService legacyAddressLocalService) {
		_legacyAddressLocalService = legacyAddressLocalService;
	}

	@Override
	public LegacyAddressLocalService getWrappedService() {
		return _legacyAddressLocalService;
	}

	@Override
	public void setWrappedService(
		LegacyAddressLocalService legacyAddressLocalService) {
		_legacyAddressLocalService = legacyAddressLocalService;
	}

	private LegacyAddressLocalService _legacyAddressLocalService;
}