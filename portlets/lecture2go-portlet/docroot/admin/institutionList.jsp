<%@include file="/init.jsp"%>
<%@ page import="de.uhh.l2g.plugins.model.Institution" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="de.uhh.l2g.plugins.model.Host" %>
<%@ page import="de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil" %>
<%@ page import="de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil" %>
<%@ page import="de.uhh.l2g.plugins.service.HostLocalServiceUtil" %>
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
<portlet:actionURL name="updateRootInstitution" var="updateRootInstitutionURL"></portlet:actionURL>

<%
//Variables required for Permissions

//On Portlet Level:
//portlet name like ind ResourcePermission Table: Resource Name != Portlet Name from portlet.xml
String institutionPortletName = portletDisplay.getRootPortletId();

//Scope(PrimKey): company wide, scope group or instance
//Scope GroupId
long groupId = scopeGroupId;
//long groupId = themeDisplay.getLayout().getGroupId();
//Company Id of Application
String companyId = String.valueOf(themeDisplay.getLayout().getCompanyId());

//Portlet Instance Id (can be string)
String institutionPortletPrimKey = portletDisplay.getResourcePK();
//On Model Level:
String portletModel = "de.uhh.l2g.plugins.model";
//On Entity Level:
String institutionModel = "de.uhh.l2g.plugins.model.Institution";

//Definded Action Ids
String actionId = "VIEW_ALL_INSTITUTIONS";
%>

<%--START: DEBUG INFO--%>
Do you have the individual <i><liferay-ui:message key='<%= "action." + actionId %>' /></i> permission for this portlet (<%= groupId+" "+institutionPortletName+" "+institutionPortletPrimKey %>)?

<strong>

<c:choose>
	<c:when test="<%= permissionChecker.hasPermission(groupId, institutionPortletName, institutionPortletPrimKey, actionId) %>">
		Yes
	</c:when>
	<c:otherwise>
		No
	</c:otherwise>
</c:choose>

</strong>
</br>
Do you have the group based <i><liferay-ui:message key='<%= "action." + actionId %>' /></i> permission for this portlet (<%= groupId+" "+institutionPortletName+" "+groupId %>)?

<strong>

<c:choose>
	<c:when test="<%= permissionChecker.hasPermission(groupId, institutionPortletName, groupId, actionId) %>">
		Yes
	</c:when>
	<c:otherwise>
		No
	</c:otherwise>
</c:choose>

</strong>
</br>
Do you have the global <i><liferay-ui:message key='<%= "action." + actionId %>' /></i> permission for this portlet (<%= groupId+" "+institutionPortletName+" "+ companyId %>)?

<strong>

<c:choose>
	<c:when test="<%= permissionChecker.hasPermission(groupId, institutionPortletName, companyId, actionId) %>">
		Yes
	</c:when>
	<c:otherwise>
		No
	</c:otherwise>
</c:choose>

</strong>
</br>

<%--END: DEBUG INFO--%>
<%
//Current Selection in Request Object
long institutionId = Long.valueOf((Long) renderRequest.getAttribute("institutionId"));
long hostId = Long.valueOf((Long) renderRequest.getAttribute("hostId"));

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("institutionId", institutionId+"");
portletURL.setParameter("hostId", hostId+"");

//Get Top Level institution of current scope
Institution root = InstitutionLocalServiceUtil.getRootByGroupId(groupId);
long rootId = root.getPrimaryKey();

//Get First Level institution List
List<Institution> institutions = InstitutionLocalServiceUtil.getByGroupIdAndParent(groupId,rootId);

List<Host> hostList = HostLocalServiceUtil.getByGroupId(groupId);

//Sort preset for first level Institutions
int maxOrder = InstitutionLocalServiceUtil.getMaxSortByParentId(rootId)+1;

%>

<%--Permission Settings only available to authorized Roles on Company Level--%>
<c:if test='<%=  permissionChecker.hasPermission(groupId, institutionPortletName, companyId, "PERMISSIONS") %>'>
<%-- Permission for setting permissions regarding model on group/entity scope--%>

<%--Global Permission for setting permissions regarding model on group scope--%>
Company Institution Permissions:
	<liferay-security:permissionsURL
	    modelResource="<%= portletModel %>"
	    modelResourceDescription="Model Global"
	    resourcePrimKey="<%= String.valueOf(companyId) %>"
	    var="globalmodelpermissionsURL" />

	<liferay-ui:icon image="permissions" url="<%= globalmodelpermissionsURL %>" />
