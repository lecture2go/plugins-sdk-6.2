package de.uhh.l2g.plugins.guest;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Creator;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_CreatorLocalServiceUtil;

public class OpenAccessVideos extends MVCPortlet {
	
	public void viewOpenAccessLectureSeries(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		//terms array
		ArrayList<Long> termIds = new ArrayList<Long>();
		termIds.add(new Long(1));
		termIds.add(new Long(9));
		
		//category array
		ArrayList<Long> categoryIds = new ArrayList<Long>();
		categoryIds.add(new Long(1));
		categoryIds.add(new Long(5));		
		
		//creator ids from lecture id (4295)
		List<Lectureseries_Creator> creatorIds = Lectureseries_CreatorLocalServiceUtil.getByLectureseriesId(new Long(4295));
		
		//return list
		List<Lectureseries> lectureseries = LectureseriesLocalServiceUtil.getFilteredByInstitutionParentInstitutionTermCategoryCreator(new Long(0), new Long(0), termIds, categoryIds, creatorIds);
		 
		request.setAttribute("lectureseries", lectureseries);
		response.setRenderParameter("jspPage","/guest/videosList.jsp");
	}
	
}