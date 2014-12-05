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
 * Provides a wrapper for {@link Video_InstitutionLocalService}.
 *
 * @author Iavor Sturm
 * @see Video_InstitutionLocalService
 * @generated
 */
public class Video_InstitutionLocalServiceWrapper
	implements Video_InstitutionLocalService,
		ServiceWrapper<Video_InstitutionLocalService> {
	public Video_InstitutionLocalServiceWrapper(
		Video_InstitutionLocalService video_InstitutionLocalService) {
		_video_InstitutionLocalService = video_InstitutionLocalService;
	}

	/**
	* Adds the video_ institution to the database. Also notifies the appropriate model listeners.
	*
	* @param video_Institution the video_ institution
	* @return the video_ institution that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Institution addVideo_Institution(
		de.uhh.l2g.plugins.model.Video_Institution video_Institution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_InstitutionLocalService.addVideo_Institution(video_Institution);
	}

	/**
	* Creates a new video_ institution with the primary key. Does not add the video_ institution to the database.
	*
	* @param videoInstitutionId the primary key for the new video_ institution
	* @return the new video_ institution
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Institution createVideo_Institution(
		long videoInstitutionId) {
		return _video_InstitutionLocalService.createVideo_Institution(videoInstitutionId);
	}

	/**
	* Deletes the video_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoInstitutionId the primary key of the video_ institution
	* @return the video_ institution that was removed
	* @throws PortalException if a video_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Institution deleteVideo_Institution(
		long videoInstitutionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _video_InstitutionLocalService.deleteVideo_Institution(videoInstitutionId);
	}

	/**
	* Deletes the video_ institution from the database. Also notifies the appropriate model listeners.
	*
	* @param video_Institution the video_ institution
	* @return the video_ institution that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Institution deleteVideo_Institution(
		de.uhh.l2g.plugins.model.Video_Institution video_Institution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_InstitutionLocalService.deleteVideo_Institution(video_Institution);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _video_InstitutionLocalService.dynamicQuery();
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
		return _video_InstitutionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _video_InstitutionLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _video_InstitutionLocalService.dynamicQuery(dynamicQuery, start,
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
		return _video_InstitutionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _video_InstitutionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Institution fetchVideo_Institution(
		long videoInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_InstitutionLocalService.fetchVideo_Institution(videoInstitutionId);
	}

	/**
	* Returns the video_ institution with the primary key.
	*
	* @param videoInstitutionId the primary key of the video_ institution
	* @return the video_ institution
	* @throws PortalException if a video_ institution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Institution getVideo_Institution(
		long videoInstitutionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _video_InstitutionLocalService.getVideo_Institution(videoInstitutionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _video_InstitutionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the video_ institutions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video_ institutions
	* @param end the upper bound of the range of video_ institutions (not inclusive)
	* @return the range of video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Institution> getVideo_Institutions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_InstitutionLocalService.getVideo_Institutions(start, end);
	}

	/**
	* Returns the number of video_ institutions.
	*
	* @return the number of video_ institutions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVideo_InstitutionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_InstitutionLocalService.getVideo_InstitutionsCount();
	}

	/**
	* Updates the video_ institution in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param video_Institution the video_ institution
	* @return the video_ institution that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Video_Institution updateVideo_Institution(
		de.uhh.l2g.plugins.model.Video_Institution video_Institution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _video_InstitutionLocalService.updateVideo_Institution(video_Institution);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _video_InstitutionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_video_InstitutionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _video_InstitutionLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public boolean removeByVideoId(java.lang.Long videoId) {
		return _video_InstitutionLocalService.removeByVideoId(videoId);
	}

	@Override
	public boolean removeByInstitutionId(java.lang.Long facilityId) {
		return _video_InstitutionLocalService.removeByInstitutionId(facilityId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Institution> getByVideo(
		java.lang.Long videoId) {
		return _video_InstitutionLocalService.getByVideo(videoId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Institution> getByInstitution(
		java.lang.Long institutionId) {
		return _video_InstitutionLocalService.getByInstitution(institutionId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Video_InstitutionLocalService getWrappedVideo_InstitutionLocalService() {
		return _video_InstitutionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVideo_InstitutionLocalService(
		Video_InstitutionLocalService video_InstitutionLocalService) {
		_video_InstitutionLocalService = video_InstitutionLocalService;
	}

	@Override
	public Video_InstitutionLocalService getWrappedService() {
		return _video_InstitutionLocalService;
	}

	@Override
	public void setWrappedService(
		Video_InstitutionLocalService video_InstitutionLocalService) {
		_video_InstitutionLocalService = video_InstitutionLocalService;
	}

	private Video_InstitutionLocalService _video_InstitutionLocalService;
}