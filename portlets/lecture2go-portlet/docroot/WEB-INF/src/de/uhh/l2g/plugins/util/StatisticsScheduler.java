package de.uhh.l2g.plugins.util;
/***************************************************************************
 * The Lecture2Go software is based on the liferay portal 6.1.1
 * <http://www.liferay.com>
 *
 * Lecture2Go <http://lecture2go.uni-hamburg.de> is an open source
 * platform for media management and distribution. Our goal is to
 * support the free access to knowledge because this is a component
 * of each democratic society. The open source software is aimed at
 * academic institutions and has to strengthen the blended learning.
 *
 * All Lecture2Go plugins are continuously being developed and improved.
 * For more details please visit <http://lecture2go-open-source.rrz.uni-hamburg.de>
 *
 * @Autor Lecture2Go Team
 * @Version 1.0
 * @Contact lecture2go-open-source@uni-hamburg.de
 *
 * Copyright (c) 2013 University of Hamburg / Computer and Data Center (RRZ)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ***************************************************************************/

import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;



/** Statistics is less shaky when running job at concrete time (ideally around midnight) 
 *  There is no built-in time based scheduler in Java, though Quartz is build-in for liferay 6.2
 * (https://quartz-scheduler.org/)
 * It setting work pretty much like cron and are configured in liferay-portlet.xml
 * http://www.quartz-scheduler.org/documentation/quartz-1.x/tutorials/crontrigger
 */
/**
 * The Class VideoStatisticsSheduler.
*/
public class StatisticsScheduler implements MessageListener {  
	
	  private static final Log LOG  = LogFactoryUtil.getLog(StatisticsScheduler.class);	
	  private static final String schedulerName  = StatisticsScheduler.class.getName(); 
	  private static Trigger trigger;
	  private static SchedulerResponse response;
	  
	  
    @Override
    public void receive(Message message) throws MessageListenerException {
       //Debug Information on running job
       LOG.info("Statistics Scheduler running...");
       
       Map<String, Object> map = message.getValues();
       for (Map.Entry<String, Object> entry : map.entrySet())
       {
           LOG.info(entry.getKey() + "/" + entry.getValue());
        
       }
    }
    
	
    /**Get Job by Name (assumes group name and storage type are constant)
     * 
     * @param schedulerName
     * @throws Exception
     */
	public static void startCron()throws Exception{
			
		try {  		
			      String groupName = response.getGroupName();  
			      StorageType storageType = response.getStorageType(); 
			      String description = response.getDescription();
			      String destinationName = response.getDestinationName();
			      Message message = response.getMessage();
			       	Map<String, Object> map = response.getMessage().getValues();  
			      	  String portletId = map.get("PORTLET_ID").toString();
			      	  int exceptionsMaxSize = Integer.valueOf(map.get("EXCEPTIONS_MAX_SIZE").toString());
			      LOG.info("Scheduling :" + schedulerName);  
			      SchedulerEngineHelperUtil.schedule(trigger, storageType, description, destinationName, message, exceptionsMaxSize);     
			      
			  
			 } catch (SchedulerException e) {  
			   LOG.warn(e);  
			 } 
	}
    
    
    public static void stopCron()throws Exception{
		try {  
			  List<SchedulerResponse> scheduledJobs = SchedulerEngineHelperUtil.getScheduledJobs();  
			  for (SchedulerResponse resp : scheduledJobs) {  
			    if (resp.getJobName().equalsIgnoreCase(schedulerName)) {  
			      String groupName = resp.getGroupName();  
			      StorageType storageType = resp.getStorageType(); 
			      //Keep those values
			      trigger = resp.getTrigger();
			      response = resp;
			      LOG.info("Unscheduling :" + schedulerName +trigger.toString());  
			      SchedulerEngineHelperUtil.unschedule(schedulerName, groupName, storageType);  
			    }  
			 }  
			 } catch (SchedulerException e) {  
			  LOG.warn(e);  
			 } 
	}
    
}
 

 
