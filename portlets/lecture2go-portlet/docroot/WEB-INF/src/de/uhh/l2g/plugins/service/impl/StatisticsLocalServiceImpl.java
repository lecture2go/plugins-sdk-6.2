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

import java.util.Date;
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

import de.uhh.l2g.plugins.StatisticsDateException;
import de.uhh.l2g.plugins.StatisticsValueException;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Statistics;
import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.StatisticsLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.StatisticsLocalServiceBaseImpl;

/**
 * The implementation of the institution_ host local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.StatisticsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.StatisticsLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.StatisticsLocalServiceUtil
 */
public class StatisticsLocalServiceImpl
	extends StatisticsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.StatisticsLocalServiceUtil} to access the institution_ host local service.
	 */

	public List<Statistics> getByCompanyIdandGroupId(long companyId, long groupId) throws SystemException, PortalException {
		List<Statistics> institution_host = statisticsPersistence.findByC_G(companyId, groupId);
		return institution_host; 
	}

	public Statistics getByStatisticsId(long statisticsId) throws SystemException, PortalException {
			Statistics statistics = statisticsPersistence.findByStatisticsId(statisticsId);
			
			return statistics;
	}
	
	public Statistics getByStatisticsId(long companyId, long groupId, long statisticsId) throws SystemException, PortalException {
		Statistics statistics = statisticsPersistence.findByStatisticsId(statisticsId);
		
		return statistics;
}

	
	/**
	public Host getByInstitution(long institutionId) throws SystemException, PortalException {
		long hid = statisticsPersistence.findByinstitutionId(institutionId).iterator().next().getHostId(); 
		Host h = HostLocalServiceUtil.getByHostId(hid);
		return h;
	}

	
	public Host getByGroupIdAndInstitutionId(long companyId, long groupId, long institutionId) throws SystemException, PortalException {
		Statistics iH = statisticsPersistence.fetchByG_I(groupId, institutionId);
		if (iH != null){
				long hId = iH.getHostId();
				Host h = HostLocalServiceUtil.getByGroupIdAndHostId(groupId,hId);
				return h;
		}
		else return HostLocalServiceUtil.getByDefault(companyId, groupId);
	}
	
	public Statistics getLinkByGroupIdAndInstitutionId(long groupId, long institutionId) throws SystemException, PortalException {
		Statistics ih = statisticsPersistence.findByG_I(groupId, institutionId);
		return ih;
	}

	public List<Institution> getByGroupIdAndHostId(long groupId, long hostId) throws SystemException, PortalException {
		List<Statistics> linkList = statisticsPersistence.findByG_H(groupId, hostId);
		List<Institution> institutions = null;

		for (Statistics link : linkList) {
			long iId = link.getInstitutionId();
			Institution i = InstitutionLocalServiceUtil.getByGroupIdAndId(groupId,iId);
			institutions.add(i);
		}
		return institutions;
	}

	public List<Statistics> getListByGroupIdAndHostId(long groupId, long hostId) throws SystemException, PortalException {
		List<Statistics> institution_host = statisticsPersistence.findByG_H(groupId, hostId);
		return institution_host;
	}
	public int getByGroupIdAndHostIdCount(long groupId, long hostId) throws SystemException, PortalException {
		int institution_host = statisticsPersistence.countByG_H(groupId, hostId);
		return institution_host;
	}

	// Actually this should never give a list because, there can be only one host per isntitution
	public List<Statistics> getListByGroupIdAndInstitutionId(long companyId, long groupId, long institutionId) throws SystemException, PortalException {
		List<Statistics> institution_host = (List<Statistics>) statisticsPersistence.findByC_G_I(companyId, groupId, institutionId);
		return institution_host;
	}
	
	* */

	/** TODO: Maximum one host per institution
	 *
	 * */
	protected void validate(long privateVideos, long publicVideos, Date date) throws PortalException {

		if (Validator.isNull(privateVideos)) {
	       throw new StatisticsValueException();
		 }

	     if (Validator.isNull(date)) {
	       throw new StatisticsDateException();
	     }

	}
	
	public void addDefaultEntry(){
		
		
	}

	public Statistics addEntry(int privateVideos, int publicVideos, ServiceContext serviceContext) throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		long companyId = serviceContext.getCompanyId();
		
		User user = userPersistence.findByPrimaryKey(userId);

		//validate(institutionId, hostId);

		long statisticsId = counterLocalService.increment(Statistics.class.getName());

		Statistics statistics = statisticsPersistence.create(statisticsId);

		statistics.setGroupId(groupId);
		statistics.setCompanyId(companyId);
		statistics.setPrivateVideos(privateVideos);
		statistics.setPublicVideos(publicVideos);
		//System.out.println ("Link: " +institutionId +" "+hostId);
		//System.out.println ("Link Contents: "+ statistics.toString());

		statistics.setExpandoBridgeAttributes(serviceContext);
		
		statisticsPersistence.update(statistics);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Statistics.class.getName(), statisticsId, false, true, true);


		return statistics;

	}

	public Statistics updateEntry(long statisticsId, int privateVideos, int publicVideos, ServiceContext serviceContext) throws SystemException, PortalException {

		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		User user = userPersistence.findByPrimaryKey(userId);
		// System.out.println ("Link: " +institutionId +" "+hostId);
		//validate(institutionId, hostId);

		Statistics statistics = getByStatisticsId(companyId, groupId, statisticsId);
		//System.out.println ("Link Contents: "+ statistics.toString());

		statistics.setGroupId(groupId);
		statistics.setPrivateVideos(privateVideos);
		statistics.setPublicVideos(publicVideos);

		statistics.setExpandoBridgeAttributes(serviceContext);

		statisticsPersistence.update(statistics);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Statistics.class.getName(), statisticsId, false, true, true);


		return statistics;

	}


	   public Statistics deleteLinkById(long statisticsId, ServiceContext serviceContext)
		        throws PortalException, SystemException {
		   		Statistics statistics = null;

		   		long groupId = serviceContext.getScopeGroupId();
		   		long userId = serviceContext.getUserId();



				statistics = deleteStatistics(statisticsId);


				statistics.setExpandoBridgeAttributes(serviceContext);
				resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				        		Statistics.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				        		statisticsId);

		        return statistics;

		    }
	   

	   public Statistics updateCounter() throws SystemException, PortalException {
		   Counter counter;
	   			// Initialize counter with a default value liferay suggests
				CounterLocalServiceUtil.increment(Statistics.class.getName());
				counter = CounterLocalServiceUtil.getCounter(Statistics.class.getName());
	   
				//Retrieve actual table data
				ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");    		
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(Statistics.class,classLoader).addOrder(OrderFactoryUtil.desc("statisticsId"));
				query.setLimit(0,1);
				List<Statistics> lStatistics = StatisticsLocalServiceUtil.dynamicQuery(query);
				Statistics statistics = lStatistics.get(0);
				
				//write Counter
				if (statistics != null) counter.setCurrentId(statistics.getStatisticsId());
				CounterLocalServiceUtil.updateCounter(counter);
				return statistics;
					
		   
	   }

}
