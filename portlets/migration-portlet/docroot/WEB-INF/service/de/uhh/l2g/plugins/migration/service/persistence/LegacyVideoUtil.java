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

package de.uhh.l2g.plugins.migration.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.migration.model.LegacyVideo;

import java.util.List;

/**
 * The persistence utility for the legacy video service. This utility wraps {@link LegacyVideoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyVideoPersistence
 * @see LegacyVideoPersistenceImpl
 * @generated
 */
public class LegacyVideoUtil {
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
	public static void clearCache(LegacyVideo legacyVideo) {
		getPersistence().clearCache(legacyVideo);
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
	public static List<LegacyVideo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegacyVideo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegacyVideo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LegacyVideo update(LegacyVideo legacyVideo)
		throws SystemException {
		return getPersistence().update(legacyVideo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LegacyVideo update(LegacyVideo legacyVideo,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(legacyVideo, serviceContext);
	}

	/**
	* Caches the legacy video in the entity cache if it is enabled.
	*
	* @param legacyVideo the legacy video
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacyVideo legacyVideo) {
		getPersistence().cacheResult(legacyVideo);
	}

	/**
	* Caches the legacy videos in the entity cache if it is enabled.
	*
	* @param legacyVideos the legacy videos
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacyVideo> legacyVideos) {
		getPersistence().cacheResult(legacyVideos);
	}

	/**
	* Creates a new legacy video with the primary key. Does not add the legacy video to the database.
	*
	* @param id the primary key for the new legacy video
	* @return the new legacy video
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyVideo create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the legacy video with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy video
	* @return the legacy video that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException if a legacy video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyVideo remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException {
		return getPersistence().remove(id);
	}

	public static de.uhh.l2g.plugins.migration.model.LegacyVideo updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyVideo legacyVideo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(legacyVideo);
	}

	/**
	* Returns the legacy video with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException} if it could not be found.
	*
	* @param id the primary key of the legacy video
	* @return the legacy video
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException if a legacy video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyVideo findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the legacy video with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the legacy video
	* @return the legacy video, or <code>null</code> if a legacy video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyVideo fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the legacy videos.
	*
	* @return the legacy videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyVideo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the legacy videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy videos
	* @param end the upper bound of the range of legacy videos (not inclusive)
	* @return the range of legacy videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyVideo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the legacy videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyVideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy videos
	* @param end the upper bound of the range of legacy videos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacy videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyVideo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the legacy videos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of legacy videos.
	*
	* @return the number of legacy videos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LegacyVideoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LegacyVideoPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.migration.service.ClpSerializer.getServletContextName(),
					LegacyVideoPersistence.class.getName());

			ReferenceRegistry.registerReference(LegacyVideoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LegacyVideoPersistence persistence) {
	}

	private static LegacyVideoPersistence _persistence;
}