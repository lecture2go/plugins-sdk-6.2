<%@include file="/init.jsp"%>
<liferay-ui:error key="host-or-institution-error" message="host-or-institution-error"/>

<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></portlet:renderURL>
<portlet:actionURL name="addEntry" var="addEntryURL"></portlet:actionURL>

<aui:form action="<%= addEntryURL %>" name="<portlet:namespace />fm">

		<aui:fieldset>

            <aui:input name="Institution"></aui:input>
            <aui:input name="Streaming Server"></aui:input>

        </aui:fieldset>
        
       <liferay-ui:panel 
		    	defaultState="closed" 
		    	extended="<%= false %>" 
		    	id="advancedPanel" 
		    	persistState="<%= true %>" 
		    	title="Advanced Streaming Server Options">
		
		 	    <aui:fieldset>
					<aui:input name="Entry Name"></aui:input>
		 	        <aui:input name="Streaming Server Domain or IP"></aui:input>
		 	        <aui:input name="HTTP Protocol"></aui:input>
		 	        <aui:input name="Server Template"></aui:input>  
		 	        <aui:button value="Refresh" type="button" onClick="<%= viewURL.toString() %>"></aui:button>          
		 	    </aui:fieldset>

		</liferay-ui:panel>


        <aui:button-row>
            <aui:button type="submit"></aui:button>
            <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
        </aui:button-row>

</aui:form>
