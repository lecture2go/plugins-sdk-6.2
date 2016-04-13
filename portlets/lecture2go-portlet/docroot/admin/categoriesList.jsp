<%@include file="/init.jsp"%>

<%
	List<Category> tempCategList = new ArrayList();
	tempCategList = CategoryLocalServiceUtil.getAllCategories(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
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
					<aui:input name="name" value="" type="text" label="name"/>
					<aui:button type="submit" value="add" id="add"/>
				</div>
			</aui:form>
	</aui:layout>
</aui:fieldset>

<liferay-ui:search-container emptyResultsMessage="no-categories-found" delta="10" iteratorURL="<%= portletURL %>">
	<liferay-ui:search-container-results>
		<%
			results = ListUtil.subList(tempCategList, searchContainer.getStart(), searchContainer.getEnd());
			total = tempCategList.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Category" keyProperty="categoryId" modelVar="cat">
		<% 
			Long catIdLong = cat.getCategoryId();
			String catIdString = catIdLong+""; 
		%>
		<portlet:actionURL name="edit" var="editURL">
			<portlet:param name="categoryId" value='<%=catIdString%>' />
			<portlet:param name="delta" value='<%=delta%>' />
			<portlet:param name="cur" value='<%=cur%>' />
			<portlet:param name="backURL" value='<%=backURL.toString()%>' />
		</portlet:actionURL>
		
		<portlet:actionURL name="delete" var="removeURL">
			<portlet:param name="categoryId" value='<%=catIdString%>' />
			<portlet:param name="delta" value='<%=delta%>' />
			<portlet:param name="cur" value='<%=cur%>' />
			<portlet:param name="backURL" value='<%=backURL.toString()%>' />
		</portlet:actionURL>		
		
		<liferay-ui:search-container-column-text name="name">
		<%
			List<Video_Category> vcl = Video_CategoryLocalServiceUtil.getByCategory(catIdLong);
			int count = vcl.size();
		%>
			<aui:form action="<%=editURL%>" commandName="model">
				  <div class="adminrow wide">
					<div class="admintile wide">
						<aui:input name="name" value="<%=cat.getName()%>" type="text" label=""/>
						<aui:input name="categoryId" value="<%=cat.getCategoryId()%>" type="hidden"/>
					</div>
					<div class="admintile wide icons creators">
						<%if(count==0){%>
							<a href="<%=removeURL.toString()%>">
								<span class="icon-large icon-remove" onclick="return confirm('really-delete-question')"></span>
							</a>
						<%}%>
						<aui:button type="submit"/>
					</div>
					<div class="undertile wide">
					<%
						if(count>0){
							%><b><%=count%></b> video-s<br/><%
						}
					%>
					</div>					
				</div>
			</aui:form>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>