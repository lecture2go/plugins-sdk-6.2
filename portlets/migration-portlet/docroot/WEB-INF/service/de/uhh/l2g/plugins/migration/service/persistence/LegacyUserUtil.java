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

package de.uhh.l2g.plugins.migration.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.migration.model.LegacyUser;

import java.util.List;

/**
 * The persistence utility for the legacy user service. This utility wraps {@link LegacyUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyUserPersistence
 * @see LegacyUserPersistenceImpl
 * @generated
 */
public class LegacyUserUtil {
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
	public static void clearCache(LegacyUser legacyUser) {
		getPersistence().clearCache(legacyUser);
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
	public static List<LegacyUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegacyUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegacyUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LegacyUser update(LegacyUser legacyUser)
		throws SystemException {
		return getPersistence().update(legacyUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LegacyUser update(LegacyUser legacyUser,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(legacyUser, serviceContext);
	}

	/**
	* Returns all the legacy users where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyUser> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the legacy users where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of legacy users
	* @param end the upper bound of the range of legacy users (not inclusive)
	* @return the range of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyUser> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the legacy users where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of legacy users
	* @param end the upper bound of the range of legacy users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyUser> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first legacy user in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first legacy user in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last legacy user in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last legacy user in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the legacy users before and after the current legacy user in the ordered set where companyId = &#63;.
	*
	* @param userId the primary key of the current legacy user
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a legacy user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser[] findByCompanyId_PrevAndNext(
		long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(userId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the legacy users where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of legacy users where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the legacy user where contactId = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	*
	* @param contactId the contact ID
	* @return the matching legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser findByContactId(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().findByContactId(contactId);
	}

	/**
	* Returns the legacy user where contactId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param contactId the contact ID
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByContactId(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByContactId(contactId);
	}

	/**
	* Returns the legacy user where contactId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param contactId the contact ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByContactId(
		long contactId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByContactId(contactId, retrieveFromCache);
	}

	/**
	* Removes the legacy user where contactId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @return the legacy user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser removeByContactId(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().removeByContactId(contactId);
	}

	/**
	* Returns the number of legacy users where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @return the number of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContactId(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByContactId(contactId);
	}

	/**
	* Returns all the legacy users where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyUser> findByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmailAddress(emailAddress);
	}

	/**
	* Returns a range of all the legacy users where emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param start the lower bound of the range of legacy users
	* @param end the upper bound of the range of legacy users (not inclusive)
	* @return the range of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyUser> findByEmailAddress(
		java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmailAddress(emailAddress, start, end);
	}

	/**
	* Returns an ordered range of all the legacy users where emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param start the lower bound of the range of legacy users
	* @param end the upper bound of the range of legacy users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyUser> findByEmailAddress(
		java.lang.String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailAddress(emailAddress, start, end,
			orderByComparator);
	}

	/**
	* Returns the first legacy user in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser findByEmailAddress_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence()
				   .findByEmailAddress_First(emailAddress, orderByComparator);
	}

	/**
	* Returns the first legacy user in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByEmailAddress_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddress_First(emailAddress, orderByComparator);
	}

	/**
	* Returns the last legacy user in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser findByEmailAddress_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence()
				   .findByEmailAddress_Last(emailAddress, orderByComparator);
	}

	/**
	* Returns the last legacy user in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByEmailAddress_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddress_Last(emailAddress, orderByComparator);
	}

	/**
	* Returns the legacy users before and after the current legacy user in the ordered set where emailAddress = &#63;.
	*
	* @param userId the primary key of the current legacy user
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a legacy user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser[] findByEmailAddress_PrevAndNext(
		long userId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence()
				   .findByEmailAddress_PrevAndNext(userId, emailAddress,
			orderByComparator);
	}

	/**
	* Removes all the legacy users where emailAddress = &#63; from the database.
	*
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmailAddress(emailAddress);
	}

	/**
	* Returns the number of legacy users where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the number of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmailAddress(emailAddress);
	}

	/**
	* Returns the legacy user where openId = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	*
	* @param openId the open ID
	* @return the matching legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser findByOpenId(
		java.lang.String openId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().findByOpenId(openId);
	}

	/**
	* Returns the legacy user where openId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param openId the open ID
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByOpenId(
		java.lang.String openId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOpenId(openId);
	}

	/**
	* Returns the legacy user where openId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param openId the open ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByOpenId(
		java.lang.String openId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOpenId(openId, retrieveFromCache);
	}

	/**
	* Removes the legacy user where openId = &#63; from the database.
	*
	* @param openId the open ID
	* @return the legacy user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser removeByOpenId(
		java.lang.String openId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().removeByOpenId(openId);
	}

	/**
	* Returns the number of legacy users where openId = &#63;.
	*
	* @param openId the open ID
	* @return the number of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOpenId(java.lang.String openId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOpenId(openId);
	}

	/**
	* Returns the legacy user where portraitId = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	*
	* @param portraitId the portrait ID
	* @return the matching legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser findByPortraitId(
		long portraitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().findByPortraitId(portraitId);
	}

	/**
	* Returns the legacy user where portraitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param portraitId the portrait ID
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByPortraitId(
		long portraitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPortraitId(portraitId);
	}

	/**
	* Returns the legacy user where portraitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param portraitId the portrait ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByPortraitId(
		long portraitId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPortraitId(portraitId, retrieveFromCache);
	}

	/**
	* Removes the legacy user where portraitId = &#63; from the database.
	*
	* @param portraitId the portrait ID
	* @return the legacy user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser removeByPortraitId(
		long portraitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().removeByPortraitId(portraitId);
	}

	/**
	* Returns the number of legacy users where portraitId = &#63;.
	*
	* @param portraitId the portrait ID
	* @return the number of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPortraitId(long portraitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPortraitId(portraitId);
	}

	/**
	* Returns the legacy user where companyId = &#63; and userId = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser findByC_U(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().findByC_U(companyId, userId);
	}

	/**
	* Returns the legacy user where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByC_U(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_U(companyId, userId);
	}

	/**
	* Returns the legacy user where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByC_U(
		long companyId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_U(companyId, userId, retrieveFromCache);
	}

	/**
	* Removes the legacy user where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the legacy user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser removeByC_U(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().removeByC_U(companyId, userId);
	}

	/**
	* Returns the number of legacy users where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_U(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_U(companyId, userId);
	}

	/**
	* Returns the legacy user where companyId = &#63; and defaultUser = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	*
	* @param companyId the company ID
	* @param defaultUser the default user
	* @return the matching legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser findByC_DU(
		long companyId, boolean defaultUser)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().findByC_DU(companyId, defaultUser);
	}

	/**
	* Returns the legacy user where companyId = &#63; and defaultUser = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param defaultUser the default user
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByC_DU(
		long companyId, boolean defaultUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_DU(companyId, defaultUser);
	}

	/**
	* Returns the legacy user where companyId = &#63; and defaultUser = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param defaultUser the default user
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByC_DU(
		long companyId, boolean defaultUser, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_DU(companyId, defaultUser, retrieveFromCache);
	}

	/**
	* Removes the legacy user where companyId = &#63; and defaultUser = &#63; from the database.
	*
	* @param companyId the company ID
	* @param defaultUser the default user
	* @return the legacy user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser removeByC_DU(
		long companyId, boolean defaultUser)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().removeByC_DU(companyId, defaultUser);
	}

	/**
	* Returns the number of legacy users where companyId = &#63; and defaultUser = &#63;.
	*
	* @param companyId the company ID
	* @param defaultUser the default user
	* @return the number of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_DU(long companyId, boolean defaultUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_DU(companyId, defaultUser);
	}

	/**
	* Returns the legacy user where companyId = &#63; and screenName = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	*
	* @param companyId the company ID
	* @param screenName the screen name
	* @return the matching legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser findByC_SN(
		long companyId, java.lang.String screenName)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().findByC_SN(companyId, screenName);
	}

	/**
	* Returns the legacy user where companyId = &#63; and screenName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param screenName the screen name
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByC_SN(
		long companyId, java.lang.String screenName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_SN(companyId, screenName);
	}

	/**
	* Returns the legacy user where companyId = &#63; and screenName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param screenName the screen name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByC_SN(
		long companyId, java.lang.String screenName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_SN(companyId, screenName, retrieveFromCache);
	}

	/**
	* Removes the legacy user where companyId = &#63; and screenName = &#63; from the database.
	*
	* @param companyId the company ID
	* @param screenName the screen name
	* @return the legacy user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser removeByC_SN(
		long companyId, java.lang.String screenName)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().removeByC_SN(companyId, screenName);
	}

	/**
	* Returns the number of legacy users where companyId = &#63; and screenName = &#63;.
	*
	* @param companyId the company ID
	* @param screenName the screen name
	* @return the number of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_SN(long companyId, java.lang.String screenName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_SN(companyId, screenName);
	}

	/**
	* Returns the legacy user where companyId = &#63; and emailAddress = &#63; or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	*
	* @param companyId the company ID
	* @param emailAddress the email address
	* @return the matching legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser findByC_EA(
		long companyId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().findByC_EA(companyId, emailAddress);
	}

	/**
	* Returns the legacy user where companyId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param emailAddress the email address
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByC_EA(
		long companyId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_EA(companyId, emailAddress);
	}

	/**
	* Returns the legacy user where companyId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param emailAddress the email address
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching legacy user, or <code>null</code> if a matching legacy user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByC_EA(
		long companyId, java.lang.String emailAddress, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_EA(companyId, emailAddress, retrieveFromCache);
	}

	/**
	* Removes the legacy user where companyId = &#63; and emailAddress = &#63; from the database.
	*
	* @param companyId the company ID
	* @param emailAddress the email address
	* @return the legacy user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser removeByC_EA(
		long companyId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().removeByC_EA(companyId, emailAddress);
	}

	/**
	* Returns the number of legacy users where companyId = &#63; and emailAddress = &#63;.
	*
	* @param companyId the company ID
	* @param emailAddress the email address
	* @return the number of matching legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_EA(long companyId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_EA(companyId, emailAddress);
	}

	/**
	* Caches the legacy user in the entity cache if it is enabled.
	*
	* @param legacyUser the legacy user
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacyUser legacyUser) {
		getPersistence().cacheResult(legacyUser);
	}

	/**
	* Caches the legacy users in the entity cache if it is enabled.
	*
	* @param legacyUsers the legacy users
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacyUser> legacyUsers) {
		getPersistence().cacheResult(legacyUsers);
	}

	/**
	* Creates a new legacy user with the primary key. Does not add the legacy user to the database.
	*
	* @param userId the primary key for the new legacy user
	* @return the new legacy user
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser create(
		long userId) {
		return getPersistence().create(userId);
	}

	/**
	* Removes the legacy user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the legacy user
	* @return the legacy user that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a legacy user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser remove(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().remove(userId);
	}

	public static de.uhh.l2g.plugins.migration.model.LegacyUser updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyUser legacyUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(legacyUser);
	}

	/**
	* Returns the legacy user with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyUserException} if it could not be found.
	*
	* @param userId the primary key of the legacy user
	* @return the legacy user
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyUserException if a legacy user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser findByPrimaryKey(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyUserException {
		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	* Returns the legacy user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the legacy user
	* @return the legacy user, or <code>null</code> if a legacy user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.migration.model.LegacyUser fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	* Returns all the legacy users.
	*
	* @return the legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the legacy users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy users
	* @param end the upper bound of the range of legacy users (not inclusive)
	* @return the range of legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the legacy users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy users
	* @param end the upper bound of the range of legacy users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.migration.model.LegacyUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the legacy users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of legacy users.
	*
	* @return the number of legacy users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LegacyUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LegacyUserPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.migration.service.ClpSerializer.getServletContextName(),
					LegacyUserPersistence.class.getName());

			ReferenceRegistry.registerReference(LegacyUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LegacyUserPersistence persistence) {
	}

	private static LegacyUserPersistence _persistence;
}