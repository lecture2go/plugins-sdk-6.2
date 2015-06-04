package de.uhh.l2g.plugins.guest;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.LicenseImpl;
import de.uhh.l2g.plugins.model.impl.MetadataImpl;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;

public class OpenAccessVideos extends MVCPortlet {

	public void addFilter(ActionRequest request, ActionResponse response){
		String jspPage = request.getParameter("jspPage");
		Long institutionId = new Long(request.getParameter("institutionId"));
		Long parentInstitutionId = new Long(request.getParameter("parentInstitutionId"));
		Long termId = new Long(request.getParameter("termId"));
		Long categoryId = new Long(request.getParameter("categoryId"));
		Long creatorId = new Long(request.getParameter("creatorId"));

		response.setRenderParameter("institutionId", institutionId+"");
		response.setRenderParameter("parentInstitutionId", parentInstitutionId+"");
		response.setRenderParameter("termId", termId+"");
		response.setRenderParameter("categoryId", categoryId+"");
		response.setRenderParameter("creatorId", creatorId+"");
		response.setRenderParameter("jspPage", jspPage);
	}

	public void viewOpenAccessVideo(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
	    Long objectId = ParamUtil.getLong(request, "objectId");
	    String objectType = ParamUtil.getString(request, "objectType");

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
    	relatedVideos = VideoLocalServiceUtil.getByLectureseriesAndOpenaccess(lectureseries.getLectureseriesId(),1);
	    
	    //chapters and segments
	    List<Segment> segments = SegmentLocalServiceUtil.getSegmentsByVideoId(objectId);
	    
	    //lectureseries for video
	    List<Video_Lectureseries> vl = new ArrayList<Video_Lectureseries>();
	    vl = Video_LectureseriesLocalServiceUtil.getByVideo(video.getVideoId());
	    
	    //institutions for video
	    List<Video_Institution> vi = new ArrayList<Video_Institution>();
	    vi = Video_InstitutionLocalServiceUtil.getByVideo(video.getVideoId());
	    
	    //metadata for video
	    Metadata m = new MetadataImpl();
	    m = MetadataLocalServiceUtil.getMetadata(video.getMetadataId());
	    
	    //license for video
	    
	    License l = new LicenseImpl();
	    l = LicenseLocalServiceUtil.getByVideoId(video.getVideoId());
	    
	    //update video hits
	    Long hits = video.getHits();
	    hits = hits+1;
	    video.setHits(hits);
	    VideoLocalServiceUtil.updateVideo(video);
	    
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
		response.setRenderParameter("jspPage","/guest/videoDetails.jsp");
	}
	
}
