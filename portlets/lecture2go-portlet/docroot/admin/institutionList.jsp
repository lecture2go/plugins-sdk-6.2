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
<%!com.liferay.portal.kernel.dao.search.SearchContainer<Host> searchHostContainer = null;%>

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
long companyId = themeDisplay.getLayout().getCompanyId();
String companyIdString = String.valueOf(companyId);

//Portlet Instance Id (can be string)
String institutionPortletPrimKey = portletDisplay.getResourcePK();
//On Model Level:
String portletModel = "de.uhh.l2g.plugins.model.Institution";
//On Entity Level:
String institutionModel = "de.uhh.l2g.plugins.model.Institution";

%>



<%--END: DEBUG INFO--%>
<%
//Current Selection in Request Object
long institutionId = Long.valueOf((Long) renderRequest.getAttribute("institutionId"));
long hostId = Long.valueOf((Long) renderRequest.getAttribute("hostId"));

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("institutionId", institutionId+"");
portletURL.setParameter("hostId", hostId+"");

String repDirectory = PropsUtil.get("lecture2go.media.repository");
//Get Top Level institution of current scope
Institution root = InstitutionLocalServiceUtil.getRootByGroupId(companyId, groupId);
long rootId = root.getInstitutionId();

//Get First Level institution List
List<Institution> institutions = InstitutionLocalServiceUtil.getByGroupIdAndParent(groupId,rootId);

//Get StreamingServers
List<Host> hostList = HostLocalServiceUtil.getByGroupId(groupId);
//System.out.println(hostList.toString());
//Get StreamingServer Defaults
Host defaultHost = HostLocalServiceUtil.getByDefault(companyId, groupId);

//Sort preset for first level Institutions
int maxOrder = InstitutionLocalServiceUtil.getMaxSortByParentId(rootId)+1;

%>

<%--Permission Settings only available to authorized Roles on Company Level--%>
<c:if test='<%=  permissionChecker.hasPermission(groupId, institutionPortletName, companyIdString, "PERMISSIONS") %>'>
<%-- Permission for setting permissions regarding model on group/entity scope--%>

<%--Global Permission for setting permissions regarding plugin on company scope--%>
Company Permissions:
	<liferay-security:permissionsURL
	    modelResource="<%= portletModel %>"
	    modelResourceDescription="Model Global"
	    resourcePrimKey="<%= companyIdString %>"
	    var="globalmodelpermissionsURL" />

	<liferay-ui:icon image="permissions" url="<%= globalmodelpermissionsURL %>" />
<%--Permission for setting permissions regarding plugin on group scope--%>
Company Institution Permissions:
	<liferay-security:permissionsURL
	    modelResource="<%= Institution.class.getName()  %>"
	    modelResourceDescription="Model Site"
	    resourcePrimKey="<%= String.valueOf(companyId) %>"
	    var="modelpermissionsURL" />

	<liferay-ui:icon image="permissions" url="<%= modelpermissionsURL %>" />

<%--Permission for setting permissions regarding institution model on group scope--%>
Group Institution Permissions:
	<liferay-security:permissionsURL
	    modelResource="<%= Institution.class.getName()  %>"
	    modelResourceDescription="Model Site"
	    resourcePrimKey="<%= String.valueOf(groupId) %>"
	    var="institutionmodelpermissionsURL" />

	<liferay-ui:icon image="permissions" url="<%= institutionmodelpermissionsURL %>" />
	
<%--Permission for setting permissions regarding concrete entity Root--%>
Root Institution Permissions:
		<liferay-security:permissionsURL
	    modelResource="<%= Institution.class.getName() %>"
	    modelResourceDescription="<%= root.getName() %>"
	    resourcePrimKey="<%= String.valueOf(rootId) %>"
	    var="rootentitypermissionsURL" />

	<liferay-ui:icon image="permissions" url="<%= rootentitypermissionsURL %>" />
</c:if>

<%--ADD INSTITUTION--%>

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
							if (host.getDefaultHost() > 0) {
				%>
							<aui:option label="Default" value="<%= host.getHostId() %>"></aui:option>
				<%			}
							else {
							%>
								<aui:option label="<%= host.getName() %>" value="<%= host.getHostId() %>"></aui:option>
							<%
								
							}
				 } %>
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


