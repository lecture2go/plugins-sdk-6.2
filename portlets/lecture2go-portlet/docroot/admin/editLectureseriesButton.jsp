<%@include file="/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Lectureseries l = (Lectureseries) row.getObject();
	String primKey = String.valueOf(l.getPrimaryKey());
%>



<portlet:actionURL name="viewLectureseries" var="editURL">
	<portlet:param name="lectureseriesId" value="<%= primKey %>" />
</portlet:actionURL>



<liferay-ui:icon-menu>
	<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>" />
</liferay-ui:icon-menu>   