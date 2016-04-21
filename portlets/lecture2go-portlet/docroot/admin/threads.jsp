<%@include file="/init.jsp" %>
<%@ page import="de.uhh.l2g.plugins.util.PortletScheduler" %>
<%@ page import="com.liferay.portal.kernel.scheduler.SchedulerEntry" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%
	String actionURL = "";
	List<SchedulerEntry> scheduledJobs = PortletScheduler.ListSchedulerEntries(portletDisplay.getRootPortletId());
	List<PortletScheduler> portletScheduler = PortletScheduler.ListSchedulers();
%>
 
<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/threads.jsp" /></portlet:renderURL>

<portlet:actionURL name="startThread" var="startThreadURL"></portlet:actionURL>
<portlet:actionURL name="stopThread" var="stopThreadURL"></portlet:actionURL>
<portlet:actionURL name="killAllThreads" var="killAllThreadsURL"></portlet:actionURL>

<liferay-portlet:resourceURL id="triggerVideohitlistThread" var="triggerVideohitlistThread" />

<div class="noresponsive">	       
	<%  int iC = 0;
		for(SchedulerEntry job : scheduledJobs) { 
	    	String schedulerPanelId = "panel"+ String.valueOf(iC);
 	    	iC++;
    %>	
		<liferay-ui:panel title="<%= job.getEventListenerClass() %>" collapsible="true" id="<%= schedulerPanelId  %>" defaultState="open" extended="false" persistState="true">     
			<aui:form action="<%= startThreadURL %>" name="<portlet:namespace />fm">         
				<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= job.getEventListenerClass() %>'/>
				<aui:button type="submit" value="Start" ></aui:button>
			</aui:form>
			<br/>
			<aui:form action="<%= stopThreadURL %>" name="<portlet:namespace />fm">         
				<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= job.getEventListenerClass() %>'/>
				<aui:button type="submit" value="Stop" ></aui:button>
			</aui:form>
		</liferay-ui:panel>
	<% 
		} 
	%>
	<!-- 
	<br/>
	<br/>
	<br/>
	
<aui:fieldset column="false" label="video-hit-list-thread">
	<aui:layout>
		<aui:form action="" commandName="model" name="metadata">
			<aui:button-row>
				<aui:button value="trigger-videohitlist-thread" onclick="triggerVideohitlistThread();"/>
			</aui:button-row>
		</aui:form>
	</aui:layout>
</aui:fieldset>
	
</div>

<script type="text/javascript">
function triggerVideohitlistThread(){
	AUI().use('aui-io-request', 'aui-node',
			function(A){
				A.io.request('', {
			 	dataType: 'json',
			 	method: 'POST',
				 	//send data to server
				 	//data: { },
				 	//get server response
					on: {
						   success: function() {
						     var jsonResponse = this.get('responseData');
						   }
					}
				});	
			}
		);
}
</script>
-->