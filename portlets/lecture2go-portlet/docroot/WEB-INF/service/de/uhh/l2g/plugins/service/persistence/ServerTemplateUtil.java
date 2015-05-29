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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.model.ServerTemplate;

import java.util.List;

/**
 * The persistence utility for the server template service. This utility wraps {@link ServerTemplatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ServerTemplatePersistence
 * @see ServerTemplatePersistenceImpl
 * @generated
 */
public class ServerTemplateUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ServerTemplate serverTemplate) {
		getPersistence().clearCache(serverTemplate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ServerTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServerTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServerTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ServerTemplate update(ServerTemplate serverTemplate)
		throws SystemException {
		return getPersistence().update(serverTemplate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ServerTemplate update(ServerTemplate serverTemplate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(serverTemplate, serviceContext);
	}

	/**
	* Returns all the server templates where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching server templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the server templates where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of server templates
	* @param end the upper bound of the range of server templates (not inclusive)
	* @return the range of matching server templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the server templates where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of server templates
	* @param end the upper bound of the range of server templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching server templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first server template in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server template
	* @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a matching server template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchServerTemplateException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first server template in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server template, or <code>null</code> if a matching server template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last server template in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server template
	* @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a matching server template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchServerTemplateException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last server template in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server template, or <code>null</code> if a matching server template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the server templates before and after the current server template in the ordered set where groupId = &#63;.
	*
	* @param serverTemplateId the primary key of the current server template
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next server template
	* @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a server template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate[] findByGroupId_PrevAndNext(
		long serverTemplateId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchServerTemplateException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(serverTemplateId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the server templates where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of server templates where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching server templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the server templates where serverTemplateId = &#63;.
	*
	* @param serverTemplateId the server template ID
	* @return the matching server templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> findByDeviceSpecificURLs(
		long serverTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeviceSpecificURLs(serverTemplateId);
	}

	/**
	* Returns a range of all the server templates where serverTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param serverTemplateId the server template ID
	* @param start the lower bound of the range of server templates
	* @param end the upper bound of the range of server templates (not inclusive)
	* @return the range of matching server templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> findByDeviceSpecificURLs(
		long serverTemplateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDeviceSpecificURLs(serverTemplateId, start, end);
	}

	/**
	* Returns an ordered range of all the server templates where serverTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param serverTemplateId the server template ID
	* @param start the lower bound of the range of server templates
	* @param end the upper bound of the range of server templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching server templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> findByDeviceSpecificURLs(
		long serverTemplateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDeviceSpecificURLs(serverTemplateId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first server template in the ordered set where serverTemplateId = &#63;.
	*
	* @param serverTemplateId the server template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server template
	* @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a matching server template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate findByDeviceSpecificURLs_First(
		long serverTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchServerTemplateException {
		return getPersistence()
				   .findByDeviceSpecificURLs_First(serverTemplateId,
			orderByComparator);
	}

	/**
	* Returns the first server template in the ordered set where serverTemplateId = &#63;.
	*
	* @param serverTemplateId the server template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server template, or <code>null</code> if a matching server template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate fetchByDeviceSpecificURLs_First(
		long serverTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDeviceSpecificURLs_First(serverTemplateId,
			orderByComparator);
	}

	/**
	* Returns the last server template in the ordered set where serverTemplateId = &#63;.
	*
	* @param serverTemplateId the server template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server template
	* @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a matching server template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate findByDeviceSpecificURLs_Last(
		long serverTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchServerTemplateException {
		return getPersistence()
				   .findByDeviceSpecificURLs_Last(serverTemplateId,
			orderByComparator);
	}

	/**
	* Returns the last server template in the ordered set where serverTemplateId = &#63;.
	*
	* @param serverTemplateId the server template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server template, or <code>null</code> if a matching server template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate fetchByDeviceSpecificURLs_Last(
		long serverTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDeviceSpecificURLs_Last(serverTemplateId,
			orderByComparator);
	}

	/**
	* Removes all the server templates where serverTemplateId = &#63; from the database.
	*
	* @param serverTemplateId the server template ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDeviceSpecificURLs(long serverTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDeviceSpecificURLs(serverTemplateId);
	}

	/**
	* Returns the number of server templates where serverTemplateId = &#63;.
	*
	* @param serverTemplateId the server template ID
	* @return the number of matching server templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDeviceSpecificURLs(long serverTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDeviceSpecificURLs(serverTemplateId);
	}

	/**
	* Returns all the server templates where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching server templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> findByDefaultServer(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDefaultServer(groupId);
	}

	/**
	* Returns a range of all the server templates where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of server templates
	* @param end the upper bound of the range of server templates (not inclusive)
	* @return the range of matching server templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> findByDefaultServer(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDefaultServer(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the server templates where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of server templates
	* @param end the upper bound of the range of server templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching server templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> findByDefaultServer(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDefaultServer(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first server template in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server template
	* @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a matching server template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate findByDefaultServer_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchServerTemplateException {
		return getPersistence()
				   .findByDefaultServer_First(groupId, orderByComparator);
	}

	/**
	* Returns the first server template in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server template, or <code>null</code> if a matching server template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate fetchByDefaultServer_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDefaultServer_First(groupId, orderByComparator);
	}

	/**
	* Returns the last server template in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server template
	* @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a matching server template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate findByDefaultServer_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchServerTemplateException {
		return getPersistence()
				   .findByDefaultServer_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last server template in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server template, or <code>null</code> if a matching server template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate fetchByDefaultServer_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDefaultServer_Last(groupId, orderByComparator);
	}

	/**
	* Returns the server templates before and after the current server template in the ordered set where groupId = &#63;.
	*
	* @param serverTemplateId the primary key of the current server template
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next server template
	* @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a server template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate[] findByDefaultServer_PrevAndNext(
		long serverTemplateId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchServerTemplateException {
		return getPersistence()
				   .findByDefaultServer_PrevAndNext(serverTemplateId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the server templates where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDefaultServer(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDefaultServer(groupId);
	}

	/**
	* Returns the number of server templates where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching server templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDefaultServer(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDefaultServer(groupId);
	}

	/**
	* Caches the server template in the entity cache if it is enabled.
	*
	* @param serverTemplate the server template
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.ServerTemplate serverTemplate) {
		getPersistence().cacheResult(serverTemplate);
	}

	/**
	* Caches the server templates in the entity cache if it is enabled.
	*
	* @param serverTemplates the server templates
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> serverTemplates) {
		getPersistence().cacheResult(serverTemplates);
	}

	/**
	* Creates a new server template with the primary key. Does not add the server template to the database.
	*
	* @param serverTemplateId the primary key for the new server template
	* @return the new server template
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate create(
		long serverTemplateId) {
		return getPersistence().create(serverTemplateId);
	}

	/**
	* Removes the server template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serverTemplateId the primary key of the server template
	* @return the server template that was removed
	* @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a server template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate remove(
		long serverTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchServerTemplateException {
		return getPersistence().remove(serverTemplateId);
	}

	public static de.uhh.l2g.plugins.model.ServerTemplate updateImpl(
		de.uhh.l2g.plugins.model.ServerTemplate serverTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(serverTemplate);
	}

	/**
	* Returns the server template with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchServerTemplateException} if it could not be found.
	*
	* @param serverTemplateId the primary key of the server template
	* @return the server template
	* @throws de.uhh.l2g.plugins.NoSuchServerTemplateException if a server template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate findByPrimaryKey(
		long serverTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchServerTemplateException {
		return getPersistence().findByPrimaryKey(serverTemplateId);
	}

	/**
	* Returns the server template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serverTemplateId the primary key of the server template
	* @return the server template, or <code>null</code> if a server template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.ServerTemplate fetchByPrimaryKey(
		long serverTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(serverTemplateId);
	}

	/**
	* Returns all the server templates.
	*
	* @return the server templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the server templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ServerTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of server templates
	* @param end the upper bound of the range of server templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of server templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.ServerTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the server templates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of server templates.
	*
	* @return the number of server templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ServerTemplatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ServerTemplatePersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					ServerTemplatePersistence.class.getName());

			ReferenceRegistry.registerReference(ServerTemplateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ServerTemplatePersistence persistence) {
	}

	private static ServerTemplatePersistence _persistence;
}