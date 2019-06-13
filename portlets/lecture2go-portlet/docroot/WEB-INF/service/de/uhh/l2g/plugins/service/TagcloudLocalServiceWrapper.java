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
 * Provides a wrapper for {@link TagcloudLocalService}.
 *
 * @author Iavor Sturm
 * @see TagcloudLocalService
 * @generated
 */
public class TagcloudLocalServiceWrapper implements TagcloudLocalService,
	ServiceWrapper<TagcloudLocalService> {
	public TagcloudLocalServiceWrapper(
		TagcloudLocalService tagcloudLocalService) {
		_tagcloudLocalService = tagcloudLocalService;
	}

	/**
	* Adds the tagcloud to the database. Also notifies the appropriate model listeners.
	*
	* @param tagcloud the tagcloud
	* @return the tagcloud that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Tagcloud addTagcloud(
		de.uhh.l2g.plugins.model.Tagcloud tagcloud)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagcloudLocalService.addTagcloud(tagcloud);
	}

	/**
	* Creates a new tagcloud with the primary key. Does not add the tagcloud to the database.
	*
	* @param tagcloudId the primary key for the new tagcloud
	* @return the new tagcloud
	*/
	@Override
	public de.uhh.l2g.plugins.model.Tagcloud createTagcloud(long tagcloudId) {
		return _tagcloudLocalService.createTagcloud(tagcloudId);
	}

	/**
	* Deletes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud that was removed
	* @throws PortalException if a tagcloud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Tagcloud deleteTagcloud(long tagcloudId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tagcloudLocalService.deleteTagcloud(tagcloudId);
	}

	/**
	* Deletes the tagcloud from the database. Also notifies the appropriate model listeners.
	*
	* @param tagcloud the tagcloud
	* @return the tagcloud that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Tagcloud deleteTagcloud(
		de.uhh.l2g.plugins.model.Tagcloud tagcloud)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagcloudLocalService.deleteTagcloud(tagcloud);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tagcloudLocalService.dynamicQuery();
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
		return _tagcloudLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tagcloudLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tagcloudLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _tagcloudLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tagcloudLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Tagcloud fetchTagcloud(long tagcloudId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagcloudLocalService.fetchTagcloud(tagcloudId);
	}

	/**
	* Returns the tagcloud with the primary key.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud
	* @throws PortalException if a tagcloud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Tagcloud getTagcloud(long tagcloudId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tagcloudLocalService.getTagcloud(tagcloudId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tagcloudLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tagclouds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @return the range of tagclouds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> getTagclouds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagcloudLocalService.getTagclouds(start, end);
	}

	/**
	* Returns the number of tagclouds.
	*
	* @return the number of tagclouds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTagcloudsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagcloudLocalService.getTagcloudsCount();
	}

	/**
	* Updates the tagcloud in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tagcloud the tagcloud
	* @return the tagcloud that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Tagcloud updateTagcloud(
		de.uhh.l2g.plugins.model.Tagcloud tagcloud)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagcloudLocalService.updateTagcloud(tagcloud);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tagcloudLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tagcloudLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tagcloudLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void deleteByObjectId(long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tagcloudLocalService.deleteByObjectId(objectId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Tagcloud getByObjectIdAndObjectClassType(
		long objectId, java.lang.String objectClassType)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchTagcloudException {
		return _tagcloudLocalService.getByObjectIdAndObjectClassType(objectId,
			objectClassType);
	}

	@Override
	public void add(java.util.ArrayList<java.lang.String> tagCloudArrayString,
		java.lang.String className, java.lang.Long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tagcloudLocalService.add(tagCloudArrayString, className, objectId);
	}

	@Override
	public void updateByObjectIdAndObjectClassType(
		java.util.ArrayList<java.lang.String> tagCloudArrayString,
		java.lang.String className, long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tagcloudLocalService.updateByObjectIdAndObjectClassType(tagCloudArrayString,
			className, objectId);
	}

	@Override
	public void generateForAllLectureseries() {
		_tagcloudLocalService.generateForAllLectureseries();
	}

	@Override
	public void generateForAllVideos() {
		_tagcloudLocalService.generateForAllVideos();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TagcloudLocalService getWrappedTagcloudLocalService() {
		return _tagcloudLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTagcloudLocalService(
		TagcloudLocalService tagcloudLocalService) {
		_tagcloudLocalService = tagcloudLocalService;
	}

	@Override
	public TagcloudLocalService getWrappedService() {
		return _tagcloudLocalService;
	}

	@Override
	public void setWrappedService(TagcloudLocalService tagcloudLocalService) {
		_tagcloudLocalService = tagcloudLocalService;
	}

	private TagcloudLocalService _tagcloudLocalService;
}