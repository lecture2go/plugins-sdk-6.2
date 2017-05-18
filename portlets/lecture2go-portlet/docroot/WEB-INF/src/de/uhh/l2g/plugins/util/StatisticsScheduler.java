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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;

import de.uhh.l2g.plugins.service.StatisticLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;


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
    
	@Override
    public void receive(Message message) throws MessageListenerException {
	   //uncoment for further debug messages
	   //super.receive(message);
	   LOG.info("Statistics Scheduler running "+message.getValues().get(SchedulerEngine.JOB_NAME).toString()+"...");
	   //Do Job....
	   int privateVideos = 0;
	   int publicVideos = 0;
	   try {
		   publicVideos=VideoLocalServiceUtil.getByOpenAccess(1).size();
		   privateVideos=VideoLocalServiceUtil.getByOpenAccess(0).size();
		   //TODO can not get the service context for using the addEntry method, because of the scheduler! And can't find workaround.
		   StatisticLocalServiceUtil.add(privateVideos, publicVideos);
	   } catch (PortalException e) {
		   LOG.info("Statistics Scheduler failed.");
	   } catch (SystemException e) {
		   LOG.info("Statistics Scheduler failed.");
	   }
	   //Job end
	   LOG.info("Statistics Scheduler finished.");
    }
	
	public void start() {
        super.schedule();
	}
	
	public void stop() {
		super.unschedule();
	}
    
}
 

 
