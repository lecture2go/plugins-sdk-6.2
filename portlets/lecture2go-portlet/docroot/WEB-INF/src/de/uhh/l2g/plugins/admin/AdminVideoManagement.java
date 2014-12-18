package de.uhh.l2g.plugins.admin;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.NoSuchLicenseException;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.LicenseImpl;
import de.uhh.l2g.plugins.model.impl.MetadataImpl;
import de.uhh.l2g.plugins.model.impl.ProducerImpl;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.model.impl.Video_InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.Video_LectureseriesImpl;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.util.ProzessManager;
import de.uhh.l2g.plugins.util.Security;

public class AdminVideoManagement extends MVCPortlet {

	private final static Logger logger = Logger.getLogger(AdminVideoManagement.class.getName());
	
	@SuppressWarnings("unused")
	public void addSegment(ActionRequest request, ActionResponse response){
		int i = 0;
		i++;
		response.setRenderParameter("jspPage", "/admin/includeAddSegment.jsp");
	}
	
	public void viewVideo(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		
		List<Lectureseries> ls  = LectureseriesLocalServiceUtil.getAllLectureseriesWhithOpenaccessVideos();
		List<Video> vl = VideoLocalServiceUtil.getLatestVideos();
		
		//permissions
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		
		//user 
		String uId = request.getRemoteUser();
		Long userId = new Long(uId);
		User remoteUser = UserLocalServiceUtil.getUserById(userId);
		
		// requested producer id
		Long reqPproducerId = (long)0;
		try{reqPproducerId = new Long(request.getParameterMap().get("producerI	d")[0]);}catch(Exception e){}
		
		// requested lecture series id
		Long reqLectureseriesId = (long)0;
		try{reqLectureseriesId = new Long(request.getParameterMap().get("lectureseriesId")[0]);}catch(Exception e){}
			
		// requested video
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		Video reqVideo = new VideoImpl(); 
		try{reqVideo = VideoLocalServiceUtil.getVideo(reqVideoId);}catch(Exception e){}
		
		//requested producer
		Producer reqProducer = new ProducerImpl();
		try{
			if(reqVideo.getVideoId()>0)reqProducer = ProducerLocalServiceUtil.getProdUcer(reqVideo.getProducerId());
			else {
				reqProducer = ProducerLocalServiceUtil.getProdUcer(reqPproducerId);
				reqVideo.setProducerId(reqPproducerId);
			}
		}catch(Exception e){}
		request.setAttribute("reqProducer", reqProducer);
		
		// requested lecture series object
		Lectureseries reqLectureseries = new LectureseriesImpl();
		try{
			if(reqVideo.getVideoId()>0)reqLectureseries = LectureseriesLocalServiceUtil.getLectureseries(reqVideo.getLectureseriesId());
			else{
				reqLectureseries = LectureseriesLocalServiceUtil.getLectureseries(reqLectureseriesId);
				reqVideo.setLectureseriesId(reqLectureseriesId);
			}
		}catch(Exception e){}
		request.setAttribute("reqLectureseries", reqLectureseries);
		
		// requested metadata
		Metadata reqMetadata = new MetadataImpl();
		try{
			if(reqVideo.getVideoId()>0)reqMetadata = (MetadataImpl)MetadataLocalServiceUtil.getMetadata(reqVideo.getMetadataId());
			else{
				reqMetadata.setDescription(reqLectureseries.getLongDesc());
				reqMetadata.setCreator(reqProducer.getFirstName()+" "+reqProducer.getLastName());
				reqMetadata.setRightsHolder(reqLectureseries.getInstructorsString());
				reqMetadata.setPublisher(reqProducer.getFirstName()+" "+reqProducer.getLastName());
				reqMetadata.setLanguage(reqLectureseries.getLanguage());
			}
		}catch(Exception e){}
		request.setAttribute("reqMetadata", reqMetadata);
		
		// requested lecture series list
		List<Lectureseries> reqLectureseriesList = new ArrayList<Lectureseries>();
		try{
			if(reqVideo.getVideoId()>0)reqLectureseriesList = LectureseriesLocalServiceUtil.getFilteredBySemesterFacultyProducer(1, "", (long) 0, reqVideo.getProducerId());
			else reqLectureseriesList = LectureseriesLocalServiceUtil.getFilteredBySemesterFacultyProducer(1, "", (long) 0, reqPproducerId);
		}catch(Exception e){}
		request.setAttribute("reqLectureseriesList", reqLectureseriesList);
		
		//requested license
		License reqLicense = new LicenseImpl();
		try{reqLicense = LicenseLocalServiceUtil.getByVideoId(reqVideo.getVideoId());}catch(Exception e){}
		request.setAttribute("reqLicense", reqLicense);
		
		request.setAttribute("reqVideo", reqVideo);
		response.setRenderParameter("jspPage", "/admin/editVideo.jsp");
	}
	
