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

import de.uhh.l2g.plugins.model.Producer;

import java.util.List;

/**
 * The persistence utility for the producer service. This utility wraps {@link ProducerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ProducerPersistence
 * @see ProducerPersistenceImpl
 * @generated
 */
public class ProducerUtil {
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
	public static void clearCache(Producer producer) {
		getPersistence().clearCache(producer);
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
	public static List<Producer> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Producer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Producer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Producer update(Producer producer) throws SystemException {
		return getPersistence().update(producer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Producer update(Producer producer,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(producer, serviceContext);
	}

	/**
	* Returns all the producers where hostId = &#63;.
	*
	* @param hostId the host ID
	* @return the matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> findByHost(
		long hostId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHost(hostId);
	}

	/**
	* Returns a range of all the producers where hostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param hostId the host ID
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @return the range of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> findByHost(
		long hostId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHost(hostId, start, end);
	}

	/**
	* Returns an ordered range of all the producers where hostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param hostId the host ID
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> findByHost(
		long hostId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHost(hostId, start, end, orderByComparator);
	}

	/**
	* Returns the first producer in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer findByHost_First(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence().findByHost_First(hostId, orderByComparator);
	}

	/**
	* Returns the first producer in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer fetchByHost_First(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHost_First(hostId, orderByComparator);
	}

	/**
	* Returns the last producer in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer findByHost_Last(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence().findByHost_Last(hostId, orderByComparator);
	}

	/**
	* Returns the last producer in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer fetchByHost_Last(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHost_Last(hostId, orderByComparator);
	}

	/**
	* Returns the producers before and after the current producer in the ordered set where hostId = &#63;.
	*
	* @param producerId the primary key of the current producer
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer[] findByHost_PrevAndNext(
		long producerId, long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence()
				   .findByHost_PrevAndNext(producerId, hostId, orderByComparator);
	}

	/**
	* Removes all the producers where hostId = &#63; from the database.
	*
	* @param hostId the host ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHost(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByHost(hostId);
	}

	/**
	* Returns the number of producers where hostId = &#63;.
	*
	* @param hostId the host ID
	* @return the number of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHost(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHost(hostId);
	}

	/**
	* Returns all the producers where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @return the matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> findByFacility(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFacility(facilityId);
	}

	/**
	* Returns a range of all the producers where facilityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facilityId the facility ID
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @return the range of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> findByFacility(
		long facilityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFacility(facilityId, start, end);
	}

	/**
	* Returns an ordered range of all the producers where facilityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facilityId the facility ID
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> findByFacility(
		long facilityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFacility(facilityId, start, end, orderByComparator);
	}

	/**
	* Returns the first producer in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer findByFacility_First(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence()
				   .findByFacility_First(facilityId, orderByComparator);
	}

	/**
	* Returns the first producer in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer fetchByFacility_First(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFacility_First(facilityId, orderByComparator);
	}

	/**
	* Returns the last producer in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer findByFacility_Last(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence()
				   .findByFacility_Last(facilityId, orderByComparator);
	}

	/**
	* Returns the last producer in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer fetchByFacility_Last(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFacility_Last(facilityId, orderByComparator);
	}

	/**
	* Returns the producers before and after the current producer in the ordered set where facilityId = &#63;.
	*
	* @param producerId the primary key of the current producer
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer[] findByFacility_PrevAndNext(
		long producerId, long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence()
				   .findByFacility_PrevAndNext(producerId, facilityId,
			orderByComparator);
	}

	/**
	* Removes all the producers where facilityId = &#63; from the database.
	*
	* @param facilityId the facility ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFacility(long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFacility(facilityId);
	}

	/**
	* Returns the number of producers where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @return the number of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFacility(long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFacility(facilityId);
	}

	/**
	* Returns all the producers where approved = &#63;.
	*
	* @param approved the approved
	* @return the matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> findByStatus(
		int approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(approved);
	}

	/**
	* Returns a range of all the producers where approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param approved the approved
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @return the range of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> findByStatus(
		int approved, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(approved, start, end);
	}

	/**
	* Returns an ordered range of all the producers where approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param approved the approved
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> findByStatus(
		int approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(approved, start, end, orderByComparator);
	}

	/**
	* Returns the first producer in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer findByStatus_First(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence().findByStatus_First(approved, orderByComparator);
	}

	/**
	* Returns the first producer in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer fetchByStatus_First(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(approved, orderByComparator);
	}

	/**
	* Returns the last producer in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer findByStatus_Last(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence().findByStatus_Last(approved, orderByComparator);
	}

	/**
	* Returns the last producer in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer fetchByStatus_Last(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(approved, orderByComparator);
	}

	/**
	* Returns the producers before and after the current producer in the ordered set where approved = &#63;.
	*
	* @param producerId the primary key of the current producer
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer[] findByStatus_PrevAndNext(
		long producerId, int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence()
				   .findByStatus_PrevAndNext(producerId, approved,
			orderByComparator);
	}

	/**
	* Removes all the producers where approved = &#63; from the database.
	*
	* @param approved the approved
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(approved);
	}

	/**
	* Returns the number of producers where approved = &#63;.
	*
	* @param approved the approved
	* @return the number of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(approved);
	}

	/**
	* Returns the producer where homeDir = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchProducerException} if it could not be found.
	*
	* @param homeDir the home dir
	* @return the matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer findByDirectory(
		java.lang.String homeDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence().findByDirectory(homeDir);
	}

	/**
	* Returns the producer where homeDir = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param homeDir the home dir
	* @return the matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer fetchByDirectory(
		java.lang.String homeDir)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDirectory(homeDir);
	}

	/**
	* Returns the producer where homeDir = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param homeDir the home dir
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer fetchByDirectory(
		java.lang.String homeDir, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDirectory(homeDir, retrieveFromCache);
	}

	/**
	* Removes the producer where homeDir = &#63; from the database.
	*
	* @param homeDir the home dir
	* @return the producer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer removeByDirectory(
		java.lang.String homeDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence().removeByDirectory(homeDir);
	}

	/**
	* Returns the number of producers where homeDir = &#63;.
	*
	* @param homeDir the home dir
	* @return the number of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDirectory(java.lang.String homeDir)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDirectory(homeDir);
	}

	/**
	* Returns the producer where idNum = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchProducerException} if it could not be found.
	*
	* @param idNum the id num
	* @return the matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer findByUID(
		java.lang.String idNum)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence().findByUID(idNum);
	}

	/**
	* Returns the producer where idNum = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param idNum the id num
	* @return the matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer fetchByUID(
		java.lang.String idNum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUID(idNum);
	}

	/**
	* Returns the producer where idNum = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param idNum the id num
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer fetchByUID(
		java.lang.String idNum, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUID(idNum, retrieveFromCache);
	}

	/**
	* Removes the producer where idNum = &#63; from the database.
	*
	* @param idNum the id num
	* @return the producer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer removeByUID(
		java.lang.String idNum)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence().removeByUID(idNum);
	}

	/**
	* Returns the number of producers where idNum = &#63;.
	*
	* @param idNum the id num
	* @return the number of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUID(java.lang.String idNum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUID(idNum);
	}

	/**
	* Caches the producer in the entity cache if it is enabled.
	*
	* @param producer the producer
	*/
	public static void cacheResult(de.uhh.l2g.plugins.model.Producer producer) {
		getPersistence().cacheResult(producer);
	}

	/**
	* Caches the producers in the entity cache if it is enabled.
	*
	* @param producers the producers
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Producer> producers) {
		getPersistence().cacheResult(producers);
	}

	/**
	* Creates a new producer with the primary key. Does not add the producer to the database.
	*
	* @param producerId the primary key for the new producer
	* @return the new producer
	*/
	public static de.uhh.l2g.plugins.model.Producer create(long producerId) {
		return getPersistence().create(producerId);
	}

	/**
	* Removes the producer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param producerId the primary key of the producer
	* @return the producer that was removed
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer remove(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence().remove(producerId);
	}

	public static de.uhh.l2g.plugins.model.Producer updateImpl(
		de.uhh.l2g.plugins.model.Producer producer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(producer);
	}

	/**
	* Returns the producer with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchProducerException} if it could not be found.
	*
	* @param producerId the primary key of the producer
	* @return the producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer findByPrimaryKey(
		long producerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException {
		return getPersistence().findByPrimaryKey(producerId);
	}

	/**
	* Returns the producer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param producerId the primary key of the producer
	* @return the producer, or <code>null</code> if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer fetchByPrimaryKey(
		long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(producerId);
	}

	/**
	* Returns all the producers.
	*
	* @return the producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the producers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @return the range of producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the producers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the producers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of producers.
	*
	* @return the number of producers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProducerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProducerPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					ProducerPersistence.class.getName());

			ReferenceRegistry.registerReference(ProducerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ProducerPersistence persistence) {
	}

	private static ProducerPersistence _persistence;
}