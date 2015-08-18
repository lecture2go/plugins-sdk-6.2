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
 * Provides a wrapper for {@link LegacyL2gSysLocalService}.
 *
 * @author unihh
 * @see LegacyL2gSysLocalService
 * @generated
 */
public class LegacyL2gSysLocalServiceWrapper implements LegacyL2gSysLocalService,
	ServiceWrapper<LegacyL2gSysLocalService> {
	public LegacyL2gSysLocalServiceWrapper(
		LegacyL2gSysLocalService legacyL2gSysLocalService) {
		_legacyL2gSysLocalService = legacyL2gSysLocalService;
	}

	/**
	* Adds the legacy l2g sys to the database. Also notifies the appropriate model listeners.
	*
	* @param legacyL2gSys the legacy l2g sys
	* @return the legacy l2g sys that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyL2gSys addLegacyL2gSys(
		de.uhh.l2g.plugins.migration.model.LegacyL2gSys legacyL2gSys)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyL2gSysLocalService.addLegacyL2gSys(legacyL2gSys);
	}

	/**
	* Creates a new legacy l2g sys with the primary key. Does not add the legacy l2g sys to the database.
	*
	* @param id the primary key for the new legacy l2g sys
	* @return the new legacy l2g sys
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyL2gSys createLegacyL2gSys(
		int id) {
		return _legacyL2gSysLocalService.createLegacyL2gSys(id);
	}

	/**
	* Deletes the legacy l2g sys with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy l2g sys
	* @return the legacy l2g sys that was removed
	* @throws PortalException if a legacy l2g sys with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyL2gSys deleteLegacyL2gSys(
		int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyL2gSysLocalService.deleteLegacyL2gSys(id);
	}

	/**
	* Deletes the legacy l2g sys from the database. Also notifies the appropriate model listeners.
	*
	* @param legacyL2gSys the legacy l2g sys
	* @return the legacy l2g sys that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyL2gSys deleteLegacyL2gSys(
		de.uhh.l2g.plugins.migration.model.LegacyL2gSys legacyL2gSys)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyL2gSysLocalService.deleteLegacyL2gSys(legacyL2gSys);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legacyL2gSysLocalService.dynamicQuery();
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
		return _legacyL2gSysLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyL2gSysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyL2gSysLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyL2gSysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyL2gSysLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _legacyL2gSysLocalService.dynamicQueryCount(dynamicQuery);
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
		return _legacyL2gSysLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyL2gSys fetchLegacyL2gSys(
		int id) throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyL2gSysLocalService.fetchLegacyL2gSys(id);
	}

	/**
	* Returns the legacy l2g sys with the primary key.
	*
	* @param id the primary key of the legacy l2g sys
	* @return the legacy l2g sys
	* @throws PortalException if a legacy l2g sys with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyL2gSys getLegacyL2gSys(
		int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyL2gSysLocalService.getLegacyL2gSys(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyL2gSysLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legacy l2g syses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyL2gSysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy l2g syses
	* @param end the upper bound of the range of legacy l2g syses (not inclusive)
	* @return the range of legacy l2g syses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyL2gSys> getLegacyL2gSyses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyL2gSysLocalService.getLegacyL2gSyses(start, end);
	}

	/**
	* Returns the number of legacy l2g syses.
	*
	* @return the number of legacy l2g syses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegacyL2gSysesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyL2gSysLocalService.getLegacyL2gSysesCount();
	}

	/**
	* Updates the legacy l2g sys in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legacyL2gSys the legacy l2g sys
	* @return the legacy l2g sys that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyL2gSys updateLegacyL2gSys(
		de.uhh.l2g.plugins.migration.model.LegacyL2gSys legacyL2gSys)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyL2gSysLocalService.updateLegacyL2gSys(legacyL2gSys);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legacyL2gSysLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legacyL2gSysLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legacyL2gSysLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LegacyL2gSysLocalService getWrappedLegacyL2gSysLocalService() {
		return _legacyL2gSysLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegacyL2gSysLocalService(
		LegacyL2gSysLocalService legacyL2gSysLocalService) {
		_legacyL2gSysLocalService = legacyL2gSysLocalService;
	}

	@Override
	public LegacyL2gSysLocalService getWrappedService() {
		return _legacyL2gSysLocalService;
	}

	@Override
	public void setWrappedService(
		LegacyL2gSysLocalService legacyL2gSysLocalService) {
		_legacyL2gSysLocalService = legacyL2gSysLocalService;
	}

	private LegacyL2gSysLocalService _legacyL2gSysLocalService;
}