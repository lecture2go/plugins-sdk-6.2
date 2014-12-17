package de.uhh.l2g.plugins.admin;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.Producer_LectureseriesImpl;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.Producer_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.persistence.LectureseriesFinderUtil;
import de.uhh.l2g.plugins.util.Htaccess;

public class AdminLectureSeriesManagement extends MVCPortlet {
	
	public void viewLectureseries(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		//permissions
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		//user 
		String uId = request.getRemoteUser();
		Long userId = new Long(uId);
		User remoteUser = UserLocalServiceUtil.getUserById(userId);

		// requested lectureseries
		long reqLectureseriesId = new Long(request.getParameterMap().get("lectureseriesId")[0]);
		Lectureseries reqLectureseries = LectureseriesLocalServiceUtil.getLectureseries(reqLectureseriesId);
		request.setAttribute("reqLectureseries", reqLectureseries);

		response.setRenderParameter("jspPage", "/admin/editLectureseries.jsp");

		//institutions for coordinator or administrator
		//l2go administrator is logged in
		boolean permissionAdmin = permissionChecker.hasPermission(remoteUser.getGroupId(), User.class.getName(), remoteUser.getPrimaryKey(), "ADD_L2GOADMIN");
		//l2go coordinator is logged in
		boolean permissionCoordinator = permissionChecker.hasPermission(remoteUser.getGroupId(), User.class.getName(), remoteUser.getPrimaryKey(), "ADD_L2GOPRODUCER");

		Map<String,String> institutions = new LinkedHashMap<String, String>();
		List<Producer> producers = new ArrayList<Producer>();
		
		if(permissionAdmin){
			institutions = InstitutionLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			producers = ProducerLocalServiceUtil.getAllProducers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			permissionCoordinator = false;
		}
		if(permissionCoordinator){
			institutions = InstitutionLocalServiceUtil.getByParent(CoordinatorLocalServiceUtil.getCoordinator(userId).getInstitutionId());
			producers = ProducerLocalServiceUtil.getProducersByInstitutionId(CoordinatorLocalServiceUtil.getCoordinator(userId).getInstitutionId());
		}
		request.setAttribute("institutions", institutions);
		request.setAttribute("producers", producers);
	}
	
