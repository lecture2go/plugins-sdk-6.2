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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Segment_User_Video. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.Segment_User_VideoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see Segment_User_VideoLocalService
 * @see de.uhh.l2g.plugins.service.base.Segment_User_VideoLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.Segment_User_VideoLocalServiceImpl
 * @generated
 */
public class Segment_User_VideoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.Segment_User_VideoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the segment_ user_ video to the database. Also notifies the appropriate model listeners.
	*
	* @param segment_User_Video the segment_ user_ video
	* @return the segment_ user_ video that was added
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video addSegment_User_Video(
		de.uhh.l2g.plugins.model.Segment_User_Video segment_User_Video)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSegment_User_Video(segment_User_Video);
	}

	/**
	* Creates a new segment_ user_ video with the primary key. Does not add the segment_ user_ video to the database.
	*
	* @param segmentUserVideoId the primary key for the new segment_ user_ video
	* @return the new segment_ user_ video
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video createSegment_User_Video(
		long segmentUserVideoId) {
		return getService().createSegment_User_Video(segmentUserVideoId);
	}

	/**
	* Deletes the segment_ user_ video with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param segmentUserVideoId the primary key of the segment_ user_ video
	* @return the segment_ user_ video that was removed
	* @throws PortalException if a segment_ user_ video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video deleteSegment_User_Video(
		long segmentUserVideoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSegment_User_Video(segmentUserVideoId);
	}

	/**
	* Deletes the segment_ user_ video from the database. Also notifies the appropriate model listeners.
	*
	* @param segment_User_Video the segment_ user_ video
	* @return the segment_ user_ video that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video deleteSegment_User_Video(
		de.uhh.l2g.plugins.model.Segment_User_Video segment_User_Video)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSegment_User_Video(segment_User_Video);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Segment_User_VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Segment_User_VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.Segment_User_Video fetchSegment_User_Video(
		long segmentUserVideoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSegment_User_Video(segmentUserVideoId);
	}

	/**
	* Returns the segment_ user_ video with the primary key.
	*
	* @param segmentUserVideoId the primary key of the segment_ user_ video
	* @return the segment_ user_ video
	* @throws PortalException if a segment_ user_ video with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video getSegment_User_Video(
		long segmentUserVideoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSegment_User_Video(segmentUserVideoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the segment_ user_ videos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Segment_User_VideoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segment_ user_ videos
	* @param end the upper bound of the range of segment_ user_ videos (not inclusive)
	* @return the range of segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Segment_User_Video> getSegment_User_Videos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSegment_User_Videos(start, end);
	}

	/**
	* Returns the number of segment_ user_ videos.
	*
	* @return the number of segment_ user_ videos
	* @throws SystemException if a system exception occurred
	*/
	public static int getSegment_User_VideosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSegment_User_VideosCount();
	}

	/**
	* Updates the segment_ user_ video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param segment_User_Video the segment_ user_ video
	* @return the segment_ user_ video that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static de.uhh.l2g.plugins.model.Segment_User_Video updateSegment_User_Video(
		de.uhh.l2g.plugins.model.Segment_User_Video segment_User_Video)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSegment_User_Video(segment_User_Video);
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

	public static void deleteByVideoId(java.lang.Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteByVideoId(videoId);
	}

	public static void clearService() {
		_service = null;
	}

	public static Segment_User_VideoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					Segment_User_VideoLocalService.class.getName());

			if (invokableLocalService instanceof Segment_User_VideoLocalService) {
				_service = (Segment_User_VideoLocalService)invokableLocalService;
			}
			else {
				_service = new Segment_User_VideoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(Segment_User_VideoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(Segment_User_VideoLocalService service) {
	}

	private static Segment_User_VideoLocalService _service;
}