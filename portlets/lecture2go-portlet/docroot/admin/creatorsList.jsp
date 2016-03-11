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
%>

<portlet:actionURL name="add" var="addURL">
	<portlet:param name="delta" value='<%=delta%>' />
	<portlet:param name="cur" value='<%=cur%>' />
	<portlet:param name="backURL" value='<%=backURL.toString()%>' />
</portlet:actionURL>
		
<aui:fieldset column="false" label="" >
	<aui:layout>
			<aui:form action="<%=addURL%>" commandName="model" name="metadata">
				<div class="add-new-creator-term-object">
					<aui:select size="1" name="jobTitle" label="job-title">
						<aui:option value="0">please-choose-title</aui:option>
							<%
							String[] l =  LanguageUtil.get(pageContext, "creator-titles").split(",");
							for(int i=0; i<l.length; i++){
								String title = l[i];
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
								<aui:option value="0">please-choose-title</aui:option>
								<%
								String[] l =  LanguageUtil.get(pageContext, "creator-titles").split(",");
								for(int i=0; i<l.length; i++){
									String title = l[i];
									%><aui:option value='<%=title%>'><%=title%></aui:option><%
									if (title.trim().equals(creator.getJobTitle().trim())) {%>
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
				</div>
			</aui:form>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>