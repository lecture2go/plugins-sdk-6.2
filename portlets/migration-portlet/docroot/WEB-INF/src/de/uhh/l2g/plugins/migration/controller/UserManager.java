package de.uhh.l2g.plugins.migration.controller;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import de.uhh.l2g.plugins.migration.mapper.AddressMapper;
import de.uhh.l2g.plugins.migration.mapper.ContactMapper;
import de.uhh.l2g.plugins.migration.mapper.UserMapper;
import de.uhh.l2g.plugins.migration.model.LegacyAddress;
import de.uhh.l2g.plugins.migration.model.LegacyContact;
import de.uhh.l2g.plugins.migration.model.LegacyUser;
import de.uhh.l2g.plugins.migration.service.LegacyAddressLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyContactLocalServiceUtil;


/**
 * This Class outsources all relveant opertations to migrate a user. 
 * This class uses the singelton pattern, to ensure to be created once. 
 * @author salow
 *
 */
public class UserManager {
    private static final Log log = LogFactoryUtil.getLog(UserManager.class);
    private String logInfoString = "";
    
    
    private static final UserManager INSTANCE = new UserManager();
    
    private UserManager() {
        
    }
    public static UserManager getInstance() {
        return INSTANCE;
    }
    
    
    
    
    /**
     * Public method invoked by the overal migration controller. It Creates a user on specific parameters.
     *
     * @throws SystemException
     * @throws PortalException
     * @throws IOException
     */
    /**
     * @param legacyUser - LegacyUser Object specified trough service.xml 
     * @param companyId - current Company id of Liferay Target System
     * @param sites - Sites the user has to be linked to 
     * @param request  Action Request to return logging information, and successfull flag.
     * @throws SystemException
     * @throws PortalException
     */
    public void createUser(LegacyUser legacyUser, long companyId, String sites, ActionRequest request) throws SystemException, PortalException   {
        long currentUserId = Long.valueOf(request.getRemoteUser());
        User currentUser = null;
        try {
            currentUser = UserLocalServiceUtil.getUser(currentUserId);
        } catch (PortalException e) {
            log.error("There is no current user.");
        } catch (SystemException e) {
            log.error("There is no current user.");
        }
        
        
        /* Read data from LegacyUser and LegacyContact. */
        LegacyContact legacyContact;
        legacyContact = LegacyContactLocalServiceUtil.getLegacyContact(legacyUser.getContactId());
        /*
         * 1) Read out legacy user data
         * 2) Check if user is valid to be updated 
         * 3) if yes do update of existing user or create a new one (
         *      a) call createOrGetID Methods 
         *      b) call createOrUpdate Methods
         */
        
        logInfo("Legacy User loaded: " + legacyContact.getFirstName() + " " + legacyContact.getLastName() + " with mailAddress " + legacyUser.getEmailAddress());       
        User nullOrUserObject = null;
        try {
            nullOrUserObject = UserLocalServiceUtil.getUserByEmailAddress(companyId, legacyUser.getEmailAddress());
        } catch (Exception e) {
            log.info("User not found by mailAddress in LF62 DB.");
        }
        
        
        // Bullet 2) passed? 
        if (currentUser != null && !legacyUser.getEmailAddress().equals("default@liferay.com")  && !legacyUser.getEmailAddress().equals("default@")  && !legacyUser.getEmailAddress().equals(currentUser.getEmailAddress())) {
            
            logInfo("Migrating " + legacyContact.getFirstName() + " " + legacyContact.getLastName() + " with mailAddress " + legacyUser.getEmailAddress());
            
            // Get (new) IDs
            // following bullet a) call createOrGetID Methods
            long contactId = createOrGetContactId(nullOrUserObject);
            long userId = createOrGetUserId(nullOrUserObject);
            long personalGroupId = createOrGetPersonalGroupId(companyId,  String.valueOf(userId));
            
            // Call as mentioned in bullet b) createOrUpdate Methods
            logInfo("Creating Contact");
            Contact contact = createOrUpdateContact(companyId,contactId,userId,legacyContact);
            logInfo("Contact created");
            logInfo("Creating User with legacyContactID " + legacyContact.getContactId() + " contactId: " + contactId);
            User user = createOrUpdateUser(companyId, nullOrUserObject, userId, legacyUser, legacyContact, contactId);
            createOrUpdateAddress(companyId, user, legacyUser, contact);
            createPersonalGroupIfNotExistent(companyId,  personalGroupId, userId, currentUserId, String.valueOf(userId), user.getScreenName());
            logInfo("Group created");
            createPersonalLayoutIfNotExistent(companyId,personalGroupId, true);
            logInfo(" Private Layout  created");
            createPersonalLayoutIfNotExistent(companyId, personalGroupId, false);
            logInfo(" Public Layout  created");
            
            // ADD Power User and User role
            addRolesToUser(user.getUserId(), companyId);
            logInfo(" Roles added");
            //update sites to user 
            addUserToSite(sites, userId, companyId);
            logInfo("Added user with id: " + user.getUserId());
        }
    }
    
    
    private long createOrGetUserId(User userByMail) throws SystemException {
        long userId;
        if (userByMail == null) {
            userId = CounterLocalServiceUtil.increment();
        } else {
            userId = userByMail.getUserId();
        }
        return userId;
    }
    
