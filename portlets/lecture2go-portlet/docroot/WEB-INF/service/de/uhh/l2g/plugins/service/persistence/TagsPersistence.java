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

import de.uhh.l2g.plugins.model.Tags;

/**
 * The persistence interface for the tags service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see TagsPersistenceImpl
 * @see TagsUtil
 * @generated
 */
public interface TagsPersistence extends BasePersistence<Tags> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TagsUtil} to access the tags persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tagses where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @return the matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tags> findByIsVideo(
		int isVideo) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tagses where isVideo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isVideo the is video
	* @param start the lower bound of the range of tagses
	* @param end the upper bound of the range of tagses (not inclusive)
	* @return the range of matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tags> findByIsVideo(
		int isVideo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tagses where isVideo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isVideo the is video
	* @param start the lower bound of the range of tagses
	* @param end the upper bound of the range of tagses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tags> findByIsVideo(
		int isVideo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tags in the ordered set where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags findByIsVideo_First(int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException;

	/**
	* Returns the first tags in the ordered set where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tags, or <code>null</code> if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags fetchByIsVideo_First(int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tags in the ordered set where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags findByIsVideo_Last(int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException;

	/**
	* Returns the last tags in the ordered set where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tags, or <code>null</code> if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags fetchByIsVideo_Last(int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tagses before and after the current tags in the ordered set where isVideo = &#63;.
	*
	* @param tagId the primary key of the current tags
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags[] findByIsVideo_PrevAndNext(
		long tagId, int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException;

	/**
	* Removes all the tagses where isVideo = &#63; from the database.
	*
	* @param isVideo the is video
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIsVideo(int isVideo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tagses where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @return the number of matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public int countByIsVideo(int isVideo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tagses where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @return the matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tags> findByIsLectureseries(
		int isLectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tagses where isLectureseries = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isLectureseries the is lectureseries
	* @param start the lower bound of the range of tagses
	* @param end the upper bound of the range of tagses (not inclusive)
	* @return the range of matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tags> findByIsLectureseries(
		int isLectureseries, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tagses where isLectureseries = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isLectureseries the is lectureseries
	* @param start the lower bound of the range of tagses
	* @param end the upper bound of the range of tagses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tags> findByIsLectureseries(
		int isLectureseries, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tags in the ordered set where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags findByIsLectureseries_First(
		int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException;

	/**
	* Returns the first tags in the ordered set where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tags, or <code>null</code> if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags fetchByIsLectureseries_First(
		int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tags in the ordered set where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags findByIsLectureseries_Last(
		int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException;

	/**
	* Returns the last tags in the ordered set where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tags, or <code>null</code> if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags fetchByIsLectureseries_Last(
		int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tagses before and after the current tags in the ordered set where isLectureseries = &#63;.
	*
	* @param tagId the primary key of the current tags
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags[] findByIsLectureseries_PrevAndNext(
		long tagId, int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException;

	/**
	* Removes all the tagses where isLectureseries = &#63; from the database.
	*
	* @param isLectureseries the is lectureseries
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIsLectureseries(int isLectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tagses where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @return the number of matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public int countByIsLectureseries(int isLectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tagses where tags = &#63;.
	*
	* @param tags the tags
	* @return the matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tags> findByTags(
		java.lang.String tags)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tagses where tags = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tags the tags
	* @param start the lower bound of the range of tagses
	* @param end the upper bound of the range of tagses (not inclusive)
	* @return the range of matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tags> findByTags(
		java.lang.String tags, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tagses where tags = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tags the tags
	* @param start the lower bound of the range of tagses
	* @param end the upper bound of the range of tagses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tags> findByTags(
		java.lang.String tags, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tags in the ordered set where tags = &#63;.
	*
	* @param tags the tags
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags findByTags_First(
		java.lang.String tags,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException;

	/**
	* Returns the first tags in the ordered set where tags = &#63;.
	*
	* @param tags the tags
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tags, or <code>null</code> if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags fetchByTags_First(
		java.lang.String tags,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tags in the ordered set where tags = &#63;.
	*
	* @param tags the tags
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags findByTags_Last(
		java.lang.String tags,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException;

	/**
	* Returns the last tags in the ordered set where tags = &#63;.
	*
	* @param tags the tags
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tags, or <code>null</code> if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags fetchByTags_Last(
		java.lang.String tags,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tagses before and after the current tags in the ordered set where tags = &#63;.
	*
	* @param tagId the primary key of the current tags
	* @param tags the tags
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags[] findByTags_PrevAndNext(long tagId,
		java.lang.String tags,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException;

	/**
	* Removes all the tagses where tags = &#63; from the database.
	*
	* @param tags the tags
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTags(java.lang.String tags)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tagses where tags = &#63;.
	*
	* @param tags the tags
	* @return the number of matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public int countByTags(java.lang.String tags)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the tags in the entity cache if it is enabled.
	*
	* @param tags the tags
	*/
	public void cacheResult(de.uhh.l2g.plugins.model.Tags tags);

	/**
	* Caches the tagses in the entity cache if it is enabled.
	*
	* @param tagses the tagses
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Tags> tagses);

	/**
	* Creates a new tags with the primary key. Does not add the tags to the database.
	*
	* @param tagId the primary key for the new tags
	* @return the new tags
	*/
	public de.uhh.l2g.plugins.model.Tags create(long tagId);

	/**
	* Removes the tags with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagId the primary key of the tags
	* @return the tags that was removed
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags remove(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException;

	public de.uhh.l2g.plugins.model.Tags updateImpl(
		de.uhh.l2g.plugins.model.Tags tags)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tags with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchTagsException} if it could not be found.
	*
	* @param tagId the primary key of the tags
	* @return the tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags findByPrimaryKey(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException;

	/**
	* Returns the tags with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tagId the primary key of the tags
	* @return the tags, or <code>null</code> if a tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Tags fetchByPrimaryKey(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tagses.
	*
	* @return the tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tags> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tagses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tagses
	* @param end the upper bound of the range of tagses (not inclusive)
	* @return the range of tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tags> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tagses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tagses
	* @param end the upper bound of the range of tagses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tagses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Tags> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tagses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tagses.
	*
	* @return the number of tagses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}