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

import de.uhh.l2g.plugins.model.Autocomplete;

import java.util.List;

/**
 * The persistence utility for the autocomplete service. This utility wraps {@link AutocompletePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see AutocompletePersistence
 * @see AutocompletePersistenceImpl
 * @generated
 */
public class AutocompleteUtil {
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
	public static void clearCache(Autocomplete autocomplete) {
		getPersistence().clearCache(autocomplete);
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
	public static List<Autocomplete> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Autocomplete> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Autocomplete> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Autocomplete update(Autocomplete autocomplete)
		throws SystemException {
		return getPersistence().update(autocomplete);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Autocomplete update(Autocomplete autocomplete,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(autocomplete, serviceContext);
	}

	/**
	* Caches the autocomplete in the entity cache if it is enabled.
	*
	* @param autocomplete the autocomplete
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Autocomplete autocomplete) {
		getPersistence().cacheResult(autocomplete);
	}

	/**
	* Caches the autocompletes in the entity cache if it is enabled.
	*
	* @param autocompletes the autocompletes
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Autocomplete> autocompletes) {
		getPersistence().cacheResult(autocompletes);
	}

	/**
	* Creates a new autocomplete with the primary key. Does not add the autocomplete to the database.
	*
	* @param autocompleteId the primary key for the new autocomplete
	* @return the new autocomplete
	*/
	public static de.uhh.l2g.plugins.model.Autocomplete create(
		long autocompleteId) {
		return getPersistence().create(autocompleteId);
	}

	/**
	* Removes the autocomplete with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param autocompleteId the primary key of the autocomplete
	* @return the autocomplete that was removed
	* @throws de.uhh.l2g.plugins.NoSuchAutocompleteException if a autocomplete with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Autocomplete remove(
		long autocompleteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchAutocompleteException {
		return getPersistence().remove(autocompleteId);
	}

	public static de.uhh.l2g.plugins.model.Autocomplete updateImpl(
		de.uhh.l2g.plugins.model.Autocomplete autocomplete)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(autocomplete);
	}

	/**
	* Returns the autocomplete with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchAutocompleteException} if it could not be found.
	*
	* @param autocompleteId the primary key of the autocomplete
	* @return the autocomplete
	* @throws de.uhh.l2g.plugins.NoSuchAutocompleteException if a autocomplete with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Autocomplete findByPrimaryKey(
		long autocompleteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchAutocompleteException {
		return getPersistence().findByPrimaryKey(autocompleteId);
	}

	/**
	* Returns the autocomplete with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param autocompleteId the primary key of the autocomplete
	* @return the autocomplete, or <code>null</code> if a autocomplete with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Autocomplete fetchByPrimaryKey(
		long autocompleteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(autocompleteId);
	}

	/**
	* Returns all the autocompletes.
	*
	* @return the autocompletes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Autocomplete> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the autocompletes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.AutocompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of autocompletes
	* @param end the upper bound of the range of autocompletes (not inclusive)
	* @return the range of autocompletes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Autocomplete> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the autocompletes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.AutocompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of autocompletes
	* @param end the upper bound of the range of autocompletes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of autocompletes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Autocomplete> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the autocompletes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of autocompletes.
	*
	* @return the number of autocompletes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AutocompletePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AutocompletePersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					AutocompletePersistence.class.getName());

			ReferenceRegistry.registerReference(AutocompleteUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AutocompletePersistence persistence) {
	}

	private static AutocompletePersistence _persistence;
}