    private long createOrGetContactId(User userByMail) throws SystemException, PortalException {
        long contactId;
        if (userByMail == null) {
            contactId = CounterLocalServiceUtil.increment();
        } else {
            contactId = userByMail.getContactId();
        }
        return contactId;
    }
    
    
    private Contact createOrUpdateContact(long companyId, long contactId,  long userId, LegacyContact legacyContact) throws SystemException {
            
            Contact contact;
            try {
                contact = ContactLocalServiceUtil.getContact(contactId);
                contact = ContactMapper.mapContact(contact, legacyContact, userId, companyId);
                ContactLocalServiceUtil.updateContact(contact);
            } catch (Exception e) {
                contact = ContactLocalServiceUtil.createContact(contactId);
                contact = ContactMapper.mapContact(contact, legacyContact, userId, companyId);
                ContactLocalServiceUtil.addContact(contact);
            }
            
            return contact;
            
    }
    
    private void createOrUpdateAddress(long companyId, User user,  LegacyUser legacyUser,  Contact contact) throws SystemException  {
        LegacyAddress legacyAddress =  null;
        Address address = null;
        
        try {
            // if legacy user has address
            legacyAddress = LegacyAddressLocalServiceUtil.getAdressByUserIdFirst(legacyUser.getUserId());
            // load address by LF 62 user
        } catch (SystemException e1) {
            logInfo("LegacyUser did not have any address - create nothing");
            return;
        }
        
        if (legacyAddress != null) {
            try {
                // get first adress by created user -- (success on re-import)
                DynamicQuery query = DynamicQueryFactoryUtil.forClass(Address.class).add(PropertyFactoryUtil.forName("userId").eq(user.getUserId())).add(PropertyFactoryUtil.forName("companyId").eq(companyId));
                @SuppressWarnings("unchecked")
                List<Address> addresses = AddressLocalServiceUtil.dynamicQuery(query);
                // get first Address of user
                address = addresses.get(0);
                address = AddressMapper.mapAddress(address, legacyAddress, user, companyId, contact);
                AddressLocalServiceUtil.updateAddress(address);
            } catch (Exception e) {
                // created new address 
                address = AddressLocalServiceUtil.createAddress(CounterLocalServiceUtil.increment());
                address = AddressMapper.mapAddress(address, legacyAddress, user, companyId, contact);
                AddressLocalServiceUtil.addAddress(address);
            }
        }
    }

    private User createOrUpdateUser(long companyId, User nullOrUserObject, long userId, LegacyUser legacyUser, LegacyContact contact,  long contactId) {
        // Only create User if user was not imported before 
        if (nullOrUserObject == null) {
            nullOrUserObject = UserLocalServiceUtil.createUser(userId);
            nullOrUserObject = UserMapper.mapUser(companyId, nullOrUserObject, legacyUser, contact, contactId);
            try {
                UserLocalServiceUtil.addUser(nullOrUserObject);
            } catch (SystemException e) {
                logInfo("Error adding User - please check log for further details!");
                log.warn("Error adding User:" + nullOrUserObject, e);
            }
        } else {
            nullOrUserObject = UserMapper.mapUser(companyId, nullOrUserObject, legacyUser, contact, contactId);
            try {
                UserLocalServiceUtil.updateUser(nullOrUserObject);
            } catch (SystemException e) {
                logInfo("Error updating User - please check log for further details!");
                log.warn("Error updating User:" + nullOrUserObject, e);
            }
        }
        return nullOrUserObject;
    }
    
    
    private void addUserToSite(String sites, long userId, long companyId) throws SystemException, PortalException {
        String[] siteIdStrings = sites.split(",");
        for (String site: siteIdStrings) {
            log.debug("Fetching group / site  with id: \"" + site + "\"");
            long siteId = Long.valueOf(site);
            Group group = null;
            try {
                group = GroupLocalServiceUtil.getGroup(siteId);
                if (group != null) {
                    GroupLocalServiceUtil.addUserGroup(userId, group);
                    logInfo("Link user to Site/Group with name: \"" + group.getName() + "\"");
                } else {
                    log.error("NO group / site with id found : \"" + site + "\" - user not linked to group");
                }
            } catch (Exception e) {
                 log.error("NO group / site with id found : \"" + site + "\" - user not linked to group");
            }
        }
    }
    
