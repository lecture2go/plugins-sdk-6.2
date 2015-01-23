<%@include file="/init.jsp"%>
<liferay-ui:error key="host-or-institution-error" message="host-or-institution-error"/>

<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></portlet:renderURL>
<portlet:actionURL name="addInstitutionEntry" var="addInstitutionEntryURL"></portlet:actionURL>


<aui:form action="<%= addInstitutionEntryURL %>" name="<portlet:namespace />fm">

		<aui:fieldset>
			<aui:input name="institution" label="Institution" required="true"/>
            <aui:input name="serverselect" label="Select Streaming Server"></aui:input>

        </aui:fieldset>
        
       <liferay-ui:panel 
		    	defaultState="closed" 
		    	extended="<%= false %>" 
		    	id="advancedPanel" 
		    	persistState="<%= true %>" 
		    	title="Advanced Streaming Server Options">
		
		 	    <aui:fieldset>
					<aui:input name="Entry Name" label="name"></aui:input>
		 	        <aui:input name="Streaming Server Domain or IP" label="ip"></aui:input>
		 	        <aui:input name="HTTP Protocol" label="protocol"></aui:input>
		 	        <aui:input name="Server Template" label="template"></aui:input>  
		 	        <aui:button value="Refresh" type="button" onClick="<%= viewURL.toString() %>"></aui:button>          
		 	    </aui:fieldset>

		</liferay-ui:panel>


        <aui:button-row>
            <aui:button type="submit"></aui:button>
            <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
        </aui:button-row>

</aui:form>
