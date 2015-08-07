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
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import de.uhh.l2g.plugins.migration.mapper.AddressMapper;
import de.uhh.l2g.plugins.migration.mapper.ContactMapper;
import de.uhh.l2g.plugins.migration.mapper.CoordinatorMapper;
import de.uhh.l2g.plugins.migration.mapper.LectureseriesFacilityMapper;
import de.uhh.l2g.plugins.migration.mapper.MetadataMapper;
import de.uhh.l2g.plugins.migration.mapper.OfficeMapper;
import de.uhh.l2g.plugins.migration.mapper.ProducerMapper;
import de.uhh.l2g.plugins.migration.mapper.SegmentMapper;
import de.uhh.l2g.plugins.migration.mapper.UploadMapper;
import de.uhh.l2g.plugins.migration.mapper.UserIDMapper;
import de.uhh.l2g.plugins.migration.mapper.UserMapper;
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
import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Office;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Upload;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.OfficeLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.UploadLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;

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
    //private static String sites = "10182";
    private static String sites = "20182";
    
    private static long companyId = 10155;
    

    /**
     * View handler (default).
     */
    @RequestMapping
    public String list(PortletRequest request, Model model) throws SystemException {
        log.info("Rendering defaultView");
        // Liferay 52 Entites 
        
        model.addAttribute("userEntrieSize", LegacyUserLocalServiceUtil.getLegacyUsersCount());
        model.addAttribute("contactEntrieSize", LegacyContactLocalServiceUtil.getLegacyContactsCount());
        model.addAttribute("officeEntrieSize", LegacyOfficeLocalServiceUtil.getLegacyOfficesCount());
        model.addAttribute("legacyLectureSeriesFacitityEntrieSize", LegacyLectureSeriesFacilityLocalServiceUtil.getLegacyLectureSeriesFacilitiesCount());
        model.addAttribute("metadataEntrieSize", LegacyMetadataLocalServiceUtil.getLegacyMetadatasCount());
        model.addAttribute("segmentEntrieSize", LegacySegmentLocalServiceUtil.getLegacySegmentsCount());
        model.addAttribute("coordinatorEntrieSize", LegacyCoordinatorLocalServiceUtil.getLegacyCoordinatorsCount());
        model.addAttribute("producerEntrieSize", LegacyProducerLocalServiceUtil.getLegacyProducersCount());
        model.addAttribute("videoEntrieSize", LegacyVideoLocalServiceUtil.getLegacyVideosCount());
        model.addAttribute("uploadEntrieSize", LegacyUploadLocalServiceUtil.getLegacyUploadsCount());
        
        // Liferay 62 entities
        model.addAttribute("userEntrieSize62", UserLocalServiceUtil.getUsersCount());
        model.addAttribute("contactEntrieSize62", ContactLocalServiceUtil.getContactsCount());
        model.addAttribute("officeEntrieSize62", OfficeLocalServiceUtil.getOfficesCount());
        model.addAttribute("LectureSeriesInstitutionEntrieSize62", Lectureseries_InstitutionLocalServiceUtil.getLectureseriesInstitutionsCount());
        model.addAttribute("metadataEntrieSize62", MetadataLocalServiceUtil.getMetadatasCount());
        model.addAttribute("segmentEntrieSize62", SegmentLocalServiceUtil.getSegmentsCount());
        model.addAttribute("coordinatorEntrieSize62", CoordinatorLocalServiceUtil.getCoordinatorsCount());
        model.addAttribute("producerEntrieSize62", ProducerLocalServiceUtil.getProducersCount());
        model.addAttribute("videoEntrieSize62", VideoLocalServiceUtil.getVideosCount());
        model.addAttribute("uploadEntrieSize62", UploadLocalServiceUtil.getUploadsCount());
        
        
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
	    	log.info("Error connect to LegacyLectureSeriesFacility Entity", e);
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
	        		log.debug("LegacyMetadata found Type:" +  metadata.getType());
	        	}
	        }
	        log.info("Test LegacyMetadata Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyMetadata Entity", e);
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
	    	log.info("Error connect to LegacyMetadata Entity", e);
			log.info("Test LegacySegment Entity...failed");
		}
		
    	/// ENTITY coordinator
        List<LegacyCoordinator> coordinators;
		try {
			log.info("Test LegacyCoordinator Entity...");
			coordinators = LegacyCoordinatorLocalServiceUtil.getLegacyCoordinators(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyCoordinator coordinator: coordinators) {
	        	log.debug("LegacyCoordinator found:" +  coordinator);
	        }
	        log.info("Test LegacyCoordinator Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyCoordinator Entity", e);
			log.info("Test LegacyCoordinator Entity...failed");
		}		
		
    	/// ENTITY Producer
        List<LegacyProducer> producers;
		try {
			log.info("Test LegacyProducer Entity...");
			producers = LegacyProducerLocalServiceUtil.getLegacyProducers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyProducer producer: producers) {
	        	log.debug("LegacyProducer found:" +  producer);
	        }
	        log.info("Test LegacyProducer Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyProducer Entity", e);
			log.info("Test LegacyProducer Entity...failed");
		}	
		
    	/// ENTITY Video
        List<LegacyVideo> videos;
		try {
			log.info("Test LegacyVideo Entity...");
			videos = LegacyVideoLocalServiceUtil.getLegacyVideos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyVideo video: videos) {
	        	log.debug("LegacyVideo found:" +  video);
	        }
	        log.info("Test LegacyVideo Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyVideo Entity", e);
			log.info("Test LegacyVideo Entity...failed");
		}

    	/// ENTITY upload
        List<LegacyVideoHitlist> uploads;
		try {
			log.info("Test LegacyVideoHitlist Entity...");
			uploads = LegacyVideoHitlistLocalServiceUtil.getLegacyVideoHitlists(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyVideoHitlist upload: uploads) {
	        	log.debug("LegacyVideoHitlist found:" +  upload);
	        }
	        log.info("Test LegacyVideoHitlist Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyVideoHitlist Entity", e);
			log.info("Test LegacyVideoHitlist Entity...failed");
		}	
		
    	/// ENTITY license
        List<LegacyLicense> licenses;
		try {
			log.info("Test LegacyLicense Entity...");
			licenses = LegacyLicenseLocalServiceUtil.getLegacyLicenses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyLicense license: licenses) {
	        	log.debug("LegacyLicense found:" +  license);
	        }
	        log.info("Test LegacyLicense Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyLicense Entity", e);
			log.info("Test LegacyLicense Entity...failed");
		}	

    	/// ENTITY facilityHost
        List<LegacyFacilityHost> facilityHosts;
		try {
			log.info("Test LegacyFacilityHost Entity...");
			facilityHosts = LegacyFacilityHostLocalServiceUtil.getLegacyFacilityHosts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyFacilityHost facilityHost: facilityHosts) {
	        	log.debug("LegacyFacilityHost found:" +  facilityHost);
	        }
	        log.info("Test LegacyFacilityHost Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyFacilityHost Entity", e);
			log.info("Test LegacyFacilityHost Entity...failed");
		}	

    	/// ENTITY producerLectureseries
        List<LegacyProducerLectureseries> producerLectureserieses;
		try {
			log.info("Test LegacyProducerLectureseries Entity...");
			producerLectureserieses = LegacyProducerLectureseriesLocalServiceUtil.getLegacyProducerLectureserieses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyProducerLectureseries producerLectureseries: producerLectureserieses) {
	        	log.debug("LegacyProducerLectureseries found:" +  producerLectureseries);
	        }
	        log.info("Test LegacyProducerLectureseries Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyProducerLectureseries Entity", e);
			log.info("Test LegacyProducerLectureseries Entity...failed");
		}	
		
    	/// ENTITY host
        List<LegacyHost> hosts;
		try {
			log.info("Test LegacyHost Entity...");
			hosts = LegacyHostLocalServiceUtil.getLegacyHosts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyHost host: hosts) {
	        	log.debug("LegacyHost found:" +  host);
	        }
	        log.info("Test LegacyHost Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyHost Entity", e);
			log.info("Test LegacyHost Entity...failed");
		}	
		
    	/// ENTITY l2gSys
        List<LegacyL2gSys> l2gSyss;
		try {
			log.info("Test LegacyL2gSys Entity...");
			l2gSyss = LegacyL2gSysLocalServiceUtil.getLegacyL2gSyses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyL2gSys l2gSys: l2gSyss) {
	        	log.debug("LegacyL2gSys found:" +  l2gSys);
	        }
	        log.info("Test LegacyL2gSys Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyL2gSys Entity", e);
			log.info("Test LegacyL2gSys Entity...failed");
		}	
		
    	/// ENTITY videoFacility
        List<LegacyVideoFacility> videoFacilitys;
		try {
			log.info("Test LegacyVideoFacility Entity...");
			videoFacilitys = LegacyVideoFacilityLocalServiceUtil.getLegacyVideoFacilities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyVideoFacility videoFacility: videoFacilitys) {
	        	log.debug("LegacyVideoFacility found:" +  videoFacility);
	        }
	        log.info("Test LegacyVideoFacility Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyVideoFacility Entity", e);
			log.info("Test LegacyVideoFacility Entity...failed");
		}	
		
    	/// ENTITY facility
        List<LegacyFacility> facilitys;
		try {
			log.info("Test LegacyFacility Entity...");
			facilitys = LegacyFacilityLocalServiceUtil.getLegacyFacilities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyFacility facility: facilitys) {
	        	log.debug("LegacyFacility found:" +  facility);
	        }
	        log.info("Test LegacyFacility Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyFacility Entity", e);
			log.info("Test LegacyFacility Entity...failed");
		}	
		
    	/// ENTITY videoHitlist
        List<LegacyVideoHitlist> videoHitlists;
		try {
			log.info("Test LegacyVideoHitlist Entity...");
			videoHitlists = LegacyVideoHitlistLocalServiceUtil.getLegacyVideoHitlists(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyVideoHitlist videoHitlist: videoHitlists) {
	        	log.debug("LegacyVideoHitlist found:" +  videoHitlist);
	        }
	        log.info("Test LegacyVideoHitlist Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyVideoHitlist Entity", e);
			log.info("Test LegacyVideoHitlist Entity...failed");
		}			
		
		
    	/// ENTITY lectureSeries
        List<LegacyLectureSeries> lectureSerieses;
		try {
			log.info("Test LegacyLectureSeries Entity...");
			lectureSerieses = LegacyLectureSeriesLocalServiceUtil.getLegacyLectureSerieses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyLectureSeries lectureSeries: lectureSerieses) {
	        	log.debug("LegacyLectureSeries found:" +  lectureSeries);
	        }
	        log.info("Test LegacyLectureSeries Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyLectureSeries Entity", e);
			log.info("Test LegacyLectureSeries Entity...failed");
		}	
		
    	/// ENTITY lastVideolist
        List<LegacyLastVideoList> lastVideolists;
		try {
			log.info("Test LegacyVideoVideolist Entity...");
			lastVideolists = LegacyLastVideoListLocalServiceUtil.getLegacyLastVideoLists(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        for (LegacyLastVideoList lastVideolist: lastVideolists) {
	        	log.debug("LegacyVideoVideolist found:" +  lastVideolist);
	        }
	        log.info("Test LegacyVideoVideolist Entity...OK!");		
		} catch (SystemException e) {
	    	log.info("Error connect to LegacyVideoVideolist Entity", e);
			log.info("Test LegacyVideoVideolist Entity...failed");
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
    public void migrateSegments(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Segments
		List<LegacySegment> segments;
		try {
			segments = LegacySegmentLocalServiceUtil.getLegacySegments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
		for (LegacySegment segment: segments) {
			migrateSegment(segment, companyId);
		} 
    	
		} catch (SystemException e1) {
			log.info("Migration of Segments failed. Can not read Source Data");
		}
		
    }
    
    @RequestMapping(params = "action=migrateCoordinators")
    public void migrateCoordinator(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Coordinator
		List<LegacyCoordinator> coordinators;
		try {
			coordinators = LegacyCoordinatorLocalServiceUtil.getLegacyCoordinators(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
		for (LegacyCoordinator coordinator: coordinators) {
			migrateCoordinator(coordinator, companyId);
		} 
    	
		} catch (SystemException e1) {
			log.info("Migration of Coordinator failed. Can not read Source Data");
		}
		
    }
    
    
    @RequestMapping(params = "action=migrateProducers")
    public void migrateProducers(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Producers
		List<LegacyProducer> producers;
		try {
			producers = LegacyProducerLocalServiceUtil.getLegacyProducers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
		for (LegacyProducer producer: producers) {
			migrateProducer(producer, companyId);
		} 
    	
		} catch (SystemException e1) {
			log.info("Migration of User failed. Can not read Source Data");
		}
		
    }
    
    
    @RequestMapping(params = "action=migrateVideos")
    public void migrateVideos(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Videos
		List<LegacyVideo> videos;
		try {
			videos = LegacyVideoLocalServiceUtil.getLegacyVideos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
		for (LegacyVideo video: videos) {
			migrateVideo(video, companyId);
		} 
    	
		} catch (SystemException e1) {
			log.info("Migration of User failed. Can not read Source Data");
		}
		
    }
    
    
    @RequestMapping(params = "action=migrateUploads")
    public void migrateUploads(ActionRequest request) throws FileNotFoundException {
    	// Load Legacy Uploads
    	log.info("Call migrateUploads");
		List<LegacyUpload> uploads;
		try {
			uploads = LegacyUploadLocalServiceUtil.getLegacyUploads(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (LegacyUpload upload: uploads) {
			migrateUpload(upload, companyId);
		} 
    	
		} catch (SystemException e1) {
			log.info("Migration of uploads failed. Can not read Source Data");
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
    	LegacyContact legacyContact;
    	legacyContact = LegacyContactLocalServiceUtil.getLegacyContact(legacyUser.getContactId());
//    	User newUser = UserLocalServiceUtil.createUser(CounterLocalServiceUtil.increment());
    	/*
    	 * 1) Read out legacy  Fields
    	 * 2) Check if User already existing in LF 62, if yes do update of existing user (
    	 * 		a) call createOrGetID Methods 
    	 * 		b) call createOrUpdate Methodes 
    	 * )
    	 * 
    	 */
    	
    	
        /* Prepare Mandatory Data. */
//        String mailAddress = legacyUser.getEmailAddress();
//        String firstName = legacyContact.getFirstName();
//        String lastName = legacyContact.getLastName();
//        Date birthDay =  legacyContact.getBirthday();
//        String userName = legacyContact.getUserName();
//        Boolean isMale = legacyContact.getMale();
//        int status = (legacyUser.isActive() ?  WorkflowConstants.STATUS_APPROVED : WorkflowConstants.STATUS_INACTIVE);
//        Date lastLoginDate = legacyUser.getLastLoginDate();
//        Date createDate = legacyUser.getCreateDate();
//        Date modifiedDate = legacyUser.getModifiedDate();
//        String password = legacyUser.getPassword();
//        String screenName = legacyUser.getScreenName();
//        String languageId = legacyUser.getLanguageId();
//        String jobTitle = legacyContact.getJobTitle();
//        //TODO Read Adress;
//        String street= "";
//        String plz= "";
//        String city = "";
//        String country = "";
    	
        log.info("Creating or updating user " + legacyContact.getFirstName() + " " + legacyContact.getLastName() + " with mailAddress " + legacyUser.getEmailAddress());
        User exstingUser = null;

        try {
        	exstingUser = UserLocalServiceUtil.getUserByEmailAddress(companyId, legacyUser.getEmailAddress());
		} catch (PortalException e) {
			log.debug("User not found by mailAddress.");
		} catch (SystemException e) {
			log.debug("User not found by mailAddress.");
		}
        
        
        if (!legacyUser.getEmailAddress().equals("default@liferay.com")) {
            long contactId = createOrGetContactId(exstingUser);
            long userId = createOrGetUserId(exstingUser);
            long personalGroupId = createOrGetPersonalGroupId(exstingUser,  String.valueOf(userId));
            
            User user =	createOrUpdateUser(companyId, exstingUser, userId, legacyUser, legacyContact, contactId);
            Contact contact = createOrUpdateContact(companyId,contactId,user,legacyContact);
            createOrUpdateAddress(companyId, user, legacyUser, contact);
            createPersonalGroupIfNotExistent(exstingUser, personalGroupId, userId, currentUserId, String.valueOf(userId), user.getScreenName());
            createPersonalLayoutIfNotExistent(personalGroupId, true);
            createPersonalLayoutIfNotExistent(personalGroupId, false);
            
            //update sites to user 
            addUserToSite(sites, userId, companyId);
            log.info("Added user with id: " + user.getUserId());
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
    
    
    private Contact createOrUpdateContact(long companyId, long contactId,  User user, LegacyContact legacyContact) throws SystemException {
            
    		Contact contact;
			try {
				contact = ContactLocalServiceUtil.getContact(user.getContactId());
				contact = ContactMapper.mapContact(contact, legacyContact, user, companyId);
				ContactLocalServiceUtil.updateContact(contact);
			} catch (Exception e) {
				contact = ContactLocalServiceUtil.createContact(contactId);
				contact = ContactMapper.mapContact(contact, legacyContact, user, companyId);
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
			log.info("LegacyUser did not have any address - create nothing");
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
				address = AddressMapper.mapAddress(address, legacyAddress, user, companyId);
				AddressLocalServiceUtil.updateAddress(address);
			} catch (Exception e) {
				// created new address 
				address = AddressLocalServiceUtil.createAddress(CounterLocalServiceUtil.increment());
				address = AddressMapper.mapAddress(address, legacyAddress, user, companyId);
				AddressLocalServiceUtil.addAddress(address);
			}
    	}
    }

    private User createOrUpdateUser(long companyId, User user, long userId, LegacyUser legacyUser, LegacyContact contact,  long contactId)
            throws SystemException {
    	// Only create User if user was not imported before 
        if (user == null) {
            user = UserLocalServiceUtil.createUser(userId);
            user = UserMapper.mapUser(companyId, user, legacyUser, contact, contactId);
            UserLocalServiceUtil.addUser(user);
        } else {
            user = UserMapper.mapUser(companyId, user, legacyUser, contact, contactId);
            UserLocalServiceUtil.updateUser(user);
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
					log.info("Link user to Site/Group with name: \"" + group.getName() + "\"");
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
				log.info("Personal Group found:"  + groupId + "  - do nothing");
			} catch (PortalException e) {
				log.info("No existing Personal Group found with groupId:"  + groupId + "  - create new one"); 
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
            	log.info("Can't get groupId for user with ID: " + userIdAsString + " : createId by CounterLocalServiceUtil" );
            	groupId = CounterLocalServiceUtil.increment();
            }
        return groupId;
    }
    
    private void createPersonalLayoutIfNotExistent(long groupId, boolean privateLayout)  {
    	LayoutSet layoutSet = null;
    	try {
			layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, privateLayout);
			log.error("Layout Set for groupId (userId) : " + groupId + " existing - do nothing");
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
				log.error("Can't create Layout Set for groupId (userId) : " + groupId + " - user will not be able to login");
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
			log.info("Video UPDATE:" +video);
			VideoLocalServiceUtil.updateVideo(video);
		} catch (Exception e) {
			video = VideoLocalServiceUtil.createVideo(legacyVideo.getId());
			video = VideoMapper.mapVideo(legacyVideo, video, companyId);
			log.info("Video NEW:" +video);
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
    
    private void migrateLectureseriesInstitution(LegacyLectureSeriesFacility legacyLectureSeriesFacility, long companyId) throws SystemException {
    	Lectureseries_Institution lectureseriesInstitution = null;
    	try {
    		Lectureseries_InstitutionLocalServiceUtil.deleteLectureseries_Institution(123L);
    		lectureseriesInstitution = Lectureseries_InstitutionLocalServiceUtil.getLectureseries_Institution(123L);
    		//lectureseriesInstitution = LectureseriesFacilityMapper.mapLectureseriesFacility(legacyLectureSeriesFacility, lectureseriesInstitution);
			log.debug("LectureSeriesInstitution UPDATE:" +lectureseriesInstitution);
			Lectureseries_InstitutionLocalServiceUtil.updateLectureseries_Institution(lectureseriesInstitution);
		} catch (Exception e) {
			//lectureseriesInstitution = LectureseriesInstitutionLocalServiceUtil.createLectureseriesInstitution(CounterLocalServiceUtil.increment());
			//lectureseriesInstitution = LectureseriesFacilityMapper.mapLectureseriesFacility(legacyLectureSeriesFacility, lectureseriesInstitution);
			//log.debug("LectureSeriesInstitution NEW:" +lectureseriesInstitution);
			Lectureseries_InstitutionLocalServiceUtil.addLectureseries_Institution(lectureseriesInstitution);
		}
    }
    
//    private void migrateOffice(LegacyOffice legacyOffice, long companyId) throws SystemException {
//    	Office office = null;
//    	try {
//    		office = OfficeLocalServiceUtil.getOffice(legacyOffice.getId());
//    		office = OfficeMapper.mapOffice(legacyOffice, office);
//			log.debug("Office UPDATE:" +office);
//			OfficeLocalServiceUtil.updateOffice(office);
//		} catch (Exception e) {
//			office = OfficeLocalServiceUtil.createOffice(legacyOffice.getId());
//			office = OfficeMapper.mapOffice(legacyOffice, office);
//			log.debug("Office NEW:" +office);
//			OfficeLocalServiceUtil.addOffice(office);
//		}
//    }    
   
}
