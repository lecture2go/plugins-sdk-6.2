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
 * Provides a wrapper for {@link AutocompleteLocalService}.
 *
 * @author Iavor Sturm
 * @see AutocompleteLocalService
 * @generated
 */
public class AutocompleteLocalServiceWrapper implements AutocompleteLocalService,
	ServiceWrapper<AutocompleteLocalService> {
	public AutocompleteLocalServiceWrapper(
		AutocompleteLocalService autocompleteLocalService) {
		_autocompleteLocalService = autocompleteLocalService;
	}

	/**
	* Adds the autocomplete to the database. Also notifies the appropriate model listeners.
	*
	* @param autocomplete the autocomplete
	* @return the autocomplete that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Autocomplete addAutocomplete(
		de.uhh.l2g.plugins.model.Autocomplete autocomplete)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _autocompleteLocalService.addAutocomplete(autocomplete);
	}

	/**
	* Creates a new autocomplete with the primary key. Does not add the autocomplete to the database.
	*
	* @param autocompleteId the primary key for the new autocomplete
	* @return the new autocomplete
	*/
	@Override
	public de.uhh.l2g.plugins.model.Autocomplete createAutocomplete(
		long autocompleteId) {
		return _autocompleteLocalService.createAutocomplete(autocompleteId);
	}

	/**
	* Deletes the autocomplete with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param autocompleteId the primary key of the autocomplete
	* @return the autocomplete that was removed
	* @throws PortalException if a autocomplete with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Autocomplete deleteAutocomplete(
		long autocompleteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _autocompleteLocalService.deleteAutocomplete(autocompleteId);
	}

	/**
	* Deletes the autocomplete from the database. Also notifies the appropriate model listeners.
	*
	* @param autocomplete the autocomplete
	* @return the autocomplete that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Autocomplete deleteAutocomplete(
		de.uhh.l2g.plugins.model.Autocomplete autocomplete)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _autocompleteLocalService.deleteAutocomplete(autocomplete);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _autocompleteLocalService.dynamicQuery();
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
		return _autocompleteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.AutocompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _autocompleteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.AutocompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _autocompleteLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _autocompleteLocalService.dynamicQueryCount(dynamicQuery);
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
		return _autocompleteLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Autocomplete fetchAutocomplete(
		long autocompleteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _autocompleteLocalService.fetchAutocomplete(autocompleteId);
	}

	/**
	* Returns the autocomplete with the primary key.
	*
	* @param autocompleteId the primary key of the autocomplete
	* @return the autocomplete
	* @throws PortalException if a autocomplete with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Autocomplete getAutocomplete(
		long autocompleteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _autocompleteLocalService.getAutocomplete(autocompleteId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _autocompleteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the autocompletes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.AutocompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of autocompletes
	* @param end the upper bound of the range of autocompletes (not inclusive)
	* @return the range of autocompletes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Autocomplete> getAutocompletes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _autocompleteLocalService.getAutocompletes(start, end);
	}

	/**
	* Returns the number of autocompletes.
	*
	* @return the number of autocompletes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAutocompletesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _autocompleteLocalService.getAutocompletesCount();
	}

	/**
	* Updates the autocomplete in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param autocomplete the autocomplete
	* @return the autocomplete that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Autocomplete updateAutocomplete(
		de.uhh.l2g.plugins.model.Autocomplete autocomplete)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _autocompleteLocalService.updateAutocomplete(autocomplete);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _autocompleteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_autocompleteLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _autocompleteLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public de.uhh.l2g.plugins.model.Autocomplete getSingularAutocomplete()
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchAutocompleteException {
		return _autocompleteLocalService.getSingularAutocomplete();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AutocompleteLocalService getWrappedAutocompleteLocalService() {
		return _autocompleteLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAutocompleteLocalService(
		AutocompleteLocalService autocompleteLocalService) {
		_autocompleteLocalService = autocompleteLocalService;
	}

	@Override
	public AutocompleteLocalService getWrappedService() {
		return _autocompleteLocalService;
	}

	@Override
	public void setWrappedService(
		AutocompleteLocalService autocompleteLocalService) {
		_autocompleteLocalService = autocompleteLocalService;
	}

	private AutocompleteLocalService _autocompleteLocalService;
}