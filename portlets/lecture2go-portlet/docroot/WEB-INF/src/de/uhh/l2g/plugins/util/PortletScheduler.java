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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.TriggerState;
import com.liferay.portal.kernel.scheduler.messaging.ReceiverKey;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.PortletLocalServiceUtil;



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
	
	 
	  protected static Log LOG;	
	  protected String schedulerName; 
	  protected String destination;
	  protected String receiverKey;
	 // protected final String DEST = "l2g/Scheduler";
	  protected final String DEST = DestinationNames.SCHEDULER_DISPATCH;
	

	  public PortletScheduler(){
		  this.schedulerName = PortletScheduler.class.getName();
		  this.LOG = LogFactoryUtil.getLog(PortletScheduler.class.getName());
		  
	  }
	 /** Retrieve initialization Data form List of scheduled Jobs
	  *  
	  * */
	 public PortletScheduler(String schedulerClassName){
		this.schedulerName = schedulerClassName;
		LOG = LogFactoryUtil.getLog(schedulerClassName);
		 
		try {  
			  List<SchedulerResponse> scheduledJobs = SchedulerEngineHelperUtil.getScheduledJobs();  
			  for (SchedulerResponse resp : scheduledJobs) {  
				LOG.info(resp.getJobName()+resp.getDestinationName() );
			    if (resp.getJobName().equalsIgnoreCase(this.schedulerName)) { 
			    	
			      this.setJobName(resp.getJobName());
			      this.setGroupName(resp.getGroupName());  
			      this.setStorageType(resp.getStorageType()); 
			      this.setDescription(resp.getDescription());
			      this.setMessage(resp.getMessage());
			      this.setTrigger(resp.getTrigger());
			      
			      if (this.getMessage() == null) this.setMessage(new Message());
			      LOG.info("Job found. Copy Portlet Information: "+this.getMessage().toString());
			      Map<String, Object> map = this.getMessage().getValues();
			     			      	  
			      //Fill this message with portlet specific data
				  if (map.containsKey(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME)) this.getMessage().put(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME, map.get(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME).toString());
		      	  if (map.containsKey(SchedulerEngine.PORTLET_ID)) this.getMessage().put(SchedulerEngine.PORTLET_ID, map.get(SchedulerEngine.PORTLET_ID).toString());
		          if (map.containsKey(SchedulerEngine.MESSAGE_LISTENER_UUID)) this.getMessage().put(SchedulerEngine.MESSAGE_LISTENER_UUID, map.get(SchedulerEngine.MESSAGE_LISTENER_UUID).toString());
		          
		          LOG.info(this.getMessage().get(SchedulerEngine.DESTINATION_NAME) +" "+
		        		  this.getMessage().getDestinationName() +" "+
		        		  this.getMessage().getValues().get(SchedulerEngine.DESTINATION_NAME)+" "+
		        		  this.getMessage().getDestinationName());
		          
			      if (map.containsKey("MESSAGE_LISTENER_CLASS_NAME") && map.get("DESTINATION_NAME") != null) {
			    	  this.destination = map.get("DESTINATION_NAME").toString();
			    	  //this.getMessage().put(SchedulerEngine.DESTINATION_NAME, map.get("DESTINATION_NAME").toString());
			    	  this.getMessage().getValues().put(SchedulerEngine.DESTINATION_NAME, map.get("DESTINATION_NAME").toString());
			    	  this.getMessage().setDestinationName(this.getMessage().getValues().get(SchedulerEngine.DESTINATION_NAME).toString());
			      		 
			      }
			      else{
			    	LOG.info("Destination not available yet. Setting to " + DEST);
			    	this.destination = DEST;
			    	//this.getMessage().put(SchedulerEngine.DESTINATION_NAME, DEST);
			    	this.getMessage().getValues().put(SchedulerEngine.DESTINATION_NAME, DEST);
			    	this.getMessage().setDestinationName(this.getMessage().getValues().get(SchedulerEngine.DESTINATION_NAME).toString());
		      		 
			      }
			      //new ReceiverKey(this.getJobName(), this.getGroupName())
			      //this.getMessage().put(SchedulerEngine.RECEIVER_KEY, "com.liferay.portal.kernel.scheduler.messaging.ReceiverKey@f1a2001c");
			      LOG.info("ReceiverKey: "+new ReceiverKey(this.getJobName(), this.getGroupName())); 
			      TriggerState state = SchedulerEngineHelperUtil.getJobState(this.getJobName(), this.getGroupName(), this.getStorageType());   
			      LOG.info(state);
			    }   
			  }
			 } catch (SchedulerException e) {  
				 LOG.warn(e);  
			 } 		
	}
	  

	@Override
    public void receive(Message message) throws MessageListenerException {
       //Debug Information on running job
		LOG.info("Portlet Scheduler running...");
       
       Map<String, Object> map = message.getValues();
       for (Map.Entry<String, Object> entry : map.entrySet())
       {
    	   LOG.info(entry.getKey() + "/" + entry.getValue());
        
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
	protected void start() {	
		int exceptionsMaxSize = 0;
		try {  		
			        LOG.info("Starting :" + this.getMessage().toString()); 
			       	Map<String, Object> map = this.getMessage().getValues();  
			       	String portletId = "";
			       	String listenerName = "";
			    
			       	if (map.containsKey(SchedulerEngine.PORTLET_ID)) portletId = map.get(SchedulerEngine.PORTLET_ID).toString();
			       	if (map.containsKey(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME)) listenerName = map.get(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME).toString();
			    	if (map.containsKey(SchedulerEngine.EXCEPTIONS_MAX_SIZE)) exceptionsMaxSize = Integer.valueOf(map.get(SchedulerEngine.EXCEPTIONS_MAX_SIZE).toString());
			      
			      	  LOG.info("Message :" + portletId +" "+ listenerName + " "+this.getDestinationName()); 
			     
			      	  TriggerState state = SchedulerEngineHelperUtil.getJobState(this.getJobName(), this.getGroupName(), this.getStorageType());
			      
			      	  if (state == null || state.equals(TriggerState.UNSCHEDULED)){
			      		  this.getMessage().put(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME, this.schedulerName);
			      		  this.getMessage().setDestinationName(this.getMessage().getValues().get(SchedulerEngine.DESTINATION_NAME).toString());
			      		  this.getMessage().put(SchedulerEngine.RECEIVER_KEY, this.getMessage().getValues().get(SchedulerEngine.RECEIVER_KEY).toString());
			      		  LOG.info("Scheduling :" + this.schedulerName +" "+ this.getTrigger().toString());  
			      		  LOG.info("New Message "+this.getMessage().toString());
			      		  
			   	       Thread thread = Thread.currentThread();
				       LOG.info("Thread :" + thread.getContextClassLoader() + thread.toString());

			      		 //SchedulerEngineHelperUtil.update(this.getTrigger(), this.getStorageType());
			      		  SchedulerEngineHelperUtil.schedule(this.getTrigger(), this.getStorageType(), this.getDescription(), this.destination, this.getMessage(), exceptionsMaxSize);     
					 
			      	  }
			      	  else{
			      		  LOG.warn("Scheduler could not be scheduled beacuse it was in state "+state);
			     	  }
			  
			 	} catch (SchedulerException e) {  
			 		LOG.warn("", e);  
			 	} catch (IllegalArgumentException e) {
			 		LOG.warn(e); 				
			   }// catch (SecurityException e) {
			   //     LOG.warn(e); 
			  //} catch (ClassNotFoundException e) {				
			 //     LOG.warn(e);
			//}
		
	}
    
    /** Stops Scheduler 
     * 
     * 
     */
    protected void stop(){
    	try {  
    		
    		List<SchedulerResponse> scheduledJobs = SchedulerEngineHelperUtil.getScheduledJobs();  

    		 for (SchedulerResponse resp : scheduledJobs) {  
    	          if (resp.getJobName().equalsIgnoreCase(this.schedulerName)) {  
    	        	  
    	        	  LOG.info("Stopping :" + resp.toString()); 
    	        	  Map<String, Object> map = resp.getMessage().getValues(); 
    	        	  
    			      String portletId = "";
    			      String listenerName = "";
    			 
    			      if (map.containsKey(SchedulerEngine.PORTLET_ID)) portletId = map.get(SchedulerEngine.PORTLET_ID).toString();
    			      if (map.containsKey(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME)) listenerName = map.get(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME).toString();
      
    	        	  LOG.info("Associated to :" + portletId +" "+ listenerName+" "+this.destination); 
		      
    	        	  TriggerState state = SchedulerEngineHelperUtil.getJobState(resp.getJobName(), resp.getGroupName(), resp.getStorageType());
		      
    	        	  if (state.equals(TriggerState.NORMAL)){
    	        		  
    	       	       Thread thread = Thread.currentThread();
    	    	       LOG.info("Thread :" + thread.getContextClassLoader() + thread.toString());
    	    	       
    	        		  LOG.info("Unscheduling :" + this.schedulerName +" "+ resp.getTrigger().toString()); 
    	        		  SchedulerEngineHelperUtil.unschedule(resp.getJobName(), resp.getGroupName(), resp.getStorageType());
      	  				  SchedulerEngineHelperUtil.delete(resp.getJobName(), resp.getGroupName(), resp.getStorageType()); 
    	        		  
    	        	  }
    	        	  else{
    	        		  LOG.warn("Scheduler could not be unscheduled beacuse it was in state "+state); 
    	        	  }
    	          } 
    			}
			  
			 } catch (SchedulerException e) {  
				 LOG.warn("Failed to unschedule job"+ this.schedulerName, e);  
			 } 
	}
    
    /**Unschedules and deletes all Jobs associated with this Listener Class' 
     * 
     * Assumes Job and Group Name are equal
     */
    public void stopAll(){
    	  if (this.schedulerName != null && this.schedulerName != ""){
    		  List<SchedulerResponse> scheduledJobs;
    		  try {
				scheduledJobs = SchedulerEngineHelperUtil.getScheduledJobs();
    	  		for (SchedulerResponse resp : scheduledJobs) {  
    	  			if (resp.getJobName().equalsIgnoreCase(this.schedulerName)) { 
    	  				SchedulerEngineHelperUtil.unschedule(resp.getJobName(), resp.getGroupName(), resp.getStorageType());
    	  			}  	  			
    	  		}
    	  		LOG.warn("Removed all Schedulers associated with "+this.schedulerName);
    		  }
    		  catch (SchedulerException e) {
    			  LOG.error("Could not retrieve ScheduledJobs");
    		  }   		  
    	  }else {
    		  LOG.info("No Scheduler set!");
    	  }    
    }
    
    /**Unschedules and deletes all Jobs associated with this Listener Class' 
     * 
     * Assumes Job and Group Name are equal
     */
    public void killAll(){
    	  if (this.schedulerName != null && this.schedulerName != ""){
    		  List<SchedulerResponse> scheduledJobs;
    		  try {
				scheduledJobs = SchedulerEngineHelperUtil.getScheduledJobs();
    	  		for (SchedulerResponse resp : scheduledJobs) {  
    	  			if (resp.getJobName().equalsIgnoreCase(this.schedulerName)) { 
    	  				SchedulerEngineHelperUtil.unschedule(resp.getJobName(), resp.getGroupName(), resp.getStorageType());
    	  				SchedulerEngineHelperUtil.delete(resp.getJobName(), resp.getGroupName(), resp.getStorageType());
    	  			}  	  			
    	  		}
    	  		LOG.warn("Removed all Schedulers associated with "+this.schedulerName);
    		  }
    		  catch (SchedulerException e) {
    			  LOG.error("Could not retrieve ScheduledJobs");
    		  }   		  
    	  }else {
    		  LOG.info("No Scheduler set!");
    	  }    
    }
    
    public static List<PortletScheduler> ListSchedulers(){
    	List<PortletScheduler> schedulers = new LinkedList<PortletScheduler>();
    	PortletScheduler psch = null;
    	int i=1;
    	 try {
				List<SchedulerResponse> scheduledJobs = SchedulerEngineHelperUtil.getScheduledJobs();
 	  		    for (SchedulerResponse resp : scheduledJobs) {  
 	  		    	if (resp != null && resp.getJobName().contains("l2g")){
 	  		    		psch = new PortletScheduler();
 	
	 	  		    	LOG.info(resp.toString());
	 	  		    	psch.setJobName(resp.getJobName());
	 	  		    	psch.setGroupName(resp.getGroupName());  
	 	  		    	psch.setStorageType(resp.getStorageType()); 
	 	  		    	psch.setDescription(resp.getDescription());
	 	  		    	psch.setMessage(resp.getMessage());
	 	  		    	psch.setTrigger(resp.getTrigger());
	 	  		        TriggerState state = SchedulerEngineHelperUtil.getJobState(resp.getJobName(), resp.getGroupName(), resp.getStorageType());
	 	  		        schedulers.add(psch);
	 	  		        LOG.info(psch.getJobName());
 	  		    	}
 	  		        
 	  		    }
 	  		    
    	  }catch (SchedulerException e) {
   			  LOG.error("Could not retrieve ScheduledJobs");
   		  }
		return schedulers; 
    }
     
 
    /**		if (PropsValues.SCHEDULER_ENABLED) {
			List<SchedulerEntry> schedulerEntries =
				portlet.getSchedulerEntries();

			if ((schedulerEntries != null) && !schedulerEntries.isEmpty()) {
				for (SchedulerEntry schedulerEntry : schedulerEntries) {
					SchedulerEngineHelperUtil.unschedule(
						schedulerEntry, StorageType.MEMORY_CLUSTERED);
				}
			}
		}
     * 
     * @param portletId
     * @return
     */
     public static List<SchedulerEntry> ListSchedulerEntriess(String portletId){
    	 Portlet portlet = PortletLocalServiceUtil.getPortletById(portletId);
    	 List<SchedulerEntry> jobs = new LinkedList<SchedulerEntry>();
    	 
    	 jobs = portlet.getSchedulerEntries();
		    for (SchedulerEntry job : jobs) {  
		    	LOG.info(job.toString());
		    }
    	 
    	 return jobs;
    	 }
}
 

 
