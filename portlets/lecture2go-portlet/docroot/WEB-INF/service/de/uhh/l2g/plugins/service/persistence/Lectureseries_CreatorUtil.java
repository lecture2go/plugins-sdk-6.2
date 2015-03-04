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

import de.uhh.l2g.plugins.model.Lectureseries_Creator;

import java.util.List;

/**
 * The persistence utility for the lectureseries_ creator service. This utility wraps {@link Lectureseries_CreatorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_CreatorPersistence
 * @see Lectureseries_CreatorPersistenceImpl
 * @generated
 */
public class Lectureseries_CreatorUtil {
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
	public static void clearCache(Lectureseries_Creator lectureseries_Creator) {
		getPersistence().clearCache(lectureseries_Creator);
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
	public static List<Lectureseries_Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lectureseries_Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lectureseries_Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Lectureseries_Creator update(
		Lectureseries_Creator lectureseries_Creator) throws SystemException {
		return getPersistence().update(lectureseries_Creator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Lectureseries_Creator update(
		Lectureseries_Creator lectureseries_Creator,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lectureseries_Creator, serviceContext);
	}

	/**
	* Returns all the lectureseries_ creators where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> findByLectureseries(
		long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLectureseries(lectureseriesId);
	}

	/**
	* Returns a range of all the lectureseries_ creators where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ creators
	* @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	* @return the range of matching lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> findByLectureseries(
		long lectureseriesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLectureseries(lectureseriesId, start, end);
	}

	/**
	* Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ creators
	* @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> findByLectureseries(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLectureseries(lectureseriesId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ creator
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator findByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException {
		return getPersistence()
				   .findByLectureseries_First(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator fetchByLectureseries_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseries_First(lectureseriesId,
			orderByComparator);
	}

	/**
	* Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ creator
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator findByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException {
		return getPersistence()
				   .findByLectureseries_Last(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator fetchByLectureseries_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLectureseries_Last(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ creator
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator[] findByLectureseries_PrevAndNext(
		long lectureseriesCreatorId, long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException {
		return getPersistence()
				   .findByLectureseries_PrevAndNext(lectureseriesCreatorId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ creators where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLectureseries(lectureseriesId);
	}

	/**
	* Returns the number of lectureseries_ creators where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLectureseries(lectureseriesId);
	}

	/**
	* Returns all the lectureseries_ creators where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the matching lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> findByCreator(
		long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreator(creatorId);
	}

	/**
	* Returns a range of all the lectureseries_ creators where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of lectureseries_ creators
	* @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	* @return the range of matching lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> findByCreator(
		long creatorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreator(creatorId, start, end);
	}

	/**
	* Returns an ordered range of all the lectureseries_ creators where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of lectureseries_ creators
	* @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> findByCreator(
		long creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreator(creatorId, start, end, orderByComparator);
	}

	/**
	* Returns the first lectureseries_ creator in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ creator
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator findByCreator_First(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException {
		return getPersistence().findByCreator_First(creatorId, orderByComparator);
	}

	/**
	* Returns the first lectureseries_ creator in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator fetchByCreator_First(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreator_First(creatorId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ creator in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ creator
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator findByCreator_Last(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException {
		return getPersistence().findByCreator_Last(creatorId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ creator in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator fetchByCreator_Last(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCreator_Last(creatorId, orderByComparator);
	}

	/**
	* Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where creatorId = &#63;.
	*
	* @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ creator
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator[] findByCreator_PrevAndNext(
		long lectureseriesCreatorId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException {
		return getPersistence()
				   .findByCreator_PrevAndNext(lectureseriesCreatorId,
			creatorId, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ creators where creatorId = &#63; from the database.
	*
	* @param creatorId the creator ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCreator(creatorId);
	}

	/**
	* Returns the number of lectureseries_ creators where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the number of matching lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCreator(creatorId);
	}

	/**
	* Caches the lectureseries_ creator in the entity cache if it is enabled.
	*
	* @param lectureseries_Creator the lectureseries_ creator
	*/
	public static void cacheResult(
		de.uhh.l2g.plugins.model.Lectureseries_Creator lectureseries_Creator) {
		getPersistence().cacheResult(lectureseries_Creator);
	}

	/**
	* Caches the lectureseries_ creators in the entity cache if it is enabled.
	*
	* @param lectureseries_Creators the lectureseries_ creators
	*/
	public static void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> lectureseries_Creators) {
		getPersistence().cacheResult(lectureseries_Creators);
	}

	/**
	* Creates a new lectureseries_ creator with the primary key. Does not add the lectureseries_ creator to the database.
	*
	* @param lectureseriesCreatorId the primary key for the new lectureseries_ creator
	* @return the new lectureseries_ creator
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator create(
		long lectureseriesCreatorId) {
		return getPersistence().create(lectureseriesCreatorId);
	}

	/**
	* Removes the lectureseries_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	* @return the lectureseries_ creator that was removed
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator remove(
		long lectureseriesCreatorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException {
		return getPersistence().remove(lectureseriesCreatorId);
	}

	public static de.uhh.l2g.plugins.model.Lectureseries_Creator updateImpl(
		de.uhh.l2g.plugins.model.Lectureseries_Creator lectureseries_Creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lectureseries_Creator);
	}

	/**
	* Returns the lectureseries_ creator with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException} if it could not be found.
	*
	* @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	* @return the lectureseries_ creator
	* @throws de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator findByPrimaryKey(
		long lectureseriesCreatorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchLectureseries_CreatorException {
		return getPersistence().findByPrimaryKey(lectureseriesCreatorId);
	}

	/**
	* Returns the lectureseries_ creator with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	* @return the lectureseries_ creator, or <code>null</code> if a lectureseries_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Lectureseries_Creator fetchByPrimaryKey(
		long lectureseriesCreatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(lectureseriesCreatorId);
	}

	/**
	* Returns all the lectureseries_ creators.
	*
	* @return the lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lectureseries_ creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ creators
	* @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	* @return the range of lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lectureseries_ creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ creators
	* @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ creators from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lectureseries_ creators.
	*
	* @return the number of lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Lectureseries_CreatorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Lectureseries_CreatorPersistence)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					Lectureseries_CreatorPersistence.class.getName());

			ReferenceRegistry.registerReference(Lectureseries_CreatorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Lectureseries_CreatorPersistence persistence) {
	}

	private static Lectureseries_CreatorPersistence _persistence;
}