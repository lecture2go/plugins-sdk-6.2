package de.uhh.l2g.plugins.admin;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.impl.HostImpl;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.LicenseImpl;
import de.uhh.l2g.plugins.model.impl.MetadataImpl;
import de.uhh.l2g.plugins.model.impl.ProducerImpl;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;

public class AdminVideoManagement extends MVCPortlet {
	@SuppressWarnings("unused")
	public void viewVideo(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		//permissions
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		//user 
		String uId = request.getRemoteUser();
		Long userId = new Long(uId);
		User remoteUser = UserLocalServiceUtil.getUserById(userId);

		// requested video
		long reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);
		Video reqVideo = VideoLocalServiceUtil.getVideo(reqVideoId);
		request.setAttribute("reqVideo", reqVideo);

		response.setRenderParameter("jspPage", "/admin/editVideo.jsp");

		//facilities for coordinator or administrator
		//l2go administrator is logged in
		boolean permissionAdmin = permissionChecker.hasPermission(remoteUser.getGroupId(), User.class.getName(), remoteUser.getPrimaryKey(), "ADD_L2GOADMIN");
		//l2go coordinator is logged in
		boolean permissionCoordinator = permissionChecker.hasPermission(remoteUser.getGroupId(), User.class.getName(), remoteUser.getPrimaryKey(), "ADD_L2GOPRODUCER");
	}
	
	public void addVideo(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		//build new video object
		Video video = new VideoImpl();
		Metadata metadata = new MetadataImpl();
		License license = new LicenseImpl();
		String lic = request.getParameter("license");
		Long producerId = new Long(request.getParameter("producerId"));
		Long lectureseriesId = new Long(request.getParameter("lectureseriesId"));
		Host host = new HostImpl();
		
		//video
		video.setLectureseriesId(new Long(request.getParameter("lectureseriesId")));
		video.setTitle(request.getParameter("title"));
		video.setTags(request.getParameter("tags"));
		
		//metadata
		metadata.setLanguage(request.getParameter("language"));
		metadata.setCreator(request.getParameter("creator"));
		metadata.setRightsHolder(request.getParameter("rightsHolder"));
		metadata.setPublisher(request.getParameter("publisher"));
		metadata.setDescription(request.getParameter("longDesc"));
		
		//lecture series
		
		//license
		if(lic.equals("uhhl2go")) license.setL2go(1);
		else license.setCcbyncsa(1);
		
		//producer
		
		//facility
		
		//save all objects with relationships
		
	}
	
	public void editVideo(ActionRequest request, ActionResponse response) throws NumberFormatException, PortalException, SystemException{
		Long videoId = new Long(request.getParameter("videoId"));
		String lic = request.getParameter("license");

		Video video = VideoLocalServiceUtil.getVideo(videoId);

		Metadata metadata = new MetadataImpl();
		
		Lectureseries lectureseries = new LectureseriesImpl();
		try{lectureseries = (Lectureseries) LectureseriesLocalServiceUtil.getFilteredBySemesterFacultyProducer(1, "", new Long(0), video.getProducerId());}catch(Exception e){}
		request.setAttribute("lectureseries", lectureseries);
		
		ProducerImpl producer = new ProducerImpl();
		LicenseImpl license = new LicenseImpl();
		int citation2go = 0;
		
		citation2go = video.getCitation2go();
		request.setAttribute("citation2go", citation2go);

		producer = (ProducerImpl)ProducerLocalServiceUtil.getProdUcer(video.getProducerId());
		request.setAttribute("producer", producer);

		license = (LicenseImpl)LicenseLocalServiceUtil.getByVideoId(video.getVideoId());
		request.setAttribute("license", license);
		
		metadata = (MetadataImpl)MetadataLocalServiceUtil.getMetadata(video.getMetadataId());
		
		//edit
		video.setLectureseriesId(new Long(request.getParameter("lectureseriesId")));
		metadata.setLanguage(request.getParameter("language"));
		video.setTitle(request.getParameter("title"));
		video.setTags(request.getParameter("tags"));
		metadata.setCreator(request.getParameter("creator"));
		metadata.setRightsHolder(request.getParameter("rightsHolder"));
		metadata.setPublisher(request.getParameter("publisher"));
		if(lic.equals("uhhl2go")){
			license.setL2go(1);
			license.setCcbyncsa(0);
		}
		if(lic.equals("ccbyncsa")){
			license.setL2go(0);
			license.setCcbyncsa(1);
		}
		metadata.setDescription(request.getParameter("longDesc"));
		//update in data base
		VideoLocalServiceUtil.updateVideo(video);
		MetadataLocalServiceUtil.updateMetadata(metadata);
		LicenseLocalServiceUtil.updateLicense(license);
	}

}