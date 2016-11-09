<%@include file="/init.jsp"%>


<%!com.liferay.portal.kernel.dao.search.SearchContainer<Institution> searchInstitutionContainer = null;%>
<%!com.liferay.portal.kernel.dao.search.SearchContainer<Institution> searchSubInstitutionContainer = null;%>

<liferay-ui:success key="request_processed" message="request_processed"/>
<liferay-ui:error key="host-or-institution-error" message="host-or-institution-error"/>
<liferay-ui:error key="no-property-error" message="property-not-configured" />
<liferay-ui:error key="no-roles-error" message="roles-not-configured" />

<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></portlet:renderURL>
<liferay-portlet:renderURL varImpl="outerURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="innerURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></liferay-portlet:renderURL>

<portlet:actionURL name="addInstitution" var="addInstitutionURL"></portlet:actionURL>
<portlet:actionURL name="addSubInstitution" var="addSubInstitutionURL"></portlet:actionURL>
<portlet:actionURL name="updateInstitution" var="updateInstitutionURL"></portlet:actionURL>
<portlet:actionURL name="updateSubInstitution" var="updateSubInstitutionURL"></portlet:actionURL>

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
String institutionHostModel = Institution_Host.class.getName();

//RoleIds
long adminRoleId = 0;
long coordinatorRoleId = 0;
long producerRoleId = 0;
long studentRoleId = 0; 

Role admin = RoleLocalServiceUtil.fetchRole(companyId, AdminUserManagement.L2G_ADMIN);
if (admin != null){
	adminRoleId = RoleLocalServiceUtil.getRole(companyId, AdminUserManagement.L2G_ADMIN).getRoleId();
	coordinatorRoleId = RoleLocalServiceUtil.getRole(companyId, AdminUserManagement.L2G_COORDINATOR).getRoleId();
	producerRoleId = RoleLocalServiceUtil.getRole(companyId, AdminUserManagement.L2G_PRODUCER).getRoleId();
	studentRoleId = RoleLocalServiceUtil.getRole(companyId, AdminUserManagement.L2G_STUDENT).getRoleId();
}
String pageName = themeDisplay.getLayout().getName(themeDisplay.getLocale());
%>
<%--END: DEBUG INFO--%>
<%
	//Current Selection in Request Object
	long institutionId = Long.valueOf((Long) renderRequest.getAttribute("institutionId"));
	long hostId = Long.valueOf((Long) renderRequest.getAttribute("hostId"));

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("institutionId", institutionId+"");
	portletURL.setParameter("hostId", hostId+"");
	
	//Get Top Level institution of current scope
	Institution root = InstitutionLocalServiceUtil.getRootByGroupId(companyId, groupId);
	long rootId = GetterUtil.getLong(root.getInstitutionId());
	
	//Get First Level institution List
	List<Institution> institutions = InstitutionLocalServiceUtil.getByGroupIdAndParent(groupId,rootId);
	
	//Get StreamingServers
	List<Host> hostList = HostLocalServiceUtil.getByGroupId(groupId);
	//System.out.println(hostList.toString());

	
	//Sort preset for first level Institutions
	int maxOrder = InstitutionLocalServiceUtil.getMaxSortByParentId(rootId)+1;
