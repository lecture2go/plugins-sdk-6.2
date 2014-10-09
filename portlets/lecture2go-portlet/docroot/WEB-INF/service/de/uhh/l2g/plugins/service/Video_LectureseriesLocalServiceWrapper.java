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
 * Provides a wrapper for {@link Video_LectureseriesLocalService}.
 *
 * @author Iavor Sturm
 * @see Video_LectureseriesLocalService
 * @generated
 */
public class Video_LectureseriesLocalServiceWrapper
	implements Video_LectureseriesLocalService,
		ServiceWrapper<Video_LectureseriesLocalService> {
	public Video_LectureseriesLocalServiceWrapper(
		Video_LectureseriesLocalService video_LectureseriesLocalService) {
		_video_LectureseriesLocalService = video_LectureseriesLocalService;
	}

	/**
	* Adds the video_ lectureseries to the database. Also notifies the appropriate model listeners.
	*
	* @param video_Lectureseries the video_ lectureseries
	* @return the video_ lectureseries that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Lectureseries addVideo_Lectureseries(
		de.uhh.l2g.plugins.model.Video_Lectureseries video_Lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_LectureseriesLocalService.addVideo_Lectureseries(video_Lectureseries);
	}

	/**
	* Creates a new video_ lectureseries with the primary key. Does not add the video_ lectureseries to the database.
	*
	* @param videoLectureseriesId the primary key for the new video_ lectureseries
	* @return the new video_ lectureseries
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Lectureseries createVideo_Lectureseries(
		long videoLectureseriesId) {
		return _video_LectureseriesLocalService.createVideo_Lectureseries(videoLectureseriesId);
	}

	/**
	* Deletes the video_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoLectureseriesId the primary key of the video_ lectureseries
	* @return the video_ lectureseries that was removed
	* @throws PortalException if a video_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Lectureseries deleteVideo_Lectureseries(
		long videoLectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _video_LectureseriesLocalService.deleteVideo_Lectureseries(videoLectureseriesId);
	}

	/**
	* Deletes the video_ lectureseries from the database. Also notifies the appropriate model listeners.
	*
	* @param video_Lectureseries the video_ lectureseries
	* @return the video_ lectureseries that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Lectureseries deleteVideo_Lectureseries(
		de.uhh.l2g.plugins.model.Video_Lectureseries video_Lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_LectureseriesLocalService.deleteVideo_Lectureseries(video_Lectureseries);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _video_LectureseriesLocalService.dynamicQuery();
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
		return _video_LectureseriesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _video_LectureseriesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _video_LectureseriesLocalService.dynamicQuery(dynamicQuery,
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
		return _video_LectureseriesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _video_LectureseriesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Lectureseries fetchVideo_Lectureseries(
		long videoLectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_LectureseriesLocalService.fetchVideo_Lectureseries(videoLectureseriesId);
	}

	/**
	* Returns the video_ lectureseries with the primary key.
	*
	* @param videoLectureseriesId the primary key of the video_ lectureseries
	* @return the video_ lectureseries
	* @throws PortalException if a video_ lectureseries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Lectureseries getVideo_Lectureseries(
		long videoLectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _video_LectureseriesLocalService.getVideo_Lectureseries(videoLectureseriesId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _video_LectureseriesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the video_ lectureserieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ lectureserieses
	* @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	* @return the range of video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries> getVideo_Lectureserieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_LectureseriesLocalService.getVideo_Lectureserieses(start,
			end);
	}

	/**
	* Returns the number of video_ lectureserieses.
	*
	* @return the number of video_ lectureserieses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVideo_LectureseriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_LectureseriesLocalService.getVideo_LectureseriesesCount();
	}

	/**
	* Updates the video_ lectureseries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param video_Lectureseries the video_ lectureseries
	* @return the video_ lectureseries that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Lectureseries updateVideo_Lectureseries(
		de.uhh.l2g.plugins.model.Video_Lectureseries video_Lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_LectureseriesLocalService.updateVideo_Lectureseries(video_Lectureseries);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _video_LectureseriesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_video_LectureseriesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _video_LectureseriesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public boolean removeByLectureseriesId(java.lang.Long lectureseriesId) {
		return _video_LectureseriesLocalService.removeByLectureseriesId(lectureseriesId);
	}

	@Override
	public boolean removeByVideoId(java.lang.Long videoId) {
		return _video_LectureseriesLocalService.removeByVideoId(videoId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Video_LectureseriesLocalService getWrappedVideo_LectureseriesLocalService() {
		return _video_LectureseriesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVideo_LectureseriesLocalService(
		Video_LectureseriesLocalService video_LectureseriesLocalService) {
		_video_LectureseriesLocalService = video_LectureseriesLocalService;
	}

	@Override
	public Video_LectureseriesLocalService getWrappedService() {
		return _video_LectureseriesLocalService;
	}

	@Override
	public void setWrappedService(
		Video_LectureseriesLocalService video_LectureseriesLocalService) {
		_video_LectureseriesLocalService = video_LectureseriesLocalService;
	}

	private Video_LectureseriesLocalService _video_LectureseriesLocalService;
}