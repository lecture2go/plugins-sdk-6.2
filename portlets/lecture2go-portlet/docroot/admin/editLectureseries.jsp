<%@include file="/init.jsp"%>

<%
	String actionURL = "";
	String lName = "";
	
	Long lId=new Long(0);
	Lectureseries reqLectureseries = LectureseriesLocalServiceUtil.createLectureseries(0);
	try{ 
		reqLectureseries = (Lectureseries)request.getAttribute("reqLectureseries");
		lId=reqLectureseries.getLectureseriesId();
		lName=reqLectureseries.getName();
	}catch(NullPointerException npe){}
	
	Long facilityId=new Long(0);
	Map<String, String> facilities = FacilityLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	
	Long producerId=new Long(0);
	List<Producer>producers = ProducerLocalServiceUtil.getAllProducers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
%>

<portlet:renderURL var="cancelURL"><portlet:param name="jspPage" value="/admin/lectureSeriesList.jsp" /></portlet:renderURL>
<portlet:actionURL name="editLectureseries" var="editURL"><portlet:param name="lectureseriesId" value='<%=""+lId%>' /></portlet:actionURL>
<portlet:actionURL name="deleteURL" var="deleteURL"><portlet:param name="lectureseriesId" value='<%=""+lId%>' /></portlet:actionURL>
<portlet:actionURL name="saveURL" var="saveURL"><portlet:param name="lectureseriesId" value='<%=""+lId%>' /></portlet:actionURL>



<aui:form action="${actionURL}" commandName="model">
	<aui:fieldset helpMessage="test" column="true" label='<%=lName%>'>
		<aui:layout>

			<aui:input name="lectureseriesNumber" label="lectureseries-number" required="true" cssClass="testa"/>

			<aui:input name="lectureseriesName" label="lectureseries-name" required="true"/>

			<aui:select size="1" name="eventType" label="event-type" required="true">
				<aui:option value=""></aui:option>
				<c:forEach items="${eventtypesforselect}" var="type">
					<aui:option value="${type}">${type}</aui:option>
				</c:forEach>
			</aui:select>
			
			<aui:select size="1" name="facilityId" label="facility" required="true" helpMessage="please-add-at-lest-one-facility">
					<aui:option value="">select-facility</aui:option>
						<%for (Map.Entry<String, String> f : facilities.entrySet()) {
								if(f.getKey().equals(facilityId.toString())){
									%>
									<aui:option value='<%=f.getKey()%>' selected="true"><%=f.getValue()%></aui:option>
								<%}else{%>
									<aui:option value='<%=f.getKey()%>'><%=f.getValue()%></aui:option>
								<%}	
						}%>
					</aui:select>
			<aui:button name="addFacility" value="add-facility" type="button" />

			<aui:select size="1" name="producerId" label="producer" required="true" helpMessage="please-add-at-lest-one-producer">
				<aui:option value=""></aui:option>
				<%for (int i = 0; i < producers.size(); i++) {if (producers.get(i).getProducerId() == producerId) {%>
				<aui:option value='<%=producers.get(i).getProducerId()%>' selected="true"><%=producers.get(i).getLastName() + ", " + producers.get(i).getFirstName()%></aui:option>
				<%} else {%>
				<aui:option value='<%=producers.get(i).getProducerId()%>'><%=producers.get(i).getLastName() + ", " + producers.get(i).getFirstName()%></aui:option>
				<%}}%>
			</aui:select>
				
			<div class="dynamicRow">
				<div id="producerSelect">
					<div class="formtitle">${producer}:<span class="orange">*</span></div>
					<select size="1" >
						<option value=""></option>
						<c:forEach items="${model.allProducers}" var="producer">
							<option value="${producer.key}">${producer.value}</option>
						</c:forEach>
					</select>
				</div>
				<aui:button name="addProducer" value="add-producer" type="button" class="addProducerButton"/>
			</div>
							
			<aui:input name="shortDescription" label="short-sescription"/>

			<aui:select size="1" name="allSemesters" label="all-semesters">
				<aui:option value=""></aui:option>
				<c:forEach items="${allSemesters}" var="semester">
					<aui:option value="${semester.key}">${semester.value}</aui:option>
				</c:forEach>
			</aui:select>
			<aui:a name="add-semester" label="add-semester" href="#" />
			<aui:input name="new-semester" disabled="true" />

			<aui:row>
				<aui:select name="languageSelect" label="language-select" required="true" helpMessage="please-add-at-lest-one-language">
					<aui:option value=""></aui:option>
					<c:forEach items="${languagesforselect}" var="lang">
						<aui:option value="${lang}">${lang}</aui:option>
					</c:forEach>
				</aui:select>
				<aui:button type="button" name="addLanguage" value="add-language" />			
			</aui:row>

			<aui:field-wrapper label="long-description">
			    <liferay-ui:input-editor name="descriptionEditor" toolbarSet="liferay-article" initMethod="initEditor" width="50%" />
			    <script type="text/javascript">
			        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString("default content") %>"; }
			    </script>
			</aui:field-wrapper>
			
			<aui:button-row>
				<aui:button type="submit" onclick="<portlet:namespace />extractCodeFromEditor()"/>
				<aui:button type="cancel" value="cancel" onClick="<%=cancelURL.toString()%>" />

				<%if (lId > 0) {%>
				<liferay-ui:icon-menu cssClass="right">
					<liferay-ui:icon image="delete" message="Delete" url="<%=deleteURL.toString()%>" />
				</liferay-ui:icon-menu>
				<%}%>
			</aui:button-row>

		</aui:layout>
	</aui:fieldset>
</aui:form>

<div class="container"></div>

<aui:button name="add" value="add"/>

<script>
//Create an AUI instance and load the 'aui-node' module
AUI().use(
  'aui-node',
  function(Y) {
    // Select the node(s) using a css selector string
    var container = Y.one('.container');
    var add = Y.one('#<portlet:namespace />add');
    var id = 0;
    
    // Change the background color on a `click` event
    node.on(
      'click',
      function() {
        alert("remove");

      }
    );
    
    add.on(
      'click',
      function(Y) {
    	  var newNode ='<div id="<portlet:namespace />'+id+'" > <div id="remBut"><a style="cursor: pointer;" class=" taglib-icon"> <img id="<portlet:namespace></portlet:namespace>deleteNode" src="/welcome-theme/images/common/delete.png" alt=""/> </a></div></div><br/>';
    	  id++;
    	  
  	      var n = Y.Node.create('<div class="mini"><p>xxxxxxxxx</p></div>');
  	      
      }
    );

  }
);
</script>
