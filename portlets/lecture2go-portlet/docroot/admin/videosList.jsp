<%@include file="/init.jsp"%>

<%
PortletURL portletURL = renderResponse.createRenderURL();
List<Video> tempVideosList = new ArrayList();

%>
<liferay-ui:search-container emptyResultsMessage="no-videos-found" delta="10" iteratorURL="<%= portletURL %>">
	<liferay-ui:search-container-results>
		<%
			tempVideosList = VideoLocalServiceUtil.getVideos(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			results = ListUtil.subList(tempVideosList, searchContainer.getStart(), searchContainer.getEnd());
			total = tempVideosList.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Video" keyProperty="videoId" modelVar="video">
		<portlet:actionURL name="viewLectureseries" var="editURL">
			<portlet:param name="lectureseriesId" value="<%= String.valueOf(video.getVideoId())%>" />
		</portlet:actionURL>
		<liferay-ui:search-container-column-text name="name">
			<aui:a  href="<%=editURL.toString()%>"><%=video.getTitle()%></aui:a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp path="/admin/editLectureseriesButton.jsp"/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>