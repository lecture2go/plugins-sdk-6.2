<%@include file="/init.jsp"%>

<%	
	List<Institution> institutions = InstitutionLocalServiceUtil.getForProducerPending();
	String articleId = PropsUtil.get("lecture2go.producer.pending.articleId");
	long groupId = themeDisplay.getLayout().getGroupId();
%>

<portlet:actionURL name="editRole" var="editURL">
	<portlet:param name="userId" value='<%=""+user.getUserId()%>'/>
	<portlet:param name="backURL" value="/"/>
</portlet:actionURL>

<div>
	<liferay-ui:journal-article articleId="<%=articleId%>" groupId="<%=groupId%>"/>
</div>
<aui:form action="<%= editURL.toString() %>" method="post">
	<aui:fieldset helpMessage="" column="true" label='<%=LanguageUtil.get(pageContext, "l2go-roles-for")+" "+user.getFullName()%>'>
		<aui:layout>
			<div id="metadata-upload">
				<c:if test='<%= permissionProducerPending %>'>
					<aui:column>
						<aui:select name="pfId" label="" required="true">
							<aui:option disabled='true' selected="true"><liferay-ui:message key="select-institution"/></aui:option>
							<%for (int i = 0; i < institutions.size(); i++) {%>
								<aui:option value='<%=institutions.get(i).getInstitutionId()%>'><liferay-ui:message key="producer-for"/> <%=institutions.get(i).getName() %></aui:option>
							<% } %>
						</aui:select>
					</aui:column>
				</c:if>
				<aui:input type="hidden" name="isStud" value="false"/>				
			
				
				<aui:button-row>
		      		<aui:button type="submit" name="submit"/>
		      		<aui:button type="cancel" value="cancel" name="cancel"/>
		    	</aui:button-row>
			</div>
		</aui:layout>
	</aui:fieldset>
</aui:form>

<script>
	$('#<portlet:namespace/>submit').click(function(){
		return confirm('<liferay-ui:message key="correct-institution-selected-question"/>');
	});
	$('#<portlet:namespace/>cancel').click(function(){
		   window.location.href="/";
	});

</script>