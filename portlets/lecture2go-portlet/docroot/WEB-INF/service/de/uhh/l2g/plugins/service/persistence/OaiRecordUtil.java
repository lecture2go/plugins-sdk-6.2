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

import de.uhh.l2g.plugins.model.OaiRecord;

import java.util.List;

/**
 * The persistence utility for the oai record service. This utility wraps {@link OaiRecordPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecordPersistence
 * @see OaiRecordPersistenceImpl
 * @generated
 */
public class OaiRecordUtil {
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
	public static void clearCache(OaiRecord oaiRecord) {
		getPersistence().clearCache(oaiRecord);
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
	public static List<OaiRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OaiRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OaiRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OaiRecord update(OaiRecord oaiRecord)
		throws SystemException {
		return getPersistence().update(oaiRecord);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OaiRecord update(OaiRecord oaiRecord,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(oaiRecord, serviceContext);
	}

	/**
	* Returns the oai record where videoId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchOaiRecordException} if it could not be found.
	*
	* @param videoId the video ID
	* @return the matching oai record
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecordException if a matching oai record could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord findByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecordException {
		return getPersistence().findByVideo(videoId);
	}

	/**
	* Returns the oai record where videoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param videoId the video ID
	* @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord fetchByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVideo(videoId);
	}

	/**
	* Returns the oai record where videoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param videoId the video ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord fetchByVideo(
		long videoId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVideo(videoId, retrieveFromCache);
	}

	/**
	* Removes the oai record where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @return the oai record that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord removeByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecordException {
		return getPersistence().removeByVideo(videoId);
	}

	/**
	* Returns the number of oai records where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching oai records
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideo(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVideo(videoId);
	}

	/**
	* Returns the oai record where identifier = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchOaiRecordException} if it could not be found.
	*
	* @param identifier the identifier
	* @return the matching oai record
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecordException if a matching oai record could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord findByIdentifier(
		java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecordException {
		return getPersistence().findByIdentifier(identifier);
	}

	/**
	* Returns the oai record where identifier = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param identifier the identifier
	* @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord fetchByIdentifier(
		java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdentifier(identifier);
	}

	/**
	* Returns the oai record where identifier = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param identifier the identifier
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord fetchByIdentifier(
		java.lang.String identifier, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdentifier(identifier, retrieveFromCache);
	}

	/**
	* Removes the oai record where identifier = &#63; from the database.
	*
	* @param identifier the identifier
	* @return the oai record that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord removeByIdentifier(
		java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecordException {
		return getPersistence().removeByIdentifier(identifier);
	}

	/**
	* Returns the number of oai records where identifier = &#63;.
	*
	* @param identifier the identifier
	* @return the number of matching oai records
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIdentifier(java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIdentifier(identifier);
	}

	/**
	* Caches the oai record in the entity cache if it is enabled.
	*
	* @param oaiRecord the oai record
	*/
	public static void cacheResult(de.uhh.l2g.plugins.model.OaiRecord oaiRecord) {
		getPersistence().cacheResult(oaiRecord);
	}

	/**
	* Caches the oai records in the entity cache if it is enabled.
	*
	* @param oaiRecords the oai records
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.OaiRecord> oaiRecords) {
		getPersistence().cacheResult(oaiRecords);
	}

	/**
	* Creates a new oai record with the primary key. Does not add the oai record to the database.
	*
	* @param oaiRecordId the primary key for the new oai record
	* @return the new oai record
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord create(long oaiRecordId) {
		return getPersistence().create(oaiRecordId);
	}

	/**
	* Removes the oai record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oaiRecordId the primary key of the oai record
	* @return the oai record that was removed
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecordException if a oai record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord remove(long oaiRecordId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecordException {
		return getPersistence().remove(oaiRecordId);
	}

	public static de.uhh.l2g.plugins.model.OaiRecord updateImpl(
		de.uhh.l2g.plugins.model.OaiRecord oaiRecord)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(oaiRecord);
	}

	/**
	* Returns the oai record with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchOaiRecordException} if it could not be found.
	*
	* @param oaiRecordId the primary key of the oai record
	* @return the oai record
	* @throws de.uhh.l2g.plugins.NoSuchOaiRecordException if a oai record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord findByPrimaryKey(
		long oaiRecordId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecordException {
		return getPersistence().findByPrimaryKey(oaiRecordId);
	}

	/**
	* Returns the oai record with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param oaiRecordId the primary key of the oai record
	* @return the oai record, or <code>null</code> if a oai record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.OaiRecord fetchByPrimaryKey(
		long oaiRecordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(oaiRecordId);
	}

	/**
	* Returns all the oai records.
	*
	* @return the oai records
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the oai records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oai records
	* @param end the upper bound of the range of oai records (not inclusive)
	* @return the range of oai records
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the oai records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oai records
	* @param end the upper bound of the range of oai records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of oai records
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the oai records from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of oai records.
	*
	* @return the number of oai records
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OaiRecordPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OaiRecordPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					OaiRecordPersistence.class.getName());

			ReferenceRegistry.registerReference(OaiRecordUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OaiRecordPersistence persistence) {
	}

	private static OaiRecordPersistence _persistence;
}