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

import de.uhh.l2g.plugins.migration.model.LegacyProducer;

import java.util.List;

/**
 * The persistence utility for the legacy producer service. This utility wraps {@link LegacyProducerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyProducerPersistence
 * @see LegacyProducerPersistenceImpl
 * @generated
 */
public class LegacyProducerUtil {
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
	public static void clearCache(LegacyProducer legacyProducer) {
		getPersistence().clearCache(legacyProducer);
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
	public static List<LegacyProducer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegacyProducer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegacyProducer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LegacyProducer update(LegacyProducer legacyProducer)
		throws SystemException {
		return getPersistence().update(legacyProducer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LegacyProducer update(LegacyProducer legacyProducer,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(legacyProducer, serviceContext);
	}

	/**
	* Caches the legacy producer in the entity cache if it is enabled.
	*
	* @param legacyProducer the legacy producer
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacyProducer legacyProducer) {
		getPersistence().cacheResult(legacyProducer);
	}

	/**
	* Caches the legacy producers in the entity cache if it is enabled.
	*
	* @param legacyProducers the legacy producers
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacyProducer> legacyProducers) {
		getPersistence().cacheResult(legacyProducers);
	}

	/**
	* Creates a new legacy producer with the primary key. Does not add the legacy producer to the database.
	*
	* @param id the primary key for the new legacy producer
	* @return the new legacy producer
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyProducer create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the legacy producer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy producer
	* @return the legacy producer that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException if a legacy producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyProducer remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException {
		return getPersistence().remove(id);
	}

	public static de.uhh.l2g.plugins.migration.model.LegacyProducer updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyProducer legacyProducer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(legacyProducer);
	}

	/**
	* Returns the legacy producer with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException} if it could not be found.
	*
	* @param id the primary key of the legacy producer
	* @return the legacy producer
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException if a legacy producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyProducer findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the legacy producer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the legacy producer
	* @return the legacy producer, or <code>null</code> if a legacy producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyProducer fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the legacy producers.
	*
	* @return the legacy producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyProducer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the legacy producers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy producers
	* @param end the upper bound of the range of legacy producers (not inclusive)
	* @return the range of legacy producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyProducer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the legacy producers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy producers
	* @param end the upper bound of the range of legacy producers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacy producers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyProducer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the legacy producers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of legacy producers.
	*
	* @return the number of legacy producers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LegacyProducerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LegacyProducerPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.migration.service.ClpSerializer.getServletContextName(),
					LegacyProducerPersistence.class.getName());

			ReferenceRegistry.registerReference(LegacyProducerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LegacyProducerPersistence persistence) {
	}

	private static LegacyProducerPersistence _persistence;
}