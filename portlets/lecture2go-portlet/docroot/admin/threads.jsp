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
	List<SchedulerEntry> scheduledJobs = PortletScheduler.ListSchedulerEntries(portletDisplay.getRootPortletId());
	List<PortletScheduler> portletScheduler = PortletScheduler.ListSchedulers();
%>
 
<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/jobs.jsp" /></portlet:renderURL>

<portlet:actionURL name="startJob" var="startJobURL"></portlet:actionURL>
<portlet:actionURL name="stopJob" var="stopJobURL"></portlet:actionURL>
<portlet:actionURL name="resumeJob" var="resumeJobURL"></portlet:actionURL>
<portlet:actionURL name="pauseJob" var="pauseJobURL"></portlet:actionURL>
<portlet:actionURL name="updateJob" var="updateJobURL"></portlet:actionURL>
<portlet:actionURL name="removeJob" var="removeJobURL"></portlet:actionURL>
<portlet:actionURL name="removeAllJobs" var="removeAllJobsURL"></portlet:actionURL>

<liferay-portlet:resourceURL id="triggerVideohitlistThread" var="triggerVideohitlistThread" />

<div class="noresponsive">	       

<liferay-ui:message key="ScheduledJobs: die eigentlichen Quartz Jobs, nur sie haben ein SchedulerResponse mit Job-Status"></liferay-ui:message>
<%-- This list all unique schedulers --%>
<% 
    TriggerState state = null;
    String cron = "";
	for(PortletScheduler ps : portletScheduler) {  	
		state = SchedulerEngineHelperUtil.getJobState(ps.getJobName(), ps.getJobName(), StorageType.MEMORY_CLUSTERED);
		Trigger trigger = ps.getTrigger();
		if (trigger != null) cron = trigger.getTriggerContent().toString(); 
%>
		<liferay-ui:message key="<%= ps.getJobName() %>"></liferay-ui:message> 
		<liferay-ui:message key="<%= state.toString() %>"></liferay-ui:message> 
		<liferay-ui:message key="<%= cron %>"></liferay-ui:message> 

        
 
 
 <% 	if (state.equals(TriggerState.UNSCHEDULED) && scheduledJobs.isEmpty()) {	%>
 			<aui:form action="<%= startJobURL %>" name="<portlet:namespace />fm">         
				<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= ps.getJobName() %>'/>
				<aui:button type="submit" value="Start" ></aui:button>
			</aui:form>
		 <% } %>   
    	 <br>
		<liferay-ui:message key="SchedulerEntries: Liferays Scheduler Liste"></liferay-ui:message>
		<%-- This lists all added Entry instances  --%>
		<%  int iC = 0;

			for(SchedulerEntry job : scheduledJobs) { 
	  		String schedulerPanelId = "panel"+ String.valueOf(iC);
	   		iC++;  
   		 %>	
		<liferay-ui:panel title="<%= job.getEventListenerClass() %>" collapsible="true" id="<%= schedulerPanelId  %>"
						defaultState="open"
						extended="<%= false %>"
						persistState="<%= true %>">  
				<liferay-ui:message key="Mit Pause/Resume funktioniert die Standardsyntax über JobName"></liferay-ui:message>
				<aui:form action="<%= pauseJobURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= job.getEventListenerClass() %>'/>
					<aui:button type="submit" value="Pause" ></aui:button>
				</aui:form> 
				<aui:form action="<%= resumeJobURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= job.getEventListenerClass() %>'/>
					<aui:button type="submit" value="Resume" ></aui:button>
				</aui:form>  
				<liferay-ui:message key="Schedule/Unschedule funktioniert nur mit SchedulerEntry (hier funktioniert unregister nicht korrekt))"></liferay-ui:message>
				<aui:form action="<%= stopJobURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= job.getEventListenerClass() %>'/>
					<aui:button type="submit" value="Stop" ></aui:button>
				</aui:form>
				<aui:form action="<%= startJobURL %>" name="<portlet:namespace />fm">         
						<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= job.getEventListenerClass() %>'/>
						<aui:button type="submit" value="Start" ></aui:button>
				</aui:form>
				<liferay-ui:message key="Updated den Trigger(Timer) (noch nicht implentiert))"></liferay-ui:message>
				<aui:form action="<%= updateJobURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= job.getEventListenerClass() %>'/>
					<aui:button type="submit" value="Update" ></aui:button>
				</aui:form>
				<liferay-ui:message key="Delete Job, entfernt den Quartz Job vollständig, aber nicht den SchedulerEntry"></liferay-ui:message>
				<aui:form action="<%= removeJobURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= job.getEventListenerClass() %>'/>
					<aui:button type="submit" value="Remove" ></aui:button>
				</aui:form>
		</liferay-ui:panel>

	<% } %>
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


