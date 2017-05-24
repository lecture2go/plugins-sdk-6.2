<%@include file="/init.jsp"%>

<jsp:useBean id="reqUser" type="com.liferay.portal.model.User" scope="request" />
<jsp:useBean id="cInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Institution>" scope="request"/>
<jsp:useBean id="pInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Institution>" scope="request"/>
<jsp:useBean id="reqProducer" type="de.uhh.l2g.plugins.model.Producer" scope="request" />
<jsp:useBean id="reqCoordinator" type="de.uhh.l2g.plugins.model.Coordinator" scope="request" />
<jsp:useBean id="loggedInCoordinator" type="de.uhh.l2g.plugins.model.Coordinator" scope="request" />
<jsp:useBean id="isStudent" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="isL2goAdmin" type="java.lang.Boolean" scope="request" />


<%
	long groupId = themeDisplay.getLayout().getGroupId();
	String name = User.class.getName();
	String backURL = request.getAttribute("backURL").toString();
%>

<portlet:actionURL name="editRole" var="editURL">
	<portlet:param name="userId" value='<%=""+reqUser.getUserId()%>'/>
	<portlet:param name="backURL" value='<%=backURL%>' />
</portlet:actionURL>

<div class="noresponsive">
<aui:form action="<%= editURL.toString() %>" method="post">
	<aui:fieldset helpMessage="" column="true" label='<%=LanguageUtil.get(pageContext, "l2go-roles-for")+" "+reqUser.getFullName()%>'>
		<aui:layout>
			<div id="metadata-upload">
				<c:if test='<%= permissionChecker.hasPermission(groupId,name,reqUser.getPrimaryKey(),"ADD_L2GOCOORDINATOR") %>'>
					<aui:column>
						<aui:select name="cfId" label="">
							<aui:option value=""><liferay-ui:message key="set-coordinator-for-institution"/></aui:option>
							<%for (int i = 0; i < cInstitutions.size(); i++) {
								if(cInstitutions.get(i).getInstitutionId()==reqCoordinator.getInstitutionId()){
							%>	
							<aui:option value='<%=cInstitutions.get(i).getInstitutionId()%>' selected="true"><liferay-ui:message key="coordinator-for"/> <%=cInstitutions.get(i).getName() %></aui:option>
							<%}else{%>
							<aui:option value='<%=cInstitutions.get(i).getInstitutionId()%>'><liferay-ui:message key="coordinator-for"/> <%=cInstitutions.get(i).getName() %></aui:option>
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
						<aui:select name="pfId" label="" disabled="<%=dis%>">
							<aui:option value=""><liferay-ui:message key="set-producer-for-institution"/></aui:option>
							<%for (int i = 0; i < pInstitutions.size(); i++) {
								if(pInstitutions.get(i).getInstitutionId()==reqProducer.getInstitutionId()){
							%>	
							<aui:option value='<%=pInstitutions.get(i).getInstitutionId()%>' selected="true"><liferay-ui:message key="producer-for"/> <%=pInstitutions.get(i).getName() %></aui:option>
							<%}else{%>
							<aui:option value='<%=pInstitutions.get(i).getInstitutionId()%>'><liferay-ui:message key="producer-for"/> <%=pInstitutions.get(i).getName() %></aui:option>
							<%}
							}%>
						</aui:select>
					</aui:column>
				</c:if>
				
				<div id="usr-roles">
					<div>
						<c:if test='<%= permissionChecker.hasPermission(groupId,name,reqUser.getPrimaryKey(),"ADD_L2GOSTUDENT") %>'>
								<%if(isStudent){%>
								<aui:input type="checkbox" name="isStud" label="" checked="true"/>
								<%}else{%>
								<aui:input type="checkbox" name="isStud" label=""/>
								<%}%>
						</c:if>
						<liferay-ui:message key="set-student-status"/>	      	      
					</div>	
					<div>		
						<c:if test='<%= permissionChecker.hasPermission(groupId,name,reqUser.getPrimaryKey(),"ADD_L2GOADMIN") %>'>
								<%if(isL2goAdmin){%>
								<aui:input type="checkbox" name="isL2goAdmin" label="" checked="true"/>
								<%}else{%>
								<aui:input type="checkbox" name="isL2goAdmin" label=""/>
								<%}%>			
						</c:if>
						<liferay-ui:message key="set-l2g-admin-status"/>
					</div>
				</div>
				
				
				<aui:button-row>
		      		<aui:button type="submit"/>
		      		<aui:button type="cancel" value="cancel" name="cancel"/>
		    	</aui:button-row>	
			</div>
		</aui:layout>
	</aui:fieldset>
</aui:form>
</div>

<script>
	$('#<portlet:namespace></portlet:namespace>cancel').click(function(){
		   window.location.href="<%=backURL.toString()%>";
	});
</script>