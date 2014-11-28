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

import de.uhh.l2g.plugins.model.Coordinator;

/**
 * The persistence interface for the coordinator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see CoordinatorPersistenceImpl
 * @see CoordinatorUtil
 * @generated
 */
public interface CoordinatorPersistence extends BasePersistence<Coordinator> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CoordinatorUtil} to access the coordinator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the coordinators where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Coordinator> findByInstitution(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the coordinators where institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionId the institution ID
	* @param start the lower bound of the range of coordinators
	* @param end the upper bound of the range of coordinators (not inclusive)
	* @return the range of matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Coordinator> findByInstitution(
		long institutionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the coordinators where institutionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionId the institution ID
	* @param start the lower bound of the range of coordinators
	* @param end the upper bound of the range of coordinators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Coordinator> findByInstitution(
		long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first coordinator in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator findByInstitution_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException;

	/**
	* Returns the first coordinator in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator fetchByInstitution_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last coordinator in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator findByInstitution_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException;

	/**
	* Returns the last coordinator in the ordered set where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator fetchByInstitution_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the coordinators before and after the current coordinator in the ordered set where institutionId = &#63;.
	*
	* @param coordinatorId the primary key of the current coordinator
	* @param institutionId the institution ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator[] findByInstitution_PrevAndNext(
		long coordinatorId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException;

	/**
	* Removes all the coordinators where institutionId = &#63; from the database.
	*
	* @param institutionId the institution ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByInstitution(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of coordinators where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the number of matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public int countByInstitution(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the coordinators where officeId = &#63;.
	*
	* @param officeId the office ID
	* @return the matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Coordinator> findByOffice(
		long officeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the coordinators where officeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param officeId the office ID
	* @param start the lower bound of the range of coordinators
	* @param end the upper bound of the range of coordinators (not inclusive)
	* @return the range of matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Coordinator> findByOffice(
		long officeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the coordinators where officeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param officeId the office ID
	* @param start the lower bound of the range of coordinators
	* @param end the upper bound of the range of coordinators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Coordinator> findByOffice(
		long officeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first coordinator in the ordered set where officeId = &#63;.
	*
	* @param officeId the office ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator findByOffice_First(
		long officeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException;

	/**
	* Returns the first coordinator in the ordered set where officeId = &#63;.
	*
	* @param officeId the office ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator fetchByOffice_First(
		long officeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last coordinator in the ordered set where officeId = &#63;.
	*
	* @param officeId the office ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator findByOffice_Last(
		long officeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException;

	/**
	* Returns the last coordinator in the ordered set where officeId = &#63;.
	*
	* @param officeId the office ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator fetchByOffice_Last(
		long officeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the coordinators before and after the current coordinator in the ordered set where officeId = &#63;.
	*
	* @param coordinatorId the primary key of the current coordinator
	* @param officeId the office ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator[] findByOffice_PrevAndNext(
		long coordinatorId, long officeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException;

	/**
	* Removes all the coordinators where officeId = &#63; from the database.
	*
	* @param officeId the office ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOffice(long officeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of coordinators where officeId = &#63;.
	*
	* @param officeId the office ID
	* @return the number of matching coordinators
	* @throws SystemException if a system exception occurred
	*/
	public int countByOffice(long officeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the coordinator in the entity cache if it is enabled.
	*
	* @param coordinator the coordinator
	*/
	public void cacheResult(de.uhh.l2g.plugins.model.Coordinator coordinator);

	/**
	* Caches the coordinators in the entity cache if it is enabled.
	*
	* @param coordinators the coordinators
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Coordinator> coordinators);

	/**
	* Creates a new coordinator with the primary key. Does not add the coordinator to the database.
	*
	* @param coordinatorId the primary key for the new coordinator
	* @return the new coordinator
	*/
	public de.uhh.l2g.plugins.model.Coordinator create(long coordinatorId);

	/**
	* Removes the coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param coordinatorId the primary key of the coordinator
	* @return the coordinator that was removed
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator remove(long coordinatorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException;

	public de.uhh.l2g.plugins.model.Coordinator updateImpl(
		de.uhh.l2g.plugins.model.Coordinator coordinator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the coordinator with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchCoordinatorException} if it could not be found.
	*
	* @param coordinatorId the primary key of the coordinator
	* @return the coordinator
	* @throws de.uhh.l2g.plugins.NoSuchCoordinatorException if a coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator findByPrimaryKey(
		long coordinatorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchCoordinatorException;

	/**
	* Returns the coordinator with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param coordinatorId the primary key of the coordinator
	* @return the coordinator, or <code>null</code> if a coordinator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Coordinator fetchByPrimaryKey(
		long coordinatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the coordinators.
	*
	* @return the coordinators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Coordinator> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the coordinators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of coordinators
	* @param end the upper bound of the range of coordinators (not inclusive)
	* @return the range of coordinators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Coordinator> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the coordinators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of coordinators
	* @param end the upper bound of the range of coordinators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of coordinators
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Coordinator> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the coordinators from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of coordinators.
	*
	* @return the number of coordinators
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}