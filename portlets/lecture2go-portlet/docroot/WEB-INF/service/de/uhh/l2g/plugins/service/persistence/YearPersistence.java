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

import com.liferay.portal.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.model.Year;

/**
 * The persistence interface for the year service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see YearPersistenceImpl
 * @see YearUtil
 * @generated
 */
public interface YearPersistence extends BasePersistence<Year> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link YearUtil} to access the year persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the years where prefix = &#63;.
	*
	* @param prefix the prefix
	* @return the matching years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Year> findByPrefix(
		java.lang.String prefix)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the years where prefix = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.YearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param prefix the prefix
	* @param start the lower bound of the range of years
	* @param end the upper bound of the range of years (not inclusive)
	* @return the range of matching years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Year> findByPrefix(
		java.lang.String prefix, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the years where prefix = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.YearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param prefix the prefix
	* @param start the lower bound of the range of years
	* @param end the upper bound of the range of years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Year> findByPrefix(
		java.lang.String prefix, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first year in the ordered set where prefix = &#63;.
	*
	* @param prefix the prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching year
	* @throws de.uhh.l2g.plugins.NoSuchYearException if a matching year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year findByPrefix_First(
		java.lang.String prefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchYearException;

	/**
	* Returns the first year in the ordered set where prefix = &#63;.
	*
	* @param prefix the prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching year, or <code>null</code> if a matching year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year fetchByPrefix_First(
		java.lang.String prefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last year in the ordered set where prefix = &#63;.
	*
	* @param prefix the prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching year
	* @throws de.uhh.l2g.plugins.NoSuchYearException if a matching year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year findByPrefix_Last(
		java.lang.String prefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchYearException;

	/**
	* Returns the last year in the ordered set where prefix = &#63;.
	*
	* @param prefix the prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching year, or <code>null</code> if a matching year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year fetchByPrefix_Last(
		java.lang.String prefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the years before and after the current year in the ordered set where prefix = &#63;.
	*
	* @param yearId the primary key of the current year
	* @param prefix the prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next year
	* @throws de.uhh.l2g.plugins.NoSuchYearException if a year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year[] findByPrefix_PrevAndNext(
		long yearId, java.lang.String prefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchYearException;

	/**
	* Removes all the years where prefix = &#63; from the database.
	*
	* @param prefix the prefix
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPrefix(java.lang.String prefix)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of years where prefix = &#63;.
	*
	* @param prefix the prefix
	* @return the number of matching years
	* @throws SystemException if a system exception occurred
	*/
	public int countByPrefix(java.lang.String prefix)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the years where name = &#63;.
	*
	* @param name the name
	* @return the matching years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Year> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the years where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.YearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of years
	* @param end the upper bound of the range of years (not inclusive)
	* @return the range of matching years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Year> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the years where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.YearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of years
	* @param end the upper bound of the range of years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Year> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first year in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching year
	* @throws de.uhh.l2g.plugins.NoSuchYearException if a matching year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchYearException;

	/**
	* Returns the first year in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching year, or <code>null</code> if a matching year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last year in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching year
	* @throws de.uhh.l2g.plugins.NoSuchYearException if a matching year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchYearException;

	/**
	* Returns the last year in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching year, or <code>null</code> if a matching year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the years before and after the current year in the ordered set where name = &#63;.
	*
	* @param yearId the primary key of the current year
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next year
	* @throws de.uhh.l2g.plugins.NoSuchYearException if a year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year[] findByName_PrevAndNext(long yearId,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchYearException;

	/**
	* Removes all the years where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of years where name = &#63;.
	*
	* @param name the name
	* @return the number of matching years
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the year in the entity cache if it is enabled.
	*
	* @param year the year
	*/
	public void cacheResult(de.uhh.l2g.plugins.model.Year year);

	/**
	* Caches the years in the entity cache if it is enabled.
	*
	* @param years the years
	*/
	public void cacheResult(java.util.List<de.uhh.l2g.plugins.model.Year> years);

	/**
	* Creates a new year with the primary key. Does not add the year to the database.
	*
	* @param yearId the primary key for the new year
	* @return the new year
	*/
	public de.uhh.l2g.plugins.model.Year create(long yearId);

	/**
	* Removes the year with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param yearId the primary key of the year
	* @return the year that was removed
	* @throws de.uhh.l2g.plugins.NoSuchYearException if a year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year remove(long yearId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchYearException;

	public de.uhh.l2g.plugins.model.Year updateImpl(
		de.uhh.l2g.plugins.model.Year year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the year with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchYearException} if it could not be found.
	*
	* @param yearId the primary key of the year
	* @return the year
	* @throws de.uhh.l2g.plugins.NoSuchYearException if a year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year findByPrimaryKey(long yearId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchYearException;

	/**
	* Returns the year with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param yearId the primary key of the year
	* @return the year, or <code>null</code> if a year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Year fetchByPrimaryKey(long yearId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the years.
	*
	* @return the years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Year> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the years.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.YearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of years
	* @param end the upper bound of the range of years (not inclusive)
	* @return the range of years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Year> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the years.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.YearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of years
	* @param end the upper bound of the range of years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Year> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the years from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of years.
	*
	* @return the number of years
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}