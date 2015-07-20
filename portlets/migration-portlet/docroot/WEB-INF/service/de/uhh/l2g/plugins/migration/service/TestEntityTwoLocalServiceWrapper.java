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
 * Provides a wrapper for {@link TestEntityTwoLocalService}.
 *
 * @author unihh
 * @see TestEntityTwoLocalService
 * @generated
 */
public class TestEntityTwoLocalServiceWrapper
	implements TestEntityTwoLocalService,
		ServiceWrapper<TestEntityTwoLocalService> {
	public TestEntityTwoLocalServiceWrapper(
		TestEntityTwoLocalService testEntityTwoLocalService) {
		_testEntityTwoLocalService = testEntityTwoLocalService;
	}

	/**
	* Adds the test entity two to the database. Also notifies the appropriate model listeners.
	*
	* @param testEntityTwo the test entity two
	* @return the test entity two that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo addTestEntityTwo(
		de.uhh.l2g.plugins.migration.model.TestEntityTwo testEntityTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityTwoLocalService.addTestEntityTwo(testEntityTwo);
	}

	/**
	* Creates a new test entity two with the primary key. Does not add the test entity two to the database.
	*
	* @param plid the primary key for the new test entity two
	* @return the new test entity two
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo createTestEntityTwo(
		long plid) {
		return _testEntityTwoLocalService.createTestEntityTwo(plid);
	}

	/**
	* Deletes the test entity two with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param plid the primary key of the test entity two
	* @return the test entity two that was removed
	* @throws PortalException if a test entity two with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo deleteTestEntityTwo(
		long plid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testEntityTwoLocalService.deleteTestEntityTwo(plid);
	}

	/**
	* Deletes the test entity two from the database. Also notifies the appropriate model listeners.
	*
	* @param testEntityTwo the test entity two
	* @return the test entity two that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo deleteTestEntityTwo(
		de.uhh.l2g.plugins.migration.model.TestEntityTwo testEntityTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityTwoLocalService.deleteTestEntityTwo(testEntityTwo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _testEntityTwoLocalService.dynamicQuery();
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
		return _testEntityTwoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.TestEntityTwoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _testEntityTwoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.TestEntityTwoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _testEntityTwoLocalService.dynamicQuery(dynamicQuery, start,
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
		return _testEntityTwoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _testEntityTwoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo fetchTestEntityTwo(
		long plid) throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityTwoLocalService.fetchTestEntityTwo(plid);
	}

	/**
	* Returns the test entity two with the primary key.
	*
	* @param plid the primary key of the test entity two
	* @return the test entity two
	* @throws PortalException if a test entity two with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo getTestEntityTwo(
		long plid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testEntityTwoLocalService.getTestEntityTwo(plid);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testEntityTwoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the test entity twos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.TestEntityTwoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of test entity twos
	* @param end the upper bound of the range of test entity twos (not inclusive)
	* @return the range of test entity twos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.migration.model.TestEntityTwo> getTestEntityTwos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityTwoLocalService.getTestEntityTwos(start, end);
	}

	/**
	* Returns the number of test entity twos.
	*
	* @return the number of test entity twos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTestEntityTwosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityTwoLocalService.getTestEntityTwosCount();
	}

	/**
	* Updates the test entity two in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testEntityTwo the test entity two
	* @return the test entity two that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo updateTestEntityTwo(
		de.uhh.l2g.plugins.migration.model.TestEntityTwo testEntityTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityTwoLocalService.updateTestEntityTwo(testEntityTwo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _testEntityTwoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_testEntityTwoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _testEntityTwoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TestEntityTwoLocalService getWrappedTestEntityTwoLocalService() {
		return _testEntityTwoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTestEntityTwoLocalService(
		TestEntityTwoLocalService testEntityTwoLocalService) {
		_testEntityTwoLocalService = testEntityTwoLocalService;
	}

	@Override
	public TestEntityTwoLocalService getWrappedService() {
		return _testEntityTwoLocalService;
	}

	@Override
	public void setWrappedService(
		TestEntityTwoLocalService testEntityTwoLocalService) {
		_testEntityTwoLocalService = testEntityTwoLocalService;
	}

	private TestEntityTwoLocalService _testEntityTwoLocalService;
}