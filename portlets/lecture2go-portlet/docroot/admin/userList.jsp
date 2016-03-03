<%@include file="/init.jsp"%>
<liferay-ui:error key="host-or-institution-error" message="host-or-institution-error"/>
<%
	long groupId = themeDisplay.getLayout().getGroupId();
	String name = User.class.getName();
	User u = UserLocalServiceUtil.getUser(new Long (request.getRemoteUser()));
	List<User> tempUserList = new ArrayList();
	AdminUserManagement aum = new AdminUserManagement();
	aum.initL2goRoles(u,renderRequest); //init roles
	List<Role> l2goRoles = aum.getL2GoRoles(u);
	Integer roleId = 0;
	try{tempUserList=UserLocalServiceUtil.getRoleUsers(new Integer(request.getParameter("roleId")));}
	catch(NumberFormatException nfe){tempUserList=UserLocalServiceUtil.getUsers(1, UserLocalServiceUtil.getUsersCount());}
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("roleId", request.getParameter("roleId")+"");
%>

<portlet:renderURL var="allRoles"><portlet:param name="jspPage" value="/admin/userList.jsp" /></portlet:renderURL>

<aui:fieldset helpMessage="choose-filter" column="true">
	<aui:form action="<%= allRoles.toString() %>" method="post">
		<aui:select name="roleId" label="" onChange="submit();">
			<aui:option value="">select-l2go-role</aui:option>
			<%for (int i = 0; i < l2goRoles.size(); i++) {
				//check for permissions
				boolean permission = false;
				if(permissionChecker.hasPermission(groupId,name,u.getPrimaryKey(),"ADD_L2GOPRODUCER") && (l2goRoles.get(i).getName().equals("L2Go Producer") || l2goRoles.get(i).getName().equals("L2Go Student"))) permission = true;
				else if(permissionChecker.hasPermission(groupId,name,u.getPrimaryKey(),"ADD_L2GOADMIN")) permission = true;
				
				if(permission){
					if(l2goRoles.get(i).getRoleId()==roleId){
						%>
						<aui:option value='<%=l2goRoles.get(i).getRoleId()%>' selected="true"><%=l2goRoles.get(i).getName()%></aui:option>
						<%}else{%>
						<aui:option value='<%=l2goRoles.get(i).getRoleId()%>'><%=l2goRoles.get(i).getName()%></aui:option>
						<%}					
				}
			}%>
		</aui:select>
	</aui:form>
</aui:fieldset>

<liferay-ui:search-container emptyResultsMessage="no-l2go-roles-found" delta="10" iteratorURL="<%= portletURL %>">
	<liferay-ui:search-container-results>
		<%
			results = ListUtil.subList(tempUserList, searchContainer.getStart(), searchContainer.getEnd());
			total = tempUserList.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="com.liferay.portal.model.User" keyProperty="userId" modelVar="usr">
		<portlet:actionURL name="viewRole" var="editURL">
			<portlet:param name="userId" value="<%= String.valueOf(usr.getUserId())%>" />
			<portlet:param name="backURL" value="<%=String.valueOf(portletURL)%>"/>
		</portlet:actionURL>
		<liferay-ui:search-container-column-text name="name">
		  <div class="adminrow wide">
			<div class="admintile wide">
				<strong><%=usr.getFullName()%></strong>
				<br/>
				<%
				List<Role> roles = usr.getRoles();
				String n = "";
				for (int i = 0; i < roles.size(); i++) {
					//check for l2g role
					String rn = roles.get(i).getName();
					if(rn.contains("L2Go Coordinator")){
						long fId = new Long(0);
						try{ fId=CoordinatorLocalServiceUtil.getCoordinator(usr.getUserId()).getInstitutionId(); }catch (Exception e){}
						String fN = "";
						try{
							fN= InstitutionLocalServiceUtil.getInstitution(fId).getName(); 
							n+="coordinator-for "+ fN+"<br/>";
						}catch (Exception e){}
					}
					if(rn.contains("L2Go Producer")){
						long fId = new Long(0);
						try{fId = ProducerLocalServiceUtil.getProducer(usr.getUserId()).getInstitutionId();}catch (Exception e){}
						String fN = "";
						try{
							fN= InstitutionLocalServiceUtil.getInstitution(fId).getName(); 
							n+="producer-for "+ fN+"<br/>";
						}catch (Exception e){}
					}
					if(!rn.contains("L2Go Producer") && !rn.contains("L2Go Coordinator")){
						n+=rn+"<br/>";
					}
				}%>
			<%=n%>
			</div>
			<div class="admintile wide icons">
				<%if(permissionAdmin){
					%>
					 <a href="<%=editURL.toString()%>">
			   		 	<span class="icon-large icon-pencil"></span>
					 </a>			
					<%
				}else{
					if(new Lecture2GoRoleChecker().isProducer(usr) || new Lecture2GoRoleChecker().isStudent(usr)){
					 %>
					 <a href="<%=editURL.toString()%>">
			   		 	<span class="icon-large icon-pencil"></span>
					 </a>
					 <%
					}
				 }%>
			</div>
		</div>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
