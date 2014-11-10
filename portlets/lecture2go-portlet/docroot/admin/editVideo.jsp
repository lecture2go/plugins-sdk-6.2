<%@include file="/init.jsp"%>

<jsp:useBean id="reqLectureseriesList" type="java.util.List<de.uhh.l2g.plugins.model.Lectureseries>" scope="request" />
<jsp:useBean id="reqLectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="reqLicense" type="de.uhh.l2g.plugins.model.License" scope="request" />
<jsp:useBean id="reqProducer" type="de.uhh.l2g.plugins.model.Producer" scope="request" />
<jsp:useBean id="reqVideo" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="reqMetadata" type="de.uhh.l2g.plugins.model.Metadata" scope="request" />
<%
	String actionURL = "";
	
	Map<String,String> facilities = new LinkedHashMap<String, String>();
	if(permissionAdmin){
		facilities = FacilityLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		permissionCoordinator = false;
	}
	if(permissionCoordinator)facilities = FacilityLocalServiceUtil.getByParent(CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId()).getFacilityId());

	Locale[] languages = LanguageUtil.getAvailableLocales();
	String[] availableLanguageIds = LocaleUtil.toLanguageIds(languages);
	String languageId="";

	List<String> semesters = LectureseriesLocalServiceUtil.getAllSemesters(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);

	String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
%>

<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/admin/videosList.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editVideo" var="editURL">
	<portlet:param name="videoId" value='<%=""+reqVideo.getVideoId()%>' />
</portlet:actionURL>

<portlet:actionURL name="removeVideo" var="removeURL">
	<portlet:param name="videoId" value='<%=""+reqVideo.getVideoId()%>' />
</portlet:actionURL>

<portlet:actionURL name="addVideo" var="addURL">
	<portlet:param name="videoId" value='<%=""+0%>' />
</portlet:actionURL>

<portlet:actionURL var="editCaseURL" name="uploadCase">
	<portlet:param name="jspPage" value="/admin/editVideo.jsp" />
</portlet:actionURL>

<%
	if(reqVideo.getVideoId() >0) {actionURL=editURL.toString();}
	else {actionURL = addURL.toString();}
%>


<portlet:resourceURL id="uploadMe" var="uploadMe"><portlet:param name="test" value="test"/></portlet:resourceURL>

<aui:fieldset helpMessage="test" column="true" label="file-upload">
	<aui:layout>
		<form method="post" enctype="multipart/form-data" name="form">
		     <input type="file" name="fileToUpload" id="fileToUpload" value="Browse" class="input" required="required"/>
		     <input type="button" name="upload" id="upload" value="Upload"  class="noText_shadow" onClick="uploadFileMe();" />
		</form>
	</aui:layout>
</aui:fieldset>

