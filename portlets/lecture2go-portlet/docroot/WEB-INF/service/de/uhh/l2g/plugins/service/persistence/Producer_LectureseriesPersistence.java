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

import de.uhh.l2g.plugins.model.Producer_Lectureseries;

/**
 * The persistence interface for the producer_ lectureseries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Producer_LectureseriesPersistenceImpl
 * @see Producer_LectureseriesUtil
 * @generated
 */
public interface Producer_LectureseriesPersistence extends BasePersistence<Producer_Lectureseries> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Producer_LectureseriesUtil} to access the producer_ lectureseries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the producer_ lectureserieses where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByLectureseries(
		long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByLectureseries(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer_Lectureseries findByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException;

	/**
	* Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer_Lectureseries fetchByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer_Lectureseries findByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException;

	/**
	* Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer_Lectureseries fetchByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Producer_Lectureseries[] findByLectureseries_PrevAndNext(
		long producerLectureseriesId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException;

	/**
	* Removes all the producer_ lectureserieses where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of producer_ lectureserieses where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the producer_ lectureserieses where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @return the matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByProducer(
		long producerId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByProducer(
		long producerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findByProducer(
		long producerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first producer_ lectureseries in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer_Lectureseries findByProducer_First(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException;

	/**
	* Returns the first producer_ lectureseries in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer_Lectureseries fetchByProducer_First(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last producer_ lectureseries in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer_Lectureseries findByProducer_Last(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException;

	/**
	* Returns the last producer_ lectureseries in the ordered set where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer_Lectureseries fetchByProducer_Last(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.uhh.l2g.plugins.model.Producer_Lectureseries[] findByProducer_PrevAndNext(
		long producerLectureseriesId, long producerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException;

	/**
	* Removes all the producer_ lectureserieses where producerId = &#63; from the database.
	*
	* @param producerId the producer ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProducer(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of producer_ lectureserieses where producerId = &#63;.
	*
	* @param producerId the producer ID
	* @return the number of matching producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByProducer(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the producer_ lectureseries in the entity cache if it is enabled.
	*
	* @param producer_Lectureseries the producer_ lectureseries
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.model.Producer_Lectureseries producer_Lectureseries);

	/**
	* Caches the producer_ lectureserieses in the entity cache if it is enabled.
	*
	* @param producer_Lectureserieses the producer_ lectureserieses
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> producer_Lectureserieses);

	/**
	* Creates a new producer_ lectureseries with the primary key. Does not add the producer_ lectureseries to the database.
	*
	* @param producerLectureseriesId the primary key for the new producer_ lectureseries
	* @return the new producer_ lectureseries
	*/
	public de.uhh.l2g.plugins.model.Producer_Lectureseries create(
		long producerLectureseriesId);

	/**
	* Removes the producer_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param producerLectureseriesId the primary key of the producer_ lectureseries
	* @return the producer_ lectureseries that was removed
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer_Lectureseries remove(
		long producerLectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException;

	public de.uhh.l2g.plugins.model.Producer_Lectureseries updateImpl(
		de.uhh.l2g.plugins.model.Producer_Lectureseries producer_Lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the producer_ lectureseries with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException} if it could not be found.
	*
	* @param producerLectureseriesId the primary key of the producer_ lectureseries
	* @return the producer_ lectureseries
	* @throws de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer_Lectureseries findByPrimaryKey(
		long producerLectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException;

	/**
	* Returns the producer_ lectureseries with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param producerLectureseriesId the primary key of the producer_ lectureseries
	* @return the producer_ lectureseries, or <code>null</code> if a producer_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer_Lectureseries fetchByPrimaryKey(
		long producerLectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the producer_ lectureserieses.
	*
	* @return the producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the producer_ lectureserieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of producer_ lectureserieses.
	*
	* @return the number of producer_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}