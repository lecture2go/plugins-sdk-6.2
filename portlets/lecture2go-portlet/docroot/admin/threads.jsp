<%@include file="/init.jsp"%>

<%

%>
 
<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/threads.jsp" /></portlet:renderURL>

<portlet:actionURL name="startThread" var="startThreadURL"></portlet:actionURL>
<portlet:actionURL name="stopThread" var="stopThreadURL"></portlet:actionURL>
	       
	 <br>  
	  <br>
	   <br>
	    <br>
	     <br>
	 
<%  %>	
	<liferay-ui:panel title="Add Institution" collapsible="true" id="institutionSettings"
						defaultState="open"
						extended="<%= false %>"
						persistState="<%= true %>">     
				<aui:form action="<%= startThreadURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= "de.uhh.l2g.plugins.util.StatisticsScheduler" %>'/>
					<aui:button type="submit" value="Start" ></aui:button>
				</aui:form>
				<aui:form action="<%= stopThreadURL %>" name="<portlet:namespace />fm">         
					<aui:input name='schedulerName' type='hidden' inlineField="true" value='<%= "de.uhh.l2g.plugins.util.StatisticsScheduler" %>'/>
					<aui:button type="submit" value="Stop" ></aui:button>
				</aui:form>
	</liferay-ui:panel>
