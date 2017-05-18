package de.uhh.l2g.plugins.migration.mapper;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Contact;

import de.uhh.l2g.plugins.migration.model.LegacyContact;

public  final class ContactMapper {
	static final Log log = LogFactoryUtil.getLog(ContactMapper.class); 
	
	public static Contact mapContact(Contact contact, LegacyContact legacyContact, long userId, long companyId) {
		if (contact == null || legacyContact == null) {
			log.warn("can't execute method with null values - return contact as null value");
			return null;
		}
		contact.setBirthday(legacyContact.getBirthday());
		contact.setCreateDate(legacyContact.getCreateDate());
		contact.setModifiedDate(legacyContact.getModifiedDate());
		contact.setUserName(legacyContact.getUserName());
		contact.setJobTitle(legacyContact.getJobTitle());
		contact.setUserId(userId);
		contact.setCompanyId(companyId);
		return contact;
	} 

}
