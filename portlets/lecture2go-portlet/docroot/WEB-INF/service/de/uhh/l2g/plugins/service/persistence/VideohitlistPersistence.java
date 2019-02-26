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

import de.uhh.l2g.plugins.model.Videohitlist;

/**
 * The persistence interface for the videohitlist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideohitlistPersistenceImpl
 * @see VideohitlistUtil
 * @generated
 */
public interface VideohitlistPersistence extends BasePersistence<Videohitlist> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideohitlistUtil} to access the videohitlist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the videohitlists where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching videohitlists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Videohitlist> findByVideo(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videohitlists where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of videohitlists
	* @param end the upper bound of the range of videohitlists (not inclusive)
	* @return the range of matching videohitlists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Videohitlist> findByVideo(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videohitlists where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of videohitlists
	* @param end the upper bound of the range of videohitlists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching videohitlists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Videohitlist> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first videohitlist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching videohitlist
	* @throws de.uhh.l2g.plugins.NoSuchVideohitlistException if a matching videohitlist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Videohitlist findByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideohitlistException;

	/**
	* Returns the first videohitlist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Videohitlist fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last videohitlist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching videohitlist
	* @throws de.uhh.l2g.plugins.NoSuchVideohitlistException if a matching videohitlist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Videohitlist findByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideohitlistException;

	/**
	* Returns the last videohitlist in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Videohitlist fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videohitlists before and after the current videohitlist in the ordered set where videoId = &#63;.
	*
	* @param videohitlistId the primary key of the current videohitlist
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next videohitlist
	* @throws de.uhh.l2g.plugins.NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Videohitlist[] findByVideo_PrevAndNext(
		long videohitlistId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideohitlistException;

	/**
	* Removes all the videohitlists where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videohitlists where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching videohitlists
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the videohitlist in the entity cache if it is enabled.
	*
	* @param videohitlist the videohitlist
	*/
	public void cacheResult(de.uhh.l2g.plugins.model.Videohitlist videohitlist);

	/**
	* Caches the videohitlists in the entity cache if it is enabled.
	*
	* @param videohitlists the videohitlists
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Videohitlist> videohitlists);

	/**
	* Creates a new videohitlist with the primary key. Does not add the videohitlist to the database.
	*
	* @param videohitlistId the primary key for the new videohitlist
	* @return the new videohitlist
	*/
	public de.uhh.l2g.plugins.model.Videohitlist create(long videohitlistId);

	/**
	* Removes the videohitlist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videohitlistId the primary key of the videohitlist
	* @return the videohitlist that was removed
	* @throws de.uhh.l2g.plugins.NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Videohitlist remove(long videohitlistId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideohitlistException;

	public de.uhh.l2g.plugins.model.Videohitlist updateImpl(
		de.uhh.l2g.plugins.model.Videohitlist videohitlist)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the videohitlist with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideohitlistException} if it could not be found.
	*
	* @param videohitlistId the primary key of the videohitlist
	* @return the videohitlist
	* @throws de.uhh.l2g.plugins.NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Videohitlist findByPrimaryKey(
		long videohitlistId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideohitlistException;

	/**
	* Returns the videohitlist with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videohitlistId the primary key of the videohitlist
	* @return the videohitlist, or <code>null</code> if a videohitlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Videohitlist fetchByPrimaryKey(
		long videohitlistId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the videohitlists.
	*
	* @return the videohitlists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Videohitlist> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the videohitlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videohitlists
	* @param end the upper bound of the range of videohitlists (not inclusive)
	* @return the range of videohitlists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Videohitlist> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the videohitlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videohitlists
	* @param end the upper bound of the range of videohitlists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of videohitlists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Videohitlist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the videohitlists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of videohitlists.
	*
	* @return the number of videohitlists
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}