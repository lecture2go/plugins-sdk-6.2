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

import de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility;

import java.util.List;

/**
 * The persistence utility for the legacy lecture series facility service. This utility wraps {@link LegacyLectureSeriesFacilityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyLectureSeriesFacilityPersistence
 * @see LegacyLectureSeriesFacilityPersistenceImpl
 * @generated
 */
public class LegacyLectureSeriesFacilityUtil {
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
	public static void clearCache(
		LegacyLectureSeriesFacility legacyLectureSeriesFacility) {
		getPersistence().clearCache(legacyLectureSeriesFacility);
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
	public static List<LegacyLectureSeriesFacility> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegacyLectureSeriesFacility> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegacyLectureSeriesFacility> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LegacyLectureSeriesFacility update(
		LegacyLectureSeriesFacility legacyLectureSeriesFacility)
		throws SystemException {
		return getPersistence().update(legacyLectureSeriesFacility);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LegacyLectureSeriesFacility update(
		LegacyLectureSeriesFacility legacyLectureSeriesFacility,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(legacyLectureSeriesFacility, serviceContext);
	}

	/**
	* Returns the legacy lecture series facility where facilityId = &#63; and lectureseriesId = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException} if it could not be found.
	*
	* @param facilityId the facility ID
	* @param lectureseriesId the lectureseries ID
	* @return the matching legacy lecture series facility
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException if a matching legacy lecture series facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility findByFacilityIdlectureseriesId(
		long facilityId, long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException {
		return getPersistence()
				   .findByFacilityIdlectureseriesId(facilityId, lectureseriesId);
	}

	/**
	* Returns the legacy lecture series facility where facilityId = &#63; and lectureseriesId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param facilityId the facility ID
	* @param lectureseriesId the lectureseries ID
	* @return the matching legacy lecture series facility, or <code>null</code> if a matching legacy lecture series facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility fetchByFacilityIdlectureseriesId(
		long facilityId, long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFacilityIdlectureseriesId(facilityId, lectureseriesId);
	}

	/**
	* Returns the legacy lecture series facility where facilityId = &#63; and lectureseriesId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param facilityId the facility ID
	* @param lectureseriesId the lectureseries ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching legacy lecture series facility, or <code>null</code> if a matching legacy lecture series facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility fetchByFacilityIdlectureseriesId(
		long facilityId, long lectureseriesId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFacilityIdlectureseriesId(facilityId,
			lectureseriesId, retrieveFromCache);
	}

	/**
	* Removes the legacy lecture series facility where facilityId = &#63; and lectureseriesId = &#63; from the database.
	*
	* @param facilityId the facility ID
	* @param lectureseriesId the lectureseries ID
	* @return the legacy lecture series facility that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility removeByFacilityIdlectureseriesId(
		long facilityId, long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException {
		return getPersistence()
				   .removeByFacilityIdlectureseriesId(facilityId,
			lectureseriesId);
	}

	/**
	* Returns the number of legacy lecture series facilities where facilityId = &#63; and lectureseriesId = &#63;.
	*
	* @param facilityId the facility ID
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching legacy lecture series facilities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFacilityIdlectureseriesId(long facilityId,
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByFacilityIdlectureseriesId(facilityId, lectureseriesId);
	}

	/**
	* Caches the legacy lecture series facility in the entity cache if it is enabled.
	*
	* @param legacyLectureSeriesFacility the legacy lecture series facility
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility legacyLectureSeriesFacility) {
		getPersistence().cacheResult(legacyLectureSeriesFacility);
	}

	/**
	* Caches the legacy lecture series facilities in the entity cache if it is enabled.
	*
	* @param legacyLectureSeriesFacilities the legacy lecture series facilities
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility> legacyLectureSeriesFacilities) {
		getPersistence().cacheResult(legacyLectureSeriesFacilities);
	}

	/**
	* Creates a new legacy lecture series facility with the primary key. Does not add the legacy lecture series facility to the database.
	*
	* @param lectureseriesFacilityId the primary key for the new legacy lecture series facility
	* @return the new legacy lecture series facility
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility create(
		long lectureseriesFacilityId) {
		return getPersistence().create(lectureseriesFacilityId);
	}

	/**
	* Removes the legacy lecture series facility with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesFacilityId the primary key of the legacy lecture series facility
	* @return the legacy lecture series facility that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException if a legacy lecture series facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility remove(
		long lectureseriesFacilityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException {
		return getPersistence().remove(lectureseriesFacilityId);
	}

	public static de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility legacyLectureSeriesFacility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(legacyLectureSeriesFacility);
	}

	/**
	* Returns the legacy lecture series facility with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException} if it could not be found.
	*
	* @param lectureseriesFacilityId the primary key of the legacy lecture series facility
	* @return the legacy lecture series facility
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException if a legacy lecture series facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility findByPrimaryKey(
		long lectureseriesFacilityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException {
		return getPersistence().findByPrimaryKey(lectureseriesFacilityId);
	}

	/**
	* Returns the legacy lecture series facility with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lectureseriesFacilityId the primary key of the legacy lecture series facility
	* @return the legacy lecture series facility, or <code>null</code> if a legacy lecture series facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility fetchByPrimaryKey(
		long lectureseriesFacilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(lectureseriesFacilityId);
	}

	/**
	* Returns all the legacy lecture series facilities.
	*
	* @return the legacy lecture series facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the legacy lecture series facilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy lecture series facilities
	* @param end the upper bound of the range of legacy lecture series facilities (not inclusive)
	* @return the range of legacy lecture series facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the legacy lecture series facilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesFacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy lecture series facilities
	* @param end the upper bound of the range of legacy lecture series facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacy lecture series facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the legacy lecture series facilities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of legacy lecture series facilities.
	*
	* @return the number of legacy lecture series facilities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LegacyLectureSeriesFacilityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LegacyLectureSeriesFacilityPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.migration.service.ClpSerializer.getServletContextName(),
					LegacyLectureSeriesFacilityPersistence.class.getName());

			ReferenceRegistry.registerReference(LegacyLectureSeriesFacilityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		LegacyLectureSeriesFacilityPersistence persistence) {
	}

	private static LegacyLectureSeriesFacilityPersistence _persistence;
}