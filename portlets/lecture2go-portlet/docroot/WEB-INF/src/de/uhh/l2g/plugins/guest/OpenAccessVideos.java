package de.uhh.l2g.plugins.guest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

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
import de.uhh.l2g.plugins.NoSuchVideoException;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
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

//test comment 2

public class OpenAccessVideos extends MVCPortlet {

	public void addFilter(ActionRequest request, ActionResponse response){
		String jspPage = request.getParameter("jspPage");
		Long institutionId = new Long(request.getParameter("institutionId"));
		Long parentInstitutionId = new Long(request.getParameter("parentInstitutionId"));
		Long termId = new Long(request.getParameter("termId"));
		Long categoryId = new Long(request.getParameter("categoryId"));
		Long creatorId = new Long(request.getParameter("creatorId"));
		String searchQuery = "";
		if (request.getParameter("searchQuery") != null) {
			searchQuery = request.getParameter("searchQuery");
		} 
		
		response.setRenderParameter("institutionId", institutionId+"");
		response.setRenderParameter("parentInstitutionId", parentInstitutionId+"");
		response.setRenderParameter("termId", termId+"");
		response.setRenderParameter("categoryId", categoryId+"");
		response.setRenderParameter("creatorId", creatorId+"");
		response.setRenderParameter("searchQuery", searchQuery);
		response.setRenderParameter("jspPage", jspPage);
	}
	
	public void addSearch(ActionRequest request, ActionResponse response) {
		String jspPage = request.getParameter("jspPage");
		String searchQuery = request.getParameter("searchQuery");
		
		response.setRenderParameter("searchQuery", searchQuery);
		response.setRenderParameter("jspPage", jspPage);
	}

	public void viewOpenAccessVideo(ActionRequest request, ActionResponse response) {
		String objectType = ParamUtil.getString(request, "objectType");
		String password = ParamUtil.getString(request, "password");
		
		Long objectId = new Long(0);
	   	String oid = request.getParameter("objectId");
	    try{
	    	objectId = new Long(oid);
	    }catch(NumberFormatException e){
		    if(objectType.equals("v")){ //only for video objects
	    		try {
					objectId = VideoLocalServiceUtil.getBySecureUrl(oid).getVideoId();				
				} catch (NoSuchVideoException e1) {
				} catch (SystemException e1) {}
	    	 }
	    }

	    Long timeStart = new Long(0);
	    Long timeEnd = new Long(0);
	    
	    try{
	    	timeStart = new Long(ParamUtil.getString(request, "timeStart"));
	    	timeEnd = new Long(ParamUtil.getString(request, "timeEnd"));
	    }catch(Exception e){}
	   
	    
	    Video video = new VideoImpl();
	    //lecture series object
	    Lectureseries lectureseries = new LectureseriesImpl();
	    
	    //Lecture series
	    if(objectType.equals("l")){
	    	try{
	    		lectureseries = LectureseriesLocalServiceUtil.getLectureseries(objectId);
	    		video = VideoLocalServiceUtil.getFullVideo(lectureseries.getLatestOpenAccessVideoId());
	    	}catch(Exception e){}
	    }else if(objectType.equals("v")){
	    	video = VideoLocalServiceUtil.getFullVideo(objectId);
	    	try{lectureseries = LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId());}catch(Exception e){}
	    }
	    
	    List<Video> relatedVideos = new ArrayList<Video>();
	    //related videos by lectureseries id
    	try {
    		int os = 0;
    		if(video.getOpenAccess()==1)os=1;
			relatedVideos = VideoLocalServiceUtil.getByLectureseriesAndOpenaccess(lectureseries.getLectureseriesId(),os);
		} catch (SystemException e) {}
	    
	    //chapters and segments
	    List<Segment> segments= new ArrayList<Segment>();
		try {
			segments = SegmentLocalServiceUtil.getSegmentsByVideoId(objectId);
		} catch (PortalException e) {
		} catch (SystemException e) {}
	    
	    //lectureseries for video
	    List<Video_Lectureseries> vl = new ArrayList<Video_Lectureseries>();
	    try {
			vl = Video_LectureseriesLocalServiceUtil.getByVideo(video.getVideoId());
		} catch (SystemException e) {}
	    
	    //institutions for video
	    List<Video_Institution> vi = new ArrayList<Video_Institution>();
	    vi = Video_InstitutionLocalServiceUtil.getByVideo(video.getVideoId());
	    
	    //metadata for video
	    Metadata m = new MetadataImpl();
	    try {
			m = MetadataLocalServiceUtil.getMetadata(video.getMetadataId());
		} catch (PortalException e) {
		} catch (SystemException e) {}
	    
	    //license for video
	    
	    License l = new LicenseImpl();
	    try {
			l = LicenseLocalServiceUtil.getByVideoId(video.getVideoId());
		} catch (NoSuchLicenseException e) {
		} catch (SystemException e) {}
	    
	    //update video hits
	    Long hits = video.getHits();
	    hits = hits+1;
	    video.setHits(hits);
	    try {
			VideoLocalServiceUtil.updateVideo(video);
		} catch (SystemException e) {}
	    
	    //check password access
	    if(video.getVideoId()>0){
	    	if(video.getOpenAccess()==1){
	    		video.setAccessPermitted(1);
	    	}else{
	    		if(video.getPassword().length()>0 || lectureseries.getPassword().length()>0){
	    			String pwd ="";
	    			if(lectureseries.getPassword().trim().length()>0)pwd=lectureseries.getPassword();
	    			if(video.getPassword().trim().length()>0)pwd=video.getPassword();
	    			//
	    			if(password.equals(pwd))video.setAccessPermitted(1);
	    			else video.setAccessPermitted(0);
	    		}
	    	}
	    }
	    
	    request.setAttribute("videoLicense",l);
	    request.setAttribute("videoMetadata",m);
	    request.setAttribute("videoInstitutions",vi);
	    request.setAttribute("videoLectureseries",vl);
	    request.setAttribute("video",video);
	    request.setAttribute("relatedVideos",relatedVideos);
	    request.setAttribute("segments",segments);
	    request.setAttribute("lectureseries",lectureseries);
	    request.setAttribute("timeStart",timeStart);
	    request.setAttribute("timeEnd",timeEnd);
	    request.setAttribute("objectType",objectType);
	    request.setAttribute("objectId",oid);
	    
		response.setRenderParameter("jspPage","/guest/videoDetails.jsp");
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
		
	}
	
}