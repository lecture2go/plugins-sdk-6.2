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
 * Provides a wrapper for {@link SysLocalService}.
 *
 * @author Iavor Sturm
 * @see SysLocalService
 * @generated
 */
public class SysLocalServiceWrapper implements SysLocalService,
	ServiceWrapper<SysLocalService> {
	public SysLocalServiceWrapper(SysLocalService sysLocalService) {
		_sysLocalService = sysLocalService;
	}

	/**
	* Adds the sys to the database. Also notifies the appropriate model listeners.
	*
	* @param sys the sys
	* @return the sys that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Sys addSys(de.uhh.l2g.plugins.model.Sys sys)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sysLocalService.addSys(sys);
	}

	/**
	* Creates a new sys with the primary key. Does not add the sys to the database.
	*
	* @param sysId the primary key for the new sys
	* @return the new sys
	*/
	@Override
	public de.uhh.l2g.plugins.model.Sys createSys(int sysId) {
		return _sysLocalService.createSys(sysId);
	}

	/**
	* Deletes the sys with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sysId the primary key of the sys
	* @return the sys that was removed
	* @throws PortalException if a sys with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Sys deleteSys(int sysId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sysLocalService.deleteSys(sysId);
	}

	/**
	* Deletes the sys from the database. Also notifies the appropriate model listeners.
	*
	* @param sys the sys
	* @return the sys that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Sys deleteSys(
		de.uhh.l2g.plugins.model.Sys sys)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sysLocalService.deleteSys(sys);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sysLocalService.dynamicQuery();
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
		return _sysLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _sysLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _sysLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _sysLocalService.dynamicQueryCount(dynamicQuery);
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
		return _sysLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Sys fetchSys(int sysId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sysLocalService.fetchSys(sysId);
	}

	/**
	* Returns the sys with the primary key.
	*
	* @param sysId the primary key of the sys
	* @return the sys
	* @throws PortalException if a sys with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Sys getSys(int sysId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sysLocalService.getSys(sysId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sysLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the syses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.SysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of syses
	* @param end the upper bound of the range of syses (not inclusive)
	* @return the range of syses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Sys> getSyses(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _sysLocalService.getSyses(start, end);
	}

	/**
	* Returns the number of syses.
	*
	* @return the number of syses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSysesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sysLocalService.getSysesCount();
	}

	/**
	* Updates the sys in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sys the sys
	* @return the sys that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Sys updateSys(
		de.uhh.l2g.plugins.model.Sys sys)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sysLocalService.updateSys(sys);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sysLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sysLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sysLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SysLocalService getWrappedSysLocalService() {
		return _sysLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSysLocalService(SysLocalService sysLocalService) {
		_sysLocalService = sysLocalService;
	}

	@Override
	public SysLocalService getWrappedService() {
		return _sysLocalService;
	}

	@Override
	public void setWrappedService(SysLocalService sysLocalService) {
		_sysLocalService = sysLocalService;
	}

	private SysLocalService _sysLocalService;
}