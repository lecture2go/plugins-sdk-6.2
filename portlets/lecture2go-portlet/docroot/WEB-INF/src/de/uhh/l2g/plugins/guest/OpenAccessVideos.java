package de.uhh.l2g.plugins.guest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;

public class OpenAccessVideos extends MVCPortlet {
	
	public void viewOpenAccessLectureSeries(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		String searchString = "Prof. Test First Name Test Last Name";
		
		//terms array
		ArrayList<Long> termIds = new ArrayList<Long>();
		termIds.add(new Long(1));
		termIds.add(new Long(9));
		//category array
		ArrayList<Long> categoryIds = new ArrayList<Long>();
		categoryIds.add(new Long(1));
		categoryIds.add(new Long(5));
		//creator ids
		ArrayList<Long> creatorIds =  new ArrayList<Long>();
		if(searchString.trim().length()>0){
			List<Creator> cl = CreatorLocalServiceUtil.getByFullName(searchString);
			ListIterator<Creator> cli = cl.listIterator();
			while(cli.hasNext()){
				creatorIds.add(cli.next().getCreatorId());
			}
		}
		//return list
		List<Lectureseries> lectureseries = LectureseriesLocalServiceUtil.getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(new Long(0), new Long(0), termIds, categoryIds, creatorIds, searchString);
		
		request.setAttribute("lectureseries", lectureseries);
		response.setRenderParameter("jspPage","/guest/videosList.jsp");
	}
	
}