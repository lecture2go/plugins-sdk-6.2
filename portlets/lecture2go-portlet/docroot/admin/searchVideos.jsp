<%@include file="/init.jsp"%>

<%@page import="de.uhh.l2g.plugins.search.VideoSearchContainer"%>
<%@page import="de.uhh.l2g.plugins.search.VideoDisplayTerms"%>

<%
	VideoSearchContainer searchContainer = (VideoSearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	VideoDisplayTerms displayTerms = (VideoDisplayTerms)searchContainer.getDisplayTerms();
%>

<style>
<!--
#toggle_id_video_searchtoggleAdvanced {
    display: none;
}

.form-search .input-append .advanced-search .search-query {
    padding-left: 10px;
    width: 160px;
}

.taglib-search-toggle {
    margin-top: -17px;
}
-->
</style>
<liferay-ui:search-toggle buttonLabel="search" displayTerms="<%= displayTerms %>" id="toggle_id_video_search">
</liferay-ui:search-toggle>

