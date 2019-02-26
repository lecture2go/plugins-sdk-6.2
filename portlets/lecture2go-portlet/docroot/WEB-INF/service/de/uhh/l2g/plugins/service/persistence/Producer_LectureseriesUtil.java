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

import de.uhh.l2g.plugins.model.Producer_Lectureseries;

import java.util.List;

/**
 * The persistence utility for the producer_ lectureseries service. This utility wraps {@link Producer_LectureseriesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Producer_LectureseriesPersistence
 * @see Producer_LectureseriesPersistenceImpl
 * @generated
 */
public class Producer_LectureseriesUtil {
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
	public static void clearCache(Producer_Lectureseries producer_Lectureseries) {
		getPersistence().clearCache(producer_Lectureseries);
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
	public static List<Producer_Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Producer_Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Producer_Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Producer_Lectureseries update(
		Producer_Lectureseries producer_Lectureseries)
		throws SystemException {
		return getPersistence().update(producer_Lectureseries);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Producer_Lectureseries update(
		Producer_Lectureseries producer_Lectureseries,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(producer_Lectureseries, serviceContext);
	}

	/**
	* Returns all the producer_ lectureserieses where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLectureseriesId(lectureseriesId);
	}

	/**
	* Returns a range of all the producer_ lectureserieses where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of producer_ lectureserieses
	* @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	* @return the range of matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesId(lectureseriesId, start, end);
	}

	/**
	* Returns an ordered range of all the producer_ lectureserieses where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of producer_ lectureserieses
	* @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesId(lectureseriesId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries findByLectureseriesId_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException {
		return getPersistence()
				   .findByLectureseriesId_First(lectureseriesId,
			orderByComparator);
	}

	/**
	* Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries fetchByLectureseriesId_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseriesId_First(lectureseriesId,
			orderByComparator);
	}

	/**
	* Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries findByLectureseriesId_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException {
		return getPersistence()
				   .findByLectureseriesId_Last(lectureseriesId,
			orderByComparator);
	}

	/**
	* Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries fetchByLectureseriesId_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseriesId_Last(lectureseriesId,
			orderByComparator);
	}

	/**
	* Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param producerLectureseriesId the primary key of the current producer_ lectureseries
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries[] findByLectureseriesId_PrevAndNext(
		long producerLectureseriesId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException {
		return getPersistence()
				   .findByLectureseriesId_PrevAndNext(producerLectureseriesId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Removes all the producer_ lectureserieses where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLectureseriesId(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLectureseriesId(lectureseriesId);
	}

	/**
	* Returns the number of producer_ lectureserieses where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLectureseriesId(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLectureseriesId(lectureseriesId);
	}

	/**
	* Returns all the producer_ lectureserieses where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @return the matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByProducerId(
		long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProducerId(producerId);
	}

	/**
	* Returns a range of all the producer_ lectureserieses where producerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param start the lower bound of the range of producer_ lectureserieses
	* @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	* @return the range of matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByProducerId(
		long producerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProducerId(producerId, start, end);
	}

	/**
	* Returns an ordered range of all the producer_ lectureserieses where producerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param producerId the producer ID
	* @param start the lower bound of the range of producer_ lectureserieses
	* @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByProducerId(
		long producerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProducerId(producerId, start, end, orderByComparator);
	}

	/**
	* Returns the first producer_ lectureseries in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries findByProducerId_First(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException {
		return getPersistence()
				   .findByProducerId_First(producerId, orderByComparator);
	}

	/**
	* Returns the first producer_ lectureseries in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries fetchByProducerId_First(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProducerId_First(producerId, orderByComparator);
	}

	/**
	* Returns the last producer_ lectureseries in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries findByProducerId_Last(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException {
		return getPersistence()
				   .findByProducerId_Last(producerId, orderByComparator);
	}

	/**
	* Returns the last producer_ lectureseries in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries fetchByProducerId_Last(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProducerId_Last(producerId, orderByComparator);
	}

	/**
	* Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where producerId = &#63;.
	*
	* @param producerLectureseriesId the primary key of the current producer_ lectureseries
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries[] findByProducerId_PrevAndNext(
		long producerLectureseriesId, long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException {
		return getPersistence()
				   .findByProducerId_PrevAndNext(producerLectureseriesId,
			producerId, orderByComparator);
	}

	/**
	* Removes all the producer_ lectureserieses where producerId = &#63; from the database.
	*
	* @param producerId the producer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProducerId(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProducerId(producerId);
	}

	/**
	* Returns the number of producer_ lectureserieses where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @return the number of matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProducerId(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProducerId(producerId);
	}

	/**
	* Returns all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param producerId the producer ID
	* @return the matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesIdAndProducerId(lectureseriesId,
			producerId);
	}

	/**
	* Returns a range of all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param producerId the producer ID
	* @param start the lower bound of the range of producer_ lectureserieses
	* @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	* @return the range of matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesIdAndProducerId(lectureseriesId,
			producerId, start, end);
	}

	/**
	* Returns an ordered range of all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param producerId the producer ID
	* @param start the lower bound of the range of producer_ lectureserieses
	* @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseriesIdAndProducerId(lectureseriesId,
			producerId, start, end, orderByComparator);
	}

	/**
	* Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries findByLectureseriesIdAndProducerId_First(
		long lectureseriesId, long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException {
		return getPersistence()
				   .findByLectureseriesIdAndProducerId_First(lectureseriesId,
			producerId, orderByComparator);
	}

	/**
	* Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries fetchByLectureseriesIdAndProducerId_First(
		long lectureseriesId, long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseriesIdAndProducerId_First(lectureseriesId,
			producerId, orderByComparator);
	}

	/**
	* Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries findByLectureseriesIdAndProducerId_Last(
		long lectureseriesId, long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException {
		return getPersistence()
				   .findByLectureseriesIdAndProducerId_Last(lectureseriesId,
			producerId, orderByComparator);
	}

	/**
	* Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries fetchByLectureseriesIdAndProducerId_Last(
		long lectureseriesId, long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseriesIdAndProducerId_Last(lectureseriesId,
			producerId, orderByComparator);
	}

	/**
	* Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	*
	* @param producerLectureseriesId the primary key of the current producer_ lectureseries
	* @param lectureseriesId the lectureseries ID
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries[] findByLectureseriesIdAndProducerId_PrevAndNext(
		long producerLectureseriesId, long lectureseriesId, long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException {
		return getPersistence()
				   .findByLectureseriesIdAndProducerId_PrevAndNext(producerLectureseriesId,
			lectureseriesId, producerId, orderByComparator);
	}

	/**
	* Removes all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @param producerId the producer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByLectureseriesIdAndProducerId(lectureseriesId, producerId);
	}

	/**
	* Returns the number of producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param producerId the producer ID
	* @return the number of matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLectureseriesIdAndProducerId(lectureseriesId,
			producerId);
	}

	/**
	* Caches the producer_ lectureseries in the entity cache if it is enabled.
	*
	* @param producer_Lectureseries the producer_ lectureseries
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Producer_Lectureseries producer_Lectureseries) {
		getPersistence().cacheResult(producer_Lectureseries);
	}

	/**
	* Caches the producer_ lectureserieses in the entity cache if it is enabled.
	*
	* @param producer_Lectureserieses the producer_ lectureserieses
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> producer_Lectureserieses) {
		getPersistence().cacheResult(producer_Lectureserieses);
	}

	/**
	* Creates a new producer_ lectureseries with the primary key. Does not add the producer_ lectureseries to the database.
	*
	* @param producerLectureseriesId the primary key for the new producer_ lectureseries
	* @return the new producer_ lectureseries
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries create(
		long producerLectureseriesId) {
		return getPersistence().create(producerLectureseriesId);
	}

	/**
	* Removes the producer_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param producerLectureseriesId the primary key of the producer_ lectureseries
	* @return the producer_ lectureseries that was removed
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries remove(
		long producerLectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException {
		return getPersistence().remove(producerLectureseriesId);
	}

	public static de.uhh.l2g.plugins.model.Producer_Lectureseries updateImpl(
		de.uhh.l2g.plugins.model.Producer_Lectureseries producer_Lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(producer_Lectureseries);
	}

	/**
	* Returns the producer_ lectureseries with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException} if it could not be found.
	*
	* @param producerLectureseriesId the primary key of the producer_ lectureseries
	* @return the producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries findByPrimaryKey(
		long producerLectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException {
		return getPersistence().findByPrimaryKey(producerLectureseriesId);
	}

	/**
	* Returns the producer_ lectureseries with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param producerLectureseriesId the primary key of the producer_ lectureseries
	* @return the producer_ lectureseries, or <code>null</code> if a producer_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Producer_Lectureseries fetchByPrimaryKey(
		long producerLectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(producerLectureseriesId);
	}

	/**
	* Returns all the producer_ lectureserieses.
	*
	* @return the producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the producer_ lectureserieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of producer_ lectureserieses
	* @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	* @return the range of producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the producer_ lectureserieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of producer_ lectureserieses
	* @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the producer_ lectureserieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of producer_ lectureserieses.
	*
	* @return the number of producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Producer_LectureseriesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Producer_LectureseriesPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					Producer_LectureseriesPersistence.class.getName());

			ReferenceRegistry.registerReference(Producer_LectureseriesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Producer_LectureseriesPersistence persistence) {
	}

	private static Producer_LectureseriesPersistence _persistence;
}