%>
<div class="noresponsive">
		<%--INSTITUTIONS START--%>
		<c:if test='<%= permissionChecker.hasPermission(groupId, institutionPortletName, institutionPortletPrimKey, "ADD_INSTITUTIONS") %>'>
			<aui:fieldset column="false" label="<%=pageName%>" cssClass="add-institution" >
				<aui:layout cssClass="aist">
					<aui:form action="<%= addInstitutionURL %>" name="fm">
							<aui:fieldset>
								<aui:input name="institution" label="institution" required="true" inlineField="true"/>
	            				<aui:select name="serverselect" id="select-streamer" label="streaming-server-name" inlineField="true">
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
	           				 	<aui:input name="order" label="order" inlineField="true" value='<%= maxOrder %>'/>
					            <aui:input name='institutionId' type='hidden' inlineField="true" value='<%= ParamUtil.getString(renderRequest, "institutionId") %>'/>
					            <aui:input name='parent' type='hidden' inlineField="true" value='<%= rootId %>'/>
								<aui:button type="submit" value="add" ></aui:button>
					        </aui:fieldset>
					</aui:form>
				</aui:layout>
			</aui:fieldset>
		</c:if>
		<%--INSTITUTION LIST--%>
		<% 
			// Unfortunately JSP does not support nesting of <c:choose> when braking containers at arbitrary points
		   	// Therefore Generate List and Root based on Permissions, instead of hiding non visible subsets
		   
	   
		   	//Find out if user is connected with an institution
		    long userId =  Long.parseLong(request.getRemoteUser());
		    long ownInstitutionId = 0; //user is not attached to a conrete institution
		   
		    try{
			    //Currently only this roles have fixed institution
				if (UserLocalServiceUtil.hasRoleUser(coordinatorRoleId, userId)){
				    	ownInstitutionId = CoordinatorLocalServiceUtil.getInstitutionByCoordinator(userId).getInstitutionId();
				}
				else{
				    if (UserLocalServiceUtil.hasRoleUser(producerRoleId, userId)){
				   		ownInstitutionId = ProducerLocalServiceUtil.getInstitutionByProducer(userId).getInstitutionId();
				    }
				}
		    }catch(Exception e){}
		    
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
	
		<%--ADD SUB_INSTITUTION -> Only Required if user can't see full listing, but is allowed to manage own entries --%>
		<%-- Permission on Portlet Scope --%>
		<c:if test='<%= !permissionChecker.hasPermission(groupId, institutionPortletName, institutionPortletPrimKey, "VIEW_ALL_INSTITUTIONS") && permissionChecker.hasPermission(groupId, institutionModel, groupId, "ADD_SUB_INSTITUTION_ENTRY") && ownInstitutionId > 0 %>'>
			<aui:fieldset column="false" label="sub-institutions" >
				<aui:layout cssClass="aist">
					<aui:form action="<%= addSubInstitutionURL %>" name="fm">
						<aui:fieldset>
							<aui:input name="subInstitution" label="sub-institution-name" inlineField="true" />
							<aui:input cssClass="subInstOrder" name="subInstitutionOrder" label="order" inlineField="true" value='<%= ownInstitutionMax  %>'/>
							<aui:input name='subInstitutionParentId' type='hidden' inlineField="true" value='<%= treeBase.getInstitutionId() %>'/>	
							<aui:button type="submit" value="add" ></aui:button>				
					    </aui:fieldset>
					</aui:form>
				</aui:layout>
			</aui:fieldset>
		</c:if>
	
		<%--TOP LEVEL INSTITUTIONS START--%>
			<liferay-ui:search-container searchContainer="<%= searchInstitutionContainer %>" curParam ="curOuter" orderByType="asc" emptyResultsMessage="there-are-no-institutions" delta="5" iteratorURL="<%= outerURL %>" deltaConfigurable="true">
				<liferay-ui:search-container-results results="<%=InstitutionLocalServiceUtil.getByGroupIdAndParent(groupId, treeBaseId, searchContainer.getStart(), searchContainer.getEnd())%>" total="<%=InstitutionLocalServiceUtil.getByGroupIdAndParentCount(groupId, treeBaseId)%>" />
				<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Institution" modelVar="institution" keyProperty="institutionId"  escapedModel="<%= false %>" indexVar="i">
		        <liferay-ui:search-container-column-text name="institution" cssClass="toplevel-institutions">
				        <%
				 			ResultRow container_row = (ResultRow)request.getAttribute("curOuter");
				 			//Institution institution_row = (Institution)row.getObject();
				 			//long institution_id = institution.getInstitutionId();
				 			String id_row = "Inst"+String.valueOf(institution.getInstitutionId());
				 			String curParam_row = "curInner"+String.valueOf(institution.getInstitutionId());
				 			long outerOrder = institution.getSort();
				 			Host curHost = Institution_HostLocalServiceUtil.getByGroupIdAndInstitutionId(companyId, groupId, institution.getInstitutionId());
 							String curHostName = AdminInstitutionManagement.DEFAULT_STREAMER;
				 			if (curHost != null && curHost.getDefaultHost() < 1 ) curHostName = curHost.getName();
				 			
				 			
				 			int subInstitutionMax = InstitutionLocalServiceUtil.getMaxSortByParentId(institution.getPrimaryKey())+1;

				 		%>
							<portlet:actionURL name="deleteInstitution" var="deleteInstitutionURL">
								<portlet:param name="outerListInstitutionId" value='<%= (new Long(institution.getPrimaryKey())).toString() %>' />
								<portlet:param name="institutionId" value='<%= (new Long(institutionId)).toString() %>' />
								<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>
							</portlet:actionURL>
							
 							<aui:form action="<%= updateInstitutionURL %>" name="<portlet:namespace />fm">
					 			<aui:fieldset>
									<aui:input name="outerListInstitution" label="institution-name" inlineField="true" value = "<%= institution.getName() %>" />
									<aui:input name="outerListOrder" label="order" inlineField="true" value='<%= institution.getSort() %>'/>
									<%-- Only display streamer if user is allowed to view host and institution is child of top level --%>
									<c:if test='<%= permissionChecker.hasPermission(groupId, institutionPortletName, institutionPortletPrimKey, "VIEW_HOSTS") && institution.getParentId() == rootId %>'>
										<aui:input name="outerListStreamer" label="streaming-server-name" inlineField="true" value = "<%= curHostName %>" disabled="true"/>
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
						
									<liferay-ui:search-container searchContainer="<%= searchSubInstitutionContainer %>" curParam ="<%=curParam_row%>" orderByType="asc" emptyResultsMessage="there-are-no-institutions" iteratorURL="<%= innerURL %>" delta="100" deltaConfigurable="true" >
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
																<aui:input name="innerListInstitution" label="sub-institution-name" inlineField="true" value = "<%= subInstitution.getName() %>" />
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
</div>