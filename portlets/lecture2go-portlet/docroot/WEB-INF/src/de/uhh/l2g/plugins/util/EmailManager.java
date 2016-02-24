package de.uhh.l2g.plugins.util;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

/**
 * The Class EmailManager.
 */
public class EmailManager extends MailEngine {
	
	/**
	 * Send email.
	 *
	 * @param from the from
	 * @param to the to
	 * @param subject the subject
	 * @param body the body
	 * @return true, if successful
	 */
	public boolean sendEmail(String from, String to, String subject, String body){
		boolean ret = false;
		InternetAddress fadss = null;
		InternetAddress[] tadss = null;
		InternetAddress[] cadss = null;
		//try to send 
		try {
			try {
				fadss =  new InternetAddress(from);
				tadss = InternetAddress.parse(to);
				cadss = InternetAddress.parse(from);
			} catch (AddressException e) {
				e.printStackTrace();
			}
			send(fadss, tadss, cadss, subject, body);
			ret = true;
		} catch (MailEngineException e) {
			e.printStackTrace();
		}
		//email successfully sent
		return ret;
	}
}

