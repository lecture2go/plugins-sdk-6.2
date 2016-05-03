package de.uhh.l2g.plugins.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.service.ServiceContext;

/**
 * The Class DatabaseThread.
 */
public final class AutocompleteScheduler extends PortletScheduler implements MessageListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public AutocompleteScheduler(){
    	super();
    	LOG = LogFactoryUtil.getLog(VideohitlistScheduler.class.getName());
    }
    
	public AutocompleteScheduler(String schedulerClassName, ServiceContext serviceContext) {
		super(AutocompleteScheduler.class.getName(), serviceContext);
	    this.schedulerClassName = AutocompleteScheduler.class.getName();
	    LOG = LogFactoryUtil.getLog(this.schedulerClassName);
	}
	
	@Override
    public void receive(Message message) throws MessageListenerException {
	   //uncoment for further debug messages
	   //super.receive(message);
		LOG.info("Autocomplete Scheduler running "+message.getValues().get(SchedulerEngine.JOB_NAME).toString()+"...");
	   //Do Job
		try {
			AutocompleteManager.generateAutocompleteResults();
			LOG.info("Autocomplete Scheduler finished.");
		} catch (SystemException e) {
			LOG.info("Autocomplete Scheduler failed.");
		}
    }	
	
	public void start() {
        super.start();
        LOG.info("Autocomplete Scheduler start.");
	}
	
	public void stop() {
		super.stop();
		LOG.info("Autocomplete Scheduler stop.");
	}

	public void init(String schedulerClassName, ServiceContext serviceContext) {
        super.initScheduler(schedulerClassName,serviceContext);
	}

}
