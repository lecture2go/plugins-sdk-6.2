<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="org.springframework.scripting.config.LangNamespaceUtils"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.util.Locale"%>

<%@include file="/init.jsp"%>

<%
	String actionURL = "";
	String lName = "";
	String lNumber = "";
	String lLanguage = "";
	String lEventType = "";
	String lSemesterName = "";
	String lShortDescription = "";
	
	Long lId=new Long(0);
	Lectureseries reqLectureseries = LectureseriesLocalServiceUtil.createLectureseries(0);
	try{ 
		reqLectureseries = (Lectureseries)request.getAttribute("reqLectureseries");
		lId=reqLectureseries.getLectureseriesId();
		lName=reqLectureseries.getName();
		lNumber=reqLectureseries.getNumber();
		lLanguage=reqLectureseries.getLanguage();
		lEventType=reqLectureseries.getEventType();
		lSemesterName=reqLectureseries.getSemesterName();
		lShortDescription=reqLectureseries.getShortDesc();
	}catch(NullPointerException npe){}
	
	Long facilityId = new Long(0);
	try{
		facilityId = FacilityLocalServiceUtil.getByLectureseriesId(lId, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS).iterator().next().getFacilityId();
	}catch(Exception npe){}
	Map<String, String> facilities = FacilityLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);

	Locale[] languages = LanguageUtil.getAvailableLocales();
	String[] availableLanguageIds = LocaleUtil.toLanguageIds(languages);
	String languageId="";
	String semesterId="";
	
	List<Producer> producers = ProducerLocalServiceUtil.getAllProducers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	List<String> semesters = LectureseriesLocalServiceUtil.getAllSemesters(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);

%>
<portlet:renderURL var="cancelURL"><portlet:param name="jspPage" value="/admin/lectureSeriesList.jsp" /></portlet:renderURL>
<portlet:actionURL name="editLectureseries" var="editURL"><portlet:param name="lectureseriesId" value='<%=""+lId%>' /></portlet:actionURL>
<portlet:actionURL name="deleteURL" var="deleteURL"><portlet:param name="lectureseriesId" value='<%=""+lId%>' /></portlet:actionURL>
<portlet:actionURL name="addLectureseries" var="addURL"><portlet:param name="lectureseriesId" value='<%=""+lId%>' /></portlet:actionURL>

