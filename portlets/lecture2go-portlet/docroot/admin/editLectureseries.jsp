<%@include file="/init.jsp"%>
<jsp:useBean id="reqLectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />

<portlet:renderURL var="cancelURL"><portlet:param name="jspPage" value="/admin/lectureSeriesList.jsp" /></portlet:renderURL>
<portlet:actionURL name="editLectureseries" var="editURL"><portlet:param name="lectureseriesId" value='<%=""+reqLectureseries.getLectureseriesId()%>'/></portlet:actionURL>
<portlet:actionURL name="deleteURL" var="deleteURL"><portlet:param name="lectureseriesId" value='<%=""+reqLectureseries.getLectureseriesId()%>'/></portlet:actionURL>

<aui:form action="<%= editURL.toString() %>" method="post">
	<aui:fieldset helpMessage="test" column="true" label='<%=""+reqLectureseries.getName()%>'>
		<aui:layout>
			<aui:button-row>
	      		<aui:button type="submit"/>
	      		<aui:button type="cancel" value="cancel" onClick="<%= cancelURL.toString() %>" />
	    	</aui:button-row>
	    	<liferay-ui:icon-menu cssClass="right">
				<liferay-ui:icon image="delete" message="Delete" url="<%= deleteURL.toString() %>" />
			</liferay-ui:icon-menu>

		</aui:layout>
	</aui:fieldset>
</aui:form>