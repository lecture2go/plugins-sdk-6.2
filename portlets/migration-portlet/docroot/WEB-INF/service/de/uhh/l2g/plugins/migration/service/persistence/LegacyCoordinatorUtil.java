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

import de.uhh.l2g.plugins.migration.model.LegacyCoordinator;

import java.util.List;

/**
 * The persistence utility for the legacy coordinator service. This utility wraps {@link LegacyCoordinatorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyCoordinatorPersistence
 * @see LegacyCoordinatorPersistenceImpl
 * @generated
 */
public class LegacyCoordinatorUtil {
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
	public static void clearCache(LegacyCoordinator legacyCoordinator) {
		getPersistence().clearCache(legacyCoordinator);
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
	public static List<LegacyCoordinator> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegacyCoordinator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegacyCoordinator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LegacyCoordinator update(LegacyCoordinator legacyCoordinator)
		throws SystemException {
		return getPersistence().update(legacyCoordinator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LegacyCoordinator update(
		LegacyCoordinator legacyCoordinator, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(legacyCoordinator, serviceContext);
	}

	/**
	* Caches the legacy coordinator in the entity cache if it is enabled.
	*
	* @param legacyCoordinator the legacy coordinator
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacyCoordinator legacyCoordinator) {
		getPersistence().cacheResult(legacyCoordinator);
	}

	/**
	* Caches the legacy coordinators in the entity cache if it is enabled.
	*
	* @param legacyCoordinators the legacy coordinators
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacyCoordinator> legacyCoordinators) {
		getPersistence().cacheResult(legacyCoordinators);
	}

	/**
	* Creates a new legacy coordinator with the primary key. Does not add the legacy coordinator to the database.
	*
	* @param userId the primary key for the new legacy coordinator
	* @return the new legacy coordinator
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyCoordinator create(
		long userId) {
		return getPersistence().create(userId);
	}

	/**
	* Removes the legacy coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the legacy coordinator
	* @return the legacy coordinator that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException if a legacy coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyCoordinator remove(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException {
		return getPersistence().remove(userId);
	}

	public static de.uhh.l2g.plugins.migration.model.LegacyCoordinator updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyCoordinator legacyCoordinator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(legacyCoordinator);
	}

	/**
	* Returns the legacy coordinator with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException} if it could not be found.
	*
	* @param userId the primary key of the legacy coordinator
	* @return the legacy coordinator
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException if a legacy coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyCoordinator findByPrimaryKey(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException {
		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	* Returns the legacy coordinator with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the legacy coordinator
	* @return the legacy coordinator, or <code>null</code> if a legacy coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyCoordinator fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	* Returns all the legacy coordinators.
	*
	* @return the legacy coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyCoordinator> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the legacy coordinators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyCoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy coordinators
	* @param end the upper bound of the range of legacy coordinators (not inclusive)
	* @return the range of legacy coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyCoordinator> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the legacy coordinators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyCoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy coordinators
	* @param end the upper bound of the range of legacy coordinators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacy coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyCoordinator> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the legacy coordinators from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of legacy coordinators.
	*
	* @return the number of legacy coordinators
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LegacyCoordinatorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LegacyCoordinatorPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.migration.service.ClpSerializer.getServletContextName(),
					LegacyCoordinatorPersistence.class.getName());

			ReferenceRegistry.registerReference(LegacyCoordinatorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LegacyCoordinatorPersistence persistence) {
	}

	private static LegacyCoordinatorPersistence _persistence;
}