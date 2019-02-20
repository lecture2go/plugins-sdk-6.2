package de.uhh.l2g.plugins.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.Validator;

import de.uhh.l2g.plugins.model.Video;

public class VideoSearchContainer extends SearchContainer<Video> {
	public static final String EMPTY_RESULTS_MESSAGE = "No Record Found";
	public static final int DEFAULT_DELTA = 10;
	static List<String> headerNames = new ArrayList<String>();
	static {
		headerNames.add("coordinatorId");
		headerNames.add("producerId");
		headerNames.add("lectureseriesId");
	}

	public VideoSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new VideoDisplayTerms(portletRequest), new VideoDisplayTerms(portletRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		VideoDisplayTerms displayTerms = (VideoDisplayTerms) getDisplayTerms();
		//
		String cId = "0"; 
		String pId = "0"; 
		//check weather the coordinator has been set
		try{ 
			cId = portletRequest.getAttribute("coordinatorId").toString(); 
			if(Validator.isDigit(cId) && !cId.equals("0")){
				displayTerms.setCoordinatorId(cId);
			}
		}catch(NullPointerException npe){}
		//check weather the producer has been set
		try{ 
			pId = portletRequest.getAttribute("producerId").toString(); 
			if(Validator.isDigit(pId) && !pId.equals("0")){
				displayTerms.setProducerId(pId);
			}
		}catch(NullPointerException npe){}
		//
		iteratorURL.setParameter("coordinatorId", displayTerms.getCoordinatorId());
		iteratorURL.setParameter("producerId", displayTerms.getProducerId());
		iteratorURL.setParameter("lectureseriesId", displayTerms.getLectureseriesId());
	}
}
