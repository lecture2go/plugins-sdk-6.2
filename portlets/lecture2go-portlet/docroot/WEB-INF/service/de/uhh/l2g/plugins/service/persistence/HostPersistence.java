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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.model.Host;

/**
 * The persistence interface for the host service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see HostPersistenceImpl
 * @see HostUtil
 * @generated
 */
public interface HostPersistence extends BasePersistence<Host> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HostUtil} to access the host persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the host where hostId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchHostException} if it could not be found.
	*
	* @param hostId the host ID
	* @return the matching host
	* @throws de.uhh.l2g.plugins.NoSuchHostException if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host findByhostId(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Returns the host where hostId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param hostId the host ID
	* @return the matching host, or <code>null</code> if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host fetchByhostId(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the host where hostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param hostId the host ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching host, or <code>null</code> if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host fetchByhostId(long hostId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the host where hostId = &#63; from the database.
	*
	* @param hostId the host ID
	* @return the host that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host removeByhostId(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Returns the number of hosts where hostId = &#63;.
	*
	* @param hostId the host ID
	* @return the number of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public int countByhostId(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the hosts where protocol = &#63;.
	*
	* @param protocol the protocol
	* @return the matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Host> findByprotocol(
		java.lang.String protocol)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the hosts where protocol = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param protocol the protocol
	* @param start the lower bound of the range of hosts
	* @param end the upper bound of the range of hosts (not inclusive)
	* @return the range of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Host> findByprotocol(
		java.lang.String protocol, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the hosts where protocol = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param protocol the protocol
	* @param start the lower bound of the range of hosts
	* @param end the upper bound of the range of hosts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Host> findByprotocol(
		java.lang.String protocol, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first host in the ordered set where protocol = &#63;.
	*
	* @param protocol the protocol
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching host
	* @throws de.uhh.l2g.plugins.NoSuchHostException if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host findByprotocol_First(
		java.lang.String protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Returns the first host in the ordered set where protocol = &#63;.
	*
	* @param protocol the protocol
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching host, or <code>null</code> if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host fetchByprotocol_First(
		java.lang.String protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last host in the ordered set where protocol = &#63;.
	*
	* @param protocol the protocol
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching host
	* @throws de.uhh.l2g.plugins.NoSuchHostException if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host findByprotocol_Last(
		java.lang.String protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Returns the last host in the ordered set where protocol = &#63;.
	*
	* @param protocol the protocol
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching host, or <code>null</code> if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host fetchByprotocol_Last(
		java.lang.String protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hosts before and after the current host in the ordered set where protocol = &#63;.
	*
	* @param hostId the primary key of the current host
	* @param protocol the protocol
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next host
	* @throws de.uhh.l2g.plugins.NoSuchHostException if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host[] findByprotocol_PrevAndNext(
		long hostId, java.lang.String protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Removes all the hosts where protocol = &#63; from the database.
	*
	* @param protocol the protocol
	* @throws SystemException if a system exception occurred
	*/
	public void removeByprotocol(java.lang.String protocol)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of hosts where protocol = &#63;.
	*
	* @param protocol the protocol
	* @return the number of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public int countByprotocol(java.lang.String protocol)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the hosts where streamer = &#63;.
	*
	* @param streamer the streamer
	* @return the matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Host> findBystreamer(
		java.lang.String streamer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the hosts where streamer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param streamer the streamer
	* @param start the lower bound of the range of hosts
	* @param end the upper bound of the range of hosts (not inclusive)
	* @return the range of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Host> findBystreamer(
		java.lang.String streamer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the hosts where streamer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param streamer the streamer
	* @param start the lower bound of the range of hosts
	* @param end the upper bound of the range of hosts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Host> findBystreamer(
		java.lang.String streamer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first host in the ordered set where streamer = &#63;.
	*
	* @param streamer the streamer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching host
	* @throws de.uhh.l2g.plugins.NoSuchHostException if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host findBystreamer_First(
		java.lang.String streamer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Returns the first host in the ordered set where streamer = &#63;.
	*
	* @param streamer the streamer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching host, or <code>null</code> if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host fetchBystreamer_First(
		java.lang.String streamer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last host in the ordered set where streamer = &#63;.
	*
	* @param streamer the streamer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching host
	* @throws de.uhh.l2g.plugins.NoSuchHostException if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host findBystreamer_Last(
		java.lang.String streamer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Returns the last host in the ordered set where streamer = &#63;.
	*
	* @param streamer the streamer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching host, or <code>null</code> if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host fetchBystreamer_Last(
		java.lang.String streamer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hosts before and after the current host in the ordered set where streamer = &#63;.
	*
	* @param hostId the primary key of the current host
	* @param streamer the streamer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next host
	* @throws de.uhh.l2g.plugins.NoSuchHostException if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host[] findBystreamer_PrevAndNext(
		long hostId, java.lang.String streamer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Removes all the hosts where streamer = &#63; from the database.
	*
	* @param streamer the streamer
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystreamer(java.lang.String streamer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of hosts where streamer = &#63;.
	*
	* @param streamer the streamer
	* @return the number of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public int countBystreamer(java.lang.String streamer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the host where name = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchHostException} if it could not be found.
	*
	* @param name the name
	* @return the matching host
	* @throws de.uhh.l2g.plugins.NoSuchHostException if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host findByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Returns the host where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching host, or <code>null</code> if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host fetchByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the host where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching host, or <code>null</code> if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host fetchByname(java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the host where name = &#63; from the database.
	*
	* @param name the name
	* @return the host that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host removeByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Returns the number of hosts where name = &#63;.
	*
	* @param name the name
	* @return the number of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the host where defaultHost = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchHostException} if it could not be found.
	*
	* @param defaultHost the default host
	* @return the matching host
	* @throws de.uhh.l2g.plugins.NoSuchHostException if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host findBydefaultHost(int defaultHost)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Returns the host where defaultHost = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param defaultHost the default host
	* @return the matching host, or <code>null</code> if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host fetchBydefaultHost(int defaultHost)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the host where defaultHost = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param defaultHost the default host
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching host, or <code>null</code> if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host fetchBydefaultHost(int defaultHost,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the host where defaultHost = &#63; from the database.
	*
	* @param defaultHost the default host
	* @return the host that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host removeBydefaultHost(int defaultHost)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Returns the number of hosts where defaultHost = &#63;.
	*
	* @param defaultHost the default host
	* @return the number of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public int countBydefaultHost(int defaultHost)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the host in the entity cache if it is enabled.
	*
	* @param host the host
	*/
	public void cacheResult(de.uhh.l2g.plugins.model.Host host);

	/**
	* Caches the hosts in the entity cache if it is enabled.
	*
	* @param hosts the hosts
	*/
	public void cacheResult(java.util.List<de.uhh.l2g.plugins.model.Host> hosts);

	/**
	* Creates a new host with the primary key. Does not add the host to the database.
	*
	* @param hostId the primary key for the new host
	* @return the new host
	*/
	public de.uhh.l2g.plugins.model.Host create(long hostId);

	/**
	* Removes the host with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hostId the primary key of the host
	* @return the host that was removed
	* @throws de.uhh.l2g.plugins.NoSuchHostException if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host remove(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	public de.uhh.l2g.plugins.model.Host updateImpl(
		de.uhh.l2g.plugins.model.Host host)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the host with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchHostException} if it could not be found.
	*
	* @param hostId the primary key of the host
	* @return the host
	* @throws de.uhh.l2g.plugins.NoSuchHostException if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host findByPrimaryKey(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchHostException;

	/**
	* Returns the host with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hostId the primary key of the host
	* @return the host, or <code>null</code> if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.Host fetchByPrimaryKey(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the hosts.
	*
	* @return the hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Host> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the hosts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hosts
	* @param end the upper bound of the range of hosts (not inclusive)
	* @return the range of hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Host> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the hosts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hosts
	* @param end the upper bound of the range of hosts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.Host> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the hosts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of hosts.
	*
	* @return the number of hosts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}