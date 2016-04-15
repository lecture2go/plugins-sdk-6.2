<%@include file="/init.jsp"%>

<%
	List<Term> tempTermList = new ArrayList();
	tempTermList = TermLocalServiceUtil.getAllSemesters();
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

<div class="noresponsive">		
	<aui:fieldset column="false" label="" >
		<aui:layout>
				<aui:form action="<%=addURL%>" commandName="model" name="metadata">
					<div class="add-new-creator-term-object">
						<aui:input name="prefix" value="" type="text" label="prefix"/>
						<aui:input name="year" value="" type="text" label="year"/>
						<aui:button type="submit" value="add" id="add"/>
					</div>
				</aui:form>
		</aui:layout>
	</aui:fieldset>
	
	<liferay-ui:search-container emptyResultsMessage="no-terms-found" delta="10" iteratorURL="<%= portletURL %>">
		<liferay-ui:search-container-results>
			<%
				results = ListUtil.subList(tempTermList, searchContainer.getStart(), searchContainer.getEnd());
				total = tempTermList.size();
				pageContext.setAttribute("results", results);
				pageContext.setAttribute("total", total);
			%>
		</liferay-ui:search-container-results>
	
		<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Term" keyProperty="termId" modelVar="term">
			<% String termId = term.getTermId()+""; %>
			<portlet:actionURL name="edit" var="editURL">
				<portlet:param name="termId" value='<%=termId%>' />
				<portlet:param name="delta" value='<%=delta%>' />
				<portlet:param name="cur" value='<%=cur%>' />
				<portlet:param name="backURL" value='<%=backURL.toString()%>' />
			</portlet:actionURL>
			
			<portlet:actionURL name="delete" var="removeURL">
				<portlet:param name="termId" value='<%=termId%>' />
				<portlet:param name="delta" value='<%=delta%>' />
				<portlet:param name="cur" value='<%=cur%>' />
				<portlet:param name="backURL" value='<%=backURL.toString()%>' />
			</portlet:actionURL>		
			
			<liferay-ui:search-container-column-text name="name">
			<%
				List<Video> vl = VideoLocalServiceUtil.getByTerm(term.getTermId());
				ListIterator<Video> vli = vl.listIterator(); 
				int count1 = vl.size();
	
				List<Lectureseries> ll = LectureseriesLocalServiceUtil.getByTerm(term.getTermId()); 
				ListIterator<Lectureseries> lli = ll.listIterator();  
				int count2 = ll.size();
			%>
				<aui:form action="<%=editURL%>" commandName="model">
					  <div class="adminrow wide">
						<div class="admintile wide">
							<aui:input name="prefix" value="<%=term.getPrefix()%>" type="text" label=""/>
							<aui:input name="year" value="<%=term.getYear()%>" type="text" label=""/>
							<aui:input name="termId" value="<%=term.getTermId()%>" type="hidden"/>
						</div>
						<div class="admintile wide icons creators">
							<%if(count1==0 && count2==0){%>
								<a href="<%=removeURL.toString()%>">
									<span class="icon-large icon-remove" onclick="return confirm('really-delete-question')"></span>
								</a>
							<%}%>
							<aui:button type="submit"/>
						</div>
						<div class="undertile wide">
	
						<%
							if(count1>0){
								%><b><%=count1%></b> video-s<br/><%
							}
							if(count2>0){
								%><b><%=count2%></b> lecture-series<%
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