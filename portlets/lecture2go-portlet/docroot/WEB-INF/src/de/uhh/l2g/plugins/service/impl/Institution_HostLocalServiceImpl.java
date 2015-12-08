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

import com.liferay.counter.model.Counter;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.Institution_HostHostException;
import de.uhh.l2g.plugins.Institution_HostInstitutionException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.Institution_HostLocalServiceBaseImpl;

/**
 * The implementation of the institution_ host local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.Institution_HostLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.Institution_HostLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil
 */
public class Institution_HostLocalServiceImpl
	extends Institution_HostLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil} to access the institution_ host local service.
	 */

	public List<Institution_Host> getByGroupId(long groupId) throws SystemException, PortalException {
		List<Institution_Host> institution_host = institution_HostPersistence.findByGroupId(groupId);
		return institution_host;
}

	public Host getByInstitutionId(long institutionId) throws SystemException, PortalException {
			long hId = institution_HostPersistence.findByG_I(0,institutionId).getHostId();

			Host h = HostLocalServiceUtil.getByHostId(hId);
			return h;
	}

	public Host getByInstitution(long institutionId) throws SystemException, PortalException {
		long hid = institution_HostPersistence.findByinstitutionId(institutionId).iterator().next().getHostId(); 
		Host h = HostLocalServiceUtil.getByHostId(hid);
		return h;
	}

	public Host getByGroupIdAndInstitutionId(long companyId, long groupId, long institutionId) throws SystemException, PortalException {
		Institution_Host iH = institution_HostPersistence.fetchByG_I(groupId, institutionId);
		if (iH != null){
				long hId = iH.getHostId();
				Host h = HostLocalServiceUtil.getByGroupIdAndHostId(groupId,hId);
				return h;
		}
		else return HostLocalServiceUtil.getByDefault(companyId, groupId);
	}
	
	public Institution_Host getLinkByGroupIdAndInstitutionId(long groupId, long institutionId) throws SystemException, PortalException {
		Institution_Host ih = institution_HostPersistence.findByG_I(groupId, institutionId);
		return ih;
	}

	public List<Institution> getByGroupIdAndHostId(long groupId, long hostId) throws SystemException, PortalException {
		List<Institution_Host> linkList = institution_HostPersistence.findByG_H(groupId, hostId);
		List<Institution> institutions = null;

		for (Institution_Host link : linkList) {
			long iId = link.getInstitutionId();
			Institution i = InstitutionLocalServiceUtil.getByGroupIdAndId(groupId,iId);
			institutions.add(i);
		}
		return institutions;
	}

	public List<Institution_Host> getListByGroupIdAndHostId(long groupId, long hostId) throws SystemException, PortalException {
		List<Institution_Host> institution_host = institution_HostPersistence.findByG_H(groupId, hostId);
		return institution_host;
	}
	public int getByGroupIdAndHostIdCount(long groupId, long hostId) throws SystemException, PortalException {
		int institution_host = institution_HostPersistence.countByG_H(groupId, hostId);
		return institution_host;
	}

	/** Actually this should never give a list because, there can be only one host per isntitution
	 * */
	public List<Institution_Host> getListByGroupIdAndInstitutionId(long companyId, long groupId, long institutionId) throws SystemException, PortalException {
		List<Institution_Host> institution_host = (List<Institution_Host>) institution_HostPersistence.findByC_G_I(companyId, groupId, institutionId);
		return institution_host;
	}

	/** TODO: Maximum one host per institution
	 *
	 * */
	protected void validate(long institutionId, long hostId) throws PortalException {

		if (Validator.isNull(institutionId)) {
	       throw new Institution_HostInstitutionException();
		 }

	     if (Validator.isNull(hostId)) {
	       throw new Institution_HostHostException();
	     }

	}
	
	public void addDefaultEntry(){
		
		
	}

	public Institution_Host addEntry(long institutionId, long hostId, ServiceContext serviceContext) throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		long companyId = serviceContext.getCompanyId();
		
		User user = userPersistence.findByPrimaryKey(userId);

		//validate(institutionId, hostId);

		long institution_HostId = counterLocalService.increment(Institution_Host.class.getName());

		Institution_Host institution_Host = institution_HostPersistence.create(institution_HostId);

		institution_Host.setGroupId(groupId);
		institution_Host.setCompanyId(companyId);
		institution_Host.setInstitutionId(institutionId);
		institution_Host.setHostId(hostId);
		//System.out.println ("Link: " +institutionId +" "+hostId);
		//System.out.println ("Link Contents: "+ institution_Host.toString());

		institution_Host.setExpandoBridgeAttributes(serviceContext);
		
		institution_HostPersistence.update(institution_Host);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Institution_Host.class.getName(), institution_HostId, false, true, true);


		return institution_Host;

	}

	public Institution_Host updateEntry(long institutionId, long hostId, ServiceContext serviceContext) throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		User user = userPersistence.findByPrimaryKey(userId);
		// System.out.println ("Link: " +institutionId +" "+hostId);
		validate(institutionId, hostId);

		Institution_Host institution_Host = getLinkByGroupIdAndInstitutionId(groupId, institutionId);
		//System.out.println ("Link Contents: "+ institution_Host.toString());

		institution_Host.setGroupId(groupId);
		institution_Host.setInstitutionId(institutionId);
		institution_Host.setHostId(hostId);

		institution_Host.setExpandoBridgeAttributes(serviceContext);

		institution_HostPersistence.update(institution_Host);

		long institution_HostId = institution_Host.getPrimaryKey();
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Institution_Host.class.getName(), institution_HostId, false, true, true);


		return institution_Host;

	}


	   public Institution_Host deleteLinkById(long institutionHostId, ServiceContext serviceContext)
		        throws PortalException, SystemException {
		   		Institution_Host institution_Host = null;

		   		long groupId = serviceContext.getScopeGroupId();
		   		long userId = serviceContext.getUserId();



				institution_Host = deleteInstitution_Host(institutionHostId);


				institution_Host.setExpandoBridgeAttributes(serviceContext);
				resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				        		Institution_Host.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				        		institutionHostId);

		        return institution_Host;

		    }
	   
	   public Institution_Host deleteLinkByInstitution(Institution institution, long groupId, long companyId)
		        throws PortalException, SystemException {
		        long iId = institution.getInstitutionId();
                Institution_Host institution_Host = getLinkByGroupIdAndInstitutionId(groupId,iId);
                long ihId = institution_Host.getInstitutionHostId();
                		
		   		ServiceContext serviceContext = new ServiceContext();
		   	    serviceContext.setScopeGroupId(groupId);
		   	    serviceContext.setCompanyId(companyId);
		

				institution_Host = deleteInstitution_Host(ihId);


				institution_Host.setExpandoBridgeAttributes(serviceContext);
				resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				        		Institution_Host.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				        		ihId);

		        return institution_Host;

		    }
	   public Institution_Host updateCounter() throws SystemException, PortalException {
		   Counter counter;
	   			// Initialize counter with a default value liferay suggests
				CounterLocalServiceUtil.increment(Institution_Host.class.getName());
				counter = CounterLocalServiceUtil.getCounter(Institution_Host.class.getName());
	   
				//Retrieve actual table data
				ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");    		
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(Institution_Host.class,classLoader).addOrder(OrderFactoryUtil.desc("institutionHostId"));
				query.setLimit(0,1);
				List<Institution_Host> institution_hosts = Institution_HostLocalServiceUtil.dynamicQuery(query);
				Institution_Host institution_host = institution_hosts.get(0);
				
				//write Counter
				if (institution_host != null) counter.setCurrentId(institution_host.getInstitutionHostId() + 1);
				CounterLocalServiceUtil.updateCounter(counter);
				return institution_host;
					
		   
	   }

}
