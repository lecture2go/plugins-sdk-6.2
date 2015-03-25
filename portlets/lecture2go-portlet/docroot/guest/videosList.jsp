<%@include file="/init.jsp"%>

<portlet:actionURL name="viewOpenAccessLectureSeries" var="viewOpenAccessLectureSeriesURL"></portlet:actionURL>

<aui:form action="<%=viewOpenAccessLectureSeriesURL%>" commandName="model">
	<aui:button type="submit" onclick="<portlet:namespace />extractCodeFromEditor()"/>
</aui:form>