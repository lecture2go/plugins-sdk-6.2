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
import java.util.List;

import com.liferay.counter.model.Counter;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.HostNameException;
import de.uhh.l2g.plugins.HostStreamerException;
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


	public Host getByInstitution(long institutionId) throws SystemException{
		Host h = null;
		try {
			h = Institution_HostLocalServiceUtil.getByInstitutionId(institutionId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return h;
	}

	public Host getByHostId(long hostId) throws SystemException{
		return hostPersistence.fetchByPrimaryKey(hostId);
	}

	public List<Host> getByGroupId(long groupId) throws SystemException{
		return hostPersistence.findByGroupId(groupId);
	}
	
	public List<Host> getByGroupId(long groupId, int start, int end) throws SystemException{
		return hostPersistence.findByGroupId(groupId, start, end);
	}
	
	public int getByGroupIdCount(long groupId) throws SystemException {
		return hostPersistence.countByGroupId(groupId);
	}

	public Host getByGroupIdAndHostId(long groupId, long hostId) throws SystemException{
		return hostPersistence.fetchByG_H(groupId, hostId);
	}
	
	public List<Host> getByCompanyIdAndGroupId(long companyId, long groupId) throws SystemException{
		return hostPersistence.findByCompanyIdAndGroupId(companyId, groupId);
	}
	
	public Host getByDefault(long companyId, long groupId) throws SystemException{
		Host defaultHost = hostPersistence.fetchByDefaultHost(companyId, groupId,false);
		return defaultHost;
	}
	
	
	public long getDefaultHostId(long companyId, long groupId) throws SystemException{
		//System.out.println(companyId +" "+groupId);
		Host defaultHost = hostPersistence.fetchByDefaultHost(companyId, groupId, false);
		if (defaultHost == null) return 0;
		else return defaultHost.getPrimaryKey();
	}
	
	/**Host is locked if it is linked to an institution */
	public int getLockingElements(long groupId, long hostId) throws SystemException { 
		int c = 0;
			try {
				c = Institution_HostLocalServiceUtil.getByGroupIdAndHostIdCount(groupId, hostId);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return c;
	}


	protected void validate (String name, String streamer) throws PortalException {
		
		//only default host db entries name field is allowed to be empty
		if (Validator.isNull(name)) {
	       throw new HostNameException();
		 }

	     if (Validator.isNull(streamer) || !Validator.isDomain(streamer) || !Validator.isHostName(streamer) ) {
	       throw new HostStreamerException();
	     }

	}
	
	
	/**Special handling for default entries (no update)
	 * 
	 */
	public Host addDefaultHost(ServiceContext serviceContext) throws SystemException, PortalException {
		
    	
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();

		User user = userPersistence.findByPrimaryKey(userId);
		
		long hostId = counterLocalService.increment(Host.class.getName());
		
		Host defaultHost = hostPersistence.create(hostId);

		//Empty name marks default
		defaultHost.setName("");
		defaultHost.setGroupId(groupId);
		defaultHost.setCompanyId(companyId);
		//Load from Portal Properties
		defaultHost.setStreamer(PropsUtil.get("lecture2go.default.streamingHost"));
		defaultHost.setProtocol(PropsUtil.get("lecture2go.default.streamingProtocol"));
		defaultHost.setServerRoot(PropsUtil.get("lecture2go.default.serverRoot"));
		defaultHost.setPort(Integer.valueOf(PropsUtil.get("lecture2go.default.streamingPort")));
		defaultHost.setDefaultHost(1);
		
		defaultHost.setExpandoBridgeAttributes(serviceContext);

		hostPersistence.update(defaultHost);
		
		//Create Directory
		try {
			
			RepositoryManager.createFolder(PropsUtil.get("lecture2go.media.repository")+"/"+ defaultHost.getServerRoot());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Host.class.getName(), hostId, false, true, true);
    	
    	return defaultHost;
	}

	public Host addHost(String name, String streamLocation, 
			String protocol, String serverRoot, int port,
			ServiceContext serviceContext) throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();

		User user = userPersistence.findByPrimaryKey(userId);

		validate(name,streamLocation);


		long hostId = counterLocalService.increment(Host.class.getName());

		Host host = hostPersistence.create(hostId);

		host.setName(name);
		host.setGroupId(groupId);
		host.setCompanyId(companyId);
//		host.setStreamingServerTemplateId(streamingServerTemplateId);
		host.setStreamer(streamLocation);
		host.setProtocol(protocol);
		host.setServerRoot(RepositoryManager.prepareServerRoot(hostId));
		host.setPort(port);
		host.setExpandoBridgeAttributes(serviceContext);

		hostPersistence.update(host);

		//Create Directory
		try {
			RepositoryManager.createFolder(PropsUtil.get("lecture2go.media.repository")+"/"+ host.getServerRoot());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Host.class.getName(), hostId, false, true, true);

		return host;
	}
	
		public Host updateHost(long hostId, String name, String streamLocation, 
			String protocol, int port,
			ServiceContext serviceContext) throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();

		User user = userPersistence.findByPrimaryKey(userId);

		validate(name,streamLocation);

		Host host = getHost(hostId);

		host.setName(name);
		host.setGroupId(groupId);
		host.setCompanyId(companyId);
//		host.setStreamingServerTemplateId(streamingServerTemplateId);
		host.setStreamer(streamLocation);
		host.setProtocol(protocol);
		//Server Root will be constant over all changes
		//host.setServerRoot(serverRoot);
		host.setPort(port);
		host.setExpandoBridgeAttributes(serviceContext);

		hostPersistence.update(host);
		
	    resourceLocalService.updateResources(user.getCompanyId(), groupId,
		         Host.class.getName(), hostId,
		         serviceContext.getGroupPermissions(),
		         serviceContext.getGuestPermissions());

		return host;
	}

	   /**Removes database record of Host
	    * 
	    * This will not remove Folder on Filesystem, Folder will not be reused 
	    * 
	    */
	   public Host deleteHost(long hostId, ServiceContext serviceContext)
		        throws PortalException, SystemException {
		   		
		   		long companyId = serviceContext.getCompanyId();
		   		long groupId = serviceContext.getScopeGroupId();
		        Host host = getHost(hostId);
		        int l = getLockingElements(groupId, hostId);
  
		        if (l<1){
			        resourceLocalService.deleteResource(companyId,
			        		Host.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
			        		hostId);
	
			        host = deleteHost(hostId);
		        }
		        else{
		        	System.out.println("Could not delete Host because it is still used by "+ l +" Institutions");
		        }
		        return host;

		    }
	   
	   public Host updateCounter() throws SystemException, PortalException {
		   Counter counter;
	   			// Initialize counter with a default value liferay suggests
				CounterLocalServiceUtil.increment(Host.class.getName());
				counter = CounterLocalServiceUtil.getCounter(Host.class.getName());
	   
				//Retrieve actual table data
				ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");    		
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(Host.class,classLoader).addOrder(OrderFactoryUtil.desc("hostId"));
				query.setLimit(0,1);
				List<Host> hosts = HostLocalServiceUtil.dynamicQuery(query);
				Host host = hosts.get(0);
				
				//TODO: Check back with file system an increment until directory number is free
				
				//write Counter
				if (host != null) counter.setCurrentId(host.getHostId());
				CounterLocalServiceUtil.updateCounter(counter);
				
				return host;
					
		   
	   }
}
