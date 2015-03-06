<%@include file="/init.jsp"%>

<%
	String actionURL = "";
	String lName = "";
	String lNumber = "";
	String lLanguage = "";
	Long categoryId = new Long(0);
	Long lSemester = new Long(0);
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
		categoryId=reqLectureseries.getCategoryId();
		lSemester=reqLectureseries.getTermId();
		lShortDesc=reqLectureseries.getShortDesc();
		lPassword=reqLectureseries.getPassword();
		lLongDesc=reqLectureseries.getLongDesc();
	}catch(NullPointerException npe){}
	
	Long institutionId = new Long(0);
	try{
		institutionId = InstitutionLocalServiceUtil.getByLectureseriesId(lId, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS).iterator().next().getInstitutionId();
	}catch(Exception npe){}

	Map<String,String> institutions = new LinkedHashMap<String, String>();
	List<Producer> producers = new ArrayList<Producer>();

	if(permissionAdmin){
		institutions = InstitutionLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		producers = ProducerLocalServiceUtil.getAllProducers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		permissionCoordinator = false;
	}
	
	if(permissionCoordinator){
		if(institutionId==0)institutionId = CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId()).getInstitutionId();
		institutions = InstitutionLocalServiceUtil.getByParent(CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId()).getInstitutionId());
		producers = ProducerLocalServiceUtil.getProducersByInstitutionId(CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId()).getInstitutionId());
	}

	Locale[] languages = LanguageUtil.getAvailableLocales();
	String[] availableLanguageIds = LocaleUtil.toLanguageIds(languages);
	String languageId="";

	List<Long> pIds = new ArrayList<Long>();
	try{
		pIds = ProducerLocalServiceUtil.getAllProducerIds(lId);
	}catch (NullPointerException e){}
	
	List<Term> semesters = new ArrayList<Term>(); 
	try{
		semesters = TermLocalServiceUtil.getAllSemesters(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	}catch(Exception e){}
	 
	List<Category> categories = new ArrayList<Category>();
	try{
		categories = CategoryLocalServiceUtil.getAllCategories(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	}catch(Exception e){}
	
	String backURL = "";
	try{
		backURL = request.getAttribute("backURL").toString();
	}catch(Exception e){
		%>
			<portlet:renderURL var="back"><portlet:param name="jspPage" value="/admin/lectureSeriesList.jsp" /></portlet:renderURL>
		<%
		backURL=back.toString();
	}
%>

<portlet:actionURL name="editLectureseries" var="editURL">
	<portlet:param name="lectureseriesId" value='<%=""+lId%>' />
	<portlet:param name="backURL" value='<%=backURL%>' />
</portlet:actionURL>

<portlet:actionURL name="addLectureseries" var="addURL">
	<portlet:param name="lectureseriesId" value='<%=""+lId%>' />
	<portlet:param name="backURL" value='<%=backURL%>' />
</portlet:actionURL>

<%
	if(lId >0) {actionURL=editURL.toString();}
	else {actionURL = addURL.toString();}
%>

<aui:form action="<%=actionURL%>" commandName="model">
	<aui:fieldset helpMessage="test" column="true" label='<%=lName%>'>
		<aui:layout>
			
			<aui:input name="number" label="number" required="true" value="<%=lNumber %>" />

			<aui:input name="name" label="name" required="true" value="<%=lName%>"/>

			<aui:select size="1" name="categoryId" label="event-type" required="true">
				<aui:option value=""></aui:option>
				<%for (int i = 0; i < categories.size(); i++) {
					if (categoryId==categories.get(i).getCategoryId()) {%>
						<aui:option value='<%=categories.get(i).getCategoryId()%>' selected="true"><%=categories.get(i).getName()%></aui:option>
					<%} else {%>
						<aui:option value='<%=categories.get(i).getCategoryId()%>'><%=categories.get(i).getName()%></aui:option>
					<%}
				}%>
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
				List<Institution> fs = new ArrayList<Institution>();
				try{
					fs = InstitutionLocalServiceUtil.getByLectureseriesId(lId, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
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
				}catch(Exception e){}
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
				<%
				try{
					for(int i=0;i<pIds.size();i++){
						Producer p = ProducerLocalServiceUtil.getProdUcer(new Long(pIds.get(i)+""));
						%>
						<div id='<%=p.getProducerId()%>'> 
							<%=p.getLastName() +", "+p.getFirstName()+"&nbsp;&nbsp;&nbsp;" %> 
							<a style='cursor:pointer;' onClick='document.getElementById("<%=p.getProducerId()%>").remove();'><b>X</b></a>
							<aui:input type="hidden" name="producers" id="producers" value="<%=p.getProducerId()%>"/>
						</div>
						<%
					}
				}catch(Exception e){}%>				
			</div>	
							
			<aui:input name="shortDesc" label="short-description"  value="<%=lShortDesc%>"/>

			<aui:select id="allSemesters" size="1" name="semesterId" label="semester">
				<aui:option value="">select-semester</aui:option>
				<%for (int i = 0; i < semesters.size(); i++) {
					if (lSemester==semesters.get(i).getTermId()) {%>
						<aui:option value='<%=semesters.get(i).getTermId()%>' selected="true"><%=semesters.get(i).getPrefix()+"&nbsp;"+semesters.get(i).getYear()%></aui:option>
					<%} else {%>
						<aui:option value='<%=semesters.get(i).getTermId()%>'><%=semesters.get(i).getPrefix()+"&nbsp;"+semesters.get(i).getYear()%></aui:option>
					<%}
				}%>
			</aui:select>

			<div id="creator"></div>
			<br/>
			<aui:button value="add-new-creator" id="addCreator"/>

			<aui:input name="password" label="password" value="<%=lPassword%>"/>
			
			<aui:field-wrapper label="description">
			    <liferay-ui:input-editor name="longDesc" toolbarSet="liferay-article" initMethod="initEditor" width="250" />
			    <script type="text/javascript">
			        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(lLongDesc) %>"; }
			    </script>
			</aui:field-wrapper>
			
			<aui:button-row>
				<aui:button type="submit" onclick="<portlet:namespace />extractCodeFromEditor()"/>
				<aui:button type="cancel" value="cancel" href="<%=backURL%>"/>
			</aui:button-row>
		</aui:layout>
	</aui:fieldset>
</aui:form>

<!-- Template -->
<script type="text/x-jquery-tmpl" id="creat">
	<div id="creator<%="${counter}"%>">
	<aui:select size="1" name="creatorTitles" label="">
		<aui:option value=""></aui:option>
		<%
		String[] l =  LanguageUtil.get(pageContext, "creator-titles").split(",");
		for(int i=0; i<l.length; i++){
			String title = l[i];
			%><aui:option value="<%=title%>"><%=title%></aui:option><%
		}
		%>
	</aui:select>
	<aui:input name="firstName" type="text"/>
	<aui:input name="lastName" type="text"/>
	<aui:input name="middleName" type="text"/>
	<a class="icon-large icon-remove" onclick="remb('<%="${counter}"%>');"></a>
	<br/><br/>
</script>

<script>
$(function () {appendCreator(c);});

function appendCreator(c){
	$(function () {
    	var vars = {'counter':c};
    	console.log(vars);
    	$.template( "filesTemplate", $("#creat") );
    	$.tmpl( "filesTemplate", vars ).appendTo( "#creator" );
	});
};

var c = 0;
$( "#addCreator" ).on( "click", function() {
	c++;
	appendCreator(c);
});

function remb(c){
	$("#creator"+c).remove();
}

AUI().use('aui-node',
  
function(A) {
	// Select the node(s) using a css selector string
    var contProduc = A.one('.prodCont');
    var contFacil = A.one('.facilCont');
    var producerId = A.one('#<portlet:namespace/>producerId');
    var institutionId = A.one('#<portlet:namespace/>institutionId');
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
    
  }
);
</script>