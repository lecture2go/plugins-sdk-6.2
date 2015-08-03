<%@include file="/init.jsp"%>
<%@ page import="de.uhh.l2g.plugins.model.Institution" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="de.uhh.l2g.plugins.model.Host" %>
<%@ page import="de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil" %>
<%@ page import="de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil" %>
<%@ page import="de.uhh.l2g.plugins.service.HostLocalServiceUtil" %>
<%@ page import="de.uhh.l2g.plugins.service.permission.InstitutionPermission"%>
<%@ page import="de.uhh.l2g.plugins.service.permission.HostPermission"%>
<%@ page import="de.uhh.l2g.plugins.service.permission.InstitutionModelPermission"%>
<%@ page import="de.uhh.l2g.plugins.service.permission.InstitutionPortletPermission"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%!com.liferay.portal.kernel.dao.search.SearchContainer<Institution> searchInstitutionContainer = null;%>
<%!com.liferay.portal.kernel.dao.search.SearchContainer<Institution> searchSubInstitutionContainer = null;%>

<liferay-ui:error key="host-or-institution-error" message="host-or-institution-error"/>

<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></portlet:renderURL>
<liferay-portlet:renderURL varImpl="outerURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="innerURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></liferay-portlet:renderURL>

<portlet:actionURL name="addInstitution" var="addInstitutionURL"></portlet:actionURL>
<portlet:actionURL name="addSubInstitution" var="addSubInstitutionURL"></portlet:actionURL>
<portlet:actionURL name="updateInstitution" var="updateInstitutionURL"></portlet:actionURL>
<portlet:actionURL name="updateSubInstitution" var="updateSubInstitutionURL"></portlet:actionURL>
<portlet:actionURL name="addStreamingServer" var="addStreamingServerURL"></portlet:actionURL>
<portlet:actionURL name="deleteStreamingServer" var="deletetreamingServerURL"></portlet:actionURL>
<portlet:actionURL name="updateStreamingServer" var="updateStreamingServerURL"></portlet:actionURL>
<portlet:actionURL name="updateTopLevelInstitution" var="updateTopLevelInstitutionURL"></portlet:actionURL>

<%
long institutionId = Long.valueOf((Long) renderRequest.getAttribute("institutionId"));
long hostId = Long.valueOf((Long) renderRequest.getAttribute("hostId"));

long groupId = themeDisplay.getLayout().getGroupId();


PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("institutionId", institutionId+"");
portletURL.setParameter("hostId", hostId+"");

List<Institution> institutions = InstitutionLocalServiceUtil.getByGroupIdAndParent(groupId,1);
List<Host> hostList = HostLocalServiceUtil.getByGroupId(groupId);
Institution topLevel = InstitutionLocalServiceUtil.getTopLevelByGroupId(groupId);

for (int i = 0; i < institutions.size(); i++) {
	Institution curInstitution = (Institution) institutions.get(i);
	long curId = curInstitution.getInstitutionId();
}

long topParentId = topLevel.getPrimaryKey();
int maxOrder = 0;
//if (institutionId > 1) {
//	Institution selectedInstitution = InstitutionLocalServiceUtil.getById(institutionId);
//	maxOrder = selectedInstitution.getSort();
//}
//else{
	maxOrder = InstitutionLocalServiceUtil.getMaxSortByParentId(topLevel.getInstitutionId())+1;
//	}
%>

<%--Permission on portlet scope--%>
<c:if test='<%= InstitutionPortletPermission.contains(permissionChecker, groupId, "ADD_INSTITUTIONS") %>'>
	<liferay-ui:panel title="Add Institution" collapsible="true" id="institutionSettings"
					defaultState="open"
					extended="<%= false %>"
					persistState="<%= true %>">
	<aui:form action="<%= addInstitutionURL %>" name="<portlet:namespace />fm">

			<aui:fieldset>
				<aui:input name="institution" label="Name" required="true" inlineField="true"/>
	            <aui:select name="serverselect" id="selecthost" label="Streaming Server" inlineField="true">
				<%
						for(Host host : hostList){
				%>
						<aui:option label="<%= host.getName() %>" value="<%= host.getHostId() %>"></aui:option>
				<% } %>
	            </aui:select>
	            <aui:input name="order" label="Order" inlineField="true" value='<%= maxOrder %>'/>
	            <aui:input name='institutionId' type='hidden' inlineField="true" value='<%= ParamUtil.getString(renderRequest, "institutionId") %>'/>
	            <aui:input name='parent' type='hidden' inlineField="true" value='<%= topParentId %>'/>
				<aui:button type="submit" value="Add" ></aui:button>
	<%-- 			<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button> --%>
	        </aui:fieldset>
	</aui:form>
	</liferay-ui:panel>
