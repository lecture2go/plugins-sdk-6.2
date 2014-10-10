package de.uhh.l2g.plugins.admin;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityImpl;
import de.uhh.l2g.plugins.model.impl.Producer_LectureseriesImpl;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_FacilityLocalServiceUtil;
import de.uhh.l2g.plugins.service.Producer_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;

public class AdminLectureSeriesManagement extends MVCPortlet {
	
	public void viewLectureseries(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		// requested lectureseries
		long reqUserId = new Long(request.getParameterMap().get("lectureseriesId")[0]);
		Lectureseries reqLectureseries = LectureseriesLocalServiceUtil.getLectureseries(reqUserId);
		request.setAttribute("reqLectureseries", reqLectureseries);
		
		response.setRenderParameter("jspPage", "/admin/editLectureseries.jsp");
	}
	
	public void filterLectureseries(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		// requested lectureseries
		List<Lectureseries> l = LectureseriesLocalServiceUtil.getFilteredBySemesterFacultyProducer(0, "", 8, 0);

		request.setAttribute("reqLectureseries", l);
		response.setRenderParameter("jspPage", "/admin/editLectureseries.jsp");
	}
	
	public void removeLectureseries(ActionRequest request, ActionResponse response) {
		Long lId = new Long(request.getParameter("lectureseriesId"));
		//remove lecture series
		try {
			LectureseriesLocalServiceUtil.deleteLectureseries(lId);
			//dependencies
			Lectureseries_FacilityLocalServiceUtil.removeByLectureseriesId(lId);//facility
			Producer_LectureseriesLocalServiceUtil.removeByLectureseriesId(lId);//producer
			VideoLocalServiceUtil.unlinkLectureseriesFromVideos(lId);//video
			Video_LectureseriesLocalServiceUtil.removeByLectureseriesId(lId);//video links to lecture series
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public void editLectureseries(ActionRequest request, ActionResponse response) throws NumberFormatException, PortalException, SystemException{
		Long lId = new Long(request.getParameter("lectureseriesId"));
		String[] producers = request.getParameterValues("producers");
		String[] facilities = request.getParameterValues("facilities");
		String s = request.getParameter("longDesc");
		
		//update object
		Lectureseries lectureseries = LectureseriesLocalServiceUtil.getLectureseries(lId);
		lectureseries.setApproved(lectureseries.getApproved());
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
		
		//update facility link
		//delete old entries first
		Lectureseries_FacilityLocalServiceUtil.removeByLectureseriesId(lectureseries.getLectureseriesId());
		//new links to facility
		for(int i=0;i<facilities.length;i++){
			Lectureseries_FacilityImpl lf = new Lectureseries_FacilityImpl();
			lf.setLectureseriesId(lId);
			lf.setFacilityId(new Long(facilities[i]));
			Lectureseries_FacilityLocalServiceUtil.addLectureseries_Facility(lf);
		}
		
		//update producer link
		//delete old entries first
		Producer_LectureseriesLocalServiceUtil.removeByLectureseriesId(lId);
		//new links to producer
		for(int i=0;i<producers.length;i++){
			Producer_LectureseriesImpl pl = new Producer_LectureseriesImpl();
			pl.setProducerId(new Long(producers[i]));
			pl.setLectureseriesId(lId);
			Producer_LectureseriesLocalServiceUtil.addProducer_Lectureseries(pl);
		}		
	}

	public void addLectureseries(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		String s = request.getParameter("longDesc");
		String[] producers = request.getParameterValues("producers");
		String[] facilities = request.getParameterValues("facilities");

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
		
		//link to facility
		for(int i=0;i<facilities.length;i++){
			Lectureseries_FacilityImpl lf = new Lectureseries_FacilityImpl();
			lf.setLectureseriesId(lId);
			lf.setFacilityId(new Long(facilities[i]));
			Lectureseries_FacilityLocalServiceUtil.addLectureseries_Facility(lf);
		}

		//link to producer
		for(int i=0;i<producers.length;i++){
			Producer_LectureseriesImpl pl = new Producer_LectureseriesImpl();
			pl.setProducerId(new Long(producers[i]));
			pl.setLectureseriesId(lId);
			Producer_LectureseriesLocalServiceUtil.addProducer_Lectureseries(pl);
		}
	}

}
