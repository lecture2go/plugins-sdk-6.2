<%@include file="/init.jsp" %>
<%@ page import="de.uhh.l2g.plugins.model.VideoStatistic" %>
<%@ page import="de.uhh.l2g.plugins.service.VideoStatisticLocalServiceUtil" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%
//Scope GroupId

long groupId = themeDisplay.getLayout().getGroupId();
//Company Id of Application
long companyId = themeDisplay.getLayout().getCompanyId();

	List<VideoStatistic> statisticEntries = VideoStatisticLocalServiceUtil.getByCompanyIdAndGroupId(companyId, groupId);

%>
 
<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/statistic.jsp" /></portlet:renderURL>

<liferay-ui:success key="request_processed" message="request_processed"/>

<portlet:actionURL name="doSomething" var="somethingURL"></portlet:actionURL>





