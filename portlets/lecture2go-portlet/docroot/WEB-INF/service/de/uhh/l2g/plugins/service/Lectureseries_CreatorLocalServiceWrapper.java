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

package de.uhh.l2g.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Lectureseries_CreatorLocalService}.
 *
 * @author Iavor Sturm
 * @see Lectureseries_CreatorLocalService
 * @generated
 */
public class Lectureseries_CreatorLocalServiceWrapper
	implements Lectureseries_CreatorLocalService,
		ServiceWrapper<Lectureseries_CreatorLocalService> {
	public Lectureseries_CreatorLocalServiceWrapper(
		Lectureseries_CreatorLocalService lectureseries_CreatorLocalService) {
		_lectureseries_CreatorLocalService = lectureseries_CreatorLocalService;
	}

	/**
	* Adds the lectureseries_ creator to the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries_Creator the lectureseries_ creator
	* @return the lectureseries_ creator that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Creator addLectureseries_Creator(
		de.uhh.l2g.plugins.model.Lectureseries_Creator lectureseries_Creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.addLectureseries_Creator(lectureseries_Creator);
	}

	/**
	* Creates a new lectureseries_ creator with the primary key. Does not add the lectureseries_ creator to the database.
	*
	* @param lectureseriesCreatorId the primary key for the new lectureseries_ creator
	* @return the new lectureseries_ creator
	*/
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Creator createLectureseries_Creator(
		long lectureseriesCreatorId) {
		return _lectureseries_CreatorLocalService.createLectureseries_Creator(lectureseriesCreatorId);
	}

	/**
	* Deletes the lectureseries_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	* @return the lectureseries_ creator that was removed
	* @throws PortalException if a lectureseries_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Creator deleteLectureseries_Creator(
		long lectureseriesCreatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.deleteLectureseries_Creator(lectureseriesCreatorId);
	}

	/**
	* Deletes the lectureseries_ creator from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseries_Creator the lectureseries_ creator
	* @return the lectureseries_ creator that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Creator deleteLectureseries_Creator(
		de.uhh.l2g.plugins.model.Lectureseries_Creator lectureseries_Creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.deleteLectureseries_Creator(lectureseries_Creator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lectureseries_CreatorLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Creator fetchLectureseries_Creator(
		long lectureseriesCreatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.fetchLectureseries_Creator(lectureseriesCreatorId);
	}

	/**
	* Returns the lectureseries_ creator with the primary key.
	*
	* @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	* @return the lectureseries_ creator
	* @throws PortalException if a lectureseries_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Creator getLectureseries_Creator(
		long lectureseriesCreatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.getLectureseries_Creator(lectureseriesCreatorId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> getLectureseries_Creators(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.getLectureseries_Creators(start,
			end);
	}

	/**
	* Returns the number of lectureseries_ creators.
	*
	* @return the number of lectureseries_ creators
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLectureseries_CreatorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.getLectureseries_CreatorsCount();
	}

	/**
	* Updates the lectureseries_ creator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lectureseries_Creator the lectureseries_ creator
	* @return the lectureseries_ creator that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Creator updateLectureseries_Creator(
		de.uhh.l2g.plugins.model.Lectureseries_Creator lectureseries_Creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.updateLectureseries_Creator(lectureseries_Creator);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _lectureseries_CreatorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lectureseries_CreatorLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lectureseries_CreatorLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void removeByLectureseriesId(java.lang.Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lectureseries_CreatorLocalService.removeByLectureseriesId(lectureseriesId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> getByCreatorId(
		java.lang.Long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.getByCreatorId(creatorId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> getByLectureseriesId(
		java.lang.Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.getByLectureseriesId(lectureseriesId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> getByLectureseriesIdAndCreatorId(
		java.lang.Long lectureseriesId, java.lang.Long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.getByLectureseriesIdAndCreatorId(lectureseriesId,
			creatorId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Creator> getByCreator(
		java.lang.Long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lectureseries_CreatorLocalService.getByCreator(creatorId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Lectureseries_CreatorLocalService getWrappedLectureseries_CreatorLocalService() {
		return _lectureseries_CreatorLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLectureseries_CreatorLocalService(
		Lectureseries_CreatorLocalService lectureseries_CreatorLocalService) {
		_lectureseries_CreatorLocalService = lectureseries_CreatorLocalService;
	}

	@Override
	public Lectureseries_CreatorLocalService getWrappedService() {
		return _lectureseries_CreatorLocalService;
	}

	@Override
	public void setWrappedService(
		Lectureseries_CreatorLocalService lectureseries_CreatorLocalService) {
		_lectureseries_CreatorLocalService = lectureseries_CreatorLocalService;
	}

	private Lectureseries_CreatorLocalService _lectureseries_CreatorLocalService;
}