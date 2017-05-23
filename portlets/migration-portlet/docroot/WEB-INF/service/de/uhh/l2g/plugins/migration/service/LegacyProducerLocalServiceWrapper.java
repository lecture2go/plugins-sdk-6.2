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
 * Provides a wrapper for {@link LegacyProducerLocalService}.
 *
 * @author unihh
 * @see LegacyProducerLocalService
 * @generated
 */
public class LegacyProducerLocalServiceWrapper
	implements LegacyProducerLocalService,
		ServiceWrapper<LegacyProducerLocalService> {
	public LegacyProducerLocalServiceWrapper(
		LegacyProducerLocalService legacyProducerLocalService) {
		_legacyProducerLocalService = legacyProducerLocalService;
	}

	/**
	* Adds the legacy producer to the database. Also notifies the appropriate model listeners.
	*
	* @param legacyProducer the legacy producer
	* @return the legacy producer that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducer addLegacyProducer(
		de.uhh.l2g.plugins.migration.model.LegacyProducer legacyProducer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyProducerLocalService.addLegacyProducer(legacyProducer);
	}

	/**
	* Creates a new legacy producer with the primary key. Does not add the legacy producer to the database.
	*
	* @param id the primary key for the new legacy producer
	* @return the new legacy producer
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducer createLegacyProducer(
		long id) {
		return _legacyProducerLocalService.createLegacyProducer(id);
	}

	/**
	* Deletes the legacy producer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy producer
	* @return the legacy producer that was removed
	* @throws PortalException if a legacy producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducer deleteLegacyProducer(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyProducerLocalService.deleteLegacyProducer(id);
	}

	/**
	* Deletes the legacy producer from the database. Also notifies the appropriate model listeners.
	*
	* @param legacyProducer the legacy producer
	* @return the legacy producer that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducer deleteLegacyProducer(
		de.uhh.l2g.plugins.migration.model.LegacyProducer legacyProducer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyProducerLocalService.deleteLegacyProducer(legacyProducer);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legacyProducerLocalService.dynamicQuery();
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
		return _legacyProducerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyProducerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyProducerLocalService.dynamicQuery(dynamicQuery, start,
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
		return _legacyProducerLocalService.dynamicQueryCount(dynamicQuery);
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
		return _legacyProducerLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducer fetchLegacyProducer(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyProducerLocalService.fetchLegacyProducer(id);
	}

	/**
	* Returns the legacy producer with the primary key.
	*
	* @param id the primary key of the legacy producer
	* @return the legacy producer
	* @throws PortalException if a legacy producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducer getLegacyProducer(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyProducerLocalService.getLegacyProducer(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyProducerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legacy producers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy producers
	* @param end the upper bound of the range of legacy producers (not inclusive)
	* @return the range of legacy producers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyProducer> getLegacyProducers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyProducerLocalService.getLegacyProducers(start, end);
	}

	/**
	* Returns the number of legacy producers.
	*
	* @return the number of legacy producers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegacyProducersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyProducerLocalService.getLegacyProducersCount();
	}

	/**
	* Updates the legacy producer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legacyProducer the legacy producer
	* @return the legacy producer that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducer updateLegacyProducer(
		de.uhh.l2g.plugins.migration.model.LegacyProducer legacyProducer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyProducerLocalService.updateLegacyProducer(legacyProducer);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legacyProducerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legacyProducerLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legacyProducerLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LegacyProducerLocalService getWrappedLegacyProducerLocalService() {
		return _legacyProducerLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegacyProducerLocalService(
		LegacyProducerLocalService legacyProducerLocalService) {
		_legacyProducerLocalService = legacyProducerLocalService;
	}

	@Override
	public LegacyProducerLocalService getWrappedService() {
		return _legacyProducerLocalService;
	}

	@Override
	public void setWrappedService(
		LegacyProducerLocalService legacyProducerLocalService) {
		_legacyProducerLocalService = legacyProducerLocalService;
	}

	private LegacyProducerLocalService _legacyProducerLocalService;
}