<aui:fieldset helpMessage="test" column="true" label="video-metadata" id="metadata">
	<aui:layout>
		<aui:form action="<%=actionURL%>" commandName="model">
			<aui:select size="1" name="lectureseriesId" label="lectureseries" required="true">
				<aui:option value="">select-lecture-series</aui:option>
					<%for (int i = 0; i < reqLectureseriesList.size(); i++) {
						if(reqLectureseriesList.get(i).getLectureseriesId()==reqVideo.getLectureseriesId()){%>
							<aui:option value='<%=reqLectureseriesList.get(i).getLectureseriesId()%>' selected="true"><%=reqLectureseriesList.get(i).getName()%></aui:option>
						<%}else{%>
							<aui:option value='<%=reqLectureseriesList.get(i).getLectureseriesId()%>'><%=reqLectureseriesList.get(i).getName()%></aui:option>
						<%}					
					}%>
			</aui:select>
			
			<aui:select size="1" name="language" label="language" required="true">
				<aui:option value="">select-language</aui:option>
				<%for (int i=0; i<languages.length; i++){
					if (languages[i].getLanguage().equals(reqMetadata.getLanguage())) {%>
						<aui:option value='<%=languages[i].getLanguage()%>' selected="true"><%=languages[i].getDisplayLanguage()%></aui:option>
					<%} else {%>
						<aui:option value='<%=languages[i].getLanguage()%>'><%=languages[i].getDisplayLanguage()%></aui:option>
					<%}
				}%>				
			</aui:select>
			
			<aui:input name="title" label="title" required="true" value="<%=reqVideo.getTitle()%>" />

			<aui:input name="tags" label="tags" required="false" value="<%=reqVideo.getTags()%>"/>

			<aui:input name="creator" label="creator" required="true" value="<%=reqMetadata.getCreator()%>"/>

			<aui:input name="rightsHolder" label="rightsHolder" required="true" value="<%=reqMetadata.getRightsHolder()%>"/>
			
			<aui:input name="publisher" label="publisher" required="true" value="<%=reqMetadata.getPublisher()%>"/>
	
			license
			<br/>
			<em>uhh-l2go</em>
			<%if(reqLicense.getL2go()==1){%><aui:input name="license" value="uhhl2go" checked="true" type="radio"/><%}%>
			<%if(reqLicense.getL2go()==0){%><aui:input name="license" value="uhhl2go" type="radio"/><%}%>
			lecture2go-licence <a href="/license" target="_blank"> details </a>	 	      	      
			<br/><br/>
			
			<em>by-nc-sa</em>	
			<%if(reqLicense.getCcbyncsa()==1){%><aui:input name="license" value="ccbyncsa" checked="true" type="radio" /><%}%>
			<%if(reqLicense.getCcbyncsa()==0){%><aui:input name="license" value="ccbyncsa" type="radio"/><%}%>
			creative-commons <a href="http://creativecommons.org/licenses/by-nc-sa/3.0/" target="_blank"> details </a>
			<br/><br/>
			
			<aui:field-wrapper label="description">
			    <liferay-ui:input-editor name="longDesc" toolbarSet="liferay-article" initMethod="initEditor" width="250" />
			    <script type="text/javascript">
			        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(reqMetadata.getDescription()) %>"; }
			    </script>
			</aui:field-wrapper>
			
			<aui:button-row>
				<aui:button type="submit" onclick="<portlet:namespace />extractCodeFromEditor()"/>
				<aui:button type="cancel" value="cancel" onClick="<%=cancelURL.toString()%>" />
				<%if (reqVideo.getVideoId()>0) {%>
					<liferay-ui:icon-menu cssClass="right">
						<liferay-ui:icon image="delete" message="Remove" url="<%=removeURL.toString()%>" />
					</liferay-ui:icon-menu>
				<%}%>
			</aui:button-row>
			
			<aui:input name="producerId" type="hidden" value="<%=reqProducer.getProducerId()%>"/>
			<aui:input name="lectureseriesId" type="hidden" value="<%=reqLectureseries.getLectureseriesId()%>"/>
		</aui:form>
	</aui:layout>
</aui:fieldset>

<script type="text/javascript">

AUI().use('aui-node','file',
	function(A) {
    	var metadata = A.one('#<portlet:namespace/>metadata');
    	var upload = A.one('#upload');
    	
    	var fileToUpload = A.one('#fileToUpload');
    	
    	<%if(reqVideo.getVideoId()==0){%>metadata.hide();upload.show()<%}%>
    	<%if(reqVideo.getVideoId()>0){%>metadata.show();upload.show()<%}%>
    	
    	upload.on(
    		'click',
    		function() {
    			//then show metadata
    			metadata.show();
    		}
    	)
    	
	}
);

function uploadFileMe(){
	$.ajaxFileUpload
	({
		url:'<%=uploadMe%>',
		secureuri : false,
		fileElementId : 'fileToUpload',
		dataType : 'json',
		data : {
			name : 'fileToUpload',
			id : 'fileToUpload'
		},
		success : function(data, status) {
			if (typeof (data.error) != 'undefined') {
				if (data.error != '') {
				 //alert(data.error);
				} else {
				 //alert(data.msg);
				}
			}
		},
		error : function(data, status, e) {
		 //alert(e);
		}
	});
}

</script>