</c:if>

<c:if test='<%= InstitutionPortletPermission.contains(permissionChecker, groupId, "VIEW_HOSTS") %>'>
	<c:if test='<%= InstitutionPortletPermission.contains(permissionChecker, groupId, "ADD_HOSTS") %>'>
	       <liferay-ui:panel title="Streaming Server Options" collapsible="true" id="streamingServerSettings"
			    	defaultState="open"
			    	extended="<%= false %>"
			    	persistState="<%= true %>">
					<aui:form action="<%= updateStreamingServerURL %>" name="<portlet:namespace />fm" inlineLabel="true">
					<aui:button-row>
			 	    <aui:fieldset column="true">
						<aui:input label="StreamingServer Name" name="name" required="true" inlineField="true"></aui:input>
			 	        <aui:input label="Streaming Server Domain or IP" name="ip" inlineField="true"></aui:input>
			 	        <aui:input label="HTTP Protocol" name="protocol" inlineField="true"></aui:input>
			 	        <aui:input name='hostId' type='hidden' inlineField="true" value='<%= ParamUtil.getString(renderRequest, "hostId") %>'/>
			 	        <aui:button type="submit"></aui:button>
						<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
			 	    </aui:fieldset>
			 	    </aui:button-row>
					</aui:form>
			</liferay-ui:panel>
	</c:if>
</c:if>

<%--Permission for setting permissions regarding concrete entity--%>
<c:if test='<%= InstitutionPortletPermission.contains(permissionChecker, groupId, "PERMISSIONS") %>'>
	<liferay-security:permissionsURL
	    modelResource="<%= Institution.class.getName() %>"
	    modelResourceDescription="<%= topLevel.getName() %>"
	    resourcePrimKey="<%= String.valueOf(topLevel.getInstitutionId()) %>"
	    var="permissionsURL" />

	<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
</c:if>
<%--Permission regarding concrete instance of element, namely TopLevelInstitution --%>
<c:if test='<%= InstitutionPermission.contains(permissionChecker, institutionId, "EDIT_ROOT_INSTITUTION") %>'>
	<liferay-ui:panel title="Top Level Institution" collapsible="true" id="topLevelInstitutionSettings"
					defaultState="closed"
					extended="<%= false %>"
					persistState="<%= true %>">
	<aui:form action="<%= updateTopLevelInstitutionURL %>" name="<portlet:namespace />fm">
		<aui:fieldset>
				<aui:input name="topLevelInstitution" label="Top Level Institution" required="true" inlineField="true" />
				<aui:input name='topLevelInstitutionId' type='hidden' />
				<aui:button type="submit"></aui:button>
				<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
		</aui:fieldset>
	</aui:form>
	</liferay-ui:panel>
</c:if>


