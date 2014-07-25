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

import de.uhh.l2g.plugins.model.License;

/**
 * The persistence interface for the license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LicensePersistenceImpl
 * @see LicenseUtil
 * @generated
 */
public interface LicensePersistence extends BasePersistence<License> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LicenseUtil} to access the license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the license in the entity cache if it is enabled.
	*
	* @param license the license
	*/
	public void cacheResult(de.uhh.l2g.plugins.model.License license);

	/**
	* Caches the licenses in the entity cache if it is enabled.
	*
	* @param licenses the licenses
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.License> licenses);

	/**
	* Creates a new license with the primary key. Does not add the license to the database.
	*
	* @param licenseId the primary key for the new license
	* @return the new license
	*/
	public de.uhh.l2g.plugins.model.License create(int licenseId);

	/**
	* Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param licenseId the primary key of the license
	* @return the license that was removed
	* @throws de.uhh.l2g.plugins.NoSuchLicenseException if a license with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.License remove(int licenseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLicenseException;

	public de.uhh.l2g.plugins.model.License updateImpl(
		de.uhh.l2g.plugins.model.License license)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the license with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLicenseException} if it could not be found.
	*
	* @param licenseId the primary key of the license
	* @return the license
	* @throws de.uhh.l2g.plugins.NoSuchLicenseException if a license with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.License findByPrimaryKey(int licenseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLicenseException;

	/**
	* Returns the license with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param licenseId the primary key of the license
	* @return the license, or <code>null</code> if a license with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.License fetchByPrimaryKey(int licenseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the licenses.
	*
	* @return the licenses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.License> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the licenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of licenses
	* @param end the upper bound of the range of licenses (not inclusive)
	* @return the range of licenses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.License> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the licenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of licenses
	* @param end the upper bound of the range of licenses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of licenses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.License> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the licenses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of licenses.
	*
	* @return the number of licenses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}