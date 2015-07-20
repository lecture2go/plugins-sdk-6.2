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

package de.uhh.l2g.plugins.migration.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.migration.model.LegacyMetadata;

/**
 * The persistence interface for the legacy metadata service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author unihh
 * @see LegacyMetadataPersistenceImpl
 * @see LegacyMetadataUtil
 * @generated
 */
public interface LegacyMetadataPersistence extends BasePersistence<LegacyMetadata> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegacyMetadataUtil} to access the legacy metadata persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the legacy metadata in the entity cache if it is enabled.
	*
	* @param legacyMetadata the legacy metadata
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.migration.model.LegacyMetadata legacyMetadata);

	/**
	* Caches the legacy metadatas in the entity cache if it is enabled.
	*
	* @param legacyMetadatas the legacy metadatas
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.migration.model.LegacyMetadata> legacyMetadatas);

	/**
	* Creates a new legacy metadata with the primary key. Does not add the legacy metadata to the database.
	*
	* @param id the primary key for the new legacy metadata
	* @return the new legacy metadata
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata create(long id);

	/**
	* Removes the legacy metadata with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the legacy metadata
	* @return the legacy metadata that was removed
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException if a legacy metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException;

	public de.uhh.l2g.plugins.migration.model.LegacyMetadata updateImpl(
		de.uhh.l2g.plugins.migration.model.LegacyMetadata legacyMetadata)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legacy metadata with the primary key or throws a {@link de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException} if it could not be found.
	*
	* @param id the primary key of the legacy metadata
	* @return the legacy metadata
	* @throws de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException if a legacy metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException;

	/**
	* Returns the legacy metadata with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the legacy metadata
	* @return the legacy metadata, or <code>null</code> if a legacy metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.migration.model.LegacyMetadata fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legacy metadatas.
	*
	* @return the legacy metadatas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyMetadata> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legacy metadatas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy metadatas
	* @param end the upper bound of the range of legacy metadatas (not inclusive)
	* @return the range of legacy metadatas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyMetadata> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legacy metadatas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacy metadatas
	* @param end the upper bound of the range of legacy metadatas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacy metadatas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.migration.model.LegacyMetadata> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legacy metadatas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legacy metadatas.
	*
	* @return the number of legacy metadatas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}