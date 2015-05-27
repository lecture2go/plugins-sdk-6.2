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

package de.uhh.l2g.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ServerTemplateLocalService}.
 *
 * @author Iavor Sturm
 * @see ServerTemplateLocalService
 * @generated
 */
public class ServerTemplateLocalServiceWrapper
	implements ServerTemplateLocalService,
		ServiceWrapper<ServerTemplateLocalService> {
	public ServerTemplateLocalServiceWrapper(
		ServerTemplateLocalService serverTemplateLocalService) {
		_serverTemplateLocalService = serverTemplateLocalService;
	}

	/**
	* Adds the server template to the database. Also notifies the appropriate model listeners.
	*
	* @param serverTemplate the server template
	* @return the server template that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.ServerTemplate addServerTemplate(
		de.uhh.l2g.plugins.model.ServerTemplate serverTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.addServerTemplate(serverTemplate);
	}

	/**
	* Creates a new server template with the primary key. Does not add the server template to the database.
	*
	* @param serverTemplateId the primary key for the new server template
	* @return the new server template
	*/
	@Override
	public de.uhh.l2g.plugins.model.ServerTemplate createServerTemplate(
		long serverTemplateId) {
		return _serverTemplateLocalService.createServerTemplate(serverTemplateId);
	}

	/**
	* Deletes the server template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serverTemplateId the primary key of the server template
	* @return the server template that was removed
	* @throws PortalException if a server template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.ServerTemplate deleteServerTemplate(
		long serverTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.deleteServerTemplate(serverTemplateId);
	}

	/**
	* Deletes the server template from the database. Also notifies the appropriate model listeners.
	*
	* @param serverTemplate the server template
	* @return the server template that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.ServerTemplate deleteServerTemplate(
		de.uhh.l2g.plugins.model.ServerTemplate serverTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.deleteServerTemplate(serverTemplate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serverTemplateLocalService.dynamicQuery();
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
		return _serverTemplateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serverTemplateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serverTemplateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _serverTemplateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _serverTemplateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.ServerTemplate fetchServerTemplate(
		long serverTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.fetchServerTemplate(serverTemplateId);
	}

	/**
	* Returns the server template with the primary key.
	*
	* @param serverTemplateId the primary key of the server template
	* @return the server template
	* @throws PortalException if a server template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.ServerTemplate getServerTemplate(
		long serverTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.getServerTemplate(serverTemplateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the server templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of server templates
	* @param end the upper bound of the range of server templates (not inclusive)
	* @return the range of server templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> getServerTemplates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.getServerTemplates(start, end);
	}

	/**
	* Returns the number of server templates.
	*
	* @return the number of server templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getServerTemplatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.getServerTemplatesCount();
	}

	/**
	* Updates the server template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serverTemplate the server template
	* @return the server template that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.ServerTemplate updateServerTemplate(
		de.uhh.l2g.plugins.model.ServerTemplate serverTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.updateServerTemplate(serverTemplate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _serverTemplateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_serverTemplateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _serverTemplateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public de.uhh.l2g.plugins.model.ServerTemplate getById(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.getById(institutionId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> getByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.getByGroupId(groupId);
	}

	@Override
	public boolean getDeviceSpecificByServerTemplateId(long serverTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.getDeviceSpecificByServerTemplateId(serverTemplateId);
	}

	@Override
	public de.uhh.l2g.plugins.model.ServerTemplate addServerTemplate(
		java.lang.String name, int type, java.lang.String templateURL,
		java.lang.String prefixURL, java.lang.String suffixURL,
		java.lang.String secExt, long iosId, long androidId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serverTemplateLocalService.addServerTemplate(name, type,
			templateURL, prefixURL, suffixURL, secExt, iosId, androidId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ServerTemplateLocalService getWrappedServerTemplateLocalService() {
		return _serverTemplateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedServerTemplateLocalService(
		ServerTemplateLocalService serverTemplateLocalService) {
		_serverTemplateLocalService = serverTemplateLocalService;
	}

	@Override
	public ServerTemplateLocalService getWrappedService() {
		return _serverTemplateLocalService;
	}

	@Override
	public void setWrappedService(
		ServerTemplateLocalService serverTemplateLocalService) {
		_serverTemplateLocalService = serverTemplateLocalService;
	}

	private ServerTemplateLocalService _serverTemplateLocalService;
}