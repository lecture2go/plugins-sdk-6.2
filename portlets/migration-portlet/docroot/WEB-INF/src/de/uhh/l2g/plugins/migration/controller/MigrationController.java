package de.uhh.l2g.plugins.migration.controller;


import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import de.uhh.l2g.plugins.migration.mapper.AddressMapper;
import de.uhh.l2g.plugins.migration.mapper.ContactMapper;
import de.uhh.l2g.plugins.migration.mapper.CoordinatorMapper;
import de.uhh.l2g.plugins.migration.mapper.FacilityHostMapper;
import de.uhh.l2g.plugins.migration.mapper.FacilityMapper;
import de.uhh.l2g.plugins.migration.mapper.HostMapper;
import de.uhh.l2g.plugins.migration.mapper.L2gSysMapper;
import de.uhh.l2g.plugins.migration.mapper.LastVideoListMapper;
import de.uhh.l2g.plugins.migration.mapper.LectureseriesFacilityMapper;
import de.uhh.l2g.plugins.migration.mapper.LectureseriesMapper;
import de.uhh.l2g.plugins.migration.mapper.LicenseMapper;
import de.uhh.l2g.plugins.migration.mapper.MetadataMapper;
import de.uhh.l2g.plugins.migration.mapper.OfficeMapper;
import de.uhh.l2g.plugins.migration.mapper.ProducerLectureseriesMapper;
import de.uhh.l2g.plugins.migration.mapper.ProducerMapper;
import de.uhh.l2g.plugins.migration.mapper.SegmentMapper;
import de.uhh.l2g.plugins.migration.mapper.UploadMapper;
import de.uhh.l2g.plugins.migration.mapper.UserIDMapper;
import de.uhh.l2g.plugins.migration.mapper.UserMapper;
import de.uhh.l2g.plugins.migration.mapper.VideoFacilityMapper;
import de.uhh.l2g.plugins.migration.mapper.VideoHitlistMapper;
import de.uhh.l2g.plugins.migration.mapper.VideoMapper;
import de.uhh.l2g.plugins.migration.model.LegacyAddress;
import de.uhh.l2g.plugins.migration.model.LegacyContact;
import de.uhh.l2g.plugins.migration.model.LegacyCoordinator;
import de.uhh.l2g.plugins.migration.model.LegacyFacility;
import de.uhh.l2g.plugins.migration.model.LegacyFacilityHost;
import de.uhh.l2g.plugins.migration.model.LegacyHost;
import de.uhh.l2g.plugins.migration.model.LegacyL2gSys;
import de.uhh.l2g.plugins.migration.model.LegacyLastVideoList;
import de.uhh.l2g.plugins.migration.model.LegacyLectureSeries;
import de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacility;
import de.uhh.l2g.plugins.migration.model.LegacyLicense;
import de.uhh.l2g.plugins.migration.model.LegacyMetadata;
import de.uhh.l2g.plugins.migration.model.LegacyOffice;
import de.uhh.l2g.plugins.migration.model.LegacyProducer;
import de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries;
import de.uhh.l2g.plugins.migration.model.LegacySegment;
import de.uhh.l2g.plugins.migration.model.LegacyUpload;
import de.uhh.l2g.plugins.migration.model.LegacyVideoHitlist;
import de.uhh.l2g.plugins.migration.model.LegacyUser;
import de.uhh.l2g.plugins.migration.model.LegacyVideo;
import de.uhh.l2g.plugins.migration.model.LegacyVideoFacility;
import de.uhh.l2g.plugins.migration.service.LegacyAddressLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyContactLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyCoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyFacilityHostLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyFacilityLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyHostLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyL2gSysLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyLastVideoListLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyLectureSeriesFacilityLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyLectureSeriesLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyLicenseLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyMetadataLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyOfficeLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyProducerLectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyProducerLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacySegmentLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyUploadLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyVideoHitlistLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyUserLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyVideoFacilityLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyVideoLocalServiceUtil;
import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.model.Lastvideolist;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Office;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Producer_Lectureseries;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Sys;
import de.uhh.l2g.plugins.model.Upload;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.Videohitlist;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.LastvideolistLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.OfficeLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.Producer_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.SysLocalServiceUtil;
import de.uhh.l2g.plugins.service.UploadLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideohitlistLocalServiceUtil;

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
	private long companyId = 0;
	private long siteId = 0;
	private String sites = "";
	private String logInfoString = "";
	private boolean propsOk = false;
	String userOkflag=""; 
    // comma separated values of SiteIds are allowed. GoupIds must match name in DB or in Site-Settings of backend.
	private static String failed = "<font color=\"red\">failed!!</font>";
	private static String ok = "<font color=\"green\">ok!!</font>";
    

    /**
     * View handler (default).
     */
    @RequestMapping
    public String list(PortletRequest request, Model model) throws SystemException {
    	String actionResponse = (String) request.getAttribute("logInfoString");
    	if (actionResponse == null || actionResponse.isEmpty() ) {
    		logInfoString = "";
    	} else {
    		logInfoString = actionResponse;
    	}
    	logInfo("Rendering defaultView");
    	
    	
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        logInfo("themeDisplay:" +themeDisplay.getCompanyId());
        logInfo("scopeGroupID:" +themeDisplay.getScopeGroupId());
        
        boolean signedIn = themeDisplay.isSignedIn();
        if (!signedIn) {
            model.addAttribute("logInfoString", logInfoString);
        	return "pleaseLogin";
        }
        
        if (!propsOk) {
        	propsOk = checkProps();
            model.addAttribute("logInfoString", logInfoString);
            if (!propsOk) {
            	return "pleaseSetProps";
            }
        } 
        if (companyId < 1 || siteId < 1 ||  sites.isEmpty()) {
	        companyId = loadCompanyId();
	        siteId = loadSiteId();
	        sites = loadSites();
        }
        
        // Liferay 52 Entites 
        // User Rel Entries
        model.addAttribute("userEntrieSize", LegacyUserLocalServiceUtil.getLegacyUsersCount());
        model.addAttribute("contactEntrieSize", LegacyContactLocalServiceUtil.getLegacyContactsCount());
        model.addAttribute("addressEntrieSize", LegacyAddressLocalServiceUtil.getLegacyAddressesCount());
        model.addAttribute("segmentEntrieSize", LegacySegmentLocalServiceUtil.getLegacySegmentsCount());
        model.addAttribute("coordinatorEntrieSize", LegacyCoordinatorLocalServiceUtil.getLegacyCoordinatorsCount());
        model.addAttribute("producerEntrieSize", LegacyProducerLocalServiceUtil.getLegacyProducersCount());
        model.addAttribute("videoEntrieSize", LegacyVideoLocalServiceUtil.getLegacyVideosCount());
        model.addAttribute("uploadEntrieSize", LegacyUploadLocalServiceUtil.getLegacyUploadsCount());
        
        // Single Entries
        model.addAttribute("officeEntrieSize", LegacyOfficeLocalServiceUtil.getLegacyOfficesCount());
        model.addAttribute("metadataEntrieSize", LegacyMetadataLocalServiceUtil.getLegacyMetadatasCount());
        model.addAttribute("faciliyEntrieSize", LegacyFacilityLocalServiceUtil.getLegacyFacilitiesCount());
        model.addAttribute("licenseEntrieSize", LegacyLicenseLocalServiceUtil.getLegacyLicensesCount());
        model.addAttribute("hostEntrieSize", LegacyHostLocalServiceUtil.getLegacyHostsCount());
        model.addAttribute("l2gsysEntrieSize", LegacyL2gSysLocalServiceUtil.getLegacyL2gSysesCount());
        model.addAttribute("lectureseriesEntrieSize", LegacyLectureSeriesLocalServiceUtil.getLegacyLectureSeriesesCount());
        model.addAttribute("videohitlistEntrieSize", LegacyVideoHitlistLocalServiceUtil.getLegacyVideoHitlistsCount());
        model.addAttribute("lastvideolistEntrieSize", LegacyLastVideoListLocalServiceUtil.getLegacyLastVideoListsCount());
        
        
        // Mapping Entries
        model.addAttribute("legacyLectureSeriesFacitityEntrieSize", LegacyLectureSeriesFacilityLocalServiceUtil.getLegacyLectureSeriesFacilitiesCount());
        model.addAttribute("legacyProducerLectureseriesEntrieSize", LegacyProducerLectureseriesLocalServiceUtil.getLegacyProducerLectureseriesesCount());
        model.addAttribute("legacyVideoFacilityEntrieSize", LegacyVideoFacilityLocalServiceUtil.getLegacyVideoFacilitiesCount());
        model.addAttribute("legacyFacilityHostEntrieSize",  LegacyFacilityHostLocalServiceUtil.getLegacyFacilityHostsCount());
        
        
        
        
        // Liferay 62 entities
        model.addAttribute("userEntrieSize62", UserLocalServiceUtil.getUsersCount());
        model.addAttribute("contactEntrieSize62", ContactLocalServiceUtil.getContactsCount());
        model.addAttribute("addressEntrieSize62", AddressLocalServiceUtil.getAddressesCount());
        model.addAttribute("segmentEntrieSize62", SegmentLocalServiceUtil.getSegmentsCount());
        model.addAttribute("coordinatorEntrieSize62", CoordinatorLocalServiceUtil.getCoordinatorsCount());
        model.addAttribute("producerEntrieSize62", ProducerLocalServiceUtil.getProducersCount());
        model.addAttribute("videoEntrieSize62", VideoLocalServiceUtil.getVideosCount());
        model.addAttribute("uploadEntrieSize62", UploadLocalServiceUtil.getUploadsCount());
        
        
        
        // Single Entries
        model.addAttribute("officeEntrieSize62", OfficeLocalServiceUtil.getOfficesCount());
        model.addAttribute("metadataEntrieSize62", MetadataLocalServiceUtil.getMetadatasCount());
        model.addAttribute("InstitutionEntrieSize62", InstitutionLocalServiceUtil.getInstitutionsCount());
        model.addAttribute("licenseEntrieSize62", LicenseLocalServiceUtil.getLicensesCount());
        model.addAttribute("hostEntrieSize62", HostLocalServiceUtil.getHostsCount());
        model.addAttribute("sysEntrieSize62", SysLocalServiceUtil.getSysesCount());
        model.addAttribute("lectureseriesEntrieSize62", LectureseriesLocalServiceUtil.getLectureseriesesCount());
        model.addAttribute("videohitlistEntrieSize62", VideohitlistLocalServiceUtil.getVideohitlistsCount());
        model.addAttribute("lastvideolistEntrieSize62", LastvideolistLocalServiceUtil.getLastvideolistsCount());

        // Mapping Entries
        model.addAttribute("lectureSeriesInstitutionEntrieSize62", Lectureseries_InstitutionLocalServiceUtil.getLectureseries_InstitutionsCount());
        model.addAttribute("producerLectureseriesEntrieSize62", Producer_LectureseriesLocalServiceUtil.getProducer_LectureseriesesCount());
        model.addAttribute("videoFacilityEntrieSize62", Video_InstitutionLocalServiceUtil.getVideo_InstitutionsCount());
        model.addAttribute("facilityHostEntrieSize62", Institution_HostLocalServiceUtil.getInstitution_HostsCount());
        
        model.addAttribute("logInfoString", logInfoString);
        
        return "defaultView";
        
    }
    
    
    private String loadSites() {
    	String sites = PropsUtil.get("migration.portlet.target.sites");
    	return sites;
	}


	private long loadSiteId() {
    	String siteId = PropsUtil.get("migration.portlet.target.siteid");
    	Long longSiteId = 0L ;
    	longSiteId= Long.valueOf(siteId);
    	return longSiteId;
	}


	private long loadCompanyId() {
    	String companyId = PropsUtil.get("migration.portlet.target.companyid");
    	Long longCompanyId = 0L;
    	longCompanyId = Long.valueOf(companyId);
		return longCompanyId;
	}


	private boolean checkProps() {
    	String companyId;
		String siteId;
		String sites;
		try {
			companyId = PropsUtil.get("migration.portlet.target.companyid");
			siteId = PropsUtil.get("migration.portlet.target.siteid");
			sites = PropsUtil.get("migration.portlet.target.sites");
		} catch (Exception e2) {
			logInfo("cant load props please check, required properites for migration");
			return false;
		}
    	Long longCompanyId = 0L;
    	try {
			longCompanyId = Long.valueOf(companyId);
		} catch (NumberFormatException e) {
			logInfo("migration.portlet.target.companyid is not a number");
			return false;
		}
    	
    	try {
			Company company = CompanyLocalServiceUtil.getCompany(longCompanyId);
			logInfo("migration.portlet.target.companyid=" + longCompanyId + " is OK!");
		} catch (PortalException e1) {
			logInfo("migration.portlet.target.companyid=" + longCompanyId + " is not existing");
			return false;
		} catch (SystemException e1) {
			logInfo("migration.portlet.target.companyid=" + longCompanyId + " is not existing");
			return false;
		}
    	Long longSiteId = 0L ;
    	try {
    		longSiteId= Long.valueOf(siteId);
		} catch (NumberFormatException e) {
			logInfo("migration.portlet.target.siteid is not a number");
			return false;
		}
       	try {
    			Group group = GroupLocalServiceUtil.getGroup(longSiteId);
    			logInfo("migration.portlet.target.siteId=" + longSiteId + " is OK!");
    	} catch (PortalException e1) {
    			logInfo("migration.portlet.target.siteId=" + longSiteId + " is not existing");
    			return false;
    	} catch (SystemException e1) {
    			logInfo("migration.portlet.target.siteId=" + longSiteId + " is not existing");
    			return false;
    	}
       	String[] siteIdStrings = sites.split(",");
        for (String site: siteIdStrings) {
            log.debug("Fetching group / site  with id: \"" + site + "\"");
            long localSiteId = Long.valueOf(site);
            Group group = null;
			try {
				group = GroupLocalServiceUtil.getGroup(localSiteId);
				logInfo("migration.portlet.target.sites= .... site: " + localSiteId + " is OK!");
				if (group == null) {
				log.error("NO group / site with id found : \"" + site + "\" - user not linked to group");
				return false;
				}
			} catch (Exception e) {
				log.error("NO group / site with id found : \"" + site + "\" - user not linked to group");
				return false;
			}
        }
    	
    	return true;
	}


	// --- Action handlers 
    
    @RequestMapping(params = "action=testExternalDBEntities")
    public void testExternalDBEntities(ActionRequest request) throws FileNotFoundException {
    	logInfoString = "";
    	logInfo("Call testExternalDBEntities");
        String result = "";
        boolean failed = false;
		/// ENTITY LEGACY USER
        List<LegacyUser> users;
		try {
			logInfo("Test User Entity...");
			users = LegacyUserLocalServiceUtil.getLegacyUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (LegacyUser user: users) {
				log.debug("Test reading out EMAIL of user:" +  user.getEmailAddress());
			}       
			logInfo("Test User Entity...OK!");
		} catch (SystemException e) {
	    	log.warn("Error connect to Entity User", e);
			logInfo("Test User Entity...failed");
		}

		
    	/// ENTITY LEGACY CONTACT 
        List<LegacyContact> contacts;
		try {
			logInfo("Test Contact Entity...");
			contacts = LegacyContactLocalServiceUtil.getLegacyContacts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyContact contact: contacts) {
	        	log.debug("Contact found First Name:" +  contact.getFirstName());
	        }
	        logInfo("Test Contact Entity...OK!");
		} catch (SystemException e) {
	    	log.warn("Error connect to Contact Entity", e);
			logInfo("Test Contact Entity...failed");
		}

    	/// ENTITY OFFICE 
        List<LegacyOffice> offices;
		try {
			logInfo("Test Office Entity...");
			offices = LegacyOfficeLocalServiceUtil.getLegacyOffices(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyOffice office: offices) {
	        	log.debug("Office found:" +  office);
	        }
	        logInfo("Test Office Entity...OK!");
		} catch (SystemException e) {
	    	log.warn("Error connect to Entity Office", e);
			logInfo("Test Office Entity...failed");
		}
		
    	/// ENTITY LECTURESERIES_FACILITY 
        List<LegacyLectureSeriesFacility> lectureSeriesFacilities;
		try {
			logInfo("Test LegacyLectureSeriesFacility Entity...");
			lectureSeriesFacilities = LegacyLectureSeriesFacilityLocalServiceUtil.getLegacyLectureSeriesFacilities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyLectureSeriesFacility lectureSeriesFacility: lectureSeriesFacilities) {
	        	log.debug("LegacyLectureSeriesFacility found:" +  lectureSeriesFacility);
	        }
	        logInfo("Test LegacyLectureSeriesFacility Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyLectureSeriesFacility Entity", e);
			logInfo("Test LegacyLectureSeriesFacility Entity...failed");
		}
		
		
    	/// ENTITY Metadata
        List<LegacyMetadata> metadatas;
		try {
			logInfo("Test LegacyMetadata Entity...");
			metadatas = LegacyMetadataLocalServiceUtil.getLegacyMetadatas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyMetadata metadata: metadatas) {
	        	log.debug("LegacyMetadata found:" +  metadata);
	        	if (!metadata.getType().isEmpty()) {
	        		log.debug("LegacyMetadata found Type:" +  metadata.getType());
	        	}
	        }
	        logInfo("Test LegacyMetadata Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyMetadata Entity", e);
			logInfo("Test LegacyMetadata Entity...failed");
		}
		
		
    	/// ENTITY Segment
        List<LegacySegment> segments;
		try {
			logInfo("Test LegacySegment Entity...");
			segments = LegacySegmentLocalServiceUtil.getLegacySegments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacySegment segment: segments) {
	        	log.debug("LegacySegment found:" +  segment);
	        }
	        logInfo("Test LegacySegment Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyMetadata Entity", e);
			logInfo("Test LegacySegment Entity...failed");
		}
		
    	/// ENTITY coordinator
        List<LegacyCoordinator> coordinators;
		try {
			logInfo("Test LegacyCoordinator Entity...");
			coordinators = LegacyCoordinatorLocalServiceUtil.getLegacyCoordinators(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyCoordinator coordinator: coordinators) {
	        	log.debug("LegacyCoordinator found:" +  coordinator);
	        }
	        logInfo("Test LegacyCoordinator Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyCoordinator Entity", e);
			logInfo("Test LegacyCoordinator Entity...failed");
		}		
		
    	/// ENTITY Producer
        List<LegacyProducer> producers;
		try {
			logInfo("Test LegacyProducer Entity...");
			producers = LegacyProducerLocalServiceUtil.getLegacyProducers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyProducer producer: producers) {
	        	log.debug("LegacyProducer found:" +  producer);
	        }
	        logInfo("Test LegacyProducer Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyProducer Entity", e);
			logInfo("Test LegacyProducer Entity...failed");
		}	
		
    	/// ENTITY Video
        List<LegacyVideo> videos;
		try {
			logInfo("Test LegacyVideo Entity...");
			videos = LegacyVideoLocalServiceUtil.getLegacyVideos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyVideo video: videos) {
	        	log.debug("LegacyVideo found:" +  video);
	        }
	        logInfo("Test LegacyVideo Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyVideo Entity", e);
			logInfo("Test LegacyVideo Entity...failed");
		}

    	/// ENTITY upload
        List<LegacyVideoHitlist> uploads;
		try {
			logInfo("Test LegacyVideoHitlist Entity...");
			uploads = LegacyVideoHitlistLocalServiceUtil.getLegacyVideoHitlists(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyVideoHitlist upload: uploads) {
	        	log.debug("LegacyVideoHitlist found:" +  upload);
	        }
	        logInfo("Test LegacyVideoHitlist Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyVideoHitlist Entity", e);
			logInfo("Test LegacyVideoHitlist Entity...failed");
		}	
		
    	/// ENTITY lastvideolist
        List<LegacyLicense> lastvideolists;
		try {
			logInfo("Test LegacyLicense Entity...");
			lastvideolists = LegacyLicenseLocalServiceUtil.getLegacyLicenses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyLicense lastvideolist: lastvideolists) {
	        	log.debug("LegacyLicense found:" +  lastvideolist);
	        }
	        logInfo("Test LegacyLicense Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyLicense Entity", e);
			logInfo("Test LegacyLicense Entity...failed");
		}	

    	/// ENTITY facilityHost
        List<LegacyFacilityHost> facilityHosts;
		try {
			logInfo("Test LegacyFacilityHost Entity...");
			facilityHosts = LegacyFacilityHostLocalServiceUtil.getLegacyFacilityHosts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyFacilityHost facilityHost: facilityHosts) {
	        	log.debug("LegacyFacilityHost found:" +  facilityHost);
	        }
	        logInfo("Test LegacyFacilityHost Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyFacilityHost Entity", e);
			logInfo("Test LegacyFacilityHost Entity...failed");
		}	

    	/// ENTITY producerLectureseries
        List<LegacyProducerLectureseries> producerLectureserieses;
		try {
			logInfo("Test LegacyProducerLectureseries Entity...");
			producerLectureserieses = LegacyProducerLectureseriesLocalServiceUtil.getLegacyProducerLectureserieses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyProducerLectureseries producerLectureseries: producerLectureserieses) {
	        	log.debug("LegacyProducerLectureseries found:" +  producerLectureseries);
	        }
	        logInfo("Test LegacyProducerLectureseries Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyProducerLectureseries Entity", e);
			logInfo("Test LegacyProducerLectureseries Entity...failed");
		}	
		
    	/// ENTITY host
        List<LegacyHost> host;
		try {
			logInfo("Test LegacyHost Entity...");
			host = LegacyHostLocalServiceUtil.getLegacyHosts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyHost lastvideolist: host) {
	        	log.debug("LegacyHost found:" +  lastvideolist);
	        }
	        logInfo("Test LegacyHost Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyHost Entity", e);
			logInfo("Test LegacyHost Entity...failed");
		}	
		
    	/// ENTITY l2gSys
        List<LegacyL2gSys> l2gSyss;
		try {
			logInfo("Test LegacyL2gSys Entity...");
			l2gSyss = LegacyL2gSysLocalServiceUtil.getLegacyL2gSyses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyL2gSys l2gSys: l2gSyss) {
	        	log.debug("LegacyL2gSys found:" +  l2gSys);
	        }
	        logInfo("Test LegacyL2gSys Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyL2gSys Entity", e);
			logInfo("Test LegacyL2gSys Entity...failed");
		}	
		
    	/// ENTITY videoFacility
        List<LegacyVideoFacility> videoFacilitys;
		try {
			logInfo("Test LegacyVideoFacility Entity...");
			videoFacilitys = LegacyVideoFacilityLocalServiceUtil.getLegacyVideoFacilities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyVideoFacility videoFacility: videoFacilitys) {
	        	log.debug("LegacyVideoFacility found:" +  videoFacility);
	        }
	        logInfo("Test LegacyVideoFacility Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyVideoFacility Entity", e);
			logInfo("Test LegacyVideoFacility Entity...failed");
		}	
		
    	/// ENTITY facility
        List<LegacyFacility> facilitys;
		try {
			logInfo("Test LegacyFacility Entity...");
			facilitys = LegacyFacilityLocalServiceUtil.getLegacyFacilities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyFacility facility: facilitys) {
	        	log.debug("LegacyFacility found:" +  facility);
	        }
	        logInfo("Test LegacyFacility Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyFacility Entity", e);
			logInfo("Test LegacyFacility Entity...failed");
		}	
		
    	/// ENTITY videoHitlist
        List<LegacyVideoHitlist> videoHitlists;
		try {
			logInfo("Test LegacyVideoHitlist Entity...");
			videoHitlists = LegacyVideoHitlistLocalServiceUtil.getLegacyVideoHitlists(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyVideoHitlist videoHitlist: videoHitlists) {
	        	log.debug("LegacyVideoHitlist found:" +  videoHitlist);
	        }
	        logInfo("Test LegacyVideoHitlist Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyVideoHitlist Entity", e);
			logInfo("Test LegacyVideoHitlist Entity...failed");
		}			
		
		
    	/// ENTITY lectureSeries
        List<LegacyLectureSeries> lectureSerieses;
		try {
			logInfo("Test LegacyLectureSeries Entity...");
			lectureSerieses = LegacyLectureSeriesLocalServiceUtil.getLegacyLectureSerieses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyLectureSeries lectureSeries: lectureSerieses) {
	        	log.debug("LegacyLectureSeries found:" +  lectureSeries);
	        }
	        logInfo("Test LegacyLectureSeries Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyLectureSeries Entity", e);
			logInfo("Test LegacyLectureSeries Entity...failed");
		}	
		
    	/// ENTITY lastVideolist
        List<LegacyLastVideoList> lastVideolists;
		try {
			logInfo("Test LegacyVideoVideolist Entity...");
			lastVideolists = LegacyLastVideoListLocalServiceUtil.getLegacyLastVideoLists(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyLastVideoList lastVideolist: lastVideolists) {
	        	log.debug("LegacyVideoVideolist found:" +  lastVideolist);
	        }
	        logInfo("Test LegacyVideoVideolist Entity...OK!");		
		} catch (SystemException e) {
	    	log.warn("Error connect to LegacyVideoVideolist Entity", e);
			logInfo("Test LegacyVideoVideolist Entity...failed");
		}	
		request.setAttribute("logInfoString", logInfoString);
    }
    
    
    @RequestMapping(params = "action=migrateUser")
    public void migrateUser(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Users
    	String userOkflag = ok;
    	
		List<LegacyUser> users;
		try {
			users = LegacyUserLocalServiceUtil.getLegacyUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyUser user: users) {
			try {
				createUser(user, companyId, request);
			} catch (PortalException e) {
				log.error("Error occured during User Migration:", e);
		    	userOkflag = failed;
			} catch (SystemException e) {
				log.error("Error occured during User Migration:", e);
		    	userOkflag = failed;
			}
		} 
		logInfo("Migration / Update of:" + users.size() + " Users sucessfull!");
		
		} catch (SystemException e1) {
			logInfo("Migration of User failed. Can not read Source Data. Please Check Log for more details!");
	    	userOkflag = failed;
		}
		request.setAttribute("userOkflag", userOkflag);	
    }
    
    
    @RequestMapping(params = "action=migrateSegments")
    public void migrateSegments(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Segments
    	String segmentOkflag = ok;
		List<LegacySegment> segments;
		try {
			segments = LegacySegmentLocalServiceUtil.getLegacySegments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacySegment segment: segments) {
			migrateSegment(segment, companyId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of Segments failed. Can not read Source Data");
			segmentOkflag = failed;
		}
		request.setAttribute("segmentOkflag", segmentOkflag);
		
    }
    
    @RequestMapping(params = "action=migrateCoordinators")
    public void migrateCoordinator(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Coordinator
    	String coordinatorOkflag = ok;
		List<LegacyCoordinator> coordinators;
		try {
			coordinators = LegacyCoordinatorLocalServiceUtil.getLegacyCoordinators(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
		for (LegacyCoordinator coordinator: coordinators) {
			migrateCoordinator(coordinator, companyId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of Coordinator failed. Can not read Source Data");
		   	coordinatorOkflag = failed;
		}
		request.setAttribute("coordinatorOkflag", coordinatorOkflag);
    }
    
    
    @RequestMapping(params = "action=migrateProducers")
    public void migrateProducers(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Producers
    	String producerOkflag = ok;
		List<LegacyProducer> producers;
		try {
			producers = LegacyProducerLocalServiceUtil.getLegacyProducers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
		for (LegacyProducer producer: producers) {
			migrateProducer(producer, companyId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of producer failed. Can not read Source Data");
			producerOkflag = failed;
		}
		request.setAttribute("producerOkflag", producerOkflag);
    }
    
    
    @RequestMapping(params = "action=migrateVideos")
    public void migrateVideos(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Videos
    	String videoOkflag = ok;
		List<LegacyVideo> videos;
		try {
			videos = LegacyVideoLocalServiceUtil.getLegacyVideos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyVideo video: videos) {
			migrateVideo(video, companyId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of video failed. Can not read Source Data");
			videoOkflag = failed;
		}
		request.setAttribute("videoOkflag", videoOkflag);
    }
    
    
    @RequestMapping(params = "action=migrateUploads")
    public void migrateUploads(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migrateUploads");
    	String uploadOkflag = ok;
		List<LegacyUpload> uploads;
		try {
			uploads = LegacyUploadLocalServiceUtil.getLegacyUploads(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyUpload upload: uploads) {
			migrateUpload(upload, companyId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of uploads failed. Can not read Source Data");
			uploadOkflag = failed;
		}
		request.setAttribute("uploadOkflag", uploadOkflag);
    }
    
    
    @RequestMapping(params = "action=migrateOffices")
    public void migrateOffices(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migrateOffices");
    	String officeOkflag = ok;
		List<LegacyOffice> offices;
		try {
			offices = LegacyOfficeLocalServiceUtil.getLegacyOffices(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyOffice office: offices) {
			migrateOffice(office, companyId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of offices failed. Can not read Source Data");
			officeOkflag = failed;
		}
		request.setAttribute("officeOkflag", officeOkflag);
    }
    
    
    
    @RequestMapping(params = "action=migrateMetadatas")
    public void migrateMetadatas(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migrateMetadatas");
    	String metatdataOkflag = ok;
		List<LegacyMetadata> legacyMetadatas;
		try {
			legacyMetadatas = LegacyMetadataLocalServiceUtil.getLegacyMetadatas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyMetadata legacyMetadata: legacyMetadatas) {
			migrateMetadata(legacyMetadata, companyId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of Metadatas failed. Can not read Source Data");
			metatdataOkflag = failed;
		}
		request.setAttribute("metatdataOkflag", metatdataOkflag);
    }
    
    @RequestMapping(params = "action=migrateInstitutions")
    public void migrateInstitutions(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migrateInsitutions");
    	String institutionOkflag = ok;
		List<LegacyFacility> legacyFacilities;
		try {
			legacyFacilities = LegacyFacilityLocalServiceUtil.getLegacyFacilities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyFacility legacyFacility: legacyFacilities) {
			migrateInstitution(legacyFacility, companyId, siteId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of Facilities failed. Can not read Source Data");
			institutionOkflag = failed;
		}
		request.setAttribute("institutionOkflag", institutionOkflag);
    }    
    
    
    @RequestMapping(params = "action=migrateLicenses")
    public void migrateLicenses(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migrateLicenses");
    	String licenseOkflag = ok;
		List<LegacyLicense> legacyLicenses;
		try {
			legacyLicenses = LegacyLicenseLocalServiceUtil.getLegacyLicenses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyLicense legacyLicense: legacyLicenses) {
			migrateLicense(legacyLicense, companyId, siteId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of License failed. Can not read Source Data");
			licenseOkflag = failed;
		}
		request.setAttribute("licenseOkflag", licenseOkflag);
    }

    
    @RequestMapping(params = "action=migrateHosts")
    public void migrateHosts(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migrateHosts");
    	String hostOkflag = ok;
		List<LegacyHost> legacyHosts;
		try {
			legacyHosts = LegacyHostLocalServiceUtil.getLegacyHosts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyHost legacyHost: legacyHosts) {
			migrateHost(legacyHost, companyId, siteId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of Host failed. Can not read Source Data");
			hostOkflag = failed;
		}
		request.setAttribute("hostOkflag", hostOkflag);
		
    }  
    
    @RequestMapping(params = "action=migrateL2gSyses")
    public void migrateL2gSyses(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migrateL2gSyses");
    	String sysOkflag = ok;
		List<LegacyL2gSys> legacyL2gSyss;
		try {
			legacyL2gSyss = LegacyL2gSysLocalServiceUtil.getLegacyL2gSyses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyL2gSys legacyL2gSys: legacyL2gSyss) {
			migrateL2gsys(legacyL2gSys, companyId, siteId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of Sys failed. Can not read Source Data");
			sysOkflag = failed;
		}
		request.setAttribute("sysOkflag", sysOkflag);
    }  
    
    @RequestMapping(params = "action=migrateLectureserieses")
    public void migrateLectureseriess(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migrateLectureseriess");
    	String lectureseriesOkflag = ok;
		List<LegacyLectureSeries> legacyLectureserieses;
		try {
			legacyLectureserieses = LegacyLectureSeriesLocalServiceUtil.getLegacyLectureSerieses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyLectureSeries legacyLectureseries: legacyLectureserieses) {
			migrateLectureseries(legacyLectureseries, companyId, siteId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of Lectureseries failed. Can not read Source Data");
			lectureseriesOkflag = failed;
		}
		request.setAttribute("lectureseriesOkflag", lectureseriesOkflag);
    }  
    
    @RequestMapping(params = "action=migrateVideohitlists")
    public void migrateVideohitlists(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migrateVideohitlists");
    	String videohitlistOkflag = ok;
		List<LegacyVideoHitlist> legacyVideohitlists;
		try {
			legacyVideohitlists = LegacyVideoHitlistLocalServiceUtil.getLegacyVideoHitlists(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyVideoHitlist legacyVideohitlist: legacyVideohitlists) {
			migrateVideohitlist(legacyVideohitlist, companyId, siteId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of Videohitlist failed. Can not read Source Data");
			videohitlistOkflag = failed;
		}
		request.setAttribute("videohitlistOkflag", videohitlistOkflag);
    }  
    
    @RequestMapping(params = "action=migrateLastvideolists")
    public void migrateLastvideolists(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migrateLastvideolists");
    	String lastvideolistOkflag = ok;
		List<LegacyLastVideoList> legacyLastvideolists;
		try {
			legacyLastvideolists = LegacyLastVideoListLocalServiceUtil.getLegacyLastVideoLists(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyLastVideoList legacyLastvideolist: legacyLastvideolists) {
			migrateLastvideolist(legacyLastvideolist, companyId, siteId);
		} 
    	
		} catch (SystemException e1) {
			logInfo("Migration of uploads failed. Can not read Source Data");
			lastvideolistOkflag = failed;
		}
		request.setAttribute("lastvideolistOkflag", lastvideolistOkflag);
    }  

    
    
    @RequestMapping(params = "action=migrateLectureseriesFacilities")
    public void migrateLectureseriesFacilities(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migrateLectureseriesFacilities");
    	String lectureseriesFacilitiesOkflag = ok;
		List<LegacyLectureSeriesFacility> lectureseriesFacilities;
		try {
			lectureseriesFacilities = LegacyLectureSeriesFacilityLocalServiceUtil.getLegacyLectureSeriesFacilities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			logInfo("lectureseriesFacilities Size : " + lectureseriesFacilities.size());
			for (LegacyLectureSeriesFacility lectureseriesFacility: lectureseriesFacilities) {
				migrateLectureseriesInstitution(lectureseriesFacility, companyId);
			} 			
    	
		} catch (SystemException e1) {
			logInfo("Migration of uploads failed. Can not read Source Data");
			lectureseriesFacilitiesOkflag = failed;
		}
		request.setAttribute("lectureseriesFacilitiesOkflag", lectureseriesFacilitiesOkflag);
    }
    
    
    
    @RequestMapping(params = "action=migrateVideo_Institution")
    public void migrateVideo_Institution(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migratemigrateVideo_Institution");
    	String videoInstitutionOkflag = ok;
		List<LegacyVideoFacility> videoFacilities;
		try {
			videoFacilities = LegacyVideoFacilityLocalServiceUtil.getLegacyVideoFacilities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			logInfo("videoFacility Size : " + videoFacilities.size());
			for (LegacyVideoFacility videoFacility: videoFacilities) {
				migrateVideo_Institution(videoFacility, companyId);
			} 			
    	
		} catch (SystemException e1) {
			logInfo("Migration of uploads failed. Can not read Source Data");
			videoInstitutionOkflag = failed;
		}
		request.setAttribute("videoInstitutionOkflag", videoInstitutionOkflag);
    }
    
    @RequestMapping(params = "action=migrateProducer_Lectureseries")
    public void migrateProducer_Lectureseries(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migratemigrateProducer_Lectureseries");
    	String producerLectureseriesOkflag = ok;
		List<LegacyProducerLectureseries> producerLectureserieses;
		try {
			producerLectureserieses = LegacyProducerLectureseriesLocalServiceUtil.getLegacyProducerLectureserieses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			logInfo("videoFacility Size : " + producerLectureserieses.size());
			for (LegacyProducerLectureseries producerLectureseries: producerLectureserieses) {
				migrateProducer_Lectureseries(producerLectureseries, companyId);
			} 			
    	
		} catch (SystemException e1) {
			logInfo("Migration of uploads failed. Can not read Source Data");
			producerLectureseriesOkflag = failed;
		}
		request.setAttribute("producerLectureseriesOkflag", producerLectureseriesOkflag);
    }    
    
    
    
    
    @RequestMapping(params = "action=migrateInstitution_Host")
    public void migrateInstitution_Host(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	logInfo("Call migratemigrateInstitution_Host");
    	String institutionHostOkflag = ok;
		List<LegacyFacilityHost> facilityHosts;
		try {
			facilityHosts = LegacyFacilityHostLocalServiceUtil.getLegacyFacilityHosts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			logInfo("FacilityHost Size : " + facilityHosts.size());
			for (LegacyFacilityHost FacilityHost: facilityHosts) {
				migrateInstitution_Host(FacilityHost, companyId);
			} 			
    	
		} catch (SystemException e1) {
			logInfo("Migration of uploads failed. Can not read Source Data");
			institutionHostOkflag = failed;
		}
		request.setAttribute("institutionHostOkflag", institutionHostOkflag);
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
    	User currentUser = null;
        String currentUserFullName = "";
        try {
        	currentUser = UserLocalServiceUtil.getUser(currentUserId);
            currentUserFullName = currentUser.getFullName();
        } catch (PortalException e) {
            log.error("There is no current user.");
        } catch (SystemException e) {
            log.error("There is no current user.");
        }
        String currentUserName = currentUserFullName;
        
        
    	/* Read data from LegacyUser and LegacyContact. */
    	LegacyContact legacyContact;
    	legacyContact = LegacyContactLocalServiceUtil.getLegacyContact(legacyUser.getContactId());
    	/*
    	 * 1) Read out legacy  Fields
    	 * 2) Check if User already existing in LF 62, if yes do update of existing user (
    	 * 		a) call createOrGetID Methods 
    	 * 		b) call createOrUpdate Methodes 
    	 * )
    	 * 
    	 */
    	
    	logInfo("Legacy User loaded: " + legacyContact.getFirstName() + " " + legacyContact.getLastName() + " with mailAddress " + legacyUser.getEmailAddress());    	
        User exstingUser = null;
        try {
        	exstingUser = UserLocalServiceUtil.getUserByEmailAddress(companyId, legacyUser.getEmailAddress());
		} catch (Exception e) {
			log.info("User not found by mailAddress in LF62 DB.");
		}
        
        if (currentUser != null && !legacyUser.getEmailAddress().equals("default@liferay.com") && !legacyUser.getEmailAddress().equals(currentUser.getEmailAddress())) {
        	logInfo("Migrating " + legacyContact.getFirstName() + " " + legacyContact.getLastName() + " with mailAddress " + legacyUser.getEmailAddress());
            long contactId = createOrGetContactId(exstingUser);
            long userId = createOrGetUserId(exstingUser);
            long personalGroupId = createOrGetPersonalGroupId(exstingUser,  String.valueOf(userId));
            logInfo("Creating Contact");
            Contact contact = createOrUpdateContact(companyId,contactId,userId,legacyContact);
            logInfo("Creating User with legacyContactID " + legacyContact.getContactId() + " contactId: " + contactId);
            User user =	createOrUpdateUser(companyId, exstingUser, userId, legacyUser, legacyContact, contactId);
            createOrUpdateAddress(companyId, user, legacyUser, contact);
            createPersonalGroupIfNotExistent(exstingUser, personalGroupId, userId, currentUserId, String.valueOf(userId), user.getScreenName());
            createPersonalLayoutIfNotExistent(personalGroupId, true);
            createPersonalLayoutIfNotExistent(personalGroupId, false);
            
            // ADD Power User and User role
            addRolesToUser(user.getUserId());
            
            //update sites to user 
            addUserToSite(sites, userId, companyId);
            logInfo("Added user with id: " + user.getUserId());
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

    private User createOrUpdateUser(long companyId, User user, long userId, LegacyUser legacyUser, LegacyContact contact,  long contactId) {
    	// Only create User if user was not imported before 
        if (user == null) {
            user = UserLocalServiceUtil.createUser(userId);
            user = UserMapper.mapUser(companyId, user, legacyUser, contact, contactId);
            try {
				UserLocalServiceUtil.addUser(user);
			} catch (SystemException e) {
				logInfo("Error adding User - please check log for further details!");
				log.warn("Error adding User:" + user, e);
			}
        } else {
            user = UserMapper.mapUser(companyId, user, legacyUser, contact, contactId);
            try {
				UserLocalServiceUtil.updateUser(user);
			} catch (SystemException e) {
				logInfo("Error updating User - please check log for further details!");
				log.warn("Error updating User:" + user, e);
			}
        }
        return user;
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
    
    private void createPersonalGroupIfNotExistent(User userByMail, long groupId, long userId, long creatorId,  String groupName, String friendlyUrl) throws SystemException {
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
    

    private long createOrGetPersonalGroupId(User userByMail, String userIdAsString) throws SystemException, PortalException {
        long groupId = 0;
        try {
                groupId = GroupLocalServiceUtil.getGroup(companyId, userIdAsString).getGroupId();
            } catch (Exception e) {
            	logInfo("Can't get groupId for user with ID: " + userIdAsString + " : createId by CounterLocalServiceUtil" );
            	groupId = CounterLocalServiceUtil.increment();
            }
        return groupId;
    }
    
    private void createPersonalLayoutIfNotExistent(long groupId, boolean privateLayout)  {
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

    private void migrateSegment(LegacySegment legacySegment, long companyId) throws SystemException {
    	Segment segment  = null;
    	try {
    		segment = SegmentLocalServiceUtil.getSegment(legacySegment.getId());
			segment = SegmentMapper.mapSegment(segment, legacySegment, companyId);
			log.debug("SEGMENT UPDATE:" +segment);
    		SegmentLocalServiceUtil.updateSegment(segment);
		} catch (Exception e) {
			segment = SegmentLocalServiceUtil.createSegment(legacySegment.getId());
			segment = SegmentMapper.mapSegment(segment, legacySegment, companyId); 
			log.debug("SEGMENT NEW:" +segment);
			SegmentLocalServiceUtil.addSegment(segment);
		}
    }
    
    private void migrateCoordinator(LegacyCoordinator legacyCoordinator, long companyId) throws SystemException {
    	Coordinator coordinator  = null;
    	try {
    		coordinator = CoordinatorLocalServiceUtil.getCoordinator(UserIDMapper.getNewUserId(legacyCoordinator.getUserId(), companyId));
    		coordinator = CoordinatorMapper.mapCoordinator(legacyCoordinator, coordinator);
			log.debug("Coordinator UPDATE:" +coordinator);
			CoordinatorLocalServiceUtil.updateCoordinator(coordinator);
		} catch (Exception e) {
			coordinator = CoordinatorLocalServiceUtil.createCoordinator(UserIDMapper.getNewUserId(legacyCoordinator.getUserId(), companyId));
			coordinator = CoordinatorMapper.mapCoordinator(legacyCoordinator, coordinator);
			log.debug("Coordinator NEW:" +coordinator);
			CoordinatorLocalServiceUtil.addCoordinator(coordinator);
		}
    }  
    
    private void migrateProducer(LegacyProducer legacyProducer, long companyId) throws SystemException {
    	Producer producer = null;
    	try {
    		producer = ProducerLocalServiceUtil.getProducer(UserIDMapper.getNewUserId(legacyProducer.getUserId(), companyId));
    		producer = ProducerMapper.mapProducer(legacyProducer, producer);
			log.debug("Producer UPDATE:" +producer);
			ProducerLocalServiceUtil.updateProducer(producer);
		} catch (Exception e) {
			producer = ProducerLocalServiceUtil.createProducer(UserIDMapper.getNewUserId(legacyProducer.getUserId(), companyId));
	 		producer = ProducerMapper.mapProducer(legacyProducer, producer);
			log.debug("Producer NEW:" +producer);
			ProducerLocalServiceUtil.addProducer(producer);
		}
    } 
    
    
    private void migrateVideo(LegacyVideo legacyVideo, long companyId) throws SystemException {
    	Video video = null;
    	try {
    		video = VideoLocalServiceUtil.getVideo(legacyVideo.getId());
    		video = VideoMapper.mapVideo(legacyVideo, video, companyId);
			logInfo("Video UPDATE:" +video);
			VideoLocalServiceUtil.updateVideo(video);
		} catch (Exception e) {
			video = VideoLocalServiceUtil.createVideo(legacyVideo.getId());
			video = VideoMapper.mapVideo(legacyVideo, video, companyId);
			logInfo("Video NEW:" +video);
			VideoLocalServiceUtil.addVideo(video);
		}
    }  

    private void migrateUpload(LegacyUpload legacyUpload, long companyId) throws SystemException {
    	Upload upload = null;
    	try {
    		upload = UploadLocalServiceUtil.getUpload(legacyUpload.getId());
    		upload = UploadMapper.mapUpload(legacyUpload, upload,companyId);
			log.debug("Upload UPDATE:" +upload);
			UploadLocalServiceUtil.updateUpload(upload);
		} catch (Exception e) {
			upload = UploadLocalServiceUtil.createUpload(legacyUpload.getId());
			upload = UploadMapper.mapUpload(legacyUpload, upload, companyId);
			log.debug("Upload NEW:" +upload);
			UploadLocalServiceUtil.addUpload(upload);
		}
    }
    
    private void migrateOffice(LegacyOffice legacyOffice, long companyId) throws SystemException {
    	Office office = null;
    	try {
    		office = OfficeLocalServiceUtil.getOffice(legacyOffice.getId());
    		office = OfficeMapper.mapOffice(legacyOffice, office);
			log.debug("Office UPDATE:" +office);
			OfficeLocalServiceUtil.updateOffice(office);
		} catch (Exception e) {
			office = OfficeLocalServiceUtil.createOffice(legacyOffice.getId());
			office = OfficeMapper.mapOffice(legacyOffice, office);
			log.debug("Office NEW:" +office);
			OfficeLocalServiceUtil.addOffice(office);
		}
    }
    
    private void migrateMetadata(LegacyMetadata legacyMetadata, long companyId) throws SystemException {
    	Metadata metadata = null;
    	try {
    		metadata = MetadataLocalServiceUtil.getMetadata(legacyMetadata.getId());
    		metadata = MetadataMapper.mapMetadata(legacyMetadata, metadata);
			log.debug("Metadata UPDATE:" +metadata);
			MetadataLocalServiceUtil.updateMetadata(metadata);
		} catch (Exception e) {
			metadata = MetadataLocalServiceUtil.createMetadata(legacyMetadata.getId());
			metadata = MetadataMapper.mapMetadata(legacyMetadata, metadata);
			log.debug("Metadata NEW:" +metadata);
			MetadataLocalServiceUtil.addMetadata(metadata);
		}
    }
    
    private void migrateInstitution(LegacyFacility legacyFacility, long companyId, long groupId) throws SystemException {
    	Institution instition = null;
    	try {
    		instition = InstitutionLocalServiceUtil.getInstitution(legacyFacility.getId());
    		instition = FacilityMapper.mapFacility(legacyFacility, instition, groupId);
			log.info("Institution UPDATE:" +instition);
			InstitutionLocalServiceUtil.updateInstitution(instition);
		} catch (Exception e) {
			instition = InstitutionLocalServiceUtil.createInstitution(legacyFacility.getId());
			instition = FacilityMapper.mapFacility(legacyFacility, instition, groupId);
			log.debug("Institution NEW:" +instition);
			InstitutionLocalServiceUtil.addInstitution(instition);
		}
    }

    private void migrateLicense(LegacyLicense legacyLicense, long companyId, long groupId) throws SystemException {
    	License license = null;
    	try {
    		license = LicenseLocalServiceUtil.getLicense(legacyLicense.getId());
    		license = LicenseMapper.mapLicense(legacyLicense, license);
			log.debug("License UPDATE:" +license);
			LicenseLocalServiceUtil.updateLicense(license);
		} catch (Exception e) {
			license = LicenseLocalServiceUtil.createLicense(legacyLicense.getId());
			license = LicenseMapper.mapLicense(legacyLicense, license);
			log.debug("License NEW:" +license);
			LicenseLocalServiceUtil.addLicense(license);
		}
    } 
    
    private void migrateHost(LegacyHost legacyHost, long companyId, long groupId) throws SystemException {
    	Host lastvideolist = null;
    	try {
    		lastvideolist = HostLocalServiceUtil.getHost(legacyHost.getId());
    		lastvideolist = HostMapper.mapHost(legacyHost, lastvideolist, groupId);
			log.debug("Host UPDATE:" +lastvideolist);
			HostLocalServiceUtil.updateHost(lastvideolist);
		} catch (Exception e) {
			lastvideolist = HostLocalServiceUtil.createHost(legacyHost.getId());
			lastvideolist = HostMapper.mapHost(legacyHost, lastvideolist, groupId);
			log.debug("Host NEW:" +lastvideolist);
			HostLocalServiceUtil.addHost(lastvideolist);
		}
    }   
    

    private void migrateL2gsys(LegacyL2gSys legacyL2gSys, long companyId, long groupId) throws SystemException {
    	Sys sys = null;
    	try {
    		sys = SysLocalServiceUtil.getSys(legacyL2gSys.getId());
    		sys = L2gSysMapper.mapL2gSys(legacyL2gSys, sys);
			logInfo("Sys UPDATE:" +sys);
			SysLocalServiceUtil.updateSys(sys);
		} catch (Exception e) {
			sys = SysLocalServiceUtil.createSys(legacyL2gSys.getId());
    		sys = L2gSysMapper.mapL2gSys(legacyL2gSys, sys);
			logInfo("Sys NEW:" +sys);
			SysLocalServiceUtil.addSys(sys);
		}
    }    

    private void migrateLectureseries(LegacyLectureSeries legacyLectureseries, long companyId, long groupId) throws SystemException {
    	Lectureseries lectureseries = null;
    	try {
    		lectureseries = LectureseriesLocalServiceUtil.getLectureseries(legacyLectureseries.getId());
    		lectureseries = LectureseriesMapper.mapLectureseries(legacyLectureseries, lectureseries);
			log.debug("Lectureseries UPDATE:" +lectureseries);
			LectureseriesLocalServiceUtil.updateLectureseries(lectureseries);
		} catch (Exception e) {
			lectureseries = LectureseriesLocalServiceUtil.createLectureseries(legacyLectureseries.getId());
			lectureseries = LectureseriesMapper.mapLectureseries(legacyLectureseries, lectureseries);
			log.debug("Lectureseries NEW:" +lectureseries);
			LectureseriesLocalServiceUtil.addLectureseries(lectureseries);
		}
    }    

   


    private void migrateVideohitlist(LegacyVideoHitlist legacyVideohitlist, long companyId, long groupId) throws SystemException {
    	Videohitlist videohitlist = null;
    	try {
    		videohitlist = VideohitlistLocalServiceUtil.getVideohitlist(legacyVideohitlist.getId());
    		videohitlist = VideoHitlistMapper.mapVideoHitlist(legacyVideohitlist, videohitlist);
			log.debug("Videohitlist UPDATE:" +videohitlist);
			VideohitlistLocalServiceUtil.updateVideohitlist(videohitlist);
		} catch (Exception e) {
			videohitlist = VideohitlistLocalServiceUtil.createVideohitlist(legacyVideohitlist.getId());
    		videohitlist = VideoHitlistMapper.mapVideoHitlist(legacyVideohitlist, videohitlist);
			log.debug("Videohitlist NEW:" +videohitlist);
			VideohitlistLocalServiceUtil.addVideohitlist(videohitlist);
		}
    }    

    private void migrateLastvideolist(LegacyLastVideoList legacyLastvideolist, long companyId, long groupId) throws SystemException {
    	Lastvideolist lastvideolist = null;
    	try {
    		lastvideolist = LastvideolistLocalServiceUtil.getLastvideolist(legacyLastvideolist.getId());
    		lastvideolist = LastVideoListMapper.mapLastVideoList(legacyLastvideolist, lastvideolist);
			log.debug("Lastvideolist UPDATE:" +lastvideolist);
			LastvideolistLocalServiceUtil.updateLastvideolist(lastvideolist);
		} catch (Exception e) {
			lastvideolist = LastvideolistLocalServiceUtil.createLastvideolist(legacyLastvideolist.getId());
			lastvideolist = LastVideoListMapper.mapLastVideoList(legacyLastvideolist, lastvideolist);
			log.debug("Lastvideolist NEW:" +lastvideolist);
			LastvideolistLocalServiceUtil.addLastvideolist(lastvideolist);
		}
    }        
    
        
    
    private void migrateLectureseriesInstitution(LegacyLectureSeriesFacility legacyLectureSeriesFacility, long companyId) throws SystemException {
    	Lectureseries_Institution lectureseriesInstitution = null;
    	try {
    		lectureseriesInstitution = Lectureseries_InstitutionLocalServiceUtil.getLectureseries_Institution(legacyLectureSeriesFacility.getLectureseriesFacilityId());
			if (lectureseriesInstitution != null) {
				lectureseriesInstitution = LectureseriesFacilityMapper.mapLectureseriesFacility(legacyLectureSeriesFacility, lectureseriesInstitution);
				log.debug("LectureSeriesInstitution UPDATE:" +lectureseriesInstitution);
				Lectureseries_InstitutionLocalServiceUtil.updateLectureseries_Institution(lectureseriesInstitution);
			} else {
				lectureseriesInstitution = Lectureseries_InstitutionLocalServiceUtil.createLectureseries_Institution(legacyLectureSeriesFacility.getLectureseriesFacilityId());
				lectureseriesInstitution = LectureseriesFacilityMapper.mapLectureseriesFacility(legacyLectureSeriesFacility, lectureseriesInstitution);
				log.debug("LectureSeriesInstitution NEW:" +lectureseriesInstitution);
				Lectureseries_InstitutionLocalServiceUtil.addLectureseries_Institution(lectureseriesInstitution);
			}
		} catch (Exception e) {
			lectureseriesInstitution = Lectureseries_InstitutionLocalServiceUtil.createLectureseries_Institution(CounterLocalServiceUtil.increment());
			lectureseriesInstitution = LectureseriesFacilityMapper.mapLectureseriesFacility(legacyLectureSeriesFacility, lectureseriesInstitution);
			logInfo("LectureSeriesInstitution NEW:" +lectureseriesInstitution);
			Lectureseries_InstitutionLocalServiceUtil.addLectureseries_Institution(lectureseriesInstitution);
		}
    }
    
    private void migrateVideo_Institution(LegacyVideoFacility legacyVideoFacility,  long companyId) throws SystemException {
    	Video_Institution videoInstitution = null;
    	try {
    		videoInstitution = Video_InstitutionLocalServiceUtil.getVideo_Institution(legacyVideoFacility.getVideoFacilityId());
    		videoInstitution = VideoFacilityMapper.mapVideoFacility(legacyVideoFacility, videoInstitution);
			log.debug("Video_Institution UPDATE:" +videoInstitution);
			Video_InstitutionLocalServiceUtil.updateVideo_Institution(videoInstitution);
		} catch (Exception e) {
			videoInstitution = Video_InstitutionLocalServiceUtil.createVideo_Institution(legacyVideoFacility.getVideoFacilityId());
			videoInstitution = VideoFacilityMapper.mapVideoFacility(legacyVideoFacility, videoInstitution);
			log.debug("Video_Institution NEW:" +videoInstitution);
			Video_InstitutionLocalServiceUtil.addVideo_Institution(videoInstitution);
		}
    }    
    
    private void migrateInstitution_Host(LegacyFacilityHost legacyFacilityHost,  long groupId) throws SystemException {
    	Institution_Host institutionHost = null;
    	try {
    		institutionHost = Institution_HostLocalServiceUtil.getInstitution_Host(legacyFacilityHost.getFacilityHostId());
    		institutionHost = FacilityHostMapper.mapFacilityHost(legacyFacilityHost, institutionHost, groupId);
			log.debug("Institution_Host UPDATE:" +institutionHost);
			Institution_HostLocalServiceUtil.updateInstitution_Host(institutionHost);
		} catch (Exception e) {
			institutionHost = Institution_HostLocalServiceUtil.createInstitution_Host(legacyFacilityHost.getFacilityHostId());
			institutionHost = FacilityHostMapper.mapFacilityHost(legacyFacilityHost, institutionHost, groupId);
			log.debug("Institution_Host NEW:" +institutionHost);
			Institution_HostLocalServiceUtil.addInstitution_Host(institutionHost);
		}
    }  
    
    
    private void migrateProducer_Lectureseries(LegacyProducerLectureseries legacyProducerLectureseries,  long groupId) throws SystemException {
    	Producer_Lectureseries producerLectureseries = null;
    	try {
    		producerLectureseries = Producer_LectureseriesLocalServiceUtil.getProducer_Lectureseries(legacyProducerLectureseries.getId());
    		producerLectureseries = ProducerLectureseriesMapper.mapProducerLectureseries(legacyProducerLectureseries, producerLectureseries);
			log.debug("Producer_Lectureseries UPDATE:" +producerLectureseries);
			Producer_LectureseriesLocalServiceUtil.updateProducer_Lectureseries(producerLectureseries);
		} catch (Exception e) {
			producerLectureseries = Producer_LectureseriesLocalServiceUtil.createProducer_Lectureseries(legacyProducerLectureseries.getId());
			producerLectureseries = ProducerLectureseriesMapper.mapProducerLectureseries(legacyProducerLectureseries, producerLectureseries);
			log.debug("Producer_Lectureseries NEW:" +producerLectureseries);
			Producer_LectureseriesLocalServiceUtil.addProducer_Lectureseries(producerLectureseries);
		}
    }       
   
    private void logInfo(String string) {
    	log.info(string);
    	logInfoString = logInfoString.concat(string + "\n");
    }
    
    private void addRolesToUser(long userId) throws SystemException {
        /* Adding user to 'Power User' and 'User' role. */
        long powerUserRoleId = RoleLocalServiceUtil.fetchRole(companyId, "Power User").getRoleId();
        long userRoleId = RoleLocalServiceUtil.fetchRole(companyId, "User").getRoleId();
        RoleLocalServiceUtil.addUserRole(userId, powerUserRoleId);
        RoleLocalServiceUtil.addUserRole(userId, userRoleId);
    }
    
}
