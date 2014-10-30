package de.uhh.l2g.plugins.admin;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Video;
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

	private final static Logger logger = Logger.getLogger(AdminVideoManagement.class.getName());
	
	@SuppressWarnings("unused")
	public void viewVideo(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		//permissions
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		//user 
		String uId = request.getRemoteUser();
		Long userId = new Long(uId);
		User remoteUser = UserLocalServiceUtil.getUserById(userId);
		
		// requested producer id
		Long reqPproducerId = (long)0;
		try{reqPproducerId = new Long(request.getParameterMap().get("producerId")[0]);}catch(Exception e){}
		
		// requested lecture series id
		Long reqLectureseriesId = (long)0;
		try{reqLectureseriesId = new Long(request.getParameterMap().get("lectureseriesId")[0]);}catch(Exception e){}
				
		// requested video
		long reqVideoId = 0;
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
		//build new video object
	}
	
	
	public void uploadCase(ActionRequest actionRequest,ActionResponse actionRresponse) throws PortletException, IOException {
		String folder = getInitParameter("uploadFolder");
		String realPath = "";
		realPath = getPortletContext().getRealPath("/");
		logger.info("RealPath" + realPath + " UploadFolder :" + folder);
		
		try {
			logger.info("Siamo nel try");
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			System.out.println("Size: "+uploadRequest.getSize("fileName"));
		 
			if (uploadRequest.getSize("fileName")==0) {
				SessionErrors.add(actionRequest, "error");
			}
		
			String sourceFileName = uploadRequest.getFileName("fileName");
			File file = uploadRequest.getFile("fileName");

			logger.info("Nome file:" + uploadRequest.getFileName("fileName"));
			File newFile = null;
			newFile = new File(folder + sourceFileName);
			logger.info("New file name: " + newFile.getName());
			logger.info("New file path: " + newFile.getPath());

			InputStream in = new BufferedInputStream(uploadRequest.getFileAsStream("fileName"));
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(newFile);

			byte[] bytes_ = FileUtil.getBytes(in);
			int i = fis.read(bytes_);

			while (i != -1) {
				fos.write(bytes_, 0, i);
				i = fis.read(bytes_);
			}
			
			fis.close();
			fos.close();
			Float size = (float) newFile.length();
			System.out.println("file size bytes:" + size);
			System.out.println("file size Mb:" + size / 1048576);

			logger.info("File created: " + newFile.getName());
			SessionMessages.add(actionRequest, "success");

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			e.printStackTrace();
			SessionMessages.add(actionRequest, "error");
		} catch (NullPointerException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
			SessionMessages.add(actionRequest, "error");
		} catch (IOException e1) {
			System.out.println("Error Reading The File.");
			SessionMessages.add(actionRequest, "error");
			e1.printStackTrace();
		}
	}
	
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws PortletException, IOException {

			try {
			UploadPortletRequest uploadrequest = PortalUtil
			.getUploadPortletRequest(resourceRequest);
			InputStream inputStream = uploadrequest
			.getFileAsStream("fileToUpload");
			if(Validator.isNotNull(inputStream)){
			File file = FileUtil.createTempFile(inputStream);
			String uploadString = getFileAsString(file);

			if (Validator.isNotNull(uploadString)) {

			resourceResponse.getWriter().write( "validated_successfully");


			logger.info("VALIDATED_SUCCESSFULLY");
			}else{
			resourceResponse.getWriter().write( "failed");

			logger.info("VALIDATION_FAILED");
			}
			}
			} catch (Exception e) {

			logger.info( "Error in adding modem");
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

	public void editVideo(ActionRequest request, ActionResponse response) throws NumberFormatException, PortalException, SystemException{
		Long videoId = new Long(request.getParameter("videoId"));
		String lic = request.getParameter("license");

		Video reqVideo = VideoLocalServiceUtil.getVideo(videoId);

		Metadata metadata = new MetadataImpl();
		
		Lectureseries reqLectureseries = new LectureseriesImpl();
		try{reqLectureseries = (Lectureseries) LectureseriesLocalServiceUtil.getFilteredBySemesterFacultyProducer(1, "", new Long(0), reqVideo.getProducerId());}catch(Exception e){}
		request.setAttribute("reqLectureseries", reqLectureseries);
		
		ProducerImpl producer = new ProducerImpl();
		LicenseImpl license = new LicenseImpl();
		int citation2go = 0;
		
		citation2go = reqVideo.getCitation2go();
		request.setAttribute("citation2go", citation2go);

		producer = (ProducerImpl)ProducerLocalServiceUtil.getProdUcer(reqVideo.getProducerId());
		request.setAttribute("producer", producer);

		license = (LicenseImpl)LicenseLocalServiceUtil.getByVideoId(reqVideo.getVideoId());
		request.setAttribute("license", license);
		
		metadata = (MetadataImpl)MetadataLocalServiceUtil.getMetadata(reqVideo.getMetadataId());
		
		//edit
		reqVideo.setLectureseriesId(new Long(request.getParameter("lectureseriesId")));
		metadata.setLanguage(request.getParameter("language"));
		reqVideo.setTitle(request.getParameter("title"));
		reqVideo.setTags(request.getParameter("tags"));
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
		VideoLocalServiceUtil.updateVideo(reqVideo);
		MetadataLocalServiceUtil.updateMetadata(metadata);
		LicenseLocalServiceUtil.updateLicense(license);
	}

}