<%--Permission for setting permissions regarding model on group scope--%>
Institution Permissions:
	<liferay-security:permissionsURL
	    modelResource="<%= portletModel %>"
	    modelResourceDescription="Model Site"
	    resourcePrimKey="<%= String.valueOf(groupId) %>"
	    var="modelpermissionsURL" />

	<liferay-ui:icon image="permissions" url="<%= modelpermissionsURL %>" />

<%--Permission for setting permissions regarding concrete entity Root--%>
Root Institution Permissions:
		<liferay-security:permissionsURL
	    modelResource="<%= Institution.class.getName() %>"
	    modelResourceDescription="<%= root.getName() %>"
	    resourcePrimKey="<%= String.valueOf(rootId) %>"
	    var="rootentitypermissionsURL" />

	<liferay-ui:icon image="permissions" url="<%= rootentitypermissionsURL %>" />
</c:if>

<%-- Permission on Portlet Scope --%>
<c:if test='<%= permissionChecker.hasPermission(groupId, institutionPortletName, institutionPortletPrimKey, "ADD_INSTITUTIONS") %>'>
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
	            <aui:input name='parent' type='hidden' inlineField="true" value='<%= rootId %>'/>
				<aui:button type="submit" value="Add" ></aui:button>
	<%-- 			<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button> --%>
	        </aui:fieldset>
	</aui:form>
	</liferay-ui:panel>
</c:if>

<c:if test='<%= permissionChecker.hasPermission(groupId, institutionPortletName, institutionPortletPrimKey, "VIEW_HOSTS") %>'>
	<c:if  test='<%= permissionChecker.hasPermission(groupId, institutionModel, groupId, "ADD_HOSTS") %>'>
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


<%--Permission regarding concrete instance of element, namely RootInstitution --%>
<c:if  test='<%= permissionChecker.hasPermission(groupId, institutionModel, groupId, "EDIT_ROOT_INSTITUTION") %>'>
	<liferay-ui:panel title="Top Level Institution" collapsible="true" id="rootInstitutionSettings"
					defaultState="closed"
					extended="<%= false %>"
					persistState="<%= true %>">
	<aui:form action="<%= updateRootInstitutionURL %>" name="<portlet:namespace />fm">
		<aui:fieldset>
				<aui:input name="rootInstitution" label="Top Level Institution" required="true" inlineField="true"  value = '<%= root.getName() %>'/>
				<aui:input name="rootInsitutionId" type='hidden' inlineField="true" value = '<%= root.getPrimaryKey() %>'/>
				<aui:button type="submit"></aui:button>
				<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
		</aui:fieldset>
	</aui:form>
	</liferay-ui:panel>
</c:if>


<%--<liferay-ui:panel title="List of Institutions" collapsible="false" id="outerList"> --%>
<liferay-ui:search-container searchContainer="<%= searchInstitutionContainer %>"
curParam ="curOuter"
orderByType="asc"
emptyResultsMessage="there-are-no-institutions"
delta="20"
iteratorURL="<%= outerURL %>"
deltaConfigurable="true">
    <liferay-ui:search-container-results
        results="<%=InstitutionLocalServiceUtil.getByGroupIdAndParent(groupId, rootId  , searchContainer.getStart(), searchContainer.getEnd())%>"
        total="<%=InstitutionLocalServiceUtil.getByGroupIdAndParentCount(groupId, rootId)%>" />

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
				<c:if  test='<%= permissionChecker.hasPermission(groupId, institutionModel, groupId, "DELETE_INSTITUTIONS") %>'>
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
								<aui:input name="innerListInstitution" label="Institution Name" inlineField="true" value = "<%= subInstitution.getName() %>" />
								<aui:input cssClass="smallInput" name="innerListOrder" label="Order" inlineField="true" value='<%= subInstitution.getSort() %>'/>
								<aui:input name="innerListInstitutionId" type='hidden' inlineField="true" value = "<%= subInstitution.getPrimaryKey() %>"/>
								<aui:button type="submit"></aui:button>
								<aui:button name="delete" value="Löschen" type="button" href="<%=deleteSubInstitutionURL.toString() %>" />
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
