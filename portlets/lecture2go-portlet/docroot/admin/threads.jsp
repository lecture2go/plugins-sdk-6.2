<%@include file="/init.jsp"%>

 
<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/threads.jsp" /></portlet:renderURL>
 
<portlet:actionURL name="startThread" var="startThreadURL"></portlet:actionURL>
<portlet:actionURL name="stopThread" var="stopThreadURL"></portlet:actionURL>
<aui:button></aui:button>