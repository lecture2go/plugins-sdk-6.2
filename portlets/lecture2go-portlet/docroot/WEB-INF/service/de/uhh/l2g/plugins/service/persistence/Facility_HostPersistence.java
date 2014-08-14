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

import com.liferay.portal.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.model.Facility_Host;

/**
 * The persistence interface for the facility_ host service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Facility_HostPersistenceImpl
 * @see Facility_HostUtil
 * @generated
 */
public interface Facility_HostPersistence extends BasePersistence<Facility_Host> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Facility_HostUtil} to access the facility_ host persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the facility_ hosts where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @return the matching facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Facility_Host> findByfacilityId(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the facility_ hosts where facilityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Facility_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facilityId the facility ID
	* @param start the lower bound of the range of facility_ hosts
	* @param end the upper bound of the range of facility_ hosts (not inclusive)
	* @return the range of matching facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Facility_Host> findByfacilityId(
		long facilityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the facility_ hosts where facilityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Facility_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facilityId the facility ID
	* @param start the lower bound of the range of facility_ hosts
	* @param end the upper bound of the range of facility_ hosts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Facility_Host> findByfacilityId(
		long facilityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first facility_ host in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility_ host
	* @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host findByfacilityId_First(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException;

	/**
	* Returns the first facility_ host in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility_ host, or <code>null</code> if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host fetchByfacilityId_First(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last facility_ host in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility_ host
	* @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host findByfacilityId_Last(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException;

	/**
	* Returns the last facility_ host in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility_ host, or <code>null</code> if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host fetchByfacilityId_Last(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the facility_ hosts before and after the current facility_ host in the ordered set where facilityId = &#63;.
	*
	* @param fasilityHostId the primary key of the current facility_ host
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next facility_ host
	* @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a facility_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host[] findByfacilityId_PrevAndNext(
		long fasilityHostId, long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException;

	/**
	* Removes all the facility_ hosts where facilityId = &#63; from the database.
	*
	* @param facilityId the facility ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfacilityId(long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of facility_ hosts where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @return the number of matching facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public int countByfacilityId(long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the facility_ hosts where hostId = &#63;.
	*
	* @param hostId the host ID
	* @return the matching facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Facility_Host> findByhostId(
		long hostId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the facility_ hosts where hostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Facility_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param hostId the host ID
	* @param start the lower bound of the range of facility_ hosts
	* @param end the upper bound of the range of facility_ hosts (not inclusive)
	* @return the range of matching facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Facility_Host> findByhostId(
		long hostId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the facility_ hosts where hostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Facility_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param hostId the host ID
	* @param start the lower bound of the range of facility_ hosts
	* @param end the upper bound of the range of facility_ hosts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Facility_Host> findByhostId(
		long hostId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first facility_ host in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility_ host
	* @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host findByhostId_First(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException;

	/**
	* Returns the first facility_ host in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility_ host, or <code>null</code> if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host fetchByhostId_First(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last facility_ host in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility_ host
	* @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host findByhostId_Last(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException;

	/**
	* Returns the last facility_ host in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility_ host, or <code>null</code> if a matching facility_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host fetchByhostId_Last(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the facility_ hosts before and after the current facility_ host in the ordered set where hostId = &#63;.
	*
	* @param fasilityHostId the primary key of the current facility_ host
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next facility_ host
	* @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a facility_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host[] findByhostId_PrevAndNext(
		long fasilityHostId, long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException;

	/**
	* Removes all the facility_ hosts where hostId = &#63; from the database.
	*
	* @param hostId the host ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByhostId(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of facility_ hosts where hostId = &#63;.
	*
	* @param hostId the host ID
	* @return the number of matching facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public int countByhostId(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the facility_ host in the entity cache if it is enabled.
	*
	* @param facility_Host the facility_ host
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.model.Facility_Host facility_Host);

	/**
	* Caches the facility_ hosts in the entity cache if it is enabled.
	*
	* @param facility_Hosts the facility_ hosts
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Facility_Host> facility_Hosts);

	/**
	* Creates a new facility_ host with the primary key. Does not add the facility_ host to the database.
	*
	* @param fasilityHostId the primary key for the new facility_ host
	* @return the new facility_ host
	*/
	public de.uhh.l2g.plugins.model.Facility_Host create(long fasilityHostId);

	/**
	* Removes the facility_ host with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fasilityHostId the primary key of the facility_ host
	* @return the facility_ host that was removed
	* @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a facility_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host remove(long fasilityHostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException;

	public de.uhh.l2g.plugins.model.Facility_Host updateImpl(
		de.uhh.l2g.plugins.model.Facility_Host facility_Host)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the facility_ host with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchFacility_HostException} if it could not be found.
	*
	* @param fasilityHostId the primary key of the facility_ host
	* @return the facility_ host
	* @throws de.uhh.l2g.plugins.NoSuchFacility_HostException if a facility_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host findByPrimaryKey(
		long fasilityHostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacility_HostException;

	/**
	* Returns the facility_ host with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fasilityHostId the primary key of the facility_ host
	* @return the facility_ host, or <code>null</code> if a facility_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Facility_Host fetchByPrimaryKey(
		long fasilityHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the facility_ hosts.
	*
	* @return the facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Facility_Host> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Facility_Host> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Facility_Host> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the facility_ hosts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of facility_ hosts.
	*
	* @return the number of facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}