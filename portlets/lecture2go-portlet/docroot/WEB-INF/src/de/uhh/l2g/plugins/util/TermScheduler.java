package de.uhh.l2g.plugins.util;

import java.util.Calendar;
import java.util.Date;

import com.liferay.portal.kernel.exception.SystemException;
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
public final class TermScheduler extends PortletScheduler implements
		MessageListener {

	private int wise = 36; // 36th week of the year ca. 4 weeks before winter term
	private int sose = 10; // 10th week of the ca. 4 weeks before summer term
	
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
		LOG.info("Term Scheduler running "
				+ message.getValues().get(SchedulerEngine.JOB_NAME).toString()
				+ "...");
		// Do Job
		Date dt = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		Term term = new TermImpl();

		// represent year as a string
		int year = cal.get(Calendar.YEAR);
		String yearString = String.valueOf(year).substring(2);
		System.out.println("year: " + yearString + "week: " + cal.get(Calendar.WEEK_OF_YEAR));

		// checks if month is april
		if (cal.get(Calendar.WEEK_OF_YEAR) == sose) {
			String prefix = "SoSe";
			term.setYear(yearString);
			term.setPrefix(prefix);
		}
		// checks if month is october
		else if (cal.get(Calendar.WEEK_OF_YEAR) == wise) {
			String prefix = "WiSe";
			int nextYear = ++year;
			String nextYearString = String.valueOf(nextYear).substring(2);
			// System.out.println("this year is: " + yearString +
			// " and next year: " + nextYearString);
			String composedYear = yearString + "/" + nextYearString;
			term.setYear(composedYear);
			term.setPrefix(prefix);
		}
		//
		try {
			TermLocalServiceUtil.addTerm(term);
		} catch (SystemException e) {
			System.out.println(e);
		}
	}

	public void start() {
		super.schedule();
		LOG.info("Wintersemester Scheduler start.");
	}

	public void stop() {
		super.unschedule();
		LOG.info("Wintersemester Scheduler stop.");
	}
	
	public void init(String schedulerClassName, ServiceContext serviceContext) {
        super.initScheduler(schedulerClassName,serviceContext);
	}
}