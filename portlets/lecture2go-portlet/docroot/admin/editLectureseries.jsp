<%@include file="/init.jsp"%>

<%
	String actionURL = "";
	String lName = "";
	String lNumber = "";
	String lLanguage = "";
	String lEventType = "";
	String lSemesterName = "";
	String lShortDesc = "";
	String lInstructors = "";
	String lPassword = "";
	String lLongDesc = "";
	
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
		lShortDesc=reqLectureseries.getShortDesc();
		lInstructors=reqLectureseries.getInstructorsString();
		lPassword=reqLectureseries.getPassword();
		lLongDesc=reqLectureseries.getLongDesc();
	}catch(NullPointerException npe){}
	
	Long institutionId = new Long(0);
	try{
		institutionId = InstitutionLocalServiceUtil.getByLectureseriesId(lId, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS).iterator().next().getInstitutionId();
	}catch(Exception npe){}

	Map<String,String> institutions = new LinkedHashMap<String, String>();
	if(permissionAdmin){
		institutions = InstitutionLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		permissionCoordinator = false;
	}
	if(permissionCoordinator)institutions = InstitutionLocalServiceUtil.getByParent(CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId()).getInstitutionId());

	Locale[] languages = LanguageUtil.getAvailableLocales();
	String[] availableLanguageIds = LocaleUtil.toLanguageIds(languages);
	String languageId="";

    List<Producer> producers = ProducerLocalServiceUtil.getAllProducers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);	
	List<Long> pIds = ProducerLocalServiceUtil.getAllProducerIds(lId);
	List<String> semesters = LectureseriesLocalServiceUtil.getAllSemesters(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	
%>

<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/admin/lectureSeriesList.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editLectureseries" var="editURL">
	<portlet:param name="lectureseriesId" value='<%=""+lId%>' />
</portlet:actionURL>

<portlet:actionURL name="removeLectureseries" var="removeURL">
	<portlet:param name="lectureseriesId" value='<%=""+lId%>' />
</portlet:actionURL>

<portlet:actionURL name="addLectureseries" var="addURL">
	<portlet:param name="lectureseriesId" value='<%=""+lId%>' />
</portlet:actionURL>

<%
	if(lId >0) {actionURL=editURL.toString();}
	else {actionURL = addURL.toString();}
%>

<aui:input name="teste" type="hidden"/>

<aui:form action="<%=actionURL%>" commandName="model">
	<aui:fieldset helpMessage="test" column="true" label='<%=lName%>'>
		<aui:layout>
			
			<aui:input name="number" label="number" required="true" value="<%=lNumber %>" />

			<aui:input name="name" label="name" required="true" value="<%=lName%>"/>

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
			
			<aui:select size="1" name="institutionId" label="institution" required="true">
				<aui:option value="">select-institution</aui:option>
				<%for (Map.Entry<String, String> f : institutions.entrySet()) {
				boolean dis=true; 
				if(f.getValue().startsWith("----") || permissionCoordinator)dis=false;
				if(f.getKey().equals(institutionId.toString())){
					%><aui:option value='<%=f.getKey()%>' selected="true" disabled="<%=dis%>"><%=f.getValue()%></aui:option>
				<%}else{%><aui:option value='<%=f.getKey()%>' disabled="<%=dis%>"><%=f.getValue()%></aui:option><%}	
				}%>
			</aui:select>
		
			<div class="facilCont">
				<%
				List<Institution> fs = InstitutionLocalServiceUtil.getByLectureseriesId(lId, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
				for(int i=0;i<fs.size();i++){
					Institution f = fs.get(i);
					%>
					<div id='<%=f.getInstitutionId()%>'> 
						<%=f.getName()+"&nbsp;&nbsp;&nbsp;" %> 
						<a style='cursor:pointer;' onClick='document.getElementById("<%=f.getInstitutionId()%>").remove();'><b>X</b></a>
						<aui:input type="hidden" name="institutions" id="institutions" value="<%=f.getInstitutionId()%>"/>
					</div>
					<%
				}
				%>				
			</div>
				
			<aui:select size="1" name="producerId" label="producer" required="true" helpMessage="please-add-at-lest-one-producer">
				<aui:option value="">select-producer</aui:option>
				<%for (int i = 0; i < producers.size(); i++) {
					Long z = new Long(0);
					if(pIds.size()>0) z = new Long(pIds.get(0)+"");
					if(producers.get(i).getProducerId()==new Long(z+"")){
						%><aui:option value='<%=producers.get(i).getProducerId()%>' selected="true"><%=producers.get(i).getLastName() + ", " + producers.get(i).getFirstName()%></aui:option><%
					}else{
						%><aui:option value='<%=producers.get(i).getProducerId()%>'><%=producers.get(i).getLastName() + ", " + producers.get(i).getFirstName()%></aui:option><%
					}
				}%>	
			</aui:select>

			<div class="prodCont">
				<%for(int i=0;i<pIds.size();i++){
					Producer p = ProducerLocalServiceUtil.getProdUcer(new Long(pIds.get(i)+""));
					%>
					<div id='<%=p.getProducerId()%>'> 
						<%=p.getLastName() +", "+p.getFirstName()+"&nbsp;&nbsp;&nbsp;" %> 
						<a style='cursor:pointer;' onClick='document.getElementById("<%=p.getProducerId()%>").remove();'><b>X</b></a>
						<aui:input type="hidden" name="producers" id="producers" value="<%=p.getProducerId()%>"/>
					</div>
					<%
				}%>				
			</div>	
							
			<aui:input name="shortDesc" label="short-description"  value="<%=lShortDesc%>"/>

			<aui:select id="allSemesters" size="1" name="semesterName" label="semester">
				<aui:option value="">select-semester</aui:option>
				<%for (int i = 0; i < semesters.size(); i++) {
					if (semesters.get(i).equals(lSemesterName)) {%>
						<aui:option value='<%=semesters.get(i)%>' selected="true"><%=semesters.get(i)%></aui:option>
					<%} else {%>
						<aui:option value='<%=semesters.get(i)%>'><%=semesters.get(i)%></aui:option>
					<%}
				}%>
			</aui:select>
			
			<a id="<portlet:namespace/>addSemester" style="cursor:pointer;">add-new-semester</a>
			<aui:input id="newSemester" name="semesterName" style="display:none;" label=""/>

			<aui:select size="1" name="language" label="language" required="true">
				<aui:option value="">select-language</aui:option>
				<%for (int i=0; i<languages.length; i++){
					if (languages[i].getLanguage().equals(lLanguage)) {%>
						<aui:option value='<%=languages[i].getLanguage()%>' selected="true"><%=languages[i].getDisplayLanguage()%></aui:option>
					<%} else {%>
						<aui:option value='<%=languages[i].getLanguage()%>'><%=languages[i].getDisplayLanguage()%></aui:option>
					<%}
				}%>
			</aui:select>
				
			<aui:input name="instructorsString" label="instructors" value="<%=lInstructors%>"/>
			
			<aui:input name="password" label="password" value="<%=lPassword%>"/>
			
			<aui:field-wrapper label="description">
			    <liferay-ui:input-editor name="longDesc" toolbarSet="liferay-article" initMethod="initEditor" width="250" />
			    <script type="text/javascript">
			        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(lLongDesc) %>"; }
			    </script>
			</aui:field-wrapper>
			
			<aui:button-row>
				<aui:button type="submit" onclick="<portlet:namespace />extractCodeFromEditor()"/>
				<aui:button type="submit" value="cancel" onClick="<%=cancelURL.toString()%>" />
				<%if (lId>0) {%>
				<liferay-ui:icon-menu cssClass="right">
					<liferay-ui:icon image="delete" message="Remove" url="<%=removeURL.toString()%>" />
				</liferay-ui:icon-menu>
				<%}%>
			</aui:button-row>
		</aui:layout>
	</aui:fieldset>
</aui:form>

<script>

AUI().use('aui-node',
  
function(A) {
	// Select the node(s) using a css selector string
    var contProduc = A.one('.prodCont');
    var contFacil = A.one('.facilCont');
    var producerId = A.one('#<portlet:namespace/>producerId');
    var institutionId = A.one('#<portlet:namespace/>institutionId');
    var addSemester = A.one('#<portlet:namespace/>addSemester');
    var newSemester = A.one('#<portlet:namespace/>newSemester');
    var allSemesters = A.one('#<portlet:namespace/>allSemesters');
    
    producerId.on(
      	'change',
      	function(A) {
  			if(producerId.get('value')>0){
  	   	 		var n = producerId.get(producerId.get('selectedIndex')).get('value');
  	    		var t = producerId.get(producerId.get('selectedIndex')).get('text')+"&nbsp;&nbsp;&nbsp;";
  	  			contProduc.append("<div id='"+n+"'> "+t+" <a style='cursor:pointer;' onClick='document.getElementById(&quot;"+n+"&quot;).remove();'><b>X</b></a><input id='<portlet:namespace></portlet:namespace>producers' name='<portlet:namespace></portlet:namespace>producers' value='"+n+"' type='hidden'/></div>");
  			}
      	}
    );

    institutionId.on(
      	'change',
      	function(A) {
  			if(institutionId.get('value')>0){
  	   	 		var n = institutionId.get(institutionId.get('selectedIndex')).get('value');
  	    		var t = institutionId.get(institutionId.get('selectedIndex')).get('text')+"&nbsp;&nbsp;&nbsp;";
  	    		contFacil.append("<div id='"+n+"'> "+t+" <a style='cursor:pointer;' onClick='document.getElementById(&quot;"+n+"&quot;).remove();'><b>X</b></a><input id='<portlet:namespace></portlet:namespace>institutions' name='<portlet:namespace></portlet:namespace>institutions' value='"+n+"' type='hidden'/></div>");
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