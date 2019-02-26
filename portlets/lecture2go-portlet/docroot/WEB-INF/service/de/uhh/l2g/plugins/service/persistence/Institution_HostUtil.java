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

import de.uhh.l2g.plugins.model.Institution_Host;

import java.util.List;

/**
 * The persistence utility for the institution_ host service. This utility wraps {@link Institution_HostPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Institution_HostPersistence
 * @see Institution_HostPersistenceImpl
 * @generated
 */
public class Institution_HostUtil {
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
	public static void clearCache(Institution_Host institution_Host) {
		getPersistence().clearCache(institution_Host);
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
	public static List<Institution_Host> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Institution_Host> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Institution_Host> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Institution_Host update(Institution_Host institution_Host)
		throws SystemException {
		return getPersistence().update(institution_Host);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Institution_Host update(Institution_Host institution_Host,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(institution_Host, serviceContext);
	}

	/**
	* Returns all the institution_ hosts where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the matching institution_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host> findByinstitutionId(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByinstitutionId(institutionId);
	}

	/**
	* Returns a range of all the institution_ hosts where institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionId the institution ID
	* @param start the lower bound of the range of institution_ hosts
	* @param end the upper bound of the range of institution_ hosts (not inclusive)
	* @return the range of matching institution_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host> findByinstitutionId(
		long institutionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByinstitutionId(institutionId, start, end);
	}

	/**
	* Returns an ordered range of all the institution_ hosts where institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionId the institution ID
	* @param start the lower bound of the range of institution_ hosts
	* @param end the upper bound of the range of institution_ hosts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institution_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host> findByinstitutionId(
		long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByinstitutionId(institutionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first institution_ host in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution_ host
	* @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a matching institution_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host findByinstitutionId_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitution_HostException {
		return getPersistence()
				   .findByinstitutionId_First(institutionId, orderByComparator);
	}

	/**
	* Returns the first institution_ host in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host fetchByinstitutionId_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByinstitutionId_First(institutionId, orderByComparator);
	}

	/**
	* Returns the last institution_ host in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution_ host
	* @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a matching institution_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host findByinstitutionId_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitution_HostException {
		return getPersistence()
				   .findByinstitutionId_Last(institutionId, orderByComparator);
	}

	/**
	* Returns the last institution_ host in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host fetchByinstitutionId_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByinstitutionId_Last(institutionId, orderByComparator);
	}

	/**
	* Returns the institution_ hosts before and after the current institution_ host in the ordered set where institutionId = &#63;.
	*
	* @param institutionHostId the primary key of the current institution_ host
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution_ host
	* @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host[] findByinstitutionId_PrevAndNext(
		long institutionHostId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitution_HostException {
		return getPersistence()
				   .findByinstitutionId_PrevAndNext(institutionHostId,
			institutionId, orderByComparator);
	}

	/**
	* Removes all the institution_ hosts where institutionId = &#63; from the database.
	*
	* @param institutionId the institution ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByinstitutionId(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByinstitutionId(institutionId);
	}

	/**
	* Returns the number of institution_ hosts where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the number of matching institution_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByinstitutionId(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByinstitutionId(institutionId);
	}

	/**
	* Returns all the institution_ hosts where hostId = &#63;.
	*
	* @param hostId the host ID
	* @return the matching institution_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host> findByhostId(
		long hostId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByhostId(hostId);
	}

	/**
	* Returns a range of all the institution_ hosts where hostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param hostId the host ID
	* @param start the lower bound of the range of institution_ hosts
	* @param end the upper bound of the range of institution_ hosts (not inclusive)
	* @return the range of matching institution_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host> findByhostId(
		long hostId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByhostId(hostId, start, end);
	}

	/**
	* Returns an ordered range of all the institution_ hosts where hostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param hostId the host ID
	* @param start the lower bound of the range of institution_ hosts
	* @param end the upper bound of the range of institution_ hosts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institution_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host> findByhostId(
		long hostId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByhostId(hostId, start, end, orderByComparator);
	}

	/**
	* Returns the first institution_ host in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution_ host
	* @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a matching institution_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host findByhostId_First(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitution_HostException {
		return getPersistence().findByhostId_First(hostId, orderByComparator);
	}

	/**
	* Returns the first institution_ host in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host fetchByhostId_First(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByhostId_First(hostId, orderByComparator);
	}

	/**
	* Returns the last institution_ host in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution_ host
	* @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a matching institution_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host findByhostId_Last(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitution_HostException {
		return getPersistence().findByhostId_Last(hostId, orderByComparator);
	}

	/**
	* Returns the last institution_ host in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host fetchByhostId_Last(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByhostId_Last(hostId, orderByComparator);
	}

	/**
	* Returns the institution_ hosts before and after the current institution_ host in the ordered set where hostId = &#63;.
	*
	* @param institutionHostId the primary key of the current institution_ host
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution_ host
	* @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host[] findByhostId_PrevAndNext(
		long institutionHostId, long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitution_HostException {
		return getPersistence()
				   .findByhostId_PrevAndNext(institutionHostId, hostId,
			orderByComparator);
	}

	/**
	* Removes all the institution_ hosts where hostId = &#63; from the database.
	*
	* @param hostId the host ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByhostId(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByhostId(hostId);
	}

	/**
	* Returns the number of institution_ hosts where hostId = &#63;.
	*
	* @param hostId the host ID
	* @return the number of matching institution_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByhostId(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByhostId(hostId);
	}

	/**
	* Caches the institution_ host in the entity cache if it is enabled.
	*
	* @param institution_Host the institution_ host
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Institution_Host institution_Host) {
		getPersistence().cacheResult(institution_Host);
	}

	/**
	* Caches the institution_ hosts in the entity cache if it is enabled.
	*
	* @param institution_Hosts the institution_ hosts
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Institution_Host> institution_Hosts) {
		getPersistence().cacheResult(institution_Hosts);
	}

	/**
	* Creates a new institution_ host with the primary key. Does not add the institution_ host to the database.
	*
	* @param institutionHostId the primary key for the new institution_ host
	* @return the new institution_ host
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host create(
		long institutionHostId) {
		return getPersistence().create(institutionHostId);
	}

	/**
	* Removes the institution_ host with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param institutionHostId the primary key of the institution_ host
	* @return the institution_ host that was removed
	* @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host remove(
		long institutionHostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitution_HostException {
		return getPersistence().remove(institutionHostId);
	}

	public static de.uhh.l2g.plugins.model.Institution_Host updateImpl(
		de.uhh.l2g.plugins.model.Institution_Host institution_Host)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(institution_Host);
	}

	/**
	* Returns the institution_ host with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchInstitution_HostException} if it could not be found.
	*
	* @param institutionHostId the primary key of the institution_ host
	* @return the institution_ host
	* @throws de.uhh.l2g.plugins.NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host findByPrimaryKey(
		long institutionHostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitution_HostException {
		return getPersistence().findByPrimaryKey(institutionHostId);
	}

	/**
	* Returns the institution_ host with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param institutionHostId the primary key of the institution_ host
	* @return the institution_ host, or <code>null</code> if a institution_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution_Host fetchByPrimaryKey(
		long institutionHostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(institutionHostId);
	}

	/**
	* Returns all the institution_ hosts.
	*
	* @return the institution_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the institution_ hosts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of institution_ hosts
	* @param end the upper bound of the range of institution_ hosts (not inclusive)
	* @return the range of institution_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the institution_ hosts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of institution_ hosts
	* @param end the upper bound of the range of institution_ hosts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of institution_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the institution_ hosts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of institution_ hosts.
	*
	* @return the number of institution_ hosts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Institution_HostPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Institution_HostPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					Institution_HostPersistence.class.getName());

			ReferenceRegistry.registerReference(Institution_HostUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Institution_HostPersistence persistence) {
	}

	private static Institution_HostPersistence _persistence;
}