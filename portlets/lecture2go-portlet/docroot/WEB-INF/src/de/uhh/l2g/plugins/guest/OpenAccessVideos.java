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
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;

public class OpenAccessVideos extends MVCPortlet {
	
	public void viewOpenAccessVideo(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
	    Long videoId = ParamUtil.getLong(request, "videoId");
	    Long lectureseriesId = ParamUtil.getLong(request, "lectureseriesId");
	    Video video = new VideoImpl();
	    //lecture series object
	    Lectureseries lectureseries = new LectureseriesImpl();
	    lectureseries = LectureseriesLocalServiceUtil.getLectureseries(lectureseriesId);
	    List<Video> relatedVideos = new ArrayList<Video>();
	    Long objectId = new Long(0);
	    	video = VideoLocalServiceUtil.getFullVideo(videoId);
	    	if(video.getVideoId()>0){
	    		//video object
	    		objectId = video.getVideoId();
	    	}else{
	    		objectId = lectureseries.getLatestOpenAccessVideoId();
	    		video = VideoLocalServiceUtil.getFullVideo(objectId);
	    	}
    	//related videos by lectureseries id
    	relatedVideos = VideoLocalServiceUtil.getByLectureseriesAndOpenaccess(lectureseries.getLectureseriesId(),1);
	    
	    //chapters and segments
	    List<Segment> segments = SegmentLocalServiceUtil.getSegmentsByVideoId(objectId);

	    //institutions for video
	    List<Video_Institution> vi = new ArrayList<Video_Institution>();
	    vi = Video_InstitutionLocalServiceUtil.getByVideo(videoId);
	    
	    request.setAttribute("videoInstitutions",vi);
	    request.setAttribute("video",video);
	    request.setAttribute("relatedVideos",relatedVideos);
	    request.setAttribute("segments",segments);
	    request.setAttribute("lectureseries",lectureseries);
		response.setRenderParameter("jspPage","/guest/videoDetails.jsp");
	}
	
}