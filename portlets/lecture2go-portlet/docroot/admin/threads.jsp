<%@include file="/init.jsp" %>
<%@ page import="de.uhh.l2g.plugins.util.PortletScheduler" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.scheduler.SchedulerEntry" %>
<%@ page import="com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil" %>
<%@ page import="com.liferay.portal.kernel.scheduler.StorageType" %>
<%@ page import="com.liferay.portal.kernel.scheduler.TriggerState" %>
<%@ page import="com.liferay.portal.kernel.scheduler.Trigger" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%
	String actionURL = "";
	//liferay's scheduler entry ist
	List<SchedulerEntry> schedulerEntries = PortletScheduler.ListSchedulerEntries(portletDisplay.getRootPortletId());
	//quartz responses/jobs
	List<PortletScheduler> portletScheduler = PortletScheduler.ListSchedulers();
%>
 
<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/threads.jsp" /></portlet:renderURL>

<liferay-ui:success key="request_processed" message="request_processed"/>

<portlet:actionURL name="scheduleJob" var="scheduleJobURL"></portlet:actionURL>
<portlet:actionURL name="unscheduleJob" var="unscheduleJobURL"></portlet:actionURL>
<portlet:actionURL name="resumeJob" var="resumeJobURL"></portlet:actionURL>
<portlet:actionURL name="pauseJob" var="pauseJobURL"></portlet:actionURL>
<portlet:actionURL name="updateJob" var="updateJobURL"></portlet:actionURL>
<portlet:actionURL name="removeJob" var="removeJobURL"></portlet:actionURL>
<portlet:actionURL name="removeAllJobs" var="removeAllJobsURL"></portlet:actionURL>
<portlet:actionURL name="pauseAllJobs" var="pauseAllJobsURL"></portlet:actionURL>

<liferay-portlet:resourceURL id="triggerVideohitlistThread" var="triggerVideohitlistThread" />

<div class="noresponsive">	       

<liferay-ui:message key="ScheduledJobs: die eigentlichen Quartz Jobs, nur sie haben ein SchedulerResponse mit Job-Status"></liferay-ui:message>
<br>
<%-- This list all unique schedulers --%>
<% 
    //Initialize parameters
    TriggerState state = null;
	Trigger trigger = null;
	String schedulerPanelId = "panel";
    String cron = "";
    int iC = 0;
    
    //Do for each Quartz Response 
	for(PortletScheduler job : portletScheduler) {  	
		state = SchedulerEngineHelperUtil.getJobState(job.getJobName(), job.getJobName(), StorageType.MEMORY_CLUSTERED);
		trigger = job.getTrigger();
		if (trigger != null) cron = trigger.getTriggerContent().toString(); 
  		schedulerPanelId = "panel"+ String.valueOf(iC);
   		iC++;  
%>
		<liferay-ui:message key="<%= job.getJobName() %>"></liferay-ui:message> 
		<liferay-ui:message key="<%= state.toString() %>"></liferay-ui:message> 
		<liferay-ui:message key="<%= cron %>"></liferay-ui:message> 

        
 
 
 <% 	if (state.equals(TriggerState.UNSCHEDULED)) {	%>
 			<aui:form action="<%= scheduleJobURL %>" name="<portlet:namespace />fm">         
				<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= job.getJobName() %>'/>
				<aui:button type="submit" value="Schedule" ></aui:button>
			</aui:form>
		 <% } %>   
    	 <br>
		<%-- This lists all added Entry instances  --%>
		<%  
        //Do for each Entry in Liferay's Scheduler List
		for(SchedulerEntry entry : schedulerEntries) { 	
			if (entry.getEventListenerClass().equalsIgnoreCase(job.getJobName())){ //only display relevant entries
				
   		 %>	
		<liferay-ui:panel title="<%= entry.getEventListenerClass() %>" collapsible="true" id="<%= schedulerPanelId  %>"
						defaultState="open"
						extended="<%= false %>"
						persistState="<%= true %>">  
				<liferay-ui:message key="Mit Pause/Resume funktioniert die Standardsyntax über JobName"></liferay-ui:message>
				<aui:form action="<%= pauseJobURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= entry.getEventListenerClass() %>'/>
					<aui:button type="submit" value="Pause" ></aui:button>
				</aui:form> 
				<aui:form action="<%= resumeJobURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= entry.getEventListenerClass() %>'/>
					<aui:button type="submit" value="Resume" ></aui:button>
				</aui:form>  
				<liferay-ui:message key="Schedule/Unschedule funktioniert jetzt mit Trigger in Datenbank"></liferay-ui:message>
				<aui:form action="<%= unscheduleJobURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= entry.getEventListenerClass() %>'/>
					<aui:button type="submit" value="Unschedule" ></aui:button>
				</aui:form>
				<liferay-ui:message key="Updated den Trigger(Timer) (noch nicht implentiert))"></liferay-ui:message>
				<aui:form action="<%= updateJobURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= entry.getEventListenerClass() %>'/>
					<aui:button type="submit" value="Update" ></aui:button>
				</aui:form>
		</liferay-ui:panel>
		<br>
		<% } %>
	<% } %>
<% } %>	       
		
		<liferay-ui:panel title="Manage" collapsible="true" id="managePanelId"
						defaultState="open"
						extended="<%= false %>"
						persistState="<%= true %>">   
				<aui:form action="<%= pauseAllJobsURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value=''/>
					<aui:button type="submit" value="pauseAllJobs" ></aui:button>
				</aui:form>  
				<aui:form action="<%= removeAllJobsURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value=''/>
					<aui:button type="submit" value="removeAllJobs" ></aui:button>
				</aui:form>
		</liferay-ui:panel>
		
		
		<liferay-ui:message key="Debug Info: Scheduler will only function correctly if both list are synchronized"></liferay-ui:message>
		<br>
		<liferay-ui:message key="SchedulerEntries:"></liferay-ui:message>
		<br>
		<% for(SchedulerEntry entry : schedulerEntries) {  %>
		<liferay-ui:message key="<%= entry.getEventListenerClass() %>"></liferay-ui:message> 
		<% } %>
		<br>
		<liferay-ui:message key="SchedulerResponses:"></liferay-ui:message>
		<% for(PortletScheduler job: portletScheduler) {  %>
		<br>
		<liferay-ui:message key="<%=job.getJobName() %>"></liferay-ui:message> 
		<% } %>
</div>


