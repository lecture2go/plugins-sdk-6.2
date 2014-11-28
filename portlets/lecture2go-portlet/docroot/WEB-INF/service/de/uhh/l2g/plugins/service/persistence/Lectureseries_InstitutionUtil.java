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

import de.uhh.l2g.plugins.model.Lectureseries_Institution;

import java.util.List;

/**
 * The persistence utility for the lectureseries_ institution service. This utility wraps {@link Lectureseries_InstitutionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_InstitutionPersistence
 * @see Lectureseries_InstitutionPersistenceImpl
 * @generated
 */
public class Lectureseries_InstitutionUtil {
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
	public static void clearCache(
		Lectureseries_Institution lectureseries_Institution) {
		getPersistence().clearCache(lectureseries_Institution);
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
	public static List<Lectureseries_Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lectureseries_Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lectureseries_Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Lectureseries_Institution update(
		Lectureseries_Institution lectureseries_Institution)
		throws SystemException {
		return getPersistence().update(lectureseries_Institution);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Lectureseries_Institution update(
		Lectureseries_Institution lectureseries_Institution,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lectureseries_Institution, serviceContext);
	}

	/**
	* Returns all the lectureseries_ institutions where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByLectureseriesId(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLectureseriesId(lectureseriesId);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByLectureseriesId(
		long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesId(lectureseriesId, start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesId(lectureseriesId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution findByLectureseriesId_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException {
		return getPersistence()
				   .findByLectureseriesId_First(lectureseriesId,
			orderByComparator);
	}

	/**
	* Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByLectureseriesId_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseriesId_First(lectureseriesId,
			orderByComparator);
	}

	/**
	* Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution findByLectureseriesId_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException {
		return getPersistence()
				   .findByLectureseriesId_Last(lectureseriesId,
			orderByComparator);
	}

	/**
	* Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByLectureseriesId_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseriesId_Last(lectureseriesId,
			orderByComparator);
	}

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
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution[] findByLectureseriesId_PrevAndNext(
		long lectureseriesInstitutionId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException {
		return getPersistence()
				   .findByLectureseriesId_PrevAndNext(lectureseriesInstitutionId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ institutions where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLectureseriesId(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLectureseriesId(lectureseriesId);
	}

	/**
	* Returns the number of lectureseries_ institutions where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLectureseriesId(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLectureseriesId(lectureseriesId);
	}

	/**
	* Returns all the lectureseries_ institutions where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByInstitutionId(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByInstitutionId(institutionId);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByInstitutionId(
		long institutionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByInstitutionId(institutionId, start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByInstitutionId(
		long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByInstitutionId(institutionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first lectureseries_ institution in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution findByInstitutionId_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException {
		return getPersistence()
				   .findByInstitutionId_First(institutionId, orderByComparator);
	}

	/**
	* Returns the first lectureseries_ institution in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByInstitutionId_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByInstitutionId_First(institutionId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ institution in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution findByInstitutionId_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException {
		return getPersistence()
				   .findByInstitutionId_Last(institutionId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ institution in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByInstitutionId_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByInstitutionId_Last(institutionId, orderByComparator);
	}

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
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution[] findByInstitutionId_PrevAndNext(
		long lectureseriesInstitutionId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException {
		return getPersistence()
				   .findByInstitutionId_PrevAndNext(lectureseriesInstitutionId,
			institutionId, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ institutions where institutionId = &#63; from the database.
	*
	* @param institutionId the institution ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByInstitutionId(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByInstitutionId(institutionId);
	}

	/**
	* Returns the number of lectureseries_ institutions where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the number of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByInstitutionId(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByInstitutionId(institutionId);
	}

	/**
	* Returns all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @return the matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesIdAndInstitutionId(lectureseriesId,
			institutionId);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesIdAndInstitutionId(lectureseriesId,
			institutionId, start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesIdAndInstitutionId(lectureseriesId,
			institutionId, start, end, orderByComparator);
	}

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
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution findByLectureseriesIdAndInstitutionId_First(
		long lectureseriesId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException {
		return getPersistence()
				   .findByLectureseriesIdAndInstitutionId_First(lectureseriesId,
			institutionId, orderByComparator);
	}

	/**
	* Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByLectureseriesIdAndInstitutionId_First(
		long lectureseriesId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseriesIdAndInstitutionId_First(lectureseriesId,
			institutionId, orderByComparator);
	}

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
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution findByLectureseriesIdAndInstitutionId_Last(
		long lectureseriesId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException {
		return getPersistence()
				   .findByLectureseriesIdAndInstitutionId_Last(lectureseriesId,
			institutionId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByLectureseriesIdAndInstitutionId_Last(
		long lectureseriesId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseriesIdAndInstitutionId_Last(lectureseriesId,
			institutionId, orderByComparator);
	}

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
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution[] findByLectureseriesIdAndInstitutionId_PrevAndNext(
		long lectureseriesInstitutionId, long lectureseriesId,
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException {
		return getPersistence()
				   .findByLectureseriesIdAndInstitutionId_PrevAndNext(lectureseriesInstitutionId,
			lectureseriesId, institutionId, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByLectureseriesIdAndInstitutionId(lectureseriesId,
			institutionId);
	}

	/**
	* Returns the number of lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param institutionId the institution ID
	* @return the number of matching lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLectureseriesIdAndInstitutionId(lectureseriesId,
			institutionId);
	}

	/**
	* Caches the lectureseries_ institution in the entity cache if it is enabled.
	*
	* @param lectureseries_Institution the lectureseries_ institution
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Lectureseries_Institution lectureseries_Institution) {
		getPersistence().cacheResult(lectureseries_Institution);
	}

	/**
	* Caches the lectureseries_ institutions in the entity cache if it is enabled.
	*
	* @param lectureseries_Institutions the lectureseries_ institutions
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> lectureseries_Institutions) {
		getPersistence().cacheResult(lectureseries_Institutions);
	}

	/**
	* Creates a new lectureseries_ institution with the primary key. Does not add the lectureseries_ institution to the database.
	*
	* @param lectureseriesInstitutionId the primary key for the new lectureseries_ institution
	* @return the new lectureseries_ institution
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution create(
		long lectureseriesInstitutionId) {
		return getPersistence().create(lectureseriesInstitutionId);
	}

	/**
	* Removes the lectureseries_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	* @return the lectureseries_ institution that was removed
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution remove(
		long lectureseriesInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException {
		return getPersistence().remove(lectureseriesInstitutionId);
	}

	public static de.uhh.l2g.plugins.model.Lectureseries_Institution updateImpl(
		de.uhh.l2g.plugins.model.Lectureseries_Institution lectureseries_Institution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lectureseries_Institution);
	}

	/**
	* Returns the lectureseries_ institution with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException} if it could not be found.
	*
	* @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	* @return the lectureseries_ institution
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution findByPrimaryKey(
		long lectureseriesInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_InstitutionException {
		return getPersistence().findByPrimaryKey(lectureseriesInstitutionId);
	}

	/**
	* Returns the lectureseries_ institution with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	* @return the lectureseries_ institution, or <code>null</code> if a lectureseries_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution fetchByPrimaryKey(
		long lectureseriesInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(lectureseriesInstitutionId);
	}

	/**
	* Returns all the lectureseries_ institutions.
	*
	* @return the lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ institutions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lectureseries_ institutions.
	*
	* @return the number of lectureseries_ institutions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Lectureseries_InstitutionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Lectureseries_InstitutionPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					Lectureseries_InstitutionPersistence.class.getName());

			ReferenceRegistry.registerReference(Lectureseries_InstitutionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Lectureseries_InstitutionPersistence persistence) {
	}

	private static Lectureseries_InstitutionPersistence _persistence;
}