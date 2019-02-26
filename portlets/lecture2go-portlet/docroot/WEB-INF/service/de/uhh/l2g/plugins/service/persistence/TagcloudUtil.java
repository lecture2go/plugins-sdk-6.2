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

import de.uhh.l2g.plugins.model.Tagcloud;

import java.util.List;

/**
 * The persistence utility for the tagcloud service. This utility wraps {@link TagcloudPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see TagcloudPersistence
 * @see TagcloudPersistenceImpl
 * @generated
 */
public class TagcloudUtil {
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
	public static void clearCache(Tagcloud tagcloud) {
		getPersistence().clearCache(tagcloud);
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
	public static List<Tagcloud> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Tagcloud> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Tagcloud> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Tagcloud update(Tagcloud tagcloud) throws SystemException {
		return getPersistence().update(tagcloud);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Tagcloud update(Tagcloud tagcloud,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tagcloud, serviceContext);
	}

	/**
	* Returns all the tagclouds where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @return the matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByObjectClassType(
		java.lang.String objectClassType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByObjectClassType(objectClassType);
	}

	/**
	* Returns a range of all the tagclouds where objectClassType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param objectClassType the object class type
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @return the range of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByObjectClassType(
		java.lang.String objectClassType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByObjectClassType(objectClassType, start, end);
	}

	/**
	* Returns an ordered range of all the tagclouds where objectClassType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param objectClassType the object class type
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByObjectClassType(
		java.lang.String objectClassType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByObjectClassType(objectClassType, start, end,
			orderByComparator);
	}

	/**
	* Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud findByObjectClassType_First(
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException {
		return getPersistence()
				   .findByObjectClassType_First(objectClassType,
			orderByComparator);
	}

	/**
	* Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud fetchByObjectClassType_First(
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByObjectClassType_First(objectClassType,
			orderByComparator);
	}

	/**
	* Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud findByObjectClassType_Last(
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException {
		return getPersistence()
				   .findByObjectClassType_Last(objectClassType,
			orderByComparator);
	}

	/**
	* Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud fetchByObjectClassType_Last(
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByObjectClassType_Last(objectClassType,
			orderByComparator);
	}

	/**
	* Returns the tagclouds before and after the current tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param tagcloudId the primary key of the current tagcloud
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud[] findByObjectClassType_PrevAndNext(
		long tagcloudId, java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException {
		return getPersistence()
				   .findByObjectClassType_PrevAndNext(tagcloudId,
			objectClassType, orderByComparator);
	}

	/**
	* Removes all the tagclouds where objectClassType = &#63; from the database.
	*
	* @param objectClassType the object class type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByObjectClassType(java.lang.String objectClassType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByObjectClassType(objectClassType);
	}

	/**
	* Returns the number of tagclouds where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @return the number of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByObjectClassType(java.lang.String objectClassType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByObjectClassType(objectClassType);
	}

	/**
	* Returns all the tagclouds where objectId = &#63;.
	*
	* @param objectId the object ID
	* @return the matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByObjectId(
		long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByObjectId(objectId);
	}

	/**
	* Returns a range of all the tagclouds where objectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param objectId the object ID
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @return the range of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByObjectId(
		long objectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByObjectId(objectId, start, end);
	}

	/**
	* Returns an ordered range of all the tagclouds where objectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param objectId the object ID
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByObjectId(
		long objectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByObjectId(objectId, start, end, orderByComparator);
	}

	/**
	* Returns the first tagcloud in the ordered set where objectId = &#63;.
	*
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud findByObjectId_First(
		long objectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException {
		return getPersistence().findByObjectId_First(objectId, orderByComparator);
	}

	/**
	* Returns the first tagcloud in the ordered set where objectId = &#63;.
	*
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud fetchByObjectId_First(
		long objectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByObjectId_First(objectId, orderByComparator);
	}

	/**
	* Returns the last tagcloud in the ordered set where objectId = &#63;.
	*
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud findByObjectId_Last(
		long objectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException {
		return getPersistence().findByObjectId_Last(objectId, orderByComparator);
	}

	/**
	* Returns the last tagcloud in the ordered set where objectId = &#63;.
	*
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud fetchByObjectId_Last(
		long objectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByObjectId_Last(objectId, orderByComparator);
	}

	/**
	* Returns the tagclouds before and after the current tagcloud in the ordered set where objectId = &#63;.
	*
	* @param tagcloudId the primary key of the current tagcloud
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud[] findByObjectId_PrevAndNext(
		long tagcloudId, long objectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException {
		return getPersistence()
				   .findByObjectId_PrevAndNext(tagcloudId, objectId,
			orderByComparator);
	}

	/**
	* Removes all the tagclouds where objectId = &#63; from the database.
	*
	* @param objectId the object ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByObjectId(long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByObjectId(objectId);
	}

	/**
	* Returns the number of tagclouds where objectId = &#63;.
	*
	* @param objectId the object ID
	* @return the number of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByObjectId(long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByObjectId(objectId);
	}

	/**
	* Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchTagcloudException} if it could not be found.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @return the matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud findByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException {
		return getPersistence()
				   .findByObjectClassTypeAndObjectId(objectClassType, objectId);
	}

	/**
	* Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud fetchByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByObjectClassTypeAndObjectId(objectClassType, objectId);
	}

	/**
	* Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud fetchByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByObjectClassTypeAndObjectId(objectClassType,
			objectId, retrieveFromCache);
	}

	/**
	* Removes the tagcloud where objectClassType = &#63; and objectId = &#63; from the database.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @return the tagcloud that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud removeByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException {
		return getPersistence()
				   .removeByObjectClassTypeAndObjectId(objectClassType, objectId);
	}

	/**
	* Returns the number of tagclouds where objectClassType = &#63; and objectId = &#63;.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @return the number of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByObjectClassTypeAndObjectId(objectClassType, objectId);
	}

	/**
	* Caches the tagcloud in the entity cache if it is enabled.
	*
	* @param tagcloud the tagcloud
	*/
	public static void cacheResult(de.uhh.l2g.plugins.model.Tagcloud tagcloud) {
		getPersistence().cacheResult(tagcloud);
	}

	/**
	* Caches the tagclouds in the entity cache if it is enabled.
	*
	* @param tagclouds the tagclouds
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Tagcloud> tagclouds) {
		getPersistence().cacheResult(tagclouds);
	}

	/**
	* Creates a new tagcloud with the primary key. Does not add the tagcloud to the database.
	*
	* @param tagcloudId the primary key for the new tagcloud
	* @return the new tagcloud
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud create(long tagcloudId) {
		return getPersistence().create(tagcloudId);
	}

	/**
	* Removes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud that was removed
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud remove(long tagcloudId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException {
		return getPersistence().remove(tagcloudId);
	}

	public static de.uhh.l2g.plugins.model.Tagcloud updateImpl(
		de.uhh.l2g.plugins.model.Tagcloud tagcloud)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tagcloud);
	}

	/**
	* Returns the tagcloud with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchTagcloudException} if it could not be found.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud findByPrimaryKey(
		long tagcloudId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException {
		return getPersistence().findByPrimaryKey(tagcloudId);
	}

	/**
	* Returns the tagcloud with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud, or <code>null</code> if a tagcloud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud fetchByPrimaryKey(
		long tagcloudId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tagcloudId);
	}

	/**
	* Returns all the tagclouds.
	*
	* @return the tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tagclouds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @return the range of tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tagclouds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tagclouds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tagclouds.
	*
	* @return the number of tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TagcloudPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TagcloudPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					TagcloudPersistence.class.getName());

			ReferenceRegistry.registerReference(TagcloudUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TagcloudPersistence persistence) {
	}

	private static TagcloudPersistence _persistence;
}