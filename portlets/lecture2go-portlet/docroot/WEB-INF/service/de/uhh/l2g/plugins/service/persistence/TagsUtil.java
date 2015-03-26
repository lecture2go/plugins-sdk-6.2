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

import de.uhh.l2g.plugins.model.Tags;

import java.util.List;

/**
 * The persistence utility for the tags service. This utility wraps {@link TagsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see TagsPersistence
 * @see TagsPersistenceImpl
 * @generated
 */
public class TagsUtil {
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
	public static void clearCache(Tags tags) {
		getPersistence().clearCache(tags);
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
	public static List<Tags> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Tags> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Tags> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Tags update(Tags tags) throws SystemException {
		return getPersistence().update(tags);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Tags update(Tags tags, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(tags, serviceContext);
	}

	/**
	* Returns all the tagses where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @return the matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tags> findByIsVideo(
		int isVideo) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsVideo(isVideo);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Tags> findByIsVideo(
		int isVideo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsVideo(isVideo, start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Tags> findByIsVideo(
		int isVideo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsVideo(isVideo, start, end, orderByComparator);
	}

	/**
	* Returns the first tags in the ordered set where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags findByIsVideo_First(
		int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException {
		return getPersistence().findByIsVideo_First(isVideo, orderByComparator);
	}

	/**
	* Returns the first tags in the ordered set where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tags, or <code>null</code> if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags fetchByIsVideo_First(
		int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIsVideo_First(isVideo, orderByComparator);
	}

	/**
	* Returns the last tags in the ordered set where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags findByIsVideo_Last(
		int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException {
		return getPersistence().findByIsVideo_Last(isVideo, orderByComparator);
	}

	/**
	* Returns the last tags in the ordered set where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tags, or <code>null</code> if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags fetchByIsVideo_Last(
		int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIsVideo_Last(isVideo, orderByComparator);
	}

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
	public static de.uhh.l2g.plugins.model.Tags[] findByIsVideo_PrevAndNext(
		long tagId, int isVideo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException {
		return getPersistence()
				   .findByIsVideo_PrevAndNext(tagId, isVideo, orderByComparator);
	}

	/**
	* Removes all the tagses where isVideo = &#63; from the database.
	*
	* @param isVideo the is video
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIsVideo(int isVideo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIsVideo(isVideo);
	}

	/**
	* Returns the number of tagses where isVideo = &#63;.
	*
	* @param isVideo the is video
	* @return the number of matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIsVideo(int isVideo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIsVideo(isVideo);
	}

	/**
	* Returns all the tagses where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @return the matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tags> findByIsLectureseries(
		int isLectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsLectureseries(isLectureseries);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Tags> findByIsLectureseries(
		int isLectureseries, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsLectureseries(isLectureseries, start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Tags> findByIsLectureseries(
		int isLectureseries, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsLectureseries(isLectureseries, start, end,
			orderByComparator);
	}

	/**
	* Returns the first tags in the ordered set where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags findByIsLectureseries_First(
		int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException {
		return getPersistence()
				   .findByIsLectureseries_First(isLectureseries,
			orderByComparator);
	}

	/**
	* Returns the first tags in the ordered set where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tags, or <code>null</code> if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags fetchByIsLectureseries_First(
		int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsLectureseries_First(isLectureseries,
			orderByComparator);
	}

	/**
	* Returns the last tags in the ordered set where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags findByIsLectureseries_Last(
		int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException {
		return getPersistence()
				   .findByIsLectureseries_Last(isLectureseries,
			orderByComparator);
	}

	/**
	* Returns the last tags in the ordered set where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tags, or <code>null</code> if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags fetchByIsLectureseries_Last(
		int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsLectureseries_Last(isLectureseries,
			orderByComparator);
	}

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
	public static de.uhh.l2g.plugins.model.Tags[] findByIsLectureseries_PrevAndNext(
		long tagId, int isLectureseries,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException {
		return getPersistence()
				   .findByIsLectureseries_PrevAndNext(tagId, isLectureseries,
			orderByComparator);
	}

	/**
	* Removes all the tagses where isLectureseries = &#63; from the database.
	*
	* @param isLectureseries the is lectureseries
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIsLectureseries(int isLectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIsLectureseries(isLectureseries);
	}

	/**
	* Returns the number of tagses where isLectureseries = &#63;.
	*
	* @param isLectureseries the is lectureseries
	* @return the number of matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIsLectureseries(int isLectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIsLectureseries(isLectureseries);
	}

	/**
	* Returns all the tagses where tags = &#63;.
	*
	* @param tags the tags
	* @return the matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tags> findByTags(
		java.lang.String tags)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTags(tags);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Tags> findByTags(
		java.lang.String tags, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTags(tags, start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Tags> findByTags(
		java.lang.String tags, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTags(tags, start, end, orderByComparator);
	}

	/**
	* Returns the first tags in the ordered set where tags = &#63;.
	*
	* @param tags the tags
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags findByTags_First(
		java.lang.String tags,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException {
		return getPersistence().findByTags_First(tags, orderByComparator);
	}

	/**
	* Returns the first tags in the ordered set where tags = &#63;.
	*
	* @param tags the tags
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tags, or <code>null</code> if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags fetchByTags_First(
		java.lang.String tags,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTags_First(tags, orderByComparator);
	}

	/**
	* Returns the last tags in the ordered set where tags = &#63;.
	*
	* @param tags the tags
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags findByTags_Last(
		java.lang.String tags,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException {
		return getPersistence().findByTags_Last(tags, orderByComparator);
	}

	/**
	* Returns the last tags in the ordered set where tags = &#63;.
	*
	* @param tags the tags
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tags, or <code>null</code> if a matching tags could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags fetchByTags_Last(
		java.lang.String tags,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTags_Last(tags, orderByComparator);
	}

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
	public static de.uhh.l2g.plugins.model.Tags[] findByTags_PrevAndNext(
		long tagId, java.lang.String tags,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException {
		return getPersistence()
				   .findByTags_PrevAndNext(tagId, tags, orderByComparator);
	}

	/**
	* Removes all the tagses where tags = &#63; from the database.
	*
	* @param tags the tags
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTags(java.lang.String tags)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTags(tags);
	}

	/**
	* Returns the number of tagses where tags = &#63;.
	*
	* @param tags the tags
	* @return the number of matching tagses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTags(java.lang.String tags)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTags(tags);
	}

	/**
	* Caches the tags in the entity cache if it is enabled.
	*
	* @param tags the tags
	*/
	public static void cacheResult(de.uhh.l2g.plugins.model.Tags tags) {
		getPersistence().cacheResult(tags);
	}

	/**
	* Caches the tagses in the entity cache if it is enabled.
	*
	* @param tagses the tagses
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Tags> tagses) {
		getPersistence().cacheResult(tagses);
	}

	/**
	* Creates a new tags with the primary key. Does not add the tags to the database.
	*
	* @param tagId the primary key for the new tags
	* @return the new tags
	*/
	public static de.uhh.l2g.plugins.model.Tags create(long tagId) {
		return getPersistence().create(tagId);
	}

	/**
	* Removes the tags with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagId the primary key of the tags
	* @return the tags that was removed
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags remove(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException {
		return getPersistence().remove(tagId);
	}

	public static de.uhh.l2g.plugins.model.Tags updateImpl(
		de.uhh.l2g.plugins.model.Tags tags)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tags);
	}

	/**
	* Returns the tags with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchTagsException} if it could not be found.
	*
	* @param tagId the primary key of the tags
	* @return the tags
	* @throws de.uhh.l2g.plugins.NoSuchTagsException if a tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags findByPrimaryKey(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagsException {
		return getPersistence().findByPrimaryKey(tagId);
	}

	/**
	* Returns the tags with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tagId the primary key of the tags
	* @return the tags, or <code>null</code> if a tags with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Tags fetchByPrimaryKey(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tagId);
	}

	/**
	* Returns all the tagses.
	*
	* @return the tagses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tags> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Tags> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Tags> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tagses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tagses.
	*
	* @return the number of tagses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TagsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TagsPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					TagsPersistence.class.getName());

			ReferenceRegistry.registerReference(TagsUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TagsPersistence persistence) {
	}

	private static TagsPersistence _persistence;
}