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

import de.uhh.l2g.plugins.model.OaiSet;

/**
 * The persistence interface for the oai set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiSetPersistenceImpl
 * @see OaiSetUtil
 * @generated
 */
public interface OaiSetPersistence extends BasePersistence<OaiSet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OaiSetUtil} to access the oai set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the oai set in the entity cache if it is enabled.
	*
	* @param oaiSet the oai set
	*/
	public void cacheResult(de.uhh.l2g.plugins.model.OaiSet oaiSet);

	/**
	* Caches the oai sets in the entity cache if it is enabled.
	*
	* @param oaiSets the oai sets
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.OaiSet> oaiSets);

	/**
	* Creates a new oai set with the primary key. Does not add the oai set to the database.
	*
	* @param oaiSetId the primary key for the new oai set
	* @return the new oai set
	*/
	public de.uhh.l2g.plugins.model.OaiSet create(long oaiSetId);

	/**
	* Removes the oai set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oaiSetId the primary key of the oai set
	* @return the oai set that was removed
	* @throws de.uhh.l2g.plugins.NoSuchOaiSetException if a oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiSet remove(long oaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiSetException;

	public de.uhh.l2g.plugins.model.OaiSet updateImpl(
		de.uhh.l2g.plugins.model.OaiSet oaiSet)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the oai set with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchOaiSetException} if it could not be found.
	*
	* @param oaiSetId the primary key of the oai set
	* @return the oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiSetException if a oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiSet findByPrimaryKey(long oaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiSetException;

	/**
	* Returns the oai set with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param oaiSetId the primary key of the oai set
	* @return the oai set, or <code>null</code> if a oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiSet fetchByPrimaryKey(long oaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the oai sets.
	*
	* @return the oai sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.OaiSet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the oai sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oai sets
	* @param end the upper bound of the range of oai sets (not inclusive)
	* @return the range of oai sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.OaiSet> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the oai sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oai sets
	* @param end the upper bound of the range of oai sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of oai sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.OaiSet> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the oai sets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of oai sets.
	*
	* @return the number of oai sets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}