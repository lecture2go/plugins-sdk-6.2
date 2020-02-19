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
 * Provides a wrapper for {@link OaiRecordLocalService}.
 *
 * @author Iavor Sturm
 * @see OaiRecordLocalService
 * @generated
 */
public class OaiRecordLocalServiceWrapper implements OaiRecordLocalService,
	ServiceWrapper<OaiRecordLocalService> {
	public OaiRecordLocalServiceWrapper(
		OaiRecordLocalService oaiRecordLocalService) {
		_oaiRecordLocalService = oaiRecordLocalService;
	}

	/**
	* Adds the oai record to the database. Also notifies the appropriate model listeners.
	*
	* @param oaiRecord the oai record
	* @return the oai record that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.OaiRecord addOaiRecord(
		de.uhh.l2g.plugins.model.OaiRecord oaiRecord)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oaiRecordLocalService.addOaiRecord(oaiRecord);
	}

	/**
	* Creates a new oai record with the primary key. Does not add the oai record to the database.
	*
	* @param oaiRecordId the primary key for the new oai record
	* @return the new oai record
	*/
	@Override
	public de.uhh.l2g.plugins.model.OaiRecord createOaiRecord(long oaiRecordId) {
		return _oaiRecordLocalService.createOaiRecord(oaiRecordId);
	}

	/**
	* Deletes the oai record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oaiRecordId the primary key of the oai record
	* @return the oai record that was removed
	* @throws PortalException if a oai record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.OaiRecord deleteOaiRecord(long oaiRecordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oaiRecordLocalService.deleteOaiRecord(oaiRecordId);
	}

	/**
	* Deletes the oai record from the database. Also notifies the appropriate model listeners.
	*
	* @param oaiRecord the oai record
	* @return the oai record that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.OaiRecord deleteOaiRecord(
		de.uhh.l2g.plugins.model.OaiRecord oaiRecord)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oaiRecordLocalService.deleteOaiRecord(oaiRecord);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _oaiRecordLocalService.dynamicQuery();
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
		return _oaiRecordLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _oaiRecordLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _oaiRecordLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _oaiRecordLocalService.dynamicQueryCount(dynamicQuery);
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
		return _oaiRecordLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.OaiRecord fetchOaiRecord(long oaiRecordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oaiRecordLocalService.fetchOaiRecord(oaiRecordId);
	}

	/**
	* Returns the oai record with the primary key.
	*
	* @param oaiRecordId the primary key of the oai record
	* @return the oai record
	* @throws PortalException if a oai record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.OaiRecord getOaiRecord(long oaiRecordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oaiRecordLocalService.getOaiRecord(oaiRecordId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oaiRecordLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord> getOaiRecords(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oaiRecordLocalService.getOaiRecords(start, end);
	}

	/**
	* Returns the number of oai records.
	*
	* @return the number of oai records
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOaiRecordsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oaiRecordLocalService.getOaiRecordsCount();
	}

	/**
	* Updates the oai record in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oaiRecord the oai record
	* @return the oai record that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.OaiRecord updateOaiRecord(
		de.uhh.l2g.plugins.model.OaiRecord oaiRecord)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oaiRecordLocalService.updateOaiRecord(oaiRecord);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _oaiRecordLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_oaiRecordLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _oaiRecordLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public de.uhh.l2g.plugins.model.OaiRecord getByVideo(java.lang.Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecordException {
		return _oaiRecordLocalService.getByVideo(videoId);
	}

	@Override
	public de.uhh.l2g.plugins.model.OaiRecord getByIdentifier(
		java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecordException {
		return _oaiRecordLocalService.getByIdentifier(identifier);
	}

	@Override
	public java.util.Date getEarliestDatestamp() {
		return _oaiRecordLocalService.getEarliestDatestamp();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord> getByCreator(
		java.lang.Long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecordException {
		return _oaiRecordLocalService.getByCreator(creatorId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord> getByCategory(
		java.lang.Long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecordException {
		return _oaiRecordLocalService.getByCategory(categoryId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord> getByLectureseries(
		java.lang.Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchOaiRecordException {
		return _oaiRecordLocalService.getByLectureseries(lectureseriesId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OaiRecordLocalService getWrappedOaiRecordLocalService() {
		return _oaiRecordLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOaiRecordLocalService(
		OaiRecordLocalService oaiRecordLocalService) {
		_oaiRecordLocalService = oaiRecordLocalService;
	}

	@Override
	public OaiRecordLocalService getWrappedService() {
		return _oaiRecordLocalService;
	}

	@Override
	public void setWrappedService(OaiRecordLocalService oaiRecordLocalService) {
		_oaiRecordLocalService = oaiRecordLocalService;
	}

	private OaiRecordLocalService _oaiRecordLocalService;
}