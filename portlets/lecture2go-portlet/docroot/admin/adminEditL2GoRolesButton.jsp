<%@include file="/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	User u = (User) row.getObject();
	String primKey = String.valueOf(u.getPrimaryKey());
%>

<portlet:actionURL name="viewRole" var="editURL">
	<portlet:param name="userId" value="<%= primKey %>" />
</portlet:actionURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>" />
</liferay-ui:icon-menu>