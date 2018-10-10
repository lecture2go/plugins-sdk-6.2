<%@include file="/init.jsp"%>

<portlet:actionURL name="addStreamingServer" var="addStreamingServerURL"></portlet:actionURL>
<portlet:actionURL name="deleteStreamingServer" var="deletetreamingServerURL"></portlet:actionURL>
<portlet:actionURL name="updateStreamingServer" var="updateStreamingServerURL"></portlet:actionURL>
<portlet:actionURL name="updateTreeRoot" var="updateTreeRootURL"></portlet:actionURL>

<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></portlet:renderURL>
<liferay-portlet:renderURL varImpl="outerURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="innerURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></liferay-portlet:renderURL>

<%!com.liferay.portal.kernel.dao.search.SearchContainer<Host> searchHostContainer = null;%>

<%
PortletURL portletURL = renderResponse.createRenderURL();
String repDirectory = PropsUtil.get("lecture2go.media.repository");

//Get StreamingServer Defaults
Host defaultHost = HostLocalServiceUtil.getDefaultHost();

 if (defaultHost != null) {%>	
	<%--STREAMING SERVER START--%>
		<%if(permissionAdmin){ %>
			<aui:fieldset column="false" label="streaming-server" cssClass="add-institution" >
				<aui:layout>
					<aui:form action="<%= addStreamingServerURL %>" name="fm" inlineLabel="true" commandName="model">
						 <aui:button-row>
						 	 <aui:fieldset column="true">
				 	         <aui:input label="streaming-server-domain-or-ip" name="ip" inlineField="true" required="true" value=''></aui:input>
				 	         <aui:input label="port" name="port" inlineField="true" value=''></aui:input>
				 	         <aui:input label="protocol" name="protocol" inlineField="true" value=''></aui:input>
				 	         <aui:input name='hostId' type='hidden' inlineField="true" value='<%= ParamUtil.getString(renderRequest, "hostId") %>'/>
						 	 <aui:button type="submit" value="add"></aui:button>
						 	 </aui:fieldset>
						 </aui:button-row>
					</aui:form>
				</aui:layout>
			</aui:fieldset>
			
			<%-- LIST --%>
				<liferay-ui:search-container searchContainer="<%= searchHostContainer %>" curParam ="curStreamingServer" orderByType="asc" emptyResultsMessage="there-are-no-hosts" iteratorURL="<%= innerURL %>" delta="20" deltaConfigurable="true" >
					<liferay-ui:search-container-results results="<%=HostLocalServiceUtil.getAll(searchContainer.getStart(), searchContainer.getEnd())%>" total="<%=HostLocalServiceUtil.countAll()%>" />
					<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Host" modelVar="Hosts" rowVar="thisRow" keyProperty="hostId"  escapedModel="<%= false %>" indexVar="k">
	        			<liferay-ui:search-container-column-text name="Host" cssClass="toplevel-institutions">
		        			<c:choose>
			        			<c:when  test='<%= (permissionAdmin||permissionCoordinator) %>'> 
			        		    	<%--DELETE: For advanced security, this should only be generated if user is allowed to delete Hosts--%>	    
					        		<portlet:actionURL name="deleteStreamingServer" var="deleteStreamingServerURL">
					        			<c:choose>
					        				<c:when test='<%=  HostLocalServiceUtil.getLockingElements(Hosts.getHostId()) < 1 %>'>
					        					<portlet:param name="curStreamingServerId" value='<%= (new Long(Hosts.getHostId())).toString() %>' />
											</c:when>
											<c:otherwise>
												<portlet:param name="curStreamingServerId" value='<%= "0" %>' />
											</c:otherwise>
										</c:choose>
										<portlet:param name="backURL" value="<%=String.valueOf(portletURL) %>"/>
									</portlet:actionURL>
									<aui:form action="<%= updateStreamingServerURL %>" name="fm">
										<aui:fieldset>
										<% 
										String hn = "";
										if (Hosts.getDefaultHost() > 0) { 
											hn="Default";
										} else {
											hn=Hosts.getName();
										}%>
											<aui:input name="curStreamingServerName" label="" inlineField="true" value = "<%= hn %>" disabled="true"/>
											<input type="hidden" name="<portlet:namespace></portlet:namespace>curStreamingServerName" value = "<%= hn %>"/>
											
											<aui:input name="curStreamingServerIP" label="" inlineField="true" value = "<%= Hosts.getStreamer() %>" />				
											<aui:input name="curStreamingServerPort" label="" inlineField="true" value = "<%= Hosts.getPort() %>" />
											<aui:input name="curStreamingServerProtocol" label="" inlineField="true" value = "<%= Hosts.getProtocol() %>" />
											<aui:input name="curStreamingServerId" type='hidden' inlineField="true" value = "<%= (new Long(Hosts.getHostId())).toString() %>"/>
											<aui:button type="submit" value="edit"></aui:button>
												<%--DELETE --%>
												<c:if test='<%= (permissionAdmin||permissionCoordinator) && HostLocalServiceUtil.getLockingElements(Hosts.getHostId()) < 1 && !(Hosts.getDefaultHost() > 0) %>'>
													<aui:button name="delete" value="delete" type="button" href="<%=deleteStreamingServerURL.toString() %>" />
												</c:if>
										</aui:fieldset>
									</aui:form>
									</c:when>
									<c:otherwise>
										<liferay-ui:message key="<%=Hosts.getName() %>"></liferay-ui:message>
										<liferay-ui:message key="<%=Hosts.getStreamer() %>"></liferay-ui:message>
										<liferay-ui:message key="<%=String.valueOf(Hosts.getPort()) %>"></liferay-ui:message>
										<liferay-ui:message key="<%=Hosts.getProtocol() %>"></liferay-ui:message>
										<liferay-ui:message key="<%=repDirectory %>"></liferay-ui:message>
									</c:otherwise>
								</c:choose>
	        				</liferay-ui:search-container-column-text>
	        			</liferay-ui:search-container-row>
	        		<liferay-ui:search-iterator searchContainer="<%= searchHostContainer %>" />
				</liferay-ui:search-container>
		<%}%>
	<%--STREAMING SERVER END--%>	
<%} else {%>
<liferay-ui:message key="streamer-defaults-not-configured"></liferay-ui:message> 
<%}%>