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
 * Provides a wrapper for {@link LegacyMetadataLocalService}.
 *
 * @author unihh
 * @see LegacyMetadataLocalService
 * @generated
 */
public class LegacyMetadataLocalServiceWrapper
	implements LegacyMetadataLocalService,
		ServiceWrapper<LegacyMetadataLocalService> {
	public LegacyMetadataLocalServiceWrapper(
		LegacyMetadataLocalService legacyMetadataLocalService) {
		_legacyMetadataLocalService = legacyMetadataLocalService;
	}

	/**
	* Adds the legacy metadata to the database. Also notifies the appropriate model listeners.
	*
	* @param legacyMetadata the legacy metadata
	* @return the legacy metadata that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata addLegacyMetadata(
		de.uhh.l2g.plugins.migration.model.LegacyMetadata legacyMetadata)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyMetadataLocalService.addLegacyMetadata(legacyMetadata);
	}

	/**
	* Creates a new legacy metadata with the primary key. Does not add the legacy metadata to the database.
	*
	* @param id the primary key for the new legacy metadata
	* @return the new legacy metadata
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata createLegacyMetadata(
		long id) {
		return _legacyMetadataLocalService.createLegacyMetadata(id);
	}

	/**
	* Deletes the legacy metadata with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy metadata
	* @return the legacy metadata that was removed
	* @throws PortalException if a legacy metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata deleteLegacyMetadata(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyMetadataLocalService.deleteLegacyMetadata(id);
	}

	/**
	* Deletes the legacy metadata from the database. Also notifies the appropriate model listeners.
	*
	* @param legacyMetadata the legacy metadata
	* @return the legacy metadata that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata deleteLegacyMetadata(
		de.uhh.l2g.plugins.migration.model.LegacyMetadata legacyMetadata)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyMetadataLocalService.deleteLegacyMetadata(legacyMetadata);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legacyMetadataLocalService.dynamicQuery();
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
		return _legacyMetadataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyMetadataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyMetadataLocalService.dynamicQuery(dynamicQuery, start,
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
		return _legacyMetadataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _legacyMetadataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata fetchLegacyMetadata(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyMetadataLocalService.fetchLegacyMetadata(id);
	}

	/**
	* Returns the legacy metadata with the primary key.
	*
	* @param id the primary key of the legacy metadata
	* @return the legacy metadata
	* @throws PortalException if a legacy metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata getLegacyMetadata(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyMetadataLocalService.getLegacyMetadata(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyMetadataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legacy metadatas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy metadatas
	* @param end the upper bound of the range of legacy metadatas (not inclusive)
	* @return the range of legacy metadatas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyMetadata> getLegacyMetadatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyMetadataLocalService.getLegacyMetadatas(start, end);
	}

	/**
	* Returns the number of legacy metadatas.
	*
	* @return the number of legacy metadatas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegacyMetadatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyMetadataLocalService.getLegacyMetadatasCount();
	}

	/**
	* Updates the legacy metadata in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legacyMetadata the legacy metadata
	* @return the legacy metadata that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata updateLegacyMetadata(
		de.uhh.l2g.plugins.migration.model.LegacyMetadata legacyMetadata)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyMetadataLocalService.updateLegacyMetadata(legacyMetadata);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legacyMetadataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legacyMetadataLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legacyMetadataLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LegacyMetadataLocalService getWrappedLegacyMetadataLocalService() {
		return _legacyMetadataLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegacyMetadataLocalService(
		LegacyMetadataLocalService legacyMetadataLocalService) {
		_legacyMetadataLocalService = legacyMetadataLocalService;
	}

	@Override
	public LegacyMetadataLocalService getWrappedService() {
		return _legacyMetadataLocalService;
	}

	@Override
	public void setWrappedService(
		LegacyMetadataLocalService legacyMetadataLocalService) {
		_legacyMetadataLocalService = legacyMetadataLocalService;
	}

	private LegacyMetadataLocalService _legacyMetadataLocalService;
}