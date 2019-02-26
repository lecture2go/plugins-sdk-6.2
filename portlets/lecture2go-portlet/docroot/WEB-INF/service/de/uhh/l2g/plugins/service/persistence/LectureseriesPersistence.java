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

import de.uhh.l2g.plugins.model.Lectureseries;

/**
 * The persistence interface for the lectureseries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LectureseriesPersistenceImpl
 * @see LectureseriesUtil
 * @generated
 */
public interface LectureseriesPersistence extends BasePersistence<Lectureseries> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LectureseriesUtil} to access the lectureseries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the lectureserieses where termId = &#63;.
	*
	* @param termId the term ID
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByTerm(
		long termId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureserieses where termId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param termId the term ID
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByTerm(
		long termId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureserieses where termId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param termId the term ID
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByTerm(
		long termId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByTerm_First(
		long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByTerm_First(
		long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByTerm_Last(long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByTerm_Last(
		long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where termId = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries[] findByTerm_PrevAndNext(
		long lectureseriesId, long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where termId = &#63; from the database.
	*
	* @param termId the term ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTerm(long termId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where termId = &#63;.
	*
	* @param termId the term ID
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByTerm(long termId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses where language = &#63;.
	*
	* @param language the language
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLanguage(
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLanguage(
		java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLanguage(
		java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where language = &#63;.
	*
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByLanguage_First(
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where language = &#63;.
	*
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByLanguage_First(
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where language = &#63;.
	*
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByLanguage_Last(
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where language = &#63;.
	*
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByLanguage_Last(
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Lectureseries[] findByLanguage_PrevAndNext(
		long lectureseriesId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where language = &#63; from the database.
	*
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLanguage(java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where language = &#63;.
	*
	* @param language the language
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByLanguage(java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses where number = &#63;.
	*
	* @param number the number
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByNumber(
		java.lang.String number)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByNumber(
		java.lang.String number, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByNumber(
		java.lang.String number, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByNumber_First(
		java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByNumber_First(
		java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByNumber_Last(
		java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByNumber_Last(
		java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Lectureseries[] findByNumber_PrevAndNext(
		long lectureseriesId, java.lang.String number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where number = &#63; from the database.
	*
	* @param number the number
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNumber(java.lang.String number)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where number = &#63;.
	*
	* @param number the number
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByNumber(java.lang.String number)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByType(
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByType(
		java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByType(
		java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Lectureseries[] findByType_PrevAndNext(
		long lectureseriesId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where eventType = &#63; from the database.
	*
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureserieses where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureserieses where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where categoryId = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries[] findByCategory_PrevAndNext(
		long lectureseriesId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses where name = &#63;.
	*
	* @param name the name
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Lectureseries[] findByName_PrevAndNext(
		long lectureseriesId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses where facultyName = &#63;.
	*
	* @param facultyName the faculty name
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByFaculty(
		java.lang.String facultyName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByFaculty(
		java.lang.String facultyName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByFaculty(
		java.lang.String facultyName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where facultyName = &#63;.
	*
	* @param facultyName the faculty name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByFaculty_First(
		java.lang.String facultyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where facultyName = &#63;.
	*
	* @param facultyName the faculty name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByFaculty_First(
		java.lang.String facultyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where facultyName = &#63;.
	*
	* @param facultyName the faculty name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByFaculty_Last(
		java.lang.String facultyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where facultyName = &#63;.
	*
	* @param facultyName the faculty name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByFaculty_Last(
		java.lang.String facultyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Lectureseries[] findByFaculty_PrevAndNext(
		long lectureseriesId, java.lang.String facultyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where facultyName = &#63; from the database.
	*
	* @param facultyName the faculty name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFaculty(java.lang.String facultyName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where facultyName = &#63;.
	*
	* @param facultyName the faculty name
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByFaculty(java.lang.String facultyName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses where approved = &#63;.
	*
	* @param approved the approved
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByApproved(
		int approved)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByApproved(
		int approved, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByApproved(
		int approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByApproved_First(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByApproved_First(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByApproved_Last(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByApproved_Last(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Lectureseries[] findByApproved_PrevAndNext(
		long lectureseriesId, int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where approved = &#63; from the database.
	*
	* @param approved the approved
	* @throws SystemException if a system exception occurred
	*/
	public void removeByApproved(int approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where approved = &#63;.
	*
	* @param approved the approved
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByApproved(int approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses where password = &#63;.
	*
	* @param password the password
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByPassword(
		java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByPassword(
		java.lang.String password, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByPassword(
		java.lang.String password, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByPassword_First(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByPassword_First(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByPassword_Last(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where password = &#63;.
	*
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByPassword_Last(
		java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Lectureseries[] findByPassword_PrevAndNext(
		long lectureseriesId, java.lang.String password,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where password = &#63; from the database.
	*
	* @param password the password
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPassword(java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where password = &#63;.
	*
	* @param password the password
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByPassword(java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses where latestOpenAccessVideoId = &#63;.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByLatestOpenAccessVideo_First(
		long latestOpenAccessVideoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByLatestOpenAccessVideo_First(
		long latestOpenAccessVideoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByLatestOpenAccessVideo_Last(
		long latestOpenAccessVideoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByLatestOpenAccessVideo_Last(
		long latestOpenAccessVideoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Lectureseries[] findByLatestOpenAccessVideo_PrevAndNext(
		long lectureseriesId, long latestOpenAccessVideoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where latestOpenAccessVideoId = &#63; from the database.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLatestOpenAccessVideo(long latestOpenAccessVideoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where latestOpenAccessVideoId = &#63;.
	*
	* @param latestOpenAccessVideoId the latest open access video ID
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByLatestOpenAccessVideo(long latestOpenAccessVideoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses where latestVideoUploadDate = &#63;.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestVideoUploadDate(
		java.util.Date latestVideoUploadDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestVideoUploadDate(
		java.util.Date latestVideoUploadDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestVideoUploadDate(
		java.util.Date latestVideoUploadDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByLatestVideoUploadDate_First(
		java.util.Date latestVideoUploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByLatestVideoUploadDate_First(
		java.util.Date latestVideoUploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByLatestVideoUploadDate_Last(
		java.util.Date latestVideoUploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByLatestVideoUploadDate_Last(
		java.util.Date latestVideoUploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Lectureseries[] findByLatestVideoUploadDate_PrevAndNext(
		long lectureseriesId, java.util.Date latestVideoUploadDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where latestVideoUploadDate = &#63; from the database.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLatestVideoUploadDate(
		java.util.Date latestVideoUploadDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where latestVideoUploadDate = &#63;.
	*
	* @param latestVideoUploadDate the latest video upload date
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByLatestVideoUploadDate(
		java.util.Date latestVideoUploadDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses where latestVideoGenerationDate = &#63;.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestVideoGenerationDate(
		java.lang.String latestVideoGenerationDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestVideoGenerationDate(
		java.lang.String latestVideoGenerationDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByLatestVideoGenerationDate(
		java.lang.String latestVideoGenerationDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByLatestVideoGenerationDate_First(
		java.lang.String latestVideoGenerationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByLatestVideoGenerationDate_First(
		java.lang.String latestVideoGenerationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByLatestVideoGenerationDate_Last(
		java.lang.String latestVideoGenerationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByLatestVideoGenerationDate_Last(
		java.lang.String latestVideoGenerationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Lectureseries[] findByLatestVideoGenerationDate_PrevAndNext(
		long lectureseriesId, java.lang.String latestVideoGenerationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where latestVideoGenerationDate = &#63; from the database.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLatestVideoGenerationDate(
		java.lang.String latestVideoGenerationDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where latestVideoGenerationDate = &#63;.
	*
	* @param latestVideoGenerationDate the latest video generation date
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByLatestVideoGenerationDate(
		java.lang.String latestVideoGenerationDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses where USID = &#63;.
	*
	* @param USID the u s i d
	* @return the matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByUSID(
		java.lang.String USID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureserieses where USID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USID the u s i d
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @return the range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByUSID(
		java.lang.String USID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureserieses where USID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USID the u s i d
	* @param start the lower bound of the range of lectureserieses
	* @param end the upper bound of the range of lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findByUSID(
		java.lang.String USID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries in the ordered set where USID = &#63;.
	*
	* @param USID the u s i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByUSID_First(
		java.lang.String USID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the first lectureseries in the ordered set where USID = &#63;.
	*
	* @param USID the u s i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByUSID_First(
		java.lang.String USID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries in the ordered set where USID = &#63;.
	*
	* @param USID the u s i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByUSID_Last(
		java.lang.String USID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the last lectureseries in the ordered set where USID = &#63;.
	*
	* @param USID the u s i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByUSID_Last(
		java.lang.String USID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureserieses before and after the current lectureseries in the ordered set where USID = &#63;.
	*
	* @param lectureseriesId the primary key of the current lectureseries
	* @param USID the u s i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries[] findByUSID_PrevAndNext(
		long lectureseriesId, java.lang.String USID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Removes all the lectureserieses where USID = &#63; from the database.
	*
	* @param USID the u s i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUSID(java.lang.String USID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses where USID = &#63;.
	*
	* @param USID the u s i d
	* @return the number of matching lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUSID(java.lang.String USID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the lectureseries in the entity cache if it is enabled.
	*
	* @param lectureseries the lectureseries
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries);

	/**
	* Caches the lectureserieses in the entity cache if it is enabled.
	*
	* @param lectureserieses the lectureserieses
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Lectureseries> lectureserieses);

	/**
	* Creates a new lectureseries with the primary key. Does not add the lectureseries to the database.
	*
	* @param lectureseriesId the primary key for the new lectureseries
	* @return the new lectureseries
	*/
	public de.uhh.l2g.plugins.model.Lectureseries create(long lectureseriesId);

	/**
	* Removes the lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesId the primary key of the lectureseries
	* @return the lectureseries that was removed
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries remove(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	public de.uhh.l2g.plugins.model.Lectureseries updateImpl(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLectureseriesException} if it could not be found.
	*
	* @param lectureseriesId the primary key of the lectureseries
	* @return the lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries findByPrimaryKey(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseriesException;

	/**
	* Returns the lectureseries with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lectureseriesId the primary key of the lectureseries
	* @return the lectureseries, or <code>null</code> if a lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries fetchByPrimaryKey(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureserieses.
	*
	* @return the lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lectureserieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureserieses.
	*
	* @return the number of lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}