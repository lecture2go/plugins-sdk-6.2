package de.uhh.l2g.plugins.migration.controller;


import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import de.uhh.l2g.plugins.migration.model.LegacyContact;
import de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility;
import de.uhh.l2g.plugins.migration.model.LegacyMetadata;
import de.uhh.l2g.plugins.migration.model.LegacyOffice;
import de.uhh.l2g.plugins.migration.model.LegacySegment;
import de.uhh.l2g.plugins.migration.model.LegacyUser;
import de.uhh.l2g.plugins.migration.service.LegacyContactLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyLectureSeriesFacilityLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyMetadataLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyOfficeLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacySegmentLocalService;
import de.uhh.l2g.plugins.migration.service.LegacySegmentLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyUserLocalServiceUtil;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * View controller.
 */
@Controller
@RequestMapping("VIEW")
public class MigrationController {

    private static final Log log = LogFactoryUtil.getLog(MigrationController.class);
    // comma separated values of SiteIds are allowed. GoupIds must match name in DB or in Site-Settings of backend.
    private static String sites = "10182";
    
    private static long companyId = 10155;
    

    /**
     * View handler (default).
     */
    @RequestMapping
    public String list(PortletRequest request, Model model) throws SystemException {
        log.info("Rendering defaultView");
        model.addAttribute("userEntrieSize", LegacyUserLocalServiceUtil.getLegacyUsersCount());
        model.addAttribute("contactEntrieSize", LegacyContactLocalServiceUtil.getLegacyContactsCount());
        model.addAttribute("officeEntrieSize", LegacyOfficeLocalServiceUtil.getLegacyOfficesCount());
        model.addAttribute("legacyLectureSeriesEntrieSize", LegacyLectureSeriesFacilityLocalServiceUtil.getLegacyLectureSeriesFacilitiesCount());
        model.addAttribute("metadataEntrieSize", LegacyMetadataLocalServiceUtil.getLegacyMetadatasCount());
        model.addAttribute("segmentEntrieSize", LegacySegmentLocalServiceUtil.getLegacySegmentsCount());
        return "defaultView";
    }
    
    
    // --- Action handlers 
    
    @RequestMapping(params = "action=testExternalDBEntities")
    public void testExternalDBEntities(ActionRequest request) throws FileNotFoundException {
    	log.info("Call testExternalDBEntities");
        
		/// ENTITY LEGACY USER
        List<LegacyUser> users;
		try {
			log.info("Test User Entity...");
			users = LegacyUserLocalServiceUtil.getLegacyUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (LegacyUser user: users) {
				log.debug("Test reading out EMAIL of user:" +  user.getEmailAddress());
			}       
			log.info("Test User Entity...OK!");
		} catch (SystemException e) {
	    	log.info("Error connect to Entity User", e);
			log.info("Test User Entity...failed");
		}

		
    	/// ENTITY LEGACY CONTACT 
        List<LegacyContact> contacts;
		try {
			log.info("Test Contact Entity...");
			contacts = LegacyContactLocalServiceUtil.getLegacyContacts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyContact contact: contacts) {
	        	log.debug("Contact found First Name:" +  contact.getFirstName());
	        }
	        log.info("Test Contact Entity...OK!");
		} catch (SystemException e) {
	    	log.info("Error connect to Contact Entity", e);
			log.info("Test Contact Entity...failed");
		}

    	/// ENTITY OFFICE 
        List<LegacyOffice> offices;
		try {
			log.info("Test Office Entity...");
			offices = LegacyOfficeLocalServiceUtil.getLegacyOffices(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyOffice office: offices) {
	        	log.debug("Office found:" +  office);
	        }
	        log.info("Test Office Entity...OK!");
		} catch (SystemException e) {
	    	log.info("Error connect to Entity Office", e);
			log.info("Test Office Entity...failed");
		}
		
