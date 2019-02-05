package de.uhh.l2g.plugins.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import de.uhh.l2g.plugins.model.Video;

public class CreatorSearchContainer extends SearchContainer<Video> {
	public static final String EMPTY_RESULTS_MESSAGE = "No Record Found";
	public static final int DEFAULT_DELTA = 10;
	static List<String> headerNames = new ArrayList<String>();
	static {
		headerNames.add("creatorId");
	}

	public CreatorSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new CreatorDisplayTerms(portletRequest), new CreatorDisplayTerms(portletRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}
}