	public void addVideo(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		//first metadata
		Metadata reqMetadata = new MetadataImpl();
		reqMetadata = MetadataLocalServiceUtil.addMetadata(reqMetadata);
		request.setAttribute("reqMetadata", reqMetadata);

		//lecture series
		Long lectureseriesId = new Long(request.getParameter("lectureseriesId"));
		Lectureseries reqLectureseries = new LectureseriesImpl();
		try{reqLectureseries = (Lectureseries) LectureseriesLocalServiceUtil.getLectureseries(lectureseriesId); }catch(Exception e){}
		request.setAttribute("reqLectureseries", reqLectureseries);

		//producer
		Long producerId = new Long(request.getParameter("producerId"));
		ProducerImpl reqProducer = new ProducerImpl();
		reqProducer = (ProducerImpl)ProducerLocalServiceUtil.getProdUcer(producerId);
		request.setAttribute("reqProducer", reqProducer);

		//video
		Video newVideo = new VideoImpl();
		newVideo.setProducerId(producerId);
		newVideo.setLectureseriesId(lectureseriesId);
		newVideo.setHostId(reqProducer.getHostId());
		newVideo.setMetadataId(reqMetadata.getMetadataId());
		newVideo.setRootInstitutionId(reqProducer.getInstitutionId());
		//save it
		Video video = VideoLocalServiceUtil.addVideo(newVideo);
		request.setAttribute("reqVideo", newVideo);
		
		//link to lectureseries list
		Video_Lectureseries vl = new Video_LectureseriesImpl();
		vl.setLectureseriesId(lectureseriesId);
		vl.setVideoId(newVideo.getVideoId());
		Video_LectureseriesLocalServiceUtil.addVideo_Lectureseries(vl);
		
		// requested lecture series list
		List<Lectureseries> reqLectureseriesList = new ArrayList<Lectureseries>();
		try{reqLectureseriesList = LectureseriesLocalServiceUtil.getFilteredBySemesterFacultyProducer(1, "", (long) 0, producerId);}catch(Exception e){}
		request.setAttribute("reqLectureseriesList", reqLectureseriesList);
		
		//licence
		License license = new LicenseImpl();
		license.setVideoId(newVideo.getVideoId());
		LicenseLocalServiceUtil.addLicense(license);
		request.setAttribute("reqLicense", license);

		//update lg_video_institution table
		Video_Institution vf = new Video_InstitutionImpl();
		vf.setVideoId(video.getVideoId());
		vf.setInstitutionId(reqProducer.getInstitutionId());
		Video_InstitutionLocalServiceUtil.addVideo_Institution(vf);
		
		response.setRenderParameter("jspPage", "/admin/editVideo.jsp");
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		String resourceID = resourceRequest.getResourceID();
		Long videoId = ParamUtil.getLong(resourceRequest, "videoId");
		Video video = VideoLocalServiceUtil.getVideo(videoId);
		Metadata metadata = new MetadataImpl();
		try {
			Long metadataId = video.getMetadataId();
			metadata = MetadataLocalServiceUtil.getMetadata(metadataId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		License license = new LicenseImpl();
		try {
			license = LicenseLocalServiceUtil.getByVideoId(video.getVideoId());
		} catch (NoSuchLicenseException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		if(resourceID.equals("updateMeatadata")){
	 	    String title = ParamUtil.getString(resourceRequest, "title");
			String language = ParamUtil.getString(resourceRequest, "language");
			String tags = ParamUtil.getString(resourceRequest, "tags");
			String creator = ParamUtil.getString(resourceRequest, "creator");
			String rightsHolder = ParamUtil.getString(resourceRequest, "rightsHolder");
			String publisher = ParamUtil.getString(resourceRequest, "publisher");
			Long lId = ParamUtil.getLong(resourceRequest, "lectureseriesId");
			//update data base
			try {
				video.setTitle(title);
				video.setTags(tags);
				video.setLectureseriesId(lId);
				VideoLocalServiceUtil.updateVideo(video);
			} catch (NumberFormatException e) {
				System.out.println(e);
			} catch (SystemException e) {
				System.out.println(e);
			}
			//metadata
			try {
				metadata.setTitle(title);
				metadata.setCreator(creator);
				metadata.setRightsHolder(rightsHolder);
				metadata.setPublisher(publisher);
				metadata.setLanguage(language);
				MetadataLocalServiceUtil.updateMetadata(metadata);
			} catch (NumberFormatException e) {
				System.out.println(e);
			} catch (SystemException e) {
				System.out.println(e);
			}
			JSONObject json = JSONFactoryUtil.createJSONObject();
			writeJSON(resourceRequest, resourceResponse, json);
		}
		
		if(resourceID.equals("updateLicense")){
			String licens = ParamUtil.getString(resourceRequest, "license");
			//reset first
			license.setCcbyncsa(0);
			license.setL2go(0);
			//save next
			if(licens.equals("uhhl2go"))license.setL2go(1);
			if(licens.equals("ccbyncsa"))license.setCcbyncsa(1);
			try {
				LicenseLocalServiceUtil.updateLicense(license);
				logger.info("LICENSE_UPDATE_SUCCESS");
			} catch (SystemException e) {
				e.printStackTrace();
				logger.info("LICENSE_UPDATE_FAILED");
			}
			JSONObject json = JSONFactoryUtil.createJSONObject();
			writeJSON(resourceRequest, resourceResponse, json);
		}
		
		if(resourceID.equals("updateDescription")){
			String description = ParamUtil.getString(resourceRequest, "description");
			metadata.setDescription(description);
			try {
				MetadataLocalServiceUtil.updateMetadata(metadata);
				logger.info("DESCRIPTION_UPDATE_SUCCESS");
			} catch (SystemException e) {
				e.printStackTrace();
				logger.info("DESCRIPTION_UPDATE_FAILED");
			}
			JSONObject json = JSONFactoryUtil.createJSONObject();
			writeJSON(resourceRequest, resourceResponse, json);
		}
		
		if(resourceID.equals("uploadMe")){
			try {
				UploadPortletRequest uploadrequest = PortalUtil.getUploadPortletRequest(resourceRequest);
				InputStream inputStream = uploadrequest.getFileAsStream("fileToUpload");

				if(Validator.isNotNull(inputStream)){
					File file = uploadrequest.getFile("fileToUpload");
					String uploadString = getFileAsString(file);
		
					if (Validator.isNotNull(uploadString)) {
						resourceResponse.getWriter().write( "validated_successfully");
						File newFile = new File("/Users/isturm/Desktop/l2gomedia/"+file.getName());
						file.renameTo(newFile);
						logger.info("VALIDATED_SUCCESSFULLY");
					}else{
						resourceResponse.getWriter().write("failed");
						logger.info("VALIDATION_FAILED");
					}
				}
			} catch (Exception e) {
				logger.info( "Error in adding modem");
			}			
		}

	}

	public String getFileAsString(File file) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		StringBuffer sb = new StringBuffer();
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
	
			while (dis.available() != 0) {
				sb.append(dis.readLine() + "\n");
			}
			fis.close();
			bis.close();
			dis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public void removeVideo(ActionRequest request, ActionResponse response){
		Video video = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getVideo(reqVideoId);
		ProzessManager pm = new ProzessManager();	
		pm.deleteVideo(video);
	}
	
	public void lockVideo(ActionRequest request, ActionResponse response){
		Video video = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getVideo(reqVideoId);
		ProzessManager pm = new ProzessManager();	
		try {
			pm.deactivateOpenaccess(video);
		} catch (PortalException e) {
		} catch (SystemException e) {
		}
	}
	
	public void unlockVideo(ActionRequest request, ActionResponse response){
		Video video = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getVideo(reqVideoId);
		ProzessManager pm = new ProzessManager();	
		try {
			pm.activateOpenaccess(video);
		} catch (SystemException e) {
		} catch (PortalException e) {
		}
	}
	
	public void activateDownload(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		Video video = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getVideo(reqVideoId);
		ProzessManager pm = new ProzessManager();
		pm.activateDownload(video);
	}
	
	public void deactivateDownload(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		Video video = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getVideo(reqVideoId);
		ProzessManager pm = new ProzessManager();
		pm.deactivateDownload(video);
	}
	
	public void segmentateVideo(ActionRequest request, ActionResponse response){
		
	}
}
