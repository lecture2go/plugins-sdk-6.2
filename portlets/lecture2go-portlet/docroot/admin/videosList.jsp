<%@include file="/init.jsp"%>

<%
PortletURL portletURL = renderResponse.createRenderURL();
List<Video> tempVideosList = new ArrayList();

Long coordinatorId = ServletRequestUtils.getLongParameter(request, "coordinatorId", 0);
Long producerId = ServletRequestUtils.getLongParameter(request, "producerId", 0);
Long lectureseriesId = ServletRequestUtils.getLongParameter(request, "lectureseriesId", 0);

portletURL.setParameter("coordinatorId", coordinatorId+"");
portletURL.setParameter("producerId", producerId+"");
portletURL.setParameter("lectureseriesId", lectureseriesId+"");
%>
<portlet:renderURL var="addVideoURL"><portlet:param name="jspPage" value="/admin/editLectureseries.jsp" /></portlet:renderURL>

<aui:fieldset helpMessage="choose-filter" column="true">
		<aui:layout>
 			<aui:column>
						<portlet:renderURL var="sortByCoordinator">
							<portlet:param name="jspPage" value="/admin/videosList.jsp" />
							<portlet:param name="producerId" value="<%=producerId.toString()%>"/>
							<portlet:param name="lectureseriesId" value="<%=lectureseriesId.toString()%>"/>
						</portlet:renderURL>
						<aui:form action="<%= sortByCoordinator.toString() %>" method="post">
							<aui:select name="coordinatorId" label="select-coordinator" onChange="submit();">
								<aui:option value="">select-coordinator</aui:option>
							</aui:select>
						</aui:form>	
				</aui:column>			
				<aui:column>
						<portlet:renderURL var="sortByProducer">
							<portlet:param name="jspPage" value="/admin/videosList.jsp" />
							<portlet:param name="coordinatorId" value="<%=coordinatorId.toString()%>"/>
							<portlet:param name="lectureseriesId" value="<%=lectureseriesId.toString()%>"/>
						</portlet:renderURL>
						<aui:form action="<%= sortByProducer.toString() %>" method="post">
							<aui:select name="producerId" label="select-producer" onChange="submit();">
								<aui:option value="">select-producer</aui:option>
							</aui:select>
						</aui:form>		
				</aui:column>	
				<aui:column>
						<portlet:renderURL var="sortByLectureseries">
							<portlet:param name="jspPage" value="/admin/videosList.jsp" />
							<portlet:param name="coordinatorId" value="<%=coordinatorId.toString()%>"/>
							<portlet:param name="producerId" value="<%=producerId.toString()%>"/>
						</portlet:renderURL>
						<aui:form action="<%= sortByLectureseries.toString() %>" method="post">
							<aui:select name="lectureseriesId" label="select-lecture-series" onChange="submit();">
								<aui:option value="">select-semester</aui:option>
							</aui:select>
						</aui:form>				
				</aui:column>	
		</aui:layout>
		<aui:layout>
			<aui:row>
				<aui:button value="add-new-video" onClick="<%=addVideoURL%>"/>
			</aui:row>
		</aui:layout>
</aui:fieldset>

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