<%
if(lId >0) {actionURL=editURL.toString();}
else {actionURL = addURL.toString();}
%>
<aui:form action="<%=actionURL%>" commandName="model">
	<aui:fieldset helpMessage="test" column="true" label='<%=lName%>'>
		<aui:layout>
			
			<aui:input name="lectureseriesNumber" label="lectureseries-number" required="true" value="<%=lNumber %>" />

			<aui:input name="lectureseriesName" label="lectureseries-name" required="true" value="<%=lName%>"/>

			<aui:select size="1" name="eventType" label="event-type" required="true">
				<aui:option value=""></aui:option>
				<%
				String[] l =  LanguageUtil.get(pageContext, "event-types-for-select").split(",");
				for(int i=0; i<l.length; i++){
					String type = l[i];
					if(lEventType.equals(type)){%> <aui:option selected="true" value="<%=type%>"><%=type%></aui:option><%}
					else{%> <aui:option value="<%=type%>"><%=type%></aui:option><%}
				}
				%>
				
			</aui:select>
			
			<aui:select size="1" name="facilityId" label="facility" required="true">
				<aui:option value="">select-facility</aui:option>
				<%for (Map.Entry<String, String> f : facilities.entrySet()) {
				boolean dis=true; 
				if(f.getValue().startsWith("----"))dis=false;
				if(f.getKey().equals(facilityId.toString())){
					%><aui:option value='<%=f.getKey()%>' selected="true"><%=f.getValue()%></aui:option>
				<%}else{%><aui:option value='<%=f.getKey()%>' disabled="<%=dis%>"><%=f.getValue()%></aui:option><%}	
				}%>
			</aui:select>
			
			<aui:select size="1" name="producerId" label="producer" required="true" helpMessage="please-add-at-lest-one-producer">
				<aui:option value="">select-producer</aui:option>
				<%for (int i = 0; i < producers.size(); i++) {
					if (producers.get(i).getProducerId()>0) {%><aui:option value='<%=producers.get(i).getProducerId()%>'><%=producers.get(i).getLastName() + ", " + producers.get(i).getFirstName()%></aui:option><%}
				}%>	
			
			</aui:select>

			<div class="prodCont">
				<%
				List<Integer> pIds = ProducerLocalServiceUtil.getAllProducerIds(lId);
				for(int i=0;i<pIds.size();i++){
					Producer p = ProducerLocalServiceUtil.getProdUcer(new Long(pIds.get(i)+""));
					%>
					<div id='<%=p.getProducerId()%>'> <%=p.getLastName() +", "+p.getFirstName()+"&nbsp;&nbsp;&nbsp;" %> <a style='cursor:pointer;' onClick='document.getElementById("<%=p.getProducerId()%>").remove();'><b>X</b></a></div>
					<%
				}
				%>				
			</div>	
							
			<aui:input name="shortDescription" label="short-description"  value="<%=lShortDescription%>"/>

			<aui:select size="1" name="allSemesters" label="semester">
				<aui:option value="">select-semester</aui:option>
				<%for (int i = 0; i < semesters.size(); i++) {
					if (semesters.get(i).equals(lSemesterName)) {%>
						<aui:option value='<%=semesters.get(i)%>' selected="true"><%=semesters.get(i)%></aui:option>
					<%} else {%>
						<aui:option value='<%=semesters.get(i)%>'><%=semesters.get(i)%></aui:option>
					<%}
				}%>
			</aui:select>
			
			<a id="addSemester" style="cur	sor:pointer;">add-new-semester</a>
			<aui:input id="newSemester" name="newSemester" style="display:none;" label=""/>

			<aui:select size="1" name="languageId" label="language" required="true">
				<aui:option value="">select-language</aui:option>
				<%for (int i=0; i<languages.length; i++){
					if (languages[i].getLanguage().equals(lLanguage)) {%>
						<aui:option value='<%=languages[i].getLanguage()%>' selected="true"><%=languages[i].getDisplayLanguage()%></aui:option>
					<%} else {%>
						<aui:option value='<%=languages[i].getLanguage()%>'><%=languages[i].getDisplayLanguage()%></aui:option>
					<%}
				}%>
			</aui:select>
				
			<aui:field-wrapper label="long-description">
			    <liferay-ui:input-editor name="descriptionEditor" toolbarSet="liferay-article" initMethod="initEditor" width="50%" />
			    <script type="text/javascript">
			        function <portlet:namespace />initEditor() {
			        	return <%= UnicodeFormatter.toString("default content safgas gagbag  agas gas gas g") %>; 
			        }
			    </script>
			</aui:field-wrapper>
			
			<aui:button-row>
				<aui:button type="submit" onclick="<portlet:namespace />extractCodeFromEditor()"/>
				<aui:button type="cancel" value="cancel" onClick="<%=cancelURL.toString()%>" />
				<%if (lId>0) {%>
				<liferay-ui:icon-menu cssClass="right">
					<liferay-ui:icon image="delete" message="Delete" url="<%=deleteURL.toString()%>" />
				</liferay-ui:icon-menu>
				<%}%>
			</aui:button-row>
		</aui:layout>
	</aui:fieldset>
</aui:form>

<script>

AUI().use(
		  'aui-node',

  function(A) {
    
	// Select the node(s) using a css selector string
    var contProduc = A.one('.prodCont');
    var producerId = A.one('#<portlet:namespace/>producerId');
    var addSemester = A.one('#addSemester');
    var newSemester = A.one('#<portlet:namespace/>newSemester');
    var allSemesters = A.one('#<portlet:namespace/>allSemesters');
    
    var j = 0;
    
    producerId.on(
      	'change',
      	function(A) {
  			if(producerId.get('value')>0){
				j++;
  	   	 		var n = producerId.get(producerId.get('selectedIndex')).get('value');
  	    		var t = producerId.get(producerId.get('selectedIndex')).get('text')+"&nbsp;&nbsp;&nbsp;";
  	  			contProduc.append("<div id='"+n+"'> "+t+" <a style='cursor:pointer;' onClick='document.getElementById(&quot;"+n+"&quot;).remove();'><b>X</b></a></div>");
  			}
      	}
    );
    
    addSemester.on(
    		'click',
    		function(A) {
    			newSemester.show(); 
    			allSemesters.set("disabled","disabled");
    		}
    );

  }
);
</script>