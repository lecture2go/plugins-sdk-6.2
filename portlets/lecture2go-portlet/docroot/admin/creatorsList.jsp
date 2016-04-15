<%@include file="/init.jsp"%>

<%
	long groupId = themeDisplay.getLayout().getGroupId();
	String name = User.class.getName();
	User u = UserLocalServiceUtil.getUser(new Long (request.getRemoteUser()));
	List<Creator> tempCreatorsList = new ArrayList();
	tempCreatorsList = CreatorLocalServiceUtil.getAllCreators();
	PortletURL portletURL = renderResponse.createRenderURL();

	String delta = "";
	String cur = "";
	
	try{new Long(delta = request.getParameterMap().get("delta")[0]).toString();}catch(Exception e){}
	try{new Long(cur = request.getParameterMap().get("cur")[0]).toString();}catch(Exception e){}
	
	PortletURL backURL = portletURL;
	backURL.setParameter("delta", delta);
	backURL.setParameter("cur", cur);
	String[] ct =  LanguageUtil.get(pageContext, "creator-titles").split(",");
%>

<portlet:actionURL name="add" var="addURL">
	<portlet:param name="delta" value='<%=delta%>' />
	<portlet:param name="cur" value='<%=cur%>' />
	<portlet:param name="backURL" value='<%=backURL.toString()%>' />
</portlet:actionURL>

<div class="noresponsive">		
	<aui:fieldset column="false" label="" >
		<aui:layout>
				<aui:form action="<%=addURL%>" commandName="model" name="metadata">
					<div class="add-new-creator-term-object">
						<aui:select size="1" name="jobTitle" label="job-title">
							<aui:option value="0">please-choose-job-title</aui:option>
								<%
								for(int i=0; i<ct.length; i++){
									String title = ct[i];
									%><aui:option value='<%=title%>'><%=title%></aui:option>
								<%}%>
						</aui:select>				
						<aui:input name="firstName" value="" type="text" label="first-name"/>
						<aui:input name="lastName" value="" type="text" label="last-name"/>
						<aui:button type="submit" value="add" id="add"/>
					</div>
				</aui:form>
		</aui:layout> 
	</aui:fieldset>
		
	<liferay-ui:search-container emptyResultsMessage="no-creators-found" delta="10" iteratorURL="<%= portletURL %>">
		<liferay-ui:search-container-results>
			<%
				results = ListUtil.subList(tempCreatorsList, searchContainer.getStart(), searchContainer.getEnd());
				total = tempCreatorsList.size();
				pageContext.setAttribute("results", results);
				pageContext.setAttribute("total", total);
			%>
		</liferay-ui:search-container-results>
	
		<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Creator" keyProperty="creatorId" modelVar="creator">
			<% String creatorId = creator.getCreatorId()+""; %>
			<portlet:actionURL name="edit" var="editURL">
				<portlet:param name="creatorId" value='<%=creatorId%>' />
				<portlet:param name="delta" value='<%=delta%>' />
				<portlet:param name="cur" value='<%=cur%>' />
				<portlet:param name="backURL" value='<%=backURL.toString()%>' />
			</portlet:actionURL>
			
			<portlet:actionURL name="delete" var="removeURL">
				<portlet:param name="creatorId" value='<%=creatorId%>' />
				<portlet:param name="delta" value='<%=delta%>' />
				<portlet:param name="cur" value='<%=cur%>' />
				<portlet:param name="backURL" value='<%=backURL.toString()%>' />
			</portlet:actionURL>		
			
			<liferay-ui:search-container-column-text name="name">
				<aui:form action="<%=editURL%>" commandName="model">
					  <div class="adminrow wide">
						<div class="admintile wide">
							<aui:select size="1" name="jobTitle" label="">
									<aui:option value="0">please-choose-job-title</aui:option>
									<%
									for(int i=0; i<ct.length; i++){
										String title = ct[i];
										if (creator.getJobTitle().trim().equals(title.trim())) {%>
											<aui:option value='<%=title%>' selected="true"><%=title%></aui:option>
										<%} else {%>
											<aui:option value='<%=title%>'><%=title%></aui:option>
										<%}
									}
									%>
							</aui:select>				
							<aui:input name="firstName" value="<%=creator.getFirstName()%>" type="text" label=""/>
							<aui:input name="lastName" value="<%=creator.getLastName()%>" type="text" label=""/>
							<aui:input name="creatorId" value="<%=creator.getCreatorId()%>" type="hidden"/>
						</div>
						<div class="admintile wide icons creators">
								<a href="<%=removeURL.toString()%>">
									<span class="icon-large icon-remove" onclick="return confirm('really-delete-question')"></span>
								</a>
								<aui:button type="submit"/>
						</div>
						<div class="undertile wide">
						<%
							List<Video_Creator> vc = Video_CreatorLocalServiceUtil.getByCreator(creator.getCreatorId()); 
							ListIterator<Video_Creator> vci = vc.listIterator(); 
							if(vc.size()>0){
								%><b>video-s</b><%
								while(vci.hasNext()){
									Video_Creator v_c = vci.next();
									Video v = VideoLocalServiceUtil.getVideo(v_c.getVideoId());
									  %><p><%=v.getTitle()+" -- id: "+v.getVideoId()%></p><%
								} 							
							}
							List<Lectureseries_Creator> lc = Lectureseries_CreatorLocalServiceUtil.getByCreator(creator.getCreatorId()); 
							ListIterator<Lectureseries_Creator> lci = lc.listIterator();  
							if(lc.size()>0){
								%><b>lecture-series</b><%
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