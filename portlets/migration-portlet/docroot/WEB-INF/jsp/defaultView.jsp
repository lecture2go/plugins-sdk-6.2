<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<%@ include file="/WEB-INF/jsp/include.jsp" %>

<h3><liferay-ui:message key="migrationPortlet" /></h3>

<pre>
LF52 User Entries Size.....: <c:out value="${userEntrieSize}" />
LF52 Contact Entrie Size........: <c:out value="${contactEntrieSize}" />
LF52 Office Entries Size.....: <c:out value="${officeEntrieSize}" />
LF52 LectureSeries Entries Size.....: <c:out value="${legacyLectureSeriesEntrieSize}" />
LF52 Metadata Entries Size.....: <c:out value="${metadataEntrieSize}" />
LF52 Segment Entries Size.....: <c:out value="${segmentEntrieSize}" />
</pre>

<p><liferay-ui:message key="migrationActions" /></p>


<portlet:actionURL var="testExternalDBEntitiesUrl">
	<portlet:param name="action" value="testExternalDBEntities" />
</portlet:actionURL>

<portlet:actionURL var="executeUserMigrationUrl">
	<portlet:param name="action" value="migrateUser" />
</portlet:actionURL>

<portlet:actionURL var="executeSegmentMigrationUrl">
	<portlet:param name="action" value="migrateSegments" />
</portlet:actionURL>


<p><a href="<c:out value="${testExternalDBEntitiesUrl}" />"><liferay-ui:message key="testExternalDBEntities" /></a></p>

<p><a href="<c:out value="${executeUserMigrationUrl}" />"><liferay-ui:message key="migrateUser" /></a></p>

<p><a href="<c:out value="${executeSegmentMigrationUrl}" />"><liferay-ui:message key="migrateSegments" /></a></p>



