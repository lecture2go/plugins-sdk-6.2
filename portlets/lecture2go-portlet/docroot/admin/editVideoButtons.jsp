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

<a href="<%=editURL.toString()%>">
   <span class="icon-large icon-pencil"></span>
</a>
		
<%if(v.getFilename().length()>0){
	if (v.getOpenAccess()==1){%>
		<a href="<%=lockURL.toString()%>">
		   <span class="icon-large icon-unlock"></span>
		</a>
	<%}else{%>
		 <a href="<%=unlockURL.toString()%>">
		    <span class="icon-large icon-lock"></span>
		 </a>
	<%}	
	
	if (v.getDownloadLink()==1){%>
		 <a href="<%=deactivateDowonloadURL.toString()%>">
		    <span class="icon-large icon-download-alt"></span>
		 </a>
	<%}else{%>
		 <a href="<%=activateDowonloadURL.toString()%>">
		    <span class="icon-large icon-download"></span>
		 </a>		
	<%}	
	if (SegmentLocalServiceUtil.getSegmentsByVideoId(v.getVideoId()).size()>0){%>
		 <a href="<%=segmentURL.toString()%>">
		    <span class="icon-large icon-comment"></span>
		 </a>			
	<%}else{%>
		<a href="<%=segmentURL.toString()%>">
		   <span class="icon-large icon-align-justify"></span>
		</a>	
	<%}	
}%>

<a href="<%=removeURL.toString()%>">
	<span class="icon-large icon-remove"></span>
</a>
