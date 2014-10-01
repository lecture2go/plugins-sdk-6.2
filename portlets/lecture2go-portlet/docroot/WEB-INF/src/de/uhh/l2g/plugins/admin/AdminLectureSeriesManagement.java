package de.uhh.l2g.plugins.admin;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;

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
	
	public void editLectureseries(ActionRequest request, ActionResponse response){
		int i = 0;
		i++;
	}

	public void addLectureseries(ActionRequest request, ActionResponse response){
		int i = 0;
		i++;		
	}

}
