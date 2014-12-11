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

import de.uhh.l2g.plugins.model.Videohitlist;

import java.util.List;

/**
 * The persistence utility for the videohitlist service. This utility wraps {@link VideohitlistPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideohitlistPersistence
 * @see VideohitlistPersistenceImpl
 * @generated
 */
public class VideohitlistUtil {
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
	public static void clearCache(Videohitlist videohitlist) {
		getPersistence().clearCache(videohitlist);
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
	public static List<Videohitlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Videohitlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Videohitlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Videohitlist update(Videohitlist videohitlist)
		throws SystemException {
		return getPersistence().update(videohitlist);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Videohitlist update(Videohitlist videohitlist,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(videohitlist, serviceContext);
	}

	/**
	* Caches the videohitlist in the entity cache if it is enabled.
	*
	* @param videohitlist the videohitlist
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Videohitlist videohitlist) {
		getPersistence().cacheResult(videohitlist);
	}

	/**
	* Caches the videohitlists in the entity cache if it is enabled.
	*
	* @param videohitlists the videohitlists
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Videohitlist> videohitlists) {
		getPersistence().cacheResult(videohitlists);
	}

	/**
	* Creates a new videohitlist with the primary key. Does not add the videohitlist to the database.
	*
	* @param videohitlistId the primary key for the new videohitlist
	* @return the new videohitlist
	*/
	public static de.uhh.l2g.plugins.model.Videohitlist create(
		long videohitlistId) {
		return getPersistence().create(videohitlistId);
	}

	/**
	* Removes the videohitlist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videohitlistId the primary key of the videohitlist
	* @return the videohitlist that was removed
	* @throws de.uhh.l2g.plugins.NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Videohitlist remove(
		long videohitlistId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideohitlistException {
		return getPersistence().remove(videohitlistId);
	}

	public static de.uhh.l2g.plugins.model.Videohitlist updateImpl(
		de.uhh.l2g.plugins.model.Videohitlist videohitlist)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videohitlist);
	}

	/**
	* Returns the videohitlist with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchVideohitlistException} if it could not be found.
	*
	* @param videohitlistId the primary key of the videohitlist
	* @return the videohitlist
	* @throws de.uhh.l2g.plugins.NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Videohitlist findByPrimaryKey(
		long videohitlistId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchVideohitlistException {
		return getPersistence().findByPrimaryKey(videohitlistId);
	}

	/**
	* Returns the videohitlist with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videohitlistId the primary key of the videohitlist
	* @return the videohitlist, or <code>null</code> if a videohitlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Videohitlist fetchByPrimaryKey(
		long videohitlistId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videohitlistId);
	}

	/**
	* Returns all the videohitlists.
	*
	* @return the videohitlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Videohitlist> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the videohitlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videohitlists
	* @param end the upper bound of the range of videohitlists (not inclusive)
	* @return the range of videohitlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Videohitlist> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the videohitlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of videohitlists
	* @param end the upper bound of the range of videohitlists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of videohitlists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Videohitlist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the videohitlists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of videohitlists.
	*
	* @return the number of videohitlists
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideohitlistPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideohitlistPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					VideohitlistPersistence.class.getName());

			ReferenceRegistry.registerReference(VideohitlistUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VideohitlistPersistence persistence) {
	}

	private static VideohitlistPersistence _persistence;
}