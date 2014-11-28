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

import de.uhh.l2g.plugins.model.Producer;

/**
 * The persistence interface for the producer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ProducerPersistenceImpl
 * @see ProducerUtil
 * @generated
 */
public interface ProducerPersistence extends BasePersistence<Producer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProducerUtil} to access the producer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the producers where hostId = &#63;.
	*
	* @param hostId the host ID
	* @return the matching producers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer> findByHost(
		long hostId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the producers where hostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param hostId the host ID
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @return the range of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer> findByHost(
		long hostId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the producers where hostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param hostId the host ID
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer> findByHost(
		long hostId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first producer in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer findByHost_First(long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Returns the first producer in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer fetchByHost_First(long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last producer in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer findByHost_Last(long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Returns the last producer in the ordered set where hostId = &#63;.
	*
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer fetchByHost_Last(long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the producers before and after the current producer in the ordered set where hostId = &#63;.
	*
	* @param producerId the primary key of the current producer
	* @param hostId the host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer[] findByHost_PrevAndNext(
		long producerId, long hostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Removes all the producers where hostId = &#63; from the database.
	*
	* @param hostId the host ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByHost(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of producers where hostId = &#63;.
	*
	* @param hostId the host ID
	* @return the number of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public int countByHost(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the producers where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the matching producers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer> findByInstitution(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the producers where institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionId the institution ID
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @return the range of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer> findByInstitution(
		long institutionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the producers where institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionId the institution ID
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer> findByInstitution(
		long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first producer in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer findByInstitution_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Returns the first producer in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer fetchByInstitution_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last producer in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer findByInstitution_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Returns the last producer in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer fetchByInstitution_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the producers before and after the current producer in the ordered set where institutionId = &#63;.
	*
	* @param producerId the primary key of the current producer
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer[] findByInstitution_PrevAndNext(
		long producerId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Removes all the producers where institutionId = &#63; from the database.
	*
	* @param institutionId the institution ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByInstitution(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of producers where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the number of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public int countByInstitution(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the producers where approved = &#63;.
	*
	* @param approved the approved
	* @return the matching producers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer> findByStatus(
		int approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the producers where approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param approved the approved
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @return the range of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer> findByStatus(
		int approved, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the producers where approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param approved the approved
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer> findByStatus(
		int approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first producer in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer findByStatus_First(int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Returns the first producer in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer fetchByStatus_First(int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last producer in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer findByStatus_Last(int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Returns the last producer in the ordered set where approved = &#63;.
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer fetchByStatus_Last(int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the producers before and after the current producer in the ordered set where approved = &#63;.
	*
	* @param producerId the primary key of the current producer
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer[] findByStatus_PrevAndNext(
		long producerId, int approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Removes all the producers where approved = &#63; from the database.
	*
	* @param approved the approved
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of producers where approved = &#63;.
	*
	* @param approved the approved
	* @return the number of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the producer where homeDir = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchProducerException} if it could not be found.
	*
	* @param homeDir the home dir
	* @return the matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer findByDirectory(
		java.lang.String homeDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Returns the producer where homeDir = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param homeDir the home dir
	* @return the matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer fetchByDirectory(
		java.lang.String homeDir)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the producer where homeDir = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param homeDir the home dir
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer fetchByDirectory(
		java.lang.String homeDir, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the producer where homeDir = &#63; from the database.
	*
	* @param homeDir the home dir
	* @return the producer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer removeByDirectory(
		java.lang.String homeDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Returns the number of producers where homeDir = &#63;.
	*
	* @param homeDir the home dir
	* @return the number of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public int countByDirectory(java.lang.String homeDir)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the producer where idNum = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchProducerException} if it could not be found.
	*
	* @param idNum the id num
	* @return the matching producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer findByUID(java.lang.String idNum)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Returns the producer where idNum = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param idNum the id num
	* @return the matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer fetchByUID(java.lang.String idNum)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the producer where idNum = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param idNum the id num
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching producer, or <code>null</code> if a matching producer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer fetchByUID(
		java.lang.String idNum, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the producer where idNum = &#63; from the database.
	*
	* @param idNum the id num
	* @return the producer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer removeByUID(java.lang.String idNum)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Returns the number of producers where idNum = &#63;.
	*
	* @param idNum the id num
	* @return the number of matching producers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUID(java.lang.String idNum)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the producer in the entity cache if it is enabled.
	*
	* @param producer the producer
	*/
	public void cacheResult(de.uhh.l2g.plugins.model.Producer producer);

	/**
	* Caches the producers in the entity cache if it is enabled.
	*
	* @param producers the producers
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Producer> producers);

	/**
	* Creates a new producer with the primary key. Does not add the producer to the database.
	*
	* @param producerId the primary key for the new producer
	* @return the new producer
	*/
	public de.uhh.l2g.plugins.model.Producer create(long producerId);

	/**
	* Removes the producer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param producerId the primary key of the producer
	* @return the producer that was removed
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer remove(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	public de.uhh.l2g.plugins.model.Producer updateImpl(
		de.uhh.l2g.plugins.model.Producer producer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the producer with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchProducerException} if it could not be found.
	*
	* @param producerId the primary key of the producer
	* @return the producer
	* @throws de.uhh.l2g.plugins.NoSuchProducerException if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer findByPrimaryKey(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchProducerException;

	/**
	* Returns the producer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param producerId the primary key of the producer
	* @return the producer, or <code>null</code> if a producer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Producer fetchByPrimaryKey(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the producers.
	*
	* @return the producers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the producers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @return the range of producers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the producers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of producers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Producer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the producers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of producers.
	*
	* @return the number of producers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}