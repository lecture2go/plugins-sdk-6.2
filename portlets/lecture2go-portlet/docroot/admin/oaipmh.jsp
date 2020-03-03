<%@include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
 
<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/oaipmh.jsp" /></portlet:renderURL>

<portlet:actionURL name="republishAll" var="republishAllURL"></portlet:actionURL>
<portlet:actionURL name="fixMissingMetadataForVideoFromRelatedLectureseries" var="fixMissingMetadataForVideoFromRelatedLectureseriesURL"></portlet:actionURL>


<div class="noresponsive">	  
	<label class="edit-video-lable"><liferay-ui:message key="oaipmh"/></label>

	<aui:form action="${republishAllURL}" name="republishAll">
		<liferay-ui:message key="oai-pmh-republish-all"/>
		<aui:button type="submit" value="Start"></aui:button>
	</aui:form>
	
	<aui:form action="${fixMissingMetadataForVideoFromRelatedLectureseriesURL}" name="fixMissingMetadataForVideoFromRelatedLectureseries">
		<liferay-ui:message key="fix-missing-metadata-for-videos"/>
		<aui:button type="submit" value="Start"></aui:button>
	</aui:form>
</div>