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

import com.liferay.portal.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.model.Lectureseries_Facility;

/**
 * The persistence interface for the lectureseries_ facility service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_FacilityPersistenceImpl
 * @see Lectureseries_FacilityUtil
 * @generated
 */
public interface Lectureseries_FacilityPersistence extends BasePersistence<Lectureseries_Facility> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Lectureseries_FacilityUtil} to access the lectureseries_ facility persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the lectureseries_ facilities where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> findByLectureseriesId(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ facilities where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ facilities
	* @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	* @return the range of matching lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> findByLectureseriesId(
		long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ facilities where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ facilities
	* @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries_ facility in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ facility
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a matching lectureseries_ facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility findByLectureseriesId_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException;

	/**
	* Returns the first lectureseries_ facility in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ facility, or <code>null</code> if a matching lectureseries_ facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility fetchByLectureseriesId_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries_ facility in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ facility
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a matching lectureseries_ facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility findByLectureseriesId_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException;

	/**
	* Returns the last lectureseries_ facility in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ facility, or <code>null</code> if a matching lectureseries_ facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility fetchByLectureseriesId_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ facilities before and after the current lectureseries_ facility in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesFacilityId the primary key of the current lectureseries_ facility
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ facility
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a lectureseries_ facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility[] findByLectureseriesId_PrevAndNext(
		long lectureseriesFacilityId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException;

	/**
	* Removes all the lectureseries_ facilities where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLectureseriesId(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ facilities where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public int countByLectureseriesId(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureseries_ facilities where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @return the matching lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> findByFacilityId(
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ facilities where facilityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facilityId the facility ID
	* @param start the lower bound of the range of lectureseries_ facilities
	* @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	* @return the range of matching lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> findByFacilityId(
		long facilityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ facilities where facilityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facilityId the facility ID
	* @param start the lower bound of the range of lectureseries_ facilities
	* @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> findByFacilityId(
		long facilityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries_ facility in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ facility
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a matching lectureseries_ facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility findByFacilityId_First(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException;

	/**
	* Returns the first lectureseries_ facility in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ facility, or <code>null</code> if a matching lectureseries_ facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility fetchByFacilityId_First(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries_ facility in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ facility
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a matching lectureseries_ facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility findByFacilityId_Last(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException;

	/**
	* Returns the last lectureseries_ facility in the ordered set where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ facility, or <code>null</code> if a matching lectureseries_ facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility fetchByFacilityId_Last(
		long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ facilities before and after the current lectureseries_ facility in the ordered set where facilityId = &#63;.
	*
	* @param lectureseriesFacilityId the primary key of the current lectureseries_ facility
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ facility
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a lectureseries_ facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility[] findByFacilityId_PrevAndNext(
		long lectureseriesFacilityId, long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException;

	/**
	* Removes all the lectureseries_ facilities where facilityId = &#63; from the database.
	*
	* @param facilityId the facility ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFacilityId(long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ facilities where facilityId = &#63;.
	*
	* @param facilityId the facility ID
	* @return the number of matching lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public int countByFacilityId(long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureseries_ facilities where lectureseriesId = &#63; and facilityId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param facilityId the facility ID
	* @return the matching lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> findByLectureseriesIdAndFacilityId(
		long lectureseriesId, long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ facilities where lectureseriesId = &#63; and facilityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param facilityId the facility ID
	* @param start the lower bound of the range of lectureseries_ facilities
	* @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	* @return the range of matching lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> findByLectureseriesIdAndFacilityId(
		long lectureseriesId, long facilityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ facilities where lectureseriesId = &#63; and facilityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param facilityId the facility ID
	* @param start the lower bound of the range of lectureseries_ facilities
	* @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> findByLectureseriesIdAndFacilityId(
		long lectureseriesId, long facilityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries_ facility in the ordered set where lectureseriesId = &#63; and facilityId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ facility
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a matching lectureseries_ facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility findByLectureseriesIdAndFacilityId_First(
		long lectureseriesId, long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException;

	/**
	* Returns the first lectureseries_ facility in the ordered set where lectureseriesId = &#63; and facilityId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ facility, or <code>null</code> if a matching lectureseries_ facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility fetchByLectureseriesIdAndFacilityId_First(
		long lectureseriesId, long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries_ facility in the ordered set where lectureseriesId = &#63; and facilityId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ facility
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a matching lectureseries_ facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility findByLectureseriesIdAndFacilityId_Last(
		long lectureseriesId, long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException;

	/**
	* Returns the last lectureseries_ facility in the ordered set where lectureseriesId = &#63; and facilityId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ facility, or <code>null</code> if a matching lectureseries_ facility could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility fetchByLectureseriesIdAndFacilityId_Last(
		long lectureseriesId, long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ facilities before and after the current lectureseries_ facility in the ordered set where lectureseriesId = &#63; and facilityId = &#63;.
	*
	* @param lectureseriesFacilityId the primary key of the current lectureseries_ facility
	* @param lectureseriesId the lectureseries ID
	* @param facilityId the facility ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ facility
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a lectureseries_ facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility[] findByLectureseriesIdAndFacilityId_PrevAndNext(
		long lectureseriesFacilityId, long lectureseriesId, long facilityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException;

	/**
	* Removes all the lectureseries_ facilities where lectureseriesId = &#63; and facilityId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @param facilityId the facility ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLectureseriesIdAndFacilityId(long lectureseriesId,
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ facilities where lectureseriesId = &#63; and facilityId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param facilityId the facility ID
	* @return the number of matching lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public int countByLectureseriesIdAndFacilityId(long lectureseriesId,
		long facilityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the lectureseries_ facility in the entity cache if it is enabled.
	*
	* @param lectureseries_Facility the lectureseries_ facility
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.model.Lectureseries_Facility lectureseries_Facility);

	/**
	* Caches the lectureseries_ facilities in the entity cache if it is enabled.
	*
	* @param lectureseries_Facilities the lectureseries_ facilities
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> lectureseries_Facilities);

	/**
	* Creates a new lectureseries_ facility with the primary key. Does not add the lectureseries_ facility to the database.
	*
	* @param lectureseriesFacilityId the primary key for the new lectureseries_ facility
	* @return the new lectureseries_ facility
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility create(
		long lectureseriesFacilityId);

	/**
	* Removes the lectureseries_ facility with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesFacilityId the primary key of the lectureseries_ facility
	* @return the lectureseries_ facility that was removed
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a lectureseries_ facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility remove(
		long lectureseriesFacilityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException;

	public de.uhh.l2g.plugins.model.Lectureseries_Facility updateImpl(
		de.uhh.l2g.plugins.model.Lectureseries_Facility lectureseries_Facility)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ facility with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException} if it could not be found.
	*
	* @param lectureseriesFacilityId the primary key of the lectureseries_ facility
	* @return the lectureseries_ facility
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException if a lectureseries_ facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility findByPrimaryKey(
		long lectureseriesFacilityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException;

	/**
	* Returns the lectureseries_ facility with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lectureseriesFacilityId the primary key of the lectureseries_ facility
	* @return the lectureseries_ facility, or <code>null</code> if a lectureseries_ facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Facility fetchByPrimaryKey(
		long lectureseriesFacilityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureseries_ facilities.
	*
	* @return the lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ facilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ facilities
	* @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	* @return the range of lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ facilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ facilities
	* @param end the upper bound of the range of lectureseries_ facilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Facility> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lectureseries_ facilities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ facilities.
	*
	* @return the number of lectureseries_ facilities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}