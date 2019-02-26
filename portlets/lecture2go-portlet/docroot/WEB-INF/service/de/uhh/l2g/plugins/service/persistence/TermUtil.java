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

import de.uhh.l2g.plugins.model.Term;

import java.util.List;

/**
 * The persistence utility for the term service. This utility wraps {@link TermPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see TermPersistence
 * @see TermPersistenceImpl
 * @generated
 */
public class TermUtil {
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
	public static void clearCache(Term term) {
		getPersistence().clearCache(term);
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
	public static List<Term> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Term> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Term> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Term update(Term term) throws SystemException {
		return getPersistence().update(term);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Term update(Term term, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(term, serviceContext);
	}

	/**
	* Returns all the terms where prefix = &#63;.
	*
	* @param prefix the prefix
	* @return the matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findByPrefix(
		java.lang.String prefix)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrefix(prefix);
	}

	/**
	* Returns a range of all the terms where prefix = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param prefix the prefix
	* @param start the lower bound of the range of terms
	* @param end the upper bound of the range of terms (not inclusive)
	* @return the range of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findByPrefix(
		java.lang.String prefix, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrefix(prefix, start, end);
	}

	/**
	* Returns an ordered range of all the terms where prefix = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param prefix the prefix
	* @param start the lower bound of the range of terms
	* @param end the upper bound of the range of terms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findByPrefix(
		java.lang.String prefix, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrefix(prefix, start, end, orderByComparator);
	}

	/**
	* Returns the first term in the ordered set where prefix = &#63;.
	*
	* @param prefix the prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching term
	* @throws de.uhh.l2g.plugins.NoSuchTermException if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term findByPrefix_First(
		java.lang.String prefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTermException {
		return getPersistence().findByPrefix_First(prefix, orderByComparator);
	}

	/**
	* Returns the first term in the ordered set where prefix = &#63;.
	*
	* @param prefix the prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching term, or <code>null</code> if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term fetchByPrefix_First(
		java.lang.String prefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrefix_First(prefix, orderByComparator);
	}

	/**
	* Returns the last term in the ordered set where prefix = &#63;.
	*
	* @param prefix the prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching term
	* @throws de.uhh.l2g.plugins.NoSuchTermException if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term findByPrefix_Last(
		java.lang.String prefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTermException {
		return getPersistence().findByPrefix_Last(prefix, orderByComparator);
	}

	/**
	* Returns the last term in the ordered set where prefix = &#63;.
	*
	* @param prefix the prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching term, or <code>null</code> if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term fetchByPrefix_Last(
		java.lang.String prefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrefix_Last(prefix, orderByComparator);
	}

	/**
	* Returns the terms before and after the current term in the ordered set where prefix = &#63;.
	*
	* @param termId the primary key of the current term
	* @param prefix the prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next term
	* @throws de.uhh.l2g.plugins.NoSuchTermException if a term with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term[] findByPrefix_PrevAndNext(
		long termId, java.lang.String prefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTermException {
		return getPersistence()
				   .findByPrefix_PrevAndNext(termId, prefix, orderByComparator);
	}

	/**
	* Removes all the terms where prefix = &#63; from the database.
	*
	* @param prefix the prefix
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPrefix(java.lang.String prefix)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPrefix(prefix);
	}

	/**
	* Returns the number of terms where prefix = &#63;.
	*
	* @param prefix the prefix
	* @return the number of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPrefix(java.lang.String prefix)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPrefix(prefix);
	}

	/**
	* Returns all the terms where year = &#63;.
	*
	* @param year the year
	* @return the matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findByYear(
		java.lang.String year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear(year);
	}

	/**
	* Returns a range of all the terms where year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param year the year
	* @param start the lower bound of the range of terms
	* @param end the upper bound of the range of terms (not inclusive)
	* @return the range of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findByYear(
		java.lang.String year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear(year, start, end);
	}

	/**
	* Returns an ordered range of all the terms where year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param year the year
	* @param start the lower bound of the range of terms
	* @param end the upper bound of the range of terms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findByYear(
		java.lang.String year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear(year, start, end, orderByComparator);
	}

	/**
	* Returns the first term in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching term
	* @throws de.uhh.l2g.plugins.NoSuchTermException if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term findByYear_First(
		java.lang.String year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTermException {
		return getPersistence().findByYear_First(year, orderByComparator);
	}

	/**
	* Returns the first term in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching term, or <code>null</code> if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term fetchByYear_First(
		java.lang.String year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByYear_First(year, orderByComparator);
	}

	/**
	* Returns the last term in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching term
	* @throws de.uhh.l2g.plugins.NoSuchTermException if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term findByYear_Last(
		java.lang.String year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTermException {
		return getPersistence().findByYear_Last(year, orderByComparator);
	}

	/**
	* Returns the last term in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching term, or <code>null</code> if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term fetchByYear_Last(
		java.lang.String year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByYear_Last(year, orderByComparator);
	}

	/**
	* Returns the terms before and after the current term in the ordered set where year = &#63;.
	*
	* @param termId the primary key of the current term
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next term
	* @throws de.uhh.l2g.plugins.NoSuchTermException if a term with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term[] findByYear_PrevAndNext(
		long termId, java.lang.String year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTermException {
		return getPersistence()
				   .findByYear_PrevAndNext(termId, year, orderByComparator);
	}

	/**
	* Removes all the terms where year = &#63; from the database.
	*
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByYear(java.lang.String year)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByYear(year);
	}

	/**
	* Returns the number of terms where year = &#63;.
	*
	* @param year the year
	* @return the number of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByYear(java.lang.String year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByYear(year);
	}

	/**
	* Returns all the terms where prefix = &#63; and year = &#63;.
	*
	* @param prefix the prefix
	* @param year the year
	* @return the matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findByPrefixAndYear(
		java.lang.String prefix, java.lang.String year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrefixAndYear(prefix, year);
	}

	/**
	* Returns a range of all the terms where prefix = &#63; and year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param prefix the prefix
	* @param year the year
	* @param start the lower bound of the range of terms
	* @param end the upper bound of the range of terms (not inclusive)
	* @return the range of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findByPrefixAndYear(
		java.lang.String prefix, java.lang.String year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrefixAndYear(prefix, year, start, end);
	}

	/**
	* Returns an ordered range of all the terms where prefix = &#63; and year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param prefix the prefix
	* @param year the year
	* @param start the lower bound of the range of terms
	* @param end the upper bound of the range of terms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findByPrefixAndYear(
		java.lang.String prefix, java.lang.String year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrefixAndYear(prefix, year, start, end,
			orderByComparator);
	}

	/**
	* Returns the first term in the ordered set where prefix = &#63; and year = &#63;.
	*
	* @param prefix the prefix
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching term
	* @throws de.uhh.l2g.plugins.NoSuchTermException if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term findByPrefixAndYear_First(
		java.lang.String prefix, java.lang.String year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTermException {
		return getPersistence()
				   .findByPrefixAndYear_First(prefix, year, orderByComparator);
	}

	/**
	* Returns the first term in the ordered set where prefix = &#63; and year = &#63;.
	*
	* @param prefix the prefix
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching term, or <code>null</code> if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term fetchByPrefixAndYear_First(
		java.lang.String prefix, java.lang.String year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrefixAndYear_First(prefix, year, orderByComparator);
	}

	/**
	* Returns the last term in the ordered set where prefix = &#63; and year = &#63;.
	*
	* @param prefix the prefix
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching term
	* @throws de.uhh.l2g.plugins.NoSuchTermException if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term findByPrefixAndYear_Last(
		java.lang.String prefix, java.lang.String year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTermException {
		return getPersistence()
				   .findByPrefixAndYear_Last(prefix, year, orderByComparator);
	}

	/**
	* Returns the last term in the ordered set where prefix = &#63; and year = &#63;.
	*
	* @param prefix the prefix
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching term, or <code>null</code> if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term fetchByPrefixAndYear_Last(
		java.lang.String prefix, java.lang.String year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrefixAndYear_Last(prefix, year, orderByComparator);
	}

	/**
	* Returns the terms before and after the current term in the ordered set where prefix = &#63; and year = &#63;.
	*
	* @param termId the primary key of the current term
	* @param prefix the prefix
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next term
	* @throws de.uhh.l2g.plugins.NoSuchTermException if a term with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term[] findByPrefixAndYear_PrevAndNext(
		long termId, java.lang.String prefix, java.lang.String year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTermException {
		return getPersistence()
				   .findByPrefixAndYear_PrevAndNext(termId, prefix, year,
			orderByComparator);
	}

	/**
	* Removes all the terms where prefix = &#63; and year = &#63; from the database.
	*
	* @param prefix the prefix
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPrefixAndYear(java.lang.String prefix,
		java.lang.String year)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPrefixAndYear(prefix, year);
	}

	/**
	* Returns the number of terms where prefix = &#63; and year = &#63;.
	*
	* @param prefix the prefix
	* @param year the year
	* @return the number of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPrefixAndYear(java.lang.String prefix,
		java.lang.String year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPrefixAndYear(prefix, year);
	}

	/**
	* Caches the term in the entity cache if it is enabled.
	*
	* @param term the term
	*/
	public static void cacheResult(de.uhh.l2g.plugins.model.Term term) {
		getPersistence().cacheResult(term);
	}

	/**
	* Caches the terms in the entity cache if it is enabled.
	*
	* @param terms the terms
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Term> terms) {
		getPersistence().cacheResult(terms);
	}

	/**
	* Creates a new term with the primary key. Does not add the term to the database.
	*
	* @param termId the primary key for the new term
	* @return the new term
	*/
	public static de.uhh.l2g.plugins.model.Term create(long termId) {
		return getPersistence().create(termId);
	}

	/**
	* Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param termId the primary key of the term
	* @return the term that was removed
	* @throws de.uhh.l2g.plugins.NoSuchTermException if a term with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term remove(long termId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTermException {
		return getPersistence().remove(termId);
	}

	public static de.uhh.l2g.plugins.model.Term updateImpl(
		de.uhh.l2g.plugins.model.Term term)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(term);
	}

	/**
	* Returns the term with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchTermException} if it could not be found.
	*
	* @param termId the primary key of the term
	* @return the term
	* @throws de.uhh.l2g.plugins.NoSuchTermException if a term with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term findByPrimaryKey(long termId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTermException {
		return getPersistence().findByPrimaryKey(termId);
	}

	/**
	* Returns the term with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param termId the primary key of the term
	* @return the term, or <code>null</code> if a term with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Term fetchByPrimaryKey(long termId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(termId);
	}

	/**
	* Returns all the terms.
	*
	* @return the terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the terms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of terms
	* @param end the upper bound of the range of terms (not inclusive)
	* @return the range of terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the terms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of terms
	* @param end the upper bound of the range of terms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Term> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the terms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of terms.
	*
	* @return the number of terms
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TermPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TermPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					TermPersistence.class.getName());

			ReferenceRegistry.registerReference(TermUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TermPersistence persistence) {
	}

	private static TermPersistence _persistence;
}