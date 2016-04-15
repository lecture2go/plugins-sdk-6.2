<div class="noresponsive">
        		<c:when  test='<%= permissionChecker.hasPermission(groupId, hostModel, groupId, "EDIT_HOST") %>'> 
        		    		<%--DELETE: For advanced security, this should only be generated if user is allowed to delete Hosts--%>	    
		        			<portlet:actionURL name="deleteStreamingServer" var="deleteStreamingServerURL">
		        				<c:choose>
		        					<c:when test='<%=  HostLocalServiceUtil.getLockingElements(groupId, Hosts.getHostId()) < 1 %>'>
		        						<portlet:param name="curStreamingServerId" value='<%= (new Long(Hosts.getHostId())).toString() %>' />
									</c:when>
									<c:otherwise>
										<portlet:param name="curStreamingServerId" value='<%= "0" %>' />
									</c:otherwise>
								</c:choose>
								<portlet:param name="backURL" value="<%=String.valueOf(portletURL) %>"/>
							</portlet:actionURL>
						<aui:form action="<%= updateStreamingServerURL %>" name="<portlet:namespace />fm">
							<aui:fieldset>
							
							<%	if (Hosts.getDefaultHost() > 0) {
							%>
								<aui:input name="curStreamingServerName" label="StreamingServer Name" inlineField="true" value = "Default" />
								
							<% }
							else {
							%>
								<aui:input name="curStreamingServerName" label="StreamingServer Name" inlineField="true" value = "<%= Hosts.getName() %>" />
							<%}%>
								<aui:input name="curStreamingServerIP" label="IP" inlineField="true" value = "<%= Hosts.getStreamer() %>" />				
								<aui:input name="curStreamingServerPort" label="Port" inlineField="true" value = "<%= Hosts.getPort() %>" />
								<aui:input name="curStreamingServerProtocol" label="Protocol" inlineField="true" value = "<%= Hosts.getProtocol() %>" />
								<aui:input name="curStreamingServerId" type='hidden' inlineField="true" value = "<%= (new Long(Hosts.getHostId())).toString() %>"/>
								<aui:button type="submit"></aui:button>
								<c:choose>
								<%--DELETE --%>
								<c:when test='<%= permissionChecker.hasPermission(groupId, hostModel, groupId, ActionKeys.DELETE) && HostLocalServiceUtil.getLockingElements(groupId, Hosts.getHostId()) < 1 && !(Hosts.getDefaultHost() > 0) %>'>
									<aui:button name="delete" value="Löschen" type="button" href="<%=deleteStreamingServerURL.toString() %>" />
								</c:when>
								<c:otherwise>
									<aui:button name="delete" value="Löschen" type="button" disabled="true" href="<%=deleteStreamingServerURL.toString() %>" />								
								</c:otherwise>
								</c:choose>
								</br>
								<liferay-ui:message key="<%= repDirectory %>" />/<liferay-ui:message key="<%= Hosts.getServerRoot() %>"/>
							</aui:fieldset>
						</aui:form>
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="<%= Hosts.getName() %>"></liferay-ui:message>
						<liferay-ui:message key="<%= Hosts.getStreamer() %>"></liferay-ui:message>
						<liferay-ui:message key="<%= String.valueOf(Hosts.getPort()) %>"></liferay-ui:message>
						<liferay-ui:message key="<%= Hosts.getProtocol() %>"></liferay-ui:message>
						<liferay-ui:message key="<%= repDirectory %>"></liferay-ui:message>
					</c:otherwise>
				</c:choose>
</div>