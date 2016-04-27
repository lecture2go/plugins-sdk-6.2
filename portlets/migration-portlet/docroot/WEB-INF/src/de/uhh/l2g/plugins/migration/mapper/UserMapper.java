package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;

import de.uhh.l2g.plugins.migration.model.LegacyContact;
import de.uhh.l2g.plugins.migration.model.LegacyUser;

public class UserMapper {
	
	public static User mapUser(long companyId, User user, LegacyUser legacyUser, LegacyContact legacyContact, long contactId) {
        user.setCompanyId(companyId);
        user.setJobTitle(legacyContact.getJobTitle()); // function in company
        user.setPasswordEncrypted(true);
        user.setPassword("{SHA}"+legacyUser.getPassword());
        user.setPasswordReset(true);
        user.setFirstName(legacyContact.getFirstName());
        user.setLastName(legacyContact.getLastName());
        user.setScreenName(legacyUser.getScreenName());
        user.setContactId(contactId);
        user.setLastLoginDate(legacyUser.getLastLoginDate());
        user.setLastLoginIP(legacyUser.getLastLoginIP());
        user.setLoginIP(legacyUser.getLoginIP());
        user.setFailedLoginAttempts(legacyUser.getFailedLoginAttempts());
        user.setGraceLoginCount(legacyUser.getGraceLoginCount());
        user.setGreeting(legacyUser.getGreeting());
        user.setCreateDate(legacyUser.getCreateDate());
        user.setCreateDate(legacyUser.getModifiedDate());
        user.setLdapServerId(-1);
        user.setLanguageId(legacyUser.getLanguageId());
    	user.setEmailAddress(legacyUser.getEmailAddress());
    	user.setStatus((legacyUser.isActive() ? WorkflowConstants.STATUS_APPROVED : WorkflowConstants.STATUS_INACTIVE));
		return user;
	}

}
