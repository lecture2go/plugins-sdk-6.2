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

import de.uhh.l2g.plugins.model.Facility;

import java.util.List;

/**
 * The persistence utility for the facility service. This utility wraps {@link FacilityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see FacilityPersistence
 * @see FacilityPersistenceImpl
 * @generated
 */
public class FacilityUtil {
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
	public static void clearCache(Facility facility) {
		getPersistence().clearCache(facility);
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
	public static List<Facility> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Facility> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Facility> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Facility update(Facility facility) throws SystemException {
		return getPersistence().update(facility);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Facility update(Facility facility,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(facility, serviceContext);
	}

	/**
	* Returns all the facilities where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findByParent(
		int parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParent(parentId);
	}

	/**
	* Returns a range of all the facilities where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @return the range of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findByParent(
		int parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParent(parentId, start, end);
	}

	/**
	* Returns an ordered range of all the facilities where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findByParent(
		int parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParent(parentId, start, end, orderByComparator);
	}

	/**
	* Returns the first facility in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findByParent_First(
		int parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findByParent_First(parentId, orderByComparator);
	}

	/**
	* Returns the first facility in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility, or <code>null</code> if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchByParent_First(
		int parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByParent_First(parentId, orderByComparator);
	}

	/**
	* Returns the last facility in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findByParent_Last(
		int parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findByParent_Last(parentId, orderByComparator);
	}

	/**
	* Returns the last facility in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility, or <code>null</code> if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchByParent_Last(
		int parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByParent_Last(parentId, orderByComparator);
	}

	/**
	* Returns the facilities before and after the current facility in the ordered set where parentId = &#63;.
	*
	* @param facilityId the primary key of the current facility
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility[] findByParent_PrevAndNext(
		long facilityId, int parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence()
				   .findByParent_PrevAndNext(facilityId, parentId,
			orderByComparator);
	}

	/**
	* Removes all the facilities where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParent(int parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParent(parentId);
	}

	/**
	* Returns the number of facilities where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParent(int parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParent(parentId);
	}

	/**
	* Returns all the facilities where name = &#63;.
	*
	* @param name the name
	* @return the matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the facilities where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @return the range of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the facilities where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first facility in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first facility in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility, or <code>null</code> if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last facility in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last facility in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility, or <code>null</code> if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the facilities before and after the current facility in the ordered set where name = &#63;.
	*
	* @param facilityId the primary key of the current facility
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility[] findByName_PrevAndNext(
		long facilityId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence()
				   .findByName_PrevAndNext(facilityId, name, orderByComparator);
	}

	/**
	* Removes all the facilities where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of facilities where name = &#63;.
	*
	* @param name the name
	* @return the number of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the facilities where typ = &#63;.
	*
	* @param typ the typ
	* @return the matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findByTyp(
		java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTyp(typ);
	}

	/**
	* Returns a range of all the facilities where typ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typ the typ
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @return the range of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findByTyp(
		java.lang.String typ, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTyp(typ, start, end);
	}

	/**
	* Returns an ordered range of all the facilities where typ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typ the typ
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findByTyp(
		java.lang.String typ, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTyp(typ, start, end, orderByComparator);
	}

	/**
	* Returns the first facility in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findByTyp_First(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findByTyp_First(typ, orderByComparator);
	}

	/**
	* Returns the first facility in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility, or <code>null</code> if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchByTyp_First(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTyp_First(typ, orderByComparator);
	}

	/**
	* Returns the last facility in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findByTyp_Last(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findByTyp_Last(typ, orderByComparator);
	}

	/**
	* Returns the last facility in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility, or <code>null</code> if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchByTyp_Last(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTyp_Last(typ, orderByComparator);
	}

	/**
	* Returns the facilities before and after the current facility in the ordered set where typ = &#63;.
	*
	* @param facilityId the primary key of the current facility
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility[] findByTyp_PrevAndNext(
		long facilityId, java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence()
				   .findByTyp_PrevAndNext(facilityId, typ, orderByComparator);
	}

	/**
	* Removes all the facilities where typ = &#63; from the database.
	*
	* @param typ the typ
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTyp(java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTyp(typ);
	}

	/**
	* Returns the number of facilities where typ = &#63;.
	*
	* @param typ the typ
	* @return the number of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTyp(java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTyp(typ);
	}

	/**
	* Returns all the facilities where www = &#63;.
	*
	* @param www the www
	* @return the matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findByWww(
		java.lang.String www)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWww(www);
	}

	/**
	* Returns a range of all the facilities where www = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param www the www
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @return the range of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findByWww(
		java.lang.String www, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWww(www, start, end);
	}

	/**
	* Returns an ordered range of all the facilities where www = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param www the www
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findByWww(
		java.lang.String www, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWww(www, start, end, orderByComparator);
	}

	/**
	* Returns the first facility in the ordered set where www = &#63;.
	*
	* @param www the www
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findByWww_First(
		java.lang.String www,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findByWww_First(www, orderByComparator);
	}

	/**
	* Returns the first facility in the ordered set where www = &#63;.
	*
	* @param www the www
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility, or <code>null</code> if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchByWww_First(
		java.lang.String www,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWww_First(www, orderByComparator);
	}

	/**
	* Returns the last facility in the ordered set where www = &#63;.
	*
	* @param www the www
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findByWww_Last(
		java.lang.String www,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findByWww_Last(www, orderByComparator);
	}

	/**
	* Returns the last facility in the ordered set where www = &#63;.
	*
	* @param www the www
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility, or <code>null</code> if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchByWww_Last(
		java.lang.String www,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWww_Last(www, orderByComparator);
	}

	/**
	* Returns the facilities before and after the current facility in the ordered set where www = &#63;.
	*
	* @param facilityId the primary key of the current facility
	* @param www the www
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility[] findByWww_PrevAndNext(
		long facilityId, java.lang.String www,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence()
				   .findByWww_PrevAndNext(facilityId, www, orderByComparator);
	}

	/**
	* Removes all the facilities where www = &#63; from the database.
	*
	* @param www the www
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByWww(java.lang.String www)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByWww(www);
	}

	/**
	* Returns the number of facilities where www = &#63;.
	*
	* @param www the www
	* @return the number of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWww(java.lang.String www)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWww(www);
	}

	/**
	* Returns all the facilities where level = &#63;.
	*
	* @param level the level
	* @return the matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findBylevel(
		int level) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylevel(level);
	}

	/**
	* Returns a range of all the facilities where level = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @return the range of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findBylevel(
		int level, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylevel(level, start, end);
	}

	/**
	* Returns an ordered range of all the facilities where level = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findBylevel(
		int level, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylevel(level, start, end, orderByComparator);
	}

	/**
	* Returns the first facility in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findBylevel_First(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findBylevel_First(level, orderByComparator);
	}

	/**
	* Returns the first facility in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility, or <code>null</code> if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchBylevel_First(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBylevel_First(level, orderByComparator);
	}

	/**
	* Returns the last facility in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findBylevel_Last(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findBylevel_Last(level, orderByComparator);
	}

	/**
	* Returns the last facility in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility, or <code>null</code> if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchBylevel_Last(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBylevel_Last(level, orderByComparator);
	}

	/**
	* Returns the facilities before and after the current facility in the ordered set where level = &#63;.
	*
	* @param facilityId the primary key of the current facility
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility[] findBylevel_PrevAndNext(
		long facilityId, int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence()
				   .findBylevel_PrevAndNext(facilityId, level, orderByComparator);
	}

	/**
	* Removes all the facilities where level = &#63; from the database.
	*
	* @param level the level
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBylevel(int level)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBylevel(level);
	}

	/**
	* Returns the number of facilities where level = &#63;.
	*
	* @param level the level
	* @return the number of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylevel(int level)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBylevel(level);
	}

	/**
	* Returns all the facilities where sort = &#63;.
	*
	* @param sort the sort
	* @return the matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findBySort(
		int sort) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySort(sort);
	}

	/**
	* Returns a range of all the facilities where sort = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sort the sort
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @return the range of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findBySort(
		int sort, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySort(sort, start, end);
	}

	/**
	* Returns an ordered range of all the facilities where sort = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sort the sort
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findBySort(
		int sort, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySort(sort, start, end, orderByComparator);
	}

	/**
	* Returns the first facility in the ordered set where sort = &#63;.
	*
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findBySort_First(int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findBySort_First(sort, orderByComparator);
	}

	/**
	* Returns the first facility in the ordered set where sort = &#63;.
	*
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching facility, or <code>null</code> if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchBySort_First(
		int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySort_First(sort, orderByComparator);
	}

	/**
	* Returns the last facility in the ordered set where sort = &#63;.
	*
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findBySort_Last(int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findBySort_Last(sort, orderByComparator);
	}

	/**
	* Returns the last facility in the ordered set where sort = &#63;.
	*
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching facility, or <code>null</code> if a matching facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchBySort_Last(int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySort_Last(sort, orderByComparator);
	}

	/**
	* Returns the facilities before and after the current facility in the ordered set where sort = &#63;.
	*
	* @param facilityId the primary key of the current facility
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility[] findBySort_PrevAndNext(
		long facilityId, int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence()
				   .findBySort_PrevAndNext(facilityId, sort, orderByComparator);
	}

	/**
	* Removes all the facilities where sort = &#63; from the database.
	*
	* @param sort the sort
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySort(int sort)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySort(sort);
	}

	/**
	* Returns the number of facilities where sort = &#63;.
	*
	* @param sort the sort
	* @return the number of matching facilities
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySort(int sort)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySort(sort);
	}

	/**
	* Caches the facility in the entity cache if it is enabled.
	*
	* @param facility the facility
	*/
	public static void cacheResult(de.uhh.l2g.plugins.model.Facility facility) {
		getPersistence().cacheResult(facility);
	}

	/**
	* Caches the facilities in the entity cache if it is enabled.
	*
	* @param facilities the facilities
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Facility> facilities) {
		getPersistence().cacheResult(facilities);
	}

	/**
	* Creates a new facility with the primary key. Does not add the facility to the database.
	*
	* @param facilityId the primary key for the new facility
	* @return the new facility
	*/
	public static de.uhh.l2g.plugins.model.Facility create(long facilityId) {
		return getPersistence().create(facilityId);
	}

	/**
	* Removes the facility with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param facilityId the primary key of the facility
	* @return the facility that was removed
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility remove(long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().remove(facilityId);
	}

	public static de.uhh.l2g.plugins.model.Facility updateImpl(
		de.uhh.l2g.plugins.model.Facility facility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(facility);
	}

	/**
	* Returns the facility with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchFacilityException} if it could not be found.
	*
	* @param facilityId the primary key of the facility
	* @return the facility
	* @throws de.uhh.l2g.plugins.NoSuchFacilityException if a facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility findByPrimaryKey(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchFacilityException {
		return getPersistence().findByPrimaryKey(facilityId);
	}

	/**
	* Returns the facility with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param facilityId the primary key of the facility
	* @return the facility, or <code>null</code> if a facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Facility fetchByPrimaryKey(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(facilityId);
	}

	/**
	* Returns all the facilities.
	*
	* @return the facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the facilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @return the range of facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the facilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of facilities
	* @param end the upper bound of the range of facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of facilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Facility> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the facilities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of facilities.
	*
	* @return the number of facilities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FacilityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FacilityPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					FacilityPersistence.class.getName());

			ReferenceRegistry.registerReference(FacilityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FacilityPersistence persistence) {
	}

	private static FacilityPersistence _persistence;
}