	public void removeLectureseries(ActionRequest request, ActionResponse response) {
		Long lId = new Long(request.getParameter("lectureseriesId"));
		//remove lecture series
		try {
			LectureseriesLocalServiceUtil.deleteLectureseries(lId);
			//dependencies
			Lectureseries_InstitutionLocalServiceUtil.removeByLectureseriesId(lId);//institution
			Producer_LectureseriesLocalServiceUtil.removeByLectureseriesId(lId);//producer
			VideoLocalServiceUtil.unlinkLectureseriesFromVideos(lId);//video
			Video_LectureseriesLocalServiceUtil.removeByLectureseriesId(lId);//video links to lecture series
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		//refresh htaccess authentication files 
		Htaccess.writePW(LectureseriesLocalServiceUtil.getAllLectureseriesWhithPassword());
	}

	public void editLectureseries(ActionRequest request, ActionResponse response) throws NumberFormatException, PortalException, SystemException{
		Long lId = new Long(request.getParameter("lectureseriesId"));
		String[] producers = request.getParameterValues("producers");
		String[] institutions = request.getParameterValues("institutions");
		String s = request.getParameter("longDesc");
		
		//update object
		Lectureseries lectureseries = LectureseriesLocalServiceUtil.getLectureseries(lId);
		lectureseries.setApproved(1);
		lectureseries.setNumber(request.getParameter("number"));
		lectureseries.setEventType(request.getParameter("eventType"));
		lectureseries.setEventCategory(request.getParameter("eventCategory"));
		lectureseries.setName(request.getParameter("name"));
		lectureseries.setShortDesc(request.getParameter("shortDesc"));
		lectureseries.setSemesterName(request.getParameter("semesterName"));
		lectureseries.setLanguage(request.getParameter("language"));
		lectureseries.setFacultyName(request.getParameter("facultyName"));
		lectureseries.setInstructorsString(request.getParameter("instructorsString"));
		lectureseries.setPassword(request.getParameter("password"));
		lectureseries.setLongDesc(s);	
		
		//update database
		LectureseriesLocalServiceUtil.updateLectureseries(lectureseries);
		//refresh htaccess authentication files 
		Htaccess.writePW(LectureseriesLocalServiceUtil.getAllLectureseriesWhithPassword());
		
		//update institution link
		//delete old entries first
		Lectureseries_InstitutionLocalServiceUtil.removeByLectureseriesId(lectureseries.getLectureseriesId());
		//new links to institution
		for(int i=0;i<institutions.length;i++){
			Lectureseries_InstitutionImpl lf = new Lectureseries_InstitutionImpl();
			lf.setLectureseriesId(lId);
			lf.setInstitutionId(new Long(institutions[i]));
			if(!Lectureseries_InstitutionLocalServiceUtil.institutionAssignedToLectureseries(lf))
				Lectureseries_InstitutionLocalServiceUtil.addLectureseries_Institution(lf);
		}
		
		//update producer link
		//delete old entries first
		Producer_LectureseriesLocalServiceUtil.removeByLectureseriesId(lId);
		//new links to producer
		for(int i=0;i<producers.length;i++){
			Producer_LectureseriesImpl pl = new Producer_LectureseriesImpl();
			pl.setProducerId(new Long(producers[i]));
			pl.setLectureseriesId(lId);
			//producer not assigned to lecture series yet
			if(!Producer_LectureseriesLocalServiceUtil.producerAssignedToLectureseries(pl))
				Producer_LectureseriesLocalServiceUtil.addProducer_Lectureseries(pl);
		}		
	}

	public void addLectureseries(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		String s = request.getParameter("longDesc");
		String[] producers = request.getParameterValues("producers");
		String[] institutions = request.getParameterValues("institutions");

		//build lecture series object
		LectureseriesImpl lectureseries = new LectureseriesImpl();
		lectureseries.setApproved(0);
		lectureseries.setNumber(request.getParameter("number"));
		lectureseries.setEventType(request.getParameter("eventType"));
		lectureseries.setEventCategory(request.getParameter("eventCategory"));
		lectureseries.setName(request.getParameter("name"));
		lectureseries.setShortDesc(request.getParameter("shortDesc"));
		lectureseries.setSemesterName(request.getParameter("semesterName"));
		lectureseries.setLanguage(request.getParameter("language"));
		lectureseries.setFacultyName(request.getParameter("facultyName"));
		lectureseries.setInstructorsString(request.getParameter("instructorsString"));
		lectureseries.setPassword(request.getParameter("password"));
		lectureseries.setLongDesc(s);
		
		//save object to database
		Long lId = LectureseriesLocalServiceUtil.addLectureseries(lectureseries).getLectureseriesId();
		//refresh htaccess authentication files 
		Htaccess.writePW(LectureseriesLocalServiceUtil.getAllLectureseriesWhithPassword());
		
		//link to institution
		for(int i=0;i<institutions.length;i++){
			Lectureseries_InstitutionImpl lf = new Lectureseries_InstitutionImpl();
			lf.setLectureseriesId(lId);
			lf.setInstitutionId(new Long(institutions[i]));
			Lectureseries_InstitutionLocalServiceUtil.addLectureseries_Institution(lf);
		}

		//link to producer
		for(int i=0;i<producers.length;i++){
			Producer_LectureseriesImpl pl = new Producer_LectureseriesImpl();
			pl.setProducerId(new Long(producers[i]));
			pl.setLectureseriesId(lId);
			Producer_LectureseriesLocalServiceUtil.addProducer_Lectureseries(pl);
		}
		request.setAttribute("institutions", institutions);
		request.setAttribute("producers", producers);
	}

}
