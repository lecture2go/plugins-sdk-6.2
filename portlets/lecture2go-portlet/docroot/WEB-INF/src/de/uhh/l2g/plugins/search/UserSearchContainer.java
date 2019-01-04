package de.uhh.l2g.plugins.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.Validator;

import de.uhh.l2g.plugins.model.Video;

public class UserSearchContainer extends SearchContainer<Video> {
	public static final String EMPTY_RESULTS_MESSAGE = "No Record Found";
	public static final int DEFAULT_DELTA = 10;
	static List<String> headerNames = new ArrayList<String>();
	static {
		headerNames.add("roleId");
	}

	public UserSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new UserDisplayTerms(portletRequest), new UserDisplayTerms(portletRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		UserDisplayTerms displayTerms = (UserDisplayTerms) getDisplayTerms();
		//
		String rId = "0"; 
		//check weather the role has been set
		try{ 
			rId = portletRequest.getAttribute("roleId").toString(); 
			if(Validator.isDigit(rId) && !rId.equals("0")){
				displayTerms.setRoleId(rId);
			}
		}catch(Exception npe){
			//
		}
		//check keyword
		if(displayTerms.getKeywords().trim().length()>0)displayTerms.setRoleId("");
		//
		iteratorURL.setParameter("roleId", displayTerms.getRoleId());
	}
}
