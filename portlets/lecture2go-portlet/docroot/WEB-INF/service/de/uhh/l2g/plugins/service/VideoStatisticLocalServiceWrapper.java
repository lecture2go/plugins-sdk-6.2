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
 * Provides a wrapper for {@link VideoStatisticLocalService}.
 *
 * @author Iavor Sturm
 * @see VideoStatisticLocalService
 * @generated
 */
public class VideoStatisticLocalServiceWrapper
	implements VideoStatisticLocalService,
		ServiceWrapper<VideoStatisticLocalService> {
	public VideoStatisticLocalServiceWrapper(
		VideoStatisticLocalService videoStatisticLocalService) {
		_videoStatisticLocalService = videoStatisticLocalService;
	}

	/**
	* Adds the video statistic to the database. Also notifies the appropriate model listeners.
	*
	* @param videoStatistic the video statistic
	* @return the video statistic that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic addVideoStatistic(
		de.uhh.l2g.plugins.model.VideoStatistic videoStatistic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.addVideoStatistic(videoStatistic);
	}

	/**
	* Creates a new video statistic with the primary key. Does not add the video statistic to the database.
	*
	* @param videoStatisticId the primary key for the new video statistic
	* @return the new video statistic
	*/
	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic createVideoStatistic(
		long videoStatisticId) {
		return _videoStatisticLocalService.createVideoStatistic(videoStatisticId);
	}

	/**
	* Deletes the video statistic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic that was removed
	* @throws PortalException if a video statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic deleteVideoStatistic(
		long videoStatisticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.deleteVideoStatistic(videoStatisticId);
	}

	/**
	* Deletes the video statistic from the database. Also notifies the appropriate model listeners.
	*
	* @param videoStatistic the video statistic
	* @return the video statistic that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic deleteVideoStatistic(
		de.uhh.l2g.plugins.model.VideoStatistic videoStatistic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.deleteVideoStatistic(videoStatistic);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _videoStatisticLocalService.dynamicQuery();
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
		return _videoStatisticLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _videoStatisticLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _videoStatisticLocalService.dynamicQuery(dynamicQuery, start,
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
		return _videoStatisticLocalService.dynamicQueryCount(dynamicQuery);
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
		return _videoStatisticLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic fetchVideoStatistic(
		long videoStatisticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.fetchVideoStatistic(videoStatisticId);
	}

	/**
	* Returns the video statistic with the primary key.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic
	* @throws PortalException if a video statistic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic getVideoStatistic(
		long videoStatisticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.getVideoStatistic(videoStatisticId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the video statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of video statistics
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> getVideoStatistics(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.getVideoStatistics(start, end);
	}

	/**
	* Returns the number of video statistics.
	*
	* @return the number of video statistics
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVideoStatisticsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.getVideoStatisticsCount();
	}

	/**
	* Updates the video statistic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoStatistic the video statistic
	* @return the video statistic that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic updateVideoStatistic(
		de.uhh.l2g.plugins.model.VideoStatistic videoStatistic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.updateVideoStatistic(videoStatistic);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _videoStatisticLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_videoStatisticLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _videoStatisticLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> getByCompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.getByCompanyIdAndGroupId(companyId,
			groupId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> getAllStatistics()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.getAllStatistics();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VideoStatisticLocalService getWrappedVideoStatisticLocalService() {
		return _videoStatisticLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVideoStatisticLocalService(
		VideoStatisticLocalService videoStatisticLocalService) {
		_videoStatisticLocalService = videoStatisticLocalService;
	}

	@Override
	public VideoStatisticLocalService getWrappedService() {
		return _videoStatisticLocalService;
	}

	@Override
	public void setWrappedService(
		VideoStatisticLocalService videoStatisticLocalService) {
		_videoStatisticLocalService = videoStatisticLocalService;
	}

	private VideoStatisticLocalService _videoStatisticLocalService;
}