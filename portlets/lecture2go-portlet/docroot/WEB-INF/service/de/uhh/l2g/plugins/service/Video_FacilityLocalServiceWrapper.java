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

package de.uhh.l2g.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Video_FacilityLocalService}.
 *
 * @author Iavor Sturm
 * @see Video_FacilityLocalService
 * @generated
 */
public class Video_FacilityLocalServiceWrapper
	implements Video_FacilityLocalService,
		ServiceWrapper<Video_FacilityLocalService> {
	public Video_FacilityLocalServiceWrapper(
		Video_FacilityLocalService video_FacilityLocalService) {
		_video_FacilityLocalService = video_FacilityLocalService;
	}

	/**
	* Adds the video_ facility to the database. Also notifies the appropriate model listeners.
	*
	* @param video_Facility the video_ facility
	* @return the video_ facility that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Facility addVideo_Facility(
		de.uhh.l2g.plugins.model.Video_Facility video_Facility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_FacilityLocalService.addVideo_Facility(video_Facility);
	}

	/**
	* Creates a new video_ facility with the primary key. Does not add the video_ facility to the database.
	*
	* @param videoFacilityId the primary key for the new video_ facility
	* @return the new video_ facility
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Facility createVideo_Facility(
		long videoFacilityId) {
		return _video_FacilityLocalService.createVideo_Facility(videoFacilityId);
	}

	/**
	* Deletes the video_ facility with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoFacilityId the primary key of the video_ facility
	* @return the video_ facility that was removed
	* @throws PortalException if a video_ facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Facility deleteVideo_Facility(
		long videoFacilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _video_FacilityLocalService.deleteVideo_Facility(videoFacilityId);
	}

	/**
	* Deletes the video_ facility from the database. Also notifies the appropriate model listeners.
	*
	* @param video_Facility the video_ facility
	* @return the video_ facility that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Facility deleteVideo_Facility(
		de.uhh.l2g.plugins.model.Video_Facility video_Facility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_FacilityLocalService.deleteVideo_Facility(video_Facility);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _video_FacilityLocalService.dynamicQuery();
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
		return _video_FacilityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _video_FacilityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _video_FacilityLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _video_FacilityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _video_FacilityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Facility fetchVideo_Facility(
		long videoFacilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_FacilityLocalService.fetchVideo_Facility(videoFacilityId);
	}

	/**
	* Returns the video_ facility with the primary key.
	*
	* @param videoFacilityId the primary key of the video_ facility
	* @return the video_ facility
	* @throws PortalException if a video_ facility with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Facility getVideo_Facility(
		long videoFacilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _video_FacilityLocalService.getVideo_Facility(videoFacilityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _video_FacilityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the video_ facilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_FacilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ facilities
	* @param end the upper bound of the range of video_ facilities (not inclusive)
	* @return the range of video_ facilities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Facility> getVideo_Facilities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_FacilityLocalService.getVideo_Facilities(start, end);
	}

	/**
	* Returns the number of video_ facilities.
	*
	* @return the number of video_ facilities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVideo_FacilitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_FacilityLocalService.getVideo_FacilitiesCount();
	}

	/**
	* Updates the video_ facility in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param video_Facility the video_ facility
	* @return the video_ facility that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Facility updateVideo_Facility(
		de.uhh.l2g.plugins.model.Video_Facility video_Facility)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_FacilityLocalService.updateVideo_Facility(video_Facility);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _video_FacilityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_video_FacilityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _video_FacilityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public boolean removeByVideoId(java.lang.Long videoId) {
		return _video_FacilityLocalService.removeByVideoId(videoId);
	}

	@Override
	public boolean removeByFacilityId(java.lang.Long facilityId) {
		return _video_FacilityLocalService.removeByFacilityId(facilityId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Video_FacilityLocalService getWrappedVideo_FacilityLocalService() {
		return _video_FacilityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVideo_FacilityLocalService(
		Video_FacilityLocalService video_FacilityLocalService) {
		_video_FacilityLocalService = video_FacilityLocalService;
	}

	@Override
	public Video_FacilityLocalService getWrappedService() {
		return _video_FacilityLocalService;
	}

	@Override
	public void setWrappedService(
		Video_FacilityLocalService video_FacilityLocalService) {
		_video_FacilityLocalService = video_FacilityLocalService;
	}

	private Video_FacilityLocalService _video_FacilityLocalService;
}