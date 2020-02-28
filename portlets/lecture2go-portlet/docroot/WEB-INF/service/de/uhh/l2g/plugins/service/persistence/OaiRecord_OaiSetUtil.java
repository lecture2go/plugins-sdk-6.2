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

import de.uhh.l2g.plugins.model.OaiRecord_OaiSet;

import java.util.List;

/**
 * The persistence utility for the oai record_ oai set service. This utility wraps {@link OaiRecord_OaiSetPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecord_OaiSetPersistence
 * @see OaiRecord_OaiSetPersistenceImpl
 * @generated
 */
public class OaiRecord_OaiSetUtil {
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
	public static void clearCache(OaiRecord_OaiSet oaiRecord_OaiSet) {
		getPersistence().clearCache(oaiRecord_OaiSet);
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
	public static List<OaiRecord_OaiSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OaiRecord_OaiSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OaiRecord_OaiSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OaiRecord_OaiSet update(OaiRecord_OaiSet oaiRecord_OaiSet)
		throws SystemException {
		return getPersistence().update(oaiRecord_OaiSet);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OaiRecord_OaiSet update(OaiRecord_OaiSet oaiRecord_OaiSet,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(oaiRecord_OaiSet, serviceContext);
	}

	/**
	* Returns all the oai record_ oai sets where oaiSetId = &#63;.
	*
	* @param oaiSetId the oai set ID
	* @return the matching oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByoaiSet(oaiSetId);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByoaiSet(oaiSetId, start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoaiSet(oaiSetId, start, end, orderByComparator);
	}

	/**
	* Returns the first oai record_ oai set in the ordered set where oaiSetId = &#63;.
	*
	* @param oaiSetId the oai set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching oai record_ oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet findByoaiSet_First(
		long oaiSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException {
		return getPersistence().findByoaiSet_First(oaiSetId, orderByComparator);
	}

	/**
	* Returns the first oai record_ oai set in the ordered set where oaiSetId = &#63;.
	*
	* @param oaiSetId the oai set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet fetchByoaiSet_First(
		long oaiSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByoaiSet_First(oaiSetId, orderByComparator);
	}

	/**
	* Returns the last oai record_ oai set in the ordered set where oaiSetId = &#63;.
	*
	* @param oaiSetId the oai set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching oai record_ oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet findByoaiSet_Last(
		long oaiSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException {
		return getPersistence().findByoaiSet_Last(oaiSetId, orderByComparator);
	}

	/**
	* Returns the last oai record_ oai set in the ordered set where oaiSetId = &#63;.
	*
	* @param oaiSetId the oai set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet fetchByoaiSet_Last(
		long oaiSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByoaiSet_Last(oaiSetId, orderByComparator);
	}

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
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet[] findByoaiSet_PrevAndNext(
		long oaiRecordOaiSetId, long oaiSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException {
		return getPersistence()
				   .findByoaiSet_PrevAndNext(oaiRecordOaiSetId, oaiSetId,
			orderByComparator);
	}

	/**
	* Removes all the oai record_ oai sets where oaiSetId = &#63; from the database.
	*
	* @param oaiSetId the oai set ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByoaiSet(long oaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByoaiSet(oaiSetId);
	}

	/**
	* Returns the number of oai record_ oai sets where oaiSetId = &#63;.
	*
	* @param oaiSetId the oai set ID
	* @return the number of matching oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByoaiSet(long oaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByoaiSet(oaiSetId);
	}

	/**
	* Returns all the oai record_ oai sets where oaiRecordId = &#63;.
	*
	* @param oaiRecordId the oai record ID
	* @return the matching oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByoaiRecord(oaiRecordId);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByoaiRecord(oaiRecordId, start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoaiRecord(oaiRecordId, start, end, orderByComparator);
	}

	/**
	* Returns the first oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	*
	* @param oaiRecordId the oai record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching oai record_ oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet findByoaiRecord_First(
		long oaiRecordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException {
		return getPersistence()
				   .findByoaiRecord_First(oaiRecordId, orderByComparator);
	}

	/**
	* Returns the first oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	*
	* @param oaiRecordId the oai record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet fetchByoaiRecord_First(
		long oaiRecordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByoaiRecord_First(oaiRecordId, orderByComparator);
	}

	/**
	* Returns the last oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	*
	* @param oaiRecordId the oai record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching oai record_ oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet findByoaiRecord_Last(
		long oaiRecordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException {
		return getPersistence()
				   .findByoaiRecord_Last(oaiRecordId, orderByComparator);
	}

	/**
	* Returns the last oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	*
	* @param oaiRecordId the oai record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet fetchByoaiRecord_Last(
		long oaiRecordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByoaiRecord_Last(oaiRecordId, orderByComparator);
	}

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
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet[] findByoaiRecord_PrevAndNext(
		long oaiRecordOaiSetId, long oaiRecordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException {
		return getPersistence()
				   .findByoaiRecord_PrevAndNext(oaiRecordOaiSetId, oaiRecordId,
			orderByComparator);
	}

	/**
	* Removes all the oai record_ oai sets where oaiRecordId = &#63; from the database.
	*
	* @param oaiRecordId the oai record ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByoaiRecord(long oaiRecordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByoaiRecord(oaiRecordId);
	}

	/**
	* Returns the number of oai record_ oai sets where oaiRecordId = &#63;.
	*
	* @param oaiRecordId the oai record ID
	* @return the number of matching oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByoaiRecord(long oaiRecordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByoaiRecord(oaiRecordId);
	}

	/**
	* Caches the oai record_ oai set in the entity cache if it is enabled.
	*
	* @param oaiRecord_OaiSet the oai record_ oai set
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet) {
		getPersistence().cacheResult(oaiRecord_OaiSet);
	}

	/**
	* Caches the oai record_ oai sets in the entity cache if it is enabled.
	*
	* @param oaiRecord_OaiSets the oai record_ oai sets
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> oaiRecord_OaiSets) {
		getPersistence().cacheResult(oaiRecord_OaiSets);
	}

	/**
	* Creates a new oai record_ oai set with the primary key. Does not add the oai record_ oai set to the database.
	*
	* @param oaiRecordOaiSetId the primary key for the new oai record_ oai set
	* @return the new oai record_ oai set
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet create(
		long oaiRecordOaiSetId) {
		return getPersistence().create(oaiRecordOaiSetId);
	}

	/**
	* Removes the oai record_ oai set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	* @return the oai record_ oai set that was removed
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet remove(
		long oaiRecordOaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException {
		return getPersistence().remove(oaiRecordOaiSetId);
	}

	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet updateImpl(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(oaiRecord_OaiSet);
	}

	/**
	* Returns the oai record_ oai set with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException} if it could not be found.
	*
	* @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	* @return the oai record_ oai set
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet findByPrimaryKey(
		long oaiRecordOaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecord_OaiSetException {
		return getPersistence().findByPrimaryKey(oaiRecordOaiSetId);
	}

	/**
	* Returns the oai record_ oai set with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	* @return the oai record_ oai set, or <code>null</code> if a oai record_ oai set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord_OaiSet fetchByPrimaryKey(
		long oaiRecordOaiSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(oaiRecordOaiSetId);
	}

	/**
	* Returns all the oai record_ oai sets.
	*
	* @return the oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the oai record_ oai sets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of oai record_ oai sets.
	*
	* @return the number of oai record_ oai sets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OaiRecord_OaiSetPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OaiRecord_OaiSetPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					OaiRecord_OaiSetPersistence.class.getName());

			ReferenceRegistry.registerReference(OaiRecord_OaiSetUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OaiRecord_OaiSetPersistence persistence) {
	}

	private static OaiRecord_OaiSetPersistence _persistence;
}