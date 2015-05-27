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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ServerTemplate. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.ServerTemplateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see ServerTemplateLocalService
 * @see de.uhh.l2g.plugins.service.base.ServerTemplateLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.ServerTemplateLocalServiceImpl
 * @generated
 */
public class ServerTemplateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.ServerTemplateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the server template to the database. Also notifies the appropriate model listeners.
	*
	* @param serverTemplate the server template
	* @return the server template that was added
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate addServerTemplate(
		de.uhh.l2g.plugins.model.ServerTemplate serverTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addServerTemplate(serverTemplate);
	}

	/**
	* Creates a new server template with the primary key. Does not add the server template to the database.
	*
	* @param serverTemplateId the primary key for the new server template
	* @return the new server template
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate createServerTemplate(
		long serverTemplateId) {
		return getService().createServerTemplate(serverTemplateId);
	}

	/**
	* Deletes the server template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serverTemplateId the primary key of the server template
	* @return the server template that was removed
	* @throws PortalException if a server template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate deleteServerTemplate(
		long serverTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteServerTemplate(serverTemplateId);
	}

	/**
	* Deletes the server template from the database. Also notifies the appropriate model listeners.
	*
	* @param serverTemplate the server template
	* @return the server template that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate deleteServerTemplate(
		de.uhh.l2g.plugins.model.ServerTemplate serverTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteServerTemplate(serverTemplate);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static de.uhh.l2g.plugins.model.ServerTemplate fetchServerTemplate(
		long serverTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchServerTemplate(serverTemplateId);
	}

	/**
	* Returns the server template with the primary key.
	*
	* @param serverTemplateId the primary key of the server template
	* @return the server template
	* @throws PortalException if a server template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate getServerTemplate(
		long serverTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getServerTemplate(serverTemplateId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> getServerTemplates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getServerTemplates(start, end);
	}

	/**
	* Returns the number of server templates.
	*
	* @return the number of server templates
	* @throws SystemException if a system exception occurred
	*/
	public static int getServerTemplatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getServerTemplatesCount();
	}

	/**
	* Updates the server template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serverTemplate the server template
	* @return the server template that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate updateServerTemplate(
		de.uhh.l2g.plugins.model.ServerTemplate serverTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateServerTemplate(serverTemplate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static de.uhh.l2g.plugins.model.ServerTemplate getById(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getById(institutionId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> getByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByGroupId(groupId);
	}

	public static boolean getDeviceSpecificByServerTemplateId(
		long serverTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDeviceSpecificByServerTemplateId(serverTemplateId);
	}

	public static de.uhh.l2g.plugins.model.ServerTemplate addServerTemplate(
		java.lang.String name, int type, java.lang.String templateURL,
		java.lang.String prefixURL, java.lang.String suffixURL,
		java.lang.String secExt, long iosId, long androidId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addServerTemplate(name, type, templateURL, prefixURL,
			suffixURL, secExt, iosId, androidId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ServerTemplateLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ServerTemplateLocalService.class.getName());

			if (invokableLocalService instanceof ServerTemplateLocalService) {
				_service = (ServerTemplateLocalService)invokableLocalService;
			}
			else {
				_service = new ServerTemplateLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ServerTemplateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ServerTemplateLocalService service) {
	}

	private static ServerTemplateLocalService _service;
}