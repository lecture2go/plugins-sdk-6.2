<%@include file="/init.jsp"%>
<liferay-ui:error key="host-or-facility-error" message="host-or-facility-error"/>
<%
	long groupId = themeDisplay.getLayout().getGroupId();
	String name = User.class.getName();
	User u = UserLocalServiceUtil.getUser(new Long (request.getRemoteUser()));
	List<User> tempUserList = new ArrayList();
	AdminUserManagement aum = new AdminUserManagement();
	aum.initL2goRoles(u); //init roles
	List<Role> l2goRoles = aum.getL2GoRoles(u);
	Integer roleId = 0;
	try{tempUserList=UserLocalServiceUtil.getRoleUsers(new Integer(request.getParameter("roleId")));}
	catch(NumberFormatException nfe){tempUserList=UserLocalServiceUtil.getUsers(1, UserLocalServiceUtil.getUsersCount());}
%>

<portlet:renderURL var="allRoles"><portlet:param name="jspPage" value="/admin/userList.jsp" /></portlet:renderURL>

<aui:form action="<%= allRoles.toString() %>" method="post">
	<aui:select name="roleId" label="select-l2go-role" onChange="submit();">
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

<liferay-ui:search-container emptyResultsMessage="no-l2go-roles-found" delta="10">
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
		</portlet:actionURL>
		<liferay-ui:search-container-column-text name="name">
			<aui:a  href="<%=editURL.toString()%>"><%=usr.getFullName()%></aui:a>
			<br/>
			<%for (int i = 0; i < usr.getRoles().size(); i++) {
				String n = usr.getRoles().get(i).getName();
				//check for l2g role
				if(n.contains("L2Go Coordinator")){
					long fId = new Long(0);
					try{ fId=CoordinatorLocalServiceUtil.getCoordinator(usr.getUserId()).getInstitutionId(); }catch (Exception e){}
					String fN = InstitutionLocalServiceUtil.getInstitution(fId).getName();
					n+=" for "+ fN;
				}
				if(n.contains("L2Go Producer")){
					long fId = new Long(0);
					try{fId = ProducerLocalServiceUtil.getProducer(usr.getUserId()).getInstitutionId();}catch (Exception e){}
					String fN = InstitutionLocalServiceUtil.getInstitution(fId).getName();
					n+=" for "+ fN;
				}
				n+="<br/>";
				out.println(n);					
			}%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp path="/admin/editL2GoRolesButton.jsp"/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>