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

import de.uhh.l2g.plugins.model.Institution;

import java.util.List;

/**
 * The persistence utility for the institution service. This utility wraps {@link InstitutionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see InstitutionPersistence
 * @see InstitutionPersistenceImpl
 * @generated
 */
public class InstitutionUtil {
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
	public static void clearCache(Institution institution) {
		getPersistence().clearCache(institution);
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
	public static List<Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Institution update(Institution institution)
		throws SystemException {
		return getPersistence().update(institution);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Institution update(Institution institution,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(institution, serviceContext);
	}

	/**
	* Returns all the institutions where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByParent(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParent(parentId);
	}

	/**
	* Returns a range of all the institutions where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByParent(
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParent(parentId, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByParent(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParent(parentId, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByParent_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByParent_First(parentId, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByParent_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByParent_First(parentId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByParent_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByParent_Last(parentId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByParent_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByParent_Last(parentId, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where parentId = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByParent_PrevAndNext(
		long institutionId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByParent_PrevAndNext(institutionId, parentId,
			orderByComparator);
	}

	/**
	* Removes all the institutions where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParent(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParent(parentId);
	}

	/**
	* Returns the number of institutions where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParent(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParent(parentId);
	}

	/**
	* Returns all the institutions where name = &#63;.
	*
	* @param name the name
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the institutions where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where name = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByName_PrevAndNext(
		long institutionId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByName_PrevAndNext(institutionId, name,
			orderByComparator);
	}

	/**
	* Removes all the institutions where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of institutions where name = &#63;.
	*
	* @param name the name
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the institutions where typ = &#63;.
	*
	* @param typ the typ
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByTyp(
		java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTyp(typ);
	}

	/**
	* Returns a range of all the institutions where typ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typ the typ
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByTyp(
		java.lang.String typ, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTyp(typ, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where typ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typ the typ
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByTyp(
		java.lang.String typ, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTyp(typ, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByTyp_First(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByTyp_First(typ, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByTyp_First(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTyp_First(typ, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByTyp_Last(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByTyp_Last(typ, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByTyp_Last(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTyp_Last(typ, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where typ = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByTyp_PrevAndNext(
		long institutionId, java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByTyp_PrevAndNext(institutionId, typ, orderByComparator);
	}

	/**
	* Removes all the institutions where typ = &#63; from the database.
	*
	* @param typ the typ
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTyp(java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTyp(typ);
	}

	/**
	* Returns the number of institutions where typ = &#63;.
	*
	* @param typ the typ
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTyp(java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTyp(typ);
	}

	/**
	* Returns all the institutions where www = &#63;.
	*
	* @param www the www
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByWww(
		java.lang.String www)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWww(www);
	}

	/**
	* Returns a range of all the institutions where www = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param www the www
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByWww(
		java.lang.String www, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWww(www, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where www = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param www the www
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByWww(
		java.lang.String www, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWww(www, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where www = &#63;.
	*
	* @param www the www
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByWww_First(
		java.lang.String www,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByWww_First(www, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where www = &#63;.
	*
	* @param www the www
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByWww_First(
		java.lang.String www,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWww_First(www, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where www = &#63;.
	*
	* @param www the www
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByWww_Last(
		java.lang.String www,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByWww_Last(www, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where www = &#63;.
	*
	* @param www the www
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByWww_Last(
		java.lang.String www,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWww_Last(www, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where www = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param www the www
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByWww_PrevAndNext(
		long institutionId, java.lang.String www,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByWww_PrevAndNext(institutionId, www, orderByComparator);
	}

	/**
	* Removes all the institutions where www = &#63; from the database.
	*
	* @param www the www
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByWww(java.lang.String www)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByWww(www);
	}

	/**
	* Returns the number of institutions where www = &#63;.
	*
	* @param www the www
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWww(java.lang.String www)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWww(www);
	}

	/**
	* Returns all the institutions where level = &#63;.
	*
	* @param level the level
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findBylevel(
		int level) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylevel(level);
	}

	/**
	* Returns a range of all the institutions where level = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findBylevel(
		int level, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylevel(level, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where level = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findBylevel(
		int level, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylevel(level, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findBylevel_First(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findBylevel_First(level, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchBylevel_First(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBylevel_First(level, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findBylevel_Last(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findBylevel_Last(level, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchBylevel_Last(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBylevel_Last(level, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where level = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findBylevel_PrevAndNext(
		long institutionId, int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findBylevel_PrevAndNext(institutionId, level,
			orderByComparator);
	}

	/**
	* Removes all the institutions where level = &#63; from the database.
	*
	* @param level the level
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBylevel(int level)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBylevel(level);
	}

	/**
	* Returns the number of institutions where level = &#63;.
	*
	* @param level the level
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylevel(int level)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBylevel(level);
	}

	/**
	* Returns all the institutions where sort = &#63;.
	*
	* @param sort the sort
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findBySort(
		int sort) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySort(sort);
	}

	/**
	* Returns a range of all the institutions where sort = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sort the sort
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findBySort(
		int sort, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySort(sort, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where sort = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sort the sort
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findBySort(
		int sort, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySort(sort, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where sort = &#63;.
	*
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findBySort_First(
		int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findBySort_First(sort, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where sort = &#63;.
	*
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchBySort_First(
		int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySort_First(sort, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where sort = &#63;.
	*
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findBySort_Last(
		int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findBySort_Last(sort, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where sort = &#63;.
	*
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchBySort_Last(
		int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySort_Last(sort, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where sort = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findBySort_PrevAndNext(
		long institutionId, int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findBySort_PrevAndNext(institutionId, sort,
			orderByComparator);
	}

	/**
	* Removes all the institutions where sort = &#63; from the database.
	*
	* @param sort the sort
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySort(int sort)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySort(sort);
	}

	/**
	* Returns the number of institutions where sort = &#63;.
	*
	* @param sort the sort
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySort(int sort)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySort(sort);
	}

	/**
	* Returns all the institutions where level = &#63; and typ = &#63;.
	*
	* @param level the level
	* @param typ the typ
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByLevelAndType(
		int level, java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLevelAndType(level, typ);
	}

	/**
	* Returns a range of all the institutions where level = &#63; and typ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param typ the typ
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByLevelAndType(
		int level, java.lang.String typ, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLevelAndType(level, typ, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where level = &#63; and typ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param typ the typ
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByLevelAndType(
		int level, java.lang.String typ, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLevelAndType(level, typ, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where level = &#63; and typ = &#63;.
	*
	* @param level the level
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByLevelAndType_First(
		int level, java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByLevelAndType_First(level, typ, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where level = &#63; and typ = &#63;.
	*
	* @param level the level
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByLevelAndType_First(
		int level, java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLevelAndType_First(level, typ, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where level = &#63; and typ = &#63;.
	*
	* @param level the level
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByLevelAndType_Last(
		int level, java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByLevelAndType_Last(level, typ, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where level = &#63; and typ = &#63;.
	*
	* @param level the level
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByLevelAndType_Last(
		int level, java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLevelAndType_Last(level, typ, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where level = &#63; and typ = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param level the level
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByLevelAndType_PrevAndNext(
		long institutionId, int level, java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByLevelAndType_PrevAndNext(institutionId, level, typ,
			orderByComparator);
	}

	/**
	* Removes all the institutions where level = &#63; and typ = &#63; from the database.
	*
	* @param level the level
	* @param typ the typ
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLevelAndType(int level, java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLevelAndType(level, typ);
	}

	/**
	* Returns the number of institutions where level = &#63; and typ = &#63;.
	*
	* @param level the level
	* @param typ the typ
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLevelAndType(int level, java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLevelAndType(level, typ);
	}

	/**
	* Returns all the institutions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the institutions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where groupId = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByGroupId_PrevAndNext(
		long institutionId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(institutionId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the institutions where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of institutions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the institutions where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_P(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_P(groupId, parentId);
	}

	/**
	* Returns a range of all the institutions where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_P(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_P(groupId, parentId, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_P(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_P(groupId, parentId, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_P_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_P_First(groupId, parentId, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_P_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_P_First(groupId, parentId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_P_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_P_Last(groupId, parentId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_P_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_P_Last(groupId, parentId, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByG_P_PrevAndNext(
		long institutionId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_P_PrevAndNext(institutionId, groupId, parentId,
			orderByComparator);
	}

	/**
	* Removes all the institutions where groupId = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_P(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_P(groupId, parentId);
	}

	/**
	* Returns the number of institutions where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_P(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_P(groupId, parentId);
	}

	/**
	* Returns all the institutions where name = &#63; and groupId = &#63;.
	*
	* @param name the name
	* @param groupId the group ID
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_N(
		java.lang.String name, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_N(name, groupId);
	}

	/**
	* Returns a range of all the institutions where name = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_N(
		java.lang.String name, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_N(name, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where name = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_N(
		java.lang.String name, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_N(name, groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where name = &#63; and groupId = &#63;.
	*
	* @param name the name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_N_First(
		java.lang.String name, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByG_N_First(name, groupId, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where name = &#63; and groupId = &#63;.
	*
	* @param name the name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_N_First(
		java.lang.String name, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_N_First(name, groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where name = &#63; and groupId = &#63;.
	*
	* @param name the name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_N_Last(
		java.lang.String name, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByG_N_Last(name, groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where name = &#63; and groupId = &#63;.
	*
	* @param name the name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_N_Last(
		java.lang.String name, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_N_Last(name, groupId, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where name = &#63; and groupId = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param name the name
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByG_N_PrevAndNext(
		long institutionId, java.lang.String name, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_N_PrevAndNext(institutionId, name, groupId,
			orderByComparator);
	}

	/**
	* Removes all the institutions where name = &#63; and groupId = &#63; from the database.
	*
	* @param name the name
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_N(java.lang.String name, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_N(name, groupId);
	}

	/**
	* Returns the number of institutions where name = &#63; and groupId = &#63;.
	*
	* @param name the name
	* @param groupId the group ID
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_N(java.lang.String name, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_N(name, groupId);
	}

	/**
	* Returns all the institutions where typ = &#63; and groupId = &#63;.
	*
	* @param typ the typ
	* @param groupId the group ID
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_T(
		java.lang.String typ, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_T(typ, groupId);
	}

	/**
	* Returns a range of all the institutions where typ = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typ the typ
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_T(
		java.lang.String typ, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_T(typ, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where typ = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typ the typ
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_T(
		java.lang.String typ, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_T(typ, groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where typ = &#63; and groupId = &#63;.
	*
	* @param typ the typ
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_T_First(
		java.lang.String typ, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByG_T_First(typ, groupId, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where typ = &#63; and groupId = &#63;.
	*
	* @param typ the typ
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_T_First(
		java.lang.String typ, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_T_First(typ, groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where typ = &#63; and groupId = &#63;.
	*
	* @param typ the typ
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_T_Last(
		java.lang.String typ, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByG_T_Last(typ, groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where typ = &#63; and groupId = &#63;.
	*
	* @param typ the typ
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_T_Last(
		java.lang.String typ, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_T_Last(typ, groupId, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where typ = &#63; and groupId = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param typ the typ
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByG_T_PrevAndNext(
		long institutionId, java.lang.String typ, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_T_PrevAndNext(institutionId, typ, groupId,
			orderByComparator);
	}

	/**
	* Removes all the institutions where typ = &#63; and groupId = &#63; from the database.
	*
	* @param typ the typ
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_T(java.lang.String typ, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_T(typ, groupId);
	}

	/**
	* Returns the number of institutions where typ = &#63; and groupId = &#63;.
	*
	* @param typ the typ
	* @param groupId the group ID
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_T(java.lang.String typ, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_T(typ, groupId);
	}

	/**
	* Returns all the institutions where www = &#63; and groupId = &#63;.
	*
	* @param www the www
	* @param groupId the group ID
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_W(
		java.lang.String www, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_W(www, groupId);
	}

	/**
	* Returns a range of all the institutions where www = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param www the www
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_W(
		java.lang.String www, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_W(www, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where www = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param www the www
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_W(
		java.lang.String www, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_W(www, groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where www = &#63; and groupId = &#63;.
	*
	* @param www the www
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_W_First(
		java.lang.String www, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByG_W_First(www, groupId, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where www = &#63; and groupId = &#63;.
	*
	* @param www the www
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_W_First(
		java.lang.String www, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_W_First(www, groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where www = &#63; and groupId = &#63;.
	*
	* @param www the www
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_W_Last(
		java.lang.String www, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByG_W_Last(www, groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where www = &#63; and groupId = &#63;.
	*
	* @param www the www
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_W_Last(
		java.lang.String www, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_W_Last(www, groupId, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where www = &#63; and groupId = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param www the www
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByG_W_PrevAndNext(
		long institutionId, java.lang.String www, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_W_PrevAndNext(institutionId, www, groupId,
			orderByComparator);
	}

	/**
	* Removes all the institutions where www = &#63; and groupId = &#63; from the database.
	*
	* @param www the www
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_W(java.lang.String www, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_W(www, groupId);
	}

	/**
	* Returns the number of institutions where www = &#63; and groupId = &#63;.
	*
	* @param www the www
	* @param groupId the group ID
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_W(java.lang.String www, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_W(www, groupId);
	}

	/**
	* Returns all the institutions where level = &#63; and groupId = &#63;.
	*
	* @param level the level
	* @param groupId the group ID
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_L(
		int level, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L(level, groupId);
	}

	/**
	* Returns a range of all the institutions where level = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_L(
		int level, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L(level, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where level = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_L(
		int level, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L(level, groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where level = &#63; and groupId = &#63;.
	*
	* @param level the level
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_L_First(
		int level, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_L_First(level, groupId, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where level = &#63; and groupId = &#63;.
	*
	* @param level the level
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_L_First(
		int level, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_L_First(level, groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where level = &#63; and groupId = &#63;.
	*
	* @param level the level
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_L_Last(
		int level, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByG_L_Last(level, groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where level = &#63; and groupId = &#63;.
	*
	* @param level the level
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_L_Last(
		int level, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_L_Last(level, groupId, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where level = &#63; and groupId = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param level the level
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByG_L_PrevAndNext(
		long institutionId, int level, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_L_PrevAndNext(institutionId, level, groupId,
			orderByComparator);
	}

	/**
	* Removes all the institutions where level = &#63; and groupId = &#63; from the database.
	*
	* @param level the level
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L(int level, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L(level, groupId);
	}

	/**
	* Returns the number of institutions where level = &#63; and groupId = &#63;.
	*
	* @param level the level
	* @param groupId the group ID
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L(int level, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L(level, groupId);
	}

	/**
	* Returns all the institutions where sort = &#63; and groupId = &#63;.
	*
	* @param sort the sort
	* @param groupId the group ID
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_S(
		int sort, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(sort, groupId);
	}

	/**
	* Returns a range of all the institutions where sort = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sort the sort
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_S(
		int sort, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(sort, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where sort = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sort the sort
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_S(
		int sort, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S(sort, groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where sort = &#63; and groupId = &#63;.
	*
	* @param sort the sort
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_S_First(
		int sort, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByG_S_First(sort, groupId, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where sort = &#63; and groupId = &#63;.
	*
	* @param sort the sort
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_S_First(
		int sort, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_First(sort, groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where sort = &#63; and groupId = &#63;.
	*
	* @param sort the sort
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_S_Last(
		int sort, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByG_S_Last(sort, groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where sort = &#63; and groupId = &#63;.
	*
	* @param sort the sort
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_S_Last(
		int sort, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_S_Last(sort, groupId, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where sort = &#63; and groupId = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param sort the sort
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByG_S_PrevAndNext(
		long institutionId, int sort, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_S_PrevAndNext(institutionId, sort, groupId,
			orderByComparator);
	}

	/**
	* Removes all the institutions where sort = &#63; and groupId = &#63; from the database.
	*
	* @param sort the sort
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_S(int sort, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_S(sort, groupId);
	}

	/**
	* Returns the number of institutions where sort = &#63; and groupId = &#63;.
	*
	* @param sort the sort
	* @param groupId the group ID
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_S(int sort, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_S(sort, groupId);
	}

	/**
	* Returns all the institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	*
	* @param level the level
	* @param typ the typ
	* @param groupId the group ID
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_L_T(
		int level, java.lang.String typ, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L_T(level, typ, groupId);
	}

	/**
	* Returns a range of all the institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param typ the typ
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_L_T(
		int level, java.lang.String typ, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L_T(level, typ, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param typ the typ
	* @param groupId the group ID
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_L_T(
		int level, java.lang.String typ, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_T(level, typ, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	*
	* @param level the level
	* @param typ the typ
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_L_T_First(
		int level, java.lang.String typ, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_L_T_First(level, typ, groupId, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	*
	* @param level the level
	* @param typ the typ
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_L_T_First(
		int level, java.lang.String typ, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_L_T_First(level, typ, groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	*
	* @param level the level
	* @param typ the typ
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_L_T_Last(
		int level, java.lang.String typ, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_L_T_Last(level, typ, groupId, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	*
	* @param level the level
	* @param typ the typ
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_L_T_Last(
		int level, java.lang.String typ, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_L_T_Last(level, typ, groupId, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param level the level
	* @param typ the typ
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByG_L_T_PrevAndNext(
		long institutionId, int level, java.lang.String typ, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_L_T_PrevAndNext(institutionId, level, typ, groupId,
			orderByComparator);
	}

	/**
	* Removes all the institutions where level = &#63; and typ = &#63; and groupId = &#63; from the database.
	*
	* @param level the level
	* @param typ the typ
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L_T(int level, java.lang.String typ,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L_T(level, typ, groupId);
	}

	/**
	* Returns the number of institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	*
	* @param level the level
	* @param typ the typ
	* @param groupId the group ID
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L_T(int level, java.lang.String typ, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L_T(level, typ, groupId);
	}

	/**
	* Returns all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param sort the sort
	* @return the matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_P_S(
		long groupId, long parentId, int sort)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_P_S(groupId, parentId, sort);
	}

	/**
	* Returns a range of all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param sort the sort
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_P_S(
		long groupId, long parentId, int sort, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_P_S(groupId, parentId, sort, start, end);
	}

	/**
	* Returns an ordered range of all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param sort the sort
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findByG_P_S(
		long groupId, long parentId, int sort, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_P_S(groupId, parentId, sort, start, end,
			orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_P_S_First(
		long groupId, long parentId, int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_P_S_First(groupId, parentId, sort, orderByComparator);
	}

	/**
	* Returns the first institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_P_S_First(
		long groupId, long parentId, int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_P_S_First(groupId, parentId, sort,
			orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_P_S_Last(
		long groupId, long parentId, int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_P_S_Last(groupId, parentId, sort, orderByComparator);
	}

	/**
	* Returns the last institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_P_S_Last(
		long groupId, long parentId, int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_P_S_Last(groupId, parentId, sort, orderByComparator);
	}

	/**
	* Returns the institutions before and after the current institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	*
	* @param institutionId the primary key of the current institution
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param sort the sort
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution[] findByG_P_S_PrevAndNext(
		long institutionId, long groupId, long parentId, int sort,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence()
				   .findByG_P_S_PrevAndNext(institutionId, groupId, parentId,
			sort, orderByComparator);
	}

	/**
	* Removes all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param sort the sort
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_P_S(long groupId, long parentId, int sort)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_P_S(groupId, parentId, sort);
	}

	/**
	* Returns the number of institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param sort the sort
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_P_S(long groupId, long parentId, int sort)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_P_S(groupId, parentId, sort);
	}

	/**
	* Returns the institution where groupId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchInstitutionException} if it could not be found.
	*
	* @param groupId the group ID
	* @return the matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByTopLevel(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByTopLevel(groupId);
	}

	/**
	* Returns the institution where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @return the matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByTopLevel(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTopLevel(groupId);
	}

	/**
	* Returns the institution where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByTopLevel(
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTopLevel(groupId, retrieveFromCache);
	}

	/**
	* Removes the institution where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @return the institution that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution removeByTopLevel(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().removeByTopLevel(groupId);
	}

	/**
	* Returns the number of institutions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTopLevel(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTopLevel(groupId);
	}

	/**
	* Returns the institution where groupId = &#63; and institutionId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchInstitutionException} if it could not be found.
	*
	* @param groupId the group ID
	* @param institutionId the institution ID
	* @return the matching institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByG_I(long groupId,
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByG_I(groupId, institutionId);
	}

	/**
	* Returns the institution where groupId = &#63; and institutionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param institutionId the institution ID
	* @return the matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_I(
		long groupId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_I(groupId, institutionId);
	}

	/**
	* Returns the institution where groupId = &#63; and institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param institutionId the institution ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching institution, or <code>null</code> if a matching institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByG_I(
		long groupId, long institutionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_I(groupId, institutionId, retrieveFromCache);
	}

	/**
	* Removes the institution where groupId = &#63; and institutionId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param institutionId the institution ID
	* @return the institution that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution removeByG_I(
		long groupId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().removeByG_I(groupId, institutionId);
	}

	/**
	* Returns the number of institutions where groupId = &#63; and institutionId = &#63;.
	*
	* @param groupId the group ID
	* @param institutionId the institution ID
	* @return the number of matching institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_I(long groupId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_I(groupId, institutionId);
	}

	/**
	* Caches the institution in the entity cache if it is enabled.
	*
	* @param institution the institution
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Institution institution) {
		getPersistence().cacheResult(institution);
	}

	/**
	* Caches the institutions in the entity cache if it is enabled.
	*
	* @param institutions the institutions
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Institution> institutions) {
		getPersistence().cacheResult(institutions);
	}

	/**
	* Creates a new institution with the primary key. Does not add the institution to the database.
	*
	* @param institutionId the primary key for the new institution
	* @return the new institution
	*/
	public static de.uhh.l2g.plugins.model.Institution create(
		long institutionId) {
		return getPersistence().create(institutionId);
	}

	/**
	* Removes the institution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param institutionId the primary key of the institution
	* @return the institution that was removed
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution remove(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().remove(institutionId);
	}

	public static de.uhh.l2g.plugins.model.Institution updateImpl(
		de.uhh.l2g.plugins.model.Institution institution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(institution);
	}

	/**
	* Returns the institution with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchInstitutionException} if it could not be found.
	*
	* @param institutionId the primary key of the institution
	* @return the institution
	* @throws de.uhh.l2g.plugins.NoSuchInstitutionException if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution findByPrimaryKey(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstitutionException {
		return getPersistence().findByPrimaryKey(institutionId);
	}

	/**
	* Returns the institution with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param institutionId the primary key of the institution
	* @return the institution, or <code>null</code> if a institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Institution fetchByPrimaryKey(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(institutionId);
	}

	/**
	* Returns all the institutions.
	*
	* @return the institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the institutions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the institutions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Institution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the institutions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of institutions.
	*
	* @return the number of institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static InstitutionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (InstitutionPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					InstitutionPersistence.class.getName());

			ReferenceRegistry.registerReference(InstitutionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(InstitutionPersistence persistence) {
	}

	private static InstitutionPersistence _persistence;
}