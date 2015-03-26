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
	* Returns all the tagclouds where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @return the matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByIsVideo(
		int isVideo) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tagclouds where isVideo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isVideo the is video
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @return the range of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByIsVideo(
		int isVideo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tagclouds where isVideo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isVideo the is video
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByIsVideo(
		int isVideo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tagcloud in the ordered set where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud findByIsVideo_First(int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Returns the first tagcloud in the ordered set where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud fetchByIsVideo_First(int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tagcloud in the ordered set where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud findByIsVideo_Last(int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Returns the last tagcloud in the ordered set where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud fetchByIsVideo_Last(int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tagclouds before and after the current tagcloud in the ordered set where isVideo = &#63;.
	*
	* @param tagcloudId the primary key of the current tagcloud
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud[] findByIsVideo_PrevAndNext(
		long tagcloudId, int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Removes all the tagclouds where isVideo = &#63; from the database.
	*
	* @param isVideo the is video
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIsVideo(int isVideo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tagclouds where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @return the number of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public int countByIsVideo(int isVideo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tagclouds where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @return the matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByIsLectureseries(
		int isLectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tagclouds where isLectureseries = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isLectureseries the is lectureseries
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @return the range of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByIsLectureseries(
		int isLectureseries, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tagclouds where isLectureseries = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isLectureseries the is lectureseries
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> findByIsLectureseries(
		int isLectureseries, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tagcloud in the ordered set where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud findByIsLectureseries_First(
		int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Returns the first tagcloud in the ordered set where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud fetchByIsLectureseries_First(
		int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tagcloud in the ordered set where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud findByIsLectureseries_Last(
		int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Returns the last tagcloud in the ordered set where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud fetchByIsLectureseries_Last(
		int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tagclouds before and after the current tagcloud in the ordered set where isLectureseries = &#63;.
	*
	* @param tagcloudId the primary key of the current tagcloud
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tagcloud
	* @throws de.uhh.l2g.plugins.NoSuchTagcloudException if a tagcloud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tagcloud[] findByIsLectureseries_PrevAndNext(
		long tagcloudId, int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException;

	/**
	* Removes all the tagclouds where isLectureseries = &#63; from the database.
	*
	* @param isLectureseries the is lectureseries
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIsLectureseries(int isLectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tagclouds where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @return the number of matching tagclouds
	* @throws SystemException if a system exception occurred
	*/
	public int countByIsLectureseries(int isLectureseries)
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