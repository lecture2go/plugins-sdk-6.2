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

import de.uhh.l2g.plugins.model.Office;

/**
 * The persistence interface for the office service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OfficePersistenceImpl
 * @see OfficeUtil
 * @generated
 */
public interface OfficePersistence extends BasePersistence<Office> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OfficeUtil} to access the office persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the office where institutionId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchOfficeException} if it could not be found.
	*
	* @param institutionId the institution ID
	* @return the matching office
	* @throws de.uhh.l2g.plugins.NoSuchOfficeException if a matching office could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Office findByInstitution(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOfficeException;

	/**
	* Returns the office where institutionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param institutionId the institution ID
	* @return the matching office, or <code>null</code> if a matching office could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Office fetchByInstitution(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the office where institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param institutionId the institution ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching office, or <code>null</code> if a matching office could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Office fetchByInstitution(
		long institutionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the office where institutionId = &#63; from the database.
	*
	* @param institutionId the institution ID
	* @return the office that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Office removeByInstitution(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOfficeException;

	/**
	* Returns the number of offices where institutionId = &#63;.
	*
	* @param institutionId the institution ID
	* @return the number of matching offices
	* @throws SystemException if a system exception occurred
	*/
	public int countByInstitution(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the office in the entity cache if it is enabled.
	*
	* @param office the office
	*/
	public void cacheResult(de.uhh.l2g.plugins.model.Office office);

	/**
	* Caches the offices in the entity cache if it is enabled.
	*
	* @param offices the offices
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Office> offices);

	/**
	* Creates a new office with the primary key. Does not add the office to the database.
	*
	* @param officeId the primary key for the new office
	* @return the new office
	*/
	public de.uhh.l2g.plugins.model.Office create(long officeId);

	/**
	* Removes the office with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeId the primary key of the office
	* @return the office that was removed
	* @throws de.uhh.l2g.plugins.NoSuchOfficeException if a office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Office remove(long officeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOfficeException;

	public de.uhh.l2g.plugins.model.Office updateImpl(
		de.uhh.l2g.plugins.model.Office office)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the office with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchOfficeException} if it could not be found.
	*
	* @param officeId the primary key of the office
	* @return the office
	* @throws de.uhh.l2g.plugins.NoSuchOfficeException if a office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Office findByPrimaryKey(long officeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOfficeException;

	/**
	* Returns the office with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param officeId the primary key of the office
	* @return the office, or <code>null</code> if a office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Office fetchByPrimaryKey(long officeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the offices.
	*
	* @return the offices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Office> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the offices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of offices
	* @param end the upper bound of the range of offices (not inclusive)
	* @return the range of offices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Office> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the offices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of offices
	* @param end the upper bound of the range of offices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of offices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Office> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the offices from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of offices.
	*
	* @return the number of offices
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}