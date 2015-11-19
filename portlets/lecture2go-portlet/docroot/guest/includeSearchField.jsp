<%@page import="com.liferay.portal.kernel.util.Constants"%>

<portlet:resourceURL var="getSearchWords">
	<portlet:param name="<%=Constants.CMD%>" value="get_search_words" />
</portlet:resourceURL>

<aui:form action="${filterBySearchQuery}">
	<aui:fieldset>
		<aui:input id="searchQuery" name="searchQuery" inlineField="true" />
    </aui:fieldset>
</aui:form>

<aui:script>
	AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',
			function (A) {
				var testData;
				new A.AutoCompleteList({
				allowBrowserAutocomplete: 'false',
				activateFirstItem: 'true',
				inputNode: '#<portlet:namespace />searchQuery',
				resultTextLocator:'word',
				render: 'true',
				resultHighlighter: 'phraseMatch',
				resultFilters:['phraseMatch'],
				source:function(){
							var inputValue=A.one("#<portlet:namespace/>searchQuery").get('value');
							var myAjaxRequest=A.io.request('<%=getSearchWords.toString()%>',
												 {
						  						    dataType: 'json',
						  							method:'POST',
						  							data:{
						  								<portlet:namespace />searchWord: inputValue,
						  							},
						  							autoLoad:false,
						  							sync:true,
						  						    on: {
						   			 				 success:function(){
						   			 					var data=this.get('responseData');
						   			 					testData=data;
						   			 				 }
						  							}
												}
											);
											myAjaxRequest.start();
											return testData;},
										}	);
			});
</aui:script>
