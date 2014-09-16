<%@page import="de.uhh.l2g.plugins.model.Producer"%>
<%@include file="/init.jsp"%>

<%
	List<Lectureseries> tempLectureseriesList = new ArrayList();
	tempLectureseriesList = LectureseriesLocalServiceUtil.getLectureserieses(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS );
	
	Map<String, String> facilities = FacilityLocalServiceUtil.getAllSortedAsTree(0, 10000000);

	List<Producer> producers = ProducerLocalServiceUtil.getProducers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS );
	
	List<String> semesters = new ArrayList();
	
	List<Integer> statusList= new ArrayList();
	statusList.add(0, 0);
	statusList.add(1, 1);
	
	Integer facilityId = 0;
	Integer producerId = 0;
	String semesterId = null;
	Integer statusId = null;
%>

<aui:fieldset helpMessage="choose-filter" column="true">
		<aui:layout>
 			<aui:column>
						<portlet:renderURL var="sortByFacility"><portlet:param name="jspPage" value="/admin/lectureSeriesList.jsp" /></portlet:renderURL>
						<aui:form action="<%= sortByFacility.toString() %>" method="post">
							<aui:select name="facilityId" label="select-facility" onChange="submit();">
								<aui:option value="">select-facility</aui:option>

								<%
								for (Map.Entry<String, String> f : facilities.entrySet()) {
										if(f.getKey().equals(facilityId.toString())){
											%>
											<aui:option value='<%=f.getKey()%>' selected="true"><%=f.getValue()%></aui:option>
											<%}else{%>
											<aui:option value='<%=f.getKey()%>'><%=f.getValue()%></aui:option>
											<%}	
								}%>
							</aui:select>
						</aui:form>	
				</aui:column>			
				<aui:column>
						<portlet:renderURL var="sortByProducer"><portlet:param name="jspPage" value="/admin/lectureSeriesList.jsp" /></portlet:renderURL>
						<aui:form action="<%= sortByProducer.toString() %>" method="post">
							<aui:select name="producerId" label="select-producer" onChange="submit();">
								<aui:option value="">select-producer</aui:option>
								<%for (int i = 0; i < producers.size(); i++) {
										if(producers.get(i).getProducerId()==producerId){
											%>
											<aui:option value='<%=producers.get(i).getProducerId()%>' selected="true"><%=producers.get(i).getHomeDir()%></aui:option>
											<%}else{%>
											<aui:option value='<%=producers.get(i).getProducerId()%>'><%=producers.get(i).getHomeDir()%></aui:option>
											<%}					
								}%>
							</aui:select>
						</aui:form>		
				</aui:column>	
				<aui:column>
						<portlet:renderURL var="sortBySemester"><portlet:param name="jspPage" value="/admin/lectureSeriesList.jsp" /></portlet:renderURL>
						<aui:form action="<%= sortBySemester.toString() %>" method="post">
							<aui:select name="semesterId" label="select-semester" onChange="submit();">
								<aui:option value="">select-semester</aui:option>
								<%for (int i = 0; i < semesters.size(); i++) {
									
										if(semesters.get(i).equals(semesterId)){
											%>
											<aui:option value='<%=semesters.get(i)%>' selected="true"><%=semesters.get(i)%></aui:option>
											<%}else{%>
											<aui:option value='<%=semesters.get(i)%>'><%=semesters.get(i)%></aui:option>
											<%}					
								}%>
							</aui:select>
						</aui:form>				
				</aui:column>	
				<aui:column>
						<portlet:renderURL var="sortByStatus"><portlet:param name="jspPage" value="/admin/lectureSeriesList.jsp" /></portlet:renderURL>
						<aui:form action="<%= sortByStatus.toString() %>" method="post">
							<aui:select name="statusId" label="select-status" onChange="submit();">
								<aui:option value="">select-status</aui:option>
								<%for (int i = 0; i < statusList.size(); i++) {
										if(statusList.get(i)==statusId){
											%>
											<aui:option value='<%=statusList.get(i)%>' selected="true"><%=statusList.get(i)%></aui:option>
											<%}else{%>
											<aui:option value='<%=statusList.get(i)%>'><%=statusList.get(i)%></aui:option>
											<%}					
								}%>
							</aui:select>
						</aui:form>
				</aui:column>		
		</aui:layout>
</aui:fieldset>

<liferay-ui:search-container emptyResultsMessage="no-l2go-roles-found" delta="10">
	<liferay-ui:search-container-results>
		<%
			results = ListUtil.subList(tempLectureseriesList, searchContainer.getStart(), searchContainer.getEnd());
			total = tempLectureseriesList.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Lectureseries" keyProperty="lectureseriesId" modelVar="lectser">
		<portlet:actionURL name="viewLectureseries" var="editURL">
			<portlet:param name="lectureseriesId" value="<%= String.valueOf(lectser.getLectureseriesId())%>" />
		</portlet:actionURL>
		<liferay-ui:search-container-column-text name="name">
			<aui:a  href="<%=editURL.toString()%>"><%=lectser.getName()%></aui:a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp path="/admin/editLectureseriesButton.jsp"/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>