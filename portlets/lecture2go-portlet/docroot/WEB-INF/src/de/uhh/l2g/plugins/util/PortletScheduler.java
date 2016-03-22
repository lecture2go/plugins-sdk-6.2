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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerState;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.service.ClassNameLocalServiceUtil;



/** There is no built-in time based scheduler in Java, though Quartz Extension is build-in for liferay 6.2
 * (https://quartz-scheduler.org/)
 * 
 * It setting work pretty much like cron and are configured in liferay-portlet.xml
 * http://www.quartz-scheduler.org/documentation/quartz-1.x/tutorials/crontrigger
 * 
 * Unfortunately Liferay Scheduler Configuration comes without start/stop/pause/resume functionality
 * This Class uses the Liferay Quartz Scheduler as specified within <scheduler-entry> 
 * and adds start/stop functionility to it until server restart
 */
/**
 * The Class PortletScheduler.
*/
@SuppressWarnings("serial")
public class PortletScheduler extends SchedulerResponse implements MessageListener {  
	
	 
	  protected Log LOG;	
	  protected String schedulerName; 
	  protected String destination;
	  protected final String DEST = DestinationNames.SCHEDULER_DISPATCH;
	
	
	  public PortletScheduler(){
		  this.schedulerName =PortletScheduler.class.getName();
		  this.LOG = LogFactoryUtil.getLog(PortletScheduler.class.getName());
		  
	  }
	 /** Retrieve initialization Data form scheduled Listings
	  *  
	  * */
	 public PortletScheduler(String schedulerClassName){
		this.schedulerName = schedulerClassName;
		this.LOG = LogFactoryUtil.getLog(schedulerClassName);
		 
		try {  
			  List<SchedulerResponse> scheduledJobs = SchedulerEngineHelperUtil.getScheduledJobs();  
			  for (SchedulerResponse resp : scheduledJobs) {  
			    if (resp.getJobName().equalsIgnoreCase(this.schedulerName)) { 
			    	
			      this.setJobName(resp.getJobName());
			      this.setGroupName(resp.getGroupName());  
			      this.setStorageType(resp.getStorageType()); 
			      this.setDescription(resp.getDescription());
			      this.setMessage(resp.getMessage());
			      this.setTrigger(resp.getTrigger());
			      
			      LOG.info("Copy Portlet Information: "+this.getMessage().toString());
			      Map<String, Object> map = this.getMessage().getValues();
			      
		      	  //this.getMessage().copyFrom(resp.getMessage());		
		      	  
			      //Fill this message with portlet specific data
		      	  this.getMessage().put(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME, map.get("MESSAGE_LISTENER_CLASS_NAME").toString());
		      	  this.getMessage().put(SchedulerEngine.PORTLET_ID, map.get("PORTLET_ID").toString());
		          this.getMessage().put(SchedulerEngine.MESSAGE_LISTENER_UUID, map.get("MESSAGE_LISTENER_UUID").toString());
		          
			      if (map.get("DESTINATION_NAME") != null) {
			    	  this.destination = map.get("DESTINATION_NAME").toString();
			    	  this.getMessage().put(SchedulerEngine.DESTINATION_NAME, map.get("DESTINATION_NAME").toString());
			    	  this.setDestinationName(map.get("DESTINATION_NAME").toString());
			    	  this.getMessage().setDestinationName(map.get("DESTINATION_NAME").toString());
			      }
			      else{
			    	LOG.info("Destination not available yet. Setting to " + DEST);
			    	this.destination = DEST;
			    	this.getMessage().put(SchedulerEngine.DESTINATION_NAME, DEST);
			    	this.setDestinationName(DEST);
			    	this.getMessage().getValues().put(SchedulerEngine.DESTINATION_NAME, DEST);
			    	this.getMessage().setDestinationName(DEST);
			      }
			      //this.getMessage().put(SchedulerEngine.DESTINATION_NAME,  this.destination);
		          //this.setDestinationName(this.destination);
			    
			     // LOG.info("Initilizing :" + this.schedulerName +" "+ this.getTrigger().toString());    
			    }   
			  }
			 } catch (SchedulerException e) {  
				 LOG.warn(e);  
			 } 		
	}
	  

