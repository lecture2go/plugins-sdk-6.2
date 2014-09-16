<%!com.liferay.portal.kernel.dao.search.SearchContainer<User> searchContainer = null;%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Collections"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@ page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.model.Portlet"%>
<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.model.Role"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserGroupRoleServiceUtil"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.PortletLocalServiceUtil"%>

<%@ page import="javax.portlet.PortletURL"%>

<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="de.uhh.l2g.plugins.model.Facility"%>
<%@ page import="de.uhh.l2g.plugins.admin.AdminUserManagement"%>

<%@page import="de.uhh.l2g.plugins.service.ProducerLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.FacilityLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.model.Lectureseries"%>
<%@page import="de.uhh.l2g.plugins.model.Producer"%>

<portlet:defineObjects />
<liferay-theme:defineObjects/>