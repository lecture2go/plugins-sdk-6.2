package de.uhh.l2g.plugins.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.admin.ThreadManagement;

/**
 * The Class DatabaseThread.
 */
public final class VideohitlistScheduler extends PortletScheduler implements MessageListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Log LOG;	
	
    public VideohitlistScheduler(){
    	super();
    	LOG = LogFactoryUtil.getLog(VideohitlistScheduler.class.getName());
    }
    
	public VideohitlistScheduler(String schedulerClassName, ServiceContext serviceContext) {
		super(VideohitlistScheduler.class.getName(), serviceContext);
	    this.schedulerClassName = VideohitlistScheduler.class.getName();
	    LOG = LogFactoryUtil.getLog(this.schedulerClassName);
	}
	
	@Override
    public void receive(Message message) throws MessageListenerException {
	   //uncoment for further debug messages
	   //super.receive(message);
		LOG.info("Videohitlist Scheduler running "+message.getValues().get(SchedulerEngine.JOB_NAME).toString()+"...");
	   //Do Job
		ThreadManagement tm = new ThreadManagement();
		try {
			tm.createPopularVideoList();
			LOG.info("Videohitlist Scheduler finished.");
		} catch (SystemException e) {
			LOG.info("Videohitlist Scheduler failed.");
		}
    }	
	
	public void start() {
        super.start();
        LOG.info("Videohitlist Scheduler start.");
	}
	
	public void stop() {
		super.stop();
		LOG.info("Videohitlist Scheduler stop.");
	}

	public void init(String schedulerClassName, String portletId) {
        super.initScheduler(schedulerClassName,portletId);
	}

}
