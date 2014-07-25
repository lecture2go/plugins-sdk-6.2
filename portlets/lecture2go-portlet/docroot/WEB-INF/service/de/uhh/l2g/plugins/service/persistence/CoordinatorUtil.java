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

import de.uhh.l2g.plugins.model.Coordinator;

import java.util.List;

/**
 * The persistence utility for the coordinator service. This utility wraps {@link CoordinatorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see CoordinatorPersistence
 * @see CoordinatorPersistenceImpl
 * @generated
 */
public class CoordinatorUtil {
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
	public static void clearCache(Coordinator coordinator) {
		getPersistence().clearCache(coordinator);
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
	public static List<Coordinator> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Coordinator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Coordinator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Coordinator update(Coordinator coordinator)
		throws SystemException {
		return getPersistence().update(coordinator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Coordinator update(Coordinator coordinator,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(coordinator, serviceContext);
	}

	/**
	* Returns all the coordinators where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @return the matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Coordinator> findByFacility(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFacility(facilityId);
	}

	/**
	* Returns a range of all the coordinators where facilityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facilityId the facility ID
	* @param start the lower bound of the range of coordinators
	* @param end the upper bound of the range of coordinators (not inclusive)
	* @return the range of matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Coordinator> findByFacility(
		long facilityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFacility(facilityId, start, end);
	}

	/**
	* Returns an ordered range of all the coordinators where facilityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facilityId the facility ID
	* @param start the lower bound of the range of coordinators
	* @param end the upper bound of the range of coordinators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Coordinator> findByFacility(
		long facilityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFacility(facilityId, start, end, orderByComparator);
	}

	/**
	* Returns the first coordinator in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator findByFacility_First(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException {
		return getPersistence()
				   .findByFacility_First(facilityId, orderByComparator);
	}

	/**
	* Returns the first coordinator in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator fetchByFacility_First(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFacility_First(facilityId, orderByComparator);
	}

	/**
	* Returns the last coordinator in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator findByFacility_Last(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException {
		return getPersistence()
				   .findByFacility_Last(facilityId, orderByComparator);
	}

	/**
	* Returns the last coordinator in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator fetchByFacility_Last(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFacility_Last(facilityId, orderByComparator);
	}

	/**
	* Returns the coordinators before and after the current coordinator in the ordered set where facilityId = &#63;.
	*
	* @param coordinatorId the primary key of the current coordinator
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator[] findByFacility_PrevAndNext(
		long coordinatorId, long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException {
		return getPersistence()
				   .findByFacility_PrevAndNext(coordinatorId, facilityId,
			orderByComparator);
	}

	/**
	* Removes all the coordinators where facilityId = &#63; from the database.
	*
	* @param facilityId the facility ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFacility(long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFacility(facilityId);
	}

	/**
	* Returns the number of coordinators where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @return the number of matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFacility(long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFacility(facilityId);
	}

	/**
	* Returns all the coordinators where officeId = &#63;.
	*
	* @param officeId the office ID
	* @return the matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Coordinator> findByOffice(
		long officeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOffice(officeId);
	}

	/**
	* Returns a range of all the coordinators where officeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param officeId the office ID
	* @param start the lower bound of the range of coordinators
	* @param end the upper bound of the range of coordinators (not inclusive)
	* @return the range of matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Coordinator> findByOffice(
		long officeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOffice(officeId, start, end);
	}

	/**
	* Returns an ordered range of all the coordinators where officeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param officeId the office ID
	* @param start the lower bound of the range of coordinators
	* @param end the upper bound of the range of coordinators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Coordinator> findByOffice(
		long officeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOffice(officeId, start, end, orderByComparator);
	}

	/**
	* Returns the first coordinator in the ordered set where officeId = &#63;.
	*
	* @param officeId the office ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator findByOffice_First(
		long officeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException {
		return getPersistence().findByOffice_First(officeId, orderByComparator);
	}

	/**
	* Returns the first coordinator in the ordered set where officeId = &#63;.
	*
	* @param officeId the office ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator fetchByOffice_First(
		long officeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOffice_First(officeId, orderByComparator);
	}

	/**
	* Returns the last coordinator in the ordered set where officeId = &#63;.
	*
	* @param officeId the office ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator findByOffice_Last(
		long officeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException {
		return getPersistence().findByOffice_Last(officeId, orderByComparator);
	}

	/**
	* Returns the last coordinator in the ordered set where officeId = &#63;.
	*
	* @param officeId the office ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator fetchByOffice_Last(
		long officeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOffice_Last(officeId, orderByComparator);
	}

	/**
	* Returns the coordinators before and after the current coordinator in the ordered set where officeId = &#63;.
	*
	* @param coordinatorId the primary key of the current coordinator
	* @param officeId the office ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator[] findByOffice_PrevAndNext(
		long coordinatorId, long officeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException {
		return getPersistence()
				   .findByOffice_PrevAndNext(coordinatorId, officeId,
			orderByComparator);
	}

	/**
	* Removes all the coordinators where officeId = &#63; from the database.
	*
	* @param officeId the office ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOffice(long officeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOffice(officeId);
	}

	/**
	* Returns the number of coordinators where officeId = &#63;.
	*
	* @param officeId the office ID
	* @return the number of matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOffice(long officeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOffice(officeId);
	}

	/**
	* Caches the coordinator in the entity cache if it is enabled.
	*
	* @param coordinator the coordinator
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Coordinator coordinator) {
		getPersistence().cacheResult(coordinator);
	}

	/**
	* Caches the coordinators in the entity cache if it is enabled.
	*
	* @param coordinators the coordinators
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Coordinator> coordinators) {
		getPersistence().cacheResult(coordinators);
	}

	/**
	* Creates a new coordinator with the primary key. Does not add the coordinator to the database.
	*
	* @param coordinatorId the primary key for the new coordinator
	* @return the new coordinator
	*/
	public static de.uhh.l2g.plugins.model.Coordinator create(
		long coordinatorId) {
		return getPersistence().create(coordinatorId);
	}

	/**
	* Removes the coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param coordinatorId the primary key of the coordinator
	* @return the coordinator that was removed
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator remove(
		long coordinatorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException {
		return getPersistence().remove(coordinatorId);
	}

	public static de.uhh.l2g.plugins.model.Coordinator updateImpl(
		de.uhh.l2g.plugins.model.Coordinator coordinator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(coordinator);
	}

	/**
	* Returns the coordinator with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchCoordinatorException} if it could not be found.
	*
	* @param coordinatorId the primary key of the coordinator
	* @return the coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator findByPrimaryKey(
		long coordinatorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException {
		return getPersistence().findByPrimaryKey(coordinatorId);
	}

	/**
	* Returns the coordinator with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param coordinatorId the primary key of the coordinator
	* @return the coordinator, or <code>null</code> if a coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Coordinator fetchByPrimaryKey(
		long coordinatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(coordinatorId);
	}

	/**
	* Returns all the coordinators.
	*
	* @return the coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Coordinator> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the coordinators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of coordinators
	* @param end the upper bound of the range of coordinators (not inclusive)
	* @return the range of coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Coordinator> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the coordinators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of coordinators
	* @param end the upper bound of the range of coordinators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Coordinator> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the coordinators from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of coordinators.
	*
	* @return the number of coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CoordinatorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CoordinatorPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					CoordinatorPersistence.class.getName());

			ReferenceRegistry.registerReference(CoordinatorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CoordinatorPersistence persistence) {
	}

	private static CoordinatorPersistence _persistence;
}