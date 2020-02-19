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

import de.uhh.l2g.plugins.model.OaiRecord_OaiSet;

/**
 * The persistence interface for the oai record_ oai set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecord_OaiSetPersistenceImpl
 * @see OaiRecord_OaiSetUtil
 * @generated
 */
public interface OaiRecord_OaiSetPersistence extends BasePersistence<OaiRecord_OaiSet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OaiRecord_OaiSetUtil} to access the oai record_ oai set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the oai record_ oai sets where oaiSetId = &#63;.
	*
	* @param oaiSetId the oai set ID
	* @return the matching oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the oai record_ oai sets where oaiSetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param oaiSetId the oai set ID
	* @param start the lower bound of the range of oai record_ oai sets
	* @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	* @return the range of matching oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the oai record_ oai sets where oaiSetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param oaiSetId the oai set ID
	* @param start the lower bound of the range of oai record_ oai sets
	* @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first oai record_ oai set in the ordered set where oaiSetId = &#63;.
	*
	* @param oaiSetId the oai set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching oai record_ oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet findByoaiSet_First(
		long oaiSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException;

	/**
	* Returns the first oai record_ oai set in the ordered set where oaiSetId = &#63;.
	*
	* @param oaiSetId the oai set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet fetchByoaiSet_First(
		long oaiSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last oai record_ oai set in the ordered set where oaiSetId = &#63;.
	*
	* @param oaiSetId the oai set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching oai record_ oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet findByoaiSet_Last(
		long oaiSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException;

	/**
	* Returns the last oai record_ oai set in the ordered set where oaiSetId = &#63;.
	*
	* @param oaiSetId the oai set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet fetchByoaiSet_Last(
		long oaiSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the oai record_ oai sets before and after the current oai record_ oai set in the ordered set where oaiSetId = &#63;.
	*
	* @param oaiRecordOaiSetId the primary key of the current oai record_ oai set
	* @param oaiSetId the oai set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next oai record_ oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet[] findByoaiSet_PrevAndNext(
		long oaiRecordOaiSetId, long oaiSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException;

	/**
	* Removes all the oai record_ oai sets where oaiSetId = &#63; from the database.
	*
	* @param oaiSetId the oai set ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByoaiSet(long oaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of oai record_ oai sets where oaiSetId = &#63;.
	*
	* @param oaiSetId the oai set ID
	* @return the number of matching oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public int countByoaiSet(long oaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the oai record_ oai sets where oaiRecordId = &#63;.
	*
	* @param oaiRecordId the oai record ID
	* @return the matching oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the oai record_ oai sets where oaiRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param oaiRecordId the oai record ID
	* @param start the lower bound of the range of oai record_ oai sets
	* @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	* @return the range of matching oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the oai record_ oai sets where oaiRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param oaiRecordId the oai record ID
	* @param start the lower bound of the range of oai record_ oai sets
	* @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	*
	* @param oaiRecordId the oai record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching oai record_ oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet findByoaiRecord_First(
		long oaiRecordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException;

	/**
	* Returns the first oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	*
	* @param oaiRecordId the oai record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet fetchByoaiRecord_First(
		long oaiRecordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	*
	* @param oaiRecordId the oai record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching oai record_ oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet findByoaiRecord_Last(
		long oaiRecordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException;

	/**
	* Returns the last oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	*
	* @param oaiRecordId the oai record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet fetchByoaiRecord_Last(
		long oaiRecordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the oai record_ oai sets before and after the current oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	*
	* @param oaiRecordOaiSetId the primary key of the current oai record_ oai set
	* @param oaiRecordId the oai record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next oai record_ oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet[] findByoaiRecord_PrevAndNext(
		long oaiRecordOaiSetId, long oaiRecordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException;

	/**
	* Removes all the oai record_ oai sets where oaiRecordId = &#63; from the database.
	*
	* @param oaiRecordId the oai record ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByoaiRecord(long oaiRecordId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of oai record_ oai sets where oaiRecordId = &#63;.
	*
	* @param oaiRecordId the oai record ID
	* @return the number of matching oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public int countByoaiRecord(long oaiRecordId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the oai record_ oai set in the entity cache if it is enabled.
	*
	* @param oaiRecord_OaiSet the oai record_ oai set
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet);

	/**
	* Caches the oai record_ oai sets in the entity cache if it is enabled.
	*
	* @param oaiRecord_OaiSets the oai record_ oai sets
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> oaiRecord_OaiSets);

	/**
	* Creates a new oai record_ oai set with the primary key. Does not add the oai record_ oai set to the database.
	*
	* @param oaiRecordOaiSetId the primary key for the new oai record_ oai set
	* @return the new oai record_ oai set
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet create(
		long oaiRecordOaiSetId);

	/**
	* Removes the oai record_ oai set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	* @return the oai record_ oai set that was removed
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet remove(
		long oaiRecordOaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException;

	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet updateImpl(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the oai record_ oai set with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException} if it could not be found.
	*
	* @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	* @return the oai record_ oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet findByPrimaryKey(
		long oaiRecordOaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException;

	/**
	* Returns the oai record_ oai set with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	* @return the oai record_ oai set, or <code>null</code> if a oai record_ oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet fetchByPrimaryKey(
		long oaiRecordOaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the oai record_ oai sets.
	*
	* @return the oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the oai record_ oai sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oai record_ oai sets
	* @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	* @return the range of oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the oai record_ oai sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oai record_ oai sets
	* @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the oai record_ oai sets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of oai record_ oai sets.
	*
	* @return the number of oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}