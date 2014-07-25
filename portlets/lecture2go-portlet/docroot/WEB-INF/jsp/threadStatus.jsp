<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<portlet:defineObjects />

<%@ include file="includeInternationalisation.jsp"%>

${threadisupdatedevery}
<c:choose>
	<c:when test="${model.interrupted}">
		<b>${stopped}</b>
	</c:when>
	<c:otherwise>
		<b>${started} ${model.time} ${hours}</b>
	</c:otherwise>
</c:choose>

<br />
<br />

<c:choose>
	<c:when test="${model.interrupted}">
		<portlet:actionURL var="threadAction">
			<portlet:param name="state" value="1" />
		</portlet:actionURL>
		<aui:form action="<%=threadAction%>" method="post">
			<aui:button type="submit" value="${start}"  />
		</aui:form>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="threadAction">
			<portlet:param name="state" value="0" />
		</portlet:actionURL>
		<aui:form action="<%=threadAction%>" method="post">
			<aui:button type="submit" value="${stop}"  />
		</aui:form>
	</c:otherwise>
</c:choose>