<c:if test='<%= InstitutionPortletPermission.contains(permissionChecker, groupId, "VIEW_ALL_INSTITUTIONS") %>'>
<%--<liferay-ui:panel title="List of Institutions" collapsible="false" id="outerList"> --%>
<liferay-ui:search-container searchContainer="<%= searchInstitutionContainer %>"
curParam ="curOuter"
orderByType="asc"
emptyResultsMessage="there-are-no-institutions"
delta="20"
iteratorURL="<%= outerURL %>"
deltaConfigurable="true">
    <liferay-ui:search-container-results
        results="<%=InstitutionLocalServiceUtil.getByGroupIdAndParent(groupId, topParentId  , searchContainer.getStart(), searchContainer.getEnd())%>"
        total="<%=InstitutionLocalServiceUtil.getByGroupIdAndParentCount(groupId, topParentId)%>" />

    <liferay-ui:search-container-row
        className="de.uhh.l2g.plugins.model.Institution" modelVar="institution"
        keyProperty="institutionId"  escapedModel="<%= false %>" indexVar="i">

        <%
 			ResultRow container_row = (ResultRow)request.getAttribute("curOuter");
 			Institution institution_row = (Institution)row.getObject();
 			long institution_id = institution_row.getInstitutionId();
 			String id_row = "Inst"+String.valueOf(institution_row.getInstitutionId());
 			String curParam_row = "curInner"+String.valueOf(institution_row.getInstitutionId());
 			long outerOrder = institution_row.getSort();
 			Host curHost = Institution_HostLocalServiceUtil.getByGroupIdAndInstitutionId(groupId, institution_row.getInstitutionId());
 			int subInstitutionMax = InstitutionLocalServiceUtil.getMaxSortByParentId(institution_id)+1;


 		%>

 		 <liferay-ui:search-container-row-parameter name="rowId" value="<%= institution_row.toString() %>"/>

        <liferay-ui:search-container-column-text name="Institution">

		<portlet:actionURL name="deleteInstitution" var="deleteInstitutionURL">
			<portlet:param name="outerListInstitutionId" value='<%= (new Long(institution.getPrimaryKey())).toString() %>' />
			<portlet:param name="institutionId" value='<%= (new Long(institutionId)).toString() %>' />
			<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>
		</portlet:actionURL>

 		<aui:form action="<%= updateInstitutionURL %>" name="<portlet:namespace />fm">
 			<aui:fieldset>
				<aui:input name="outerListInstitution" label="Institution Name" inlineField="true" value = "<%= institution.getName() %>" />
				<aui:input name="outerListOrder" label="Order" inlineField="true" value='<%= institution.getSort() %>'/>
				<aui:input name="outerListStreamer" label="Streamer" inlineField="true" value = "<%= curHost.getName() %>" disabled="true"/>
				<aui:input name="outerListInstitutionId" type='hidden' inlineField="true" value = "<%= institution.getPrimaryKey() %>"/>
				<aui:input name="outerListHostId" type='hidden' inlineField="true" value = "<%= curHost.getPrimaryKey() %>"/>

				<aui:input name='institutionId' type='hidden' inlineField="true" value='<%= ParamUtil.getString(renderRequest, "institutionId") %>'/>

				<aui:button type="submit"></aui:button>
				<c:if test='<%= InstitutionPortletPermission.contains(permissionChecker, groupId, "DELETE_INSTITUTIONS") %>'>
					<aui:button name="delete" value="Löschen" type="button" href="<%=deleteInstitutionURL.toString() %>" />
				</c:if>
			</aui:fieldset>
 		</aui:form>
		<liferay-ui:panel
				defaultState="closed"
				extended="<%= false %>"
				id="<%= id_row %>"
				persistState="<%= true %>"
				title="SubInstitutions" >
			<aui:form action="<%= addSubInstitutionURL %>" name="<portlet:namespace />fm">
	 			<aui:fieldset>
					<aui:input name="subInstitution" label="SubInstitution Name" inlineField="true" />
					<aui:input name="subInstitutionOrder" label="Order" inlineField="true" value='<%= subInstitutionMax  %>'/>
					<aui:button type="submit" value="Add"></aui:button>
				</aui:fieldset>
 			</aui:form>

			<liferay-ui:search-container searchContainer="<%= searchSubInstitutionContainer %>"
				curParam ="<%=curParam_row%>"
				orderByType="asc"
				emptyResultsMessage="there-are-no-institutions"
				iteratorURL="<%= innerURL %>"
				delta="20"
				deltaConfigurable="true" >


				<liferay-ui:search-container-results
        			results="<%=InstitutionLocalServiceUtil.getByGroupIdAndParent(groupId, institution_id, searchContainer.getStart(), searchContainer.getEnd())%>"
        			total="<%=InstitutionLocalServiceUtil.getByGroupIdAndParentCount(groupId, institution_id)%>" />

				<liferay-ui:search-container-row
				className="de.uhh.l2g.plugins.model.Institution" modelVar="subInstitution" rowVar="thisRow"
				keyProperty="institutionId"  escapedModel="<%= false %>" indexVar="j">

        			<liferay-ui:search-container-column-text name="Institution" >
	        			<portlet:actionURL name="deleteSubInstitution" var="deleteSubInstitutionURL">
		 					<portlet:param name="innerListInstitutionId" value='<%= (new Long(subInstitution.getInstitutionId())).toString() %>' />
		 					<portlet:param name="institutionId" value='<%= (new Long(institutionId)).toString() %>' />
							<portlet:param name="backURL" value="<%=String.valueOf(portletURL) %>"/>
						</portlet:actionURL>
						<aui:form action="<%= updateSubInstitutionURL %>" name="<portlet:namespace />fm">
							<aui:fieldset>
								<aui:input name="institution" label="Institution Name" inlineField="true" value = "<%= subInstitution.getName() %>" />
								<aui:input cssClass="smallInput" name="innerListOrder" label="Order" inlineField="true" value='<%= subInstitution.getSort() %>'/>
								<aui:button type="submit"></aui:button>
								<aui:button name="delete" value="Löschen" type="button" href="<%=deleteInstitutionURL.toString() %>" />
							</aui:fieldset>
						</aui:form>
        			</liferay-ui:search-container-column-text>

        		</liferay-ui:search-container-row>
        	<liferay-ui:search-iterator searchContainer="<%= searchSubInstitutionContainer %>" />
			</liferay-ui:search-container>

		</liferay-ui:panel>
		</liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator searchContainer="<%= searchInstitutionContainer %>" />
</liferay-ui:search-container>
<%-- </liferay-ui:panel> --%>
</c:if>