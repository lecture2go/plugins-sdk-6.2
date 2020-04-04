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

package de.uhh.l2g.plugins.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.model.Counter;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.HostNameException;
import de.uhh.l2g.plugins.HostStreamerException;
import de.uhh.l2g.plugins.NoPropertyException;
import de.uhh.l2g.plugins.admin.AdminStreamerManagement;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.HostLocalServiceBaseImpl;
import de.uhh.l2g.plugins.util.RepositoryManager;

/**
 * The implementation of the host local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.uhh.l2g.plugins.service.HostLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.HostLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.HostLocalServiceUtil
 */
public class HostLocalServiceImpl extends HostLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * de.uhh.l2g.plugins.service.HostLocalServiceUtil} to access the host local
	 * service.
	 */

	protected static Log LOG = LogFactoryUtil.getLog(Host.class.getName());
	protected static final String SYS_ROOT = "vh_000";
	protected static final String SYS_SERVER = "localhost";
	protected static final String SYS_PROTOCOL = "http";
	protected static final int SYS_PORT = 80;

	public Host getByInstitution(long institutionId) throws SystemException {
		Host h = null;
		try {
			h = Institution_HostLocalServiceUtil.getByInstitutionId(institutionId);
		} catch (PortalException e) {
			LOG.debug("Can't fetch host by institution id "+institutionId);
		}
		return h;
	}

	public int countAll(){
		int count = 0;
		try {
			count = hostPersistence.countAll();
		} catch (SystemException e) {
			LOG.debug("Can't fetch number of hosts");
		}
		return count;
	}
	
	public List<Host> getAll(){
		List<Host> ret = new ArrayList<Host>(); 
		try {
			ret = hostPersistence.findAll();
		} catch (SystemException e) {
			LOG.debug("Can't fetch list of all hosts");
		}
		return ret;
	}
	
	public List<Host> getAll(int start, int end){
		List<Host> ret = new ArrayList<Host>(); 
		try {
			ret = hostPersistence.findAll(start, end);
		} catch (SystemException e) {
			LOG.debug("Can't fetch list of hosts");
		}
		return ret;
	}
	
	public Host getByHostId(long hostId) throws SystemException {
		return hostPersistence.fetchByPrimaryKey(hostId);
	}
	
	public Host getDefaultHost(){
		Host defaultHost = HostLocalServiceUtil.createHost(0);
		try {
			defaultHost = hostPersistence.findBydefaultHost(0);
		} catch (Exception e) {
			LOG.debug("Can't fetch default host");
		}
		return defaultHost;
	}

	/** Host is locked if it is linked to an institution */
	public int getLockingElements(long hostId) throws SystemException {
		int c = 0;
		try {
			c = Institution_HostLocalServiceUtil.getByHostIdCount(hostId);
		} catch (PortalException e) {
			LOG.debug("Can't fetch locking elements");
		}
		return c;
	}

	protected void validate(String name, String streamer) throws PortalException {
		// only default host db entries name field is allowed to be empty
		if (Validator.isNull(name)) {
			throw new HostNameException();
		}

		if (Validator.isNull(streamer) || !Validator.isDomain(streamer) || !Validator.isHostName(streamer)) {
			throw new HostStreamerException();
		}
	}

	public Host addHost(String name) throws SystemException, PortalException {
		long hostId = counterLocalService.increment(Host.class.getName());
		Host host = hostPersistence.create(hostId);
		host.setName(name);
		host.setDirectory("vh_"+hostId);
		super.addHost(host);

		// Create Directory
		try {
			RepositoryManager.createFolder(PropsUtil.get("lecture2go.media.repository") + "/" + host.getDirectory());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return host;
	}

	public Host updateHost(long hostId, String name) throws SystemException, PortalException {
		Host host = getHost(hostId);
		host.setName(name);
		// host.setStreamingServerTemplateId(streamingServerTemplateId);
		// Server Root will be constant over all changes
		hostPersistence.update(host);
		return host;
	}

	/**
	 * Removes database record of Host
	 * 
	 * This will not remove Folder on Filesystem, Folder will not be reused
	 * 
	 */
	public Host deleteHost(long hostId, ServiceContext serviceContext) throws PortalException, SystemException {
		long companyId = serviceContext.getCompanyId();
		Host host = getHost(hostId);
		int l = getLockingElements(hostId);

		if (l < 1) {
			resourceLocalService.deleteResource(companyId, Host.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, hostId);
			host = deleteHost(hostId);
		} else {
			String message = LanguageUtil.format(serviceContext.getLocale(), "There are {0} objects still refering to this institution", l);
			SessionMessages.add(serviceContext.getRequest(), "deletion-locked", message);
			System.out.println("Could not delete Host because it is still used by " + l + " Institutions");
		}
		return host;
	}

}
