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

import de.uhh.l2g.plugins.model.Video_Institution;

import java.util.List;

/**
 * The persistence utility for the video_ institution service. This utility wraps {@link Video_InstitutionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_InstitutionPersistence
 * @see Video_InstitutionPersistenceImpl
 * @generated
 */
public class Video_InstitutionUtil {
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
	public static void clearCache(Video_Institution video_Institution) {
		getPersistence().clearCache(video_Institution);
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
	public static List<Video_Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Video_Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Video_Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Video_Institution update(Video_Institution video_Institution)
		throws SystemException {
		return getPersistence().update(video_Institution);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Video_Institution update(
		Video_Institution video_Institution, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(video_Institution, serviceContext);
	}

	/**
	* Returns all the video_ institutions where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Institution> findByVideo(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideo(videoId);
	}

	/**
	* Returns a range of all the video_ institutions where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video_ institutions
	* @param end the upper bound of the range of video_ institutions (not inclusive)
	* @return the range of matching video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Institution> findByVideo(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	* Returns an ordered range of all the video_ institutions where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video_ institutions
	* @param end the upper bound of the range of video_ institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Institution> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideo(videoId, start, end, orderByComparator);
	}

	/**
	* Returns the first video_ institution in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ institution
	* @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution findByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_InstitutionException {
		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the first video_ institution in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	* Returns the last video_ institution in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ institution
	* @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution findByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_InstitutionException {
		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the last video_ institution in the ordered set where videoId = &#63;.
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	* Returns the video_ institutions before and after the current video_ institution in the ordered set where videoId = &#63;.
	*
	* @param videoInstitutionId the primary key of the current video_ institution
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ institution
	* @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution[] findByVideo_PrevAndNext(
		long videoInstitutionId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_InstitutionException {
		return getPersistence()
				   .findByVideo_PrevAndNext(videoInstitutionId, videoId,
			orderByComparator);
	}

	/**
	* Removes all the video_ institutions where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVideo(videoId);
	}

	/**
	* Returns the number of video_ institutions where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVideo(videoId);
	}

	/**
	* Returns all the video_ institutions where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the matching video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Institution> findByInstitution(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByInstitution(institutionId);
	}

	/**
	* Returns a range of all the video_ institutions where institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionId the institution ID
	* @param start the lower bound of the range of video_ institutions
	* @param end the upper bound of the range of video_ institutions (not inclusive)
	* @return the range of matching video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Institution> findByInstitution(
		long institutionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByInstitution(institutionId, start, end);
	}

	/**
	* Returns an ordered range of all the video_ institutions where institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionId the institution ID
	* @param start the lower bound of the range of video_ institutions
	* @param end the upper bound of the range of video_ institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Institution> findByInstitution(
		long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByInstitution(institutionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first video_ institution in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ institution
	* @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution findByInstitution_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_InstitutionException {
		return getPersistence()
				   .findByInstitution_First(institutionId, orderByComparator);
	}

	/**
	* Returns the first video_ institution in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution fetchByInstitution_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByInstitution_First(institutionId, orderByComparator);
	}

	/**
	* Returns the last video_ institution in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ institution
	* @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution findByInstitution_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_InstitutionException {
		return getPersistence()
				   .findByInstitution_Last(institutionId, orderByComparator);
	}

	/**
	* Returns the last video_ institution in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution fetchByInstitution_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByInstitution_Last(institutionId, orderByComparator);
	}

	/**
	* Returns the video_ institutions before and after the current video_ institution in the ordered set where institutionId = &#63;.
	*
	* @param videoInstitutionId the primary key of the current video_ institution
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ institution
	* @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution[] findByInstitution_PrevAndNext(
		long videoInstitutionId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_InstitutionException {
		return getPersistence()
				   .findByInstitution_PrevAndNext(videoInstitutionId,
			institutionId, orderByComparator);
	}

	/**
	* Removes all the video_ institutions where institutionId = &#63; from the database.
	*
	* @param institutionId the institution ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByInstitution(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByInstitution(institutionId);
	}

	/**
	* Returns the number of video_ institutions where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the number of matching video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByInstitution(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByInstitution(institutionId);
	}

	/**
	* Returns all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	*
	* @param videoId the video ID
	* @param institutionId the institution ID
	* @return the matching video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Institution> findByVideoInstitution(
		long videoId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideoInstitution(videoId, institutionId);
	}

	/**
	* Returns a range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param institutionId the institution ID
	* @param start the lower bound of the range of video_ institutions
	* @param end the upper bound of the range of video_ institutions (not inclusive)
	* @return the range of matching video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Institution> findByVideoInstitution(
		long videoId, long institutionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideoInstitution(videoId, institutionId, start, end);
	}

	/**
	* Returns an ordered range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videoId the video ID
	* @param institutionId the institution ID
	* @param start the lower bound of the range of video_ institutions
	* @param end the upper bound of the range of video_ institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Institution> findByVideoInstitution(
		long videoId, long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideoInstitution(videoId, institutionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	*
	* @param videoId the video ID
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ institution
	* @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution findByVideoInstitution_First(
		long videoId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_InstitutionException {
		return getPersistence()
				   .findByVideoInstitution_First(videoId, institutionId,
			orderByComparator);
	}

	/**
	* Returns the first video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	*
	* @param videoId the video ID
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution fetchByVideoInstitution_First(
		long videoId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVideoInstitution_First(videoId, institutionId,
			orderByComparator);
	}

	/**
	* Returns the last video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	*
	* @param videoId the video ID
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ institution
	* @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution findByVideoInstitution_Last(
		long videoId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_InstitutionException {
		return getPersistence()
				   .findByVideoInstitution_Last(videoId, institutionId,
			orderByComparator);
	}

	/**
	* Returns the last video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	*
	* @param videoId the video ID
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution fetchByVideoInstitution_Last(
		long videoId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVideoInstitution_Last(videoId, institutionId,
			orderByComparator);
	}

	/**
	* Returns the video_ institutions before and after the current video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	*
	* @param videoInstitutionId the primary key of the current video_ institution
	* @param videoId the video ID
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video_ institution
	* @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution[] findByVideoInstitution_PrevAndNext(
		long videoInstitutionId, long videoId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_InstitutionException {
		return getPersistence()
				   .findByVideoInstitution_PrevAndNext(videoInstitutionId,
			videoId, institutionId, orderByComparator);
	}

	/**
	* Removes all the video_ institutions where videoId = &#63; and institutionId = &#63; from the database.
	*
	* @param videoId the video ID
	* @param institutionId the institution ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideoInstitution(long videoId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVideoInstitution(videoId, institutionId);
	}

	/**
	* Returns the number of video_ institutions where videoId = &#63; and institutionId = &#63;.
	*
	* @param videoId the video ID
	* @param institutionId the institution ID
	* @return the number of matching video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideoInstitution(long videoId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVideoInstitution(videoId, institutionId);
	}

	/**
	* Caches the video_ institution in the entity cache if it is enabled.
	*
	* @param video_Institution the video_ institution
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Video_Institution video_Institution) {
		getPersistence().cacheResult(video_Institution);
	}

	/**
	* Caches the video_ institutions in the entity cache if it is enabled.
	*
	* @param video_Institutions the video_ institutions
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Video_Institution> video_Institutions) {
		getPersistence().cacheResult(video_Institutions);
	}

	/**
	* Creates a new video_ institution with the primary key. Does not add the video_ institution to the database.
	*
	* @param videoInstitutionId the primary key for the new video_ institution
	* @return the new video_ institution
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution create(
		long videoInstitutionId) {
		return getPersistence().create(videoInstitutionId);
	}

	/**
	* Removes the video_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoInstitutionId the primary key of the video_ institution
	* @return the video_ institution that was removed
	* @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution remove(
		long videoInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_InstitutionException {
		return getPersistence().remove(videoInstitutionId);
	}

	public static de.uhh.l2g.plugins.model.Video_Institution updateImpl(
		de.uhh.l2g.plugins.model.Video_Institution video_Institution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(video_Institution);
	}

	/**
	* Returns the video_ institution with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideo_InstitutionException} if it could not be found.
	*
	* @param videoInstitutionId the primary key of the video_ institution
	* @return the video_ institution
	* @throws de.uhh.l2g.plugins.NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution findByPrimaryKey(
		long videoInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideo_InstitutionException {
		return getPersistence().findByPrimaryKey(videoInstitutionId);
	}

	/**
	* Returns the video_ institution with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoInstitutionId the primary key of the video_ institution
	* @return the video_ institution, or <code>null</code> if a video_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Video_Institution fetchByPrimaryKey(
		long videoInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videoInstitutionId);
	}

	/**
	* Returns all the video_ institutions.
	*
	* @return the video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Institution> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video_ institutions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ institutions
	* @param end the upper bound of the range of video_ institutions (not inclusive)
	* @return the range of video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Institution> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video_ institutions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ institutions
	* @param end the upper bound of the range of video_ institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Institution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video_ institutions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video_ institutions.
	*
	* @return the number of video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Video_InstitutionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Video_InstitutionPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					Video_InstitutionPersistence.class.getName());

			ReferenceRegistry.registerReference(Video_InstitutionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Video_InstitutionPersistence persistence) {
	}

	private static Video_InstitutionPersistence _persistence;
}