<%--STREAMING SERVER SETTINGS AND LIST --%>
<c:if test='<%= permissionChecker.hasPermission(groupId, institutionPortletName, institutionPortletPrimKey, "VIEW_HOSTS") %>'>

	 <liferay-ui:panel title="Streaming Server Options" collapsible="true" id="streamingServerSettings"
			    	defaultState="open"
			    	extended="<%= false %>"
			    	persistState="<%= true %>">
					<c:if  test='<%= permissionChecker.hasPermission(groupId, institutionModel, groupId, "ADD_HOSTS") %>'>
	      
						<aui:form action="<%= addStreamingServerURL %>" name="<portlet:namespace />fm" inlineLabel="true">
						<aui:button-row>
				 	    <aui:fieldset column="true">
							<aui:input label="StreamingServer Name" name="name" required="true" inlineField="true"></aui:input>
				 	        <aui:input label="Streaming Server Domain or IP" name="ip" inlineField="true" value='<%= defaultHost.getStreamer() %>'></aui:input>
				 	        <aui:input label="Port" name="port" inlineField="true" value='<%= defaultHost.getPort() %>'></aui:input>
				 	        <aui:input label="Protocol" name="protocol" inlineField="true" value='<%= defaultHost.getProtocol() %>'></aui:input>
				 	        <aui:input label="Root Directory" name="serverroot" inlineField="true" value='<%= defaultHost.getServerRoot() %>'></aui:input>
				 	        <aui:input name='hostId' type='hidden' inlineField="true" value='<%= ParamUtil.getString(renderRequest, "hostId") %>'/>
				 	        <aui:button type="submit"></aui:button>
							<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
				 	    </aui:fieldset>
				 	    </aui:button-row>
						</aui:form>
			
				</c:if>
				<%--STREAMING SERVER SEARCH CONTAINER --%>
				<liferay-ui:search-container searchContainer="<%= searchHostContainer %>"
				curParam ="curStreamingServer"
				orderByType="asc"
				emptyResultsMessage="there-are-no-hosts"
				iteratorURL="<%= innerURL %>"
				delta="20"
				deltaConfigurable="true" >


				<liferay-ui:search-container-results
        			results="<%=HostLocalServiceUtil.getByGroupId(groupId, searchContainer.getStart(), searchContainer.getEnd())%>"
        			total="<%=HostLocalServiceUtil.getByGroupIdCount(groupId)%>" />

				<liferay-ui:search-container-row
				className="de.uhh.l2g.plugins.model.Host" modelVar="Hosts" rowVar="thisRow"
				keyProperty="hostId"  escapedModel="<%= false %>" indexVar="k">

        			<liferay-ui:search-container-column-text name="Host" >      			    
		        			<portlet:actionURL name="deleteStreamingServer" var="deleteStreamingServerURL">
		        				<c:choose>
		        					<c:when test='<%=  HostLocalServiceUtil.getLockingElements(groupId, Hosts.getHostId()) < 1 %>'>
		        						<portlet:param name="curStreamingServerId" value='<%= (new Long(Hosts.getHostId())).toString() %>' />
									</c:when>
									<c:otherwise>
										<portlet:param name="curStreamingServerId" value='<%= "0" %>' />
									</c:otherwise>
								</c:choose>
								<portlet:param name="backURL" value="<%=String.valueOf(portletURL) %>"/>
							</portlet:actionURL>
						<aui:form action="<%= updateStreamingServerURL %>" name="<portlet:namespace />fm">
							<aui:fieldset>
							
							<%	if (Hosts.getDefaultHost() > 0) {
							%>
								<aui:input name="curStreamingServerName" label="StreamingServer Name" inlineField="true" value = "Default" />
								
							<% }
							else {
							%>
			
								<aui:input name="curStreamingServerName" label="StreamingServer Name" inlineField="true" value = "<%= Hosts.getName() %>" />
								
							<%}%>
							
								<aui:input name="curStreamingServerIP" label="IP" inlineField="true" value = "<%= Hosts.getStreamer() %>" />				
								<aui:input name="curStreamingServerPort" label="Port" inlineField="true" value = "<%= Hosts.getPort() %>" />
								<aui:input name="curStreamingServerProtocol" label="Protocol" inlineField="true" value = "<%= Hosts.getProtocol() %>" />
								
								<%-- <aui:input name="curStreamingServerRoot" label="Root Directory" inlineField="true" disabled="true" value = "<%= Hosts.getServerRoot() %>" /> --%>
								
								<aui:input name="curStreamingServerId" type='hidden' inlineField="true" value = "<%= (new Long(Hosts.getHostId())).toString() %>"/>
								<aui:button type="submit"></aui:button>
								<c:choose>
								<c:when test='<%=  HostLocalServiceUtil.getLockingElements(groupId, Hosts.getHostId()) < 1 %>'>
									<aui:button name="delete" value="Löschen" type="button" href="<%=deleteStreamingServerURL.toString() %>" />
								</c:when>
								<c:otherwise>
									<aui:button name="delete" value="Löschen" type="button" disabled="true" href="<%=deleteStreamingServerURL.toString() %>" />								
								</c:otherwise>
								</c:choose>
								</br>
								<liferay-ui:message key="<%= repDirectory %>" />/<liferay-ui:message key="<%= Hosts.getServerRoot() %>"/>
							</aui:fieldset>
						</aui:form>
        			</liferay-ui:search-container-column-text>

        		</liferay-ui:search-container-row>
        	<liferay-ui:search-iterator searchContainer="<%= searchHostContainer %>" />
			</liferay-ui:search-container>
		</liferay-ui:panel>
</c:if>