    private void createPersonalGroupIfNotExistent(long companyId, long groupId, long userId, long creatorId,  String groupName, String friendlyUrl) throws SystemException {
            if (groupId  < 1) {
                log.error("Personal Group with id:" + groupId +  " is invalid, skip creation of group");
                return;
            } 
        
            Group userGroup = null;
            try {
                userGroup = GroupLocalServiceUtil.getGroup(groupId);
                logInfo("Personal Group found:"  + groupId + "  - do nothing");
            } catch (PortalException e) {
                logInfo("No existing Personal Group found with groupId:"  + groupId + "  - create new one"); 
                userGroup = GroupLocalServiceUtil.createGroup(groupId);
                userGroup.setClassNameId(ClassNameLocalServiceUtil.getClassNameId(User.class));
                userGroup.setClassPK(userId);
                userGroup.setCompanyId(companyId);
                userGroup.setName(groupName);
                userGroup.setFriendlyURL("/" + friendlyUrl);
                userGroup.setCreatorUserId(creatorId);
                userGroup.setTreePath("/" + groupId + "/");
                userGroup.setActive(true);
                GroupLocalServiceUtil.addGroup(userGroup);
            }
            
    }
    

    private long createOrGetPersonalGroupId(long companyId, String userIdAsString) throws SystemException, PortalException {
        long groupId = 0;
        try {
                groupId = GroupLocalServiceUtil.getGroup(companyId, userIdAsString).getGroupId();
            } catch (Exception e) {
                logInfo("Can't get groupId for user with ID: " + userIdAsString + " : createId by CounterLocalServiceUtil" );
                groupId = CounterLocalServiceUtil.increment();
            }
        return groupId;
    }
    
    private void createPersonalLayoutIfNotExistent(long companyId, long groupId, boolean privateLayout)  {
        LayoutSet layoutSet = null;
        try {
            layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, privateLayout);
            log.info("Layout Set for groupId (userId) : " + groupId + " existing - do nothing");
        } catch (Exception e) {
            long layoutSetId;
            try {
                layoutSetId = CounterLocalServiceUtil.increment();
                layoutSet = LayoutSetLocalServiceUtil.createLayoutSet(layoutSetId);
                layoutSet.setCompanyId(companyId);
                layoutSet.setPrivateLayout(privateLayout);
                layoutSet.setGroupId(groupId);
                layoutSet.setThemeId("classic");
                layoutSet.setCreateDate(new Date());
                layoutSet.setModifiedDate(new Date());
                LayoutSetLocalServiceUtil.addLayoutSet(layoutSet);
            } catch (SystemException e1) {
                log.warn("Can't create Layout Set for groupId (userId) : " + groupId + " - user will not be able to login");
            }
        } 
    }
    
    
    
    private void addRolesToUser(long userId, long companyId)  {
        /* Adding user to 'Power User' and 'User' role. */
        Role powerUser;
        try {
            powerUser = RoleLocalServiceUtil.fetchRole(companyId, "Power User");
            Role user = RoleLocalServiceUtil.fetchRole(companyId, "User");
        if (powerUser != null) {
            RoleLocalServiceUtil.addUserRole(userId, powerUser.getRoleId());
        }
        if (user != null) {
            RoleLocalServiceUtil.addUserRole(userId, user.getRoleId());
        }
        } catch (SystemException e) {
            log.warn("can't load Role PowerUser and/or User Role and add Role to userid" + userId); 
        }
        

    }
    
    private void logInfo(String string) {
        log.info(string);
        this.logInfoString = this.logInfoString.concat(string + "\n");
    }

}
