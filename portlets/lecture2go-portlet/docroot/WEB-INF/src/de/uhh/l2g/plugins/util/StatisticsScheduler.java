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

import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.service.ServiceContext;


/** Statistics is less flawed when running job at concrete time (ideally around midnight)  
 *  
 * The Class StatisticsSheduler.
 */
@SuppressWarnings("serial")
public class StatisticsScheduler extends PortletScheduler implements MessageListener {  
	private static Log LOG;	
	
	  
    public StatisticsScheduler(){
    	super();
    	LOG = LogFactoryUtil.getLog(StatisticsScheduler.class.getName());
    }
    
	public StatisticsScheduler(String schedulerClassName, ServiceContext serviceContext) {
		super(StatisticsScheduler.class.getName(), serviceContext);
	    this.schedulerClassName = StatisticsScheduler.class.getName();
	    LOG = LogFactoryUtil.getLog(StatisticsScheduler.class.getName());
	}

	@Override
    public void receive(Message message) throws MessageListenerException {
	   //uncoment for further debug messages
	   //super.receive(message);
		LOG.info("Statistics Scheduler running "+message.getValues().get(SchedulerEngine.JOB_NAME).toString()+"...");
	   //Do Job....
		
		LOG.info("Statistics Scheduler finished.");
    }
	
	public void start() {
        super.start();
	}
	
	public void stop() {
		super.stop();
	}

	public void init(String schedulerClassName, String portletId) {
        super.initScheduler(schedulerClassName,portletId);
	}
  
    
}
 

 
