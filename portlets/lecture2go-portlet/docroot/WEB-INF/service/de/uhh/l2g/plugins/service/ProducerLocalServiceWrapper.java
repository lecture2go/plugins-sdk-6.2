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
 * Provides a wrapper for {@link ProducerLocalService}.
 *
 * @author Iavor Sturm
 * @see ProducerLocalService
 * @generated
 */
public class ProducerLocalServiceWrapper implements ProducerLocalService,
	ServiceWrapper<ProducerLocalService> {
	public ProducerLocalServiceWrapper(
		ProducerLocalService producerLocalService) {
		_producerLocalService = producerLocalService;
	}

	/**
	* Adds the producer to the database. Also notifies the appropriate model listeners.
	*
	* @param producer the producer
	* @return the producer that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Producer addProducer(
		de.uhh.l2g.plugins.model.Producer producer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.addProducer(producer);
	}

	/**
	* Creates a new producer with the primary key. Does not add the producer to the database.
	*
	* @param producerId the primary key for the new producer
	* @return the new producer
	*/
	@Override
	public de.uhh.l2g.plugins.model.Producer createProducer(long producerId) {
		return _producerLocalService.createProducer(producerId);
	}

	/**
	* Deletes the producer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param producerId the primary key of the producer
	* @return the producer that was removed
	* @throws PortalException if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Producer deleteProducer(long producerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.deleteProducer(producerId);
	}

	/**
	* Deletes the producer from the database. Also notifies the appropriate model listeners.
	*
	* @param producer the producer
	* @return the producer that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Producer deleteProducer(
		de.uhh.l2g.plugins.model.Producer producer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.deleteProducer(producer);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _producerLocalService.dynamicQuery();
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
		return _producerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _producerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _producerLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _producerLocalService.dynamicQueryCount(dynamicQuery);
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
		return _producerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Producer fetchProducer(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.fetchProducer(producerId);
	}

	/**
	* Returns the producer with the primary key.
	*
	* @param producerId the primary key of the producer
	* @return the producer
	* @throws PortalException if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Producer getProducer(long producerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.getProducer(producerId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the producers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @return the range of producers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Producer> getProducers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.getProducers(start, end);
	}

	/**
	* Returns the number of producers.
	*
	* @return the number of producers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProducersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.getProducersCount();
	}

	/**
	* Updates the producer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param producer the producer
	* @return the producer that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Producer updateProducer(
		de.uhh.l2g.plugins.model.Producer producer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.updateProducer(producer);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _producerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_producerLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _producerLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Producer> getProducersByInstitutionId(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.getProducersByInstitutionId(institutionId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Producer> getAllProducers(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.getAllProducers(begin, end);
	}

	@Override
	public de.uhh.l2g.plugins.model.Producer getProdUcer(
		java.lang.Long producerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.getProdUcer(producerId);
	}

	@Override
	public java.util.List<java.lang.Long> getAllProducerIds(
		java.lang.Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.getAllProducerIds(lectureseriesId);
	}

	@Override
	public java.util.List<java.lang.Long> getProducerIds(
		java.lang.Long lectureseriesId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _producerLocalService.getProducerIds(lectureseriesId, begin, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProducerLocalService getWrappedProducerLocalService() {
		return _producerLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProducerLocalService(
		ProducerLocalService producerLocalService) {
		_producerLocalService = producerLocalService;
	}

	@Override
	public ProducerLocalService getWrappedService() {
		return _producerLocalService;
	}

	@Override
	public void setWrappedService(ProducerLocalService producerLocalService) {
		_producerLocalService = producerLocalService;
	}

	private ProducerLocalService _producerLocalService;
}