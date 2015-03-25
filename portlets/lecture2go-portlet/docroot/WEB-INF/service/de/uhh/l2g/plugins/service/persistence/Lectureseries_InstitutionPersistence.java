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

import de.uhh.l2g.plugins.model.Lectureseries_Institution;

/**
 * The persistence interface for the lectureseries_ institution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_InstitutionPersistenceImpl
 * @see Lectureseries_InstitutionUtil
 * @generated
 */
public interface Lectureseries_InstitutionPersistence extends BasePersistence<Lectureseries_Institution> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Lectureseries_InstitutionUtil} to access the lectureseries_ institution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the lectureseries_ institutions where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByLectureseriesId(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ institutions where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ institutions
	* @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	* @return the range of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByLectureseriesId(
		long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ institutions where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ institutions
	* @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution findByLectureseriesId_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByLectureseriesId_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution findByLectureseriesId_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByLectureseriesId_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ institutions before and after the current lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesInstitutionId the primary key of the current lectureseries_ institution
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution[] findByLectureseriesId_PrevAndNext(
		long lectureseriesInstitutionId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Removes all the lectureseries_ institutions where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLectureseriesId(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ institutions where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public int countByLectureseriesId(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureseries_ institutions where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByInstitutionId(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ institutions where institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionId the institution ID
	* @param start the lower bound of the range of lectureseries_ institutions
	* @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	* @return the range of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByInstitutionId(
		long institutionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ institutions where institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionId the institution ID
	* @param start the lower bound of the range of lectureseries_ institutions
	* @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByInstitutionId(
		long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries_ institution in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution findByInstitutionId_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Returns the first lectureseries_ institution in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByInstitutionId_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries_ institution in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution findByInstitutionId_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Returns the last lectureseries_ institution in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByInstitutionId_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ institutions before and after the current lectureseries_ institution in the ordered set where institutionId = &#63;.
	*
	* @param lectureseriesInstitutionId the primary key of the current lectureseries_ institution
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution[] findByInstitutionId_PrevAndNext(
		long lectureseriesInstitutionId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Removes all the lectureseries_ institutions where institutionId = &#63; from the database.
	*
	* @param institutionId the institution ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByInstitutionId(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ institutions where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the number of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public int countByInstitutionId(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @return the matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @param start the lower bound of the range of lectureseries_ institutions
	* @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	* @return the range of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @param start the lower bound of the range of lectureseries_ institutions
	* @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution findByLectureseriesIdAndInstitutionId_First(
		long lectureseriesId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByLectureseriesIdAndInstitutionId_First(
		long lectureseriesId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution findByLectureseriesIdAndInstitutionId_Last(
		long lectureseriesId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByLectureseriesIdAndInstitutionId_Last(
		long lectureseriesId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ institutions before and after the current lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* @param lectureseriesInstitutionId the primary key of the current lectureseries_ institution
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution[] findByLectureseriesIdAndInstitutionId_PrevAndNext(
		long lectureseriesInstitutionId, long lectureseriesId,
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Removes all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLectureseriesIdAndInstitutionId(long lectureseriesId,
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @return the number of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public int countByLectureseriesIdAndInstitutionId(long lectureseriesId,
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureseries_ institutions where institutionParentId = &#63;.
	*
	* @param institutionParentId the institution parent ID
	* @return the matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByInstitutionParentId(
		long institutionParentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ institutions where institutionParentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionParentId the institution parent ID
	* @param start the lower bound of the range of lectureseries_ institutions
	* @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	* @return the range of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ institutions where institutionParentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionParentId the institution parent ID
	* @param start the lower bound of the range of lectureseries_ institutions
	* @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	*
	* @param institutionParentId the institution parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution findByInstitutionParentId_First(
		long institutionParentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Returns the first lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	*
	* @param institutionParentId the institution parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByInstitutionParentId_First(
		long institutionParentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	*
	* @param institutionParentId the institution parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution findByInstitutionParentId_Last(
		long institutionParentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Returns the last lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	*
	* @param institutionParentId the institution parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByInstitutionParentId_Last(
		long institutionParentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ institutions before and after the current lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	*
	* @param lectureseriesInstitutionId the primary key of the current lectureseries_ institution
	* @param institutionParentId the institution parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution[] findByInstitutionParentId_PrevAndNext(
		long lectureseriesInstitutionId, long institutionParentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Removes all the lectureseries_ institutions where institutionParentId = &#63; from the database.
	*
	* @param institutionParentId the institution parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByInstitutionParentId(long institutionParentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ institutions where institutionParentId = &#63;.
	*
	* @param institutionParentId the institution parent ID
	* @return the number of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public int countByInstitutionParentId(long institutionParentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the lectureseries_ institution in the entity cache if it is enabled.
	*
	* @param lectureseries_Institution the lectureseries_ institution
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.model.Lectureseries_Institution lectureseries_Institution);

	/**
	* Caches the lectureseries_ institutions in the entity cache if it is enabled.
	*
	* @param lectureseries_Institutions the lectureseries_ institutions
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> lectureseries_Institutions);

	/**
	* Creates a new lectureseries_ institution with the primary key. Does not add the lectureseries_ institution to the database.
	*
	* @param lectureseriesInstitutionId the primary key for the new lectureseries_ institution
	* @return the new lectureseries_ institution
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution create(
		long lectureseriesInstitutionId);

	/**
	* Removes the lectureseries_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	* @return the lectureseries_ institution that was removed
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution remove(
		long lectureseriesInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	public de.uhh.l2g.plugins.model.Lectureseries_Institution updateImpl(
		de.uhh.l2g.plugins.model.Lectureseries_Institution lectureseries_Institution)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lectureseries_ institution with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException} if it could not be found.
	*
	* @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	* @return the lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution findByPrimaryKey(
		long lectureseriesInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException;

	/**
	* Returns the lectureseries_ institution with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	* @return the lectureseries_ institution, or <code>null</code> if a lectureseries_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByPrimaryKey(
		long lectureseriesInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lectureseries_ institutions.
	*
	* @return the lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lectureseries_ institutions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ institutions
	* @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	* @return the range of lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lectureseries_ institutions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ institutions
	* @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lectureseries_ institutions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lectureseries_ institutions.
	*
	* @return the number of lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}