<%@include file="/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Video v = (Video) row.getObject();
	String primKey = String.valueOf(v.getPrimaryKey());
%>

<portlet:actionURL name="viewVideo" var="editURL">
	<portlet:param name="videoId" value="<%= primKey%>" />
</portlet:actionURL>

<portlet:actionURL name="removeVideo" var="removeURL">
	<portlet:param name="videoId" value='<%=""+v.getVideoId()%>' />
</portlet:actionURL>

<portlet:actionURL name="lockVideo" var="lockURL">
	<portlet:param name="videoId" value='<%=""+v.getVideoId()%>' />
</portlet:actionURL>

<portlet:actionURL name="unlockVideo" var="unlockURL">
	<portlet:param name="videoId" value='<%=""+v.getVideoId()%>' />
</portlet:actionURL>


<%if (v.getFilename().length()>0){
	if (v.getOpenAccess()==1){%>
		<liferay-ui:icon-menu cssClass="right">
			<liferay-ui:icon src="/lecture2go-portlet/img/lock_button.png" message="lock" url="<%=lockURL.toString()%>" />
		</liferay-ui:icon-menu>
	<%}else{%>
		<liferay-ui:icon-menu cssClass="right">
			<liferay-ui:icon src="/lecture2go-portlet/img/unlock_button.png" message="unlock" url="<%=unlockURL.toString()%>" />
		</liferay-ui:icon-menu>	
	<%}%>	
<%}%>

<liferay-ui:icon-menu cssClass="right">
	<liferay-ui:icon image="delete" message="Remove" url="<%=removeURL.toString()%>" />
</liferay-ui:icon-menu>
