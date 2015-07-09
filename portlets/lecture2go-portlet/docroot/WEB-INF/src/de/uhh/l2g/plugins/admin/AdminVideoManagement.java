package de.uhh.l2g.plugins.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONArray;
import org.json.JSONException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.NoSuchLicenseException;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Tagcloud;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Category;
import de.uhh.l2g.plugins.model.Video_Creator;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.model.impl.CategoryImpl;
import de.uhh.l2g.plugins.model.impl.CreatorImpl;
import de.uhh.l2g.plugins.model.impl.InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.LicenseImpl;
import de.uhh.l2g.plugins.model.impl.MetadataImpl;
import de.uhh.l2g.plugins.model.impl.ProducerImpl;
import de.uhh.l2g.plugins.model.impl.SegmentImpl;
import de.uhh.l2g.plugins.model.impl.TagcloudImpl;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.model.impl.Video_CategoryImpl;
import de.uhh.l2g.plugins.model.impl.Video_CreatorImpl;
import de.uhh.l2g.plugins.model.impl.Video_InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.Video_LectureseriesImpl;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.TagcloudLocalServiceUtil;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.util.FFmpegManager;
import de.uhh.l2g.plugins.util.ProzessManager;
import de.uhh.l2g.plugins.util.Security;

public class AdminVideoManagement extends MVCPortlet {

	private final static Logger logger = Logger.getLogger(AdminVideoManagement.class.getName());
	
	public void addSegment(ActionRequest request, ActionResponse response){
		Video reqVideo = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		reqVideo = VideoLocalServiceUtil.getFullVideo(reqVideoId);

		request.setAttribute("reqVideo", reqVideo);
		String backURL = request.getParameter("backURL");
		request.setAttribute("backURL", backURL);
		response.setRenderParameter("jspPage", "/admin/segments.jsp");
	}
	