    	/// ENTITY LECTURESERIES_FACILITY 
        List<LegacyLectureSeriesFacility> lectureSeriesFacilities;
		try {
			log.info("Test LegacyLectureSeriesFacility Entity...");
			lectureSeriesFacilities = LegacyLectureSeriesFacilityLocalServiceUtil.getLegacyLectureSeriesFacilities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyLectureSeriesFacility lectureSeriesFacility: lectureSeriesFacilities) {
	        	log.debug("LegacyLectureSeriesFacility found:" +  lectureSeriesFacility);
	        }
	        log.info("Test LegacyLectureSeriesFacility Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyLectureSeriesFacility Office", e);
			log.info("Test LegacyLectureSeriesFacility Entity...failed");
		}
		
		
    	/// ENTITY Metadata
        List<LegacyMetadata> metadatas;
		try {
			log.info("Test LegacyMetadata Entity...");
			metadatas = LegacyMetadataLocalServiceUtil.getLegacyMetadatas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyMetadata metadata: metadatas) {
	        	log.debug("LegacyMetadata found:" +  metadata);
	        	if (!metadata.getType().isEmpty()) {
	        		log.info("LegacyMetadata found Type:" +  metadata.getType());
	        	}
	        }
	        log.info("Test LegacyMetadata Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyMetadata Office", e);
			log.info("Test LegacyMetadata Entity...failed");
		}
		
		
    	/// ENTITY Segment
        List<LegacySegment> segments;
		try {
			log.info("Test LegacySegment Entity...");
			segments = LegacySegmentLocalServiceUtil.getLegacySegments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacySegment segment: segments) {
	        	log.debug("LegacySegment found:" +  segment);
	        }
	        log.info("Test LegacySegment Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyMetadata Office", e);
			log.info("Test LegacySegment Entity...failed");
		}
		
    }
    
    
    @RequestMapping(params = "action=migrateUser")
    public void migrateUser(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Users
		List<LegacyUser> users;
		try {
			users = LegacyUserLocalServiceUtil.getLegacyUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyUser user: users) {
			try {
				createUser(user, companyId, request);
			} catch (PortalException e) {
				log.error("Error occured during User Migration:", e);
			} catch (SystemException e) {
				log.error("Error occured during User Migration:", e);
			}
		} 
    	
		} catch (SystemException e1) {
			log.info("Migration of User failed. Can not read Source Data");
		}
		
    }
    
    
    @RequestMapping(params = "action=migrateSegments")
    public void migrateOfficeEntries(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Segments
		List<LegacySegment> segments;
		try {
			segments = LegacySegmentLocalServiceUtil.getLegacySegments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
		for (LegacySegment segment: segments) {
			migrateSegment(segment);
		} 
    	
		} catch (SystemException e1) {
			log.info("Migration of User failed. Can not read Source Data");
		}
		
    }
    
    
    
    
    
    /******************** Private User Migration Methods ********************************************************************************/
    //TODO put into UTIL-Class
    
    
    


	/**
     * Create a user on specific parameters.
     *
     * @throws SystemException
     * @throws PortalException
     * @throws IOException
     */
    private void createUser(LegacyUser legacyUser, long companyId, ActionRequest request) throws SystemException, PortalException   {
    	long currentUserId = Long.valueOf(request.getRemoteUser());
        String currentUserFullName = "";
        try {
            currentUserFullName = UserLocalServiceUtil.getUser(currentUserId).getFullName();
        } catch (PortalException e) {
            log.error("There is no current user.");
        } catch (SystemException e) {
            log.error("There is no current user.");
        }
        String currentUserName = currentUserFullName;
        
        
    	/* Read data from LegacyUser and LegacyContact. */
    	LegacyContact contact;
		contact = LegacyContactLocalServiceUtil.getLegacyContact(legacyUser.getContactId());
    	User newUser = UserLocalServiceUtil.createUser(CounterLocalServiceUtil.increment());
    	/*
    	 * 1) Read out legacy  Fields
    	 * 2) Check if User already existing in LF 62, if yes do update of existing user (
    	 * 		a) call createOrGetID Methods 
    	 * 		b) call createOrUpdate Methodes 
    	 * )
    	 * 
    	 */
    	
    	
        /* Prepare Mandatory Data. */
        String mailAddress = legacyUser.getEmailAddress();
        String greeting = legacyUser.getGreeting();
        String firstName = contact.getFirstName();
        String lastName = contact.getLastName();
        Boolean isMale = contact.getMale();
        int status = (legacyUser.isActive() ?  WorkflowConstants.STATUS_APPROVED : WorkflowConstants.STATUS_INACTIVE);
        Date lastLoginDate = legacyUser.getLastLoginDate();
        Date createDate = legacyUser.getCreateDate();
        Date modifiedDate = legacyUser.getModifiedDate();
        long legacyId = legacyUser.getUserId();
        String password = legacyUser.getPassword();
        String screenName = legacyUser.getScreenName();
        String languageId = legacyUser.getLanguageId();
        String jobTitle = contact.getJobTitle();
        //TODO Read Adress;
        String street= "";
        String plz= "";
        String city = "";
        String country = "";
    	
        log.info("Creating or updating user " + firstName + " " + lastName + " with mailAddress " + mailAddress);

        User userByMail = null;

        try {
			userByMail = UserLocalServiceUtil.getUserByEmailAddress(companyId, mailAddress);
		} catch (PortalException e) {
			log.debug("User not found by mailAddress.");
		} catch (SystemException e) {
			log.debug("User not found by mailAddress.");
		}
        
        
        if (!mailAddress.equals("default@liferay.com")) {
            long contactId = createOrGetContactId(userByMail);
            long userId = createOrGetUserId(userByMail);
            long addressId = createOrGetAddressId(userByMail, companyId);

            createContactIfNotExistent(userByMail, contactId, userId, isMale);
            createOrUpdateAddress(companyId, userByMail, addressId, contactId, street, plz, city, country, currentUserId, currentUserName);
            User user =	createOrUpdateUser(companyId, userByMail, userId, jobTitle, status, password, mailAddress, firstName, lastName, screenName, contactId,  lastLoginDate, modifiedDate, languageId, createDate);
            //createGroupIfNotExistent(userByMail, groupId, userId, String.valueOf(userId), user.getScreenName());

            
            /* Updating user relations existing, otherwise create a new one. */
            if (userByMail == null) {
                addUserToCommunities(sites, userId, companyId);
//              addUserToGroups(userGroups, userId);
//              addRolesToUser(userId);

                log.info("Added user with id: " + user.getUserId());
            } else {
                log.info("Updated user with id: " + user.getUserId() + " and mail-address: " + user.getEmailAddress());
            }
        }
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
    
    private long createOrGetUserId(User userByMail) throws SystemException {
        long userId;
        if (userByMail == null) {
            userId = CounterLocalServiceUtil.increment();
        } else {
            userId = userByMail.getUserId();
        }
        return userId;
    }
    
    
    private long createOrGetAddressId(User userByMail, long companyId) throws SystemException  {
        long addressId;
        if (userByMail == null) {
            addressId = CounterLocalServiceUtil.increment();
        } else {
            List<Address> addresses = AddressLocalServiceUtil.getAddresses(companyId, Contact.class.getName(), userByMail.getContactId());
            if (!addresses.isEmpty()) {
                addressId = addresses.get(0).getAddressId(); // we assume everyone has only one address.
            } else {
                addressId = CounterLocalServiceUtil.increment();
            }
        }
        return addressId;
    }
    
    
    private void createContactIfNotExistent(User userByMail, long contactId, long userId, boolean isMale) throws SystemException {
        if (userByMail == null) {
            /* Creating contact for user. */
            Contact contact = ContactLocalServiceUtil.createContact(contactId);
            contact.setBirthday(new Date(0));
            contact.setUserId(userId);
            contact.setMale(isMale);
            ContactLocalServiceUtil.addContact(contact);
        }
    }
    
    private void createOrUpdateAddress(long companyId, User userByMail, long addressId, long contactId, String street, String plz, String city, String country, long currentUserId, String currentUserName) throws SystemException, PortalException {
        Address address;
        if (userByMail == null) {
            /* Creating address for user. */
            address = AddressLocalServiceUtil.createAddress(addressId);
        } else {
            try {
                address = AddressLocalServiceUtil.getAddress(addressId);
            } catch (Exception e) {
                log.info("User has no address yet.");
                address = AddressLocalServiceUtil.createAddress(addressId);
            }
        }
        address.setStreet1(street);
        address.setZip(plz);
        address.setCity(city);
        if (!country.equals("")) {
            address.setCountryId(CountryServiceUtil.getCountryByName(country).getCountryId());
        }
        address.setCompanyId(companyId);
        List<ListType> types = ListTypeServiceUtil.getListTypes("com.liferay.portal.model.Contact.address");
        for (ListType type: types) {
            if (type.getName().equals("business")) {
                address.setTypeId(type.getListTypeId());
            }
        }
        address.setPrimary(true);
        if (userByMail == null)  {
            address.setCreateDate(new Date());
        }
        address.setModifiedDate(new Date());
        address.setClassPK(contactId);
        if (userByMail == null) {
            address.setClassNameId(ClassNameLocalServiceUtil.getClassNameId(Contact.class));
            address.setUserId(currentUserId);
            address.setUserName(currentUserName);
            AddressLocalServiceUtil.addAddress(address);
        } else {
            AddressLocalServiceUtil.updateAddress(address);
        }
    }

    private User createOrUpdateUser(long companyId, User userByMail, long userId, String jobTitle, int status, String password, String mailAddress, String firstName, String lastName, String screenName, long contactId,  Date lastLoginDate, Date modifiedDate, String languageId,  Date createDate)
            throws SystemException {
        // UserByEmail will be  not null if user was already imported
    	User user = userByMail;
    	// Only create User if user was not imported before 
        if (user == null) {
            user = UserLocalServiceUtil.createUser(userId);
        }
        user.setCompanyId(companyId);
        user.setJobTitle(jobTitle); // function in company
        user.setStatus(status);
        user.setPasswordEncrypted(true);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setScreenName(screenName);
        user.setContactId(contactId);
        user.setLastLoginDate(lastLoginDate);
        user.setModifiedDate(modifiedDate);
        user.setLdapServerId(-1);
        user.setLanguageId(languageId);
        // required? 
        // AheadExpandoUtil.setUserExpandoValueData(user, ExpandoBridgeFieldEnum.AHEAD_LEGACY_LIFERAY_ID, legacyId); //legacy id

        if (userByMail == null) {
        	// for fresh imported user call ADD
        	user.setCreateDate(createDate);
        	user.setEmailAddress(mailAddress);
            UserLocalServiceUtil.addUser(user);    
        } else {
        	// for re-imported user call Update
            UserLocalServiceUtil.updateUser(user);
        }
        return user;
    }
    
    private void addUserToCommunities(String sites, long userId, long companyId) throws SystemException, PortalException {
        String[] siteIdStrings = sites.split(",");
        for (String site: siteIdStrings) {
            log.debug("Fetching group / site  with id: \"" + site + "\"");
            long siteId = Long.valueOf(site);
            Group group = GroupLocalServiceUtil.getGroup(siteId);
            if (group != null) {
                log.debug("Found group with name: \"" + group.getName() + "\"");
                GroupLocalServiceUtil.addUserGroup(userId, group);
            } else {
                log.debug("NO group / site with id found : \"" + site + "\"");
            }
        }
    }
    /******************** Private Segment Migration Methods 
     * @throws SystemException ********************************************************************************/
    //TODO put into UTIL-Class
    

    private void migrateSegment(LegacySegment legacySegment) throws SystemException {
    	Segment newSegment  = null;
    	try {
    		newSegment =   SegmentLocalServiceUtil.getSegment(legacySegment.getId());
		} catch (Exception e) {
			log.info("NO existing Segment found create new Segment with legacy id : \"" + legacySegment.getId() + "\"");
			newSegment = SegmentLocalServiceUtil.createSegment(legacySegment.getId());
		}
    	
    	newSegment = SegmentLocalServiceUtil.createSegment(legacySegment.getId());
    	newSegment.setVideoId(legacySegment.getVideoId());
    	newSegment.setStart(legacySegment.getStart());
    	newSegment.setTitle(legacySegment.getTitle());
    	newSegment.setDescription(legacySegment.getDescription());
    	newSegment.setEnd(legacySegment.getEnd());
    	
    	//TODO doublecheck Legacy Version Chapter was Boolean? now Long? 
    	newSegment.setChapter(legacySegment.getChapter());
    	
    	
    	
    	//newSegment.setUserId(arg0);
    	
    	//SegmentLocalServiceUtil.addSegment(newSegment);
    	log.info("Segment with legacy id : \"" + legacySegment.getId() + "\" added " );
    	
    }

}
