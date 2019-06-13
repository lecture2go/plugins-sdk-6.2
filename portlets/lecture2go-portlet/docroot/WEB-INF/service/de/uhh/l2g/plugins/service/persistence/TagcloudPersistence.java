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

import com.liferay.portal.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.model.Tagcloud;

/**
 * The persistence interface for the tagcloud service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see TagcloudPersistenceImpl
 * @see TagcloudUtil
 * @generated
 */
public interface TagcloudPersistence extends BasePersistence<Tagcloud> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TagcloudUtil} to access the tagcloud persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tagclouds where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @return the matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByObjectClassType(
		java.lang.String objectClassType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByObjectClassType(
		java.lang.String objectClassType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByObjectClassType(
		java.lang.String objectClassType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud findByObjectClassType_First(
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud fetchByObjectClassType_First(
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud findByObjectClassType_Last(
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud fetchByObjectClassType_Last(
		java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Tagcloud[] findByObjectClassType_PrevAndNext(
		long tagcloudId, java.lang.String objectClassType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Removes all the tagclouds where objectClassType = &#63; from the database.
	*
	* @param objectClassType the object class type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByObjectClassType(java.lang.String objectClassType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tagclouds where objectClassType = &#63;.
	*
	* @param objectClassType the object class type
	* @return the number of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public int countByObjectClassType(java.lang.String objectClassType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tagclouds where objectId = &#63;.
	*
	* @param objectId the object ID
	* @return the matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByObjectId(
		long objectId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByObjectId(
		long objectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByObjectId(
		long objectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tagcloud in the ordered set where objectId = &#63;.
	*
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud findByObjectId_First(
		long objectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Returns the first tagcloud in the ordered set where objectId = &#63;.
	*
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud fetchByObjectId_First(
		long objectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tagcloud in the ordered set where objectId = &#63;.
	*
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud findByObjectId_Last(
		long objectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Returns the last tagcloud in the ordered set where objectId = &#63;.
	*
	* @param objectId the object ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud fetchByObjectId_Last(
		long objectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Tagcloud[] findByObjectId_PrevAndNext(
		long tagcloudId, long objectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Removes all the tagclouds where objectId = &#63; from the database.
	*
	* @param objectId the object ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByObjectId(long objectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tagclouds where objectId = &#63;.
	*
	* @param objectId the object ID
	* @return the number of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public int countByObjectId(long objectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchTagcloudException} if it could not be found.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @return the matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud findByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud fetchByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud fetchByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the tagcloud where objectClassType = &#63; and objectId = &#63; from the database.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @return the tagcloud that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud removeByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Returns the number of tagclouds where objectClassType = &#63; and objectId = &#63;.
	*
	* @param objectClassType the object class type
	* @param objectId the object ID
	* @return the number of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public int countByObjectClassTypeAndObjectId(
		java.lang.String objectClassType, long objectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the tagcloud in the entity cache if it is enabled.
	*
	* @param tagcloud the tagcloud
	*/
	public void cacheResult(de.uhh.l2g.plugins.model.Tagcloud tagcloud);

	/**
	* Caches the tagclouds in the entity cache if it is enabled.
	*
	* @param tagclouds the tagclouds
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Tagcloud> tagclouds);

	/**
	* Creates a new tagcloud with the primary key. Does not add the tagcloud to the database.
	*
	* @param tagcloudId the primary key for the new tagcloud
	* @return the new tagcloud
	*/
	public de.uhh.l2g.plugins.model.Tagcloud create(long tagcloudId);

	/**
	* Removes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud that was removed
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud remove(long tagcloudId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	public de.uhh.l2g.plugins.model.Tagcloud updateImpl(
		de.uhh.l2g.plugins.model.Tagcloud tagcloud)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tagcloud with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchTagcloudException} if it could not be found.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud findByPrimaryKey(long tagcloudId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Returns the tagcloud with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud, or <code>null</code> if a tagcloud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud fetchByPrimaryKey(long tagcloudId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tagclouds.
	*
	* @return the tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tagclouds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tagclouds.
	*
	* @return the number of tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}