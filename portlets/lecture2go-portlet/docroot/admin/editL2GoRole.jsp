<%@include file="/init.jsp"%>

<jsp:useBean id="reqUser" type="com.liferay.portal.model.User" scope="request" />
<jsp:useBean id="cInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Institution>" scope="request"/>
<jsp:useBean id="pInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Institution>" scope="request"/>
<jsp:useBean id="reqProducer" type="de.uhh.l2g.plugins.model.Producer" scope="request" />
<jsp:useBean id="reqCoordinator" type="de.uhh.l2g.plugins.model.Coordinator" scope="request" />
<jsp:useBean id="loggedInCoordinator" type="de.uhh.l2g.plugins.model.Coordinator" scope="request" />
<jsp:useBean id="isStudent" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="isL2goAdmin" type="java.lang.Boolean" scope="request" />

<portlet:renderURL var="cancelURL"><portlet:param name="jspPage" value="/admin/userList.jsp" /></portlet:renderURL>
<portlet:actionURL name="editRole" var="editURL"><portlet:param name="userId" value='<%=""+reqUser.getUserId()%>'/></portlet:actionURL>

<%
	long groupId = themeDisplay.getLayout().getGroupId();
	String name = User.class.getName();
%>

<aui:form action="<%= editURL.toString() %>" method="post">
	<aui:fieldset helpMessage="test" column="true" label='<%="l2go-roles-for "+reqUser.getFullName()%>'>
		<aui:layout>
			<c:if test='<%= permissionChecker.hasPermission(groupId,name,reqUser.getPrimaryKey(),"ADD_L2GOCOORDINATOR") %>'>
				<aui:column>
					<aui:select name="cfId" label="set-coordinator-for-institution">
						<aui:option value="">select-institution</aui:option>
						<%for (int i = 0; i < cInstitutions.size(); i++) {
							if(cInstitutions.get(i).getInstitutionId()==reqCoordinator.getInstitutionId()){
						%>	
						<aui:option value='<%=cInstitutions.get(i).getInstitutionId()%>' selected="true"><%=cInstitutions.get(i).getName() %></aui:option>
						<%}else{%>
						<aui:option value='<%=cInstitutions.get(i).getInstitutionId()%>'><%=cInstitutions.get(i).getName() %></aui:option>
						<%}
						}%>
					</aui:select>
				</aui:column>
			</c:if>
			<c:if test='<%= permissionChecker.hasPermission(groupId,name,reqUser.getPrimaryKey(),"ADD_L2GOPRODUCER") %>'>
				<aui:column>
					<%
					boolean dis = false;
					if(loggedInCoordinator.getInstitutionId()!=reqProducer.getInstitutionId() && reqProducer.getInstitutionId()!=0 && !permissionChecker.hasPermission(groupId,name,reqUser.getPrimaryKey(),"ADD_L2GOCOORDINATOR"))dis=true;
					%>
					<aui:select name="pfId" label="set-producer-for-institution" disabled="<%=dis%>">
						<aui:option value="">select-institution</aui:option>
						<%for (int i = 0; i < pInstitutions.size(); i++) {
							if(pInstitutions.get(i).getInstitutionId()==reqProducer.getInstitutionId()){
						%>	
						<aui:option value='<%=pInstitutions.get(i).getInstitutionId()%>' selected="true"><%=pInstitutions.get(i).getName() %></aui:option>
						<%}else{%>
						<aui:option value='<%=pInstitutions.get(i).getInstitutionId()%>'><%=pInstitutions.get(i).getName() %></aui:option>
						<%}
						}%>
					</aui:select>
				</aui:column>
			</c:if>
			<c:if test='<%= permissionChecker.hasPermission(groupId,name,reqUser.getPrimaryKey(),"ADD_L2GOSTUDENT") %>'>
				<aui:column>
					<%if(isStudent){%>
					<aui:input type="checkbox" name="isStud" label="set-student-status" checked="true"/>
					<%}else{%>
					<aui:input type="checkbox" name="isStud" label="set-student-status"/>
					<%}%>
				</aui:column>
			</c:if>
			<c:if test='<%= permissionChecker.hasPermission(groupId,name,reqUser.getPrimaryKey(),"ADD_L2GOADMIN") %>'>
				<aui:column>
					<%if(isL2goAdmin){%>
					<aui:input type="checkbox" name="isL2goAdmin" label="set-l2goadmin-status" checked="true"/>
					<%}else{%>
					<aui:input type="checkbox" name="isL2goAdmin" label="set-l2goadmin-status"/>
					<%}%>			
				</aui:column>
			</c:if>
			<aui:button-row>
	      		<aui:button type="submit"/>
	      		<aui:button type="cancel" value="cancel" onClick="<%= cancelURL.toString() %>" />
	    	</aui:button-row>	
		</aui:layout>
	</aui:fieldset>
</aui:form>