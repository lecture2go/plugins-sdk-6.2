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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Creator. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.CreatorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see CreatorLocalService
 * @see de.uhh.l2g.plugins.service.base.CreatorLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.CreatorLocalServiceImpl
 * @generated
 */
public class CreatorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.CreatorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the creator to the database. Also notifies the appropriate model listeners.
	*
	* @param creator the creator
	* @return the creator that was added
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Creator addCreator(
		de.uhh.l2g.plugins.model.Creator creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCreator(creator);
	}

	/**
	* Creates a new creator with the primary key. Does not add the creator to the database.
	*
	* @param creatorId the primary key for the new creator
	* @return the new creator
	*/
	public static de.uhh.l2g.plugins.model.Creator createCreator(long creatorId) {
		return getService().createCreator(creatorId);
	}

	/**
	* Deletes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param creatorId the primary key of the creator
	* @return the creator that was removed
	* @throws PortalException if a creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Creator deleteCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCreator(creatorId);
	}

	/**
	* Deletes the creator from the database. Also notifies the appropriate model listeners.
	*
	* @param creator the creator
	* @return the creator that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Creator deleteCreator(
		de.uhh.l2g.plugins.model.Creator creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCreator(creator);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static de.uhh.l2g.plugins.model.Creator fetchCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCreator(creatorId);
	}

	/**
	* Returns the creator with the primary key.
	*
	* @param creatorId the primary key of the creator
	* @return the creator
	* @throws PortalException if a creator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Creator getCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCreator(creatorId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the creators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of creators
	* @param end the upper bound of the range of creators (not inclusive)
	* @return the range of creators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreators(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCreators(start, end);
	}

	/**
	* Returns the number of creators.
	*
	* @return the number of creators
	* @throws SystemException if a system exception occurred
	*/
	public static int getCreatorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCreatorsCount();
	}

	/**
	* Updates the creator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param creator the creator
	* @return the creator that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Creator updateCreator(
		de.uhh.l2g.plugins.model.Creator creator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCreator(creator);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getAllCreators()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCreators();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsByLectureseriesId(
		java.lang.Long lectureseriesId) {
		return getService().getCreatorsByLectureseriesId(lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsByLectureseriesIdForOpenAccessVideosOnly(
		java.lang.Long lectureseriesId) {
		return getService()
				   .getCreatorsByLectureseriesIdForOpenAccessVideosOnly(lectureseriesId);
	}

	public static java.lang.String getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(
		java.lang.Long lectureseriesId, int maxCreators) {
		return getService()
				   .getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(lectureseriesId,
			maxCreators);
	}

	public static java.lang.String getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators(
		java.lang.Long lectureseriesId, int maxCreators) {
		return getService()
				   .getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators(lectureseriesId,
			maxCreators);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsByVideoId(
		java.lang.Long videoId) {
		return getService().getCreatorsByVideoId(videoId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsForLectureseriesOverTheAssigenedVideos(
		java.lang.Long lectureseriesId) {
		return getService()
				   .getCreatorsForLectureseriesOverTheAssigenedVideos(lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(
		java.lang.Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(lectureseriesId);
	}

	public static void updateAllCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId() {
		getService()
			.updateAllCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId();
	}

	public static java.lang.String getCommaSeparatedCreatorsByVideoIdAndMaxCreators(
		java.lang.Long videoId, int maxCreators) {
		return getService()
				   .getCommaSeparatedCreatorsByVideoIdAndMaxCreators(videoId,
			maxCreators);
	}

	public static java.lang.String getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(
		java.lang.Long videoId, int maxCreators) {
		return getService()
				   .getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(videoId,
			maxCreators);
	}

	public static org.json.JSONArray getJSONCreatorsByVideoId(
		java.lang.Long videoId) {
		return getService().getJSONCreatorsByVideoId(videoId);
	}

	public static org.json.JSONArray getJSONCreatorsByLectureseriesId(
		java.lang.Long lectureseriesId) {
		return getService().getJSONCreatorsByLectureseriesId(lectureseriesId);
	}

	public static org.json.JSONArray getJSONCreator(java.lang.Long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getJSONCreator(creatorId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getByFullName(
		java.lang.String fullName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByFullName(fullName);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreatorsFromLectureseriesIdsAndVideoIds(
		java.util.ArrayList<java.lang.Long> lectureseriesIds,
		java.util.ArrayList<java.lang.Long> videoIds) {
		return getService()
				   .getCreatorsFromLectureseriesIdsAndVideoIds(lectureseriesIds,
			videoIds);
	}

	public static void deleteById(java.lang.Long id)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteById(id);
	}

	public static void clearService() {
		_service = null;
	}

	public static CreatorLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CreatorLocalService.class.getName());

			if (invokableLocalService instanceof CreatorLocalService) {
				_service = (CreatorLocalService)invokableLocalService;
			}
			else {
				_service = new CreatorLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CreatorLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CreatorLocalService service) {
	}

	private static CreatorLocalService _service;
}