<%--ROOT INSTITUTION--%>
<%--Permission regarding concrete instance of element, namely RootInstitution --%>
<c:if  test='<%= permissionChecker.hasPermission(groupId, institutionModel, groupId, "EDIT_ROOT_INSTITUTION") %>'>
	<liferay-ui:panel title="Top Level Institution" collapsible="true" id="rootInstitutionSettings"
					defaultState="closed"
					extended="<%= false %>"
					persistState="<%= true %>">
	<aui:form action="<%= updateRootInstitutionURL %>" name="<portlet:namespace />fm">
		<aui:fieldset>
				<aui:input name="rootInstitution" label="Top Level Institution" required="true" inlineField="true"  value = '<%= root.getName() %>'/>
				<aui:input name="rootInstitutionId" type='hidden' inlineField="true" value = '<%= root.getInstitutionId() %>'/>
				<aui:button type="submit"></aui:button>
				<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
		</aui:fieldset>
	</aui:form>
	</liferay-ui:panel>
</c:if>

<%--TOP LEVEL INSTITUTIONS--%>

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
 			Host curHost = Institution_HostLocalServiceUtil.getByGroupIdAndInstitutionId(companyId, groupId, institution_row.getInstitutionId());
 			String curHostName = "Default";
 			if (curHost != null && curHost.getDefaultHost() < 1 ) curHostName = curHost.getName();
 			
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
				<aui:input name="outerListStreamer" label="Streamer" inlineField="true" value = "<%= curHostName %>" disabled="true"/>
				<aui:input name="outerListInstitutionId" type='hidden' inlineField="true" value = "<%= institution.getPrimaryKey() %>"/>
				<aui:input name="outerListHostId" type='hidden' inlineField="true" value = "<%= curHost.getPrimaryKey() %>"/>

				<aui:input name='institutionId' type='hidden' inlineField="true" value='<%= ParamUtil.getString(renderRequest, "institutionId") %>'/>

				<aui:button type="submit"></aui:button>
				<c:if  test='<%= permissionChecker.hasPermission(groupId, institutionModel, groupId, "DELETE_INSTITUTIONS") %>'>
					<c:choose>
					<c:when test='<%=  InstitutionLocalServiceUtil.getLockingElements(institution.getInstitutionId()) < 1 %>'>
								<aui:button name="delete" value="Löschen" type="button" href="<%=deleteInstitutionURL.toString() %>" />
					</c:when>
					<c:otherwise>
								<aui:button name="delete" value="Löschen" type="button" disabled="true" href="<%=deleteInstitutionURL.toString() %>" />								
					</c:otherwise>
					</c:choose>
				</c:if>
			</aui:fieldset>
 		</aui:form>
 		
 		<%--SUB INSTITUTIONS--%>
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
					<aui:input name='subInstitutionParentId' type='hidden' inlineField="true" value='<%= institution.getPrimaryKey() %>'/>
					
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
		 					<portlet:param name="innerListInstitutionId" value='<%= (new Long(subInstitution.getPrimaryKey())).toString() %>' />
		 					<portlet:param name="innerListInstitutionParentId" value='<%= (new Long(institution.getPrimaryKey())).toString() %>' />
							<portlet:param name="backURL" value="<%=String.valueOf(portletURL) %>"/>
						</portlet:actionURL>
						<aui:form action="<%= updateSubInstitutionURL %>" name="<portlet:namespace />fm">
							<aui:fieldset>
								<aui:input name="innerListInstitution" label="Institution Name" inlineField="true" value = "<%= subInstitution.getName() %>" />
								<aui:input cssClass="smallInput" name="innerListOrder" label="Order" inlineField="true" value='<%= subInstitution.getSort() %>'/>
								<aui:input name="innerListInstitutionId" type='hidden' inlineField="true" value = "<%= subInstitution.getPrimaryKey() %>"/>
								<aui:button type="submit"></aui:button>
								<c:choose>
									<c:when test='<%=  InstitutionLocalServiceUtil.getLockingElements(subInstitution.getInstitutionId()) < 1 %>'>
											<aui:button name="delete" value="Löschen" type="button" href="<%=deleteSubInstitutionURL.toString() %>" />
									</c:when>
									<c:otherwise>
											<aui:button name="delete" value="Löschen" type="button" disabled="true" href="<%=deleteSubInstitutionURL.toString() %>" />								
									</c:otherwise>
								</c:choose>
							</aui:fieldset>
						</aui:form>
        			</liferay-ui:search-container-column-text>

        		</liferay-ui:search-container-row>
        	<liferay-ui:search-iterator searchContainer="<%= searchSubInstitutionContainer %>" />
			</liferay-ui:search-container>

		</liferay-ui:panel>
		<%--END: SUB INSTUTIONS--%>
		</liferay-ui:search-container-column-text>

    	</liferay-ui:search-container-row>

   	 	<liferay-ui:search-iterator searchContainer="<%= searchInstitutionContainer %>" />
		</liferay-ui:search-container>
	<%--END: INSTITUTIONS--%>


<%-- </liferay-ui:panel> --%>
