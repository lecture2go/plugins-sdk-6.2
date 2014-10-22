<%@include file="/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Video v = (Video) row.getObject();
	String primKey = String.valueOf(v.getPrimaryKey());
%>

<portlet:actionURL name="viewVideo" var="editURL">
	<portlet:param name="videoId" value="<%= primKey%>" />
</portlet:actionURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>" />
</liferay-ui:icon-menu>   