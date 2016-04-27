<%@include file="/init.jsp"%>
<%@ page import="de.uhh.l2g.plugins.model.Institution" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="de.uhh.l2g.plugins.model.Host" %>
<%@ page import="de.uhh.l2g.plugins.model.Institution_Host" %>
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
<portlet:actionURL name="updateTreeRoot" var="updateTreeRootURL"></portlet:actionURL>

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
String groupIdString = String.valueOf(groupId);

//Portlet Instance Id (can be string)
String institutionPortletPrimKey = portletDisplay.getResourcePK();
//On Model Level:
String institutionModel = Institution.class.getName();
String hostModel = Host.class.getName();
String institutionHostModel = Institution_Host.class.getName();

//RoleIds
long adminRoleId = RoleLocalServiceUtil.getRole(companyId, "L2Go Admin").getRoleId();
long coordinatorRoleId = RoleLocalServiceUtil.getRole(companyId, "L2Go Coordinator").getRoleId();
long producerRoleId = RoleLocalServiceUtil.getRole(companyId, "L2Go Producer").getRoleId();
long studentRoleId = RoleLocalServiceUtil.getRole(companyId, "L2Go Student").getRoleId();

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
<div class="noresponsive">
		<%--INSTITUTIONS START--%>
		<c:if test='<%= permissionChecker.hasPermission(groupId, institutionPortletName, institutionPortletPrimKey, "ADD_INSTITUTIONS") %>'>
			<aui:fieldset column="false" label="institutions" cssClass="add-institution" >
				<aui:layout>
					<aui:form action="<%= addInstitutionURL %>" name="fm">
							<aui:fieldset>
								<aui:input name="institution" label="name" required="true" inlineField="true"/>
					            <aui:select name="serverselect" id="selecthost" label="streaming-server" inlineField="true">
									<%
										for(Host host : hostList){
											if (host.getDefaultHost() > 0) {
											%>
											<aui:option label="default" value="<%= host.getHostId() %>"></aui:option>
											<%			
											} else {
												%>
												<aui:option label="<%= host.getName() %>" value="<%= host.getHostId() %>"></aui:option>
												<%
											}
								 		} 
								 	%>
					            </aui:select>
					            <aui:input name="order" label="Order" inlineField="true" value='<%= maxOrder %>'/>
					            <aui:input name='institutionId' type='hidden' inlineField="true" value='<%= ParamUtil.getString(renderRequest, "institutionId") %>'/>
					            <aui:input name='parent' type='hidden' inlineField="true" value='<%= rootId %>'/>
								<aui:button type="submit" value="add" ></aui:button>
					        </aui:fieldset>
					</aui:form>
				</aui:layout>
			</aui:fieldset>
		</c:if>
		<%--LIST--%>
		<% 
			// Unfortunately JSP does not support nesting of <c:choose> when braking containers at arbitrary points
		   	// Therefore Generate List and Root based on Permissions, instead of hiding non visible subsets
		   
		   	//Find out if user is connected with an institution
		    long userId =  Long.parseLong(request.getRemoteUser());
		    long ownInstitutionId = 0; //user is not attached to a conrete institution
		   
		    //Currently only this roles have fixed institution
			if (UserLocalServiceUtil.hasRoleUser(coordinatorRoleId, userId)){
			    	ownInstitutionId = CoordinatorLocalServiceUtil.getInstitutionByCoordinator(userId).getInstitutionId();
			}else{
			    if (UserLocalServiceUtil.hasRoleUser(producerRoleId, userId)){
			   		ownInstitutionId = ProducerLocalServiceUtil.getInstitutionByProducer(userId).getInstitutionId();
			    }
			}
			
		   	long treeBaseId = InstitutionLocalServiceUtil.getDefaultInstitutionId(companyId, groupId);
		
		    if(permissionChecker.hasPermission(groupId, institutionPortletName, institutionPortletPrimKey, "VIEW_ALL_INSTITUTIONS")){
		    	treeBaseId = rootId; //top level
		    }
		    else { //set User's institution
			    treeBaseId = ownInstitutionId;
		    }
		    
		    Institution treeBase = InstitutionLocalServiceUtil.getByGroupIdAndId(groupId, treeBaseId);
		    int ownInstitutionMax = InstitutionLocalServiceUtil.getMaxSortByParentId(treeBaseId)+1;
	   	%>
	
		<%--ADD SUB_INSTITUTION -> Only Required if user can't see full listing, but is allowed to mange own entries --%>
		<%-- Permission on Portlet Scope --%>
		<c:if test='<%= !permissionChecker.hasPermission(groupId, institutionPortletName, institutionPortletPrimKey, "VIEW_ALL_INSTITUTIONS") && permissionChecker.hasPermission(groupId, institutionModel, groupId, "ADD_SUB_INSTITUTION_ENTRY") && ownInstitutionId > 0 %>'>
			<liferay-ui:panel title="add-sub-institution" collapsible="true" id="subInstitutionSettings" defaultState="close" extended="false" persistState="true">
				<aui:form action="<%= addSubInstitutionURL %>" name="fm">
					<aui:fieldset>
						<aui:input name="subInstitution" label="subInstitution-name" inlineField="true" />
						<aui:input name="subInstitutionOrder" label="order" inlineField="true" value='<%= ownInstitutionMax  %>'/>
						<aui:input name='subInstitutionParentId' type='hidden' inlineField="true" value='<%= treeBase.getInstitutionId() %>'/>	
						<aui:button type="submit" value="add" ></aui:button>				
				    </aui:fieldset>
				</aui:form>
			</liferay-ui:panel>
		</c:if>
	
		<%--TOP LEVEL INSTITUTIONS START--%>
			<liferay-ui:search-container searchContainer="<%= searchInstitutionContainer %>" curParam ="curOuter" orderByType="asc" emptyResultsMessage="there-are-no-institutions" delta="5" iteratorURL="<%= outerURL %>" deltaConfigurable="true">
				<liferay-ui:search-container-results results="<%=InstitutionLocalServiceUtil.getByGroupIdAndParent(groupId, treeBaseId, searchContainer.getStart(), searchContainer.getEnd())%>" total="<%=InstitutionLocalServiceUtil.getByGroupIdAndParentCount(groupId, treeBaseId)%>" />
				<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Institution" modelVar="institution" keyProperty="institutionId"  escapedModel="<%= false %>" indexVar="i">
		        <liferay-ui:search-container-column-text name="institution">
				        <%
				 			ResultRow container_row = (ResultRow)request.getAttribute("curOuter");
				 			//Institution institution_row = (Institution)row.getObject();
				 			//long institution_id = institution.getInstitutionId();
				 			String id_row = "Inst"+String.valueOf(institution.getInstitutionId());
				 			String curParam_row = "curInner"+String.valueOf(institution.getInstitutionId());
				 			long outerOrder = institution.getSort();
				 			Host curHost = Institution_HostLocalServiceUtil.getByGroupIdAndInstitutionId(companyId, groupId, institution.getInstitutionId());
				 			String curHostName = "Default";
				 			if (curHost != null && curHost.getDefaultHost() < 1 ) curHostName = curHost.getName();
				 			int subInstitutionMax = InstitutionLocalServiceUtil.getMaxSortByParentId(institution.getPrimaryKey())+1;
				 		%>
							<portlet:actionURL name="deleteInstitution" var="deleteInstitutionURL">
								<portlet:param name="outerListInstitutionId" value='<%= (new Long(institution.getPrimaryKey())).toString() %>' />
								<portlet:param name="institutionId" value='<%= (new Long(institutionId)).toString() %>' />
								<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>
							</portlet:actionURL>
					 		<aui:form action="<%= updateInstitutionURL %>" name="fm">
					 			<aui:fieldset>
									<aui:input name="outerListInstitution" label="institution-name" inlineField="true" value = "<%= institution.getName() %>" />
									<aui:input name="outerListOrder" label="order" inlineField="true" value='<%= institution.getSort() %>'/>
									<%-- Only display streamer if user is allowed to view host and institution is child of top level --%>
									<c:if test='<%= permissionChecker.hasPermission(groupId, institutionPortletName, institutionPortletPrimKey, "VIEW_HOSTS") && institution.getParentId() == rootId %>'>
											<aui:input name="outerListStreamer" label="streamer" inlineField="true" value = "<%= curHostName %>" disabled="true"/>
									</c:if>
									<aui:input name="outerListInstitutionId" type='hidden' inlineField="true" value = "<%= institution.getPrimaryKey() %>"/>
									<aui:input name="outerListHostId" type='hidden' inlineField="true" value = "<%= curHost.getPrimaryKey() %>"/>
									<aui:input name='institutionId' type='hidden' inlineField="true" value='<%= ParamUtil.getString(renderRequest, "institutionId") %>'/>
									<aui:button type="submit" value="edit"></aui:button>
									<c:if  test='<%= permissionChecker.hasPermission(groupId, institutionModel, groupId, "DELETE_INSTITUTIONS") %>'>
										<c:if test='<%=  InstitutionLocalServiceUtil.getLockingElements(institution.getInstitutionId()) < 1 %>'>
											<aui:button name="delete" value="delete" type="button" href="<%=deleteInstitutionURL.toString() %>" />
										</c:if>
									</c:if>
								</aui:fieldset>
					 		</aui:form>
					 		<%--SUB INSTITUTIONS--%>
					 		<% 
					 		//Only display second level if user has view all permission
					 		%>
					 		<c:if test='<%= permissionChecker.hasPermission(groupId, institutionPortletName, institutionPortletPrimKey, "VIEW_ALL_INSTITUTIONS") %>'>
								<liferay-ui:panel defaultState="closed" extended="false" id="<%= id_row %>" persistState="true" title="sub-institutions" cssClass="sub-inst">
									<aui:form action="<%= addSubInstitutionURL %>" name="fm">
							 			<aui:fieldset>
											<aui:input name="subInstitution" label="sub-institution-name" inlineField="true" />
											<aui:input name="subInstitutionOrder" label="order" inlineField="true" value='<%= subInstitutionMax  %>'/>
											<aui:input name='subInstitutionParentId' type='hidden' inlineField="true" value='<%= institution.getPrimaryKey() %>'/>
											<aui:button type="submit" value="add"/>
										</aui:fieldset>
						 			</aui:form>
						
									<liferay-ui:search-container searchContainer="<%= searchSubInstitutionContainer %>" curParam ="<%=curParam_row%>" orderByType="asc" emptyResultsMessage="there-are-no-institutions" iteratorURL="<%= innerURL %>" delta="5" deltaConfigurable="true" >
										<liferay-ui:search-container-results results="<%=InstitutionLocalServiceUtil.getByGroupIdAndParent(groupId, institution.getPrimaryKey(), searchContainer.getStart(), searchContainer.getEnd())%>" total="<%=InstitutionLocalServiceUtil.getByGroupIdAndParentCount(groupId, institution.getPrimaryKey())%>" />
											<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Institution" modelVar="subInstitution" rowVar="thisRow" keyProperty="institutionId"  escapedModel="<%=false%>" indexVar="j">
											<c:choose>
												<c:when  test='<%= permissionChecker.hasPermission(groupId, institutionModel, groupId, "EDIT_ALL_INSTITUTIONS") || (permissionChecker.hasPermission(groupId, institutionModel, groupId, "EDIT_OWN_INSTITUTIONS") && ownInstitutionId == institution.getPrimaryKey() ) %>'> 
								        			<liferay-ui:search-container-column-text name="institution" >
									        			<portlet:actionURL name="deleteSubInstitution" var="deleteSubInstitutionURL">
										 					<portlet:param name="innerListInstitutionId" value='<%= (new Long(subInstitution.getPrimaryKey())).toString() %>' />
										 					<portlet:param name="innerListInstitutionParentId" value='<%= (new Long(institution.getPrimaryKey())).toString() %>' />
															<portlet:param name="backURL" value="<%=String.valueOf(portletURL) %>"/>
														</portlet:actionURL>
														
														<aui:form action="<%= updateSubInstitutionURL %>" name="fm">
															<aui:fieldset>
																<aui:input name="innerListInstitution" label="institution-name" inlineField="true" value = "<%= subInstitution.getName() %>" />
																<aui:input cssClass="smallInput" name="innerListOrder" label="order" inlineField="true" value='<%= subInstitution.getSort() %>'/>
																<aui:input name="innerListInstitutionId" type='hidden' inlineField="true" value = "<%= subInstitution.getInstitutionId() %>"/>
																<aui:button type="submit" value="edit"></aui:button>
																<c:if  test='<%= permissionChecker.hasPermission(groupId, institutionModel, groupId, "DELETE_SUB_INSTITUTIONS") %>'>
																	<c:if test='<%=  InstitutionLocalServiceUtil.getLockingElements(subInstitution.getInstitutionId()) < 1 %>'>
																			<aui:button name="delete" value="delete" type="button" href="<%=deleteSubInstitutionURL.toString() %>" />
																	</c:if>
																</c:if>
															</aui:fieldset>
														</aui:form>
							        				</liferay-ui:search-container-column-text>
							        			</c:when>
												<c:otherwise>
													<liferay-ui:message key="<%= subInstitution.getName() %>"></liferay-ui:message>
												</c:otherwise>
											</c:choose>
						        		</liferay-ui:search-container-row>
						        	<liferay-ui:search-iterator searchContainer="<%= searchSubInstitutionContainer %>" />
									</liferay-ui:search-container>
								</liferay-ui:panel>
							</c:if>
							<%--END: SUB INSTUTIONS--%>
						</liferay-ui:search-container-column-text>
			    	</liferay-ui:search-container-row>
			   	 	<liferay-ui:search-iterator searchContainer="<%= searchInstitutionContainer %>" />
			</liferay-ui:search-container>
		<%--TOP LEVEL INSTITUTIONS END--%>
	<%--INSTITUTIONS END--%>
	
	<%--STREAMING SERVER START--%>
		<%if(permissionAdmin){ %>
			<aui:fieldset column="false" label="institutions-streaming-server" cssClass="add-streaming-server" >
				<aui:layout>
					<aui:form action="<%= addStreamingServerURL %>" name="fm" inlineLabel="true">
						 <aui:button-row>
						 	  <aui:fieldset column="true">
								<aui:input label="name" name="name" required="true" inlineField="true"></aui:input>
						 	    <aui:input label="domain-or-ip" name="ip" inlineField="true" value='<%= defaultHost.getStreamer() %>'></aui:input>
						 	    <aui:input label="port" name="port" inlineField="true" value='<%= defaultHost.getPort() %>'></aui:input>
						 	    <aui:input label="protocol" name="protocol" inlineField="true" value='<%= defaultHost.getProtocol() %>'></aui:input>
						 	    <aui:input label="root-directory" name="serverroot" inlineField="true" value='<%= defaultHost.getServerRoot() %>'></aui:input>
						 	    <aui:input name='hostId' type='hidden' inlineField="true" value='<%= ParamUtil.getString(renderRequest, "hostId") %>'/>
						 	    <aui:button type="submit" value="add"></aui:button>
						 	 </aui:fieldset>
						 </aui:button-row>
					</aui:form>
				</aui:layout>
			</aui:fieldset>
			
			<%-- LIST --%>
			<liferay-ui:panel title="streaming-server" collapsible="true" id="streamingServerSettings" defaultState="closed" extended="false" persistState="true" cssClass="sub-inst">
				<liferay-ui:search-container searchContainer="<%= searchHostContainer %>" curParam ="curStreamingServer" orderByType="asc" emptyResultsMessage="there-are-no-hosts" iteratorURL="<%= innerURL %>" delta="20" deltaConfigurable="true" >
					<liferay-ui:search-container-results results="<%=HostLocalServiceUtil.getByGroupId(groupId, searchContainer.getStart(), searchContainer.getEnd())%>" total="<%=HostLocalServiceUtil.getByGroupIdCount(groupId)%>" />
					<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Host" modelVar="Hosts" rowVar="thisRow" keyProperty="hostId"  escapedModel="<%= false %>" indexVar="k">
	        			<liferay-ui:search-container-column-text name="Host" >
		        			<c:choose>
			        			<c:when  test='<%= permissionChecker.hasPermission(groupId, hostModel, groupId, "EDIT_HOST") %>'> 
			        		    	<%--DELETE: For advanced security, this should only be generated if user is allowed to delete Hosts--%>	    
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
									<aui:form action="<%= updateStreamingServerURL %>" name="fm">
										<aui:fieldset>
										<% if (Hosts.getDefaultHost() > 0) { %>
											<aui:input name="curStreamingServerName" label="name" inlineField="true" value = "Default" />
										<% } else { %>
											<aui:input name="curStreamingServerName" label="name" inlineField="true" value = "<%= Hosts.getName() %>" />
										<%}%>
											<aui:input name="curStreamingServerIP" label="ip-or-domain" inlineField="true" value = "<%= Hosts.getStreamer() %>" />				
											<aui:input name="curStreamingServerPort" label="port" inlineField="true" value = "<%= Hosts.getPort() %>" />
											<aui:input name="curStreamingServerProtocol" label="protocol" inlineField="true" value = "<%= Hosts.getProtocol() %>" />
											<aui:input name="curStreamingServerId" type='hidden' inlineField="true" value = "<%= (new Long(Hosts.getHostId())).toString() %>"/>
											<aui:button type="submit" value="edit"></aui:button>
												<%--DELETE --%>
												<c:if test='<%= permissionChecker.hasPermission(groupId, hostModel, groupId, ActionKeys.DELETE) && HostLocalServiceUtil.getLockingElements(groupId, Hosts.getHostId()) < 1 && !(Hosts.getDefaultHost() > 0) %>'>
													<aui:button name="delete" value="delete" type="button" href="<%=deleteStreamingServerURL.toString() %>" />
												</c:if>
										</aui:fieldset>
									</aui:form>
									</c:when>
									<c:otherwise>
										<liferay-ui:message key="<%=Hosts.getName() %>"></liferay-ui:message>
										<liferay-ui:message key="<%=Hosts.getStreamer() %>"></liferay-ui:message>
										<liferay-ui:message key="<%=String.valueOf(Hosts.getPort()) %>"></liferay-ui:message>
										<liferay-ui:message key="<%=Hosts.getProtocol() %>"></liferay-ui:message>
										<liferay-ui:message key="<%=repDirectory %>"></liferay-ui:message>
									</c:otherwise>
								</c:choose>
	        				</liferay-ui:search-container-column-text>
	        			</liferay-ui:search-container-row>
	        		<liferay-ui:search-iterator searchContainer="<%= searchHostContainer %>" />
				</liferay-ui:search-container>
			</liferay-ui:panel>
		<%}%>
	<%--STREAMING SERVER END--%>	
</div>