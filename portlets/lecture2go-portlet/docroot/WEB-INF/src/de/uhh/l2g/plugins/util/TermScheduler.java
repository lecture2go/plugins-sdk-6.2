package de.uhh.l2g.plugins.util;

import java.util.Calendar;
import java.util.Date;

import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.impl.TermImpl;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;


/*
 * Checks via cron job periodically what month it is and according to that adds a new Term
 *
 *
 */
public final class TermScheduler extends PortletScheduler implements MessageListener {

	private int wise = 9; // begins October
	private int sose = 3; // begins April
	
	public int getWise() {
		return wise;
	}

	public void setWise(int wise) {
		this.wise = wise;
	}

	public int getSose() {
		return sose;
	}

	public void setSose(int sose) {
		this.sose = sose;
	}

	public TermScheduler() {
		super();
		LOG = LogFactoryUtil.getLog(TermScheduler.class.getName());
	}

	@Override
	public void receive(Message message) throws MessageListenerException {
		// uncoment for further debug messages
		// super.receive(message);
		LOG.info("Term Scheduler running " + message.getValues().get(SchedulerEngine.JOB_NAME).toString() + "...");
		
		// Do Job
		Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);

		Term term = new TermImpl();
		// represent year as a string
		int year = cal.get(Calendar.YEAR);
		String yearString = String.valueOf(year).substring(2);
		
		boolean create = false;
		// prepare for sose
		if (month >= (sose-1) && month <= sose) {
			String prefix = "SoSe";
			term.setYear(yearString);
			term.setPrefix(prefix);
			create = true;
		}
		//prepare for wise
		if (month >= (wise-1) && month <= wise) {
			String prefix = "WiSe";
			int nextYear = ++year;
			String nextYearString = String.valueOf(nextYear).substring(2);
			// System.out.println("this year is: " + yearString +
			// " and next year: " + nextYearString);
			String composedYear = yearString + "/" + nextYearString;
			term.setYear(composedYear);
			term.setPrefix(prefix);
			create = true;
		}
		// create if not yet done
		try {
			int foundedTerms = 0;
			foundedTerms = TermLocalServiceUtil.getByPrefixAndYear(term.getPrefix(), term.getYear()).size();
			
			if(foundedTerms==0 && create == true){
				TermLocalServiceUtil.addTerm(term);
			}
			LOG.info("Term Scheduler finished.");
		} catch (Exception e) {
			LOG.info("Error runnig the term scheduler.");
		} 
	}

	public void start() {
		super.schedule();
		LOG.info("Scheduler start.");
	}

	public void stop() {
		super.unschedule();
		LOG.info("Scheduler stop.");
	}
	
	public void init(String schedulerClassName, ServiceContext serviceContext) {
        super.initScheduler(schedulerClassName,serviceContext);
	}
}