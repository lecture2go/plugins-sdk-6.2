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

import de.uhh.l2g.plugins.model.VideoStatistic;

import java.util.List;

/**
 * The persistence utility for the video statistic service. This utility wraps {@link VideoStatisticPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideoStatisticPersistence
 * @see VideoStatisticPersistenceImpl
 * @generated
 */
public class VideoStatisticUtil {
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
	public static void clearCache(VideoStatistic videoStatistic) {
		getPersistence().clearCache(videoStatistic);
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
	public static List<VideoStatistic> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoStatistic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoStatistic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VideoStatistic update(VideoStatistic videoStatistic)
		throws SystemException {
		return getPersistence().update(videoStatistic);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VideoStatistic update(VideoStatistic videoStatistic,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(videoStatistic, serviceContext);
	}

	/**
	* Returns all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching video statistics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> findByCompanyIdAndGroupId(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyIdAndGroupId(groupId, companyId);
	}

	/**
	* Returns a range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of matching video statistics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> findByCompanyIdAndGroupId(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndGroupId(groupId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video statistics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> findByCompanyIdAndGroupId(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndGroupId(groupId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic
	* @throws de.uhh.l2g.plugins.NoSuchVideoStatisticException if a matching video statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.VideoStatistic findByCompanyIdAndGroupId_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoStatisticException {
		return getPersistence()
				   .findByCompanyIdAndGroupId_First(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.VideoStatistic fetchByCompanyIdAndGroupId_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyIdAndGroupId_First(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic
	* @throws de.uhh.l2g.plugins.NoSuchVideoStatisticException if a matching video statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.VideoStatistic findByCompanyIdAndGroupId_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoStatisticException {
		return getPersistence()
				   .findByCompanyIdAndGroupId_Last(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.VideoStatistic fetchByCompanyIdAndGroupId_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyIdAndGroupId_Last(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the video statistics before and after the current video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param videoStatisticId the primary key of the current video statistic
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video statistic
	* @throws de.uhh.l2g.plugins.NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.VideoStatistic[] findByCompanyIdAndGroupId_PrevAndNext(
		long videoStatisticId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoStatisticException {
		return getPersistence()
				   .findByCompanyIdAndGroupId_PrevAndNext(videoStatisticId,
			groupId, companyId, orderByComparator);
	}

	/**
	* Removes all the video statistics where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyIdAndGroupId(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyIdAndGroupId(groupId, companyId);
	}

	/**
	* Returns the number of video statistics where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching video statistics
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyIdAndGroupId(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyIdAndGroupId(groupId, companyId);
	}

	/**
	* Caches the video statistic in the entity cache if it is enabled.
	*
	* @param videoStatistic the video statistic
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.VideoStatistic videoStatistic) {
		getPersistence().cacheResult(videoStatistic);
	}

	/**
	* Caches the video statistics in the entity cache if it is enabled.
	*
	* @param videoStatistics the video statistics
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> videoStatistics) {
		getPersistence().cacheResult(videoStatistics);
	}

	/**
	* Creates a new video statistic with the primary key. Does not add the video statistic to the database.
	*
	* @param videoStatisticId the primary key for the new video statistic
	* @return the new video statistic
	*/
	public static de.uhh.l2g.plugins.model.VideoStatistic create(
		long videoStatisticId) {
		return getPersistence().create(videoStatisticId);
	}

	/**
	* Removes the video statistic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic that was removed
	* @throws de.uhh.l2g.plugins.NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.VideoStatistic remove(
		long videoStatisticId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoStatisticException {
		return getPersistence().remove(videoStatisticId);
	}

	public static de.uhh.l2g.plugins.model.VideoStatistic updateImpl(
		de.uhh.l2g.plugins.model.VideoStatistic videoStatistic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videoStatistic);
	}

	/**
	* Returns the video statistic with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideoStatisticException} if it could not be found.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic
	* @throws de.uhh.l2g.plugins.NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.VideoStatistic findByPrimaryKey(
		long videoStatisticId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideoStatisticException {
		return getPersistence().findByPrimaryKey(videoStatisticId);
	}

	/**
	* Returns the video statistic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic, or <code>null</code> if a video statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.VideoStatistic fetchByPrimaryKey(
		long videoStatisticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videoStatisticId);
	}

	/**
	* Returns all the video statistics.
	*
	* @return the video statistics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of video statistics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video statistics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video statistics from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video statistics.
	*
	* @return the number of video statistics
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoStatisticPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoStatisticPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					VideoStatisticPersistence.class.getName());

			ReferenceRegistry.registerReference(VideoStatisticUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VideoStatisticPersistence persistence) {
	}

	private static VideoStatisticPersistence _persistence;
}