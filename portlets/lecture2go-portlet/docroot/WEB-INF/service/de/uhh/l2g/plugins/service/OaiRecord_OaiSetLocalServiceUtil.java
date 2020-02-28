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
 * Provides the local service utility for OaiRecord_OaiSet. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.OaiRecord_OaiSetLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see OaiRecord_OaiSetLocalService
 * @see de.uhh.l2g.plugins.service.base.OaiRecord_OaiSetLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.OaiRecord_OaiSetLocalServiceImpl
 * @generated
 */
public class OaiRecord_OaiSetLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.OaiRecord_OaiSetLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the oai record_ oai set to the database. Also notifies the appropriate model listeners.
	*
	* @param oaiRecord_OaiSet the oai record_ oai set
	* @return the oai record_ oai set that was added
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet addOaiRecord_OaiSet(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addOaiRecord_OaiSet(oaiRecord_OaiSet);
	}

	/**
	* Creates a new oai record_ oai set with the primary key. Does not add the oai record_ oai set to the database.
	*
	* @param oaiRecordOaiSetId the primary key for the new oai record_ oai set
	* @return the new oai record_ oai set
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet createOaiRecord_OaiSet(
		long oaiRecordOaiSetId) {
		return getService().createOaiRecord_OaiSet(oaiRecordOaiSetId);
	}

	/**
	* Deletes the oai record_ oai set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	* @return the oai record_ oai set that was removed
	* @throws PortalException if a oai record_ oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet deleteOaiRecord_OaiSet(
		long oaiRecordOaiSetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOaiRecord_OaiSet(oaiRecordOaiSetId);
	}

	/**
	* Deletes the oai record_ oai set from the database. Also notifies the appropriate model listeners.
	*
	* @param oaiRecord_OaiSet the oai record_ oai set
	* @return the oai record_ oai set that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet deleteOaiRecord_OaiSet(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOaiRecord_OaiSet(oaiRecord_OaiSet);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet fetchOaiRecord_OaiSet(
		long oaiRecordOaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOaiRecord_OaiSet(oaiRecordOaiSetId);
	}

	/**
	* Returns the oai record_ oai set with the primary key.
	*
	* @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	* @return the oai record_ oai set
	* @throws PortalException if a oai record_ oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet getOaiRecord_OaiSet(
		long oaiRecordOaiSetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOaiRecord_OaiSet(oaiRecordOaiSetId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the oai record_ oai sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oai record_ oai sets
	* @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	* @return the range of oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> getOaiRecord_OaiSets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOaiRecord_OaiSets(start, end);
	}

	/**
	* Returns the number of oai record_ oai sets.
	*
	* @return the number of oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public static int getOaiRecord_OaiSetsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOaiRecord_OaiSetsCount();
	}

	/**
	* Updates the oai record_ oai set in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oaiRecord_OaiSet the oai record_ oai set
	* @return the oai record_ oai set that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet updateOaiRecord_OaiSet(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOaiRecord_OaiSet(oaiRecord_OaiSet);
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

	public static OaiRecord_OaiSetLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					OaiRecord_OaiSetLocalService.class.getName());

			if (invokableLocalService instanceof OaiRecord_OaiSetLocalService) {
				_service = (OaiRecord_OaiSetLocalService)invokableLocalService;
			}
			else {
				_service = new OaiRecord_OaiSetLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(OaiRecord_OaiSetLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(OaiRecord_OaiSetLocalService service) {
	}

	private static OaiRecord_OaiSetLocalService _service;
}