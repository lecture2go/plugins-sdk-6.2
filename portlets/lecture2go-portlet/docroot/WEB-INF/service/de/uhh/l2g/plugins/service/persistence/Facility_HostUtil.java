/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import de.uhh.l2g.plugins.model.Facility_Host;

import java.util.List;

/**
 * The persistence utility for the facility_ host service. This utility wraps {@link Facility_HostPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Facility_HostPersistence
 * @see Facility_HostPersistenceImpl
 * @generated
 */
public class Facility_HostUtil {
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
	public static void clearCache(Facility_Host facility_Host) {
		getPersistence().clearCache(facility_Host);
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
	public static List<Facility_Host> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Facility_Host> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Facility_Host> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Facility_Host update(Facility_Host facility_Host)
		throws SystemException {
		return getPersistence().update(facility_Host);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Facility_Host update(Facility_Host facility_Host,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(facility_Host, serviceContext);
	}

	/**
	* Returns the facility_ host where facilityId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchFacility_HostException} if it could not be found.
	*
	* @param facilityId the facility ID
	* @return the matching facility_ host
	* @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility_Host findByfacilityId(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException {
		return getPersistence().findByfacilityId(facilityId);
	}

	/**
	* Returns the facility_ host where facilityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param facilityId the facility ID
	* @return the matching facility_ host, or <code>null</code> if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility_Host fetchByfacilityId(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByfacilityId(facilityId);
	}

	/**
	* Returns the facility_ host where facilityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param facilityId the facility ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching facility_ host, or <code>null</code> if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility_Host fetchByfacilityId(
		long facilityId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByfacilityId(facilityId, retrieveFromCache);
	}

	/**
	* Removes the facility_ host where facilityId = &#63; from the database.
	*
	* @param facilityId the facility ID
	* @return the facility_ host that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility_Host removeByfacilityId(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException {
		return getPersistence().removeByfacilityId(facilityId);
	}

	/**
	* Returns the number of facility_ hosts where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @return the number of matching facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfacilityId(long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfacilityId(facilityId);
	}

	/**
	* Returns the facility_ host where hostId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchFacility_HostException} if it could not be found.
	*
	* @param hostId the host ID
	* @return the matching facility_ host
	* @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility_Host findByhostId(
		long hostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException {
		return getPersistence().findByhostId(hostId);
	}

	/**
	* Returns the facility_ host where hostId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param hostId the host ID
	* @return the matching facility_ host, or <code>null</code> if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility_Host fetchByhostId(
		long hostId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByhostId(hostId);
	}

	/**
	* Returns the facility_ host where hostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param hostId the host ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching facility_ host, or <code>null</code> if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility_Host fetchByhostId(
		long hostId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByhostId(hostId, retrieveFromCache);
	}

	/**
	* Removes the facility_ host where hostId = &#63; from the database.
	*
	* @param hostId the host ID
	* @return the facility_ host that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility_Host removeByhostId(
		long hostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException {
		return getPersistence().removeByhostId(hostId);
	}

	/**
	* Returns the number of facility_ hosts where hostId = &#63;.
	*
	* @param hostId the host ID
	* @return the number of matching facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByhostId(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByhostId(hostId);
	}

	/**
	* Caches the facility_ host in the entity cache if it is enabled.
	*
	* @param facility_Host the facility_ host
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Facility_Host facility_Host) {
		getPersistence().cacheResult(facility_Host);
	}

	/**
	* Caches the facility_ hosts in the entity cache if it is enabled.
	*
	* @param facility_Hosts the facility_ hosts
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Facility_Host> facility_Hosts) {
		getPersistence().cacheResult(facility_Hosts);
	}

	/**
	* Creates a new facility_ host with the primary key. Does not add the facility_ host to the database.
	*
	* @param fasilityHostId the primary key for the new facility_ host
	* @return the new facility_ host
	*/
	public static de.uhh.l2g.plugins.model.Facility_Host create(
		long fasilityHostId) {
		return getPersistence().create(fasilityHostId);
	}

	/**
	* Removes the facility_ host with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fasilityHostId the primary key of the facility_ host
	* @return the facility_ host that was removed
	* @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a facility_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility_Host remove(
		long fasilityHostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException {
		return getPersistence().remove(fasilityHostId);
	}

	public static de.uhh.l2g.plugins.model.Facility_Host updateImpl(
		de.uhh.l2g.plugins.model.Facility_Host facility_Host)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(facility_Host);
	}

	/**
	* Returns the facility_ host with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchFacility_HostException} if it could not be found.
	*
	* @param fasilityHostId the primary key of the facility_ host
	* @return the facility_ host
	* @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a facility_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility_Host findByPrimaryKey(
		long fasilityHostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException {
		return getPersistence().findByPrimaryKey(fasilityHostId);
	}

	/**
	* Returns the facility_ host with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fasilityHostId the primary key of the facility_ host
	* @return the facility_ host, or <code>null</code> if a facility_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility_Host fetchByPrimaryKey(
		long fasilityHostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(fasilityHostId);
	}

	/**
	* Returns all the facility_ hosts.
	*
	* @return the facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility_Host> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the facility_ hosts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Facility_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of facility_ hosts
	* @param end the upper bound of the range of facility_ hosts (not inclusive)
	* @return the range of facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility_Host> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the facility_ hosts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Facility_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of facility_ hosts
	* @param end the upper bound of the range of facility_ hosts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility_Host> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the facility_ hosts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of facility_ hosts.
	*
	* @return the number of facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Facility_HostPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Facility_HostPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					Facility_HostPersistence.class.getName());

			ReferenceRegistry.registerReference(Facility_HostUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Facility_HostPersistence persistence) {
	}

	private static Facility_HostPersistence _persistence;
}