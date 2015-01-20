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

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.HostNameException;
import de.uhh.l2g.plugins.HostServerTemplateException;
import de.uhh.l2g.plugins.HostStreamerException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.base.HostLocalServiceBaseImpl;

/**
 * The implementation of the host local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.HostLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
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
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.HostLocalServiceUtil} to access the host local service.
	 */
	

	public List<Host> getByInstitution(long institutionId) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public Host getByHostId(long hostId) throws SystemException{
		return hostPersistence.fetchByPrimaryKey(hostId);
	}
	
	public List<Host> getByGroupId(long groupId) throws SystemException{
		return hostPersistence.findByGroupId(groupId);
	}
	
	protected void validate (String name, String streamer, String serverTemplate) throws PortalException {
	    
		if (Validator.isNull(name)) {
	       throw new HostNameException();
		 }
		
	     if (Validator.isNull(streamer) || !Validator.isDomain(streamer) ) {
	       throw new HostStreamerException();
	     }     
	     
	     if (Validator.isNull(serverTemplate)) {
	       throw new HostServerTemplateException();
	     }
	}
	
	public Host addHost(String name, String streamer, String serverTemplate,
			String protocol, String serverRoot, int port,
			ServiceContext serviceContext) throws SystemException, PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		User user = userPersistence.findByPrimaryKey(userId);
		
		validate(name,streamer,serverTemplate);
		

		long hostId = counterLocalService.increment();

		Host host = hostPersistence.create(hostId);
		
		host.setName(name);
		host.setServerTemplate(serverTemplate);
		host.setStreamer(streamer);
		host.setProtocol(protocol);
		host.setServerRoot(serverRoot);
		host.setPort(port);
		host.setExpandoBridgeAttributes(serviceContext);

		hostPersistence.update(host);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Host.class.getName(), hostId, false, true, true);

		return host;
	}
	
}