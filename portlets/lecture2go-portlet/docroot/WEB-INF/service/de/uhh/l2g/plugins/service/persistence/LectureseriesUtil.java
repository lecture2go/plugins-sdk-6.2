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

import de.uhh.l2g.plugins.model.Lectureseries;

import java.util.List;

/**
 * The persistence utility for the lectureseries service. This utility wraps {@link LectureseriesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LectureseriesPersistence
 * @see LectureseriesPersistenceImpl
 * @generated
 */
public class LectureseriesUtil {
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
	public static void clearCache(Lectureseries lectureseries) {
		getPersistence().clearCache(lectureseries);
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
	public static List<Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Lectureseries update(Lectureseries lectureseries)
		throws SystemException {
		return getPersistence().update(lectureseries);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Lectureseries update(Lectureseries lectureseries,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lectureseries, serviceContext);
	}

	/**
	* Returns all the lectureserieses where yearId = &#63;.
	*
	* @param yearId the year ID
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByYear(
		long yearId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear(yearId);
	}

	/**
	* Returns a range of all the lectureserieses where yearId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param yearId the year ID
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByYear(
		long yearId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear(yearId, start, end);
	}

	/**
	* Returns an ordered range of all the lectureserieses where yearId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param yearId the year ID
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByYear(
		long yearId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear(yearId, start, end, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where yearId = &#63;.
	*
	* @param yearId the year ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByYear_First(
		long yearId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByYear_First(yearId, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where yearId = &#63;.
	*
	* @param yearId the year ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByYear_First(
		long yearId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByYear_First(yearId, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where yearId = &#63;.
	*
	* @param yearId the year ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByYear_Last(
		long yearId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByYear_Last(yearId, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where yearId = &#63;.
	*
	* @param yearId the year ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByYear_Last(
		long yearId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByYear_Last(yearId, orderByComparator);
	}

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where yearId = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param yearId the year ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries[] findByYear_PrevAndNext(
		long lectureseriesId, long yearId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByYear_PrevAndNext(lectureseriesId, yearId,
			orderByComparator);
	}

	/**
	* Removes all the lectureserieses where yearId = &#63; from the database.
	*
	* @param yearId the year ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByYear(long yearId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByYear(yearId);
	}

	/**
	* Returns the number of lectureserieses where yearId = &#63;.
	*
	* @param yearId the year ID
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByYear(long yearId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByYear(yearId);
	}

	/**
	* Returns all the lectureserieses where language = &#63;.
	*
	* @param language the language
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLanguage(
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLanguage(language);
	}

	/**
	* Returns a range of all the lectureserieses where language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param language the language
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLanguage(
		java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLanguage(language, start, end);
	}

	/**
	* Returns an ordered range of all the lectureserieses where language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param language the language
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLanguage(
		java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLanguage(language, start, end, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where language = &#63;.
	*
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByLanguage_First(
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByLanguage_First(language, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where language = &#63;.
	*
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByLanguage_First(
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLanguage_First(language, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where language = &#63;.
	*
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByLanguage_Last(
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByLanguage_Last(language, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where language = &#63;.
	*
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByLanguage_Last(
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLanguage_Last(language, orderByComparator);
	}

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where language = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries[] findByLanguage_PrevAndNext(
		long lectureseriesId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByLanguage_PrevAndNext(lectureseriesId, language,
			orderByComparator);
	}

	/**
	* Removes all the lectureserieses where language = &#63; from the database.
	*
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLanguage(java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLanguage(language);
	}

	/**
	* Returns the number of lectureserieses where language = &#63;.
	*
	* @param language the language
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLanguage(java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLanguage(language);
	}

	/**
	* Returns all the lectureserieses where number = &#63;.
	*
	* @param number the number
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByNumber(
		java.lang.String number)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNumber(number);
	}

	/**
	* Returns a range of all the lectureserieses where number = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param number the number
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByNumber(
		java.lang.String number, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNumber(number, start, end);
	}

	/**
	* Returns an ordered range of all the lectureserieses where number = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param number the number
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByNumber(
		java.lang.String number, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNumber(number, start, end, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByNumber_First(
		java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByNumber_First(number, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByNumber_First(
		java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNumber_First(number, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByNumber_Last(
		java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByNumber_Last(number, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByNumber_Last(
		java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNumber_Last(number, orderByComparator);
	}

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where number = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries[] findByNumber_PrevAndNext(
		long lectureseriesId, java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByNumber_PrevAndNext(lectureseriesId, number,
			orderByComparator);
	}

	/**
	* Removes all the lectureserieses where number = &#63; from the database.
	*
	* @param number the number
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNumber(java.lang.String number)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNumber(number);
	}

	/**
	* Returns the number of lectureserieses where number = &#63;.
	*
	* @param number the number
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNumber(java.lang.String number)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNumber(number);
	}

	/**
	* Returns all the lectureserieses where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByType(
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(eventType);
	}

	/**
	* Returns a range of all the lectureserieses where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByType(
		java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(eventType, start, end);
	}

	/**
	* Returns an ordered range of all the lectureserieses where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByType(
		java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType(eventType, start, end, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByType_First(eventType, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_First(eventType, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByType_Last(eventType, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_Last(eventType, orderByComparator);
	}

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where eventType = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries[] findByType_PrevAndNext(
		long lectureseriesId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByType_PrevAndNext(lectureseriesId, eventType,
			orderByComparator);
	}

	/**
	* Removes all the lectureserieses where eventType = &#63; from the database.
	*
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(eventType);
	}

	/**
	* Returns the number of lectureserieses where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(eventType);
	}

	/**
	* Returns all the lectureserieses where eventCategory = &#63;.
	*
	* @param eventCategory the event category
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByCategory(
		java.lang.String eventCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(eventCategory);
	}

	/**
	* Returns a range of all the lectureserieses where eventCategory = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventCategory the event category
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByCategory(
		java.lang.String eventCategory, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(eventCategory, start, end);
	}

	/**
	* Returns an ordered range of all the lectureserieses where eventCategory = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventCategory the event category
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByCategory(
		java.lang.String eventCategory, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory(eventCategory, start, end, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where eventCategory = &#63;.
	*
	* @param eventCategory the event category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByCategory_First(
		java.lang.String eventCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByCategory_First(eventCategory, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where eventCategory = &#63;.
	*
	* @param eventCategory the event category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByCategory_First(
		java.lang.String eventCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_First(eventCategory, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where eventCategory = &#63;.
	*
	* @param eventCategory the event category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByCategory_Last(
		java.lang.String eventCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByCategory_Last(eventCategory, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where eventCategory = &#63;.
	*
	* @param eventCategory the event category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByCategory_Last(
		java.lang.String eventCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_Last(eventCategory, orderByComparator);
	}

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where eventCategory = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param eventCategory the event category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries[] findByCategory_PrevAndNext(
		long lectureseriesId, java.lang.String eventCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByCategory_PrevAndNext(lectureseriesId, eventCategory,
			orderByComparator);
	}

	/**
	* Removes all the lectureserieses where eventCategory = &#63; from the database.
	*
	* @param eventCategory the event category
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategory(java.lang.String eventCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategory(eventCategory);
	}

	/**
	* Returns the number of lectureserieses where eventCategory = &#63;.
	*
	* @param eventCategory the event category
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(java.lang.String eventCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(eventCategory);
	}

	/**
	* Returns all the lectureserieses where name = &#63;.
	*
	* @param name the name
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the lectureserieses where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the lectureserieses where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where name = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries[] findByName_PrevAndNext(
		long lectureseriesId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByName_PrevAndNext(lectureseriesId, name,
			orderByComparator);
	}

	/**
	* Removes all the lectureserieses where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of lectureserieses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the lectureserieses where facultyName = &#63;.
	*
	* @param facultyName the faculty name
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByFaculty(
		java.lang.String facultyName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFaculty(facultyName);
	}

	/**
	* Returns a range of all the lectureserieses where facultyName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facultyName the faculty name
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByFaculty(
		java.lang.String facultyName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFaculty(facultyName, start, end);
	}

	/**
	* Returns an ordered range of all the lectureserieses where facultyName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facultyName the faculty name
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByFaculty(
		java.lang.String facultyName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFaculty(facultyName, start, end, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where facultyName = &#63;.
	*
	* @param facultyName the faculty name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByFaculty_First(
		java.lang.String facultyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByFaculty_First(facultyName, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where facultyName = &#63;.
	*
	* @param facultyName the faculty name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByFaculty_First(
		java.lang.String facultyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFaculty_First(facultyName, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where facultyName = &#63;.
	*
	* @param facultyName the faculty name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByFaculty_Last(
		java.lang.String facultyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByFaculty_Last(facultyName, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where facultyName = &#63;.
	*
	* @param facultyName the faculty name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByFaculty_Last(
		java.lang.String facultyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFaculty_Last(facultyName, orderByComparator);
	}

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where facultyName = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param facultyName the faculty name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries[] findByFaculty_PrevAndNext(
		long lectureseriesId, java.lang.String facultyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByFaculty_PrevAndNext(lectureseriesId, facultyName,
			orderByComparator);
	}

	/**
	* Removes all the lectureserieses where facultyName = &#63; from the database.
	*
	* @param facultyName the faculty name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFaculty(java.lang.String facultyName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFaculty(facultyName);
	}

	/**
	* Returns the number of lectureserieses where facultyName = &#63;.
	*
	* @param facultyName the faculty name
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFaculty(java.lang.String facultyName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFaculty(facultyName);
	}

	/**
	* Returns all the lectureserieses where approved = &#63;.
	*
	* @param approved the approved
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByApproved(
		int approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApproved(approved);
	}

	/**
	* Returns a range of all the lectureserieses where approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param approved the approved
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByApproved(
		int approved, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApproved(approved, start, end);
	}

	/**
	* Returns an ordered range of all the lectureserieses where approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param approved the approved
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByApproved(
		int approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApproved(approved, start, end, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByApproved_First(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByApproved_First(approved, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByApproved_First(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApproved_First(approved, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByApproved_Last(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByApproved_Last(approved, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByApproved_Last(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByApproved_Last(approved, orderByComparator);
	}

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where approved = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries[] findByApproved_PrevAndNext(
		long lectureseriesId, int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByApproved_PrevAndNext(lectureseriesId, approved,
			orderByComparator);
	}

	/**
	* Removes all the lectureserieses where approved = &#63; from the database.
	*
	* @param approved the approved
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByApproved(int approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByApproved(approved);
	}

	/**
	* Returns the number of lectureserieses where approved = &#63;.
	*
	* @param approved the approved
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByApproved(int approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByApproved(approved);
	}

	/**
	* Returns all the lectureserieses where password = &#63;.
	*
	* @param password the password
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByPassword(
		java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPassword(password);
	}

	/**
	* Returns a range of all the lectureserieses where password = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param password the password
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByPassword(
		java.lang.String password, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPassword(password, start, end);
	}

	/**
	* Returns an ordered range of all the lectureserieses where password = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param password the password
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByPassword(
		java.lang.String password, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPassword(password, start, end, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByPassword_First(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByPassword_First(password, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByPassword_First(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPassword_First(password, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByPassword_Last(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByPassword_Last(password, orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByPassword_Last(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPassword_Last(password, orderByComparator);
	}

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where password = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries[] findByPassword_PrevAndNext(
		long lectureseriesId, java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByPassword_PrevAndNext(lectureseriesId, password,
			orderByComparator);
	}

	/**
	* Removes all the lectureserieses where password = &#63; from the database.
	*
	* @param password the password
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPassword(java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPassword(password);
	}

	/**
	* Returns the number of lectureserieses where password = &#63;.
	*
	* @param password the password
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPassword(java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPassword(password);
	}

	/**
	* Returns all the lectureserieses where latestOpenAccessVideoId = &#63;.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLatestOpenAccessVideo(latestOpenAccessVideoId);
	}

	/**
	* Returns a range of all the lectureserieses where latestOpenAccessVideoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLatestOpenAccessVideo(latestOpenAccessVideoId, start,
			end);
	}

	/**
	* Returns an ordered range of all the lectureserieses where latestOpenAccessVideoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLatestOpenAccessVideo(latestOpenAccessVideoId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByLatestOpenAccessVideo_First(
		long latestOpenAccessVideoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByLatestOpenAccessVideo_First(latestOpenAccessVideoId,
			orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByLatestOpenAccessVideo_First(
		long latestOpenAccessVideoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLatestOpenAccessVideo_First(latestOpenAccessVideoId,
			orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByLatestOpenAccessVideo_Last(
		long latestOpenAccessVideoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByLatestOpenAccessVideo_Last(latestOpenAccessVideoId,
			orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByLatestOpenAccessVideo_Last(
		long latestOpenAccessVideoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLatestOpenAccessVideo_Last(latestOpenAccessVideoId,
			orderByComparator);
	}

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param latestOpenAccessVideoId the latest open access video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries[] findByLatestOpenAccessVideo_PrevAndNext(
		long lectureseriesId, long latestOpenAccessVideoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByLatestOpenAccessVideo_PrevAndNext(lectureseriesId,
			latestOpenAccessVideoId, orderByComparator);
	}

	/**
	* Removes all the lectureserieses where latestOpenAccessVideoId = &#63; from the database.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLatestOpenAccessVideo(
		long latestOpenAccessVideoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLatestOpenAccessVideo(latestOpenAccessVideoId);
	}

	/**
	* Returns the number of lectureserieses where latestOpenAccessVideoId = &#63;.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLatestOpenAccessVideo(long latestOpenAccessVideoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLatestOpenAccessVideo(latestOpenAccessVideoId);
	}

	/**
	* Returns all the lectureserieses where latestVideoUploadDate = &#63;.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestVideoUploadDate(
		java.util.Date latestVideoUploadDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLatestVideoUploadDate(latestVideoUploadDate);
	}

	/**
	* Returns a range of all the lectureserieses where latestVideoUploadDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param latestVideoUploadDate the latest video upload date
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestVideoUploadDate(
		java.util.Date latestVideoUploadDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLatestVideoUploadDate(latestVideoUploadDate, start,
			end);
	}

	/**
	* Returns an ordered range of all the lectureserieses where latestVideoUploadDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param latestVideoUploadDate the latest video upload date
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestVideoUploadDate(
		java.util.Date latestVideoUploadDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLatestVideoUploadDate(latestVideoUploadDate, start,
			end, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByLatestVideoUploadDate_First(
		java.util.Date latestVideoUploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByLatestVideoUploadDate_First(latestVideoUploadDate,
			orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByLatestVideoUploadDate_First(
		java.util.Date latestVideoUploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLatestVideoUploadDate_First(latestVideoUploadDate,
			orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByLatestVideoUploadDate_Last(
		java.util.Date latestVideoUploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByLatestVideoUploadDate_Last(latestVideoUploadDate,
			orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByLatestVideoUploadDate_Last(
		java.util.Date latestVideoUploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLatestVideoUploadDate_Last(latestVideoUploadDate,
			orderByComparator);
	}

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param latestVideoUploadDate the latest video upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries[] findByLatestVideoUploadDate_PrevAndNext(
		long lectureseriesId, java.util.Date latestVideoUploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByLatestVideoUploadDate_PrevAndNext(lectureseriesId,
			latestVideoUploadDate, orderByComparator);
	}

	/**
	* Removes all the lectureserieses where latestVideoUploadDate = &#63; from the database.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLatestVideoUploadDate(
		java.util.Date latestVideoUploadDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLatestVideoUploadDate(latestVideoUploadDate);
	}

	/**
	* Returns the number of lectureserieses where latestVideoUploadDate = &#63;.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLatestVideoUploadDate(
		java.util.Date latestVideoUploadDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLatestVideoUploadDate(latestVideoUploadDate);
	}

	/**
	* Returns all the lectureserieses where latestVideoGenerationDate = &#63;.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestVideoGenerationDate(
		java.lang.String latestVideoGenerationDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLatestVideoGenerationDate(latestVideoGenerationDate);
	}

	/**
	* Returns a range of all the lectureserieses where latestVideoGenerationDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestVideoGenerationDate(
		java.lang.String latestVideoGenerationDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLatestVideoGenerationDate(latestVideoGenerationDate,
			start, end);
	}

	/**
	* Returns an ordered range of all the lectureserieses where latestVideoGenerationDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestVideoGenerationDate(
		java.lang.String latestVideoGenerationDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLatestVideoGenerationDate(latestVideoGenerationDate,
			start, end, orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByLatestVideoGenerationDate_First(
		java.lang.String latestVideoGenerationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByLatestVideoGenerationDate_First(latestVideoGenerationDate,
			orderByComparator);
	}

	/**
	* Returns the first lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByLatestVideoGenerationDate_First(
		java.lang.String latestVideoGenerationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLatestVideoGenerationDate_First(latestVideoGenerationDate,
			orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByLatestVideoGenerationDate_Last(
		java.lang.String latestVideoGenerationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByLatestVideoGenerationDate_Last(latestVideoGenerationDate,
			orderByComparator);
	}

	/**
	* Returns the last lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByLatestVideoGenerationDate_Last(
		java.lang.String latestVideoGenerationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLatestVideoGenerationDate_Last(latestVideoGenerationDate,
			orderByComparator);
	}

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param latestVideoGenerationDate the latest video generation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries[] findByLatestVideoGenerationDate_PrevAndNext(
		long lectureseriesId, java.lang.String latestVideoGenerationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence()
				   .findByLatestVideoGenerationDate_PrevAndNext(lectureseriesId,
			latestVideoGenerationDate, orderByComparator);
	}

	/**
	* Removes all the lectureserieses where latestVideoGenerationDate = &#63; from the database.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLatestVideoGenerationDate(
		java.lang.String latestVideoGenerationDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByLatestVideoGenerationDate(latestVideoGenerationDate);
	}

	/**
	* Returns the number of lectureserieses where latestVideoGenerationDate = &#63;.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLatestVideoGenerationDate(
		java.lang.String latestVideoGenerationDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLatestVideoGenerationDate(latestVideoGenerationDate);
	}

	/**
	* Caches the lectureseries in the entity cache if it is enabled.
	*
	* @param lectureseries the lectureseries
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries) {
		getPersistence().cacheResult(lectureseries);
	}

	/**
	* Caches the lectureserieses in the entity cache if it is enabled.
	*
	* @param lectureserieses the lectureserieses
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Lectureseries> lectureserieses) {
		getPersistence().cacheResult(lectureserieses);
	}

	/**
	* Creates a new lectureseries with the primary key. Does not add the lectureseries to the database.
	*
	* @param lectureseriesId the primary key for the new lectureseries
	* @return the new lectureseries
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries create(
		long lectureseriesId) {
		return getPersistence().create(lectureseriesId);
	}

	/**
	* Removes the lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesId the primary key of the lectureseries
	* @return the lectureseries that was removed
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries remove(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().remove(lectureseriesId);
	}

	public static de.uhh.l2g.plugins.model.Lectureseries updateImpl(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lectureseries);
	}

	/**
	* Returns the lectureseries with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLectureseriesException} if it could not be found.
	*
	* @param lectureseriesId the primary key of the lectureseries
	* @return the lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries findByPrimaryKey(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException {
		return getPersistence().findByPrimaryKey(lectureseriesId);
	}

	/**
	* Returns the lectureseries with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lectureseriesId the primary key of the lectureseries
	* @return the lectureseries, or <code>null</code> if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries fetchByPrimaryKey(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(lectureseriesId);
	}

	/**
	* Returns all the lectureserieses.
	*
	* @return the lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lectureserieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lectureserieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the lectureserieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lectureserieses.
	*
	* @return the number of lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LectureseriesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LectureseriesPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					LectureseriesPersistence.class.getName());

			ReferenceRegistry.registerReference(LectureseriesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LectureseriesPersistence persistence) {
	}

	private static LectureseriesPersistence _persistence;
}