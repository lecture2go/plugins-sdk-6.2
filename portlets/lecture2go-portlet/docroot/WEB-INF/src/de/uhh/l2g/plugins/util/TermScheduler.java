package de.uhh.l2g.plugins.util;

import java.util.Calendar;
import java.util.Date;

import com.liferay.portal.TermsOfUseException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.NoSuchTermException;
import de.uhh.l2g.plugins.admin.ThreadManagement;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.impl.TermImpl;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;


/*
 * Checks via cron job periodically what it is and according to that adds a new Term 
 * 
 */
public final class TermScheduler extends PortletScheduler implements
		MessageListener {

	public Date dt = new Date();

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
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		Term term = new TermImpl();

		// represent year as a string
		int year = cal.get(Calendar.YEAR);
		String yearString = String.valueOf(year).substring(2);
		System.out.println("year: " + yearString);

		// checks if month is april
		if (cal.get(Calendar.MONTH) == 3) {
			String prefix = "SoSe";
			term.setYear(yearString);
			term.setPrefix(prefix);

			try {
				TermLocalServiceUtil.addTerm(term);
			} catch (SystemException e) {
				System.out.println(e);
			}
		}
		// checks if month is october
		else if (cal.get(Calendar.MONTH) == 9) {
			String prefix = "WiSe";
			int nextYear = ++year;
			String nextYearString = String.valueOf(nextYear).substring(2);
			// System.out.println("this year is: " + yearString +
			// " and next year: " + nextYearString);
			String composedYear = yearString + "/" + nextYearString;
			term.setYear(composedYear);
			term.setPrefix(prefix);

			try {
				TermLocalServiceUtil.addTerm(term);
			} catch (SystemException e) {
				System.out.println(e);
			}
			/*
			 * try { System.out.println(TermLocalServiceUtil.getAllSemesters());
			 * } catch (SystemException e) { System.out.println(e); }
			 */

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

}
