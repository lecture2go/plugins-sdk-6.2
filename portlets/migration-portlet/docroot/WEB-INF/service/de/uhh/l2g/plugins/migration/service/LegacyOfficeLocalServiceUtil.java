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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LegacyOffice. This utility wraps
 * {@link de.uhh.l2g.plugins.migration.service.impl.LegacyOfficeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author unihh
 * @see LegacyOfficeLocalService
 * @see de.uhh.l2g.plugins.migration.service.base.LegacyOfficeLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.migration.service.impl.LegacyOfficeLocalServiceImpl
 * @generated
 */
public class LegacyOfficeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.migration.service.impl.LegacyOfficeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the legacy office to the database. Also notifies the appropriate model listeners.
	*
	* @param legacyOffice the legacy office
	* @return the legacy office that was added
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyOffice addLegacyOffice(
		de.uhh.l2g.plugins.migration.model.LegacyOffice legacyOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLegacyOffice(legacyOffice);
	}

	/**
	* Creates a new legacy office with the primary key. Does not add the legacy office to the database.
	*
	* @param id the primary key for the new legacy office
	* @return the new legacy office
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyOffice createLegacyOffice(
		long id) {
		return getService().createLegacyOffice(id);
	}

	/**
	* Deletes the legacy office with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy office
	* @return the legacy office that was removed
	* @throws PortalException if a legacy office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyOffice deleteLegacyOffice(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLegacyOffice(id);
	}

	/**
	* Deletes the legacy office from the database. Also notifies the appropriate model listeners.
	*
	* @param legacyOffice the legacy office
	* @return the legacy office that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyOffice deleteLegacyOffice(
		de.uhh.l2g.plugins.migration.model.LegacyOffice legacyOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLegacyOffice(legacyOffice);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.migration.model.LegacyOffice fetchLegacyOffice(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLegacyOffice(id);
	}

	/**
	* Returns the legacy office with the primary key.
	*
	* @param id the primary key of the legacy office
	* @return the legacy office
	* @throws PortalException if a legacy office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyOffice getLegacyOffice(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegacyOffice(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legacy offices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy offices
	* @param end the upper bound of the range of legacy offices (not inclusive)
	* @return the range of legacy offices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyOffice> getLegacyOffices(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegacyOffices(start, end);
	}

	/**
	* Returns the number of legacy offices.
	*
	* @return the number of legacy offices
	* @throws SystemException if a system exception occurred
	*/
	public static int getLegacyOfficesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegacyOfficesCount();
	}

	/**
	* Updates the legacy office in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legacyOffice the legacy office
	* @return the legacy office that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyOffice updateLegacyOffice(
		de.uhh.l2g.plugins.migration.model.LegacyOffice legacyOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLegacyOffice(legacyOffice);
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

	public static void clearService() {
		_service = null;
	}

	public static LegacyOfficeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LegacyOfficeLocalService.class.getName());

			if (invokableLocalService instanceof LegacyOfficeLocalService) {
				_service = (LegacyOfficeLocalService)invokableLocalService;
			}
			else {
				_service = new LegacyOfficeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LegacyOfficeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LegacyOfficeLocalService service) {
	}

	private static LegacyOfficeLocalService _service;
}