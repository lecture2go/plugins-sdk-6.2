<%@include file="/init.jsp" %>
<%@ page import="de.uhh.l2g.plugins.util.PortletScheduler" %>
<%@ page import="com.liferay.portal.kernel.scheduler.SchedulerEntry" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%
List<SchedulerEntry> scheduledJobs = PortletScheduler.ListSchedulerEntries(portletDisplay.getRootPortletId());
List<PortletScheduler> portletScheduler = PortletScheduler.ListSchedulers();
%>
 
<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/threads.jsp" /></portlet:renderURL>

<portlet:actionURL name="startThread" var="startThreadURL"></portlet:actionURL>
<portlet:actionURL name="stopThread" var="stopThreadURL"></portlet:actionURL>
<portlet:actionURL name="removeAllJobss" var="removeAllJobsURL"></portlet:actionURL>

<div class="noresponsive">	       

	<%-- This lists all listed instances  --%>
	<%  int iC = 0;
	for(SchedulerEntry job : scheduledJobs) { 
	    String schedulerPanelId = "panel"+ String.valueOf(iC);
 	    iC++;
    %>	
		<liferay-ui:panel title="<%= job.getEventListenerClass() %>" collapsible="true" id="<%= schedulerPanelId  %>"
						defaultState="open"
						extended="<%= false %>"
						persistState="<%= true %>">     
				<aui:form action="<%= startThreadURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= job.getEventListenerClass() %>'/>
					<aui:button type="submit" value="Start" ></aui:button>
				</aui:form>
				<aui:form action="<%= stopThreadURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= job.getEventListenerClass() %>'/>
					<aui:button type="submit" value="Stop" ></aui:button>
				</aui:form>
		</liferay-ui:panel>
	<% } %>

   <br>
<%-- This list all unique schedulers --%>
<% for(PortletScheduler ps : portletScheduler) {  %>	
	<liferay-ui:message key="<%= ps.getJobName() %>"></liferay-ui:message>
<% } %>
        
        
		
		<liferay-ui:panel title="Manage" collapsible="true" id="managePanelId"
						defaultState="open"
						extended="<%= false %>"
						persistState="<%= true %>">     
				<aui:form action="<%= removeAllJobsURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value=''/>
					<aui:button type="submit" value="removeAllJobs" ></aui:button>
				</aui:form>
		</liferay-ui:panel>
</div>