	public void viewVideo(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		// requested producer id
		Long reqPproducerId = (long)0;
		try{reqPproducerId = new Long(request.getParameterMap().get("producerId")[0]);}catch(Exception e){}
		
		// requested lecture series id
		Long reqLectureseriesId = (long)0;
		try{reqLectureseriesId = new Long(request.getParameterMap().get("lectureseriesId")[0]);}catch(Exception e){}
			
		// requested video
		Long reqVideoId = new Long(0);
		Video reqVideo = new VideoImpl(); 
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
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
				reqMetadata.setPublisher(reqProducer.getFirstName()+" "+reqProducer.getLastName());
				reqMetadata.setLanguage(reqLectureseries.getLanguage());
			}
		}catch(Exception e){}
		request.setAttribute("reqMetadata", reqMetadata);
		
		// requested lecture series list
		List<Lectureseries> reqLectureseriesList = new ArrayList<Lectureseries>();
		try{
			if(reqVideo.getVideoId()>0)reqLectureseriesList = LectureseriesLocalServiceUtil.getFilteredBySemesterFacultyProducer(1, (long) 0, (long) 0, reqVideo.getProducerId());
			else reqLectureseriesList = LectureseriesLocalServiceUtil.getFilteredBySemesterFacultyProducer(1, (long) 0, (long) 0, reqPproducerId);
		}catch(Exception e){}
		request.setAttribute("reqLectureseriesList", reqLectureseriesList);
		
		//requested license
		License reqLicense = new LicenseImpl();
		try{reqLicense = LicenseLocalServiceUtil.getByVideoId(reqVideo.getVideoId());}catch(Exception e){}
		request.setAttribute("reqLicense", reqLicense);
		
		String backURL = request.getParameter("backURL");
		request.setAttribute("backURL", backURL);

		request.setAttribute("reqVideo", reqVideo);
		response.setRenderParameter("jspPage", "/admin/editVideo.jsp");
	}
	
	public void addVideo(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		//search tags
		String tagCloudString = "";

		//first metadata
		Metadata reqMetadata = new MetadataImpl();
		reqMetadata = MetadataLocalServiceUtil.addMetadata(reqMetadata);
		request.setAttribute("reqMetadata", reqMetadata);

		//lecture series
		Long lectureseriesId = new Long(request.getParameter("lectureseriesId"));
		Lectureseries reqLectureseries = new LectureseriesImpl();
		try{
			reqLectureseries = (Lectureseries) LectureseriesLocalServiceUtil.getLectureseries(lectureseriesId); 
			Category ctgr = new CategoryImpl();
			try{ctgr = CategoryLocalServiceUtil.getCategory(reqLectureseries.getCategoryId());}catch(Exception e){}			
			tagCloudString += ctgr.getName()+" ### "+ reqLectureseries.getName() +" ### "+ reqLectureseries.getNumber()+" ### ";
			
		}catch(Exception e){}
		request.setAttribute("reqLectureseries", reqLectureseries);
		
		//producer
		Long producerId = new Long(request.getParameter("producerId"));
		ProducerImpl reqProducer = new ProducerImpl();
		reqProducer = (ProducerImpl)ProducerLocalServiceUtil.getProdUcer(producerId);
		request.setAttribute("reqProducer", reqProducer);

		//video
		Video newVideo = new VideoImpl();
		newVideo.setProducerId(producerId);
		if(lectureseriesId>0)newVideo.setLectureseriesId(lectureseriesId);
		else {
			java.util.Date date= new java.util.Date();
			newVideo.setLectureseriesId(-date.getTime());
		}
		newVideo.setHostId(reqProducer.getHostId());
		newVideo.setMetadataId(reqMetadata.getMetadataId());
		newVideo.setRootInstitutionId(reqProducer.getInstitutionId());
		newVideo.setOpenAccess(0);
		newVideo.setSecureFilename(Security.createSecureFileName()+".xx");
		//save it
		Video video = VideoLocalServiceUtil.addVideo(newVideo);
		request.setAttribute("reqVideo", newVideo);
		tagCloudString += video.getTitle()+" ### ";

		//link to lectureseries list
		Video_Lectureseries vl = new Video_LectureseriesImpl();
		vl.setLectureseriesId(lectureseriesId);
		vl.setVideoId(newVideo.getVideoId());
		vl.setOpenAccess(newVideo.getOpenAccess()); 
		Video_LectureseriesLocalServiceUtil.addVideo_Lectureseries(vl);
		
		// requested lecture series list
		List<Lectureseries> reqLectureseriesList = new ArrayList<Lectureseries>();
		try{reqLectureseriesList = LectureseriesLocalServiceUtil.getFilteredBySemesterFacultyProducer(1, (long) 0, (long) 0, producerId);}catch(Exception e){}
		request.setAttribute("reqLectureseriesList", reqLectureseriesList);
		
		//licence
		License license = new LicenseImpl();
		license.setVideoId(newVideo.getVideoId());
		LicenseLocalServiceUtil.addLicense(license);
		request.setAttribute("reqLicense", license);

		//update lg_video_institution table
		if(lectureseriesId>0){
			List<Lectureseries_Institution> li = Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lectureseriesId);
			ListIterator<Lectureseries_Institution> i = li.listIterator();
			while(i.hasNext()){
				Institution ins = InstitutionLocalServiceUtil.getInstitution(i.next().getInstitutionId());
				Video_Institution vi = new Video_InstitutionImpl();
				vi.setVideoId(video.getVideoId());
				vi.setInstitutionId(ins.getInstitutionId());
				vi.setInstitutionParentId(ins.getParentId());
				Video_InstitutionLocalServiceUtil.addVideo_Institution(vi);
				tagCloudString += ins.getName()+" ### ";
			}
		}
		
		//creators
		JSONArray creatorsArray = CreatorLocalServiceUtil.getJSONCreatorsByLectureseriesId(lectureseriesId);
		for (int i = 0; i< creatorsArray.length(); i++){
			org.json.JSONObject creator;
			try {
				creator = creatorsArray.getJSONObject(i);
				Long creatorId= creator.getLong("creatorId");
				Video_Creator vc = new Video_CreatorImpl();
				vc.setCreatorId(creatorId);
				vc.setVideoId(newVideo.getVideoId());
				Video_CreatorLocalServiceUtil.addVideo_Creator(vc);
				tagCloudString += creator.getString("firstName")+" ### "+creator.getString("lastName")+" ### "+creator.getString("fullName")+" ### ";
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		//Tag cloud
		Tagcloud tagcloud = new TagcloudImpl();
		tagcloud.setTags(tagCloudString);
		tagcloud.setObjectClassType(video.getClass().getName());
		tagcloud.setObjectId(video.getVideoId());
		TagcloudLocalServiceUtil.addTagcloud(tagcloud);
		//
		String backURL = request.getParameter("backURL");
		request.setAttribute("backURL", backURL);
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
				video.setSecureFilename(secureFileName);
				video.setContainerFormat(containerFormat);
				video.setGenerationDate(generationDate);
				video.setUploadDate(new Date());
				VideoLocalServiceUtil.updateVideo(video);
				FFmpegManager.updateFfmpegMetadata(video);
				//update thumbs
				String image="";
				String fileLocation="";
				if(video.getOpenAccess()==1){
					image = video.getPreffix()+".jpg";
					fileLocation = ProducerLocalServiceUtil.getProdUcer(video.getProducerId()).getHomeDir() + "/" + video.getFilename();
				}else{
					image = video.getSPreffix()+".jpg";
					fileLocation = ProducerLocalServiceUtil.getProdUcer(video.getProducerId()).getHomeDir() + "/" + video.getSecureFilename();
				}
				String thumbnailLocation = PropsUtil.get("lecture2go.images.system.path") + "/" + image;
				//delete old thumbs
				String thumbPreffLoc = thumbnailLocation.split(".jpg")[0];
				File f1 = new File(thumbnailLocation);
				File f2 = new File(thumbPreffLoc + "_s.jpg");
				File f3 = new File(thumbPreffLoc + "_m.jpg");
				f1.delete();
				f2.delete();
				f3.delete();
				//and and thumbs for segments
				// delete all segment images from repository location
				try{
					List<Segment> segmentList = SegmentLocalServiceUtil.getSegmentsByVideoId(video.getVideoId());
					SegmentLocalServiceUtil.deleteThumbhailsFromSegments(segmentList);
				}catch (PortalException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				} catch (NullPointerException e){
					e.printStackTrace();
				}				
				FFmpegManager.createThumbnail(fileLocation, thumbnailLocation);
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
		
		if(resourceID.equals("updateMetadata")){
	 	    String title = ParamUtil.getString(resourceRequest, "title");
			String language = ParamUtil.getString(resourceRequest, "language");
			String tags = ParamUtil.getString(resourceRequest, "tags");
			String publisher = ParamUtil.getString(resourceRequest, "publisher");
			Long lId = ParamUtil.getLong(resourceRequest, "lectureseriesId");
			Long termId = ParamUtil.getLong(resourceRequest, "termId");
			Long categoryId = ParamUtil.getLong(resourceRequest, "categoryId");
			Integer citationAllowed = ParamUtil.getInteger(resourceRequest, "citationAllowedCheckbox");
	 	    String password = ParamUtil.getString(resourceRequest, "password");

			Lectureseries oldLs = new LectureseriesImpl();
			try {
				oldLs = LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId());
			} catch (PortalException e1) {
				//e1.printStackTrace();
			} catch (SystemException e1) {
				//e1.printStackTrace();
			}
			//search tags
			String tagCloudString = "";
			Lectureseries newLect = new LectureseriesImpl();
			Category ctgr = new CategoryImpl();
			//update data base
			try {
				video.setTitle(title);
				video.setLectureseriesId(lId);
				if(lId>0)video.setLectureseriesId(lId);
				else {
					java.util.Date date= new java.util.Date();
					video.setLectureseriesId(-date.getTime());
					//update table video_lectureseries
					Video_LectureseriesLocalServiceUtil.removeByVideoId(video.getVideoId());
				}
				video.setTags(tags);
				if(lId>0){
					newLect = LectureseriesLocalServiceUtil.getLectureseries(lId);
					//
					termId = newLect.getTermId();
					categoryId = newLect.getCategoryId();
					//update lg_video_institution table
					Video_InstitutionLocalServiceUtil.removeByVideoId(video.getVideoId());
					List<Lectureseries_Institution> li = Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lId);
					ListIterator<Lectureseries_Institution> l_i = li.listIterator();
					//institutions for video
					while(l_i.hasNext()){
						Institution in = new InstitutionImpl();
						Lectureseries_Institution lectinst = l_i.next();
						in = InstitutionLocalServiceUtil.getInstitution(lectinst.getInstitutionId());
						Video_Institution vi = new Video_InstitutionImpl();
						vi.setVideoId(video.getVideoId());
						vi.setInstitutionId(lectinst.getInstitutionId());
						vi.setInstitutionParentId(in.getParentId());
						Video_InstitutionLocalServiceUtil.addVideo_Institution(vi);
					}
					//update lg_video_lectureseries 
					Video_Lectureseries vl = new Video_LectureseriesImpl();
					vl.setVideoId(video.getVideoId());
					vl.setLectureseriesId(lId);
					vl.setOpenAccess(video.getOpenAccess());
					Video_LectureseriesLocalServiceUtil.removeByVideoId(video.getVideoId());//delete old entries
					Video_LectureseriesLocalServiceUtil.addVideo_Lectureseries(vl);//add new
					LectureseriesLocalServiceUtil.updateLectureseries(newLect);
					//update lectureseries
					LectureseriesLocalServiceUtil.updateOpenAccess(video, newLect);
					
					//add lecture series parameter to tag cloud
					tagCloudString += newLect.getName() +" ### "+ newLect.getNumber()+" ### ";
				}
				//add category and term to tag cloud
				//category
				try{ctgr = CategoryLocalServiceUtil.getCategory(categoryId);}catch(Exception e){}			
				tagCloudString += ctgr.getName()+" ### ";
				//term
				try{
					Term t = TermLocalServiceUtil.getTerm(termId);
					tagCloudString += t.getPrefix()+ " ### "+t.getYear()+" ### "+t.getPrefix()+" "+t.getYear()+" ### ";
				}catch(Exception e){}
				video.setTermId(termId);
				//
				//and update categories in DB for video
				Video_CategoryLocalServiceUtil.removeByVideo(videoId);
				Video_Category vc = new Video_CategoryImpl();
				vc.setVideoId(videoId);
				vc.setCategoryId(categoryId);
				if(categoryId>0)Video_CategoryLocalServiceUtil.addVideo_Category(vc);
				//
				//title to tag cloud
				tagCloudString += video.getTitle()+" ### ";

				//add creators to tag cloud
				JSONArray creatorsArray = CreatorLocalServiceUtil.getJSONCreatorsByVideoId(videoId);
				for (int i = 0; i< creatorsArray.length(); i++){
					org.json.JSONObject creator;
					try {
						creator = creatorsArray.getJSONObject(i);
						tagCloudString += creator.getString("fullName")+" ### ";
					} catch (JSONException e) {
						//e.printStackTrace();
					}
				}
				//update tag cloud for this video
				Tagcloud tc = new TagcloudImpl();
				try{
					tc = TagcloudLocalServiceUtil.getByObjectIdAndObjectClassType(video.getVideoId(), video.getClass().getName());
					tc.setTags(tagCloudString);
				}catch(de.uhh.l2g.plugins.NoSuchTagcloudException e){
					tc.setObjectId(video.getVideoId());
					tc.setObjectClassType(video.getClass().getName());
					tc.setTags(tagCloudString);
				}
				TagcloudLocalServiceUtil.updateTagcloud(tc);
				//set citation 
				video.setCitation2go(citationAllowed);
				//password
				video.setPassword(password);
				// update video
				VideoLocalServiceUtil.updateVideo(video);
				// refresh open access for old lecture if lid > 0
				if(oldLs.getLectureseriesId()>0) LectureseriesLocalServiceUtil.updateOpenAccess(video, oldLs);
				
			} catch (NumberFormatException e) {
				//System.out.println(e);
			} catch (SystemException e) {
				//System.out.println(e);
			} catch (PortalException e) {
				//e.printStackTrace();
			}
			//metadata
			try {
				metadata.setTitle(title);
				metadata.setPublisher(publisher);
				metadata.setLanguage(language);
				MetadataLocalServiceUtil.updateMetadata(metadata);
			} catch (NumberFormatException e) {
//				System.out.println(e);
			} catch (SystemException e) {
//				System.out.println(e);
			}
			
			JSONObject json = JSONFactoryUtil.createJSONObject();
			writeJSON(resourceRequest, resourceResponse, json);
		}

		if(resourceID.equals("videoUpdateGenerationDate")){
			String generationDate = ParamUtil.getString(resourceRequest, "generationDate");
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			video.setGenerationDate(generationDate);
			try {
				VideoLocalServiceUtil.updateVideo(video);
				jo.put("generationDate", generationDate);
				writeJSON(resourceRequest, resourceResponse, jo);
			} catch (SystemException e) {
//				e.printStackTrace();
			}
		}
		
		if(resourceID.equals("getGenerationDate")){
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			jo.put("generationDate", video.getGenerationDate());
			writeJSON(resourceRequest, resourceResponse, jo);
		}
		
		if(resourceID.equals("videoFileNameExists")){
			String filename = ParamUtil.getString(resourceRequest, "fileName");
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			try {
				List<Video> vl = VideoLocalServiceUtil.getByFilename(filename); 
				if(vl.size()>0)jo.put("exist", "1");
				else jo.put("exist", "0");
			} catch (SystemException e) {
//				e.printStackTrace();
				jo.put("exist", "0");
			}
			writeJSON(resourceRequest, resourceResponse, jo);
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
//				e.printStackTrace();
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
//				e.printStackTrace();
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
//				e.printStackTrace();
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
			//update chapter file (vtt)
			updateVttChapterFile(video);
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
			//update chapter file (vtt)
			updateVttChapterFile(video);
		}

		if(resourceID.equals("isFirstUpload")){
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			if(video.getFilename().isEmpty())jo.put("firstUpload", "1");
			else jo.put("firstUpload", "0");
			writeJSON(resourceRequest, resourceResponse, jo);
		}
		
		if(resourceID.equals("defaultContainer")){
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			jo.put("containerFormat", video.getContainerFormat());
			writeJSON(resourceRequest, resourceResponse, jo);
		}
		
		if(resourceID.equals("deleteFile")){
			String fileName = ParamUtil.getString(resourceRequest, "fileName");
			String mainContainerFormat = "";

			//delete file
			String fPath="";
			try {
				fPath = ProducerLocalServiceUtil.getProdUcer(video.getProducerId()).getHomeDir()+"/";
				mainContainerFormat = VideoLocalServiceUtil.getVideo(videoId).getContainerFormat();
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			JSONArray jarr = new JSONArray();
			//delete all
			
			if(fileName.endsWith(mainContainerFormat)){
				//delete all file on disc 
				//but not from DB
				JSONArray jVids = VideoLocalServiceUtil.getJSONVideo(video.getVideoId());
				for (int i = 0; i < jVids.length(); i++) {
					try {
						org.json.JSONObject o = jVids.getJSONObject(i);
						String fs = (String) o.get("name");
						File f = new File(fPath+fs);
						if(f.delete()){
							o.put("fileId", fs.replace(".", ""));
						}else{
							o.put("fileId", "");
						}
						jarr.put(o);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				ProzessManager pm = new ProzessManager();
				pm.deleteFilesImagesFromVideo(video);
			}else{
				org.json.JSONObject o = new org.json.JSONObject();
					try {
						File f = new File(fPath+fileName);
						if(f.delete()){
							o.put("fileId", fileName.replace(".", ""));
						}else{
							o.put("fileId", "");
						}
						jarr.put(o);
					} catch (JSONException e) {
						e.printStackTrace();
					}
			}
			writeJSON(resourceRequest, resourceResponse, jarr);
		}
		
		if(resourceID.equals("getJSONCreator")){
			String creatorId = ParamUtil.getString(resourceRequest, "creatorId");
			Long cId = new Long(0);
			try{
				cId = new Long(creatorId);
			}catch(Exception e){
				e.printStackTrace();
			}
			JSONArray json = new JSONArray();
			try {
				json = CreatorLocalServiceUtil.getJSONCreator(cId);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			writeJSON(resourceRequest, resourceResponse, json);			
		}
		
		if(resourceID.equals("updateCreators")){
			String creators = ParamUtil.getString(resourceRequest, "creator");
			try {
				JSONArray creatorsArray = new JSONArray(creators);
				//remove creators for video
				try {
					Video_CreatorLocalServiceUtil.deleteByVideoId(videoId);			
					//and update with new creators from list
					for (int i = 0; i< creatorsArray.length(); i++){
						org.json.JSONObject creator =  creatorsArray.getJSONObject(i);
						Long creatorId= creator.getLong("creatorId");
						String firstName = creator.getString("firstName");
						String lastName = creator.getString("lastName");
						String middleName = creator.getString("middleName");
						String jobTitle = creator.getString("jobTitle");
						String gender = creator.getString("gender");
						String fullName = creator.getString("fullName");
						
						Video_Creator vc = new Video_CreatorImpl();
						Long newCreatorId = new Long(0);
						//if creator exists in DB, just add to video
						if(creatorId>new Long(0)){
							newCreatorId = creatorId;
						}else{ 
							//if new creator doesn't exits in the creators DB (check by full name),
							//create a new one in DB and add to video
							List<Creator> cL = CreatorLocalServiceUtil.getByFullName(fullName);
							if(cL.size()==0){
								Creator c = new CreatorImpl();
								c.setFirstName(firstName);
								c.setLastName(lastName);
								c.setMiddleName(middleName);
								c.setJobTitle(jobTitle);
								c.setGender(gender);
								c.setFullName(fullName);
								newCreatorId = CreatorLocalServiceUtil.addCreator(c).getCreatorId();
							}else{
								newCreatorId = cL.listIterator().next().getCreatorId();
							}
						}
						vc.setCreatorId(newCreatorId);
						vc.setVideoId(videoId);
						List<Video_Creator> vcl = new ArrayList<Video_Creator>();
						vcl = Video_CreatorLocalServiceUtil.getByVideoCreator(videoId, newCreatorId);
						if(vcl.size()==0)Video_CreatorLocalServiceUtil.addVideo_Creator(vc);
					}
				} catch (SystemException e) {
					e.printStackTrace();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			writeJSON(resourceRequest, resourceResponse, CreatorLocalServiceUtil.getJSONCreatorsByVideoId(videoId));			
		}
		
		if(resourceID.equals("updateSubInstitutions")){
			String subInstitutions = ParamUtil.getString(resourceRequest, "subInstitution");
			try {
				JSONArray institutionsArray = new JSONArray(subInstitutions);
				//remove sub-institutions for video
				try {
					Video_InstitutionLocalServiceUtil.removeByVideoId(videoId);
					//and update with new institutions from list
					for (int i = 0; i< institutionsArray.length(); i++){
						org.json.JSONObject institution =  institutionsArray.getJSONObject(i);
						Long institutionId= institution.getLong("institutionId");
						Institution in = new InstitutionImpl();
						try {
							in = InstitutionLocalServiceUtil.getInstitution(institutionId);
						} catch (PortalException e) {
							e.printStackTrace();
						}
						List<Video_Institution> vil = new ArrayList<Video_Institution>();
						vil = Video_InstitutionLocalServiceUtil.getByVideoAndInstitution(videoId, institutionId);
						
						Video_Institution vi = new Video_InstitutionImpl();
						vi.setInstitutionId(in.getInstitutionId());
						vi.setVideoId(videoId);
						vi.setInstitutionParentId(in.getParentId());
						if(vil.size()==0)Video_InstitutionLocalServiceUtil.addVideo_Institution(vi);
					}
				} catch (SystemException e) {
					e.printStackTrace();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			writeJSON(resourceRequest, resourceResponse, CreatorLocalServiceUtil.getJSONCreatorsByVideoId(videoId));			
		}
		
		if(resourceID.equals("updateupdateOpenAccessForLectureseries")){
			Lectureseries lect = new LectureseriesImpl();
			try {
				lect = LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId());
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			try {
				LectureseriesLocalServiceUtil.updateOpenAccess(video, lect);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			writeJSON(resourceRequest, resourceResponse, CreatorLocalServiceUtil.getJSONCreatorsByVideoId(videoId));			
		}
		
	}
	
	public void removeVideo(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		Video video = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getFullVideo(reqVideoId);
		ProzessManager pm = new ProzessManager();	
		pm.deleteVideo(video);
		String backURL = request.getParameter("backURL");
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lockVideo(ActionRequest request, ActionResponse response){
		Video video = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getFullVideo(reqVideoId);
		ProzessManager pm = new ProzessManager();	
		//deactivate open access
		//and refresh lecture series with this video
		try {
			pm.deactivateOpenaccess(video);
		} catch (PortalException e) {
		} catch (SystemException e) {
		}
		String backURL = request.getParameter("backURL");
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void unlockVideo(ActionRequest request, ActionResponse response){
		Video video = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getFullVideo(reqVideoId);
		//activate open access
		//and refresh lecture series with this video
		ProzessManager pm = new ProzessManager();	
		try {
			pm.activateOpenaccess(video);
		} catch (SystemException e) {
		} catch (PortalException e) {
		}
		String backURL = request.getParameter("backURL");
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void activateDownload(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		Video video = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getVideo(reqVideoId);
		ProzessManager pm = new ProzessManager();
		pm.activateDownload(video);
		String backURL = request.getParameter("backURL");
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deactivateDownload(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		Video video = new VideoImpl();
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getVideo(reqVideoId);
		ProzessManager pm = new ProzessManager();
		pm.deactivateDownload(video);
		String backURL = request.getParameter("backURL");
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateVttChapterFile(Video video){
		File vttDirectory = new File(PropsUtil.get("lecture2go.chapters.system.path"));
		String dateiName = vttDirectory + "/" + video.getVideoId()+".vtt";
		//get all segments
		List<Segment> sL = new ArrayList<Segment>();
		try {
			sL = SegmentLocalServiceUtil.getSegmentsByVideoId(video.getVideoId());
		} 
		catch (PortalException e) {} 
		catch (SystemException e) {}
		//
		ListIterator<Segment> sLi = sL.listIterator();
		String text="WEBVTT \n\n";
		int count =1;
		while(sLi.hasNext()){
			Segment seg = sLi.next();
			text +="Chapter "+count+" \n";
			text +=seg.getStart()+" --> "+seg.getEnd()+" \n";
			if(seg.getChapter()==1 && video.getContainerFormat().equals("mp4"))text +="<img src=\""+seg.getImage()+"\"/><br/>";
			text +=seg.getTitle()+"<br/>"+seg.getDescription()+" \n\n";
			count++;
		}
		FileOutputStream s;
		try {
			s = new FileOutputStream(dateiName);
			for (int i = 0; i < text.length(); i++) {
				s.write((byte) text.charAt(i));
			}
			s.close();
		} 
		catch (FileNotFoundException e) {} 
		catch (IOException e) {}
	}
	
}
