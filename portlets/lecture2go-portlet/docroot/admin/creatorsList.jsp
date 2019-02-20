<%@include file="/init.jsp"%>

<%
	long groupId = themeDisplay.getLayout().getGroupId();
	String name = Creator.class.getName();
	PortletURL portletURL = renderResponse.createRenderURL();
	
	PortletURL backURL = portletURL;
	//
	String portletURLString = portletURL.toString();
	CreatorSearchContainer creatorSearchContainer = new CreatorSearchContainer(renderRequest, portletURL);	
	CreatorDisplayTerms displayTerms = (CreatorDisplayTerms)creatorSearchContainer.getDisplayTerms();
	//		
	String pageName = themeDisplay.getLayout().getName(themeDisplay.getLocale());
%>

<portlet:actionURL name="add" var="addURL">
	<portlet:param name="backURL" value='<%=backURL.toString()%>' />
</portlet:actionURL>

<div class="noresponsive">		
	<label class="edit-video-lable"><%=pageName%></label>	
	<aui:fieldset column="false" label="" >
		<aui:layout>
				<aui:form action="<%=addURL%>" commandName="model" name="metadata">
					<div class="add-new-creator-term-object">
						<aui:input name="jobTitle" value="" type="text" label="job-title"/>
						<aui:input name="firstName" value="" type="text" label="first-name"/>
						<aui:input name="middleName" value="" type="text" label="middle-name"/>
						<aui:input name="lastName" value="" type="text" label="last-name"/>
						<aui:button type="submit" value="add" id="add"/>
					</div>
				</aui:form>
		</aui:layout> 
	</aui:fieldset>

	<liferay-ui:search-container emptyResultsMessage="no-creators-found" searchContainer="<%= creatorSearchContainer %>">
		
			<div id="modifiedSearch">
				<aui:form action="<%= portletURLString %>" method="post" name="fm">
					<liferay-ui:search-form page="/admin/searchCreators.jsp" servletContext="<%= application %>" />
				</aui:form>
			</div>
					
			<liferay-ui:search-container-results 
				results="<%= CreatorSearchHelper.getCreator(displayTerms,creatorSearchContainer.getStart(), creatorSearchContainer.getEnd()) %>" 
				total="<%= CreatorSearchHelper.getTotalCreatorCount(displayTerms,creatorSearchContainer.getStart(), creatorSearchContainer.getEnd()) %>"
			/>
		
			<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Creator" keyProperty="creatorId" modelVar="creator">
			<% String creatorId = creator.getCreatorId()+""; %>
			<portlet:actionURL name="edit" var="editURL">
				<portlet:param name="creatorId" value='<%=creatorId%>' />
				<portlet:param name="backURL" value='<%=backURL.toString()%>' />
			</portlet:actionURL>
			
			<portlet:actionURL name="delete" var="removeURL">
				<portlet:param name="creatorId" value='<%=creatorId%>' />
				<portlet:param name="backURL" value='<%=backURL.toString()%>' />
			</portlet:actionURL>		
			
			<liferay-ui:search-container-column-text name="name">
				<aui:form action="<%=editURL%>" commandName="model">
					  <div class="adminrow wide">
						<div class="admintile wide">
							<aui:input name="jobTitle" value="<%=creator.getJobTitle()%>" type="job-title" label=""/>
							<aui:input name="firstName" value="<%=creator.getFirstName()%>" type="text" label=""/>
							<aui:input name="middleName" value="<%=creator.getMiddleName()%>" type="text" label=""/>
							<aui:input name="lastName" value="<%=creator.getLastName()%>" type="text" label=""/>
							<aui:input name="creatorId" value="<%=creator.getCreatorId()%>" type="hidden"/>
						</div>
						<div class="admintile wide icons creators">
								<a href="<%=removeURL.toString()%>">
									<span class="icon-large icon-remove" onclick="return confirm('<liferay-ui:message key="really-delete-question"/>')"></span>
								</a>
								<aui:button type="submit"/>
						</div>
						<div class="undertile wide">
						<%
							List<Video_Creator> vc = Video_CreatorLocalServiceUtil.getByCreator(creator.getCreatorId()); 
							ListIterator<Video_Creator> vci = vc.listIterator(); 
							if(vc.size()>0){
								%><b><liferay-ui:message key="video-s"/></b><%
								while(vci.hasNext()){
									Video_Creator v_c = vci.next();
									Video v = VideoLocalServiceUtil.getVideo(v_c.getVideoId());
									  %><p><%=v.getTitle()+" -- id: "+v.getVideoId()%></p><%
								} 							
							}
							List<Lectureseries_Creator> lc = Lectureseries_CreatorLocalServiceUtil.getByCreator(creator.getCreatorId()); 
							ListIterator<Lectureseries_Creator> lci = lc.listIterator();  
							if(lc.size()>0){
								%><b><liferay-ui:message key="lecture-series"/></b><%
								while(lci.hasNext()){
									Lectureseries_Creator l_c = lci.next();
									Lectureseries l = LectureseriesLocalServiceUtil.getLectureseries(l_c.getLectureseriesId());
									  %><p><%=l.getName()+" -- id: "+l.getLectureseriesId()%></p><%
								}
							}
						%>
						</div>
					</div>
				</aui:form>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>