	@Override
    public void receive(Message message) throws MessageListenerException {
       //Debug Information on running job
		this.LOG.info("Portlet Scheduler running...");
       
       Map<String, Object> map = message.getValues();
       for (Map.Entry<String, Object> entry : map.entrySet())
       {
    	   this.LOG.info(entry.getKey() + "/" + entry.getValue());
        
       }
       
    }
    
    
    /**
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws SchedulerException 
     * @throws Exception 
     * @throws InstantiationException 
     * 
     * 
     */
	public void start() throws ClassNotFoundException, InstantiationException, IllegalAccessException {	
		try {  		
			    
			       	Map<String, Object> map = this.getMessage().getValues();  
			      	  String portletId = map.get("PORTLET_ID").toString();
			      	  String listenerName = map.get("MESSAGE_LISTENER_CLASS_NAME").toString();
			      	  int exceptionsMaxSize = Integer.valueOf(map.get("EXCEPTIONS_MAX_SIZE").toString());
			      
			      LOG.info("Message :" + this.getMessage().getString(SchedulerEngine.PORTLET_ID) +" "+ this.getMessage().getString(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME)+ " "+this.getMessage().getString(SchedulerEngine.DESTINATION_NAME)); 
			     
			      TriggerState state = SchedulerEngineHelperUtil.getJobState(this.getJobName(), this.getGroupName(), this.getStorageType());
			      
			      if (state.equals(TriggerState.UNSCHEDULED)){
			    	  LOG.info("Scheduling :" + this.schedulerName +" "+ this.getTrigger().toString());  
			    	  LOG.info("New Message "+this.getMessage().toString());
			    	
			   
			    	  //Register Listener for  Class (this will register your class to all messages for destinationName)
			    	  //Class<?> listenerClass = Class.forName(this.schedulerName);	
			    	  //LOG.info("Registering :" + listenerClass.getName());
			    	  // MessageBusUtil.registerMessageListener(this.getDestinationName(), (MessageListener)  listenerClass.newInstance());
	                  
			    	  ClassLoader classLoader = PortletClassLoaderUtil.getClassLoader(portletId); //Where portletID is not null
			    	  Class<MessageListener> messageListener = (Class<MessageListener>) classLoader.loadClass(this.schedulerName);
			    	  MessageBusUtil.registerMessageListener(this.getDestinationName(), (MessageListener)  messageListener.newInstance());
	                  
			    	  this.getMessage().put(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME, messageListener.getName());
			    	  
			    	  SchedulerEngineHelperUtil.schedule(this.getTrigger(), this.getStorageType(), this.getDescription(), this.destination, this.getMessage(), exceptionsMaxSize);     
			      }
			      else{
			    	  LOG.warn("Scheduler could not be scheduled beacuse it was in state "+state);
			      }
			  
			 } catch (SchedulerException e) {  
			   LOG.warn(e);  
			 } catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}
    
    /** Stops Scheduler 
     * 
     * 
     */
    public void stop(){
		try {  
			
			    LOG.info("Message :" + this.getMessage().toString()); 
		       	Map<String, Object> map = this.getMessage().getValues();  
		      	  String portletId = map.get("PORTLET_ID").toString();
		      	  String listenerName = map.get("MESSAGE_LISTENER_CLASS_NAME").toString();		      		    
		      	
		      LOG.info("Message :" + portletId +" "+ listenerName); 
		      
		      TriggerState state = SchedulerEngineHelperUtil.getJobState(this.getJobName(), this.getGroupName(), this.getStorageType());
		      
		      if (state.equals(TriggerState.NORMAL)){
			      this.LOG.info("Unscheduling :" + this.schedulerName +" "+ this.getTrigger().toString());  
			      SchedulerEngineHelperUtil.unschedule(this.getJobName(), this.getGroupName(), this.getStorageType());  
		      }
		      else{
		    	 LOG.warn("Scheduler could not be unscheduled beacuse it was in state "+state); 
		      }
			  
			 } catch (SchedulerException e) {  
				 LOG.warn(e);  
			 } 
	}
    
    
    
}
 

 
