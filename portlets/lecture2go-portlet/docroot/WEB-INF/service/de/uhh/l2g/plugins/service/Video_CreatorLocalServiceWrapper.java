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
 * Provides a wrapper for {@link Video_CreatorLocalService}.
 *
 * @author Iavor Sturm
 * @see Video_CreatorLocalService
 * @generated
 */
public class Video_CreatorLocalServiceWrapper
	implements Video_CreatorLocalService,
		ServiceWrapper<Video_CreatorLocalService> {
	public Video_CreatorLocalServiceWrapper(
		Video_CreatorLocalService video_CreatorLocalService) {
		_video_CreatorLocalService = video_CreatorLocalService;
	}

	/**
	* Adds the video_ creator to the database. Also notifies the appropriate model listeners.
	*
	* @param video_Creator the video_ creator
	* @return the video_ creator that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Creator addVideo_Creator(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_CreatorLocalService.addVideo_Creator(video_Creator);
	}

	/**
	* Creates a new video_ creator with the primary key. Does not add the video_ creator to the database.
	*
	* @param videoCreatorId the primary key for the new video_ creator
	* @return the new video_ creator
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Creator createVideo_Creator(
		long videoCreatorId) {
		return _video_CreatorLocalService.createVideo_Creator(videoCreatorId);
	}

	/**
	* Deletes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoCreatorId the primary key of the video_ creator
	* @return the video_ creator that was removed
	* @throws PortalException if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Creator deleteVideo_Creator(
		long videoCreatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _video_CreatorLocalService.deleteVideo_Creator(videoCreatorId);
	}

	/**
	* Deletes the video_ creator from the database. Also notifies the appropriate model listeners.
	*
	* @param video_Creator the video_ creator
	* @return the video_ creator that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Creator deleteVideo_Creator(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_CreatorLocalService.deleteVideo_Creator(video_Creator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _video_CreatorLocalService.dynamicQuery();
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
		return _video_CreatorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _video_CreatorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _video_CreatorLocalService.dynamicQuery(dynamicQuery, start,
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
		return _video_CreatorLocalService.dynamicQueryCount(dynamicQuery);
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
		return _video_CreatorLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Creator fetchVideo_Creator(
		long videoCreatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_CreatorLocalService.fetchVideo_Creator(videoCreatorId);
	}

	/**
	* Returns the video_ creator with the primary key.
	*
	* @param videoCreatorId the primary key of the video_ creator
	* @return the video_ creator
	* @throws PortalException if a video_ creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Creator getVideo_Creator(
		long videoCreatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _video_CreatorLocalService.getVideo_Creator(videoCreatorId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _video_CreatorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the video_ creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ creators
	* @param end the upper bound of the range of video_ creators (not inclusive)
	* @return the range of video_ creators
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> getVideo_Creators(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_CreatorLocalService.getVideo_Creators(start, end);
	}

	/**
	* Returns the number of video_ creators.
	*
	* @return the number of video_ creators
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVideo_CreatorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_CreatorLocalService.getVideo_CreatorsCount();
	}

	/**
	* Updates the video_ creator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param video_Creator the video_ creator
	* @return the video_ creator that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Creator updateVideo_Creator(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_CreatorLocalService.updateVideo_Creator(video_Creator);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _video_CreatorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_video_CreatorLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _video_CreatorLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void deleteByVideoId(java.lang.Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_video_CreatorLocalService.deleteByVideoId(videoId);
	}

	@Override
	public void deleteByCreatorId(java.lang.Long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_video_CreatorLocalService.deleteByCreatorId(creatorId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> getByVideoCreator(
		java.lang.Long videoId, java.lang.Long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_CreatorLocalService.getByVideoCreator(videoId, creatorId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Video_CreatorLocalService getWrappedVideo_CreatorLocalService() {
		return _video_CreatorLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVideo_CreatorLocalService(
		Video_CreatorLocalService video_CreatorLocalService) {
		_video_CreatorLocalService = video_CreatorLocalService;
	}

	@Override
	public Video_CreatorLocalService getWrappedService() {
		return _video_CreatorLocalService;
	}

	@Override
	public void setWrappedService(
		Video_CreatorLocalService video_CreatorLocalService) {
		_video_CreatorLocalService = video_CreatorLocalService;
	}

	private Video_CreatorLocalService _video_CreatorLocalService;
}