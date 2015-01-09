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
	<portlet:param name="videoId" value="<%= primKey%>" />
</portlet:actionURL>

<portlet:actionURL name="lockVideo" var="lockURL">
	<portlet:param name="videoId" value="<%= primKey%>" />
</portlet:actionURL>

<portlet:actionURL name="unlockVideo" var="unlockURL">
	<portlet:param name="videoId" value="<%= primKey%>" />
</portlet:actionURL>

<portlet:actionURL name="activateDownload" var="activateDowonloadURL">
	<portlet:param name="videoId" value="<%= primKey%>" />
</portlet:actionURL>

<portlet:actionURL name="deactivateDownload" var="deactivateDowonloadURL">
	<portlet:param name="videoId" value="<%= primKey%>" />
</portlet:actionURL>

<portlet:actionURL name="addSegment" var="segmentURL">
		<portlet:param name="videoId" value="<%= primKey%>" />
</portlet:actionURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="edit" message="" url="<%= editURL.toString() %>" />
</liferay-ui:icon-menu>   

<%if(v.getFilename().length()>0){
	if (v.getOpenAccess()==1){%>
		<liferay-ui:icon-menu cssClass="right">
			<liferay-ui:icon src="/lecture2go-portlet/img/unlock_button.png" message="" url="<%=lockURL.toString()%>" />
		</liferay-ui:icon-menu>
	<%}else{%>
		<liferay-ui:icon-menu cssClass="right">
			<liferay-ui:icon src="/lecture2go-portlet/img/lock_button.png" message="" url="<%=unlockURL.toString()%>" />
		</liferay-ui:icon-menu>	
	<%}	
	
	if (v.getDownloadLink()==1){%>
		<liferay-ui:icon-menu cssClass="right">
			<liferay-ui:icon src="/lecture2go-portlet/img/dl_aktiv.png" message="" url="<%=deactivateDowonloadURL.toString()%>" />
		</liferay-ui:icon-menu>
	<%}else{%>
		<liferay-ui:icon-menu cssClass="right">
			<liferay-ui:icon src="/lecture2go-portlet/img/dl_inaktiv.png" message="" url="<%=activateDowonloadURL.toString()%>" />
		</liferay-ui:icon-menu>	
	<%}	
	if (SegmentLocalServiceUtil.getSegmentsByVideoId(v.getVideoId()).size()>0){%>
		<liferay-ui:icon-menu cssClass="right">
			<liferay-ui:icon src="/lecture2go-portlet/img/segmentOn.png" message="" url="<%=segmentURL.toString()%>" />
		</liferay-ui:icon-menu>
	<%}else{%>
		<liferay-ui:icon-menu cssClass="right">
			<liferay-ui:icon src="/lecture2go-portlet/img/segmentOff.png" message="" url="<%=segmentURL.toString()%>" />
		</liferay-ui:icon-menu>	
	<%}	
}%>

<liferay-ui:icon-menu cssClass="right">
	<liferay-ui:icon src="/lecture2go-portlet/img/delete.png" message="" url="<%=removeURL.toString()%>" />
</liferay-ui:icon-menu>
