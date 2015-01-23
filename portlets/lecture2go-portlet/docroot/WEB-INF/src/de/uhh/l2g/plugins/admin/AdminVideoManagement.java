package de.uhh.l2g.plugins.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.NoSuchLicenseException;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.LicenseImpl;
import de.uhh.l2g.plugins.model.impl.MetadataImpl;
import de.uhh.l2g.plugins.model.impl.ProducerImpl;
import de.uhh.l2g.plugins.model.impl.SegmentImpl;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.model.impl.Video_InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.Video_LectureseriesImpl;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.util.FFmpegManager;
import de.uhh.l2g.plugins.util.ProzessManager;

public class AdminVideoManagement extends MVCPortlet {

	private final static Logger logger = Logger.getLogger(AdminVideoManagement.class.getName());
	
	public void addSegment(ActionRequest request, ActionResponse response){
		Video reqVideo = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		reqVideo = VideoLocalServiceUtil.getFullVideo(reqVideoId);

		response.setRenderParameter("jspPage", "/admin/segments.jsp");
		request.setAttribute("reqVideo", reqVideo);
		
	}
	
	public void viewVideo(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		
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
		String userID = resourceRequest.getRemoteUser();
		Long userId = new Long(userID);
		String resourceID = resourceRequest.getResourceID();
		Long videoId = ParamUtil.getLong(resourceRequest, "videoId");
		Video video = VideoLocalServiceUtil.getFullVideo(videoId);
		
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
		
		if(resourceID.equals("updateVideoFileName")){
			String fileName = ParamUtil.getString(resourceRequest, "fileName");
			String secureFileName = ParamUtil.getString(resourceRequest, "secureFileName");
			String generationDate = ParamUtil.getString(resourceRequest, "generationDate");
			String containerFormat = fileName.split("\\.")[fileName.split("\\.").length-1];
			//update data base
			try {
				video.setFilename(fileName);
				video.setSurl(secureFileName);
				video.setContainerFormat(containerFormat);
				video.setGenerationDate(generationDate);
				VideoLocalServiceUtil.updateVideo(video);
				FFmpegManager.updateFfmpegMetadata(video);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			} catch (PortalException e) {
				e.printStackTrace();
			}
			
			JSONObject json = JSONFactoryUtil.createJSONObject();
			writeJSON(resourceRequest, resourceResponse, json);
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
		
		if(resourceID.equals("toggleSegmentation")){
			String segmentation = ParamUtil.getString(resourceRequest, "segmentationPermittedCheckbox");
			int sAllowed = new Integer(segmentation);
			if(sAllowed==0)video.setPermittedToSegment(0);
			else video.setPermittedToSegment(1);
			
			try {
				VideoLocalServiceUtil.updateVideo(video);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			JSONObject json = JSONFactoryUtil.createJSONObject();
			writeJSON(resourceRequest, resourceResponse, json);
		}
		
		if (resourceID.equals("addSegment")) {
			String shortTitle = ParamUtil.getString(resourceRequest, "chortTitle");
			String timeStart = ParamUtil.getString(resourceRequest, "timeStart");
			String timeEnd = ParamUtil.getString(resourceRequest, "timeEnd");
			String text = ParamUtil.getString(resourceRequest, "text");
			String chapter = ParamUtil.getString(resourceRequest, "chapter");
			String comment = ParamUtil.getString(resourceRequest, "comment");

			int chap = 0;
			if (chapter.equals("1") && comment.equals("0"))
				chap = 1;

			if (!shortTitle.trim().equals("") && !timeStart.trim().equals("") && !timeEnd.trim().equals("")) {
				Segment segment = new SegmentImpl();
				segment.setVideoId(videoId);
				segment.setTitle(shortTitle);
				segment.setStart(timeStart);
				segment.setEnd(timeEnd);
				segment.setChapter(chap);
				segment.setDescription(text);
				segment.setUserId(userId);
				try {
					// save
					Segment s = SegmentLocalServiceUtil.createSegment(segment);
					
					JSONObject jo = JSONFactoryUtil.createJSONObject();
					jo.put("chapter", s.getChapter());
					jo.put("description", s.getDescription());
					jo.put("end", s.getEnd());
					jo.put("image", s.getImage());
					jo.put("number", s.getNumber());
					jo.put("segmentId", s.getPrimaryKey());
					jo.put("seconds", s.getSeconds());
					jo.put("start", s.getStart());
					jo.put("title", s.getTitle());
					jo.put("userId", s.getUserId());
					jo.put("videoId", s.getVideoId());
					jo.put("previousSegmentId", SegmentLocalServiceUtil.getPreviusSegmentId(s.getSegmentId()));
					
					// and return response
					writeJSON(resourceRequest, resourceResponse, jo);
				} catch (SystemException e) {
					e.printStackTrace();
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
		}

		if(resourceID.equals("showSegments")){
			String vId = ParamUtil.getString(resourceRequest, "videoId");
			Long vID = new Long(vId);
			com.liferay.portal.kernel.json.JSONArray ja = JSONFactoryUtil.createJSONArray();
			//get segments for video and convert to json array
			try {
				List<Segment> sl= SegmentLocalServiceUtil.getSegmentsByVideoId(vID);
				ListIterator<Segment> sIt = sl.listIterator();
				while(sIt.hasNext()){
					Segment s = sIt.next();
					JSONObject jo = JSONFactoryUtil.createJSONObject();
					jo.put("chapter", s.getChapter());
					jo.put("description", s.getDescription());
					jo.put("end", s.getEnd());
					jo.put("image", s.getImage());
					jo.put("number", s.getNumber());
					jo.put("segmentId", s.getPrimaryKey());
					jo.put("seconds", s.getSeconds());
					jo.put("start", s.getStart());
					jo.put("title", s.getTitle());
					jo.put("userId", s.getUserId());
					jo.put("videoId", s.getVideoId());
					jo.put("previousSegmentId", SegmentLocalServiceUtil.getPreviusSegmentId(s.getSegmentId()));
					ja.put(jo);
				}
				
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			writeJSON(resourceRequest, resourceResponse, ja);
		}
		
		if(resourceID.equals("deleteSegment")){
			String sId = ParamUtil.getString(resourceRequest, "segmentId");
			Long sID = new Long(sId);
			//delete requested segment
			try {
				Segment s = SegmentLocalServiceUtil.removeSegment(sID);
				JSONObject jo = JSONFactoryUtil.createJSONObject();
				jo.put("chapter", s.getChapter());
				jo.put("description", s.getDescription());
				jo.put("end", s.getEnd());
				jo.put("image", s.getImage());
				jo.put("number", s.getNumber());
				jo.put("segmentId", s.getPrimaryKey());
				jo.put("seconds", s.getSeconds());
				jo.put("start", s.getStart());
				jo.put("title", s.getTitle());
				jo.put("userId", s.getUserId());
				jo.put("videoId", s.getVideoId());
				writeJSON(resourceRequest, resourceResponse, jo);
			} catch (SystemException e) {
				e.printStackTrace();
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void removeVideo(ActionRequest request, ActionResponse response){
		Video video = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getFullVideo(reqVideoId);
		ProzessManager pm = new ProzessManager();	
		pm.deleteVideo(video);
	}
	
	public void lockVideo(ActionRequest request, ActionResponse response){
		Video video = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getFullVideo(reqVideoId);
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
		video = VideoLocalServiceUtil.getFullVideo(reqVideoId);
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
	
}
