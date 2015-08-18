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

package de.uhh.l2g.plugins.migration.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LegacyLectureSeriesLocalService}.
 *
 * @author unihh
 * @see LegacyLectureSeriesLocalService
 * @generated
 */
public class LegacyLectureSeriesLocalServiceWrapper
	implements LegacyLectureSeriesLocalService,
		ServiceWrapper<LegacyLectureSeriesLocalService> {
	public LegacyLectureSeriesLocalServiceWrapper(
		LegacyLectureSeriesLocalService legacyLectureSeriesLocalService) {
		_legacyLectureSeriesLocalService = legacyLectureSeriesLocalService;
	}

	/**
	* Adds the legacy lecture series to the database. Also notifies the appropriate model listeners.
	*
	* @param legacyLectureSeries the legacy lecture series
	* @return the legacy lecture series that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries addLegacyLectureSeries(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeries legacyLectureSeries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesLocalService.addLegacyLectureSeries(legacyLectureSeries);
	}

	/**
	* Creates a new legacy lecture series with the primary key. Does not add the legacy lecture series to the database.
	*
	* @param id the primary key for the new legacy lecture series
	* @return the new legacy lecture series
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries createLegacyLectureSeries(
		long id) {
		return _legacyLectureSeriesLocalService.createLegacyLectureSeries(id);
	}

	/**
	* Deletes the legacy lecture series with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy lecture series
	* @return the legacy lecture series that was removed
	* @throws PortalException if a legacy lecture series with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries deleteLegacyLectureSeries(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesLocalService.deleteLegacyLectureSeries(id);
	}

	/**
	* Deletes the legacy lecture series from the database. Also notifies the appropriate model listeners.
	*
	* @param legacyLectureSeries the legacy lecture series
	* @return the legacy lecture series that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries deleteLegacyLectureSeries(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeries legacyLectureSeries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesLocalService.deleteLegacyLectureSeries(legacyLectureSeries);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legacyLectureSeriesLocalService.dynamicQuery();
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
		return _legacyLectureSeriesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyLectureSeriesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _legacyLectureSeriesLocalService.dynamicQuery(dynamicQuery,
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
		return _legacyLectureSeriesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _legacyLectureSeriesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries fetchLegacyLectureSeries(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesLocalService.fetchLegacyLectureSeries(id);
	}

	/**
	* Returns the legacy lecture series with the primary key.
	*
	* @param id the primary key of the legacy lecture series
	* @return the legacy lecture series
	* @throws PortalException if a legacy lecture series with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries getLegacyLectureSeries(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesLocalService.getLegacyLectureSeries(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legacy lecture serieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy lecture serieses
	* @param end the upper bound of the range of legacy lecture serieses (not inclusive)
	* @return the range of legacy lecture serieses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyLectureSeries> getLegacyLectureSerieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesLocalService.getLegacyLectureSerieses(start,
			end);
	}

	/**
	* Returns the number of legacy lecture serieses.
	*
	* @return the number of legacy lecture serieses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLegacyLectureSeriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesLocalService.getLegacyLectureSeriesesCount();
	}

	/**
	* Updates the legacy lecture series in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legacyLectureSeries the legacy lecture series
	* @return the legacy lecture series that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyLectureSeries updateLegacyLectureSeries(
		de.uhh.l2g.plugins.migration.model.LegacyLectureSeries legacyLectureSeries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legacyLectureSeriesLocalService.updateLegacyLectureSeries(legacyLectureSeries);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _legacyLectureSeriesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legacyLectureSeriesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legacyLectureSeriesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LegacyLectureSeriesLocalService getWrappedLegacyLectureSeriesLocalService() {
		return _legacyLectureSeriesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLegacyLectureSeriesLocalService(
		LegacyLectureSeriesLocalService legacyLectureSeriesLocalService) {
		_legacyLectureSeriesLocalService = legacyLectureSeriesLocalService;
	}

	@Override
	public LegacyLectureSeriesLocalService getWrappedService() {
		return _legacyLectureSeriesLocalService;
	}

	@Override
	public void setWrappedService(
		LegacyLectureSeriesLocalService legacyLectureSeriesLocalService) {
		_legacyLectureSeriesLocalService = legacyLectureSeriesLocalService;
	}

	private LegacyLectureSeriesLocalService _legacyLectureSeriesLocalService;
}