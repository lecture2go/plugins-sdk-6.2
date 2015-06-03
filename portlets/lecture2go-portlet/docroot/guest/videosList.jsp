<%@page import="com.liferay.portal.kernel.servlet.ServletRequestUtil"%>
<%@page import="com.liferay.portal.service.persistence.PortletUtil"%>
<%@include file="/init.jsp"%>

<%
		//FILTER
		//terms array
		ArrayList<Long> termIds = new ArrayList<Long>();
		//termIds.add(new Long(11));
		//termIds.add(new Long(7));
		//category array
		ArrayList<Long> categoryIds = new ArrayList<Long>();
		//categoryIds.add(new Long(1));
		//categoryIds.add(new Long(5));
		//creator ids
		ArrayList<Long> creatorIds =  new ArrayList<Long>();
		//creatorIds.add(new Long(1));
		//creatorIds.add(new Long(2));
		
		//institution 
		Long institutionId = ServletRequestUtils.getLongParameter(request, "institutionId", 0);
		String test = ServletRequestUtils.getStringParameter(request, "institutionId", "");

		System.out.print(test);
		//parentInstitutionId
		Long parentInstitutionId = ServletRequestUtils.getLongParameter(request, "parentInstitutionId", 0);
		
		//institutionId = new Long(74);
		//parentInstitutionId = new Long(3);
		//return list
		List<Lectureseries> reqLectureseries = LectureseriesLocalServiceUtil.getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(institutionId, parentInstitutionId, termIds, categoryIds, creatorIds);

		List<Lectureseries> tempLectureseriesList = new ArrayList();
		
		PortletURL portletURL = renderResponse.createRenderURL();
		
%>

<liferay-ui:search-container emptyResultsMessage="no-lectureseries-found" delta="5" iteratorURL="<%=portletURL %>">
	<liferay-ui:search-container-results>
		<%
			tempLectureseriesList = reqLectureseries;
			results = ListUtil.subList(tempLectureseriesList, searchContainer.getStart(), searchContainer.getEnd());
			total = tempLectureseriesList.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Lectureseries" keyProperty="lectureseriesId" modelVar="lectser">
		<liferay-ui:search-container-column-text>
			<%
				String oId = "";
				boolean isVideo = false;
				
				if(lectser.getLatestOpenAccessVideoId()<0) isVideo = true;
				oId = lectser.getLectureseriesId()+"";
			%>
			<portlet:actionURL name="viewOpenAccessVideo" var="viewOpenAccessVideoURL">
				<portlet:param name="objectId" value="<%=oId%>"/>
				<%if(isVideo){%><portlet:param name="objectType" value="v"/><%}%>
				<%if(!isVideo){%><portlet:param name="objectType" value="l"/><%}%>
			</portlet:actionURL>
			<a href="<%=viewOpenAccessVideoURL%>"><%=lectser.getName()%></a>
			<br/>
			<%
				if(lectser.getLatestOpenAccessVideoId()<0){%>video id = <%=lectser.getLectureseriesId()%><%}
				else{%>lecture series id = <%=lectser.getLectureseriesId()%><%}
			%>		
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>